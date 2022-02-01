package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"})
public final class p
{
  private static final p BVK;
  public static final p.a BVL;
  ArrayList<j> BVH;
  final ArrayList<GalleryItem.MediaItem> BVI;
  private c BVJ;
  
  static
  {
    AppMethodBeat.i(111798);
    BVL = new p.a((byte)0);
    b localb = b.BVN;
    BVK = b.etW();
    AppMethodBeat.o(111798);
  }
  
  private p()
  {
    AppMethodBeat.i(111797);
    this.BVH = new ArrayList();
    this.BVI = new ArrayList();
    this.BVJ = c.BVO;
    AppMethodBeat.o(111797);
  }
  
  private final void o(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    Log.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.BVI.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.BVI.size())
      {
        c localc = e.etk();
        Object localObject1 = this.BVI.get(i);
        kotlin.g.b.p.j(localObject1, "mediaItems[item]");
        localObject1 = ((GalleryItem.MediaItem)localObject1).aZe();
        Object localObject2 = this.BVI.get(i);
        kotlin.g.b.p.j(localObject2, "mediaItems[item]");
        int j = ((GalleryItem.MediaItem)localObject2).getType();
        localObject2 = this.BVI.get(i);
        kotlin.g.b.p.j(localObject2, "mediaItems[item]");
        localc.b((String)localObject1, j, ((GalleryItem.MediaItem)localObject2).etI(), ((GalleryItem.MediaItem)this.BVI.get(i)).BVl, ((GalleryItem.MediaItem)this.BVI.get(i)).BVm);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(111794);
    kotlin.g.b.p.k(paramj, "preload");
    this.BVH.add(paramj);
    AppMethodBeat.o(111794);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    kotlin.g.b.p.k(paramc, "state");
    Log.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.BVJ, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.BVJ != paramc) {
      this.BVJ = paramc;
    }
    Iterator localIterator = this.BVH.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if ((c.BVO == paramc) && (localj.etO())) {
        o(localj.a(paramc, this.BVJ, paramInt1, paramInt2, paramInt3));
      }
      if (!localj.etO()) {
        o(localj.a(paramc, this.BVJ, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
  
  public final void fk(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(244150);
    kotlin.g.b.p.k(paramList, "mediaItems");
    Log.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    this.BVI.clear();
    this.BVI.addAll((Collection)paramList);
    AppMethodBeat.o(244150);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getHolder", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"})
  static final class b
  {
    private static final p BVM;
    public static final b BVN;
    
    static
    {
      AppMethodBeat.i(111790);
      BVN = new b();
      BVM = new p((byte)0);
      AppMethodBeat.o(111790);
    }
    
    public static p etW()
    {
      return BVM;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "", "(Ljava/lang/String;I)V", "IDLE", "UP", "DOWN", "plugin-gallery_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(111791);
      c localc1 = new c("IDLE", 0);
      BVO = localc1;
      c localc2 = new c("UP", 1);
      BVP = localc2;
      c localc3 = new c("DOWN", 2);
      BVQ = localc3;
      BVR = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(111791);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p
 * JD-Core Version:    0.7.0.1
 */