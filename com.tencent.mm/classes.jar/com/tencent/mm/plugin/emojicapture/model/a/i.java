package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class i
  implements c
{
  private final String TAG;
  private final RecyclerView.a<?> gnR;
  private String pRQ;
  public int pRR;
  private boolean pRS;
  private final h pRT;
  private final LinkedList<com.tencent.mm.sticker.c> pRo;
  
  public i(h paramh, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(258);
    this.pRT = paramh;
    this.gnR = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.pRo = new LinkedList();
    this.pRR = 1;
    this.pRS = true;
    AppMethodBeat.o(258);
  }
  
  public final void V(List<com.tencent.mm.sticker.c> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    p.h(paramList, "lensList");
    ad.i(this.TAG, "updateData: " + paramList.size() + ", " + bt.flS());
    this.pRo.clear();
    this.pRo.addAll((Collection)paramList);
    this.pRT.V((List)this.pRo);
    int i;
    if (this.pRS)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.pRQ != null) {
          break label152;
        }
        j = this.pRR;
        this.pRS = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.pRT.Cq(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!p.i(((com.tencent.mm.sticker.c)paramList.next()).IlG.Geb, this.pRQ)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.pRS = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.gnR.ar(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.gnR.as(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.gnR.aq(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.gnR.ap(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
  
  public final void setSelection(String paramString)
  {
    this.pRQ = paramString;
    this.pRS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.i
 * JD-Core Version:    0.7.0.1
 */