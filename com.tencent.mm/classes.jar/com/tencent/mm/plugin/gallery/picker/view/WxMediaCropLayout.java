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
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.h;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.BaseCropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.cropview.VideoTimeView;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVideo", "onCalculateVisibilityRectCallback", "forceSet", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"})
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final a BZt;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b AQa;
  private final f BYR;
  private final f BYT;
  private long BYV;
  private final LongSparseArray<b> BYX;
  private final kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> BYq;
  private final RectF BZm;
  private final f BZn;
  private WxCropOperationLayout.j BZo;
  private boolean BZp;
  private CropLayout.e BZq;
  private final int[] BZr;
  private long BZs;
  public CommonVideoView rhH;
  public int ttK;
  
  static
  {
    AppMethodBeat.i(165029);
    BZt = new a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.BYX = new LongSparseArray();
    this.BYR = g.ar((a)new e(this));
    this.BZm = new RectF();
    this.BYV = -1L;
    this.BYT = g.ar((a)new g(this));
    this.BZn = g.ar((a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.BZo = WxCropOperationLayout.j.HWx;
    this.BZq = CropLayout.e.Ylv;
    this.BYq = ((kotlin.g.a.q)d.BZy);
    this.BZr = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.BYX = new LongSparseArray();
    this.BYR = g.ar((a)new e(this));
    this.BZm = new RectF();
    this.BYV = -1L;
    this.BYT = g.ar((a)new g(this));
    this.BZn = g.ar((a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.BZo = WxCropOperationLayout.j.HWx;
    this.BZq = CropLayout.e.Ylv;
    this.BYq = ((kotlin.g.a.q)d.BZy);
    this.BZr = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final b C(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.BYX.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.BYX.put(paramLong, paramString);
      this.BZm.round(paramString.kXj);
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.BYX.get(paramLong);
    p.j(paramString, "cropInfo");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  private final boolean NJ(long paramLong)
  {
    return (this.BZs == paramLong) || (this.BZs == 0L);
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, final RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    Log.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.BZm + " path=" + paramString + " mediaType=" + paramInt3);
    this.BYV = paramLong;
    if (0L == this.BZs) {
      this.BZs = paramLong;
    }
    paramString = C(paramLong, paramString);
    if (NJ(paramLong))
    {
      getOperationLayout().setStyle(this.BZo);
      if (!paramString.aHZ.isIdentity()) {
        paramRectF.set(this.BZm);
      }
      this.BZm.round(paramString.kXj);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new j(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.aHZ);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.aHZ, this.BZq, (kotlin.g.a.b)new k(this, paramRectF, paramString));
      getLayout().setOnChangeListener((CropLayout.c)new l(this, paramString));
      paramView = this.BYX.get(paramLong);
      p.j(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.HWy);
      paramRectF.set(this.BZm);
      this.BZm.round(paramString.kXj);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.BYR.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(242138);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.BZn.getValue();
    AppMethodBeat.o(242138);
    return localWxCropOperationLayout;
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(242139);
    this.BZo = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(242139);
  }
  
  @SuppressLint({"ResourceType"})
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    p.k(paramString, "mediaPath");
    if ((paramLong == this.BYV) && (!paramBoolean1))
    {
      paramString = this.BYX.get(paramLong);
      p.j(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    Log.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().HA(true);
    getLayout().setEnableScale(true);
    Object localObject1 = d.CeY;
    localObject1 = d.aFG(paramString);
    if (this.rhH == null) {
      this.rhH = new CommonVideoView(getContext());
    }
    Object localObject2 = this.rhH;
    if (localObject2 != null)
    {
      if ((!(p.h(((CommonVideoView)localObject2).getTag(), paramString) ^ true)) && (!paramBoolean2)) {
        break label418;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).egX();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(i.e.RcG);
      ((CommonVideoView)localObject2).c(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.BZr[0] = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
      this.BZr[1] = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
      localObject2 = new RectF(this.BZm);
      if (paramc != null) {
        paramc.a(this.BZr, (RectF)localObject2);
      }
      getOperationLayout().a(WxCropOperationLayout.h.HWo);
      getOperationLayout().a(WxCropOperationLayout.h.HWp);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.HWo);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.b)paramc);
      getOperationLayout().fxY();
      Log.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.rhH;
      if (paramc == null) {
        p.iCn();
      }
      paramString = a((View)paramc, ((com.tencent.mm.plugin.sight.base.b)localObject1).width, ((com.tencent.mm.plugin.sight.base.b)localObject1).height, (RectF)localObject2, paramLong, paramString, 1);
      AppMethodBeat.o(165040);
      return paramString;
      label418:
      if (!((CommonVideoView)localObject2).isPlaying()) {
        ((CommonVideoView)localObject2).start();
      }
    }
  }
  
  public final void a(RectF paramRectF, WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(242136);
    p.k(paramRectF, "initCropRect");
    p.k(paramj, "style");
    setStyle(paramj);
    this.BZm.set(paramRectF);
    AppMethodBeat.o(242136);
  }
  
  public final void eul()
  {
    AppMethodBeat.i(242150);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(242150);
  }
  
  public final CropLayout.e getCropLayoutScaleType()
  {
    return this.BZq;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    b localb = (b)this.BYX.get(this.BYV);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = (WxMediaCropLayout)this;
      Log.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + ((WxMediaCropLayout)localObject).BYV);
      localObject = new b(((WxMediaCropLayout)localObject).BYV, "");
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.ttK;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.BYT.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.BZs;
  }
  
  public final int[] getMediaWH()
  {
    return this.BZr;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.AQa;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.rhH;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(242148);
    Log.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.rhH != null)
    {
      localObject = this.rhH;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.AQa != null)
    {
      localObject = this.AQa;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
        AppMethodBeat.o(242148);
        return;
      }
    }
    AppMethodBeat.o(242148);
  }
  
  public final void setCropLayoutScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(242141);
    p.k(parame, "value");
    this.BZq = parame;
    getLayout().setScaleType(parame);
    AppMethodBeat.o(242141);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.ttK = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(242149);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(242149);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.BZs = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.AQa = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.BZp = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.rhH = paramCommonVideoView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$Companion;", "", "()V", "MAXTARGETSIZE", "", "TAG", "", "TYPE_IMAGE", "TYPE_VIDEO", "plugin-gallery_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"})
  public static final class b
  {
    private final long BVT;
    private Matrix BZu;
    Matrix BZv;
    public Rect BZw;
    float BZx;
    float aGN;
    float aGO;
    public Matrix aHZ;
    public Rect kXj;
    private final String mediaPath;
    public final Rect vcr;
    public Rect viewRect;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.BVT = paramLong;
      this.mediaPath = paramString;
      this.aHZ = new Matrix();
      this.BZu = new Matrix();
      this.BZv = new Matrix();
      this.kXj = new Rect();
      this.BZw = new Rect();
      this.viewRect = new Rect();
      this.vcr = new Rect();
      this.BZx = 1.0F;
      this.aGN = 1.0F;
      this.aGO = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(165017);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.BVT != paramObject.BVT) || (!p.h(this.mediaPath, paramObject.mediaPath))) {}
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
    
    public final Matrix eum()
    {
      AppMethodBeat.i(165013);
      this.BZu.set(this.aHZ);
      this.BZu.postTranslate(0.0F, -this.kXj.top);
      Log.d("WxMediaCropLayout", "matrix=" + this.aHZ + " cropMatrix=" + this.BZu + ' ' + this.kXj);
      Matrix localMatrix = this.BZu;
      AppMethodBeat.o(165013);
      return localMatrix;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(165016);
      long l = this.BVT;
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
      String str = "CropInfo(mediaId=" + this.BVT + ", mediaPath=" + this.mediaPath + ")";
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x>
  {
    public static final d BZy;
    
    static
    {
      AppMethodBeat.i(244513);
      BZy = new d();
      AppMethodBeat.o(244513);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"})
  public static final class f
    implements BaseCropLayout.b
  {
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.BZA));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.BZA).aK(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "outWidth", "", "outHeight", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements m<Integer, Integer, WxMediaCropLayout.b>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements a<WxCropOperationLayout>
  {
    i(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    j(long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      p.k(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.BZA, paramLong)) {
        WxMediaCropLayout.b(this.BZA).set(paramRectF);
      }
      paramRectF.round(this.BZD.kXj);
      WxMediaCropLayout.d(this.BZA).b(paramRectF, false);
      AppMethodBeat.o(165025);
    }
    
    public final void rU(boolean paramBoolean) {}
    
    public final void rV(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    k(WxMediaCropLayout paramWxMediaCropLayout, Matrix paramMatrix, WxMediaCropLayout.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"})
  public static final class l
    implements CropLayout.c
  {
    l(WxMediaCropLayout.b paramb) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      paramString.vcr.set(WxMediaCropLayout.d(this.BZA).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */