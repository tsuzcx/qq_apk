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

public class MMBitmapFactory
{
  private static final int DENSITY_DEFAULT = 160;
  private static final int REWIND_BUFFER_SIZE = 8388608;
  private static final String TAG = "MicroMsg.MMBitmapFactory";
  private static final int TEMP_STORAGE_SIZE = 4096;
  private static a sDecodeCanary;
  private static boolean sForceUsingSystemDecoderOpt;
  private static b sStreamProvider;
  private byte _hellAccFlag_;
  
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
        break label185;
      }
      int i = paramBitmap.getByteCount();
      if (i >= sDecodeCanary.aXW()) {
        sDecodeCanary.a(paramOptions, i);
      }
      AppMethodBeat.o(999);
      return;
    }
    Log.e("MicroMsg.MMBitmapFactory", "[+] fail to decode by %s", new Object[] { str });
    label185:
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
      return;
    }
    finally
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
    finally
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
  
  private static Bitmap decodeFileDescriptorInternal(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    int i = 0;
    AppMethodBeat.i(991);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (isForceSystemDecoder(localOptions))
    {
      Log.w("MicroMsg.MMBitmapFactory", "[!] force decoding fd %s by system codec.", new Object[] { paramFileDescriptor });
      paramFileDescriptor = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, paramRect, localOptions);
      announceDecodeResult(localOptions, paramFileDescriptor, true);
      AppMethodBeat.o(991);
      return paramFileDescriptor;
    }
    if (nativeIsSeekable(paramFileDescriptor)) {
      try
      {
        paramOptions = nativeDecodeFileDescriptor(paramFileDescriptor, getOrCreateStorageBuffer(localOptions), paramRect, localOptions);
        if (localOptions.outMimeType != null) {
          i = 1;
        }
        if (i != 0)
        {
          announceDecodeResult(localOptions, paramOptions, false);
          setDensityFromOptions(paramOptions, localOptions);
          paramFileDescriptor = scaleBitmapOnDemand(paramOptions, localOptions);
          AppMethodBeat.o(991);
          return paramFileDescriptor;
        }
        Log.w("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
        paramFileDescriptor = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, paramRect, localOptions);
        announceDecodeResult(localOptions, paramFileDescriptor, true);
        AppMethodBeat.o(991);
        return paramFileDescriptor;
      }
      finally
      {
        Log.e("MicroMsg.MMBitmapFactory", paramFileDescriptor, "decode failed.");
        AppMethodBeat.o(991);
        return null;
      }
    }
    try
    {
      paramFileDescriptor = new FileInputStream(paramFileDescriptor);
      try
      {
        Log.e("MicroMsg.MMBitmapFactory", paramRect, "decode failed.");
        return null;
      }
      finally
      {
        closeQuietly(paramFileDescriptor);
        AppMethodBeat.o(991);
      }
    }
    finally
    {
      try
      {
        paramRect = decodeStreamInternal(paramFileDescriptor, paramRect, localOptions);
        closeQuietly(paramFileDescriptor);
        AppMethodBeat.o(991);
        return paramRect;
      }
      finally {}
      paramRect = finally;
      paramFileDescriptor = null;
    }
  }
  
  private static Bitmap decodeFileInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    AppMethodBeat.i(987);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (isForceSystemDecoder(localOptions))
    {
      Log.w("MicroMsg.MMBitmapFactory", "[!] force decoding file %s by system codec.", new Object[] { paramString });
      paramString = decodeFileWithStreamBySystemInternal(paramString, localOptions);
      AppMethodBeat.o(987);
      return paramString;
    }
    try
    {
      paramOptions = wrapUnResetableStreamOnDemand(getStreamFromPath(paramString));
      try
      {
        Bitmap localBitmap;
        Log.e("MicroMsg.MMBitmapFactory", paramString, "decode failed.");
        return null;
      }
      finally
      {
        closeQuietly(paramOptions);
        AppMethodBeat.o(987);
      }
    }
    finally
    {
      try
      {
        paramOptions.mark(getCompatibleRewindBufferSize());
        localBitmap = nativeDecodeStream(paramOptions, null, localOptions);
        if (localOptions.outMimeType != null) {}
        while (i != 0)
        {
          announceDecodeResult(localOptions, localBitmap, false);
          setDensityFromOptions(localBitmap, localOptions);
          paramString = scaleBitmapOnDemand(localBitmap, localOptions);
          closeQuietly(paramOptions);
          AppMethodBeat.o(987);
          return paramString;
          i = 0;
        }
        Log.w("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
        paramString = decodeFileWithStreamBySystemInternal(paramString, localOptions);
        closeQuietly(paramOptions);
        AppMethodBeat.o(987);
        return paramString;
      }
      finally
      {
        break label157;
      }
      paramString = finally;
      paramOptions = null;
    }
  }
  
  /* Error */
  private static Bitmap decodeFileWithStreamBySystemInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: sipush 988
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 41	com/tencent/mm/graphics/MMBitmapFactory:sStreamProvider	Lcom/tencent/mm/graphics/MMBitmapFactory$b;
    //   9: ifnull +80 -> 89
    //   12: aload_0
    //   13: invokestatic 242	com/tencent/mm/graphics/MMBitmapFactory:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: invokestatic 246	com/tencent/mm/graphics/MMBitmapFactory:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 249	com/tencent/mm/graphics/MMBitmapFactory:getCompatibleRewindBufferSize	()I
    //   24: invokevirtual 254	java/io/InputStream:mark	(I)V
    //   27: aload_0
    //   28: aconst_null
    //   29: aload_1
    //   30: invokestatic 260	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_2
    //   34: aload_1
    //   35: aload_2
    //   36: iconst_1
    //   37: invokestatic 170	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   40: aload_0
    //   41: invokestatic 233	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   44: sipush 988
    //   47: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: areturn
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_0
    //   55: ldc 21
    //   57: aload_1
    //   58: ldc_w 262
    //   61: invokestatic 188	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   64: aload_0
    //   65: invokestatic 233	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   68: sipush 988
    //   71: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_1
    //   77: aload_0
    //   78: invokestatic 233	com/tencent/mm/graphics/MMBitmapFactory:closeQuietly	(Ljava/io/Closeable;)V
    //   81: sipush 988
    //   84: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: athrow
    //   89: aload_0
    //   90: aload_1
    //   91: invokestatic 264	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   94: astore_0
    //   95: aload_1
    //   96: aload_0
    //   97: iconst_1
    //   98: invokestatic 170	com/tencent/mm/graphics/MMBitmapFactory:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   101: sipush 988
    //   104: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: ldc 21
    //   112: aload_0
    //   113: ldc_w 262
    //   116: invokestatic 188	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   119: sipush 988
    //   122: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: goto -73 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   0	131	1	paramOptions	BitmapFactory.Options
    //   33	18	2	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   12	20	52	finally
    //   55	64	76	finally
    //   89	101	109	finally
    //   20	40	127	finally
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
        finally
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
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/graphics/MMBitmapFactory", "loadNativeModule", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/graphics/MMBitmapFactory", "loadNativeModule", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      Log.i("MicroMsg.MMBitmapFactory", "Successfully load native module: %s", new Object[] { paramString });
      AppMethodBeat.o(1009);
      return;
    }
    finally
    {
      Log.e("MicroMsg.MMBitmapFactory", localThrowable, "Fail to load native module: %s", new Object[] { paramString });
      paramString = new RuntimeException(localThrowable);
      AppMethodBeat.o(1009);
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
    private long mvq = 0L;
    
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
          this.mvq = ((FileInputStream)this.in).getChannel().position();
          AppMethodBeat.o(978);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMBitmapFactory", localIOException, "fail to mark position.");
            this.mvq = -1L;
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
        if (this.mvq < 0L)
        {
          IOException localIOException = new IOException("Illegal marked position: " + this.mvq);
          AppMethodBeat.o(979);
          throw localIOException;
        }
      }
      finally {}
      ((FileInputStream)this.in).getChannel().position(this.mvq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.MMBitmapFactory
 * JD-Core Version:    0.7.0.1
 */