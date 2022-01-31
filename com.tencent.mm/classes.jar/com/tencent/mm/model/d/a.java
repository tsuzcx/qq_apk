package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.az.m;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class a
  implements c.a
{
  private static final String bwK;
  private static final String bwL;
  public static String bwM = "";
  private static a dYW;
  private static final String dYX;
  public static final String dYY;
  private static final long dZb;
  private static SimpleDateFormat sDateFormat;
  long[] bwO = { 0L, 0L, 0L };
  private long dYZ = 0L;
  private volatile boolean dZa = false;
  private long dZc = 8000L;
  private long dZd = 800L;
  private long dZe = 25600L;
  private long dZf = 35840L;
  private long dZg = 86400000L;
  private long dZh = 180000L;
  private long dZi = 5000L;
  private int dZj = 120;
  private int dZk = 50;
  private int dZl = 1800000;
  private Long[] dZm = new Long[18];
  public long dZn = 0L;
  private String dZo = "";
  private LinkedList<a.a> dZp = new LinkedList();
  private SharedPreferences dnD = ae.cqS();
  
  static
  {
    String str = q.zg();
    bwK = str;
    bwL = o.getString(str.hashCode());
    dYX = com.tencent.mm.compatible.util.e.bkF + "/tencent/MicroMsg/Handler/";
    dYY = dYX + "Handler.trace";
    dZb = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
  }
  
  private a()
  {
    Arrays.fill(this.dZm, Long.valueOf(0L));
  }
  
  public static a Ja()
  {
    if (dYW == null) {}
    try
    {
      if (dYW == null) {
        dYW = new a();
      }
      return dYW;
    }
    finally {}
  }
  
  private void b(File paramFile, boolean paramBoolean)
  {
    y.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramFile.exists())
    {
      if (!paramBoolean) {
        break label80;
      }
      paramFile.delete();
    }
    try
    {
      paramFile.createNewFile();
      SharedPreferences.Editor localEditor = this.dnD.edit();
      localEditor.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
      localEditor.putLong("handler_trace_log_file_full_time", 0L).commit();
      label80:
      q(paramFile);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
      }
    }
  }
  
  /* Error */
  private static String jm(String paramString)
  {
    // Byte code:
    //   0: new 271	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 272	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 380	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 382	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 385	java/io/FileInputStream:available	()I
    //   22: newarray byte
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 389	java/io/FileInputStream:read	([B)I
    //   30: pop
    //   31: new 57	java/lang/String
    //   34: dup
    //   35: aload_1
    //   36: invokestatic 308	com/tencent/mm/ch/e:bH	([B)[B
    //   39: invokespecial 391	java/lang/String:<init>	([B)V
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 392	java/io/FileInputStream:close	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 392	java/io/FileInputStream:close	()V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 392	java/io/FileInputStream:close	()V
    //   73: aload_1
    //   74: athrow
    //   75: astore_0
    //   76: aload_1
    //   77: areturn
    //   78: astore_0
    //   79: goto -19 -> 60
    //   82: astore_0
    //   83: goto -10 -> 73
    //   86: astore_1
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: goto -39 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString	String
    //   24	24	1	localObject1	Object
    //   62	15	1	str	String
    //   86	1	1	localObject2	Object
    //   90	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	18	49	java/io/IOException
    //   9	18	62	finally
    //   43	47	75	java/lang/Exception
    //   56	60	78	java/lang/Exception
    //   69	73	82	java/lang/Exception
    //   18	43	86	finally
    //   18	43	90	java/io/IOException
  }
  
  private void q(File paramFile)
  {
    boolean bool2 = true;
    if (paramFile.exists())
    {
      long l;
      if (paramFile.length() > this.dZe)
      {
        bool1 = true;
        this.dZa = bool1;
        if (this.dZa)
        {
          l = this.dnD.getLong("handler_trace_log_file_full_time", 0L);
          if (l == 0L) {
            break label118;
          }
        }
      }
      label118:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        y.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          this.dnD.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
        }
        return;
        bool1 = false;
        break;
      }
    }
    this.dZa = false;
  }
  
  final String Jb()
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
      localObject1 = h.getDataDirectory();
      Object localObject2 = new StatFs(((File)localObject1).getPath());
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.bkF);
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ae.getContext().getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), com.tencent.mm.compatible.util.e.bkF, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=" + (String)localObject1);
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = this.dnD.getLong("handler_trace_log_file_full_time", 0L);
      long l2 = this.dnD.getLong("handler_trace_log_file_create_time", 0L);
      localPrintStream.println("#logfile.fulllast :" + (l1 - l2));
      if (this.bwO[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.bwO[0] + " data size=" + this.bwO[1] + " code size=" + this.bwO[2]);
      }
      localObject1 = r.PK().ja(21);
      if ((localObject1 == null) || (localObject1.length == 0) || (localObject1[0] == null))
      {
        localPrintStream.println("#traceconfig hardcode");
        localPrintStream.println("#handler.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      String str;
      for (;;)
      {
        try
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          return localObject1;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        y.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
        str = "";
        continue;
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      return str;
    }
  }
  
  public final void Jc()
  {
    y.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.dZc = this.dnD.getLong("handler_debug_log_time", 8000L);
    this.dZd = this.dnD.getLong("handler_debug_log_time_main", 800L);
    this.dZe = this.dnD.getLong("handler_trace_file_full_size", 25600L);
    this.dZf = this.dnD.getLong("handler_log_file_max_size", 35840L);
    this.dZg = this.dnD.getLong("handler_upload_time_interval", 86400000L);
    this.dZh = this.dnD.getLong("handler_worker_assert_time", 180000L);
    this.dZi = this.dnD.getLong("handler_worker_warn_time", 5000L);
    this.dZj = ((int)this.dnD.getLong("handler_worker_warn_task_max_size", 120L));
    this.dZk = ((int)this.dnD.getLong("handler_worker_warn_task_keep_size", 50L));
    this.dZl = ((int)this.dnD.getLong("handler_worker_warn_task_keep_size", 1800000L));
    q(new File(dYY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.a
 * JD-Core Version:    0.7.0.1
 */