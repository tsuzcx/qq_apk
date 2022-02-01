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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroid/support/constraint/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final StickerPreviewView.a pZG;
  private final String TAG;
  private final int gbw;
  private int mode;
  private String pUX;
  public final com.tencent.mm.media.widget.camerarecordview.a pVA;
  private boolean pVB;
  private final FontAnimTextView pVI;
  private final CaptureStickerHint pVJ;
  private final CameraFrontSightView pVt;
  private final MMSightCaptureTouchView pVu;
  private final ImageView pZA;
  private final ImageView pZB;
  private final Guideline pZC;
  private n pZD;
  private final int pZE;
  public final b pZF;
  private final Rect pZq;
  private final ViewGroup pZw;
  private final CameraPreviewGLTextureView pZx;
  private final View pZy;
  private final View pZz;
  
  static
  {
    AppMethodBeat.i(926);
    pZG = new StickerPreviewView.a((byte)0);
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
    this.pZD = new n((byte)0);
    this.mode = 2;
    this.pZq = new Rect();
    this.pUX = "";
    this.pZF = new b(this);
    View.inflate(paramContext, 2131495644, (ViewGroup)this);
    this.gbw = getResources().getDimensionPixelSize(2131166205);
    this.pZE = getResources().getDimensionPixelSize(2131165285);
    paramAttributeSet = findViewById(2131305220);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.pZw = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131305228);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.pZx = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305219);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.pVt = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305227);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.pVu = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305224);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.pZy = paramAttributeSet;
    paramAttributeSet = findViewById(2131305221);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.pZz = paramAttributeSet;
    paramAttributeSet = findViewById(2131305225);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.pZA = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305222);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.pZB = ((ImageView)paramAttributeSet);
    com.tencent.mm.plugin.emojicapture.ui.c.a(this.pZB, 2131690362, -1);
    paramAttributeSet = findViewById(2131305238);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.pZC = ((Guideline)paramAttributeSet);
    this.pZC.setGuidelineEnd(ar.ej(paramContext) + getResources().getDimensionPixelOffset(2131165294));
    paramAttributeSet = findViewById(2131305230);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.pVJ = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(2131305236);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.pVI = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.cc.a.fromDPToPix(paramContext, 120);
    this.pVt.gC(paramInt, paramInt);
    this.pZx.setOpaque(false);
    this.pVA = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.pVu.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void E(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.f(this.pZH).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.g(this.pZH).getWidth(), StickerPreviewView.g(this.pZH).getHeight());
        StickerPreviewView.h(this.pZH).W(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void aVu()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.f(this.pZH).j(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void aVv()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.f(this.pZH).j(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void ckt()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.f(this.pZH).awk();
        StickerPreviewView.a(this.pZH, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.pZH)));
        AppMethodBeat.o(903);
      }
    });
    this.pZy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(909);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new android.support.design.widget.a(paramContext);
        localObject = new StickerPreviewChangeMode(paramContext);
        ((StickerPreviewChangeMode)localObject).setBackgroundResource(2131232016);
        ((StickerPreviewChangeMode)localObject).setOnModeSelected((d.g.a.b)new q(paramAnonymousView) {});
        paramAnonymousView.setContentView((View)localObject);
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(909);
      }
    });
    this.pZz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(910);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.pZH));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(910);
      }
    });
    paramContext = com.tencent.mm.sticker.loader.e.ImJ;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.g.f)this.pZF);
    paramContext = new com.tencent.mm.sticker.f();
    paramAttributeSet = new StringBuilder();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.ImJ;
    paramContext.aRZ(com.tencent.mm.sticker.loader.e.fof() + "preview/");
    paramAttributeSet = new StringBuilder();
    locale = com.tencent.mm.sticker.loader.e.ImJ;
    paramContext.aSa(com.tencent.mm.sticker.loader.e.fof() + "preview/");
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  public final boolean Pf()
  {
    return false;
  }
  
  public final void a(final com.tencent.mm.sticker.f paramf)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramf));
    this.pZx.h((d.g.a.a)new d(this, paramf));
    AppMethodBeat.o(917);
  }
  
  public final boolean axJ()
  {
    AppMethodBeat.i(920);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.pQv.ate()).hpe;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean axK()
  {
    return false;
  }
  
  public final boolean axL()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.pZx;
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
    return (com.tencent.mm.media.j.a)this.pZD;
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
    int i = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.pQv.ate()).gHw;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = k.vOq.hvh;
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
    com.tencent.mm.media.widget.camerarecordview.a.a(this.pVA, this.pVB, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.gbw) / 2;
      paramInt2 = this.pZE;
      this.pZq.set(paramInt1, paramInt2, this.gbw + paramInt1, this.gbw + paramInt2);
      n localn = this.pZD;
      Rect localRect = this.pZq;
      d.g.b.p.h(localRect, "previewRect");
      localn.pZq.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    d.g.b.p.h(paramString, "url");
    this.pUX = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.ImJ;
    com.tencent.mm.sticker.loader.e.aSd(paramString);
    AppMethodBeat.o(916);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final String axA()
    {
      AppMethodBeat.i(915);
      Object localObject = d.pQW;
      localObject = d.a.cjt();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final int axz()
    {
      return 2;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = d.pQW;
      localObject = d.a.cjs();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */