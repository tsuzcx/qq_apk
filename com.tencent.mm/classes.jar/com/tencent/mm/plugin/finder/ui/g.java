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
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import d.g.a.b;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class g
  extends BaseAdapter
{
  private String TAG;
  public ArrayList<alo> dataList;
  private Activity dgE;
  public b<? super alo, y> rbj;
  public b<? super alo, y> rbk;
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(203212);
    this.TAG = "Finder.FinderLikedAdapter";
    this.dgE = paramActivity;
    this.dataList = new ArrayList();
    AppMethodBeat.o(203212);
  }
  
  private alo Eu(int paramInt)
  {
    AppMethodBeat.i(203209);
    Object localObject = this.dataList.get(paramInt);
    d.g.b.k.g(localObject, "dataList[position]");
    localObject = (alo)localObject;
    AppMethodBeat.o(203209);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(203205);
    d.g.b.k.h(parama, "vh");
    parama.cBL().setImageResource(2131690419);
    parama.cBL().setIconColor(this.dgE.getResources().getColor(2131099803));
    AppMethodBeat.o(203205);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(203206);
    d.g.b.k.h(parama, "vh");
    parama.cBL().setImageResource(2131690587);
    parama.cBL().setIconColor(this.dgE.getResources().getColor(2131099735));
    AppMethodBeat.o(203206);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(203207);
    d.g.b.k.h(parama, "vh");
    parama.cBN().setImageResource(2131690398);
    parama.cBN().setIconColor(this.dgE.getResources().getColor(2131099732));
    AppMethodBeat.o(203207);
  }
  
  public final void d(a parama)
  {
    AppMethodBeat.i(203208);
    d.g.b.k.h(parama, "vh");
    parama.cBN().setImageResource(2131690569);
    parama.cBN().setIconColor(this.dgE.getResources().getColor(2131099735));
    AppMethodBeat.o(203208);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(203211);
    int i = this.dataList.size();
    AppMethodBeat.o(203211);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203204);
    View localView = paramView;
    if (paramView == null)
    {
      localView = z.jD((Context)this.dgE).inflate(2131496223, paramViewGroup, false);
      paramView = new a();
      d.g.b.k.g(localView, "itemView");
      localView.setTag(paramView);
    }
    paramView = localView.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
      AppMethodBeat.o(203204);
      throw paramView;
    }
    paramView = (a)paramView;
    paramViewGroup = localView.findViewById(2131307402);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
    paramViewGroup = (ImageView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.fxQ = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307406);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.…finder_liked_username_tv)");
    paramViewGroup = (TextView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.nMU = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307404);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_liked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.rHJ = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307403);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.…inder_liked_click_layout)");
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.rHK = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307439);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_iv)");
    paramViewGroup = (WeImageView)paramViewGroup;
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.rHL = paramViewGroup;
    paramViewGroup = localView.findViewById(2131307440);
    d.g.b.k.g(paramViewGroup, "itemView.findViewById(R.id.finder_unliked_layout)");
    d.g.b.k.h(paramViewGroup, "<set-?>");
    paramView.rHM = paramViewGroup;
    paramViewGroup = Eu(paramInt);
    Object localObject;
    if (d.g.b.k.g(paramViewGroup.diA, u.axw()))
    {
      paramView.cBM().setVisibility(8);
      paramView.cBN().setVisibility(8);
      localObject = h.rtK;
      localObject = h.cwp();
      com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(paramViewGroup.hlG);
      ImageView localImageView = paramView.getAvatarIv();
      h localh = h.rtK;
      ((d)localObject).a(locala, localImageView, h.a(h.a.rtO));
      localObject = paramView.nMU;
      if (localObject == null) {
        d.g.b.k.aVY("nicknameTv");
      }
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.dgE, (CharSequence)paramViewGroup.bLs));
      d.g.b.k.h(paramView, "vh");
      d.g.b.k.h(paramViewGroup, "contact");
      if (paramViewGroup.likeFlag != 1) {
        break label531;
      }
      a(paramView);
      label412:
      d.g.b.k.h(paramView, "vh");
      d.g.b.k.h(paramViewGroup, "contact");
      if (paramViewGroup.EFh != 1) {
        break label539;
      }
      c(paramView);
    }
    for (;;)
    {
      paramView.getAvatarIv().setOnClickListener((View.OnClickListener)new d(this, paramViewGroup));
      AppMethodBeat.o(203204);
      return localView;
      paramView.cBM().setVisibility(0);
      paramView.cBM().setOnClickListener((View.OnClickListener)new b(this, paramView, paramViewGroup));
      localObject = paramView.rHM;
      if (localObject == null) {
        d.g.b.k.aVY("unLikeLayout");
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
  public static final class a
  {
    public ImageView fxQ;
    public TextView nMU;
    public WeImageView rHJ;
    public View rHK;
    public WeImageView rHL;
    public View rHM;
    
    public final WeImageView cBL()
    {
      AppMethodBeat.i(203198);
      WeImageView localWeImageView = this.rHJ;
      if (localWeImageView == null) {
        d.g.b.k.aVY("likeIv");
      }
      AppMethodBeat.o(203198);
      return localWeImageView;
    }
    
    public final View cBM()
    {
      AppMethodBeat.i(203199);
      View localView = this.rHK;
      if (localView == null) {
        d.g.b.k.aVY("likeLayout");
      }
      AppMethodBeat.o(203199);
      return localView;
    }
    
    public final WeImageView cBN()
    {
      AppMethodBeat.i(203200);
      WeImageView localWeImageView = this.rHL;
      if (localWeImageView == null) {
        d.g.b.k.aVY("unLike");
      }
      AppMethodBeat.o(203200);
      return localWeImageView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(203197);
      ImageView localImageView = this.fxQ;
      if (localImageView == null) {
        d.g.b.k.aVY("avatarIv");
      }
      AppMethodBeat.o(203197);
      return localImageView;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(g paramg, g.a parama, alo paramalo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203201);
      Object localObject = this.rHN;
      g.a locala = paramView;
      paramView = paramViewGroup;
      d.g.b.k.h(locala, "vh");
      d.g.b.k.h(paramView, "likeInfo");
      if (paramView.likeFlag == 1) {
        ((g)localObject).b(locala);
      }
      for (;;)
      {
        paramView.likeFlag = ((paramView.likeFlag + 1) % 2);
        localObject = ((g)localObject).rbj;
        if (localObject == null) {
          break;
        }
        ((b)localObject).ay(paramView);
        AppMethodBeat.o(203201);
        return;
        ((g)localObject).a(locala);
      }
      AppMethodBeat.o(203201);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(g paramg, g.a parama, alo paramalo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203202);
      Object localObject = this.rHN;
      g.a locala = paramView;
      paramView = paramViewGroup;
      d.g.b.k.h(locala, "vh");
      d.g.b.k.h(paramView, "likeInfo");
      if (paramView.EFh == 1) {
        ((g)localObject).d(locala);
      }
      for (;;)
      {
        paramView.EFh = ((paramView.EFh + 1) % 2);
        localObject = ((g)localObject).rbk;
        if (localObject == null) {
          break;
        }
        ((b)localObject).ay(paramView);
        AppMethodBeat.o(203202);
        return;
        ((g)localObject).c(locala);
      }
      AppMethodBeat.o(203202);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(g paramg, alo paramalo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203203);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramView = paramViewGroup.diA;
      d.g.b.k.g(paramView, "likedUser.wxUsername");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)g.a(this.rHN));
      AppMethodBeat.o(203203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */