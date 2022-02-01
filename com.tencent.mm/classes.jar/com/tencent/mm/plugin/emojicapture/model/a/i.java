package com.tencent.mm.plugin.emojicapture.model.a;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", "index", "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements c
{
  private final String TAG;
  private String mlM;
  private final RecyclerView.a<?> mlt;
  private final h yhG;
  public int yhH;
  private boolean yhI;
  private final LinkedList<com.tencent.mm.sticker.c> yhj;
  
  public i(h paramh, RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(269369);
    this.yhG = paramh;
    this.mlt = parama;
    this.TAG = "MicroMsg.StickerRecommendData";
    this.yhj = new LinkedList();
    this.yhH = 1;
    this.yhI = true;
    AppMethodBeat.o(269369);
  }
  
  public final void apm(String paramString)
  {
    this.mlM = paramString;
    this.yhI = true;
  }
  
  public final void bz(List<com.tencent.mm.sticker.c> paramList)
  {
    int j = 0;
    AppMethodBeat.i(253);
    s.u(paramList, "lensList");
    Log.i(this.TAG, "updateData: " + paramList.size() + ", " + Util.getStack());
    this.yhj.clear();
    this.yhj.addAll((Collection)paramList);
    this.yhG.bz((List)this.yhj);
    int i;
    if (this.yhI)
    {
      if (((Collection)paramList).isEmpty()) {
        break label147;
      }
      i = 1;
      if (i != 0)
      {
        if (this.mlM != null) {
          break label152;
        }
        j = this.yhH;
        this.yhI = false;
      }
    }
    label147:
    label152:
    label161:
    label219:
    for (;;)
    {
      this.yhG.KS(j);
      AppMethodBeat.o(253);
      return;
      i = 0;
      break;
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext()) {
        if (!s.p(((com.tencent.mm.sticker.c)paramList.next()).acBO.LensId, this.mlM)) {}
      }
      for (;;)
      {
        if (i <= 0) {
          break label219;
        }
        this.yhI = false;
        j = i;
        break;
        i += 1;
        break label161;
        i = -1;
      }
    }
  }
  
  public final void gX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254);
    this.mlt.bA(paramInt1, paramInt2);
    AppMethodBeat.o(254);
  }
  
  public final void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255);
    this.mlt.bB(paramInt1, paramInt2);
    AppMethodBeat.o(255);
  }
  
  public final void gZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256);
    this.mlt.bz(paramInt1, paramInt2);
    AppMethodBeat.o(256);
  }
  
  public final void ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257);
    this.mlt.by(paramInt1, paramInt2);
    AppMethodBeat.o(257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.i
 * JD-Core Version:    0.7.0.1
 */