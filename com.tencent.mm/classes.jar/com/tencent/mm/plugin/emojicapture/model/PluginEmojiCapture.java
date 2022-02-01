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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final int pRa = 52428800;
  private static final String pRb = "youtu_file/";
  private static final String pRc = "video_lut";
  private static final String pRd = "yt_model";
  private static final String pRe = "yt_backup_model";
  public static final PluginEmojiCapture.a pRf;
  private boolean cAX;
  private final String gio = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(203);
    pRf = new PluginEmojiCapture.a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    pRa = 52428800;
    pRb = "youtu_file/";
    pRc = "video_lut";
    pRd = "yt_model";
    pRe = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.plugin.voip.f.gA(paramContext)) || (com.tencent.mm.plugin.voip.f.cf(paramContext)) || (com.tencent.mm.bi.e.cd(paramContext)) || (com.tencent.mm.s.a.cg(paramContext)))
    {
      ad.i(this.gio, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().i(al.a.IDX);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.ge(true);
      AppMethodBeat.o(200);
      return;
    }
    localObject = com.tencent.mm.ar.b.aHo();
    p.g(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.ar.b)localObject).aHp()) {
      com.tencent.mm.plugin.report.service.g.yhR.A(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2131232010);
    new d.a(paramContext).afe(2131758073).a((Bitmap)localObject, false, 0).afi(2131758072).afl(2131758070).a((DialogInterface.OnDismissListener)new b(parama)).fMb().show();
    paramContext = com.tencent.mm.kernel.g.ajC();
    p.g(paramContext, "MMKernel.storage()");
    paramContext.ajl().set(al.a.IDX, Boolean.TRUE);
    ad.i(this.gio, "first open check false");
    AppMethodBeat.o(200);
  }
  
  private final void initCheck()
  {
    if (!this.cAX) {
      this.cAX = true;
    }
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    AppMethodBeat.i(201);
    j localj = j.gkf;
    if (j.aeO())
    {
      new d.a(paramContext).afe(2131758077).afi(2131758076).afl(2131758075).c((DialogInterface.OnClickListener)new PluginEmojiCapture.c(paramContext)).afm(2131758074).fMb().show();
      ad.i(this.gio, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(193);
    ad.i(this.gio, "Plugin EmojiCapture Execute");
    if (aj.cmR())
    {
      com.tencent.mm.plugin.xlabeffect.d locald = com.tencent.mm.plugin.xlabeffect.d.EIn;
      com.tencent.mm.plugin.xlabeffect.d.eYy();
    }
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.xf(":tools"));; paramg = null)
    {
      if (paramg == null) {
        p.gfZ();
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
    return this.cAX;
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
    ad.i(this.gio, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    ad.i(this.gio, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    p.h(paramContext, "context");
    p.h(parama, "onResult");
    com.tencent.mm.ar.b.aHo();
    com.tencent.mm.ar.b.aHq();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.ge(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.ge(false);
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
    this.cAX = paramBoolean;
  }
  
  public final int stickerRecommendCount()
  {
    AppMethodBeat.i(174297);
    int i = m.stickerRecommendCount();
    AppMethodBeat.o(174297);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(a.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191);
      this.pRg.ge(true);
      AppMethodBeat.o(191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */