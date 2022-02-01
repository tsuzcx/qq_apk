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
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c
  implements b.a
{
  public static final c.a rrq;
  private Context context;
  private final com.tencent.mm.remoteservice.d gVN;
  private final String gXz;
  private boolean rpL;
  private String rqC;
  private com.tencent.mm.plugin.emojicapture.model.a.b rqD;
  private EmojiCaptureUI.b rqI;
  private final EmojiCaptureReporter rqJ;
  private String rrh;
  private boolean rri;
  private boolean rrj;
  private boolean rrk;
  private final CgiEmojiTextSpamProxy rrl;
  private com.tencent.mm.plugin.emojicapture.model.b.d rrm;
  private final e rrn;
  private final Runnable rro;
  private b.b rrp;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(372);
    rrq = new c.a((byte)0);
    AppMethodBeat.o(372);
  }
  
  public c(Context paramContext, b.b paramb, EmojiCaptureUI.b paramb1, String paramString, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(371);
    this.context = paramContext;
    this.rrp = paramb;
    this.rqI = paramb1;
    this.gXz = paramString;
    this.rqJ = paramEmojiCaptureReporter;
    this.gVN = new com.tencent.mm.remoteservice.d(this.context);
    this.rrl = new CgiEmojiTextSpamProxy(this.gVN);
    this.rqD = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.rrn = new e(this);
    this.rro = ((Runnable)new c(this));
    AppMethodBeat.o(371);
  }
  
  private final EmojiInfo a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(364);
    String str1 = this.rqD.thumbPath;
    String str2 = s.bhK(str1);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    String str3 = EmojiInfo.hRO() + str2;
    if (!s.YS(str3)) {
      s.nw(str1, str3);
    }
    Log.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + str2 + " outputPath: " + str3);
    localEmojiInfo.setMd5(str2);
    localEmojiInfo.bxm("capture");
    localEmojiInfo.awx(EmojiInfo.Uup);
    localEmojiInfo.field_attachedText = paramString;
    paramString = com.tencent.mm.plugin.emojicapture.model.d.roA;
    localEmojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.cII();
    paramString = com.tencent.mm.plugin.emojicapture.model.d.roA;
    localEmojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.cII();
    localEmojiInfo.a(EmojiInfo.a.Osk);
    localEmojiInfo.bl(paramArrayList);
    localEmojiInfo.field_imitateMd5 = this.gXz;
    localEmojiInfo.field_captureEnterTime = this.rqJ.hdz;
    paramString = this.rqD.roL;
    if (paramString != null) {}
    for (paramString = paramString.rnS;; paramString = null)
    {
      localEmojiInfo.field_lensId = paramString;
      paramString = com.tencent.mm.plugin.emojicapture.model.d.roA;
      localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.emojicapture.model.d.a.Gm(paramInt);
      localEmojiInfo.field_captureScene = this.rqJ.scene;
      paramString = EmojiCaptureProxy.rrF;
      EmojiCaptureProxy.access$getInstance$cp().createEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(364);
      return localEmojiInfo;
    }
  }
  
  private final void cJz()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363);
    Object localObject3 = new StringBuilder("start mix ");
    Object localObject1 = this.rrp.getVideoPlayView();
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((EmojiVideoPlayTextureView)localObject1).getVideoPath();
      Log.i("MicroMsg.EditorPresenter", (String)localObject1);
      localObject3 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.rrp.getItemContainer().getValidRect());
      localObject1 = this.rrp.getItemContainer().getAllItemViews();
      localObject4 = this.rrp.getItemContainer().getAllEmojiMd5();
      localObject5 = this.rrp.getItemContainer().getTextItem();
      if (localObject5 == null) {
        break label196;
      }
    }
    label196:
    for (int i = ((TextEditorItemView)localObject5).getTextColor();; i = 0)
    {
      localObject5 = this.rrp.getItemContainer().getAttachedText();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject3).a(((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject1).next()).c(null));
      }
      localObject1 = null;
      break;
    }
    if (this.rrm == null)
    {
      this.rqJ.gXx = this.rrp.getItemContainer().getAttachedText();
      this.rqJ.textColor = i;
      this.rqJ.rnN = this.rpL;
      this.rqJ.rnO = this.rrk;
      this.rqJ.rnP = ((ArrayList)localObject4).size();
      this.rqJ.dtZ = (System.currentTimeMillis() - this.rqJ.hdz);
      EmojiCaptureReporter localEmojiCaptureReporter = this.rqJ;
      f localf = this.rqD.roL;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.rnS;
      }
      localEmojiCaptureReporter.rnS = ((String)localObject1);
      this.rqJ.cIu();
      localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
      localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.rpT;
      j = this.rqD.scene;
      l = ((EmojiInfo)localObject1).field_captureEnterTime;
      localObject2 = this.rqD.videoPath;
      localObject4 = this.rrp.getVideoPlayView();
      if (localObject4 != null) {}
      for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
      {
        this.rrm = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.rpL, this.rqD.roL, (EmojiInfo)localObject1);
        pause();
        if (!com.tencent.mm.plugin.emojicapture.ui.c.Gq(this.rqD.scene)) {
          break;
        }
        MMHandlerThread.removeRunnable(this.rro);
        MMHandlerThread.postToMainThreadDelayed(this.rro, 60000L);
        localObject1 = this.rqI;
        localObject2 = this.context;
        localObject3 = this.context.getString(2131758547);
        p.g(localObject3, "context.getString(R.string.emoji_generating)");
        EmojiCaptureUI.b.a.a((EmojiCaptureUI.b)localObject1, (Context)localObject2, (CharSequence)localObject3);
        localObject1 = com.tencent.mm.emoji.d.b.hdv;
        com.tencent.mm.emoji.d.b.a(this.rqD.hdz, (com.tencent.mm.emoji.d.a)this.rrn);
        AppMethodBeat.o(363);
        return;
      }
    }
    localObject1 = EmojiCaptureProxy.rrF;
    EmojiCaptureProxy.access$getInstance$cp().deleteEmojiInfoByEnterTime(this.rqJ.hdz);
    localObject1 = a((String)localObject5, i, (ArrayList)localObject4);
    localObject2 = com.tencent.mm.plugin.emojicapture.model.b.e.rpT;
    int j = this.rqD.scene;
    long l = ((EmojiInfo)localObject1).field_captureEnterTime;
    localObject2 = this.rqD.videoPath;
    Object localObject4 = this.rrp.getVideoPlayView();
    if (localObject4 != null) {}
    for (i = (int)((EmojiVideoPlayTextureView)localObject4).getPlayRate();; i = 1)
    {
      this.rrm = com.tencent.mm.plugin.emojicapture.model.b.e.a(j, l, (String)localObject2, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject3, i, this.rpL, this.rqD.roL, (EmojiInfo)localObject1);
      break;
    }
    EmojiCaptureUI.b.a.a(this.rqI, true);
    AppMethodBeat.o(363);
  }
  
  private final void g(String paramString, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(365);
    if (Util.isNullOrNil(paramString))
    {
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(365);
      return;
    }
    this.rrl.cgiEmojiTextSpam(paramString, (kotlin.g.a.b)new c.b(paramb));
    AppMethodBeat.o(365);
  }
  
  private final void lI(boolean paramBoolean)
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
  
  public final boolean Ul()
  {
    AppMethodBeat.i(367);
    Log.i("MicroMsg.EditorPresenter", "onBack: " + this.rrp.bJw() + ' ' + this.rrp.cIB() + ' ' + this.rrp.cIC());
    if (this.rrp.bJw())
    {
      if (this.rrp.cIB())
      {
        this.rrp.a(false, null, 0);
        AppMethodBeat.o(367);
        return true;
      }
      if (this.rrp.cIC())
      {
        this.rrp.lE(false);
        AppMethodBeat.o(367);
        return true;
      }
      this.rpL = false;
      this.rrk = false;
      this.rqC = null;
      this.rri = false;
      this.rrj = false;
      Object localObject = this.rrp.getVideoPlayView();
      if (localObject != null) {}
      for (localObject = ((EmojiVideoPlayTextureView)localObject).getVideoPath();; localObject = null)
      {
        s.deleteFile((String)localObject);
        this.rrp.reset();
        localObject = this.rrp.getItemContainer();
        ((EditorItemContainer)localObject).pause();
        ((EditorItemContainer)localObject).ruN.removeAllViews();
        this.rrm = null;
        lI(true);
        this.rqI.cJC();
        EmojiCaptureReporter.a(9, this.rqJ.hdz, 0L, 0L, 0L, 0L, 0, 0, this.rqJ.scene);
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
    p.h(paramr, "emojiInfo");
    if ((paramr instanceof EmojiInfo))
    {
      if (this.rrp.getItemContainer().getAllEmojiMd5().size() >= 8)
      {
        u.makeText(this.context, 2131758501, 0).show();
        AppMethodBeat.o(360);
        return;
      }
      com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
      ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramr);
      locala.resume();
      this.rrp.getItemContainer().a(locala, paramMatrix);
    }
    AppMethodBeat.o(360);
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(356);
    p.h(paramb, "emojiCaptureInfo");
    Log.i("MicroMsg.EditorPresenter", "setup");
    this.rqD = paramb;
    this.rrh = paramb.videoPath;
    this.rpL = paramb.rnN;
    this.textColor = paramb.roN;
    this.rrp.a(paramb, paramb.videoPath, paramb.roO, this.rpL, (kotlin.g.a.a)new h(this));
    com.tencent.mm.ac.d.b("EditorPresenter_setup", (kotlin.g.a.a)new i(paramb));
    AppMethodBeat.o(356);
  }
  
  public final void ank(final String paramString)
  {
    AppMethodBeat.i(357);
    Log.i("MicroMsg.EditorPresenter", "voice text callback");
    g(paramString, (kotlin.g.a.b)new f(this, paramString));
    AppMethodBeat.o(357);
  }
  
  public final boolean cIx()
  {
    boolean bool = true;
    AppMethodBeat.i(358);
    Log.i("MicroMsg.EditorPresenter", "removeBg " + this.rpL);
    if (!this.rqD.roO)
    {
      AppMethodBeat.o(358);
      return false;
    }
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      if (!this.rpL) {}
      for (;;)
      {
        this.rpL = bool;
        localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
        if (localEmojiVideoPlayTextureView != null) {
          localEmojiVideoPlayTextureView.setRemoveBackground(this.rpL);
        }
        bool = this.rpL;
        AppMethodBeat.o(358);
        return bool;
        bool = false;
      }
    }
    AppMethodBeat.o(358);
    return false;
  }
  
  public final boolean cIy()
  {
    AppMethodBeat.i(359);
    Log.i("MicroMsg.EditorPresenter", "speedUp " + this.rrk);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.getPlayRate() == 1.0F))
    {
      localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.setPlayRate(2.0F);
      }
      this.rrk = true;
      AppMethodBeat.o(359);
      return true;
    }
    localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.setPlayRate(1.0F);
    }
    this.rrk = false;
    AppMethodBeat.o(359);
    return false;
  }
  
  public final void cIz()
  {
    AppMethodBeat.i(362);
    if (!Util.isNullOrNil(this.gXz))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().c(ar.a.OgV, Boolean.FALSE)).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.d.a(this.context).aoS(2131758331).aoV(2131758330).a((DialogInterface.OnDismissListener)new d(this)).show();
        locala = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().d(ar.a.OgV, Boolean.TRUE);
        AppMethodBeat.o(362);
        return;
      }
    }
    cJz();
    AppMethodBeat.o(362);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(370);
    Log.i("MicroMsg.EditorPresenter", "destroy");
    Object localObject = this.rrp.getVideoPlayView();
    if (localObject != null) {
      ((EmojiVideoPlayTextureView)localObject).stop();
    }
    this.rrp.getItemContainer().pause();
    this.rrp.destroy();
    this.gVN.release();
    this.rrl.setCallback(null);
    localObject = com.tencent.mm.emoji.d.b.hdv;
    com.tencent.mm.emoji.d.b.b(this.rqD.hdz, (com.tencent.mm.emoji.d.a)this.rrn);
    AppMethodBeat.o(370);
  }
  
  public final void n(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(361);
    Log.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(paramString)));
    g(paramString, (kotlin.g.a.b)new j(this, com.tencent.mm.ui.base.q.a(this.context, (CharSequence)this.context.getString(2131762446), true, 0, null), paramString, paramInt, paramBoolean));
    AppMethodBeat.o(361);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(368);
    Log.i("MicroMsg.EditorPresenter", "pause");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
    if ((localEmojiVideoPlayTextureView != null) && (localEmojiVideoPlayTextureView.isPlaying() == true))
    {
      localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        localEmojiVideoPlayTextureView.pause();
      }
    }
    this.rrp.getItemContainer().pause();
    lI(false);
    AppMethodBeat.o(368);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(369);
    Log.i("MicroMsg.EditorPresenter", "resume");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.rrp.getVideoPlayView();
    if (localEmojiVideoPlayTextureView != null) {
      localEmojiVideoPlayTextureView.start();
    }
    this.rrp.getItemContainer().resume();
    lI(true);
    AppMethodBeat.o(369);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(346);
      c.i(this.rrt).cJE();
      u.makeText(c.d(this.rrt), 2131758546, 0).show();
      this.rrt.resume();
      AppMethodBeat.o(346);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(347);
      c.l(this.rrt);
      AppMethodBeat.o(347);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.emoji.d.a
  {
    public final void a(long paramLong, final boolean paramBoolean, final String paramString)
    {
      AppMethodBeat.i(349);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramBoolean, paramString));
      AppMethodBeat.o(349);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(c.e parame, boolean paramBoolean, String paramString)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(c paramc, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "shouldBlock", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    j(c paramc, com.tencent.mm.ui.base.q paramq, String paramString, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, z.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(355);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      c.f(this.rrt).a(true, ((TextEditorItemView)this.rrB.SYG).getText(), ((TextEditorItemView)this.rrB.SYG).getTextColor());
      EmojiCaptureReporter.a(13, c.k(this.rrt).hdz, 0L, 0L, 0L, 0L, 0, 0, c.k(this.rrt).scene);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */