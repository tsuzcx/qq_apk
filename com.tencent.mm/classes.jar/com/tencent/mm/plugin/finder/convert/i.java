package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "setUnLikeGray", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.n>
{
  final long dig;
  public d.g.a.b<? super alo, y> rbj;
  public d.g.a.b<? super alo, y> rbk;
  
  public i(long paramLong)
  {
    this.dig = paramLong;
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(201289);
    k.h(parame, "holder");
    ((WeImageView)parame.adJ(2131307404)).setImageResource(2131690419);
    WeImageView localWeImageView = (WeImageView)parame.adJ(2131307404);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099803));
    AppMethodBeat.o(201289);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(201290);
    k.h(parame, "holder");
    ((WeImageView)parame.adJ(2131307404)).setImageResource(2131690587);
    WeImageView localWeImageView = (WeImageView)parame.adJ(2131307404);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099735));
    AppMethodBeat.o(201290);
  }
  
  public static void c(e parame)
  {
    AppMethodBeat.i(201291);
    k.h(parame, "holder");
    ((WeImageView)parame.adJ(2131307439)).setImageResource(2131690398);
    WeImageView localWeImageView = (WeImageView)parame.adJ(2131307439);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099732));
    AppMethodBeat.o(201291);
  }
  
  public static void d(e parame)
  {
    AppMethodBeat.i(201292);
    k.h(parame, "holder");
    ((WeImageView)parame.adJ(2131307439)).setImageResource(2131690569);
    WeImageView localWeImageView = (WeImageView)parame.adJ(2131307439);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099735));
    AppMethodBeat.o(201292);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201287);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(201287);
  }
  
  public final int getLayoutId()
  {
    return 2131496223;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(i parami, e parame, alo paramalo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201284);
      Object localObject = this.rbl;
      e locale = this.ojH;
      paramView = this.rbm;
      k.h(locale, "vh");
      k.h(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        i.b(locale);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((i)localObject).rbj;
        if (localObject == null) {
          break;
        }
        ((d.g.a.b)localObject).ay(paramView);
        AppMethodBeat.o(201284);
        return;
        i.a(locale);
      }
      AppMethodBeat.o(201284);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(i parami, e parame, alo paramalo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201285);
      Object localObject = this.rbl;
      e locale = this.ojH;
      paramView = this.rbm;
      k.h(locale, "vh");
      k.h(paramView, "likeInfo");
      if (paramView.EFh == 1) {
        i.d(locale);
      }
      for (;;)
      {
        paramView.EFh = ((paramView.EFh + 1) % 2);
        localObject = ((i)localObject).rbk;
        if (localObject == null) {
          break;
        }
        ((d.g.a.b)localObject).ay(paramView);
        AppMethodBeat.o(201285);
        return;
        i.c(locale);
      }
      AppMethodBeat.o(201285);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(i parami, alo paramalo, e parame, com.tencent.mm.plugin.finder.model.n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201286);
      paramView = com.tencent.mm.plugin.finder.utils.n.rPN;
      long l;
      if (!com.tencent.mm.plugin.finder.utils.n.isFriend(this.rbm.diA))
      {
        paramView = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (!com.tencent.mm.plugin.finder.utils.n.aeE(this.rbm.diA)) {}
      }
      else
      {
        paramView = a.rOv;
        paramView = this.rbm.diA;
        k.g(paramView, "likedUser.wxUsername");
        Object localObject = this.ojH.getContext();
        k.g(localObject, "holder.context");
        a.d(paramView, (Context)localObject);
        paramView = FinderReporterUIC.seQ;
        paramView = this.ojH.getContext();
        k.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.eV(paramView);
        if (paramView != null)
        {
          localObject = d.rxr;
          paramView = paramView.cGb();
          l = this.rbl.dig;
          localObject = this.rbm.diA;
          k.g(localObject, "likedUser.wxUsername");
          d.b(paramView, l, 6, (String)localObject);
        }
        paramView = FinderReporterUIC.seQ;
        paramView = this.ojH.getContext();
        k.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.eV(paramView);
        if (paramView == null) {
          break label224;
        }
      }
      label224:
      for (int i = paramView.rfR;; i = 0)
      {
        paramView = d.rxr;
        l = this.rbl.dig;
        paramView = this.rbn.ruS.diA;
        k.g(paramView, "item.likeObj.wxUsername");
        d.a(2, l, i, 2, paramView);
        AppMethodBeat.o(201286);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.i
 * JD-Core Version:    0.7.0.1
 */