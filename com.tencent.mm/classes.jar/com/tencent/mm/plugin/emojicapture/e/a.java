package com.tencent.mm.plugin.emojicapture.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a.a pTi;
  private Context context;
  private final com.tencent.mm.remoteservice.d giA;
  private a.b pSX;
  private boolean pSY;
  private boolean pSZ;
  private String pTa;
  private final com.tencent.mm.plugin.emojicapture.model.a.b pTb;
  private VoiceInputProxy pTc;
  private final av pTd;
  private com.tencent.mm.plugin.emojicapture.c.a.b pTe;
  private final VideoTransPara pTf;
  private EmojiCaptureUI.b pTg;
  private final EmojiCaptureReporter pTh;
  private long pto;
  
  static
  {
    AppMethodBeat.i(333);
    pTi = new a.a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.pTe = paramb;
    this.pTf = paramVideoTransPara;
    this.pTg = paramb1;
    this.pTh = paramEmojiCaptureReporter;
    this.pSX = a.b.pTk;
    this.pTb = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.giA = new com.tencent.mm.remoteservice.d(this.context);
    this.pTc = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.giA);
    this.pTd = new av((av.a)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.giA));
    this.giA.connect((Runnable)a.1.pTj);
    paramContext = this.pTf;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.cjo();
    paramContext = this.pTf;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.cjo();
    this.pTf.videoBitrate = 5000000;
    k.vOq.videoBitrate = this.pTf.videoBitrate;
    k.vOq.hvh = this.pTf;
    this.pTb.scene = this.pTh.scene;
    this.pTb.gpU = this.pTh.gpU;
    AppMethodBeat.o(332);
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(327);
    ad.i("MicroMsg.CapturePresenter", "stop record " + this.pSX);
    if (this.pSX == a.b.pTo)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.pSX = a.b.pTo;
    if (bt.aO(this.pto) < 600L)
    {
      localObject = this.pTc;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.pSX = a.b.pTl;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.pTg;
    Context localContext = this.context;
    String str = this.context.getString(2131760709);
    p.g(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new d(this));
    localObject = this.pTe.getDecoration();
    ((CaptureDecoration)localObject).pVH.pause();
    ((CaptureDecoration)localObject).pVI.pause();
    if (this.pSY)
    {
      localObject = this.pTc;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.pTd.stopTimer();
    }
    this.pTh.pQd = System.currentTimeMillis();
    this.pTh.gdo = (this.pTh.pQd - this.pTh.pQc);
    EmojiCaptureReporter.a(4, this.pTh.gpU, 0L, this.pTh.gdo, 0L, 0L, 0, 0, this.pTh.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    p.h(paramb, "info");
    ad.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.pTb.setVideoPath(paramb.htN);
    this.pTb.yo(paramb.htO);
    this.pTb.pRj = this.pTa;
    this.pTb.pRk = this.pTe.getDecoration().getTextColor();
    Object localObject = this.pTb;
    paramb = this.pTb.pRi;
    if (paramb != null)
    {
      paramb = paramb.Ims;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).pRl = bool1;
      paramb = this.pTb;
      if (this.pTb.pRl)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.pQj = bool1;
      this.pTb.pRm = this.pTe.getDecoration().getAttachEmoji();
      paramb = this.pTb;
      localObject = this.pTe.getDecoration().getAttachEmojiMatrix();
      p.h(localObject, "<set-?>");
      paramb.pRn = ((Matrix)localObject);
      this.pTg.b(this.pTb);
      AppMethodBeat.o(328);
      return;
      paramb = null;
      break;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(331);
    ad.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(paramf)));
    this.pTb.pRi = paramf;
    this.pTe.a(paramf);
    AppMethodBeat.o(331);
  }
  
  public final void bjO()
  {
    AppMethodBeat.i(326);
    ad.i("MicroMsg.CapturePresenter", "start record " + this.pSX);
    this.pTb.setVideoPath("");
    this.pTb.yo("");
    this.pTa = this.pTe.getDecoration().getText();
    this.pTe.getDecoration();
    Object localObject = (CharSequence)this.pTa;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pSY = bool;
      ad.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.pSY);
      if ((this.pSY) && ((p.i("NON_NETWORK", ay.getNetTypeString(aj.getContext())) ^ true)))
      {
        localObject = this.pTc;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.pTd.CX(50L);
      }
      this.pSZ = false;
      this.pSX = a.b.pTn;
      this.pto = bt.HI();
      this.pTh.pQc = System.currentTimeMillis();
      this.pTh.bjO();
      AppMethodBeat.o(326);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.giA.release();
    VoiceInputProxy localVoiceInputProxy = this.pTc;
    if (localVoiceInputProxy != null)
    {
      localVoiceInputProxy.setUiCallback(null);
      AppMethodBeat.o(330);
      return;
    }
    AppMethodBeat.o(330);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(329);
    EmojiCaptureUI.b.a.a(this.pTg, false);
    AppMethodBeat.o(329);
  }
  
  public final void sx()
  {
    AppMethodBeat.i(325);
    ad.i("MicroMsg.CapturePresenter", "pauseCapture " + this.pSZ);
    if ((this.pTa != null) || (this.pSZ))
    {
      this.pTg.aco(this.pTa);
      AppMethodBeat.o(325);
      return;
    }
    aq.o((Runnable)new c(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(320);
      ad.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.pTq)) {
        a.c(this.pTq).aco(a.d(this.pTq));
      }
      a.b(this.pTq);
      AppMethodBeat.o(320);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(321);
      a.c(this.pTq).ckk();
      AppMethodBeat.o(321);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements av.a
  {
    e(a parama) {}
    
    public final boolean onTimerExpired()
    {
      boolean bool = false;
      AppMethodBeat.i(322);
      Object localObject;
      int i;
      if (a.e(this.pTq) != null)
      {
        localObject = a.e(this.pTq);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.pTq);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).kC(bool);
        AppMethodBeat.o(322);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void aNU()
    {
      AppMethodBeat.i(324);
      ad.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.pTq)) {
        a.c(this.pTq).aco(a.d(this.pTq));
      }
      a.b(this.pTq);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      ad.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.pTq, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */