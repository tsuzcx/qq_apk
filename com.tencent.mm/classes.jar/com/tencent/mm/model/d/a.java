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
import com.tencent.mm.bc.o;
import com.tencent.mm.bc.t;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.e;
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
  private static final String cUi;
  private static final String cUj;
  private static String cUk;
  private static final String hJA;
  private static final String hJB;
  private static final long hJE;
  private static a hJz;
  private static SimpleDateFormat sDateFormat;
  long[] cUn;
  private long hJC;
  private volatile boolean hJD;
  private long hJF;
  private long hJG;
  private long hJH;
  private long hJI;
  private long hJJ;
  private long hJK;
  private long hJL;
  private int hJM;
  private int hJN;
  private int hJO;
  private Long[] hJP;
  private long hJQ;
  private long hJR;
  private String hJS;
  private LinkedList<Object> hJT;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20436);
    String str = q.aay();
    cUi = str;
    cUj = com.tencent.mm.b.p.getString(str.hashCode());
    hJA = b.arO() + "/tencent/MicroMsg/Handler/";
    hJB = hJA + "Handler.trace";
    hJE = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    cUk = "";
    AppMethodBeat.o(20436);
  }
  
  private a()
  {
    AppMethodBeat.i(20425);
    this.cUn = new long[] { 0L, 0L, 0L };
    this.hJC = 0L;
    this.hJD = false;
    this.hJF = 8000L;
    this.hJG = 800L;
    this.hJH = 25600L;
    this.hJI = 35840L;
    this.hJJ = 86400000L;
    this.hJK = 180000L;
    this.hJL = 5000L;
    this.hJM = 120;
    this.hJN = 50;
    this.hJO = 1800000;
    this.sp = aj.fkD();
    this.hJP = new Long[18];
    this.hJQ = 0L;
    this.hJR = 0L;
    this.hJS = "";
    this.hJT = new LinkedList();
    this.hJF = this.sp.getLong("handler_debug_log_time", 8000L);
    this.hJG = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.hJH = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.hJI = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.hJJ = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.hJR = ba.ajF().IdO.getLooper().getThread().getId();
    Arrays.fill(this.hJP, Long.valueOf(0L));
    AppMethodBeat.o(20425);
  }
  
  /* Error */
  private static String BU(String paramString)
  {
    // Byte code:
    //   0: sipush 20429
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 254	com/tencent/mm/vfs/e
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 255	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 261	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
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
    //   38: invokestatic 276	com/tencent/mm/cj/e:cF	([B)[B
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
  
  public static a aDv()
  {
    AppMethodBeat.i(20426);
    if (hJz == null) {}
    try
    {
      if (hJz == null) {
        hJz = new a();
      }
      a locala = hJz;
      AppMethodBeat.o(20426);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(20426);
    }
  }
  
  private void i(e parame)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169693);
    if (parame.exists())
    {
      long l;
      if (parame.length() > this.hJH)
      {
        bool1 = true;
        this.hJD = bool1;
        if (!this.hJD) {
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
        ad.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
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
      this.hJD = false;
    }
    label140:
    AppMethodBeat.o(169693);
  }
  
  final String aDw()
  {
    AppMethodBeat.i(20428);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.Fnj);
    localPrintStream.println("#accinfo.revision=" + i.REV);
    localPrintStream.println("#accinfo.uin=" + az.hFS.ax("last_login_uin", cUj));
    localPrintStream.println("#accinfo.dev=" + cUi);
    localPrintStream.println("#accinfo.build=" + i.TIME + ":" + i.HOSTNAME + ":" + j.cSc);
    try
    {
      localObject1 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
      Object localObject2 = new StatFs(b.arO());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)aj.getContext().getSystemService("activity")).getMemoryClass()), com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), b.arO(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0L) - this.sp.getLong("handler_trace_log_file_create_time", 0L))));
      if (this.cUn[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.cUn[0] + " data size=" + this.cUn[1] + " code size=" + this.cUn[2]);
      }
      localObject1 = t.aJZ().pR(21);
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
          ad.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
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
  
  public final void aDx()
  {
    AppMethodBeat.i(20431);
    ad.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.hJF = this.sp.getLong("handler_debug_log_time", 8000L);
    this.hJG = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.hJH = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.hJI = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.hJJ = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.hJK = this.sp.getLong("handler_worker_assert_time", 180000L);
    this.hJL = this.sp.getLong("handler_worker_warn_time", 5000L);
    this.hJM = ((int)this.sp.getLong("handler_worker_warn_task_max_size", 120L));
    this.hJN = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 50L));
    this.hJO = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 1800000L));
    i(new e(hJB));
    AppMethodBeat.o(20431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.a
 * JD-Core Version:    0.7.0.1
 */