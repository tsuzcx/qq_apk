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
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.t;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class a
  implements c.a
{
  private static final String cVh;
  private static final String cVi;
  private static String cVj;
  private static a hMs;
  private static final String hMt;
  private static final String hMu;
  private static final long hMx;
  private static SimpleDateFormat sDateFormat;
  long[] cVm;
  private long hMA;
  private long hMB;
  private long hMC;
  private long hMD;
  private long hME;
  private int hMF;
  private int hMG;
  private int hMH;
  private Long[] hMI;
  private long hMJ;
  private long hMK;
  private String hML;
  private LinkedList<Object> hMM;
  private long hMv;
  private volatile boolean hMw;
  private long hMy;
  private long hMz;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20436);
    String str = q.aaH();
    cVh = str;
    cVi = com.tencent.mm.b.p.getString(str.hashCode());
    hMt = b.asb() + "/trace/";
    hMu = hMt + "Handler.trace";
    hMx = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    cVj = "";
    AppMethodBeat.o(20436);
  }
  
  private a()
  {
    AppMethodBeat.i(20425);
    this.cVm = new long[] { 0L, 0L, 0L };
    this.hMv = 0L;
    this.hMw = false;
    this.hMy = 8000L;
    this.hMz = 800L;
    this.hMA = 25600L;
    this.hMB = 35840L;
    this.hMC = 86400000L;
    this.hMD = 180000L;
    this.hME = 5000L;
    this.hMF = 120;
    this.hMG = 50;
    this.hMH = 1800000;
    this.sp = ak.fox();
    this.hMI = new Long[18];
    this.hMJ = 0L;
    this.hMK = 0L;
    this.hML = "";
    this.hMM = new LinkedList();
    this.hMy = this.sp.getLong("handler_debug_log_time", 8000L);
    this.hMz = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.hMA = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.hMB = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.hMC = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.hMK = bc.ajU().IxZ.getLooper().getThread().getId();
    Arrays.fill(this.hMI, Long.valueOf(0L));
    AppMethodBeat.o(20425);
  }
  
  /* Error */
  private static String Cw(String paramString)
  {
    // Byte code:
    //   0: sipush 20429
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 254	com/tencent/mm/vfs/k
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 255	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 261	com/tencent/mm/vfs/o:ai	(Lcom/tencent/mm/vfs/k;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 266	java/io/InputStream:available	()I
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 270	java/io/InputStream:read	([B)I
    //   32: pop
    //   33: new 66	java/lang/String
    //   36: dup
    //   37: aload_1
    //   38: invokestatic 276	com/tencent/mm/ci/e:cI	([B)[B
    //   41: invokespecial 279	java/lang/String:<init>	([B)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 282	java/io/InputStream:close	()V
    //   53: sipush 20429
    //   56: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 282	java/io/InputStream:close	()V
    //   72: sipush 20429
    //   75: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 282	java/io/InputStream:close	()V
    //   91: sipush 20429
    //   94: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   26	34	1	localObject1	Object
    //   80	18	1	localObject2	Object
    //   111	1	1	localObject3	Object
    //   115	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   15	20	61	java/io/IOException
    //   15	20	80	finally
    //   49	53	99	java/lang/Exception
    //   68	72	103	java/lang/Exception
    //   87	91	107	java/lang/Exception
    //   20	45	111	finally
    //   20	45	115	java/io/IOException
  }
  
  public static a aDL()
  {
    AppMethodBeat.i(20426);
    if (hMs == null) {}
    try
    {
      if (hMs == null) {
        hMs = new a();
      }
      a locala = hMs;
      AppMethodBeat.o(20426);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(20426);
    }
  }
  
  private void i(com.tencent.mm.vfs.k paramk)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169693);
    if (paramk.exists())
    {
      long l;
      if (paramk.length() > this.hMA)
      {
        bool1 = true;
        this.hMw = bool1;
        if (!this.hMw) {
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
        ae.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          this.sp.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
        }
        AppMethodBeat.o(169693);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.hMw = false;
    }
    label140:
    AppMethodBeat.o(169693);
  }
  
  final String aDM()
  {
    AppMethodBeat.i(20428);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.FFH);
    localPrintStream.println("#accinfo.revision=" + j.REV);
    localPrintStream.println("#accinfo.uin=" + bb.hIK.ay("last_login_uin", cVi));
    localPrintStream.println("#accinfo.dev=" + cVh);
    localPrintStream.println("#accinfo.build=" + j.TIME + ":" + j.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.k.cSM);
    try
    {
      localObject1 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
      Object localObject2 = new StatFs(b.asd());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ak.getContext().getSystemService("activity")).getMemoryClass()), com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), b.asd(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0L) - this.sp.getLong("handler_trace_log_file_create_time", 0L))));
      if (this.cVm[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.cVm[0] + " data size=" + this.cVm[1] + " code size=" + this.cVm[2]);
      }
      localObject1 = t.aKs().pU(21);
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
        label529:
        String str;
        for (;;)
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          AppMethodBeat.o(20428);
          return localObject1;
          localException1 = localException1;
          ae.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
        }
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label529;
      }
    }
  }
  
  public final void aDN()
  {
    AppMethodBeat.i(20431);
    ae.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.hMy = this.sp.getLong("handler_debug_log_time", 8000L);
    this.hMz = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.hMA = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.hMB = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.hMC = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.hMD = this.sp.getLong("handler_worker_assert_time", 180000L);
    this.hME = this.sp.getLong("handler_worker_warn_time", 5000L);
    this.hMF = ((int)this.sp.getLong("handler_worker_warn_task_max_size", 120L));
    this.hMG = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 50L));
    this.hMH = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 1800000L));
    i(new com.tencent.mm.vfs.k(hMu));
    AppMethodBeat.o(20431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.a
 * JD-Core Version:    0.7.0.1
 */