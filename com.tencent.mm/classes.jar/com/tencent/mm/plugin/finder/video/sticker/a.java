package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a
  implements d
{
  private List<c> dataList;
  private d tcq;
  
  public a()
  {
    AppMethodBeat.i(205601);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(205601);
  }
  
  public final void V(List<c> paramList)
  {
    AppMethodBeat.i(205596);
    p.h(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.tcq;
    if (locald != null)
    {
      locald.V(paramList);
      AppMethodBeat.o(205596);
      return;
    }
    AppMethodBeat.o(205596);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(205595);
    this.tcq = paramd;
    paramd.V(this.dataList);
    paramd.fr(0, this.dataList.size());
    AppMethodBeat.o(205595);
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205597);
    d locald = this.tcq;
    if (locald != null)
    {
      locald.fr(paramInt1, paramInt2);
      AppMethodBeat.o(205597);
      return;
    }
    AppMethodBeat.o(205597);
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205598);
    d locald = this.tcq;
    if (locald != null)
    {
      locald.fs(paramInt1, paramInt2);
      AppMethodBeat.o(205598);
      return;
    }
    AppMethodBeat.o(205598);
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205599);
    d locald = this.tcq;
    if (locald != null)
    {
      locald.ft(paramInt1, paramInt2);
      AppMethodBeat.o(205599);
      return;
    }
    AppMethodBeat.o(205599);
  }
  
  public final void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205600);
    d locald = this.tcq;
    if (locald != null)
    {
      locald.fu(paramInt1, paramInt2);
      AppMethodBeat.o(205600);
      return;
    }
    AppMethodBeat.o(205600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */