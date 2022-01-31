package com.tencent.mm.plugin.emojicapture.e;

import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.kernel.g;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final c.a lwt;
  private Context context;
  private final com.tencent.mm.remoteservice.d evl;
  private final String ewH;
  private final EmojiCaptureReporter lsY;
  private boolean lux;
  private String lvL;
  private com.tencent.mm.plugin.emojicapture.model.a.a lvM;
  private EmojiCaptureUI.b lvR;
  private String lwk;
  private boolean lwl;
  private boolean lwm;
  private boolean lwn;
  private final CgiEmojiTextSpamProxy lwo;
  private com.tencent.mm.plugin.emojicapture.model.b.d lwp;
  private final c.e lwq;
  private final Runnable lwr;
  private b.b lws;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(2794);
    lwt = new c.a((byte)0);
    AppMethodBeat.o(2794);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(2793);
    this.context = paramContext;
    this.lws = paramb;
    this.lvR = paramb1;
    this.ewH = paramString;
    this.lsY = paramEmojiCaptureReporter;
    this.evl = new com.tencent.mm.remoteservice.d(this.context);
    this.lwo = new CgiEmojiTextSpamProxy(this.evl);
    this.lvM = new com.tencent.mm.plugin.emojicapture.model.a.a();
    this.lwq = new c.e(this);
    this.lwr = ((Runnable)new c.c(this));
    AppMethodBeat.o(2793);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(2786);
    String str1 = this.lvM.thumbPath;
    String str2 = com.tencent.mm.vfs.e.avP(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.dQD() + str2;
    if (!com.tencent.mm.a.e.cN(str3)) {
      com.tencent.mm.vfs.e.C(str1, str3);
    }
    ab.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.wW(str2);
    localEmojiInfo.avG("capture");
    localEmojiInfo.NC(EmojiInfo.yPg);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.c.bnQ();
    paramString = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.c.bnQ();
    localEmojiInfo.a(EmojiInfo.a.yPC);
    localEmojiInfo.am(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.ewH;
    localEmojiInfo.field_captureEnterTime = this.lsY.eyh;
    paramString = this.lvM.ltF;
    if (paramString != null) {}
    for (paramString = paramString.lsW;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.c.ltu;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.c.a.uF(paramInt);
      localEmojiInfo.field_captureScene = this.lsY.scene;
      paramString = EmojiCaptureProxy.lwI;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(2786);
      return localEmojiInfo;
    }
  }
  
  private final void b(String paramString, a.f.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(2787);
    if (bo.isNullOrNil(paramString))
    {
      paramb.S(Boolean.FALSE);
      AppMethodBeat.o(2787);
      return;
    }
    this.lwo.cgiEmojiTextSpam(paramString, (a.f.a.b)new c.b(paramb));
    AppMethodBeat.o(2787);
  }
  
  private final void boN()
  {
    AppMethodBeat.i(2785);
    Object localObject2 = new StringBuilder("start mix ");
    Object localObject1 = this.lws.getVideoPlayView();
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      ab.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject2 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.lws.getItemContainer().getValidRect());
      localObject1 = this.lws.getItemContainer().getAllItemViews();
      localObject3 = this.lws.getItemContainer().getAllEmojiMd5();
      localObject4 = this.lws.getItemContainer().getTextItem();
      if (localObject4 == null) {
        break label192;
      }
    }
    label192:
    for (int i = ((TextEditorItemView)localObject4).getTextColor();; i = 0)
    {
      localObject4 = this.lws.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject2).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).UH());
      }
      localObject1 = null;
      break;
    }
    label386:
    boolean bool2;
    if (this.lwp == null)
    {
      this.lsY.ewF = this.lws.getItemContainer().getAttachedText();
      this.lsY.textColor = i;
      this.lsY.lsQ = this.lux;
      this.lsY.lsR = this.lwn;
      this.lsY.lsS = ((ArrayList)localObject3).size();
      this.lsY.cew = (System.currentTimeMillis() - this.lsY.eyh);
      EmojiCaptureReporter localEmojiCaptureReporter = this.lsY;
      localObject1 = this.lvM.ltF;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject1).lsW;
        localEmojiCaptureReporter.lsW = ((String)localObject1);
        this.lsY.bny();
        localObject1 = a((String)localObject4, i, (ArrayList)localObject3);
        localObject3 = com.tencent.mm.plugin.emojicapture.model.b.e.luE;
        j = this.lvM.scene;
        l = ((EmojiInfo)localObject1).field_captureEnterTime;
        localObject3 = this.lvM.videoPath;
        localObject4 = this.lws.getVideoPlayView();
        if (localObject4 == null) {
          break label538;
        }
        i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();
        bool2 = this.lux;
        if (this.lvM.ltF == null) {
          break label543;
        }
      }
      label538:
      label543:
      for (bool1 = true;; bool1 = false)
      {
        this.lwp = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject3, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject2, i, bool2, bool1, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.a.uO(this.lvM.scene)) {
          break label682;
        }
        al.ae(this.lwr);
        al.p(this.lwr, 60000L);
        localObject1 = this.lvR;
        localObject2 = this.context;
        localObject3 = this.context.getString(2131299143);
        j.p(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.d.b.eyc;
        com.tencent.mm.emoji.d.b.a(this.lvM.eyh, (com.tencent.mm.emoji.d.a)this.lwq);
        AppMethodBeat.o(2785);
        return;
        localObject1 = null;
        break;
        i = 1;
        break label386;
      }
    }
    localObject1 = EmojiCaptureProxy.lwI;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.lsY.eyh);
    localObject1 = a((String)localObject4, i, (ArrayList)localObject3);
    Object localObject3 = com.tencent.mm.plugin.emojicapture.model.b.e.luE;
    int j = this.lvM.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject3 = this.lvM.videoPath;
    Object localObject4 = this.lws.getVideoPlayView();
    if (localObject4 != null)
    {
      i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();
      label629:
      bool2 = this.lux;
      if (this.lvM.ltF == null) {
        break label676;
      }
    }
    label676:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.lwp = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject3, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject2, i, bool2, bool1, (EmojiInfo)localObject1);
      break;
      i = 1;
      break label629;
    }
    label682:
    EmojiCaptureUI.b.a.a(this.lvR, true);
    AppMethodBeat.o(2785);
  }
  
  private final void gV(boolean paramBoolean)
  {
    AppMethodBeat.i(2788);
    ab.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(paramBoolean)));
    if ((this.context instanceof Activity))
    {
      Object localObject = this.context;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(2788);
        throw ((Throwable)localObject);
      }
      localObject = (Activity)localObject;
      if (paramBoolean)
      {
        ((Activity)localObject).getWindow().clearFlags(16);
        AppMethodBeat.o(2788);
        return;
      }
      ((Activity)localObject).getWindow().addFlags(16);
    }
    AppMethodBeat.o(2788);
  }
  
  public final void Lm(String paramString)
  {
    AppMethodBeat.i(2779);
    ab.i("MicroMsg.EditorPresenter", "voice text callback");
    b(paramString, (a.f.a.b)new c.f(this, paramString));
    AppMethodBeat.o(2779);
  }
  
  public final void b(com.tencent.mm.plugin.emojicapture.model.a.a parama)
  {
    AppMethodBeat.i(2778);
    j.q(parama, "emojiCaptureInfo");
    ab.i("MicroMsg.EditorPresenter", "setup");
    this.lvM = parama;
    this.lwk = parama.videoPath;
    this.lux = parama.lsQ;
    this.textColor = parama.ltH;
    this.lws.a(parama, parama.videoPath, parama.ltI, this.lux, (a.f.a.a)new c.h(this));
    com.tencent.mm.ab.b.a("EditorPresenter_setup", (a.f.a.a)new c.i(parama));
    AppMethodBeat.o(2778);
  }
  
  public final boolean bnA()
  {
    boolean bool = true;
    AppMethodBeat.i(2780);
    ab.i("MicroMsg.EditorPresenter", "removeBg " + this.lux);
    if (!this.lvM.ltI)
    {
      AppMethodBeat.o(2780);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.lux) {}
      for (;;)
      {
        this.lux = bool;
        localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          EmojiVideoPlayTextureView.a(localEmojiVideoPlayTextureView, this.lux);
        }
        bool = this.lux;
        AppMethodBeat.o(2780);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(2780);
    return false;
  }
  
  public final boolean bnB()
  {
    AppMethodBeat.i(2781);
    ab.i("MicroMsg.EditorPresenter", "speedUp " + this.lwn);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.lwn = true;
      AppMethodBeat.o(2781);
      return true;
    }
    localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.lwn = false;
    AppMethodBeat.o(2781);
    return false;
  }
  
  public final void bnC()
  {
    AppMethodBeat.i(2784);
    if (!bo.isNullOrNil(this.ewH))
    {
      com.tencent.mm.kernel.b.a locala = g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(ac.a.yKp, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.b.c.a(this.context).Rf(2131298976).Ri(2131298975).a((DialogInterface.OnDismissListener)new c.d(this)).show();
        locala = g.G(com.tencent.mm.plugin.emoji.b.d.class);
        j.p(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(ac.a.yKp, Boolean.TRUE);
        AppMethodBeat.o(2784);
        return;
      }
    }
    boN();
    AppMethodBeat.o(2784);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(2782);
    j.q(paramk, "emojiInfo");
    if ((paramk instanceof EmojiInfo))
    {
      if (this.lws.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        t.makeText(this.context, 2131299101, 0).show();
        AppMethodBeat.o(2782);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramk);
      locala.resume();
      paramk = this.lws.getItemContainer();
      j.q(locala, "itemView");
      Object localObject = new RelativeLayout.LayoutParams(-1, -1);
      paramk.lzD.addView((View)locala, (ViewGroup.LayoutParams)localObject);
      localObject = paramk.getValidRect();
      Context localContext = paramk.getContext();
      j.p(localContext, "context");
      locala.a((RectF)localObject, localContext.getResources().getDimension(2131427333));
      paramk.setEditing(locala);
      paramk.lzD.bringChildToFront((View)paramk.getTextItem());
    }
    AppMethodBeat.o(2782);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(2792);
    ab.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.lws.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.lws.getItemContainer().pause();
    this.lws.destroy();
    this.evl.release();
    this.lwo.setCallback(null);
    localObject = com.tencent.mm.emoji.d.b.eyc;
    com.tencent.mm.emoji.d.b.b(this.lvM.eyh, (com.tencent.mm.emoji.d.a)this.lwq);
    AppMethodBeat.o(2792);
  }
  
  public final void n(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2783);
    ab.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    b(paramString, (a.f.a.b)new c.j(this, p.b(this.context, (CharSequence)this.context.getString(2131301086), true, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(2783);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(2790);
    ab.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.lws.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.lws.getItemContainer().pause();
    gV(false);
    AppMethodBeat.o(2790);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(2791);
    ab.i("MicroMsg.EditorPresenter", "resume");
    Object localObject = this.lws.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).start();
    }
    localObject = this.lws.getItemContainer();
    int j = ((EditorItemContainer)localObject).lzD.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = ((EditorItemContainer)localObject).lzD.getChildAt(i);
      if ((localView instanceof com.tencent.mm.plugin.emojicapture.ui.editor.a)) {
        ((com.tencent.mm.plugin.emojicapture.ui.editor.a)localView).resume();
      }
      i += 1;
    }
    gV(true);
    AppMethodBeat.o(2791);
  }
  
  public final boolean zY()
  {
    AppMethodBeat.i(2789);
    ab.i("MicroMsg.EditorPresenter", "onBack: " + this.lws.Pk() + ' ' + this.lws.bnE() + ' ' + this.lws.bnF());
    if (this.lws.Pk())
    {
      if (this.lws.bnE())
      {
        this.lws.a(false, null, 0);
        AppMethodBeat.o(2789);
        return true;
      }
      if (this.lws.bnF())
      {
        this.lws.gT(false);
        AppMethodBeat.o(2789);
        return true;
      }
      this.lux = false;
      this.lwn = false;
      this.lvL = null;
      this.lwl = false;
      this.lwm = false;
      Object localObject = this.lws.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        com.tencent.mm.vfs.e.deleteFile((String)localObject);
        this.lws.reset();
        localObject = this.lws.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).lzD.removeAllViews();
        this.lwp = null;
        gV(true);
        this.lvR.boQ();
        EmojiCaptureReporter.a(9, this.lsY.eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, this.lsY.scene);
        AppMethodBeat.o(2789);
        return true;
      }
    }
    AppMethodBeat.o(2789);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */