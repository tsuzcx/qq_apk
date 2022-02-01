package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.k;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedLbsBarData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class at
  extends e<k>
{
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(286146);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (TextView)parami.RD(b.f.lbs_entrance_bar_title_tv);
    p.j(paramRecyclerView, "titleTv");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    parami.amk.setOnClickListener((View.OnClickListener)a.xmX);
    AppMethodBeat.o(286146);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_lbs_entrance_bar_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    public static final a xmX;
    
    static
    {
      AppMethodBeat.i(290847);
      xmX = new a();
      AppMethodBeat.o(290847);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290846);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      localObject1 = j.zVy;
      j.dPt();
      localObject1 = new Intent();
      Object localObject2 = aj.Bnu;
      p.j(paramView, "it");
      localObject2 = paramView.getContext();
      p.j(localObject2, "it.context");
      aj.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, true, 60);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(290846);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)paramView, (Intent)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.at
 * JD-Core Version:    0.7.0.1
 */