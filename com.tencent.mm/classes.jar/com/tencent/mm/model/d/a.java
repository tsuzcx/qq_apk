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
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.i;
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
  private static final String cIZ;
  private static final String cJa;
  private static String cJb;
  private static a hrh;
  private static final String hri;
  private static final String hrj;
  private static final long hrm;
  private static SimpleDateFormat sDateFormat;
  long[] cJc;
  private String hrA;
  private LinkedList<Object> hrB;
  private long hrk;
  private volatile boolean hrl;
  private long hrn;
  private long hro;
  private long hrp;
  private long hrq;
  private long hrr;
  private long hrs;
  private long hrt;
  private int hru;
  private int hrv;
  private int hrw;
  private Long[] hrx;
  private long hry;
  private long hrz;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20436);
    String str = q.XX();
    cIZ = str;
    cJa = com.tencent.mm.b.p.getString(str.hashCode());
    hri = b.apb() + "/tencent/MicroMsg/Handler/";
    hrj = hri + "Handler.trace";
    hrm = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    cJb = "";
    AppMethodBeat.o(20436);
  }
  
  private a()
  {
    AppMethodBeat.i(20425);
    this.cJc = new long[] { 0L, 0L, 0L };
    this.hrk = 0L;
    this.hrl = false;
    this.hrn = 8000L;
    this.hro = 800L;
    this.hrp = 25600L;
    this.hrq = 35840L;
    this.hrr = 86400000L;
    this.hrs = 180000L;
    this.hrt = 5000L;
    this.hru = 120;
    this.hrv = 50;
    this.hrw = 1800000;
    this.sp = ai.eUY();
    this.hrx = new Long[18];
    this.hry = 0L;
    this.hrz = 0L;
    this.hrA = "";
    this.hrB = new LinkedList();
    this.hrn = this.sp.getLong("handler_debug_log_time", 8000L);
    this.hro = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.hrp = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.hrq = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.hrr = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.hrz = az.agU().GrZ.getLooper().getThread().getId();
    Arrays.fill(this.hrx, Long.valueOf(0L));
    AppMethodBeat.o(20425);
  }
  
  public static a aAs()
  {
    AppMethodBeat.i(20426);
    if (hrh == null) {}
    try
    {
      if (hrh == null) {
        hrh = new a();
      }
      a locala = hrh;
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
      if (parame.length() > this.hrp)
      {
        bool1 = true;
        this.hrl = bool1;
        if (!this.hrl) {
          break label139;
        }
        l = this.sp.getLong("handler_trace_log_file_full_time", 0L);
        if (l == 0L) {
          break label129;
        }
      }
      label129:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ac.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
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
      this.hrl = false;
    }
    label139:
    AppMethodBeat.o(169693);
  }
  
  /* Error */
  private static String yV(String paramString)
  {
    // Byte code:
    //   0: sipush 20429
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 269	com/tencent/mm/vfs/e
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 339	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 345	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 350	java/io/InputStream:available	()I
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 354	java/io/InputStream:read	([B)I
    //   32: pop
    //   33: new 66	java/lang/String
    //   36: dup
    //   37: aload_1
    //   38: invokestatic 360	com/tencent/mm/cj/e:cy	([B)[B
    //   41: invokespecial 363	java/lang/String:<init>	([B)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 366	java/io/InputStream:close	()V
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
    //   69: invokevirtual 366	java/io/InputStream:close	()V
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
    //   88: invokevirtual 366	java/io/InputStream:close	()V
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
  
  final String aAt()
  {
    AppMethodBeat.i(20428);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.DIc);
    localPrintStream.println("#accinfo.revision=" + h.REV);
    localPrintStream.println("#accinfo.uin=" + ay.hnA.aw("last_login_uin", cJa));
    localPrintStream.println("#accinfo.dev=" + cIZ);
    localPrintStream.println("#accinfo.build=" + h.TIME + ":" + h.HOSTNAME + ":" + i.cGY);
    try
    {
      localObject1 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
      Object localObject2 = new StatFs(b.apb());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)ai.getContext().getSystemService("activity")).getMemoryClass()), com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), b.apb(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0L) - this.sp.getLong("handler_trace_log_file_create_time", 0L))));
      if (this.cJc[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.cJc[0] + " data size=" + this.cJc[1] + " code size=" + this.cJc[2]);
      }
      localObject1 = t.aGO().po(21);
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
          ac.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
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
  
  public final void aAu()
  {
    AppMethodBeat.i(20431);
    ac.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.hrn = this.sp.getLong("handler_debug_log_time", 8000L);
    this.hro = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.hrp = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.hrq = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.hrr = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.hrs = this.sp.getLong("handler_worker_assert_time", 180000L);
    this.hrt = this.sp.getLong("handler_worker_warn_time", 5000L);
    this.hru = ((int)this.sp.getLong("handler_worker_warn_task_max_size", 120L));
    this.hrv = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 50L));
    this.hrw = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 1800000L));
    i(new e(hrj));
    AppMethodBeat.o(20431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.a
 * JD-Core Version:    0.7.0.1
 */