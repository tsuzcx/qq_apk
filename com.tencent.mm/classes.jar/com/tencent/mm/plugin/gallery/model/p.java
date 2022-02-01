package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"})
public final class p
{
  private static final p tSi;
  public static final p.a tSj;
  ArrayList<j> tSf;
  public final ArrayList<GalleryItem.MediaItem> tSg;
  private p.c tSh;
  
  static
  {
    AppMethodBeat.i(111798);
    tSj = new p.a((byte)0);
    b localb = b.tSl;
    tSi = b.cYb();
    AppMethodBeat.o(111798);
  }
  
  private p()
  {
    AppMethodBeat.i(111797);
    this.tSf = new ArrayList();
    this.tSg = new ArrayList();
    this.tSh = p.c.tSm;
    AppMethodBeat.o(111797);
  }
  
  private final void m(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    ae.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.tSg.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.tSg.size())
      {
        c localc = e.cXq();
        Object localObject1 = this.tSg.get(i);
        d.g.b.p.g(localObject1, "mediaItems[item]");
        localObject1 = ((GalleryItem.MediaItem)localObject1).axP();
        Object localObject2 = this.tSg.get(i);
        d.g.b.p.g(localObject2, "mediaItems[item]");
        int j = ((GalleryItem.MediaItem)localObject2).getType();
        localObject2 = this.tSg.get(i);
        d.g.b.p.g(localObject2, "mediaItems[item]");
        localc.b((String)localObject1, j, ((GalleryItem.MediaItem)localObject2).cXO(), ((GalleryItem.MediaItem)this.tSg.get(i)).tRM, ((GalleryItem.MediaItem)this.tSg.get(i)).tRN);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(111794);
    d.g.b.p.h(paramj, "preload");
    this.tSf.add(paramj);
    AppMethodBeat.o(111794);
  }
  
  public final void a(p.c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    d.g.b.p.h(paramc, "state");
    ae.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.tSh, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tSh != paramc) {
      this.tSh = paramc;
    }
    Iterator localIterator = this.tSf.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((p.c.tSm == paramc) && (localj.cXT())) {
        m(localj.a(paramc, this.tSh, paramInt1, paramInt2, paramInt3));
      }
      if (!localj.cXT()) {
        m(localj.a(paramc, this.tSh, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getHolder", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"})
  static final class b
  {
    private static final p tSk;
    public static final b tSl;
    
    static
    {
      AppMethodBeat.i(111790);
      tSl = new b();
      tSk = new p((byte)0);
      AppMethodBeat.o(111790);
    }
    
    public static p cYb()
    {
      return tSk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p
 * JD-Core Version:    0.7.0.1
 */