package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class c
  extends BaseAdapter
{
  private String TAG;
  private Activity dsa;
  public ArrayList<aot> jfg;
  public d.g.a.b<? super aot, d.z> rNT;
  public d.g.a.b<? super aot, d.z> rNU;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(204011);
    this.TAG = "Finder.FinderLikedAdapter";
    this.dsa = paramActivity;
    this.jfg = new ArrayList();
    AppMethodBeat.o(204011);
  }
  
  private aot FD(int paramInt)
  {
    AppMethodBeat.i(204008);
    Object localObject = this.jfg.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (aot)localObject;
    AppMethodBeat.o(204008);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(204004);
    p.h(parama, "vh");
    parama.cJL().setImageResource(2131690419);
    parama.cJL().setIconColor(this.dsa.getResources().getColor(2131099803));
    AppMethodBeat.o(204004);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(204005);
    p.h(parama, "vh");
    parama.cJL().setImageResource(2131690587);
    parama.cJL().setIconColor(this.dsa.getResources().getColor(2131099735));
    AppMethodBeat.o(204005);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(204006);
    p.h(parama, "vh");
    parama.cJN().setImageResource(2131690398);
    parama.cJN().setIconColor(this.dsa.getResources().getColor(2131099732));
    AppMethodBeat.o(204006);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(204007);
    p.h(parama, "vh");
    parama.cJN().setImageResource(2131690569);
    parama.cJN().setIconColor(this.dsa.getResources().getColor(2131099735));
    AppMethodBeat.o(204007);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(204010);
    int i = this.jfg.size();
    AppMethodBeat.o(204010);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204003);
    View localView = paramView;
    if (paramView == null)
    {
      localView = com.tencent.mm.ui.z.jO((Context)this.dsa).inflate(2131496223, paramViewGroup, false);
      paramView = new a();
      p.g(localView, "itemView");
      localView.setTag(paramView);
    }
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(204003);
      throw paramView;
    }
    paramView = (a)paramView;
    paramViewGroup = localView.findViewById(2131307402);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramViewGroup = (ImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.fRd = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307406);
    p.g(paramViewGroup, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramViewGroup = (TextView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.opA = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307404);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.rPA = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307403);
    p.g(paramViewGroup, "itemView.findViewById(R.…inder_liked_click_layout)");
    p.h(paramViewGroup, "<set-?>");
    paramView.sCI = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307439);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.sCJ = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307440);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_layout)");
    p.h(paramViewGroup, "<set-?>");
    paramView.sCK = paramViewGroup;
    paramViewGroup = FD(paramInt);
    Object localObject;
    if (p.i(paramViewGroup.dul, u.aAm()))
    {
      paramView.cJM().setVisibility(8);
      paramView.cJN().setVisibility(8);
      localObject = i.sja;
      localObject = i.cCD();
      com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(paramViewGroup.hDQ);
      ImageView localImageView = paramView.getAvatarIv();
      i locali = i.sja;
      ((d)localObject).a(locala, localImageView, i.a(i.a.sje));
      localObject = paramView.opA;
      if (localObject == null) {
        p.bcb("nicknameTv");
      }
      ((TextView)localObject).setText((CharSequence)k.c((Context)this.dsa, (CharSequence)paramViewGroup.bVF));
      p.h(paramView, "vh");
      p.h(paramViewGroup, "contact");
      if (paramViewGroup.likeFlag != 1) {
        break label531;
      }
      a(paramView);
      label412:
      p.h(paramView, "vh");
      p.h(paramViewGroup, "contact");
      if (paramViewGroup.Gnn != 1) {
        break label539;
      }
      c(paramView);
    }
    for (;;)
    {
      paramView.getAvatarIv().setOnClickListener((View.OnClickListener)new d(this, paramViewGroup));
      AppMethodBeat.o(204003);
      return localView;
      paramView.cJM().setVisibility(0);
      paramView.cJM().setOnClickListener((View.OnClickListener)new b(this, paramView, paramViewGroup));
      localObject = paramView.sCK;
      if (localObject == null) {
        p.bcb("unLikeLayout");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new c(this, paramView, paramViewGroup));
      break;
      label531:
      b(paramView);
      break label412;
      label539:
      d(paramView);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
  public static final class a
  {
    public ImageView fRd;
    public TextView opA;
    public WeImageView rPA;
    public View sCI;
    public WeImageView sCJ;
    public View sCK;
    
    public final WeImageView cJL()
    {
      AppMethodBeat.i(203997);
      WeImageView localWeImageView = this.rPA;
      if (localWeImageView == null) {
        p.bcb("likeIv");
      }
      AppMethodBeat.o(203997);
      return localWeImageView;
    }
    
    public final View cJM()
    {
      AppMethodBeat.i(203998);
      View localView = this.sCI;
      if (localView == null) {
        p.bcb("likeLayout");
      }
      AppMethodBeat.o(203998);
      return localView;
    }
    
    public final WeImageView cJN()
    {
      AppMethodBeat.i(203999);
      WeImageView localWeImageView = this.sCJ;
      if (localWeImageView == null) {
        p.bcb("unLike");
      }
      AppMethodBeat.o(203999);
      return localWeImageView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(203996);
      ImageView localImageView = this.fRd;
      if (localImageView == null) {
        p.bcb("avatarIv");
      }
      AppMethodBeat.o(203996);
      return localImageView;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, c.a parama, aot paramaot) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204000);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.sCL;
      c.a locala = paramView;
      paramView = paramViewGroup;
      p.h(locala, "vh");
      p.h(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        ((c)localObject).b(locala);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((c)localObject).rNT;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204000);
        return;
        ((c)localObject).a(locala);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, c.a parama, aot paramaot) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204001);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.sCL;
      c.a locala = paramView;
      paramView = paramViewGroup;
      p.h(locala, "vh");
      p.h(paramView, "likeInfo");
      if (paramView.Gnn == 1) {
        ((c)localObject).d(locala);
      }
      for (;;)
      {
        paramView.Gnn = ((paramView.Gnn + 1) % 2);
        localObject = ((c)localObject).rNU;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204001);
        return;
        ((c)localObject).c(locala);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(c paramc, aot paramaot) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204002);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = paramViewGroup.dul;
      p.g(paramView, "likedUser.wxUsername");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)c.a(this.sCL));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */