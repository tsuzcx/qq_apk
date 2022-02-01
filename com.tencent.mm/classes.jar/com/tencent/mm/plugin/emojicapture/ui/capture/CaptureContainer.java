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
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sticker.f;
import d.g.a.m;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter pZM;
  public boolean qaY;
  private final ViewGroup qbQ;
  private EmojiCaptureGLTextureView qbR;
  private final MMSightRecordButton qbS;
  private final View qbT;
  private final View qbU;
  public final EditorStickerView qbV;
  private final View qbW;
  public final CaptureDecoration qbX;
  private final CameraFrontSightView qbY;
  private final MMSightCaptureTouchView qbZ;
  private com.tencent.mm.plugin.emojicapture.ui.b.e qbm;
  private final TextView qca;
  private final TextView qcb;
  com.tencent.mm.plugin.emojicapture.c.a.a qcc;
  private bus qcd;
  private final Runnable qce;
  public com.tencent.mm.media.widget.camerarecordview.a qcf;
  public boolean qcg;
  
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
    this.qbm = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    this.qce = ((Runnable)new c(this));
    View.inflate(paramContext, 2131493752, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299346);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.qbQ = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299334);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.qbS = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131297701);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.qbT = paramAttributeSet;
    paramAttributeSet = findViewById(2131297706);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.qbU = paramAttributeSet;
    paramAttributeSet = findViewById(2131306485);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.qbW = paramAttributeSet;
    paramAttributeSet = findViewById(2131297703);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.qbX = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(2131297707);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.qbY = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297709);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.qbZ = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299343);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.qca = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299348);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.qcb = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299354);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.qbV = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 120);
    this.qbY.gC(paramInt, paramInt);
    this.qbR = new EmojiCaptureGLTextureView(paramContext);
    this.qcf = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.qcf.rQ(600L);
    this.qbQ.addView((View)this.qbR);
    this.qbR.setOpaque(false);
    this.qbS.setHighLightOuter(getResources().getColor(2131100271));
    this.qbS.setInnerColor(getResources().getColor(2131099653));
    this.qbS.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void clG()
      {
        AppMethodBeat.i(568);
        ae.i(CaptureContainer.e(this.qch), "onLongPressFinish");
        CaptureContainer.a(this.qch, this.qch.p((d.g.a.b)new b(this)));
        AppMethodBeat.o(568);
      }
      
      public final void clH()
      {
        AppMethodBeat.i(570);
        ae.i(CaptureContainer.e(this.qch), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.f(this.qch).getLocationOnScreen(arrayOfInt);
        CaptureContainer.c(this.qch).od(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void jB()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.f(this.qch);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pXB;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.ckD() * 1000, com.tencent.mm.plugin.emojicapture.ui.c.dP(this.qch), (MMSightCircularProgressBar.a)new a(this));
        localObject1 = this.qch;
        ((CaptureContainer)localObject1).qbV.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).qcc;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).bkx();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).qcf)) {
          EmojiCaptureReporter.Cx(33);
        }
        CaptureContainer.g(this.qch).setEnabled(false);
        CaptureContainer.g(this.qch).animate().alpha(0.0F).start();
        CaptureContainer.a(this.qch, false, 0);
        CaptureContainer.b(this.qch).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        public final void S(ArrayList<Float> paramArrayList) {}
        
        public final void kI(boolean paramBoolean)
        {
          AppMethodBeat.i(221771);
          ae.i(CaptureContainer.e(this.qci.qch), "onLongPress");
          CaptureContainer.a(this.qci.qch, this.qci.qch.p((d.g.a.b)new a(this)));
          AppMethodBeat.o(221771);
        }
        
        @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
        static final class a
          extends q
          implements d.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, z>
        {
          a(CaptureContainer.1.a parama)
          {
            super();
          }
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
      static final class b
        extends q
        implements d.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, z>
      {
        b(CaptureContainer.1 param1)
        {
          super();
        }
      }
    });
    this.qbS.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void clI()
      {
        AppMethodBeat.i(572);
        ae.i(CaptureContainer.e(this.qch), "simpleTapCallback");
        CaptureContainer.a(this.qch, false);
        AppMethodBeat.o(572);
      }
    });
    this.qbS.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void CI(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.c(this.qch).j(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void CJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.c(this.qch).j(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.qbZ.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void E(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.c(this.qch).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.qch).getWidth(), CaptureContainer.h(this.qch).getHeight());
        CaptureContainer.i(this.qch).W(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void aVT()
      {
        AppMethodBeat.i(577);
        CaptureContainer.c(this.qch).j(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void aVU()
      {
        AppMethodBeat.i(578);
        CaptureContainer.c(this.qch).j(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void clJ()
      {
        AppMethodBeat.i(576);
        CaptureContainer.c(this.qch).awz();
        this.qch.awo();
        AppMethodBeat.o(576);
      }
    });
    this.qbT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(579);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.qch.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.exit();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(579);
      }
    });
    this.qbU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(580);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.qch.awo();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(580);
      }
    });
    this.qcb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(581);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = CaptureContainer.j(this.qch);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.GQO;
          if (paramAnonymousView != null)
          {
            localObject = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
            localObject = new Intent(paramContext, (Class)localObject);
            ((Intent)localObject).putExtra("uin", paramAnonymousView.DesignerUin);
            ((Intent)localObject).putExtra("name", paramAnonymousView.Name);
            ((Intent)localObject).putExtra("headurl", paramAnonymousView.HeadUrl);
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(581);
      }
    });
    this.qbV.setSelectionCallback((m)new q(paramContext) {});
    this.qbV.setVisibility(8);
    this.qca.setAlpha(0.0F);
    post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(583);
        CaptureContainer.a(this.qch, true, 2131756780);
        AppMethodBeat.o(583);
      }
    });
    if ((bv.fpT()) || (j.IS_FLAVOR_RED)) {
      this.qbT.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(571);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = new android.support.design.widget.a(paramContext);
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = new XLabEffectSettingView(paramContext);
          ((XLabEffectSettingView)localObject).setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.e)CaptureContainer.h(this.qch));
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
  
  private final void E(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(594);
    if (paramBoolean)
    {
      if (this.qca.getTop() < getResources().getDimension(2131166205) + getResources().getDimension(2131166693) + getResources().getDimension(2131166206) + getResources().getDimension(2131166207) + com.tencent.mm.cb.a.fromDPToPix(getContext(), 30)) {
        this.qca.setBackgroundResource(2131232011);
      }
      removeCallbacks(this.qce);
      this.qca.animate().cancel();
      this.qca.animate().alpha(1.0F).start();
      this.qca.setText(paramInt);
      postDelayed(this.qce, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.qca.animate().cancel();
    this.qca.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  public final boolean Pd()
  {
    return true;
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(592);
    this.qbX.setStickerInfo(paramf);
    this.qbR.i((d.g.a.a)new a(this, paramf));
    AppMethodBeat.o(592);
  }
  
  public final boolean awo()
  {
    AppMethodBeat.i(598);
    this.qcg = com.tencent.mm.media.widget.camerarecordview.a.b(this.qcf);
    EmojiCaptureReporter localEmojiCaptureReporter = this.pZM;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.gsp;
      localEmojiCaptureReporter = this.pZM;
      if (localEmojiCaptureReporter == null) {
        break label83;
      }
    }
    label83:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.qcg;
      AppMethodBeat.o(598);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean axY()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.pXa.att()).hrS;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean axZ()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.qaI;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean aya()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.qbR;
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
    return this.qbX;
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
    return this.qcc;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.qbm;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    int i = com.tencent.mm.plugin.emojicapture.model.d.ckE();
    locala = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    ((g)localObject).cU(i, com.tencent.mm.plugin.emojicapture.model.d.ckE());
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
      d.g.b.p.gkB();
    }
    com.tencent.mm.media.g.d locald = this.qbR.getPreviewTexture();
    if (locald != null) {}
    for (int i = locald.hnc;; i = -1)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, (com.tencent.mm.media.j.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.pZM;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.pXa.att()).gKf;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = k.wat.hxV;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final void kB(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.qbW.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.qbW.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final void kH(final boolean paramBoolean)
  {
    AppMethodBeat.i(221773);
    com.tencent.mm.ac.c.h((d.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(221773);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    ae.i(this.TAG, "resumeCapture");
    kB(false);
    if (this.qaY) {
      this.qbV.setShow(true);
    }
    getDecoration().resume();
    this.qbR.i((d.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.qcf, this.qcg, (d.g.a.b)new e(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final boolean p(d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, z> paramb)
  {
    AppMethodBeat.i(597);
    this.qbR.i((d.g.a.a)new g(this));
    boolean bool = this.qcf.p(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.qcc = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.pZM = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    ae.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.qbT.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.qbS.setTouchEnable(true);
      this.qbV.clK();
    }
    if (paramInt == 8)
    {
      this.qbR.setTextureChangeCallback(null);
      this.qbQ.removeView((View)this.qbR);
      this.qbR = new EmojiCaptureGLTextureView(getContext());
      this.qbQ.addView((View)this.qbR);
      this.qbm = new com.tencent.mm.plugin.emojicapture.ui.b.e();
      this.qbR.a((com.tencent.mm.media.j.a)this.qbm, axY());
      this.qbR.setOpaque(false);
    }
    this.qbR.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(CaptureContainer paramCaptureContainer, f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int axO()
    {
      return 2;
    }
    
    public final String axP()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pXB;
      localObject = d.a.ckJ();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pXB;
      localObject = d.a.ckI();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CaptureContainer paramCaptureContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(587);
      CaptureContainer.a(this.qch, false, 0);
      AppMethodBeat.o(587);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<Boolean, z>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(CaptureContainer paramCaptureContainer, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */