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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class d
  extends BaseAdapter
{
  private String TAG;
  private Activity dKq;
  public ArrayList<aul> kgc;
  public kotlin.g.a.b<? super aul, x> tBx;
  public kotlin.g.a.b<? super aul, x> tBy;
  
  public d(Activity paramActivity)
  {
    AppMethodBeat.i(252396);
    this.TAG = "Finder.FinderLikedAdapter";
    this.dKq = paramActivity;
    this.kgc = new ArrayList();
    AppMethodBeat.o(252396);
  }
  
  private aul Lo(int paramInt)
  {
    AppMethodBeat.i(252393);
    Object localObject = this.kgc.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (aul)localObject;
    AppMethodBeat.o(252393);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(252389);
    p.h(parama, "vh");
    parama.dzw().setImageResource(2131690577);
    parama.dzw().setIconColor(this.dKq.getResources().getColor(2131099818));
    AppMethodBeat.o(252389);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(252390);
    p.h(parama, "vh");
    parama.dzw().setImageResource(2131690822);
    parama.dzw().setIconColor(this.dKq.getResources().getColor(2131099749));
    AppMethodBeat.o(252390);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(252391);
    p.h(parama, "vh");
    parama.dzy().setImageResource(2131690549);
    parama.dzy().setIconColor(this.dKq.getResources().getColor(2131099746));
    AppMethodBeat.o(252391);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(252392);
    p.h(parama, "vh");
    parama.dzy().setImageResource(2131690798);
    parama.dzy().setIconColor(this.dKq.getResources().getColor(2131099749));
    AppMethodBeat.o(252392);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(252395);
    int i = this.kgc.size();
    AppMethodBeat.o(252395);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(252388);
    View localView = paramView;
    if (paramView == null)
    {
      localView = aa.jQ((Context)this.dKq).inflate(2131494359, paramViewGroup, false);
      paramView = new a();
      p.g(localView, "itemView");
      localView.setTag(paramView);
    }
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(252388);
      throw paramView;
    }
    paramView = (a)paramView;
    paramViewGroup = localView.findViewById(2131300859);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramViewGroup = (ImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.gyr = paramViewGroup;
    paramViewGroup = localView.findViewById(2131300863);
    p.g(paramViewGroup, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramViewGroup = (TextView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.pIN = paramViewGroup;
    paramViewGroup = localView.findViewById(2131300861);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.tFv = paramViewGroup;
    paramViewGroup = localView.findViewById(2131300860);
    p.g(paramViewGroup, "itemView.findViewById(R.…inder_liked_click_layout)");
    p.h(paramViewGroup, "<set-?>");
    paramView.vKh = paramViewGroup;
    paramViewGroup = localView.findViewById(2131301501);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.vKi = paramViewGroup;
    paramViewGroup = localView.findViewById(2131301502);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_layout)");
    p.h(paramViewGroup, "<set-?>");
    paramView.vKj = paramViewGroup;
    paramViewGroup = Lo(paramInt);
    Object localObject;
    if (p.j(paramViewGroup.dMW, z.aTY()))
    {
      paramView.dzx().setVisibility(8);
      paramView.dzy().setVisibility(8);
      localObject = m.uJa;
      localObject = m.dkb();
      com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(paramViewGroup.iAR);
      ImageView localImageView = paramView.getAvatarIv();
      m localm = m.uJa;
      ((com.tencent.mm.loader.d)localObject).a(locala, localImageView, m.a(m.a.uJg));
      localObject = paramView.pIN;
      if (localObject == null) {
        p.btv("nicknameTv");
      }
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.dKq, (CharSequence)paramViewGroup.nickName));
      p.h(paramView, "vh");
      p.h(paramViewGroup, "contact");
      if (paramViewGroup.likeFlag != 1) {
        break label531;
      }
      a(paramView);
      label412:
      p.h(paramView, "vh");
      p.h(paramViewGroup, "contact");
      if (paramViewGroup.LFn != 1) {
        break label539;
      }
      c(paramView);
    }
    for (;;)
    {
      paramView.getAvatarIv().setOnClickListener((View.OnClickListener)new d(this, paramViewGroup));
      AppMethodBeat.o(252388);
      return localView;
      paramView.dzx().setVisibility(0);
      paramView.dzx().setOnClickListener((View.OnClickListener)new b(this, paramView, paramViewGroup));
      localObject = paramView.vKj;
      if (localObject == null) {
        p.btv("unLikeLayout");
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
  public static final class a
  {
    public ImageView gyr;
    public TextView pIN;
    public WeImageView tFv;
    public View vKh;
    public WeImageView vKi;
    public View vKj;
    
    public final WeImageView dzw()
    {
      AppMethodBeat.i(252382);
      WeImageView localWeImageView = this.tFv;
      if (localWeImageView == null) {
        p.btv("likeIv");
      }
      AppMethodBeat.o(252382);
      return localWeImageView;
    }
    
    public final View dzx()
    {
      AppMethodBeat.i(252383);
      View localView = this.vKh;
      if (localView == null) {
        p.btv("likeLayout");
      }
      AppMethodBeat.o(252383);
      return localView;
    }
    
    public final WeImageView dzy()
    {
      AppMethodBeat.i(252384);
      WeImageView localWeImageView = this.vKi;
      if (localWeImageView == null) {
        p.btv("unLike");
      }
      AppMethodBeat.o(252384);
      return localWeImageView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(252381);
      ImageView localImageView = this.gyr;
      if (localImageView == null) {
        p.btv("avatarIv");
      }
      AppMethodBeat.o(252381);
      return localImageView;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, d.a parama, aul paramaul) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252385);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.vKk;
      d.a locala = paramView;
      paramView = paramViewGroup;
      p.h(locala, "vh");
      p.h(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        ((d)localObject).b(locala);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((d)localObject).tBx;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252385);
        return;
        ((d)localObject).a(locala);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(d paramd, d.a parama, aul paramaul) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252386);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.vKk;
      d.a locala = paramView;
      paramView = paramViewGroup;
      p.h(locala, "vh");
      p.h(paramView, "likeInfo");
      if (paramView.LFn == 1) {
        ((d)localObject).d(locala);
      }
      for (;;)
      {
        paramView.LFn = ((paramView.LFn + 1) % 2);
        localObject = ((d)localObject).tBy;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252386);
        return;
        ((d)localObject).c(locala);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(d paramd, aul paramaul) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252387);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.d(paramViewGroup.dMW, (Context)d.a(this.vKk));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252387);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.d
 * JD-Core Version:    0.7.0.1
 */