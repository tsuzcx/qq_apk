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
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.b;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class h
  extends BaseAdapter
{
  public b<? super dzd, d.y> KKO;
  public b<? super dzd, d.y> KKP;
  private String TAG;
  public ArrayList<dzd> dataList;
  private Activity djj;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(199242);
    this.TAG = "Finder.FinderLikedAdapter";
    this.djj = paramActivity;
    this.dataList = new ArrayList();
    AppMethodBeat.o(199242);
  }
  
  private dzd ahE(int paramInt)
  {
    AppMethodBeat.i(199239);
    Object localObject = this.dataList.get(paramInt);
    d.g.b.k.g(localObject, "dataList[position]");
    localObject = (dzd)localObject;
    AppMethodBeat.o(199239);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(199235);
    d.g.b.k.h(parama, "vh");
    parama.fVt().setImageResource(2131690419);
    parama.fVt().setIconColor(this.djj.getResources().getColor(2131099803));
    AppMethodBeat.o(199235);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(199236);
    d.g.b.k.h(parama, "vh");
    parama.fVt().setImageResource(2131690587);
    parama.fVt().setIconColor(this.djj.getResources().getColor(2131099735));
    AppMethodBeat.o(199236);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(199237);
    d.g.b.k.h(parama, "vh");
    parama.fVv().setImageResource(2131690398);
    parama.fVv().setIconColor(this.djj.getResources().getColor(2131099732));
    AppMethodBeat.o(199237);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(199238);
    d.g.b.k.h(parama, "vh");
    parama.fVv().setImageResource(2131690569);
    parama.fVv().setIconColor(this.djj.getResources().getColor(2131099735));
    AppMethodBeat.o(199238);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(199241);
    int i = this.dataList.size();
    AppMethodBeat.o(199241);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(199234);
    View localView = paramView;
    if (paramView == null)
    {
      localView = com.tencent.mm.ui.y.js((Context)this.djj).inflate(2131496222, paramViewGroup, false);
      paramView = new a();
      d.g.b.k.g(localView, "itemView");
      localView.setTag(paramView);
    }
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(199234);
      throw paramView;
    }
    paramView = (a)paramView;
    paramViewGroup = localView.findViewById(2131307333);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramViewGroup = (ImageView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.fuj = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307337);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramViewGroup = (TextView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.nkb = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307335);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.KYu = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307334);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.…inder_liked_click_layout)");
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.qWQ = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307370);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.KYv = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307371);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_layout)");
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.KYw = paramViewGroup;
    paramViewGroup = ahE(paramInt);
    Object localObject;
    if (d.g.b.k.g(paramViewGroup.hKD, u.aqG()))
    {
      paramView.fVu().setVisibility(8);
      paramView.fVv().setVisibility(8);
      localObject = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject = com.tencent.mm.plugin.finder.loader.h.cmW();
      com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(paramViewGroup.gLg);
      ImageView localImageView = paramView.getAvatarIv();
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((d)localObject).a(locala, localImageView, com.tencent.mm.plugin.finder.loader.h.a(com.tencent.mm.plugin.finder.loader.h.a.qCJ));
      localObject = paramView.nkb;
      if (localObject == null) {
        d.g.b.k.aPZ("nicknameTv");
      }
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.djj, (CharSequence)paramViewGroup.bNK));
      d.g.b.k.h(paramView, "vh");
      d.g.b.k.h(paramViewGroup, "contact");
      if (paramViewGroup.likeFlag != 1) {
        break label531;
      }
      a(paramView);
      label412:
      d.g.b.k.h(paramView, "vh");
      d.g.b.k.h(paramViewGroup, "contact");
      if (paramViewGroup.LxF != 1) {
        break label539;
      }
      c(paramView);
    }
    for (;;)
    {
      paramView.getAvatarIv().setOnClickListener((View.OnClickListener)new d(this, paramViewGroup));
      AppMethodBeat.o(199234);
      return localView;
      paramView.fVu().setVisibility(0);
      paramView.fVu().setOnClickListener((View.OnClickListener)new b(this, paramView, paramViewGroup));
      localObject = paramView.KYw;
      if (localObject == null) {
        d.g.b.k.aPZ("unLikeLayout");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
  public static final class a
  {
    public WeImageView KYu;
    public WeImageView KYv;
    public View KYw;
    public ImageView fuj;
    public TextView nkb;
    public View qWQ;
    
    public final WeImageView fVt()
    {
      AppMethodBeat.i(199228);
      WeImageView localWeImageView = this.KYu;
      if (localWeImageView == null) {
        d.g.b.k.aPZ("likeIv");
      }
      AppMethodBeat.o(199228);
      return localWeImageView;
    }
    
    public final View fVu()
    {
      AppMethodBeat.i(199229);
      View localView = this.qWQ;
      if (localView == null) {
        d.g.b.k.aPZ("likeLayout");
      }
      AppMethodBeat.o(199229);
      return localView;
    }
    
    public final WeImageView fVv()
    {
      AppMethodBeat.i(199230);
      WeImageView localWeImageView = this.KYv;
      if (localWeImageView == null) {
        d.g.b.k.aPZ("unLike");
      }
      AppMethodBeat.o(199230);
      return localWeImageView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(199227);
      ImageView localImageView = this.fuj;
      if (localImageView == null) {
        d.g.b.k.aPZ("avatarIv");
      }
      AppMethodBeat.o(199227);
      return localImageView;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh, h.a parama, dzd paramdzd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199231);
      Object localObject = this.KYx;
      h.a locala = paramView;
      paramView = paramViewGroup;
      d.g.b.k.h(locala, "vh");
      d.g.b.k.h(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        ((h)localObject).b(locala);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((h)localObject).KKO;
        if (localObject == null) {
          break;
        }
        ((b)localObject).aA(paramView);
        AppMethodBeat.o(199231);
        return;
        ((h)localObject).a(locala);
      }
      AppMethodBeat.o(199231);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh, h.a parama, dzd paramdzd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199232);
      Object localObject = this.KYx;
      h.a locala = paramView;
      paramView = paramViewGroup;
      d.g.b.k.h(locala, "vh");
      d.g.b.k.h(paramView, "likeInfo");
      if (paramView.LxF == 1) {
        ((h)localObject).d(locala);
      }
      for (;;)
      {
        paramView.LxF = ((paramView.LxF + 1) % 2);
        localObject = ((h)localObject).KKP;
        if (localObject == null) {
          break;
        }
        ((b)localObject).aA(paramView);
        AppMethodBeat.o(199232);
        return;
        ((h)localObject).c(locala);
      }
      AppMethodBeat.o(199232);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh, dzd paramdzd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199233);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramView = paramViewGroup.hKD;
      d.g.b.k.g(paramView, "likedUser.wxUsername");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)h.a(this.KYx));
      AppMethodBeat.o(199233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.h
 * JD-Core Version:    0.7.0.1
 */