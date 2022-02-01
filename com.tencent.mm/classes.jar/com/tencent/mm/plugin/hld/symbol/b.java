package com.tencent.mm.plugin.hld.symbol;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder;", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;)V", "currentSelectItem", "Lcom/tencent/wxhld/info/Syllable;", "mListener", "viewHolderList", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "selectItemByPy", "syllable", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<c>
{
  public static final b.a JwM;
  private final ArrayList<c> GyR;
  private Syllable Jnk;
  private final c.a JwN;
  private final ArrayList<Object> pUj;
  
  static
  {
    AppMethodBeat.i(312149);
    JwM = new b.a((byte)0);
    AppMethodBeat.o(312149);
  }
  
  public b(ArrayList<Object> paramArrayList, c.a parama)
  {
    AppMethodBeat.i(312143);
    this.pUj = paramArrayList;
    this.GyR = new ArrayList();
    this.JwN = parama;
    AppMethodBeat.o(312143);
  }
  
  public final void a(Syllable paramSyllable)
  {
    AppMethodBeat.i(312168);
    this.Jnk = paramSyllable;
    try
    {
      k = this.GyR.size() - 1;
      if (k < 0) {
        break label188;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int j;
        Object localObject1;
        Object localObject2 = new StringBuilder("selectItemByPy ");
        if (paramSyllable == null) {
          paramSyllable = "";
        }
        for (;;)
        {
          Log.e("WxIme.ImeSymbolKeysAdapter", paramSyllable + ' ' + localException.getMessage());
          AppMethodBeat.o(312168);
          return;
          localObject1 = paramSyllable.syllable;
          paramSyllable = (Syllable)localObject1;
          if (localObject1 == null) {
            paramSyllable = "";
          }
        }
        int i = j;
      }
    }
    j = i + 1;
    if (this.Jnk == null) {
      ((c)this.GyR.get(i)).wL(false);
    }
    while (j > k)
    {
      AppMethodBeat.o(312168);
      return;
      localObject2 = (c)this.GyR.get(i);
      localObject1 = this.Jnk;
      s.checkNotNull(localObject1);
      String str2 = ((Syllable)localObject1).syllable;
      String str1 = ((Syllable)this.pUj.get(i)).syllable;
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "";
      }
      ((c)localObject2).wL(Util.isEqual(str2, (String)localObject1));
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312157);
    int i = this.pUj.size();
    AppMethodBeat.o(312157);
    return i;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(312175);
    this.Jnk = null;
    this.GyR.clear();
    this.pUj.clear();
    AppMethodBeat.o(312175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.b
 * JD-Core Version:    0.7.0.1
 */