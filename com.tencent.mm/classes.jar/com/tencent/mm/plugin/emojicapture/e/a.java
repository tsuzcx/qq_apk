package com.tencent.mm.plugin.emojicapture.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a uWq;
  private Context context;
  private final com.tencent.mm.remoteservice.d jGJ;
  private b uWf;
  private boolean uWg;
  private boolean uWh;
  private String uWi;
  private final com.tencent.mm.plugin.emojicapture.model.a.b uWj;
  private VoiceInputProxy uWk;
  private final MTimerHandler uWl;
  private com.tencent.mm.plugin.emojicapture.c.a.b uWm;
  private final VideoTransPara uWn;
  private EmojiCaptureUI.b uWo;
  private final EmojiCaptureReporter uWp;
  private long urr;
  
  static
  {
    AppMethodBeat.i(333);
    uWq = new a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.uWm = paramb;
    this.uWn = paramVideoTransPara;
    this.uWo = paramb1;
    this.uWp = paramEmojiCaptureReporter;
    this.uWf = b.uWs;
    this.uWj = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.jGJ = new com.tencent.mm.remoteservice.d(this.context);
    this.uWk = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.jGJ);
    this.uWl = new MTimerHandler((MTimerHandler.CallBack)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.jGJ));
    this.jGJ.connect((Runnable)1.uWr);
    paramContext = this.uWn;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.cXp();
    paramContext = this.uWn;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.cXp();
    this.uWn.videoBitrate = 5000000;
    j.EZX.videoBitrate = this.uWn.videoBitrate;
    j.EZX.lgX = this.uWn;
    this.uWj.scene = this.uWp.scene;
    this.uWj.jPf = this.uWp.jPf;
    AppMethodBeat.o(332);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    p.k(paramb, "info");
    Log.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.uWj.setVideoPath(paramb.lfj);
    this.uWj.ON(paramb.lfk);
    this.uWj.uUs = this.uWi;
    this.uWj.uUt = this.uWm.getDecoration().getTextColor();
    Object localObject = this.uWj;
    paramb = this.uWj.uUr;
    if (paramb != null)
    {
      paramb = paramb.Vbd;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).uUu = bool1;
      paramb = this.uWj;
      if (this.uWj.uUu)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.uTu = bool1;
      this.uWj.uUv = this.uWm.getDecoration().getAttachEmoji();
      paramb = this.uWj;
      localObject = this.uWm.getDecoration().getAttachEmojiMatrix();
      p.k(localObject, "<set-?>");
      paramb.uUw = ((Matrix)localObject);
      this.uWo.b(this.uWj);
      AppMethodBeat.o(328);
      return;
      paramb = null;
      break;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(331);
    Log.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(paramf)));
    this.uWj.uUr = paramf;
    this.uWm.a(paramf);
    AppMethodBeat.o(331);
  }
  
  public final boolean aeJ()
  {
    AppMethodBeat.i(327);
    Log.i("MicroMsg.CapturePresenter", "stop record " + this.uWf);
    if (this.uWf == b.uWw)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.uWf = b.uWw;
    if (Util.ticksToNow(this.urr) < 600L)
    {
      localObject = this.uWk;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.uWf = b.uWt;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.uWo;
    Context localContext = this.context;
    String str = this.context.getString(a.i.loading_tips);
    p.j(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new d(this));
    localObject = this.uWm.getDecoration();
    ((CaptureDecoration)localObject).uYO.pause();
    ((CaptureDecoration)localObject).uYP.pause();
    if (this.uWg)
    {
      localObject = this.uWk;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.uWl.stopTimer();
    }
    this.uWp.uTo = System.currentTimeMillis();
    this.uWp.jvs = (this.uWp.uTo - this.uWp.uTn);
    EmojiCaptureReporter.a(4, this.uWp.jPf, 0L, this.uWp.jvs, 0L, 0L, 0, 0, this.uWp.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(326);
    Log.i("MicroMsg.CapturePresenter", "start record " + this.uWf);
    this.uWj.setVideoPath("");
    this.uWj.ON("");
    this.uWi = this.uWm.getDecoration().getText();
    this.uWm.getDecoration();
    Object localObject = (CharSequence)this.uWi;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.uWg = bool;
      Log.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.uWg);
      if ((this.uWg) && ((p.h("NON_NETWORK", NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())) ^ true)))
      {
        localObject = this.uWk;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.uWl.startTimer(50L);
      }
      this.uWh = false;
      this.uWf = b.uWv;
      this.urr = Util.currentTicks();
      this.uWp.uTn = System.currentTimeMillis();
      this.uWp.bRC();
      AppMethodBeat.o(326);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.jGJ.release();
    VoiceInputProxy localVoiceInputProxy = this.uWk;
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
    EmojiCaptureUI.b.a.a(this.uWo, false);
    AppMethodBeat.o(329);
  }
  
  public final void qo()
  {
    AppMethodBeat.i(325);
    Log.i("MicroMsg.CapturePresenter", "pauseCapture " + this.uWh);
    if ((this.uWi != null) || (this.uWh))
    {
      this.uWo.avn(this.uWi);
      AppMethodBeat.o(325);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed((Runnable)new c(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "", "(Ljava/lang/String;I)V", "RECORD_STATE_IDLE", "RECORD_STATE_PREVIEW", "RECORD_STATE_PREVIEW_PAUSED", "RECORD_STATE_STARTED", "RECORD_STATE_STOP", "plugin-emojicapture_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(317);
      b localb1 = new b("RECORD_STATE_IDLE", 0);
      uWs = localb1;
      b localb2 = new b("RECORD_STATE_PREVIEW", 1);
      uWt = localb2;
      b localb3 = new b("RECORD_STATE_PREVIEW_PAUSED", 2);
      uWu = localb3;
      b localb4 = new b("RECORD_STATE_STARTED", 3);
      uWv = localb4;
      b localb5 = new b("RECORD_STATE_STOP", 4);
      uWw = localb5;
      uWx = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(317);
    }
    
    private b() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(320);
      Log.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.uWy)) {
        a.c(this.uWy).avn(a.d(this.uWy));
      }
      a.b(this.uWy);
      AppMethodBeat.o(320);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(321);
      a.c(this.uWy).cYk();
      AppMethodBeat.o(321);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements MTimerHandler.CallBack
  {
    e(a parama) {}
    
    public final boolean onTimerExpired()
    {
      boolean bool = false;
      AppMethodBeat.i(322);
      Object localObject;
      int i;
      if (a.e(this.uWy) != null)
      {
        localObject = a.e(this.uWy);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.uWy);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).mO(bool);
        AppMethodBeat.o(322);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void brX()
    {
      AppMethodBeat.i(324);
      Log.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.uWy)) {
        a.c(this.uWy).avn(a.d(this.uWy));
      }
      a.b(this.uWy);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      Log.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.uWy, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */