package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jr;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.e;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedFooterNoMoreData;", "tabType", "", "(I)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends f<e>
{
  private final int hJx;
  
  public aa(int paramInt)
  {
    this.hJx = paramInt;
  }
  
  private static final void d(j paramj, View paramView)
  {
    AppMethodBeat.i(350113);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    paramView = as.GSQ;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramj = as.a.hu(paramj);
    if (paramj != null)
    {
      paramj = paramj.fou();
      if (paramj != null)
      {
        paramView = z.FrZ;
        z.g(paramj);
      }
    }
    paramj = new jr();
    paramj.hLn.hJx = 4;
    paramj.publish();
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedNoMreFooterConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350113);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350129);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350129);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_timeline_empty_footer_view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aa
 * JD-Core Version:    0.7.0.1
 */