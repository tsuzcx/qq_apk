package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sticker.f;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "isMute", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter rqJ;
  public boolean rrV;
  private final ViewGroup rsN;
  private EmojiCaptureGLTextureView rsO;
  private final MMSightRecordButton rsP;
  private final View rsQ;
  private final View rsR;
  public final EditorStickerView rsS;
  private final View rsT;
  public final CaptureDecoration rsU;
  private final CameraFrontSightView rsV;
  private final MMSightCaptureTouchView rsW;
  private final TextView rsX;
  private final TextView rsY;
  com.tencent.mm.plugin.emojicapture.c.a.a rsZ;
  private com.tencent.mm.plugin.emojicapture.ui.b.e rsj;
  private chz rta;
  private final Runnable rtb;
  public com.tencent.mm.media.widget.camerarecordview.a rtc;
  public boolean rtd;
  
  public CaptureContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(607);
    AppMethodBeat.o(607);
  }
  
  public CaptureContainer(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(606);
    this.TAG = "MicroMsg.CaptureContainer";
    this.rsj = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    this.rtb = ((Runnable)new c(this));
    View.inflate(paramContext, 2131493901, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299958);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.rsN = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299946);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.rsP = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131297996);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.rsQ = paramAttributeSet;
    paramAttributeSet = findViewById(2131298001);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.rsR = paramAttributeSet;
    paramAttributeSet = findViewById(2131309944);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.rsT = paramAttributeSet;
    paramAttributeSet = findViewById(2131297998);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.rsU = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(2131298002);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.rsV = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131298005);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.rsW = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299955);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.rsX = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299960);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.rsY = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299966);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.rsS = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 120);
    this.rsV.hd(paramInt, paramInt);
    this.rsO = new EmojiCaptureGLTextureView(paramContext);
    this.rtc = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.rtc.zU(600L);
    this.rsN.addView((View)this.rsO);
    this.rsO.setOpaque(false);
    this.rsP.setHighLightOuter(getResources().getColor(2131100305));
    this.rsP.setInnerColor(getResources().getColor(2131099653));
    this.rsP.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void cJI()
      {
        AppMethodBeat.i(568);
        Log.i(CaptureContainer.e(this.rte), "onLongPressFinish");
        CaptureContainer.a(this.rte, this.rte.p((kotlin.g.a.b)new b(this)));
        AppMethodBeat.o(568);
      }
      
      public final void cJJ()
      {
        AppMethodBeat.i(570);
        Log.i(CaptureContainer.e(this.rte), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.f(this.rte).getLocationOnScreen(arrayOfInt);
        CaptureContainer.c(this.rte).rz(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void jK()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.f(this.rte);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.cIF() * 1000, com.tencent.mm.plugin.emojicapture.ui.c.dH(this.rte), (MMSightCircularProgressBar.a)new a(this));
        localObject1 = this.rte;
        ((CaptureContainer)localObject1).rsS.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).rsZ;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).bFT();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).rtc)) {
          EmojiCaptureReporter.Gi(33);
        }
        CaptureContainer.g(this.rte).setEnabled(false);
        CaptureContainer.g(this.rte).animate().alpha(0.0F).start();
        CaptureContainer.a(this.rte, false, 0);
        CaptureContainer.b(this.rte).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        public final void Z(ArrayList<Float> paramArrayList) {}
        
        public final void lK(boolean paramBoolean)
        {
          AppMethodBeat.i(256440);
          Log.i(CaptureContainer.e(this.rtf.rte), "onLongPress");
          CaptureContainer.a(this.rtf.rte, this.rtf.rte.p((kotlin.g.a.b)new a(this)));
          AppMethodBeat.o(256440);
        }
        
        @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
        static final class a
          extends q
          implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x>
        {
          a(CaptureContainer.1.a parama)
          {
            super();
          }
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
      static final class b
        extends q
        implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x>
      {
        b(CaptureContainer.1 param1)
        {
          super();
        }
      }
    });
    this.rsP.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cJK()
      {
        AppMethodBeat.i(572);
        Log.i(CaptureContainer.e(this.rte), "simpleTapCallback");
        CaptureContainer.a(this.rte, false);
        AppMethodBeat.o(572);
      }
    });
    this.rsP.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void Gt(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.c(this.rte).i(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void Gu(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.c(this.rte).i(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.rsW.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void I(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.c(this.rte).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.rte).getWidth(), CaptureContainer.h(this.rte).getHeight());
        CaptureContainer.i(this.rte).aa(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void bqQ()
      {
        AppMethodBeat.i(577);
        CaptureContainer.c(this.rte).i(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void bqR()
      {
        AppMethodBeat.i(578);
        CaptureContainer.c(this.rte).i(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void cJL()
      {
        AppMethodBeat.i(576);
        CaptureContainer.c(this.rte).aPq();
        this.rte.aPb();
        AppMethodBeat.o(576);
      }
    });
    this.rsQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(579);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.rte.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.exit();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(579);
      }
    });
    this.rsR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(580);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.rte.aPb();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(580);
      }
    });
    this.rsY.setOnClickListener((View.OnClickListener)new CaptureContainer.8(this, paramContext));
    this.rsS.setSelectionCallback((m)new q(paramContext) {});
    this.rsS.setVisibility(8);
    this.rsX.setAlpha(0.0F);
    post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(583);
        CaptureContainer.a(this.rte, true, 2131756945);
        AppMethodBeat.o(583);
      }
    });
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      this.rsQ.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(571);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new android.support.design.widget.a(paramContext);
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = new XLabEffectSettingView(paramContext);
          ((XLabEffectSettingView)localObject).setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.e)CaptureContainer.h(this.rte));
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(571);
          return true;
        }
      });
    }
    AppMethodBeat.o(606);
  }
  
  private final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(594);
    if (paramBoolean)
    {
      if (this.rsX.getTop() < getResources().getDimension(2131166248) + getResources().getDimension(2131166813) + getResources().getDimension(2131166249) + getResources().getDimension(2131166250) + com.tencent.mm.cb.a.fromDPToPix(getContext(), 30)) {
        this.rsX.setBackgroundResource(2131232102);
      }
      removeCallbacks(this.rtb);
      this.rsX.animate().cancel();
      this.rsX.animate().alpha(1.0F).start();
      this.rsX.setText(paramInt);
      postDelayed(this.rtb, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.rsX.animate().cancel();
    this.rsX.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  public final boolean Zx()
  {
    return true;
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(592);
    this.rsU.setStickerInfo(paramf);
    this.rsO.j((kotlin.g.a.a)new a(this, paramf));
    AppMethodBeat.o(592);
  }
  
  public final boolean aPb()
  {
    AppMethodBeat.i(598);
    this.rtd = com.tencent.mm.media.widget.camerarecordview.a.b(this.rtc);
    EmojiCaptureReporter localEmojiCaptureReporter = this.rqJ;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.hdz;
      localEmojiCaptureReporter = this.rqJ;
      if (localEmojiCaptureReporter == null) {
        break label83;
      }
    }
    label83:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.rtd;
      AppMethodBeat.o(598);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean aQw()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).ilO;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean aQx()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.rrF;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean aQy()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.rsO;
  }
  
  public final VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(608);
    VideoTransPara localVideoTransPara = getVideoTransPara();
    AppMethodBeat.o(608);
    return localVideoTransPara;
  }
  
  public final CaptureDecoration getDecoration()
  {
    return this.rsU;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(601);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new b();
    AppMethodBeat.o(601);
    return locala;
  }
  
  public final com.tencent.mm.plugin.emojicapture.c.a.a getPresenter()
  {
    return this.rsZ;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.rsj;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.roA;
    int i = com.tencent.mm.plugin.emojicapture.model.d.cIG();
    locala = com.tencent.mm.plugin.emojicapture.model.d.roA;
    ((g)localObject).cZ(i, com.tencent.mm.plugin.emojicapture.model.d.cIG());
    localObject = (com.tencent.mm.media.j.a)localObject;
    AppMethodBeat.o(603);
    return localObject;
  }
  
  public final int getRecordScene()
  {
    return 8;
  }
  
  public final com.tencent.mm.media.widget.c.b getRecorder()
  {
    AppMethodBeat.i(604);
    Object localObject = getRecordRenderer();
    VideoTransPara localVideoTransPara = getVideoTransPara();
    EGLContext localEGLContext = getCameraPreviewView().getEGLContext();
    if (localEGLContext == null) {
      kotlin.g.b.p.hyc();
    }
    com.tencent.mm.media.g.d locald = this.rsO.getPreviewTexture();
    if (locald != null) {}
    for (int i = locald.igv;; i = -1)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, (com.tencent.mm.media.j.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.rqJ;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).hzj;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = k.zuy.irT;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.rsT.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.rsT.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final void lJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(256442);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(256442);
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(256443);
    if (paramWindowInsets != null) {
      findViewById(2131299954).setPadding(0, paramWindowInsets.getSystemWindowInsetTop(), 0, 0);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    kotlin.g.b.p.g(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(256443);
    return paramWindowInsets;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    Log.i(this.TAG, "resumeCapture");
    lD(false);
    if (this.rrV) {
      this.rsS.setShow(true);
    }
    getDecoration().resume();
    this.rsO.j((kotlin.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.rtc, this.rtd, (kotlin.g.a.b)new e(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final boolean p(kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, x> paramb)
  {
    AppMethodBeat.i(597);
    this.rsO.j((kotlin.g.a.a)new g(this));
    boolean bool = this.rtc.p(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.rsZ = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.rqJ = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    Log.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.rsQ.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.rsP.setTouchEnable(true);
      this.rsS.cJM();
    }
    if (paramInt == 8)
    {
      this.rsO.setTextureChangeCallback(null);
      this.rsN.removeView((View)this.rsO);
      this.rsO = new EmojiCaptureGLTextureView(getContext());
      this.rsN.addView((View)this.rsO);
      this.rsj = new com.tencent.mm.plugin.emojicapture.ui.b.e();
      this.rsO.a((com.tencent.mm.media.j.a)this.rsj, aQw());
      this.rsO.setOpaque(false);
    }
    this.rsO.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(CaptureContainer paramCaptureContainer, f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aQm()
    {
      return 2;
    }
    
    public final String aQn()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
      localObject = d.a.cIL();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
      localObject = d.a.cIK();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CaptureContainer paramCaptureContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(587);
      CaptureContainer.a(this.rte, false, 0);
      AppMethodBeat.o(587);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(CaptureContainer paramCaptureContainer, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */