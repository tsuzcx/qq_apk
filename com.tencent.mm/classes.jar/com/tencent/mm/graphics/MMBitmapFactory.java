package com.tencent.mm.graphics;

import android.content.res.AssetManager.AssetInputStream;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

@Keep
public class MMBitmapFactory
{
  private static final int DENSITY_DEFAULT = 160;
  private static final int REWIND_BUFFER_SIZE = 8388608;
  private static final String TAG = "MicroMsg.MMBitmapFactory";
  private static final int TEMP_STORAGE_SIZE = 4096;
  private static a sDecodeCanary;
  private static boolean sForceUsingSystemDecoderOpt;
  private static b sStreamProvider;
  
  static
  {
    AppMethodBeat.i(1011);
    sStreamProvider = null;
    sForceUsingSystemDecoderOpt = false;
    sDecodeCanary = null;
    loadNativeModule("mmimgcodec");
    AppMethodBeat.o(1011);
  }
  
  private MMBitmapFactory()
  {
    AppMethodBeat.i(1010);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(1010);
    throw localUnsupportedOperationException;
  }
  
  public static void addExternalCodecLibDir(String paramString)
  {
    AppMethodBeat.i(980);
    Log.i("MicroMsg.MMBitmapFactory", "[+] add external codec library path: %s", new Object[] { paramString });
    nativeAddExternalLibDir(paramString);
    AppMethodBeat.o(980);
  }
  
  private static void announceDecodeResult(BitmapFactory.Options paramOptions, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(999);
    assertNotNull(paramOptions, "[-] opts is null.");
    if (paramBoolean) {}
    for (String str = "system"; ((paramBitmap != null) || (paramOptions.outMimeType != null)) && (paramOptions.outWidth > 0) && (paramOptions.outHeight > 0); str = "mmcodec")
    {
      Log.i("MicroMsg.MMBitmapFactory", "[+] decode success by %s, boundsOnly:%s, w:%s, h:%s, mime-type:%s, sampleSize:%s", new Object[] { str, Boolean.valueOf(paramOptions.inJustDecodeBounds), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight), paramOptions.outMimeType, Integer.valueOf(paramOptions.inSampleSize) });
      if ((sDecodeCanary == null) || (paramBitmap == null) || (paramOptions.inJustDecodeBounds)) {
        break label180;
      }
      int i = paramBitmap.getByteCount();
      if (i >= 20971520L) {
        sDecodeCanary.a(paramOptions, i);
      }
      AppMethodBeat.o(999);
      return;
    }
    Log.e("MicroMsg.MMBitmapFactory", "[+] fail to decode by %s", new Object[] { str });
    label180:
    AppMethodBeat.o(999);
  }
  
  private static void assertNotNull(Object paramObject, String paramString)
  {
    AppMethodBeat.i(1003);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException(paramString);
      AppMethodBeat.o(1003);
      throw paramObject;
    }
    AppMethodBeat.o(1003);
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(1004);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(1004);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(1004);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(1004);
    }
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(992);
    assertNotNull(paramArrayOfByte, "'data' is null.");
    paramArrayOfByte = decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, null);
    AppMethodBeat.o(992);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(993);
    assertNotNull(paramArrayOfByte, "'data' is null.");
    paramArrayOfByte = decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
    AppMethodBeat.o(993);
    return paramArrayOfByte;
  }
  
  private static Bitmap decodeByteArrayInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    int i = 0;
    AppMethodBeat.i(994);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (isForceSystemDecoder(localOptions))
    {
      Log.w("MicroMsg.MMBitmapFactory", "[!] force decoding data by system codec.");
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      announceDecodeResult(localOptions, paramArrayOfByte, true);
      AppMethodBeat.o(994);
      return paramArrayOfByte;
    }
    try
    {
      paramOptions = nativeDecodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      if (localOptions.outMimeType != null) {
        i = 1;
      }
      if (i != 0)
      {
        announceDecodeResult(localOptions, paramOptions, false);
        setDensityFromOptions(paramOptions, localOptions);
        paramArrayOfByte = scaleBitmapOnDemand(paramOptions, localOptions);
        AppMethodBeat.o(994);
        return paramArrayOfByte;
      }
      Log.w("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      announceDecodeResult(localOptions, paramArrayOfByte, true);
      AppMethodBeat.o(994);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      Log.e("MicroMsg.MMBitmapFactory", paramArrayOfByte, "decode failed.");
      AppMethodBeat.o(994);
    }
    return null;
  }
  
  public static Bitmap decodeFile(String paramString)
  {
    AppMethodBeat.i(985);
    assertNotNull(paramString, "'pathName' is null.");
    paramString = decodeFileInternal(paramString, null);
    AppMethodBeat.o(985);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(986);
    assertNotNull(paramString, "'pathName' is null.");
    paramString = decodeFileInternal(paramString, paramOptions);
    AppMethodBeat.o(986);
    return paramString;
  }
  
  public static Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(989);
    assertNotNull(paramFileDescriptor, "'fd' is null.");
    paramFileDescriptor = decodeFileDescriptorInternal(paramFileDescriptor, null, null);
    AppMethodBeat.o(989);
    return paramFileDescriptor;
  }
  
  public static Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(990);
    assertNotNull(paramFileDescriptor, "'fd' is null.");
    paramFileDescriptor = decodeFileDescriptorInternal(paramFileDescriptor, paramRect, paramOptions);
    AppMethodBeat.o(990);
    return paramFileDescriptor;
  }
  
  /* Error */
  private static Bitmap decodeFileDescriptorInternal(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: sipush 991
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: astore 4
    //   11: aload_2
    //   12: ifnonnull +12 -> 24
    //   15: new 83	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 153	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore 4
    //   24: aload 4
    //   26: invokestatic 157	com/tencent/mm/graphics/MMBitmapFactory:isForceSystemDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   29: ifeq +41 -> 70
    //   32: ldc 22
    //   34: ldc 205
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: invokestatic 207	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload_1
    //   49: aload 4
    //   51: invokestatic 209	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   54: astore_0
    //   55: aload 4
    //   57: aload_0
    //   58: iconst_1
    //   59: invokestatic 169	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   62: sipush 991
    //   65: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_0
    //   69: areturn
    //   70: aload_0
    //   71: invokestatic 213	com/tencent/mm/graphics/MMBitmapFactory:nativeIsSeekable	(Ljava/io/FileDescriptor;)Z
    //   74: ifeq +105 -> 179
    //   77: aload_0
    //   78: aload 4
    //   80: invokestatic 217	com/tencent/mm/graphics/MMBitmapFactory:getOrCreateStorageBuffer	(Landroid/graphics/BitmapFactory$Options;)[B
    //   83: aload_1
    //   84: aload 4
    //   86: invokestatic 221	com/tencent/mm/graphics/MMBitmapFactory:nativeDecodeFileDescriptor	(Ljava/io/FileDescriptor;[BLandroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore_2
    //   90: aload 4
    //   92: getfield 86	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   95: ifnull +5 -> 100
    //   98: iconst_1
    //   99: istore_3
    //   100: iload_3
    //   101: ifeq +31 -> 132
    //   104: aload 4
    //   106: aload_2
    //   107: iconst_0
    //   108: invokestatic 169	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   111: aload_2
    //   112: aload 4
    //   114: invokestatic 176	com/tencent/mm/graphics/MMBitmapFactory:setDensityFromOptions	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)V
    //   117: aload_2
    //   118: aload 4
    //   120: invokestatic 180	com/tencent/mm/graphics/MMBitmapFactory:scaleBitmapOnDemand	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   123: astore_0
    //   124: sipush 991
    //   127: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: areturn
    //   132: ldc 22
    //   134: ldc 182
    //   136: invokestatic 163	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: aload_1
    //   141: aload 4
    //   143: invokestatic 209	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   146: astore_0
    //   147: aload 4
    //   149: aload_0
    //   150: iconst_1
    //   151: invokestatic 169	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   154: sipush 991
    //   157: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: areturn
    //   162: astore_0
    //   163: ldc 22
    //   165: aload_0
    //   166: ldc 184
    //   168: invokestatic 187	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   171: sipush 991
    //   174: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aconst_null
    //   178: areturn
    //   179: new 223	java/io/FileInputStream
    //   182: dup
    //   183: aload_0
    //   184: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   187: astore_2
    //   188: aload_2
    //   189: astore_0
    //   190: aload_2
    //   191: aload_1
    //   192: aload 4
    //   194: invokestatic 230	com/tencent/mm/graphics/MMBitmapFactory:decodeStreamInternal	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   197: astore_1
    //   198: aload_2
    //   199: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   202: sipush 991
    //   205: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_1
    //   209: areturn
    //   210: astore 4
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: astore_0
    //   216: ldc 22
    //   218: aload 4
    //   220: ldc 184
    //   222: invokestatic 187	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   225: aload_1
    //   226: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   229: sipush 991
    //   232: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: aload_0
    //   241: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   244: sipush 991
    //   247: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: goto -13 -> 240
    //   256: astore 4
    //   258: aload_2
    //   259: astore_1
    //   260: goto -46 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFileDescriptor	FileDescriptor
    //   0	263	1	paramRect	Rect
    //   0	263	2	paramOptions	BitmapFactory.Options
    //   1	100	3	i	int
    //   9	184	4	localOptions	BitmapFactory.Options
    //   210	9	4	localThrowable1	Throwable
    //   256	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   77	90	162	java/lang/Throwable
    //   90	98	162	java/lang/Throwable
    //   104	124	162	java/lang/Throwable
    //   132	154	162	java/lang/Throwable
    //   179	188	210	java/lang/Throwable
    //   179	188	237	finally
    //   190	198	252	finally
    //   216	225	252	finally
    //   190	198	256	java/lang/Throwable
  }
  
  /* Error */
  private static Bitmap decodeFileInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: sipush 987
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: astore 4
    //   11: aload_1
    //   12: ifnonnull +12 -> 24
    //   15: new 83	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 153	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore 4
    //   24: aload 4
    //   26: invokestatic 157	com/tencent/mm/graphics/MMBitmapFactory:isForceSystemDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   29: ifeq +33 -> 62
    //   32: ldc 22
    //   34: ldc 234
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: invokestatic 207	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload 4
    //   50: invokestatic 237	com/tencent/mm/graphics/MMBitmapFactory:decodeFileWithStreamBySystemInternal	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: astore_0
    //   54: sipush 987
    //   57: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: areturn
    //   62: aload_0
    //   63: invokestatic 241	com/tencent/mm/graphics/MMBitmapFactory:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: invokestatic 245	com/tencent/mm/graphics/MMBitmapFactory:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   69: astore_3
    //   70: aload_3
    //   71: astore_1
    //   72: aload_3
    //   73: invokestatic 248	com/tencent/mm/graphics/MMBitmapFactory:getCompatibleRewindBufferSize	()I
    //   76: invokevirtual 253	java/io/InputStream:mark	(I)V
    //   79: aload_3
    //   80: astore_1
    //   81: aload_3
    //   82: aconst_null
    //   83: aload 4
    //   85: invokestatic 256	com/tencent/mm/graphics/MMBitmapFactory:nativeDecodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   88: astore 5
    //   90: aload_3
    //   91: astore_1
    //   92: aload 4
    //   94: getfield 86	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   97: ifnull +48 -> 145
    //   100: iload_2
    //   101: ifeq +49 -> 150
    //   104: aload_3
    //   105: astore_1
    //   106: aload 4
    //   108: aload 5
    //   110: iconst_0
    //   111: invokestatic 169	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   114: aload_3
    //   115: astore_1
    //   116: aload 5
    //   118: aload 4
    //   120: invokestatic 176	com/tencent/mm/graphics/MMBitmapFactory:setDensityFromOptions	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)V
    //   123: aload_3
    //   124: astore_1
    //   125: aload 5
    //   127: aload 4
    //   129: invokestatic 180	com/tencent/mm/graphics/MMBitmapFactory:scaleBitmapOnDemand	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   132: astore_0
    //   133: aload_3
    //   134: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   137: sipush 987
    //   140: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_0
    //   144: areturn
    //   145: iconst_0
    //   146: istore_2
    //   147: goto -47 -> 100
    //   150: aload_3
    //   151: astore_1
    //   152: ldc 22
    //   154: ldc 182
    //   156: invokestatic 163	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_3
    //   160: astore_1
    //   161: aload_0
    //   162: aload 4
    //   164: invokestatic 237	com/tencent/mm/graphics/MMBitmapFactory:decodeFileWithStreamBySystemInternal	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   167: astore_0
    //   168: aload_3
    //   169: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   172: sipush 987
    //   175: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_0
    //   179: areturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_3
    //   183: aload_3
    //   184: astore_1
    //   185: ldc 22
    //   187: aload_0
    //   188: ldc 184
    //   190: invokestatic 187	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   193: aload_3
    //   194: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   197: sipush 987
    //   200: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aconst_null
    //   204: areturn
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   212: sipush 987
    //   215: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_0
    //   219: athrow
    //   220: astore_0
    //   221: goto -13 -> 208
    //   224: astore_0
    //   225: goto -42 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString	String
    //   0	228	1	paramOptions	BitmapFactory.Options
    //   1	146	2	i	int
    //   69	125	3	localInputStream	InputStream
    //   9	154	4	localOptions	BitmapFactory.Options
    //   88	38	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   62	70	180	java/lang/Throwable
    //   62	70	205	finally
    //   72	79	220	finally
    //   81	90	220	finally
    //   92	100	220	finally
    //   106	114	220	finally
    //   116	123	220	finally
    //   125	133	220	finally
    //   152	159	220	finally
    //   161	168	220	finally
    //   185	193	220	finally
    //   72	79	224	java/lang/Throwable
    //   81	90	224	java/lang/Throwable
    //   92	100	224	java/lang/Throwable
    //   106	114	224	java/lang/Throwable
    //   116	123	224	java/lang/Throwable
    //   125	133	224	java/lang/Throwable
    //   152	159	224	java/lang/Throwable
    //   161	168	224	java/lang/Throwable
  }
  
  /* Error */
  private static Bitmap decodeFileWithStreamBySystemInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: sipush 988
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 40	com/tencent/mm/graphics/MMBitmapFactory:sStreamProvider	Lcom/tencent/mm/graphics/MMBitmapFactory$b;
    //   9: ifnull +90 -> 99
    //   12: aload_0
    //   13: invokestatic 241	com/tencent/mm/graphics/MMBitmapFactory:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: invokestatic 245	com/tencent/mm/graphics/MMBitmapFactory:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: aload_2
    //   23: invokestatic 248	com/tencent/mm/graphics/MMBitmapFactory:getCompatibleRewindBufferSize	()I
    //   26: invokevirtual 253	java/io/InputStream:mark	(I)V
    //   29: aload_2
    //   30: astore_0
    //   31: aload_2
    //   32: aconst_null
    //   33: aload_1
    //   34: invokestatic 259	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   37: astore_3
    //   38: aload_2
    //   39: astore_0
    //   40: aload_1
    //   41: aload_3
    //   42: iconst_1
    //   43: invokestatic 169	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   46: aload_2
    //   47: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   50: sipush 988
    //   53: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_3
    //   57: areturn
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_0
    //   63: ldc 22
    //   65: aload_1
    //   66: ldc_w 261
    //   69: invokestatic 187	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   72: aload_2
    //   73: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   76: sipush 988
    //   79: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   91: sipush 988
    //   94: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    //   99: aload_0
    //   100: aload_1
    //   101: invokestatic 263	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   104: astore_0
    //   105: aload_1
    //   106: aload_0
    //   107: iconst_1
    //   108: invokestatic 169	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   111: sipush 988
    //   114: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: ldc 22
    //   122: aload_0
    //   123: ldc_w 261
    //   126: invokestatic 187	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   129: sipush 988
    //   132: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_1
    //   138: goto -51 -> 87
    //   141: astore_1
    //   142: goto -81 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   0	145	1	paramOptions	BitmapFactory.Options
    //   19	54	2	localInputStream	InputStream
    //   37	20	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   12	20	58	java/lang/Throwable
    //   12	20	84	finally
    //   99	111	119	java/lang/Throwable
    //   22	29	137	finally
    //   31	38	137	finally
    //   40	46	137	finally
    //   63	72	137	finally
    //   22	29	141	java/lang/Throwable
    //   31	38	141	java/lang/Throwable
    //   40	46	141	java/lang/Throwable
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(982);
    Log.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", new Object[] { paramResources, Integer.valueOf(paramInt) });
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt);
    AppMethodBeat.o(982);
    return paramResources;
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(983);
    Log.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", new Object[] { paramResources, Integer.valueOf(paramInt), paramOptions });
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt, paramOptions);
    AppMethodBeat.o(983);
    return paramResources;
  }
  
  public static Bitmap decodeResourceStream(Resources paramResources, TypedValue paramTypedValue, InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(984);
    Log.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", new Object[] { paramResources, paramTypedValue, paramInputStream, paramRect, paramOptions });
    paramResources = BitmapFactory.decodeResourceStream(paramResources, paramTypedValue, paramInputStream, paramRect, paramOptions);
    AppMethodBeat.o(984);
    return paramResources;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(995);
    assertNotNull(paramInputStream, "'is' is null.");
    paramInputStream = decodeStreamInternal(paramInputStream, null, null);
    AppMethodBeat.o(995);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(996);
    assertNotNull(paramInputStream, "'is' is null.");
    paramInputStream = decodeStreamInternal(paramInputStream, paramRect, paramOptions);
    AppMethodBeat.o(996);
    return paramInputStream;
  }
  
  private static Bitmap decodeStreamInternal(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    int j = 0;
    AppMethodBeat.i(997);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    int i;
    if ((paramInputStream instanceof AssetManager.AssetInputStream))
    {
      Log.w("MicroMsg.MMBitmapFactory", "[!] force decoding stream by system codec since it's asset stream.");
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
        announceDecodeResult(localOptions, paramInputStream, true);
        AppMethodBeat.o(997);
        return paramInputStream;
        if (isForceSystemDecoder(localOptions))
        {
          Log.w("MicroMsg.MMBitmapFactory", "[!] force decoding stream by system codec since specific options.");
          i = 1;
        }
      }
      else
      {
        try
        {
          paramInputStream = wrapUnResetableStreamOnDemand(paramInputStream);
          paramInputStream.mark(getCompatibleRewindBufferSize());
          paramOptions = nativeDecodeStream(paramInputStream, paramRect, localOptions);
          i = j;
          if (localOptions.outMimeType != null) {
            i = 1;
          }
          if (i != 0)
          {
            announceDecodeResult(localOptions, paramOptions, false);
            setDensityFromOptions(paramOptions, localOptions);
            paramInputStream = scaleBitmapOnDemand(paramOptions, localOptions);
            AppMethodBeat.o(997);
            return paramInputStream;
          }
          Log.w("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
          paramInputStream.reset();
          paramInputStream.mark(getCompatibleRewindBufferSize());
          paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
          announceDecodeResult(localOptions, paramInputStream, true);
          AppMethodBeat.o(997);
          return paramInputStream;
        }
        catch (Throwable paramInputStream)
        {
          Log.e("MicroMsg.MMBitmapFactory", paramInputStream, "decode failed.");
          AppMethodBeat.o(997);
          return null;
        }
      }
      i = 0;
    }
  }
  
  private static int getCompatibleRewindBufferSize()
  {
    AppMethodBeat.i(1007);
    if ("HUAWEI".equals(Build.MANUFACTURER))
    {
      AppMethodBeat.o(1007);
      return 8388608;
    }
    AppMethodBeat.o(1007);
    return 8388608;
  }
  
  private static byte[] getOrCreateStorageBuffer(BitmapFactory.Options paramOptions)
  {
    if (paramOptions != null) {}
    for (paramOptions = paramOptions.inTempStorage; paramOptions != null; paramOptions = null) {
      return paramOptions;
    }
    return new byte[4096];
  }
  
  private static InputStream getStreamFromPath(String paramString)
  {
    AppMethodBeat.i(998);
    if (sStreamProvider != null)
    {
      paramString = sStreamProvider.getStreamFromPath(paramString);
      if (paramString == null)
      {
        paramString = new IllegalArgumentException("Injected stream provider returned null in getStreamFromPath.");
        AppMethodBeat.o(998);
        throw paramString;
      }
      AppMethodBeat.o(998);
      return paramString;
    }
    paramString = new FileInputStream(paramString);
    AppMethodBeat.o(998);
    return paramString;
  }
  
  public static String getVersion()
  {
    return "0.2.26";
  }
  
  private static boolean isForceSystemDecoder(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(1002);
    if ((sForceUsingSystemDecoderOpt) || ((paramOptions != null) && (Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.HARDWARE.equals(paramOptions.inPreferredConfig))))
    {
      AppMethodBeat.o(1002);
      return true;
    }
    AppMethodBeat.o(1002);
    return false;
  }
  
  private static void loadNativeModule(String paramString)
  {
    AppMethodBeat.i(1009);
    try
    {
      System.loadLibrary(paramString);
      Log.i("MicroMsg.MMBitmapFactory", "Successfully load native module: %s", new Object[] { paramString });
      AppMethodBeat.o(1009);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MMBitmapFactory", localThrowable, "Fail to load native module: %s", new Object[] { paramString });
      paramString = new RuntimeException(localThrowable);
      AppMethodBeat.o(1009);
      throw paramString;
    }
  }
  
  private static native void nativeAddExternalLibDir(String paramString);
  
  private static native Bitmap nativeDecodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions);
  
  private static native Bitmap nativeDecodeFileDescriptor(FileDescriptor paramFileDescriptor, byte[] paramArrayOfByte, Rect paramRect, BitmapFactory.Options paramOptions);
  
  private static native Bitmap nativeDecodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions);
  
  private static native boolean nativeIsSeekable(FileDescriptor paramFileDescriptor);
  
  private static native int nativePinBitmap(Bitmap paramBitmap);
  
  private static native int nativeUnPinBitmap(Bitmap paramBitmap);
  
  public static Bitmap pinBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(1000);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.MMBitmapFactory", "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", new Object[] { paramBitmap, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramBitmap.getConfig(), Integer.valueOf(paramBitmap.getByteCount()) });
      int i = nativePinBitmap(paramBitmap);
      if (i < 0) {
        Log.e("MicroMsg.MMBitmapFactory", "pinBitmap failed, ret: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    AppMethodBeat.o(1000);
    return paramBitmap;
  }
  
  private static Bitmap scaleBitmapOnDemand(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(1005);
    if ((paramBitmap == null) || (paramOptions == null))
    {
      AppMethodBeat.o(1005);
      return paramBitmap;
    }
    if (!paramOptions.inScaled)
    {
      AppMethodBeat.o(1005);
      return paramBitmap;
    }
    int i = paramOptions.inDensity;
    int j = paramOptions.inTargetDensity;
    int k = paramOptions.inScreenDensity;
    if ((i != 0) && (j != 0) && (i != k)) {}
    for (float f1 = j / i;; f1 = 1.0F)
    {
      if (f1 == 1.0F)
      {
        AppMethodBeat.o(1005);
        return paramBitmap;
      }
      i = (int)(paramBitmap.getWidth() * f1 + 0.5F);
      j = (int)(f1 * paramBitmap.getHeight() + 0.5F);
      f1 = i / paramBitmap.getWidth();
      float f2 = j / paramBitmap.getHeight();
      Log.d("MicroMsg.MMBitmapFactory", "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2) });
      paramOptions = new Matrix();
      paramOptions.setScale(f1, f2);
      paramOptions = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramOptions, true);
      if (paramOptions != paramBitmap) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(1005);
      return paramOptions;
    }
  }
  
  public static void setDecodeCanary(a parama)
  {
    sDecodeCanary = parama;
  }
  
  private static void setDensityFromOptions(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(1006);
    if ((paramBitmap == null) || (paramOptions == null))
    {
      AppMethodBeat.o(1006);
      return;
    }
    int i = paramOptions.inDensity;
    if (i != 0)
    {
      paramBitmap.setDensity(i);
      int j = paramOptions.inTargetDensity;
      if ((j == 0) || (i == j) || (i == paramOptions.inScreenDensity))
      {
        AppMethodBeat.o(1006);
        return;
      }
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if ((arrayOfByte != null) && (NinePatch.isNinePatchChunk(arrayOfByte))) {}
      for (i = 1;; i = 0)
      {
        if ((paramOptions.inScaled) || (i != 0)) {
          paramBitmap.setDensity(j);
        }
        AppMethodBeat.o(1006);
        return;
      }
    }
    if (paramOptions.inBitmap != null) {
      paramBitmap.setDensity(160);
    }
    AppMethodBeat.o(1006);
  }
  
  public static void setForceUsingSystemDecoder(boolean paramBoolean)
  {
    AppMethodBeat.i(981);
    Log.w("MicroMsg.MMBitmapFactory", "[!] setForceUsingSystemDecoder, value: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    sForceUsingSystemDecoderOpt = paramBoolean;
    AppMethodBeat.o(981);
  }
  
  public static void setStreamProvider(b paramb)
  {
    sStreamProvider = paramb;
  }
  
  public static Bitmap unPinBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(1001);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.MMBitmapFactory", "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", new Object[] { paramBitmap, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramBitmap.getConfig(), Integer.valueOf(paramBitmap.getByteCount()) });
      int i = nativeUnPinBitmap(paramBitmap);
      if (i < 0) {
        Log.e("MicroMsg.MMBitmapFactory", "unPinBitmap failed, ret: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    AppMethodBeat.o(1001);
    return paramBitmap;
  }
  
  private static InputStream wrapUnResetableStreamOnDemand(InputStream paramInputStream)
  {
    AppMethodBeat.i(1008);
    if (paramInputStream.markSupported())
    {
      AppMethodBeat.o(1008);
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream))
    {
      paramInputStream = new a((FileInputStream)paramInputStream);
      AppMethodBeat.o(1008);
      return paramInputStream;
    }
    paramInputStream = new BufferedInputStream(paramInputStream);
    AppMethodBeat.o(1008);
    return paramInputStream;
  }
  
  static final class a
    extends FilterInputStream
  {
    private long gwZ = 0L;
    
    public a(FileInputStream paramFileInputStream)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      try
      {
        AppMethodBeat.i(978);
        try
        {
          this.gwZ = ((FileInputStream)this.in).getChannel().position();
          AppMethodBeat.o(978);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMBitmapFactory", localIOException, "fail to mark position.");
            this.gwZ = -1L;
            AppMethodBeat.o(978);
          }
        }
        return;
      }
      finally {}
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(979);
        if (this.gwZ < 0L)
        {
          IOException localIOException = new IOException("Illegal marked position: " + this.gwZ);
          AppMethodBeat.o(979);
          throw localIOException;
        }
      }
      finally {}
      ((FileInputStream)this.in).getChannel().position(this.gwZ);
      AppMethodBeat.o(979);
    }
  }
  
  public static abstract class b
  {
    public InputStream getStreamFromPath(String paramString)
    {
      return new FileInputStream(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.graphics.MMBitmapFactory
 * JD-Core Version:    0.7.0.1
 */