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
import com.tencent.mm.media.widget.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.b.a.a;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.ui.b.n;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.au;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "bottomLine", "Landroid/support/constraint/Guideline;", "callback", "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiPreviewSize", "emojiPreviewTopMargin", "mode", "previewLayout", "Landroid/view/ViewGroup;", "previewRect", "Landroid/graphics/Rect;", "render", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "stickerUrl", "switchCamera", "Landroid/view/View;", "switchCameraIcon", "Landroid/widget/ImageView;", "switchMode", "switchModeIcon", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "useBackgroundCamera", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordScene", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "initCameraConfig", "onDestroy", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "setStickerUrl", "url", "useCpuCrop", "Companion", "plugin-emojicapture_release"})
public final class StickerPreviewView
  extends ConstraintLayout
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final StickerPreviewView.a rxh;
  private final String TAG;
  private final int gJc;
  private int mode;
  private final Rect previewRect;
  private final CameraFrontSightView rsV;
  private final MMSightCaptureTouchView rsW;
  private String rsz;
  public final com.tencent.mm.media.widget.camerarecordview.a rtc;
  private boolean rtd;
  private final FontAnimTextView rtk;
  private final CaptureStickerHint rtl;
  private final ViewGroup rwX;
  private final CameraPreviewGLTextureView rwY;
  private final View rwZ;
  private final View rxa;
  private final ImageView rxb;
  private final ImageView rxc;
  private final Guideline rxd;
  private n rxe;
  private final int rxf;
  public final b rxg;
  
  static
  {
    AppMethodBeat.i(926);
    rxh = new StickerPreviewView.a((byte)0);
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
    this.rxe = new n((byte)0);
    this.mode = 2;
    this.previewRect = new Rect();
    this.rsz = "";
    this.rxg = new b(this);
    View.inflate(paramContext, 2131496549, (ViewGroup)this);
    this.gJc = getResources().getDimensionPixelSize(2131166248);
    this.rxf = getResources().getDimensionPixelSize(2131165290);
    paramAttributeSet = findViewById(2131308424);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_layout)");
    this.rwX = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131308432);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_capture_view)");
    this.rwY = ((CameraPreviewGLTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308423);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_focus_frame)");
    this.rsV = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308431);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…eview_capture_touch_view)");
    this.rsW = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308428);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…view_capture_switch_mode)");
    this.rwZ = paramAttributeSet;
    paramAttributeSet = findViewById(2131308425);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…ew_capture_switch_camera)");
    this.rxa = paramAttributeSet;
    paramAttributeSet = findViewById(2131308429);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…capture_switch_mode_icon)");
    this.rxb = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308426);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticke…pture_switch_camera_icon)");
    this.rxc = ((ImageView)paramAttributeSet);
    c.a(this.rxc, 2131690502, -1);
    paramAttributeSet = findViewById(2131308442);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_switch_bottom)");
    this.rxd = ((Guideline)paramAttributeSet);
    this.rxd.setGuidelineEnd(au.aD(paramContext) + getResources().getDimensionPixelOffset(2131165303));
    paramAttributeSet = findViewById(2131308434);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_hint)");
    this.rtl = ((CaptureStickerHint)paramAttributeSet);
    paramAttributeSet = findViewById(2131308440);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.sticker_preview_subtitle)");
    this.rtk = ((FontAnimTextView)paramAttributeSet);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 120);
    this.rsV.hd(paramInt, paramInt);
    this.rwY.setOpaque(false);
    this.rtc = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)this);
    this.rsW.setTouchCallback((MMSightCaptureTouchView.a)new MMSightCaptureTouchView.a()
    {
      public final void I(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(902);
        StickerPreviewView.f(this.rxi).b(paramAnonymousFloat1, paramAnonymousFloat2, StickerPreviewView.g(this.rxi).getWidth(), StickerPreviewView.g(this.rxi).getHeight());
        StickerPreviewView.h(this.rxi).aa(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(902);
      }
      
      public final void bqQ()
      {
        AppMethodBeat.i(904);
        StickerPreviewView.f(this.rxi).i(true, 1);
        AppMethodBeat.o(904);
      }
      
      public final void bqR()
      {
        AppMethodBeat.i(905);
        StickerPreviewView.f(this.rxi).i(false, 1);
        AppMethodBeat.o(905);
      }
      
      public final void cJL()
      {
        AppMethodBeat.i(903);
        StickerPreviewView.f(this.rxi).aPq();
        StickerPreviewView.a(this.rxi, com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.rxi)));
        AppMethodBeat.o(903);
      }
    });
    this.rwZ.setOnClickListener((View.OnClickListener)new StickerPreviewView.2(this, paramContext));
    this.rxa.setOnClickListener((View.OnClickListener)new StickerPreviewView.3(this));
    paramContext = com.tencent.mm.sticker.loader.e.NNN;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.g.f)this.rxg);
    paramContext = new com.tencent.mm.sticker.f();
    paramAttributeSet = new StringBuilder();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.NNN;
    paramContext.bip(com.tencent.mm.sticker.loader.e.gyY() + "preview/");
    paramAttributeSet = new StringBuilder();
    locale = com.tencent.mm.sticker.loader.e.NNN;
    paramContext.bir(com.tencent.mm.sticker.loader.e.gyY() + "preview/");
    a(paramContext);
    AppMethodBeat.o(924);
  }
  
  public final boolean Zx()
  {
    return false;
  }
  
  public final void a(final com.tencent.mm.sticker.f paramf)
  {
    AppMethodBeat.i(917);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramf));
    this.rwY.j((kotlin.g.a.a)new d(this, paramf));
    AppMethodBeat.o(917);
  }
  
  public final boolean aQw()
  {
    AppMethodBeat.i(920);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).ilO;
    AppMethodBeat.o(920);
    return bool;
  }
  
  public final boolean aQx()
  {
    return false;
  }
  
  public final boolean aQy()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.e)this.rwY;
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
    return (com.tencent.mm.media.j.a)this.rxe;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    return null;
  }
  
  public final int getRecordScene()
  {
    return 10;
  }
  
  public final b getRecorder()
  {
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(921);
    int i = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.rnZ.aLT()).hzj;
    AppMethodBeat.o(921);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(923);
    VideoTransPara localVideoTransPara = k.zuy.irT;
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
    com.tencent.mm.media.widget.camerarecordview.a.a(this.rtc, this.rtd, null, 6);
    AppMethodBeat.o(918);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(919);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) && (paramInt1 > 0))
    {
      paramInt1 = (getWidth() - this.gJc) / 2;
      paramInt2 = this.rxf;
      this.previewRect.set(paramInt1, paramInt2, this.gJc + paramInt1, this.gJc + paramInt2);
      n localn = this.rxe;
      Rect localRect = this.previewRect;
      kotlin.g.b.p.h(localRect, "previewRect");
      localn.previewRect.set(localRect);
    }
    AppMethodBeat.o(919);
  }
  
  public final void setStickerUrl(String paramString)
  {
    AppMethodBeat.i(916);
    kotlin.g.b.p.h(paramString, "url");
    this.rsz = paramString;
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.NNN;
    com.tencent.mm.sticker.loader.e.biv(paramString);
    AppMethodBeat.o(916);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(StickerPreviewView paramStickerPreviewView, com.tencent.mm.sticker.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
  public static final class e
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aQm()
    {
      return 2;
    }
    
    public final String aQn()
    {
      AppMethodBeat.i(915);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
      localObject = d.a.cIL();
      AppMethodBeat.o(915);
      return localObject;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(914);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
      localObject = d.a.cIK();
      AppMethodBeat.o(914);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView
 * JD-Core Version:    0.7.0.1
 */