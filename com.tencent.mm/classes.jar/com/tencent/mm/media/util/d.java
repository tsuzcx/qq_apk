package com.tencent.mm.media.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.eclipsesource.a.e;
import com.tencent.gpudetector.JniGPUDetector;
import com.tencent.gpudetector.JniGPUDetector.Companion;
import com.tencent.gpudetector.JniGPUDetector.GpuDeviceModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", "code", "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "saveGpuDetectorVersion", "saveGpuDeviceModel", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "saveGpuRating", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a nFC;
  private MMHandler handler;
  private c.b nFD;
  private HandlerThread nty;
  
  static
  {
    AppMethodBeat.i(236974);
    nFC = new a((byte)0);
    nFC.getClass().getClassLoader();
    k.DA("GPUDetector");
    AppMethodBeat.o(236974);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(236935);
    s.u(paramd, "this$0");
    if (paramd.nFD != null)
    {
      Object localObject = c.nFs;
      localObject = paramd.nFD;
      s.checkNotNull(localObject);
      c.a.a((c.b)localObject);
    }
    paramd = paramd.nty;
    if (paramd != null) {
      paramd.quitSafely();
    }
    AppMethodBeat.o(236935);
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(236944);
    s.u(paramd, "this$0");
    paramd.nFD = c.a.a(c.nFs, null, 1, 1, null, 16);
    try
    {
      Object localObject1 = new JniGPUDetector.GpuDeviceModel();
      Object localObject2 = new JniGPUDetector();
      if (((JniGPUDetector)localObject2).GetGPUDeviceModel((JniGPUDetector.GpuDeviceModel)localObject1))
      {
        int i = ((JniGPUDetector.GpuDeviceModel)localObject1).getArch();
        int j = ((JniGPUDetector.GpuDeviceModel)localObject1).getCode();
        int k = ((JniGPUDetector.GpuDeviceModel)localObject1).getNumCores();
        String str1 = ((JniGPUDetector.GpuDeviceModel)localObject1).getName();
        String str2 = ((JniGPUDetector.GpuDeviceModel)localObject1).getVendor();
        String str3 = ((JniGPUDetector.GpuDeviceModel)localObject1).getVersion();
        int m = ((JniGPUDetector)localObject2).getGpuPerfScoreInfo();
        String str4 = JniGPUDetector.Companion.getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject1).getArch());
        h.OAn.a(20128, true, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str1, str2, str3, Integer.valueOf(m), str4 });
        i = ((JniGPUDetector)localObject2).getGpuPerfScoreInfo();
        a.aBP().putInt("gpu_info_rating", i);
        localObject2 = JniGPUDetector.Companion.getVersion();
        a.aBP().putString("gpu_detector_version", (String)localObject2);
        localObject2 = new e();
        ((e)localObject2).o("arch", String.valueOf(((JniGPUDetector.GpuDeviceModel)localObject1).getArch()));
        ((e)localObject2).o("code", String.valueOf(((JniGPUDetector.GpuDeviceModel)localObject1).getCode()));
        ((e)localObject2).o("numCores", String.valueOf(((JniGPUDetector.GpuDeviceModel)localObject1).getNumCores()));
        ((e)localObject2).o("name", ((JniGPUDetector.GpuDeviceModel)localObject1).getName());
        ((e)localObject2).o("vendor", ((JniGPUDetector.GpuDeviceModel)localObject1).getVendor());
        ((e)localObject2).o("version", ((JniGPUDetector.GpuDeviceModel)localObject1).getVersion());
        ((e)localObject2).o("archDetail", JniGPUDetector.Companion.getArchNameDetail(((JniGPUDetector.GpuDeviceModel)localObject1).getArch()));
        a.aBP().putString("gpu_info_device_model", ((e)localObject2).toString());
      }
      localObject1 = paramd.handler;
      if (localObject1 != null) {
        ((MMHandler)localObject1).removeCallbacksAndMessages(null);
      }
      localObject1 = paramd.handler;
      if (localObject1 != null) {
        ((MMHandler)localObject1).post(new d..ExternalSyntheticLambda2(paramd));
      }
      AppMethodBeat.o(236944);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printInfoStack("MicroMsg.GpuDetectorUtil", s.X("Failed to detect GPU ", localException), new Object[0]);
      }
    }
  }
  
  public static final int bqn()
  {
    AppMethodBeat.i(236961);
    int i = nFC.bqn();
    AppMethodBeat.o(236961);
    return i;
  }
  
  public static final int bqo()
  {
    AppMethodBeat.i(236965);
    int i = nFC.bqo();
    AppMethodBeat.o(236965);
    return i;
  }
  
  public static final String bqp()
  {
    AppMethodBeat.i(236967);
    Object localObject = nFC;
    localObject = ((a)localObject).bqq() + " \n Rating is " + ((a)localObject).bqn();
    AppMethodBeat.o(236967);
    return localObject;
  }
  
  private static final void c(d paramd)
  {
    AppMethodBeat.i(236956);
    s.u(paramd, "this$0");
    if (paramd.nFD != null)
    {
      Object localObject = c.nFs;
      localObject = paramd.nFD;
      s.checkNotNull(localObject);
      c.a.a((c.b)localObject);
    }
    paramd = paramd.nty;
    if (paramd != null) {
      paramd.quitSafely();
    }
    AppMethodBeat.o(236956);
  }
  
  public final void bqm()
  {
    AppMethodBeat.i(237017);
    try
    {
      if ((a.bqr() == -1) || (a.bqs() == null) || (a.bqt() == null) || (!s.p(JniGPUDetector.Companion.getVersion(), a.bqt())))
      {
        this.nty = com.tencent.threadpool.c.d.jy("GpuDetectorUtil", 5);
        Object localObject = this.nty;
        if (localObject != null) {
          ((HandlerThread)localObject).start();
        }
        localObject = this.nty;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((HandlerThread)localObject).getLooper())
        {
          this.handler = new MMHandler((Looper)localObject);
          localObject = this.handler;
          if (localObject == null) {
            break;
          }
          ((MMHandler)localObject).post(new d..ExternalSyntheticLambda1(this));
          AppMethodBeat.o(237017);
          return;
        }
      }
      Log.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
      AppMethodBeat.o(237017);
      return;
    }
    catch (Exception localException)
    {
      Log.printInfoStack("MicroMsg.GpuDetectorUtil", s.X("error happened ", localException), new Object[0]);
      AppMethodBeat.o(237017);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(237027);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    localMMHandler = this.handler;
    if ((localMMHandler != null) && (!localMMHandler.isQuit())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localMMHandler = this.handler;
        if (localMMHandler != null) {
          localMMHandler.post(new d..ExternalSyntheticLambda0(this));
        }
      }
      AppMethodBeat.o(237027);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_DETECTOR_VERSION", "", "GPU_INFO_DEVICE_MODEL", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "KV_NAME", "TAG", "checkGpuDetectorVersionFormSharePreference", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "queryGpuDeviceModel", "queryGpuRating", "queryGpuRatingWithoutCheck", "showInformation", "spToMMKV", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static MultiProcessMMKV aBP()
    {
      AppMethodBeat.i(236931);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_info");
      s.s(localMultiProcessMMKV, "getMMKV(KV_NAME)");
      AppMethodBeat.o(236931);
      return localMultiProcessMMKV;
    }
    
    static int bqr()
    {
      AppMethodBeat.i(236923);
      int i = aBP().getInt("gpu_info_rating", -1);
      if (i == -1) {
        bqu();
      }
      AppMethodBeat.o(236923);
      return i;
    }
    
    static String bqs()
    {
      AppMethodBeat.i(236926);
      String str = aBP().getString("gpu_info_device_model", null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          bqu();
        }
        AppMethodBeat.o(236926);
        return str;
      }
    }
    
    static String bqt()
    {
      AppMethodBeat.i(236929);
      String str = aBP().getString("gpu_detector_version", null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          bqu();
        }
        AppMethodBeat.o(236929);
        return str;
      }
    }
    
    private static void bqu()
    {
      AppMethodBeat.i(236936);
      MultiProcessMMKV localMultiProcessMMKV = aBP();
      for (;;)
      {
        try
        {
          Log.i("MicroMsg.GpuDetectorUtil", "spToMMKV: ");
          Object localObject1 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
          i = ((SharedPreferences)localObject1).getInt("gpu_info_rating", -1);
          if (i != -1) {
            localMultiProcessMMKV.putInt("gpu_info_rating", i);
          }
          Object localObject2 = ((SharedPreferences)localObject1).getString("gpu_info_device_model", null);
          CharSequence localCharSequence = (CharSequence)localObject2;
          if (localCharSequence != null)
          {
            if (localCharSequence.length() == 0)
            {
              break label177;
              if (i == 0) {
                localMultiProcessMMKV.putString("gpu_info_device_model", (String)localObject2);
              }
              localObject1 = ((SharedPreferences)localObject1).getString("gpu_detector_version", null);
              localObject2 = (CharSequence)localObject1;
              if (localObject2 == null) {
                break label182;
              }
              if (((CharSequence)localObject2).length() == 0)
              {
                break label182;
                if (i != 0) {
                  continue;
                }
                localMultiProcessMMKV.putString("gpu_detector_version", (String)localObject1);
                AppMethodBeat.o(236936);
              }
            }
            else
            {
              i = 0;
              continue;
            }
            i = 0;
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.GpuDetectorUtil", (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(236936);
          return;
        }
        label177:
        continue;
        label182:
        int i = 1;
      }
    }
    
    public final int bqn()
    {
      AppMethodBeat.i(236941);
      try
      {
        int j = bqr();
        String str1 = bqt();
        String str2 = JniGPUDetector.Companion.getVersion();
        if ((j != -1) && (str1 != null))
        {
          i = j;
          if (s.p(str2, str2)) {}
        }
        else
        {
          new d().bqm();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printInfoStack("MicroMsg.GpuDetectorUtil", s.X("error happened ", localException), new Object[0]);
          int i = -1;
        }
      }
      AppMethodBeat.o(236941);
      return i;
    }
    
    public final int bqo()
    {
      AppMethodBeat.i(236943);
      try
      {
        int j = bqr();
        i = j;
        if (j == -1)
        {
          new d().bqm();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printInfoStack("MicroMsg.GpuDetectorUtil", s.X("error happened ", localException), new Object[0]);
          int i = -1;
        }
      }
      AppMethodBeat.o(236943);
      return i;
    }
    
    public final String bqq()
    {
      AppMethodBeat.i(236946);
      try
      {
        String str2 = bqs();
        str1 = str2;
        if (str2 == null)
        {
          new d().bqm();
          str1 = str2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          Log.printInfoStack("MicroMsg.GpuDetectorUtil", s.X("error happened ", localException), new Object[0]);
          Object localObject = null;
        }
      }
      AppMethodBeat.o(236946);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.media.util.d
 * JD-Core Version:    0.7.0.1
 */