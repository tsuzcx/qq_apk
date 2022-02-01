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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.g.b.v.e;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final a oMO;
  private Context context;
  private final com.tencent.mm.remoteservice.d fLo;
  private final String fNc;
  private boolean oLo;
  private String oMF;
  private boolean oMG;
  private boolean oMH;
  private boolean oMI;
  private final CgiEmojiTextSpamProxy oMJ;
  private com.tencent.mm.plugin.emojicapture.model.b.d oMK;
  private final e oML;
  private final Runnable oMM;
  private b.b oMN;
  private String oMf;
  private com.tencent.mm.plugin.emojicapture.model.a.b oMg;
  private EmojiCaptureUI.b oMl;
  private final EmojiCaptureReporter oMm;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(372);
    oMO = new a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.oMN = paramb;
    this.oMl = paramb1;
    this.fNc = paramString;
    this.oMm = paramEmojiCaptureReporter;
    this.fLo = new com.tencent.mm.remoteservice.d(this.context);
    this.oMJ = new CgiEmojiTextSpamProxy(this.fLo);
    this.oMg = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.oML = new e(this);
    this.oMM = ((Runnable)new c(this));
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.oMg.thumbPath;
    String str2 = i.aEN(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.gac() + str2;
    if (!i.eK(str3)) {
      i.lC(str1, str3);
    }
    ad.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.Cb(str2);
    localEmojiInfo.aWh("capture");
    localEmojiInfo.aim(EmojiInfo.LBQ);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.bXA();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.bXA();
    localEmojiInfo.a(EmojiInfo.a.FBw);
    localEmojiInfo.bc(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.fNc;
    localEmojiInfo.field_captureEnterTime = this.oMm.fSw;
    paramString = this.oMg.oKk;
    if (paramString != null) {}
    for (paramString = paramString.oJp;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.oJY;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.d.a.AP(paramInt);
      localEmojiInfo.field_captureScene = this.oMm.scene;
      paramString = EmojiCaptureProxy.oNd;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private final void bYr()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject3 = new StringBuilder("start mix ");
    Object localObject1 = this.oMN.getVideoPlayView();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      ad.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.oMN.getItemContainer().getValidRect());
      localObject1 = this.oMN.getItemContainer().getAllItemViews();
      localObject4 = this.oMN.getItemContainer().getAllEmojiMd5();
      localObject5 = this.oMN.getItemContainer().getTextItem();
      if (localObject5 == null) {
        break label196;
      }
    }
    label196:
    for (int i = ((TextEditorItemView)localObject5).getTextColor();; i = 0)
    {
      localObject5 = this.oMN.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).c(null));
      }
      localObject1 = null;
      break;
    }
    if (this.oMK == null)
    {
      this.oMm.fNa = this.oMN.getItemContainer().getAttachedText();
      this.oMm.textColor = i;
      this.oMm.oJj = this.oLo;
      this.oMm.oJk = this.oMI;
      this.oMm.oJl = ((ArrayList)localObject4).size();
      this.oMm.cTt = (System.currentTimeMillis() - this.oMm.fSw);
      EmojiCaptureReporter localEmojiCaptureReporter = this.oMm;
      com.tencent.mm.sticker.e locale = this.oMg.oKk;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.oJp;
      }
      localEmojiCaptureReporter.oJp = ((String)localObject1);
      this.oMm.bXm();
      localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
      localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.oLw;
      j = this.oMg.scene;
      l = ((EmojiInfo)localObject1).field_captureEnterTime;
      localObject2 = this.oMg.videoPath;
      localObject4 = this.oMN.getVideoPlayView();
      if (localObject4 != null) {}
      for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
      {
        this.oMK = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.oLo, this.oMg.oKk, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.c.AT(this.oMg.scene)) {
          break;
        }
        aq.az(this.oMM);
        aq.n(this.oMM, 60000L);
        localObject1 = this.oMl;
        localObject2 = this.context;
        localObject3 = this.context.getString(2131758259);
        k.g(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.c.b.fSs;
        com.tencent.mm.emoji.c.b.a(this.oMg.fSw, (com.tencent.mm.emoji.c.a)this.oML);
        AppMethodBeat.o(363);
        return;
      }
    }
    localObject1 = EmojiCaptureProxy.oNd;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.oMm.fSw);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.oLw;
    int j = this.oMg.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.oMg.videoPath;
    Object localObject4 = this.oMN.getVideoPlayView();
    if (localObject4 != null) {}
    for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
    {
      this.oMK = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.oLo, this.oMg.oKk, (EmojiInfo)localObject1);
      break;
    }
    EmojiCaptureUI.b.a.a(this.oMl, true);
    AppMethodBeat.o(363);
  }
  
  private final void e(String paramString, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(365);
    if (bt.isNullOrNil(paramString))
    {
      paramb.aA(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.oMJ.cgiEmojiTextSpam(paramString, (d.g.a.b)new b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void jS(boolean paramBoolean)
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
  
  public final boolean IL()
  {
    AppMethodBeat.i(367);
    ad.i("MicroMsg.EditorPresenter", "onBack: " + this.oMN.bcB() + ' ' + this.oMN.bXt() + ' ' + this.oMN.bXu());
    if (this.oMN.bcB())
    {
      if (this.oMN.bXt())
      {
        this.oMN.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.oMN.bXu())
      {
        this.oMN.jP(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.oLo = false;
      this.oMI = false;
      this.oMf = null;
      this.oMG = false;
      this.oMH = false;
      Object localObject = this.oMN.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        i.deleteFile((String)localObject);
        this.oMN.reset();
        localObject = this.oMN.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).oQt.removeAllViews();
        this.oMK = null;
        jS(true);
        this.oMl.bYt();
        EmojiCaptureReporter.a(9, this.oMm.fSw, 0L, 0L, 0L, 0L, 0, 0, this.oMm.scene);
        AppMethodBeat.o(367);
        return true;
      }
    }
    AppMethodBeat.o(367);
    return false;
  }
  
  public final void Us(final String paramString)
  {
    AppMethodBeat.i(357);
    ad.i("MicroMsg.EditorPresenter", "voice text callback");
    e(paramString, (d.g.a.b)new f(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final void a(com.tencent.mm.api.p paramp, Matrix paramMatrix)
  {
    AppMethodBeat.i(360);
    k.h(paramp, "emojiInfo");
    if ((paramp instanceof EmojiInfo))
    {
      if (this.oMN.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        t.makeText(this.context, 2131758213, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramp);
      locala.resume();
      this.oMN.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    k.h(paramb, "emojiCaptureInfo");
    ad.i("MicroMsg.EditorPresenter", "setup");
    this.oMg = paramb;
    this.oMF = paramb.videoPath;
    this.oLo = paramb.oJj;
    this.textColor = paramb.oKm;
    this.oMN.a(paramb, paramb.videoPath, paramb.oKn, this.oLo, (d.g.a.a)new h(this));
    com.tencent.mm.ad.c.b("EditorPresenter_setup", (d.g.a.a)new i(paramb));
    AppMethodBeat.o(356);
  }
  
  public final boolean bXp()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    ad.i("MicroMsg.EditorPresenter", "removeBg " + this.oLo);
    if (!this.oMg.oKn)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.oLo) {}
      for (;;)
      {
        this.oLo = bool;
        localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.setRemoveBackground(this.oLo);
        }
        bool = this.oLo;
        AppMethodBeat.o(358);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean bXq()
  {
    AppMethodBeat.i(359);
    ad.i("MicroMsg.EditorPresenter", "speedUp " + this.oMI);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.oMI = true;
      AppMethodBeat.o(359);
      return true;
    }
    localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.oMI = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void bXr()
  {
    AppMethodBeat.i(362);
    if (!bt.isNullOrNil(this.fNc))
    {
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(ae.a.FtA, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.d.a(this.context).aay(2131758071).aaB(2131758070).a((DialogInterface.OnDismissListener)new d(this)).show();
        locala = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(ae.a.FtA, Boolean.TRUE);
        AppMethodBeat.o(362);
        return;
      }
    }
    bYr();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    ad.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.oMN.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.oMN.getItemContainer().pause();
    this.oMN.destroy();
    this.fLo.release();
    this.oMJ.setCallback(null);
    localObject = com.tencent.mm.emoji.c.b.fSs;
    com.tencent.mm.emoji.c.b.b(this.oMg.fSw, (com.tencent.mm.emoji.c.a)this.oML);
    AppMethodBeat.o(370);
  }
  
  public final void m(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    ad.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    e(paramString, (d.g.a.b)new j(this, com.tencent.mm.ui.base.p.a(this.context, (CharSequence)this.context.getString(2131760709), true, 0, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(368);
    ad.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.oMN.getItemContainer().pause();
    jS(false);
    AppMethodBeat.o(368);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    ad.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.oMN.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.oMN.getItemContainer().resume();
    jS(true);
    AppMethodBeat.o(369);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    b(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(346);
      c.i(this.oMR).bYv();
      t.makeText(c.d(this.oMR), 2131758258, 0).show();
      this.oMR.resume();
      AppMethodBeat.o(346);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(347);
      c.l(this.oMR);
      AppMethodBeat.o(347);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.emoji.c.a
  {
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    f(c paramc, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    j(c paramc, com.tencent.mm.ui.base.p paramp, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, v.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(355);
      c.f(this.oMR).a(true, ((TextEditorItemView)this.oMZ.Jhw).getText(), ((TextEditorItemView)this.oMZ.Jhw).getTextColor());
      EmojiCaptureReporter.a(13, c.k(this.oMR).fSw, 0L, 0L, 0L, 0L, 0, 0, c.k(this.oMR).scene);
      AppMethodBeat.o(355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */