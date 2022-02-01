package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.y.f;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "TAG", "", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "unlikeToast", "Landroid/widget/Toast;", "cancelToast", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "needToast", "setUnLikeGray", "showCenterToast", "context", "Landroid/content/Context;", "text", "resource", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.view.recyclerview.b<o>
{
  final String TAG;
  final long dtq;
  public d.g.a.b<? super aot, z> rNT;
  public d.g.a.b<? super aot, z> rNU;
  private Toast rNV;
  
  public j(long paramLong)
  {
    this.dtq = paramLong;
    this.TAG = "Finder.FinderFeedFriendLikeConvert";
  }
  
  private final void ap(Context paramContext, String paramString)
  {
    AppMethodBeat.i(201376);
    cyX();
    Toast localToast = Toast.makeText(paramContext, (CharSequence)"", 0);
    View localView = View.inflate(paramContext, 2131493368, null);
    Object localObject = (WeImageView)localView.findViewById(2131305956);
    ((WeImageView)localObject).setImageResource(2131690398);
    d.g.b.p.g(localObject, "it");
    ViewGroup.LayoutParams localLayoutParams = ((WeImageView)localObject).getLayoutParams();
    int i = paramContext.getResources().getDimensionPixelSize(2131165296);
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    ((WeImageView)localObject).setLayoutParams(localLayoutParams);
    ((WeImageView)localObject).setIconColor(paramContext.getResources().getColor(2131099674));
    localObject = (TextView)localView.findViewById(2131305957);
    d.g.b.p.g(localObject, "it");
    ((TextView)localObject).setText((CharSequence)paramString);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimension(2131165257));
    ((TextView)localObject).setTextColor(paramContext.getResources().getColor(2131099674));
    localToast.setGravity(17, 0, 0);
    d.g.b.p.g(localToast, "toast");
    localToast.setView(localView);
    localToast.show();
    this.rNV = localToast;
    AppMethodBeat.o(201376);
  }
  
  private final void cyX()
  {
    AppMethodBeat.i(201377);
    Toast localToast = this.rNV;
    if (localToast != null) {
      localToast.cancel();
    }
    this.rNV = null;
    AppMethodBeat.o(201377);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201372);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    AppMethodBeat.o(201372);
  }
  
  public final void b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(201374);
    d.g.b.p.h(parame, "holder");
    ((WeImageView)parame.Gd(2131307439)).setImageResource(2131690568);
    Object localObject = (WeImageView)parame.Gd(2131307439);
    Context localContext = parame.getContext();
    d.g.b.p.g(localContext, "holder.context");
    ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099804));
    if (paramBoolean)
    {
      localObject = parame.getContext();
      d.g.b.p.g(localObject, "holder.context");
      parame = parame.getContext().getString(2131766861);
      d.g.b.p.g(parame, "holder.context.getString…finder_unlike_toast_text)");
      ap((Context)localObject, parame);
    }
    AppMethodBeat.o(201374);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(201375);
    d.g.b.p.h(parame, "holder");
    ((WeImageView)parame.Gd(2131307439)).setImageResource(2131690569);
    WeImageView localWeImageView = (WeImageView)parame.Gd(2131307439);
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099734));
    cyX();
    AppMethodBeat.o(201375);
  }
  
  public final int getLayoutId()
  {
    return 2131496223;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(j paramj, e parame, aot paramaot) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201369);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.rNW;
      e locale = this.oNd;
      paramView = this.rNX;
      d.g.b.p.h(locale, "vh");
      d.g.b.p.h(paramView, "likeInfo");
      if (paramView.Gnn == 1) {
        ((j)localObject).c(locale);
      }
      for (;;)
      {
        paramView.Gnn = ((paramView.Gnn + 1) % 2);
        localObject = ((j)localObject).rNU;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201369);
        return;
        ((j)localObject).b(locale, true);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(j paramj, aot paramaot, e parame, o paramo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201370);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      long l;
      if (!com.tencent.mm.plugin.finder.utils.p.isFriend(this.rNX.dul))
      {
        paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (!com.tencent.mm.plugin.finder.utils.p.aiY(this.rNX.dul)) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
        paramView = this.rNX.dul;
        d.g.b.p.g(paramView, "likedUser.wxUsername");
        localObject = this.oNd.getContext();
        d.g.b.p.g(localObject, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
        paramView = FinderReporterUIC.tcM;
        paramView = this.oNd.getContext();
        d.g.b.p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.eY(paramView);
        if (paramView != null)
        {
          localObject = h.soM;
          paramView = paramView.cOu();
          l = this.rNW.dtq;
          localObject = this.rNX.dul;
          d.g.b.p.g(localObject, "likedUser.wxUsername");
          h.b(paramView, l, 6, (String)localObject);
        }
        paramView = FinderReporterUIC.tcM;
        paramView = this.oNd.getContext();
        d.g.b.p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.eY(paramView);
        if (paramView == null) {
          break label268;
        }
      }
      label268:
      for (int i = paramView.rTD;; i = 0)
      {
        paramView = h.soM;
        l = this.rNW.dtq;
        paramView = this.rNY.skl.dul;
        d.g.b.p.g(paramView, "item.likeObj.wxUsername");
        h.a(2, l, i, 2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201370);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(y.f paramf, int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221455);
      paramAnimator = (View)this.rNZ.MLV;
      d.g.b.p.g(paramAnimator, "maskView");
      paramAnimator.setVisibility(8);
      ad.i(this.rNW.TAG, "maskView gone " + this.ghM);
      AppMethodBeat.o(221455);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j
 * JD-Core Version:    0.7.0.1
 */