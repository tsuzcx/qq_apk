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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", "code", "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "saveGpuDetectorVersion", "saveGpuDeviceModel", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "saveGpuRating", "Companion", "plugin-mediaeditor_release"})
public final class d
{
  public static final a ilx;
  public MMHandler handler;
  private HandlerThread igZ;
  private c.b ilw;
  
  static
  {
    AppMethodBeat.i(218808);
    ilx = new a((byte)0);
    ilx.getClass().getClassLoader();
    j.Ed("GPUDetector");
    AppMethodBeat.o(218808);
  }
  
  public static final int aNd()
  {
    AppMethodBeat.i(218810);
    int i = ilx.aNd();
    AppMethodBeat.o(218810);
    return i;
  }
  
  public final void aNb()
  {
    AppMethodBeat.i(218807);
    for (;;)
    {
      try
      {
        if ((a.aNg() == -1) || (a.aNh() == null) || (a.aNi() == null) || ((p.j(JniGPUDetector.Companion.getVersion(), a.aNi()) ^ true)))
        {
          this.igZ = com.tencent.f.c.d.hC("GpuDetectorUtil", 5);
          Object localObject1 = this.igZ;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).start();
          }
          localObject1 = this.igZ;
          if (localObject1 == null) {
            break label167;
          }
          localObject1 = ((HandlerThread)localObject1).getLooper();
          this.handler = new MMHandler((Looper)localObject1);
          localObject1 = this.handler;
          if (localObject1 != null)
          {
            ((MMHandler)localObject1).post((Runnable)new b(this));
            AppMethodBeat.o(218807);
            return;
          }
          AppMethodBeat.o(218807);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        AppMethodBeat.o(218807);
        return;
      }
      Log.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
      AppMethodBeat.o(218807);
      return;
      label167:
      Object localObject2 = null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_DETECTOR_VERSION", "", "GPU_INFO_DEVICE_MODEL", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "KV_NAME", "TAG", "checkGpuDetectorVersionFormSharePreference", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "queryGpuDeviceModel", "queryGpuRating", "queryGpuRatingWithoutCheck", "spToMMKV", "", "plugin-mediaeditor_release"})
  public static final class a
  {
    static MultiProcessMMKV VQ()
    {
      AppMethodBeat.i(218802);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_info");
      p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(KV_NAME)");
      AppMethodBeat.o(218802);
      return localMultiProcessMMKV;
    }
    
    static int aNg()
    {
      AppMethodBeat.i(218799);
      int i = VQ().getInt("gpu_info_rating", -1);
      if (i == -1) {
        aNj();
      }
      AppMethodBeat.o(218799);
      return i;
    }
    
    static String aNh()
    {
      AppMethodBeat.i(218800);
      String str = VQ().getString("gpu_info_device_model", null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          aNj();
        }
        AppMethodBeat.o(218800);
        return str;
      }
    }
    
    static String aNi()
    {
      AppMethodBeat.i(218801);
      String str = VQ().getString("gpu_detector_version", null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          aNj();
        }
        AppMethodBeat.o(218801);
        return str;
      }
    }
    
    private static void aNj()
    {
      AppMethodBeat.i(218803);
      MultiProcessMMKV localMultiProcessMMKV = VQ();
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
                AppMethodBeat.o(218803);
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
          AppMethodBeat.o(218803);
          return;
        }
        label177:
        continue;
        label182:
        int i = 1;
      }
    }
    
    public final int aNd()
    {
      AppMethodBeat.i(218797);
      try
      {
        int j = aNg();
        i = j;
        if (j == -1)
        {
          new d().aNb();
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
      AppMethodBeat.o(218797);
      return i;
    }
    
    public final int aNe()
    {
      AppMethodBeat.i(218796);
      try
      {
        int j = aNg();
        String str1 = aNi();
        String str2 = JniGPUDetector.Companion.getVersion();
        if ((j != -1) && (str1 != null))
        {
          i = j;
          if (!(p.j(str2, str2) ^ true)) {}
        }
        else
        {
          new d().aNb();
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
      AppMethodBeat.o(218796);
      return i;
    }
    
    public final String aNf()
    {
      AppMethodBeat.i(218798);
      try
      {
        String str2 = aNh();
        str1 = str2;
        if (str2 == null)
        {
          new d().aNb();
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
      AppMethodBeat.o(218798);
      return str1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(218805);
      d.a(this.ily, c.a.a(c.ilt, null, 1, 1, null, 16));
      d.aNc();
      MMHandler localMMHandler = d.b(this.ily);
      if (localMMHandler != null) {
        localMMHandler.removeCallbacksAndMessages(null);
      }
      localMMHandler = d.b(this.ily);
      if (localMMHandler != null)
      {
        localMMHandler.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218804);
            if (d.a(this.ilz.ily) != null)
            {
              localObject = c.ilt;
              localObject = d.a(this.ilz.ily);
              if (localObject == null) {
                p.hyc();
              }
              c.a.a((c.b)localObject);
            }
            Object localObject = d.c(this.ilz.ily);
            if (localObject != null)
            {
              ((HandlerThread)localObject).quitSafely();
              AppMethodBeat.o(218804);
              return;
            }
            AppMethodBeat.o(218804);
          }
        });
        AppMethodBeat.o(218805);
        return;
      }
      AppMethodBeat.o(218805);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(218806);
      if (d.a(this.ily) != null)
      {
        localObject = c.ilt;
        localObject = d.a(this.ily);
        if (localObject == null) {
          p.hyc();
        }
        c.a.a((c.b)localObject);
      }
      Object localObject = d.c(this.ily);
      if (localObject != null)
      {
        ((HandlerThread)localObject).quitSafely();
        AppMethodBeat.o(218806);
        return;
      }
      AppMethodBeat.o(218806);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.k.d
 * JD-Core Version:    0.7.0.1
 */