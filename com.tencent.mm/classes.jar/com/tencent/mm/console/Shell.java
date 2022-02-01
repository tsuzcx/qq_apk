package com.tencent.mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.jo.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public final class Shell
{
  private static HashMap<String, a> fHK;
  private static IntentFilter fHL;
  private static Runnable fHM;
  private Receiver fHJ = null;
  
  static
  {
    AppMethodBeat.i(20168);
    fHK = new HashMap();
    fHL = new IntentFilter();
    a("wechat.shell.SET_NEXTRET", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20140);
        int i = paramAnonymousIntent.getIntExtra("type", 2147483647);
        int j = paramAnonymousIntent.getIntExtra("error", 0);
        if ((i == 2147483647) || (j == 0))
        {
          AppMethodBeat.o(20140);
          return;
        }
        ad.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        ab.dt(i, j);
        AppMethodBeat.o(20140);
      }
    });
    a("wechat.shell.SET_LOGLEVEL", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20153);
        int i = paramAnonymousIntent.getIntExtra("level", 0);
        ad.w("MicroMsg.Shell", "kiro set Log.level=%d", new Object[] { Integer.valueOf(ad.getLogLevel()) });
        ad.Wj(i);
        AppMethodBeat.o(20153);
      }
    });
    a("wechat.shell.SET_CDNTRANS", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20157);
        ab.hVw = paramAnonymousIntent.getBooleanExtra("value", false);
        ad.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[] { Boolean.valueOf(ab.hVw) });
        AppMethodBeat.o(20157);
      }
    });
    a("wechat.shell.SET_DKTEST", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20158);
        ab.hVC = paramAnonymousIntent.getIntExtra("key", 0);
        ab.hVD = paramAnonymousIntent.getIntExtra("val", 0);
        ab.hVE = paramAnonymousIntent.getStringExtra("str");
        ad.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[] { Integer.valueOf(ab.hVC), Integer.valueOf(ab.hVD), ab.hVE });
        if (10009 == ab.hVC)
        {
          int i = ab.hVD;
          Shell.Zf();
          AppMethodBeat.o(20158);
          return;
        }
        if ((10014 == ab.hVC) && (aj.cbv()))
        {
          o.azv().a(7L, 1, "");
          AppMethodBeat.o(20158);
          return;
        }
        if (10015 == ab.hVC) {
          aj.eFH();
        }
        AppMethodBeat.o(20158);
      }
    });
    a("wechat.shell.NET_DNS_TEST", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20159);
        ab.hVB = paramAnonymousIntent.getIntExtra("value", 0);
        ad.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", new Object[] { Integer.toBinaryString(ab.hVB) });
        AppMethodBeat.o(20159);
      }
    });
    a("wechat.shell.IDC_ERROR", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20160);
        ab.hVF = paramAnonymousIntent.getStringExtra("errmsg");
        ad.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", new Object[] { ab.hVF });
        AppMethodBeat.o(20160);
      }
    });
    a("wechat.shell.SET_DK_WT_TEST", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20161);
        ab.hVG = paramAnonymousIntent.getStringExtra("acc");
        ab.hVH = paramAnonymousIntent.getStringExtra("pass");
        ad.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[] { ab.hVG, ab.hVH });
        AppMethodBeat.o(20161);
      }
    });
    a("wechat.shell.SET_MUTE_ROOM_TEST", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20162);
        ab.hWk = paramAnonymousIntent.getIntExtra("flag", 0);
        ad.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[] { Integer.valueOf(ab.hWk) });
        AppMethodBeat.o(20162);
      }
    });
    a("wechat.shell.HOTPATCH_TEST", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20163);
        jo localjo = new jo();
        localjo.dnH.dnM = paramAnonymousIntent.getExtras().getString("path", "/data/local/tmp/test.apk");
        ad.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[] { localjo.dnH.dnM });
        com.tencent.mm.sdk.b.a.ESL.l(localjo);
        AppMethodBeat.o(20163);
      }
    });
    a("wechat.shell.EXEC_SQL", new a()
    {
      public final void s(final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20143);
        if (!aj.cbv())
        {
          AppMethodBeat.o(20143);
          return;
        }
        final String str = paramAnonymousIntent.getStringExtra("sql");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("file");
        if ((str != null) && (str.length() > 0))
        {
          g.afE().ax(new Runnable()
          {
            public final void run()
            {
              Object localObject4 = null;
              com.tencent.wcdb.Cursor localCursor = null;
              AppMethodBeat.i(20141);
              SQLiteDatabase localSQLiteDatabase = g.afB().gda.eOh();
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
                  ad.i("MicroMsg.Shell", "Executing SQL from shell: " + str);
                  if (i > 0)
                  {
                    localObject2 = localCursor;
                    localObject1 = localCursor;
                    ad.i("MicroMsg.Shell", " > " + TextUtils.join(" | ", (Object[])localObject4));
                  }
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  localObject4 = new StringBuilder(1024);
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  if (!localCursor.moveToNext()) {
                    break label465;
                  }
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  ((StringBuilder)localObject4).setLength(0);
                  localObject2 = localCursor;
                  localObject1 = localCursor;
                  ((StringBuilder)localObject4).append(" > ");
                  j = 0;
                  if (j >= i) {
                    break label444;
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
                  ad.e("MicroMsg.Shell", "Failed to execute SQL '%s': %s", new Object[] { str, localRuntimeException2.getMessage() });
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
                  AppMethodBeat.o(20141);
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
                label444:
                RuntimeException localRuntimeException1 = localRuntimeException2;
                localObject1 = localRuntimeException2;
                ad.i("MicroMsg.Shell", ((StringBuilder)localObject4).toString());
                continue;
                label465:
                localRuntimeException1 = localRuntimeException2;
                localObject1 = localRuntimeException2;
                ad.i("MicroMsg.Shell", "Finish executing SQL in %d ms: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str });
                if (localRuntimeException2 != null)
                {
                  localRuntimeException2.close();
                  AppMethodBeat.o(20141);
                  return;
                }
                AppMethodBeat.o(20141);
                return;
              }
            }
          });
          AppMethodBeat.o(20143);
          return;
        }
        if ((paramAnonymousIntent != null) && (paramAnonymousIntent.length() > 0)) {
          g.afE().ax(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: sipush 20142
              //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   6: invokestatic 44	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
              //   9: getfield 50	com/tencent/mm/kernel/e:gda	Lcom/tencent/mm/storagebase/h;
              //   12: invokevirtual 56	com/tencent/mm/storagebase/h:eOh	()Lcom/tencent/wcdb/database/SQLiteDatabase;
              //   15: astore 6
              //   17: invokestatic 62	java/lang/System:currentTimeMillis	()J
              //   20: lstore_1
              //   21: new 64	java/io/BufferedReader
              //   24: dup
              //   25: new 66	com/tencent/mm/vfs/k
              //   28: dup
              //   29: aload_0
              //   30: getfield 21	com/tencent/mm/console/Shell$2$2:val$file	Ljava/lang/String;
              //   33: invokespecial 69	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
              //   36: invokespecial 72	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
              //   39: astore_3
              //   40: aload_3
              //   41: astore 4
              //   43: ldc 74
              //   45: new 76	java/lang/StringBuilder
              //   48: dup
              //   49: ldc 78
              //   51: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   54: aload_0
              //   55: getfield 21	com/tencent/mm/console/Shell$2$2:val$file	Ljava/lang/String;
              //   58: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   61: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   64: invokestatic 92	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   67: aload_3
              //   68: astore 4
              //   70: aload_3
              //   71: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
              //   74: astore 5
              //   76: aload 5
              //   78: ifnull +73 -> 151
              //   81: aload_3
              //   82: astore 4
              //   84: aload 6
              //   86: aload 5
              //   88: invokevirtual 100	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
              //   91: goto -24 -> 67
              //   94: astore 4
              //   96: aload_3
              //   97: astore 4
              //   99: ldc 74
              //   101: new 76	java/lang/StringBuilder
              //   104: dup
              //   105: ldc 102
              //   107: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   110: aload_0
              //   111: getfield 21	com/tencent/mm/console/Shell$2$2:val$file	Ljava/lang/String;
              //   114: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   117: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   120: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   123: aload_3
              //   124: ifnull +7 -> 131
              //   127: aload_3
              //   128: invokevirtual 108	java/io/BufferedReader:close	()V
              //   131: aload 6
              //   133: invokevirtual 112	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   136: ifeq +160 -> 296
              //   139: aload 6
              //   141: invokevirtual 115	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   144: sipush 20142
              //   147: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   150: return
              //   151: aload_3
              //   152: astore 4
              //   154: ldc 74
              //   156: ldc 120
              //   158: iconst_1
              //   159: anewarray 4	java/lang/Object
              //   162: dup
              //   163: iconst_0
              //   164: invokestatic 62	java/lang/System:currentTimeMillis	()J
              //   167: lload_1
              //   168: lsub
              //   169: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   172: aastore
              //   173: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   176: aload_3
              //   177: invokevirtual 108	java/io/BufferedReader:close	()V
              //   180: aload 6
              //   182: invokevirtual 112	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   185: ifeq +111 -> 296
              //   188: aload 6
              //   190: invokevirtual 115	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   193: sipush 20142
              //   196: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   199: return
              //   200: astore 4
              //   202: aconst_null
              //   203: astore_3
              //   204: ldc 74
              //   206: aload 4
              //   208: new 76	java/lang/StringBuilder
              //   211: dup
              //   212: ldc 131
              //   214: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   217: aload_0
              //   218: getfield 21	com/tencent/mm/console/Shell$2$2:val$file	Ljava/lang/String;
              //   221: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   224: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   227: iconst_0
              //   228: anewarray 4	java/lang/Object
              //   231: invokestatic 135	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   234: aload_3
              //   235: ifnull +7 -> 242
              //   238: aload_3
              //   239: invokevirtual 108	java/io/BufferedReader:close	()V
              //   242: aload 6
              //   244: invokevirtual 112	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   247: ifeq +49 -> 296
              //   250: aload 6
              //   252: invokevirtual 115	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   255: sipush 20142
              //   258: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   261: return
              //   262: astore 4
              //   264: aconst_null
              //   265: astore_3
              //   266: aload_3
              //   267: ifnull +7 -> 274
              //   270: aload_3
              //   271: invokevirtual 108	java/io/BufferedReader:close	()V
              //   274: aload 6
              //   276: invokevirtual 112	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
              //   279: ifeq +8 -> 287
              //   282: aload 6
              //   284: invokevirtual 115	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
              //   287: sipush 20142
              //   290: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   293: aload 4
              //   295: athrow
              //   296: sipush 20142
              //   299: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   302: return
              //   303: astore_3
              //   304: goto -124 -> 180
              //   307: astore_3
              //   308: goto -177 -> 131
              //   311: astore_3
              //   312: goto -70 -> 242
              //   315: astore_3
              //   316: goto -42 -> 274
              //   319: astore_3
              //   320: aload 4
              //   322: astore 5
              //   324: aload_3
              //   325: astore 4
              //   327: aload 5
              //   329: astore_3
              //   330: goto -64 -> 266
              //   333: astore 4
              //   335: goto -69 -> 266
              //   338: astore 4
              //   340: goto -136 -> 204
              //   343: astore_3
              //   344: aconst_null
              //   345: astore_3
              //   346: goto -250 -> 96
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	349	0	this	2
              //   20	148	1	l	long
              //   39	232	3	localBufferedReader1	java.io.BufferedReader
              //   303	1	3	localIOException1	IOException
              //   307	1	3	localIOException2	IOException
              //   311	1	3	localIOException3	IOException
              //   315	1	3	localIOException4	IOException
              //   319	6	3	localObject1	Object
              //   329	1	3	localObject2	Object
              //   343	1	3	localFileNotFoundException1	java.io.FileNotFoundException
              //   345	1	3	localObject3	Object
              //   41	42	4	localBufferedReader2	java.io.BufferedReader
              //   94	1	4	localFileNotFoundException2	java.io.FileNotFoundException
              //   97	56	4	localBufferedReader3	java.io.BufferedReader
              //   200	7	4	localException1	java.lang.Exception
              //   262	59	4	localObject4	Object
              //   325	1	4	localObject5	Object
              //   333	1	4	localObject6	Object
              //   338	1	4	localException2	java.lang.Exception
              //   74	254	5	localObject7	Object
              //   15	268	6	localSQLiteDatabase	SQLiteDatabase
              // Exception table:
              //   from	to	target	type
              //   43	67	94	java/io/FileNotFoundException
              //   70	76	94	java/io/FileNotFoundException
              //   84	91	94	java/io/FileNotFoundException
              //   154	176	94	java/io/FileNotFoundException
              //   17	40	200	java/lang/Exception
              //   17	40	262	finally
              //   176	180	303	java/io/IOException
              //   127	131	307	java/io/IOException
              //   238	242	311	java/io/IOException
              //   270	274	315	java/io/IOException
              //   43	67	319	finally
              //   70	76	319	finally
              //   84	91	319	finally
              //   99	123	319	finally
              //   154	176	319	finally
              //   204	234	333	finally
              //   43	67	338	java/lang/Exception
              //   70	76	338	java/lang/Exception
              //   84	91	338	java/lang/Exception
              //   154	176	338	java/lang/Exception
              //   17	40	343	java/io/FileNotFoundException
            }
          });
        }
        AppMethodBeat.o(20143);
      }
    });
    a("wechat.shell.DUMP_HPROF", new b()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20144);
        if ((!bu.eGT()) && (!bu.eEO()))
        {
          ad.e("MicroMsg.Shell", "not coolassist or monkey env, disable hprof dump cmd.");
          AppMethodBeat.o(20144);
          return;
        }
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("process_suffix");
        if (bt.isNullOrNil(paramAnonymousIntent))
        {
          if (!aj.cbv()) {
            AppMethodBeat.o(20144);
          }
        }
        else
        {
          if (!paramAnonymousIntent.startsWith(":"))
          {
            ad.e("MicroMsg.Shell", "bad process suffix: %s", new Object[] { paramAnonymousIntent });
            AppMethodBeat.o(20144);
            return;
          }
          if (!aj.getProcessName().endsWith(paramAnonymousIntent))
          {
            AppMethodBeat.o(20144);
            return;
          }
        }
        paramAnonymousIntent = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aih() + "hprofs");
        if (!paramAnonymousIntent.exists()) {
          paramAnonymousIntent.mkdirs();
        }
        paramAnonymousIntent = new com.tencent.mm.vfs.e(paramAnonymousIntent, aj.getProcessName().replace(".", "_").replace(":", "_") + "_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".hprof");
        try
        {
          Debug.dumpHprofData(q.B(paramAnonymousIntent.fhU()));
          Toast.makeText(aj.getContext(), "Done.", 1).show();
          AppMethodBeat.o(20144);
          return;
        }
        catch (IOException paramAnonymousIntent)
        {
          ad.printErrStackTrace("MicroMsg.Shell", paramAnonymousIntent, "dump hprof failed.", new Object[0]);
          Toast.makeText(aj.getContext(), "Failure.", 1).show();
          AppMethodBeat.o(20144);
        }
      }
    });
    a("wechat.shell.HOOK_ALL", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20145);
        if ((!bu.eGT()) && (!bu.eEO()))
        {
          ad.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20145);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K("<cmd>\n\t<diagnostic>\n\t\t<MemoryHook\n\t\t\tenable='1'\n\t\t\tmultiprocess='0'\n\t\t\tduration='24'\n\t\t\thook='.*\\.so$'\n\t\t\tstack='0'\n\t\t\tmin='0'\n\t\t\tmax='0'\n\t\t\tforce='1'\n\t\t\tenableExpt='0'\n\t\t\tsampling='1'/>\n\t</diagnostic>\n</cmd>", "cmd"));
        Toast.makeText(aj.getContext(), "Hook ALL .*\\.so", 0).show();
        AppMethodBeat.o(20145);
      }
    });
    a("wechat.shell.HOOK_MM", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20146);
        if ((!bu.eGT()) && (!bu.eEO()))
        {
          ad.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20146);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K("<cmd>\n\t<diagnostic>\n\t\t<MemoryHook\n\t\t\tenable='1'\n\t\t\tmultiprocess='0'\n\t\t\tduration='24'\n\t\t\thook='.*com\\.tencent\\.mm.*\\.so$'\n\t\t\tstack='0'\n\t\t\tmin='0'\n\t\t\tmax='0'\n\t\t\tforce='1'\n\t\t\tenableExpt='0'\n\t\t\tsampling='1'/>\n\t</diagnostic>\n</cmd>", "cmd"));
        Toast.makeText(aj.getContext(), "Hook MM so", 0).show();
        AppMethodBeat.o(20146);
      }
    });
    a("wechat.shell.HOOK_DISABLE", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20147);
        if ((!bu.eGT()) && (!bu.eEO()))
        {
          ad.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20147);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K("<cmd>\n\t<diagnostic>\n\t\t<MemoryHook\n\t\t\tenable='0'\n\t\t\tenableExpt='0'\n\t\t\tforce='1'/>\n\t</diagnostic>\n</cmd>", "cmd"));
        Toast.makeText(aj.getContext(), "Hook Disable", 0).show();
        AppMethodBeat.o(20147);
      }
    });
    a("wechat.shell.HOOK_REPORT", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20148);
        if ((!bu.eGT()) && (!bu.eEO()))
        {
          ad.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20148);
          return;
        }
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K("<cmd>\n\t<diagnostic>\n\t\t<report>\n\t\t\t<memory/>\n\t\t</report>\n\t</diagnostic>\n</cmd>", "cmd"));
        Toast.makeText(aj.getContext(), "Hook report", 0).show();
        AppMethodBeat.o(20148);
      }
    });
    a("wechat.shell.MEMORY_HOOK", new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20149);
        if ((!bu.eGT()) && (!bu.eEO()))
        {
          ad.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
          AppMethodBeat.o(20149);
          return;
        }
        paramAnonymousIntent = "<cmd><diagnostic><MemoryHook enable='" + Shell.ae(paramAnonymousIntent.getStringExtra("enable"), "0") + "' multiprocess='" + Shell.ae(paramAnonymousIntent.getStringExtra("multiprocess"), "0") + "' duration='" + Shell.ae(paramAnonymousIntent.getStringExtra("duration"), "1") + "' hook='" + Shell.ae(paramAnonymousIntent.getStringExtra("hook"), ".*com\\.tencent\\.mm.*\\.so$") + "' ignore='" + Shell.ae(paramAnonymousIntent.getStringExtra("ignore"), "") + "' stack='" + Shell.ae(paramAnonymousIntent.getStringExtra("stack"), "0") + "' min='" + Shell.ae(paramAnonymousIntent.getStringExtra("min"), "0") + "' max='" + Shell.ae(paramAnonymousIntent.getStringExtra("max"), "0") + "' force='" + Shell.ae(paramAnonymousIntent.getStringExtra("force"), "0") + "' sampling='" + Shell.ae(paramAnonymousIntent.getStringExtra("sampling"), "1") + "' extreme='" + Shell.ae(paramAnonymousIntent.getStringExtra("extreme"), "0") + "' mmap='" + Shell.ae(paramAnonymousIntent.getStringExtra("mmap"), "0") + "'/></diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K(paramAnonymousIntent, "cmd"));
        Toast.makeText(aj.getContext(), paramAnonymousIntent, 0).show();
        AppMethodBeat.o(20149);
      }
    });
    a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.akk(""), new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20150);
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' network='any' />", new Object[] { com.tencent.mm.plugin.performance.a.b.akk("©¥¶£ê¯¥§»") }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K(paramAnonymousIntent, "cmd"));
        Toast.makeText(aj.getContext(), "Diag op1 triggered.", 1).show();
        AppMethodBeat.o(20150);
      }
    });
    a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.akk(""), new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20151);
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' network='any' />", new Object[] { com.tencent.mm.plugin.performance.a.b.akk("©¥¶£ê¶¥§»") }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K(paramAnonymousIntent, "cmd"));
        Toast.makeText(aj.getContext(), "Diag op2 triggered.", 1).show();
        AppMethodBeat.o(20151);
      }
    });
    a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.akk(""), new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20152);
        paramAnonymousIntent = bt.nullAsNil(paramAnonymousIntent.getStringExtra("name_regex"));
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' name_regex='%s' network='any' />", new Object[] { com.tencent.mm.plugin.performance.a.b.akk("§§´¥ì±¬"), paramAnonymousIntent }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K(paramAnonymousIntent, "cmd"));
        Toast.makeText(aj.getContext(), "Diag op3 triggered.", 1).show();
        AppMethodBeat.o(20152);
      }
    });
    a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.akk(""), new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20154);
        paramAnonymousIntent = bt.nullAsNil(paramAnonymousIntent.getStringExtra("process"));
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' process='%s' network='any' />", new Object[] { com.tencent.mm.plugin.performance.a.b.akk("­ ²°"), paramAnonymousIntent }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K(paramAnonymousIntent, "cmd"));
        Toast.makeText(aj.getContext(), "Diag op4 triggered.", 1).show();
        AppMethodBeat.o(20154);
      }
    });
    a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.akk(""), new a()
    {
      public final void s(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(20155);
        paramAnonymousIntent = bt.nullAsNil(paramAnonymousIntent.getStringExtra("process"));
        paramAnonymousIntent = "<cmd><diagnostic>" + String.format("<fetch target='%s' process='%s' network='any' />", new Object[] { com.tencent.mm.plugin.performance.a.b.akk("´­ ²°"), paramAnonymousIntent }) + "</diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.urg.an(bw.K(paramAnonymousIntent, "cmd"));
        Toast.makeText(aj.getContext(), "Diag op5 triggered.", 1).show();
        AppMethodBeat.o(20155);
      }
    });
    fHM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20156);
        ad.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() });
        Object[] arrayOfObject = new Object[1];
        throw new NullPointerException();
      }
    };
    AppMethodBeat.o(20168);
  }
  
  private static void a(String paramString, a parama)
  {
    AppMethodBeat.i(20165);
    fHL.addAction(paramString);
    fHK.put(paramString, parama);
    AppMethodBeat.o(20165);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(20166);
    if (this.fHJ == null)
    {
      this.fHJ = new Receiver();
      paramContext.registerReceiver(this.fHJ, fHL);
    }
    AppMethodBeat.o(20166);
  }
  
  public static class Receiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(20164);
      paramContext = paramIntent.getAction();
      Shell.a locala = (Shell.a)Shell.Zg().get(paramContext);
      if (locala == null)
      {
        ad.e("MicroMsg.Shell", "no action found for %s", new Object[] { paramContext });
        AppMethodBeat.o(20164);
        return;
      }
      if ((!aj.cbe()) && (!(locala instanceof Shell.b)))
      {
        ad.e("MicroMsg.Shell", "action[%s] can only run in mm process", new Object[] { paramContext });
        AppMethodBeat.o(20164);
        return;
      }
      ad.e("MicroMsg.Shell", "shell action %s", new Object[] { paramContext });
      locala.s(paramIntent);
      AppMethodBeat.o(20164);
    }
  }
  
  public static abstract interface a
  {
    public abstract void s(Intent paramIntent);
  }
  
  public static abstract interface b
    extends Shell.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell
 * JD-Core Version:    0.7.0.1
 */