package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
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
import com.tencent.mm.plugin.emojicapture.ui.b.e;
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
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sticker.f;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "isMute", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter yiI;
  public boolean yjR;
  private final ViewGroup ykD;
  private EmojiCaptureGLTextureView ykE;
  private final MMSightRecordButton ykF;
  private final View ykG;
  private final View ykH;
  public final EditorStickerView ykI;
  private final View ykJ;
  public final CaptureDecoration ykK;
  private final CameraFrontSightView ykL;
  private final MMSightCaptureTouchView ykM;
  private final TextView ykN;
  private final TextView ykO;
  com.tencent.mm.plugin.emojicapture.c.a.a ykP;
  private dhp ykQ;
  private final Runnable ykR;
  public com.tencent.mm.media.widget.camerarecordview.a ykS;
  public boolean ykT;
  private e ykd;
  
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
    this.ykd = new e();
    this.ykR = new CaptureContainer..ExternalSyntheticLambda6(this);
    View.inflate(paramContext, a.g.yfm, (ViewGroup)this);
    paramAttributeSet = findViewById(a.f.yeG);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.ykD = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yex);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.ykF = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yek);
    s.s(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.ykG = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yen);
    s.s(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.ykH = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yfl);
    s.s(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.ykJ = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yem);
    s.s(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.ykK = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.capture_focus_frame);
    s.s(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.ykL = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.capture_touch_view);
    s.s(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.ykM = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeF);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.ykN = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeH);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.ykO = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeL);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.ykI = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(paramContext, 120);
    this.ykL.jN(paramInt, paramInt);
    this.ykE = new EmojiCaptureGLTextureView(paramContext);
    this.ykS = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.ykS.ij(600L);
    this.ykD.addView((View)this.ykE);
    this.ykE.setOpaque(false);
    this.ykF.setHighLightOuter(getResources().getColor(a.c.ydR));
    this.ykF.setInnerColor(getResources().getColor(a.c.BG_5));
    this.ykF.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void dEK()
      {
        AppMethodBeat.i(568);
        Log.i(CaptureContainer.h(this.ykU), "onLongPressFinish");
        CaptureContainer.a(this.ykU, this.ykU.J((kotlin.g.a.b)new b(this.ykU)));
        AppMethodBeat.o(568);
      }
      
      public final void dEL()
      {
        AppMethodBeat.i(570);
        Log.i(CaptureContainer.h(this.ykU), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.i(this.ykU).getLocationOnScreen(arrayOfInt);
        CaptureContainer.f(this.ykU).ut(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void eI()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.i(this.ykU);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.dDE() * 1000, com.tencent.mm.plugin.emojicapture.ui.b.eZ((View)this.ykU), (MMSightCircularProgressBar.a)new a(this.ykU));
        localObject1 = this.ykU;
        ((CaptureContainer)localObject1).ykI.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).ykP;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).dpe();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).ykS)) {
          EmojiCaptureReporter.KN(33);
        }
        CaptureContainer.j(this.ykU).setEnabled(false);
        CaptureContainer.j(this.ykU).animate().alpha(0.0F).start();
        CaptureContainer.k(this.ykU);
        CaptureContainer.e(this.ykU).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        a(CaptureContainer paramCaptureContainer) {}
        
        public final void ad(ArrayList<Float> paramArrayList) {}
        
        public final void ov(boolean paramBoolean)
        {
          AppMethodBeat.i(269570);
          Log.i(CaptureContainer.h(this.ykU), "onLongPress");
          CaptureContainer.a(this.ykU, this.ykU.J((kotlin.g.a.b)new a(this.ykU)));
          AppMethodBeat.o(269570);
        }
        
        @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;"}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, ah>
        {
          a(CaptureContainer paramCaptureContainer)
          {
            super();
          }
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;"}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends u
        implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, ah>
      {
        b(CaptureContainer paramCaptureContainer)
        {
          super();
        }
      }
    });
    this.ykF.setSimpleTapCallback(new CaptureContainer..ExternalSyntheticLambda4(this));
    this.ykF.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void KY(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.f(this.ykU).h(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void KZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.f(this.ykU).h(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.ykM.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void al(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.f(this.ykU).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.l(this.ykU).getWidth(), CaptureContainer.l(this.ykU).getHeight());
        CaptureContainer.m(this.ykU).aG(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void bof()
      {
        AppMethodBeat.i(577);
        CaptureContainer.f(this.ykU).h(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void bog()
      {
        AppMethodBeat.i(578);
        CaptureContainer.f(this.ykU).h(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void bow()
      {
        AppMethodBeat.i(576);
        CaptureContainer.f(this.ykU).btb();
        this.ykU.bsC();
        AppMethodBeat.o(576);
      }
    });
    this.ykG.setOnClickListener(new CaptureContainer..ExternalSyntheticLambda0(this));
    this.ykH.setOnClickListener(new CaptureContainer..ExternalSyntheticLambda1(this));
    this.ykO.setOnClickListener(new CaptureContainer..ExternalSyntheticLambda2(this, paramContext));
    this.ykI.setSelectionCallback((m)new u(paramContext) {});
    this.ykI.setVisibility(8);
    this.ykN.setAlpha(0.0F);
    post(new CaptureContainer..ExternalSyntheticLambda5(this));
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {
      this.ykG.setOnLongClickListener(new CaptureContainer..ExternalSyntheticLambda3(paramContext, this));
    }
    AppMethodBeat.o(606);
  }
  
  private final void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(594);
    if (paramBoolean)
    {
      if (this.ykN.getTop() < getResources().getDimension(a.d.yeb) + getResources().getDimension(a.d.yee) + getResources().getDimension(a.d.yec) + getResources().getDimension(a.d.yed) + com.tencent.mm.cd.a.fromDPToPix(getContext(), 30)) {
        this.ykN.setBackgroundResource(a.e.yeg);
      }
      removeCallbacks(this.ykR);
      this.ykN.animate().cancel();
      this.ykN.animate().alpha(1.0F).start();
      this.ykN.setText(paramInt);
      postDelayed(this.ykR, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.ykN.animate().cancel();
    this.ykN.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  private static final void a(CaptureContainer paramCaptureContainer)
  {
    AppMethodBeat.i(269581);
    s.u(paramCaptureContainer, "this$0");
    paramCaptureContainer.H(false, 0);
    AppMethodBeat.o(269581);
  }
  
  private static final void a(CaptureContainer paramCaptureContainer, Context paramContext, View paramView)
  {
    AppMethodBeat.i(269592);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureContainer);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureContainer, "this$0");
    s.u(paramContext, "$context");
    paramCaptureContainer = paramCaptureContainer.ykQ;
    if (paramCaptureContainer != null)
    {
      paramCaptureContainer = paramCaptureContainer.aarb;
      if (paramCaptureContainer != null)
      {
        paramView = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI"));
        paramView.putExtra("uin", paramCaptureContainer.ZtX);
        paramView.putExtra("name", paramCaptureContainer.IGU);
        paramView.putExtra("headurl", paramCaptureContainer.ZuK);
        paramCaptureContainer = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramCaptureContainer.aYi(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "_init_$lambda-5", "(Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;Landroid/content/Context;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramCaptureContainer.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "_init_$lambda-5", "(Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;Landroid/content/Context;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269592);
  }
  
  private static final void a(CaptureContainer paramCaptureContainer, View paramView)
  {
    AppMethodBeat.i(269589);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureContainer, "this$0");
    paramCaptureContainer = paramCaptureContainer.getPresenter();
    if (paramCaptureContainer != null) {
      paramCaptureContainer.exit();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269589);
  }
  
  private static final boolean a(Context paramContext, CaptureContainer paramCaptureContainer, View paramView)
  {
    AppMethodBeat.i(269596);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramCaptureContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramContext, "$context");
    s.u(paramCaptureContainer, "this$0");
    paramView = new com.google.android.material.bottomsheet.a(paramContext);
    localObject = paramView.getWindow();
    if (localObject != null) {
      ((Window)localObject).clearFlags(2);
    }
    paramContext = new XLabEffectSettingView(paramContext);
    paramContext.setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.b)paramCaptureContainer.ykE);
    paramCaptureContainer = ah.aiuX;
    paramView.setContentView((View)paramContext);
    paramView.show();
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(269596);
    return true;
  }
  
  private static final void b(CaptureContainer paramCaptureContainer)
  {
    AppMethodBeat.i(269585);
    s.u(paramCaptureContainer, "this$0");
    Log.i(paramCaptureContainer.TAG, "simpleTapCallback");
    paramCaptureContainer.ot(false);
    AppMethodBeat.o(269585);
  }
  
  private static final void b(CaptureContainer paramCaptureContainer, View paramView)
  {
    AppMethodBeat.i(269590);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCaptureContainer);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCaptureContainer, "this$0");
    paramCaptureContainer.bsC();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269590);
  }
  
  private static final void c(CaptureContainer paramCaptureContainer)
  {
    AppMethodBeat.i(269594);
    s.u(paramCaptureContainer, "this$0");
    paramCaptureContainer.H(true, a.i.yfB);
    AppMethodBeat.o(269594);
  }
  
  private final void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(269575);
    if (paramBoolean)
    {
      Log.i(this.TAG, "stopRecord true");
      this.ykF.setTouchEnable(false);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new EditorStickerView.b(this.ykI));
    }
    for (;;)
    {
      this.ykG.setEnabled(true);
      this.ykG.animate().cancel();
      this.ykG.setAlpha(1.0F);
      AppMethodBeat.o(269575);
      return;
      Log.i(this.TAG, "stopRecord false");
      H(true, a.i.yfD);
      this.ykI.setShow(true);
      this.ykE.H((kotlin.g.a.a)new e(this));
      ou(com.tencent.mm.media.widget.camerarecordview.a.btW());
      this.ykI.dEM();
    }
  }
  
  public final boolean J(kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, ah> paramb)
  {
    AppMethodBeat.i(597);
    this.ykE.H((kotlin.g.a.a)new f(this));
    boolean bool = this.ykS.J(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(592);
    this.ykK.setStickerInfo(paramf);
    this.ykE.H((kotlin.g.a.a)new a(this, paramf));
    AppMethodBeat.o(592);
  }
  
  public final boolean aGe()
  {
    return true;
  }
  
  public final boolean bsC()
  {
    AppMethodBeat.i(598);
    this.ykT = com.tencent.mm.media.widget.camerarecordview.a.b(this.ykS);
    EmojiCaptureReporter localEmojiCaptureReporter = this.yiI;
    long l;
    if (localEmojiCaptureReporter == null)
    {
      l = 0L;
      localEmojiCaptureReporter = this.yiI;
      if (localEmojiCaptureReporter != null) {
        break label79;
      }
    }
    label79:
    for (int i = 0;; i = localEmojiCaptureReporter.scene)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.ykT;
      AppMethodBeat.o(598);
      return bool;
      l = localEmojiCaptureReporter.mnX;
      break;
    }
  }
  
  public final boolean bun()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).nFT;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean buo()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.yjA;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean bup()
  {
    AppMethodBeat.i(269701);
    s.u(this, "this");
    AppMethodBeat.o(269701);
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.b getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.b)this.ykE;
  }
  
  public final VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(608);
    VideoTransPara localVideoTransPara = com.tencent.mm.media.widget.camerarecordview.d.a.a.a(this);
    AppMethodBeat.o(608);
    return localVideoTransPara;
  }
  
  public final CaptureDecoration getDecoration()
  {
    return this.ykK;
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
    return this.ykP;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.ykd;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    int i = com.tencent.mm.plugin.emojicapture.model.d.dDF();
    locala = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    ((g)localObject).el(i, com.tencent.mm.plugin.emojicapture.model.d.dDF());
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
    s.checkNotNull(localEGLContext);
    com.tencent.mm.media.g.d locald = this.ykE.getPreviewTexture();
    if (locald == null) {}
    for (int i = -1;; i = locald.nAF)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new c(localVideoTransPara, (com.tencent.mm.media.j.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.yiI;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).mNl;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = j.KVJ.nLH;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final void on(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.ykJ.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.ykJ.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(269700);
    if (paramWindowInsets != null) {
      findViewById(a.f.yeE).setPadding(0, paramWindowInsets.getSystemWindowInsetTop(), 0, 0);
    }
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    s.s(paramWindowInsets, "super.onApplyWindowInsets(insets)");
    AppMethodBeat.o(269700);
    return paramWindowInsets;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    Log.i(this.TAG, "resumeCapture");
    on(false);
    if (this.yjR) {
      this.ykI.setShow(true);
    }
    getDecoration().resume();
    this.ykE.H((kotlin.g.a.a)new c(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.ykS, this.ykT, null, (kotlin.g.a.b)new d(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final void ou(boolean paramBoolean)
  {
    AppMethodBeat.i(269684);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(paramBoolean, this));
    AppMethodBeat.o(269684);
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.ykP = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.yiI = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    Log.i(this.TAG, s.X("setVisibility:", Integer.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.ykG.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.ykF.setTouchEnable(true);
      this.ykI.dEM();
    }
    if (paramInt == 8)
    {
      this.ykE.setTextureChangeCallback(null);
      this.ykD.removeView((View)this.ykE);
      this.ykE = new EmojiCaptureGLTextureView(getContext());
      this.ykD.addView((View)this.ykE);
      this.ykd = new e();
      this.ykE.a((com.tencent.mm.media.j.a)this.ykd, bun());
      this.ykE.setOpaque(false);
    }
    this.ykE.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(CaptureContainer paramCaptureContainer, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int buc()
    {
      return 2;
    }
    
    public final String bud()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      localObject = d.a.dDK();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      localObject = d.a.dDJ();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(boolean paramBoolean, CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */