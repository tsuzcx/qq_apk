package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"})
public final class p
{
  private static final p rBN;
  public static final p.a rBO;
  ArrayList<j> rBK;
  public final ArrayList<GalleryItem.MediaItem> rBL;
  private p.c rBM;
  
  static
  {
    AppMethodBeat.i(111798);
    rBO = new p.a((byte)0);
    b localb = b.rBQ;
    rBN = b.czS();
    AppMethodBeat.o(111798);
  }
  
  private p()
  {
    AppMethodBeat.i(111797);
    this.rBK = new ArrayList();
    this.rBL = new ArrayList();
    this.rBM = p.c.rBR;
    AppMethodBeat.o(111797);
  }
  
  private final void g(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    ad.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.rBL.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.rBL.size())
      {
        c localc = e.czg();
        Object localObject1 = this.rBL.get(i);
        k.g(localObject1, "mediaItems[item]");
        localObject1 = ((GalleryItem.MediaItem)localObject1).anX();
        Object localObject2 = this.rBL.get(i);
        k.g(localObject2, "mediaItems[item]");
        int j = ((GalleryItem.MediaItem)localObject2).getType();
        localObject2 = this.rBL.get(i);
        k.g(localObject2, "mediaItems[item]");
        localc.b((String)localObject1, j, ((GalleryItem.MediaItem)localObject2).czE(), ((GalleryItem.MediaItem)this.rBL.get(i)).rBs, ((GalleryItem.MediaItem)this.rBL.get(i)).rBt);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(111794);
    k.h(paramj, "preload");
    this.rBK.add(paramj);
    AppMethodBeat.o(111794);
  }
  
  public final void a(p.c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    k.h(paramc, "state");
    ad.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.rBM, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.rBM != paramc) {
      this.rBM = paramc;
    }
    Iterator localIterator = this.rBK.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((p.c.rBR == paramc) && (localj.czK())) {
        g(localj.a(paramc, this.rBM, paramInt1, paramInt2, paramInt3));
      }
      if (!localj.czK()) {
        g(localj.a(paramc, this.rBM, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getHolder", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"})
  static final class b
  {
    private static final p rBP;
    public static final b rBQ;
    
    static
    {
      AppMethodBeat.i(111790);
      rBQ = new b();
      rBP = new p((byte)0);
      AppMethodBeat.o(111790);
    }
    
    public static p czS()
    {
      return rBP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p
 * JD-Core Version:    0.7.0.1
 */