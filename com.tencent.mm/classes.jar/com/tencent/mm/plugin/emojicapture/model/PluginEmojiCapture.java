package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.emojicapture.api.a.a;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final int roD = 52428800;
  private static final String roE = "youtu_file/";
  private static final String roF = "video_lut";
  private static final String roG = "yt_model";
  private static final String roH = "yt_backup_model";
  public static final PluginEmojiCapture.a roI;
  private final String gVB = "MicroMsg.PluginEmojiCapture";
  private boolean isInit;
  
  static
  {
    AppMethodBeat.i(203);
    roI = new PluginEmojiCapture.a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    roD = 52428800;
    roE = "youtu_file/";
    roF = "video_lut";
    roG = "yt_model";
    roH = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.plugin.voip.f.hy(paramContext)) || (com.tencent.mm.plugin.voip.f.cC(paramContext)) || (com.tencent.mm.bh.e.cA(paramContext)) || (com.tencent.mm.q.a.cD(paramContext)))
    {
      Log.i(this.gVB, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().i(ar.a.OgU);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.ha(true);
      AppMethodBeat.o(200);
      return;
    }
    localObject = com.tencent.mm.aq.b.bby();
    p.g(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.aq.b)localObject).bbz()) {
      h.CyF.F(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2131232101);
    new d.a(paramContext).aoO(2131758333).b((Bitmap)localObject, false, 0).aoS(2131758332).aoV(2131758330).a((DialogInterface.OnDismissListener)new b(parama)).hbn().show();
    paramContext = com.tencent.mm.kernel.g.aAh();
    p.g(paramContext, "MMKernel.storage()");
    paramContext.azQ().set(ar.a.OgU, Boolean.TRUE);
    Log.i(this.gVB, "first open check false");
    AppMethodBeat.o(200);
  }
  
  private final void initCheck()
  {
    if (!this.isInit) {
      this.isInit = true;
    }
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    AppMethodBeat.i(201);
    k localk = k.gXr;
    if (k.auQ())
    {
      new d.a(paramContext).aoO(2131758337).aoS(2131758336).aoV(2131758335).c((DialogInterface.OnClickListener)new PluginEmojiCapture.c(paramContext)).aoW(2131758334).hbn().show();
      Log.i(this.gVB, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(193);
    Log.i(this.gVB, "Plugin EmojiCapture Execute");
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.plugin.xlabeffect.e locale = com.tencent.mm.plugin.xlabeffect.e.JRF;
      com.tencent.mm.plugin.xlabeffect.e.glw();
    }
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.FY(":tools"));; paramg = null)
    {
      if (paramg == null) {
        p.hyc();
      }
      if (paramg.booleanValue()) {
        initCheck();
      }
      AppMethodBeat.o(193);
      return;
    }
  }
  
  public final boolean isInit()
  {
    return this.isInit;
  }
  
  public final boolean isStickerEnable()
  {
    AppMethodBeat.i(195);
    boolean bool = n.isStickerEnable();
    AppMethodBeat.o(195);
    return bool;
  }
  
  public final String name()
  {
    return "plugin-emojicapture";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(198);
    Log.i(this.gVB, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    Log.i(this.gVB, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.V(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    p.h(paramContext, "context");
    p.h(parama, "onResult");
    com.tencent.mm.aq.b.bby();
    com.tencent.mm.aq.b.bbA();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.ha(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.ha(false);
    AppMethodBeat.o(194);
  }
  
  public final void prepareEmojiCapture(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(197);
    p.h(paramContext, "context");
    p.h(paramString, "lensIdWithUrl");
    p.h(paramb, "onResult");
    new a(paramContext, paramString, paramb);
    AppMethodBeat.o(197);
  }
  
  public final void prepareStickerPreview(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(196);
    p.h(paramContext, "context");
    p.h(paramString, "url");
    p.h(paramb, "onResult");
    new b(paramContext, paramString, paramb);
    AppMethodBeat.o(196);
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.isInit = paramBoolean;
  }
  
  public final int stickerRecommendCount()
  {
    AppMethodBeat.i(174297);
    int i = n.stickerRecommendCount();
    AppMethodBeat.o(174297);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(a.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191);
      this.roJ.ha(true);
      AppMethodBeat.o(191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */