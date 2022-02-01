package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"})
public final class p
{
  private static final p tHr;
  public static final p.a tHs;
  ArrayList<j> tHo;
  public final ArrayList<GalleryItem.MediaItem> tHp;
  private p.c tHq;
  
  static
  {
    AppMethodBeat.i(111798);
    tHs = new p.a((byte)0);
    b localb = b.tHu;
    tHr = b.cVw();
    AppMethodBeat.o(111798);
  }
  
  private p()
  {
    AppMethodBeat.i(111797);
    this.tHo = new ArrayList();
    this.tHp = new ArrayList();
    this.tHq = p.c.tHv;
    AppMethodBeat.o(111797);
  }
  
  private final void m(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    ad.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.tHp.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.tHp.size())
      {
        c localc = e.cUL();
        Object localObject1 = this.tHp.get(i);
        d.g.b.p.g(localObject1, "mediaItems[item]");
        localObject1 = ((GalleryItem.MediaItem)localObject1).axA();
        Object localObject2 = this.tHp.get(i);
        d.g.b.p.g(localObject2, "mediaItems[item]");
        int j = ((GalleryItem.MediaItem)localObject2).getType();
        localObject2 = this.tHp.get(i);
        d.g.b.p.g(localObject2, "mediaItems[item]");
        localc.b((String)localObject1, j, ((GalleryItem.MediaItem)localObject2).cVj(), ((GalleryItem.MediaItem)this.tHp.get(i)).tGV, ((GalleryItem.MediaItem)this.tHp.get(i)).tGW);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(111794);
    d.g.b.p.h(paramj, "preload");
    this.tHo.add(paramj);
    AppMethodBeat.o(111794);
  }
  
  public final void a(p.c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    d.g.b.p.h(paramc, "state");
    ad.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.tHq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tHq != paramc) {
      this.tHq = paramc;
    }
    Iterator localIterator = this.tHo.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((p.c.tHv == paramc) && (localj.cVo())) {
        m(localj.a(paramc, this.tHq, paramInt1, paramInt2, paramInt3));
      }
      if (!localj.cVo()) {
        m(localj.a(paramc, this.tHq, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getHolder", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"})
  static final class b
  {
    private static final p tHt;
    public static final b tHu;
    
    static
    {
      AppMethodBeat.i(111790);
      tHu = new b();
      tHt = new p((byte)0);
      AppMethodBeat.o(111790);
    }
    
    public static p cVw()
    {
      return tHt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p
 * JD-Core Version:    0.7.0.1
 */