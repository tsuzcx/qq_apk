package com.tencent.mm.plugin.hp.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hp.a.c;
import com.tencent.mm.plugin.hp.net.e;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static int index = 0;
  
  public static void a(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(261865);
    if (paramb == null)
    {
      AppMethodBeat.o(261865);
      return;
    }
    if (paramb.vyQ.intValue() == 4) {
      paramb.JEL = y.bub(com.tencent.mm.plugin.hp.b.d.iH(MMApplicationContext.getContext()));
    }
    AppMethodBeat.o(261865);
  }
  
  /* Error */
  public static void aFf()
  {
    // Byte code:
    //   0: ldc 63
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 65	java/io/File
    //   8: dup
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: invokestatic 74	com/tencent/mm/plugin/hp/b/d:fQv	()Ljava/lang/String;
    //   19: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 80
    //   24: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 90	java/io/File:length	()J
    //   38: lconst_0
    //   39: lcmp
    //   40: ifgt +16 -> 56
    //   43: ldc 92
    //   45: ldc 94
    //   47: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc 63
    //   52: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: iconst_2
    //   57: newarray byte
    //   59: astore_3
    //   60: aload_3
    //   61: dup
    //   62: iconst_0
    //   63: ldc 100
    //   65: bastore
    //   66: dup
    //   67: iconst_1
    //   68: ldc 100
    //   70: bastore
    //   71: pop
    //   72: aload_3
    //   73: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   76: pop
    //   77: new 108	java/io/RandomAccessFile
    //   80: dup
    //   81: aload_2
    //   82: ldc 110
    //   84: invokespecial 113	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   87: astore_1
    //   88: aload_1
    //   89: astore_0
    //   90: aload_1
    //   91: aload_2
    //   92: invokevirtual 90	java/io/File:length	()J
    //   95: ldc2_w 114
    //   98: lsub
    //   99: invokevirtual 119	java/io/RandomAccessFile:seek	(J)V
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: aload_3
    //   106: invokevirtual 123	java/io/RandomAccessFile:read	([B)I
    //   109: pop
    //   110: aload_1
    //   111: astore_0
    //   112: ldc 92
    //   114: ldc 125
    //   116: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   123: ldc 63
    //   125: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: astore_0
    //   130: ldc 92
    //   132: ldc 130
    //   134: aload_0
    //   135: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   138: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc 63
    //   146: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: return
    //   150: astore_2
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_1
    //   154: astore_0
    //   155: ldc 92
    //   157: ldc 130
    //   159: aload_2
    //   160: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   177: ldc 63
    //   179: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_0
    //   184: ldc 92
    //   186: ldc 130
    //   188: aload_0
    //   189: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   192: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: ldc 63
    //   200: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_0
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 128	java/io/RandomAccessFile:close	()V
    //   215: ldc 63
    //   217: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_1
    //   221: athrow
    //   222: astore_0
    //   223: ldc 92
    //   225: ldc 130
    //   227: aload_0
    //   228: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -22 -> 215
    //   240: astore_1
    //   241: goto -34 -> 207
    //   244: astore_2
    //   245: goto -92 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   89	23	0	localRandomAccessFile1	java.io.RandomAccessFile
    //   129	6	0	localException1	Exception
    //   154	1	0	localRandomAccessFile2	java.io.RandomAccessFile
    //   183	6	0	localException2	Exception
    //   206	6	0	localObject1	Object
    //   222	6	0	localException3	Exception
    //   87	87	1	localRandomAccessFile3	java.io.RandomAccessFile
    //   204	17	1	localObject2	Object
    //   240	1	1	localObject3	Object
    //   33	59	2	localFile	File
    //   150	10	2	localException4	Exception
    //   244	1	2	localException5	Exception
    //   59	47	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   119	123	129	java/lang/Exception
    //   56	88	150	java/lang/Exception
    //   173	177	183	java/lang/Exception
    //   56	88	204	finally
    //   211	215	222	java/lang/Exception
    //   90	102	240	finally
    //   104	110	240	finally
    //   112	119	240	finally
    //   155	169	240	finally
    //   90	102	244	java/lang/Exception
    //   104	110	244	java/lang/Exception
    //   112	119	244	java/lang/Exception
  }
  
  public static void fPJ()
  {
    AppMethodBeat.i(261857);
    String str = com.tencent.mm.plugin.hp.b.d.aIO("111");
    new File(str);
    c.jD(str, com.tencent.mm.plugin.hp.b.d.fQv() + "test_tmp.apk");
    AppMethodBeat.o(261857);
  }
  
  public static void fPK()
  {
    AppMethodBeat.i(261862);
    Log.d("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "command checkout update.");
    new LinkedList();
    Object localObject = e.fPU();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((LinkedList)localObject).iterator();
    while (localIterator.hasNext())
    {
      dzo localdzo = (dzo)localIterator.next();
      localStringBuilder.append(localdzo.key).append(":").append(localdzo.value).append("\n");
    }
    Log.d("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "BaseID:%s PatchID:%s %s", new Object[] { "tinker_id_624b42f86244d6a829453585af994daa6a8d8798_arm64-v8a", "", localStringBuilder.toString() });
    localObject = new com.tencent.mm.plugin.hp.net.d("tinker_id_624b42f86244d6a829453585af994daa6a8d8798_arm64-v8a", "", (List)localObject);
    h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(261862);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int j = -1;
    AppMethodBeat.i(261869);
    if (paramArrayOfString.length < 2)
    {
      Log.d("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "no args input.");
      AppMethodBeat.o(261869);
      return false;
    }
    paramContext = paramArrayOfString[1];
    if (CrashReportFactory.hasDebuger()) {}
    label60:
    int i;
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label63:
        Log.d("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "%s i not a debugger command.", new Object[] { paramContext });
        switch (paramContext.hashCode())
        {
        default: 
          i = j;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.d("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "%s is not a release command.", new Object[] { paramContext });
        AppMethodBeat.o(261869);
        return false;
        if (!paramContext.equals("hdiff")) {
          break label60;
        }
        i = 0;
        break label63;
        h.baH().postToWorker(new b.1());
        AppMethodBeat.o(261869);
        return true;
        i = j;
        if (paramContext.equals("check")) {
          i = 0;
        }
        break;
      }
    }
    try
    {
      com.tinkerboots.sdk.a.kkr().Pi(true);
      AppMethodBeat.o(261869);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.b
 * JD-Core Version:    0.7.0.1
 */