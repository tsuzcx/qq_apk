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
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "TAG", "", "formatDesc", "", "preCount", "", "incCount", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "id", "descTv", "Landroid/widget/TextView;", "getLayoutId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ae
  extends com.tencent.mm.view.recyclerview.b<BaseFinderFeed>
{
  final String TAG = "Finder.FinderLikeConvert";
  
  private static void a(int paramInt1, int paramInt2, e parame, int paramInt3, TextView paramTextView)
  {
    AppMethodBeat.i(201874);
    Object localObject = paramInt1 + " + " + paramInt2;
    int i = ((String)localObject).length() - n.a((CharSequence)localObject, '+', 0, 6);
    localObject = parame.getContext().getString(paramInt3, new Object[] { paramInt1 + " + " + paramInt2 });
    p.g(localObject, "text");
    paramInt1 = n.a((CharSequence)localObject, '+', 0, 6);
    if ((paramInt1 > 0) && (paramInt1 + i < ((String)localObject).length()))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      parame = parame.getContext();
      p.g(parame, "holder.context");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parame.getResources().getColor(2131099803)), paramInt1, i + paramInt1, 17);
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(201874);
      return;
    }
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(201874);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201872);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = (TextView)parame.GD(2131307924);
    parame = (TextView)parame.GD(2131307921);
    p.g(paramRecyclerView, "nicknameTv");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    p.g(parame, "descTv");
    al.a((Paint)parame.getPaint(), 0.8F);
    AppMethodBeat.o(201872);
  }
  
  public final int getLayoutId()
  {
    return 2131496374;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$2$3"})
  static final class a
    implements View.OnClickListener
  {
    a(ae paramae, e parame, List paramList, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.bw.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201870);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.rUu.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307397);; paramView = null)
      {
        if (paramView != null) {
          paramView.a(this.rVp.feedObject, this.rXu);
        }
        a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201870);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae
 * JD-Core Version:    0.7.0.1
 */