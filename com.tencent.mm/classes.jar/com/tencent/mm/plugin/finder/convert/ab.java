package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "tabType", "", "(I)V", "getLayoutId", "gotoMachine", "", "context", "Landroid/content/Context;", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ab
  extends com.tencent.mm.view.recyclerview.b<v>
{
  @SuppressLint({"UseSparseArrays"})
  private static final SparseArray<Integer> rOO;
  public static final a rOP;
  private final int duh;
  
  static
  {
    AppMethodBeat.i(201423);
    rOP = new a((byte)0);
    rOO = new SparseArray();
    AppMethodBeat.o(201423);
  }
  
  public ab(int paramInt)
  {
    this.duh = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201421);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = parame.Gd(2131299887);
    p.g(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
    paramRecyclerView = (TextView)paramRecyclerView;
    parame = parame.getContext();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    paramRecyclerView.setText((CharSequence)parame.getString(2131766946, new Object[] { com.tencent.mm.plugin.finder.storage.b.cGD() }));
    AppMethodBeat.o(201421);
  }
  
  public final int getLayoutId()
  {
    return 2131492873;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$Companion;", "", "()V", "TAG", "", "positionMap", "Landroid/util/SparseArray;", "", "getPositionMap", "()Landroid/util/SparseArray;", "getPositionByTabType", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static int El(int paramInt)
    {
      AppMethodBeat.i(201419);
      Object localObject = ab.czb().get(paramInt);
      p.g(localObject, "positionMap[tabType]");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(201419);
      return paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ab paramab, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201420);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.oNd.getContext();
      p.g(paramView, "holder.context");
      ab.V(paramView, this.oNd.lN());
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ab
 * JD-Core Version:    0.7.0.1
 */