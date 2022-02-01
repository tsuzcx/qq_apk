package com.tencent.mm.plugin.emojicapture.model.a;

import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallbackWrapper;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataCallback", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;)V", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getRecommendCallback", "recommendList", "onMore", "", "lensList", "", "onRecommend", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements d
{
  final LinkedList<com.tencent.mm.sticker.c> vEn;
  final c yhb;
  final c yhi;
  final LinkedList<com.tencent.mm.sticker.c> yhj;
  
  public e(c paramc1, c paramc2)
  {
    AppMethodBeat.i(233);
    this.yhi = paramc1;
    this.yhb = paramc2;
    this.yhj = new LinkedList();
    this.vEn = new LinkedList();
    AppMethodBeat.o(233);
  }
  
  public final void fi(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(231);
    s.u(paramList, "lensList");
    com.tencent.mm.ae.d.d("StickerPanelCallbackWrapper_onRecommend", (a)new b(this, paramList));
    AppMethodBeat.o(231);
  }
  
  public final void fj(final List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(232);
    s.u(paramList, "lensList");
    com.tencent.mm.ae.d.d("StickerPanelCallbackWrapper_onMore", (a)new a(this, paramList));
    AppMethodBeat.o(232);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(e parame, List<com.tencent.mm.sticker.c> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(e parame, List<com.tencent.mm.sticker.c> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.e
 * JD-Core Version:    0.7.0.1
 */