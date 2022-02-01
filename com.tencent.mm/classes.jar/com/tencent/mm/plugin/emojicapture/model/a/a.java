package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.g;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/capture/DataCallbackHolder;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "()V", "dataCallback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setDataCallback", "callback", "updateData", "lensList", "plugin-emojicapture_release"})
public final class a
  implements d
{
  public List<g> dataList;
  public d oKj;
  
  public a()
  {
    AppMethodBeat.i(209);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(209);
  }
  
  public final void ad(List<g> paramList)
  {
    AppMethodBeat.i(204);
    k.h(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.oKj;
    if (locald != null)
    {
      locald.ad(paramList);
      AppMethodBeat.o(204);
      return;
    }
    AppMethodBeat.o(204);
  }
  
  public final void fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205);
    d locald = this.oKj;
    if (locald != null)
    {
      locald.fj(paramInt1, paramInt2);
      AppMethodBeat.o(205);
      return;
    }
    AppMethodBeat.o(205);
  }
  
  public final void fk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206);
    d locald = this.oKj;
    if (locald != null)
    {
      locald.fk(paramInt1, paramInt2);
      AppMethodBeat.o(206);
      return;
    }
    AppMethodBeat.o(206);
  }
  
  public final void fl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207);
    d locald = this.oKj;
    if (locald != null)
    {
      locald.fl(paramInt1, paramInt2);
      AppMethodBeat.o(207);
      return;
    }
    AppMethodBeat.o(207);
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208);
    d locald = this.oKj;
    if (locald != null)
    {
      locald.fm(paramInt1, paramInt2);
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