package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "tabType", "", "(I)V", "getLayoutId", "gotoMachine", "", "context", "Landroid/content/Context;", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends f<am>
{
  public static final a ALb;
  private static final SparseArray<Integer> ALc;
  private final int hJx;
  
  static
  {
    AppMethodBeat.i(350222);
    ALb = new a((byte)0);
    ALc = new SparseArray();
    AppMethodBeat.o(350222);
  }
  
  public al(int paramInt)
  {
    this.hJx = paramInt;
  }
  
  private static final void a(al paramal, j paramj, View paramView)
  {
    AppMethodBeat.i(350216);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramal);
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramal, "this$0");
    s.u(paramj, "$holder");
    paramal = paramj.context;
    s.s(paramal, "holder.context");
    int i = paramj.KJ();
    paramj = as.GSQ;
    paramj = as.a.hu(paramal);
    if (paramj != null)
    {
      paramj = paramj.fou();
      if (paramj != null)
      {
        paramView = z.FrZ;
        z.a(2, 2, i, paramj);
      }
    }
    paramj = k.aeZF;
    paramal = k.d((AppCompatActivity)paramal).q(FinderHomeUIC.class);
    s.s(paramal, "UICProvider.of(context a…inderHomeUIC::class.java)");
    paramal = (FinderHomeUIC)paramal;
    paramj = new Bundle();
    paramj.putInt("Source", 4);
    paramal.u(4, paramj);
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350216);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350237);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = (TextView)paramj.UH(e.e.feed_tip_tv_2);
    Context localContext = paramj.context;
    paramInt = e.h.finder_timeline_see_machine_tip;
    d locald = d.FAy;
    paramRecyclerView.setText((CharSequence)localContext.getString(paramInt, new Object[] { d.eRK() }));
    if (((bw)h.ax(bw.class)).aBu())
    {
      ((TextView)paramj.UH(e.e.feed_tip_tv_2)).setVisibility(8);
      AppMethodBeat.o(350237);
      return;
    }
    ((TextView)paramj.UH(e.e.feed_tip_tv_2)).setVisibility(0);
    AppMethodBeat.o(350237);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_tip_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderHistoryDividerConvert$Companion;", "", "()V", "TAG", "", "positionMap", "Landroid/util/SparseArray;", "", "getPositionMap", "()Landroid/util/SparseArray;", "getPositionByTabType", "tabType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int Nj(int paramInt)
    {
      AppMethodBeat.i(349578);
      Object localObject = al.dXK().get(paramInt);
      s.s(localObject, "positionMap[tabType]");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(349578);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.al
 * JD-Core Version:    0.7.0.1
 */