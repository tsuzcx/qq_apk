package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/capture/DataCallbackHolder;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "()V", "dataCallback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setDataCallback", "callback", "updateData", "lensList", "plugin-emojicapture_release"})
public final class a
  implements c
{
  public List<com.tencent.mm.sticker.c> dataList;
  public c roK;
  
  public a()
  {
    AppMethodBeat.i(209);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(209);
  }
  
  public final void ad(List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(204);
    p.h(paramList, "lensList");
    this.dataList = paramList;
    c localc = this.roK;
    if (localc != null)
    {
      localc.ad(paramList);
      AppMethodBeat.o(204);
      return;
    }
    AppMethodBeat.o(204);
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205);
    c localc = this.roK;
    if (localc != null)
    {
      localc.fH(paramInt1, paramInt2);
      AppMethodBeat.o(205);
      return;
    }
    AppMethodBeat.o(205);
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206);
    c localc = this.roK;
    if (localc != null)
    {
      localc.fI(paramInt1, paramInt2);
      AppMethodBeat.o(206);
      return;
    }
    AppMethodBeat.o(206);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207);
    c localc = this.roK;
    if (localc != null)
    {
      localc.fJ(paramInt1, paramInt2);
      AppMethodBeat.o(207);
      return;
    }
    AppMethodBeat.o(207);
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208);
    c localc = this.roK;
    if (localc != null)
    {
      localc.fK(paramInt1, paramInt2);
      AppMethodBeat.o(208);
      return;
    }
    AppMethodBeat.o(208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.a
 * JD-Core Version:    0.7.0.1
 */