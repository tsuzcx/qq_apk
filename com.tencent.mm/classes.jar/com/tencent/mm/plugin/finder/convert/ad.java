package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "TAG", "", "formatDesc", "", "preCount", "", "incCount", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "id", "descTv", "Landroid/widget/TextView;", "getLayoutId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ad
  extends com.tencent.mm.view.recyclerview.b<BaseFinderFeed>
{
  final String TAG = "Finder.FinderLikeConvert";
  
  private static void a(int paramInt1, int paramInt2, e parame, int paramInt3, TextView paramTextView)
  {
    AppMethodBeat.i(201432);
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
      AppMethodBeat.o(201432);
      return;
    }
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(201432);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201430);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = (TextView)parame.Gd(2131307924);
    parame = (TextView)parame.Gd(2131307921);
    p.g(paramRecyclerView, "nicknameTv");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    p.g(parame, "descTv");
    al.a((Paint)parame.getPaint(), 0.8F);
    AppMethodBeat.o(201430);
  }
  
  public final int getLayoutId()
  {
    return 2131496374;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$2$3"})
  static final class a
    implements View.OnClickListener
  {
    a(ad paramad, e parame, List paramList, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.bx.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201428);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.rMh.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307397);; paramView = null)
      {
        if (paramView != null) {
          paramView.a(this.rNb.feedObject, this.rOT);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201428);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ad paramad, long paramLong, String paramString, com.tencent.mm.bx.b paramb, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201429);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = new Intent();
      ((Intent)localObject).putExtra("feed_object_id", this.rOU);
      ((Intent)localObject).putExtra("feed_object_nonceId", this.rOV);
      ((Intent)localObject).putExtra("key_show_jump_entry", false);
      paramView = this.rOW;
      if (paramView != null) {}
      for (paramView = paramView.toByteArray();; paramView = null)
      {
        ((Intent)localObject).putExtra("key_like_buffer", bt.cE(paramView));
        paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
        paramView = this.oNd.getContext();
        p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.D(paramView, (Intent)localObject);
        com.tencent.mm.sdk.platformtools.ad.i(this.rOR.TAG, "go detail, jumpFeedId:" + this.rOU);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201429);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ad
 * JD-Core Version:    0.7.0.1
 */