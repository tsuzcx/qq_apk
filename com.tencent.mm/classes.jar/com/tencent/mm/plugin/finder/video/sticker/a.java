package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a
  implements d
{
  private List<c> dataList;
  private d rUu;
  
  public a()
  {
    AppMethodBeat.i(204015);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(204015);
  }
  
  public final void U(List<c> paramList)
  {
    AppMethodBeat.i(204010);
    k.h(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.rUu;
    if (locald != null)
    {
      locald.U(paramList);
      AppMethodBeat.o(204010);
      return;
    }
    AppMethodBeat.o(204010);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(204009);
    this.rUu = paramd;
    paramd.U(this.dataList);
    paramd.fm(0, this.dataList.size());
    AppMethodBeat.o(204009);
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204011);
    d locald = this.rUu;
    if (locald != null)
    {
      locald.fm(paramInt1, paramInt2);
      AppMethodBeat.o(204011);
      return;
    }
    AppMethodBeat.o(204011);
  }
  
  public final void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204012);
    d locald = this.rUu;
    if (locald != null)
    {
      locald.fn(paramInt1, paramInt2);
      AppMethodBeat.o(204012);
      return;
    }
    AppMethodBeat.o(204012);
  }
  
  public final void fo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204013);
    d locald = this.rUu;
    if (locald != null)
    {
      locald.fo(paramInt1, paramInt2);
      AppMethodBeat.o(204013);
      return;
    }
    AppMethodBeat.o(204013);
  }
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204014);
    d locald = this.rUu;
    if (locald != null)
    {
      locald.fp(paramInt1, paramInt2);
      AppMethodBeat.o(204014);
      return;
    }
    AppMethodBeat.o(204014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */