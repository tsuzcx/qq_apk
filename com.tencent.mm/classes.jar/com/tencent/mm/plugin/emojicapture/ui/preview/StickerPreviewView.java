package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
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
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.b.n;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroidx/constraintlayout/widget/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final StickerPreviewView.b yov;
  private final String TAG;
  private final int lWL;
  private int mode;
  private final Rect previewRect;
  private final CameraFrontSightView ykL;
  private final MMSightCaptureTouchView ykM;
  public final com.tencent.mm.media.widget.camerarecordview.a ykS;
  private boolean ykT;
  private final FontAnimTextView ykX;
  private final CaptureStickerHint ykY;
  private String ykt;
  private final ImageView yoA;
  private final ImageView yoB;
  private final Guideline yoC;
  private n yoD;
  private final int yoE;
  public final c yoF;
  private final ViewGroup yow;
  private final CameraPreviewGLTextureView yox;
  private final View yoy;
  private final View yoz;
  
  static
  {
    AppMethodBeat.i(926);
    yov = new StickerPreviewView.b((byte)0);
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
    this.yoD = new n((byte)0);
    this.mode = 2;
    this.previewRect = new Rect();
    this.ykt = "";
    this.yoF = new c(this);
    View.inflate(paramContext, a.g.yfA, (ViewGroup)this);
    this.lWL = getResources().getDimensionPixelSize(a.d.yeb);
    this.yoE = getResources().getDimensionPixelSize(a.d.Edge_20A);
    paramAttributeSet = findViewById(a.f.yeW);
    s.s(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.yow = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yfc);
    s.s(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.yox = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeV);
    s.s(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.ykL = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yfb);
    s.s(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.ykM = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeZ);
    s.s(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.yoy = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yeX);
    s.s(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.yoz = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.yfa);
    s.s(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.yoA = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeY);
    s.s(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.yoB = ((ImageView)paramAttributeSet);
    com.tencent.mm.plugin.emojicapture.ui.b.a(this.yoB, a.h.icons_filled_camera_switch, -1);
    paramAttributeSet = findViewById(a.f.yfi);
    s.s(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.yoC = ((Guideline)paramAttributeSet);
    this.yoC.setGuidelineEnd(bf.bk(paramContext) + getResources().getDimensionPixelOffset(a.d.Edge_4A));
    paramAttributeSet = findViewById(a.f.sticker_preview_hint);
    s.s(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.ykY = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yfg);
    s.s(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.ykX = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(paramContext, 120);
    this.ykL.jN(paramInt, paramInt);
    this.yox.setOpaque(false);
    this.ykS = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.ykM.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void al(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.k(this.yoG).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.d(this.yoG).getWidth(), StickerPreviewView.d(this.yoG).getHeight());
        StickerPreviewView.l(this.yoG).aG(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void bof()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.k(this.yoG).h(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void bog()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.k(this.yoG).h(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void bow()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.k(this.yoG).btb();
        StickerPreviewView.a(this.yoG, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.k(this.yoG)));
        AppMethodBeat.o(903);
      }
    });
    this.yoy.setOnClickListener(new StickerPreviewView..ExternalSyntheticLambda0(paramContext, this));
    this.yoz.setOnClickListener(new StickerPreviewView..ExternalSyntheticLambda1(this));
    paramContext = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.f.e)this.yoF);
    paramContext = new f();
    paramAttributeSet = com.tencent.mm.sticker.loader.e.acCJ;
    paramContext.buM(s.X(com.tencent.mm.sticker.loader.e.iWB(), "preview/"));
    paramAttributeSet = com.tencent.mm.sticker.loader.e.acCJ;
    paramContext.buO(s.X(com.tencent.mm.sticker.loader.e.iWB(), "preview/"));
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  private static final void a(Context paramContext, StickerPreviewView paramStickerPreviewView, final View paramView)
  {
    AppMethodBeat.i(269486);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramStickerPreviewView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    s.u(paramStickerPreviewView, "this$0");
    paramView = new com.google.android.material.bottomsheet.a(paramContext);
    paramContext = new StickerPreviewChangeMode(paramContext);
    paramContext.setBackgroundResource(a.e.yeh);
    paramContext.setOnModeSelected((kotlin.g.a.b)new a(paramStickerPreviewView, paramView));
    paramView.setContentView((View)paramContext);
    paramView.show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269486);
  }
  
  private static final void a(StickerPreviewView paramStickerPreviewView, View paramView)
  {
    AppMethodBeat.i(269488);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStickerPreviewView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStickerPreviewView, "this$0");
    com.tencent.mm.media.widget.camerarecordview.a.b(paramStickerPreviewView.ykS);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269488);
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramf, this));
    this.yox.H((kotlin.g.a.a)new e(this, paramf));
    AppMethodBeat.o(917);
  }
  
  public final boolean aGe()
  {
    AppMethodBeat.i(269577);
    s.u(this, "this");
    AppMethodBeat.o(269577);
    return false;
  }
  
  public final boolean bun()
  {
    AppMethodBeat.i(920);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).nFT;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean buo()
  {
    AppMethodBeat.i(269568);
    s.u(this, "this");
    AppMethodBeat.o(269568);
    return false;
  }
  
  public final boolean bup()
  {
    AppMethodBeat.i(269579);
    s.u(this, "this");
    AppMethodBeat.o(269579);
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.b getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.b)this.yox;
  }
  
  public final VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(927);
    VideoTransPara localVideoTransPara = com.tencent.mm.media.widget.camerarecordview.d.a.a.a(this);
    AppMethodBeat.o(927);
    return localVideoTransPara;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(922);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new f();
    AppMethodBeat.o(922);
    return locala;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return (com.tencent.mm.media.j.a)this.yoD;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(269573);
    s.u(this, "this");
    AppMethodBeat.o(269573);
    return null;
  }
  
  public final int getRecordScene()
  {
    return 10;
  }
  
  public final com.tencent.mm.media.widget.c.b getRecorder()
  {
    AppMethodBeat.i(269576);
    s.u(this, "this");
    AppMethodBeat.o(269576);
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(921);
    int i = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).mNl;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = j.KVJ.nLH;
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
    com.tencent.mm.media.widget.camerarecordview.a.a(this.ykS, this.ykT, null, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.lWL) / 2;
      paramInt2 = this.yoE;
      this.previewRect.set(paramInt1, paramInt2, this.lWL + paramInt1, this.lWL + paramInt2);
      n localn = this.yoD;
      Rect localRect = this.previewRect;
      s.u(localRect, "previewRect");
      localn.previewRect.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    s.u(paramString, "url");
    this.ykt = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.buT(paramString);
    AppMethodBeat.o(916);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    a(StickerPreviewView paramStickerPreviewView, com.google.android.material.bottomsheet.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.f.e<g>
  {
    c(StickerPreviewView paramStickerPreviewView) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(f paramf, StickerPreviewView paramStickerPreviewView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(StickerPreviewView paramStickerPreviewView, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int buc()
    {
      return 2;
    }
    
    public final String bud()
    {
      AppMethodBeat.i(915);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      localObject = d.a.dDK();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      localObject = d.a.dDJ();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */