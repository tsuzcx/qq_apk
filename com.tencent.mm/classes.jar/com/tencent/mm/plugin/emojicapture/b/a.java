package com.tencent.mm.plugin.emojicapture.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.b.c;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a
  extends c<a>
{
  private static final String TAG = "MicroMsg.EmojiCameraElementConfig";
  private static boolean oJv;
  public static final a oJw;
  
  static
  {
    AppMethodBeat.i(134);
    oJw = new a();
    TAG = "MicroMsg.EmojiCameraElementConfig";
    oJv = true;
    AppMethodBeat.o(134);
  }
  
  public final int P(String paramString, int paramInt)
  {
    AppMethodBeat.i(133);
    k.h(paramString, "key");
    if (aj.cbv())
    {
      localObject = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
      paramInt = bt.getInt(((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue(paramString), paramInt);
      AppMethodBeat.o(133);
      return paramInt;
    }
    Object localObject = EmojiCaptureProxy.oNd;
    paramInt = bt.getInt(EmojiCaptureProxy.access$getInstance$cp().getDynamicConfig(paramString), paramInt);
    AppMethodBeat.o(133);
    return paramInt;
  }
  
  public final void ajo()
  {
    boolean bool = true;
    AppMethodBeat.i(132);
    ((a)ajm()).gwB = false;
    Object localObject;
    if (bu.eGT())
    {
      if (aj.cbv())
      {
        localObject = (a)ajm();
        bool = com.tencent.mm.emoji.a.l.abC();
        ((a)localObject).gwB = bool;
      }
    }
    else {
      if (!((a)ajm()).gwB) {
        break label164;
      }
    }
    label164:
    for (((a)ajm()).oJx = 720;; ((a)ajm()).oJx = 1080)
    {
      ad.i(TAG, "config resolution:" + ((a)ajm()).oJx + ", useCpuCrop:" + ((a)ajm()).gwB);
      AppMethodBeat.o(132);
      return;
      a locala = (a)ajm();
      localObject = EmojiCaptureProxy.oNd;
      localObject = locala;
      if (EmojiCaptureProxy.access$getInstance$cp().getInt(ae.a.Fvk, 1) == 0) {
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
    bJ(new a((byte)0));
    Object localObject = aj.getContext().getSystemService("activity");
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
    int j = ((b)g.ab(b.class)).a(b.a.poq, 512);
    int k = ((b)g.ab(b.class)).a(b.a.pop, 2048);
    if ((d.lf(23)) && (i >= j) && (l >= k))
    {
      bool1 = true;
      oJv = bool1;
      if (!bool1) {
        break label585;
      }
      localObject = com.tencent.mm.plugin.emojicapture.model.e.oKa;
      com.tencent.mm.plugin.emojicapture.model.e.bXZ();
      label182:
      ad.i(TAG, "checkHighPerformance: device: " + i + ", " + l + "; high: " + j + ", " + k + "; " + oJv);
      if (!oJv) {
        break label596;
      }
      ((a)ajm()).oJy = ((b)g.ab(b.class)).a(b.a.por, 640);
      ((a)ajm()).oJz = ((b)g.ab(b.class)).a(b.a.pot, 1);
      label309:
      i = ae.fFD.fEp;
      j = ae.fFD.fEq;
      if (i != -1)
      {
        ad.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(i)));
        ((a)ajm()).oJy = i;
      }
      if (j != -1)
      {
        ad.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(j)));
        ((a)ajm()).oJz = j;
      }
      ad.i(TAG, "setPreviewConfig: " + ((a)ajm()).oJy + ", " + ((a)ajm()).oJz);
      if (P("VideoRecordUseCpuCrop", 0) != 1) {
        break label655;
      }
      bool1 = true;
      label453:
      i = ae.fFE.fEn;
      ad.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (bool1) {
        ((a)ajm()).gwB = true;
      }
      if (i != -1)
      {
        localObject = (a)ajm();
        if (i != 1) {
          break label661;
        }
      }
    }
    label655:
    label661:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).gwB = bool1;
      ad.i(TAG, "final set useCpuCrop:" + ((a)ajm()).gwB);
      AppMethodBeat.o(130);
      return;
      bool1 = false;
      break;
      label585:
      localObject = com.tencent.mm.plugin.emojicapture.model.e.oKa;
      com.tencent.mm.plugin.emojicapture.model.e.bYa();
      break label182;
      label596:
      ((a)ajm()).oJy = ((b)g.ab(b.class)).a(b.a.pou, 480);
      ((a)ajm()).oJz = ((b)g.ab(b.class)).a(b.a.pov, 1);
      break label309;
      bool1 = false;
      break label453;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "previewSize", "stickerSampleSize", "useCameraApi2", "(IZIIZ)V", "getPreviewSize", "()I", "setPreviewSize", "(I)V", "getResolution", "setResolution", "getStickerSampleSize", "setStickerSampleSize", "getUseCameraApi2", "()Z", "setUseCameraApi2", "(Z)V", "getUseCpuCrop", "setUseCpuCrop", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-emojicapture_release"})
  public static final class a
  {
    public boolean gwB = false;
    private boolean oJA = false;
    public int oJx = 1080;
    public int oJy = 640;
    int oJz = 1;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.oJx != paramObject.oJx) || (this.gwB != paramObject.gwB) || (this.oJy != paramObject.oJy) || (this.oJz != paramObject.oJz) || (this.oJA != paramObject.oJA)) {}
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
      String str = "CameraPreviewConfig(resolution=" + this.oJx + ", useCpuCrop=" + this.gwB + ", previewSize=" + this.oJy + ", stickerSampleSize=" + this.oJz + ", useCameraApi2=" + this.oJA + ")";
      AppMethodBeat.o(129);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */