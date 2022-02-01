package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/VideoItemView;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "onCovert", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "loader", "Lcom/tencent/mm/loader/Loader;", "covertType", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VideoItemView
  extends MediaItemView<GalleryItem.VideoMediaItem>
{
  public static final VideoItemView.a HLg;
  
  static
  {
    AppMethodBeat.i(164957);
    HLg = new VideoItemView.a((byte)0);
    AppMethodBeat.o(164957);
  }
  
  public VideoItemView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164954);
    AppMethodBeat.o(164954);
  }
  
  public VideoItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164955);
    AppMethodBeat.o(164955);
  }
  
  public VideoItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164956);
    AppMethodBeat.o(164956);
  }
  
  public final int getLayoutId()
  {
    return b.f.picker_item_video_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.VideoItemView
 * JD-Core Version:    0.7.0.1
 */