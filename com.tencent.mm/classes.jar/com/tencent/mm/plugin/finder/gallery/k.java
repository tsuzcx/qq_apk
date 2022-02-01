package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "galleryTabData", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;)V", "getGalleryTabData", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements cc
{
  public final j Bvc;
  boolean Bvd;
  
  public k(j paramj)
  {
    AppMethodBeat.i(334270);
    this.Bvc = paramj;
    AppMethodBeat.o(334270);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    AppMethodBeat.i(334317);
    s.u(paramk, "obj");
    if (((paramk instanceof k)) && (((k)paramk).Bvc.idY == this.Bvc.idY))
    {
      AppMethodBeat.o(334317);
      return 0;
    }
    AppMethodBeat.o(334317);
    return -1;
  }
  
  public final long bZA()
  {
    return this.Bvc.idY;
  }
  
  public final int bZB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.k
 * JD-Core Version:    0.7.0.1
 */