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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder;", "syllableList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Syllable;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;)V", "currentSelectItem", "mListener", "viewHolderMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "selectItemByPy", "syllable", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<c>
{
  public static final b.a Jni;
  private final ArrayList<Syllable> Jnj;
  Syllable Jnk;
  private final c.a Jnl;
  final HashMap<Integer, c> Jnm;
  
  static
  {
    AppMethodBeat.i(311684);
    Jni = new b.a((byte)0);
    AppMethodBeat.o(311684);
  }
  
  public b(ArrayList<Syllable> paramArrayList, c.a parama)
  {
    AppMethodBeat.i(311674);
    this.Jnj = paramArrayList;
    this.Jnl = parama;
    this.Jnm = new HashMap();
    AppMethodBeat.o(311674);
  }
  
  public final void a(Syllable paramSyllable)
  {
    AppMethodBeat.i(311712);
    this.Jnk = paramSyllable;
    Object localObject3;
    Object localObject1;
    try
    {
      localObject3 = this.Jnm.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Integer)((Iterator)localObject3).next();
        if (this.Jnk != null) {
          break label127;
        }
        localObject1 = (c)this.Jnm.get(localObject1);
        if (localObject1 != null)
        {
          ((c)localObject1).wL(false);
          continue;
          paramSyllable = "";
        }
      }
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder("selectItemByPy ");
      if (paramSyllable != null) {}
    }
    for (;;)
    {
      Log.e("WxIme.ImeAlternativePyAdapter", paramSyllable + ' ' + localException.getMessage());
      AppMethodBeat.o(311712);
      return;
      label127:
      c localc = (c)this.Jnm.get(localObject1);
      if (localc == null) {
        break;
      }
      Object localObject2 = this.Jnk;
      s.checkNotNull(localObject2);
      String str = ((Syllable)localObject2).syllable;
      localObject2 = this.Jnj;
      s.s(localObject1, "i");
      localObject2 = ((Syllable)((ArrayList)localObject2).get(((Integer)localObject1).intValue())).syllable;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localc.wL(Util.isEqual(str, (String)localObject1));
      break;
      localObject1 = paramSyllable.syllable;
      paramSyllable = (Syllable)localObject1;
      if (localObject1 == null) {
        paramSyllable = "";
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(311696);
    int i = this.Jnj.size();
    AppMethodBeat.o(311696);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.b
 * JD-Core Version:    0.7.0.1
 */