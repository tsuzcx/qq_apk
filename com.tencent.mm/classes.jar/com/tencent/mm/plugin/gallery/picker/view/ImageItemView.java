package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageItemView;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$ImageMediaItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "onCovert", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "loader", "Lcom/tencent/mm/loader/Loader;", "covertType", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImageItemView
  extends MediaItemView<GalleryItem.ImageMediaItem>
{
  public static final ImageItemView.a HKS;
  
  static
  {
    AppMethodBeat.i(164924);
    HKS = new ImageItemView.a((byte)0);
    AppMethodBeat.o(164924);
  }
  
  public ImageItemView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164921);
    AppMethodBeat.o(164921);
  }
  
  public ImageItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164922);
    AppMethodBeat.o(164922);
  }
  
  public ImageItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164923);
    AppMethodBeat.o(164923);
  }
  
  public final int getLayoutId()
  {
    return b.f.picker_item_image_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageItemView
 * JD-Core Version:    0.7.0.1
 */