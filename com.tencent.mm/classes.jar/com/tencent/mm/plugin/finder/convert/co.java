package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onItemClick", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function0;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class co
  extends f<com.tencent.mm.view.recyclerview.a>
{
  private final kotlin.g.a.a<ah> AMq;
  
  public co(kotlin.g.a.a<ah> parama)
  {
    this.AMq = parama;
  }
  
  private static final void a(co paramco, View paramView)
  {
    AppMethodBeat.i(349921);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramco);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramco, "this$0");
    paramco = paramco.AMq;
    if (paramco != null) {
      paramco.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349921);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349939);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj.caK.setOnClickListener(new co..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(349939);
  }
  
  public final void a(j paramj, com.tencent.mm.view.recyclerview.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(349945);
    s.u(paramj, "holder");
    s.u(parama, "item");
    AppMethodBeat.o(349945);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_show_more_footer_convert_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.co
 * JD-Core Version:    0.7.0.1
 */