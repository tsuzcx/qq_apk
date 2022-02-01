package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpl;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder_release"})
public final class f
  implements c
{
  private static final com.tencent.mm.sticker.c rUI;
  public static final f.a rUJ;
  private final LinkedList<com.tencent.mm.sticker.c> pof;
  private final LinkedList<com.tencent.mm.sticker.c> pog;
  final d rUG;
  final d rUH;
  
  static
  {
    AppMethodBeat.i(204063);
    rUJ = new f.a((byte)0);
    rUI = new com.tencent.mm.sticker.c(new bpl(), 0, 6, (byte)0);
    AppMethodBeat.o(204063);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(204062);
    this.rUG = paramd1;
    this.rUH = paramd2;
    this.pog = new LinkedList();
    this.pof = new LinkedList();
    AppMethodBeat.o(204062);
  }
  
  public final void cT(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(204061);
    k.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerEffectCallbackWrapper_onMore", (a)new d(this, paramList));
    AppMethodBeat.o(204061);
  }
  
  public final void dD(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(204060);
    k.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerEffectCallbackWrapper_onHistory", (a)new c(this, paramList));
    AppMethodBeat.o(204060);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroid/support/v7/util/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    private final d rUu;
    
    public b(d paramd)
    {
      AppMethodBeat.i(204055);
      this.rUu = paramd;
      AppMethodBeat.o(204055);
    }
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204051);
      this.rUu.fm(paramInt1, paramInt2);
      AppMethodBeat.o(204051);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204052);
      this.rUu.fn(paramInt1, paramInt2);
      AppMethodBeat.o(204052);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204053);
      this.rUu.fo(paramInt1, paramInt2);
      AppMethodBeat.o(204053);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(204054);
      this.rUu.fp(paramInt1, paramInt2);
      AppMethodBeat.o(204054);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(f paramf, List paramList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
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