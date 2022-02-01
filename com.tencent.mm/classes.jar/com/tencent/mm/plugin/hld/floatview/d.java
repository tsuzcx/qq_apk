package com.tencent.mm.plugin.hld.floatview;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder;", "compositionList", "Ljava/util/ArrayList;", "", "listener", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;)V", "mListener", "selectItemPosition", "", "viewHolderList", "getItemCount", "getSelectItemText", "onBindViewHolder", "", "viewHolderLongClick", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "selectItemByPosition", "updateDefaultSelectPosition", "Companion", "plugin-hld_release"})
public final class d
  extends RecyclerView.a<e>
{
  public static final a Dxs;
  private final ArrayList<e> AXn;
  private final ArrayList<String> Dxf;
  private final e.a Dxq;
  int Dxr;
  
  static
  {
    AppMethodBeat.i(210802);
    Dxs = new a((byte)0);
    AppMethodBeat.o(210802);
  }
  
  public d(ArrayList<String> paramArrayList, e.a parama)
  {
    AppMethodBeat.i(210801);
    this.Dxf = paramArrayList;
    this.Dxq = parama;
    this.AXn = new ArrayList(this.Dxf.size());
    AppMethodBeat.o(210801);
  }
  
  public final void Us(int paramInt)
  {
    AppMethodBeat.i(210800);
    for (;;)
    {
      try
      {
        this.Dxr = paramInt;
        int j = ((Collection)this.AXn).size();
        int i = 0;
        Object localObject;
        if (i < j)
        {
          localObject = (e)this.AXn.get(i);
          if (i == paramInt)
          {
            bool = true;
            ((e)localObject).sF(bool);
            i += 1;
          }
        }
        else
        {
          localObject = this.Dxq;
          if (localObject != null)
          {
            ((e.a)localObject).notifyDataSetChanged();
            AppMethodBeat.o(210800);
            return;
          }
          AppMethodBeat.o(210800);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeLongClickFloatViewAdapter", "selectItemByPosition " + paramInt + ' ' + localException.getMessage());
        AppMethodBeat.o(210800);
        return;
      }
      boolean bool = false;
    }
  }
  
  public final String eDu()
  {
    AppMethodBeat.i(210797);
    String str = (String)this.Dxf.get(this.Dxr);
    AppMethodBeat.o(210797);
    return str;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(210795);
    int i = this.Dxf.size();
    AppMethodBeat.o(210795);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.d
 * JD-Core Version:    0.7.0.1
 */