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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a.a rqK;
  private Context context;
  private final com.tencent.mm.remoteservice.d gVN;
  private long qPl;
  private boolean rqA;
  private boolean rqB;
  private String rqC;
  private final com.tencent.mm.plugin.emojicapture.model.a.b rqD;
  private VoiceInputProxy rqE;
  private final MTimerHandler rqF;
  private com.tencent.mm.plugin.emojicapture.c.a.b rqG;
  private final VideoTransPara rqH;
  private EmojiCaptureUI.b rqI;
  private final EmojiCaptureReporter rqJ;
  private a.b rqz;
  
  static
  {
    AppMethodBeat.i(333);
    rqK = new a.a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.rqG = paramb;
    this.rqH = paramVideoTransPara;
    this.rqI = paramb1;
    this.rqJ = paramEmojiCaptureReporter;
    this.rqz = a.b.rqM;
    this.rqD = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.gVN = new com.tencent.mm.remoteservice.d(this.context);
    this.rqE = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.gVN);
    this.rqF = new MTimerHandler((MTimerHandler.CallBack)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
    this.gVN.connect((Runnable)a.1.rqL);
    paramContext = this.rqH;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.roA;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.cIG();
    paramContext = this.rqH;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.roA;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.cIG();
    this.rqH.videoBitrate = 5000000;
    k.zuy.videoBitrate = this.rqH.videoBitrate;
    k.zuy.irT = this.rqH;
    this.rqD.scene = this.rqJ.scene;
    this.rqD.hdz = this.rqJ.hdz;
    AppMethodBeat.o(332);
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(327);
    Log.i("MicroMsg.CapturePresenter", "stop record " + this.rqz);
    if (this.rqz == a.b.rqQ)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.rqz = a.b.rqQ;
    if (Util.ticksToNow(this.qPl) < 600L)
    {
      localObject = this.rqE;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.rqz = a.b.rqN;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.rqI;
    Context localContext = this.context;
    String str = this.context.getString(2131762446);
    p.g(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new d(this));
    localObject = this.rqG.getDecoration();
    ((CaptureDecoration)localObject).rtj.pause();
    ((CaptureDecoration)localObject).rtk.pause();
    if (this.rqA)
    {
      localObject = this.rqE;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.rqF.stopTimer();
    }
    this.rqJ.rnH = System.currentTimeMillis();
    this.rqJ.gLd = (this.rqJ.rnH - this.rqJ.rnG);
    EmojiCaptureReporter.a(4, this.rqJ.hdz, 0L, this.rqJ.gLd, 0L, 0L, 0, 0, this.rqJ.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    p.h(paramb, "info");
    Log.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.rqD.setVideoPath(paramb.iqd);
    this.rqD.HA(paramb.iqe);
    this.rqD.roM = this.rqC;
    this.rqD.roN = this.rqG.getDecoration().getTextColor();
    Object localObject = this.rqD;
    paramb = this.rqD.roL;
    if (paramb != null)
    {
      paramb = paramb.NNt;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).roO = bool1;
      paramb = this.rqD;
      if (this.rqD.roO)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.rnN = bool1;
      this.rqD.roP = this.rqG.getDecoration().getAttachEmoji();
      paramb = this.rqD;
      localObject = this.rqG.getDecoration().getAttachEmojiMatrix();
      p.h(localObject, "<set-?>");
      paramb.roQ = ((Matrix)localObject);
      this.rqI.b(this.rqD);
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
    this.rqD.roL = paramf;
    this.rqG.a(paramf);
    AppMethodBeat.o(331);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(326);
    Log.i("MicroMsg.CapturePresenter", "start record " + this.rqz);
    this.rqD.setVideoPath("");
    this.rqD.HA("");
    this.rqC = this.rqG.getDecoration().getText();
    this.rqG.getDecoration();
    Object localObject = (CharSequence)this.rqC;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.rqA = bool;
      Log.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.rqA);
      if ((this.rqA) && ((p.j("NON_NETWORK", NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())) ^ true)))
      {
        localObject = this.rqE;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.rqF.startTimer(50L);
      }
      this.rqB = false;
      this.rqz = a.b.rqP;
      this.qPl = Util.currentTicks();
      this.rqJ.rnG = System.currentTimeMillis();
      this.rqJ.bFT();
      AppMethodBeat.o(326);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.gVN.release();
    VoiceInputProxy localVoiceInputProxy = this.rqE;
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
    EmojiCaptureUI.b.a.a(this.rqI, false);
    AppMethodBeat.o(329);
  }
  
  public final void sA()
  {
    AppMethodBeat.i(325);
    Log.i("MicroMsg.CapturePresenter", "pauseCapture " + this.rqB);
    if ((this.rqC != null) || (this.rqB))
    {
      this.rqI.ano(this.rqC);
      AppMethodBeat.o(325);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed((Runnable)new c(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(320);
      Log.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.rqS)) {
        a.c(this.rqS).ano(a.d(this.rqS));
      }
      a.b(this.rqS);
      AppMethodBeat.o(320);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(321);
      a.c(this.rqS).cJC();
      AppMethodBeat.o(321);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
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
      if (a.e(this.rqS) != null)
      {
        localObject = a.e(this.rqS);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.rqS);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).lD(bool);
        AppMethodBeat.o(322);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void biz()
    {
      AppMethodBeat.i(324);
      Log.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.rqS)) {
        a.c(this.rqS).ano(a.d(this.rqS));
      }
      a.b(this.rqS);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      Log.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.rqS, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */