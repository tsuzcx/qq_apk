package com.tencent.mm.compatible.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends BitmapFactory
{
  private static a gLb = null;
  
  /* Error */
  private static Bitmap a(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 20
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 32	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   12: new 34	android/util/TypedValue
    //   15: dup
    //   16: invokespecial 37	android/util/TypedValue:<init>	()V
    //   19: astore 5
    //   21: aload_0
    //   22: iload_1
    //   23: aload 5
    //   25: invokevirtual 43	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   28: astore_3
    //   29: aload_0
    //   30: aload 5
    //   32: aload_3
    //   33: aconst_null
    //   34: aload_2
    //   35: invokestatic 47	com/tencent/mm/compatible/f/a:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnonnull +136 -> 176
    //   43: aload_3
    //   44: invokestatic 51	com/tencent/mm/compatible/f/a:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   47: astore 4
    //   49: aload 4
    //   51: astore_0
    //   52: aload_0
    //   53: astore 4
    //   55: aload_3
    //   56: ifnull +10 -> 66
    //   59: aload_3
    //   60: invokevirtual 56	java/io/InputStream:close	()V
    //   63: aload_0
    //   64: astore 4
    //   66: aload 4
    //   68: ifnonnull +71 -> 139
    //   71: aload_2
    //   72: ifnull +67 -> 139
    //   75: new 58	java/lang/IllegalArgumentException
    //   78: dup
    //   79: ldc 60
    //   81: invokespecial 63	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   84: astore_0
    //   85: ldc 20
    //   87: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: astore 4
    //   100: aload_3
    //   101: ifnull -35 -> 66
    //   104: aload_3
    //   105: invokevirtual 56	java/io/InputStream:close	()V
    //   108: aload_0
    //   109: astore 4
    //   111: goto -45 -> 66
    //   114: astore_3
    //   115: aload_0
    //   116: astore 4
    //   118: goto -52 -> 66
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 56	java/io/InputStream:close	()V
    //   132: ldc 20
    //   134: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_0
    //   138: athrow
    //   139: ldc 20
    //   141: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload 4
    //   146: areturn
    //   147: astore_0
    //   148: aload 4
    //   150: astore_0
    //   151: goto -112 -> 39
    //   154: astore_3
    //   155: aload_0
    //   156: astore 4
    //   158: goto -92 -> 66
    //   161: astore_2
    //   162: goto -30 -> 132
    //   165: astore_0
    //   166: aload_3
    //   167: astore_2
    //   168: goto -44 -> 124
    //   171: astore 4
    //   173: goto -76 -> 97
    //   176: goto -124 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramResources	Resources
    //   0	179	1	paramInt	int
    //   0	179	2	paramOptions	BitmapFactory.Options
    //   28	77	3	localInputStream	java.io.InputStream
    //   114	1	3	localIOException1	java.io.IOException
    //   154	13	3	localIOException2	java.io.IOException
    //   1	156	4	localObject	Object
    //   171	1	4	localException	java.lang.Exception
    //   19	12	5	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   12	29	92	java/lang/Exception
    //   104	108	114	java/io/IOException
    //   12	29	121	finally
    //   29	39	147	java/lang/Exception
    //   59	63	154	java/io/IOException
    //   128	132	161	java/io/IOException
    //   29	39	165	finally
    //   43	49	165	finally
    //   43	49	171	java/lang/Exception
  }
  
  public static void a(a parama)
  {
    gLb = parama;
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
    if (gLb != null)
    {
      Bitmap localBitmap = gLb.decodeResource(paramResources, paramInt, paramOptions);
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
 * Qualified Name:     com.tencent.mm.compatible.f.a
 * JD-Core Version:    0.7.0.1
 */