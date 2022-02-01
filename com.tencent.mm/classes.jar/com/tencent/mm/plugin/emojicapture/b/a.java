package com.tencent.mm.plugin.emojicapture.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.media.b.c<a.a>
{
  private static final String TAG;
  public static final a ygu;
  private static boolean ygv;
  
  static
  {
    AppMethodBeat.i(134);
    ygu = new a();
    TAG = "MicroMsg.EmojiCameraElementConfig";
    ygv = true;
    AppMethodBeat.o(134);
  }
  
  public final int aC(String paramString, int paramInt)
  {
    AppMethodBeat.i(133);
    s.u(paramString, "key");
    if (MMApplicationContext.isMMProcess())
    {
      paramInt = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue(paramString), paramInt);
      AppMethodBeat.o(133);
      return paramInt;
    }
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.yjA;
    paramInt = Util.getInt(EmojiCaptureProxy.access$getInstance$cp().getDynamicConfig(paramString), paramInt);
    AppMethodBeat.o(133);
    return paramInt;
  }
  
  public final void boD()
  {
    boolean bool = true;
    AppMethodBeat.i(132);
    ((a.a)boB()).nFT = false;
    Object localObject;
    if (WeChatEnvironment.hasDebugger())
    {
      if (MMApplicationContext.isMMProcess())
      {
        localObject = (a.a)boB();
        bool = o.aUZ();
        ((a.a)localObject).nFT = bool;
      }
    }
    else {
      if (!((a.a)boB()).nFT) {
        break label164;
      }
    }
    label164:
    for (((a.a)boB()).mNl = 720;; ((a.a)boB()).mNl = 1080)
    {
      Log.i(TAG, "config resolution:" + ((a.a)boB()).mNl + ", useCpuCrop:" + ((a.a)boB()).nFT);
      AppMethodBeat.o(132);
      return;
      a.a locala = (a.a)boB();
      localObject = EmojiCaptureProxy.yjA;
      localObject = locala;
      if (EmojiCaptureProxy.access$getInstance$cp().getInt(at.a.acYQ, 1) == 0) {
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
    dm(new a.a((byte)0));
    Object localObject = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(130);
      throw ((Throwable)localObject);
    }
    localObject = (ActivityManager)localObject;
    int i = ((ActivityManager)localObject).getLargeMemoryClass();
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.totalMem / 1024L / 1024L;
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRk, 512);
    int k = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRj, 2048);
    if ((d.rb(23)) && (i >= j) && (l >= k))
    {
      bool1 = true;
      ygv = bool1;
      if (!bool1) {
        break label575;
      }
      localObject = e.ygT;
      e.dEg();
      label182:
      Log.i(TAG, "checkHighPerformance: device: " + i + ", " + l + "; high: " + j + ", " + k + "; " + ygv);
      if (!ygv) {
        break label586;
      }
      ((a.a)boB()).ygw = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRl, 640);
      ((a.a)boB()).ygx = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRm, 1);
      label307:
      i = af.lYf.lWL;
      j = af.lYf.lWM;
      if (i != -1)
      {
        Log.i(TAG, s.X("setPreviewConfig: use device preview ", Integer.valueOf(i)));
        ((a.a)boB()).ygw = i;
      }
      if (j != -1)
      {
        Log.i(TAG, s.X("setPreviewConfig: use device sample size ", Integer.valueOf(j)));
        ((a.a)boB()).ygx = j;
      }
      Log.i(TAG, "setPreviewConfig: " + ((a.a)boB()).ygw + ", " + ((a.a)boB()).ygx);
      if (aC("VideoRecordUseCpuCrop", 0) != 1) {
        break label645;
      }
      bool1 = true;
      label450:
      i = af.lYg.lWJ;
      Log.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (bool1) {
        ((a.a)boB()).nFT = true;
      }
      if (i != -1)
      {
        localObject = (a.a)boB();
        if (i != 1) {
          break label651;
        }
      }
    }
    label645:
    label651:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a.a)localObject).nFT = bool1;
      Log.i(TAG, s.X("final set useCpuCrop:", Boolean.valueOf(((a.a)boB()).nFT)));
      AppMethodBeat.o(130);
      return;
      bool1 = false;
      break;
      label575:
      localObject = e.ygT;
      e.dEh();
      break label182;
      label586:
      ((a.a)boB()).ygw = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRn, 480);
      ((a.a)boB()).ygx = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRo, 1);
      break label307;
      bool1 = false;
      break label450;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */