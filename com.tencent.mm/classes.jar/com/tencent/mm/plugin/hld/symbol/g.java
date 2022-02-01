package com.tencent.mm.plugin.hld.symbol;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder;", "symbolTypeList", "", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "([Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;)V", "currentSelectItem", "", "mListener", "[Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "viewHolderList", "Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "selectItemByTypeName", "typeName", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.a<h>
{
  public static final g.a Jxc;
  private final ArrayList<h> GyR;
  private final f[] Jxd;
  private String Jxe;
  private final h.a Jxf;
  
  static
  {
    AppMethodBeat.i(312141);
    Jxc = new g.a((byte)0);
    AppMethodBeat.o(312141);
  }
  
  public g(f[] paramArrayOff, h.a parama)
  {
    AppMethodBeat.i(312134);
    this.Jxd = paramArrayOff;
    paramArrayOff = b.Jyf;
    this.Jxe = b.fNN();
    this.Jxf = parama;
    this.GyR = new ArrayList(this.Jxd.length);
    AppMethodBeat.o(312134);
  }
  
  public final void aIu(String paramString)
  {
    AppMethodBeat.i(312158);
    s.u(paramString, "typeName");
    label163:
    for (;;)
    {
      try
      {
        this.Jxe = paramString;
        int k = this.GyR.size() - 1;
        int j;
        if (k >= 0)
        {
          i = 0;
          j = i + 1;
          h localh = (h)this.GyR.get(i);
          String str2 = this.Jxe;
          Object localObject = this.Jxd[i];
          if (localObject == null)
          {
            localObject = "";
            localh.wL(Util.isEqual(str2, (String)localObject));
            if (j <= k) {
              break label163;
            }
            AppMethodBeat.o(312158);
            return;
          }
          String str1 = ((f)localObject).typeName;
          localObject = str1;
          if (str1 != null) {
            continue;
          }
          localObject = "";
          continue;
        }
        int i = j;
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeSymbolTypesAdapter", "selectItemByTypeName " + paramString + ' ' + localException.getMessage());
        AppMethodBeat.o(312158);
        return;
      }
    }
  }
  
  public final int getItemCount()
  {
    return this.Jxd.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.g
 * JD-Core Version:    0.7.0.1
 */