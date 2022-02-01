package com.tencent.mm.plugin.hld.symbol;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder;", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;)V", "currentSelectItem", "Lcom/tencent/wxhld/info/Syllable;", "mListener", "viewHolderList", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "selectItemByPy", "syllable", "Companion", "plugin-hld_release"})
public final class b
  extends RecyclerView.a<c>
{
  public static final a DFg;
  private final ArrayList<c> AXn;
  private final c.a DFf;
  private Syllable DtH;
  private final ArrayList<Object> mXB;
  
  static
  {
    AppMethodBeat.i(217548);
    DFg = new a((byte)0);
    AppMethodBeat.o(217548);
  }
  
  public b(ArrayList<Object> paramArrayList, c.a parama)
  {
    AppMethodBeat.i(217546);
    this.mXB = paramArrayList;
    this.AXn = new ArrayList();
    this.DFf = parama;
    AppMethodBeat.o(217546);
  }
  
  public final void a(Syllable paramSyllable)
  {
    AppMethodBeat.i(217544);
    this.DtH = paramSyllable;
    for (;;)
    {
      int i;
      Object localObject2;
      String str2;
      try
      {
        int j = ((Collection)this.AXn).size();
        i = 0;
        if (i < j)
        {
          if (this.DtH == null)
          {
            ((c)this.AXn.get(i)).sF(false);
            break label225;
          }
          localObject2 = (c)this.AXn.get(i);
          localObject1 = this.DtH;
          if (localObject1 == null) {
            p.iCn();
          }
          str2 = ((Syllable)localObject1).syllable;
          localObject1 = this.mXB.get(i);
          if (localObject1 != null) {
            break label190;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.wxhld.info.Syllable");
          AppMethodBeat.o(217544);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder("selectItemByPy ");
        if (paramSyllable != null)
        {
          localObject1 = paramSyllable.syllable;
          paramSyllable = (Syllable)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramSyllable = "";
        }
        Log.e("WxIme.ImeSymbolKeysAdapter", paramSyllable + ' ' + localException.getMessage());
        AppMethodBeat.o(217544);
        return;
      }
      label190:
      String str1 = ((Syllable)localObject1).syllable;
      Object localObject1 = str1;
      if (str1 == null) {
        localObject1 = "";
      }
      ((c)localObject2).sF(Util.isEqual(str2, (String)localObject1));
      label225:
      i += 1;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(217542);
    int i = this.mXB.size();
    AppMethodBeat.o(217542);
    return i;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(217545);
    this.DtH = null;
    this.AXn.clear();
    this.mXB.clear();
    AppMethodBeat.o(217545);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.b
 * JD-Core Version:    0.7.0.1
 */