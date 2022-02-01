package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import d.y;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderShowMoreFooterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onItemClick", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function0;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class as
  extends b<com.tencent.mm.view.recyclerview.a>
{
  final d.g.a.a<y> KLD;
  
  public as(d.g.a.a<y> parama)
  {
    this.KLD = parama;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(197488);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    parame.arI.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(197488);
  }
  
  public final void a(e parame, com.tencent.mm.view.recyclerview.a parama, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197489);
    k.h(parame, "holder");
    k.h(parama, "item");
    AppMethodBeat.o(197489);
  }
  
  public final int getLayoutId()
  {
    return 2131496254;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(as paramas) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197487);
      paramView = this.KLE.KLD;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(197487);
        return;
      }
      AppMethodBeat.o(197487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.as
 * JD-Core Version:    0.7.0.1
 */