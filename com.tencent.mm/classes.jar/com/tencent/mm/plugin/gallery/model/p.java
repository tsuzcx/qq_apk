package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"})
public final class p
{
  private static final p sKG;
  public static final p.a sKH;
  ArrayList<j> sKD;
  public final ArrayList<GalleryItem.MediaItem> sKE;
  private p.c sKF;
  
  static
  {
    AppMethodBeat.i(111798);
    sKH = new p.a((byte)0);
    p.b localb = p.b.sKJ;
    sKG = p.b.cNe();
    AppMethodBeat.o(111798);
  }
  
  private p()
  {
    AppMethodBeat.i(111797);
    this.sKD = new ArrayList();
    this.sKE = new ArrayList();
    this.sKF = p.c.sKK;
    AppMethodBeat.o(111797);
  }
  
  private final void h(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    ac.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.sKE.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.sKE.size())
      {
        c localc = e.cMs();
        Object localObject1 = this.sKE.get(i);
        k.g(localObject1, "mediaItems[item]");
        localObject1 = ((GalleryItem.MediaItem)localObject1).auN();
        Object localObject2 = this.sKE.get(i);
        k.g(localObject2, "mediaItems[item]");
        int j = ((GalleryItem.MediaItem)localObject2).getType();
        localObject2 = this.sKE.get(i);
        k.g(localObject2, "mediaItems[item]");
        localc.b((String)localObject1, j, ((GalleryItem.MediaItem)localObject2).cMQ(), ((GalleryItem.MediaItem)this.sKE.get(i)).sKk, ((GalleryItem.MediaItem)this.sKE.get(i)).sKl);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(111794);
    k.h(paramj, "preload");
    this.sKD.add(paramj);
    AppMethodBeat.o(111794);
  }
  
  public final void a(p.c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    k.h(paramc, "state");
    ac.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.sKF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sKF != paramc) {
      this.sKF = paramc;
    }
    Iterator localIterator = this.sKD.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((p.c.sKK == paramc) && (localj.cMW())) {
        h(localj.a(paramc, this.sKF, paramInt1, paramInt2, paramInt3));
      }
      if (!localj.cMW()) {
        h(localj.a(paramc, this.sKF, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p
 * JD-Core Version:    0.7.0.1
 */