package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallbackWrapper;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataCallback", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;)V", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getRecommendCallback", "recommendList", "onMore", "", "lensList", "", "onRecommend", "plugin-emojicapture_release"})
public final class e
  implements d
{
  final LinkedList<com.tencent.mm.sticker.c> nxC;
  final c pnH;
  final LinkedList<com.tencent.mm.sticker.c> pnO;
  final c pnP;
  
  public e(c paramc1, c paramc2)
  {
    AppMethodBeat.i(233);
    this.pnP = paramc1;
    this.pnH = paramc2;
    this.pnO = new LinkedList();
    this.nxC = new LinkedList();
    AppMethodBeat.o(233);
  }
  
  public final void cS(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(231);
    k.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerPanelCallbackWrapper_onRecommend", (a)new b(this, paramList));
    AppMethodBeat.o(231);
  }
  
  public final void cT(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(232);
    k.h(paramList, "lensList");
    com.tencent.mm.ac.c.b("StickerPanelCallbackWrapper_onMore", (a)new a(this, paramList));
    AppMethodBeat.o(232);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(e parame, List paramList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(e parame, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.e
 * JD-Core Version:    0.7.0.1
 */