package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.g;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sticker.f;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "isMute", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter uWp;
  public boolean uXB;
  private com.tencent.mm.plugin.emojicapture.ui.b.e uXP;
  private final CameraFrontSightView uYA;
  private final MMSightCaptureTouchView uYB;
  private final TextView uYC;
  private final TextView uYD;
  com.tencent.mm.plugin.emojicapture.c.a.a uYE;
  private cqv uYF;
  private final Runnable uYG;
  public com.tencent.mm.media.widget.camerarecordview.a uYH;
  public boolean uYI;
  private final ViewGroup uYs;
  private EmojiCaptureGLTextureView uYt;
  private final MMSightRecordButton uYu;
  private final View uYv;
  private final View uYw;
  public final EditorStickerView uYx;
  private final View uYy;
  public final CaptureDecoration uYz;
  
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
    this.uXP = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    this.uYG = ((Runnable)new c(this));
    View.inflate(paramContext, a.g.uSy, (ViewGroup)this);
    paramAttributeSet = findViewById(a.f.uRS);
    p.j(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.uYs = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRJ);
    p.j(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.uYu = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRw);
    p.j(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.uYv = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uRz);
    p.j(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.uYw = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uSx);
    p.j(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.uYy = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uRy);
    p.j(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.uYz = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.capture_focus_frame);
    p.j(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.uYA = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.capture_touch_view);
    p.j(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.uYB = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRR);
    p.j(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.uYC = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRT);
    p.j(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.uYD = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uRX);
    p.j(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.uYx = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.ci.a.fromDPToPix(paramContext, 120);
    this.uYA.ii(paramInt, paramInt);
    this.uYt = new EmojiCaptureGLTextureView(paramContext);
    this.uYH = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.uYH.Gb(600L);
    this.uYs.addView((View)this.uYt);
    this.uYt.setOpaque(false);
    this.uYu.setHighLightOuter(getResources().getColor(a.c.uRd));
    this.uYu.setInnerColor(getResources().getColor(a.c.BG_5));
    this.uYu.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void cYs()
      {
        AppMethodBeat.i(568);
        Log.i(CaptureContainer.e(this.uYJ), "onLongPressFinish");
        CaptureContainer.a(this.uYJ, this.uYJ.p((kotlin.g.a.b)new b(this)));
        AppMethodBeat.o(568);
      }
      
      public final void cYt()
      {
        AppMethodBeat.i(570);
        Log.i(CaptureContainer.e(this.uYJ), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.f(this.uYJ).getLocationOnScreen(arrayOfInt);
        CaptureContainer.c(this.uYJ).ut(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void dJ()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.f(this.uYJ);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.cXo() * 1000, com.tencent.mm.plugin.emojicapture.ui.c.ef(this.uYJ), (MMSightCircularProgressBar.a)new a(this));
        localObject1 = this.uYJ;
        ((CaptureContainer)localObject1).uYx.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).uYE;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).bRC();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).uYH)) {
          EmojiCaptureReporter.JP(33);
        }
        CaptureContainer.g(this.uYJ).setEnabled(false);
        CaptureContainer.g(this.uYJ).animate().alpha(0.0F).start();
        CaptureContainer.a(this.uYJ, false, 0);
        CaptureContainer.b(this.uYJ).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        public final void Z(ArrayList<Float> paramArrayList) {}
        
        public final void mV(boolean paramBoolean)
        {
          AppMethodBeat.i(201000);
          Log.i(CaptureContainer.e(this.uYK.uYJ), "onLongPress");
          CaptureContainer.a(this.uYK.uYJ, this.uYK.uYJ.p((kotlin.g.a.b)new a(this)));
          AppMethodBeat.o(201000);
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
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
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
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
    this.uYu.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cYu()
      {
        AppMethodBeat.i(572);
        Log.i(CaptureContainer.e(this.uYJ), "simpleTapCallback");
        CaptureContainer.a(this.uYJ, false);
        AppMethodBeat.o(572);
      }
    });
    this.uYu.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void Ka(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.c(this.uYJ).k(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void Kb(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.c(this.uYJ).k(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.uYB.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void J(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.c(this.uYJ).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.uYJ).getWidth(), CaptureContainer.h(this.uYJ).getHeight());
        CaptureContainer.i(this.uYJ).ab(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void bBF()
      {
        AppMethodBeat.i(577);
        CaptureContainer.c(this.uYJ).k(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void bBG()
      {
        AppMethodBeat.i(578);
        CaptureContainer.c(this.uYJ).k(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void cYv()
      {
        AppMethodBeat.i(576);
        CaptureContainer.c(this.uYJ).aYe();
        this.uYJ.aXP();
        AppMethodBeat.o(576);
      }
    });
    this.uYv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(579);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.uYJ.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.exit();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(579);
      }
    });
    this.uYw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(580);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.uYJ.aXP();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(580);
      }
    });
    this.uYD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(581);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = CaptureContainer.j(this.uYJ);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.TdN;
          if (paramAnonymousView != null)
          {
            localObject = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
            p.j(localObject, "Class.forName(\"com.tence….EmojiStoreV2DesignerUI\")");
            localObject = new Intent(paramContext, (Class)localObject);
            ((Intent)localObject).putExtra("uin", paramAnonymousView.TdG);
            ((Intent)localObject).putExtra("name", paramAnonymousView.CMP);
            ((Intent)localObject).putExtra("headurl", paramAnonymousView.SuR);
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(581);
      }
    });
    this.uYx.setSelectionCallback((m)new q(paramContext) {});
    this.uYx.setVisibility(8);
    this.uYC.setAlpha(0.0F);
    post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(583);
        CaptureContainer.a(this.uYJ, true, a.i.uSN);
        AppMethodBeat.o(583);
      }
    });
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      this.uYv.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(571);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = new com.google.android.material.bottomsheet.a(paramContext);
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = new XLabEffectSettingView(paramContext);
          ((XLabEffectSettingView)localObject).setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.e)CaptureContainer.h(this.uYJ));
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
  
  private final void J(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(594);
    if (paramBoolean)
    {
      if (this.uYC.getTop() < getResources().getDimension(a.d.uRn) + getResources().getDimension(a.d.uRq) + getResources().getDimension(a.d.uRo) + getResources().getDimension(a.d.uRp) + com.tencent.mm.ci.a.fromDPToPix(getContext(), 30)) {
        this.uYC.setBackgroundResource(a.e.uRs);
      }
      removeCallbacks(this.uYG);
      this.uYC.animate().cancel();
      this.uYC.animate().alpha(1.0F).start();
      this.uYC.setText(paramInt);
      postDelayed(this.uYG, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.uYC.animate().cancel();
    this.uYC.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(592);
    this.uYz.setStickerInfo(paramf);
    this.uYt.i((kotlin.g.a.a)new a(this, paramf));
    AppMethodBeat.o(592);
  }
  
  public final boolean aXP()
  {
    AppMethodBeat.i(598);
    this.uYI = com.tencent.mm.media.widget.camerarecordview.a.b(this.uYH);
    EmojiCaptureReporter localEmojiCaptureReporter = this.uWp;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.jPf;
      localEmojiCaptureReporter = this.uWp;
      if (localEmojiCaptureReporter == null) {
        break label83;
      }
    }
    label83:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.uYI;
      AppMethodBeat.o(598);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean aZo()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.uTG.aUb()).laO;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean aZp()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.uXl;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean aZq()
  {
    return false;
  }
  
  public final boolean aeg()
  {
    return true;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.uYt;
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
    return this.uYz;
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
    return this.uYE;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.uXP;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    int i = com.tencent.mm.plugin.emojicapture.model.d.cXp();
    locala = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    ((g)localObject).dv(i, com.tencent.mm.plugin.emojicapture.model.d.cXp());
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
      p.iCn();
    }
    com.tencent.mm.media.g.d locald = this.uYt.getPreviewTexture();
    if (locald != null) {}
    for (int i = locald.kVj;; i = -1)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, (com.tencent.mm.media.j.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.uWp;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.uTG.aUb()).kmg;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = j.EZX.lgX;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final void mO(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.uYy.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.uYy.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final void mU(final boolean paramBoolean)
  {
    AppMethodBeat.i(203593);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(203593);
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(203603);
    if (paramWindowInsets != null) {
      findViewById(a.f.uRQ).setPadding(0, paramWindowInsets.getSystemWindowInsetTop(), 0, 0);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    p.j(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(203603);
    return paramWindowInsets;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    Log.i(this.TAG, "resumeCapture");
    mO(false);
    if (this.uXB) {
      this.uYx.setShow(true);
    }
    getDecoration().resume();
    this.uYt.i((kotlin.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.uYH, this.uYI, null, (kotlin.g.a.b)new e(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final boolean p(kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, x> paramb)
  {
    AppMethodBeat.i(597);
    this.uYt.i((kotlin.g.a.a)new g(this));
    boolean bool = this.uYH.p(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.uYE = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.uWp = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    Log.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.uYv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.uYu.setTouchEnable(true);
      this.uYx.cYw();
    }
    if (paramInt == 8)
    {
      this.uYt.setTextureChangeCallback(null);
      this.uYs.removeView((View)this.uYt);
      this.uYt = new EmojiCaptureGLTextureView(getContext());
      this.uYs.addView((View)this.uYt);
      this.uXP = new com.tencent.mm.plugin.emojicapture.ui.b.e();
      this.uYt.a((com.tencent.mm.media.j.a)this.uXP, aZo());
      this.uYt.setOpaque(false);
    }
    this.uYt.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(CaptureContainer paramCaptureContainer, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aZd()
    {
      return 2;
    }
    
    public final String aZe()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      localObject = d.a.cXu();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      localObject = d.a.cXt();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CaptureContainer paramCaptureContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(587);
      CaptureContainer.a(this.uYJ, false, 0);
      AppMethodBeat.o(587);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */