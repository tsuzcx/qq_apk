package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "TAG", "", "formatDesc", "", "preCount", "", "incCount", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "id", "descTv", "Landroid/widget/TextView;", "getLayoutId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class as
  extends e<BaseFinderFeed>
{
  final String TAG = "Finder.FinderLikeConvert";
  
  private static void a(int paramInt1, int paramInt2, h paramh, int paramInt3, TextView paramTextView)
  {
    AppMethodBeat.i(243154);
    Object localObject = paramInt1 + " + " + paramInt2;
    int i = ((String)localObject).length() - n.a((CharSequence)localObject, '+', 0, false, 6);
    localObject = paramh.getContext().getString(paramInt3, new Object[] { paramInt1 + " + " + paramInt2 });
    p.g(localObject, "holder.context.getString… \"$preCount + $incCount\")");
    paramInt1 = n.a((CharSequence)localObject, '+', 0, false, 6);
    if ((paramInt1 > 0) && (paramInt1 + i < ((String)localObject).length()))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      paramh = paramh.getContext();
      p.g(paramh, "holder.context");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramh.getResources().getColor(2131099818)), paramInt1, i + paramInt1, 17);
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(243154);
      return;
    }
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(243154);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243152);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (TextView)paramh.Mn(2131306597);
    paramh = (TextView)paramh.Mn(2131306594);
    p.g(paramRecyclerView, "nicknameTv");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    p.g(paramh, "descTv");
    ao.a((Paint)paramh.getPaint(), 0.8F);
    AppMethodBeat.o(243152);
  }
  
  public final int getLayoutId()
  {
    return 2131492883;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$2$3"})
  static final class a
    implements View.OnClickListener
  {
    a(as paramas, h paramh, List paramList, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.bw.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243150);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.tzq.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131300826);; paramView = null)
      {
        if (paramView != null) {
          paramView.a(this.tAz.feedObject, this.tEy);
        }
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243150);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.as
 * JD-Core Version:    0.7.0.1
 */