package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.g;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "beautyParaBtn", "Landroid/widget/Button;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLSurfaceTextureRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "", "voiceDetectView", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.c.a, a.b
{
  public final String TAG;
  private EmojiCaptureReporter lsY;
  private final ViewGroup lxY;
  private EmojiCaptureGLTextureView lxZ;
  public com.tencent.mm.plugin.emojicapture.ui.b.b lya;
  private final MMSightRecordButton lyb;
  private final View lyc;
  private final View lyd;
  private final EditorStickerView lye;
  private final View lyf;
  private final CaptureDecoration lyg;
  private final CameraFrontSightView lyh;
  private final MMSightCaptureTouchView lyi;
  private final TextView lyj;
  private final Button lyk;
  com.tencent.mm.plugin.emojicapture.c.a.a lyl;
  private final Runnable lym;
  public com.tencent.mm.media.widget.camerarecordview.a lyn;
  public boolean lyo;
  
  public CaptureContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(2984);
    AppMethodBeat.o(2984);
  }
  
  public CaptureContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(2983);
    this.TAG = "MicroMsg.CaptureContainer";
    this.lya = new com.tencent.mm.plugin.emojicapture.ui.b.b((byte)0);
    this.lym = ((Runnable)new CaptureContainer.c(this));
    View.inflate(paramContext, 2130969356, (ViewGroup)this);
    paramAttributeSet = findViewById(2131823533);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.lxY = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131823538);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.lyb = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131823542);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.lyc = paramAttributeSet;
    paramAttributeSet = findViewById(2131823539);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.lyd = paramAttributeSet;
    paramAttributeSet = findViewById(2131823540);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.lyf = paramAttributeSet;
    paramAttributeSet = findViewById(2131823534);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.lyg = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(2131823535);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.lyh = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823536);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.lyi = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823541);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.lyj = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823537);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.lye = ((EditorStickerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823543);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.beauty_debug)");
    this.lyk = ((Button)paramAttributeSet);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 120);
    this.lyh.eI(paramInt, paramInt);
    this.lxZ = new EmojiCaptureGLTextureView(paramContext);
    this.lyn = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.c.a)this);
    this.lyn.gq(600L);
    this.lxY.addView((View)this.lxZ);
    this.lxZ.setOpaque(false);
    this.lyb.setHighLightOuter(com.tencent.mm.plugin.emojicapture.ui.a.dk(this));
    this.lyb.setLongPressCallback((MMSightRecordButton.b)new CaptureContainer.1(this));
    this.lyb.setSimpleTapCallback((MMSightRecordButton.d)new CaptureContainer.2(this));
    this.lyb.setLongPressScrollCallback((MMSightRecordButton.c)new CaptureContainer.3(this));
    this.lyi.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void T(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(2953);
        CaptureContainer.c(this.lyp).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.lyp).getWidth(), CaptureContainer.h(this.lyp).getHeight());
        CaptureContainer.i(this.lyp).Z(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(2953);
      }
      
      public final void asQ()
      {
        AppMethodBeat.i(2955);
        CaptureContainer.c(this.lyp).a(true, false, 1);
        AppMethodBeat.o(2955);
      }
      
      public final void asR()
      {
        AppMethodBeat.i(2956);
        CaptureContainer.c(this.lyp).a(false, false, 1);
        AppMethodBeat.o(2956);
      }
      
      public final void bpb()
      {
        AppMethodBeat.i(2954);
        CaptureContainer.c(this.lyp).WW();
        this.lyp.WN();
        AppMethodBeat.o(2954);
      }
    });
    this.lyc.setOnClickListener((View.OnClickListener)new CaptureContainer.5(this));
    this.lyd.setOnClickListener((View.OnClickListener)new CaptureContainer.6(this));
    if (bp.dud())
    {
      this.lyk.setVisibility(0);
      this.lyk.setOnClickListener((View.OnClickListener)new CaptureContainer.7(paramContext));
    }
    for (;;)
    {
      this.lye.setCallback((a.f.a.b)new CaptureContainer.8(this));
      this.lye.setVisibility(8);
      this.lyj.setAlpha(0.0F);
      post((Runnable)new CaptureContainer.9(this));
      AppMethodBeat.o(2983);
      return;
      this.lyk.setVisibility(8);
    }
  }
  
  private final void u(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(2971);
    if (paramBoolean)
    {
      removeCallbacks(this.lym);
      this.lyj.animate().cancel();
      this.lyj.animate().alpha(1.0F).start();
      this.lyj.setText(paramInt);
      postDelayed(this.lym, 2000L);
      AppMethodBeat.o(2971);
      return;
    }
    this.lyj.animate().cancel();
    this.lyj.animate().alpha(0.0F).start();
    AppMethodBeat.o(2971);
  }
  
  public final boolean DP()
  {
    return true;
  }
  
  public final boolean WN()
  {
    AppMethodBeat.i(2975);
    this.lyo = this.lyn.WN();
    EmojiCaptureReporter localEmojiCaptureReporter = this.lsY;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.eyh;
      localEmojiCaptureReporter = this.lsY;
      if (localEmojiCaptureReporter == null) {
        break label84;
      }
    }
    label84:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.lyo;
      AppMethodBeat.o(2975);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean Xn()
  {
    AppMethodBeat.i(2976);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.lta.Uw()).eZM;
    AppMethodBeat.o(2976);
    return bool;
  }
  
  public final boolean Xo()
  {
    AppMethodBeat.i(2982);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.lwI;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(2982);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(2969);
    this.lyg.setStickerInfo(paramb);
    this.lxZ.e((a.f.a.a)new CaptureContainer.a(this, paramb));
    AppMethodBeat.o(2969);
  }
  
  public final boolean c(a.f.a.b<? super com.tencent.mm.media.widget.camerarecordview.a.b, y> paramb)
  {
    AppMethodBeat.i(2974);
    com.tencent.mm.plugin.emojicapture.c.a.a locala = this.lyl;
    if (locala != null) {
      locala.Et();
    }
    boolean bool = this.lyn.c(paramb);
    AppMethodBeat.o(2974);
    return bool;
  }
  
  public final void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(2970);
    if (paramBoolean)
    {
      this.lyf.setVisibility(0);
      AppMethodBeat.o(2970);
      return;
    }
    this.lyf.setVisibility(8);
    AppMethodBeat.o(2970);
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.c getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.c)this.lxZ;
  }
  
  public final CaptureDecoration getDecoration()
  {
    return this.lyg;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.a.a getEncodeConfig()
  {
    AppMethodBeat.i(2978);
    com.tencent.mm.media.widget.camerarecordview.a.a locala = (com.tencent.mm.media.widget.camerarecordview.a.a)new CaptureContainer.b();
    AppMethodBeat.o(2978);
    return locala;
  }
  
  public final com.tencent.mm.plugin.emojicapture.c.a.a getPresenter()
  {
    return this.lyl;
  }
  
  public final com.tencent.mm.media.h.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.h.a)this.lya;
  }
  
  public final com.tencent.mm.media.h.a getRecordRenderer()
  {
    AppMethodBeat.i(2980);
    Object localObject = new g();
    c.a locala = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    com.tencent.mm.plugin.emojicapture.model.c.bnP();
    locala = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    com.tencent.mm.plugin.emojicapture.model.c.bnP();
    localObject = (com.tencent.mm.media.h.a)localObject;
    AppMethodBeat.o(2980);
    return localObject;
  }
  
  public final com.tencent.mm.media.widget.b.b getRecorder()
  {
    AppMethodBeat.i(2981);
    Object localObject = getRecordRenderer();
    VideoTransPara localVideoTransPara = getVideoTransPara();
    EGLContext localEGLContext = getCameraPreviewView().getEGLContext();
    if (localEGLContext == null) {
      a.f.b.j.ebi();
    }
    localObject = (com.tencent.mm.media.widget.b.b)new com.tencent.mm.media.widget.b.c(localVideoTransPara, (com.tencent.mm.media.h.a)localObject, localEGLContext, this.lxZ.getPreviewTextureId());
    AppMethodBeat.o(2981);
    return localObject;
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.lsY;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(2977);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.lta.Uw()).ltb;
    AppMethodBeat.o(2977);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(2979);
    VideoTransPara localVideoTransPara = com.tencent.mm.plugin.mmsight.model.j.oHG.fcu;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(2979);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(2979);
    return localVideoTransPara;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(2973);
    ab.i(this.TAG, "resumeCapture");
    gS(false);
    getDecoration().resume();
    this.lyn.a(this.lyo, (a.f.a.b)new CaptureContainer.d(this));
    AppMethodBeat.o(2973);
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.lyl = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.lsY = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(2972);
    ab.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.lyc.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.lyb.setTouchEnable(true);
      this.lye.bpd();
    }
    if (paramInt == 8)
    {
      this.lxZ.setTextureChangeCallback(null);
      this.lxY.removeView((View)this.lxZ);
      this.lxZ = new EmojiCaptureGLTextureView(getContext());
      this.lxY.addView((View)this.lxZ);
      this.lya = new com.tencent.mm.plugin.emojicapture.ui.b.b((byte)0);
      this.lxZ.a((com.tencent.mm.media.h.a)this.lya, Xn());
      this.lxZ.setOpaque(false);
    }
    this.lxZ.setVisibility(paramInt);
    AppMethodBeat.o(2972);
  }
  
  public final void setup(EmojiInfo paramEmojiInfo)
  {
    long l = 0L;
    AppMethodBeat.i(2968);
    if (paramEmojiInfo != null)
    {
      this.lyg.setImitateEmoji(paramEmojiInfo);
      EditorStickerView localEditorStickerView = this.lye;
      localObject = this.lsY;
      if (localObject != null) {
        l = ((EmojiCaptureReporter)localObject).eyh;
      }
      localObject = paramEmojiInfo.field_lensId;
      paramEmojiInfo = (EmojiInfo)localObject;
      if (localObject == null) {
        paramEmojiInfo = "";
      }
      localEditorStickerView.m(l, paramEmojiInfo);
      AppMethodBeat.o(2968);
      return;
    }
    this.lyg.setImitateEmoji(null);
    paramEmojiInfo = this.lye;
    Object localObject = this.lsY;
    if (localObject != null) {
      l = ((EmojiCaptureReporter)localObject).eyh;
    }
    paramEmojiInfo.m(l, null);
    AppMethodBeat.o(2968);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class e
    extends k
    implements a.f.a.a<y>
  {
    e(CaptureContainer paramCaptureContainer, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */