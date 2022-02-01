package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "", "()V", "lastState", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "mediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "preloadList", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "addPreload", "", "preload", "dispatchPreload", "state", "first", "", "last", "limit", "executePreload", "items", "", "removePreload", "reset", "syncMediaItems", "", "Companion", "SingletonHolder", "State", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r.a HIe;
  private static final r HIi;
  ArrayList<m> HIf;
  final ArrayList<GalleryItem.MediaItem> HIg;
  private c HIh;
  
  static
  {
    AppMethodBeat.i(111798);
    HIe = new r.a((byte)0);
    b localb = b.HIj;
    HIi = b.fAU();
    AppMethodBeat.o(111798);
  }
  
  private r()
  {
    AppMethodBeat.i(111797);
    this.HIf = new ArrayList();
    this.HIg = new ArrayList();
    this.HIh = c.HIl;
    AppMethodBeat.o(111797);
  }
  
  private final void w(Set<Integer> paramSet)
  {
    AppMethodBeat.i(111796);
    Log.d("MicroMsg.PreLoadManager", "mediaItems.size: %s.", new Object[] { Integer.valueOf(this.HIg.size()) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      if (i < this.HIg.size()) {
        e.fAm().b(((GalleryItem.MediaItem)this.HIg.get(i)).bud(), ((GalleryItem.MediaItem)this.HIg.get(i)).getType(), ((GalleryItem.MediaItem)this.HIg.get(i)).Gcc, ((GalleryItem.MediaItem)this.HIg.get(i)).HHJ, ((GalleryItem.MediaItem)this.HIg.get(i)).HHK);
      }
    }
    AppMethodBeat.o(111796);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(111794);
    s.u(paramm, "preload");
    this.HIf.add(paramm);
    AppMethodBeat.o(111794);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111795);
    s.u(paramc, "state");
    Log.d("MicroMsg.PreLoadManager", "dispatchPreload, %s %s %s %s.", new Object[] { paramc, this.HIh, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.HIh != paramc) {
      this.HIh = paramc;
    }
    Iterator localIterator = this.HIf.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if ((c.HIl == paramc) && (localm.fAO())) {
        w(localm.a(paramc, this.HIh, paramInt1, paramInt2, paramInt3));
      }
      if (!localm.fAO()) {
        w(localm.a(paramc, this.HIh, paramInt1, paramInt2, paramInt3));
      }
    }
    AppMethodBeat.o(111795);
  }
  
  public final void ia(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(289613);
    s.u(paramList, "mediaItems");
    Log.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    this.HIg.clear();
    this.HIg.addAll((Collection)paramList);
    AppMethodBeat.o(289613);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "getHolder", "()Lcom/tencent/mm/plugin/gallery/model/PreLoadManager;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b HIj;
    private static final r HIk;
    
    static
    {
      AppMethodBeat.i(111790);
      HIj = new b();
      HIk = new r((byte)0);
      AppMethodBeat.o(111790);
    }
    
    public static r fAU()
    {
      return HIk;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "", "(Ljava/lang/String;I)V", "IDLE", "UP", "DOWN", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(111791);
      HIl = new c("IDLE", 0);
      HIm = new c("UP", 1);
      HIn = new c("DOWN", 2);
      HIo = new c[] { HIl, HIm, HIn };
      AppMethodBeat.o(111791);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.r
 * JD-Core Version:    0.7.0.1
 */