package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
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
  private static final String bYu;
  private static final String bYv;
  public static String bYw;
  private static a foZ;
  private static final String fpa;
  public static final String fpb;
  private static final long fpe;
  private static SimpleDateFormat sDateFormat;
  long[] bYy;
  private long fpc;
  private volatile boolean fpd;
  private long fpf;
  private long fpg;
  private long fph;
  private long fpi;
  private long fpj;
  private long fpk;
  private long fpl;
  private int fpm;
  private int fpn;
  private int fpo;
  private Long[] fpp;
  public long fpq;
  private long fpr;
  private String fpt;
  private LinkedList<a.a> fpu;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(16390);
    String str = q.LK();
    bYu = str;
    bYv = p.getString(str.hashCode());
    fpa = e.eQx + "/tencent/MicroMsg/Handler/";
    fpb = fpa + "Handler.trace";
    fpe = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    bYw = "";
    AppMethodBeat.o(16390);
  }
  
  private a()
  {
    AppMethodBeat.i(16379);
    this.bYy = new long[] { 0L, 0L, 0L };
    this.fpc = 0L;
    this.fpd = false;
    this.fpf = 8000L;
    this.fpg = 800L;
    this.fph = 25600L;
    this.fpi = 35840L;
    this.fpj = 86400000L;
    this.fpk = 180000L;
    this.fpl = 5000L;
    this.fpm = 120;
    this.fpn = 50;
    this.fpo = 1800000;
    this.sp = ah.dsQ();
    this.fpp = new Long[18];
    this.fpq = 0L;
    this.fpr = 0L;
    this.fpt = "";
    this.fpu = new LinkedList();
    this.fpf = this.sp.getLong("handler_debug_log_time", 8000L);
    this.fpg = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.fph = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.fpi = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.fpj = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.fpr = aw.RO().oNc.getLooper().getThread().getId();
    Arrays.fill(this.fpp, Long.valueOf(0L));
    AppMethodBeat.o(16379);
  }
  
  public static a abX()
  {
    AppMethodBeat.i(16380);
    if (foZ == null) {}
    try
    {
      if (foZ == null) {
        foZ = new a();
      }
      a locala = foZ;
      AppMethodBeat.o(16380);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(16380);
    }
  }
  
  private void b(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(16384);
    ab.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramFile.exists())
    {
      if (!paramBoolean) {
        break label86;
      }
      paramFile.delete();
    }
    try
    {
      paramFile.createNewFile();
      SharedPreferences.Editor localEditor = this.sp.edit();
      localEditor.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
      localEditor.putLong("handler_trace_log_file_full_time", 0L).commit();
      label86:
      w(paramFile);
      AppMethodBeat.o(16384);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
      }
    }
  }
  
  /* Error */
  private static String qa(String paramString)
  {
    // Byte code:
    //   0: sipush 16383
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 291	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 416	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 418	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 421	java/io/FileInputStream:available	()I
    //   28: newarray byte
    //   30: astore_1
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 425	java/io/FileInputStream:read	([B)I
    //   36: pop
    //   37: new 64	java/lang/String
    //   40: dup
    //   41: aload_1
    //   42: invokestatic 328	com/tencent/mm/ci/e:ch	([B)[B
    //   45: invokespecial 427	java/lang/String:<init>	([B)V
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 428	java/io/FileInputStream:close	()V
    //   53: sipush 16383
    //   56: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 428	java/io/FileInputStream:close	()V
    //   72: sipush 16383
    //   75: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 428	java/io/FileInputStream:close	()V
    //   91: sipush 16383
    //   94: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    //   99: astore_0
    //   100: goto -47 -> 53
    //   103: astore_0
    //   104: goto -32 -> 72
    //   107: astore_0
    //   108: goto -17 -> 91
    //   111: astore_1
    //   112: goto -29 -> 83
    //   115: astore_1
    //   116: goto -52 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramString	String
    //   30	30	1	localObject1	Object
    //   80	18	1	localObject2	Object
    //   111	1	1	localObject3	Object
    //   115	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   15	24	61	java/io/IOException
    //   15	24	80	finally
    //   49	53	99	java/lang/Exception
    //   68	72	103	java/lang/Exception
    //   87	91	107	java/lang/Exception
    //   24	49	111	finally
    //   24	49	115	java/io/IOException
  }
  
  private void w(File paramFile)
  {
    boolean bool2 = true;
    AppMethodBeat.i(16381);
    if (paramFile.exists())
    {
      long l;
      if (paramFile.length() > this.fph)
      {
        bool1 = true;
        this.fpd = bool1;
        if (!this.fpd) {
          break label140;
        }
        l = this.sp.getLong("handler_trace_log_file_full_time", 0L);
        if (l == 0L) {
          break label130;
        }
      }
      label130:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ab.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          this.sp.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
        }
        AppMethodBeat.o(16381);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.fpd = false;
    }
    label140:
    AppMethodBeat.o(16381);
  }
  
  final String abY()
  {
    AppMethodBeat.i(16382);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.whH);
    localPrintStream.println("#accinfo.revision=" + f.REV);
    localPrintStream.println("#accinfo.uin=" + av.flM.Y("last_login_uin", bYv));
    localPrintStream.println("#accinfo.dev=" + bYu);
    localPrintStream.println("#accinfo.build=" + f.TIME + ":" + f.HOSTNAME + ":" + g.bWu);
    try
    {
      localObject1 = h.getDataDirectory();
      Object localObject2 = new StatFs(((File)localObject1).getPath());
      StatFs localStatFs = new StatFs(e.eQx);
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ah.getContext().getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), e.eQx, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0L) - this.sp.getLong("handler_trace_log_file_create_time", 0L))));
      if (this.bYy[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.bYy[0] + " data size=" + this.bYy[1] + " code size=" + this.bYy[2]);
      }
      localObject1 = r.aiP().lS(21);
      if ((localObject1 == null) || (localObject1.length == 0) || (localObject1[0] == null))
      {
        localPrintStream.println("#traceconfig hardcode");
        localPrintStream.println("#handler.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        label533:
        String str;
        for (;;)
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          AppMethodBeat.o(16382);
          return localObject1;
          localException1 = localException1;
          ab.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
        }
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label533;
      }
    }
  }
  
  public final void abZ()
  {
    AppMethodBeat.i(16385);
    ab.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.fpf = this.sp.getLong("handler_debug_log_time", 8000L);
    this.fpg = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.fph = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.fpi = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.fpj = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.fpk = this.sp.getLong("handler_worker_assert_time", 180000L);
    this.fpl = this.sp.getLong("handler_worker_warn_time", 5000L);
    this.fpm = ((int)this.sp.getLong("handler_worker_warn_task_max_size", 120L));
    this.fpn = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 50L));
    this.fpo = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 1800000L));
    w(new File(fpb));
    AppMethodBeat.o(16385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.d.a
 * JD-Core Version:    0.7.0.1
 */