package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ua;
import com.tencent.mm.emoji.c.m;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.a.a;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginEmojiCapture
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String TAG;
  public static final PluginEmojiCapture.a ygV;
  private static final int ygW;
  private static final String ygX;
  private static final String ygY;
  private static final String ygZ;
  private static final String yha;
  private boolean isInit;
  private final String mgf = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(203);
    ygV = new PluginEmojiCapture.a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    ygW = 52428800;
    ygX = "youtu_file/";
    ygY = "video_lut";
    ygZ = "yt_model";
    yha = "yt_backup_model";
    AppMethodBeat.o(203);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(202);
    if ((com.tencent.mm.n.a.p(paramContext, true)) || (com.tencent.mm.n.a.dm(paramContext)) || (com.tencent.mm.n.a.dl(paramContext)) || (com.tencent.mm.n.a.u(paramContext, true)))
    {
      Log.i(this.mgf, "camera check false");
      AppMethodBeat.o(202);
      return false;
    }
    AppMethodBeat.o(202);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(200);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acWT, null);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.onCheckResult(true);
      AppMethodBeat.o(200);
      return;
    }
    if (!com.tencent.mm.modelemoji.b.bII().oDr) {
      com.tencent.mm.plugin.report.service.h.OAn.p(933L, 2L, 1L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), a.e.yef);
    new e.a(paramContext).aEK(a.i.yfH).b((Bitmap)localObject, false, 0).aEO(a.i.yfG).aER(a.i.yfE).c(new PluginEmojiCapture..ExternalSyntheticLambda1(parama)).jHH().show();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWT, Boolean.TRUE);
    Log.i(this.mgf, "first open check false");
    AppMethodBeat.o(200);
  }
  
  private static final void firstOpenCheck$lambda-0(a.a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(269357);
    s.u(parama, "$onResult");
    parama.onCheckResult(true);
    AppMethodBeat.o(269357);
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
    m localm = m.mhY;
    if (m.aUK())
    {
      new e.a(paramContext).aEK(a.i.yfL).aEO(a.i.yfK).aER(a.i.yfJ).c(new PluginEmojiCapture..ExternalSyntheticLambda0(paramContext)).aES(a.i.yfI).jHH().show();
      Log.i(this.mgf, "over size check false");
      AppMethodBeat.o(201);
      return false;
    }
    AppMethodBeat.o(201);
    return true;
  }
  
  private static final void overSizeCheck$lambda-1(Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(269361);
    s.u(paramContext, "$context");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_emoji_panel_type", 1);
    com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.EmojiCustomUI", paramDialogInterface);
    AppMethodBeat.o(269361);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    Object localObject1 = null;
    AppMethodBeat.i(193);
    Log.i(this.mgf, "Plugin EmojiCapture Execute");
    if (MMApplicationContext.isMainProcess())
    {
      Object localObject2 = com.tencent.mm.plugin.xlabeffect.d.XJR;
      com.tencent.mm.plugin.xlabeffect.d.iFU();
      localObject2 = com.tencent.mm.plugin.xlabeffect.h.XKm;
      Log.i(com.tencent.mm.plugin.xlabeffect.h.TAG, "init: ");
      com.tencent.mm.plugin.xlabeffect.h.oDs.alive();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(99);
      com.tencent.mm.plugin.xlabeffect.h.iFX();
      localObject2 = com.tencent.mm.plugin.xlabeffect.d.XJR;
      Object localObject3 = com.tencent.mm.plugin.xlabeffect.d.iFP();
      localObject2 = new ua();
      Object localObject4 = com.tencent.mm.xeffect.d.agXC;
      ((ua)localObject2).jFt = 140;
      ((ua)localObject2).jFu = ((com.tencent.mm.plugin.xlabeffect.g)localObject3).sdkVersion;
      ((ua)localObject2).jFv = ((com.tencent.mm.plugin.xlabeffect.g)localObject3).XKk;
      Object localObject5 = (Iterable)((com.tencent.mm.plugin.xlabeffect.g)localObject3).XKl;
      localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((Collection)localObject4).add(Integer.valueOf(((com.tencent.mm.plugin.xlabeffect.e)((Iterator)localObject5).next()).subType));
      }
      ((ua)localObject2).jFw = ((ua)localObject2).F("ModelList", p.a((Iterable)localObject4, (CharSequence)";", null, null, 0, null, null, 62), true);
      localObject4 = (Iterable)((com.tencent.mm.plugin.xlabeffect.g)localObject3).XKl;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label313:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if (!((com.tencent.mm.plugin.xlabeffect.e)localObject5).isValid()) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label313;
          }
          ((Collection)localObject3).add(localObject5);
          break;
        }
      }
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Integer.valueOf(((com.tencent.mm.plugin.xlabeffect.e)((Iterator)localObject4).next()).subType));
      }
      ((ua)localObject2).jFx = ((ua)localObject2).F("InvalidModelList", p.a((Iterable)localObject3, (CharSequence)";", null, null, 0, null, null, 62), true);
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      ((ua)localObject2).jFy = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nJ(99, 0);
      Log.i(com.tencent.mm.plugin.xlabeffect.f.aUw(), s.X("reportModelRes: ", ((ua)localObject2).aIF()));
      ((ua)localObject2).bMH();
    }
    if (paramg == null) {}
    for (paramg = localObject1;; paramg = Boolean.valueOf(paramg.FH(":tools")))
    {
      s.checkNotNull(paramg);
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
    Log.i(this.mgf, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new c(), new String[] { "//emojicapture" });
    AppMethodBeat.o(198);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199);
    Log.i(this.mgf, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.X(new String[] { "//emojicapture" });
    AppMethodBeat.o(199);
  }
  
  public final void preCheck(Context paramContext, int paramInt, a.a parama)
  {
    AppMethodBeat.i(194);
    s.u(paramContext, "context");
    s.u(parama, "onResult");
    com.tencent.mm.modelemoji.b.bII();
    com.tencent.mm.modelemoji.b.bIJ();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.onCheckResult(true);
        AppMethodBeat.o(194);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(194);
      return;
    }
    parama.onCheckResult(false);
    AppMethodBeat.o(194);
  }
  
  public final void prepareEmojiCapture(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(197);
    s.u(paramContext, "context");
    s.u(paramString, "lensIdWithUrl");
    s.u(paramb, "onResult");
    new a(paramContext, paramString, paramb);
    AppMethodBeat.o(197);
  }
  
  public final void prepareStickerPreview(Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(196);
    s.u(paramContext, "context");
    s.u(paramString, "url");
    s.u(paramb, "onResult");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */