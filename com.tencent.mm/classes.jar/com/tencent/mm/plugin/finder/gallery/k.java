package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "galleryTabData", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;)V", "getGalleryTabData", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabData;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class k
  implements bu
{
  boolean xUg;
  public final j xUh;
  
  public k(j paramj)
  {
    AppMethodBeat.i(274538);
    this.xUh = paramj;
    AppMethodBeat.o(274538);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    AppMethodBeat.i(274536);
    p.k(paramk, "obj");
    if (((paramk instanceof k)) && (((k)paramk).xUh.fXY == this.xUh.fXY))
    {
      AppMethodBeat.o(274536);
      return 0;
    }
    AppMethodBeat.o(274536);
    return -1;
  }
  
  public final int bAQ()
  {
    return 1;
  }
  
  public final long mf()
  {
    return this.xUh.fXY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.k
 * JD-Core Version:    0.7.0.1
 */