package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class i
  implements c
{
  private final String TAG;
  private final RecyclerView.a<?> hbg;
  private final LinkedList<com.tencent.mm.sticker.c> roR;
  private String rpt;
  public int rpu;
  private boolean rpv;
  private final h rpw;
  
  public i(h paramh, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(258);
    this.rpw = paramh;
    this.hbg = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.roR = new LinkedList();
    this.rpu = 1;
    this.rpv = true;
    AppMethodBeat.o(258);
  }
  
  public final void ad(List<com.tencent.mm.sticker.c> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    p.h(paramList, "lensList");
    Log.i(this.TAG, "updateData: " + paramList.size() + ", " + Util.getStack());
    this.roR.clear();
    this.roR.addAll((Collection)paramList);
    this.rpw.ad((List)this.roR);
    int i;
    if (this.rpv)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.rpt != null) {
          break label152;
        }
        j = this.rpu;
        this.rpv = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.rpw.Gn(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!p.j(((com.tencent.mm.sticker.c)paramList.next()).NMJ.Lso, this.rpt)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.rpv = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.hbg.as(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.hbg.at(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.hbg.ar(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.hbg.aq(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
  
  public final void setSelection(String paramString)
  {
    this.rpt = paramString;
    this.rpv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.i
 * JD-Core Version:    0.7.0.1
 */