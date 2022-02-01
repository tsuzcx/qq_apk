package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/capture/DataCallbackHolder;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "()V", "dataCallback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setDataCallback", "callback", "updateData", "lensList", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public List<com.tencent.mm.sticker.c> dataList;
  public c yhb;
  
  public a()
  {
    AppMethodBeat.i(209);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(209);
  }
  
  public final void bz(List<com.tencent.mm.sticker.c> paramList)
  {
    AppMethodBeat.i(204);
    s.u(paramList, "lensList");
    this.dataList = paramList;
    c localc = this.yhb;
    if (localc != null) {
      localc.bz(paramList);
    }
    AppMethodBeat.o(204);
  }
  
  public final void gX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205);
    c localc = this.yhb;
    if (localc != null) {
      localc.gX(paramInt1, paramInt2);
    }
    AppMethodBeat.o(205);
  }
  
  public final void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206);
    c localc = this.yhb;
    if (localc != null) {
      localc.gY(paramInt1, paramInt2);
    }
    AppMethodBeat.o(206);
  }
  
  public final void gZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207);
    c localc = this.yhb;
    if (localc != null) {
      localc.gZ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(207);
  }
  
  public final void ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208);
    c localc = this.yhb;
    if (localc != null) {
      localc.ha(paramInt1, paramInt2);
    }
    AppMethodBeat.o(208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.a
 * JD-Core Version:    0.7.0.1
 */