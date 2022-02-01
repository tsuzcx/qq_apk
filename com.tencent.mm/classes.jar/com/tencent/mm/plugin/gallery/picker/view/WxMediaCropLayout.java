package com.tencent.mm.plugin.gallery.picker.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.h;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.BaseCropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.VideoTimeView;
import d.f;
import d.g;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.w;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "isPreviousVLog", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "vlogView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "getVlogView", "()Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "setVlogView", "(Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVLog", "onCalculateVisibilityRectCallback", "forceSet", "onPreviewVideo", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"})
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final a rGH;
  public VLogCompositionPlayView Lmo;
  private boolean Lmp;
  private WxCropOperationLayout.j Lmq;
  public CommonVideoView lLq;
  public int nxe;
  private final f rEW;
  private final f rEY;
  private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> rEt;
  private long rFa;
  private final LongSparseArray<b> rFc;
  private final RectF rGB;
  private final f rGC;
  private boolean rGD;
  private CropLayout.c rGE;
  private final int[] rGF;
  private long rGG;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b vmF;
  
  static
  {
    AppMethodBeat.i(165029);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(WxMediaCropLayout.class), "imageView", "getImageView()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bk(WxMediaCropLayout.class), "layout", "getLayout()Lcom/tencent/mm/ui/widget/cropview/CropLayout;")), (d.l.k)w.a(new u(w.bk(WxMediaCropLayout.class), "operationLayout", "getOperationLayout()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;")) };
    rGH = new a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.rFc = new LongSparseArray();
    this.rEW = g.E((d.g.a.a)new e(this));
    this.rGB = new RectF();
    this.rFa = -1L;
    this.rEY = g.E((d.g.a.a)new g(this));
    this.rGC = g.E((d.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.Lmq = WxCropOperationLayout.j.LpK;
    this.rGE = CropLayout.c.HDI;
    this.rEt = ((q)d.rGM);
    this.rGF = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.rFc = new LongSparseArray();
    this.rEW = g.E((d.g.a.a)new e(this));
    this.rGB = new RectF();
    this.rFa = -1L;
    this.rEY = g.E((d.g.a.a)new g(this));
    this.rGC = g.E((d.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.Lmq = WxCropOperationLayout.j.LpK;
    this.rGE = CropLayout.c.HDI;
    this.rEt = ((q)d.rGM);
    this.rGF = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, final RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    ad.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.rGB + " path=" + paramString + " mediaType=" + paramInt3);
    this.rFa = paramLong;
    if (0L == this.rGG) {
      this.rGG = paramLong;
    }
    paramString = s(paramLong, paramString);
    if (paramInt3 != 3) {
      this.Lmp = false;
    }
    if (qS(paramLong))
    {
      getOperationLayout().setStyle(this.Lmq);
      if (!paramString.dY.isIdentity()) {
        paramRectF.set(this.rGB);
      }
      this.rGB.round(paramString.gtE);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new j(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.dY);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.dY, this.rGE, (d.g.a.b)new k(this, paramRectF, paramString));
      getLayout().setOnChangeListener((CropLayout.b)new l(this, paramString));
      paramView = this.rFc.get(paramLong);
      d.g.b.k.g(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.LpL);
      paramRectF.set(this.rGB);
      this.rGB.round(paramString.gtE);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.rEW.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(200790);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.rGC.getValue();
    AppMethodBeat.o(200790);
    return localWxCropOperationLayout;
  }
  
  private final boolean qS(long paramLong)
  {
    return (this.rGG == paramLong) || (this.rGG == 0L);
  }
  
  private final b s(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.rFc.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.rFc.put(paramLong, paramString);
      this.rGB.round(paramString.gtE);
      if (this.Lmp) {
        paramString.dY.reset();
      }
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.rFc.get(paramLong);
    if (this.Lmp) {
      paramString.dY.reset();
    }
    d.g.b.k.g(paramString, "cropInfo");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(200791);
    this.Lmq = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(200791);
  }
  
  @SuppressLint({"ResourceType"})
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    d.g.b.k.h(paramString, "mediaPath");
    if ((paramLong == this.rFa) && (!paramBoolean1))
    {
      paramString = this.rFc.get(paramLong);
      d.g.b.k.g(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    ad.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().wS(true);
    getLayout().setEnableScale(true);
    Object localObject1 = c.rMg;
    localObject1 = c.ZP(paramString);
    if (this.lLq == null) {
      this.lLq = new CommonVideoView(getContext());
    }
    Object localObject2 = this.lLq;
    if (localObject2 != null)
    {
      if ((!(d.g.b.k.g(((CommonVideoView)localObject2).getTag(), paramString) ^ true)) && (!paramBoolean2)) {
        break label419;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).cCC();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(h.e.BVs);
      ((CommonVideoView)localObject2).c(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.rGF[0] = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      this.rGF[1] = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
      localObject2 = new RectF(this.rGB);
      if (paramc != null) {
        paramc.a(this.rGF, (RectF)localObject2, true);
      }
      getOperationLayout().a(WxCropOperationLayout.h.LpB);
      getOperationLayout().a(WxCropOperationLayout.h.LpC);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.LpB);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.b)paramc);
      getOperationLayout().fYr();
      ad.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.lLq;
      if (paramc == null) {
        d.g.b.k.fvU();
      }
      paramString = a((View)paramc, ((com.tencent.mm.plugin.sight.base.a)localObject1).width, ((com.tencent.mm.plugin.sight.base.a)localObject1).height, (RectF)localObject2, paramLong, paramString, 1);
      AppMethodBeat.o(165040);
      return paramString;
      label419:
      if (!((CommonVideoView)localObject2).isPlaying()) {
        ((CommonVideoView)localObject2).start();
      }
    }
  }
  
  public final void a(RectF paramRectF, WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(200789);
    d.g.b.k.h(paramRectF, "initCropRect");
    d.g.b.k.h(paramj, "style");
    setStyle(paramj);
    this.rGB.set(paramRectF);
    AppMethodBeat.o(200789);
  }
  
  public final void cAk()
  {
    AppMethodBeat.i(186822);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(186822);
  }
  
  public final CropLayout.c getCropLayoutScaleType()
  {
    return this.rGE;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    b localb = (b)this.rFc.get(this.rFa);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = (WxMediaCropLayout)this;
      ad.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + ((WxMediaCropLayout)localObject).rFa);
      localObject = new b(((WxMediaCropLayout)localObject).rFa, "");
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.nxe;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.rEY.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.rGG;
  }
  
  public final int[] getMediaWH()
  {
    return this.rGF;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.vmF;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.lLq;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final VLogCompositionPlayView getVlogView()
  {
    return this.Lmo;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(200793);
    ad.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.lLq != null)
    {
      localObject = this.lLq;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.Lmo != null)
    {
      localObject = this.Lmo;
      if (localObject != null) {
        ((VLogCompositionPlayView)localObject).pause();
      }
    }
    if (this.vmF != null)
    {
      localObject = this.vmF;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
        AppMethodBeat.o(200793);
        return;
      }
    }
    AppMethodBeat.o(200793);
  }
  
  public final void setCropLayoutScaleType(CropLayout.c paramc)
  {
    AppMethodBeat.i(186819);
    d.g.b.k.h(paramc, "value");
    this.rGE = paramc;
    getLayout().setScaleType(paramc);
    AppMethodBeat.o(186819);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.nxe = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(186821);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(186821);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.rGG = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.vmF = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.rGD = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.lLq = paramCommonVideoView;
  }
  
  public final void setVlogView(VLogCompositionPlayView paramVLogCompositionPlayView)
  {
    this.Lmo = paramVLogCompositionPlayView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$Companion;", "", "()V", "MAXTARGETSIZE", "", "TAG", "", "TYPE_IMAGE", "TYPE_VIDEO", "TYPE_VLOG", "plugin-gallery_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"})
  public static final class b
  {
    float aMu;
    float aMv;
    public Matrix dY;
    public Rect gtE;
    private final String mediaPath;
    public final Rect oSt;
    private final long rBW;
    private Matrix rGI;
    Matrix rGJ;
    public Rect rGK;
    float rGL;
    public Rect viewRect;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.rBW = paramLong;
      this.mediaPath = paramString;
      this.dY = new Matrix();
      this.rGI = new Matrix();
      this.rGJ = new Matrix();
      this.gtE = new Rect();
      this.rGK = new Rect();
      this.viewRect = new Rect();
      this.oSt = new Rect();
      this.rGL = 1.0F;
      this.aMu = 1.0F;
      this.aMv = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final Matrix cAl()
    {
      AppMethodBeat.i(165013);
      this.rGI.set(this.dY);
      this.rGI.postTranslate(0.0F, -this.gtE.top);
      ad.d("WxMediaCropLayout", "matrix=" + this.dY + " cropMatrix=" + this.rGI + ' ' + this.gtE);
      Matrix localMatrix = this.rGI;
      AppMethodBeat.o(165013);
      return localMatrix;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(165017);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.rBW != paramObject.rBW) || (!d.g.b.k.g(this.mediaPath, paramObject.mediaPath))) {}
        }
      }
      else
      {
        AppMethodBeat.o(165017);
        return true;
      }
      AppMethodBeat.o(165017);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(165016);
      long l = this.rBW;
      int j = (int)(l ^ l >>> 32);
      String str = this.mediaPath;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(165016);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(165015);
      String str = "CropInfo(mediaId=" + this.rBW + ", mediaPath=" + this.mediaPath + ")";
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF, boolean paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, y>
  {
    public static final d rGM;
    
    static
    {
      AppMethodBeat.i(186817);
      rGM = new d();
      AppMethodBeat.o(186817);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"})
  public static final class f
    implements BaseCropLayout.b
  {
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.rGO));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.rGO).ah(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "outWidth", "", "outHeight", "invoke"})
  static final class h
    extends d.g.b.l
    implements m<Integer, Integer, WxMediaCropLayout.b>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<WxCropOperationLayout>
  {
    i(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    j(long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      d.g.b.k.h(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.rGO, paramLong)) {
        WxMediaCropLayout.b(this.rGO).set(paramRectF);
      }
      paramRectF.round(this.rGR.gtE);
      WxMediaCropLayout.d(this.rGO).g(paramRectF);
      AppMethodBeat.o(165025);
    }
    
    public final void yV(boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.b<Matrix, Boolean>
  {
    k(WxMediaCropLayout paramWxMediaCropLayout, Matrix paramMatrix, WxMediaCropLayout.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"})
  public static final class l
    implements CropLayout.b
  {
    l(WxMediaCropLayout.b paramb) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      paramString.oSt.set(WxMediaCropLayout.d(this.rGO).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(WxMediaCropLayout paramWxMediaCropLayout, ImageView paramImageView, WxMediaCropLayout.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200787);
      ad.i("WxMediaCropLayout", "[adaptResize] onClick..." + this.Lmr.getTag());
      paramView = new RectF(WxMediaCropLayout.b(this.rGO));
      WxMediaCropLayout.c localc;
      if (d.g.b.k.g(this.Lmr.getTag(), Boolean.TRUE))
      {
        this.Lmr.setImageResource(2131691100);
        this.Lmr.setTag(Boolean.FALSE);
        localc = this.Lms;
        if (localc != null) {
          localc.a(this.rGO.getMediaWH(), paramView, true);
        }
      }
      for (;;)
      {
        WxMediaCropLayout.d(this.rGO).a(paramView, true);
        WxMediaCropLayout.a(this.rGO).getVisibilityRect().set(paramView);
        WxMediaCropLayout.a(this.rGO).ah(0, 500L);
        AppMethodBeat.o(200787);
        return;
        this.Lmr.setImageResource(2131691099);
        this.Lmr.setTag(Boolean.TRUE);
        localc = this.Lms;
        if (localc != null) {
          localc.a(this.rGO.getMediaWH(), paramView, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */