package com.tencent.mm.plugin.emojicapture.b;

import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.media.b.b;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a
  extends b<a.a>
{
  private static final String TAG = "MicroMsg.EmojiCameraElementConfig";
  private static boolean lsZ;
  public static final a lta;
  
  static
  {
    AppMethodBeat.i(2574);
    lta = new a();
    TAG = "MicroMsg.EmojiCameraElementConfig";
    lsZ = true;
    AppMethodBeat.o(2574);
  }
  
  public final int L(String paramString, int paramInt)
  {
    AppMethodBeat.i(2573);
    j.q(paramString, "key");
    if (ah.brt())
    {
      localObject = g.E(com.tencent.mm.plugin.zero.b.a.class);
      j.p(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
      paramInt = bo.getInt(((com.tencent.mm.plugin.zero.b.a)localObject).Nq().getValue(paramString), paramInt);
      AppMethodBeat.o(2573);
      return paramInt;
    }
    Object localObject = EmojiCaptureProxy.lwI;
    paramInt = bo.getInt(EmojiCaptureProxy.access$getInstance$cp().getDynamicConfig(paramString), paramInt);
    AppMethodBeat.o(2573);
    return paramInt;
  }
  
  public final void Uv()
  {
    boolean bool = true;
    AppMethodBeat.i(2572);
    ((a.a)Ut()).eZM = false;
    Object localObject;
    if (bp.dud())
    {
      if (ah.brt())
      {
        localObject = (a.a)Ut();
        bool = h.OT();
        ((a.a)localObject).eZM = bool;
      }
    }
    else {
      if (!((a.a)Ut()).eZM) {
        break label164;
      }
    }
    label164:
    for (((a.a)Ut()).ltb = 720;; ((a.a)Ut()).ltb = 1080)
    {
      ab.i(TAG, "config resolution:" + ((a.a)Ut()).ltb + ", useCpuCrop:" + ((a.a)Ut()).eZM);
      AppMethodBeat.o(2572);
      return;
      a.a locala = (a.a)Ut();
      localObject = EmojiCaptureProxy.lwI;
      localObject = locala;
      if (EmojiCaptureProxy.access$getInstance$cp().getInt(ac.a.yLN, 1) == 0) {
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
    AppMethodBeat.i(2570);
    aF(new a.a((byte)0));
    Object localObject = ah.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(2570);
      throw ((Throwable)localObject);
    }
    localObject = (ActivityManager)localObject;
    int i = ((ActivityManager)localObject).getLargeMemoryClass();
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.totalMem / 1024L / 1024L;
    int j = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVf, 512);
    int k = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVe, 2048);
    if ((com.tencent.mm.compatible.util.d.fv(23)) && (i >= j) && (l >= k))
    {
      bool1 = true;
      lsZ = bool1;
      if (!bool1) {
        break label585;
      }
      localObject = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      com.tencent.mm.plugin.emojicapture.model.d.boo();
      label182:
      ab.i(TAG, "checkHighPerformance: device: " + i + ", " + l + "; high: " + j + ", " + k + "; " + lsZ);
      if (!lsZ) {
        break label596;
      }
      ((a.a)Ut()).ltc = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVg, 640);
      ((a.a)Ut()).ltd = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVh, 1);
      label309:
      i = ac.erB.eqX;
      j = ac.erB.eqY;
      if (i != -1)
      {
        ab.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(i)));
        ((a.a)Ut()).ltc = i;
      }
      if (j != -1)
      {
        ab.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(j)));
        ((a.a)Ut()).ltd = j;
      }
      ab.i(TAG, "setPreviewConfig: " + ((a.a)Ut()).ltc + ", " + ((a.a)Ut()).ltd);
      if (L("VideoRecordUseCpuCrop", 0) != 1) {
        break label655;
      }
      bool1 = true;
      label453:
      i = ac.erC.eqV;
      ab.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (bool1) {
        ((a.a)Ut()).eZM = true;
      }
      if (i != -1)
      {
        localObject = (a.a)Ut();
        if (i != 1) {
          break label661;
        }
      }
    }
    label655:
    label661:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a.a)localObject).eZM = bool1;
      ab.i(TAG, "final set useCpuCrop:" + ((a.a)Ut()).eZM);
      AppMethodBeat.o(2570);
      return;
      bool1 = false;
      break;
      label585:
      localObject = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      com.tencent.mm.plugin.emojicapture.model.d.bop();
      break label182;
      label596:
      ((a.a)Ut()).ltc = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVi, 480);
      ((a.a)Ut()).ltd = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVj, 1);
      break label309;
      bool1 = false;
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */