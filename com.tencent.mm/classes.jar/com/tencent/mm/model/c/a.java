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
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.s;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static String hgV;
  private static a ooV;
  private static final String ooW;
  private static final String ooX;
  private static final long opa;
  private static SimpleDateFormat sDateFormat;
  long[] hhb;
  private long ooY;
  private volatile boolean ooZ;
  private long opb;
  private long opc;
  private long opd;
  private long ope;
  private long opf;
  private long opg;
  private long oph;
  private int opi;
  private int opj;
  private int opk;
  private Long[] opl;
  private long opm;
  private long opn;
  private String opo;
  private LinkedList<Object> opp;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20436);
    ooW = com.tencent.mm.loader.i.b.bmr() + "/trace/";
    ooX = ooW + "Handler.trace";
    opa = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    hgV = "";
    AppMethodBeat.o(20436);
  }
  
  private a()
  {
    AppMethodBeat.i(20425);
    this.hhb = new long[] { 0L, 0L, 0L };
    this.ooY = 0L;
    this.ooZ = false;
    this.opb = 8000L;
    this.opc = 800L;
    this.opd = 25600L;
    this.ope = 35840L;
    this.opf = 86400000L;
    this.opg = 180000L;
    this.oph = 5000L;
    this.opi = 120;
    this.opj = 50;
    this.opk = 1800000;
    this.sp = MMApplicationContext.getDefaultPreference();
    this.opl = new Long[18];
    this.opm = 0L;
    this.opn = 0L;
    this.opo = "";
    this.opp = new LinkedList();
    this.opb = this.sp.getLong("handler_debug_log_time", 8000L);
    this.opc = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.opd = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.ope = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.opf = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.opn = bh.baH().getLooper().getThread().getId();
    Arrays.fill(this.opl, Long.valueOf(0L));
    AppMethodBeat.o(20425);
  }
  
  /* Error */
  private static String KC(String paramString)
  {
    // Byte code:
    //   0: sipush 20429
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 225	com/tencent/mm/vfs/u
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 226	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 232	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 238	java/io/InputStream:available	()I
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 242	java/io/InputStream:read	([B)I
    //   32: pop
    //   33: new 244	java/lang/String
    //   36: dup
    //   37: aload_1
    //   38: invokestatic 250	com/tencent/mm/model/c/d:at	([B)[B
    //   41: invokespecial 253	java/lang/String:<init>	([B)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 256	java/io/InputStream:close	()V
    //   53: sipush 20429
    //   56: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 256	java/io/InputStream:close	()V
    //   72: sipush 20429
    //   75: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 256	java/io/InputStream:close	()V
    //   91: sipush 20429
    //   94: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static a bEw()
  {
    AppMethodBeat.i(20426);
    if (ooV == null) {}
    try
    {
      if (ooV == null) {
        ooV = new a();
      }
      a locala = ooV;
      AppMethodBeat.o(20426);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(20426);
    }
  }
  
  private void h(com.tencent.mm.vfs.u paramu)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169693);
    if (paramu.jKS())
    {
      long l;
      if (paramu.length() > this.opd)
      {
        bool1 = true;
        this.ooZ = bool1;
        if (!this.ooZ) {
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
        Log.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
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
      this.ooZ = false;
    }
    label140:
    AppMethodBeat.o(169693);
  }
  
  final String bEx()
  {
    AppMethodBeat.i(20428);
    Object localObject1 = q.aPg();
    Object localObject2 = p.getString(((String)localObject1).hashCode());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.Yxh);
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
      localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0L) - this.sp.getLong("handler_trace_log_file_create_time", 0L))));
      if (this.hhb[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.hhb[0] + " data size=" + this.hhb[1] + " code size=" + this.hhb[2]);
      }
      localObject1 = com.tencent.mm.modelpackage.u.bLH().wK(21);
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
        label532:
        String str;
        for (;;)
        {
          localByteArrayOutputStream.close();
          AppMethodBeat.o(20428);
          return localObject1;
          localException1 = localException1;
          Log.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
        }
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        break label532;
      }
    }
  }
  
  public final void bEy()
  {
    AppMethodBeat.i(20431);
    Log.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.opb = this.sp.getLong("handler_debug_log_time", 8000L);
    this.opc = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.opd = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.ope = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.opf = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.opg = this.sp.getLong("handler_worker_assert_time", 180000L);
    this.oph = this.sp.getLong("handler_worker_warn_time", 5000L);
    this.opi = ((int)this.sp.getLong("handler_worker_warn_task_max_size", 120L));
    this.opj = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 50L));
    this.opk = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 1800000L));
    h(new com.tencent.mm.vfs.u(ooX));
    AppMethodBeat.o(20431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c.a
 * JD-Core Version:    0.7.0.1
 */