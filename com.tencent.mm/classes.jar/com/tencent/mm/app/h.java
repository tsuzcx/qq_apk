package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.RandomAccessFile;

public final class h
{
  private static final String hfP;
  
  static
  {
    AppMethodBeat.i(19439);
    hfP = at.acHq + "channel_history.cfg";
    AppMethodBeat.o(19439);
  }
  
  public static void aCk()
  {
    AppMethodBeat.i(19437);
    if (!aCl())
    {
      Log.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
      AppMethodBeat.o(19437);
      return;
    }
    localObject4 = null;
    Object localObject1 = null;
    try
    {
      RandomAccessFile localRandomAccessFile = y.eA(hfP, true);
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
  
  private static boolean aCl()
  {
    AppMethodBeat.i(19438);
    boolean bool = new u(hfP).jKS();
    AppMethodBeat.o(19438);
    return bool;
  }
  
  /* Error */
  public static void cr(android.content.Context paramContext)
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
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 207	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   35: getfield 210	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   38: bipush 29
    //   40: if_icmpgt +53 -> 93
    //   43: aload_1
    //   44: invokestatic 216	com/tencent/mm/d/a:hY	(Ljava/lang/String;)Lcom/tencent/mm/d/a;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +44 -> 93
    //   52: aload_1
    //   53: getfield 220	com/tencent/mm/d/a:hem	Lcom/tencent/mm/d/b;
    //   56: ifnull +37 -> 93
    //   59: ldc 49
    //   61: ldc 222
    //   63: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_1
    //   67: getfield 220	com/tencent/mm/d/a:hem	Lcom/tencent/mm/d/b;
    //   70: getfield 225	com/tencent/mm/d/b:channelId	I
    //   73: ifeq +20 -> 93
    //   76: aload_1
    //   77: getfield 220	com/tencent/mm/d/a:hem	Lcom/tencent/mm/d/b;
    //   80: getfield 225	com/tencent/mm/d/b:channelId	I
    //   83: putstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   86: ldc 49
    //   88: ldc 227
    //   90: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: ldc 49
    //   95: ldc 229
    //   97: iconst_2
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: getstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   106: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: invokestatic 232	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: invokestatic 47	com/tencent/mm/app/h:aCl	()Z
    //   122: ifne +52 -> 174
    //   125: aconst_null
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: getstatic 36	com/tencent/mm/app/h:hfP	Ljava/lang/String;
    //   132: iconst_1
    //   133: invokestatic 63	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   136: astore_3
    //   137: aload_3
    //   138: astore_1
    //   139: aload_3
    //   140: astore_2
    //   141: aload_3
    //   142: ldc 146
    //   144: iconst_1
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: getstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   153: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: invokestatic 152	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokevirtual 156	java/lang/String:getBytes	()[B
    //   163: invokevirtual 160	java/io/RandomAccessFile:write	([B)V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   174: aload_0
    //   175: invokestatic 238	com/tencent/mm/booter/d:cO	(Landroid/content/Context;)Lcom/tencent/mm/booter/d;
    //   178: astore_0
    //   179: aload_0
    //   180: ifnull +18 -> 198
    //   183: aload_0
    //   184: getfield 241	com/tencent/mm/booter/d:lrt	I
    //   187: iconst_m1
    //   188: if_icmpeq +10 -> 198
    //   191: aload_0
    //   192: getfield 241	com/tencent/mm/booter/d:lrt	I
    //   195: putstatic 83	com/tencent/mm/sdk/platformtools/ChannelUtil:channelId	I
    //   198: sipush 19436
    //   201: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: return
    //   205: astore_1
    //   206: ldc 49
    //   208: ldc 243
    //   210: invokestatic 246	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -120 -> 93
    //   216: astore_1
    //   217: ldc 49
    //   219: ldc 248
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_1
    //   228: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: aastore
    //   232: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: goto -142 -> 93
    //   238: astore_1
    //   239: ldc 49
    //   241: aload_1
    //   242: ldc 98
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: ldc 100
    //   252: aastore
    //   253: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: goto -82 -> 174
    //   259: astore_3
    //   260: aload_1
    //   261: astore_2
    //   262: ldc 49
    //   264: aload_3
    //   265: ldc 164
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: ldc 100
    //   275: aastore
    //   276: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload_1
    //   280: ifnull -106 -> 174
    //   283: aload_1
    //   284: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   287: goto -113 -> 174
    //   290: astore_1
    //   291: ldc 49
    //   293: aload_1
    //   294: ldc 98
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: ldc 100
    //   304: aastore
    //   305: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -134 -> 174
    //   311: astore_0
    //   312: aload_2
    //   313: ifnull +7 -> 320
    //   316: aload_2
    //   317: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   320: sipush 19436
    //   323: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_0
    //   327: athrow
    //   328: astore_1
    //   329: ldc 49
    //   331: aload_1
    //   332: ldc 98
    //   334: iconst_1
    //   335: anewarray 4	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: ldc 100
    //   342: aastore
    //   343: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: goto -26 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramContext	android.content.Context
    //   14	125	1	localObject1	Object
    //   205	1	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   216	12	1	localException1	Exception
    //   238	46	1	localException2	Exception
    //   290	4	1	localException3	Exception
    //   328	4	1	localException4	Exception
    //   126	191	2	localObject2	Object
    //   136	35	3	localRandomAccessFile	RandomAccessFile
    //   259	6	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   15	48	205	android/content/pm/PackageManager$NameNotFoundException
    //   52	93	205	android/content/pm/PackageManager$NameNotFoundException
    //   15	48	216	java/lang/Exception
    //   52	93	216	java/lang/Exception
    //   170	174	238	java/lang/Exception
    //   129	137	259	java/lang/Exception
    //   141	166	259	java/lang/Exception
    //   283	287	290	java/lang/Exception
    //   129	137	311	finally
    //   141	166	311	finally
    //   262	279	311	finally
    //   316	320	328	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.h
 * JD-Core Version:    0.7.0.1
 */