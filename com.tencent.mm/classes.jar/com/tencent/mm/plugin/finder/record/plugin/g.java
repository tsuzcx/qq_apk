package com.tencent.mm.plugin.finder.record.plugin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fxr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/TemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/record/plugin/TemplateHolder;", "()V", "onItemClick", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "templates", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "Lkotlin/collections/ArrayList;", "getItemCount", "getTemplate", "index", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateTemplateList", "list", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.a<h>
{
  m<? super View, ? super Integer, ah> EUi;
  final ArrayList<fxr> Fjq;
  
  public g()
  {
    AppMethodBeat.i(337008);
    this.Fjq = new ArrayList();
    this.EUi = ((m)g.b.Fjs);
    AppMethodBeat.o(337008);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(337022);
    int i = this.Fjq.size();
    AppMethodBeat.o(337022);
    return i;
  }
  
  public final void hq(List<? extends fxr> paramList)
  {
    AppMethodBeat.i(337016);
    s.u(paramList, "list");
    this.Fjq.clear();
    this.Fjq.addAll((Collection)paramList);
    AppMethodBeat.o(337016);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, ah>
  {
    a(g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.g
 * JD-Core Version:    0.7.0.1
 */