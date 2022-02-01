package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.f.a.ll.a;
import com.tencent.mm.model.cs.d;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.performance.a.b;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.q;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class Shell
{
  private static HashMap<String, a> jwU;
  private static IntentFilter jwV;
  private static Runnable jwW;
  private Receiver jwT = null;
  
  static
  {
    AppMethodBeat.i(20168);
    jwU = new HashMap();
    jwV = new IntentFilter();
    a("wechat.shell.SET_NEXTRET", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20140);
        int i = paramAnonymousIntent.getIntExtra("type", 2147483647);
        int j = paramAnonymousIntent.getIntExtra("error", 0);
        if ((i == 2147483647) || (j == 0))
        {
          AppMethodBeat.o(20140);
          return;
        }
        Log.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        ac.ed(i, j);
        AppMethodBeat.o(20140);
      }
    }, true);
    a("wechat.shell.SET_LOGLEVEL", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20153);
        int i = paramAnonymousIntent.getIntExtra("level", 0);
        Log.w("MicroMsg.Shell", "kiro set Log.level=%d", new Object[] { Integer.valueOf(Log.getLogLevel()) });
        Log.setLevel(i, false);
        AppMethodBeat.o(20153);
      }
    }, true);
    a("wechat.shell.SET_CDNTRANS", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20157);
        ac.mFG = paramAnonymousIntent.getBooleanExtra("value", false);
        Log.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[] { Boolean.valueOf(ac.mFG) });
        AppMethodBeat.o(20157);
      }
    }, true);
    a("wechat.shell.SET_DKTEST", new Shell.34(), true);
    a("wechat.shell.NET_DNS_TEST", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20159);
        ac.mFL = paramAnonymousIntent.getIntExtra("value", 0);
        Log.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", new Object[] { Integer.toBinaryString(ac.mFL) });
        AppMethodBeat.o(20159);
      }
    }, true);
    a("wechat.shell.IDC_ERROR", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20160);
        ac.mFP = paramAnonymousIntent.getStringExtra("errmsg");
        Log.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", new Object[] { ac.mFP });
        AppMethodBeat.o(20160);
      }
    }, true);
    a("wechat.shell.SET_DK_WT_TEST", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20161);
        ac.mFQ = paramAnonymousIntent.getStringExtra("acc");
        ac.mFR = paramAnonymousIntent.getStringExtra("pass");
        Log.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[] { ac.mFQ, ac.mFR });
        AppMethodBeat.o(20161);
      }
    }, true);
    a("wechat.shell.SET_MUTE_ROOM_TEST", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20162);
        ac.mGu = paramAnonymousIntent.getIntExtra("flag", 0);
        Log.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[] { Integer.valueOf(ac.mGu) });
        AppMethodBeat.o(20162);
      }
    }, true);
    a("wechat.shell.HOTPATCH_TEST", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20163);
        ll localll = new ll();
        localll.fJg.fJl = paramAnonymousIntent.getExtras().getString("path", "/data/local/tmp/test.apk");
        Log.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[] { localll.fJg.fJl });
        EventCenter.instance.publish(localll);
        AppMethodBeat.o(20163);
      }
    }, true);
    a("wechat.shell.EXEC_STATUSDB_SQL", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20143);
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("sql");
        if (paramAnonymousIntent != null) {
          ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).execSQL(paramAnonymousIntent);
        }
        AppMethodBeat.o(20143);
      }
    }, true);
    a("wechat.shell.EXEC_SQL", new a()
    {
      public final void u(final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20144);
        if (!MMApplicationContext.isMMProcess())
        {
          AppMethodBeat.o(20144);
          return;
        }
        final String str = paramAnonymousIntent.getStringExtra("sql");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("file");
        if ((str != null) && (str.length() > 0))
        {
          com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              Object localObject4 = null;
              com.tencent.wcdb.Cursor localCursor = null;
              AppMethodBeat.i(269290);
              SQLiteDatabase localSQLiteDatabase = com.tencent.mm.kernel.h.aHG().kcF.hBZ();
              Object localObject2 = localCursor;
              Object localObject1 = localObject4;
              for (;;)
              {
                long l;
                try
                {
                  l = System.currentTimeMillis();
                  localObject2 = localCursor;
                  localObject1 = localObject4;
                  localCursor = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null);
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  localObject4 = localCursor.getColumnNames();
                  if (localObject4 != null) {
                    continue;
                  }
                  i = 0;
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  Log.i("MicroMsg.Shell", "Executing SQL from shell: " + str);
                  if (i > 0)
                  {
                    localObject2 = localCursor;
                    localObject1 = localCursor;
                    Log.i("MicroMsg.Shell", " > " + TextUtils.join(" | ", (Object[])localObject4));
                  }
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  localObject4 = new StringBuilder(1024);
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  if (!localCursor.moveToNext()) {
                    break label463;
                  }
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  ((StringBuilder)localObject4).setLength(0);
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  ((StringBuilder)localObject4).append(" > ");
                  j = 0;
                  if (j >= i) {
                    break label442;
                  }
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  switch (localCursor.getType(j))
                  {
                  case 0: 
                    localObject2 = localCursor;
                    localObject1 = localCursor;
                    ((StringBuilder)localObject4).append(localCursor.getString(j));
                  }
                }
                catch (RuntimeException localRuntimeException2)
                {
                  int i;
                  int j;
                  localObject1 = localObject2;
                  Log.e("MicroMsg.Shell", "Failed to execute SQL '%s': %s", new Object[] { str, localRuntimeException2.getMessage() });
                  return;
                  localObject2 = localRuntimeException2;
                  localObject1 = localRuntimeException2;
                  ((StringBuilder)localObject4).append("(blob)");
                  continue;
                }
                finally
                {
                  if (localObject1 == null) {
                    continue;
                  }
                  ((android.database.Cursor)localObject1).close();
                  AppMethodBeat.o(269290);
                }
                localObject2 = localCursor;
                localObject1 = localCursor;
                ((StringBuilder)localObject4).append(" | ");
                j += 1;
                continue;
                localObject2 = localCursor;
                localObject1 = localCursor;
                i = localObject4.length;
                continue;
                localObject2 = localCursor;
                localObject1 = localCursor;
                ((StringBuilder)localObject4).append("(null)");
                continue;
                label442:
                RuntimeException localRuntimeException1 = localRuntimeException2;
                localObject1 = localRuntimeException2;
                Log.i("MicroMsg.Shell", ((StringBuilder)localObject4).toString());
                continue;
                label463:
                localRuntimeException1 = localRuntimeException2;
                localObject1 = localRuntimeException2;
                Log.i("MicroMsg.Shell", "Finish executing SQL in %d ms: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str });
                if (localRuntimeException2 != null)
                {
                  localRuntimeException2.close();
                  AppMethodBeat.o(269290);
                  return;
                }
                AppMethodBeat.o(269290);
                return;
              }
            }
          });
          AppMethodBeat.o(20144);
          return;
        }
        if ((paramAnonymousIntent != null) && (paramAnonymousIntent.length() > 0)) {
          com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 33
              //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: invokestatic 45	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
              //   8: getfield 51	com/tencent/mm/kernel/f:kcF	Lcom/tencent/mm/storagebase/h;
              //   11: invokevirtual 57	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
              //   14: astore 6
              //   16: invokestatic 63	java/lang/System:currentTimeMillis	()J
              //   19: lstore_1
              //   20: new 65	java/io/BufferedReader
              //   23: dup
              //   24: new 67	com/tencent/mm/vfs/x
              //   27: dup
              //   28: aload_0
              //   29: getfield 21	com/tencent/mm/console/Shell$3$2:val$file	Ljava/lang/String;
              //   32: invokespecial 70	com/tencent/mm/vfs/x:<init>	(Ljava/lang/String;)V
              //   35: invokespecial 73	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
              //   38: astore_3
              //   39: aload_3
              //   40: astore 4
              //   42: ldc 75
              //   44: new 77	java/lang/StringBuilder
              //   47: dup
              //   48: ldc 79
              //   50: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   53: aload_0
              //   54: getfield 21	com/tencent/mm/console/Shell$3$2:val$file	Ljava/lang/String;
              //   57: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   60: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   63: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   66: aload_3
              //   67: astore 4
              //   69: aload_3
              //   70: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
              //   73: astore 5
              //   75: aload 5
              //   77: ifnull +72 -> 149
              //   80: aload_3
              //   81: astore 4
              //   83: aload 6
              //   85: aload 5
              //   87: invokevirtual 101	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
              //   90: goto -24 -> 66
              //   93: astore 4
              //   95: aload_3
              //   96: astore 4
              //   98: ldc 75
              //   100: new 77	java/lang/StringBuilder
              //   103: dup
              //   104: ldc 103
              //   106: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   109: aload_0
              //   110: getfield 21	com/tencent/mm/console/Shell$3$2:val$file	Ljava/lang/String;
              //   113: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   116: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   119: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   122: aload_3
              //   123: ifnull +7 -> 130
              //   126: aload_3
              //   127: invokevirtual 109	java/io/BufferedReader:close	()V
              //   130: aload 6
              //   132: invokevirtual 113	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   135: ifeq +156 -> 291
              //   138: aload 6
              //   140: invokevirtual 116	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   143: ldc 33
              //   145: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   148: return
              //   149: aload_3
              //   150: astore 4
              //   152: ldc 75
              //   154: ldc 121
              //   156: iconst_1
              //   157: anewarray 4	java/lang/Object
              //   160: dup
              //   161: iconst_0
              //   162: invokestatic 63	java/lang/System:currentTimeMillis	()J
              //   165: lload_1
              //   166: lsub
              //   167: invokestatic 127	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   170: aastore
              //   171: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   174: aload_3
              //   175: invokevirtual 109	java/io/BufferedReader:close	()V
              //   178: aload 6
              //   180: invokevirtual 113	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   183: ifeq +108 -> 291
              //   186: aload 6
              //   188: invokevirtual 116	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   191: ldc 33
              //   193: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   196: return
              //   197: astore 4
              //   199: aconst_null
              //   200: astore_3
              //   201: ldc 75
              //   203: aload 4
              //   205: new 77	java/lang/StringBuilder
              //   208: dup
              //   209: ldc 132
              //   211: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   214: aload_0
              //   215: getfield 21	com/tencent/mm/console/Shell$3$2:val$file	Ljava/lang/String;
              //   218: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   221: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   224: iconst_0
              //   225: anewarray 4	java/lang/Object
              //   228: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   231: aload_3
              //   232: ifnull +7 -> 239
              //   235: aload_3
              //   236: invokevirtual 109	java/io/BufferedReader:close	()V
              //   239: aload 6
              //   241: invokevirtual 113	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   244: ifeq +47 -> 291
              //   247: aload 6
              //   249: invokevirtual 116	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   252: ldc 33
              //   254: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   257: return
              //   258: astore 4
              //   260: aconst_null
              //   261: astore_3
              //   262: aload_3
              //   263: ifnull +7 -> 270
              //   266: aload_3
              //   267: invokevirtual 109	java/io/BufferedReader:close	()V
              //   270: aload 6
              //   272: invokevirtual 113	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   275: ifeq +8 -> 283
              //   278: aload 6
              //   280: invokevirtual 116	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   283: ldc 33
              //   285: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   288: aload 4
              //   290: athrow
              //   291: ldc 33
              //   293: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   296: return
              //   297: astore_3
              //   298: goto -120 -> 178
              //   301: astore_3
              //   302: goto -172 -> 130
              //   305: astore_3
              //   306: goto -67 -> 239
              //   309: astore_3
              //   310: goto -40 -> 270
              //   313: astore_3
              //   314: aload 4
              //   316: astore 5
              //   318: aload_3
              //   319: astore 4
              //   321: aload 5
              //   323: astore_3
              //   324: goto -62 -> 262
              //   327: astore 4
              //   329: goto -67 -> 262
              //   332: astore 4
              //   334: goto -133 -> 201
              //   337: astore_3
              //   338: aconst_null
              //   339: astore_3
              //   340: goto -245 -> 95
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	343	0	this	2
              //   19	147	1	l	long
              //   38	229	3	localBufferedReader1	java.io.BufferedReader
              //   297	1	3	localIOException1	IOException
              //   301	1	3	localIOException2	IOException
              //   305	1	3	localIOException3	IOException
              //   309	1	3	localIOException4	IOException
              //   313	6	3	localObject1	Object
              //   323	1	3	localObject2	Object
              //   337	1	3	localFileNotFoundException1	java.io.FileNotFoundException
              //   339	1	3	localObject3	Object
              //   40	42	4	localBufferedReader2	java.io.BufferedReader
              //   93	1	4	localFileNotFoundException2	java.io.FileNotFoundException
              //   96	55	4	localBufferedReader3	java.io.BufferedReader
              //   197	7	4	localException1	java.lang.Exception
              //   258	57	4	localObject4	Object
              //   319	1	4	localObject5	Object
              //   327	1	4	localObject6	Object
              //   332	1	4	localException2	java.lang.Exception
              //   73	249	5	localObject7	Object
              //   14	265	6	localSQLiteDatabase	SQLiteDatabase
              // Exception table:
              //   from	to	target	type
              //   42	66	93	java/io/FileNotFoundException
              //   69	75	93	java/io/FileNotFoundException
              //   83	90	93	java/io/FileNotFoundException
              //   152	174	93	java/io/FileNotFoundException
              //   16	39	197	java/lang/Exception
              //   16	39	258	finally
              //   174	178	297	java/io/IOException
              //   126	130	301	java/io/IOException
              //   235	239	305	java/io/IOException
              //   266	270	309	java/io/IOException
              //   42	66	313	finally
              //   69	75	313	finally
              //   83	90	313	finally
              //   98	122	313	finally
              //   152	174	313	finally
              //   201	231	327	finally
              //   42	66	332	java/lang/Exception
              //   69	75	332	java/lang/Exception
              //   83	90	332	java/lang/Exception
              //   152	174	332	java/lang/Exception
              //   16	39	337	java/io/FileNotFoundException
            }
          });
        }
        AppMethodBeat.o(20144);
      }
    }, true);
    a("wechat.shell.GC", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20145);
        Runtime.getRuntime().gc();
        Toast.makeText(MMApplicationContext.getContext(), "trigger gc...", 0).show();
        AppMethodBeat.o(20145);
      }
    }, true);
    a("wechat.shell.DUMP_HPROF", new b()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20146);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "not coolassist or monkey env, disable hprof dump cmd.");
          AppMethodBeat.o(20146);
          return;
        }
        long l = System.currentTimeMillis();
        Runtime.getRuntime().gc();
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("process_suffix");
        if (Util.isNullOrNil(paramAnonymousIntent))
        {
          if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(20146);
          }
        }
        else
        {
          if (!paramAnonymousIntent.startsWith(":"))
          {
            Log.e("MicroMsg.Shell", "bad process suffix: %s", new Object[] { paramAnonymousIntent });
            AppMethodBeat.o(20146);
            return;
          }
          if (!MMApplicationContext.getProcessName().endsWith(paramAnonymousIntent))
          {
            AppMethodBeat.o(20146);
            return;
          }
        }
        paramAnonymousIntent = new q(MMApplicationContext.getContext().getExternalCacheDir() + "/hprofs");
        Log.i("MicroMsg.Shell", "prepare hprof dir %s", new Object[] { paramAnonymousIntent });
        if (!paramAnonymousIntent.ifE()) {
          Log.e("MicroMsg.Shell", "dir not exists, mkdir: %s", new Object[] { Boolean.valueOf(paramAnonymousIntent.ifL()) });
        }
        paramAnonymousIntent = new q(paramAnonymousIntent, MMApplicationContext.getProcessName().replace(".", "_").replace(":", "_") + "_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".hprof");
        Log.i("MicroMsg.Shell", "hprof file path is %s", new Object[] { paramAnonymousIntent.bOF() });
        try
        {
          Debug.dumpHprofData(paramAnonymousIntent.bOF());
          Toast.makeText(MMApplicationContext.getContext(), "Done. cost " + (System.currentTimeMillis() - l) + "ms, file:\n" + paramAnonymousIntent.bOF(), 1).show();
          AppMethodBeat.o(20146);
          return;
        }
        catch (IOException paramAnonymousIntent)
        {
          Log.printErrStackTrace("MicroMsg.Shell", paramAnonymousIntent, "dump hprof failed.", new Object[0]);
          Toast.makeText(MMApplicationContext.getContext(), "Failure.", 1).show();
          AppMethodBeat.o(20146);
        }
      }
    }, true);
    a("wechat.shell.HOOK_ALL", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20147);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20147);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.GLp.aUm("<cmd><diagnostic><MemoryHook enable='1' source='push' multiprocess='0' duration='24' hook='.*\\.so$' stack='0' min='0' max='0' force='1' enableExpt='0' sampling='1'/></diagnostic></cmd>");
        Toast.makeText(MMApplicationContext.getContext(), "Hook ALL .*\\.so", 0).show();
        AppMethodBeat.o(20147);
      }
    }, true);
    a("wechat.shell.HOOK_MM", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20148);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20148);
          return;
        }
        if (BuildInfo.IS_FLAVOR_RED) {}
        for (paramAnonymousIntent = ".*com\\.tencent\\.mm.*\\.so$;.*libhwui\\.so$;.*libEGL\\.so$;.*libGLES.*\\.so$";; paramAnonymousIntent = ".*com\\.tencent\\.mm.*\\.so$")
        {
          paramAnonymousIntent = "<cmd><diagnostic><MemoryHook\n enable='1' source='push' multiprocess='0' duration='24' hook='" + paramAnonymousIntent + "' stack='0' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='1'/></diagnostic></cmd>";
          com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
          Toast.makeText(MMApplicationContext.getContext(), "Hook MM so", 0).show();
          AppMethodBeat.o(20148);
          return;
        }
      }
    }, true);
    a("wechat.shell.HOOK_DISABLE", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20149);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20149);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.GLp.aUm("<cmd><diagnostic><MemoryHook enable='0' source='push' enableExpt='0' force='1'/></diagnostic></cmd>");
        Toast.makeText(MMApplicationContext.getContext(), "Hook Disable", 0).show();
        AppMethodBeat.o(20149);
      }
    }, true);
    a("wechat.shell.HOOK_REPORT", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20150);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20150);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.GLp.aUm("<cmd><diagnostic><report><memory/></report></diagnostic></cmd>");
        Toast.makeText(MMApplicationContext.getContext(), "Hook report", 0).show();
        AppMethodBeat.o(20150);
      }
    }, true);
    a("wechat.shell.MEMORY_HOOK", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20151);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20151);
          return;
        }
        paramAnonymousIntent = "<cmd><diagnostic><MemoryHook enable='" + Shell.ap(paramAnonymousIntent.getStringExtra("enable"), "0") + "' source='push' multiprocess='" + Shell.ap(paramAnonymousIntent.getStringExtra("multiprocess"), "0") + "' duration='" + Shell.ap(paramAnonymousIntent.getStringExtra("duration"), "1") + "' hook='" + Shell.ap(paramAnonymousIntent.getStringExtra("hook"), ".*com\\.tencent\\.mm.*\\.so$") + "' ignore='" + Shell.ap(paramAnonymousIntent.getStringExtra("ignore"), "") + "' stack='" + Shell.ap(paramAnonymousIntent.getStringExtra("stack"), "0") + "' min='" + Shell.ap(paramAnonymousIntent.getStringExtra("min"), "0") + "' max='" + Shell.ap(paramAnonymousIntent.getStringExtra("max"), "0") + "' force='" + Shell.ap(paramAnonymousIntent.getStringExtra("force"), "0") + "' sampling='" + Shell.ap(paramAnonymousIntent.getStringExtra("sampling"), "1") + "' extreme='" + Shell.ap(paramAnonymousIntent.getStringExtra("extreme"), "0") + "' mmap='" + Shell.ap(paramAnonymousIntent.getStringExtra("mmap"), "0") + "'/></diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
        Toast.makeText(MMApplicationContext.getContext(), paramAnonymousIntent, 0).show();
        AppMethodBeat.o(20151);
      }
    }, true);
    a("wechat.shell." + b.aUn(""), new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20152);
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' network='any' />", new Object[] { b.aUn("©¥¶£ê¯¥§»") }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
        Toast.makeText(MMApplicationContext.getContext(), "Diag op1 triggered.", 1).show();
        AppMethodBeat.o(20152);
      }
    }, true);
    a("wechat.shell." + b.aUn(""), new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20154);
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' network='any' />", new Object[] { b.aUn("©¥¶£ê¶¥§»") }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
        Toast.makeText(MMApplicationContext.getContext(), "Diag op2 triggered.", 1).show();
        AppMethodBeat.o(20154);
      }
    }, true);
    a("wechat.shell." + b.aUn(""), new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20155);
        paramAnonymousIntent = Util.nullAsNil(paramAnonymousIntent.getStringExtra("name_regex"));
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' name_regex='%s' network='any' />", new Object[] { b.aUn("§§´¥ì±¬"), paramAnonymousIntent }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
        Toast.makeText(MMApplicationContext.getContext(), "Diag op3 triggered.", 1).show();
        AppMethodBeat.o(20155);
      }
    }, true);
    a("wechat.shell." + b.aUn(""), new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(281446);
        paramAnonymousIntent = Util.nullAsNil(paramAnonymousIntent.getStringExtra("process"));
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' process='%s' network='any' />", new Object[] { b.aUn("­ ²°"), paramAnonymousIntent }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
        Toast.makeText(MMApplicationContext.getContext(), "Diag op4 triggered.", 1).show();
        AppMethodBeat.o(281446);
      }
    }, true);
    a("wechat.shell." + b.aUn(""), new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(283702);
        paramAnonymousIntent = Util.nullAsNil(paramAnonymousIntent.getStringExtra("process"));
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' process='%s' network='any' />", new Object[] { b.aUn("´­ ²°"), paramAnonymousIntent }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramAnonymousIntent);
        Toast.makeText(MMApplicationContext.getContext(), "Diag op5 triggered.", 1).show();
        AppMethodBeat.o(283702);
      }
    }, true);
    a("wechat.shell.RECOVERY_LAUNCH_UI", new a()
    {
      @SuppressLint({"VisibleForTests"})
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(270442);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(270442);
          return;
        }
        Log.i("MicroMsg.Shell", "#RECOVERY_LAUNCH_UI");
        Object localObject = new Intent(MMApplicationContext.getContext(), RecoveryUI.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("extra_crash_count", 3);
        paramAnonymousIntent = MMApplicationContext.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/console/Shell$24", "exec", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousIntent, "com/tencent/mm/console/Shell$24", "exec", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(270442);
      }
    }, true);
    a("wechat.shell.RECOVERY_FETCH_PATCH", new a()
    {
      @SuppressLint({"VisibleForTests"})
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(288779);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(288779);
          return;
        }
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("fetch_base_id");
        if (TextUtils.isEmpty(paramAnonymousIntent))
        {
          Log.e("MicroMsg.Shell", "base id is empty, abort");
          Toast.makeText(MMApplicationContext.getContext(), "base id is empty, abort", 1).show();
          AppMethodBeat.o(288779);
          return;
        }
        Log.i("MicroMsg.Shell", "#RECOVERY_FETCH_PATCH, baseId = ".concat(String.valueOf(paramAnonymousIntent)));
        WXRecoveryUploadService.fetchTinkerPatch(MMApplicationContext.getContext(), paramAnonymousIntent);
        AppMethodBeat.o(288779);
      }
    }, true);
    a("wechat.shell.THREAD_HOOK", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(212414);
        com.tencent.mm.plugin.performance.a.a.GLp.aUm("<cmd><diagnostic><PthreadHook enable='1' source='push' multiprocess='0' duration='24' hook='.*\\.so$' force='1' thread='.*'/></diagnostic></cmd>");
        Toast.makeText(MMApplicationContext.getContext(), "PthreadHook enable", 1).show();
        AppMethodBeat.o(212414);
      }
    }, true);
    a("wechat.shell.THREAD_DUMP", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(202252);
        com.tencent.mm.plugin.performance.a.a.GLp.aUm("<cmd><diagnostic><report><pthread/></report></diagnostic></cmd>");
        Toast.makeText(MMApplicationContext.getContext(), "PthreadHook report", 1).show();
        AppMethodBeat.o(202252);
      }
    }, true);
    a("wechat.shell.FINDER_SHELL", new Shell.21(), true);
    a("wechat.shell.WATCH_MEM", new Shell.22(), true);
    a("wechat.shell.TRIM_MEM", new Shell.24(), true);
    a("wechat.shell.WATCH_PROC", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(279041);
        Log.d("MicroMsg.ProcessWatchDog", "DumpProcesses: %s", new Object[] { Arrays.toString(com.tencent.mm.plugin.performance.watchdogs.d.foB().foC().toArray()) });
        AppMethodBeat.o(279041);
      }
    }, true);
    a("wechat.shell.MOVE_XLOG", new a()
    {
      boolean jwZ = false;
      
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(283958);
        if (this.jwZ)
        {
          Toast.makeText(MMApplicationContext.getContext(), "xlog had moved.", 0).show();
          AppMethodBeat.o(283958);
          return;
        }
        Log.i("MicroMsg.Shell", "action: wechat.shell.PULL_XLOG");
        Toast.makeText(MMApplicationContext.getContext(), "start to move xlog.", 0).show();
        Log.moveLogsFromCacheDirToLogDir();
        Toast.makeText(MMApplicationContext.getContext(), "xlog move success", 0).show();
        this.jwZ = true;
        AppMethodBeat.o(283958);
      }
    }, false);
    a local27 = new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(292158);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "OpenWeApp not coolassist or monkey env, disable hprof dump cmd.");
          AppMethodBeat.o(292158);
          return;
        }
        if (!MMApplicationContext.isMMProcess())
        {
          AppMethodBeat.o(292158);
          return;
        }
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("kContent");
        if (Util.isNullOrNil(paramAnonymousIntent))
        {
          AppMethodBeat.o(292158);
          return;
        }
        paramAnonymousIntent = new String(Base64.decode(paramAnonymousIntent, 0));
        com.tencent.mm.plugin.appbrand.debugger.f localf = (com.tencent.mm.plugin.appbrand.debugger.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.debugger.f.class);
        MMApplicationContext.getContext();
        localf.afE(paramAnonymousIntent);
        AppMethodBeat.o(292158);
      }
    };
    a("wechat.shell.OpenWeApp", local27, true);
    a("wechat.shell.KillWeApp", local27, true);
    a("wechat.shell.FINDER_VIDEO_TEST", new Shell.28(), true);
    a("wechat.shell.DUMP_MAPS", new b()
    {
      /* Error */
      public final void u(Intent paramAnonymousIntent)
      {
        // Byte code:
        //   0: ldc 20
        //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 32	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
        //   8: ifne +22 -> 30
        //   11: invokestatic 35	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
        //   14: ifne +16 -> 30
        //   17: ldc 37
        //   19: ldc 39
        //   21: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   24: ldc 20
        //   26: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: aload_1
        //   31: ldc 50
        //   33: invokevirtual 56	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   36: astore_2
        //   37: aload_2
        //   38: invokestatic 62	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   41: ifeq +15 -> 56
        //   44: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
        //   47: ifne +55 -> 102
        //   50: ldc 20
        //   52: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   55: return
        //   56: aload_2
        //   57: ldc 69
        //   59: invokevirtual 74	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   62: ifne +24 -> 86
        //   65: ldc 37
        //   67: ldc 76
        //   69: iconst_1
        //   70: anewarray 4	java/lang/Object
        //   73: dup
        //   74: iconst_0
        //   75: aload_2
        //   76: aastore
        //   77: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   80: ldc 20
        //   82: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   85: return
        //   86: invokestatic 83	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
        //   89: aload_2
        //   90: invokevirtual 86	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   93: ifne +9 -> 102
        //   96: ldc 20
        //   98: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   101: return
        //   102: aload_1
        //   103: ldc 88
        //   105: invokevirtual 56	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
        //   108: astore_1
        //   109: new 90	com/tencent/mm/vfs/q
        //   112: dup
        //   113: new 92	java/lang/StringBuilder
        //   116: dup
        //   117: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   120: invokestatic 98	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
        //   123: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   126: ldc 104
        //   128: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   131: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   134: invokespecial 110	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
        //   137: astore_2
        //   138: aload_2
        //   139: invokevirtual 113	com/tencent/mm/vfs/q:ifE	()Z
        //   142: ifne +8 -> 150
        //   145: aload_2
        //   146: invokevirtual 116	com/tencent/mm/vfs/q:ifL	()Z
        //   149: pop
        //   150: ldc 118
        //   152: iconst_2
        //   153: anewarray 4	java/lang/Object
        //   156: dup
        //   157: iconst_0
        //   158: aload_2
        //   159: aastore
        //   160: dup
        //   161: iconst_1
        //   162: aload_1
        //   163: aastore
        //   164: invokestatic 122	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   167: astore_2
        //   168: ldc 124
        //   170: iconst_1
        //   171: anewarray 4	java/lang/Object
        //   174: dup
        //   175: iconst_0
        //   176: invokestatic 130	android/os/Process:myPid	()I
        //   179: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   182: aastore
        //   183: invokestatic 122	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   186: astore_1
        //   187: ldc 37
        //   189: ldc 138
        //   191: iconst_2
        //   192: anewarray 4	java/lang/Object
        //   195: dup
        //   196: iconst_0
        //   197: aload_1
        //   198: aastore
        //   199: dup
        //   200: iconst_1
        //   201: aload_2
        //   202: aastore
        //   203: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   206: new 142	java/io/BufferedWriter
        //   209: dup
        //   210: new 144	java/io/OutputStreamWriter
        //   213: dup
        //   214: new 146	java/io/FileOutputStream
        //   217: dup
        //   218: aload_2
        //   219: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   222: invokespecial 150	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   225: invokespecial 153	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   228: astore_2
        //   229: new 155	java/io/BufferedReader
        //   232: dup
        //   233: new 157	java/io/InputStreamReader
        //   236: dup
        //   237: new 159	java/io/FileInputStream
        //   240: dup
        //   241: aload_1
        //   242: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
        //   245: invokespecial 163	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   248: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   251: astore_1
        //   252: aload_2
        //   253: astore 4
        //   255: aload_1
        //   256: astore_3
        //   257: aload_1
        //   258: invokevirtual 169	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   261: astore 5
        //   263: aload 5
        //   265: ifnull +74 -> 339
        //   268: aload_2
        //   269: astore 4
        //   271: aload_1
        //   272: astore_3
        //   273: aload_2
        //   274: aload 5
        //   276: iconst_0
        //   277: aload 5
        //   279: invokevirtual 172	java/lang/String:length	()I
        //   282: invokevirtual 176	java/io/BufferedWriter:write	(Ljava/lang/String;II)V
        //   285: aload_2
        //   286: astore 4
        //   288: aload_1
        //   289: astore_3
        //   290: aload_2
        //   291: invokevirtual 179	java/io/BufferedWriter:newLine	()V
        //   294: goto -42 -> 252
        //   297: astore 5
        //   299: aload_2
        //   300: astore 4
        //   302: aload_1
        //   303: astore_3
        //   304: ldc 37
        //   306: aload 5
        //   308: ldc 181
        //   310: iconst_0
        //   311: anewarray 4	java/lang/Object
        //   314: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   317: aload_1
        //   318: ifnull +7 -> 325
        //   321: aload_1
        //   322: invokevirtual 188	java/io/BufferedReader:close	()V
        //   325: aload_2
        //   326: ifnull +78 -> 404
        //   329: aload_2
        //   330: invokevirtual 189	java/io/BufferedWriter:close	()V
        //   333: ldc 20
        //   335: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   338: return
        //   339: aload_2
        //   340: astore 4
        //   342: aload_1
        //   343: astore_3
        //   344: aload_2
        //   345: invokevirtual 192	java/io/BufferedWriter:flush	()V
        //   348: aload_1
        //   349: invokevirtual 188	java/io/BufferedReader:close	()V
        //   352: aload_2
        //   353: invokevirtual 189	java/io/BufferedWriter:close	()V
        //   356: ldc 20
        //   358: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   361: return
        //   362: astore_1
        //   363: ldc 20
        //   365: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   368: return
        //   369: astore_1
        //   370: ldc 20
        //   372: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   375: return
        //   376: astore_1
        //   377: aconst_null
        //   378: astore_2
        //   379: aconst_null
        //   380: astore_3
        //   381: aload_3
        //   382: ifnull +7 -> 389
        //   385: aload_3
        //   386: invokevirtual 188	java/io/BufferedReader:close	()V
        //   389: aload_2
        //   390: ifnull +7 -> 397
        //   393: aload_2
        //   394: invokevirtual 189	java/io/BufferedWriter:close	()V
        //   397: ldc 20
        //   399: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   402: aload_1
        //   403: athrow
        //   404: ldc 20
        //   406: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   409: return
        //   410: astore_1
        //   411: goto -59 -> 352
        //   414: astore_1
        //   415: goto -90 -> 325
        //   418: astore_3
        //   419: goto -30 -> 389
        //   422: astore_2
        //   423: goto -26 -> 397
        //   426: astore_1
        //   427: aconst_null
        //   428: astore_3
        //   429: goto -48 -> 381
        //   432: astore_1
        //   433: aload 4
        //   435: astore_2
        //   436: goto -55 -> 381
        //   439: astore 5
        //   441: aconst_null
        //   442: astore_2
        //   443: aconst_null
        //   444: astore_1
        //   445: goto -146 -> 299
        //   448: astore 5
        //   450: aconst_null
        //   451: astore_1
        //   452: goto -153 -> 299
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	455	0	this	29
        //   0	455	1	paramAnonymousIntent	Intent
        //   36	358	2	localObject1	Object
        //   422	1	2	localIOException1	IOException
        //   435	8	2	localObject2	Object
        //   256	130	3	localIntent	Intent
        //   418	1	3	localIOException2	IOException
        //   428	1	3	localObject3	Object
        //   253	181	4	localObject4	Object
        //   261	17	5	str	String
        //   297	10	5	localException1	java.lang.Exception
        //   439	1	5	localException2	java.lang.Exception
        //   448	1	5	localException3	java.lang.Exception
        // Exception table:
        //   from	to	target	type
        //   257	263	297	java/lang/Exception
        //   273	285	297	java/lang/Exception
        //   290	294	297	java/lang/Exception
        //   344	348	297	java/lang/Exception
        //   352	356	362	java/io/IOException
        //   329	333	369	java/io/IOException
        //   206	229	376	finally
        //   348	352	410	java/io/IOException
        //   321	325	414	java/io/IOException
        //   385	389	418	java/io/IOException
        //   393	397	422	java/io/IOException
        //   229	252	426	finally
        //   257	263	432	finally
        //   273	285	432	finally
        //   290	294	432	finally
        //   304	317	432	finally
        //   344	348	432	finally
        //   206	229	439	java/lang/Exception
        //   229	252	448	java/lang/Exception
      }
    }, true);
    a("wechat.shell.BRANDS_XID", new a()
    {
      @SuppressLint({"VisibleForTests"})
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(197197);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(197197);
          return;
        }
        paramAnonymousIntent = paramAnonymousIntent.getExtras();
        if (paramAnonymousIntent == null)
        {
          Log.e("MicroMsg.Shell", "extras is null");
          AppMethodBeat.o(197197);
          return;
        }
        int i = Integer.parseInt(String.valueOf(paramAnonymousIntent.get("set_xid")));
        Log.i("MicroMsg.Shell", "#BRANDS_XID, set_xid = ".concat(String.valueOf(i)));
        if (i >= 0) {
          cs.d.vt(i);
        }
        AppMethodBeat.o(197197);
      }
    }, true);
    a("wechat.shell.BRANDS_BIZ", new a()
    {
      @SuppressLint({"VisibleForTests"})
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(290105);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(290105);
          return;
        }
        paramAnonymousIntent = paramAnonymousIntent.getExtras();
        if (paramAnonymousIntent == null)
        {
          Log.e("MicroMsg.Shell", "extras is null");
          AppMethodBeat.o(290105);
          return;
        }
        Log.i("MicroMsg.Shell", "#BRANDS_BIZ");
        Iterator localIterator = paramAnonymousIntent.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if ((str1.startsWith("set_biz_")) && (str1.length() > 8))
          {
            String str2 = str1.substring(str1.indexOf("set_biz_") + 8);
            int i = Integer.parseInt(String.valueOf(paramAnonymousIntent.get(str1)));
            Log.i("MicroMsg.Shell", "#BRANDS_BIZ, set " + str2 + " = " + i);
            cs.d.aE(str2, i);
          }
        }
        AppMethodBeat.o(290105);
      }
    }, true);
    a("wechat.shell.BRANDS_CLEAR", new a()
    {
      @SuppressLint({"VisibleForTests"})
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(267613);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(267613);
          return;
        }
        Log.i("MicroMsg.Shell", "#BRANDS_CLEAR");
        cs.d.clearAll();
        AppMethodBeat.o(267613);
      }
    }, true);
    a("wechat.shell.BRANDS_DUMP", new a()
    {
      @SuppressLint({"VisibleForTests"})
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(276421);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(276421);
          return;
        }
        Log.i("MicroMsg.Shell", "#BRANDS_DUMP");
        cs.d.bfV();
        AppMethodBeat.o(276421);
      }
    }, true);
    a("wechat.shell.WATCH_FD", new a()
    {
      public final void u(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(278806);
        if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
        {
          Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(278806);
          return;
        }
        com.tencent.mm.plugin.performance.watchdogs.a.jdMethod_for().run();
        AppMethodBeat.o(278806);
      }
    }, true);
    a("wechat.shell.DISABLE_ACTIVITY_NOTIFIER", new Shell.36(), true);
    jwW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276562);
        Log.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() });
        Object[] arrayOfObject = new Object[1];
        throw new NullPointerException();
      }
    };
    AppMethodBeat.o(20168);
  }
  
  private static void a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(280729);
    if ((!paramBoolean) || (WeChatEnvironment.hasDebugger()))
    {
      jwV.addAction(paramString);
      jwU.put(paramString, parama);
    }
    AppMethodBeat.o(280729);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(20166);
    Receiver localReceiver;
    IntentFilter localIntentFilter;
    if (this.jwT == null)
    {
      this.jwT = new Receiver();
      localReceiver = this.jwT;
      localIntentFilter = jwV;
      if (!WeChatEnvironment.hasDebugger()) {
        break label59;
      }
    }
    label59:
    for (String str = null;; str = "com.tencent.mm.permission.MOVE_XLOG")
    {
      paramContext.registerReceiver(localReceiver, localIntentFilter, str, null);
      AppMethodBeat.o(20166);
      return;
    }
  }
  
  public static class Receiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(20164);
      paramContext = paramIntent.getAction();
      Shell.a locala = (Shell.a)Shell.axf().get(paramContext);
      if (locala == null)
      {
        Log.e("MicroMsg.Shell", "no action found for %s", new Object[] { paramContext });
        AppMethodBeat.o(20164);
        return;
      }
      if ((!MMApplicationContext.isMainProcess()) && (!(locala instanceof Shell.b)))
      {
        Log.e("MicroMsg.Shell", "action[%s] can only run in mm process", new Object[] { paramContext });
        AppMethodBeat.o(20164);
        return;
      }
      Log.e("MicroMsg.Shell", "shell action %s", new Object[] { paramContext });
      locala.u(paramIntent);
      AppMethodBeat.o(20164);
    }
  }
  
  public static abstract interface a
  {
    public abstract void u(Intent paramIntent);
  }
  
  public static abstract interface b
    extends Shell.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell
 * JD-Core Version:    0.7.0.1
 */