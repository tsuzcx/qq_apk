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
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class d
  extends BaseAdapter
{
  private String TAG;
  private Activity fDf;
  public ArrayList<awr> mXB;
  public kotlin.g.a.b<? super awr, x> xjj;
  public kotlin.g.a.b<? super awr, x> xjk;
  
  public d(Activity paramActivity)
  {
    AppMethodBeat.i(269798);
    this.TAG = "Finder.FinderLikedAdapter";
    this.fDf = paramActivity;
    this.mXB = new ArrayList();
    AppMethodBeat.o(269798);
  }
  
  private awr Qy(int paramInt)
  {
    AppMethodBeat.i(269795);
    Object localObject = this.mXB.get(paramInt);
    p.j(localObject, "dataList[position]");
    localObject = (awr)localObject;
    AppMethodBeat.o(269795);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(269791);
    p.k(parama, "vh");
    parama.eaq().setImageResource(b.i.icons_filled_like);
    parama.eaq().setIconColor(this.fDf.getResources().getColor(b.c.Red));
    AppMethodBeat.o(269791);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(269792);
    p.k(parama, "vh");
    parama.eaq().setImageResource(b.i.icons_outlined_like);
    parama.eaq().setIconColor(this.fDf.getResources().getColor(b.c.FG_2));
    AppMethodBeat.o(269792);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(269793);
    p.k(parama, "vh");
    parama.eas().setImageResource(b.i.icons_filled_eyes_off);
    parama.eas().setIconColor(this.fDf.getResources().getColor(b.c.FG_0));
    AppMethodBeat.o(269793);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(269794);
    p.k(parama, "vh");
    parama.eas().setImageResource(b.i.icons_outlined_eyes_on);
    parama.eas().setIconColor(this.fDf.getResources().getColor(b.c.FG_2));
    AppMethodBeat.o(269794);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(269797);
    int i = this.mXB.size();
    AppMethodBeat.o(269797);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(269790);
    View localView = paramView;
    if (paramView == null)
    {
      localView = ad.kS((Context)this.fDf).inflate(b.g.finder_liked_list_item_layout, paramViewGroup, false);
      paramView = new a();
      p.j(localView, "itemView");
      localView.setTag(paramView);
    }
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(269790);
      throw paramView;
    }
    paramView = (a)paramView;
    paramViewGroup = localView.findViewById(b.f.finder_liked_avatar_iv);
    p.j(paramViewGroup, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramViewGroup = (ImageView)paramViewGroup;
    p.k(paramViewGroup, "<set-?>");
    paramView.jiu = paramViewGroup;
    paramViewGroup = localView.findViewById(b.f.finder_liked_username_tv);
    p.j(paramViewGroup, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramViewGroup = (TextView)paramViewGroup;
    p.k(paramViewGroup, "<set-?>");
    paramView.xoK = paramViewGroup;
    paramViewGroup = localView.findViewById(b.f.finder_liked_iv);
    p.j(paramViewGroup, "itemView.findViewById(R.id.finder_liked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.k(paramViewGroup, "<set-?>");
    paramView.xoe = paramViewGroup;
    paramViewGroup = localView.findViewById(b.f.finder_liked_click_layout);
    p.j(paramViewGroup, "itemView.findViewById(R.…inder_liked_click_layout)");
    p.k(paramViewGroup, "<set-?>");
    paramView.AqZ = paramViewGroup;
    paramViewGroup = localView.findViewById(b.f.finder_unliked_iv);
    p.j(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.k(paramViewGroup, "<set-?>");
    paramView.Ara = paramViewGroup;
    paramViewGroup = localView.findViewById(b.f.finder_unliked_layout);
    p.j(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_layout)");
    p.k(paramViewGroup, "<set-?>");
    paramView.Arb = paramViewGroup;
    paramViewGroup = Qy(paramInt);
    Object localObject;
    if (p.h(paramViewGroup.fGe, z.bcZ()))
    {
      paramView.ear().setVisibility(8);
      paramView.eas().setVisibility(8);
      localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject = com.tencent.mm.plugin.finder.loader.t.dJi();
      e locale = new e(paramViewGroup.lqp);
      ImageView localImageView = paramView.getAvatarIv();
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject).a(locale, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
      localObject = paramView.xoK;
      if (localObject == null) {
        p.bGy("nicknameTv");
      }
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.fDf, (CharSequence)paramViewGroup.nickName));
      p.k(paramView, "vh");
      p.k(paramViewGroup, "contact");
      if (paramViewGroup.likeFlag != 1) {
        break label545;
      }
      a(paramView);
      label426:
      p.k(paramView, "vh");
      p.k(paramViewGroup, "contact");
      if (paramViewGroup.SJo != 1) {
        break label553;
      }
      c(paramView);
    }
    for (;;)
    {
      paramView.getAvatarIv().setOnClickListener((View.OnClickListener)new d(this, paramViewGroup));
      AppMethodBeat.o(269790);
      return localView;
      paramView.ear().setVisibility(0);
      paramView.ear().setOnClickListener((View.OnClickListener)new b(this, paramView, paramViewGroup));
      localObject = paramView.Arb;
      if (localObject == null) {
        p.bGy("unLikeLayout");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new c(this, paramView, paramViewGroup));
      break;
      label545:
      b(paramView);
      break label426;
      label553:
      d(paramView);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
  public static final class a
  {
    public View AqZ;
    public WeImageView Ara;
    public View Arb;
    public ImageView jiu;
    public TextView xoK;
    public WeImageView xoe;
    
    public final WeImageView eaq()
    {
      AppMethodBeat.i(292162);
      WeImageView localWeImageView = this.xoe;
      if (localWeImageView == null) {
        p.bGy("likeIv");
      }
      AppMethodBeat.o(292162);
      return localWeImageView;
    }
    
    public final View ear()
    {
      AppMethodBeat.i(292163);
      View localView = this.AqZ;
      if (localView == null) {
        p.bGy("likeLayout");
      }
      AppMethodBeat.o(292163);
      return localView;
    }
    
    public final WeImageView eas()
    {
      AppMethodBeat.i(292164);
      WeImageView localWeImageView = this.Ara;
      if (localWeImageView == null) {
        p.bGy("unLike");
      }
      AppMethodBeat.o(292164);
      return localWeImageView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(292161);
      ImageView localImageView = this.jiu;
      if (localImageView == null) {
        p.bGy("avatarIv");
      }
      AppMethodBeat.o(292161);
      return localImageView;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, d.a parama, awr paramawr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289510);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.Arc;
      d.a locala = paramView;
      paramView = paramViewGroup;
      p.k(locala, "vh");
      p.k(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        ((d)localObject).b(locala);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((d)localObject).xjj;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289510);
        return;
        ((d)localObject).a(locala);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(d paramd, d.a parama, awr paramawr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289517);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.Arc;
      d.a locala = paramView;
      paramView = paramViewGroup;
      p.k(locala, "vh");
      p.k(paramView, "likeInfo");
      if (paramView.SJo == 1) {
        ((d)localObject).d(locala);
      }
      for (;;)
      {
        paramView.SJo = ((paramView.SJo + 1) % 2);
        localObject = ((d)localObject).xjk;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289517);
        return;
        ((d)localObject).c(locala);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(d paramd, awr paramawr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246549);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.e(paramViewGroup.fGe, (Context)d.a(this.Arc));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246549);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.d
 * JD-Core Version:    0.7.0.1
 */