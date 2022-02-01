package com.tencent.mm.plugin.emojicapture.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.b.c;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a
  extends c<a.a>
{
  private static final String TAG = "MicroMsg.EmojiCameraElementConfig";
  private static boolean pWZ;
  public static final a pXa;
  
  static
  {
    AppMethodBeat.i(134);
    pXa = new a();
    TAG = "MicroMsg.EmojiCameraElementConfig";
    pWZ = true;
    AppMethodBeat.o(134);
  }
  
  public final int Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(133);
    p.h(paramString, "key");
    if (ak.cpe())
    {
      localObject = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
      paramInt = bu.getInt(((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue(paramString), paramInt);
      AppMethodBeat.o(133);
      return paramInt;
    }
    Object localObject = EmojiCaptureProxy.qaI;
    paramInt = bu.getInt(EmojiCaptureProxy.access$getInstance$cp().getDynamicConfig(paramString), paramInt);
    AppMethodBeat.o(133);
    return paramInt;
  }
  
  public final void ats()
  {
    boolean bool = true;
    AppMethodBeat.i(132);
    ((a.a)atq()).hrS = false;
    Object localObject;
    if (bv.fpT())
    {
      if (ak.cpe())
      {
        localObject = (a.a)atq();
        bool = m.aft();
        ((a.a)localObject).hrS = bool;
      }
    }
    else {
      if (!((a.a)atq()).hrS) {
        break label164;
      }
    }
    label164:
    for (((a.a)atq()).gKf = 720;; ((a.a)atq()).gKf = 1080)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "config resolution:" + ((a.a)atq()).gKf + ", useCpuCrop:" + ((a.a)atq()).hrS);
      AppMethodBeat.o(132);
      return;
      a.a locala = (a.a)atq();
      localObject = EmojiCaptureProxy.qaI;
      localObject = locala;
      if (EmojiCaptureProxy.access$getInstance$cp().getInt(am.a.Jaj, 1) == 0) {
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
    bJ(new a.a((byte)0));
    Object localObject = ak.getContext().getSystemService("activity");
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
    int j = ((b)g.ab(b.class)).a(b.a.qDp, 512);
    int k = ((b)g.ab(b.class)).a(b.a.qDo, 2048);
    if ((d.lA(23)) && (i >= j) && (l >= k))
    {
      bool1 = true;
      pWZ = bool1;
      if (!bool1) {
        break label585;
      }
      localObject = com.tencent.mm.plugin.emojicapture.model.e.pXD;
      com.tencent.mm.plugin.emojicapture.model.e.clf();
      label182:
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "checkHighPerformance: device: " + i + ", " + l + "; high: " + j + ", " + k + "; " + pWZ);
      if (!pWZ) {
        break label596;
      }
      ((a.a)atq()).pXb = ((b)g.ab(b.class)).a(b.a.qDq, 640);
      ((a.a)atq()).pXc = ((b)g.ab(b.class)).a(b.a.qDr, 1);
      label309:
      i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdE;
      j = com.tencent.mm.compatible.deviceinfo.ae.geT.gdF;
      if (i != -1)
      {
        com.tencent.mm.sdk.platformtools.ae.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(i)));
        ((a.a)atq()).pXb = i;
      }
      if (j != -1)
      {
        com.tencent.mm.sdk.platformtools.ae.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(j)));
        ((a.a)atq()).pXc = j;
      }
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "setPreviewConfig: " + ((a.a)atq()).pXb + ", " + ((a.a)atq()).pXc);
      if (Z("VideoRecordUseCpuCrop", 0) != 1) {
        break label655;
      }
      bool1 = true;
      label453:
      i = com.tencent.mm.compatible.deviceinfo.ae.geU.gdC;
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (bool1) {
        ((a.a)atq()).hrS = true;
      }
      if (i != -1)
      {
        localObject = (a.a)atq();
        if (i != 1) {
          break label661;
        }
      }
    }
    label655:
    label661:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a.a)localObject).hrS = bool1;
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "final set useCpuCrop:" + ((a.a)atq()).hrS);
      AppMethodBeat.o(130);
      return;
      bool1 = false;
      break;
      label585:
      localObject = com.tencent.mm.plugin.emojicapture.model.e.pXD;
      com.tencent.mm.plugin.emojicapture.model.e.clg();
      break label182;
      label596:
      ((a.a)atq()).pXb = ((b)g.ab(b.class)).a(b.a.qDs, 480);
      ((a.a)atq()).pXc = ((b)g.ab(b.class)).a(b.a.qDt, 1);
      break label309;
      bool1 = false;
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */