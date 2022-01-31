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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
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
  private static final String bYu;
  private static final String bYv;
  public static List<String> fpH;
  private static b fpx;
  public static final String fpy;
  long[] bYy;
  public long fpA;
  public long fpB;
  public long fpC;
  long fpD;
  private long fpE;
  private long fpF;
  private long fpG;
  private long fpc;
  public volatile boolean fpd;
  public long fpz;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(16416);
    String str = q.LK();
    bYu = str;
    bYv = p.getString(str.hashCode());
    fpy = com.tencent.mm.compatible.util.e.eQx + "/tencent/MicroMsg/SQLTrace/";
    fpH = Arrays.asList(new String[] { "FTS5IndexMicroMsg_encrypt.db" });
    AppMethodBeat.o(16416);
  }
  
  public b()
  {
    AppMethodBeat.i(16395);
    this.fpd = false;
    this.bYy = new long[] { 0L, 0L, 0L };
    this.fpc = 0L;
    this.sp = ah.dsQ();
    ace();
    AppMethodBeat.o(16395);
  }
  
  private static String Bm()
  {
    AppMethodBeat.i(16405);
    String str2 = av.flM.Y("login_weixin_username", "");
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = av.flM.Y("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(16405);
    return str1;
  }
  
  private static long a(String paramString, com.tencent.mm.cg.h paramh)
  {
    AppMethodBeat.i(16400);
    paramString = paramh.a("select count(*) from ".concat(String.valueOf(paramString)), null, 2);
    long l = 0L;
    if (paramString.moveToFirst()) {
      l = paramString.getLong(0);
    }
    paramString.close();
    AppMethodBeat.o(16400);
    return l;
  }
  
  private static void a(com.tencent.mm.cg.h paramh, PrintStream paramPrintStream, List<String> paramList)
  {
    AppMethodBeat.i(16402);
    if ((paramh == null) || (!paramh.isOpen()))
    {
      ab.i("MicroMsg.SQLTraceManager", "db is not open!");
      AppMethodBeat.o(16402);
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
    ab.i("MicroMsg.SQLTraceManager", "dump all table count last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(16402);
  }
  
  public static void a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(16403);
    paramStringBuilder.append(paramString1).append(":").append(paramString2).append(" ");
    AppMethodBeat.o(16403);
  }
  
  private String abY()
  {
    AppMethodBeat.i(16401);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.whH);
    localPrintStream.println("#accinfo.revision=" + f.REV);
    localPrintStream.println("#accinfo.uin=" + av.flM.Y("last_login_uin", bYv));
    localPrintStream.println("#accinfo.dev=" + bYu);
    localPrintStream.println("#accinfo.build=" + f.TIME + ":" + f.HOSTNAME + ":" + g.bWu);
    try
    {
      localObject1 = com.tencent.mm.compatible.util.h.getDataDirectory();
      Object localObject2 = new StatFs(((File)localObject1).getPath());
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.eQx);
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ah.getContext().getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), com.tencent.mm.compatible.util.e.eQx, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = bW(ah.getContext());
      if (l1 > 0L) {
        localPrintStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(l1)));
      }
      if (bV(ah.getContext()) != 0L)
      {
        long l2 = bV(ah.getContext()) - bU(ah.getContext());
        localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(l2)));
        if ((l2 > 0L) && (l2 < 28800000L))
        {
          l1 += 100L;
          PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", l1).commit();
          ab.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[] { Long.valueOf(l1) });
          ace();
        }
        localObject1 = r.aiP().lS(21);
        if ((localObject1 != null) && (localObject1.length != 0) && (localObject1[0] != null)) {
          break label961;
        }
        localPrintStream.println("#traceconfig hardcode");
        if (this.bYy[1] != -1L) {
          localPrintStream.println("#wxpackage :cache size=" + this.bYy[0] + " data size= " + this.bYy[1] + " code size =" + this.bYy[2]);
        }
        localObject1 = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        aw.aaz();
        localPrintStream.println(new File(c.Rs()).length());
        localObject1 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        localObject2 = new StringBuilder();
        aw.aaz();
        localPrintStream.println(new File(((StringBuilder)localObject2).append(c.Rp()).append("SnsMicroMsg.db").toString()).length());
        aw.aaz();
        a(c.Yy(), localPrintStream, Arrays.asList(new String[] { "message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo" }));
        localPrintStream.println("#sql.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        label889:
        String str;
        for (;;)
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          AppMethodBeat.o(16401);
          return localObject1;
          localException1 = localException1;
          ab.e("MicroMsg.SQLTraceManager", "check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
          continue;
          localPrintStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - bU(ah.getContext())));
        }
        label961:
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label889;
      }
    }
  }
  
  public static b acd()
  {
    AppMethodBeat.i(16394);
    if (fpx == null) {
      fpx = new b();
    }
    b localb = fpx;
    AppMethodBeat.o(16394);
    return localb;
  }
  
  private void ace()
  {
    AppMethodBeat.i(16396);
    this.fpz = this.sp.getLong("sql_trace_main_thread_select_interval_time", 300L);
    this.fpA = this.sp.getLong("sql_trace_main_thread_update_interval_time", 500L);
    this.fpB = this.sp.getLong("sql_trace_child_thread_interval_time", 1500L);
    long l = bW(ah.getContext());
    if (l > 0L)
    {
      this.fpz += l;
      this.fpA += l;
      this.fpB += l;
      ab.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[] { Long.valueOf(l) });
    }
    this.fpC = this.sp.getLong("sql_trace_child_transaction_interval_time", 5000L);
    this.fpG = this.sp.getLong("sql_trace_file_full_size", 30720L);
    this.fpD = this.sp.getLong("sql_trace_log_file_max_size", 35840L);
    this.fpE = this.sp.getLong("sql_trace_upload_file_min_size", 10240L);
    this.fpF = this.sp.getLong("sql_upload_time_interval", 21600000L);
    w(new File(fpy, "MMSQL.trace"));
    ab.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", new Object[] { Long.valueOf(this.fpz), Long.valueOf(this.fpA), Long.valueOf(this.fpB), Long.valueOf(this.fpC), Long.valueOf(this.fpG), Long.valueOf(this.fpD), Long.valueOf(this.fpE), Long.valueOf(this.fpF) });
    AppMethodBeat.o(16396);
  }
  
  public static long bT(Context paramContext)
  {
    AppMethodBeat.i(16408);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_report_lastUploadTime", 0L);
    AppMethodBeat.o(16408);
    return l;
  }
  
  private static long bU(Context paramContext)
  {
    AppMethodBeat.i(16409);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_create_time", 0L);
    AppMethodBeat.o(16409);
    return l;
  }
  
  private static long bV(Context paramContext)
  {
    AppMethodBeat.i(16411);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_full_time", 0L);
    AppMethodBeat.o(16411);
    return l;
  }
  
  private static long bW(Context paramContext)
  {
    AppMethodBeat.i(16412);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_autoAdaptaTime", 0L);
    AppMethodBeat.o(16412);
    return l;
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(16407);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_report_lastUploadTime", paramLong).commit();
    AppMethodBeat.o(16407);
  }
  
  private static void d(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(16410);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_full_time", paramLong).commit();
    AppMethodBeat.o(16410);
  }
  
  /* Error */
  public static String qa(String paramString)
  {
    // Byte code:
    //   0: sipush 16399
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 310	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 459	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 620	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 622	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 625	java/io/FileInputStream:available	()I
    //   28: newarray byte
    //   30: astore_1
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 629	java/io/FileInputStream:read	([B)I
    //   36: pop
    //   37: new 49	java/lang/String
    //   40: dup
    //   41: aload_1
    //   42: invokestatic 635	com/tencent/mm/ci/e:ch	([B)[B
    //   45: invokespecial 638	java/lang/String:<init>	([B)V
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 639	java/io/FileInputStream:close	()V
    //   53: sipush 16399
    //   56: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: ldc 178
    //   64: aload_0
    //   65: ldc 125
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 643	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -21 -> 53
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 639	java/io/FileInputStream:close	()V
    //   88: sipush 16399
    //   91: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: ldc 178
    //   99: aload_0
    //   100: ldc 125
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 643	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -21 -> 88
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 639	java/io/FileInputStream:close	()V
    //   123: sipush 16399
    //   126: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: ldc 178
    //   134: aload_0
    //   135: ldc 125
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 643	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto -21 -> 123
    //   147: astore_1
    //   148: goto -33 -> 115
    //   151: astore_1
    //   152: goto -72 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   30	30	1	localObject1	Object
    //   112	18	1	localObject2	Object
    //   147	1	1	localObject3	Object
    //   151	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   49	53	61	java/lang/Exception
    //   15	24	77	java/io/IOException
    //   84	88	96	java/lang/Exception
    //   15	24	112	finally
    //   119	123	131	java/lang/Exception
    //   24	49	147	finally
    //   24	49	151	java/io/IOException
  }
  
  public static void setup()
  {
    AppMethodBeat.i(16397);
    if (ah.ynK) {
      ab.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(com.tencent.mm.a.e.deleteFile(fpy + "MMSQL.trace"))));
    }
    AppMethodBeat.o(16397);
  }
  
  public final void abZ()
  {
    AppMethodBeat.i(16413);
    ab.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
    ace();
    AppMethodBeat.o(16413);
  }
  
  final void b(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(16406);
    ab.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramFile.exists())
    {
      if (!paramBoolean) {
        break label87;
      }
      paramFile.delete();
    }
    try
    {
      paramFile.createNewFile();
      Context localContext = ah.getContext();
      long l = System.currentTimeMillis();
      PreferenceManager.getDefaultSharedPreferences(localContext).edit().putLong("sql_trace_log_file_create_time", l).commit();
      d(ah.getContext(), 0L);
      label87:
      w(paramFile);
      AppMethodBeat.o(16406);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SQLTraceManager", "recreate log file fail");
      }
    }
  }
  
  public final void qc(String paramString)
  {
    AppMethodBeat.i(16404);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new Intent();
    paramString.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    paramString.setAction("uncatch_exception");
    paramString.putExtra("exceptionPid", Process.myPid());
    paramString.putExtra("userName", Bm());
    paramString.putExtra("tag", "SqlTrace");
    paramString.putExtra("exceptionMsg", Base64.encodeToString((abY() + str).getBytes(), 2));
    ah.getContext().sendBroadcast(paramString);
    AppMethodBeat.o(16404);
  }
  
  final void w(File paramFile)
  {
    boolean bool2 = true;
    AppMethodBeat.i(16398);
    if (paramFile.exists())
    {
      long l;
      if (paramFile.length() > this.fpG)
      {
        bool1 = true;
        this.fpd = bool1;
        if (!this.fpd) {
          break label115;
        }
        l = bV(ah.getContext());
        if (l == 0L) {
          break label105;
        }
      }
      label105:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ab.i("MicroMsg.SQLTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          d(ah.getContext(), System.currentTimeMillis());
        }
        AppMethodBeat.o(16398);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.fpd = false;
    }
    label115:
    AppMethodBeat.o(16398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.d.b
 * JD-Core Version:    0.7.0.1
 */