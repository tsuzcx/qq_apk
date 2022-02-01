package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.protocal.protobuf.fmd;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter$FansInfoViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/TaskProgressItem;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDataList", "Companion", "FansInfoViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends RecyclerView.a<b>
{
  public static final a DQA;
  private kotlin.g.a.b<? super String, ah> nod;
  public LinkedList<fmd> vEn;
  
  static
  {
    AppMethodBeat.i(358570);
    DQA = new a((byte)0);
    AppMethodBeat.o(358570);
  }
  
  public m()
  {
    AppMethodBeat.i(358548);
    this.vEn = new LinkedList();
    AppMethodBeat.o(358548);
  }
  
  private static final void a(m paramm, View paramView)
  {
    AppMethodBeat.i(358559);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    paramm = paramm.nod;
    if (paramm != null) {
      paramm.invoke(null);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358559);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358586);
    int i = this.vEn.size();
    AppMethodBeat.o(358586);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter$FansInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter;Landroid/view/View;)V", "taskDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTaskDesc", "()Landroid/widget/TextView;", "taskProgress", "getTaskProgress", "taskTitle", "getTaskTitle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    final TextView DQB;
    final TextView DQC;
    final TextView DQD;
    
    public b()
    {
      super();
      AppMethodBeat.i(359100);
      this.DQB = ((TextView)localObject.findViewById(p.e.CbB));
      this.DQC = ((TextView)localObject.findViewById(p.e.Cby));
      this.DQD = ((TextView)localObject.findViewById(p.e.Cbz));
      AppMethodBeat.o(359100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.m
 * JD-Core Version:    0.7.0.1
 */