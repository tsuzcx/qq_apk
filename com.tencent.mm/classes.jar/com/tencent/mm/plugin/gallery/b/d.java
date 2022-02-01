package com.tencent.mm.plugin.gallery.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import androidx.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class d
{
  /* Error */
  private static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 19
    //   8: invokestatic 25	com/tencent/mm/vfs/y:qk	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: invokevirtual 31	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +10 -> 26
    //   19: ldc 11
    //   21: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_1
    //   27: iconst_1
    //   28: putfield 40	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   31: aload_0
    //   32: aconst_null
    //   33: aload_1
    //   34: invokestatic 46	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   37: pop
    //   38: aload_1
    //   39: getfield 50	android/graphics/BitmapFactory$Options:outWidth	I
    //   42: istore_3
    //   43: aload_1
    //   44: getfield 53	android/graphics/BitmapFactory$Options:outHeight	I
    //   47: istore 4
    //   49: iload_3
    //   50: iconst_m1
    //   51: if_icmpeq +9 -> 60
    //   54: iload 4
    //   56: iconst_m1
    //   57: if_icmpne +17 -> 74
    //   60: ldc 55
    //   62: ldc 57
    //   64: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc 11
    //   69: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aconst_null
    //   73: areturn
    //   74: iload_3
    //   75: iload 4
    //   77: invokestatic 68	java/lang/Math:min	(II)I
    //   80: iload_2
    //   81: idiv
    //   82: istore_2
    //   83: iload_2
    //   84: ifgt +192 -> 276
    //   87: iconst_1
    //   88: istore_2
    //   89: iload_3
    //   90: iload_2
    //   91: idiv
    //   92: iload 4
    //   94: iload_2
    //   95: idiv
    //   96: imul
    //   97: ldc 69
    //   99: if_icmplt +95 -> 194
    //   102: iload_2
    //   103: iconst_2
    //   104: imul
    //   105: istore_2
    //   106: goto -17 -> 89
    //   109: new 71	java/lang/IllegalArgumentException
    //   112: dup
    //   113: ldc 73
    //   115: iload_2
    //   116: invokestatic 79	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   119: invokevirtual 83	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokespecial 87	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   125: astore_0
    //   126: ldc 11
    //   128: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_0
    //   132: athrow
    //   133: astore_0
    //   134: ldc 55
    //   136: aload_0
    //   137: ldc 89
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 11
    //   148: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aconst_null
    //   152: areturn
    //   153: iload_2
    //   154: iconst_1
    //   155: isub
    //   156: istore_2
    //   157: iload_2
    //   158: iload_2
    //   159: bipush 16
    //   161: ishr
    //   162: ior
    //   163: istore_2
    //   164: iload_2
    //   165: iload_2
    //   166: bipush 8
    //   168: ishr
    //   169: ior
    //   170: istore_2
    //   171: iload_2
    //   172: iload_2
    //   173: iconst_4
    //   174: ishr
    //   175: ior
    //   176: istore_2
    //   177: iload_2
    //   178: iload_2
    //   179: iconst_2
    //   180: ishr
    //   181: ior
    //   182: istore_2
    //   183: iload_2
    //   184: iload_2
    //   185: iconst_1
    //   186: ishr
    //   187: ior
    //   188: iconst_1
    //   189: iadd
    //   190: istore_2
    //   191: goto -102 -> 89
    //   194: aload_1
    //   195: iload_2
    //   196: putfield 96	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   199: aload_1
    //   200: iconst_0
    //   201: putfield 40	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   204: aload_1
    //   205: iconst_1
    //   206: putfield 99	android/graphics/BitmapFactory$Options:inMutable	Z
    //   209: aload_0
    //   210: aconst_null
    //   211: aload_1
    //   212: invokestatic 46	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   215: astore_1
    //   216: aload_1
    //   217: astore_0
    //   218: aload_1
    //   219: invokevirtual 105	android/graphics/Bitmap:getWidth	()I
    //   222: aload_1
    //   223: invokevirtual 108	android/graphics/Bitmap:getHeight	()I
    //   226: imul
    //   227: ldc 69
    //   229: if_icmplt +16 -> 245
    //   232: aload_1
    //   233: iload_3
    //   234: iload_2
    //   235: idiv
    //   236: iload 4
    //   238: iload_2
    //   239: idiv
    //   240: iconst_0
    //   241: invokestatic 112	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   244: astore_0
    //   245: ldc 11
    //   247: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_0
    //   251: areturn
    //   252: astore_0
    //   253: ldc 55
    //   255: aload_0
    //   256: ldc 114
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: ldc 11
    //   267: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_0
    //   273: goto -139 -> 134
    //   276: iload_2
    //   277: ifle -168 -> 109
    //   280: iload_2
    //   281: ldc 115
    //   283: if_icmple -130 -> 153
    //   286: goto -177 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramString	String
    //   0	289	1	paramOptions	BitmapFactory.Options
    //   0	289	2	paramInt	int
    //   42	194	3	i	int
    //   47	193	4	j	int
    // Exception table:
    //   from	to	target	type
    //   5	15	133	java/lang/Exception
    //   19	24	133	java/lang/Exception
    //   26	49	133	java/lang/Exception
    //   60	72	133	java/lang/Exception
    //   74	83	133	java/lang/Exception
    //   89	102	133	java/lang/Exception
    //   109	133	133	java/lang/Exception
    //   194	216	133	java/lang/Exception
    //   218	245	133	java/lang/Exception
    //   5	15	252	finally
    //   19	24	252	finally
    //   26	49	252	finally
    //   60	72	252	finally
    //   74	83	252	finally
    //   89	102	252	finally
    //   109	133	252	finally
    //   194	216	252	finally
    //   218	245	252	finally
    //   5	15	272	java/lang/OutOfMemoryError
    //   19	24	272	java/lang/OutOfMemoryError
    //   26	49	272	java/lang/OutOfMemoryError
    //   60	72	272	java/lang/OutOfMemoryError
    //   74	83	272	java/lang/OutOfMemoryError
    //   89	102	272	java/lang/OutOfMemoryError
    //   109	133	272	java/lang/OutOfMemoryError
    //   194	216	272	java/lang/OutOfMemoryError
    //   218	245	272	java/lang/OutOfMemoryError
  }
  
  public static Bitmap fl(String paramString, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(111737);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GalleryBitmapUtil", "imgPath is invalid.");
      AppMethodBeat.o(111737);
      return null;
    }
    localOptions = new BitmapFactory.Options();
    for (;;)
    {
      try
      {
        arrayOfByte = new a(paramString).FN();
        if (arrayOfByte == null) {
          continue;
        }
        if (arrayOfByte == null)
        {
          localObject1 = localObject2;
          if (localObject1 == null) {
            continue;
          }
          Log.i("MicroMsg.GalleryBitmapUtil", "decode thumb success from exif.");
          AppMethodBeat.o(111737);
          return localObject1;
        }
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        localObject1 = localObject2;
        if (localOptions.outWidth < paramInt) {
          continue;
        }
        localObject1 = localObject2;
        if (localOptions.outHeight < paramInt) {
          continue;
        }
        i = localOptions.outWidth;
        int j = localOptions.outHeight;
        i = Math.max(i / paramInt, j / paramInt);
        if (i > 1) {
          continue;
        }
        i = 1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        byte[] arrayOfByte;
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", localFileNotFoundException, "failed to find file to read thumbnail: %s.", new Object[] { paramString });
        paramString = a(paramString, localOptions, paramInt);
        AppMethodBeat.o(111737);
        return paramString;
        int i = Integer.highestOneBit(i);
        continue;
        i /= 8;
        i *= 8;
        continue;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", localIndexOutOfBoundsException, "failed to get thumbnail from: %s.", new Object[] { paramString });
        continue;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", localException, "failed to get thumbnail from: %s.", new Object[] { paramString });
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        continue;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      localOptions.inMutable = true;
      localObject1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    if (i <= 8) {
      if (i <= 0)
      {
        localObject1 = new IllegalArgumentException();
        AppMethodBeat.o(111737);
        throw ((Throwable)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.d
 * JD-Core Version:    0.7.0.1
 */