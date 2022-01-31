package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.az.m;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class b
  implements c.a
{
  private static final String bwK;
  private static final String bwL;
  public static List<String> dZC = Arrays.asList(new String[] { "FTS5IndexMicroMsg.db" });
  private static b dZs;
  public static final String dZt;
  long[] bwO = { 0L, 0L, 0L };
  private long dYZ = 0L;
  private long dZA;
  private long dZB;
  public volatile boolean dZa = false;
  public long dZu;
  public long dZv;
  public long dZw;
  public long dZx;
  long dZy;
  private long dZz;
  private SharedPreferences dnD = ae.cqS();
  
  static
  {
    String str = q.zg();
    bwK = str;
    bwL = o.getString(str.hashCode());
    dZt = com.tencent.mm.compatible.util.e.bkF + "/tencent/MicroMsg/SQLTrace/";
  }
  
  public b()
  {
    Jh();
  }
  
  private String Jb()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + com.tencent.mm.protocal.d.spa);
    localPrintStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.d.REV);
    localPrintStream.println("#accinfo.uin=" + at.dVC.L("last_login_uin", bwL));
    localPrintStream.println("#accinfo.dev=" + bwK);
    localPrintStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.d.TIME + ":" + com.tencent.mm.sdk.platformtools.d.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.e.bvj);
    try
    {
      localObject1 = com.tencent.mm.compatible.util.h.getDataDirectory();
      Object localObject2 = new StatFs(((File)localObject1).getPath());
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.bkF);
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ae.getContext().getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), com.tencent.mm.compatible.util.e.bkF, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=" + (String)localObject1);
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = bs(ae.getContext());
      if (l1 > 0L) {
        localPrintStream.println("#logfile.autoAdapteTime :" + l1);
      }
      if (br(ae.getContext()) != 0L)
      {
        long l2 = br(ae.getContext()) - bq(ae.getContext());
        localPrintStream.println("#logfile.fulllast :" + l2);
        if ((l2 > 0L) && (l2 < 28800000L))
        {
          l1 += 100L;
          PreferenceManager.getDefaultSharedPreferences(ae.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", l1).commit();
          y.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[] { Long.valueOf(l1) });
          Jh();
        }
        localObject1 = r.PK().ja(21);
        if ((localObject1 != null) && (localObject1.length != 0) && (localObject1[0] != null)) {
          break label961;
        }
        localPrintStream.println("#traceconfig hardcode");
        if (this.bwO[1] != -1L) {
          localPrintStream.println("#wxpackage :cache size=" + this.bwO[0] + " data size= " + this.bwO[1] + " code size =" + this.bwO[2]);
        }
        localObject1 = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        au.Hx();
        localPrintStream.println(new File(c.Dx()).length());
        localObject1 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        localObject2 = new StringBuilder();
        au.Hx();
        localPrintStream.println(new File(((StringBuilder)localObject2).append(c.FT()).append("SnsMicroMsg.db").toString()).length());
        au.Hx();
        a(c.Fu(), localPrintStream, Arrays.asList(new String[] { "message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo" }));
        localPrintStream.println("#sql.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      String str;
      for (;;)
      {
        label961:
        try
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          return localObject1;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        y.e("MicroMsg.SQLTraceManager", "check data size failed :%s", new Object[] { localException1.getMessage() });
        str = "";
        continue;
        localPrintStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - bq(ae.getContext())));
        continue;
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      return str;
    }
  }
  
  public static b Jg()
  {
    if (dZs == null) {
      dZs = new b();
    }
    return dZs;
  }
  
  private void Jh()
  {
    this.dZu = this.dnD.getLong("sql_trace_main_thread_select_interval_time", 300L);
    this.dZv = this.dnD.getLong("sql_trace_main_thread_update_interval_time", 500L);
    this.dZw = this.dnD.getLong("sql_trace_child_thread_interval_time", 1500L);
    long l = bs(ae.getContext());
    if (l > 0L)
    {
      this.dZu += l;
      this.dZv += l;
      this.dZw += l;
      y.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[] { Long.valueOf(l) });
    }
    this.dZx = this.dnD.getLong("sql_trace_child_transaction_interval_time", 5000L);
    this.dZB = this.dnD.getLong("sql_trace_file_full_size", 30720L);
    this.dZy = this.dnD.getLong("sql_trace_log_file_max_size", 35840L);
    this.dZz = this.dnD.getLong("sql_trace_upload_file_min_size", 10240L);
    this.dZA = this.dnD.getLong("sql_upload_time_interval", 21600000L);
    q(new File(dZt, "MMSQL.trace"));
    y.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", new Object[] { Long.valueOf(this.dZu), Long.valueOf(this.dZv), Long.valueOf(this.dZw), Long.valueOf(this.dZx), Long.valueOf(this.dZB), Long.valueOf(this.dZy), Long.valueOf(this.dZz), Long.valueOf(this.dZA) });
  }
  
  private static long a(String paramString, com.tencent.mm.cf.h paramh)
  {
    paramString = paramh.a("select count(*) from " + paramString, null, 2);
    long l = 0L;
    if (paramString.moveToFirst()) {
      l = paramString.getLong(0);
    }
    paramString.close();
    return l;
  }
  
  private static void a(com.tencent.mm.cf.h paramh, PrintStream paramPrintStream, List<String> paramList)
  {
    if ((paramh == null) || (!paramh.isOpen()))
    {
      y.i("MicroMsg.SQLTraceManager", "db is not open!");
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
    y.i("MicroMsg.SQLTraceManager", "dump all table count last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static void a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramString1).append(":").append(paramString2).append(" ");
  }
  
  public static long bp(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_report_lastUploadTime", 0L);
  }
  
  private static long bq(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_create_time", 0L);
  }
  
  private static long br(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_full_time", 0L);
  }
  
  private static long bs(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_autoAdaptaTime", 0L);
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_report_lastUploadTime", paramLong).commit();
  }
  
  private static void d(Context paramContext, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_full_time", paramLong).commit();
  }
  
  /* Error */
  public static String jm(String paramString)
  {
    // Byte code:
    //   0: new 181	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 590	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 592	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 595	java/io/FileInputStream:available	()I
    //   22: newarray byte
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 599	java/io/FileInputStream:read	([B)I
    //   30: pop
    //   31: new 43	java/lang/String
    //   34: dup
    //   35: aload_1
    //   36: invokestatic 605	com/tencent/mm/ch/e:bH	([B)[B
    //   39: invokespecial 608	java/lang/String:<init>	([B)V
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 609	java/io/FileInputStream:close	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_0
    //   50: ldc_w 296
    //   53: aload_0
    //   54: ldc_w 412
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 613	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_1
    //   65: areturn
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 609	java/io/FileInputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc_w 296
    //   83: aload_0
    //   84: ldc_w 412
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 613	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: goto -17 -> 77
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 609	java/io/FileInputStream:close	()V
    //   108: aload_1
    //   109: athrow
    //   110: astore_0
    //   111: ldc_w 296
    //   114: aload_0
    //   115: ldc_w 412
    //   118: iconst_0
    //   119: anewarray 4	java/lang/Object
    //   122: invokestatic 613	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: goto -17 -> 108
    //   128: astore_1
    //   129: goto -29 -> 100
    //   132: astore_1
    //   133: goto -64 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   24	41	1	localObject1	Object
    //   97	12	1	localObject2	Object
    //   128	1	1	localObject3	Object
    //   132	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/lang/Exception
    //   9	18	66	java/io/IOException
    //   73	77	79	java/lang/Exception
    //   9	18	97	finally
    //   104	108	110	java/lang/Exception
    //   18	43	128	finally
    //   18	43	132	java/io/IOException
  }
  
  public static void setup()
  {
    if (ae.ufk)
    {
      boolean bool = com.tencent.mm.a.e.deleteFile(dZt + "MMSQL.trace");
      y.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + bool);
    }
  }
  
  public final void Jc()
  {
    y.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
    Jh();
  }
  
  final void b(File paramFile, boolean paramBoolean)
  {
    y.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramFile.exists())
    {
      if (!paramBoolean) {
        break label82;
      }
      paramFile.delete();
    }
    try
    {
      paramFile.createNewFile();
      Context localContext = ae.getContext();
      long l = System.currentTimeMillis();
      PreferenceManager.getDefaultSharedPreferences(localContext).edit().putLong("sql_trace_log_file_create_time", l).commit();
      d(ae.getContext(), 0L);
      label82:
      q(paramFile);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SQLTraceManager", "recreate log file fail");
      }
    }
  }
  
  public final void jo(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
    localIntent.setAction("uncatch_exception");
    localIntent.putExtra("exceptionPid", Process.myPid());
    String str2 = at.dVC.L("login_weixin_username", "");
    paramString = str2;
    if (bk.bl(str2)) {
      paramString = at.dVC.L("login_user_name", "never_login_crash");
    }
    localIntent.putExtra("userName", paramString);
    localIntent.putExtra("tag", "SqlTrace");
    localIntent.putExtra("exceptionMsg", Base64.encodeToString((Jb() + str1).getBytes(), 2));
    ae.getContext().startService(localIntent);
  }
  
  final void q(File paramFile)
  {
    boolean bool2 = true;
    if (paramFile.exists())
    {
      long l;
      if (paramFile.length() > this.dZB)
      {
        bool1 = true;
        this.dZa = bool1;
        if (this.dZa)
        {
          l = br(ae.getContext());
          if (l == 0L) {
            break label94;
          }
        }
      }
      label94:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        y.i("MicroMsg.SQLTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          d(ae.getContext(), System.currentTimeMillis());
        }
        return;
        bool1 = false;
        break;
      }
    }
    this.dZa = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.d.b
 * JD-Core Version:    0.7.0.1
 */