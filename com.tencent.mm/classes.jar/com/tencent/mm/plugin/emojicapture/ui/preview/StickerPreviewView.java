package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.b.a.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.b.n;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.ap;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroid/support/constraint/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a oSQ;
  private final CaptureStickerHint KEf;
  private final String TAG;
  private final int fEp;
  private int mode;
  private String oNX;
  public final com.tencent.mm.media.widget.camerarecordview.a oOA;
  private boolean oOB;
  private final FontAnimTextView oOI;
  private final CameraFrontSightView oOt;
  private final MMSightCaptureTouchView oOu;
  private final Rect oSA;
  private final ViewGroup oSG;
  private final CameraPreviewGLTextureView oSH;
  private final View oSI;
  private final View oSJ;
  private final ImageView oSK;
  private final ImageView oSL;
  private final Guideline oSM;
  private n oSN;
  private final int oSO;
  public final b oSP;
  
  static
  {
    AppMethodBeat.i(926);
    oSQ = new a((byte)0);
    AppMethodBeat.o(926);
  }
  
  public StickerPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(925);
    AppMethodBeat.o(925);
  }
  
  public StickerPreviewView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(924);
    this.TAG = "MicroMsg.StickerPreviewView";
    this.oSN = new n((byte)0);
    this.mode = 2;
    this.oSA = new Rect();
    this.oNX = "";
    this.oSP = new b(this);
    View.inflate(paramContext, 2131495644, (ViewGroup)this);
    this.fEp = getResources().getDimensionPixelSize(2131166205);
    this.oSO = getResources().getDimensionPixelSize(2131165285);
    paramAttributeSet = findViewById(2131305220);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.oSG = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131305228);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.oSH = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305219);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.oOt = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305227);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.oOu = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305224);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.oSI = paramAttributeSet;
    paramAttributeSet = findViewById(2131305221);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.oSJ = paramAttributeSet;
    paramAttributeSet = findViewById(2131305225);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.oSK = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305222);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.oSL = ((ImageView)paramAttributeSet);
    com.tencent.mm.plugin.emojicapture.ui.c.a(this.oSL, 2131690362, -1);
    paramAttributeSet = findViewById(2131305238);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.oSM = ((Guideline)paramAttributeSet);
    this.oSM.setGuidelineEnd(ap.eb(paramContext) + getResources().getDimensionPixelOffset(2131165294));
    paramAttributeSet = findViewById(2131305230);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.KEf = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(2131305236);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.oOI = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(paramContext, 120);
    this.oOt.ge(paramInt, paramInt);
    this.oSH.setOpaque(false);
    this.oOA = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.oOu.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void A(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.f(this.oSR).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.g(this.oSR).getWidth(), StickerPreviewView.g(this.oSR).getHeight());
        StickerPreviewView.h(this.oSR).Q(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void aLr()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.f(this.oSR).i(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void aLs()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.f(this.oSR).i(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void bYD()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.f(this.oSR).amF();
        StickerPreviewView.a(this.oSR, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.oSR)));
        AppMethodBeat.o(903);
      }
    });
    this.oSI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(909);
        paramAnonymousView = new android.support.design.widget.a(paramContext);
        StickerPreviewChangeMode localStickerPreviewChangeMode = new StickerPreviewChangeMode(paramContext);
        localStickerPreviewChangeMode.setBackgroundResource(2131232016);
        localStickerPreviewChangeMode.setOnModeSelected((d.g.a.b)new d.g.b.l(paramAnonymousView) {});
        paramAnonymousView.setContentView((View)localStickerPreviewChangeMode);
        paramAnonymousView.show();
        AppMethodBeat.o(909);
      }
    });
    this.oSJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(910);
        com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.oSR));
        AppMethodBeat.o(910);
      }
    });
    paramContext = com.tencent.mm.sticker.loader.e.Fds;
    com.tencent.mm.sticker.loader.e.a((f)this.oSP);
    paramContext = new com.tencent.mm.sticker.e();
    paramAttributeSet = new StringBuilder();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Fds;
    paramContext.aGZ(com.tencent.mm.sticker.loader.e.eIZ() + "preview/");
    paramAttributeSet = new StringBuilder();
    locale = com.tencent.mm.sticker.loader.e.Fds;
    paramContext.aHa(com.tencent.mm.sticker.loader.e.eIZ() + "preview/");
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  public final boolean Ny()
  {
    return false;
  }
  
  public final void a(final com.tencent.mm.sticker.e parame)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, parame));
    this.oSH.j((d.g.a.a)new d(this, parame));
    AppMethodBeat.o(917);
  }
  
  public final boolean aof()
  {
    AppMethodBeat.i(920);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.oJw.ajp()).gwB;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean aog()
  {
    return false;
  }
  
  public final boolean aoh()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.oSH;
  }
  
  public final VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(927);
    VideoTransPara localVideoTransPara = getVideoTransPara();
    AppMethodBeat.o(927);
    return localVideoTransPara;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(922);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new e();
    AppMethodBeat.o(922);
    return locala;
  }
  
  public final com.tencent.mm.media.i.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.i.a)this.oSN;
  }
  
  public final com.tencent.mm.media.i.a getRecordRenderer()
  {
    return null;
  }
  
  public final int getRecordScene()
  {
    return 10;
  }
  
  public final com.tencent.mm.media.widget.c.b getRecorder()
  {
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(921);
    int i = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.oJw.ajp()).oJx;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = com.tencent.mm.plugin.mmsight.model.k.tCN.gCB;
    if (localVideoTransPara != null)
    {
      AppMethodBeat.o(923);
      return localVideoTransPara;
    }
    localVideoTransPara = new VideoTransPara();
    AppMethodBeat.o(923);
    return localVideoTransPara;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(918);
    com.tencent.mm.media.widget.camerarecordview.a.a(this.oOA, this.oOB, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.fEp) / 2;
      paramInt2 = this.oSO;
      this.oSA.set(paramInt1, paramInt2, this.fEp + paramInt1, this.fEp + paramInt2);
      n localn = this.oSN;
      Rect localRect = this.oSA;
      d.g.b.k.h(localRect, "previewRect");
      localn.oSA.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    d.g.b.k.h(paramString, "url");
    this.oNX = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Fds;
    com.tencent.mm.sticker.loader.e.aHc(paramString);
    AppMethodBeat.o(916);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$Companion;", "", "()V", "MODE_CAPTURE_EMOJI", "", "MODE_FULLSCREEN", "MODE_RATIO_16_9", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class b
    implements f<g>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int anW()
    {
      return 2;
    }
    
    public final String anX()
    {
      AppMethodBeat.i(915);
      Object localObject = d.oJY;
      localObject = d.a.bXD();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = d.oJY;
      localObject = d.a.bXC();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */