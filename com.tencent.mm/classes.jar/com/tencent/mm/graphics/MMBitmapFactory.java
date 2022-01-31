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
import com.tencent.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static b sStreamProvider;
  
  static
  {
    AppMethodBeat.i(57658);
    sStreamProvider = null;
    loadNativeModule("mmimgcodec");
    AppMethodBeat.o(57658);
  }
  
  private MMBitmapFactory()
  {
    AppMethodBeat.i(57657);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(57657);
    throw localUnsupportedOperationException;
  }
  
  public static void addExternalCodecLibDir(String paramString)
  {
    AppMethodBeat.i(57633);
    b.i("MicroMsg.MMBitmapFactory", "[+] add external codec library path: %s", new Object[] { paramString });
    nativeAddExternalLibDir(paramString);
    AppMethodBeat.o(57633);
  }
  
  private static void announceDecodeResult(BitmapFactory.Options paramOptions, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(138193);
    assertNotNull(paramOptions, "[-] opts is null.");
    if (paramBoolean) {}
    for (String str = "system"; ((paramBitmap != null) || (paramOptions.outMimeType != null)) && (paramOptions.outWidth > 0) && (paramOptions.outHeight > 0); str = "mmcodec")
    {
      b.i("MicroMsg.MMBitmapFactory", "[+] decode success by %s, w:%s, h:%s, mime-type:%s, sampleSize:%s", new Object[] { str, Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight), paramOptions.outMimeType, Integer.valueOf(paramOptions.inSampleSize) });
      AppMethodBeat.o(138193);
      return;
    }
    b.e("MicroMsg.MMBitmapFactory", "[+] fail to decode by %s", new Object[] { str });
    AppMethodBeat.o(138193);
  }
  
  private static void assertNotNull(Object paramObject, String paramString)
  {
    AppMethodBeat.i(57652);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException(paramString);
      AppMethodBeat.o(57652);
      throw paramObject;
    }
    AppMethodBeat.o(57652);
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(57653);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(57653);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(57653);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(57653);
    }
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57643);
    assertNotNull(paramArrayOfByte, "'data' is null.");
    paramArrayOfByte = decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, null);
    AppMethodBeat.o(57643);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57644);
    assertNotNull(paramArrayOfByte, "'data' is null.");
    paramArrayOfByte = decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
    AppMethodBeat.o(57644);
    return paramArrayOfByte;
  }
  
  private static Bitmap decodeByteArrayInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    int i = 0;
    AppMethodBeat.i(57645);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (isForceSystemDecoder(localOptions))
    {
      b.w("MicroMsg.MMBitmapFactory", "[!] force decoding data by system codec.");
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      announceDecodeResult(localOptions, paramArrayOfByte, true);
      AppMethodBeat.o(57645);
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
        AppMethodBeat.o(57645);
        return paramArrayOfByte;
      }
      b.w("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      announceDecodeResult(localOptions, paramArrayOfByte, true);
      AppMethodBeat.o(57645);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      b.b("MicroMsg.MMBitmapFactory", paramArrayOfByte, "decode failed.");
      AppMethodBeat.o(57645);
    }
    return null;
  }
  
  public static Bitmap decodeFile(String paramString)
  {
    AppMethodBeat.i(57637);
    assertNotNull(paramString, "'pathName' is null.");
    paramString = decodeFileInternal(paramString, null);
    AppMethodBeat.o(57637);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57638);
    assertNotNull(paramString, "'pathName' is null.");
    paramString = decodeFileInternal(paramString, paramOptions);
    AppMethodBeat.o(57638);
    return paramString;
  }
  
  public static Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(57640);
    assertNotNull(paramFileDescriptor, "'fd' is null.");
    paramFileDescriptor = decodeFileDescriptorInternal(paramFileDescriptor, null, null);
    AppMethodBeat.o(57640);
    return paramFileDescriptor;
  }
  
  public static Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57641);
    assertNotNull(paramFileDescriptor, "'fd' is null.");
    paramFileDescriptor = decodeFileDescriptorInternal(paramFileDescriptor, paramRect, paramOptions);
    AppMethodBeat.o(57641);
    return paramFileDescriptor;
  }
  
  /* Error */
  private static Bitmap decodeFileDescriptorInternal(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 189
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: astore 4
    //   10: aload_2
    //   11: ifnonnull +12 -> 23
    //   14: new 80	android/graphics/BitmapFactory$Options
    //   17: dup
    //   18: invokespecial 134	android/graphics/BitmapFactory$Options:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 138	com/tencent/mm/graphics/MMBitmapFactory:isForceSystemDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   28: ifeq +40 -> 68
    //   31: ldc 23
    //   33: ldc 191
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: aastore
    //   43: invokestatic 193	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload_1
    //   48: aload 4
    //   50: invokestatic 195	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: astore_0
    //   54: aload 4
    //   56: aload_0
    //   57: iconst_1
    //   58: invokestatic 150	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   61: ldc 189
    //   63: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: aload_0
    //   69: invokestatic 199	com/tencent/mm/graphics/MMBitmapFactory:nativeIsSeekable	(Ljava/io/FileDescriptor;)Z
    //   72: ifeq +102 -> 174
    //   75: aload_0
    //   76: aload 4
    //   78: invokestatic 203	com/tencent/mm/graphics/MMBitmapFactory:getOrCreateStorageBuffer	(Landroid/graphics/BitmapFactory$Options;)[B
    //   81: aload_1
    //   82: aload 4
    //   84: invokestatic 207	com/tencent/mm/graphics/MMBitmapFactory:nativeDecodeFileDescriptor	(Ljava/io/FileDescriptor;[BLandroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   87: astore_2
    //   88: aload 4
    //   90: getfield 83	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   93: ifnull +5 -> 98
    //   96: iconst_1
    //   97: istore_3
    //   98: iload_3
    //   99: ifeq +30 -> 129
    //   102: aload 4
    //   104: aload_2
    //   105: iconst_0
    //   106: invokestatic 150	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   109: aload_2
    //   110: aload 4
    //   112: invokestatic 157	com/tencent/mm/graphics/MMBitmapFactory:setDensityFromOptions	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)V
    //   115: aload_2
    //   116: aload 4
    //   118: invokestatic 161	com/tencent/mm/graphics/MMBitmapFactory:scaleBitmapOnDemand	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   121: astore_0
    //   122: ldc 189
    //   124: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: areturn
    //   129: ldc 23
    //   131: ldc 163
    //   133: invokestatic 144	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: aload_1
    //   138: aload 4
    //   140: invokestatic 195	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   143: astore_0
    //   144: aload 4
    //   146: aload_0
    //   147: iconst_1
    //   148: invokestatic 150	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   151: ldc 189
    //   153: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_0
    //   157: areturn
    //   158: astore_0
    //   159: ldc 23
    //   161: aload_0
    //   162: ldc 165
    //   164: invokestatic 168	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   167: ldc 189
    //   169: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aconst_null
    //   173: areturn
    //   174: new 209	java/io/FileInputStream
    //   177: dup
    //   178: aload_0
    //   179: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   182: astore_2
    //   183: aload_2
    //   184: astore_0
    //   185: aload_2
    //   186: aload_1
    //   187: aload 4
    //   189: invokestatic 216	com/tencent/mm/graphics/MMBitmapFactory:decodeStreamInternal	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   192: astore_1
    //   193: aload_2
    //   194: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   197: ldc 189
    //   199: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: areturn
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: astore_0
    //   210: ldc 23
    //   212: aload 4
    //   214: ldc 165
    //   216: invokestatic 168	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   219: aload_1
    //   220: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   223: ldc 189
    //   225: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_0
    //   233: aload_0
    //   234: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   237: ldc 189
    //   239: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: goto -12 -> 233
    //   248: astore 4
    //   250: aload_2
    //   251: astore_1
    //   252: goto -44 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramFileDescriptor	FileDescriptor
    //   0	255	1	paramRect	Rect
    //   0	255	2	paramOptions	BitmapFactory.Options
    //   1	98	3	i	int
    //   8	180	4	localOptions	BitmapFactory.Options
    //   204	9	4	localThrowable1	Throwable
    //   248	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   75	88	158	java/lang/Throwable
    //   88	96	158	java/lang/Throwable
    //   102	122	158	java/lang/Throwable
    //   129	151	158	java/lang/Throwable
    //   174	183	204	java/lang/Throwable
    //   174	183	230	finally
    //   185	193	244	finally
    //   210	219	244	finally
    //   185	193	248	java/lang/Throwable
  }
  
  /* Error */
  private static Bitmap decodeFileInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 219
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: astore 4
    //   10: aload_1
    //   11: ifnonnull +12 -> 23
    //   14: new 80	android/graphics/BitmapFactory$Options
    //   17: dup
    //   18: invokespecial 134	android/graphics/BitmapFactory$Options:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 138	com/tencent/mm/graphics/MMBitmapFactory:isForceSystemDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   28: ifeq +32 -> 60
    //   31: ldc 23
    //   33: ldc 221
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: aastore
    //   43: invokestatic 193	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload 4
    //   49: invokestatic 224	com/tencent/mm/graphics/MMBitmapFactory:decodeFileWithStreamBySystemInternal	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   52: astore_0
    //   53: ldc 219
    //   55: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: areturn
    //   60: aload_0
    //   61: invokestatic 228	com/tencent/mm/graphics/MMBitmapFactory:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   64: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   67: astore_3
    //   68: aload_3
    //   69: astore_1
    //   70: aload_3
    //   71: invokestatic 236	com/tencent/mm/graphics/MMBitmapFactory:getCompatibleRewindBufferSize	()I
    //   74: invokevirtual 241	java/io/InputStream:mark	(I)V
    //   77: aload_3
    //   78: astore_1
    //   79: aload_3
    //   80: aconst_null
    //   81: aload 4
    //   83: invokestatic 244	com/tencent/mm/graphics/MMBitmapFactory:nativeDecodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   86: astore 5
    //   88: aload_3
    //   89: astore_1
    //   90: aload 4
    //   92: getfield 83	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   95: ifnull +47 -> 142
    //   98: iload_2
    //   99: ifeq +48 -> 147
    //   102: aload_3
    //   103: astore_1
    //   104: aload 4
    //   106: aload 5
    //   108: iconst_0
    //   109: invokestatic 150	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   112: aload_3
    //   113: astore_1
    //   114: aload 5
    //   116: aload 4
    //   118: invokestatic 157	com/tencent/mm/graphics/MMBitmapFactory:setDensityFromOptions	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)V
    //   121: aload_3
    //   122: astore_1
    //   123: aload 5
    //   125: aload 4
    //   127: invokestatic 161	com/tencent/mm/graphics/MMBitmapFactory:scaleBitmapOnDemand	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   130: astore_0
    //   131: aload_3
    //   132: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   135: ldc 219
    //   137: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_0
    //   141: areturn
    //   142: iconst_0
    //   143: istore_2
    //   144: goto -46 -> 98
    //   147: aload_3
    //   148: astore_1
    //   149: ldc 23
    //   151: ldc 163
    //   153: invokestatic 144	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_3
    //   157: astore_1
    //   158: aload_0
    //   159: aload 4
    //   161: invokestatic 224	com/tencent/mm/graphics/MMBitmapFactory:decodeFileWithStreamBySystemInternal	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   164: astore_0
    //   165: aload_3
    //   166: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   169: ldc 219
    //   171: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_0
    //   175: areturn
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: astore_1
    //   181: ldc 23
    //   183: aload_0
    //   184: ldc 165
    //   186: invokestatic 168	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   189: aload_3
    //   190: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   193: ldc 219
    //   195: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   207: ldc 219
    //   209: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: goto -12 -> 203
    //   218: astore_0
    //   219: goto -40 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramString	String
    //   0	222	1	paramOptions	BitmapFactory.Options
    //   1	143	2	i	int
    //   67	123	3	localInputStream	InputStream
    //   8	152	4	localOptions	BitmapFactory.Options
    //   86	38	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   60	68	176	java/lang/Throwable
    //   60	68	200	finally
    //   70	77	214	finally
    //   79	88	214	finally
    //   90	98	214	finally
    //   104	112	214	finally
    //   114	121	214	finally
    //   123	131	214	finally
    //   149	156	214	finally
    //   158	165	214	finally
    //   181	189	214	finally
    //   70	77	218	java/lang/Throwable
    //   79	88	218	java/lang/Throwable
    //   90	98	218	java/lang/Throwable
    //   104	112	218	java/lang/Throwable
    //   114	121	218	java/lang/Throwable
    //   123	131	218	java/lang/Throwable
    //   149	156	218	java/lang/Throwable
    //   158	165	218	java/lang/Throwable
  }
  
  /* Error */
  private static Bitmap decodeFileWithStreamBySystemInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 245
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 38	com/tencent/mm/graphics/MMBitmapFactory:sStreamProvider	Lcom/tencent/mm/graphics/MMBitmapFactory$b;
    //   8: ifnull +86 -> 94
    //   11: aload_0
    //   12: invokestatic 228	com/tencent/mm/graphics/MMBitmapFactory:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: invokestatic 232	com/tencent/mm/graphics/MMBitmapFactory:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: aload_2
    //   22: invokestatic 236	com/tencent/mm/graphics/MMBitmapFactory:getCompatibleRewindBufferSize	()I
    //   25: invokevirtual 241	java/io/InputStream:mark	(I)V
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: aconst_null
    //   32: aload_1
    //   33: invokestatic 248	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   36: astore_3
    //   37: aload_2
    //   38: astore_0
    //   39: aload_1
    //   40: aload_3
    //   41: iconst_1
    //   42: invokestatic 150	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   45: aload_2
    //   46: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   49: ldc 245
    //   51: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_3
    //   55: areturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_0
    //   61: ldc 23
    //   63: aload_1
    //   64: ldc 250
    //   66: invokestatic 168	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   69: aload_2
    //   70: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   73: ldc 245
    //   75: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: invokestatic 218	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   87: ldc 245
    //   89: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    //   94: aload_0
    //   95: aload_1
    //   96: invokestatic 252	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   99: astore_0
    //   100: aload_1
    //   101: aload_0
    //   102: iconst_1
    //   103: invokestatic 150	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   106: ldc 245
    //   108: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: ldc 23
    //   116: aload_0
    //   117: ldc 250
    //   119: invokestatic 168	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   122: ldc 245
    //   124: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_1
    //   130: goto -47 -> 83
    //   133: astore_1
    //   134: goto -75 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   0	137	1	paramOptions	BitmapFactory.Options
    //   18	52	2	localInputStream	InputStream
    //   36	19	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   11	19	56	java/lang/Throwable
    //   11	19	80	finally
    //   94	106	113	java/lang/Throwable
    //   21	28	129	finally
    //   30	37	129	finally
    //   39	45	129	finally
    //   61	69	129	finally
    //   21	28	133	java/lang/Throwable
    //   30	37	133	java/lang/Throwable
    //   39	45	133	java/lang/Throwable
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(57634);
    b.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", new Object[] { paramResources, Integer.valueOf(paramInt) });
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt);
    AppMethodBeat.o(57634);
    return paramResources;
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57635);
    b.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", new Object[] { paramResources, Integer.valueOf(paramInt), paramOptions });
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt, paramOptions);
    AppMethodBeat.o(57635);
    return paramResources;
  }
  
  public static Bitmap decodeResourceStream(Resources paramResources, TypedValue paramTypedValue, InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57636);
    b.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", new Object[] { paramResources, paramTypedValue, paramInputStream, paramRect, paramOptions });
    paramResources = BitmapFactory.decodeResourceStream(paramResources, paramTypedValue, paramInputStream, paramRect, paramOptions);
    AppMethodBeat.o(57636);
    return paramResources;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(57646);
    assertNotNull(paramInputStream, "'is' is null.");
    paramInputStream = decodeStreamInternal(paramInputStream, null, null);
    AppMethodBeat.o(57646);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57647);
    assertNotNull(paramInputStream, "'is' is null.");
    paramInputStream = decodeStreamInternal(paramInputStream, paramRect, paramOptions);
    AppMethodBeat.o(57647);
    return paramInputStream;
  }
  
  private static Bitmap decodeStreamInternal(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    int j = 0;
    AppMethodBeat.i(57648);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    int i;
    if ((paramInputStream instanceof AssetManager.AssetInputStream))
    {
      b.w("MicroMsg.MMBitmapFactory", "[!] force decoding stream by system codec since it's asset stream.");
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
        announceDecodeResult(localOptions, paramInputStream, true);
        AppMethodBeat.o(57648);
        return paramInputStream;
        if (isForceSystemDecoder(localOptions))
        {
          b.w("MicroMsg.MMBitmapFactory", "[!] force decoding stream by system codec since specific options.");
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
            AppMethodBeat.o(57648);
            return paramInputStream;
          }
          b.w("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
          paramInputStream.reset();
          paramInputStream.mark(getCompatibleRewindBufferSize());
          paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
          announceDecodeResult(localOptions, paramInputStream, true);
          AppMethodBeat.o(57648);
          return paramInputStream;
        }
        catch (Throwable paramInputStream)
        {
          b.b("MicroMsg.MMBitmapFactory", paramInputStream, "decode failed.");
          AppMethodBeat.o(57648);
          return null;
        }
      }
      i = 0;
    }
  }
  
  private static int getCompatibleRewindBufferSize()
  {
    AppMethodBeat.i(138505);
    if ("HUAWEI".equals(Build.MANUFACTURER))
    {
      AppMethodBeat.o(138505);
      return 8388608;
    }
    AppMethodBeat.o(138505);
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
    AppMethodBeat.i(142693);
    if (sStreamProvider != null)
    {
      paramString = new FileInputStream(paramString);
      AppMethodBeat.o(142693);
      return paramString;
    }
    paramString = new FileInputStream(paramString);
    AppMethodBeat.o(142693);
    return paramString;
  }
  
  public static String getVersion()
  {
    return "0.2.24";
  }
  
  private static boolean isForceSystemDecoder(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57651);
    if ((paramOptions != null) && (Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.HARDWARE.equals(paramOptions.inPreferredConfig)))
    {
      AppMethodBeat.o(57651);
      return true;
    }
    AppMethodBeat.o(57651);
    return false;
  }
  
  private static void loadNativeModule(String paramString)
  {
    AppMethodBeat.i(57656);
    try
    {
      System.loadLibrary(paramString);
      b.i("MicroMsg.MMBitmapFactory", "Successfully load native module: %s", new Object[] { paramString });
      AppMethodBeat.o(57656);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a("MicroMsg.MMBitmapFactory", localThrowable, "Fail to load native module: %s", new Object[] { paramString });
      paramString = new RuntimeException(localThrowable);
      AppMethodBeat.o(57656);
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
    AppMethodBeat.i(57649);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.i("MicroMsg.MMBitmapFactory", "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", new Object[] { paramBitmap, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramBitmap.getConfig(), Integer.valueOf(paramBitmap.getByteCount()) });
      int i = nativePinBitmap(paramBitmap);
      if (i < 0) {
        b.e("MicroMsg.MMBitmapFactory", "pinBitmap failed, ret: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    AppMethodBeat.o(57649);
    return paramBitmap;
  }
  
  private static Bitmap scaleBitmapOnDemand(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57654);
    if ((paramBitmap == null) || (paramOptions == null))
    {
      AppMethodBeat.o(57654);
      return paramBitmap;
    }
    if (!paramOptions.inScaled)
    {
      AppMethodBeat.o(57654);
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
        AppMethodBeat.o(57654);
        return paramBitmap;
      }
      i = (int)(paramBitmap.getWidth() * f1 + 0.5F);
      j = (int)(f1 * paramBitmap.getHeight() + 0.5F);
      f1 = i / paramBitmap.getWidth();
      float f2 = j / paramBitmap.getHeight();
      b.d("MicroMsg.MMBitmapFactory", "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2) });
      paramOptions = new Matrix();
      paramOptions.setScale(f1, f2);
      paramOptions = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramOptions, true);
      if (paramOptions != paramBitmap) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(57654);
      return paramOptions;
    }
  }
  
  private static void setDensityFromOptions(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(57655);
    if ((paramBitmap == null) || (paramOptions == null))
    {
      AppMethodBeat.o(57655);
      return;
    }
    int i = paramOptions.inDensity;
    if (i != 0)
    {
      paramBitmap.setDensity(i);
      int j = paramOptions.inTargetDensity;
      if ((j == 0) || (i == j) || (i == paramOptions.inScreenDensity))
      {
        AppMethodBeat.o(57655);
        return;
      }
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if ((arrayOfByte != null) && (NinePatch.isNinePatchChunk(arrayOfByte))) {}
      for (i = 1;; i = 0)
      {
        if ((paramOptions.inScaled) || (i != 0)) {
          paramBitmap.setDensity(j);
        }
        AppMethodBeat.o(57655);
        return;
      }
    }
    if (paramOptions.inBitmap != null) {
      paramBitmap.setDensity(160);
    }
    AppMethodBeat.o(57655);
  }
  
  public static void setStreamProvider(b paramb)
  {
    sStreamProvider = paramb;
  }
  
  public static Bitmap unPinBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(57650);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.i("MicroMsg.MMBitmapFactory", "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", new Object[] { paramBitmap, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramBitmap.getConfig(), Integer.valueOf(paramBitmap.getByteCount()) });
      int i = nativeUnPinBitmap(paramBitmap);
      if (i < 0) {
        b.e("MicroMsg.MMBitmapFactory", "unPinBitmap failed, ret: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    AppMethodBeat.o(57650);
    return paramBitmap;
  }
  
  private static InputStream wrapUnResetableStreamOnDemand(InputStream paramInputStream)
  {
    AppMethodBeat.i(138506);
    if (paramInputStream.markSupported())
    {
      AppMethodBeat.o(138506);
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream))
    {
      paramInputStream = new a((FileInputStream)paramInputStream);
      AppMethodBeat.o(138506);
      return paramInputStream;
    }
    paramInputStream = new BufferedInputStream(paramInputStream);
    AppMethodBeat.o(138506);
    return paramInputStream;
  }
  
  @Keep
  public static class Options
    extends BitmapFactory.Options
  {
    @Keep
    public boolean inUseSmoothSample = true;
  }
  
  static final class a
    extends FilterInputStream
  {
    private long eAy = 0L;
    
    public a(FileInputStream paramFileInputStream)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      try
      {
        AppMethodBeat.i(138503);
        try
        {
          this.eAy = ((FileInputStream)this.in).getChannel().position();
          AppMethodBeat.o(138503);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            b.b("MicroMsg.MMBitmapFactory", localIOException, "fail to mark position.");
            this.eAy = -1L;
            AppMethodBeat.o(138503);
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
        AppMethodBeat.i(138504);
        if (this.eAy < 0L)
        {
          IOException localIOException = new IOException("Illegal marked position: " + this.eAy);
          AppMethodBeat.o(138504);
          throw localIOException;
        }
      }
      finally {}
      ((FileInputStream)this.in).getChannel().position(this.eAy);
      AppMethodBeat.o(138504);
    }
  }
  
  public static abstract class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.graphics.MMBitmapFactory
 * JD-Core Version:    0.7.0.1
 */