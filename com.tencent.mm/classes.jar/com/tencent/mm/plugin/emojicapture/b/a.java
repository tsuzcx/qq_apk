package com.tencent.mm.plugin.emojicapture.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.b.c;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a
  extends c<a>
{
  private static final String TAG = "MicroMsg.EmojiCameraElementConfig";
  private static boolean rnY;
  public static final a rnZ;
  
  static
  {
    AppMethodBeat.i(134);
    rnZ = new a();
    TAG = "MicroMsg.EmojiCameraElementConfig";
    rnY = true;
    AppMethodBeat.o(134);
  }
  
  public final void aLS()
  {
    boolean bool = true;
    AppMethodBeat.i(132);
    ((a)aLQ()).ilO = false;
    Object localObject;
    if (WeChatEnvironment.hasDebugger())
    {
      if (MMApplicationContext.isMMProcess())
      {
        localObject = (a)aLQ();
        bool = n.avh();
        ((a)localObject).ilO = bool;
      }
    }
    else {
      if (!((a)aLQ()).ilO) {
        break label164;
      }
    }
    label164:
    for (((a)aLQ()).hzj = 720;; ((a)aLQ()).hzj = 1080)
    {
      Log.i(TAG, "config resolution:" + ((a)aLQ()).hzj + ", useCpuCrop:" + ((a)aLQ()).ilO);
      AppMethodBeat.o(132);
      return;
      a locala = (a)aLQ();
      localObject = EmojiCaptureProxy.rrF;
      localObject = locala;
      if (EmojiCaptureProxy.access$getInstance$cp().getInt(ar.a.OiP, 1) == 0) {
        break;
      }
      bool = false;
      localObject = locala;
      break;
    }
  }
  
  public final int ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(133);
    p.h(paramString, "key");
    if (MMApplicationContext.isMMProcess())
    {
      localObject = g.af(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
      paramInt = Util.getInt(((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue(paramString), paramInt);
      AppMethodBeat.o(133);
      return paramInt;
    }
    Object localObject = EmojiCaptureProxy.rrF;
    paramInt = Util.getInt(EmojiCaptureProxy.access$getInstance$cp().getDynamicConfig(paramString), paramInt);
    AppMethodBeat.o(133);
    return paramInt;
  }
  
  public final void init()
  {
    boolean bool2 = true;
    AppMethodBeat.i(130);
    bS(new a((byte)0));
    Object localObject = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(130);
      throw ((Throwable)localObject);
    }
    localObject = (ActivityManager)localObject;
    int i = ((ActivityManager)localObject).getLargeMemoryClass();
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.totalMem / 1024L / 1024L;
    int j = ((b)g.af(b.class)).a(b.a.rWj, 512);
    int k = ((b)g.af(b.class)).a(b.a.rWi, 2048);
    if ((d.oD(23)) && (i >= j) && (l >= k))
    {
      bool1 = true;
      rnY = bool1;
      if (!bool1) {
        break label585;
      }
      localObject = e.roB;
      e.cJh();
      label182:
      Log.i(TAG, "checkHighPerformance: device: " + i + ", " + l + "; high: " + j + ", " + k + "; " + rnY);
      if (!rnY) {
        break label596;
      }
      ((a)aLQ()).roa = ((b)g.af(b.class)).a(b.a.rWk, 640);
      ((a)aLQ()).rob = ((b)g.af(b.class)).a(b.a.rWl, 1);
      label309:
      i = ae.gKA.gJc;
      j = ae.gKA.gJd;
      if (i != -1)
      {
        Log.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(i)));
        ((a)aLQ()).roa = i;
      }
      if (j != -1)
      {
        Log.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(j)));
        ((a)aLQ()).rob = j;
      }
      Log.i(TAG, "setPreviewConfig: " + ((a)aLQ()).roa + ", " + ((a)aLQ()).rob);
      if (ab("VideoRecordUseCpuCrop", 0) != 1) {
        break label655;
      }
      bool1 = true;
      label453:
      i = ae.gKB.gJa;
      Log.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (bool1) {
        ((a)aLQ()).ilO = true;
      }
      if (i != -1)
      {
        localObject = (a)aLQ();
        if (i != 1) {
          break label661;
        }
      }
    }
    label655:
    label661:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).ilO = bool1;
      Log.i(TAG, "final set useCpuCrop:" + ((a)aLQ()).ilO);
      AppMethodBeat.o(130);
      return;
      bool1 = false;
      break;
      label585:
      localObject = e.roB;
      e.cJi();
      break label182;
      label596:
      ((a)aLQ()).roa = ((b)g.af(b.class)).a(b.a.rWm, 480);
      ((a)aLQ()).rob = ((b)g.af(b.class)).a(b.a.rWn, 1);
      break label309;
      bool1 = false;
      break label453;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "previewSize", "stickerSampleSize", "useCameraApi2", "(IZIIZ)V", "getPreviewSize", "()I", "setPreviewSize", "(I)V", "getResolution", "setResolution", "getStickerSampleSize", "setStickerSampleSize", "getUseCameraApi2", "()Z", "setUseCameraApi2", "(Z)V", "getUseCpuCrop", "setUseCpuCrop", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-emojicapture_release"})
  public static final class a
  {
    public int hzj = 1080;
    public boolean ilO = false;
    public int roa = 640;
    int rob = 1;
    private boolean roc = false;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.hzj != paramObject.hzj) || (this.ilO != paramObject.ilO) || (this.roa != paramObject.roa) || (this.rob != paramObject.rob) || (this.roc != paramObject.roc)) {}
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
      String str = "CameraPreviewConfig(resolution=" + this.hzj + ", useCpuCrop=" + this.ilO + ", previewSize=" + this.roa + ", stickerSampleSize=" + this.rob + ", useCameraApi2=" + this.roc + ")";
      AppMethodBeat.o(129);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */