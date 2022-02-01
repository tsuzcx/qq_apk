package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class i
  implements c
{
  private final String TAG;
  private final RecyclerView.a<?> gqn;
  private final LinkedList<com.tencent.mm.sticker.c> pXT;
  private String pYv;
  public int pYw;
  private boolean pYx;
  private final h pYy;
  
  public i(h paramh, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(258);
    this.pYy = paramh;
    this.gqn = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.pXT = new LinkedList();
    this.pYw = 1;
    this.pYx = true;
    AppMethodBeat.o(258);
  }
  
  public final void V(List<com.tencent.mm.sticker.c> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    p.h(paramList, "lensList");
    ae.i(this.TAG, "updateData: " + paramList.size() + ", " + bu.fpN());
    this.pXT.clear();
    this.pXT.addAll((Collection)paramList);
    this.pYy.V((List)this.pXT);
    int i;
    if (this.pYx)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.pYv != null) {
          break label152;
        }
        j = this.pYw;
        this.pYx = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.pYy.CC(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!p.i(((com.tencent.mm.sticker.c)paramList.next()).IFR.GwI, this.pYv)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.pYx = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.gqn.ar(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.gqn.as(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.gqn.aq(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.gqn.ap(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
  
  public final void setSelection(String paramString)
  {
    this.pYv = paramString;
    this.pYx = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.i
 * JD-Core Version:    0.7.0.1
 */