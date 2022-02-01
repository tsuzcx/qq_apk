package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bus;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder_release"})
public final class f
  implements c
{
  private static final com.tencent.mm.sticker.c tcB;
  public static final f.a tcC;
  private final LinkedList<com.tencent.mm.sticker.c> pYk;
  private final LinkedList<com.tencent.mm.sticker.c> pYl;
  final d tcA;
  final d tcz;
  
  static
  {
    AppMethodBeat.i(205641);
    tcC = new f.a((byte)0);
    tcB = new com.tencent.mm.sticker.c(new bus(), 0, 6, (byte)0);
    AppMethodBeat.o(205641);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(205640);
    this.tcz = paramd1;
    this.tcA = paramd2;
    this.pYl = new LinkedList();
    this.pYk = new LinkedList();
    AppMethodBeat.o(205640);
  }
  
  public final void cW(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(205639);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerEffectCallbackWrapper_onMore", (a)new d(this, paramList));
    AppMethodBeat.o(205639);
  }
  
  public final void dQ(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(205638);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerEffectCallbackWrapper_onHistory", (a)new c(this, paramList));
    AppMethodBeat.o(205638);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroid/support/v7/util/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    private final d tcq;
    
    public b(d paramd)
    {
      AppMethodBeat.i(205633);
      this.tcq = paramd;
      AppMethodBeat.o(205633);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(205632);
      this.tcq.fu(paramInt1, paramInt2);
      AppMethodBeat.o(205632);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205629);
      this.tcq.fr(paramInt1, paramInt2);
      AppMethodBeat.o(205629);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205630);
      this.tcq.fs(paramInt1, paramInt2);
      AppMethodBeat.o(205630);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205631);
      this.tcq.ft(paramInt1, paramInt2);
      AppMethodBeat.o(205631);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(f paramf, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.f
 * JD-Core Version:    0.7.0.1
 */