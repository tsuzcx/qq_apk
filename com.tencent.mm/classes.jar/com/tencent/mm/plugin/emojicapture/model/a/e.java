package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallbackWrapper;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataCallback", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;)V", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getRecommendCallback", "recommendList", "onMore", "", "lensList", "", "onRecommend", "plugin-emojicapture_release"})
public final class e
  implements d
{
  final LinkedList<com.tencent.mm.sticker.c> ppH;
  final c roK;
  final LinkedList<com.tencent.mm.sticker.c> roR;
  final c roS;
  
  public e(c paramc1, c paramc2)
  {
    AppMethodBeat.i(233);
    this.roS = paramc1;
    this.roK = paramc2;
    this.roR = new LinkedList();
    this.ppH = new LinkedList();
    AppMethodBeat.o(233);
  }
  
  public final void dk(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(231);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.d.b("StickerPanelCallbackWrapper_onRecommend", (a)new b(this, paramList));
    AppMethodBeat.o(231);
  }
  
  public final void dl(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(232);
    p.h(paramList, "lensList");
    com.tencent.mm.ac.d.b("StickerPanelCallbackWrapper_onMore", (a)new a(this, paramList));
    AppMethodBeat.o(232);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(e parame, List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
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