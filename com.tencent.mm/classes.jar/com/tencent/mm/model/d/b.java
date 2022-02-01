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
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.t;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final String cIZ;
  private static final String cJa;
  private static b hrD;
  public static final String hrE;
  public static List<String> hrN;
  long[] cJc;
  public long hrF;
  public long hrG;
  public long hrH;
  public long hrI;
  private long hrJ;
  private long hrK;
  private long hrL;
  private long hrM;
  private long hrk;
  public volatile boolean hrl;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20462);
    String str = q.XX();
    cIZ = str;
    cJa = com.tencent.mm.b.p.getString(str.hashCode());
    hrE = com.tencent.mm.loader.j.b.apN();
    hrN = Arrays.asList(new String[] { "FTS5IndexMicroMsg_encrypt.db" });
    AppMethodBeat.o(20462);
  }
  
  public b()
  {
    AppMethodBeat.i(20441);
    this.hrl = false;
    this.cJc = new long[] { 0L, 0L, 0L };
    this.hrk = 0L;
    this.sp = ai.eUY();
    aAw();
    AppMethodBeat.o(20441);
  }
  
  private static String Ky()
  {
    AppMethodBeat.i(20451);
    String str2 = ay.hnA.aw("login_weixin_username", "");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = ay.hnA.aw("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(20451);
    return str1;
  }
  
  private static long a(String paramString, com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(20446);
    paramString = paramh.a("select count(*) from ".concat(String.valueOf(paramString)), null, 2);
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
      ac.i("MicroMsg.SQLTraceManager", "db is not open!");
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
      paramList = paramh.a("select name from sqlite_master where type='table' ", null, 2);
      while (paramList.moveToNext())
      {
        str = paramList.getString(0);
        paramPrintStream.println("#table : " + str + " count=" + a(str, paramh));
      }
      paramList.close();
    }
    ac.i("MicroMsg.SQLTraceManager", "dump all table count last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20448);
  }
  
  private void a(com.tencent.mm.vfs.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(169698);
    ac.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (parame.exists())
    {
      if (paramBoolean) {
        parame.delete();
      }
    }
    else {
      j(parame);
    }
    i(parame);
    AppMethodBeat.o(169698);
  }
  
  public static void a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(20449);
    paramStringBuilder.append(paramString1).append(":").append(paramString2).append(" ");
    AppMethodBeat.o(20449);
  }
  
  private String aAt()
  {
    AppMethodBeat.i(20447);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.DIc);
    localPrintStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.h.REV);
    localPrintStream.println("#accinfo.uin=" + ay.hnA.aw("last_login_uin", cJa));
    localPrintStream.println("#accinfo.dev=" + cIZ);
    localPrintStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.h.TIME + ":" + com.tencent.mm.sdk.platformtools.h.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.i.cGY);
    try
    {
      localObject1 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
      Object localObject2 = new StatFs(com.tencent.mm.loader.j.b.apb());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ai.getContext().getSystemService("activity")).getMemoryClass()), com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), com.tencent.mm.loader.j.b.apb(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = cy(ai.getContext());
      if (l1 > 0L) {
        localPrintStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(l1)));
      }
      if (cx(ai.getContext()) != 0L)
      {
        long l2 = cx(ai.getContext()) - cw(ai.getContext());
        localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(l2)));
        if ((l2 > 0L) && (l2 < 28800000L))
        {
          l1 += 100L;
          PreferenceManager.getDefaultSharedPreferences(ai.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", l1).commit();
          ac.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[] { Long.valueOf(l1) });
          aAw();
        }
        localObject1 = t.aGO().po(21);
        if ((localObject1 != null) && (localObject1.length != 0) && (localObject1[0] != null)) {
          break label960;
        }
        localPrintStream.println("#traceconfig hardcode");
        if (this.cJc[1] != -1L) {
          localPrintStream.println("#wxpackage :cache size=" + this.cJc[0] + " data size= " + this.cJc[1] + " code size =" + this.cJc[2]);
        }
        localObject1 = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        az.ayM();
        localPrintStream.println(new com.tencent.mm.vfs.e(c.agy()).length());
        localObject1 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        localObject2 = new StringBuilder();
        az.ayM();
        localPrintStream.println(new com.tencent.mm.vfs.e(((StringBuilder)localObject2).append(c.agv()).append("SnsMicroMsg.db").toString()).length());
        az.ayM();
        a(c.awz(), localPrintStream, Arrays.asList(new String[] { "message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo" }));
        localPrintStream.println("#sql.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        label888:
        String str;
        for (;;)
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          AppMethodBeat.o(20447);
          return localObject1;
          localException1 = localException1;
          ac.e("MicroMsg.SQLTraceManager", "check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
          continue;
          localPrintStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - cw(ai.getContext())));
        }
        label960:
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label888;
      }
    }
  }
  
  public static b aAv()
  {
    AppMethodBeat.i(20440);
    if (hrD == null) {
      hrD = new b();
    }
    b localb = hrD;
    AppMethodBeat.o(20440);
    return localb;
  }
  
  private void aAw()
  {
    AppMethodBeat.i(20442);
    this.hrF = this.sp.getLong("sql_trace_main_thread_select_interval_time", 300L);
    this.hrG = this.sp.getLong("sql_trace_main_thread_update_interval_time", 500L);
    this.hrH = this.sp.getLong("sql_trace_child_thread_interval_time", 1500L);
    long l = cy(ai.getContext());
    if (l > 0L)
    {
      this.hrF += l;
      this.hrG += l;
      this.hrH += l;
      ac.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[] { Long.valueOf(l) });
    }
    this.hrI = this.sp.getLong("sql_trace_child_transaction_interval_time", 5000L);
    this.hrM = this.sp.getLong("sql_trace_file_full_size", 30720L);
    this.hrJ = this.sp.getLong("sql_trace_log_file_max_size", 35840L);
    this.hrK = this.sp.getLong("sql_trace_upload_file_min_size", 10240L);
    this.hrL = this.sp.getLong("sql_upload_time_interval", 21600000L);
    i(new com.tencent.mm.vfs.e(hrE, "MMSQL.trace"));
    ac.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", new Object[] { Long.valueOf(this.hrF), Long.valueOf(this.hrG), Long.valueOf(this.hrH), Long.valueOf(this.hrI), Long.valueOf(this.hrM), Long.valueOf(this.hrJ), Long.valueOf(this.hrK), Long.valueOf(this.hrL) });
    AppMethodBeat.o(20442);
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(20453);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_report_lastUploadTime", paramLong).commit();
    AppMethodBeat.o(20453);
  }
  
  public static long cv(Context paramContext)
  {
    AppMethodBeat.i(20454);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_report_lastUploadTime", 0L);
    AppMethodBeat.o(20454);
    return l;
  }
  
  private static long cw(Context paramContext)
  {
    AppMethodBeat.i(20455);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_create_time", 0L);
    AppMethodBeat.o(20455);
    return l;
  }
  
  private static long cx(Context paramContext)
  {
    AppMethodBeat.i(20457);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_full_time", 0L);
    AppMethodBeat.o(20457);
    return l;
  }
  
  private static long cy(Context paramContext)
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
  
  private void i(com.tencent.mm.vfs.e parame)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169696);
    if (parame.exists())
    {
      long l;
      if (parame.length() > this.hrM)
      {
        bool1 = true;
        this.hrl = bool1;
        if (!this.hrl) {
          break label115;
        }
        l = cx(ai.getContext());
        if (l == 0L) {
          break label105;
        }
      }
      label105:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ac.i("MicroMsg.SQLTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          e(ai.getContext(), System.currentTimeMillis());
        }
        AppMethodBeat.o(169696);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.hrl = false;
    }
    label115:
    AppMethodBeat.o(169696);
  }
  
  private static void j(com.tencent.mm.vfs.e parame)
  {
    AppMethodBeat.i(169699);
    try
    {
      parame.createNewFile();
      d(ai.getContext(), System.currentTimeMillis());
      e(ai.getContext(), 0L);
      AppMethodBeat.o(169699);
      return;
    }
    catch (IOException parame)
    {
      ac.e("MicroMsg.SQLTraceManager", "recreate log file fail");
      AppMethodBeat.o(169699);
    }
  }
  
  public static void setup()
  {
    AppMethodBeat.i(20443);
    if (ai.GrM) {
      ac.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(com.tencent.mm.vfs.i.deleteFile(hrE + "MMSQL.trace"))));
    }
    AppMethodBeat.o(20443);
  }
  
  /* Error */
  public static String yV(String paramString)
  {
    // Byte code:
    //   0: sipush 20445
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 262	com/tencent/mm/vfs/e
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 678	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 683	java/io/InputStream:available	()I
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 687	java/io/InputStream:read	([B)I
    //   32: pop
    //   33: new 55	java/lang/String
    //   36: dup
    //   37: aload_1
    //   38: invokestatic 692	com/tencent/mm/cj/e:cy	([B)[B
    //   41: invokespecial 695	java/lang/String:<init>	([B)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 696	java/io/InputStream:close	()V
    //   53: sipush 20445
    //   56: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: ldc 177
    //   64: aload_0
    //   65: ldc 119
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -21 -> 53
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 696	java/io/InputStream:close	()V
    //   88: sipush 20445
    //   91: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: ldc 177
    //   99: aload_0
    //   100: ldc 119
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -21 -> 88
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 696	java/io/InputStream:close	()V
    //   123: sipush 20445
    //   126: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: ldc 177
    //   134: aload_0
    //   135: ldc 119
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 700	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void aAu()
  {
    AppMethodBeat.i(20459);
    ac.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
    aAw();
    AppMethodBeat.o(20459);
  }
  
  public final void aQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169697);
    if (!com.tencent.mm.compatible.util.e.YD())
    {
      ac.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
      AppMethodBeat.o(169697);
      return;
    }
    try
    {
      localObject1 = new com.tencent.mm.vfs.e(hrE);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        ((com.tencent.mm.vfs.e)localObject1).mkdirs();
      }
      a(new com.tencent.mm.vfs.e(hrE, "MMSQL.trace"), false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString1 = com.tencent.mm.vfs.i.cY(paramString1, true);
          Object localObject1 = paramString1;
          localObject2 = paramString1;
          paramString1.seek(paramString1.length());
          localObject1 = paramString1;
          localObject2 = paramString1;
          paramString1.write(com.tencent.mm.cj.e.cy(paramString2.getBytes()));
        }
        catch (IOException paramString1)
        {
          localObject2 = localException;
          ac.printErrStackTrace("MicroMsg.SQLTraceManager", paramString1, "appendToFile fail with exception", new Object[0]);
          if (localException == null) {
            continue;
          }
          try
          {
            localException.close();
          }
          catch (Exception paramString1)
          {
            ac.printErrStackTrace("MicroMsg.SQLTraceManager", paramString1, "appendToFile fail with exception", new Object[0]);
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
          i(new com.tencent.mm.vfs.e(hrE + "MMSQL.trace"));
          AppMethodBeat.o(169697);
          return;
          localException = localException;
          ac.e("MicroMsg.SQLTraceManager", "init dir fail");
        }
        catch (Exception paramString1)
        {
          ac.printErrStackTrace("MicroMsg.SQLTraceManager", paramString1, "appendToFile fail with exception", new Object[0]);
        }
      }
    }
    localObject1 = new com.tencent.mm.vfs.e(paramString1);
    if (((com.tencent.mm.vfs.e)localObject1).length() > this.hrJ)
    {
      ac.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
      a((com.tencent.mm.vfs.e)localObject1, true);
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
        ac.printErrStackTrace("MicroMsg.SQLTraceManager", paramString2, "appendToFile fail with exception", new Object[0]);
      }
    }
  }
  
  public final void yX(String paramString)
  {
    AppMethodBeat.i(20450);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new Intent();
    paramString.setClassName(ai.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    paramString.setAction("uncatch_exception");
    paramString.putExtra("exceptionPid", Process.myPid());
    paramString.putExtra("userName", Ky());
    paramString.putExtra("tag", "SqlTrace");
    paramString.putExtra("exceptionMsg", Base64.encodeToString((aAt() + str).getBytes(), 2));
    ai.getContext().sendBroadcast(paramString);
    AppMethodBeat.o(20450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.b
 * JD-Core Version:    0.7.0.1
 */