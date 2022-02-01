package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "showEdu", "", "isSelfLike", "Lkotlin/Function0;", "selfLikeClick", "Lkotlin/Function1;", "", "onRefresh", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getOnRefresh", "getSelfLikeClick", "()Lkotlin/jvm/functions/Function1;", "getShowEdu", "()Z", "canShowLikeEdu", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refresh", "plugin-finder_release"})
public final class m
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.p>
{
  private final boolean rWw;
  private final d.g.a.a<Boolean> rWx;
  final d.g.a.b<Boolean, z> rWy;
  private final d.g.a.a<z> rWz;
  
  public m(boolean paramBoolean, d.g.a.a<Boolean> parama, d.g.a.b<? super Boolean, z> paramb, d.g.a.a<z> parama1)
  {
    AppMethodBeat.i(201819);
    this.rWw = paramBoolean;
    this.rWx = parama;
    this.rWy = paramb;
    this.rWz = parama1;
    AppMethodBeat.o(201819);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201816);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    AppMethodBeat.o(201816);
  }
  
  final void a(final com.tencent.mm.plugin.finder.model.p paramp, final e parame)
  {
    AppMethodBeat.i(201818);
    if ((this.rWw) && (d.g.b.p.i(paramp.sti.dvq, v.aAC())))
    {
      if (((Boolean)this.rWx.invoke()).booleanValue())
      {
        localView = parame.GD(2131307321);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = parame.GD(2131307798);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = parame.GD(2131307245);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = parame.GD(2131308063);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = parame.GD(2131303320);
        if (localView != null)
        {
          localView.setOnClickListener((View.OnClickListener)new a(this, paramp, parame));
          AppMethodBeat.o(201818);
          return;
        }
        AppMethodBeat.o(201818);
        return;
      }
      View localView = parame.GD(2131307245);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = parame.GD(2131308063);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = parame.GD(2131308063);
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new b(this, paramp, parame));
      }
      this.rWz.invoke();
      AppMethodBeat.o(201818);
      return;
    }
    paramp = parame.GD(2131307321);
    if (paramp != null) {
      paramp.setVisibility(0);
    }
    paramp = parame.GD(2131307798);
    if (paramp != null) {
      paramp.setVisibility(8);
    }
    paramp = parame.GD(2131307245);
    if (paramp != null) {
      paramp.setVisibility(0);
    }
    paramp = parame.GD(2131308063);
    if (paramp != null) {
      paramp.setVisibility(8);
    }
    paramp = parame.GD(2131303320);
    if (paramp != null)
    {
      paramp.setVisibility(8);
      AppMethodBeat.o(201818);
      return;
    }
    AppMethodBeat.o(201818);
  }
  
  public final int getLayoutId()
  {
    return 2131496505;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(m paramm, com.tencent.mm.plugin.finder.model.p paramp, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201814);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.rWA.rWy.invoke(Boolean.FALSE);
      this.rWA.a(paramp, parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201814);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(m paramm, com.tencent.mm.plugin.finder.model.p paramp, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201815);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.rWA.rWy.invoke(Boolean.TRUE);
      this.rWA.a(paramp, parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201815);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */