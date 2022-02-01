package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.g;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class j
  implements d
{
  private final String TAG;
  private final RecyclerView.a<?> fQu;
  private String oKX;
  public int oKY;
  private boolean oKZ;
  private final LinkedList<g> oKt;
  private final i oLa;
  
  public j(i parami, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(258);
    this.oLa = parami;
    this.fQu = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.oKt = new LinkedList();
    this.oKY = 1;
    this.oKZ = true;
    AppMethodBeat.o(258);
  }
  
  public final void ad(List<g> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    k.h(paramList, "lensList");
    ad.i(this.TAG, "updateData: " + paramList.size() + ", " + bt.eGN());
    this.oKt.clear();
    this.oKt.addAll((Collection)paramList);
    this.oLa.ad((List)this.oKt);
    int i;
    if (this.oKZ)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.oKX != null) {
          break label152;
        }
        j = this.oKY;
        this.oKZ = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.oLa.AQ(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!k.g(((g)paramList.next()).oKq.Dds, this.oKX)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.oKZ = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.fQu.aq(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void fk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.fQu.ar(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void fl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.fQu.ap(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.fQu.ao(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
  
  public final void setSelection(String paramString)
  {
    this.oKX = paramString;
    this.oKZ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.j
 * JD-Core Version:    0.7.0.1
 */