package com.tencent.mm.plugin.finder.video.sticker;

import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqv;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder_release"})
public final class f
  implements c
{
  private static final com.tencent.mm.sticker.c ATh;
  public static final a ATi;
  final d ATf;
  final d ATg;
  private final LinkedList<com.tencent.mm.sticker.c> uUO;
  private final LinkedList<com.tencent.mm.sticker.c> uUP;
  
  static
  {
    AppMethodBeat.i(233927);
    ATi = new a((byte)0);
    ATh = new com.tencent.mm.sticker.c(new cqv(), 0, 6, (byte)0);
    AppMethodBeat.o(233927);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(233925);
    this.ATf = paramd1;
    this.ATg = paramd2;
    this.uUP = new LinkedList();
    this.uUO = new LinkedList();
    AppMethodBeat.o(233925);
  }
  
  public final void dm(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(233923);
    p.k(paramList, "lensList");
    com.tencent.mm.ae.d.b("StickerEffectCallbackWrapper_onMore", (a)new d(this, paramList));
    AppMethodBeat.o(233923);
  }
  
  public final void eZ(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(233922);
    p.k(paramList, "lensList");
    com.tencent.mm.ae.d.b("StickerEffectCallbackWrapper_onHistory", (a)new c(this, paramList));
    AppMethodBeat.o(233922);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$Companion;", "", "()V", "EmptyLensItem", "Lcom/tencent/mm/sticker/LensItem;", "getEmptyLensItem", "()Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
  public static final class b
    implements s
  {
    private final d ASW;
    
    public b(d paramd)
    {
      AppMethodBeat.i(289134);
      this.ASW = paramd;
      AppMethodBeat.o(289134);
    }
    
    public final void W(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289128);
      this.ASW.ge(paramInt1, paramInt2);
      AppMethodBeat.o(289128);
    }
    
    public final void ac(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289130);
      this.ASW.gf(paramInt1, paramInt2);
      AppMethodBeat.o(289130);
    }
    
    public final void ad(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289131);
      this.ASW.gg(paramInt1, paramInt2);
      AppMethodBeat.o(289131);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(289133);
      this.ASW.gh(paramInt1, paramInt2);
      AppMethodBeat.o(289133);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.f
 * JD-Core Version:    0.7.0.1
 */