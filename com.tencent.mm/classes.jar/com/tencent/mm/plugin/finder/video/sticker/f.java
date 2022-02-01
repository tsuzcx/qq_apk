package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chz;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder_release"})
public final class f
  implements c
{
  private static final com.tencent.mm.sticker.c wiZ;
  public static final f.a wja;
  private final LinkedList<com.tencent.mm.sticker.c> rpi;
  private final LinkedList<com.tencent.mm.sticker.c> rpj;
  final d wiX;
  final d wiY;
  
  static
  {
    AppMethodBeat.i(254593);
    wja = new f.a((byte)0);
    wiZ = new com.tencent.mm.sticker.c(new chz(), 0, 6, (byte)0);
    AppMethodBeat.o(254593);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(254592);
    this.wiX = paramd1;
    this.wiY = paramd2;
    this.rpj = new LinkedList();
    this.rpi = new LinkedList();
    AppMethodBeat.o(254592);
  }
  
  public final void dl(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(254591);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.d.b("StickerEffectCallbackWrapper_onMore", (a)new d(this, paramList));
    AppMethodBeat.o(254591);
  }
  
  public final void eE(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(254590);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.d.b("StickerEffectCallbackWrapper_onHistory", (a)new c(this, paramList));
    AppMethodBeat.o(254590);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroid/support/v7/util/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    private final d wiO;
    
    public b(d paramd)
    {
      AppMethodBeat.i(254585);
      this.wiO = paramd;
      AppMethodBeat.o(254585);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(254584);
      this.wiO.fK(paramInt1, paramInt2);
      AppMethodBeat.o(254584);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254581);
      this.wiO.fH(paramInt1, paramInt2);
      AppMethodBeat.o(254581);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254582);
      this.wiO.fI(paramInt1, paramInt2);
      AppMethodBeat.o(254582);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254583);
      this.wiO.fJ(paramInt1, paramInt2);
      AppMethodBeat.o(254583);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(f paramf, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.f
 * JD-Core Version:    0.7.0.1
 */