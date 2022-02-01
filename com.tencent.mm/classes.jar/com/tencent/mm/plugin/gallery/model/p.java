package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"})
public final class p
{
  private static final p xjv;
  public static final a xjw;
  ArrayList<j> xjs;
  final ArrayList<GalleryItem.MediaItem> xjt;
  private p.c xju;
  
  static
  {
    AppMethodBeat.i(111798);
    xjw = new a((byte)0);
    b localb = b.xjy;
    xjv = b.dRu();
    AppMethodBeat.o(111798);
  }
  
  private p()
  {
    AppMethodBeat.i(111797);
    this.xjs = new ArrayList();
    this.xjt = new ArrayList();
    this.xju = p.c.xjz;
    AppMethodBeat.o(111797);
  }
  
  private final void o(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    Log.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.xjt.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.xjt.size())
      {
        c localc = e.dQJ();
        Object localObject1 = this.xjt.get(i);
        kotlin.g.b.p.g(localObject1, "mediaItems[item]");
        localObject1 = ((GalleryItem.MediaItem)localObject1).aQn();
        Object localObject2 = this.xjt.get(i);
        kotlin.g.b.p.g(localObject2, "mediaItems[item]");
        int j = ((GalleryItem.MediaItem)localObject2).getType();
        localObject2 = this.xjt.get(i);
        kotlin.g.b.p.g(localObject2, "mediaItems[item]");
        localc.b((String)localObject1, j, ((GalleryItem.MediaItem)localObject2).dRh(), ((GalleryItem.MediaItem)this.xjt.get(i)).xiZ, ((GalleryItem.MediaItem)this.xjt.get(i)).xja);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(111794);
    kotlin.g.b.p.h(paramj, "preload");
    this.xjs.add(paramj);
    AppMethodBeat.o(111794);
  }
  
  public final void a(p.c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    kotlin.g.b.p.h(paramc, "state");
    Log.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.xju, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.xju != paramc) {
      this.xju = paramc;
    }
    Iterator localIterator = this.xjs.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((p.c.xjz == paramc) && (localj.dRm())) {
        o(localj.a(paramc, this.xju, paramInt1, paramInt2, paramInt3));
      }
      if (!localj.dRm()) {
        o(localj.a(paramc, this.xju, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
  
  public final void eU(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(257767);
    kotlin.g.b.p.h(paramList, "mediaItems");
    Log.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    this.xjt.clear();
    this.xjt.addAll((Collection)paramList);
    AppMethodBeat.o(257767);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getInstance", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getHolder", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"})
  static final class b
  {
    private static final p xjx;
    public static final b xjy;
    
    static
    {
      AppMethodBeat.i(111790);
      xjy = new b();
      xjx = new p((byte)0);
      AppMethodBeat.o(111790);
    }
    
    public static p dRu()
    {
      return xjx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p
 * JD-Core Version:    0.7.0.1
 */