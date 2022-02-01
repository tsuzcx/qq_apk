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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final c.a pTO;
  private Context context;
  private final com.tencent.mm.remoteservice.d giA;
  private final String gkn;
  private boolean pSj;
  private String pTF;
  private boolean pTG;
  private boolean pTH;
  private boolean pTI;
  private final CgiEmojiTextSpamProxy pTJ;
  private com.tencent.mm.plugin.emojicapture.model.b.d pTK;
  private final e pTL;
  private final Runnable pTM;
  private b.b pTN;
  private String pTa;
  private com.tencent.mm.plugin.emojicapture.model.a.b pTb;
  private EmojiCaptureUI.b pTg;
  private final EmojiCaptureReporter pTh;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(372);
    pTO = new c.a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.pTN = paramb;
    this.pTg = paramb1;
    this.gkn = paramString;
    this.pTh = paramEmojiCaptureReporter;
    this.giA = new com.tencent.mm.remoteservice.d(this.context);
    this.pTJ = new CgiEmojiTextSpamProxy(this.giA);
    this.pTb = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.pTL = new e(this);
    this.pTM = ((Runnable)new c(this));
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.pTb.thumbPath;
    String str2 = i.aPK(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.gzS() + str2;
    if (!i.fv(str3)) {
      i.mz(str1, str3);
    }
    ad.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.Jt(str2);
    localEmojiInfo.bed("capture");
    localEmojiInfo.amj(EmojiInfo.OeN);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.cjq();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.cjq();
    localEmojiInfo.a(EmojiInfo.a.INL);
    localEmojiInfo.aS(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.gkn;
    localEmojiInfo.field_captureEnterTime = this.pTh.gpU;
    paramString = this.pTb.pRi;
    if (paramString != null) {}
    for (paramString = paramString.pQo;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.pQW;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.d.a.Cp(paramInt);
      localEmojiInfo.field_captureScene = this.pTh.scene;
      paramString = EmojiCaptureProxy.pUd;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private final void ckh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject3 = new StringBuilder("start mix ");
    Object localObject1 = this.pTN.getVideoPlayView();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      ad.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.pTN.getItemContainer().getValidRect());
      localObject1 = this.pTN.getItemContainer().getAllItemViews();
      localObject4 = this.pTN.getItemContainer().getAllEmojiMd5();
      localObject5 = this.pTN.getItemContainer().getTextItem();
      if (localObject5 == null) {
        break label196;
      }
    }
    label196:
    for (int i = ((TextEditorItemView)localObject5).getTextColor();; i = 0)
    {
      localObject5 = this.pTN.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).c(null));
      }
      localObject1 = null;
      break;
    }
    if (this.pTK == null)
    {
      this.pTh.gkl = this.pTN.getItemContainer().getAttachedText();
      this.pTh.textColor = i;
      this.pTh.pQj = this.pSj;
      this.pTh.pQk = this.pTI;
      this.pTh.pQl = ((ArrayList)localObject4).size();
      this.pTh.dcg = (System.currentTimeMillis() - this.pTh.gpU);
      EmojiCaptureReporter localEmojiCaptureReporter = this.pTh;
      f localf = this.pTb.pRi;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.pQo;
      }
      localEmojiCaptureReporter.pQo = ((String)localObject1);
      this.pTh.cjc();
      localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
      localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.pSr;
      j = this.pTb.scene;
      l = ((EmojiInfo)localObject1).field_captureEnterTime;
      localObject2 = this.pTb.videoPath;
      localObject4 = this.pTN.getVideoPlayView();
      if (localObject4 != null) {}
      for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
      {
        this.pTK = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.pSj, this.pTb.pRi, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.c.Ct(this.pTb.scene)) {
          break;
        }
        aq.aA(this.pTM);
        aq.o(this.pTM, 60000L);
        localObject1 = this.pTg;
        localObject2 = this.context;
        localObject3 = this.context.getString(2131758259);
        d.g.b.p.g(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.c.b.gpQ;
        com.tencent.mm.emoji.c.b.a(this.pTb.gpU, (com.tencent.mm.emoji.c.a)this.pTL);
        AppMethodBeat.o(363);
        return;
      }
    }
    localObject1 = EmojiCaptureProxy.pUd;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.pTh.gpU);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.pSr;
    int j = this.pTb.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.pTb.videoPath;
    Object localObject4 = this.pTN.getVideoPlayView();
    if (localObject4 != null) {}
    for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
    {
      this.pTK = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.pSj, this.pTb.pRi, (EmojiInfo)localObject1);
      break;
    }
    EmojiCaptureUI.b.a.a(this.pTg, true);
    AppMethodBeat.o(363);
  }
  
  private final void f(String paramString, d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(365);
    if (bt.isNullOrNil(paramString))
    {
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.pTJ.cgiEmojiTextSpam(paramString, (d.g.a.b)new c.b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void kG(boolean paramBoolean)
  {
    AppMethodBeat.i(366);
    ad.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(paramBoolean)));
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
  
  public final boolean JU()
  {
    AppMethodBeat.i(367);
    ad.i("MicroMsg.EditorPresenter", "onBack: " + this.pTN.bni() + ' ' + this.pTN.cjj() + ' ' + this.pTN.cjk());
    if (this.pTN.bni())
    {
      if (this.pTN.cjj())
      {
        this.pTN.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.pTN.cjk())
      {
        this.pTN.kD(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.pSj = false;
      this.pTI = false;
      this.pTa = null;
      this.pTG = false;
      this.pTH = false;
      Object localObject = this.pTN.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        i.deleteFile((String)localObject);
        this.pTN.reset();
        localObject = this.pTN.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).pXk.removeAllViews();
        this.pTK = null;
        kG(true);
        this.pTg.ckk();
        EmojiCaptureReporter.a(9, this.pTh.gpU, 0L, 0L, 0L, 0L, 0, 0, this.pTh.scene);
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
      if (this.pTN.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        t.makeText(this.context, 2131758213, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramp);
      locala.resume();
      this.pTN.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    d.g.b.p.h(paramb, "emojiCaptureInfo");
    ad.i("MicroMsg.EditorPresenter", "setup");
    this.pTb = paramb;
    this.pTF = paramb.videoPath;
    this.pSj = paramb.pQj;
    this.textColor = paramb.pRk;
    this.pTN.a(paramb, paramb.videoPath, paramb.pRl, this.pSj, (d.g.a.a)new h(this));
    com.tencent.mm.ad.c.b("EditorPresenter_setup", (d.g.a.a)new i(paramb));
    AppMethodBeat.o(356);
  }
  
  public final void ack(final String paramString)
  {
    AppMethodBeat.i(357);
    ad.i("MicroMsg.EditorPresenter", "voice text callback");
    f(paramString, (d.g.a.b)new f(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final boolean cjf()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    ad.i("MicroMsg.EditorPresenter", "removeBg " + this.pSj);
    if (!this.pTb.pRl)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.pSj) {}
      for (;;)
      {
        this.pSj = bool;
        localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.setRemoveBackground(this.pSj);
        }
        bool = this.pSj;
        AppMethodBeat.o(358);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean cjg()
  {
    AppMethodBeat.i(359);
    ad.i("MicroMsg.EditorPresenter", "speedUp " + this.pTI);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.pTI = true;
      AppMethodBeat.o(359);
      return true;
    }
    localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.pTI = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void cjh()
  {
    AppMethodBeat.i(362);
    if (!bt.isNullOrNil(this.gkn))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      d.g.b.p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(al.a.IDY, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.d.a(this.context).afi(2131758071).afl(2131758070).a((DialogInterface.OnDismissListener)new d(this)).show();
        locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        d.g.b.p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(al.a.IDY, Boolean.TRUE);
        AppMethodBeat.o(362);
        return;
      }
    }
    ckh();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    ad.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.pTN.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.pTN.getItemContainer().pause();
    this.pTN.destroy();
    this.giA.release();
    this.pTJ.setCallback(null);
    localObject = com.tencent.mm.emoji.c.b.gpQ;
    com.tencent.mm.emoji.c.b.b(this.pTb.gpU, (com.tencent.mm.emoji.c.a)this.pTL);
    AppMethodBeat.o(370);
  }
  
  public final void m(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    ad.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    f(paramString, (d.g.a.b)new j(this, com.tencent.mm.ui.base.p.a(this.context, (CharSequence)this.context.getString(2131760709), true, 0, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(368);
    ad.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.pTN.getItemContainer().pause();
    kG(false);
    AppMethodBeat.o(368);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    ad.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.pTN.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.pTN.getItemContainer().resume();
    kG(true);
    AppMethodBeat.o(369);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(346);
      c.i(this.pTR).ckm();
      t.makeText(c.d(this.pTR), 2131758258, 0).show();
      this.pTR.resume();
      AppMethodBeat.o(346);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(347);
      c.l(this.pTR);
      AppMethodBeat.o(347);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.emoji.c.a
  {
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<Boolean, z>
  {
    f(c paramc, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<Boolean, z>
  {
    j(c paramc, com.tencent.mm.ui.base.p paramp, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, y.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(355);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      c.f(this.pTR).a(true, ((TextEditorItemView)this.pTZ.MLV).getText(), ((TextEditorItemView)this.pTZ.MLV).getTextColor());
      EmojiCaptureReporter.a(13, c.k(this.pTR).gpU, 0L, 0L, 0L, 0L, 0, 0, c.k(this.pTR).scene);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */