package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.sticker.g;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallbackWrapper;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataCallback", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;)V", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getRecommendCallback", "recommendList", "onMore", "", "lensList", "", "onRecommend", "plugin-emojicapture_release"})
public final class f
  implements e
{
  final LinkedList<g> mVb;
  final d oKj;
  final LinkedList<g> oKt;
  final d oKu;
  
  public f(d paramd1, d paramd2)
  {
    AppMethodBeat.i(233);
    this.oKu = paramd1;
    this.oKj = paramd2;
    this.oKt = new LinkedList();
    this.mVb = new LinkedList();
    AppMethodBeat.o(233);
  }
  
  public final void cQ(final List<g> paramList)
  {
    AppMethodBeat.i(231);
    k.h(paramList, "lensList");
    c.b("StickerPanelCallbackWrapper_onRecommend", (a)new c(this, paramList));
    AppMethodBeat.o(231);
  }
  
  public final void cR(final List<g> paramList)
  {
    AppMethodBeat.i(232);
    k.h(paramList, "lensList");
    c.b("StickerPanelCallbackWrapper_onMore", (a)new b(this, paramList));
    AppMethodBeat.o(232);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(f paramf, List paramList)
    {
      super();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f
 * JD-Core Version:    0.7.0.1
 */