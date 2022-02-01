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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a.a pZN;
  private Context context;
  private final com.tencent.mm.remoteservice.d gkS;
  private a.b pZC;
  private boolean pZD;
  private boolean pZE;
  private String pZF;
  private final com.tencent.mm.plugin.emojicapture.model.a.b pZG;
  private VoiceInputProxy pZH;
  private final aw pZI;
  private com.tencent.mm.plugin.emojicapture.c.a.b pZJ;
  private final VideoTransPara pZK;
  private EmojiCaptureUI.b pZL;
  private final EmojiCaptureReporter pZM;
  private long pzU;
  
  static
  {
    AppMethodBeat.i(333);
    pZN = new a.a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.pZJ = paramb;
    this.pZK = paramVideoTransPara;
    this.pZL = paramb1;
    this.pZM = paramEmojiCaptureReporter;
    this.pZC = a.b.pZP;
    this.pZG = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.gkS = new com.tencent.mm.remoteservice.d(this.context);
    this.pZH = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.gkS);
    this.pZI = new aw((aw.a)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.gkS));
    this.gkS.connect((Runnable)a.1.pZO);
    paramContext = this.pZK;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.ckE();
    paramContext = this.pZK;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.ckE();
    this.pZK.videoBitrate = 5000000;
    k.wat.videoBitrate = this.pZK.videoBitrate;
    k.wat.hxV = this.pZK;
    this.pZG.scene = this.pZM.scene;
    this.pZG.gsp = this.pZM.gsp;
    AppMethodBeat.o(332);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(327);
    ae.i("MicroMsg.CapturePresenter", "stop record " + this.pZC);
    if (this.pZC == a.b.pZT)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.pZC = a.b.pZT;
    if (bu.aO(this.pzU) < 600L)
    {
      localObject = this.pZH;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.pZC = a.b.pZQ;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.pZL;
    Context localContext = this.context;
    String str = this.context.getString(2131760709);
    p.g(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new d(this));
    localObject = this.pZJ.getDecoration();
    ((CaptureDecoration)localObject).qcm.pause();
    ((CaptureDecoration)localObject).qcn.pause();
    if (this.pZD)
    {
      localObject = this.pZH;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.pZI.stopTimer();
    }
    this.pZM.pWI = System.currentTimeMillis();
    this.pZM.gfw = (this.pZM.pWI - this.pZM.pWH);
    EmojiCaptureReporter.a(4, this.pZM.gsp, 0L, this.pZM.gfw, 0L, 0L, 0, 0, this.pZM.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    p.h(paramb, "info");
    ae.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.pZG.setVideoPath(paramb.hwB);
    this.pZG.yY(paramb.hwC);
    this.pZG.pXO = this.pZF;
    this.pZG.pXP = this.pZJ.getDecoration().getTextColor();
    Object localObject = this.pZG;
    paramb = this.pZG.pXN;
    if (paramb != null)
    {
      paramb = paramb.IGD;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).pXQ = bool1;
      paramb = this.pZG;
      if (this.pZG.pXQ)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.pWO = bool1;
      this.pZG.pXR = this.pZJ.getDecoration().getAttachEmoji();
      paramb = this.pZG;
      localObject = this.pZJ.getDecoration().getAttachEmojiMatrix();
      p.h(localObject, "<set-?>");
      paramb.pXS = ((Matrix)localObject);
      this.pZL.b(this.pZG);
      AppMethodBeat.o(328);
      return;
      paramb = null;
      break;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(331);
    ae.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(paramf)));
    this.pZG.pXN = paramf;
    this.pZJ.a(paramf);
    AppMethodBeat.o(331);
  }
  
  public final void bkx()
  {
    AppMethodBeat.i(326);
    ae.i("MicroMsg.CapturePresenter", "start record " + this.pZC);
    this.pZG.setVideoPath("");
    this.pZG.yY("");
    this.pZF = this.pZJ.getDecoration().getText();
    this.pZJ.getDecoration();
    Object localObject = (CharSequence)this.pZF;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pZD = bool;
      ae.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.pZD);
      if ((this.pZD) && ((p.i("NON_NETWORK", az.getNetTypeString(ak.getContext())) ^ true)))
      {
        localObject = this.pZH;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.pZI.Dv(50L);
      }
      this.pZE = false;
      this.pZC = a.b.pZS;
      this.pzU = bu.HQ();
      this.pZM.pWH = System.currentTimeMillis();
      this.pZM.bkx();
      AppMethodBeat.o(326);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.gkS.release();
    VoiceInputProxy localVoiceInputProxy = this.pZH;
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
    EmojiCaptureUI.b.a.a(this.pZL, false);
    AppMethodBeat.o(329);
  }
  
  public final void sx()
  {
    AppMethodBeat.i(325);
    ae.i("MicroMsg.CapturePresenter", "pauseCapture " + this.pZE);
    if ((this.pZF != null) || (this.pZE))
    {
      this.pZL.adf(this.pZF);
      AppMethodBeat.o(325);
      return;
    }
    ar.o((Runnable)new c(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(320);
      ae.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.pZV)) {
        a.c(this.pZV).adf(a.d(this.pZV));
      }
      a.b(this.pZV);
      AppMethodBeat.o(320);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(321);
      a.c(this.pZV).clA();
      AppMethodBeat.o(321);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements aw.a
  {
    e(a parama) {}
    
    public final boolean onTimerExpired()
    {
      boolean bool = false;
      AppMethodBeat.i(322);
      Object localObject;
      int i;
      if (a.e(this.pZV) != null)
      {
        localObject = a.e(this.pZV);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.pZV);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).kB(bool);
        AppMethodBeat.o(322);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void aOs()
    {
      AppMethodBeat.i(324);
      ae.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.pZV)) {
        a.c(this.pZV).adf(a.d(this.pZV));
      }
      a.b(this.pZV);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      ae.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.pZV, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */