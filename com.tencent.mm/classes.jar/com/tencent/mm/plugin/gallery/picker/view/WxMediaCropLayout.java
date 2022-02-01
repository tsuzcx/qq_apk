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
import com.tencent.mm.plugin.gallery.a.c;
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
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVideo", "onCalculateVisibilityRectCallback", "forceSet", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"})
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final a xnb;
  public CommonVideoView ofW;
  public int pXO;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b wgF;
  private final kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> xlW;
  private final f xmB;
  private long xmD;
  private final LongSparseArray<b> xmF;
  private final RectF xmU;
  private final f xmV;
  private WxCropOperationLayout.j xmW;
  private boolean xmX;
  private CropLayout.e xmY;
  private final int[] xmZ;
  private final f xmz;
  private long xna;
  
  static
  {
    AppMethodBeat.i(165029);
    xnb = new a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.xmF = new LongSparseArray();
    this.xmz = g.ah((kotlin.g.a.a)new e(this));
    this.xmU = new RectF();
    this.xmD = -1L;
    this.xmB = g.ah((kotlin.g.a.a)new g(this));
    this.xmV = g.ah((kotlin.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.xmW = WxCropOperationLayout.j.BZI;
    this.xmY = CropLayout.e.QMD;
    this.xlW = ((kotlin.g.a.q)d.xng);
    this.xmZ = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.xmF = new LongSparseArray();
    this.xmz = g.ah((kotlin.g.a.a)new e(this));
    this.xmU = new RectF();
    this.xmD = -1L;
    this.xmB = g.ah((kotlin.g.a.a)new g(this));
    this.xmV = g.ah((kotlin.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.xmW = WxCropOperationLayout.j.BZI;
    this.xmY = CropLayout.e.QMD;
    this.xlW = ((kotlin.g.a.q)d.xng);
    this.xmZ = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final boolean GF(long paramLong)
  {
    return (this.xna == paramLong) || (this.xna == 0L);
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, final RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    Log.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.xmU + " path=" + paramString + " mediaType=" + paramInt3);
    this.xmD = paramLong;
    if (0L == this.xna) {
      this.xna = paramLong;
    }
    paramString = v(paramLong, paramString);
    if (GF(paramLong))
    {
      getOperationLayout().setStyle(this.xmW);
      if (!paramString.gT.isIdentity()) {
        paramRectF.set(this.xmU);
      }
      this.xmU.round(paramString.iiw);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new j(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.gT);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.gT, this.xmY, (kotlin.g.a.b)new k(this, paramRectF, paramString));
      getLayout().setOnChangeListener((CropLayout.c)new l(this, paramString));
      paramView = this.xmF.get(paramLong);
      p.g(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.BZJ);
      paramRectF.set(this.xmU);
      this.xmU.round(paramString.iiw);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.xmz.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(257861);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.xmV.getValue();
    AppMethodBeat.o(257861);
    return localWxCropOperationLayout;
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(257862);
    this.xmW = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(257862);
  }
  
  private final b v(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.xmF.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.xmF.put(paramLong, paramString);
      this.xmU.round(paramString.iiw);
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.xmF.get(paramLong);
    p.g(paramString, "cropInfo");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  @SuppressLint({"ResourceType"})
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    p.h(paramString, "mediaPath");
    if ((paramLong == this.xmD) && (!paramBoolean1))
    {
      paramString = this.xmF.get(paramLong);
      p.g(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    Log.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().De(true);
    getLayout().setEnableScale(true);
    Object localObject1 = c.xsz;
    localObject1 = c.awl(paramString);
    if (this.ofW == null) {
      this.ofW = new CommonVideoView(getContext());
    }
    Object localObject2 = this.ofW;
    if (localObject2 != null)
    {
      if ((!(p.j(((CommonVideoView)localObject2).getTag(), paramString) ^ true)) && (!paramBoolean2)) {
        break label418;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).dFl();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(i.e.Kcb);
      ((CommonVideoView)localObject2).c(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.xmZ[0] = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      this.xmZ[1] = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
      localObject2 = new RectF(this.xmU);
      if (paramc != null) {
        paramc.a(this.xmZ, (RectF)localObject2);
      }
      getOperationLayout().a(WxCropOperationLayout.h.BZz);
      getOperationLayout().a(WxCropOperationLayout.h.BZA);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.BZz);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.b)paramc);
      getOperationLayout().eLD();
      Log.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.ofW;
      if (paramc == null) {
        p.hyc();
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
    AppMethodBeat.i(257860);
    p.h(paramRectF, "initCropRect");
    p.h(paramj, "style");
    setStyle(paramj);
    this.xmU.set(paramRectF);
    AppMethodBeat.o(257860);
  }
  
  public final void dRJ()
  {
    AppMethodBeat.i(257867);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(257867);
  }
  
  public final CropLayout.e getCropLayoutScaleType()
  {
    return this.xmY;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    b localb = (b)this.xmF.get(this.xmD);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = (WxMediaCropLayout)this;
      Log.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + ((WxMediaCropLayout)localObject).xmD);
      localObject = new b(((WxMediaCropLayout)localObject).xmD, "");
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.pXO;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.xmB.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.xna;
  }
  
  public final int[] getMediaWH()
  {
    return this.xmZ;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.wgF;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.ofW;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(257865);
    Log.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.ofW != null)
    {
      localObject = this.ofW;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.wgF != null)
    {
      localObject = this.wgF;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
        AppMethodBeat.o(257865);
        return;
      }
    }
    AppMethodBeat.o(257865);
  }
  
  public final void setCropLayoutScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(257863);
    p.h(parame, "value");
    this.xmY = parame;
    getLayout().setScaleType(parame);
    AppMethodBeat.o(257863);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.pXO = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(257866);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(257866);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.xna = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.wgF = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.xmX = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.ofW = paramCommonVideoView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$Companion;", "", "()V", "MAXTARGETSIZE", "", "TAG", "", "TYPE_IMAGE", "TYPE_VIDEO", "plugin-gallery_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"})
  public static final class b
  {
    float aXt;
    float aXu;
    public Matrix gT;
    public Rect iiw;
    private final String mediaPath;
    public final Rect rwL;
    public Rect viewRect;
    private final long xjE;
    private Matrix xnc;
    Matrix xnd;
    public Rect xne;
    float xnf;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.xjE = paramLong;
      this.mediaPath = paramString;
      this.gT = new Matrix();
      this.xnc = new Matrix();
      this.xnd = new Matrix();
      this.iiw = new Rect();
      this.xne = new Rect();
      this.viewRect = new Rect();
      this.rwL = new Rect();
      this.xnf = 1.0F;
      this.aXt = 1.0F;
      this.aXu = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final Matrix dRK()
    {
      AppMethodBeat.i(165013);
      this.xnc.set(this.gT);
      this.xnc.postTranslate(0.0F, -this.iiw.top);
      Log.d("WxMediaCropLayout", "matrix=" + this.gT + " cropMatrix=" + this.xnc + ' ' + this.iiw);
      Matrix localMatrix = this.xnc;
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
          if ((this.xjE != paramObject.xjE) || (!p.j(this.mediaPath, paramObject.mediaPath))) {}
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
      long l = this.xjE;
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
      String str = "CropInfo(mediaId=" + this.xjE + ", mediaPath=" + this.mediaPath + ")";
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"})
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x>
  {
    public static final d xng;
    
    static
    {
      AppMethodBeat.i(257857);
      xng = new d();
      AppMethodBeat.o(257857);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"})
  public static final class f
    implements BaseCropLayout.b
  {
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.xni));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.xni).ay(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "outWidth", "", "outHeight", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements m<Integer, Integer, WxMediaCropLayout.b>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxCropOperationLayout>
  {
    i(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    j(long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      p.h(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.xni, paramLong)) {
        WxMediaCropLayout.b(this.xni).set(paramRectF);
      }
      paramRectF.round(this.xnl.iiw);
      WxMediaCropLayout.d(this.xni).b(paramRectF, false);
      AppMethodBeat.o(165025);
    }
    
    public final void pA(boolean paramBoolean) {}
    
    public final void pz(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    k(WxMediaCropLayout paramWxMediaCropLayout, Matrix paramMatrix, WxMediaCropLayout.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"})
  public static final class l
    implements CropLayout.c
  {
    l(WxMediaCropLayout.b paramb) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      paramString.rwL.set(WxMediaCropLayout.d(this.xni).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */