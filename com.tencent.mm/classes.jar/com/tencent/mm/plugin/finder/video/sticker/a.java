package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a
  implements d
{
  private d ASW;
  private List<c> dataList;
  
  public a()
  {
    AppMethodBeat.i(290574);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(290574);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(290567);
    this.ASW = paramd;
    paramd.aa(this.dataList);
    paramd.ge(0, this.dataList.size());
    AppMethodBeat.o(290567);
  }
  
  public final void aa(List<c> paramList)
  {
    AppMethodBeat.i(290569);
    p.k(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.ASW;
    if (locald != null)
    {
      locald.aa(paramList);
      AppMethodBeat.o(290569);
      return;
    }
    AppMethodBeat.o(290569);
  }
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290570);
    d locald = this.ASW;
    if (locald != null)
    {
      locald.ge(paramInt1, paramInt2);
      AppMethodBeat.o(290570);
      return;
    }
    AppMethodBeat.o(290570);
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290571);
    d locald = this.ASW;
    if (locald != null)
    {
      locald.gf(paramInt1, paramInt2);
      AppMethodBeat.o(290571);
      return;
    }
    AppMethodBeat.o(290571);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290572);
    d locald = this.ASW;
    if (locald != null)
    {
      locald.gg(paramInt1, paramInt2);
      AppMethodBeat.o(290572);
      return;
    }
    AppMethodBeat.o(290572);
  }
  
  public final void gh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290573);
    d locald = this.ASW;
    if (locald != null)
    {
      locald.gh(paramInt1, paramInt2);
      AppMethodBeat.o(290573);
      return;
    }
    AppMethodBeat.o(290573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */