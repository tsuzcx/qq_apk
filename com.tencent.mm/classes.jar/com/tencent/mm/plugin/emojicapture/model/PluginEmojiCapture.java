package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.emojicapture.api.a.a;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final int oKc = 52428800;
  private static final String oKd = "youtu_file/";
  private static final String oKe = "video_lut";
  private static final String oKf = "yt_model";
  private static final String oKg = "yt_backup_model";
  public static final a oKh;
  private boolean csX;
  private final String fLc = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(203);
    oKh = new a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    oKc = 52428800;
    oKd = "youtu_file/";
    oKe = "video_lut";
    oKf = "yt_model";
    oKg = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.plugin.voip.f.cd(paramContext)) || (com.tencent.mm.plugin.voip.f.ce(paramContext)) || (com.tencent.mm.bi.e.cc(paramContext)))
    {
      ad.i(this.fLc, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().i(ae.a.Ftz);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.fD(true);
      AppMethodBeat.o(200);
      return;
    }
    localObject = com.tencent.mm.ar.b.axr();
    k.g(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.ar.b)localObject).axs()) {
      h.vKh.D(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2131232010);
    new d.a(paramContext).aau(2131758073).a((Bitmap)localObject, false, 0).aay(2131758072).aaB(2131758070).a((DialogInterface.OnDismissListener)new b(parama)).fft().show();
    paramContext = com.tencent.mm.kernel.g.afB();
    k.g(paramContext, "MMKernel.storage()");
    paramContext.afk().set(ae.a.Ftz, Boolean.TRUE);
    ad.i(this.fLc, "first open check false");
    AppMethodBeat.o(200);
  }
  
  private final void initCheck()
  {
    if (!this.csX) {
      this.csX = true;
    }
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    AppMethodBeat.i(201);
    i locali = i.fMT;
    if (i.abm())
    {
      new d.a(paramContext).aau(2131758077).aay(2131758076).aaB(2131758075).b((DialogInterface.OnClickListener)new PluginEmojiCapture.c(paramContext)).aaC(2131758074).fft().show();
      ad.i(this.fLc, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(193);
    ad.i(this.fLc, "Plugin EmojiCapture Execute");
    if (aj.cbe())
    {
      com.tencent.mm.plugin.xlabeffect.c localc = com.tencent.mm.plugin.xlabeffect.c.BMk;
      com.tencent.mm.plugin.xlabeffect.c.eut();
    }
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.ra(":tools"));; paramg = null)
    {
      if (paramg == null) {
        k.fvU();
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
    return this.csX;
  }
  
  public final boolean isStickerEnable()
  {
    AppMethodBeat.i(195);
    boolean bool = com.tencent.mm.emoji.a.l.isStickerEnable();
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
    ad.i(this.fLc, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    ad.i(this.fLc, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    k.h(paramContext, "context");
    k.h(parama, "onResult");
    com.tencent.mm.ar.b.axr();
    com.tencent.mm.ar.b.axt();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.fD(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.fD(false);
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
    this.csX = paramBoolean;
  }
  
  public final int stickerRecommendCount()
  {
    AppMethodBeat.i(174297);
    int i = com.tencent.mm.emoji.a.l.stickerRecommendCount();
    AppMethodBeat.o(174297);
    return i;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture$Companion;", "", "()V", "MIN_STORAGE_SIZE", "", "getMIN_STORAGE_SIZE", "()I", "TAG", "", "VIDEO_LUT_FILE_DIR", "getVIDEO_LUT_FILE_DIR", "()Ljava/lang/String;", "YT_FILE_ROOT_DIR", "getYT_FILE_ROOT_DIR", "YT_MODEL_BACKUP_FILE_DIR", "getYT_MODEL_BACKUP_FILE_DIR", "YT_MODEL_FILE_DIR", "getYT_MODEL_FILE_DIR", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(a.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191);
      this.oKi.fD(true);
      AppMethodBeat.o(191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */