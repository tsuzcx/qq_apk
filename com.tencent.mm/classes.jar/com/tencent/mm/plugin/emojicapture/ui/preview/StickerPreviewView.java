package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.b.a.a;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.b.n;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroidx/constraintlayout/widget/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a vcN;
  private final String TAG;
  private final int jtu;
  private int mode;
  private final Rect previewRect;
  private final CameraFrontSightView uYA;
  private final MMSightCaptureTouchView uYB;
  public final com.tencent.mm.media.widget.camerarecordview.a uYH;
  private boolean uYI;
  private final FontAnimTextView uYP;
  private final CaptureStickerHint uYQ;
  private String uYf;
  private final ViewGroup vcD;
  private final CameraPreviewGLTextureView vcE;
  private final View vcF;
  private final View vcG;
  private final ImageView vcH;
  private final ImageView vcI;
  private final Guideline vcJ;
  private n vcK;
  private final int vcL;
  public final b vcM;
  
  static
  {
    AppMethodBeat.i(926);
    vcN = new a((byte)0);
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
    this.vcK = new n((byte)0);
    this.mode = 2;
    this.previewRect = new Rect();
    this.uYf = "";
    this.vcM = new b(this);
    View.inflate(paramContext, a.g.uSM, (ViewGroup)this);
    this.jtu = getResources().getDimensionPixelSize(a.d.uRn);
    this.vcL = getResources().getDimensionPixelSize(a.d.Edge_20A);
    paramAttributeSet = findViewById(a.f.uSi);
    p.j(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.vcD = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSo);
    p.j(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.vcE = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSh);
    p.j(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.uYA = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSn);
    p.j(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.uYB = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSl);
    p.j(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.vcF = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uSj);
    p.j(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.vcG = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.uSm);
    p.j(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.vcH = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSk);
    p.j(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.vcI = ((ImageView)paramAttributeSet);
    c.a(this.vcI, a.h.icons_filled_camera_switch, -1);
    paramAttributeSet = findViewById(a.f.uSu);
    p.j(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.vcJ = ((Guideline)paramAttributeSet);
    this.vcJ.setGuidelineEnd(ax.aB(paramContext) + getResources().getDimensionPixelOffset(a.d.Edge_4A));
    paramAttributeSet = findViewById(a.f.sticker_preview_hint);
    p.j(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.uYQ = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.uSs);
    p.j(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.uYP = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.ci.a.fromDPToPix(paramContext, 120);
    this.uYA.ii(paramInt, paramInt);
    this.vcE.setOpaque(false);
    this.uYH = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.uYB.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void J(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.f(this.vcO).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.g(this.vcO).getWidth(), StickerPreviewView.g(this.vcO).getHeight());
        StickerPreviewView.h(this.vcO).ab(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void bBF()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.f(this.vcO).k(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void bBG()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.f(this.vcO).k(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void cYv()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.f(this.vcO).aYe();
        StickerPreviewView.a(this.vcO, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.vcO)));
        AppMethodBeat.o(903);
      }
    });
    this.vcF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(909);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new com.google.android.material.bottomsheet.a(paramContext);
        localObject = new StickerPreviewChangeMode(paramContext);
        ((StickerPreviewChangeMode)localObject).setBackgroundResource(a.e.uRt);
        ((StickerPreviewChangeMode)localObject).setOnModeSelected((kotlin.g.a.b)new q(paramAnonymousView) {});
        paramAnonymousView.setContentView((View)localObject);
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(909);
      }
    });
    this.vcG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(910);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.vcO));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(910);
      }
    });
    paramContext = com.tencent.mm.sticker.loader.e.Vbx;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.g.f)this.vcM);
    paramContext = new com.tencent.mm.sticker.f();
    paramAttributeSet = new StringBuilder();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Vbx;
    paramContext.buG(com.tencent.mm.sticker.loader.e.huZ() + "preview/");
    paramAttributeSet = new StringBuilder();
    locale = com.tencent.mm.sticker.loader.e.Vbx;
    paramContext.buI(com.tencent.mm.sticker.loader.e.huZ() + "preview/");
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  public final void a(final com.tencent.mm.sticker.f paramf)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramf));
    this.vcE.i((kotlin.g.a.a)new d(this, paramf));
    AppMethodBeat.o(917);
  }
  
  public final boolean aZo()
  {
    AppMethodBeat.i(920);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.uTG.aUb()).laO;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean aZp()
  {
    return false;
  }
  
  public final boolean aZq()
  {
    return false;
  }
  
  public final boolean aeg()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.vcE;
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
    return (com.tencent.mm.media.j.a)this.vcK;
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
    int i = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.uTG.aUb()).kmg;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = j.EZX.lgX;
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
    com.tencent.mm.media.widget.camerarecordview.a.a(this.uYH, this.uYI, null, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.jtu) / 2;
      paramInt2 = this.vcL;
      this.previewRect.set(paramInt1, paramInt2, this.jtu + paramInt1, this.jtu + paramInt2);
      n localn = this.vcK;
      Rect localRect = this.previewRect;
      p.k(localRect, "previewRect");
      localn.previewRect.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    p.k(paramString, "url");
    this.uYf = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Vbx;
    com.tencent.mm.sticker.loader.e.buM(paramString);
    AppMethodBeat.o(916);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$Companion;", "", "()V", "MODE_CAPTURE_EMOJI", "", "MODE_FULLSCREEN", "MODE_RATIO_16_9", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aZd()
    {
      return 2;
    }
    
    public final String aZe()
    {
      AppMethodBeat.i(915);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      localObject = d.a.cXu();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      localObject = d.a.cXt();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */