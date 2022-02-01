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
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "TAG", "", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "unlikeToast", "Landroid/widget/Toast;", "cancelToast", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "needToast", "setUnLikeGray", "showCenterToast", "context", "Landroid/content/Context;", "text", "resource", "plugin-finder_release"})
public final class n
  extends e<v>
{
  final String TAG;
  final long feedId;
  public kotlin.g.a.b<? super aul, x> tBx;
  public kotlin.g.a.b<? super aul, x> tBy;
  private Toast tBz;
  
  public n(long paramLong)
  {
    this.feedId = paramLong;
    this.TAG = "Finder.FinderFeedFriendLikeConvert";
  }
  
  private final void aA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(242879);
    cZB();
    Toast localToast = Toast.makeText(paramContext, (CharSequence)"", 0);
    View localView = View.inflate(paramContext, 2131493459, null);
    Object localObject = (WeImageView)localView.findViewById(2131309259);
    ((WeImageView)localObject).setImageResource(2131690549);
    p.g(localObject, "it");
    ViewGroup.LayoutParams localLayoutParams = ((WeImageView)localObject).getLayoutParams();
    int i = paramContext.getResources().getDimensionPixelSize(2131165306);
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    ((WeImageView)localObject).setLayoutParams(localLayoutParams);
    ((WeImageView)localObject).setIconColor(paramContext.getResources().getColor(2131099681));
    localObject = (TextView)localView.findViewById(2131309260);
    p.g(localObject, "it");
    ((TextView)localObject).setText((CharSequence)paramString);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimension(2131165261));
    ((TextView)localObject).setTextColor(paramContext.getResources().getColor(2131099681));
    localToast.setGravity(17, 0, 0);
    p.g(localToast, "toast");
    localToast.setView(localView);
    localToast.show();
    this.tBz = localToast;
    AppMethodBeat.o(242879);
  }
  
  private final void cZB()
  {
    AppMethodBeat.i(242880);
    Toast localToast = this.tBz;
    if (localToast != null) {
      localToast.cancel();
    }
    this.tBz = null;
    AppMethodBeat.o(242880);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(242875);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(242875);
  }
  
  public final void b(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(242877);
    p.h(paramh, "holder");
    ((WeImageView)paramh.Mn(2131301501)).setImageResource(2131690797);
    Object localObject = (WeImageView)paramh.Mn(2131301501);
    Context localContext = paramh.getContext();
    p.g(localContext, "holder.context");
    ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099819));
    if (paramBoolean)
    {
      localObject = paramh.getContext();
      p.g(localObject, "holder.context");
      paramh = paramh.getContext().getString(2131760656);
      p.g(paramh, "holder.context.getString…finder_unlike_toast_text)");
      aA((Context)localObject, paramh);
    }
    AppMethodBeat.o(242877);
  }
  
  public final void e(h paramh)
  {
    AppMethodBeat.i(242878);
    p.h(paramh, "holder");
    ((WeImageView)paramh.Mn(2131301501)).setImageResource(2131690798);
    WeImageView localWeImageView = (WeImageView)paramh.Mn(2131301501);
    paramh = paramh.getContext();
    p.g(paramh, "holder.context");
    localWeImageView.setIconColor(paramh.getResources().getColor(2131099748));
    cZB();
    AppMethodBeat.o(242878);
  }
  
  public final int getLayoutId()
  {
    return 2131494359;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(n paramn, h paramh, aul paramaul) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242872);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.tBA;
      h localh = this.qhp;
      paramView = this.tBB;
      p.h(localh, "vh");
      p.h(paramView, "likeInfo");
      if (paramView.LFn == 1) {
        ((n)localObject).e(localh);
      }
      for (;;)
      {
        paramView.LFn = ((paramView.LFn + 1) % 2);
        localObject = ((n)localObject).tBy;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242872);
        return;
        ((n)localObject).b(localh, true);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(n paramn, aul paramaul, h paramh, v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242873);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = y.vXH;
      if (!y.isFriend(this.tBB.dMW))
      {
        paramView = y.vXH;
        if (!y.awn(this.tBB.dMW)) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = this.tBB.dMW;
        localObject = this.qhp.getContext();
        p.g(localObject, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
        paramView = FinderReporterUIC.wzC;
        paramView = this.qhp.getContext();
        p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fH(paramView);
        if (paramView != null)
        {
          localObject = k.vfA;
          k.a(paramView.dIx(), this.tBA.feedId, 6, this.tBB.dMW);
        }
        paramView = FinderReporterUIC.wzC;
        paramView = this.qhp.getContext();
        p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fH(paramView);
        if (paramView == null) {
          break label230;
        }
      }
      label230:
      for (int i = paramView.tCE;; i = 0)
      {
        paramView = k.vfA;
        k.a(2, this.tBA.feedId, i, 2, this.tBC.uOk.dMW);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242873);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(z.f paramf, int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(242874);
      paramAnimator = (View)this.tBD.SYG;
      p.g(paramAnimator, "maskView");
      paramAnimator.setVisibility(8);
      Log.i(this.tBA.TAG, "maskView gone " + this.gUj);
      AppMethodBeat.o(242874);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */