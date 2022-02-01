package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "TAG", "", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "unlikeToast", "Landroid/widget/Toast;", "cancelToast", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "needToast", "setUnLikeGray", "showCenterToast", "context", "Landroid/content/Context;", "text", "resource", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.p>
{
  final String TAG;
  final long duw;
  public d.g.a.b<? super apg, z> rWl;
  public d.g.a.b<? super apg, z> rWm;
  private Toast rWn;
  
  public j(long paramLong)
  {
    this.duw = paramLong;
    this.TAG = "Finder.FinderFeedFriendLikeConvert";
  }
  
  private final void ar(Context paramContext, String paramString)
  {
    AppMethodBeat.i(201805);
    cAB();
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
    this.rWn = localToast;
    AppMethodBeat.o(201805);
  }
  
  private final void cAB()
  {
    AppMethodBeat.i(201806);
    Toast localToast = this.rWn;
    if (localToast != null) {
      localToast.cancel();
    }
    this.rWn = null;
    AppMethodBeat.o(201806);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201801);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    AppMethodBeat.o(201801);
  }
  
  public final void b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(201803);
    d.g.b.p.h(parame, "holder");
    ((WeImageView)parame.GD(2131307439)).setImageResource(2131690568);
    Object localObject = (WeImageView)parame.GD(2131307439);
    Context localContext = parame.getContext();
    d.g.b.p.g(localContext, "holder.context");
    ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099804));
    if (paramBoolean)
    {
      localObject = parame.getContext();
      d.g.b.p.g(localObject, "holder.context");
      parame = parame.getContext().getString(2131766861);
      d.g.b.p.g(parame, "holder.context.getString…finder_unlike_toast_text)");
      ar((Context)localObject, parame);
    }
    AppMethodBeat.o(201803);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(201804);
    d.g.b.p.h(parame, "holder");
    ((WeImageView)parame.GD(2131307439)).setImageResource(2131690569);
    WeImageView localWeImageView = (WeImageView)parame.GD(2131307439);
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    localWeImageView.setIconColor(parame.getResources().getColor(2131099734));
    cAB();
    AppMethodBeat.o(201804);
  }
  
  public final int getLayoutId()
  {
    return 2131496223;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(j paramj, e parame, apg paramapg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201798);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.rWo;
      e locale = this.oTF;
      paramView = this.rWp;
      d.g.b.p.h(locale, "vh");
      d.g.b.p.h(paramView, "likeInfo");
      if (paramView.GGt == 1) {
        ((j)localObject).c(locale);
      }
      for (;;)
      {
        paramView.GGt = ((paramView.GGt + 1) % 2);
        localObject = ((j)localObject).rWm;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201798);
        return;
        ((j)localObject).b(locale, true);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(j paramj, apg paramapg, e parame, com.tencent.mm.plugin.finder.model.p paramp) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201799);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.isFriend(this.rWp.dvq))
      {
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (!com.tencent.mm.plugin.finder.utils.p.ajV(this.rWp.dvq)) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramView = this.rWp.dvq;
        localObject = this.oTF.getContext();
        d.g.b.p.g(localObject, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
        paramView = FinderReporterUIC.tnG;
        paramView = this.oTF.getContext();
        d.g.b.p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fc(paramView);
        if (paramView != null)
        {
          localObject = i.syT;
          i.b(paramView.cQZ(), this.rWo.duw, 6, this.rWp.dvq);
        }
        paramView = FinderReporterUIC.tnG;
        paramView = this.oTF.getContext();
        d.g.b.p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fc(paramView);
        if (paramView == null) {
          break label230;
        }
      }
      label230:
      for (int i = paramView.sch;; i = 0)
      {
        paramView = i.syT;
        i.a(2, this.rWo.duw, i, 2, this.rWq.sti.dvq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201799);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j
 * JD-Core Version:    0.7.0.1
 */