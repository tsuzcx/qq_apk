package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "setUnLikeGray", "plugin-finder_release"})
public final class aa
  extends com.tencent.mm.view.recyclerview.b<z>
{
  public d.g.a.b<? super dzd, y> KKO;
  public d.g.a.b<? super dzd, y> KKP;
  final long feedId;
  
  public aa(long paramLong)
  {
    this.feedId = paramLong;
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(197414);
    k.h(parame, "holder");
    ((WeImageView)parame.abq(2131307335)).setImageResource(2131690419);
    WeImageView localWeImageView = (WeImageView)parame.abq(2131307335);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099803));
    AppMethodBeat.o(197414);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(197415);
    k.h(parame, "holder");
    ((WeImageView)parame.abq(2131307335)).setImageResource(2131690587);
    WeImageView localWeImageView = (WeImageView)parame.abq(2131307335);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099735));
    AppMethodBeat.o(197415);
  }
  
  public static void c(e parame)
  {
    AppMethodBeat.i(197416);
    k.h(parame, "holder");
    ((WeImageView)parame.abq(2131307370)).setImageResource(2131690398);
    WeImageView localWeImageView = (WeImageView)parame.abq(2131307370);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099732));
    AppMethodBeat.o(197416);
  }
  
  public static void d(e parame)
  {
    AppMethodBeat.i(197417);
    k.h(parame, "holder");
    ((WeImageView)parame.abq(2131307370)).setImageResource(2131690569);
    WeImageView localWeImageView = (WeImageView)parame.abq(2131307370);
    parame = parame.getContext();
    k.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099735));
    AppMethodBeat.o(197417);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(197412);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(197412);
  }
  
  public final int getLayoutId()
  {
    return 2131496222;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(aa paramaa, e parame, dzd paramdzd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197409);
      Object localObject = this.KKQ;
      e locale = this.nGG;
      paramView = this.KKR;
      k.h(locale, "vh");
      k.h(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        aa.b(locale);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((aa)localObject).KKO;
        if (localObject == null) {
          break;
        }
        ((d.g.a.b)localObject).aA(paramView);
        AppMethodBeat.o(197409);
        return;
        aa.a(locale);
      }
      AppMethodBeat.o(197409);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(aa paramaa, e parame, dzd paramdzd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197410);
      Object localObject = this.KKQ;
      e locale = this.nGG;
      paramView = this.KKR;
      k.h(locale, "vh");
      k.h(paramView, "likeInfo");
      if (paramView.LxF == 1) {
        aa.d(locale);
      }
      for (;;)
      {
        paramView.LxF = ((paramView.LxF + 1) % 2);
        localObject = ((aa)localObject).KKP;
        if (localObject == null) {
          break;
        }
        ((d.g.a.b)localObject).aA(paramView);
        AppMethodBeat.o(197410);
        return;
        aa.c(locale);
      }
      AppMethodBeat.o(197410);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(aa paramaa, dzd paramdzd, e parame, z paramz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197411);
      paramView = i.qTa;
      long l;
      if (!i.isFriend(this.KKR.hKD))
      {
        paramView = i.qTa;
        if (!i.ZS(this.KKR.hKD)) {}
      }
      else
      {
        paramView = a.qSb;
        paramView = this.KKR.hKD;
        k.g(paramView, "likedUser.wxUsername");
        Object localObject = this.nGG.getContext();
        k.g(localObject, "holder.context");
        a.d(paramView, (Context)localObject);
        paramView = FinderReporterUIC.Ljl;
        paramView = this.nGG.getContext();
        k.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.lB(paramView);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.finder.report.b.qFq;
          paramView = paramView.fXs();
          l = this.KKQ.feedId;
          localObject = this.KKR.hKD;
          k.g(localObject, "likedUser.wxUsername");
          com.tencent.mm.plugin.finder.report.b.b(paramView, l, 6, (String)localObject);
        }
        paramView = FinderReporterUIC.Ljl;
        paramView = this.nGG.getContext();
        k.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.lB(paramView);
        if (paramView == null) {
          break label224;
        }
      }
      label224:
      for (int i = paramView.qqE;; i = 0)
      {
        paramView = com.tencent.mm.plugin.finder.report.b.qFq;
        l = this.KKQ.feedId;
        paramView = this.KKS.KTs.hKD;
        k.g(paramView, "item.likeObj.wxUsername");
        com.tencent.mm.plugin.finder.report.b.a(2, l, i, 2, paramView);
        AppMethodBeat.o(197411);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aa
 * JD-Core Version:    0.7.0.1
 */