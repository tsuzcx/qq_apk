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
import com.tencent.mm.plugin.mmsight.model.p;
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
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.g.a.m;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter oMm;
  private com.tencent.mm.plugin.emojicapture.ui.b.e oNH;
  public boolean oNt;
  public com.tencent.mm.media.widget.camerarecordview.a oOA;
  public boolean oOB;
  private final ViewGroup oOl;
  private EmojiCaptureGLTextureView oOm;
  private final MMSightRecordButton oOn;
  private final View oOo;
  private final View oOp;
  public final EditorStickerView oOq;
  private final View oOr;
  public final CaptureDecoration oOs;
  private final CameraFrontSightView oOt;
  private final MMSightCaptureTouchView oOu;
  private final TextView oOv;
  private final TextView oOw;
  com.tencent.mm.plugin.emojicapture.c.a.a oOx;
  private blp oOy;
  private final Runnable oOz;
  
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
    this.oNH = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    this.oOz = ((Runnable)new c(this));
    View.inflate(paramContext, 2131493752, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299346);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.oOl = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299334);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.oOn = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131297701);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.oOo = paramAttributeSet;
    paramAttributeSet = findViewById(2131297706);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.oOp = paramAttributeSet;
    paramAttributeSet = findViewById(2131306485);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.oOr = paramAttributeSet;
    paramAttributeSet = findViewById(2131297703);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.oOs = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(2131297707);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.oOt = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297709);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.oOu = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299343);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.oOv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299348);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.oOw = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299354);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.oOq = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(paramContext, 120);
    this.oOt.ge(paramInt, paramInt);
    this.oOm = new EmojiCaptureGLTextureView(paramContext);
    this.oOA = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.oOA.lQ(600L);
    this.oOl.addView((View)this.oOm);
    this.oOm.setOpaque(false);
    this.oOn.setHighLightOuter(getResources().getColor(2131100271));
    this.oOn.setInnerColor(getResources().getColor(2131099653));
    this.oOn.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void bYA()
      {
        AppMethodBeat.i(570);
        ad.i(CaptureContainer.e(this.oOC), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.f(this.oOC).getLocationOnScreen(arrayOfInt);
        CaptureContainer.c(this.oOC).mN(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void bYz()
      {
        AppMethodBeat.i(568);
        ad.i(CaptureContainer.e(this.oOC), "onLongPressFinish");
        CaptureContainer.a(this.oOC, this.oOC.j((d.g.a.b)new b(this)));
        AppMethodBeat.o(568);
      }
      
      public final void jd()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.f(this.oOC);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.oJY;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.bXx() * 1000, com.tencent.mm.plugin.emojicapture.ui.c.dK(this.oOC), (MMSightCircularProgressBar.a)new a(this));
        localObject1 = this.oOC;
        ((CaptureContainer)localObject1).oOq.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).oOx;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).aZs();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).oOA)) {
          EmojiCaptureReporter.AL(33);
        }
        CaptureContainer.g(this.oOC).setEnabled(false);
        CaptureContainer.g(this.oOC).animate().alpha(0.0F).start();
        CaptureContainer.a(this.oOC, false, 0);
        CaptureContainer.b(this.oOC).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        public final void aV(ArrayList<Float> paramArrayList) {}
        
        public final void yw(boolean paramBoolean)
        {
          AppMethodBeat.i(205003);
          ad.i(CaptureContainer.e(this.oOD.oOC), "onLongPress");
          CaptureContainer.a(this.oOD.oOC, this.oOD.oOC.j((d.g.a.b)new CaptureContainer.1.a.a(this)));
          AppMethodBeat.o(205003);
        }
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
      static final class b
        extends d.g.b.l
        implements d.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, y>
      {
        b(CaptureContainer.1 param1)
        {
          super();
        }
      }
    });
    this.oOn.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void bYC()
      {
        AppMethodBeat.i(572);
        ad.i(CaptureContainer.e(this.oOC), "simpleTapCallback");
        CaptureContainer.a(this.oOC, false);
        AppMethodBeat.o(572);
      }
    });
    this.oOn.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void AW(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.c(this.oOC).i(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void AX(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.c(this.oOC).i(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.oOu.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void A(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.c(this.oOC).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.oOC).getWidth(), CaptureContainer.h(this.oOC).getHeight());
        CaptureContainer.i(this.oOC).Q(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void aLr()
      {
        AppMethodBeat.i(577);
        CaptureContainer.c(this.oOC).i(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void aLs()
      {
        AppMethodBeat.i(578);
        CaptureContainer.c(this.oOC).i(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void bYD()
      {
        AppMethodBeat.i(576);
        CaptureContainer.c(this.oOC).amF();
        this.oOC.amu();
        AppMethodBeat.o(576);
      }
    });
    this.oOo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(579);
        paramAnonymousView = this.oOC.getPresenter();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.exit();
          AppMethodBeat.o(579);
          return;
        }
        AppMethodBeat.o(579);
      }
    });
    this.oOp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(580);
        this.oOC.amu();
        AppMethodBeat.o(580);
      }
    });
    this.oOw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(581);
        paramAnonymousView = CaptureContainer.j(this.oOC);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.Dtg;
          if (paramAnonymousView != null)
          {
            Object localObject = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
            localObject = new Intent(paramContext, (Class)localObject);
            ((Intent)localObject).putExtra("uin", paramAnonymousView.DesignerUin);
            ((Intent)localObject).putExtra("name", paramAnonymousView.Name);
            ((Intent)localObject).putExtra("headurl", paramAnonymousView.HeadUrl);
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(581);
            return;
          }
        }
        AppMethodBeat.o(581);
      }
    });
    this.oOq.setSelectionCallback((m)new d.g.b.l(paramContext) {});
    this.oOq.setVisibility(8);
    this.oOv.setAlpha(0.0F);
    post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(583);
        CaptureContainer.a(this.oOC, true, 2131756780);
        AppMethodBeat.o(583);
      }
    });
    if ((bu.eGT()) || (h.IS_FLAVOR_RED)) {
      this.oOo.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(571);
          paramAnonymousView = new android.support.design.widget.a(paramContext);
          Object localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = new XLabEffectSettingView(paramContext);
          ((XLabEffectSettingView)localObject).setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.e)CaptureContainer.h(this.oOC));
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          AppMethodBeat.o(571);
          return true;
        }
      });
    }
    AppMethodBeat.o(606);
  }
  
  private final void C(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(594);
    if (paramBoolean)
    {
      if (this.oOv.getTop() < getResources().getDimension(2131166205) + getResources().getDimension(2131166693) + getResources().getDimension(2131166206) + getResources().getDimension(2131166207) + com.tencent.mm.cd.a.fromDPToPix(getContext(), 30)) {
        this.oOv.setBackgroundResource(2131232011);
      }
      removeCallbacks(this.oOz);
      this.oOv.animate().cancel();
      this.oOv.animate().alpha(1.0F).start();
      this.oOv.setText(paramInt);
      postDelayed(this.oOz, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.oOv.animate().cancel();
    this.oOv.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  public final boolean Ny()
  {
    return true;
  }
  
  public final void a(final com.tencent.mm.sticker.e parame)
  {
    AppMethodBeat.i(592);
    this.oOs.setStickerInfo(parame);
    this.oOm.j((d.g.a.a)new a(this, parame));
    AppMethodBeat.o(592);
  }
  
  public final boolean amu()
  {
    AppMethodBeat.i(598);
    this.oOB = com.tencent.mm.media.widget.camerarecordview.a.b(this.oOA);
    EmojiCaptureReporter localEmojiCaptureReporter = this.oMm;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.fSw;
      localEmojiCaptureReporter = this.oMm;
      if (localEmojiCaptureReporter == null) {
        break label83;
      }
    }
    label83:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.oOB;
      AppMethodBeat.o(598);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean aof()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.oJw.ajp()).gwB;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean aog()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.oNd;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean aoh()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.oOm;
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
    return this.oOs;
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
    return this.oOx;
  }
  
  public final com.tencent.mm.media.i.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.i.a)this.oNH;
  }
  
  public final com.tencent.mm.media.i.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    int i = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    locala = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    ((g)localObject).cS(i, com.tencent.mm.plugin.emojicapture.model.d.bXy());
    localObject = (com.tencent.mm.media.i.a)localObject;
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
      d.g.b.k.fvU();
    }
    com.tencent.mm.media.f.d locald = this.oOm.getPreviewTexture();
    if (locald != null) {}
    for (int i = locald.gro;; i = -1)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, (com.tencent.mm.media.i.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.oMm;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.oJw.ajp()).oJx;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = com.tencent.mm.plugin.mmsight.model.k.tCN.gCB;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final boolean j(d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, y> paramb)
  {
    AppMethodBeat.i(597);
    this.oOm.j((d.g.a.a)new f(this));
    boolean bool = this.oOA.j(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void jO(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.oOr.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.oOr.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    ad.i(this.TAG, "resumeCapture");
    jO(false);
    if (this.oNt) {
      this.oOq.setShow(true);
    }
    getDecoration().resume();
    this.oOm.j((d.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.oOA, this.oOB, (d.g.a.b)new e(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.oOx = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.oMm = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    ad.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.oOo.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.oOn.setTouchEnable(true);
      this.oOq.bYG();
    }
    if (paramInt == 8)
    {
      this.oOm.setTextureChangeCallback(null);
      this.oOl.removeView((View)this.oOm);
      this.oOm = new EmojiCaptureGLTextureView(getContext());
      this.oOl.addView((View)this.oOm);
      this.oNH = new com.tencent.mm.plugin.emojicapture.ui.b.e();
      this.oOm.a((com.tencent.mm.media.i.a)this.oNH, aof());
      this.oOm.setOpaque(false);
    }
    this.oOm.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(CaptureContainer paramCaptureContainer, com.tencent.mm.sticker.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int anW()
    {
      return 2;
    }
    
    public final String anX()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
      localObject = d.a.bXD();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
      localObject = d.a.bXC();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CaptureContainer paramCaptureContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(587);
      CaptureContainer.a(this.oOC, false, 0);
      AppMethodBeat.o(587);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(CaptureContainer paramCaptureContainer, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */