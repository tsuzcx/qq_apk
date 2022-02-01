package com.tencent.mm.model.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.s;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class b
  implements c.a
{
  public static List<String> opC;
  public static List<String> opD;
  private static Boolean opE;
  private static b opr;
  public static final String ops;
  long[] hhb;
  private long ooY;
  public volatile boolean ooZ;
  private long opA;
  private long opB;
  public long opt;
  public long opu;
  public long opv;
  public long opw;
  public long opx;
  private long opy;
  private long opz;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20462);
    ops = com.tencent.mm.loader.i.b.bmr() + "/trace/";
    opC = Arrays.asList(new String[] { "FTS5IndexMicroMsg_encrypt.db" });
    opD = Arrays.asList(new String[] { "rcontact", "rconversation" });
    opE = null;
    AppMethodBeat.o(20462);
  }
  
  public b()
  {
    AppMethodBeat.i(20441);
    this.ooZ = false;
    this.hhb = new long[] { 0L, 0L, 0L };
    this.ooY = 0L;
    this.sp = MMApplicationContext.getDefaultPreference();
    bEA();
    AppMethodBeat.o(20441);
  }
  
  /* Error */
  public static String KC(String paramString)
  {
    // Byte code:
    //   0: sipush 20445
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 119	com/tencent/mm/vfs/u
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 122	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 128	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 134	java/io/InputStream:available	()I
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 138	java/io/InputStream:read	([B)I
    //   32: pop
    //   33: new 71	java/lang/String
    //   36: dup
    //   37: aload_1
    //   38: invokestatic 144	com/tencent/mm/model/c/d:at	([B)[B
    //   41: invokespecial 147	java/lang/String:<init>	([B)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 150	java/io/InputStream:close	()V
    //   53: sipush 20445
    //   56: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: ldc 152
    //   64: aload_0
    //   65: ldc 154
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -21 -> 53
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 150	java/io/InputStream:close	()V
    //   88: sipush 20445
    //   91: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: ldc 152
    //   99: aload_0
    //   100: ldc 154
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -21 -> 88
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 150	java/io/InputStream:close	()V
    //   123: sipush 20445
    //   126: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: ldc 152
    //   134: aload_0
    //   135: ldc 154
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto -21 -> 123
    //   147: astore_1
    //   148: goto -33 -> 115
    //   151: astore_1
    //   152: goto -72 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   26	34	1	localObject1	Object
    //   112	18	1	localObject2	Object
    //   147	1	1	localObject3	Object
    //   151	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   49	53	61	java/lang/Exception
    //   15	20	77	java/io/IOException
    //   84	88	96	java/lang/Exception
    //   15	20	112	finally
    //   119	123	131	java/lang/Exception
    //   20	45	147	finally
    //   20	45	151	java/io/IOException
  }
  
  private static long a(String paramString, com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(20446);
    paramString = paramh.rawQuery("select count(*) from ".concat(String.valueOf(paramString)), null, 2);
    long l = 0L;
    if (paramString.moveToFirst()) {
      l = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(20446);
    return l;
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh, PrintStream paramPrintStream, List<String> paramList)
  {
    AppMethodBeat.i(20448);
    if ((paramh == null) || (!paramh.isOpen()))
    {
      Log.i("MicroMsg.SQLTraceManager", "db is not open!");
      AppMethodBeat.o(20448);
      return;
    }
    long l = System.currentTimeMillis();
    if ((paramList != null) && (paramList.size() > 0)) {
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramPrintStream.println("#table : " + str + " count=" + a(str, paramh));
      continue;
      paramList = paramh.rawQuery("select name from sqlite_master where type='table' ", null, 2);
      while (paramList.moveToNext())
      {
        str = paramList.getString(0);
        paramPrintStream.println("#table : " + str + " count=" + a(str, paramh));
      }
      paramList.close();
    }
    Log.i("MicroMsg.SQLTraceManager", "dump all table count last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20448);
  }
  
  private void a(com.tencent.mm.vfs.u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(169698);
    Log.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramu.jKS())
    {
      if (paramBoolean) {
        paramu.diJ();
      }
    }
    else {
      i(paramu);
    }
    h(paramu);
    AppMethodBeat.o(169698);
  }
  
  public static void a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(20449);
    paramStringBuilder.append(paramString1).append(":").append(paramString2).append(" ");
    AppMethodBeat.o(20449);
  }
  
  private static String aCz()
  {
    AppMethodBeat.i(20451);
    String str2 = bg.okT.aM("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bg.okT.aM("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(20451);
    return str1;
  }
  
  private void bEA()
  {
    AppMethodBeat.i(20442);
    this.opt = this.sp.getLong("sql_trace_main_thread_select_interval_time", 300L);
    this.opu = this.sp.getLong("sql_trace_main_thread_update_interval_time", 500L);
    this.opv = this.sp.getLong("sql_trace_select_interval_frozen_time", 1000L);
    this.opw = this.sp.getLong("sql_trace_child_thread_interval_time", 1500L);
    long l = dL(MMApplicationContext.getContext());
    if (l > 0L)
    {
      this.opt += l;
      this.opu += l;
      this.opw += l;
      this.opv += l;
      Log.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[] { Long.valueOf(l) });
    }
    this.opx = this.sp.getLong("sql_trace_child_transaction_interval_time", 5000L);
    this.opB = this.sp.getLong("sql_trace_file_full_size", 30720L);
    this.opy = this.sp.getLong("sql_trace_log_file_max_size", 35840L);
    this.opz = this.sp.getLong("sql_trace_upload_file_min_size", 10240L);
    this.opA = this.sp.getLong("sql_upload_time_interval", 21600000L);
    h(new com.tencent.mm.vfs.u(ops, "MMSQL.trace"));
    Log.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d %d", new Object[] { Long.valueOf(this.opt), Long.valueOf(this.opu), Long.valueOf(this.opw), Long.valueOf(this.opx), Long.valueOf(this.opB), Long.valueOf(this.opy), Long.valueOf(this.opz), Long.valueOf(this.opA), Long.valueOf(this.opv) });
    AppMethodBeat.o(20442);
  }
  
  public static boolean bEB()
  {
    AppMethodBeat.i(242103);
    if (opE == null) {}
    try
    {
      opE = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztw, false));
      Log.i("MicroMsg.SQLTraceManager", "isSQLFrozenTraceOn!!");
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        opE = Boolean.TRUE;
      }
      boolean bool = opE.booleanValue();
      AppMethodBeat.o(242103);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SQLTraceManager", localException, "isSQLFrozenTraceOn", new Object[0]);
        opE = Boolean.FALSE;
      }
    }
  }
  
  private String bEx()
  {
    AppMethodBeat.i(20447);
    Object localObject1 = q.aPg();
    Object localObject2 = p.getString(((String)localObject1).hashCode());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + com.tencent.mm.protocal.d.Yxh);
    localPrintStream.println("#accinfo.revision=" + BuildInfo.REV);
    localPrintStream.println("#accinfo.uin=" + bg.okT.aM("last_login_uin", (String)localObject2));
    localPrintStream.println("#accinfo.dev=".concat(String.valueOf(localObject1)));
    localPrintStream.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
    try
    {
      localObject1 = new StatFs(g.aQa().getPath());
      localObject2 = new StatFs(com.tencent.mm.loader.i.b.bmt());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getMemoryClass()), g.aQa().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), com.tencent.mm.loader.i.b.bmt(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = dL(MMApplicationContext.getContext());
      if (l1 > 0L) {
        localPrintStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(l1)));
      }
      if (dK(MMApplicationContext.getContext()) != 0L)
      {
        long l2 = dK(MMApplicationContext.getContext()) - dJ(MMApplicationContext.getContext());
        localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(l2)));
        if ((l2 > 0L) && (l2 < 28800000L))
        {
          l1 += 100L;
          PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", l1).commit();
          Log.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[] { Long.valueOf(l1) });
          bEA();
        }
        localObject1 = com.tencent.mm.modelpackage.u.bLH().wK(21);
        if ((localObject1 != null) && (localObject1.length != 0) && (localObject1[0] != null)) {
          break label964;
        }
        localPrintStream.println("#traceconfig hardcode");
        if (this.hhb[1] != -1L) {
          localPrintStream.println("#wxpackage :cache size=" + this.hhb[0] + " data size= " + this.hhb[1] + " code size =" + this.hhb[2]);
        }
        localObject1 = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        bh.bCz();
        localPrintStream.println(new com.tencent.mm.vfs.u(com.tencent.mm.model.c.bal()).length());
        localObject1 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        localObject2 = new StringBuilder();
        bh.bCz();
        localPrintStream.println(new com.tencent.mm.vfs.u(((StringBuilder)localObject2).append(com.tencent.mm.model.c.baj()).append("SnsMicroMsg.db").toString()).length());
        bh.bCz();
        a(com.tencent.mm.model.c.bzy(), localPrintStream, Arrays.asList(new String[] { "message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo" }));
        localPrintStream.println("#sql.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        label892:
        String str;
        for (;;)
        {
          localByteArrayOutputStream.close();
          AppMethodBeat.o(20447);
          return localObject1;
          localException1 = localException1;
          Log.e("MicroMsg.SQLTraceManager", "check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
          continue;
          localPrintStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - dJ(MMApplicationContext.getContext())));
        }
        label964:
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label892;
      }
    }
  }
  
  public static b bEz()
  {
    AppMethodBeat.i(20440);
    if (opr == null) {
      opr = new b();
    }
    b localb = opr;
    AppMethodBeat.o(20440);
    return localb;
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(20453);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_report_lastUploadTime", paramLong).commit();
    AppMethodBeat.o(20453);
  }
  
  private static void d(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(169700);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_create_time", paramLong).commit();
    AppMethodBeat.o(169700);
  }
  
  public static long dI(Context paramContext)
  {
    AppMethodBeat.i(20454);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_report_lastUploadTime", 0L);
    AppMethodBeat.o(20454);
    return l;
  }
  
  private static long dJ(Context paramContext)
  {
    AppMethodBeat.i(20455);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_create_time", 0L);
    AppMethodBeat.o(20455);
    return l;
  }
  
  private static long dK(Context paramContext)
  {
    AppMethodBeat.i(20457);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_full_time", 0L);
    AppMethodBeat.o(20457);
    return l;
  }
  
  private static long dL(Context paramContext)
  {
    AppMethodBeat.i(20458);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_autoAdaptaTime", 0L);
    AppMethodBeat.o(20458);
    return l;
  }
  
  private static void e(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(20456);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_full_time", paramLong).commit();
    AppMethodBeat.o(20456);
  }
  
  private void h(com.tencent.mm.vfs.u paramu)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169696);
    if (paramu.jKS())
    {
      long l;
      if (paramu.length() > this.opB)
      {
        bool1 = true;
        this.ooZ = bool1;
        if (!this.ooZ) {
          break label115;
        }
        l = dK(MMApplicationContext.getContext());
        if (l == 0L) {
          break label105;
        }
      }
      label105:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Log.i("MicroMsg.SQLTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          e(MMApplicationContext.getContext(), System.currentTimeMillis());
        }
        AppMethodBeat.o(169696);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.ooZ = false;
    }
    label115:
    AppMethodBeat.o(169696);
  }
  
  private static void i(com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(169699);
    try
    {
      paramu.jKZ();
      d(MMApplicationContext.getContext(), System.currentTimeMillis());
      e(MMApplicationContext.getContext(), 0L);
      AppMethodBeat.o(169699);
      return;
    }
    catch (IOException paramu)
    {
      Log.e("MicroMsg.SQLTraceManager", "recreate log file fail");
      AppMethodBeat.o(169699);
    }
  }
  
  public static void setup()
  {
    AppMethodBeat.i(20443);
    if (MMApplicationContext.sIsRevChange) {
      Log.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(y.deleteFile(ops + "MMSQL.trace"))));
    }
    AppMethodBeat.o(20443);
  }
  
  public final void KE(String paramString)
  {
    AppMethodBeat.i(20450);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new Intent();
    paramString.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    paramString.setAction("uncatch_exception");
    paramString.putExtra("exceptionPid", Process.myPid());
    paramString.putExtra("userName", aCz());
    paramString.putExtra("tag", "SqlTrace");
    paramString.putExtra("exceptionMsg", Base64.encodeToString((bEx() + str).getBytes(), 2));
    MMApplicationContext.getContext().sendBroadcast(paramString);
    AppMethodBeat.o(20450);
  }
  
  public final void bEy()
  {
    AppMethodBeat.i(20459);
    Log.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
    bEA();
    AppMethodBeat.o(20459);
  }
  
  public final void bj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169697);
    if (!e.aPU())
    {
      Log.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
      AppMethodBeat.o(169697);
      return;
    }
    try
    {
      localObject1 = new com.tencent.mm.vfs.u(ops);
      if (!((com.tencent.mm.vfs.u)localObject1).jKS()) {
        ((com.tencent.mm.vfs.u)localObject1).jKY();
      }
      a(new com.tencent.mm.vfs.u(ops, "MMSQL.trace"), false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString1 = y.eA(paramString1, true);
          Object localObject1 = paramString1;
          localObject2 = paramString1;
          paramString1.seek(paramString1.length());
          localObject1 = paramString1;
          localObject2 = paramString1;
          paramString1.write(d.at(paramString2.getBytes()));
        }
        catch (IOException paramString1)
        {
          localObject2 = localException;
          Log.printErrStackTrace("MicroMsg.SQLTraceManager", paramString1, "appendToFile fail with exception", new Object[0]);
          if (localException == null) {
            continue;
          }
          try
          {
            localException.close();
          }
          catch (Exception paramString1)
          {
            Log.printErrStackTrace("MicroMsg.SQLTraceManager", paramString1, "appendToFile fail with exception", new Object[0]);
          }
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label276;
          }
        }
        try
        {
          paramString1.close();
          h(new com.tencent.mm.vfs.u(ops + "MMSQL.trace"));
          AppMethodBeat.o(169697);
          return;
          localException = localException;
          Log.e("MicroMsg.SQLTraceManager", "init dir fail");
        }
        catch (Exception paramString1)
        {
          Log.printErrStackTrace("MicroMsg.SQLTraceManager", paramString1, "appendToFile fail with exception", new Object[0]);
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.u(paramString1);
    if (((com.tencent.mm.vfs.u)localObject1).length() > this.opy)
    {
      Log.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
      a((com.tencent.mm.vfs.u)localObject1, true);
    }
    Object localObject2 = null;
    localObject1 = null;
    try
    {
      ((RandomAccessFile)localObject2).close();
      label276:
      AppMethodBeat.o(169697);
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SQLTraceManager", paramString2, "appendToFile fail with exception", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */