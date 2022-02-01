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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final int pXF = 52428800;
  private static final String pXG = "youtu_file/";
  private static final String pXH = "video_lut";
  private static final String pXI = "yt_model";
  private static final String pXJ = "yt_backup_model";
  public static final PluginEmojiCapture.a pXK;
  private boolean cBE;
  private final String gkG = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(203);
    pXK = new PluginEmojiCapture.a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    pXF = 52428800;
    pXG = "youtu_file/";
    pXH = "video_lut";
    pXI = "yt_model";
    pXJ = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.plugin.voip.f.gF(paramContext)) || (com.tencent.mm.plugin.voip.f.ch(paramContext)) || (com.tencent.mm.bh.e.cf(paramContext)) || (com.tencent.mm.r.a.ci(paramContext)))
    {
      ae.i(this.gkG, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().i(am.a.IYx);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.gd(true);
      AppMethodBeat.o(200);
      return;
    }
    localObject = com.tencent.mm.aq.b.aHF();
    p.g(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.aq.b)localObject).aHG()) {
      com.tencent.mm.plugin.report.service.g.yxI.A(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2131232010);
    new d.a(paramContext).afN(2131758073).a((Bitmap)localObject, false, 0).afR(2131758072).afU(2131758070).a((DialogInterface.OnDismissListener)new b(parama)).fQv().show();
    paramContext = com.tencent.mm.kernel.g.ajR();
    p.g(paramContext, "MMKernel.storage()");
    paramContext.ajA().set(am.a.IYx, Boolean.TRUE);
    ae.i(this.gkG, "first open check false");
    AppMethodBeat.o(200);
  }
  
  private final void initCheck()
  {
    if (!this.cBE) {
      this.cBE = true;
    }
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    AppMethodBeat.i(201);
    j localj = j.gmz;
    if (j.afc())
    {
      new d.a(paramContext).afN(2131758077).afR(2131758076).afU(2131758075).c((DialogInterface.OnClickListener)new PluginEmojiCapture.c(paramContext)).afV(2131758074).fQv().show();
      ae.i(this.gkG, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(193);
    ae.i(this.gkG, "Plugin EmojiCapture Execute");
    if (ak.coh())
    {
      com.tencent.mm.plugin.xlabeffect.e locale = com.tencent.mm.plugin.xlabeffect.e.FaL;
      com.tencent.mm.plugin.xlabeffect.e.fcm();
    }
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.xO(":tools"));; paramg = null)
    {
      if (paramg == null) {
        p.gkB();
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
    return this.cBE;
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
    ae.i(this.gkG, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    ae.i(this.gkG, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    p.h(paramContext, "context");
    p.h(parama, "onResult");
    com.tencent.mm.aq.b.aHF();
    com.tencent.mm.aq.b.aHH();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.gd(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.gd(false);
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
    this.cBE = paramBoolean;
  }
  
  public final int stickerRecommendCount()
  {
    AppMethodBeat.i(174297);
    int i = m.stickerRecommendCount();
    AppMethodBeat.o(174297);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(a.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191);
      this.pXL.gd(true);
      AppMethodBeat.o(191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */