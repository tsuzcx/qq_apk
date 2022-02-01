package com.tencent.mm.plugin.emojicapture.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Matrix;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.g.b.v.f;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final c.a pqi;
  private Context context;
  private final com.tencent.mm.remoteservice.d fPa;
  private final String fQN;
  private boolean poI;
  private com.tencent.mm.plugin.emojicapture.model.a.b ppA;
  private EmojiCaptureUI.b ppF;
  private final EmojiCaptureReporter ppG;
  private String ppZ;
  private String ppz;
  private boolean pqa;
  private boolean pqb;
  private boolean pqc;
  private final CgiEmojiTextSpamProxy pqd;
  private com.tencent.mm.plugin.emojicapture.model.b.d pqe;
  private final e pqf;
  private final Runnable pqg;
  private b.b pqh;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(372);
    pqi = new c.a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.pqh = paramb;
    this.ppF = paramb1;
    this.fQN = paramString;
    this.ppG = paramEmojiCaptureReporter;
    this.fPa = new com.tencent.mm.remoteservice.d(this.context);
    this.pqd = new CgiEmojiTextSpamProxy(this.fPa);
    this.ppA = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.pqf = new e(this);
    this.pqg = ((Runnable)new c(this));
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.ppA.thumbPath;
    String str2 = i.aKe(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.ghf() + str2;
    if (!i.eA(str3)) {
      i.lZ(str1, str3);
    }
    ac.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.Ge(str2);
    localEmojiInfo.aXJ("capture");
    localEmojiInfo.ajs(EmojiInfo.Jss);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.ceN();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.ceN();
    localEmojiInfo.a(EmojiInfo.a.Haw);
    localEmojiInfo.aV(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.fQN;
    localEmojiInfo.field_captureEnterTime = this.ppG.fWr;
    paramString = this.ppA.pnI;
    if (paramString != null) {}
    for (paramString = paramString.pmO;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.pnw;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.d.a.BH(paramInt);
      localEmojiInfo.field_captureScene = this.ppG.scene;
      paramString = EmojiCaptureProxy.pqx;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private final void cfE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject3 = new StringBuilder("start mix ");
    Object localObject1 = this.pqh.getVideoPlayView();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      ac.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.pqh.getItemContainer().getValidRect());
      localObject1 = this.pqh.getItemContainer().getAllItemViews();
      localObject4 = this.pqh.getItemContainer().getAllEmojiMd5();
      localObject5 = this.pqh.getItemContainer().getTextItem();
      if (localObject5 == null) {
        break label196;
      }
    }
    label196:
    for (int i = ((TextEditorItemView)localObject5).getTextColor();; i = 0)
    {
      localObject5 = this.pqh.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).c(null));
      }
      localObject1 = null;
      break;
    }
    if (this.pqe == null)
    {
      this.ppG.fQL = this.pqh.getItemContainer().getAttachedText();
      this.ppG.textColor = i;
      this.ppG.pmJ = this.poI;
      this.ppG.pmK = this.pqc;
      this.ppG.pmL = ((ArrayList)localObject4).size();
      this.ppG.cQQ = (System.currentTimeMillis() - this.ppG.fWr);
      EmojiCaptureReporter localEmojiCaptureReporter = this.ppG;
      f localf = this.ppA.pnI;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.pmO;
      }
      localEmojiCaptureReporter.pmO = ((String)localObject1);
      this.ppG.cez();
      localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
      localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.poQ;
      j = this.ppA.scene;
      l = ((EmojiInfo)localObject1).field_captureEnterTime;
      localObject2 = this.ppA.videoPath;
      localObject4 = this.pqh.getVideoPlayView();
      if (localObject4 != null) {}
      for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
      {
        this.pqe = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.poI, this.ppA.pnI, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.c.BL(this.ppA.scene)) {
          break;
        }
        ap.aB(this.pqg);
        ap.n(this.pqg, 60000L);
        localObject1 = this.ppF;
        localObject2 = this.context;
        localObject3 = this.context.getString(2131758259);
        k.g(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.c.b.fWn;
        com.tencent.mm.emoji.c.b.a(this.ppA.fWr, (com.tencent.mm.emoji.c.a)this.pqf);
        AppMethodBeat.o(363);
        return;
      }
    }
    localObject1 = EmojiCaptureProxy.pqx;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.ppG.fWr);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.poQ;
    int j = this.ppA.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.ppA.videoPath;
    Object localObject4 = this.pqh.getVideoPlayView();
    if (localObject4 != null) {}
    for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
    {
      this.pqe = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.poI, this.ppA.pnI, (EmojiInfo)localObject1);
      break;
    }
    EmojiCaptureUI.b.a.a(this.ppF, true);
    AppMethodBeat.o(363);
  }
  
  private final void f(String paramString, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(365);
    if (bs.isNullOrNil(paramString))
    {
      paramb.ay(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.pqd.cgiEmojiTextSpam(paramString, (d.g.a.b)new c.b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void kv(boolean paramBoolean)
  {
    AppMethodBeat.i(366);
    ac.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(paramBoolean)));
    if ((this.context instanceof Activity))
    {
      Object localObject = this.context;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(366);
        throw ((Throwable)localObject);
      }
      localObject = (Activity)localObject;
      if (paramBoolean)
      {
        ((Activity)localObject).getWindow().clearFlags(16);
        AppMethodBeat.o(366);
        return;
      }
      ((Activity)localObject).getWindow().addFlags(16);
    }
    AppMethodBeat.o(366);
  }
  
  public final boolean Iu()
  {
    AppMethodBeat.i(367);
    ac.i("MicroMsg.EditorPresenter", "onBack: " + this.pqh.bjw() + ' ' + this.pqh.ceG() + ' ' + this.pqh.ceH());
    if (this.pqh.bjw())
    {
      if (this.pqh.ceG())
      {
        this.pqh.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.pqh.ceH())
      {
        this.pqh.ks(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.poI = false;
      this.pqc = false;
      this.ppz = null;
      this.pqa = false;
      this.pqb = false;
      Object localObject = this.pqh.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        i.deleteFile((String)localObject);
        this.pqh.reset();
        localObject = this.pqh.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).ptG.removeAllViews();
        this.pqe = null;
        kv(true);
        this.ppF.cfH();
        EmojiCaptureReporter.a(9, this.ppG.fWr, 0L, 0L, 0L, 0L, 0, 0, this.ppG.scene);
        AppMethodBeat.o(367);
        return true;
      }
    }
    AppMethodBeat.o(367);
    return false;
  }
  
  public final void YE(final String paramString)
  {
    AppMethodBeat.i(357);
    ac.i("MicroMsg.EditorPresenter", "voice text callback");
    f(paramString, (d.g.a.b)new f(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final void a(com.tencent.mm.api.p paramp, Matrix paramMatrix)
  {
    AppMethodBeat.i(360);
    k.h(paramp, "emojiInfo");
    if ((paramp instanceof EmojiInfo))
    {
      if (this.pqh.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        t.makeText(this.context, 2131758213, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramp);
      locala.resume();
      this.pqh.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    k.h(paramb, "emojiCaptureInfo");
    ac.i("MicroMsg.EditorPresenter", "setup");
    this.ppA = paramb;
    this.ppZ = paramb.videoPath;
    this.poI = paramb.pmJ;
    this.textColor = paramb.pnK;
    this.pqh.a(paramb, paramb.videoPath, paramb.pnL, this.poI, (d.g.a.a)new h(this));
    com.tencent.mm.ac.c.b("EditorPresenter_setup", (d.g.a.a)new i(paramb));
    AppMethodBeat.o(356);
  }
  
  public final boolean ceC()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    ac.i("MicroMsg.EditorPresenter", "removeBg " + this.poI);
    if (!this.ppA.pnL)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.poI) {}
      for (;;)
      {
        this.poI = bool;
        localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.setRemoveBackground(this.poI);
        }
        bool = this.poI;
        AppMethodBeat.o(358);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean ceD()
  {
    AppMethodBeat.i(359);
    ac.i("MicroMsg.EditorPresenter", "speedUp " + this.pqc);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.pqc = true;
      AppMethodBeat.o(359);
      return true;
    }
    localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.pqc = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void ceE()
  {
    AppMethodBeat.i(362);
    if (!bs.isNullOrNil(this.fQN))
    {
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(ah.a.GRu, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.d.a(this.context).acJ(2131758071).acM(2131758070).a((DialogInterface.OnDismissListener)new d(this)).show();
        locala = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(ah.a.GRu, Boolean.TRUE);
        AppMethodBeat.o(362);
        return;
      }
    }
    cfE();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    ac.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.pqh.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.pqh.getItemContainer().pause();
    this.pqh.destroy();
    this.fPa.release();
    this.pqd.setCallback(null);
    localObject = com.tencent.mm.emoji.c.b.fWn;
    com.tencent.mm.emoji.c.b.b(this.ppA.fWr, (com.tencent.mm.emoji.c.a)this.pqf);
    AppMethodBeat.o(370);
  }
  
  public final void m(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    ac.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    f(paramString, (d.g.a.b)new j(this, com.tencent.mm.ui.base.p.a(this.context, (CharSequence)this.context.getString(2131760709), true, 0, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(368);
    ac.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.pqh.getItemContainer().pause();
    kv(false);
    AppMethodBeat.o(368);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    ac.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pqh.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.pqh.getItemContainer().resume();
    kv(true);
    AppMethodBeat.o(369);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(346);
      c.i(this.pql).cfJ();
      t.makeText(c.d(this.pql), 2131758258, 0).show();
      this.pql.resume();
      AppMethodBeat.o(346);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(347);
      c.l(this.pql);
      AppMethodBeat.o(347);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.emoji.c.a
  {
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(c.e parame, boolean paramBoolean, String paramString)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    f(c paramc, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    j(c paramc, com.tencent.mm.ui.base.p paramp, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, v.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(355);
      c.f(this.pql).a(true, ((TextEditorItemView)this.pqt.KUQ).getText(), ((TextEditorItemView)this.pqt.KUQ).getTextColor());
      EmojiCaptureReporter.a(13, c.k(this.pql).fWr, 0L, 0L, 0L, 0L, 0, 0, c.k(this.pql).scene);
      AppMethodBeat.o(355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */