package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.graphics.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class j
  extends l
{
  /* Error */
  private static Bitmap a(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   8: invokevirtual 30	com/tencent/mm/memory/h:acquire	()Ljava/lang/Object;
    //   11: checkcast 32	java/nio/ByteBuffer
    //   14: astore_2
    //   15: aload_0
    //   16: aconst_null
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: iconst_0
    //   21: aconst_null
    //   22: invokestatic 35	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/nio/ByteBuffer;ZLandroid/graphics/Rect;)Landroid/graphics/BitmapFactory$Options;
    //   25: invokestatic 39	com/tencent/mm/memory/j:b	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   28: astore_0
    //   29: aload_2
    //   30: ifnull +99 -> 129
    //   33: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   36: aload_2
    //   37: invokevirtual 43	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: ldc 14
    //   43: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: areturn
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_0
    //   51: ldc 48
    //   53: ldc 50
    //   55: iconst_1
    //   56: anewarray 52	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: invokevirtual 56	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: ifnull +54 -> 124
    //   73: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   76: aload_0
    //   77: invokevirtual 43	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -42 -> 41
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +11 -> 101
    //   93: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   96: aload_0
    //   97: invokevirtual 43	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: ldc 14
    //   103: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_2
    //   110: astore_0
    //   111: goto -22 -> 89
    //   114: astore_1
    //   115: goto -26 -> 89
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: goto -70 -> 51
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -85 -> 41
    //   129: goto -88 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramInputStream	InputStream
    //   0	132	1	paramOptions	BitmapFactory.Options
    //   14	106	2	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	15	48	java/lang/Exception
    //   5	15	86	finally
    //   15	29	108	finally
    //   51	69	114	finally
    //   15	29	118	java/lang/Exception
  }
  
  @TargetApi(19)
  private static BitmapFactory.Options a(InputStream paramInputStream, BitmapFactory.Options paramOptions, ByteBuffer paramByteBuffer, boolean paramBoolean, Rect paramRect)
  {
    AppMethodBeat.i(115383);
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (paramByteBuffer != null) {
      localOptions.inTempStorage = paramByteBuffer.array();
    }
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    if ((localOptions.outWidth == -1) || (localOptions.outHeight == -1))
    {
      paramInputStream = new IllegalArgumentException("cannot get the bitmap size!");
      AppMethodBeat.o(115383);
      throw paramInputStream;
    }
    localOptions.inJustDecodeBounds = false;
    localOptions.inDither = true;
    int j = localOptions.outWidth;
    int i = localOptions.outHeight;
    label206:
    boolean bool;
    if (paramRect == null)
    {
      ab.i("MicroMsg.InBitmapFactory", "options.outWidth: %s, options.outHeight: %s, sampleSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localOptions.inSampleSize) });
      if (!paramBoolean) {
        break label407;
      }
      paramOptions = (Bitmap)c.fdB.c(c.d(Integer.valueOf(j * i)));
      paramInputStream = paramOptions;
      if (paramOptions != null)
      {
        paramInputStream = paramOptions;
        if (com.tencent.mm.compatible.util.d.fv(19))
        {
          paramOptions.reconfigure(j, i, Bitmap.Config.ARGB_8888);
          paramInputStream = paramOptions;
        }
      }
      if ((paramInputStream != null) && (!paramInputStream.isRecycled())) {
        break label428;
      }
      bool = true;
      label220:
      if (paramInputStream == null) {
        break label434;
      }
      i = paramInputStream.getWidth();
      label230:
      if (paramInputStream == null) {
        break label440;
      }
    }
    label407:
    label428:
    label434:
    label440:
    for (j = paramInputStream.getHeight();; j = 0)
    {
      ab.i("MicroMsg.InBitmapFactory", "bitmapToReuse: %s, isRecycle: %s, isRegionDecode: %s, width: %s, height: %s", new Object[] { paramInputStream, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) });
      if ((paramInputStream != null) && (paramInputStream.isMutable()) && (!paramInputStream.isRecycled())) {
        localOptions.inBitmap = paramInputStream;
      }
      localOptions.inMutable = true;
      com.tencent.mm.sdk.platformtools.d.dsm();
      ab.i("MicroMsg.InBitmapFactory", "mimetype: %s", new Object[] { localOptions.outMimeType });
      AppMethodBeat.o(115383);
      return localOptions;
      j = paramRect.right - paramRect.left;
      i = paramRect.bottom - paramRect.top;
      ab.i("MicroMsg.InBitmapFactory", "region decode, width: %s, height: %s, rect: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramRect });
      break;
      paramInputStream = c.fdB.e(c.d(Integer.valueOf(i * j)));
      break label206;
      bool = false;
      break label220;
      i = 0;
      break label230;
    }
  }
  
  private static Bitmap b(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(115384);
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localInputStream = p(paramInputStream);
        localObject1 = localObject3;
        q(localInputStream);
        localObject1 = localObject3;
        localInputStream.mark(1048576);
        if (paramRect != null) {}
      }
      catch (Exception paramInputStream)
      {
        InputStream localInputStream;
        String str;
        int k;
        int m;
        int n;
        ab.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", new Object[] { paramInputStream.getMessage() });
        paramOptions = (BitmapFactory.Options)localObject1;
        continue;
        i = 0;
        continue;
        j = 0;
        continue;
        localObject1 = paramInputStream;
        paramInputStream = a.a(localInputStream, paramRect, paramOptions);
        continue;
        continue;
      }
      try
      {
        paramInputStream = MMBitmapFactory.decodeStream(localInputStream, null, paramOptions);
        if (paramInputStream != null) {
          continue;
        }
        localObject1 = paramInputStream;
        ab.i("MicroMsg.InBitmapFactory", "decode again");
        localObject1 = paramInputStream;
        q(localInputStream);
        localObject1 = paramInputStream;
        paramOptions.inBitmap = null;
        if (paramRect == null)
        {
          localObject1 = paramInputStream;
          paramInputStream = MMBitmapFactory.decodeStream(localInputStream, null, paramOptions);
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
      catch (Exception paramInputStream)
      {
        localObject1 = localObject3;
        str = paramInputStream.getMessage();
        localObject1 = localObject3;
        k = paramOptions.outWidth;
        localObject1 = localObject3;
        m = paramOptions.outHeight;
        localObject1 = localObject3;
        n = paramOptions.inSampleSize;
        localObject1 = localObject3;
        if (paramOptions.inBitmap == null) {}
      }
      try
      {
        if (paramInputStream.getWidth() > paramRect.right - paramRect.left)
        {
          paramOptions = paramInputStream;
          if (paramInputStream.getHeight() > paramRect.bottom - paramRect.top)
          {
            ab.i("MicroMsg.InBitmapFactory", "fuck region decode size not match, clip it, reqWidth: %s, reqHeight: %s, resultWidth: %s, resultHeight: %s", new Object[] { Integer.valueOf(paramRect.right - paramRect.left), Integer.valueOf(paramRect.bottom - paramRect.top), Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInputStream.getHeight()) });
            paramOptions = Bitmap.createBitmap(paramInputStream, 0, 0, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
          }
        }
        if (paramOptions != null) {
          ab.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", new Object[] { paramOptions, Integer.valueOf(paramOptions.getWidth()), Integer.valueOf(paramOptions.getHeight()) });
        }
        AppMethodBeat.o(115384);
        return paramOptions;
      }
      catch (Exception paramRect)
      {
        int i;
        int j;
        localObject1 = paramInputStream;
        paramInputStream = paramRect;
        continue;
      }
      paramInputStream = a.a(localInputStream, paramRect, paramOptions);
      continue;
      localObject1 = localObject3;
      i = paramOptions.inBitmap.getWidth();
      localObject1 = localObject3;
      if (paramOptions.inBitmap == null) {
        continue;
      }
      localObject1 = localObject3;
      j = paramOptions.inBitmap.getHeight();
      localObject1 = localObject3;
      ab.printErrStackTrace("MicroMsg.InBitmapFactory", paramInputStream, "decode with inBitmap error: %s, outWidth: %s, outHeight: %s, sampleSize: %s, reuseBitmapWidth: %s, reuseBitmapHeight: %s", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
      paramInputStream = localObject2;
    }
  }
  
  /* Error */
  public final Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 249
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 255	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_3
    //   13: aload_3
    //   14: astore_1
    //   15: aload_3
    //   16: aload_2
    //   17: invokestatic 257	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_3
    //   24: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   27: ldc 249
    //   29: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_1
    //   33: areturn
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_3
    //   37: aload_3
    //   38: astore_1
    //   39: ldc 48
    //   41: aload_2
    //   42: ldc 50
    //   44: iconst_1
    //   45: anewarray 52	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: invokevirtual 56	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic 245	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aload_3
    //   59: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   62: aload 4
    //   64: astore_1
    //   65: goto -38 -> 27
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   75: ldc 249
    //   77: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_2
    //   81: athrow
    //   82: astore_2
    //   83: goto -12 -> 71
    //   86: astore_2
    //   87: goto -50 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	j
    //   0	90	1	paramString	String
    //   0	90	2	paramOptions	BitmapFactory.Options
    //   12	47	3	localInputStream	InputStream
    //   1	62	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	13	34	java/lang/Exception
    //   8	13	68	finally
    //   15	21	82	finally
    //   39	58	82	finally
    //   15	21	86	java/lang/Exception
  }
  
  /* Error */
  public final Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc_w 264
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 255	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   14: invokevirtual 30	com/tencent/mm/memory/h:acquire	()Ljava/lang/Object;
    //   17: checkcast 32	java/nio/ByteBuffer
    //   20: astore 4
    //   22: aload_1
    //   23: aload_2
    //   24: aload_1
    //   25: aload_3
    //   26: aload 4
    //   28: iconst_1
    //   29: aload_2
    //   30: invokestatic 35	com/tencent/mm/memory/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/nio/ByteBuffer;ZLandroid/graphics/Rect;)Landroid/graphics/BitmapFactory$Options;
    //   33: invokestatic 39	com/tencent/mm/memory/j:b	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   36: astore_2
    //   37: aload 4
    //   39: ifnull +12 -> 51
    //   42: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   45: aload 4
    //   47: invokevirtual 43	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload_1
    //   52: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: astore_1
    //   57: ldc_w 264
    //   60: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: areturn
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_1
    //   70: ldc 48
    //   72: ldc 50
    //   74: iconst_1
    //   75: anewarray 52	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: invokevirtual 56	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: aastore
    //   85: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_1
    //   89: ifnull +11 -> 100
    //   92: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   95: aload_1
    //   96: invokevirtual 43	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   99: pop
    //   100: aload_3
    //   101: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   104: aconst_null
    //   105: astore_1
    //   106: goto -49 -> 57
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +11 -> 126
    //   118: getstatic 26	com/tencent/mm/memory/h:fdJ	Lcom/tencent/mm/memory/h;
    //   121: aload_1
    //   122: invokevirtual 43	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: aload_3
    //   127: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   130: ldc_w 264
    //   133: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aconst_null
    //   140: astore 4
    //   142: aload_1
    //   143: astore_3
    //   144: aload 4
    //   146: astore_1
    //   147: goto -33 -> 114
    //   150: astore_2
    //   151: aload_1
    //   152: astore_3
    //   153: aload 4
    //   155: astore_1
    //   156: goto -42 -> 114
    //   159: astore_2
    //   160: goto -46 -> 114
    //   163: astore_2
    //   164: aconst_null
    //   165: astore 4
    //   167: aload_1
    //   168: astore_3
    //   169: aload 4
    //   171: astore_1
    //   172: goto -102 -> 70
    //   175: astore_2
    //   176: aload_1
    //   177: astore_3
    //   178: aload 4
    //   180: astore_1
    //   181: goto -111 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	j
    //   0	184	1	paramString	String
    //   0	184	2	paramRect	Rect
    //   0	184	3	paramOptions	BitmapFactory.Options
    //   20	159	4	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   6	11	65	java/lang/Exception
    //   6	11	109	finally
    //   11	22	138	finally
    //   22	37	150	finally
    //   70	88	159	finally
    //   11	22	163	java/lang/Exception
    //   22	37	175	java/lang/Exception
  }
  
  public final void u(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115385);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      c.fdB.t(paramBitmap);
    }
    AppMethodBeat.o(115385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.j
 * JD-Core Version:    0.7.0.1
 */