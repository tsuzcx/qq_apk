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
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sticker.f;
import d.g.a.m;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter pTh;
  private com.tencent.mm.plugin.emojicapture.ui.b.e pUH;
  public boolean pUt;
  public com.tencent.mm.media.widget.camerarecordview.a pVA;
  public boolean pVB;
  private final ViewGroup pVl;
  private EmojiCaptureGLTextureView pVm;
  private final MMSightRecordButton pVn;
  private final View pVo;
  private final View pVp;
  public final EditorStickerView pVq;
  private final View pVr;
  public final CaptureDecoration pVs;
  private final CameraFrontSightView pVt;
  private final MMSightCaptureTouchView pVu;
  private final TextView pVv;
  private final TextView pVw;
  com.tencent.mm.plugin.emojicapture.c.a.a pVx;
  private bty pVy;
  private final Runnable pVz;
  
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
    this.pUH = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    this.pVz = ((Runnable)new c(this));
    View.inflate(paramContext, 2131493752, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299346);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.pVl = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299334);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.pVn = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131297701);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.pVo = paramAttributeSet;
    paramAttributeSet = findViewById(2131297706);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.pVp = paramAttributeSet;
    paramAttributeSet = findViewById(2131306485);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.pVr = paramAttributeSet;
    paramAttributeSet = findViewById(2131297703);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.pVs = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(2131297707);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.pVt = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297709);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.pVu = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299343);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.pVv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299348);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.pVw = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299354);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.pVq = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.cc.a.fromDPToPix(paramContext, 120);
    this.pVt.gC(paramInt, paramInt);
    this.pVm = new EmojiCaptureGLTextureView(paramContext);
    this.pVA = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.pVA.rD(600L);
    this.pVl.addView((View)this.pVm);
    this.pVm.setOpaque(false);
    this.pVn.setHighLightOuter(getResources().getColor(2131100271));
    this.pVn.setInnerColor(getResources().getColor(2131099653));
    this.pVn.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void ckq()
      {
        AppMethodBeat.i(568);
        ad.i(CaptureContainer.e(this.pVC), "onLongPressFinish");
        CaptureContainer.a(this.pVC, this.pVC.p((d.g.a.b)new b(this)));
        AppMethodBeat.o(568);
      }
      
      public final void ckr()
      {
        AppMethodBeat.i(570);
        ad.i(CaptureContainer.e(this.pVC), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.f(this.pVC).getLocationOnScreen(arrayOfInt);
        CaptureContainer.c(this.pVC).oa(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void jB()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.f(this.pVC);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pQW;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.cjn() * 1000, com.tencent.mm.plugin.emojicapture.ui.c.dP(this.pVC), (MMSightCircularProgressBar.a)new a(this));
        localObject1 = this.pVC;
        ((CaptureContainer)localObject1).pVq.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).pVx;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).bjO();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).pVA)) {
          EmojiCaptureReporter.Cl(33);
        }
        CaptureContainer.g(this.pVC).setEnabled(false);
        CaptureContainer.g(this.pVC).animate().alpha(0.0F).start();
        CaptureContainer.a(this.pVC, false, 0);
        CaptureContainer.b(this.pVC).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        public final void S(ArrayList<Float> paramArrayList) {}
        
        public final void kH(boolean paramBoolean)
        {
          AppMethodBeat.i(195139);
          ad.i(CaptureContainer.e(this.pVD.pVC), "onLongPress");
          CaptureContainer.a(this.pVD.pVC, this.pVD.pVC.p((d.g.a.b)new a(this)));
          AppMethodBeat.o(195139);
        }
        
        @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
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
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
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
    this.pVn.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cks()
      {
        AppMethodBeat.i(572);
        ad.i(CaptureContainer.e(this.pVC), "simpleTapCallback");
        CaptureContainer.a(this.pVC, false);
        AppMethodBeat.o(572);
      }
    });
    this.pVn.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void Cw(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.c(this.pVC).j(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void Cx(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.c(this.pVC).j(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.pVu.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void E(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.c(this.pVC).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.pVC).getWidth(), CaptureContainer.h(this.pVC).getHeight());
        CaptureContainer.i(this.pVC).W(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void aVu()
      {
        AppMethodBeat.i(577);
        CaptureContainer.c(this.pVC).j(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void aVv()
      {
        AppMethodBeat.i(578);
        CaptureContainer.c(this.pVC).j(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void ckt()
      {
        AppMethodBeat.i(576);
        CaptureContainer.c(this.pVC).awk();
        this.pVC.avZ();
        AppMethodBeat.o(576);
      }
    });
    this.pVo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(579);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.pVC.getPresenter();
        if (paramAnonymousView != null) {
          paramAnonymousView.exit();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(579);
      }
    });
    this.pVp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(580);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.pVC.avZ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(580);
      }
    });
    this.pVw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(581);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = CaptureContainer.j(this.pVC);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.Gxo;
          if (paramAnonymousView != null)
          {
            localObject = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
            localObject = new Intent(paramContext, (Class)localObject);
            ((Intent)localObject).putExtra("uin", paramAnonymousView.DesignerUin);
            ((Intent)localObject).putExtra("name", paramAnonymousView.Name);
            ((Intent)localObject).putExtra("headurl", paramAnonymousView.HeadUrl);
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(581);
      }
    });
    this.pVq.setSelectionCallback((m)new q(paramContext) {});
    this.pVq.setVisibility(8);
    this.pVv.setAlpha(0.0F);
    post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(583);
        CaptureContainer.a(this.pVC, true, 2131756780);
        AppMethodBeat.o(583);
      }
    });
    if ((bu.flY()) || (i.IS_FLAVOR_RED)) {
      this.pVo.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(571);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = new android.support.design.widget.a(paramContext);
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = new XLabEffectSettingView(paramContext);
          ((XLabEffectSettingView)localObject).setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.e)CaptureContainer.h(this.pVC));
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
  
  private final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(594);
    if (paramBoolean)
    {
      if (this.pVv.getTop() < getResources().getDimension(2131166205) + getResources().getDimension(2131166693) + getResources().getDimension(2131166206) + getResources().getDimension(2131166207) + com.tencent.mm.cc.a.fromDPToPix(getContext(), 30)) {
        this.pVv.setBackgroundResource(2131232011);
      }
      removeCallbacks(this.pVz);
      this.pVv.animate().cancel();
      this.pVv.animate().alpha(1.0F).start();
      this.pVv.setText(paramInt);
      postDelayed(this.pVz, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.pVv.animate().cancel();
    this.pVv.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  public final boolean Pf()
  {
    return true;
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(592);
    this.pVs.setStickerInfo(paramf);
    this.pVm.h((d.g.a.a)new a(this, paramf));
    AppMethodBeat.o(592);
  }
  
  public final boolean avZ()
  {
    AppMethodBeat.i(598);
    this.pVB = com.tencent.mm.media.widget.camerarecordview.a.b(this.pVA);
    EmojiCaptureReporter localEmojiCaptureReporter = this.pTh;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.gpU;
      localEmojiCaptureReporter = this.pTh;
      if (localEmojiCaptureReporter == null) {
        break label83;
      }
    }
    label83:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.pVB;
      AppMethodBeat.o(598);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean axJ()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.pQv.ate()).hpe;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean axK()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.pUd;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean axL()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.pVm;
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
    return this.pVs;
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
    return this.pVx;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.pUH;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    int i = com.tencent.mm.plugin.emojicapture.model.d.cjo();
    locala = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    ((g)localObject).cU(i, com.tencent.mm.plugin.emojicapture.model.d.cjo());
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
      d.g.b.p.gfZ();
    }
    com.tencent.mm.media.g.d locald = this.pVm.getPreviewTexture();
    if (locald != null) {}
    for (int i = locald.hko;; i = -1)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, (com.tencent.mm.media.j.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.pTh;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.pQv.ate()).gHw;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = k.vOq.hvh;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final void kC(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.pVr.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.pVr.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    ad.i(this.TAG, "resumeCapture");
    kC(false);
    if (this.pUt) {
      this.pVq.setShow(true);
    }
    getDecoration().resume();
    this.pVm.h((d.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.pVA, this.pVB, (d.g.a.b)new e(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final boolean p(d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, z> paramb)
  {
    AppMethodBeat.i(597);
    this.pVm.h((d.g.a.a)new f(this));
    boolean bool = this.pVA.p(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.pVx = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.pTh = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    ad.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.pVo.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.pVn.setTouchEnable(true);
      this.pVq.cku();
    }
    if (paramInt == 8)
    {
      this.pVm.setTextureChangeCallback(null);
      this.pVl.removeView((View)this.pVm);
      this.pVm = new EmojiCaptureGLTextureView(getContext());
      this.pVl.addView((View)this.pVm);
      this.pUH = new com.tencent.mm.plugin.emojicapture.ui.b.e();
      this.pVm.a((com.tencent.mm.media.j.a)this.pUH, axJ());
      this.pVm.setOpaque(false);
    }
    this.pVm.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  public final void yZ(final boolean paramBoolean)
  {
    AppMethodBeat.i(221669);
    com.tencent.mm.ad.c.g((d.g.a.a)new g(this, paramBoolean));
    AppMethodBeat.o(221669);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(CaptureContainer paramCaptureContainer, f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final String axA()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pQW;
      localObject = d.a.cjt();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final int axz()
    {
      return 2;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pQW;
      localObject = d.a.cjs();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CaptureContainer paramCaptureContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(587);
      CaptureContainer.a(this.pVC, false, 0);
      AppMethodBeat.o(587);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<Boolean, z>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(CaptureContainer paramCaptureContainer, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */