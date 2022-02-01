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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "tabType", "", "(I)V", "getLayoutId", "gotoMachine", "", "context", "Landroid/content/Context;", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ap
  extends e<ai>
{
  @SuppressLint({"UseSparseArrays"})
  private static final SparseArray<Integer> tEs;
  public static final a tEt;
  private final int dLS;
  
  static
  {
    AppMethodBeat.i(243141);
    tEt = new a((byte)0);
    tEs = new SparseArray();
    AppMethodBeat.o(243141);
  }
  
  public ap(int paramInt)
  {
    this.dLS = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243139);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramh.Mn(2131300586);
    p.g(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
    paramRecyclerView = (TextView)paramRecyclerView;
    Context localContext = paramh.getContext();
    c localc = c.vCb;
    paramRecyclerView.setText((CharSequence)localContext.getString(2131760630, new Object[] { c.dsg() }));
    paramRecyclerView = g.af(ad.class);
    p.g(paramRecyclerView, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)paramRecyclerView).dxX())
    {
      paramRecyclerView = paramh.Mn(2131300586);
      p.g(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
      ((TextView)paramRecyclerView).setVisibility(8);
      AppMethodBeat.o(243139);
      return;
    }
    paramRecyclerView = paramh.Mn(2131300586);
    p.g(paramRecyclerView, "holder.getView<TextView>(R.id.feed_tip_tv_2)");
    ((TextView)paramRecyclerView).setVisibility(0);
    AppMethodBeat.o(243139);
  }
  
  public final int getLayoutId()
  {
    return 2131492888;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$Companion;", "", "()V", "TAG", "", "positionMap", "Landroid/util/SparseArray;", "", "getPositionMap", "()Landroid/util/SparseArray;", "getPositionByTabType", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static int Is(int paramInt)
    {
      AppMethodBeat.i(243137);
      Object localObject = ap.cZJ().get(paramInt);
      p.g(localObject, "positionMap[tabType]");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(243137);
      return paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ap paramap, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243138);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.qhp.getContext();
      p.g(paramView, "holder.context");
      ap.aa(paramView, this.qhp.lR());
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243138);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ap
 * JD-Core Version:    0.7.0.1
 */