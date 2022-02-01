package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.view.recyclerview.e;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "showEdu", "", "isSelfLike", "Lkotlin/Function0;", "selfLikeClick", "Lkotlin/Function1;", "", "onRefresh", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getOnRefresh", "getSelfLikeClick", "()Lkotlin/jvm/functions/Function1;", "getShowEdu", "()Z", "canShowLikeEdu", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refresh", "plugin-finder_release"})
public final class m
  extends com.tencent.mm.view.recyclerview.b<o>
{
  private final a<z> EIA;
  private final boolean EIx;
  private final a<Boolean> EIy;
  final d.g.a.b<Boolean, z> EIz;
  
  public m(boolean paramBoolean, a<Boolean> parama, d.g.a.b<? super Boolean, z> paramb, a<z> parama1)
  {
    AppMethodBeat.i(221459);
    this.EIx = paramBoolean;
    this.EIy = parama;
    this.EIz = paramb;
    this.EIA = parama1;
    AppMethodBeat.o(221459);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201385);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(201385);
  }
  
  final void a(o paramo, e parame)
  {
    AppMethodBeat.i(221458);
    if ((this.EIx) && (p.i(paramo.skl.dul, u.aAm())))
    {
      if (((Boolean)this.EIy.invoke()).booleanValue())
      {
        localView = parame.Gd(2131307321);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = parame.Gd(2131307798);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = parame.Gd(2131307245);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = parame.Gd(2131308063);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = parame.Gd(2131303320);
        if (localView != null)
        {
          localView.setOnClickListener((View.OnClickListener)new m.a(this, paramo, parame));
          AppMethodBeat.o(221458);
          return;
        }
        AppMethodBeat.o(221458);
        return;
      }
      View localView = parame.Gd(2131307245);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = parame.Gd(2131308063);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = parame.Gd(2131308063);
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new m.b(this, paramo, parame));
      }
      this.EIA.invoke();
      AppMethodBeat.o(221458);
      return;
    }
    paramo = parame.Gd(2131307321);
    if (paramo != null) {
      paramo.setVisibility(0);
    }
    paramo = parame.Gd(2131307798);
    if (paramo != null) {
      paramo.setVisibility(8);
    }
    paramo = parame.Gd(2131307245);
    if (paramo != null) {
      paramo.setVisibility(0);
    }
    paramo = parame.Gd(2131308063);
    if (paramo != null) {
      paramo.setVisibility(8);
    }
    paramo = parame.Gd(2131303320);
    if (paramo != null)
    {
      paramo.setVisibility(8);
      AppMethodBeat.o(221458);
      return;
    }
    AppMethodBeat.o(221458);
  }
  
  public final int getLayoutId()
  {
    return 2131496505;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */