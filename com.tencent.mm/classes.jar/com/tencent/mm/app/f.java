package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.RandomAccessFile;

public final class f
{
  private static final String fcf;
  
  static
  {
    AppMethodBeat.i(19439);
    fcf = ar.Vgb + "channel_history.cfg";
    AppMethodBeat.o(19439);
  }
  
  public static void aaD()
  {
    AppMethodBeat.i(19437);
    if (!aaE())
    {
      Log.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
      AppMethodBeat.o(19437);
      return;
    }
    localObject4 = null;
    Object localObject1 = null;
    try
    {
      RandomAccessFile localRandomAccessFile = u.dO(fcf, true);
      localObject1 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      long l = localRandomAccessFile.length();
      localObject1 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      Log.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", new Object[] { Long.valueOf(l), Integer.valueOf(ChannelUtil.channelId) });
      if (l <= 0L)
      {
        localObject1 = localRandomAccessFile;
        localObject4 = localRandomAccessFile;
        Log.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
        if (localRandomAccessFile != null) {}
        try
        {
          localRandomAccessFile.close();
          AppMethodBeat.o(19437);
          return;
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.ChannelHistory", localException1, "Close ChannelHistory History file failed.", new Object[] { "" });
          AppMethodBeat.o(19437);
          return;
        }
      }
      Object localObject2 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      String str2 = localRandomAccessFile.readLine();
      localObject2 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      int k = ChannelUtil.channelId;
      localObject2 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      int i = ChannelUtil.channelId;
      localObject2 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      ChannelUtil.historyChannelId = ChannelUtil.channelId;
      Object localObject5 = "";
      localObject2 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      String str1;
      if (!Util.isNullOrNil(str2))
      {
        localObject2 = localRandomAccessFile;
        localObject4 = localRandomAccessFile;
        str1 = "" + str2 + ",";
        localObject2 = localRandomAccessFile;
        localObject4 = localRandomAccessFile;
        int j = Util.getInt(str2, 0);
        localObject5 = str1;
        i = j;
        localObject2 = localRandomAccessFile;
        localObject4 = localRandomAccessFile;
        if (j != ChannelUtil.channelId)
        {
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          ChannelUtil.historyChannelId = j;
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          Log.i("MicroMsg.ChannelHistory", "real correct final channelid: " + ChannelUtil.channelId);
          i = j;
          localObject5 = str1;
        }
      }
      localObject2 = localRandomAccessFile;
      localObject4 = localRandomAccessFile;
      if (MMApplicationContext.sIsRevChange)
      {
        for (;;)
        {
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          str1 = localRandomAccessFile.readLine();
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          if (Util.isNullOrNil(str1)) {
            break;
          }
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          localObject5 = (String)localObject5 + str1 + ",";
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          i = Util.getInt(str1, 0);
        }
        localObject2 = localRandomAccessFile;
        localObject4 = localRandomAccessFile;
        Log.i("MicroMsg.ChannelHistory", "channel list: %s", new Object[] { localObject5 });
        if (i != k)
        {
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          localRandomAccessFile.seek(l);
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          localRandomAccessFile.write(String.format("%d\n", new Object[] { Integer.valueOf(k) }).getBytes());
          localObject2 = localRandomAccessFile;
          localObject4 = localRandomAccessFile;
          Log.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
        }
      }
      if (localRandomAccessFile != null) {}
      try
      {
        localRandomAccessFile.close();
        AppMethodBeat.o(19437);
        return;
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.ChannelHistory", localException2, "Close ChannelHistory History file failed.", new Object[] { "" });
        AppMethodBeat.o(19437);
        return;
      }
      try
      {
        localObject4.close();
        AppMethodBeat.o(19437);
        throw localObject3;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ChannelHistory", localException4, "Close ChannelHistory History file failed.", new Object[] { "" });
        }
      }
    }
    catch (Exception localException5)
    {
      localObject4 = localException2;
      Log.printErrStackTrace("MicroMsg.ChannelHistory", localException5, "Open ChannelHistory History file failed.", new Object[] { "" });
      if (localException2 != null) {}
      try
      {
        localException2.close();
        AppMethodBeat.o(19437);
        return;
      }
      catch (Exception localException3)
      {
        Log.printErrStackTrace("MicroMsg.ChannelHistory", localException3, "Close ChannelHistory History file failed.", new Object[] { "" });
        AppMethodBeat.o(19437);
        return;
      }
    }
    finally
    {
      if (localObject4 == null) {}
    }
  }
  
  private static boolean aaE()
  {
    AppMethodBeat.i(19438);
    boolean bool = new q(fcf).ifE();
    AppMethodBeat.o(19438);
    return bool;
  }
  
  /* Error */
  public static void bE(android.content.Context paramContext)
  {
    // Byte code:
    //   0: sipush 19436
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 177	com/tencent/mm/sdk/platformtools/ChannelUtil:setupChannelId	(Landroid/content/Context;)V
    //   10: aload_0
    //   11: invokevirtual 183	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
    //   20: iconst_0
    //   21: invokevirtual 192	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   24: getfield 198	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   27: getfield 203	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   30: invokestatic 209	com/tencent/mm/d/a:gy	(Ljava/lang/String;)Lcom/tencent/mm/d/a;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +44 -> 79
    //   38: aload_1
    //   39: getfield 213	com/tencent/mm/d/a:faM	Lcom/tencent/mm/d/b;
    //   42: ifnull +37 -> 79
    //   45: ldc 49
    //   47: ldc 215
    //   49: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: getfield 213	com/tencent/mm/d/a:faM	Lcom/tencent/mm/d/b;
    //   56: getfield 218	com/tencent/mm/d/b:channelId	I
    //   59: ifeq +20 -> 79
    //   62: aload_1
    //   63: getfield 213	com/tencent/mm/d/a:faM	Lcom/tencent/mm/d/b;
    //   66: getfield 218	com/tencent/mm/d/b:channelId	I
    //   69: putstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   72: ldc 49
    //   74: ldc 220
    //   76: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: ldc 49
    //   81: ldc 222
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: getstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   92: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: invokestatic 225	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: invokestatic 47	com/tencent/mm/app/f:aaE	()Z
    //   108: ifne +52 -> 160
    //   111: aconst_null
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_1
    //   115: getstatic 36	com/tencent/mm/app/f:fcf	Ljava/lang/String;
    //   118: iconst_1
    //   119: invokestatic 63	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   122: astore_3
    //   123: aload_3
    //   124: astore_1
    //   125: aload_3
    //   126: astore_2
    //   127: aload_3
    //   128: ldc 146
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: getstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   139: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: aastore
    //   143: invokestatic 152	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokevirtual 156	java/lang/String:getBytes	()[B
    //   149: invokevirtual 160	java/io/RandomAccessFile:write	([B)V
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   160: aload_0
    //   161: invokestatic 231	com/tencent/mm/booter/d:cc	(Landroid/content/Context;)Lcom/tencent/mm/booter/d;
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +18 -> 184
    //   169: aload_0
    //   170: getfield 234	com/tencent/mm/booter/d:iPy	I
    //   173: iconst_m1
    //   174: if_icmpeq +10 -> 184
    //   177: aload_0
    //   178: getfield 234	com/tencent/mm/booter/d:iPy	I
    //   181: putstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   184: sipush 19436
    //   187: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: astore_1
    //   192: ldc 49
    //   194: ldc 236
    //   196: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: goto -120 -> 79
    //   202: astore_1
    //   203: ldc 49
    //   205: ldc 241
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_1
    //   214: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: aastore
    //   218: invokestatic 246	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: goto -142 -> 79
    //   224: astore_1
    //   225: ldc 49
    //   227: aload_1
    //   228: ldc 98
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: ldc 100
    //   238: aastore
    //   239: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: goto -82 -> 160
    //   245: astore_3
    //   246: aload_1
    //   247: astore_2
    //   248: ldc 49
    //   250: aload_3
    //   251: ldc 164
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: ldc 100
    //   261: aastore
    //   262: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_1
    //   266: ifnull -106 -> 160
    //   269: aload_1
    //   270: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   273: goto -113 -> 160
    //   276: astore_1
    //   277: ldc 49
    //   279: aload_1
    //   280: ldc 98
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: ldc 100
    //   290: aastore
    //   291: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: goto -134 -> 160
    //   297: astore_0
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   306: sipush 19436
    //   309: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload_0
    //   313: athrow
    //   314: astore_1
    //   315: ldc 49
    //   317: aload_1
    //   318: ldc 98
    //   320: iconst_1
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc 100
    //   328: aastore
    //   329: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: goto -26 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramContext	android.content.Context
    //   14	111	1	localObject1	Object
    //   191	1	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   202	12	1	localException1	Exception
    //   224	46	1	localException2	Exception
    //   276	4	1	localException3	Exception
    //   314	4	1	localException4	Exception
    //   112	191	2	localObject2	Object
    //   122	35	3	localRandomAccessFile	RandomAccessFile
    //   245	6	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   15	34	191	android/content/pm/PackageManager$NameNotFoundException
    //   38	79	191	android/content/pm/PackageManager$NameNotFoundException
    //   15	34	202	java/lang/Exception
    //   38	79	202	java/lang/Exception
    //   156	160	224	java/lang/Exception
    //   115	123	245	java/lang/Exception
    //   127	152	245	java/lang/Exception
    //   269	273	276	java/lang/Exception
    //   115	123	297	finally
    //   127	152	297	finally
    //   248	265	297	finally
    //   302	306	314	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.f
 * JD-Core Version:    0.7.0.1
 */