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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sticker.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  public static final a.a ppH;
  private Context context;
  private final com.tencent.mm.remoteservice.d fPa;
  private long oPG;
  private final com.tencent.mm.plugin.emojicapture.model.a.b ppA;
  private VoiceInputProxy ppB;
  private final au ppC;
  private com.tencent.mm.plugin.emojicapture.c.a.b ppD;
  private final VideoTransPara ppE;
  private EmojiCaptureUI.b ppF;
  private final EmojiCaptureReporter ppG;
  private a.b ppw;
  private boolean ppx;
  private boolean ppy;
  private String ppz;
  
  static
  {
    AppMethodBeat.i(333);
    ppH = new a.a((byte)0);
    AppMethodBeat.o(333);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, EmojiCaptureUI.b paramb1, EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    AppMethodBeat.i(332);
    this.context = paramContext;
    this.ppD = paramb;
    this.ppE = paramVideoTransPara;
    this.ppF = paramb1;
    this.ppG = paramEmojiCaptureReporter;
    this.ppw = a.b.ppJ;
    this.ppA = new com.tencent.mm.plugin.emojicapture.model.a.b();
    this.fPa = new com.tencent.mm.remoteservice.d(this.context);
    this.ppB = new VoiceInputProxy((VoiceInputProxy.b)new f(this), this.fPa);
    this.ppC = new au((au.a)new e(this), true);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.fPa));
    this.fPa.connect((Runnable)a.1.ppI);
    paramContext = this.ppE;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    paramContext.width = com.tencent.mm.plugin.emojicapture.model.d.ceL();
    paramContext = this.ppE;
    paramb = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    paramContext.height = com.tencent.mm.plugin.emojicapture.model.d.ceL();
    this.ppE.videoBitrate = 5000000;
    com.tencent.mm.plugin.mmsight.model.k.uLk.videoBitrate = this.ppE.videoBitrate;
    com.tencent.mm.plugin.mmsight.model.k.uLk.hcZ = this.ppE;
    this.ppA.scene = this.ppG.scene;
    this.ppA.fWr = this.ppG.fWr;
    AppMethodBeat.o(332);
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(327);
    ac.i("MicroMsg.CapturePresenter", "stop record " + this.ppw);
    if (this.ppw == a.b.ppN)
    {
      AppMethodBeat.o(327);
      return true;
    }
    this.ppw = a.b.ppN;
    if (bs.aO(this.oPG) < 600L)
    {
      localObject = this.ppB;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.ppw = a.b.ppK;
      AppMethodBeat.o(327);
      return false;
    }
    Object localObject = this.ppF;
    Context localContext = this.context;
    String str = this.context.getString(2131760709);
    d.g.b.k.g(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, true, (DialogInterface.OnCancelListener)new d(this));
    localObject = this.ppD.getDecoration();
    ((CaptureDecoration)localObject).psb.pause();
    ((CaptureDecoration)localObject).psc.pause();
    if (this.ppx)
    {
      localObject = this.ppB;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      this.ppC.stopTimer();
    }
    this.ppG.pmD = System.currentTimeMillis();
    this.ppG.fJN = (this.ppG.pmD - this.ppG.pmC);
    EmojiCaptureReporter.a(4, this.ppG.fWr, 0L, this.ppG.fJN, 0L, 0L, 0, 0, this.ppG.scene);
    AppMethodBeat.o(327);
    return true;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(328);
    d.g.b.k.h(paramb, "info");
    ac.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
    this.ppA.setVideoPath(paramb.hbF);
    this.ppA.vx(paramb.hbG);
    this.ppA.pnJ = this.ppz;
    this.ppA.pnK = this.ppD.getDecoration().getTextColor();
    Object localObject = this.ppA;
    paramb = this.ppA.pnI;
    if (paramb != null)
    {
      paramb = paramb.GAy;
      if (paramb != null) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.emojicapture.model.a.b)localObject).pnL = bool1;
      paramb = this.ppA;
      if (this.ppA.pnL)
      {
        bool1 = bool2;
        if (paramBoolean) {}
      }
      else
      {
        bool1 = true;
      }
      paramb.pmJ = bool1;
      this.ppA.pnM = this.ppD.getDecoration().getAttachEmoji();
      paramb = this.ppA;
      localObject = this.ppD.getDecoration().getAttachEmojiMatrix();
      d.g.b.k.h(localObject, "<set-?>");
      paramb.pnN = ((Matrix)localObject);
      this.ppF.b(this.ppA);
      AppMethodBeat.o(328);
      return;
      paramb = null;
      break;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(331);
    ac.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(paramf)));
    this.ppA.pnI = paramf;
    this.ppD.a(paramf);
    AppMethodBeat.o(331);
  }
  
  public final void bgk()
  {
    AppMethodBeat.i(326);
    ac.i("MicroMsg.CapturePresenter", "start record " + this.ppw);
    this.ppA.setVideoPath("");
    this.ppA.vx("");
    this.ppz = this.ppD.getDecoration().getText();
    this.ppD.getDecoration();
    Object localObject = (CharSequence)this.ppz;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ppx = bool;
      ac.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.ppx);
      if ((this.ppx) && ((d.g.b.k.g("NON_NETWORK", ax.getNetTypeString(ai.getContext())) ^ true)))
      {
        localObject = this.ppB;
        if (localObject != null) {
          ((VoiceInputProxy)localObject).start();
        }
        this.ppC.Ah(50L);
      }
      this.ppy = false;
      this.ppw = a.b.ppM;
      this.oPG = bs.Gn();
      this.ppG.pmC = System.currentTimeMillis();
      this.ppG.bgk();
      AppMethodBeat.o(326);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(330);
    this.fPa.release();
    VoiceInputProxy localVoiceInputProxy = this.ppB;
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
    EmojiCaptureUI.b.a.a(this.ppF, false);
    AppMethodBeat.o(329);
  }
  
  public final void qZ()
  {
    AppMethodBeat.i(325);
    ac.i("MicroMsg.CapturePresenter", "pauseCapture " + this.ppy);
    if ((this.ppz != null) || (this.ppy))
    {
      this.ppF.YI(this.ppz);
      AppMethodBeat.o(325);
      return;
    }
    ap.n((Runnable)new c(this), 1500L);
    AppMethodBeat.o(325);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(320);
      ac.i("MicroMsg.CapturePresenter", "voice finish called force");
      if (!a.a(this.ppP)) {
        a.c(this.ppP).YI(a.d(this.ppP));
      }
      a.b(this.ppP);
      AppMethodBeat.o(320);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(321);
      a.c(this.ppP).cfH();
      AppMethodBeat.o(321);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements au.a
  {
    e(a parama) {}
    
    public final boolean onTimerExpired()
    {
      boolean bool = false;
      AppMethodBeat.i(322);
      Object localObject;
      int i;
      if (a.e(this.ppP) != null)
      {
        localObject = a.e(this.ppP);
        if (localObject != null) {
          i = ((VoiceInputProxy)localObject).getMaxAmplitudeRate();
        }
      }
      for (;;)
      {
        localObject = a.f(this.ppP);
        if (i > 10) {
          bool = true;
        }
        ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).kr(bool);
        AppMethodBeat.o(322);
        return true;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static final class f
    implements VoiceInputProxy.b
  {
    public final void aKL()
    {
      AppMethodBeat.i(324);
      ac.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
      if (!a.a(this.ppP)) {
        a.c(this.ppP).YI(a.d(this.ppP));
      }
      a.b(this.ppP);
      AppMethodBeat.o(324);
    }
    
    public final void onRes(String paramString)
    {
      AppMethodBeat.i(323);
      ac.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(paramString)));
      a.a(this.ppP, paramString);
      AppMethodBeat.o(323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */