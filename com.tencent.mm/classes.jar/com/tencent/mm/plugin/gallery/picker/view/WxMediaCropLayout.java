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
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVideo", "onCalculateVisibilityRectCallback", "forceSet", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"})
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final WxMediaCropLayout.a tVR;
  public CommonVideoView mST;
  public int oKa;
  private final d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> tUK;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b tVJ;
  private final RectF tVK;
  private final f tVL;
  private WxCropOperationLayout.j tVM;
  private boolean tVN;
  private CropLayout.e tVO;
  private final int[] tVP;
  private long tVQ;
  private final f tVn;
  private final f tVp;
  private long tVr;
  private final LongSparseArray<b> tVt;
  
  static
  {
    AppMethodBeat.i(165029);
    tVR = new WxMediaCropLayout.a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.tVt = new LongSparseArray();
    this.tVn = g.O((d.g.a.a)new e(this));
    this.tVK = new RectF();
    this.tVr = -1L;
    this.tVp = g.O((d.g.a.a)new g(this));
    this.tVL = g.O((d.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.tVM = WxCropOperationLayout.j.xYQ;
    this.tVO = CropLayout.e.LrL;
    this.tUK = ((d.g.a.q)WxMediaCropLayout.d.tVW);
    this.tVP = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.tVt = new LongSparseArray();
    this.tVn = g.O((d.g.a.a)new e(this));
    this.tVK = new RectF();
    this.tVr = -1L;
    this.tVp = g.O((d.g.a.a)new g(this));
    this.tVL = g.O((d.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.tVM = WxCropOperationLayout.j.xYQ;
    this.tVO = CropLayout.e.LrL;
    this.tUK = ((d.g.a.q)WxMediaCropLayout.d.tVW);
    this.tVP = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, final RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    ae.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.tVK + " path=" + paramString + " mediaType=" + paramInt3);
    this.tVr = paramLong;
    if (0L == this.tVQ) {
      this.tVQ = paramLong;
    }
    paramString = r(paramLong, paramString);
    if (xV(paramLong))
    {
      getOperationLayout().setStyle(this.tVM);
      if (!paramString.gR.isIdentity()) {
        paramRectF.set(this.tVK);
      }
      this.tVK.round(paramString.hpa);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new j(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.gR);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.gR, this.tVO, (d.g.a.b)new k(this, paramRectF, paramString));
      getLayout().setOnChangeListener((CropLayout.c)new l(this, paramString));
      paramView = this.tVt.get(paramLong);
      p.g(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.xYR);
      paramRectF.set(this.tVK);
      this.tVK.round(paramString.hpa);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.tVn.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(186295);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.tVL.getValue();
    AppMethodBeat.o(186295);
    return localWxCropOperationLayout;
  }
  
  private final b r(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.tVt.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.tVt.put(paramLong, paramString);
      this.tVK.round(paramString.hpa);
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.tVt.get(paramLong);
    p.g(paramString, "cropInfo");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(186296);
    this.tVM = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(186296);
  }
  
  private final boolean xV(long paramLong)
  {
    return (this.tVQ == paramLong) || (this.tVQ == 0L);
  }
  
  @SuppressLint({"ResourceType"})
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    p.h(paramString, "mediaPath");
    if ((paramLong == this.tVr) && (!paramBoolean1))
    {
      paramString = this.tVt.get(paramLong);
      p.g(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    ae.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().za(true);
    getLayout().setEnableScale(true);
    Object localObject1 = c.ubl;
    localObject1 = c.ajS(paramString);
    if (this.mST == null) {
      this.mST = new CommonVideoView(getContext());
    }
    Object localObject2 = this.mST;
    if (localObject2 != null)
    {
      if ((!(p.i(((CommonVideoView)localObject2).getTag(), paramString) ^ true)) && (!paramBoolean2)) {
        break label418;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).cOS();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(i.e.Flj);
      ((CommonVideoView)localObject2).c(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.tVP[0] = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      this.tVP[1] = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
      localObject2 = new RectF(this.tVK);
      if (paramc != null) {
        paramc.a(this.tVP, (RectF)localObject2);
      }
      getOperationLayout().a(WxCropOperationLayout.h.xYH);
      getOperationLayout().a(WxCropOperationLayout.h.xYI);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.xYH);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.b)paramc);
      getOperationLayout().dKE();
      ae.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.mST;
      if (paramc == null) {
        p.gkB();
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
    AppMethodBeat.i(186294);
    p.h(paramRectF, "initCropRect");
    p.h(paramj, "style");
    setStyle(paramj);
    this.tVK.set(paramRectF);
    AppMethodBeat.o(186294);
  }
  
  public final void cYq()
  {
    AppMethodBeat.i(186301);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(186301);
  }
  
  public final CropLayout.e getCropLayoutScaleType()
  {
    return this.tVO;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    b localb = (b)this.tVt.get(this.tVr);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = (WxMediaCropLayout)this;
      ae.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + ((WxMediaCropLayout)localObject).tVr);
      localObject = new b(((WxMediaCropLayout)localObject).tVr, "");
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.oKa;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.tVp.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.tVQ;
  }
  
  public final int[] getMediaWH()
  {
    return this.tVP;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.tVJ;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.mST;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(186299);
    ae.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.mST != null)
    {
      localObject = this.mST;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.tVJ != null)
    {
      localObject = this.tVJ;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
        AppMethodBeat.o(186299);
        return;
      }
    }
    AppMethodBeat.o(186299);
  }
  
  public final void setCropLayoutScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(186297);
    p.h(parame, "value");
    this.tVO = parame;
    getLayout().setScaleType(parame);
    AppMethodBeat.o(186297);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.oKa = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(186300);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(186300);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.tVQ = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.tVJ = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.tVN = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.mST = paramCommonVideoView;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"})
  public static final class b
  {
    float aXE;
    float aXF;
    public Matrix gR;
    public Rect hpa;
    private final String mediaPath;
    public final Rect qfO;
    private final long tSr;
    private Matrix tVS;
    Matrix tVT;
    public Rect tVU;
    float tVV;
    public Rect viewRect;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.tSr = paramLong;
      this.mediaPath = paramString;
      this.gR = new Matrix();
      this.tVS = new Matrix();
      this.tVT = new Matrix();
      this.hpa = new Rect();
      this.tVU = new Rect();
      this.viewRect = new Rect();
      this.qfO = new Rect();
      this.tVV = 1.0F;
      this.aXE = 1.0F;
      this.aXF = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final Matrix cYr()
    {
      AppMethodBeat.i(165013);
      this.tVS.set(this.gR);
      this.tVS.postTranslate(0.0F, -this.hpa.top);
      ae.d("WxMediaCropLayout", "matrix=" + this.gR + " cropMatrix=" + this.tVS + ' ' + this.hpa);
      Matrix localMatrix = this.tVS;
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
          if ((this.tSr != paramObject.tSr) || (!p.i(this.mediaPath, paramObject.mediaPath))) {}
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
      long l = this.tSr;
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
      String str = "CropInfo(mediaId=" + this.tSr + ", mediaPath=" + this.mediaPath + ")";
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"})
  public static final class f
    implements BaseCropLayout.b
  {
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.tVY));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.tVY).ar(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "outWidth", "", "outHeight", "invoke"})
  static final class h
    extends d.g.b.q
    implements m<Integer, Integer, WxMediaCropLayout.b>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<WxCropOperationLayout>
  {
    i(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    j(long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      p.h(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.tVY, paramLong)) {
        WxMediaCropLayout.b(this.tVY).set(paramRectF);
      }
      paramRectF.round(this.tWb.hpa);
      WxMediaCropLayout.d(this.tVY).i(paramRectF);
      AppMethodBeat.o(165025);
    }
    
    public final void mS(boolean paramBoolean) {}
    
    public final void mT(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.b<Matrix, Boolean>
  {
    k(WxMediaCropLayout paramWxMediaCropLayout, Matrix paramMatrix, WxMediaCropLayout.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"})
  public static final class l
    implements CropLayout.c
  {
    l(WxMediaCropLayout.b paramb) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      paramString.qfO.set(WxMediaCropLayout.d(this.tVY).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */