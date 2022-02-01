package com.tencent.mm.plugin.emojicapture.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.b.c;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a
  extends c<a>
{
  private static final String TAG = "MicroMsg.EmojiCameraElementConfig";
  private static boolean pmU;
  public static final a pmV;
  
  static
  {
    AppMethodBeat.i(134);
    pmV = new a();
    TAG = "MicroMsg.EmojiCameraElementConfig";
    pmU = true;
    AppMethodBeat.o(134);
  }
  
  public final int U(String paramString, int paramInt)
  {
    AppMethodBeat.i(133);
    k.h(paramString, "key");
    if (ai.ciE())
    {
      localObject = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
      paramInt = bs.getInt(((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue(paramString), paramInt);
      AppMethodBeat.o(133);
      return paramInt;
    }
    Object localObject = EmojiCaptureProxy.pqx;
    paramInt = bs.getInt(EmojiCaptureProxy.access$getInstance$cp().getDynamicConfig(paramString), paramInt);
    AppMethodBeat.o(133);
    return paramInt;
  }
  
  public final void aqo()
  {
    boolean bool = true;
    AppMethodBeat.i(132);
    ((a)aqm()).gWY = false;
    Object localObject;
    if (bt.eWo())
    {
      if (ai.ciE())
      {
        localObject = (a)aqm();
        bool = m.acB();
        ((a)localObject).gWY = bool;
      }
    }
    else {
      if (!((a)aqm()).gWY) {
        break label164;
      }
    }
    label164:
    for (((a)aqm()).gnN = 720;; ((a)aqm()).gnN = 1080)
    {
      ac.i(TAG, "config resolution:" + ((a)aqm()).gnN + ", useCpuCrop:" + ((a)aqm()).gWY);
      AppMethodBeat.o(132);
      return;
      a locala = (a)aqm();
      localObject = EmojiCaptureProxy.pqx;
      localObject = locala;
      if (EmojiCaptureProxy.access$getInstance$cp().getInt(ah.a.GTe, 1) == 0) {
        break;
      }
      bool = false;
      localObject = locala;
      break;
    }
  }
  
  public final void init()
  {
    boolean bool2 = true;
    AppMethodBeat.i(130);
    bH(new a((byte)0));
    Object localObject = ai.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(130);
      throw ((Throwable)localObject);
    }
    localObject = (ActivityManager)localObject;
    int i = ((ActivityManager)localObject).getLargeMemoryClass();
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.totalMem / 1024L / 1024L;
    int j = ((b)g.ab(b.class)).a(b.a.pRS, 512);
    int k = ((b)g.ab(b.class)).a(b.a.pRR, 2048);
    if ((d.kZ(23)) && (i >= j) && (l >= k))
    {
      bool1 = true;
      pmU = bool1;
      if (!bool1) {
        break label585;
      }
      localObject = com.tencent.mm.plugin.emojicapture.model.e.pny;
      com.tencent.mm.plugin.emojicapture.model.e.cfm();
      label182:
      ac.i(TAG, "checkHighPerformance: device: " + i + ", " + l + "; high: " + j + ", " + k + "; " + pmU);
      if (!pmU) {
        break label596;
      }
      ((a)aqm()).pmW = ((b)g.ab(b.class)).a(b.a.pRT, 640);
      ((a)aqm()).pmX = ((b)g.ab(b.class)).a(b.a.pRU, 1);
      label309:
      i = ae.fJk.fHW;
      j = ae.fJk.fHX;
      if (i != -1)
      {
        ac.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(i)));
        ((a)aqm()).pmW = i;
      }
      if (j != -1)
      {
        ac.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(j)));
        ((a)aqm()).pmX = j;
      }
      ac.i(TAG, "setPreviewConfig: " + ((a)aqm()).pmW + ", " + ((a)aqm()).pmX);
      if (U("VideoRecordUseCpuCrop", 0) != 1) {
        break label655;
      }
      bool1 = true;
      label453:
      i = ae.fJl.fHU;
      ac.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (bool1) {
        ((a)aqm()).gWY = true;
      }
      if (i != -1)
      {
        localObject = (a)aqm();
        if (i != 1) {
          break label661;
        }
      }
    }
    label655:
    label661:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).gWY = bool1;
      ac.i(TAG, "final set useCpuCrop:" + ((a)aqm()).gWY);
      AppMethodBeat.o(130);
      return;
      bool1 = false;
      break;
      label585:
      localObject = com.tencent.mm.plugin.emojicapture.model.e.pny;
      com.tencent.mm.plugin.emojicapture.model.e.cfn();
      break label182;
      label596:
      ((a)aqm()).pmW = ((b)g.ab(b.class)).a(b.a.pRV, 480);
      ((a)aqm()).pmX = ((b)g.ab(b.class)).a(b.a.pRW, 1);
      break label309;
      bool1 = false;
      break label453;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "previewSize", "stickerSampleSize", "useCameraApi2", "(IZIIZ)V", "getPreviewSize", "()I", "setPreviewSize", "(I)V", "getResolution", "setResolution", "getStickerSampleSize", "setStickerSampleSize", "getUseCameraApi2", "()Z", "setUseCameraApi2", "(Z)V", "getUseCpuCrop", "setUseCpuCrop", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-emojicapture_release"})
  public static final class a
  {
    public boolean gWY = false;
    public int gnN = 1080;
    public int pmW = 640;
    int pmX = 1;
    private boolean pmY = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.gnN != paramObject.gnN) || (this.gWY != paramObject.gWY) || (this.pmW != paramObject.pmW) || (this.pmX != paramObject.pmX) || (this.pmY != paramObject.pmY)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(129);
      String str = "CameraPreviewConfig(resolution=" + this.gnN + ", useCpuCrop=" + this.gWY + ", previewSize=" + this.pmW + ", stickerSampleSize=" + this.pmX + ", useCameraApi2=" + this.pmY + ")";
      AppMethodBeat.o(129);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */