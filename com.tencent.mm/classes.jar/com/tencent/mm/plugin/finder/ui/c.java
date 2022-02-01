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
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class c
  extends BaseAdapter
{
  private String TAG;
  private Activity dtg;
  public ArrayList<apg> jhZ;
  public d.g.a.b<? super apg, d.z> rWl;
  public d.g.a.b<? super apg, d.z> rWm;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(204607);
    this.TAG = "Finder.FinderLikedAdapter";
    this.dtg = paramActivity;
    this.jhZ = new ArrayList();
    AppMethodBeat.o(204607);
  }
  
  private apg Gb(int paramInt)
  {
    AppMethodBeat.i(204604);
    Object localObject = this.jhZ.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (apg)localObject;
    AppMethodBeat.o(204604);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(204600);
    p.h(parama, "vh");
    parama.cMo().setImageResource(2131690419);
    parama.cMo().setIconColor(this.dtg.getResources().getColor(2131099803));
    AppMethodBeat.o(204600);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(204601);
    p.h(parama, "vh");
    parama.cMo().setImageResource(2131690587);
    parama.cMo().setIconColor(this.dtg.getResources().getColor(2131099735));
    AppMethodBeat.o(204601);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(204602);
    p.h(parama, "vh");
    parama.cMq().setImageResource(2131690398);
    parama.cMq().setIconColor(this.dtg.getResources().getColor(2131099732));
    AppMethodBeat.o(204602);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(204603);
    p.h(parama, "vh");
    parama.cMq().setImageResource(2131690569);
    parama.cMq().setIconColor(this.dtg.getResources().getColor(2131099735));
    AppMethodBeat.o(204603);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(204606);
    int i = this.jhZ.size();
    AppMethodBeat.o(204606);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204599);
    View localView = paramView;
    if (paramView == null)
    {
      localView = com.tencent.mm.ui.z.jV((Context)this.dtg).inflate(2131496223, paramViewGroup, false);
      paramView = new a();
      p.g(localView, "itemView");
      localView.setTag(paramView);
    }
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(204599);
      throw paramView;
    }
    paramView = (a)paramView;
    paramViewGroup = localView.findViewById(2131307402);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramViewGroup = (ImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.fTj = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307406);
    p.g(paramViewGroup, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramViewGroup = (TextView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.ovs = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307404);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.rYb = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307403);
    p.g(paramViewGroup, "itemView.findViewById(R.…inder_liked_click_layout)");
    p.h(paramViewGroup, "<set-?>");
    paramView.sNH = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307439);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    p.h(paramViewGroup, "<set-?>");
    paramView.sNI = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307440);
    p.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_layout)");
    p.h(paramViewGroup, "<set-?>");
    paramView.sNJ = paramViewGroup;
    paramViewGroup = Gb(paramInt);
    Object localObject;
    if (p.i(paramViewGroup.dvq, com.tencent.mm.model.v.aAC()))
    {
      paramView.cMp().setVisibility(8);
      paramView.cMq().setVisibility(8);
      localObject = i.srW;
      localObject = i.cEp();
      com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(paramViewGroup.hGI);
      ImageView localImageView = paramView.getAvatarIv();
      i locali = i.srW;
      ((d)localObject).a(locala, localImageView, i.a(i.a.ssb));
      localObject = paramView.ovs;
      if (localObject == null) {
        p.bdF("nicknameTv");
      }
      ((TextView)localObject).setText((CharSequence)k.c((Context)this.dtg, (CharSequence)paramViewGroup.bVF));
      p.h(paramView, "vh");
      p.h(paramViewGroup, "contact");
      if (paramViewGroup.likeFlag != 1) {
        break label531;
      }
      a(paramView);
      label412:
      p.h(paramView, "vh");
      p.h(paramViewGroup, "contact");
      if (paramViewGroup.GGt != 1) {
        break label539;
      }
      c(paramView);
    }
    for (;;)
    {
      paramView.getAvatarIv().setOnClickListener((View.OnClickListener)new d(this, paramViewGroup));
      AppMethodBeat.o(204599);
      return localView;
      paramView.cMp().setVisibility(0);
      paramView.cMp().setOnClickListener((View.OnClickListener)new b(this, paramView, paramViewGroup));
      localObject = paramView.sNJ;
      if (localObject == null) {
        p.bdF("unLikeLayout");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
  public static final class a
  {
    public ImageView fTj;
    public TextView ovs;
    public WeImageView rYb;
    public View sNH;
    public WeImageView sNI;
    public View sNJ;
    
    public final WeImageView cMo()
    {
      AppMethodBeat.i(204593);
      WeImageView localWeImageView = this.rYb;
      if (localWeImageView == null) {
        p.bdF("likeIv");
      }
      AppMethodBeat.o(204593);
      return localWeImageView;
    }
    
    public final View cMp()
    {
      AppMethodBeat.i(204594);
      View localView = this.sNH;
      if (localView == null) {
        p.bdF("likeLayout");
      }
      AppMethodBeat.o(204594);
      return localView;
    }
    
    public final WeImageView cMq()
    {
      AppMethodBeat.i(204595);
      WeImageView localWeImageView = this.sNI;
      if (localWeImageView == null) {
        p.bdF("unLike");
      }
      AppMethodBeat.o(204595);
      return localWeImageView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(204592);
      ImageView localImageView = this.fTj;
      if (localImageView == null) {
        p.bdF("avatarIv");
      }
      AppMethodBeat.o(204592);
      return localImageView;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, c.a parama, apg paramapg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204596);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.sNK;
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
        localObject = ((c)localObject).rWl;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204596);
        return;
        ((c)localObject).a(locala);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, c.a parama, apg paramapg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204597);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.sNK;
      c.a locala = paramView;
      paramView = paramViewGroup;
      p.h(locala, "vh");
      p.h(paramView, "likeInfo");
      if (paramView.GGt == 1) {
        ((c)localObject).d(locala);
      }
      for (;;)
      {
        paramView.GGt = ((paramView.GGt + 1) % 2);
        localObject = ((c)localObject).rWm;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204597);
        return;
        ((c)localObject).c(locala);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(c paramc, apg paramapg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204598);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.d(paramViewGroup.dvq, (Context)c.a(this.sNK));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */