package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class j
  extends l
{
  /* Error */
  private static Bitmap a(InputStream paramInputStream, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   3: invokevirtual 23	com/tencent/mm/memory/h:de	()Ljava/lang/Object;
    //   6: checkcast 25	java/nio/ByteBuffer
    //   9: astore_3
    //   10: aload_0
    //   11: aconst_null
    //   12: aload_0
    //   13: aload_1
    //   14: aload_3
    //   15: iconst_0
    //   16: aconst_null
    //   17: invokestatic 28	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/nio/ByteBuffer;ZLandroid/graphics/Rect;)Landroid/graphics/BitmapFactory$Options;
    //   20: aload_2
    //   21: invokestatic 31	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   24: astore_0
    //   25: aload_3
    //   26: ifnull +83 -> 109
    //   29: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   32: aload_3
    //   33: invokevirtual 35	com/tencent/mm/memory/h:D	(Ljava/lang/Object;)Z
    //   36: pop
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_0
    //   42: ldc 37
    //   44: ldc 39
    //   46: iconst_1
    //   47: anewarray 41	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 51	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: ifnull +46 -> 107
    //   64: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   67: aload_0
    //   68: invokevirtual 35	com/tencent/mm/memory/h:D	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: aconst_null
    //   73: areturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull +11 -> 89
    //   81: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   84: aload_0
    //   85: invokevirtual 35	com/tencent/mm/memory/h:D	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_3
    //   93: astore_0
    //   94: goto -17 -> 77
    //   97: astore_1
    //   98: goto -21 -> 77
    //   101: astore_1
    //   102: aload_3
    //   103: astore_0
    //   104: goto -62 -> 42
    //   107: aconst_null
    //   108: areturn
    //   109: aload_0
    //   110: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramInputStream	InputStream
    //   0	111	1	paramOptions	BitmapFactory.Options
    //   0	111	2	paramDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    //   9	94	3	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	10	39	java/lang/Exception
    //   0	10	74	finally
    //   10	25	91	finally
    //   42	60	97	finally
    //   10	25	101	java/lang/Exception
  }
  
  private static Bitmap a(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        localInputStream = m(paramInputStream);
        n(localInputStream);
        localInputStream.mark(1048576);
        if (paramRect != null) {}
      }
      catch (Exception paramRect)
      {
        InputStream localInputStream;
        String str;
        int k;
        int m;
        int n;
        paramInputStream = null;
        y.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", new Object[] { paramRect.getMessage() });
        paramOptions = paramInputStream;
        continue;
        i = 0;
        continue;
        j = 0;
        continue;
        paramOptions = MMBitmapFactory.decodeRegion(localInputStream, paramRect, paramOptions, paramDecodeResultLogger);
        paramInputStream = paramOptions;
        continue;
        continue;
      }
      try
      {
        paramInputStream = MMBitmapFactory.decodeStream(localInputStream, null, paramOptions, paramDecodeResultLogger, 0, new int[0]);
        if (paramInputStream != null) {
          continue;
        }
      }
      catch (Exception paramInputStream)
      {
        str = paramInputStream.getMessage();
        k = paramOptions.outWidth;
        m = paramOptions.outHeight;
        n = paramOptions.inSampleSize;
        if (paramOptions.inBitmap == null) {}
      }
      try
      {
        y.i("MicroMsg.InBitmapFactory", "decode again");
        n(localInputStream);
        paramOptions.inBitmap = null;
        if (paramRect == null)
        {
          paramOptions = MMBitmapFactory.decodeStream(localInputStream, null, paramOptions, paramDecodeResultLogger, 0, new int[0]);
          paramInputStream = paramOptions;
          paramOptions = paramInputStream;
          if (paramRect != null)
          {
            paramOptions = paramInputStream;
            if (paramInputStream != null) {
              paramOptions = paramInputStream;
            }
          }
        }
      }
      catch (Exception paramRect)
      {
        int i;
        int j;
        continue;
      }
      try
      {
        if (paramInputStream.getWidth() > paramRect.right - paramRect.left)
        {
          paramOptions = paramInputStream;
          if (paramInputStream.getHeight() > paramRect.bottom - paramRect.top)
          {
            y.i("MicroMsg.InBitmapFactory", "fuck region decode size not match, clip it, reqWidth: %s, reqHeight: %s, resultWidth: %s, resultHeight: %s", new Object[] { Integer.valueOf(paramRect.right - paramRect.left), Integer.valueOf(paramRect.bottom - paramRect.top), Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInputStream.getHeight()) });
            paramOptions = Bitmap.createBitmap(paramInputStream, 0, 0, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
          }
        }
        if (paramOptions != null) {
          y.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", new Object[] { paramOptions, Integer.valueOf(paramOptions.getWidth()), Integer.valueOf(paramOptions.getHeight()) });
        }
        return paramOptions;
      }
      catch (Exception paramRect)
      {
        continue;
      }
      paramInputStream = MMBitmapFactory.decodeRegion(localInputStream, paramRect, paramOptions, paramDecodeResultLogger);
      continue;
      i = paramOptions.inBitmap.getWidth();
      if (paramOptions.inBitmap == null) {
        continue;
      }
      j = paramOptions.inBitmap.getHeight();
      y.printErrStackTrace("MicroMsg.InBitmapFactory", paramInputStream, "decode with inBitmap error: %s, outWidth: %s, outHeight: %s, sampleSize: %s, reuseBitmapWidth: %s, reuseBitmapHeight: %s", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
      paramInputStream = localObject;
    }
  }
  
  @TargetApi(19)
  private static BitmapFactory.Options a(InputStream paramInputStream, BitmapFactory.Options paramOptions, ByteBuffer paramByteBuffer, boolean paramBoolean, Rect paramRect)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (paramByteBuffer != null) {
      localOptions.inTempStorage = paramByteBuffer.array();
    }
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeStream(paramInputStream, null, localOptions, 0);
    if ((localOptions.outWidth == -1) || (localOptions.outHeight == -1)) {
      throw new IllegalArgumentException("cannot get the bitmap size!");
    }
    localOptions.inJustDecodeBounds = false;
    localOptions.inDither = true;
    int j = localOptions.outWidth;
    int i = localOptions.outHeight;
    label201:
    boolean bool;
    if (paramRect == null)
    {
      y.i("MicroMsg.InBitmapFactory", "options.outWidth: %s, options.outHeight: %s, sampleSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localOptions.inSampleSize) });
      if (!paramBoolean) {
        break label399;
      }
      paramInputStream = c.dOU;
      paramOptions = c.dOU;
      paramOptions = (Bitmap)paramInputStream.c(c.d(Integer.valueOf(j * i)));
      paramInputStream = paramOptions;
      if (paramOptions != null)
      {
        paramInputStream = paramOptions;
        if (d.gF(19))
        {
          paramOptions.reconfigure(j, i, Bitmap.Config.ARGB_8888);
          paramInputStream = paramOptions;
        }
      }
      if ((paramInputStream != null) && (!paramInputStream.isRecycled())) {
        break label426;
      }
      bool = true;
      label215:
      if (paramInputStream == null) {
        break label432;
      }
      i = paramInputStream.getWidth();
      label225:
      if (paramInputStream == null) {
        break label438;
      }
    }
    label399:
    label426:
    label432:
    label438:
    for (j = paramInputStream.getHeight();; j = 0)
    {
      y.i("MicroMsg.InBitmapFactory", "bitmapToReuse: %s, isRecycle: %s, isRegionDecode: %s, width: %s, height: %s", new Object[] { paramInputStream, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) });
      if ((paramInputStream != null) && (paramInputStream.isMutable()) && (!paramInputStream.isRecycled())) {
        localOptions.inBitmap = paramInputStream;
      }
      localOptions.inMutable = true;
      com.tencent.mm.sdk.platformtools.c.c(localOptions);
      y.i("MicroMsg.InBitmapFactory", "mimetype: %s", new Object[] { localOptions.outMimeType });
      return localOptions;
      j = paramRect.right - paramRect.left;
      i = paramRect.bottom - paramRect.top;
      y.i("MicroMsg.InBitmapFactory", "region decode, width: %s, height: %s, rect: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramRect });
      break;
      paramInputStream = c.dOU;
      paramOptions = c.dOU;
      paramInputStream = paramInputStream.e(c.d(Integer.valueOf(i * j)));
      break label201;
      bool = false;
      break label215;
      i = 0;
      break label225;
    }
  }
  
  /* Error */
  public final Bitmap a(String paramString, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 246	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore 4
    //   6: aload 4
    //   8: astore_1
    //   9: aload 4
    //   11: aload_2
    //   12: aload_3
    //   13: invokestatic 248	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   16: astore_2
    //   17: aload 4
    //   19: invokestatic 254	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   22: aload_2
    //   23: areturn
    //   24: astore_2
    //   25: aconst_null
    //   26: astore 4
    //   28: aload 4
    //   30: astore_1
    //   31: ldc 37
    //   33: aload_2
    //   34: ldc 39
    //   36: iconst_1
    //   37: anewarray 41	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_2
    //   43: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   46: aastore
    //   47: invokestatic 142	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aload 4
    //   52: invokestatic 254	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   55: aconst_null
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: invokestatic 254	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   64: aload_2
    //   65: athrow
    //   66: astore_2
    //   67: goto -7 -> 60
    //   70: astore_2
    //   71: goto -43 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	j
    //   0	74	1	paramString	String
    //   0	74	2	paramOptions	BitmapFactory.Options
    //   0	74	3	paramDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    //   4	47	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   0	6	24	java/lang/Exception
    //   0	6	57	finally
    //   9	17	66	finally
    //   31	50	66	finally
    //   9	17	70	java/lang/Exception
  }
  
  /* Error */
  public final Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 246	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore_1
    //   5: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   8: invokevirtual 23	com/tencent/mm/memory/h:de	()Ljava/lang/Object;
    //   11: checkcast 25	java/nio/ByteBuffer
    //   14: astore 5
    //   16: aload_1
    //   17: aload_2
    //   18: aload_1
    //   19: aload_3
    //   20: aload 5
    //   22: iconst_1
    //   23: aload_2
    //   24: invokestatic 28	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/nio/ByteBuffer;ZLandroid/graphics/Rect;)Landroid/graphics/BitmapFactory$Options;
    //   27: aload 4
    //   29: invokestatic 31	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   32: astore_2
    //   33: aload 5
    //   35: ifnull +12 -> 47
    //   38: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   41: aload 5
    //   43: invokevirtual 35	com/tencent/mm/memory/h:D	(Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: invokestatic 254	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_1
    //   58: ldc 37
    //   60: ldc 39
    //   62: iconst_1
    //   63: anewarray 41	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_2
    //   69: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   72: aastore
    //   73: invokestatic 51	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: aload_1
    //   77: ifnull +11 -> 88
    //   80: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   83: aload_1
    //   84: invokevirtual 35	com/tencent/mm/memory/h:D	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_3
    //   89: invokestatic 254	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +11 -> 111
    //   103: getstatic 19	com/tencent/mm/memory/h:dPc	Lcom/tencent/mm/memory/h;
    //   106: aload_1
    //   107: invokevirtual 35	com/tencent/mm/memory/h:D	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: aload_3
    //   112: invokestatic 254	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   115: aload_2
    //   116: athrow
    //   117: astore_2
    //   118: aconst_null
    //   119: astore 4
    //   121: aload_1
    //   122: astore_3
    //   123: aload 4
    //   125: astore_1
    //   126: goto -27 -> 99
    //   129: astore_2
    //   130: aload_1
    //   131: astore_3
    //   132: aload 5
    //   134: astore_1
    //   135: goto -36 -> 99
    //   138: astore_2
    //   139: goto -40 -> 99
    //   142: astore_2
    //   143: aconst_null
    //   144: astore 4
    //   146: aload_1
    //   147: astore_3
    //   148: aload 4
    //   150: astore_1
    //   151: goto -93 -> 58
    //   154: astore_2
    //   155: aload_1
    //   156: astore_3
    //   157: aload 5
    //   159: astore_1
    //   160: goto -102 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	j
    //   0	163	1	paramString	String
    //   0	163	2	paramRect	Rect
    //   0	163	3	paramOptions	BitmapFactory.Options
    //   0	163	4	paramDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    //   14	144	5	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	5	53	java/lang/Exception
    //   0	5	94	finally
    //   5	16	117	finally
    //   16	33	129	finally
    //   58	76	138	finally
    //   5	16	142	java/lang/Exception
    //   16	33	154	java/lang/Exception
  }
  
  public final void n(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      c.dOU.m(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.j
 * JD-Core Version:    0.7.0.1
 */