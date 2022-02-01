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
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
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
  private static String dlA;
  private static final long iHA;
  private static a iHv;
  private static final String iHw;
  private static final String iHx;
  private static SimpleDateFormat sDateFormat;
  long[] dlF;
  private long iHB;
  private long iHC;
  private long iHD;
  private long iHE;
  private long iHF;
  private long iHG;
  private long iHH;
  private int iHI;
  private int iHJ;
  private int iHK;
  private Long[] iHL;
  private long iHM;
  private long iHN;
  private String iHO;
  private LinkedList<Object> iHP;
  private long iHy;
  private volatile boolean iHz;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(20436);
    iHw = b.aKB() + "/trace/";
    iHx = iHw + "Handler.trace";
    iHA = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    dlA = "";
    AppMethodBeat.o(20436);
  }
  
  private a()
  {
    AppMethodBeat.i(20425);
    this.dlF = new long[] { 0L, 0L, 0L };
    this.iHy = 0L;
    this.iHz = false;
    this.iHB = 8000L;
    this.iHC = 800L;
    this.iHD = 25600L;
    this.iHE = 35840L;
    this.iHF = 86400000L;
    this.iHG = 180000L;
    this.iHH = 5000L;
    this.iHI = 120;
    this.iHJ = 50;
    this.iHK = 1800000;
    this.sp = MMApplicationContext.getDefaultPreference();
    this.iHL = new Long[18];
    this.iHM = 0L;
    this.iHN = 0L;
    this.iHO = "";
    this.iHP = new LinkedList();
    this.iHB = this.sp.getLong("handler_debug_log_time", 8000L);
    this.iHC = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.iHD = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.iHE = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.iHF = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.iHN = bg.aAk().getLooper().getThread().getId();
    Arrays.fill(this.iHL, Long.valueOf(0L));
    AppMethodBeat.o(20425);
  }
  
  /* Error */
  private static String Lh(String paramString)
  {
    // Byte code:
    //   0: sipush 20429
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 225	com/tencent/mm/vfs/o
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 226	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 232	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
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
    //   38: invokestatic 250	com/tencent/mm/ci/e:cL	([B)[B
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
  
  public static a aXx()
  {
    AppMethodBeat.i(20426);
    if (iHv == null) {}
    try
    {
      if (iHv == null) {
        iHv = new a();
      }
      a locala = iHv;
      AppMethodBeat.o(20426);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(20426);
    }
  }
  
  private void h(o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(169693);
    if (paramo.exists())
    {
      long l;
      if (paramo.length() > this.iHD)
      {
        bool1 = true;
        this.iHz = bool1;
        if (!this.iHz) {
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
      this.iHz = false;
    }
    label140:
    AppMethodBeat.o(169693);
  }
  
  final String aXy()
  {
    AppMethodBeat.i(20428);
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
      localObject2 = new StatFs(b.aKD());
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getMemoryClass()), com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), b.aKD(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      localPrintStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0L) - this.sp.getLong("handler_trace_log_file_create_time", 0L))));
      if (this.dlF[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.dlF[0] + " data size=" + this.dlF[1] + " code size=" + this.dlF[2]);
      }
      localObject1 = v.bev().tJ(21);
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
  
  public final void aXz()
  {
    AppMethodBeat.i(20431);
    Log.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.iHB = this.sp.getLong("handler_debug_log_time", 8000L);
    this.iHC = this.sp.getLong("handler_debug_log_time_main", 800L);
    this.iHD = this.sp.getLong("handler_trace_file_full_size", 25600L);
    this.iHE = this.sp.getLong("handler_log_file_max_size", 35840L);
    this.iHF = this.sp.getLong("handler_upload_time_interval", 86400000L);
    this.iHG = this.sp.getLong("handler_worker_assert_time", 180000L);
    this.iHH = this.sp.getLong("handler_worker_warn_time", 5000L);
    this.iHI = ((int)this.sp.getLong("handler_worker_warn_task_max_size", 120L));
    this.iHJ = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 50L));
    this.iHK = ((int)this.sp.getLong("handler_worker_warn_task_keep_size", 1800000L));
    h(new o(iHx));
    AppMethodBeat.o(20431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.a
 * JD-Core Version:    0.7.0.1
 */