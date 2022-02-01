package com.tencent.mm.plugin.gallery.picker.view;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.h;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.BaseCropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.cropview.VideoTimeView;
import d.f;
import d.g;
import d.g.a.m;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVideo", "onCalculateVisibilityRectCallback", "forceSet", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"})
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final WxMediaCropLayout.a tLa;
  public CommonVideoView mNP;
  public int oDy;
  private final d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> tJT;
  private long tKA;
  private final LongSparseArray<b> tKC;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b tKS;
  private final RectF tKT;
  private final f tKU;
  private WxCropOperationLayout.j tKV;
  private boolean tKW;
  private CropLayout.e tKX;
  private final int[] tKY;
  private long tKZ;
  private final f tKw;
  private final f tKy;
  
  static
  {
    AppMethodBeat.i(165029);
    tLa = new WxMediaCropLayout.a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.tKC = new LongSparseArray();
    this.tKw = g.O((d.g.a.a)new e(this));
    this.tKT = new RectF();
    this.tKA = -1L;
    this.tKy = g.O((d.g.a.a)new g(this));
    this.tKU = g.O((d.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.tKV = WxCropOperationLayout.j.xIV;
    this.tKX = CropLayout.e.KVn;
    this.tJT = ((d.g.a.q)WxMediaCropLayout.d.tLf);
    this.tKY = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.tKC = new LongSparseArray();
    this.tKw = g.O((d.g.a.a)new e(this));
    this.tKT = new RectF();
    this.tKA = -1L;
    this.tKy = g.O((d.g.a.a)new g(this));
    this.tKU = g.O((d.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.tKV = WxCropOperationLayout.j.xIV;
    this.tKX = CropLayout.e.KVn;
    this.tJT = ((d.g.a.q)WxMediaCropLayout.d.tLf);
    this.tKY = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, final RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    ad.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.tKT + " path=" + paramString + " mediaType=" + paramInt3);
    this.tKA = paramLong;
    if (0L == this.tKZ) {
      this.tKZ = paramLong;
    }
    paramString = r(paramLong, paramString);
    if (xB(paramLong))
    {
      getOperationLayout().setStyle(this.tKV);
      if (!paramString.gR.isIdentity()) {
        paramRectF.set(this.tKT);
      }
      this.tKT.round(paramString.hmm);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new j(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.gR);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.gR, this.tKX, (d.g.a.b)new k(this, paramRectF, paramString));
      getLayout().setOnChangeListener((CropLayout.c)new l(this, paramString));
      paramView = this.tKC.get(paramLong);
      p.g(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.xIW);
      paramRectF.set(this.tKT);
      this.tKT.round(paramString.hmm);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.tKw.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(198885);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.tKU.getValue();
    AppMethodBeat.o(198885);
    return localWxCropOperationLayout;
  }
  
  private final b r(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.tKC.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.tKC.put(paramLong, paramString);
      this.tKT.round(paramString.hmm);
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.tKC.get(paramLong);
    p.g(paramString, "cropInfo");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(198886);
    this.tKV = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(198886);
  }
  
  private final boolean xB(long paramLong)
  {
    return (this.tKZ == paramLong) || (this.tKZ == 0L);
  }
  
  @SuppressLint({"ResourceType"})
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    p.h(paramString, "mediaPath");
    if ((paramLong == this.tKA) && (!paramBoolean1))
    {
      paramString = this.tKC.get(paramLong);
      p.g(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    ad.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().yM(true);
    getLayout().setEnableScale(true);
    Object localObject1 = c.tQu;
    localObject1 = c.aiV(paramString);
    if (this.mNP == null) {
      this.mNP = new CommonVideoView(getContext());
    }
    Object localObject2 = this.mNP;
    if (localObject2 != null)
    {
      if ((!(p.i(((CommonVideoView)localObject2).getTag(), paramString) ^ true)) && (!paramBoolean2)) {
        break label418;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).cMk();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(i.e.ESO);
      ((CommonVideoView)localObject2).c(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.tKY[0] = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      this.tKY[1] = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
      localObject2 = new RectF(this.tKT);
      if (paramc != null) {
        paramc.a(this.tKY, (RectF)localObject2);
      }
      getOperationLayout().a(WxCropOperationLayout.h.xIM);
      getOperationLayout().a(WxCropOperationLayout.h.xIN);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.xIM);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.b)paramc);
      getOperationLayout().dHn();
      ad.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.mNP;
      if (paramc == null) {
        p.gfZ();
      }
      paramString = a((View)paramc, ((com.tencent.mm.plugin.sight.base.a)localObject1).width, ((com.tencent.mm.plugin.sight.base.a)localObject1).height, (RectF)localObject2, paramLong, paramString, 1);
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
    AppMethodBeat.i(198884);
    p.h(paramRectF, "initCropRect");
    p.h(paramj, "style");
    setStyle(paramj);
    this.tKT.set(paramRectF);
    AppMethodBeat.o(198884);
  }
  
  public final void cVL()
  {
    AppMethodBeat.i(198891);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(198891);
  }
  
  public final CropLayout.e getCropLayoutScaleType()
  {
    return this.tKX;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    b localb = (b)this.tKC.get(this.tKA);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = (WxMediaCropLayout)this;
      ad.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + ((WxMediaCropLayout)localObject).tKA);
      localObject = new b(((WxMediaCropLayout)localObject).tKA, "");
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.oDy;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.tKy.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.tKZ;
  }
  
  public final int[] getMediaWH()
  {
    return this.tKY;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.tKS;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.mNP;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(198889);
    ad.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.mNP != null)
    {
      localObject = this.mNP;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.tKS != null)
    {
      localObject = this.tKS;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
        AppMethodBeat.o(198889);
        return;
      }
    }
    AppMethodBeat.o(198889);
  }
  
  public final void setCropLayoutScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(198887);
    p.h(parame, "value");
    this.tKX = parame;
    getLayout().setScaleType(parame);
    AppMethodBeat.o(198887);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.oDy = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(198890);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(198890);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.tKZ = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.tKS = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.tKW = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.mNP = paramCommonVideoView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"})
  public static final class b
  {
    float aXE;
    float aXF;
    public Matrix gR;
    public Rect hmm;
    private final String mediaPath;
    public final Rect pZj;
    private final long tHA;
    private Matrix tLb;
    Matrix tLc;
    public Rect tLd;
    float tLe;
    public Rect viewRect;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.tHA = paramLong;
      this.mediaPath = paramString;
      this.gR = new Matrix();
      this.tLb = new Matrix();
      this.tLc = new Matrix();
      this.hmm = new Rect();
      this.tLd = new Rect();
      this.viewRect = new Rect();
      this.pZj = new Rect();
      this.tLe = 1.0F;
      this.aXE = 1.0F;
      this.aXF = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final Matrix cVM()
    {
      AppMethodBeat.i(165013);
      this.tLb.set(this.gR);
      this.tLb.postTranslate(0.0F, -this.hmm.top);
      ad.d("WxMediaCropLayout", "matrix=" + this.gR + " cropMatrix=" + this.tLb + ' ' + this.hmm);
      Matrix localMatrix = this.tLb;
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
          if ((this.tHA != paramObject.tHA) || (!p.i(this.mediaPath, paramObject.mediaPath))) {}
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
      long l = this.tHA;
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
      String str = "CropInfo(mediaId=" + this.tHA + ", mediaPath=" + this.mediaPath + ")";
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"})
  public static final class f
    implements BaseCropLayout.b
  {
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.tLh));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.tLh).ar(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "outWidth", "", "outHeight", "invoke"})
  static final class h
    extends d.g.b.q
    implements m<Integer, Integer, WxMediaCropLayout.b>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<WxCropOperationLayout>
  {
    i(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    j(long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      p.h(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.tLh, paramLong)) {
        WxMediaCropLayout.b(this.tLh).set(paramRectF);
      }
      paramRectF.round(this.tLk.hmm);
      WxMediaCropLayout.d(this.tLh).i(paramRectF);
      AppMethodBeat.o(165025);
    }
    
    public final void mO(boolean paramBoolean) {}
    
    public final void mP(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.b<Matrix, Boolean>
  {
    k(WxMediaCropLayout paramWxMediaCropLayout, Matrix paramMatrix, WxMediaCropLayout.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"})
  public static final class l
    implements CropLayout.c
  {
    l(WxMediaCropLayout.b paramb) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      paramString.pZj.set(WxMediaCropLayout.d(this.tLh).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */