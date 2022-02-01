package com.tencent.mm.plugin.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getHintByTemplateType", "", "selectMediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final String hY(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(289251);
    HashSet localHashSet = new HashSet();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      int j = 0;
      do
      {
        m = i;
        k = j;
        if (!paramList.hasNext()) {
          break;
        }
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramList.next();
        k = j;
        if (localMediaItem.getType() == 2) {
          k = j + 1;
        }
        j = i;
        if (localMediaItem.getType() == 1) {
          j = i + 1;
        }
        localHashSet.add(Integer.valueOf(localMediaItem.getType()));
        i = j;
        j = k;
      } while (localHashSet.size() < 2);
      paramList = a.bt(MMApplicationContext.getContext(), b.i.gallery_album_template_hint_select_video_pic);
      s.s(paramList, "getString(\n             …t_video_pic\n            )");
      AppMethodBeat.o(289251);
      return paramList;
    }
    int m = 0;
    int k = 0;
    if (m > 9)
    {
      paramList = a.bt(MMApplicationContext.getContext(), b.i.gallery_album_template_hint_select_many_picture);
      s.s(paramList, "getString(\n            M…ct_many_picture\n        )");
      AppMethodBeat.o(289251);
      return paramList;
    }
    if (k >= 2)
    {
      paramList = a.bt(MMApplicationContext.getContext(), b.i.gallery_album_template_hint_select_many_video);
      s.s(paramList, "getString(\n            M…lect_many_video\n        )");
      AppMethodBeat.o(289251);
      return paramList;
    }
    AppMethodBeat.o(289251);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.b
 * JD-Core Version:    0.7.0.1
 */