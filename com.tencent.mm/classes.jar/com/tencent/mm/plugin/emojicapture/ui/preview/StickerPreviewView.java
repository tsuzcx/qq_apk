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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroid/support/constraint/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final StickerPreviewView.a pwb;
  private final String TAG;
  private final int fHW;
  private int mode;
  private final CameraFrontSightView prN;
  private final MMSightCaptureTouchView prO;
  public final com.tencent.mm.media.widget.camerarecordview.a prU;
  private boolean prV;
  private String prr;
  private final FontAnimTextView psc;
  private final CaptureStickerHint psd;
  private final Rect pvL;
  private final ViewGroup pvR;
  private final CameraPreviewGLTextureView pvS;
  private final View pvT;
  private final View pvU;
  private final ImageView pvV;
  private final ImageView pvW;
  private final Guideline pvX;
  private n pvY;
  private final int pvZ;
  public final b pwa;
  
  static
  {
    AppMethodBeat.i(926);
    pwb = new StickerPreviewView.a((byte)0);
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
    this.pvY = new n((byte)0);
    this.mode = 2;
    this.pvL = new Rect();
    this.prr = "";
    this.pwa = new b(this);
    View.inflate(paramContext, 2131495644, (ViewGroup)this);
    this.fHW = getResources().getDimensionPixelSize(2131166205);
    this.pvZ = getResources().getDimensionPixelSize(2131165285);
    paramAttributeSet = findViewById(2131305220);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.pvR = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131305228);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.pvS = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305219);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.prN = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305227);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.prO = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305224);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.pvT = paramAttributeSet;
    paramAttributeSet = findViewById(2131305221);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.pvU = paramAttributeSet;
    paramAttributeSet = findViewById(2131305225);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.pvV = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305222);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.pvW = ((ImageView)paramAttributeSet);
    com.tencent.mm.plugin.emojicapture.ui.c.a(this.pvW, 2131690362, -1);
    paramAttributeSet = findViewById(2131305238);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.pvX = ((Guideline)paramAttributeSet);
    this.pvX.setGuidelineEnd(ap.ej(paramContext) + getResources().getDimensionPixelOffset(2131165294));
    paramAttributeSet = findViewById(2131305230);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.psd = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(2131305236);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.psc = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.cc.a.fromDPToPix(paramContext, 120);
    this.prN.gl(paramInt, paramInt);
    this.pvS.setOpaque(false);
    this.prU = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.prO.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void D(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.f(this.pwc).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.g(this.pwc).getWidth(), StickerPreviewView.g(this.pwc).getHeight());
        StickerPreviewView.h(this.pwc).U(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void aSi()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.f(this.pwc).j(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void aSj()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.f(this.pwc).j(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void cfQ()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.f(this.pwc).atx();
        StickerPreviewView.a(this.pwc, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.pwc)));
        AppMethodBeat.o(903);
      }
    });
    this.pvT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
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
    this.pvU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(910);
        com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.pwc));
        AppMethodBeat.o(910);
      }
    });
    paramContext = com.tencent.mm.sticker.loader.e.GAP;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.g.f)this.pwa);
    paramContext = new com.tencent.mm.sticker.f();
    paramAttributeSet = new StringBuilder();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.GAP;
    paramContext.aMs(com.tencent.mm.sticker.loader.e.eYv() + "preview/");
    paramAttributeSet = new StringBuilder();
    locale = com.tencent.mm.sticker.loader.e.GAP;
    paramContext.aMt(com.tencent.mm.sticker.loader.e.eYv() + "preview/");
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  public final boolean Nw()
  {
    return false;
  }
  
  public final void a(final com.tencent.mm.sticker.f paramf)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramf));
    this.pvS.h((d.g.a.a)new d(this, paramf));
    AppMethodBeat.o(917);
  }
  
  public final boolean auW()
  {
    AppMethodBeat.i(920);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.pmV.aqp()).gWY;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean auX()
  {
    return false;
  }
  
  public final boolean auY()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.pvS;
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
    return (com.tencent.mm.media.i.a)this.pvY;
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
    int i = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.pmV.aqp()).gnN;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = com.tencent.mm.plugin.mmsight.model.k.uLk.hcZ;
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
    com.tencent.mm.media.widget.camerarecordview.a.a(this.prU, this.prV, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.fHW) / 2;
      paramInt2 = this.pvZ;
      this.pvL.set(paramInt1, paramInt2, this.fHW + paramInt1, this.fHW + paramInt2);
      n localn = this.pvY;
      Rect localRect = this.pvL;
      d.g.b.k.h(localRect, "previewRect");
      localn.pvL.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    d.g.b.k.h(paramString, "url");
    this.prr = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.GAP;
    com.tencent.mm.sticker.loader.e.aMw(paramString);
    AppMethodBeat.o(916);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int auM()
    {
      return 2;
    }
    
    public final String auN()
    {
      AppMethodBeat.i(915);
      Object localObject = d.pnw;
      localObject = d.a.ceQ();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = d.pnw;
      localObject = d.a.ceP();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */