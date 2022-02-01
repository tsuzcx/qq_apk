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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a oMn;
  private Context context;
  private final com.tencent.mm.remoteservice.d fLo;
  private a.b oMc;
  private boolean oMd;
  private boolean oMe;
  private String oMf;
  private final com.tencent.mm.plugin.emojicapture.model.a.b oMg;
  private VoiceInputProxy oMh;
  private final av oMi;
  private com.tencent.mm.plugin.emojicapture.c.a.b oMj;
  private final VideoTransPara oMk;
  private EmojiCaptureUI.b oMl;
  private final EmojiCaptureReporter oMm;
  private long omg;
  
  static
  {
    AppMethodBeat.i(333);
    oMn = new a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.oMj = paramb;
    this.oMk = paramVideoTransPara;
    this.oMl = paramb1;
    this.oMm = paramEmojiCaptureReporter;
    this.oMc = a.b.oMp;
    this.oMg = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.fLo = new com.tencent.mm.remoteservice.d(this.context);
    this.oMh = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.fLo);
    this.oMi = new av((av.a)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.fLo));
    this.fLo.connect((Runnable)a.1.oMo);
    paramContext = this.oMk;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    paramContext = this.oMk;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    this.oMk.videoBitrate = 5000000;
    com.tencent.mm.plugin.mmsight.model.k.tCN.videoBitrate = this.oMk.videoBitrate;
    com.tencent.mm.plugin.mmsight.model.k.tCN.gCB = this.oMk;
    this.oMg.scene = this.oMm.scene;
    this.oMg.fSw = this.oMm.fSw;
    AppMethodBeat.o(332);
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(327);
    ad.i("MicroMsg.CapturePresenter", "stop record " + this.oMc);
    if (this.oMc == a.b.oMt)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.oMc = a.b.oMt;
    if (bt.aS(this.omg) < 600L)
    {
      localObject = this.oMh;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.oMc = a.b.oMq;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.oMl;
    Context localContext = this.context;
    String str = this.context.getString(2131760709);
    d.g.b.k.g(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new d(this));
    localObject = this.oMj.getDecoration();
    ((CaptureDecoration)localObject).oOH.pause();
    ((CaptureDecoration)localObject).oOI.pause();
    if (this.oMd)
    {
      localObject = this.oMh;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.oMi.stopTimer();
    }
    this.oMm.oJd = System.currentTimeMillis();
    this.oMm.fGg = (this.oMm.oJd - this.oMm.oJc);
    EmojiCaptureReporter.a(4, this.oMm.fSw, 0L, this.oMm.fGg, 0L, 0L, 0, 0, this.oMm.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    d.g.b.k.h(paramb, "info");
    ad.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.oMg.setVideoPath(paramb.gBj);
    this.oMg.ru(paramb.gBk);
    this.oMg.oKl = this.oMf;
    this.oMg.oKm = this.oMj.getDecoration().getTextColor();
    Object localObject = this.oMg;
    paramb = this.oMg.oKk;
    if (paramb != null)
    {
      paramb = paramb.Fdb;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).oKn = bool1;
      paramb = this.oMg;
      if (this.oMg.oKn)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.oJj = bool1;
      this.oMg.oKo = this.oMj.getDecoration().getAttachEmoji();
      paramb = this.oMg;
      localObject = this.oMj.getDecoration().getAttachEmojiMatrix();
      d.g.b.k.h(localObject, "<set-?>");
      paramb.oKp = ((Matrix)localObject);
      this.oMl.b(this.oMg);
      AppMethodBeat.o(328);
      return;
      paramb = null;
      break;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(331);
    ad.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(parame)));
    this.oMg.oKk = parame;
    this.oMj.a(parame);
    AppMethodBeat.o(331);
  }
  
  public final void aZs()
  {
    AppMethodBeat.i(326);
    ad.i("MicroMsg.CapturePresenter", "start record " + this.oMc);
    this.oMg.setVideoPath("");
    this.oMg.ru("");
    this.oMf = this.oMj.getDecoration().getText();
    this.oMj.getDecoration();
    Object localObject = (CharSequence)this.oMf;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.oMd = bool;
      ad.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.oMd);
      if ((this.oMd) && ((d.g.b.k.g("NON_NETWORK", ay.getNetTypeString(aj.getContext())) ^ true)))
      {
        localObject = this.oMh;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.oMi.vE(50L);
      }
      this.oMe = false;
      this.oMc = a.b.oMs;
      this.omg = bt.GC();
      this.oMm.oJc = System.currentTimeMillis();
      this.oMm.aZs();
      AppMethodBeat.o(326);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.fLo.release();
    VoiceInputProxy localVoiceInputProxy = this.oMh;
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
    EmojiCaptureUI.b.a.a(this.oMl, false);
    AppMethodBeat.o(329);
  }
  
  public final void qP()
  {
    AppMethodBeat.i(325);
    ad.i("MicroMsg.CapturePresenter", "pauseCapture " + this.oMe);
    if ((this.oMf != null) || (this.oMe))
    {
      this.oMl.Uw(this.oMf);
      AppMethodBeat.o(325);
      return;
    }
    aq.n((Runnable)new c(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(320);
      ad.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.oMv)) {
        a.c(this.oMv).Uw(a.d(this.oMv));
      }
      a.b(this.oMv);
      AppMethodBeat.o(320);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(321);
      a.c(this.oMv).bYt();
      AppMethodBeat.o(321);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
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
      if (a.e(this.oMv) != null)
      {
        localObject = a.e(this.oMv);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.oMv);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).jO(bool);
        AppMethodBeat.o(322);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void aDU()
    {
      AppMethodBeat.i(324);
      ad.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.oMv)) {
        a.c(this.oMv).Uw(a.d(this.oMv));
      }
      a.b(this.oMv);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      ad.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.oMv, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */