package com.tencent.mm.plugin.hld.symbol;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder;", "symbolTypeList", "", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "([Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;)V", "currentSelectItem", "", "mListener", "[Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "viewHolderList", "Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "selectItemByTypeName", "typeName", "Companion", "plugin-hld_release"})
public final class g
  extends RecyclerView.a<h>
{
  public static final a DFy;
  private final ArrayList<h> AXn;
  private String DFv;
  private final h.a DFw;
  private final f[] DFx;
  
  static
  {
    AppMethodBeat.i(216635);
    DFy = new a((byte)0);
    AppMethodBeat.o(216635);
  }
  
  public g(f[] paramArrayOff, h.a parama)
  {
    AppMethodBeat.i(216634);
    this.DFx = paramArrayOff;
    paramArrayOff = b.DGL;
    this.DFv = b.eFU();
    this.DFw = parama;
    this.AXn = new ArrayList(this.DFx.length);
    AppMethodBeat.o(216634);
  }
  
  public final void aLC(String paramString)
  {
    AppMethodBeat.i(216633);
    p.k(paramString, "typeName");
    label148:
    for (;;)
    {
      try
      {
        this.DFv = paramString;
        int j = ((Collection)this.AXn).size();
        int i = 0;
        if (i < j)
        {
          h localh = (h)this.AXn.get(i);
          String str3 = this.DFv;
          Object localObject = this.DFx[i];
          if (localObject == null) {
            break label148;
          }
          String str2 = ((f)localObject).typeName;
          localObject = str2;
          if (str2 == null) {
            break label148;
          }
          localh.sF(Util.isEqual(str3, (String)localObject));
          i += 1;
        }
        String str1 = "";
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeSymbolTypesAdapter", "selectItemByTypeName " + paramString + ' ' + localException.getMessage());
        AppMethodBeat.o(216633);
        return;
      }
    }
  }
  
  public final int getItemCount()
  {
    return this.DFx.length;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.g
 * JD-Core Version:    0.7.0.1
 */