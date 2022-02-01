package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends BaseAdapter
{
  public kotlin.g.a.b<? super bco, ah> AIb;
  public kotlin.g.a.b<? super bco, ah> AIc;
  private String TAG;
  private Activity hHU;
  public ArrayList<bco> pUj;
  
  public d(Activity paramActivity)
  {
    AppMethodBeat.i(346501);
    this.TAG = "Finder.FinderLikedAdapter";
    this.hHU = paramActivity;
    this.pUj = new ArrayList();
    AppMethodBeat.o(346501);
  }
  
  private bco TG(int paramInt)
  {
    AppMethodBeat.i(346527);
    Object localObject = this.pUj.get(paramInt);
    s.s(localObject, "dataList[position]");
    localObject = (bco)localObject;
    AppMethodBeat.o(346527);
    return localObject;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(346505);
    s.u(parama, "vh");
    parama.fbd().setImageResource(e.g.icons_filled_like);
    parama.fbd().setIconColor(this.hHU.getResources().getColor(e.b.Red));
    AppMethodBeat.o(346505);
  }
  
  private static final void a(d paramd, a parama, bco parambco, View paramView)
  {
    AppMethodBeat.i(346537);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(parama);
    localb.cH(parambco);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(parama, "$viewHolder");
    s.u(parambco, "$likedUser");
    s.u(parama, "vh");
    s.u(parambco, "likeInfo");
    if (parambco.likeFlag == 1) {
      paramd.b(parama);
    }
    for (;;)
    {
      parambco.likeFlag = ((parambco.likeFlag + 1) % 2);
      paramd = paramd.AIb;
      if (paramd != null) {
        paramd.invoke(parambco);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346537);
      return;
      paramd.a(parama);
    }
  }
  
  private static final void a(bco parambco, d paramd, View paramView)
  {
    AppMethodBeat.i(346549);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambco);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambco, "$likedUser");
    s.u(paramd, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.e(parambco.hLv, (Context)paramd.hHU);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346549);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(346512);
    s.u(parama, "vh");
    parama.fbd().setImageResource(e.g.icons_outlined_like);
    parama.fbd().setIconColor(this.hHU.getResources().getColor(e.b.FG_2));
    AppMethodBeat.o(346512);
  }
  
  private static final void b(d paramd, a parama, bco parambco, View paramView)
  {
    AppMethodBeat.i(346545);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(parama);
    localb.cH(parambco);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(parama, "$viewHolder");
    s.u(parambco, "$likedUser");
    s.u(parama, "vh");
    s.u(parambco, "likeInfo");
    if (parambco.ZNz == 1) {
      paramd.d(parama);
    }
    for (;;)
    {
      parambco.ZNz = ((parambco.ZNz + 1) % 2);
      paramd = paramd.AIc;
      if (paramd != null) {
        paramd.invoke(parambco);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346545);
      return;
      paramd.c(parama);
    }
  }
  
  private void c(a parama)
  {
    AppMethodBeat.i(346518);
    s.u(parama, "vh");
    parama.fbf().setImageResource(e.g.icons_filled_eyes_off);
    parama.fbf().setIconColor(this.hHU.getResources().getColor(e.b.FG_0));
    AppMethodBeat.o(346518);
  }
  
  private void d(a parama)
  {
    AppMethodBeat.i(346522);
    s.u(parama, "vh");
    parama.fbf().setImageResource(e.g.icons_outlined_eyes_on);
    parama.fbf().setIconColor(this.hHU.getResources().getColor(e.b.FG_2));
    AppMethodBeat.o(346522);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(346580);
    int i = this.pUj.size();
    AppMethodBeat.o(346580);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(346571);
    View localView = paramView;
    if (paramView == null)
    {
      localView = af.mU((Context)this.hHU).inflate(e.f.finder_liked_list_item_layout, paramViewGroup, false);
      localView.setTag(new a());
    }
    s.checkNotNull(localView);
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(346571);
      throw paramView;
    }
    paramViewGroup = (a)paramView;
    paramView = localView.findViewById(e.e.finder_liked_avatar_iv);
    s.s(paramView, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramView = (ImageView)paramView;
    s.u(paramView, "<set-?>");
    paramViewGroup.lKK = paramView;
    paramView = localView.findViewById(e.e.finder_liked_username_tv);
    s.s(paramView, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramView = (TextView)paramView;
    s.u(paramView, "<set-?>");
    paramViewGroup.nicknameTv = paramView;
    paramView = localView.findViewById(e.e.finder_liked_iv);
    s.s(paramView, "itemView.findViewById(R.id.finder_liked_iv)");
    paramView = (WeImageView)paramView;
    s.u(paramView, "<set-?>");
    paramViewGroup.ALM = paramView;
    paramView = localView.findViewById(e.e.finder_liked_click_layout);
    s.s(paramView, "itemView.findViewById(R.…inder_liked_click_layout)");
    s.u(paramView, "<set-?>");
    paramViewGroup.FQD = paramView;
    paramView = localView.findViewById(e.e.finder_unliked_iv);
    s.s(paramView, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramView = (WeImageView)paramView;
    s.u(paramView, "<set-?>");
    paramViewGroup.FQE = paramView;
    paramView = localView.findViewById(e.e.finder_unliked_layout);
    s.s(paramView, "itemView.findViewById(R.id.finder_unliked_layout)");
    s.u(paramView, "<set-?>");
    paramViewGroup.FQF = paramView;
    bco localbco = TG(paramInt);
    if (s.p(localbco.hLv, z.bAM()))
    {
      paramViewGroup.fbe().setVisibility(8);
      paramViewGroup.fbf().setVisibility(8);
      paramView = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramView = com.tencent.mm.plugin.finder.loader.p.eCq();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(localbco.nVs);
      ImageView localImageView = paramViewGroup.getAvatarIv();
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramView.a(localb, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      paramView = paramViewGroup.nicknameTv;
      if (paramView == null) {
        break label551;
      }
      label367:
      paramView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.hHU, (CharSequence)localbco.nickName));
      s.u(paramViewGroup, "vh");
      s.u(localbco, "contact");
      if (localbco.likeFlag != 1) {
        break label562;
      }
      a(paramViewGroup);
      label420:
      s.u(paramViewGroup, "vh");
      s.u(localbco, "contact");
      if (localbco.ZNz != 1) {
        break label570;
      }
      c(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.getAvatarIv().setOnClickListener(new d..ExternalSyntheticLambda2(localbco, this));
      AppMethodBeat.o(346571);
      return localView;
      paramViewGroup.fbe().setVisibility(0);
      paramViewGroup.fbe().setOnClickListener(new d..ExternalSyntheticLambda1(this, paramViewGroup, localbco));
      paramViewGroup.fbg().setOnClickListener(new d..ExternalSyntheticLambda0(this, paramViewGroup, localbco));
      paramView = com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.hHU, (CharSequence)localbco.nickName);
      paramViewGroup.fbg().setTag(e.e.finder_accessibility_nickname_tag, paramView);
      break;
      label551:
      s.bIx("nicknameTv");
      paramView = null;
      break label367;
      label562:
      b(paramViewGroup);
      break label420;
      label570:
      d(paramViewGroup);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public WeImageView ALM;
    public View FQD;
    public WeImageView FQE;
    public View FQF;
    public ImageView lKK;
    public TextView nicknameTv;
    
    public final WeImageView fbd()
    {
      AppMethodBeat.i(346948);
      WeImageView localWeImageView = this.ALM;
      if (localWeImageView != null)
      {
        AppMethodBeat.o(346948);
        return localWeImageView;
      }
      s.bIx("likeIv");
      AppMethodBeat.o(346948);
      return null;
    }
    
    public final View fbe()
    {
      AppMethodBeat.i(346953);
      View localView = this.FQD;
      if (localView != null)
      {
        AppMethodBeat.o(346953);
        return localView;
      }
      s.bIx("likeLayout");
      AppMethodBeat.o(346953);
      return null;
    }
    
    public final WeImageView fbf()
    {
      AppMethodBeat.i(346960);
      WeImageView localWeImageView = this.FQE;
      if (localWeImageView != null)
      {
        AppMethodBeat.o(346960);
        return localWeImageView;
      }
      s.bIx("unLike");
      AppMethodBeat.o(346960);
      return null;
    }
    
    public final View fbg()
    {
      AppMethodBeat.i(346966);
      View localView = this.FQF;
      if (localView != null)
      {
        AppMethodBeat.o(346966);
        return localView;
      }
      s.bIx("unLikeLayout");
      AppMethodBeat.o(346966);
      return null;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(346938);
      ImageView localImageView = this.lKK;
      if (localImageView != null)
      {
        AppMethodBeat.o(346938);
        return localImageView;
      }
      s.bIx("avatarIv");
      AppMethodBeat.o(346938);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.d
 * JD-Core Version:    0.7.0.1
 */