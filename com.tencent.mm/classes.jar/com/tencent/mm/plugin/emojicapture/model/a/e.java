package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallbackWrapper;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataCallback", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;)V", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getRecommendCallback", "recommendList", "onMore", "", "lensList", "", "onRecommend", "plugin-emojicapture_release"})
public final class e
  implements d
{
  final LinkedList<com.tencent.mm.sticker.c> oeJ;
  final c pXM;
  final LinkedList<com.tencent.mm.sticker.c> pXT;
  final c pXU;
  
  public e(c paramc1, c paramc2)
  {
    AppMethodBeat.i(233);
    this.pXU = paramc1;
    this.pXM = paramc2;
    this.pXT = new LinkedList();
    this.oeJ = new LinkedList();
    AppMethodBeat.o(233);
  }
  
  public final void cV(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(231);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerPanelCallbackWrapper_onRecommend", (a)new b(this, paramList));
    AppMethodBeat.o(231);
  }
  
  public final void cW(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(232);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerPanelCallbackWrapper_onMore", (a)new a(this, paramList));
    AppMethodBeat.o(232);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(e parame, List paramList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(e parame, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.e
 * JD-Core Version:    0.7.0.1
 */