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
import com.tencent.mm.ae.d;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentPreviewMediaId", "", "getCurrentPreviewMediaId", "()J", "setCurrentPreviewMediaId", "(J)V", "defaultScaleType", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "getDefaultScaleType", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;", "setDefaultScaleType", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$ScaleType;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "isLockCropWindow", "", "()Z", "setLockCropWindow", "(Z)V", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "layout$delegate", "matrixMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "videoView", "Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "getVideoView", "()Lcom/tencent/mm/pluginsdk/ui/CommonVideoView;", "videoView$delegate", "lockCropWindow", "", "width", "height", "onDetachedFromWindow", "onPreview", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onPreviewImage", "isHard", "onPreviewVideo", "onUIPause", "onUIResume", "reset", "scaleType", "setContentView", "view", "Landroid/view/View;", "mediaId", "item", "Companion", "CropInfo", "MediaExtra", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMMediaCropLayout
  extends FrameLayout
{
  public static final MMMediaCropLayout.a HKT;
  private final j HKU;
  private final j HKV;
  private final j HKW;
  private CropLayout.e HKX;
  private long HKY;
  public boolean HKZ;
  private final LongSparseArray<MMMediaCropLayout.b> HLa;
  
  static
  {
    AppMethodBeat.i(164935);
    HKT = new MMMediaCropLayout.a((byte)0);
    AppMethodBeat.o(164935);
  }
  
  public MMMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164946);
    this.HKU = k.cm((kotlin.g.a.a)new MMMediaCropLayout.d(this));
    this.HKV = k.cm((kotlin.g.a.a)new MMMediaCropLayout.g(this));
    this.HKW = k.cm((kotlin.g.a.a)new MMMediaCropLayout.e(this));
    this.HKX = CropLayout.e.agdu;
    this.HLa = new LongSparseArray();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.gravity = 17;
    addView((View)getLayout(), (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(164946);
  }
  
  public MMMediaCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164947);
    this.HKU = k.cm((kotlin.g.a.a)new MMMediaCropLayout.d(this));
    this.HKV = k.cm((kotlin.g.a.a)new MMMediaCropLayout.g(this));
    this.HKW = k.cm((kotlin.g.a.a)new MMMediaCropLayout.e(this));
    this.HKX = CropLayout.e.agdu;
    this.HLa = new LongSparseArray();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.gravity = 17;
    addView((View)getLayout(), (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(164947);
  }
  
  private final void a(View paramView, long paramLong, int paramInt1, int paramInt2, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164942);
    Log.i("MMMediaCropLayout", "[setContentView] mediaId=" + paramLong + " width=" + paramInt1 + " height=" + paramInt2 + " isLockCropWindow=" + this.HKZ);
    this.HKY = paramLong;
    Object localObject1 = (MMMediaCropLayout.b)this.HLa.get(paramLong);
    if (localObject1 == null) {}
    Object localObject3;
    for (localObject1 = null;; localObject1 = ((MMMediaCropLayout.b)localObject1).matrix)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label233;
      }
      localObject1 = (MMMediaCropLayout)this;
      localObject2 = new MMMediaCropLayout.b(paramLong);
      localObject3 = ((MMMediaCropLayout)localObject1).getLayout().getVisibilityRect();
      Rect localRect = ((MMMediaCropLayout.b)localObject2).Gl;
      s.checkNotNull(localRect);
      ((RectF)localObject3).round(localRect);
      ((MMMediaCropLayout.b)localObject2).viewRect.set(0, 0, paramInt1, paramInt2);
      ((MMMediaCropLayout.b)localObject2).yok = ((MMMediaCropLayout)localObject1).getLayout().getContentRect();
      localObject3 = paramMediaItem.extra;
      if (localObject3 != null) {
        break;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.MediaExtra");
      AppMethodBeat.o(164942);
      throw paramView;
    }
    ((MMMediaCropLayout.c)localObject3).a((MMMediaCropLayout.b)localObject2);
    ((MMMediaCropLayout)localObject1).HLa.put(paramLong, localObject2);
    Object localObject2 = ((MMMediaCropLayout.b)localObject2).matrix;
    label233:
    if ((this.HKZ) || (paramMediaItem.getType() == 2))
    {
      localObject1 = CropLayout.e.agdt;
      localObject3 = getLayout();
      if (paramMediaItem.getType() == 2) {
        break label313;
      }
    }
    label313:
    for (boolean bool = true;; bool = false)
    {
      ((CropLayout)localObject3).setEnableScale(bool);
      CropLayout.a(getLayout(), paramView, paramInt1, paramInt2, (Matrix)localObject2, (CropLayout.e)localObject1, null, 32);
      AppMethodBeat.o(164942);
      return;
      localObject1 = this.HKX;
      break;
    }
  }
  
  private static final void a(MMMediaCropLayout paramMMMediaCropLayout, final GalleryItem.MediaItem paramMediaItem, com.tencent.mm.loader.g.a.a parama, g paramg, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(289437);
    s.u(paramMMMediaCropLayout, "this$0");
    s.u(paramMediaItem, "$media");
    if (paramBitmap != null) {
      d.uiThread((kotlin.g.a.a)new f(paramMMMediaCropLayout, paramMediaItem, paramBitmap));
    }
    AppMethodBeat.o(289437);
  }
  
  public final long getCurrentPreviewMediaId()
  {
    return this.HKY;
  }
  
  public final CropLayout.e getDefaultScaleType()
  {
    return this.HKX;
  }
  
  public final ImageView getImageView()
  {
    AppMethodBeat.i(164936);
    ImageView localImageView = (ImageView)this.HKU.getValue();
    AppMethodBeat.o(164936);
    return localImageView;
  }
  
  public final CropLayout getLayout()
  {
    AppMethodBeat.i(164938);
    CropLayout localCropLayout = (CropLayout)this.HKW.getValue();
    AppMethodBeat.o(164938);
    return localCropLayout;
  }
  
  public final CommonVideoView getVideoView()
  {
    AppMethodBeat.i(164937);
    CommonVideoView localCommonVideoView = (CommonVideoView)this.HKV.getValue();
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
    this.HKY = paramLong;
  }
  
  public final void setDefaultScaleType(CropLayout.e parame)
  {
    AppMethodBeat.i(164939);
    s.u(parame, "<set-?>");
    this.HKX = parame;
    AppMethodBeat.o(164939);
  }
  
  public final void setLockCropWindow(boolean paramBoolean)
  {
    this.HKZ = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(MMMediaCropLayout paramMMMediaCropLayout, GalleryItem.MediaItem paramMediaItem, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout
 * JD-Core Version:    0.7.0.1
 */