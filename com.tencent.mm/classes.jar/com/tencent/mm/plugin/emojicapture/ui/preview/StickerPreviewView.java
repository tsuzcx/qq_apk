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
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.ar;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroid/support/constraint/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final StickerPreviewView.a qgl;
  private final String TAG;
  private final int gdE;
  private int mode;
  private String qbC;
  private final CameraFrontSightView qbY;
  private final MMSightCaptureTouchView qbZ;
  public final com.tencent.mm.media.widget.camerarecordview.a qcf;
  private boolean qcg;
  private final FontAnimTextView qcn;
  private final CaptureStickerHint qco;
  private final Rect qfV;
  private final ViewGroup qgb;
  private final CameraPreviewGLTextureView qgc;
  private final View qgd;
  private final View qge;
  private final ImageView qgf;
  private final ImageView qgg;
  private final Guideline qgh;
  private n qgi;
  private final int qgj;
  public final b qgk;
  
  static
  {
    AppMethodBeat.i(926);
    qgl = new StickerPreviewView.a((byte)0);
    AppMethodBeat.o(926);
  }
  
  public StickerPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(925);
    AppMethodBeat.o(925);
  }
  
  public StickerPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(924);
    this.TAG = "MicroMsg.StickerPreviewView";
    this.qgi = new n((byte)0);
    this.mode = 2;
    this.qfV = new Rect();
    this.qbC = "";
    this.qgk = new b(this);
    View.inflate(paramContext, 2131495644, (ViewGroup)this);
    this.gdE = getResources().getDimensionPixelSize(2131166205);
    this.qgj = getResources().getDimensionPixelSize(2131165285);
    paramAttributeSet = findViewById(2131305220);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.qgb = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131305228);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.qgc = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305219);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.qbY = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305227);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.qbZ = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305224);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.qgd = paramAttributeSet;
    paramAttributeSet = findViewById(2131305221);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.qge = paramAttributeSet;
    paramAttributeSet = findViewById(2131305225);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.qgf = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305222);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.qgg = ((ImageView)paramAttributeSet);
    com.tencent.mm.plugin.emojicapture.ui.c.a(this.qgg, 2131690362, -1);
    paramAttributeSet = findViewById(2131305238);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.qgh = ((Guideline)paramAttributeSet);
    this.qgh.setGuidelineEnd(ar.en(paramContext) + getResources().getDimensionPixelOffset(2131165294));
    paramAttributeSet = findViewById(2131305230);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.qco = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(2131305236);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.qcn = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 120);
    this.qbY.gC(paramInt, paramInt);
    this.qgc.setOpaque(false);
    this.qcf = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.qbZ.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void E(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.f(this.qgm).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.g(this.qgm).getWidth(), StickerPreviewView.g(this.qgm).getHeight());
        StickerPreviewView.h(this.qgm).W(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void aVT()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.f(this.qgm).j(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void aVU()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.f(this.qgm).j(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void clJ()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.f(this.qgm).awz();
        StickerPreviewView.a(this.qgm, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.qgm)));
        AppMethodBeat.o(903);
      }
    });
    this.qgd.setOnClickListener((View.OnClickListener)new StickerPreviewView.2(this, paramContext));
    this.qge.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(910);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.qgm));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(910);
      }
    });
    paramContext = com.tencent.mm.sticker.loader.e.IGU;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.g.f)this.qgk);
    paramContext = new com.tencent.mm.sticker.f();
    paramAttributeSet = new StringBuilder();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.IGU;
    paramContext.aTw(com.tencent.mm.sticker.loader.e.frY() + "preview/");
    paramAttributeSet = new StringBuilder();
    locale = com.tencent.mm.sticker.loader.e.IGU;
    paramContext.aTx(com.tencent.mm.sticker.loader.e.frY() + "preview/");
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  public final boolean Pd()
  {
    return false;
  }
  
  public final void a(final com.tencent.mm.sticker.f paramf)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ac.c.h((d.g.a.a)new c(this, paramf));
    this.qgc.i((d.g.a.a)new d(this, paramf));
    AppMethodBeat.o(917);
  }
  
  public final boolean axY()
  {
    AppMethodBeat.i(920);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.pXa.att()).hrS;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean axZ()
  {
    return false;
  }
  
  public final boolean aya()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.qgc;
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
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.qgi;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
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
    int i = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.pXa.att()).gKf;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = k.wat.hxV;
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
    com.tencent.mm.media.widget.camerarecordview.a.a(this.qcf, this.qcg, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.gdE) / 2;
      paramInt2 = this.qgj;
      this.qfV.set(paramInt1, paramInt2, this.gdE + paramInt1, this.gdE + paramInt2);
      n localn = this.qgi;
      Rect localRect = this.qfV;
      d.g.b.p.h(localRect, "previewRect");
      localn.qfV.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    d.g.b.p.h(paramString, "url");
    this.qbC = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.IGU;
    com.tencent.mm.sticker.loader.e.aTA(paramString);
    AppMethodBeat.o(916);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int axO()
    {
      return 2;
    }
    
    public final String axP()
    {
      AppMethodBeat.i(915);
      Object localObject = d.pXB;
      localObject = d.a.ckJ();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = d.pXB;
      localObject = d.a.ckI();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */