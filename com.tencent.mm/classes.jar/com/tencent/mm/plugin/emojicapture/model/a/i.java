package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class i
  implements c
{
  private final String TAG;
  private final RecyclerView.a<?> fUp;
  private final LinkedList<com.tencent.mm.sticker.c> pnO;
  private String poq;
  public int por;
  private boolean pot;
  private final h pou;
  
  public i(h paramh, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(258);
    this.pou = paramh;
    this.fUp = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.pnO = new LinkedList();
    this.por = 1;
    this.pot = true;
    AppMethodBeat.o(258);
  }
  
  public final void U(List<com.tencent.mm.sticker.c> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    k.h(paramList, "lensList");
    ac.i(this.TAG, "updateData: " + paramList.size() + ", " + bs.eWi());
    this.pnO.clear();
    this.pnO.addAll((Collection)paramList);
    this.pou.U((List)this.pnO);
    int i;
    if (this.pot)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.poq != null) {
          break label152;
        }
        j = this.por;
        this.pot = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.pou.BI(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!k.g(((com.tencent.mm.sticker.c)paramList.next()).GzM.Ewy, this.poq)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.pot = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.fUp.aq(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.fUp.ar(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void fo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.fUp.ap(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.fUp.ao(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
  
  public final void setSelection(String paramString)
  {
    this.poq = paramString;
    this.pot = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.i
 * JD-Core Version:    0.7.0.1
 */