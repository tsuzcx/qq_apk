package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sticker.g;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder_release"})
public final class f
  implements c
{
  private static final g LdQ;
  public static final a LdR;
  final d LdO;
  final d LdP;
  private final LinkedList<g> oKM;
  private final LinkedList<g> oKN;
  
  static
  {
    AppMethodBeat.i(199995);
    LdR = new a((byte)0);
    LdQ = new g(new blp(), 0, 6, (byte)0);
    AppMethodBeat.o(199995);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(199994);
    this.LdO = paramd1;
    this.LdP = paramd2;
    this.oKN = new LinkedList();
    this.oKM = new LinkedList();
    AppMethodBeat.o(199994);
  }
  
  public final void cR(final List<g> paramList)
  {
    AppMethodBeat.i(199993);
    k.h(paramList, "lensList");
    com.tencent.mm.ad.c.b("StickerEffectCallbackWrapper_onMore", (a)new d(this, paramList));
    AppMethodBeat.o(199993);
  }
  
  public final void hF(final List<g> paramList)
  {
    AppMethodBeat.i(199992);
    k.h(paramList, "lensList");
    com.tencent.mm.ad.c.b("StickerEffectCallbackWrapper_onHistory", (a)new c(this, paramList));
    AppMethodBeat.o(199992);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$Companion;", "", "()V", "EmptyLensItem", "Lcom/tencent/mm/sticker/LensItem;", "getEmptyLensItem", "()Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroid/support/v7/util/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
  public static final class b
    implements android.support.v7.h.d
  {
    private final d LdC;
    
    public b(d paramd)
    {
      AppMethodBeat.i(199987);
      this.LdC = paramd;
      AppMethodBeat.o(199987);
    }
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199983);
      this.LdC.fj(paramInt1, paramInt2);
      AppMethodBeat.o(199983);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199984);
      this.LdC.fk(paramInt1, paramInt2);
      AppMethodBeat.o(199984);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199985);
      this.LdC.fl(paramInt1, paramInt2);
      AppMethodBeat.o(199985);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(199986);
      this.LdC.fm(paramInt1, paramInt2);
      AppMethodBeat.o(199986);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(f paramf, List paramList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.f
 * JD-Core Version:    0.7.0.1
 */