package com.tencent.luggage.e.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;

public final class a
{
  public static boolean d(BitmapFactory.Options paramOptions)
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
  
  public static String e(BitmapFactory.Options paramOptions)
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
    //   0: ldc 52
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 58	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   9: ifne +17 -> 26
    //   12: ldc 60
    //   14: ldc 62
    //   16: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 52
    //   21: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 71	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore 4
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 4
    //   36: invokestatic 77	com/tencent/mm/plugin/appbrand/l/b:m	(Ljava/io/InputStream;)I
    //   39: istore_1
    //   40: aload 4
    //   42: ifnull +8 -> 50
    //   45: aload 4
    //   47: invokevirtual 83	java/io/InputStream:close	()V
    //   50: ldc 52
    //   52: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iload_1
    //   56: ireturn
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: ldc 52
    //   62: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_3
    //   68: athrow
    //   69: astore_3
    //   70: aload 4
    //   72: ifnull +12 -> 84
    //   75: aload_2
    //   76: ifnull +53 -> 129
    //   79: aload 4
    //   81: invokevirtual 83	java/io/InputStream:close	()V
    //   84: ldc 52
    //   86: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_3
    //   90: athrow
    //   91: astore_2
    //   92: ldc 60
    //   94: ldc 85
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_0
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_2
    //   107: aastore
    //   108: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: ldc 52
    //   113: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore 4
    //   120: aload_2
    //   121: aload 4
    //   123: invokevirtual 92	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   126: goto -42 -> 84
    //   129: aload 4
    //   131: invokevirtual 83	java/io/InputStream:close	()V
    //   134: goto -50 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   39	17	1	i	int
    //   33	43	2	localObject1	Object
    //   91	30	2	localException	Exception
    //   57	11	3	localThrowable1	java.lang.Throwable
    //   69	21	3	localObject2	Object
    //   30	50	4	localInputStream	InputStream
    //   118	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   34	40	57	java/lang/Throwable
    //   34	40	69	finally
    //   60	65	69	finally
    //   67	69	69	finally
    //   26	32	91	java/lang/Exception
    //   45	50	91	java/lang/Exception
    //   79	84	91	java/lang/Exception
    //   84	91	91	java/lang/Exception
    //   120	126	91	java/lang/Exception
    //   129	134	91	java/lang/Exception
    //   79	84	118	java/lang/Throwable
  }
  
  public static String hN(int paramInt)
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
  
  public static int m(InputStream paramInputStream)
  {
    AppMethodBeat.i(138794);
    try
    {
      int i = b.m(paramInputStream);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.e.a.a
 * JD-Core Version:    0.7.0.1
 */