package com.tencent.luggage.e.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;

public final class a
{
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(138796);
    if (paramOptions == null)
    {
      AppMethodBeat.o(138796);
      return false;
    }
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null)
    {
      AppMethodBeat.o(138796);
      return false;
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0)
    {
      AppMethodBeat.o(138796);
      return true;
    }
    if (paramOptions.indexOf("jpeg") >= 0)
    {
      AppMethodBeat.o(138796);
      return true;
    }
    AppMethodBeat.o(138796);
    return false;
  }
  
  public static String b(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(138797);
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null)
    {
      AppMethodBeat.o(138797);
      return "unknown";
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0)
    {
      AppMethodBeat.o(138797);
      return "jpeg";
    }
    if (paramOptions.indexOf("jpeg") >= 0)
    {
      AppMethodBeat.o(138797);
      return "jpeg";
    }
    if (paramOptions.indexOf("png") >= 0)
    {
      AppMethodBeat.o(138797);
      return "png";
    }
    if (paramOptions.indexOf("gif") >= 0)
    {
      AppMethodBeat.o(138797);
      return "gif";
    }
    AppMethodBeat.o(138797);
    return "unknown";
  }
  
  /* Error */
  public static int getExifOrientation(String paramString)
  {
    // Byte code:
    //   0: ldc 50
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 56	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   9: ifne +17 -> 26
    //   12: ldc 58
    //   14: ldc 60
    //   16: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 50
    //   21: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 70	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore_3
    //   31: aload_3
    //   32: invokestatic 76	com/tencent/mm/plugin/appbrand/m/c:v	(Ljava/io/InputStream;)I
    //   35: istore_1
    //   36: aload_3
    //   37: ifnull +7 -> 44
    //   40: aload_3
    //   41: invokevirtual 82	java/io/InputStream:close	()V
    //   44: ldc 50
    //   46: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iload_1
    //   50: ireturn
    //   51: astore_2
    //   52: aload_3
    //   53: ifnull +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 82	java/io/InputStream:close	()V
    //   60: ldc 50
    //   62: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: athrow
    //   67: astore_2
    //   68: ldc 58
    //   70: ldc 84
    //   72: iconst_2
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_0
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_2
    //   83: aastore
    //   84: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: ldc 50
    //   89: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_3
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual 93	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   100: goto -40 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramString	String
    //   35	15	1	i	int
    //   51	15	2	localObject	Object
    //   67	29	2	localException	Exception
    //   30	27	3	localInputStream	InputStream
    //   94	3	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   31	36	51	finally
    //   26	31	67	java/lang/Exception
    //   40	44	67	java/lang/Exception
    //   60	67	67	java/lang/Exception
    //   95	100	67	java/lang/Exception
    //   56	60	94	finally
  }
  
  public static String mp(int paramInt)
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
  
  public static int v(InputStream paramInputStream)
  {
    AppMethodBeat.i(138794);
    try
    {
      int i = c.v(paramInputStream);
      AppMethodBeat.o(138794);
      return i;
    }
    catch (Exception paramInputStream)
    {
      Log.e("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", new Object[] { paramInputStream });
      AppMethodBeat.o(138794);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.e.a.a
 * JD-Core Version:    0.7.0.1
 */