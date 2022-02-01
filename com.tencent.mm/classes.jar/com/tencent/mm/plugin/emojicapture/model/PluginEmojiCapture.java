package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.a.a;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final int uUj = 52428800;
  private static final String uUk = "youtu_file/";
  private static final String uUl = "video_lut";
  private static final String uUm = "yt_model";
  private static final String uUn = "yt_backup_model";
  public static final a uUo;
  private boolean isInit;
  private final String jGx = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(203);
    uUo = new a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    uUj = 52428800;
    uUk = "youtu_file/";
    uUl = "video_lut";
    uUm = "yt_model";
    uUn = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.plugin.voip.f.iE(paramContext)) || (com.tencent.mm.plugin.voip.f.cy(paramContext)) || (e.cw(paramContext)) || (com.tencent.mm.q.a.cA(paramContext)))
    {
      Log.i(this.jGx, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().j(ar.a.Vvk);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.hR(true);
      AppMethodBeat.o(200);
      return;
    }
    localObject = com.tencent.mm.at.b.bkO();
    p.j(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.at.b)localObject).bkP()) {
      com.tencent.mm.plugin.report.service.h.IzE.F(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), a.e.uRr);
    new d.a(paramContext).ayc(a.i.uST).b((Bitmap)localObject, false, 0).ayg(a.i.uSS).ayj(a.i.uSQ).a((DialogInterface.OnDismissListener)new b(parama)).icu().show();
    paramContext = com.tencent.mm.kernel.h.aHG();
    p.j(paramContext, "MMKernel.storage()");
    paramContext.aHp().set(ar.a.Vvk, Boolean.TRUE);
    Log.i(this.jGx, "first open check false");
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
    com.tencent.mm.emoji.b.l locall = com.tencent.mm.emoji.b.l.jIq;
    if (com.tencent.mm.emoji.b.l.aBM())
    {
      new d.a(paramContext).ayc(a.i.uSX).ayg(a.i.uSW).ayj(a.i.uSV).c((DialogInterface.OnClickListener)new PluginEmojiCapture.c(paramContext)).ayk(a.i.uSU).icu().show();
      Log.i(this.jGx, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(193);
    Log.i(this.jGx, "Plugin EmojiCapture Execute");
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.plugin.xlabeffect.h localh = com.tencent.mm.plugin.xlabeffect.h.QQH;
      com.tencent.mm.plugin.xlabeffect.h.hfm();
      localh = com.tencent.mm.plugin.xlabeffect.h.QQH;
      com.tencent.mm.plugin.xlabeffect.h.hfn();
    }
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.MY(":tools"));; paramg = null)
    {
      if (paramg == null) {
        p.iCn();
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
    boolean bool = o.isStickerEnable();
    AppMethodBeat.o(195);
    return bool;
  }
  
  public final String name()
  {
    return "plugin-emojicapture";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(198);
    Log.i(this.jGx, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    Log.i(this.jGx, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.W(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    p.k(paramContext, "context");
    p.k(parama, "onResult");
    com.tencent.mm.at.b.bkO();
    com.tencent.mm.at.b.bkQ();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.hR(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.hR(false);
    AppMethodBeat.o(194);
  }
  
  public final void prepareEmojiCapture(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(197);
    p.k(paramContext, "context");
    p.k(paramString, "lensIdWithUrl");
    p.k(paramb, "onResult");
    new a(paramContext, paramString, paramb);
    AppMethodBeat.o(197);
  }
  
  public final void prepareStickerPreview(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(196);
    p.k(paramContext, "context");
    p.k(paramString, "url");
    p.k(paramb, "onResult");
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
    int i = o.stickerRecommendCount();
    AppMethodBeat.o(174297);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture$Companion;", "", "()V", "MIN_STORAGE_SIZE", "", "getMIN_STORAGE_SIZE", "()I", "TAG", "", "VIDEO_LUT_FILE_DIR", "getVIDEO_LUT_FILE_DIR", "()Ljava/lang/String;", "YT_FILE_ROOT_DIR", "getYT_FILE_ROOT_DIR", "YT_MODEL_BACKUP_FILE_DIR", "getYT_MODEL_BACKUP_FILE_DIR", "YT_MODEL_FILE_DIR", "getYT_MODEL_FILE_DIR", "plugin-emojicapture_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(a.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191);
      this.uUp.hR(true);
      AppMethodBeat.o(191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */