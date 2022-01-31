package com.tencent.luggage.e.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;

public final class a
{
  public static boolean b(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(65348);
    if (paramOptions == null)
    {
      AppMethodBeat.o(65348);
      return false;
    }
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null)
    {
      AppMethodBeat.o(65348);
      return false;
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0)
    {
      AppMethodBeat.o(65348);
      return true;
    }
    if (paramOptions.indexOf("jpeg") >= 0)
    {
      AppMethodBeat.o(65348);
      return true;
    }
    AppMethodBeat.o(65348);
    return false;
  }
  
  /* Error */
  public static int bY(String paramString)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 49	com/tencent/mm/a/e:cN	(Ljava/lang/String;)Z
    //   9: ifne +17 -> 26
    //   12: ldc 51
    //   14: ldc 53
    //   16: invokestatic 59	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 43
    //   21: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: new 61	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 65	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aconst_null
    //   37: astore_2
    //   38: aload 4
    //   40: invokestatic 71	com/tencent/mm/plugin/appbrand/h/b:f	(Ljava/io/InputStream;)I
    //   43: istore_1
    //   44: aload 4
    //   46: invokevirtual 75	java/io/FileInputStream:close	()V
    //   49: ldc 43
    //   51: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iload_1
    //   55: ireturn
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: ldc 43
    //   61: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: athrow
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +53 -> 123
    //   73: aload 4
    //   75: invokevirtual 75	java/io/FileInputStream:close	()V
    //   78: ldc 43
    //   80: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_3
    //   84: athrow
    //   85: astore_2
    //   86: ldc 51
    //   88: ldc 77
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_2
    //   101: aastore
    //   102: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: ldc 43
    //   107: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore 4
    //   114: aload_2
    //   115: aload 4
    //   117: invokevirtual 84	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   120: goto -42 -> 78
    //   123: aload 4
    //   125: invokevirtual 75	java/io/FileInputStream:close	()V
    //   128: goto -50 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   43	12	1	i	int
    //   37	33	2	localObject1	Object
    //   85	30	2	localException	Exception
    //   56	11	3	localThrowable1	java.lang.Throwable
    //   68	16	3	localObject2	Object
    //   34	40	4	localFileInputStream	java.io.FileInputStream
    //   112	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   38	44	56	java/lang/Throwable
    //   38	44	68	finally
    //   59	64	68	finally
    //   66	68	68	finally
    //   26	36	85	java/lang/Exception
    //   44	49	85	java/lang/Exception
    //   73	78	85	java/lang/Exception
    //   78	85	85	java/lang/Exception
    //   114	120	85	java/lang/Exception
    //   123	128	85	java/lang/Exception
    //   73	78	112	java/lang/Throwable
  }
  
  public static String c(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(65349);
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null)
    {
      AppMethodBeat.o(65349);
      return "unknown";
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0)
    {
      AppMethodBeat.o(65349);
      return "jpeg";
    }
    if (paramOptions.indexOf("jpeg") >= 0)
    {
      AppMethodBeat.o(65349);
      return "jpeg";
    }
    if (paramOptions.indexOf("png") >= 0)
    {
      AppMethodBeat.o(65349);
      return "png";
    }
    if (paramOptions.indexOf("gif") >= 0)
    {
      AppMethodBeat.o(65349);
      return "gif";
    }
    AppMethodBeat.o(65349);
    return "unknown";
  }
  
  public static int f(InputStream paramInputStream)
  {
    AppMethodBeat.i(65346);
    try
    {
      int i = b.f(paramInputStream);
      AppMethodBeat.o(65346);
      return i;
    }
    catch (Exception paramInputStream)
    {
      ab.e("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", new Object[] { paramInputStream });
      AppMethodBeat.o(65346);
    }
    return 0;
  }
  
  public static String ft(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "up";
    case 1: 
      return "up";
    case 2: 
      return "up-mirrored";
    case 3: 
      return "down";
    case 4: 
      return "down-mirrored";
    case 5: 
      return "left-mirrored";
    case 6: 
      return "right";
    case 7: 
      return "right-mirrored";
    case 8: 
      return "left";
    }
    return "up";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.e.a.a
 * JD-Core Version:    0.7.0.1
 */