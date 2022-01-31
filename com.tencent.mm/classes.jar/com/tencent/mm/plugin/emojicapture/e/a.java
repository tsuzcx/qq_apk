package com.tencent.mm.plugin.emojicapture.e;

import a.l;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a.a lvS;
  private Context context;
  private final d evl;
  private final EmojiCaptureReporter lsY;
  private a.b lvH;
  private long lvI;
  private boolean lvJ;
  private boolean lvK;
  private String lvL;
  private final com.tencent.mm.plugin.emojicapture.model.a.a lvM;
  private VoiceInputProxy lvN;
  private final ap lvO;
  private com.tencent.mm.plugin.emojicapture.c.a.b lvP;
  private final VideoTransPara lvQ;
  private EmojiCaptureUI.b lvR;
  
  static
  {
    AppMethodBeat.i(2754);
    lvS = new a.a((byte)0);
    AppMethodBeat.o(2754);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(2753);
    this.context = paramContext;
    this.lvP = paramb;
    this.lvQ = paramVideoTransPara;
    this.lvR = paramb1;
    this.lsY = paramEmojiCaptureReporter;
    this.lvH = a.b.lvU;
    this.lvM = new com.tencent.mm.plugin.emojicapture.model.a.a();
    this.evl = new d(this.context);
    this.lvN = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.evl);
    this.lvO = new ap((ap.a)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    this.evl.connect((Runnable)a.1.lvT);
    paramContext = this.lvQ;
    paramb = c.ltu;
    paramContext.width = c.bnP();
    paramContext = this.lvQ;
    paramb = c.ltu;
    paramContext.height = c.bnP();
    this.lvQ.videoBitrate = 5000000;
    com.tencent.mm.plugin.mmsight.model.j.oHG.videoBitrate = this.lvQ.videoBitrate;
    com.tencent.mm.plugin.mmsight.model.j.oHG.fcu = this.lvQ;
    this.lvM.scene = this.lsY.scene;
    this.lvM.eyh = this.lsY.eyh;
    AppMethodBeat.o(2753);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(2748);
    ab.i("MicroMsg.CapturePresenter", "stop record " + this.lvH);
    if (this.lvH == a.b.lvY)
    {
      AppMethodBeat.o(2748);
      return true;
    }
    this.lvH = a.b.lvY;
    if (bo.av(this.lvI) < 600L)
    {
      localObject = this.lvN;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.lvH = a.b.lvV;
      AppMethodBeat.o(2748);
      return false;
    }
    Object localObject = this.lvR;
    Context localContext = this.context;
    String str = this.context.getString(2131301086);
    a.f.b.j.p(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new a.d(this));
    this.lvP.getDecoration().lyv.pause();
    if (this.lvJ)
    {
      localObject = this.lvN;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.lvO.stopTimer();
    }
    this.lsY.lsK = System.currentTimeMillis();
    this.lsY.esf = (this.lsY.lsK - this.lsY.lsJ);
    EmojiCaptureReporter.a(4, this.lsY.eyh, 0L, this.lsY.esf, 0L, 0L, 0L, 0, 0, this.lsY.scene);
    AppMethodBeat.o(2748);
    return true;
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.a parama)
  {
    AppMethodBeat.i(2749);
    a.f.b.j.q(parama, "info");
    ab.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.lvM.setVideoPath(parama.videoPath);
    this.lvM.mV(parama.thumbPath);
    this.lvM.ltG = this.lvL;
    this.lvM.ltH = parama.ltH;
    com.tencent.mm.plugin.emojicapture.model.a.a locala = this.lvM;
    if (this.lvM.ltF == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.ltI = bool;
      this.lvM.lsQ = parama.lsQ;
      this.lvR.c(this.lvM);
      AppMethodBeat.o(2749);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(2752);
    ab.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(paramb)));
    this.lvM.ltF = paramb;
    this.lvP.a(paramb);
    AppMethodBeat.o(2752);
  }
  
  public final void aCJ()
  {
    AppMethodBeat.i(2747);
    ab.i("MicroMsg.CapturePresenter", "start record " + this.lvH);
    this.lvM.setVideoPath("");
    this.lvM.mV("");
    this.lvL = this.lvP.getDecoration().getText();
    this.lvP.getDecoration().lyv.reset();
    if (this.lvL == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.lvJ = bool;
      ab.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.lvJ);
      if ((this.lvJ) && ((a.f.b.j.e("NON_NETWORK", at.getNetTypeString(ah.getContext())) ^ true)))
      {
        VoiceInputProxy localVoiceInputProxy = this.lvN;
        if (localVoiceInputProxy != null) {
          localVoiceInputProxy.start();
        }
        this.lvO.nP(50L);
      }
      this.lvK = false;
      this.lvH = a.b.lvX;
      this.lvI = bo.yB();
      this.lsY.lsJ = System.currentTimeMillis();
      EmojiCaptureReporter.a(3, this.lsY.eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, this.lsY.scene);
      AppMethodBeat.o(2747);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(2751);
    this.evl.release();
    VoiceInputProxy localVoiceInputProxy = this.lvN;
    if (localVoiceInputProxy != null)
    {
      localVoiceInputProxy.setUiCallback(null);
      AppMethodBeat.o(2751);
      return;
    }
    AppMethodBeat.o(2751);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(2750);
    EmojiCaptureUI.b.a.a(this.lvR, false);
    AppMethodBeat.o(2750);
  }
  
  public final void me()
  {
    AppMethodBeat.i(2746);
    ab.i("MicroMsg.CapturePresenter", "pauseCapture " + this.lvK);
    if ((this.lvL != null) || (this.lvK))
    {
      this.lvR.Lp(this.lvL);
      AppMethodBeat.o(2746);
      return;
    }
    al.p((Runnable)new c(this), 1500L);
    AppMethodBeat.o(2746);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(2741);
      ab.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.lwa)) {
        a.c(this.lwa).Lp(a.d(this.lwa));
      }
      a.b(this.lwa);
      AppMethodBeat.o(2741);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements ap.a
  {
    e(a parama) {}
    
    public final boolean onTimerExpired()
    {
      boolean bool = false;
      AppMethodBeat.i(2743);
      Object localObject;
      int i;
      if (a.e(this.lwa) != null)
      {
        localObject = a.e(this.lwa);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.lwa);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).gS(bool);
        AppMethodBeat.o(2743);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void amO()
    {
      AppMethodBeat.i(2745);
      ab.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.lwa)) {
        a.c(this.lwa).Lp(a.d(this.lwa));
      }
      a.b(this.lwa);
      AppMethodBeat.o(2745);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(2744);
      ab.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.lwa, paramString);
      AppMethodBeat.o(2744);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */