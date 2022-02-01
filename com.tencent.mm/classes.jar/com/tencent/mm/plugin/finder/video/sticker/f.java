package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bty;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder_release"})
public final class f
  implements c
{
  private static final com.tencent.mm.sticker.c sRq;
  public static final f.a sRr;
  private final LinkedList<com.tencent.mm.sticker.c> pRF;
  private final LinkedList<com.tencent.mm.sticker.c> pRG;
  final d sRo;
  final d sRp;
  
  static
  {
    AppMethodBeat.i(205016);
    sRr = new f.a((byte)0);
    sRq = new com.tencent.mm.sticker.c(new bty(), 0, 6, (byte)0);
    AppMethodBeat.o(205016);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(205015);
    this.sRo = paramd1;
    this.sRp = paramd2;
    this.pRG = new LinkedList();
    this.pRF = new LinkedList();
    AppMethodBeat.o(205015);
  }
  
  public final void cT(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(205014);
    p.h(paramList, "lensList");
    com.tencent.mm.ad.c.b("StickerEffectCallbackWrapper_onMore", (a)new d(this, paramList));
    AppMethodBeat.o(205014);
  }
  
  public final void dM(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(205013);
    p.h(paramList, "lensList");
    com.tencent.mm.ad.c.b("StickerEffectCallbackWrapper_onHistory", (a)new c(this, paramList));
    AppMethodBeat.o(205013);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroid/support/v7/util/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    private final d sRf;
    
    public b(d paramd)
    {
      AppMethodBeat.i(205008);
      this.sRf = paramd;
      AppMethodBeat.o(205008);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(205007);
      this.sRf.ft(paramInt1, paramInt2);
      AppMethodBeat.o(205007);
    }
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205004);
      this.sRf.fq(paramInt1, paramInt2);
      AppMethodBeat.o(205004);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205005);
      this.sRf.fr(paramInt1, paramInt2);
      AppMethodBeat.o(205005);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205006);
      this.sRf.fs(paramInt1, paramInt2);
      AppMethodBeat.o(205006);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.f
 * JD-Core Version:    0.7.0.1
 */