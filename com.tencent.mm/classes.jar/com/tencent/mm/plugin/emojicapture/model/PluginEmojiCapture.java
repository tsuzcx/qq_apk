package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.emojicapture.api.a.a;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final int pnA = 52428800;
  private static final String pnB = "youtu_file/";
  private static final String pnC = "video_lut";
  private static final String pnD = "yt_model";
  private static final String pnE = "yt_backup_model";
  public static final PluginEmojiCapture.a pnF;
  private boolean cqf;
  private final String fOO = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(203);
    pnF = new PluginEmojiCapture.a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    pnA = 52428800;
    pnB = "youtu_file/";
    pnC = "video_lut";
    pnD = "yt_model";
    pnE = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.plugin.voip.f.cg(paramContext)) || (com.tencent.mm.plugin.voip.f.ci(paramContext)) || (com.tencent.mm.bh.e.cf(paramContext)) || (com.tencent.mm.r.a.cj(paramContext)))
    {
      ac.i(this.fOO, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agA().i(ah.a.GRt);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.fZ(true);
      AppMethodBeat.o(200);
      return;
    }
    localObject = com.tencent.mm.aq.b.aEj();
    k.g(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.aq.b)localObject).aEk()) {
      h.wUl.A(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2131232010);
    new d.a(paramContext).acF(2131758073).a((Bitmap)localObject, false, 0).acJ(2131758072).acM(2131758070).a((DialogInterface.OnDismissListener)new b(parama)).fvp().show();
    paramContext = com.tencent.mm.kernel.g.agR();
    k.g(paramContext, "MMKernel.storage()");
    paramContext.agA().set(ah.a.GRt, Boolean.TRUE);
    ac.i(this.fOO, "first open check false");
    AppMethodBeat.o(200);
  }
  
  private final void initCheck()
  {
    if (!this.cqf) {
      this.cqf = true;
    }
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    AppMethodBeat.i(201);
    j localj = j.fQF;
    if (j.ack())
    {
      new d.a(paramContext).acF(2131758077).acJ(2131758076).acM(2131758075).b((DialogInterface.OnClickListener)new PluginEmojiCapture.c(paramContext)).acN(2131758074).fvp().show();
      ac.i(this.fOO, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(193);
    ac.i(this.fOO, "Plugin EmojiCapture Execute");
    if (ai.cin())
    {
      com.tencent.mm.plugin.xlabeffect.c localc = com.tencent.mm.plugin.xlabeffect.c.Deu;
      com.tencent.mm.plugin.xlabeffect.c.eJM();
    }
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.up(":tools"));; paramg = null)
    {
      if (paramg == null) {
        k.fOy();
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
    return this.cqf;
  }
  
  public final boolean isStickerEnable()
  {
    AppMethodBeat.i(195);
    boolean bool = m.isStickerEnable();
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
    ac.i(this.fOO, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    ac.i(this.fOO, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    k.h(paramContext, "context");
    k.h(parama, "onResult");
    com.tencent.mm.aq.b.aEj();
    com.tencent.mm.aq.b.aEl();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.fZ(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.fZ(false);
    AppMethodBeat.o(194);
  }
  
  public final void prepareEmojiCapture(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(197);
    k.h(paramContext, "context");
    k.h(paramString, "lensIdWithUrl");
    k.h(paramb, "onResult");
    new a(paramContext, paramString, paramb);
    AppMethodBeat.o(197);
  }
  
  public final void prepareStickerPreview(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(196);
    k.h(paramContext, "context");
    k.h(paramString, "url");
    k.h(paramb, "onResult");
    new b(paramContext, paramString, paramb);
    AppMethodBeat.o(196);
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.cqf = paramBoolean;
  }
  
  public final int stickerRecommendCount()
  {
    AppMethodBeat.i(174297);
    int i = m.stickerRecommendCount();
    AppMethodBeat.o(174297);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(a.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191);
      this.pnG.fZ(true);
      AppMethodBeat.o(191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */