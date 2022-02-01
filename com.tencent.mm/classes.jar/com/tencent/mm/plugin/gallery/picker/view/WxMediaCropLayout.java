package com.tencent.mm.plugin.gallery.picker.view;

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
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.g;
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
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "cropLayoutScaleType", "getCropLayoutScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setCropLayoutScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "currentPreviewMediaId", "", "currentType", "getCurrentType", "()I", "setCurrentType", "(I)V", "defaultImageContentCreator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "imageView", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "", "isShowBorder", "()Z", "setShowBorder", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "lockCropMediaId", "getLockCropMediaId", "()J", "setLockCropMediaId", "(J)V", "lockCropRect", "Landroid/graphics/RectF;", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "mediaWH", "", "getMediaWH", "()[I", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getMusicController", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "setMusicController", "(Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;)V", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "operationLayout$delegate", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "setVideoView", "(Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;)V", "getCropInfo", "mediaId", "path", "getCurrentCropInfo", "init", "", "initCropRect", "minCropHeight", "", "maxCropHeight", "isLockMedia", "onPreview", "type", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "onPreviewImage", "isHard", "contentCreator", "onPreviewVideo", "onCalculateVisibilityRectCallback", "forceSet", "onRevertRotate", "onRotate", "onUIPause", "onUIRelease", "onUIResume", "removeCropOverlay", "setCropView", "view", "Landroid/view/View;", "viewW", "viewH", "defaultVisibilityRect", "setEnableScale", "enable", "Companion", "CropInfo", "OnCalculateVisibilityRect", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxMediaCropLayout
  extends FrameLayout
{
  public static final WxMediaCropLayout.a HLh;
  public com.tencent.mm.plugin.recordvideo.plugin.a.b Gsn;
  private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> HKE;
  private final j HKU;
  private final j HKW;
  private long HKY;
  private final LongSparseArray<b> HLa;
  private final RectF HLi;
  private final j HLj;
  private WxCropOperationLayout.j HLk;
  private boolean HLl;
  private CropLayout.e HLm;
  private final int[] HLn;
  private long HLo;
  public CommonVideoView upC;
  public int wyh;
  
  static
  {
    AppMethodBeat.i(165029);
    HLh = new WxMediaCropLayout.a((byte)0);
    AppMethodBeat.o(165029);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165045);
    this.HLa = new LongSparseArray();
    this.HKU = k.cm((kotlin.g.a.a)new e(this));
    this.HLi = new RectF();
    this.HKY = -1L;
    this.HKW = k.cm((kotlin.g.a.a)new g(this));
    this.HLj = k.cm((kotlin.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.HLk = WxCropOperationLayout.j.NTk;
    this.HLm = CropLayout.e.agdt;
    this.HKE = ((q)WxMediaCropLayout.d.HLt);
    this.HLn = new int[2];
    AppMethodBeat.o(165045);
  }
  
  public WxMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(165046);
    this.HLa = new LongSparseArray();
    this.HKU = k.cm((kotlin.g.a.a)new e(this));
    this.HLi = new RectF();
    this.HKY = -1L;
    this.HKW = k.cm((kotlin.g.a.a)new g(this));
    this.HLj = k.cm((kotlin.g.a.a)new i(this));
    addView((View)getLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)getOperationLayout(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.HLk = WxCropOperationLayout.j.NTk;
    this.HLm = CropLayout.e.agdt;
    this.HKE = ((q)WxMediaCropLayout.d.HLt);
    this.HLn = new int[2];
    AppMethodBeat.o(165046);
  }
  
  private final b N(long paramLong, String paramString)
  {
    AppMethodBeat.i(165042);
    if (this.HLa.get(paramLong) == null)
    {
      paramString = new b(paramLong, paramString);
      this.HLa.put(paramLong, paramString);
      this.HLi.round(paramString.Gl);
      AppMethodBeat.o(165042);
      return paramString;
    }
    paramString = (b)this.HLa.get(paramLong);
    s.s(paramString, "{\n            val cropIn…       cropInfo\n        }");
    AppMethodBeat.o(165042);
    return paramString;
  }
  
  private final b a(View paramView, int paramInt1, int paramInt2, RectF paramRectF, final long paramLong, final String paramString, int paramInt3)
  {
    AppMethodBeat.i(165043);
    Log.i("WxMediaCropLayout", "[setCropView] mediaId=" + paramLong + " viewW=" + paramInt1 + " viewH=" + paramInt2 + " defaultVisibilityRect=" + paramRectF + " lockCropRect=" + this.HLi + " path=" + paramString + " mediaType=" + paramInt3);
    this.HKY = paramLong;
    if (0L == this.HLo) {
      this.HLo = paramLong;
    }
    paramString = N(paramLong, paramString);
    if (rx(paramLong))
    {
      getOperationLayout().setStyle(this.HLk);
      if (!paramString.matrix.isIdentity()) {
        paramRectF.set(this.HLi);
      }
      this.HLi.round(paramString.Gl);
    }
    for (;;)
    {
      getLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().getVisibilityRect().set(paramRectF);
      getOperationLayout().setOnOperationCallback((WxCropOperationLayout.i)new j(this, paramLong, paramString));
      paramRectF = new Matrix(paramString.matrix);
      getLayout().a(paramView, paramInt1, paramInt2, paramString.matrix, this.HLm, (kotlin.g.a.b)new k(paramRectF, paramString, this));
      getLayout().setOnChangeListener((CropLayout.c)new l(paramString, this));
      paramView = this.HLa.get(paramLong);
      s.s(paramView, "matrixMap[mediaId]");
      paramView = (b)paramView;
      AppMethodBeat.o(165043);
      return paramView;
      getOperationLayout().setStyle(WxCropOperationLayout.j.NTl);
      paramRectF.set(this.HLi);
      this.HLi.round(paramString.Gl);
    }
  }
  
  private final ImageView getImageView()
  {
    AppMethodBeat.i(165030);
    ImageView localImageView = (ImageView)this.HKU.getValue();
    AppMethodBeat.o(165030);
    return localImageView;
  }
  
  private final WxCropOperationLayout getOperationLayout()
  {
    AppMethodBeat.i(289414);
    WxCropOperationLayout localWxCropOperationLayout = (WxCropOperationLayout)this.HLj.getValue();
    AppMethodBeat.o(289414);
    return localWxCropOperationLayout;
  }
  
  private final boolean rx(long paramLong)
  {
    return (this.HLo == paramLong) || (this.HLo == 0L);
  }
  
  private final void setStyle(WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(289418);
    this.HLk = paramj;
    getOperationLayout().setStyle(paramj);
    AppMethodBeat.o(289418);
  }
  
  public final b a(long paramLong, String paramString, boolean paramBoolean1, c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(165040);
    s.u(paramString, "mediaPath");
    if ((paramLong == this.HKY) && (!paramBoolean1))
    {
      paramString = this.HLa.get(paramLong);
      s.s(paramString, "matrixMap[mediaId]");
      paramString = (b)paramString;
      AppMethodBeat.o(165040);
      return paramString;
    }
    Log.i("WxMediaCropLayout", "onPreviewVideo");
    getLayout().Nw(true);
    getLayout().setEnableScale(true);
    Object localObject1 = g.HRf;
    localObject1 = g.aBH(paramString);
    if (this.upC == null) {
      this.upC = new CommonVideoView(getContext());
    }
    Object localObject2 = this.upC;
    if (localObject2 != null)
    {
      if ((s.p(((CommonVideoView)localObject2).getTag(), paramString)) && (!paramBoolean2)) {
        break label413;
      }
      ((CommonVideoView)localObject2).stop();
      ((CommonVideoView)localObject2).eLM();
      ((CommonVideoView)localObject2).setLoop(true);
      ((CommonVideoView)localObject2).setMute(false);
      ((CommonVideoView)localObject2).setIsShowBasicControls(false);
      ((CommonVideoView)localObject2).setScaleType(i.e.XYM);
      ((CommonVideoView)localObject2).b(false, paramString, 0);
      ((CommonVideoView)localObject2).onUIResume();
      ((CommonVideoView)localObject2).start();
      ((CommonVideoView)localObject2).setTag(paramString);
    }
    for (;;)
    {
      this.HLn[0] = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
      this.HLn[1] = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
      localObject2 = new RectF(this.HLi);
      if (paramc != null) {
        paramc.a(this.HLn, (RectF)localObject2);
      }
      getOperationLayout().a(WxCropOperationLayout.h.NTb);
      getOperationLayout().a(WxCropOperationLayout.h.NTc);
      paramc = new VideoTimeView(getContext());
      paramc.setDuration(((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration / 1000);
      paramc.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramc.start();
      getOperationLayout().a((View)paramc, WxCropOperationLayout.h.NTb);
      getOperationLayout().setBorderVisibilityCallback((com.tencent.mm.ui.widget.cropview.a)paramc);
      getOperationLayout().gJL();
      Log.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
      paramc = this.upC;
      s.checkNotNull(paramc);
      paramString = a((View)paramc, ((com.tencent.mm.plugin.sight.base.b)localObject1).width, ((com.tencent.mm.plugin.sight.base.b)localObject1).height, (RectF)localObject2, paramLong, paramString, 1);
      AppMethodBeat.o(165040);
      return paramString;
      label413:
      if (!((CommonVideoView)localObject2).isPlaying()) {
        ((CommonVideoView)localObject2).start();
      }
    }
  }
  
  public final void a(RectF paramRectF, WxCropOperationLayout.j paramj)
  {
    AppMethodBeat.i(289456);
    s.u(paramRectF, "initCropRect");
    s.u(paramj, "style");
    setStyle(paramj);
    this.HLi.set(paramRectF);
    AppMethodBeat.o(289456);
  }
  
  public final void fBi()
  {
    AppMethodBeat.i(289477);
    removeView((View)getOperationLayout());
    AppMethodBeat.o(289477);
  }
  
  public final CropLayout.e getCropLayoutScaleType()
  {
    return this.HLm;
  }
  
  public final b getCurrentCropInfo()
  {
    AppMethodBeat.i(165044);
    Object localObject = (b)this.HLa.get(this.HKY);
    if (localObject == null)
    {
      localObject = (WxMediaCropLayout)this;
      Log.w("WxMediaCropLayout", s.X("[getCurrentCropInfo] currentPreviewMediaId=", Long.valueOf(((WxMediaCropLayout)localObject).HKY)));
      localObject = new b(((WxMediaCropLayout)localObject).HKY, "");
      AppMethodBeat.o(165044);
      return localObject;
    }
    AppMethodBeat.o(165044);
    return localObject;
  }
  
  public final int getCurrentType()
  {
    return this.wyh;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(165034);
    CropLayout localCropLayout = (CropLayout)this.HKW.getValue();
    AppMethodBeat.o(165034);
    return localCropLayout;
  }
  
  public final long getLockCropMediaId()
  {
    return this.HLo;
  }
  
  public final int[] getMediaWH()
  {
    return this.HLn;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController()
  {
    return this.Gsn;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(165031);
    CommonVideoView localCommonVideoView = this.upC;
    AppMethodBeat.o(165031);
    return localCommonVideoView;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(289473);
    Log.i("WxMediaCropLayout", "onUIPause");
    Object localObject;
    if (this.upC != null)
    {
      localObject = this.upC;
      if (localObject != null) {
        ((CommonVideoView)localObject).onUIPause();
      }
    }
    if (this.Gsn != null)
    {
      localObject = this.Gsn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject).pauseAudio();
      }
    }
    AppMethodBeat.o(289473);
  }
  
  public final void setCropLayoutScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(289466);
    s.u(parame, "value");
    this.HLm = parame;
    getLayout().setScaleType(parame);
    AppMethodBeat.o(289466);
  }
  
  public final void setCurrentType(int paramInt)
  {
    this.wyh = paramInt;
  }
  
  public final void setEnableScale(boolean paramBoolean)
  {
    AppMethodBeat.i(289475);
    getLayout().setEnableScale(paramBoolean);
    AppMethodBeat.o(289475);
  }
  
  public final void setLockCropMediaId(long paramLong)
  {
    this.HLo = paramLong;
  }
  
  public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b paramb)
  {
    this.Gsn = paramb;
  }
  
  public final void setShowBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(165037);
    getLayout().setHasBorder(paramBoolean);
    this.HLl = paramBoolean;
    if (paramBoolean) {
      getLayout().setOnBorderVisibilityCallback((BaseCropLayout.b)new f(this));
    }
    AppMethodBeat.o(165037);
  }
  
  public final void setVideoView(CommonVideoView paramCommonVideoView)
  {
    this.upC = paramCommonVideoView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "", "mediaId", "", "mediaPath", "", "(JLjava/lang/String;)V", "centerMatrix", "Landroid/graphics/Matrix;", "getCenterMatrix", "()Landroid/graphics/Matrix;", "setCenterMatrix", "(Landroid/graphics/Matrix;)V", "contentCenterRect", "Landroid/graphics/Rect;", "getContentCenterRect", "()Landroid/graphics/Rect;", "setContentCenterRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "cropMatrix", "getCropMatrix", "setCropMatrix", "cropRect", "getCropRect", "setCropRect", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "getMatrix", "setMatrix", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public Rect Gl;
    private final long HIr;
    private Matrix HLp;
    Matrix HLq;
    public Rect HLr;
    float HLs;
    public Matrix matrix;
    float maxScale;
    private final String mediaPath;
    float minScale;
    public Rect viewRect;
    public final Rect yok;
    
    public b(long paramLong, String paramString)
    {
      AppMethodBeat.i(165014);
      this.HIr = paramLong;
      this.mediaPath = paramString;
      this.matrix = new Matrix();
      this.HLp = new Matrix();
      this.HLq = new Matrix();
      this.Gl = new Rect();
      this.HLr = new Rect();
      this.viewRect = new Rect();
      this.yok = new Rect();
      this.HLs = 1.0F;
      this.maxScale = 1.0F;
      this.minScale = 1.0F;
      AppMethodBeat.o(165014);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(165017);
      if (this == paramObject)
      {
        AppMethodBeat.o(165017);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(165017);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.HIr != paramObject.HIr)
      {
        AppMethodBeat.o(165017);
        return false;
      }
      if (!s.p(this.mediaPath, paramObject.mediaPath))
      {
        AppMethodBeat.o(165017);
        return false;
      }
      AppMethodBeat.o(165017);
      return true;
    }
    
    public final Matrix fBj()
    {
      AppMethodBeat.i(165013);
      this.HLp.set(this.matrix);
      this.HLp.postTranslate(0.0F, -this.Gl.top);
      Log.d("WxMediaCropLayout", "matrix=" + this.matrix + " cropMatrix=" + this.HLp + ' ' + this.Gl);
      Matrix localMatrix = this.HLp;
      AppMethodBeat.o(165013);
      return localMatrix;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(165016);
      int i = q.a..ExternalSyntheticBackport0.m(this.HIr);
      int j = this.mediaPath.hashCode();
      AppMethodBeat.o(165016);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(165015);
      String str = "CropInfo(mediaId=" + this.HIr + ", mediaPath=" + this.mediaPath + ')';
      AppMethodBeat.o(165015);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(int[] paramArrayOfInt, RectF paramRectF);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    e(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$isShowBorder$1", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "onDismiss", "", "onShow", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements BaseCropLayout.b
  {
    f(WxMediaCropLayout paramWxMediaCropLayout) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(165020);
      WxCropOperationLayout.a(WxMediaCropLayout.a(this.HLu));
      AppMethodBeat.o(165020);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(165019);
      WxMediaCropLayout.a(this.HLu).aR(255, 0L);
      AppMethodBeat.o(165019);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<CropLayout>
  {
    g(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "outWidth", "", "outHeight"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<Integer, Integer, Object>
  {
    h(WxMediaCropLayout paramWxMediaCropLayout, WxMediaCropLayout.c paramc, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<WxCropOperationLayout>
  {
    i(WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements WxCropOperationLayout.i
  {
    j(WxMediaCropLayout paramWxMediaCropLayout, long paramLong, WxMediaCropLayout.b paramb) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(165025);
      s.u(paramRectF, "rectF");
      if (WxMediaCropLayout.a(this.HLu, paramLong)) {
        WxMediaCropLayout.b(this.HLu).set(paramRectF);
      }
      paramRectF.round(this.HLx.Gl);
      WxMediaCropLayout.d(this.HLu).b(paramRectF, false);
      AppMethodBeat.o(165025);
    }
    
    public final void vS(boolean paramBoolean) {}
    
    public final void vT(boolean paramBoolean)
    {
      AppMethodBeat.i(289398);
      s.u(this, "this");
      AppMethodBeat.o(289398);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Matrix;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    k(Matrix paramMatrix, WxMediaCropLayout.b paramb, WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$setCropView$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements CropLayout.c
  {
    l(WxMediaCropLayout.b paramb, WxMediaCropLayout paramWxMediaCropLayout) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(165027);
      this.HLx.yok.set(WxMediaCropLayout.d(jdField_this).getContentRect());
      AppMethodBeat.o(165027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */