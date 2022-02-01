package com.tencent.mm.plugin.finder.live.component;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/component/LotteryViewHolder;", "()V", "dataList", "", "Lcom/tencent/mm/plugin/finder/live/component/LotteryCreateItem;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "", "pos", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends RecyclerView.a<av>
{
  public static final ac.a CyY;
  private static final String TAG;
  m<? super at, ? super Integer, ah> CyZ;
  List<at> dataList;
  
  static
  {
    AppMethodBeat.i(353041);
    CyY = new ac.a((byte)0);
    TAG = "FinderLiveLotteryCreateAdapter";
    AppMethodBeat.o(353041);
  }
  
  private static final void a(ac paramac, at paramat, int paramInt, View paramView)
  {
    AppMethodBeat.i(353036);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramac);
    localb.cH(paramat);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramac, "this$0");
    paramac = paramac.CyZ;
    if (paramac != null) {
      paramac.invoke(paramat, Integer.valueOf(paramInt));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353036);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(353055);
    List localList = this.dataList;
    if (localList == null)
    {
      AppMethodBeat.o(353055);
      return 0;
    }
    int i = localList.size();
    AppMethodBeat.o(353055);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ac
 * JD-Core Version:    0.7.0.1
 */