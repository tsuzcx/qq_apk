package com.tencent.mm.plugin.livelist;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/livelist/MMLiveListAdapterCallback;", "liveList", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "needScrollData", "", "(Lcom/tencent/mm/plugin/livelist/MMLiveList;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Z)V", "getLiveList", "()Lcom/tencent/mm/plugin/livelist/MMLiveList;", "needBindClickEvent", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "scrollToPosition", "Companion", "plugin-livelist_release"})
public final class h<T extends b>
  extends WxRecyclerAdapter<T>
  implements e
{
  public static final a Eiu;
  private final MMLiveList<T> Eit;
  
  static
  {
    AppMethodBeat.i(217813);
    Eiu = new a((byte)0);
    AppMethodBeat.o(217813);
  }
  
  private h(MMLiveList<T> paramMMLiveList, f paramf)
  {
    super(paramf, (ArrayList)localList, false);
    AppMethodBeat.i(217812);
    this.Eit = paramMMLiveList;
    paramMMLiveList = this.Eit;
    paramf = (e)this;
    p.k(paramf, "callback");
    paramMMLiveList.EhI = paramf;
    AppMethodBeat.o(217812);
  }
  
  public final void W(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217804);
    int i = this.YSk.size() + paramInt1;
    Log.i("MicroMsg.Mvvm.MMLiveRecyclerAdapter", "onInserted pos:" + paramInt1 + " fixPos:" + i + " count:" + paramInt2);
    aG(i, paramInt2);
    AppMethodBeat.o(217804);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217806);
    int i = this.YSk.size() + paramInt1;
    Log.i("MicroMsg.Mvvm.MMLiveRecyclerAdapter", "onRemoved pos:" + paramInt1 + " fixPos:" + i + " count:" + paramInt2);
    aH(i, paramInt2);
    AppMethodBeat.o(217806);
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217808);
    int i = this.YSk.size() + paramInt1;
    int j = this.YSk.size() + paramInt2;
    Log.i("MicroMsg.Mvvm.MMLiveRecyclerAdapter", "onMoved fromPos:" + paramInt1 + " fromFixPos:" + i + " toPos:" + paramInt2 + " toFixPos:" + j);
    aF(i, j);
    AppMethodBeat.o(217808);
  }
  
  public final boolean bAS()
  {
    return true;
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(217809);
    int i = this.YSk.size() + paramInt1;
    Log.i("MicroMsg.Mvvm.MMLiveRecyclerAdapter", "onChanged pos:" + paramInt1 + " fixPos:" + i + " count:" + paramInt2 + ' ' + paramObject);
    e(i, paramInt2, paramObject);
    AppMethodBeat.o(217809);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(217811);
    int i = paramInt + this.YSk.size();
    Log.i("MicroMsg.Mvvm.MMLiveRecyclerAdapter", "scrollToPosition pos:" + paramInt + " fixPos:" + i);
    RecyclerView localRecyclerView = getRecyclerView();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(217811);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter$Companion;", "", "()V", "TAG", "", "plugin-livelist_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.h
 * JD-Core Version:    0.7.0.1
 */