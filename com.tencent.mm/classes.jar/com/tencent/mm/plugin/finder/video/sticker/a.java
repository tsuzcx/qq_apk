package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a
  implements d
{
  private List<c> dataList;
  private d sRf;
  
  public a()
  {
    AppMethodBeat.i(204976);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(204976);
  }
  
  public final void V(List<c> paramList)
  {
    AppMethodBeat.i(204971);
    p.h(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.sRf;
    if (locald != null)
    {
      locald.V(paramList);
      AppMethodBeat.o(204971);
      return;
    }
    AppMethodBeat.o(204971);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(204970);
    this.sRf = paramd;
    paramd.V(this.dataList);
    paramd.fq(0, this.dataList.size());
    AppMethodBeat.o(204970);
  }
  
  public final void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204972);
    d locald = this.sRf;
    if (locald != null)
    {
      locald.fq(paramInt1, paramInt2);
      AppMethodBeat.o(204972);
      return;
    }
    AppMethodBeat.o(204972);
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204973);
    d locald = this.sRf;
    if (locald != null)
    {
      locald.fr(paramInt1, paramInt2);
      AppMethodBeat.o(204973);
      return;
    }
    AppMethodBeat.o(204973);
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204974);
    d locald = this.sRf;
    if (locald != null)
    {
      locald.fs(paramInt1, paramInt2);
      AppMethodBeat.o(204974);
      return;
    }
    AppMethodBeat.o(204974);
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204975);
    d locald = this.sRf;
    if (locald != null)
    {
      locald.ft(paramInt1, paramInt2);
      AppMethodBeat.o(204975);
      return;
    }
    AppMethodBeat.o(204975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */