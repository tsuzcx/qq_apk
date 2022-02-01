package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.g;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a
  implements d
{
  private d LdC;
  private List<g> dataList;
  
  public a()
  {
    AppMethodBeat.i(199947);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(199947);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(199941);
    this.LdC = paramd;
    paramd.ad(this.dataList);
    paramd.fj(0, this.dataList.size());
    AppMethodBeat.o(199941);
  }
  
  public final void ad(List<g> paramList)
  {
    AppMethodBeat.i(199942);
    k.h(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.LdC;
    if (locald != null)
    {
      locald.ad(paramList);
      AppMethodBeat.o(199942);
      return;
    }
    AppMethodBeat.o(199942);
  }
  
  public final void fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199943);
    d locald = this.LdC;
    if (locald != null)
    {
      locald.fj(paramInt1, paramInt2);
      AppMethodBeat.o(199943);
      return;
    }
    AppMethodBeat.o(199943);
  }
  
  public final void fk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199944);
    d locald = this.LdC;
    if (locald != null)
    {
      locald.fk(paramInt1, paramInt2);
      AppMethodBeat.o(199944);
      return;
    }
    AppMethodBeat.o(199944);
  }
  
  public final void fl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199945);
    d locald = this.LdC;
    if (locald != null)
    {
      locald.fl(paramInt1, paramInt2);
      AppMethodBeat.o(199945);
      return;
    }
    AppMethodBeat.o(199945);
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199946);
    d locald = this.LdC;
    if (locald != null)
    {
      locald.fm(paramInt1, paramInt2);
      AppMethodBeat.o(199946);
      return;
    }
    AppMethodBeat.o(199946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */