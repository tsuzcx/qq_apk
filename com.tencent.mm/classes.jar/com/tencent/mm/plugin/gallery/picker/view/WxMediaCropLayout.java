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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.cropview.BaseCropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.cropview.VideoTimeView;
import d.f;
import d.g;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.w;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "isPreviousVLog", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "vlogView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "getVlogView", "()Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "setVlogView", "(Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVLog", "onCalculateVisibilityRectCallback", "forceSet", "onPreviewVideo", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"})
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final WxMediaCropLayout.a sOu;
  public CommonVideoView mnn;
  public int oae;
  private final f sNO;
  private final f sNQ;
  private long sNS;
  private final LongSparseArray<b> sNU;
  private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> sNl;
  public VLogCompositionPlayView sOk;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b sOl;
  private final RectF sOm;
  private boolean sOn;
  private final f sOo;
  private WxCropOperationLayout.j sOp;
  private boolean sOq;
  private CropLayout.e sOr;
  private final int[] sOs;
  private long sOt;
  
  static
  {
    AppMethodBeat.i(165029);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(WxMediaCropLayout.class), "imageView", "getImageView()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bn(WxMediaCropLayout.class), "layout", "getLayout()Lcom/tencent/mm/ui/widget/cropview/CropLayout;")), (d.l.k)w.a(new u(w.bn(WxMediaCropLayout.class), "operationLayout", "getOperationLayout()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;")) };
    sOu = new WxMediaCropLayout.a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.sNU = new LongSparseArray();
    this.sNO = g.K((d.g.a.a)new e(this));
    this.sOm = new RectF();
    this.sNS = -1L;
    this.sNQ = g.K((d.g.a.a)new g(this));
    this.sOo = g.K((d.g.a.a)new j(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.sOp = WxCropOperationLayout.j.wzH;
    this.sOr = CropLayout.e.Jef;
    this.sNl = ((q)d.sOz);
    this.sOs = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.sNU = new LongSparseArray();
    this.sNO = g.K((d.g.a.a)new e(this));
    this.sOm = new RectF();
    this.sNS = -1L;
    this.sNQ = g.K((d.g.a.a)new g(this));
    this.sOo = g.K((d.g.a.a)new j(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.sOp = WxCropOperationLayout.j.wzH;
    this.sOr = CropLayout.e.Jef;
    this.sNl = ((q)d.sOz);
    this.sOs = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, final RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    ac.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.sOm + " path=" + paramString + " mediaType=" + paramInt3);
    this.sNS = paramLong;
    if (0L == this.sOt) {
      this.sOt = paramLong;
    }
    paramString = q(paramLong, paramString);
    if (paramInt3 != 3) {
      this.sOn = false;
    }
    if (vv(paramLong))
    {
      getOperationLayout().setStyle(this.sOp);
      if (!paramString.eY.isIdentity()) {
        paramRectF.set(this.sOm);
      }
      this.sOm.round(paramString.gUl);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new k(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.eY);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.eY, this.sOr, (d.g.a.b)new l(this, paramRectF, paramString));
      getLayout().setOnChangeListener((CropLayout.c)new m(this, paramString));
      paramView = this.sNU.get(paramLong);
      d.g.b.k.g(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.wzI);
      paramRectF.set(this.sOm);
      this.sOm.round(paramString.gUl);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.sNO.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(198524);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.sOo.getValue();
    AppMethodBeat.o(198524);
    return localWxCropOperationLayout;
  }
  
  private final b q(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.sNU.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.sNU.put(paramLong, paramString);
      this.sOm.round(paramString.gUl);
      if (this.sOn) {
        paramString.eY.reset();
      }
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.sNU.get(paramLong);
    if (this.sOn) {
      paramString.eY.reset();
    }
    d.g.b.k.g(paramString, "cropInfo");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(198525);
    this.sOp = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(198525);
  }
  
  private final boolean vv(long paramLong)
  {
    return (this.sOt == paramLong) || (this.sOt == 0L);
  }
  
  @SuppressLint({"ResourceType"})
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    d.g.b.k.h(paramString, "mediaPath");
    if ((paramLong == this.sNS) && (!paramBoolean1))
    {
      paramString = this.sNU.get(paramLong);
      d.g.b.k.g(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    ac.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().ya(true);
    getLayout().setEnableScale(true);
    Object localObject1 = c.sTV;
    localObject1 = c.aeB(paramString);
    if (this.mnn == null) {
      this.mnn = new CommonVideoView(getContext());
    }
    Object localObject2 = this.mnn;
    if (localObject2 != null)
    {
      if ((!(d.g.b.k.g(((CommonVideoView)localObject2).getTag(), paramString) ^ true)) && (!paramBoolean2)) {
        break label419;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).cDR();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(h.e.DnJ);
      ((CommonVideoView)localObject2).c(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.sOs[0] = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      this.sOs[1] = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
      localObject2 = new RectF(this.sOm);
      if (paramc != null) {
        paramc.a(this.sOs, (RectF)localObject2, true);
      }
      getOperationLayout().a(WxCropOperationLayout.h.wzy);
      getOperationLayout().a(WxCropOperationLayout.h.wzz);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.wzy);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.b)paramc);
      getOperationLayout().dwB();
      ac.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.mnn;
      if (paramc == null) {
        d.g.b.k.fOy();
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
    AppMethodBeat.i(198523);
    d.g.b.k.h(paramRectF, "initCropRect");
    d.g.b.k.h(paramj, "style");
    setStyle(paramj);
    this.sOm.set(paramRectF);
    AppMethodBeat.o(198523);
  }
  
  public final void cNt()
  {
    AppMethodBeat.i(198531);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(198531);
  }
  
  public final CropLayout.e getCropLayoutScaleType()
  {
    return this.sOr;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    b localb = (b)this.sNU.get(this.sNS);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = (WxMediaCropLayout)this;
      ac.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + ((WxMediaCropLayout)localObject).sNS);
      localObject = new b(((WxMediaCropLayout)localObject).sNS, "");
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.oae;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.sNQ.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.sOt;
  }
  
  public final int[] getMediaWH()
  {
    return this.sOs;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.sOl;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.mnn;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final VLogCompositionPlayView getVlogView()
  {
    return this.sOk;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(198529);
    ac.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.mnn != null)
    {
      localObject = this.mnn;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.sOk != null)
    {
      localObject = this.sOk;
      if (localObject != null) {
        ((VLogCompositionPlayView)localObject).pause();
      }
    }
    if (this.sOl != null)
    {
      localObject = this.sOl;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
        AppMethodBeat.o(198529);
        return;
      }
    }
    AppMethodBeat.o(198529);
  }
  
  public final void setCropLayoutScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(198526);
    d.g.b.k.h(parame, "value");
    this.sOr = parame;
    getLayout().setScaleType(parame);
    AppMethodBeat.o(198526);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.oae = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(198530);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(198530);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.sOt = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.sOl = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.sOq = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.mnn = paramCommonVideoView;
  }
  
  public final void setVlogView(VLogCompositionPlayView paramVLogCompositionPlayView)
  {
    this.sOk = paramVLogCompositionPlayView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"})
  public static final class b
  {
    float aNk;
    float aNl;
    public Matrix eY;
    public Rect gUl;
    private final String mediaPath;
    public final Rect pvE;
    private final long sKP;
    private Matrix sOv;
    Matrix sOw;
    public Rect sOx;
    float sOy;
    public Rect viewRect;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.sKP = paramLong;
      this.mediaPath = paramString;
      this.eY = new Matrix();
      this.sOv = new Matrix();
      this.sOw = new Matrix();
      this.gUl = new Rect();
      this.sOx = new Rect();
      this.viewRect = new Rect();
      this.pvE = new Rect();
      this.sOy = 1.0F;
      this.aNk = 1.0F;
      this.aNl = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final Matrix cNu()
    {
      AppMethodBeat.i(165013);
      this.sOv.set(this.eY);
      this.sOv.postTranslate(0.0F, -this.gUl.top);
      ac.d("WxMediaCropLayout", "matrix=" + this.eY + " cropMatrix=" + this.sOv + ' ' + this.gUl);
      Matrix localMatrix = this.sOv;
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
          if ((this.sKP != paramObject.sKP) || (!d.g.b.k.g(this.mediaPath, paramObject.mediaPath))) {}
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
      long l = this.sKP;
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
      String str = "CropInfo(mediaId=" + this.sKP + ", mediaPath=" + this.mediaPath + ")";
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF, boolean paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, y>
  {
    public static final d sOz;
    
    static
    {
      AppMethodBeat.i(198519);
      sOz = new d();
      AppMethodBeat.o(198519);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"})
  public static final class f
    implements BaseCropLayout.b
  {
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.sOB));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.sOB).am(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "outWidth", "", "outHeight", "invoke"})
  static final class h
    extends d.g.b.l
    implements m<Integer, Integer, WxMediaCropLayout.b>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(WxMediaCropLayout paramWxMediaCropLayout, ImageView paramImageView, WxMediaCropLayout.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198521);
      ac.i("WxMediaCropLayout", "[adaptResize] onClick..." + this.sOE.getTag());
      paramView = new RectF(WxMediaCropLayout.b(this.sOB));
      WxMediaCropLayout.c localc;
      if (d.g.b.k.g(this.sOE.getTag(), Boolean.TRUE))
      {
        this.sOE.setImageResource(2131691100);
        this.sOE.setTag(Boolean.FALSE);
        localc = this.sOF;
        if (localc != null) {
          localc.a(this.sOB.getMediaWH(), paramView, true);
        }
      }
      for (;;)
      {
        WxMediaCropLayout.d(this.sOB).a(paramView, true);
        WxMediaCropLayout.a(this.sOB).getVisibilityRect().set(paramView);
        WxMediaCropLayout.a(this.sOB).am(0, 500L);
        AppMethodBeat.o(198521);
        return;
        this.sOE.setImageResource(2131691099);
        this.sOE.setTag(Boolean.TRUE);
        localc = this.sOF;
        if (localc != null) {
          localc.a(this.sOB.getMediaWH(), paramView, false);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<WxCropOperationLayout>
  {
    j(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"})
  public static final class k
    implements WxCropOperationLayout.i
  {
    k(long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      d.g.b.k.h(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.sOB, paramLong)) {
        WxMediaCropLayout.b(this.sOB).set(paramRectF);
      }
      paramRectF.round(this.sOG.gUl);
      WxMediaCropLayout.d(this.sOB).g(paramRectF);
      AppMethodBeat.o(165025);
    }
    
    public final void mx(boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Matrix, Boolean>
  {
    l(WxMediaCropLayout paramWxMediaCropLayout, Matrix paramMatrix, WxMediaCropLayout.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"})
  public static final class m
    implements CropLayout.c
  {
    m(WxMediaCropLayout.b paramb) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      paramString.pvE.set(WxMediaCropLayout.d(this.sOB).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */