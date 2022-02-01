package com.tencent.mm.plugin.emojicapture.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.model.d.a;
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
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements b.a
{
  public static final c.a yjk;
  private Context context;
  private String oYm;
  private final com.tencent.mm.remoteservice.d pfZ;
  private int textColor;
  private boolean yhT;
  private EmojiCaptureUI.b yiH;
  private final EmojiCaptureReporter yiI;
  private String yiM;
  private com.tencent.mm.plugin.emojicapture.model.a.b yiN;
  private b.b yjl;
  private final String yjm;
  private boolean yjn;
  private boolean yjo;
  private boolean yjp;
  private final CgiEmojiTextSpamProxy yjq;
  private com.tencent.mm.plugin.emojicapture.model.b.d yjr;
  private final c yjs;
  private final Runnable yjt;
  
  static
  {
    AppMethodBeat.i(372);
    yjk = new c.a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.yjl = paramb;
    this.yiH = paramb1;
    this.yjm = paramString;
    this.yiI = paramEmojiCaptureReporter;
    this.pfZ = new com.tencent.mm.remoteservice.d(this.context);
    this.yjq = new CgiEmojiTextSpamProxy(this.pfZ);
    this.yiN = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.yjs = new c(this);
    this.yjt = new c..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.yiN.thumbPath;
    String str2 = y.bub(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = s.X(EmojiInfo.kMp(), str2);
    if (!y.ZC(str3)) {
      y.O(str1, str3, false);
    }
    Log.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.field_md5 = str2;
    localEmojiInfo.field_groupId = "capture";
    localEmojiInfo.field_catalog = EmojiInfo.aklG;
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.dDH();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.dDH();
    localEmojiInfo.a(EmojiInfo.a.admf);
    localEmojiInfo.cb(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.yjm;
    localEmojiInfo.field_captureEnterTime = this.yiI.mnX;
    paramString = this.yiN.yhc;
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.ygo)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      localEmojiInfo.field_attachTextColor = d.a.KR(paramInt);
      localEmojiInfo.field_captureScene = this.yiI.scene;
      paramString = EmojiCaptureProxy.yjA;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(269319);
    s.u(paramc, "this$0");
    paramc.yiH.dEE();
    aa.makeText(paramc.context, a.i.yfT, 0).show();
    paramc.resume();
    AppMethodBeat.o(269319);
  }
  
  private static final void a(c paramc, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(269324);
    s.u(paramc, "this$0");
    paramc.dEy();
    AppMethodBeat.o(269324);
  }
  
  private static final void a(c paramc, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(269323);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.u(paramf, "$itemView");
    paramc.yjl.a(true, ((TextEditorItemView)paramf.aqH).getText(), ((TextEditorItemView)paramf.aqH).getTextColor());
    EmojiCaptureReporter.a(13, paramc.yiI.mnX, 0L, 0L, 0L, 0L, 0, 0, paramc.yiI.scene);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269323);
  }
  
  private final void dEy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject1 = this.yjl.getVideoPlayView();
    Object localObject3;
    Object localObject5;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.EditorPresenter", s.X("start mix ", localObject1));
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.yjl.getItemContainer().getValidRect());
      localObject1 = this.yjl.getItemContainer().getAllItemViews();
      localObject4 = this.yjl.getItemContainer().getAllEmojiMd5();
      localObject5 = this.yjl.getItemContainer().getTextItem();
      if (localObject5 != null) {
        break label181;
      }
    }
    label181:
    for (int i = 0;; i = ((TextEditorItemView)localObject5).getTextColor())
    {
      localObject5 = this.yjl.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.recordvideo.ui.editor.item.h)((Iterator)localObject1).next()).e(null));
      }
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      break;
    }
    if (this.yjr == null)
    {
      this.yiI.ygi = this.yjl.getItemContainer().getAttachedText();
      this.yiI.textColor = i;
      this.yiI.ygj = this.yhT;
      this.yiI.ygk = this.yjp;
      this.yiI.ygl = ((ArrayList)localObject4).size();
      this.yiI.hqS = (System.currentTimeMillis() - this.yiI.mnX);
      EmojiCaptureReporter localEmojiCaptureReporter = this.yiI;
      localObject1 = this.yiN.yhc;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        localEmojiCaptureReporter.ygo = ((String)localObject1);
        this.yiI.dDv();
        localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
        localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.yhW;
        j = this.yiN.scene;
        l = ((EmojiInfo)localObject1).field_captureEnterTime;
        localObject2 = this.yiN.videoPath;
        localObject4 = this.yjl.getVideoPlayView();
        if (localObject4 != null) {
          break label515;
        }
      }
      label515:
      for (i = 1;; i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate())
      {
        this.yjr = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.yhT, this.yiN.yhc, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.b.KV(this.yiN.scene)) {
          break label640;
        }
        MMHandlerThread.removeRunnable(this.yjt);
        MMHandlerThread.postToMainThreadDelayed(this.yjt, 60000L);
        localObject1 = this.yiH;
        localObject2 = this.context;
        localObject3 = this.context.getString(a.i.yfU);
        s.s(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.e.b.mnS;
        com.tencent.mm.emoji.e.b.a(this.yiN.mnX, (com.tencent.mm.emoji.e.a)this.yjs);
        AppMethodBeat.o(363);
        return;
        localObject1 = ((f)localObject1).ygo;
        break;
      }
    }
    localObject1 = EmojiCaptureProxy.yjA;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.yiI.mnX);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.yhW;
    int j = this.yiN.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.yiN.videoPath;
    Object localObject4 = this.yjl.getVideoPlayView();
    if (localObject4 == null) {}
    for (i = 1;; i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate())
    {
      this.yjr = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.yhT, this.yiN.yhc, (EmojiInfo)localObject1);
      break;
    }
    label640:
    EmojiCaptureUI.b.a.a(this.yiH, true);
    AppMethodBeat.o(363);
  }
  
  private final void m(String paramString, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(365);
    if (Util.isNullOrNil(paramString))
    {
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.yjq.cgiEmojiTextSpam(paramString, (kotlin.g.a.b)new c.b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void os(boolean paramBoolean)
  {
    AppMethodBeat.i(366);
    Log.i("MicroMsg.EditorPresenter", s.X("toggleTouch: ", Boolean.valueOf(paramBoolean)));
    if ((this.context instanceof Activity))
    {
      Activity localActivity = (Activity)this.context;
      if (paramBoolean)
      {
        localActivity.getWindow().clearFlags(16);
        AppMethodBeat.o(366);
        return;
      }
      localActivity.getWindow().addFlags(16);
    }
    AppMethodBeat.o(366);
  }
  
  public final void a(t paramt, Matrix paramMatrix)
  {
    AppMethodBeat.i(360);
    s.u(paramt, "emojiInfo");
    if ((paramt instanceof EmojiInfo))
    {
      if (this.yjl.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        aa.makeText(this.context, a.i.yfM, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramt);
      ((EmojiEditorItemView)locala).resume();
      this.yjl.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    s.u(paramb, "emojiCaptureInfo");
    Log.i("MicroMsg.EditorPresenter", "setup");
    this.yiN = paramb;
    this.oYm = paramb.videoPath;
    this.yhT = paramb.ygj;
    this.textColor = paramb.yhe;
    this.yjl.a(paramb, paramb.videoPath, paramb.yhf, this.yhT, (kotlin.g.a.a)new f(this));
    com.tencent.mm.ae.d.d("EditorPresenter_setup", (kotlin.g.a.a)new g(paramb));
    AppMethodBeat.o(356);
  }
  
  public final boolean aAx()
  {
    AppMethodBeat.i(367);
    Log.i("MicroMsg.EditorPresenter", "onBack: " + this.yjl.cvt() + ' ' + this.yjl.dDB() + ' ' + this.yjl.dDC());
    if (this.yjl.cvt())
    {
      if (this.yjl.dDB())
      {
        this.yjl.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.yjl.dDC())
      {
        this.yjl.oo(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.yhT = false;
      this.yjp = false;
      this.yiM = null;
      this.yjn = false;
      this.yjo = false;
      Object localObject = this.yjl.getVideoPlayView();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath())
      {
        y.deleteFile((String)localObject);
        this.yjl.reset();
        localObject = this.yjl.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).yms.removeAllViews();
        this.yjr = null;
        os(true);
        this.yiH.dEC();
        EmojiCaptureReporter.a(9, this.yiI.mnX, 0L, 0L, 0L, 0L, 0, 0, this.yiI.scene);
        AppMethodBeat.o(367);
        return true;
      }
    }
    AppMethodBeat.o(367);
    return false;
  }
  
  public final void api(final String paramString)
  {
    AppMethodBeat.i(357);
    Log.i("MicroMsg.EditorPresenter", "voice text callback");
    m(paramString, (kotlin.g.a.b)new d(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final boolean dDx()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    Log.i("MicroMsg.EditorPresenter", s.X("removeBg ", Boolean.valueOf(this.yhT)));
    if (!this.yiN.yhf)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.yjl.getVideoPlayView();
    int i;
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      i = 1;
      if (i == 0) {
        break label129;
      }
      if (this.yhT) {
        break label124;
      }
    }
    for (;;)
    {
      this.yhT = bool;
      localEmojiVideoPlayTextureView = this.yjl.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setRemoveBackground(this.yhT);
      }
      bool = this.yhT;
      AppMethodBeat.o(358);
      return bool;
      i = 0;
      break;
      label124:
      bool = false;
    }
    label129:
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean dDy()
  {
    AppMethodBeat.i(359);
    Log.i("MicroMsg.EditorPresenter", s.X("speedUp ", Boolean.valueOf(this.yjp)));
    Object localObject = this.yjl.getVideoPlayView();
    if (localObject == null) {}
    for (localObject = null; s.a((Float)localObject, 1.0F); localObject = Float.valueOf(((EmojiVideoPlayTextureView)localObject).getPlayRate()))
    {
      localObject = this.yjl.getVideoPlayView();
      if (localObject != null) {
        ((EmojiVideoPlayTextureView)localObject).setPlayRate(2.0F);
      }
      this.yjp = true;
      AppMethodBeat.o(359);
      return true;
    }
    localObject = this.yjl.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).setPlayRate(1.0F);
    }
    this.yjp = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void dDz()
  {
    AppMethodBeat.i(362);
    if ((!Util.isNullOrNil(this.yjm)) && (!((Boolean)((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().c(at.a.acWU, Boolean.FALSE)).booleanValue()))
    {
      new e.a(this.context).aEO(a.i.yfF).aER(a.i.yfE).c(new c..ExternalSyntheticLambda0(this)).jHH().show();
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().d(at.a.acWU, Boolean.TRUE);
      AppMethodBeat.o(362);
      return;
    }
    dEy();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    Log.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.yjl.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.yjl.getItemContainer().pause();
    this.yjl.destroy();
    this.pfZ.release();
    this.yjq.setCallback(null);
    localObject = com.tencent.mm.emoji.e.b.mnS;
    com.tencent.mm.emoji.e.b.b(this.yiN.mnX, (com.tencent.mm.emoji.e.a)this.yjs);
    AppMethodBeat.o(370);
  }
  
  public final void pause()
  {
    int i = 1;
    AppMethodBeat.i(368);
    Log.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.yjl.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localEmojiVideoPlayTextureView = this.yjl.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.pause();
        }
      }
      this.yjl.getItemContainer().pause();
      os(false);
      AppMethodBeat.o(368);
      return;
      i = 0;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    Log.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.yjl.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.yjl.getItemContainer().resume();
    os(true);
    AppMethodBeat.o(369);
  }
  
  public final void s(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    Log.i("MicroMsg.EditorPresenter", s.X("updateText ", paramString));
    m(paramString, (kotlin.g.a.b)new h(w.a(this.context, (CharSequence)this.context.getString(a.i.loading_tips), true, 0, null), this, paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.emoji.e.a
  {
    c(c paramc) {}
    
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.yju, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(c paramc, boolean paramBoolean, String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "shouldBlock", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(c paramc, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "shouldBlock", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    h(w paramw, c paramc, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */