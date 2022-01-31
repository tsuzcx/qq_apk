package com.tencent.mm.compatible.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public final class a
  extends BitmapFactory
{
  private static a dzo = null;
  
  /* Error */
  private static Bitmap a(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: invokestatic 25	com/tencent/mm/sdk/platformtools/c:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   7: new 27	android/util/TypedValue
    //   10: dup
    //   11: invokespecial 30	android/util/TypedValue:<init>	()V
    //   14: astore 5
    //   16: aload_0
    //   17: iload_1
    //   18: aload 5
    //   20: invokevirtual 36	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   23: astore_3
    //   24: aload_0
    //   25: aload 5
    //   27: aload_3
    //   28: aconst_null
    //   29: aload_2
    //   30: invokestatic 40	com/tencent/mm/compatible/g/a:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnonnull +126 -> 161
    //   38: aload_3
    //   39: invokestatic 44	com/tencent/mm/compatible/g/a:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   42: astore 4
    //   44: aload 4
    //   46: astore_0
    //   47: aload_0
    //   48: astore 4
    //   50: aload_3
    //   51: ifnull +10 -> 61
    //   54: aload_3
    //   55: invokevirtual 49	java/io/InputStream:close	()V
    //   58: aload_0
    //   59: astore 4
    //   61: aload 4
    //   63: ifnonnull +59 -> 122
    //   66: aload_2
    //   67: ifnull +55 -> 122
    //   70: new 51	java/lang/IllegalArgumentException
    //   73: dup
    //   74: ldc 53
    //   76: invokespecial 56	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   79: athrow
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: astore 4
    //   88: aload_3
    //   89: ifnull -28 -> 61
    //   92: aload_3
    //   93: invokevirtual 49	java/io/InputStream:close	()V
    //   96: aload_0
    //   97: astore 4
    //   99: goto -38 -> 61
    //   102: astore_3
    //   103: aload_0
    //   104: astore 4
    //   106: goto -45 -> 61
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 49	java/io/InputStream:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: getstatic 62	com/tencent/mm/sdk/platformtools/an:ufL	Lcom/tencent/mm/sdk/platformtools/an;
    //   125: astore_0
    //   126: invokestatic 65	com/tencent/mm/sdk/platformtools/an:crm	()V
    //   129: aload 4
    //   131: areturn
    //   132: astore_0
    //   133: aload 4
    //   135: astore_0
    //   136: goto -102 -> 34
    //   139: astore_3
    //   140: aload_0
    //   141: astore 4
    //   143: goto -82 -> 61
    //   146: astore_2
    //   147: goto -27 -> 120
    //   150: astore_0
    //   151: aload_3
    //   152: astore_2
    //   153: goto -41 -> 112
    //   156: astore 4
    //   158: goto -73 -> 85
    //   161: goto -114 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramResources	Resources
    //   0	164	1	paramInt	int
    //   0	164	2	paramOptions	BitmapFactory.Options
    //   23	70	3	localInputStream	java.io.InputStream
    //   102	1	3	localIOException1	java.io.IOException
    //   139	13	3	localIOException2	java.io.IOException
    //   1	141	4	localObject	Object
    //   156	1	4	localException	java.lang.Exception
    //   14	12	5	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   7	24	80	java/lang/Exception
    //   92	96	102	java/io/IOException
    //   7	24	109	finally
    //   24	34	132	java/lang/Exception
    //   54	58	139	java/io/IOException
    //   116	120	146	java/io/IOException
    //   24	34	150	finally
    //   38	44	150	finally
    //   38	44	156	java/lang/Exception
  }
  
  public static void a(a parama)
  {
    dzo = parama;
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt)
  {
    return decodeResource(paramResources, paramInt, null);
  }
  
  public static Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (dzo != null)
    {
      Bitmap localBitmap = dzo.decodeResource(paramResources, paramInt, paramOptions);
      if (localBitmap != null) {
        return localBitmap;
      }
    }
    return a(paramResources, paramInt, paramOptions);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.g.a
 * JD-Core Version:    0.7.0.1
 */