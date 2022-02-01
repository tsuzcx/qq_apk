package com.tencent.mm.plugin.finder.video.sticker;

import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhp;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "moreCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getHistoryCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getMoreCallback", "moreList", "onHistory", "", "lensList", "", "onMore", "Companion", "ListUpdateCallbackWrapper", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements c
{
  public static final f.a Gvd;
  private static final com.tencent.mm.sticker.c Gvg;
  final d Gve;
  final d Gvf;
  private final LinkedList<com.tencent.mm.sticker.c> yhx;
  private final LinkedList<com.tencent.mm.sticker.c> yhy;
  
  static
  {
    AppMethodBeat.i(335910);
    Gvd = new f.a((byte)0);
    Gvg = new com.tencent.mm.sticker.c(new dhp(), 0, 6, (byte)0);
    AppMethodBeat.o(335910);
  }
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(335887);
    this.Gve = paramd1;
    this.Gvf = paramd2;
    this.yhy = new LinkedList();
    this.yhx = new LinkedList();
    AppMethodBeat.o(335887);
  }
  
  public final void fj(List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(335922);
    s.u(paramList, "lensList");
    com.tencent.mm.ae.d.d("StickerEffectCallbackWrapper_onMore", (a)new d(paramList, this));
    AppMethodBeat.o(335922);
  }
  
  public final void hL(List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(335915);
    s.u(paramList, "lensList");
    com.tencent.mm.ae.d.d("StickerEffectCallbackWrapper_onHistory", (a)new c(paramList, this));
    AppMethodBeat.o(335915);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectCallbackWrapper$ListUpdateCallbackWrapper;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q
  {
    private final d GuV;
    
    public b(d paramd)
    {
      AppMethodBeat.i(335861);
      this.GuV = paramd;
      AppMethodBeat.o(335861);
    }
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335869);
      this.GuV.gX(paramInt1, paramInt2);
      AppMethodBeat.o(335869);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335880);
      this.GuV.gY(paramInt1, paramInt2);
      AppMethodBeat.o(335880);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335889);
      this.GuV.gZ(paramInt1, paramInt2);
      AppMethodBeat.o(335889);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(335901);
      this.GuV.ha(paramInt1, paramInt2);
      AppMethodBeat.o(335901);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(List<com.tencent.mm.sticker.c> paramList, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(List<com.tencent.mm.sticker.c> paramList, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.f
 * JD-Core Version:    0.7.0.1
 */