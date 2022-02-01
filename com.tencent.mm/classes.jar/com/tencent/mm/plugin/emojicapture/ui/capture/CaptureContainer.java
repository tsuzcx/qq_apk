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
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sticker.f;
import d.g.a.m;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "stickerDesigner", "stickerEnable", "", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "voiceDetectView", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "lensId", "talkerName", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer
  extends RelativeLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a, a.b
{
  public final String TAG;
  public EmojiCaptureReporter ppG;
  public boolean pqN;
  private final ViewGroup prF;
  private EmojiCaptureGLTextureView prG;
  private final MMSightRecordButton prH;
  private final View prI;
  private final View prJ;
  public final EditorStickerView prK;
  private final View prL;
  public final CaptureDecoration prM;
  private final CameraFrontSightView prN;
  private final MMSightCaptureTouchView prO;
  private final TextView prP;
  private final TextView prQ;
  com.tencent.mm.plugin.emojicapture.c.a.a prR;
  private bpl prS;
  private final Runnable prT;
  public com.tencent.mm.media.widget.camerarecordview.a prU;
  public boolean prV;
  private com.tencent.mm.plugin.emojicapture.ui.b.e prb;
  
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
    this.prb = new com.tencent.mm.plugin.emojicapture.ui.b.e();
    this.prT = ((Runnable)new c(this));
    View.inflate(paramContext, 2131493752, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299346);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_preview_layout)");
    this.prF = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299334);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_button)");
    this.prH = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131297701);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_close)");
    this.prI = paramAttributeSet;
    paramAttributeSet = findViewById(2131297706);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_flip_camera)");
    this.prJ = paramAttributeSet;
    paramAttributeSet = findViewById(2131306485);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.voice_detect_hint)");
    this.prL = paramAttributeSet;
    paramAttributeSet = findViewById(2131297703);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_decoration)");
    this.prM = ((CaptureDecoration)paramAttributeSet);
    paramAttributeSet = findViewById(2131297707);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.prN = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297709);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.prO = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299343);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_hint)");
    this.prP = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299348);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_designer)");
    this.prQ = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131299354);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_panel)");
    this.prK = ((EditorStickerView)paramAttributeSet);
    paramInt = com.tencent.mm.cc.a.fromDPToPix(paramContext, 120);
    this.prN.gl(paramInt, paramInt);
    this.prG = new EmojiCaptureGLTextureView(paramContext);
    this.prU = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.prU.pE(600L);
    this.prF.addView((View)this.prG);
    this.prG.setOpaque(false);
    this.prH.setHighLightOuter(getResources().getColor(2131100271));
    this.prH.setInnerColor(getResources().getColor(2131099653));
    this.prH.setLongPressCallback((MMSightRecordButton.b)new MMSightRecordButton.b()
    {
      public final void cfN()
      {
        AppMethodBeat.i(568);
        ac.i(CaptureContainer.e(this.prW), "onLongPressFinish");
        CaptureContainer.a(this.prW, this.prW.o((d.g.a.b)new b(this)));
        AppMethodBeat.o(568);
      }
      
      public final void cfO()
      {
        AppMethodBeat.i(570);
        ac.i(CaptureContainer.e(this.prW), "onPressDown");
        int[] arrayOfInt = new int[2];
        CaptureContainer.f(this.prW).getLocationOnScreen(arrayOfInt);
        CaptureContainer.c(this.prW).nB(arrayOfInt[1]);
        AppMethodBeat.o(570);
      }
      
      public final void jl()
      {
        AppMethodBeat.i(569);
        Object localObject1 = CaptureContainer.f(this.prW);
        Object localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pnw;
        ((MMSightRecordButton)localObject1).a(com.tencent.mm.plugin.emojicapture.model.d.ceK() * 1000, com.tencent.mm.plugin.emojicapture.ui.c.dM(this.prW), (MMSightCircularProgressBar.a)new a(this));
        localObject1 = this.prW;
        ((CaptureContainer)localObject1).prK.setShow(false);
        localObject2 = ((CaptureContainer)localObject1).prR;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2).bgk();
        }
        if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).prU)) {
          EmojiCaptureReporter.BD(33);
        }
        CaptureContainer.g(this.prW).setEnabled(false);
        CaptureContainer.g(this.prW).animate().alpha(0.0F).start();
        CaptureContainer.a(this.prW, false, 0);
        CaptureContainer.b(this.prW).setVisibility(8);
        AppMethodBeat.o(569);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-emojicapture_release"})
      public static final class a
        implements MMSightCircularProgressBar.a
      {
        public final void S(ArrayList<Float> paramArrayList) {}
        
        public final void kw(boolean paramBoolean)
        {
          AppMethodBeat.i(195163);
          ac.i(CaptureContainer.e(this.prX.prW), "onLongPress");
          CaptureContainer.a(this.prX.prW, this.prX.prW.o((d.g.a.b)new a(this)));
          AppMethodBeat.o(195163);
        }
        
        @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
        static final class a
          extends d.g.b.l
          implements d.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, y>
        {
          a(CaptureContainer.1.a parama)
          {
            super();
          }
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
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
    this.prH.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cfP()
      {
        AppMethodBeat.i(572);
        ac.i(CaptureContainer.e(this.prW), "simpleTapCallback");
        CaptureContainer.a(this.prW, false);
        AppMethodBeat.o(572);
      }
    });
    this.prH.setLongPressScrollCallback((MMSightRecordButton.c)new MMSightRecordButton.c()
    {
      public final void BO(int paramAnonymousInt)
      {
        AppMethodBeat.i(573);
        CaptureContainer.c(this.prW).j(true, paramAnonymousInt);
        AppMethodBeat.o(573);
      }
      
      public final void BP(int paramAnonymousInt)
      {
        AppMethodBeat.i(574);
        CaptureContainer.c(this.prW).j(false, paramAnonymousInt);
        AppMethodBeat.o(574);
      }
    });
    this.prO.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void D(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(575);
        CaptureContainer.c(this.prW).b(paramAnonymousFloat1, paramAnonymousFloat2, CaptureContainer.h(this.prW).getWidth(), CaptureContainer.h(this.prW).getHeight());
        CaptureContainer.i(this.prW).U(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(575);
      }
      
      public final void aSi()
      {
        AppMethodBeat.i(577);
        CaptureContainer.c(this.prW).j(true, 1);
        AppMethodBeat.o(577);
      }
      
      public final void aSj()
      {
        AppMethodBeat.i(578);
        CaptureContainer.c(this.prW).j(false, 1);
        AppMethodBeat.o(578);
      }
      
      public final void cfQ()
      {
        AppMethodBeat.i(576);
        CaptureContainer.c(this.prW).atx();
        this.prW.atm();
        AppMethodBeat.o(576);
      }
    });
    this.prI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(579);
        paramAnonymousView = this.prW.getPresenter();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.exit();
          AppMethodBeat.o(579);
          return;
        }
        AppMethodBeat.o(579);
      }
    });
    this.prJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(580);
        this.prW.atm();
        AppMethodBeat.o(580);
      }
    });
    this.prQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(581);
        paramAnonymousView = CaptureContainer.j(this.prW);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.EOk;
          if (paramAnonymousView != null)
          {
            Object localObject = Class.forName("com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI");
            localObject = new Intent(paramContext, (Class)localObject);
            ((Intent)localObject).putExtra("uin", paramAnonymousView.DesignerUin);
            ((Intent)localObject).putExtra("name", paramAnonymousView.Name);
            ((Intent)localObject).putExtra("headurl", paramAnonymousView.HeadUrl);
            paramAnonymousView = paramContext;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(581);
            return;
          }
        }
        AppMethodBeat.o(581);
      }
    });
    this.prK.setSelectionCallback((m)new d.g.b.l(paramContext) {});
    this.prK.setVisibility(8);
    this.prP.setAlpha(0.0F);
    post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(583);
        CaptureContainer.a(this.prW, true, 2131756780);
        AppMethodBeat.o(583);
      }
    });
    if ((bt.eWo()) || (h.IS_FLAVOR_RED)) {
      this.prI.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
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
          ((XLabEffectSettingView)localObject).setCameraView((com.tencent.mm.media.widget.camerarecordview.preview.e)CaptureContainer.h(this.prW));
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
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
      if (this.prP.getTop() < getResources().getDimension(2131166205) + getResources().getDimension(2131166693) + getResources().getDimension(2131166206) + getResources().getDimension(2131166207) + com.tencent.mm.cc.a.fromDPToPix(getContext(), 30)) {
        this.prP.setBackgroundResource(2131232011);
      }
      removeCallbacks(this.prT);
      this.prP.animate().cancel();
      this.prP.animate().alpha(1.0F).start();
      this.prP.setText(paramInt);
      postDelayed(this.prT, 2000L);
      AppMethodBeat.o(594);
      return;
    }
    this.prP.animate().cancel();
    this.prP.animate().alpha(0.0F).start();
    AppMethodBeat.o(594);
  }
  
  public final boolean Nw()
  {
    return true;
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(592);
    this.prM.setStickerInfo(paramf);
    this.prG.h((d.g.a.a)new a(this, paramf));
    AppMethodBeat.o(592);
  }
  
  public final boolean atm()
  {
    AppMethodBeat.i(598);
    this.prV = com.tencent.mm.media.widget.camerarecordview.a.b(this.prU);
    EmojiCaptureReporter localEmojiCaptureReporter = this.ppG;
    long l;
    if (localEmojiCaptureReporter != null)
    {
      l = localEmojiCaptureReporter.fWr;
      localEmojiCaptureReporter = this.ppG;
      if (localEmojiCaptureReporter == null) {
        break label83;
      }
    }
    label83:
    for (int i = localEmojiCaptureReporter.scene;; i = 0)
    {
      EmojiCaptureReporter.a(5, l, 0L, 0L, 0L, 0L, 0, 0, i);
      boolean bool = this.prV;
      AppMethodBeat.o(598);
      return bool;
      l = 0L;
      break;
    }
  }
  
  public final boolean auW()
  {
    AppMethodBeat.i(599);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.pmV.aqp()).gWY;
    AppMethodBeat.o(599);
    return bool;
  }
  
  public final boolean auX()
  {
    AppMethodBeat.i(605);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.pqx;
    boolean bool = EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate();
    AppMethodBeat.o(605);
    return bool;
  }
  
  public final boolean auY()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.prG;
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
    return this.prM;
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
    return this.prR;
  }
  
  public final com.tencent.mm.media.i.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.i.a)this.prb;
  }
  
  public final com.tencent.mm.media.i.a getRecordRenderer()
  {
    AppMethodBeat.i(603);
    Object localObject = new g();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    int i = com.tencent.mm.plugin.emojicapture.model.d.ceL();
    locala = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    ((g)localObject).cS(i, com.tencent.mm.plugin.emojicapture.model.d.ceL());
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
      d.g.b.k.fOy();
    }
    com.tencent.mm.media.f.d locald = this.prG.getPreviewTexture();
    if (locald != null) {}
    for (int i = locald.gRW;; i = -1)
    {
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, (com.tencent.mm.media.i.a)localObject, localEGLContext, i);
      AppMethodBeat.o(604);
      return localObject;
    }
  }
  
  public final EmojiCaptureReporter getReporter()
  {
    return this.ppG;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(600);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.pmV.aqp()).gnN;
    AppMethodBeat.o(600);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(602);
    VideoTransPara localVideoTransPara = com.tencent.mm.plugin.mmsight.model.k.uLk.hcZ;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(602);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(602);
    return localVideoTransPara;
  }
  
  public final void kr(boolean paramBoolean)
  {
    AppMethodBeat.i(593);
    if (paramBoolean)
    {
      this.prL.setVisibility(0);
      AppMethodBeat.o(593);
      return;
    }
    this.prL.setVisibility(8);
    AppMethodBeat.o(593);
  }
  
  public final boolean o(d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, y> paramb)
  {
    AppMethodBeat.i(597);
    this.prG.h((d.g.a.a)new f(this));
    boolean bool = this.prU.o(paramb);
    AppMethodBeat.o(597);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(596);
    ac.i(this.TAG, "resumeCapture");
    kr(false);
    if (this.pqN) {
      this.prK.setShow(true);
    }
    getDecoration().resume();
    this.prG.h((d.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.a.a(this.prU, this.prV, (d.g.a.b)new e(this), 2);
    AppMethodBeat.o(596);
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    this.prR = parama;
  }
  
  public final void setReporter(EmojiCaptureReporter paramEmojiCaptureReporter)
  {
    this.ppG = paramEmojiCaptureReporter;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(595);
    ac.i(this.TAG, "setVisibility:".concat(String.valueOf(paramInt)));
    super.setVisibility(paramInt);
    this.prI.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.prH.setTouchEnable(true);
      this.prK.cfR();
    }
    if (paramInt == 8)
    {
      this.prG.setTextureChangeCallback(null);
      this.prF.removeView((View)this.prG);
      this.prG = new EmojiCaptureGLTextureView(getContext());
      this.prF.addView((View)this.prG);
      this.prb = new com.tencent.mm.plugin.emojicapture.ui.b.e();
      this.prG.a((com.tencent.mm.media.i.a)this.prb, auW());
      this.prG.setOpaque(false);
    }
    this.prG.setVisibility(paramInt);
    AppMethodBeat.o(595);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(CaptureContainer paramCaptureContainer, f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int auM()
    {
      return 2;
    }
    
    public final String auN()
    {
      AppMethodBeat.i(586);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pnw;
      localObject = d.a.ceQ();
      AppMethodBeat.o(586);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(585);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pnw;
      localObject = d.a.ceP();
      AppMethodBeat.o(585);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CaptureContainer paramCaptureContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(587);
      CaptureContainer.a(this.prW, false, 0);
      AppMethodBeat.o(587);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    e(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(CaptureContainer paramCaptureContainer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */