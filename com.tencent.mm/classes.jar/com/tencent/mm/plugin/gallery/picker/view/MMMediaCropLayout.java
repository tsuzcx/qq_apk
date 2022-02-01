package com.tencent.mm.plugin.gallery.picker.view;

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
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentPreviewMediaId", "", "getCurrentPreviewMediaId", "()J", "setCurrentPreviewMediaId", "(J)V", "defaultScaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getDefaultScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setDefaultScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "isLockCropWindow", "", "()Z", "setLockCropWindow", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "videoView$delegate", "lockCropWindow", "", "width", "height", "onDetachedFromWindow", "onPreview", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onPreviewImage", "isHard", "onPreviewVideo", "onUIPause", "onUIResume", "reset", "scaleType", "setContentView", "view", "Landroid/view/View;", "mediaId", "item", "Companion", "CropInfo", "MediaExtra", "plugin-gallery_release"})
public final class MMMediaCropLayout
  extends FrameLayout
{
  public static final MMMediaCropLayout.a tKD;
  private long tKA;
  public boolean tKB;
  private final LongSparseArray<b> tKC;
  private final f tKw;
  private final f tKx;
  private final f tKy;
  private CropLayout.e tKz;
  
  static
  {
    AppMethodBeat.i(164935);
    tKD = new MMMediaCropLayout.a((byte)0);
    AppMethodBeat.o(164935);
  }
  
  public MMMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164946);
    this.tKw = g.O((a)new d(this));
    this.tKx = g.O((a)new g(this));
    this.tKy = g.O((a)new e(this));
    this.tKz = CropLayout.e.KVo;
    this.tKC = new LongSparseArray();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.gravity = 17;
    addView((View)getLayout(), (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(164946);
  }
  
  public MMMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164947);
    this.tKw = g.O((a)new d(this));
    this.tKx = g.O((a)new g(this));
    this.tKy = g.O((a)new e(this));
    this.tKz = CropLayout.e.KVo;
    this.tKC = new LongSparseArray();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.gravity = 17;
    addView((View)getLayout(), (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(164947);
  }
  
  private final void a(View paramView, long paramLong, int paramInt1, int paramInt2, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164942);
    ad.i("MMMediaCropLayout", "[setContentView] mediaId=" + paramLong + " width=" + paramInt1 + " height=" + paramInt2 + " isLockCropWindow=" + this.tKB);
    this.tKA = paramLong;
    Object localObject1 = (b)this.tKC.get(paramLong);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((b)localObject1).gR;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = (MMMediaCropLayout)this;
      localObject2 = new b(paramLong);
      ((MMMediaCropLayout)localObject1).getLayout().getVisibilityRect().round(((b)localObject2).hmm);
      ((b)localObject2).viewRect.set(0, 0, paramInt1, paramInt2);
      ((b)localObject2).pZj = ((MMMediaCropLayout)localObject1).getLayout().getContentRect();
      localObject3 = paramMediaItem.hNZ;
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.MediaExtra");
        AppMethodBeat.o(164942);
        throw paramView;
      }
      ((MMMediaCropLayout.c)localObject3).a((b)localObject2);
      ((MMMediaCropLayout)localObject1).tKC.put(paramLong, localObject2);
      localObject1 = ((b)localObject2).gR;
    }
    if ((this.tKB) || (paramMediaItem.getType() == 2))
    {
      localObject2 = CropLayout.e.KVn;
      localObject3 = getLayout();
      if (paramMediaItem.getType() == 2) {
        break label294;
      }
    }
    label294:
    for (boolean bool = true;; bool = false)
    {
      ((CropLayout)localObject3).setEnableScale(bool);
      CropLayout.a(getLayout(), paramView, paramInt1, paramInt2, (Matrix)localObject1, (CropLayout.e)localObject2, null, 32);
      AppMethodBeat.o(164942);
      return;
      localObject2 = this.tKz;
      break;
    }
  }
  
  public final long getCurrentPreviewMediaId()
  {
    return this.tKA;
  }
  
  public final CropLayout.e getDefaultScaleType()
  {
    return this.tKz;
  }
  
  public final ImageView getImageView()
  {
    AppMethodBeat.i(164936);
    ImageView localImageView = (ImageView)this.tKw.getValue();
    AppMethodBeat.o(164936);
    return localImageView;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(164938);
    CropLayout localCropLayout = (CropLayout)this.tKy.getValue();
    AppMethodBeat.o(164938);
    return localCropLayout;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(164937);
    CommonVideoView localCommonVideoView = (CommonVideoView)this.tKx.getValue();
    AppMethodBeat.o(164937);
    return localCommonVideoView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(164944);
    super.onDetachedFromWindow();
    getVideoView().onUIDestroy();
    AppMethodBeat.o(164944);
  }
  
  public final void setCurrentPreviewMediaId(long paramLong)
  {
    this.tKA = paramLong;
  }
  
  public final void setDefaultScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(164939);
    p.h(parame, "<set-?>");
    this.tKz = parame;
    AppMethodBeat.o(164939);
  }
  
  public final void setLockCropWindow(boolean paramBoolean)
  {
    this.tKB = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "", "mediaId", "", "(J)V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "setContentRect", "(Landroid/graphics/Rect;)V", "cropRect", "getCropRect", "setCropRect", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "viewRect", "getViewRect", "setViewRect", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-gallery_release"})
  public static final class b
  {
    public Matrix gR;
    public Rect hmm;
    public Rect pZj;
    private final long tHA;
    public Rect viewRect;
    
    public b(long paramLong)
    {
      AppMethodBeat.i(164925);
      this.tHA = paramLong;
      this.gR = new Matrix();
      this.viewRect = new Rect();
      AppMethodBeat.o(164925);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.tHA != paramObject.tHA) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.tHA;
      return (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(164926);
      String str = "CropInfo(mediaId=" + this.tHA + ")";
      AppMethodBeat.o(164926);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "invoke"})
  static final class d
    extends q
    implements a<ImageView>
  {
    d(MMMediaCropLayout paramMMMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "invoke"})
  static final class e
    extends q
    implements a<CropLayout>
  {
    e(MMMediaCropLayout paramMMMediaCropLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class f<T, R>
    implements e<GalleryItem.MediaItem, Bitmap>
  {
    f(MMMediaCropLayout paramMMMediaCropLayout, GalleryItem.MediaItem paramMediaItem) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$onPreviewImage$1$1$1"})
    static final class a
      extends q
      implements a<z>
    {
      a(Bitmap paramBitmap, MMMediaCropLayout.f paramf)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "invoke"})
  static final class g
    extends q
    implements a<CommonVideoView>
  {
    g(MMMediaCropLayout paramMMMediaCropLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */