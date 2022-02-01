package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "tabType", "", "(I)V", "getLayoutId", "gotoMachine", "", "context", "Landroid/content/Context;", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ab
  extends com.tencent.mm.view.recyclerview.b<w>
{
  @SuppressLint({"UseSparseArrays"})
  private static final SparseArray<Integer> rXo;
  public static final a rXp;
  private final int dvm;
  
  static
  {
    AppMethodBeat.i(201861);
    rXp = new a((byte)0);
    rXo = new SparseArray();
    AppMethodBeat.o(201861);
  }
  
  public ab(int paramInt)
  {
    this.dvm = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201859);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = parame.GD(2131299887);
    p.g(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
    paramRecyclerView = (TextView)paramRecyclerView;
    parame = parame.getContext();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    paramRecyclerView.setText((CharSequence)parame.getString(2131766946, new Object[] { com.tencent.mm.plugin.finder.storage.b.cIA() }));
    AppMethodBeat.o(201859);
  }
  
  public final int getLayoutId()
  {
    return 2131492873;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$Companion;", "", "()V", "TAG", "", "positionMap", "Landroid/util/SparseArray;", "", "getPositionMap", "()Landroid/util/SparseArray;", "getPositionByTabType", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static int Ey(int paramInt)
    {
      AppMethodBeat.i(201857);
      Object localObject = ab.cAF().get(paramInt);
      p.g(localObject, "positionMap[tabType]");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(201857);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ab
 * JD-Core Version:    0.7.0.1
 */