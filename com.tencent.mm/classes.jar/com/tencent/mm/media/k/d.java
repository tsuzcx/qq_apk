package com.tencent.mm.media.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gpudetector.JniGPUDetector;
import com.tencent.gpudetector.JniGPUDetector.Companion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", "code", "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "saveGpuDetectorVersion", "saveGpuDeviceModel", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "saveGpuRating", "Companion", "plugin-mediaeditor_release"})
public final class d
{
  public static final a law;
  public MMHandler handler;
  private HandlerThread kVN;
  private c.b lav;
  
  static
  {
    AppMethodBeat.i(263820);
    law = new a((byte)0);
    law.getClass().getClassLoader();
    j.KW("GPUDetector");
    AppMethodBeat.o(263820);
  }
  
  public static final int aVG()
  {
    AppMethodBeat.i(263824);
    int i = law.aVG();
    AppMethodBeat.o(263824);
    return i;
  }
  
  public static final String aVH()
  {
    AppMethodBeat.i(263825);
    Object localObject = law;
    localObject = p.I(((a)localObject).aVJ(), " \n Rating is " + ((a)localObject).aVI());
    AppMethodBeat.o(263825);
    return localObject;
  }
  
  public final void aVE()
  {
    AppMethodBeat.i(263817);
    for (;;)
    {
      try
      {
        if ((a.aVK() == -1) || (a.aVL() == null) || (a.aVM() == null) || ((p.h(JniGPUDetector.Companion.getVersion(), a.aVM()) ^ true)))
        {
          this.kVN = com.tencent.e.c.d.im("GpuDetectorUtil", 5);
          Object localObject1 = this.kVN;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).start();
          }
          localObject1 = this.kVN;
          if (localObject1 == null) {
            break label173;
          }
          localObject1 = ((HandlerThread)localObject1).getLooper();
          this.handler = new MMHandler((Looper)localObject1);
          localObject1 = this.handler;
          if (localObject1 != null)
          {
            ((MMHandler)localObject1).post((Runnable)new b(this));
            AppMethodBeat.o(263817);
            return;
          }
          AppMethodBeat.o(263817);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        AppMethodBeat.o(263817);
        return;
      }
      Log.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
      AppMethodBeat.o(263817);
      return;
      label173:
      Object localObject2 = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_DETECTOR_VERSION", "", "GPU_INFO_DEVICE_MODEL", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "KV_NAME", "TAG", "checkGpuDetectorVersionFormSharePreference", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "queryGpuDeviceModel", "queryGpuRating", "queryGpuRatingWithoutCheck", "showInformation", "spToMMKV", "", "plugin-mediaeditor_release"})
  public static final class a
  {
    static int aVK()
    {
      AppMethodBeat.i(258208);
      int i = aal().getInt("gpu_info_rating", -1);
      if (i == -1) {
        aVN();
      }
      AppMethodBeat.o(258208);
      return i;
    }
    
    static String aVL()
    {
      AppMethodBeat.i(258209);
      String str = aal().getString("gpu_info_device_model", null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          aVN();
        }
        AppMethodBeat.o(258209);
        return str;
      }
    }
    
    static String aVM()
    {
      AppMethodBeat.i(258210);
      String str = aal().getString("gpu_detector_version", null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          aVN();
        }
        AppMethodBeat.o(258210);
        return str;
      }
    }
    
    private static void aVN()
    {
      AppMethodBeat.i(258212);
      MultiProcessMMKV localMultiProcessMMKV = aal();
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
                AppMethodBeat.o(258212);
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
          AppMethodBeat.o(258212);
          return;
        }
        label177:
        continue;
        label182:
        int i = 1;
      }
    }
    
    static MultiProcessMMKV aal()
    {
      AppMethodBeat.i(258211);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_info");
      p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(KV_NAME)");
      AppMethodBeat.o(258211);
      return localMultiProcessMMKV;
    }
    
    public final int aVG()
    {
      AppMethodBeat.i(258206);
      try
      {
        int j = aVK();
        i = j;
        if (j == -1)
        {
          new d().aVE();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
          int i = -1;
        }
      }
      AppMethodBeat.o(258206);
      return i;
    }
    
    public final int aVI()
    {
      AppMethodBeat.i(258205);
      try
      {
        int j = aVK();
        String str1 = aVM();
        String str2 = JniGPUDetector.Companion.getVersion();
        if ((j != -1) && (str1 != null))
        {
          i = j;
          if (!(p.h(str2, str2) ^ true)) {}
        }
        else
        {
          new d().aVE();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
          int i = -1;
        }
      }
      AppMethodBeat.o(258205);
      return i;
    }
    
    public final String aVJ()
    {
      AppMethodBeat.i(258207);
      try
      {
        String str2 = aVL();
        str1 = str2;
        if (str2 == null)
        {
          new d().aVE();
          str1 = str2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
          Object localObject = null;
        }
      }
      AppMethodBeat.o(258207);
      return str1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(258806);
      d.a(this.lax, c.a.a(c.lar, null, 1, 1, null, 16));
      d.aVF();
      MMHandler localMMHandler = d.b(this.lax);
      if (localMMHandler != null) {
        localMMHandler.removeCallbacksAndMessages(null);
      }
      localMMHandler = d.b(this.lax);
      if (localMMHandler != null)
      {
        localMMHandler.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(259426);
            if (d.a(this.lay.lax) != null)
            {
              localObject = c.lar;
              localObject = d.a(this.lay.lax);
              if (localObject == null) {
                p.iCn();
              }
              c.a.a((c.b)localObject);
            }
            Object localObject = d.c(this.lay.lax);
            if (localObject != null)
            {
              ((HandlerThread)localObject).quitSafely();
              AppMethodBeat.o(259426);
              return;
            }
            AppMethodBeat.o(259426);
          }
        });
        AppMethodBeat.o(258806);
        return;
      }
      AppMethodBeat.o(258806);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(260303);
      if (d.a(this.lax) != null)
      {
        localObject = c.lar;
        localObject = d.a(this.lax);
        if (localObject == null) {
          p.iCn();
        }
        c.a.a((c.b)localObject);
      }
      Object localObject = d.c(this.lax);
      if (localObject != null)
      {
        ((HandlerThread)localObject).quitSafely();
        AppMethodBeat.o(260303);
        return;
      }
      AppMethodBeat.o(260303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.k.d
 * JD-Core Version:    0.7.0.1
 */