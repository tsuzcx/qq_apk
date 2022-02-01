package com.tencent.mm.compatible.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends BitmapFactory
{
  private static a fJL = null;
  
  /* Error */
  private static Bitmap a(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 20
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 31	com/tencent/mm/sdk/platformtools/f:eUu	()V
    //   11: new 33	android/util/TypedValue
    //   14: dup
    //   15: invokespecial 36	android/util/TypedValue:<init>	()V
    //   18: astore 5
    //   20: aload_0
    //   21: iload_1
    //   22: aload 5
    //   24: invokevirtual 42	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   27: astore_3
    //   28: aload_0
    //   29: aload 5
    //   31: aload_3
    //   32: aconst_null
    //   33: aload_2
    //   34: invokestatic 46	com/tencent/mm/compatible/e/a:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnonnull +136 -> 175
    //   42: aload_3
    //   43: invokestatic 50	com/tencent/mm/compatible/e/a:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   46: astore 4
    //   48: aload 4
    //   50: astore_0
    //   51: aload_0
    //   52: astore 4
    //   54: aload_3
    //   55: ifnull +10 -> 65
    //   58: aload_3
    //   59: invokevirtual 55	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: astore 4
    //   65: aload 4
    //   67: ifnonnull +71 -> 138
    //   70: aload_2
    //   71: ifnull +67 -> 138
    //   74: new 57	java/lang/IllegalArgumentException
    //   77: dup
    //   78: ldc 59
    //   80: invokespecial 62	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   83: astore_0
    //   84: ldc 20
    //   86: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore 4
    //   99: aload_3
    //   100: ifnull -35 -> 65
    //   103: aload_3
    //   104: invokevirtual 55	java/io/InputStream:close	()V
    //   107: aload_0
    //   108: astore 4
    //   110: goto -45 -> 65
    //   113: astore_3
    //   114: aload_0
    //   115: astore 4
    //   117: goto -52 -> 65
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 55	java/io/InputStream:close	()V
    //   131: ldc 20
    //   133: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_0
    //   137: athrow
    //   138: ldc 20
    //   140: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload 4
    //   145: areturn
    //   146: astore_0
    //   147: aload 4
    //   149: astore_0
    //   150: goto -112 -> 38
    //   153: astore_3
    //   154: aload_0
    //   155: astore 4
    //   157: goto -92 -> 65
    //   160: astore_2
    //   161: goto -30 -> 131
    //   164: astore_0
    //   165: aload_3
    //   166: astore_2
    //   167: goto -44 -> 123
    //   170: astore 4
    //   172: goto -76 -> 96
    //   175: goto -124 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramResources	Resources
    //   0	178	1	paramInt	int
    //   0	178	2	paramOptions	BitmapFactory.Options
    //   27	77	3	localInputStream	java.io.InputStream
    //   113	1	3	localIOException1	java.io.IOException
    //   153	13	3	localIOException2	java.io.IOException
    //   1	155	4	localObject	Object
    //   170	1	4	localException	java.lang.Exception
    //   18	12	5	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   11	28	91	java/lang/Exception
    //   103	107	113	java/io/IOException
    //   11	28	120	finally
    //   28	38	146	java/lang/Exception
    //   58	62	153	java/io/IOException
    //   127	131	160	java/io/IOException
    //   28	38	164	finally
    //   42	48	164	finally
    //   42	48	170	java/lang/Exception
  }
  
  public static void a(a parama)
  {
    fJL = parama;
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(155854);
    paramResources = decodeResource(paramResources, paramInt, null);
    AppMethodBeat.o(155854);
    return paramResources;
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(155855);
    if (fJL != null)
    {
      Bitmap localBitmap = fJL.decodeResource(paramResources, paramInt, paramOptions);
      if (localBitmap != null)
      {
        AppMethodBeat.o(155855);
        return localBitmap;
      }
    }
    paramResources = a(paramResources, paramInt, paramOptions);
    AppMethodBeat.o(155855);
    return paramResources;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.a
 * JD-Core Version:    0.7.0.1
 */