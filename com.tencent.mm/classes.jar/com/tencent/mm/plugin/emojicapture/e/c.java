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
import com.tencent.mm.api.r;
import com.tencent.mm.plugin.emojicapture.a.i;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final a uWW;
  private Context context;
  private final com.tencent.mm.remoteservice.d jGJ;
  private final String jIx;
  private int textColor;
  private boolean uVr;
  private String uWN;
  private boolean uWO;
  private boolean uWP;
  private boolean uWQ;
  private final CgiEmojiTextSpamProxy uWR;
  private com.tencent.mm.plugin.emojicapture.model.b.d uWS;
  private final e uWT;
  private final Runnable uWU;
  private b.b uWV;
  private String uWi;
  private com.tencent.mm.plugin.emojicapture.model.a.b uWj;
  private EmojiCaptureUI.b uWo;
  private final EmojiCaptureReporter uWp;
  
  static
  {
    AppMethodBeat.i(372);
    uWW = new a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.uWV = paramb;
    this.uWo = paramb1;
    this.jIx = paramString;
    this.uWp = paramEmojiCaptureReporter;
    this.jGJ = new com.tencent.mm.remoteservice.d(this.context);
    this.uWR = new CgiEmojiTextSpamProxy(this.jGJ);
    this.uWj = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.uWT = new e(this);
    this.uWU = ((Runnable)new c(this));
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.uWj.thumbPath;
    String str2 = u.buc(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.ifj() + str2;
    if (!u.agG(str3)) {
      u.on(str1, str3);
    }
    Log.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.setMd5(str2);
    localEmojiInfo.bIR("capture");
    localEmojiInfo.aGn(EmojiInfo.YCx);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.cXr();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.cXr();
    localEmojiInfo.a(EmojiInfo.a.VIj);
    localEmojiInfo.bA(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.jIx;
    localEmojiInfo.field_captureEnterTime = this.uWp.jPf;
    paramString = this.uWj.uUr;
    if (paramString != null) {}
    for (paramString = paramString.uTz;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.d.a.JT(paramInt);
      localEmojiInfo.field_captureScene = this.uWp.scene;
      paramString = EmojiCaptureProxy.uXl;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private final void cYh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject3 = new StringBuilder("start mix ");
    Object localObject1 = this.uWV.getVideoPlayView();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      Log.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.uWV.getItemContainer().getValidRect());
      localObject1 = this.uWV.getItemContainer().getAllItemViews();
      localObject4 = this.uWV.getItemContainer().getAllEmojiMd5();
      localObject5 = this.uWV.getItemContainer().getTextItem();
      if (localObject5 == null) {
        break label196;
      }
    }
    label196:
    for (int i = ((TextEditorItemView)localObject5).getTextColor();; i = 0)
    {
      localObject5 = this.uWV.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).c(null));
      }
      localObject1 = null;
      break;
    }
    if (this.uWS == null)
    {
      this.uWp.jIv = this.uWV.getItemContainer().getAttachedText();
      this.uWp.textColor = i;
      this.uWp.uTu = this.uVr;
      this.uWp.uTv = this.uWQ;
      this.uWp.uTw = ((ArrayList)localObject4).size();
      this.uWp.fmH = (System.currentTimeMillis() - this.uWp.jPf);
      EmojiCaptureReporter localEmojiCaptureReporter = this.uWp;
      f localf = this.uWj.uUr;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.uTz;
      }
      localEmojiCaptureReporter.uTz = ((String)localObject1);
      this.uWp.cXd();
      localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
      localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.uVz;
      j = this.uWj.scene;
      l = ((EmojiInfo)localObject1).field_captureEnterTime;
      localObject2 = this.uWj.videoPath;
      localObject4 = this.uWV.getVideoPlayView();
      if (localObject4 != null) {}
      for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
      {
        this.uWS = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.uVr, this.uWj.uUr, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.c.JX(this.uWj.scene)) {
          break;
        }
        MMHandlerThread.removeRunnable(this.uWU);
        MMHandlerThread.postToMainThreadDelayed(this.uWU, 60000L);
        localObject1 = this.uWo;
        localObject2 = this.context;
        localObject3 = this.context.getString(a.i.uTg);
        p.j(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.d.b.jPc;
        com.tencent.mm.emoji.d.b.a(this.uWj.jPf, (com.tencent.mm.emoji.d.a)this.uWT);
        AppMethodBeat.o(363);
        return;
      }
    }
    localObject1 = EmojiCaptureProxy.uXl;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.uWp.jPf);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.uVz;
    int j = this.uWj.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.uWj.videoPath;
    Object localObject4 = this.uWV.getVideoPlayView();
    if (localObject4 != null) {}
    for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
    {
      this.uWS = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.uVr, this.uWj.uUr, (EmojiInfo)localObject1);
      break;
    }
    EmojiCaptureUI.b.a.a(this.uWo, true);
    AppMethodBeat.o(363);
  }
  
  private final void h(String paramString, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(365);
    if (Util.isNullOrNil(paramString))
    {
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.uWR.cgiEmojiTextSpam(paramString, (kotlin.g.a.b)new b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void mT(boolean paramBoolean)
  {
    AppMethodBeat.i(366);
    Log.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(paramBoolean)));
    if ((this.context instanceof Activity))
    {
      Object localObject = this.context;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
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
  
  public final boolean YD()
  {
    AppMethodBeat.i(367);
    Log.i("MicroMsg.EditorPresenter", "onBack: " + this.uWV.bVd() + ' ' + this.uWV.cXk() + ' ' + this.uWV.cXl());
    if (this.uWV.bVd())
    {
      if (this.uWV.cXk())
      {
        this.uWV.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.uWV.cXl())
      {
        this.uWV.mP(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.uVr = false;
      this.uWQ = false;
      this.uWi = null;
      this.uWO = false;
      this.uWP = false;
      Object localObject = this.uWV.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        u.deleteFile((String)localObject);
        this.uWV.reset();
        localObject = this.uWV.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).var.removeAllViews();
        this.uWS = null;
        mT(true);
        this.uWo.cYk();
        EmojiCaptureReporter.a(9, this.uWp.jPf, 0L, 0L, 0L, 0L, 0, 0, this.uWp.scene);
        AppMethodBeat.o(367);
        return true;
      }
    }
    AppMethodBeat.o(367);
    return false;
  }
  
  public final void a(r paramr, Matrix paramMatrix)
  {
    AppMethodBeat.i(360);
    p.k(paramr, "emojiInfo");
    if ((paramr instanceof EmojiInfo))
    {
      if (this.uWV.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        w.makeText(this.context, a.i.uSY, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramr);
      locala.resume();
      this.uWV.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    p.k(paramb, "emojiCaptureInfo");
    Log.i("MicroMsg.EditorPresenter", "setup");
    this.uWj = paramb;
    this.uWN = paramb.videoPath;
    this.uVr = paramb.uTu;
    this.textColor = paramb.uUt;
    this.uWV.a(paramb, paramb.videoPath, paramb.uUu, this.uVr, (kotlin.g.a.a)new h(this));
    com.tencent.mm.ae.d.b("EditorPresenter_setup", (kotlin.g.a.a)new i(paramb));
    AppMethodBeat.o(356);
  }
  
  public final void avi(final String paramString)
  {
    AppMethodBeat.i(357);
    Log.i("MicroMsg.EditorPresenter", "voice text callback");
    h(paramString, (kotlin.g.a.b)new f(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final boolean cXg()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    Log.i("MicroMsg.EditorPresenter", "removeBg " + this.uVr);
    if (!this.uWj.uUu)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.uVr) {}
      for (;;)
      {
        this.uVr = bool;
        localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.setRemoveBackground(this.uVr);
        }
        bool = this.uVr;
        AppMethodBeat.o(358);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean cXh()
  {
    AppMethodBeat.i(359);
    Log.i("MicroMsg.EditorPresenter", "speedUp " + this.uWQ);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.uWQ = true;
      AppMethodBeat.o(359);
      return true;
    }
    localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.uWQ = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void cXi()
  {
    AppMethodBeat.i(362);
    if (!Util.isNullOrNil(this.jIx))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(ar.a.Vvl, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.d.a(this.context).ayg(a.i.uSR).ayj(a.i.uSQ).a((DialogInterface.OnDismissListener)new d(this)).show();
        locala = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        p.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(ar.a.Vvl, Boolean.TRUE);
        AppMethodBeat.o(362);
        return;
      }
    }
    cYh();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    Log.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.uWV.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.uWV.getItemContainer().pause();
    this.uWV.destroy();
    this.jGJ.release();
    this.uWR.setCallback(null);
    localObject = com.tencent.mm.emoji.d.b.jPc;
    com.tencent.mm.emoji.d.b.b(this.uWj.jPf, (com.tencent.mm.emoji.d.a)this.uWT);
    AppMethodBeat.o(370);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(368);
    Log.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.uWV.getItemContainer().pause();
    mT(false);
    AppMethodBeat.o(368);
  }
  
  public final void r(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    Log.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    h(paramString, (kotlin.g.a.b)new j(this, s.a(this.context, (CharSequence)this.context.getString(a.i.loading_tips), true, 0, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    Log.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.uWV.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.uWV.getItemContainer().resume();
    mT(true);
    AppMethodBeat.o(369);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(346);
      c.i(this.uWZ).cYm();
      w.makeText(c.d(this.uWZ), a.i.uTf, 0).show();
      this.uWZ.resume();
      AppMethodBeat.o(346);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(347);
      c.l(this.uWZ);
      AppMethodBeat.o(347);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.emoji.d.a
  {
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(c.e parame, boolean paramBoolean, String paramString)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(c paramc, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    j(c paramc, s params, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, aa.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(355);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      c.f(this.uWZ).a(true, ((TextEditorItemView)this.uXh.aaBC).getText(), ((TextEditorItemView)this.uXh.aaBC).getTextColor());
      EmojiCaptureReporter.a(13, c.k(this.uWZ).jPf, 0L, 0L, 0L, 0L, 0, 0, c.k(this.uWZ).scene);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */