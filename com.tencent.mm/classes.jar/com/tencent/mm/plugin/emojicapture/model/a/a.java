package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/capture/DataCallbackHolder;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "()V", "dataCallback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setDataCallback", "callback", "updateData", "lensList", "plugin-emojicapture_release"})
public final class a
  implements c
{
  public List<com.tencent.mm.sticker.c> dataList;
  public c uUq;
  
  public a()
  {
    AppMethodBeat.i(209);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(209);
  }
  
  public final void aa(List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(204);
    p.k(paramList, "lensList");
    this.dataList = paramList;
    c localc = this.uUq;
    if (localc != null)
    {
      localc.aa(paramList);
      AppMethodBeat.o(204);
      return;
    }
    AppMethodBeat.o(204);
  }
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205);
    c localc = this.uUq;
    if (localc != null)
    {
      localc.ge(paramInt1, paramInt2);
      AppMethodBeat.o(205);
      return;
    }
    AppMethodBeat.o(205);
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206);
    c localc = this.uUq;
    if (localc != null)
    {
      localc.gf(paramInt1, paramInt2);
      AppMethodBeat.o(206);
      return;
    }
    AppMethodBeat.o(206);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207);
    c localc = this.uUq;
    if (localc != null)
    {
      localc.gg(paramInt1, paramInt2);
      AppMethodBeat.o(207);
      return;
    }
    AppMethodBeat.o(207);
  }
  
  public final void gh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208);
    c localc = this.uUq;
    if (localc != null)
    {
      localc.gh(paramInt1, paramInt2);
      AppMethodBeat.o(208);
      return;
    }
    AppMethodBeat.o(208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.a
 * JD-Core Version:    0.7.0.1
 */