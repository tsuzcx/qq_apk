package com.tencent.mm.plugin.finder.order.ui;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.order.data.d;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/ui/OrderTabConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/order/data/OrderTabFeed;", "()V", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f<d>
{
  private final kotlin.j AMa;
  
  public c()
  {
    AppMethodBeat.i(332377);
    this.AMa = k.cm((kotlin.g.a.a)c.a.ESN);
    AppMethodBeat.o(332377);
  }
  
  private static final void a(View paramView, TextView paramTextView)
  {
    AppMethodBeat.i(332381);
    if (paramView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = paramTextView.getWidth();
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(332381);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(332404);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    float f = (((Point)this.AMa.getValue()).x - com.tencent.mm.cd.a.fromDPToPix(paramj.context, 16)) / 4.0F;
    paramRecyclerView = paramj.UH(p.e.BYY);
    if (paramRecyclerView != null)
    {
      paramj = paramRecyclerView.getLayoutParams();
      if (paramj != null)
      {
        paramj.width = ((int)f);
        paramRecyclerView.setLayoutParams(paramj);
      }
    }
    AppMethodBeat.o(332404);
  }
  
  public final int getLayoutId()
  {
    return p.f.Cfc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.ui.c
 * JD-Core Version:    0.7.0.1
 */