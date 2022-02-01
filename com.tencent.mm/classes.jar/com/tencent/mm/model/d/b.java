package com.tencent.mm.model.d;

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
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private static b iHR;
  public static final String iHS;
  public static List<String> iIc;
  public static List<String> iId;
  private static Boolean iIe;
  long[] dlF;
  public long iHT;
  public long iHU;
  public long iHV;
  public long iHW;
  public long iHX;
  private long iHY;
  private long iHZ;
  private long iHy;
  public volatile boolean iHz;
  private long iIa;
  private long iIb;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20462);
    iHS = com.tencent.mm.loader.j.b.aKB() + "/trace/";
    iIc = Arrays.asList(new String[] { "FTS5IndexMicroMsg_encrypt.db" });
    iId = Arrays.asList(new String[] { "rcontact" });
    iIe = null;
    AppMethodBeat.o(20462);
  }
  
  public b()
  {
    AppMethodBeat.i(20441);
    this.iHz = false;
    this.dlF = new long[] { 0L, 0L, 0L };
    this.iHy = 0L;
    this.sp = MMApplicationContext.getDefaultPreference();
    aXB();
    AppMethodBeat.o(20441);
  }
  
  /* Error */
  public static String Lh(String paramString)
  {
    // Byte code:
    //   0: sipush 20445
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 117	com/tencent/mm/vfs/o
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 120	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 126	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 132	java/io/InputStream:available	()I
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 136	java/io/InputStream:read	([B)I
    //   32: pop
    //   33: new 71	java/lang/String
    //   36: dup
    //   37: aload_1
    //   38: invokestatic 142	com/tencent/mm/ci/e:cL	([B)[B
    //   41: invokespecial 145	java/lang/String:<init>	([B)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 148	java/io/InputStream:close	()V
    //   53: sipush 20445
    //   56: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: ldc 150
    //   64: aload_0
    //   65: ldc 152
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -21 -> 53
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 148	java/io/InputStream:close	()V
    //   88: sipush 20445
    //   91: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: ldc 150
    //   99: aload_0
    //   100: ldc 152
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -21 -> 88
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 148	java/io/InputStream:close	()V
    //   123: sipush 20445
    //   126: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: ldc 150
    //   134: aload_0
    //   135: ldc 152
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static String Wv()
  {
    AppMethodBeat.i(20451);
    String str2 = bf.iDu.aA("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bf.iDu.aA("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(20451);
    return str1;
  }
  
  private static long a(String paramString, h paramh)
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
  
  private static void a(h paramh, PrintStream paramPrintStream, List<String> paramList)
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
  
  private void a(o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(169698);
    Log.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramo.exists())
    {
      if (paramBoolean) {
        paramo.delete();
      }
    }
    else {
      i(paramo);
    }
    h(paramo);
    AppMethodBeat.o(169698);
  }
  
  public static void a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(20449);
    paramStringBuilder.append(paramString1).append(":").append(paramString2).append(" ");
    AppMethodBeat.o(20449);
  }
  
  public static b aXA()
  {
    AppMethodBeat.i(20440);
    if (iHR == null) {
      iHR = new b();
    }
    b localb = iHR;
    AppMethodBeat.o(20440);
    return localb;
  }
  
  private void aXB()
  {
    AppMethodBeat.i(20442);
    this.iHT = this.sp.getLong("sql_trace_main_thread_select_interval_time", 300L);
    this.iHU = this.sp.getLong("sql_trace_main_thread_update_interval_time", 500L);
    this.iHV = this.sp.getLong("sql_trace_select_interval_frozen_time", 1000L);
    this.iHW = this.sp.getLong("sql_trace_child_thread_interval_time", 1500L);
    long l = cT(MMApplicationContext.getContext());
    if (l > 0L)
    {
      this.iHT += l;
      this.iHU += l;
      this.iHW += l;
      this.iHV += l;
      Log.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[] { Long.valueOf(l) });
    }
    this.iHX = this.sp.getLong("sql_trace_child_transaction_interval_time", 5000L);
    this.iIb = this.sp.getLong("sql_trace_file_full_size", 30720L);
    this.iHY = this.sp.getLong("sql_trace_log_file_max_size", 35840L);
    this.iHZ = this.sp.getLong("sql_trace_upload_file_min_size", 10240L);
    this.iIa = this.sp.getLong("sql_upload_time_interval", 21600000L);
    h(new o(iHS, "MMSQL.trace"));
    Log.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", new Object[] { Long.valueOf(this.iHT), Long.valueOf(this.iHU), Long.valueOf(this.iHW), Long.valueOf(this.iHX), Long.valueOf(this.iIb), Long.valueOf(this.iHY), Long.valueOf(this.iHZ), Long.valueOf(this.iIa) });
    AppMethodBeat.o(20442);
  }
  
  public static boolean aXC()
  {
    AppMethodBeat.i(231539);
    if (iIe == null) {}
    try
    {
      iIe = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sov, false));
      Log.i("MicroMsg.SQLTraceManager", "isSQLFrozenTraceOn!!");
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        iIe = Boolean.TRUE;
      }
      boolean bool = iIe.booleanValue();
      AppMethodBeat.o(231539);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SQLTraceManager", localException, "isSQLFrozenTraceOn", new Object[0]);
        iIe = Boolean.FALSE;
      }
    }
  }
  
  private String aXy()
  {
    AppMethodBeat.i(20447);
    Object localObject1 = com.tencent.mm.compatible.deviceinfo.q.aoG();
    Object localObject2 = p.getString(((String)localObject1).hashCode());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.KyO);
    localPrintStream.println("#accinfo.revision=" + BuildInfo.REV);
    localPrintStream.println("#accinfo.uin=" + bf.iDu.aA("last_login_uin", (String)localObject2));
    localPrintStream.println("#accinfo.dev=".concat(String.valueOf(localObject1)));
    localPrintStream.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
    try
    {
      localObject1 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
      localObject2 = new StatFs(com.tencent.mm.loader.j.b.aKD());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getMemoryClass()), com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), com.tencent.mm.loader.j.b.aKD(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = cT(MMApplicationContext.getContext());
      if (l1 > 0L) {
        localPrintStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(l1)));
      }
      if (cS(MMApplicationContext.getContext()) != 0L)
      {
        long l2 = cS(MMApplicationContext.getContext()) - cR(MMApplicationContext.getContext());
        localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(l2)));
        if ((l2 > 0L) && (l2 < 28800000L))
        {
          l1 += 100L;
          PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", l1).commit();
          Log.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[] { Long.valueOf(l1) });
          aXB();
        }
        localObject1 = v.bev().tJ(21);
        if ((localObject1 != null) && (localObject1.length != 0) && (localObject1[0] != null)) {
          break label965;
        }
        localPrintStream.println("#traceconfig hardcode");
        if (this.dlF[1] != -1L) {
          localPrintStream.println("#wxpackage :cache size=" + this.dlF[0] + " data size= " + this.dlF[1] + " code size =" + this.dlF[2]);
        }
        localObject1 = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        bg.aVF();
        localPrintStream.println(new o(c.azO()).length());
        localObject1 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        localObject2 = new StringBuilder();
        bg.aVF();
        localPrintStream.println(new o(((StringBuilder)localObject2).append(c.azM()).append("SnsMicroMsg.db").toString()).length());
        bg.aVF();
        a(c.aSL(), localPrintStream, Arrays.asList(new String[] { "message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo" }));
        localPrintStream.println("#sql.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        label893:
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
          localPrintStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - cR(MMApplicationContext.getContext())));
        }
        label965:
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label893;
      }
    }
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(20453);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_report_lastUploadTime", paramLong).commit();
    AppMethodBeat.o(20453);
  }
  
  public static long cQ(Context paramContext)
  {
    AppMethodBeat.i(20454);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_report_lastUploadTime", 0L);
    AppMethodBeat.o(20454);
    return l;
  }
  
  private static long cR(Context paramContext)
  {
    AppMethodBeat.i(20455);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_create_time", 0L);
    AppMethodBeat.o(20455);
    return l;
  }
  
  private static long cS(Context paramContext)
  {
    AppMethodBeat.i(20457);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_full_time", 0L);
    AppMethodBeat.o(20457);
    return l;
  }
  
  private static long cT(Context paramContext)
  {
    AppMethodBeat.i(20458);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_autoAdaptaTime", 0L);
    AppMethodBeat.o(20458);
    return l;
  }
  
  private static void d(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(169700);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_create_time", paramLong).commit();
    AppMethodBeat.o(169700);
  }
  
  private static void e(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(20456);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_full_time", paramLong).commit();
    AppMethodBeat.o(20456);
  }
  
  private void h(o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169696);
    if (paramo.exists())
    {
      long l;
      if (paramo.length() > this.iIb)
      {
        bool1 = true;
        this.iHz = bool1;
        if (!this.iHz) {
          break label115;
        }
        l = cS(MMApplicationContext.getContext());
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
      this.iHz = false;
    }
    label115:
    AppMethodBeat.o(169696);
  }
  
  private static void i(o paramo)
  {
    AppMethodBeat.i(169699);
    try
    {
      paramo.createNewFile();
      d(MMApplicationContext.getContext(), System.currentTimeMillis());
      e(MMApplicationContext.getContext(), 0L);
      AppMethodBeat.o(169699);
      return;
    }
    catch (IOException paramo)
    {
      Log.e("MicroMsg.SQLTraceManager", "recreate log file fail");
      AppMethodBeat.o(169699);
    }
  }
  
  public static void setup()
  {
    AppMethodBeat.i(20443);
    if (MMApplicationContext.sIsRevChange) {
      Log.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(s.deleteFile(iHS + "MMSQL.trace"))));
    }
    AppMethodBeat.o(20443);
  }
  
  public final void Lj(String paramString)
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
    paramString.putExtra("userName", Wv());
    paramString.putExtra("tag", "SqlTrace");
    paramString.putExtra("exceptionMsg", Base64.encodeToString((aXy() + str).getBytes(), 2));
    MMApplicationContext.getContext().sendBroadcast(paramString);
    AppMethodBeat.o(20450);
  }
  
  public final void aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169697);
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      Log.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
      AppMethodBeat.o(169697);
      return;
    }
    try
    {
      localObject1 = new o(iHS);
      if (!((o)localObject1).exists()) {
        ((o)localObject1).mkdirs();
      }
      a(new o(iHS, "MMSQL.trace"), false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString1 = s.dB(paramString1, true);
          Object localObject1 = paramString1;
          localObject2 = paramString1;
          paramString1.seek(paramString1.length());
          localObject1 = paramString1;
          localObject2 = paramString1;
          paramString1.write(com.tencent.mm.ci.e.cL(paramString2.getBytes()));
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
          h(new o(iHS + "MMSQL.trace"));
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
    localObject1 = new o(paramString1);
    if (((o)localObject1).length() > this.iHY)
    {
      Log.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
      a((o)localObject1, true);
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
  
  public final void aXz()
  {
    AppMethodBeat.i(20459);
    Log.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
    aXB();
    AppMethodBeat.o(20459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.b
 * JD-Core Version:    0.7.0.1
 */