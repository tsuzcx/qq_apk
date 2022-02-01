package com.tencent.mm.plugin.hld.alternative;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder;", "syllableList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Syllable;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;)V", "currentSelectItem", "mListener", "viewHolderMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "selectItemByPy", "syllable", "Companion", "plugin-hld_release"})
public final class b
  extends RecyclerView.a<c>
{
  public static final a DtL;
  Syllable DtH;
  private final c.a DtI;
  final HashMap<Integer, c> DtJ;
  private final ArrayList<Syllable> DtK;
  
  static
  {
    AppMethodBeat.i(213297);
    DtL = new a((byte)0);
    AppMethodBeat.o(213297);
  }
  
  public b(ArrayList<Syllable> paramArrayList, c.a parama)
  {
    AppMethodBeat.i(213293);
    this.DtK = paramArrayList;
    this.DtI = parama;
    this.DtJ = new HashMap();
    AppMethodBeat.o(213293);
  }
  
  public final void a(Syllable paramSyllable)
  {
    AppMethodBeat.i(213289);
    this.DtH = paramSyllable;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = this.DtJ.keySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (Integer)((Iterator)localObject3).next();
          if (this.DtH != null) {
            break label138;
          }
          localObject1 = (c)this.DtJ.get(localObject1);
          if (localObject1 == null) {
            continue;
          }
          ((c)localObject1).sF(false);
        }
        localc = (c)this.DtJ.get(localObject1);
      }
      catch (Exception localException)
      {
        localObject3 = new StringBuilder("selectItemByPy ");
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
        Log.e("WxIme.ImeAlternativePyAdapter", paramSyllable + ' ' + localException.getMessage());
        AppMethodBeat.o(213289);
        return;
      }
      label138:
      c localc;
      if (localc != null)
      {
        Object localObject2 = this.DtH;
        if (localObject2 == null) {
          p.iCn();
        }
        String str = ((Syllable)localObject2).syllable;
        localObject2 = this.DtK;
        p.j(localObject1, "i");
        localObject2 = ((Syllable)((ArrayList)localObject2).get(((Integer)localObject1).intValue())).syllable;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.sF(Util.isEqual(str, (String)localObject1));
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(213284);
    int i = this.DtK.size();
    AppMethodBeat.o(213284);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyAdapter$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.b
 * JD-Core Version:    0.7.0.1
 */