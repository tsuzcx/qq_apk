package com.tencent.mm.plugin.emojicapture.model.a;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class i
  implements c
{
  private final String TAG;
  private final RecyclerView.a<?> jMq;
  private String uUZ;
  private final LinkedList<com.tencent.mm.sticker.c> uUx;
  public int uVa;
  private boolean uVb;
  private final h uVc;
  
  public i(h paramh, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(204673);
    this.uVc = paramh;
    this.jMq = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.uUx = new LinkedList();
    this.uVa = 1;
    this.uVb = true;
    AppMethodBeat.o(204673);
  }
  
  public final void aa(List<com.tencent.mm.sticker.c> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    p.k(paramList, "lensList");
    Log.i(this.TAG, "updateData: " + paramList.size() + ", " + Util.getStack());
    this.uUx.clear();
    this.uUx.addAll((Collection)paramList);
    this.uVc.aa((List)this.uUx);
    int i;
    if (this.uVb)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.uUZ != null) {
          break label152;
        }
        j = this.uVa;
        this.uVb = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.uVc.JU(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!p.h(((com.tencent.mm.sticker.c)paramList.next()).Vat.LensId, this.uUZ)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.uVb = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void avm(String paramString)
  {
    this.uUZ = paramString;
    this.uVb = true;
  }
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.jMq.aG(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.jMq.aH(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.jMq.aF(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void gh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.jMq.aE(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.i
 * JD-Core Version:    0.7.0.1
 */