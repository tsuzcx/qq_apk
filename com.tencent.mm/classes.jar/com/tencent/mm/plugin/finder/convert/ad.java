package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedLbsBarData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ad
  extends com.tencent.mm.view.recyclerview.b<j>
{
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201868);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = (TextView)parame.GD(2131308497);
    p.g(paramRecyclerView, "titleTv");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    parame.auu.setOnClickListener((View.OnClickListener)a.rXr);
    AppMethodBeat.o(201868);
  }
  
  public final int getLayoutId()
  {
    return 2131496519;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    public static final a rXr;
    
    static
    {
      AppMethodBeat.i(201867);
      rXr = new a();
      AppMethodBeat.o(201867);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201866);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      localObject1 = f.syc;
      f.cFn();
      localObject1 = new Intent();
      Object localObject2 = FinderReporterUIC.tnG;
      p.g(paramView, "it");
      localObject2 = paramView.getContext();
      p.g(localObject2, "it.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, true, 60);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201866);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)paramView, (Intent)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201866);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ad
 * JD-Core Version:    0.7.0.1
 */