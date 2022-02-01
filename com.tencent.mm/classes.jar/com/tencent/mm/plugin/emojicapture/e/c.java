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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final c.a qat;
  private Context context;
  private final com.tencent.mm.remoteservice.d gkS;
  private final String gmH;
  private boolean pYO;
  private String pZF;
  private com.tencent.mm.plugin.emojicapture.model.a.b pZG;
  private EmojiCaptureUI.b pZL;
  private final EmojiCaptureReporter pZM;
  private String qak;
  private boolean qal;
  private boolean qam;
  private boolean qan;
  private final CgiEmojiTextSpamProxy qao;
  private com.tencent.mm.plugin.emojicapture.model.b.d qap;
  private final e qaq;
  private final Runnable qar;
  private b.b qas;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(372);
    qat = new c.a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.qas = paramb;
    this.pZL = paramb1;
    this.gmH = paramString;
    this.pZM = paramEmojiCaptureReporter;
    this.gkS = new com.tencent.mm.remoteservice.d(this.context);
    this.qao = new CgiEmojiTextSpamProxy(this.gkS);
    this.pZG = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.qaq = new e(this);
    this.qar = ((Runnable)new c(this));
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.pZG.thumbPath;
    String str2 = o.aRh(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.fSS() + str2;
    if (!o.fB(str3)) {
      o.mF(str1, str3);
    }
    ae.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.JS(str2);
    localEmojiInfo.bfN("capture");
    localEmojiInfo.agn(EmojiInfo.OzU);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.ckG();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.ckG();
    localEmojiInfo.a(EmojiInfo.a.Jis);
    localEmojiInfo.be(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.gmH;
    localEmojiInfo.field_captureEnterTime = this.pZM.gsp;
    paramString = this.pZG.pXN;
    if (paramString != null) {}
    for (paramString = paramString.pWT;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.pXB;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.d.a.CB(paramInt);
      localEmojiInfo.field_captureScene = this.pZM.scene;
      paramString = EmojiCaptureProxy.qaI;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private final void clx()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject3 = new StringBuilder("start mix ");
    Object localObject1 = this.qas.getVideoPlayView();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      ae.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.qas.getItemContainer().getValidRect());
      localObject1 = this.qas.getItemContainer().getAllItemViews();
      localObject4 = this.qas.getItemContainer().getAllEmojiMd5();
      localObject5 = this.qas.getItemContainer().getTextItem();
      if (localObject5 == null) {
        break label196;
      }
    }
    label196:
    for (int i = ((TextEditorItemView)localObject5).getTextColor();; i = 0)
    {
      localObject5 = this.qas.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).c(null));
      }
      localObject1 = null;
      break;
    }
    if (this.qap == null)
    {
      this.pZM.gmF = this.qas.getItemContainer().getAttachedText();
      this.pZM.textColor = i;
      this.pZM.pWO = this.pYO;
      this.pZM.pWP = this.qan;
      this.pZM.pWQ = ((ArrayList)localObject4).size();
      this.pZM.ddi = (System.currentTimeMillis() - this.pZM.gsp);
      EmojiCaptureReporter localEmojiCaptureReporter = this.pZM;
      f localf = this.pZG.pXN;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.pWT;
      }
      localEmojiCaptureReporter.pWT = ((String)localObject1);
      this.pZM.cks();
      localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
      localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.pYW;
      j = this.pZG.scene;
      l = ((EmojiInfo)localObject1).field_captureEnterTime;
      localObject2 = this.pZG.videoPath;
      localObject4 = this.qas.getVideoPlayView();
      if (localObject4 != null) {}
      for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
      {
        this.qap = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.pYO, this.pZG.pXN, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.c.CF(this.pZG.scene)) {
          break;
        }
        ar.ay(this.qar);
        ar.o(this.qar, 60000L);
        localObject1 = this.pZL;
        localObject2 = this.context;
        localObject3 = this.context.getString(2131758259);
        d.g.b.p.g(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.c.b.gsl;
        com.tencent.mm.emoji.c.b.a(this.pZG.gsp, (com.tencent.mm.emoji.c.a)this.qaq);
        AppMethodBeat.o(363);
        return;
      }
    }
    localObject1 = EmojiCaptureProxy.qaI;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.pZM.gsp);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.pYW;
    int j = this.pZG.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.pZG.videoPath;
    Object localObject4 = this.qas.getVideoPlayView();
    if (localObject4 != null) {}
    for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
    {
      this.qap = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.pYO, this.pZG.pXN, (EmojiInfo)localObject1);
      break;
    }
    EmojiCaptureUI.b.a.a(this.pZL, true);
    AppMethodBeat.o(363);
  }
  
  private final void f(String paramString, d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(365);
    if (bu.isNullOrNil(paramString))
    {
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.qao.cgiEmojiTextSpam(paramString, (d.g.a.b)new c.b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void kG(boolean paramBoolean)
  {
    AppMethodBeat.i(366);
    ae.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(paramBoolean)));
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
  
  public final boolean Kc()
  {
    AppMethodBeat.i(367);
    ae.i("MicroMsg.EditorPresenter", "onBack: " + this.qas.bnS() + ' ' + this.qas.ckz() + ' ' + this.qas.ckA());
    if (this.qas.bnS())
    {
      if (this.qas.ckz())
      {
        this.qas.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.qas.ckA())
      {
        this.qas.kC(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.pYO = false;
      this.qan = false;
      this.pZF = null;
      this.qal = false;
      this.qam = false;
      Object localObject = this.qas.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        o.deleteFile((String)localObject);
        this.qas.reset();
        localObject = this.qas.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).qdP.removeAllViews();
        this.qap = null;
        kG(true);
        this.pZL.clA();
        EmojiCaptureReporter.a(9, this.pZM.gsp, 0L, 0L, 0L, 0L, 0, 0, this.pZM.scene);
        AppMethodBeat.o(367);
        return true;
      }
    }
    AppMethodBeat.o(367);
    return false;
  }
  
  public final void a(com.tencent.mm.api.p paramp, Matrix paramMatrix)
  {
    AppMethodBeat.i(360);
    d.g.b.p.h(paramp, "emojiInfo");
    if ((paramp instanceof EmojiInfo))
    {
      if (this.qas.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        t.makeText(this.context, 2131758213, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramp);
      locala.resume();
      this.qas.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    d.g.b.p.h(paramb, "emojiCaptureInfo");
    ae.i("MicroMsg.EditorPresenter", "setup");
    this.pZG = paramb;
    this.qak = paramb.videoPath;
    this.pYO = paramb.pWO;
    this.textColor = paramb.pXP;
    this.qas.a(paramb, paramb.videoPath, paramb.pXQ, this.pYO, (d.g.a.a)new h(this));
    com.tencent.mm.ac.c.b("EditorPresenter_setup", (d.g.a.a)new i(paramb));
    AppMethodBeat.o(356);
  }
  
  public final void adb(final String paramString)
  {
    AppMethodBeat.i(357);
    ae.i("MicroMsg.EditorPresenter", "voice text callback");
    f(paramString, (d.g.a.b)new f(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final boolean ckv()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    ae.i("MicroMsg.EditorPresenter", "removeBg " + this.pYO);
    if (!this.pZG.pXQ)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.pYO) {}
      for (;;)
      {
        this.pYO = bool;
        localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.setRemoveBackground(this.pYO);
        }
        bool = this.pYO;
        AppMethodBeat.o(358);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean ckw()
  {
    AppMethodBeat.i(359);
    ae.i("MicroMsg.EditorPresenter", "speedUp " + this.qan);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.qan = true;
      AppMethodBeat.o(359);
      return true;
    }
    localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.qan = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void ckx()
  {
    AppMethodBeat.i(362);
    if (!bu.isNullOrNil(this.gmH))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      d.g.b.p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(am.a.IYy, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.d.a(this.context).afR(2131758071).afU(2131758070).a((DialogInterface.OnDismissListener)new d(this)).show();
        locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        d.g.b.p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(am.a.IYy, Boolean.TRUE);
        AppMethodBeat.o(362);
        return;
      }
    }
    clx();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    ae.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.qas.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.qas.getItemContainer().pause();
    this.qas.destroy();
    this.gkS.release();
    this.qao.setCallback(null);
    localObject = com.tencent.mm.emoji.c.b.gsl;
    com.tencent.mm.emoji.c.b.b(this.pZG.gsp, (com.tencent.mm.emoji.c.a)this.qaq);
    AppMethodBeat.o(370);
  }
  
  public final void m(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    ae.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    f(paramString, (d.g.a.b)new j(this, com.tencent.mm.ui.base.p.a(this.context, (CharSequence)this.context.getString(2131760709), true, 0, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(368);
    ae.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.qas.getItemContainer().pause();
    kG(false);
    AppMethodBeat.o(368);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    ae.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.qas.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.qas.getItemContainer().resume();
    kG(true);
    AppMethodBeat.o(369);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(346);
      c.i(this.qaw).clC();
      t.makeText(c.d(this.qaw), 2131758258, 0).show();
      this.qaw.resume();
      AppMethodBeat.o(346);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(347);
      c.l(this.qaw);
      AppMethodBeat.o(347);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.emoji.c.a
  {
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(c.e parame, boolean paramBoolean, String paramString)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<Boolean, z>
  {
    f(c paramc, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<Boolean, z>
  {
    j(c paramc, com.tencent.mm.ui.base.p paramp, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, y.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(355);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      c.f(this.qaw).a(true, ((TextEditorItemView)this.qaE.NiY).getText(), ((TextEditorItemView)this.qaE.NiY).getTextColor());
      EmojiCaptureReporter.a(13, c.k(this.qaw).gsp, 0L, 0L, 0L, 0L, 0, 0, c.k(this.qaw).scene);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */