package com.tencent.mm.plugin.hld.floatview;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder;", "compositionList", "Ljava/util/ArrayList;", "", "listener", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;)V", "mListener", "selectItemPosition", "", "viewHolderList", "getItemCount", "getSelectItemText", "onBindViewHolder", "", "viewHolderLongClick", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "selectItemByPosition", "updateDefaultSelectPosition", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.a<e>
{
  public static final d.a Jqv;
  private final ArrayList<e> GyR;
  private final ArrayList<String> Jql;
  private final e.a Jqw;
  int Jqx;
  
  static
  {
    AppMethodBeat.i(312789);
    Jqv = new d.a((byte)0);
    AppMethodBeat.o(312789);
  }
  
  public d(ArrayList<String> paramArrayList, e.a parama)
  {
    AppMethodBeat.i(312785);
    this.Jql = paramArrayList;
    this.Jqw = parama;
    this.GyR = new ArrayList(this.Jql.size());
    AppMethodBeat.o(312785);
  }
  
  public final void Yp(int paramInt)
  {
    AppMethodBeat.i(312813);
    label138:
    for (;;)
    {
      try
      {
        this.Jqx = paramInt;
        int k = this.GyR.size() - 1;
        int j;
        Object localObject;
        if (k >= 0)
        {
          i = 0;
          j = i + 1;
          localObject = (e)this.GyR.get(i);
          if (i == paramInt)
          {
            bool = true;
            ((e)localObject).wL(bool);
            if (j <= k) {
              break label138;
            }
          }
        }
        else
        {
          localObject = this.Jqw;
          if (localObject == null) {
            continue;
          }
          ((e.a)localObject).notifyDataSetChanged();
          AppMethodBeat.o(312813);
          return;
        }
        boolean bool = false;
        continue;
        int i = j;
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeLongClickFloatViewAdapter", "selectItemByPosition " + paramInt + ' ' + localException.getMessage());
        AppMethodBeat.o(312813);
        return;
      }
    }
  }
  
  public final String fLu()
  {
    AppMethodBeat.i(312802);
    String str = (String)this.Jql.get(this.Jqx);
    AppMethodBeat.o(312802);
    return str;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312797);
    int i = this.Jql.size();
    AppMethodBeat.o(312797);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.d
 * JD-Core Version:    0.7.0.1
 */