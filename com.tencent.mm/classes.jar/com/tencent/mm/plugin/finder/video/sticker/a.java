package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder_release"})
public final class a
  implements d
{
  private List<c> dataList;
  private d wiO;
  
  public a()
  {
    AppMethodBeat.i(254553);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(254553);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(254547);
    this.wiO = paramd;
    paramd.ad(this.dataList);
    paramd.fH(0, this.dataList.size());
    AppMethodBeat.o(254547);
  }
  
  public final void ad(List<c> paramList)
  {
    AppMethodBeat.i(254548);
    p.h(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.wiO;
    if (locald != null)
    {
      locald.ad(paramList);
      AppMethodBeat.o(254548);
      return;
    }
    AppMethodBeat.o(254548);
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254549);
    d locald = this.wiO;
    if (locald != null)
    {
      locald.fH(paramInt1, paramInt2);
      AppMethodBeat.o(254549);
      return;
    }
    AppMethodBeat.o(254549);
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254550);
    d locald = this.wiO;
    if (locald != null)
    {
      locald.fI(paramInt1, paramInt2);
      AppMethodBeat.o(254550);
      return;
    }
    AppMethodBeat.o(254550);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254551);
    d locald = this.wiO;
    if (locald != null)
    {
      locald.fJ(paramInt1, paramInt2);
      AppMethodBeat.o(254551);
      return;
    }
    AppMethodBeat.o(254551);
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254552);
    d locald = this.wiO;
    if (locald != null)
    {
      locald.fK(paramInt1, paramInt2);
      AppMethodBeat.o(254552);
      return;
    }
    AppMethodBeat.o(254552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */