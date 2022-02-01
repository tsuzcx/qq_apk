package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "()V", "callback", "dataList", "", "Lcom/tencent/mm/sticker/LensItem;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setCallback", "updateData", "lensList", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d
{
  private d GuV;
  private List<c> dataList;
  
  public a()
  {
    AppMethodBeat.i(335873);
    this.dataList = ((List)new ArrayList());
    AppMethodBeat.o(335873);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(335878);
    this.GuV = paramd;
    paramd.bz(this.dataList);
    paramd.gX(0, this.dataList.size());
    AppMethodBeat.o(335878);
  }
  
  public final void bz(List<c> paramList)
  {
    AppMethodBeat.i(335883);
    s.u(paramList, "lensList");
    this.dataList = paramList;
    d locald = this.GuV;
    if (locald != null) {
      locald.bz(paramList);
    }
    AppMethodBeat.o(335883);
  }
  
  public final void gX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335891);
    d locald = this.GuV;
    if (locald != null) {
      locald.gX(paramInt1, paramInt2);
    }
    AppMethodBeat.o(335891);
  }
  
  public final void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335897);
    d locald = this.GuV;
    if (locald != null) {
      locald.gY(paramInt1, paramInt2);
    }
    AppMethodBeat.o(335897);
  }
  
  public final void gZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335904);
    d locald = this.GuV;
    if (locald != null) {
      locald.gZ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(335904);
  }
  
  public final void ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335908);
    d locald = this.GuV;
    if (locald != null) {
      locald.ha(paramInt1, paramInt2);
    }
    AppMethodBeat.o(335908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.a
 * JD-Core Version:    0.7.0.1
 */