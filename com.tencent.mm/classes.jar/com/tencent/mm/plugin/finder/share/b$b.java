package com.tencent.mm.plugin.finder.share;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$ViewHolder;", "Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "finerObjects", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "strokeShowPos", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "objects", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
  extends RecyclerView.a<b.d>
{
  List<FinderObject> ALu;
  private int FzW;
  private final Context context;
  
  public b$b(Context paramContext)
  {
    AppMethodBeat.i(330632);
    this.context = localObject;
    this.ALu = ((List)new ArrayList());
    AppMethodBeat.o(330632);
  }
  
  private static final void a(b paramb, int paramInt, b paramb1, FinderObject paramFinderObject, View paramView)
  {
    AppMethodBeat.i(330642);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramb1);
    localb.cH(paramFinderObject);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramb1, "this$1");
    s.u(paramFinderObject, "$finderObject");
    paramb.FzW = paramInt;
    paramb.bZE.notifyChanged();
    s.u(paramFinderObject, "finderObject");
    paramb1.ABJ = paramFinderObject;
    paramb1.position = paramInt;
    paramb = paramb1.FzR;
    if (paramb != null)
    {
      paramFinderObject = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramb, paramFinderObject.aYi(), "com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC", "onClickSideItem", "(ILcom/tencent/mm/protocal/protobuf/FinderObject;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramb.smoothScrollToPosition(((Integer)paramFinderObject.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramb, "com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC", "onClickSideItem", "(ILcom/tencent/mm/protocal/protobuf/FinderObject;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    paramb1.FzT = true;
    paramb1.rG(4);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330642);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(330663);
    int i = this.ALu.size();
    AppMethodBeat.o(330663);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.share.b.b
 * JD-Core Version:    0.7.0.1
 */