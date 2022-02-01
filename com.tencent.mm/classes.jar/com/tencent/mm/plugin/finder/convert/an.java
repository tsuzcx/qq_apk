package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.k;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedLbsBarData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends f<k>
{
  private static final void fv(View paramView)
  {
    AppMethodBeat.i(350211);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMN();
    localObject1 = new Intent();
    localObject2 = as.GSQ;
    localObject2 = paramView.getContext();
    kotlin.g.b.s.s(localObject2, "it.context");
    as.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, true, 60);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350211);
      throw paramView;
    }
    com.tencent.mm.plugin.finder.utils.a.c((MMActivity)paramView, (Intent)localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350211);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350234);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    aw.a((Paint)((TextView)paramj.UH(e.e.lbs_entrance_bar_title_tv)).getPaint(), 0.8F);
    paramj.caK.setOnClickListener(an..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(350234);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_lbs_entrance_bar_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.an
 * JD-Core Version:    0.7.0.1
 */