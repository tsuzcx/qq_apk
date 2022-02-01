package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "tabType", "", "(I)V", "getLayoutId", "gotoMachine", "", "context", "Landroid/content/Context;", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ar
  extends e<ak>
{
  @SuppressLint({"UseSparseArrays"})
  private static final SparseArray<Integer> xmU;
  public static final a xmV;
  private final int fEH;
  
  static
  {
    AppMethodBeat.i(273215);
    xmV = new a((byte)0);
    xmU = new SparseArray();
    AppMethodBeat.o(273215);
  }
  
  public ar(int paramInt)
  {
    this.fEH = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(273213);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = parami.RD(b.f.feed_tip_tv_2);
    p.j(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
    paramRecyclerView = (TextView)paramRecyclerView;
    Context localContext = parami.getContext();
    paramInt = b.j.finder_timeline_see_machine_tip;
    d locald = d.AjH;
    paramRecyclerView.setText((CharSequence)localContext.getString(paramInt, new Object[] { d.dTv() }));
    paramRecyclerView = h.ae(ae.class);
    p.j(paramRecyclerView, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)paramRecyclerView).dYT())
    {
      paramRecyclerView = parami.RD(b.f.feed_tip_tv_2);
      p.j(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
      ((TextView)paramRecyclerView).setVisibility(8);
      AppMethodBeat.o(273213);
      return;
    }
    paramRecyclerView = parami.RD(b.f.feed_tip_tv_2);
    p.j(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
    ((TextView)paramRecyclerView).setVisibility(0);
    AppMethodBeat.o(273213);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_tip_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$Companion;", "", "()V", "TAG", "", "positionMap", "Landroid/util/SparseArray;", "", "getPositionMap", "()Landroid/util/SparseArray;", "getPositionByTabType", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static int Mf(int paramInt)
    {
      AppMethodBeat.i(286640);
      Object localObject = ar.dpF().get(paramInt);
      p.j(localObject, "positionMap[tabType]");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(286640);
      return paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ar paramar, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271169);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      ar.af(paramView, this.tDl.md());
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271169);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ar
 * JD-Core Version:    0.7.0.1
 */