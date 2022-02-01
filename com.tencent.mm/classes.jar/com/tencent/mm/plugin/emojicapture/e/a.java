package com.tencent.mm.plugin.emojicapture.e;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a.a yiE;
  private Context context;
  private final com.tencent.mm.remoteservice.d pfZ;
  private long xxM;
  private com.tencent.mm.plugin.emojicapture.c.a.b yiF;
  private final VideoTransPara yiG;
  private EmojiCaptureUI.b yiH;
  private final EmojiCaptureReporter yiI;
  private a.b yiJ;
  private boolean yiK;
  private boolean yiL;
  private String yiM;
  private final com.tencent.mm.plugin.emojicapture.model.a.b yiN;
  private VoiceInputProxy yiO;
  private final MTimerHandler yiP;
  
  static
  {
    AppMethodBeat.i(333);
    yiE = new a.a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.yiF = paramb;
    this.yiG = paramVideoTransPara;
    this.yiH = paramb1;
    this.yiI = paramEmojiCaptureReporter;
    this.yiJ = a.b.yiQ;
    this.yiN = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.pfZ = new com.tencent.mm.remoteservice.d(this.context);
    this.yiO = new VoiceInputProxy((VoiceInputProxy.b)new c(this), this.pfZ);
    this.yiP = new MTimerHandler(new a..ExternalSyntheticLambda1(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.pfZ));
    this.pfZ.connect(a..ExternalSyntheticLambda3.INSTANCE);
    paramContext = this.yiG;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.dDF();
    paramContext = this.yiG;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.dDF();
    this.yiG.videoBitrate = 5000000;
    j.KVJ.videoBitrate = this.yiG.videoBitrate;
    j.KVJ.nLH = this.yiG;
    this.yiN.scene = this.yiI.scene;
    this.yiN.mnX = this.yiI.mnX;
    AppMethodBeat.o(332);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(269306);
    s.u(parama, "this$0");
    parama.yiH.dEC();
    AppMethodBeat.o(269306);
  }
  
  private static final boolean a(a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(269300);
    s.u(parama, "this$0");
    VoiceInputProxy localVoiceInputProxy;
    int i;
    if (parama.yiO != null)
    {
      localVoiceInputProxy = parama.yiO;
      if (localVoiceInputProxy == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parama.yiF;
      if (i > 10) {
        bool = true;
      }
      parama.on(bool);
      AppMethodBeat.o(269300);
      return true;
      i = localVoiceInputProxy.getMaxAmplitudeRate();
      continue;
      i = 0;
    }
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(269305);
    s.u(parama, "this$0");
    Log.i("MicroMsg.CapturePresenter", "voice finish called force");
    if (!parama.yiL) {
      parama.yiH.apn(parama.yiM);
    }
    parama.yiL = true;
    AppMethodBeat.o(269305);
  }
  
  private static final void dEx()
  {
    AppMethodBeat.i(269303);
    Log.i("MicroMsg.CapturePresenter", "proxy connected");
    AppMethodBeat.o(269303);
  }
  
  public final void Pz()
  {
    AppMethodBeat.i(325);
    Log.i("MicroMsg.CapturePresenter", s.X("pauseCapture ", Boolean.valueOf(this.yiL)));
    if ((this.yiM != null) || (this.yiL))
    {
      this.yiH.apn(this.yiM);
      AppMethodBeat.o(325);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new a..ExternalSyntheticLambda2(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    s.u(paramb, "info");
    Log.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.yiN.setVideoPath(paramb.nJU);
    this.yiN.Hd(paramb.nJV);
    this.yiN.yhd = this.yiM;
    this.yiN.yhe = this.yiF.getDecoration().getTextColor();
    Object localObject = this.yiN;
    paramb = this.yiN.yhc;
    if (paramb == null)
    {
      paramb = null;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).yhf = bool1;
      paramb = this.yiN;
      if (this.yiN.yhf)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.ygj = bool1;
      this.yiN.yhg = this.yiF.getDecoration().getAttachEmoji();
      paramb = this.yiN;
      localObject = this.yiF.getDecoration().getAttachEmojiMatrix();
      s.u(localObject, "<set-?>");
      paramb.yhh = ((Matrix)localObject);
      this.yiH.b(this.yiN);
      AppMethodBeat.o(328);
      return;
      paramb = paramb.acCx;
      break;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(331);
    Log.i("MicroMsg.CapturePresenter", s.X("changeSticker:", paramf));
    this.yiN.yhc = paramf;
    this.yiF.a(paramf);
    AppMethodBeat.o(331);
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(327);
    Log.i("MicroMsg.CapturePresenter", s.X("stop record ", this.yiJ));
    if (this.yiJ == a.b.yiU)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.yiJ = a.b.yiU;
    if (Util.ticksToNow(this.xxM) < 600L)
    {
      localObject = this.yiO;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.yiJ = a.b.yiR;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.yiH;
    Context localContext = this.context;
    String str = this.context.getString(a.i.loading_tips);
    s.s(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, new a..ExternalSyntheticLambda0(this));
    localObject = this.yiF.getDecoration();
    ((CaptureDecoration)localObject).ykW.pause();
    ((CaptureDecoration)localObject).ykX.pause();
    if (this.yiK)
    {
      localObject = this.yiO;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.yiP.stopTimer();
    }
    this.yiI.ygc = System.currentTimeMillis();
    this.yiI.lYJ = (this.yiI.ygc - this.yiI.ygb);
    EmojiCaptureReporter.a(4, this.yiI.mnX, 0L, this.yiI.lYJ, 0L, 0L, 0, 0, this.yiI.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.pfZ.release();
    VoiceInputProxy localVoiceInputProxy = this.yiO;
    if (localVoiceInputProxy != null) {
      localVoiceInputProxy.setUiCallback(null);
    }
    AppMethodBeat.o(330);
  }
  
  public final void dpe()
  {
    AppMethodBeat.i(326);
    Log.i("MicroMsg.CapturePresenter", s.X("start record ", this.yiJ));
    this.yiN.setVideoPath("");
    this.yiN.Hd("");
    this.yiM = this.yiF.getDecoration().getText();
    this.yiF.getDecoration();
    Object localObject = (CharSequence)this.yiM;
    boolean bool;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool = true;
      this.yiK = bool;
      Log.i("MicroMsg.CapturePresenter", s.X("startRecord: useVoiceInput ", Boolean.valueOf(this.yiK)));
      if (this.yiK) {
        if (s.p("NON_NETWORK", NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()))) {
          break label374;
        }
      }
    }
    label374:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.yiO;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.yiP.startTimer(50L);
      }
      this.yiL = false;
      this.yiJ = a.b.yiT;
      this.xxM = Util.currentTicks();
      this.yiI.ygb = System.currentTimeMillis();
      localObject = this.yiI;
      h.OAn.b(15982, new Object[] { Integer.valueOf(3), Long.valueOf(((EmojiCaptureReporter)localObject).mnX), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((EmojiCaptureReporter)localObject).scene), ((EmojiCaptureReporter)localObject).ygo, Integer.valueOf(((EmojiCaptureReporter)localObject).ygp), Integer.valueOf(0), Integer.valueOf(((EmojiCaptureReporter)localObject).ygq), ((EmojiCaptureReporter)localObject).ygr, Integer.valueOf(((EmojiCaptureReporter)localObject).ygs), Integer.valueOf(((EmojiCaptureReporter)localObject).ygt) });
      AppMethodBeat.o(326);
      return;
      bool = false;
      break;
    }
  }
  
  public final void exit()
  {
    AppMethodBeat.i(329);
    EmojiCaptureUI.b.a.a(this.yiH, false);
    AppMethodBeat.o(329);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements VoiceInputProxy.b
  {
    c(a parama) {}
    
    public final void bPD()
    {
      AppMethodBeat.i(324);
      Log.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.c(this.yiW)) {
        a.d(this.yiW).apn(a.e(this.yiW));
      }
      a.f(this.yiW);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      Log.i("MicroMsg.CapturePresenter", s.X("onRes ", paramString));
      a.a(this.yiW, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */