package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class a
  extends BaseAdapter
{
  private String TAG;
  private Activity fDf;
  private ArrayList<asn> mXB;
  m<? super View, ? super Integer, x> yWG;
  m<? super View, ? super Integer, x> yWH;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(167129);
    this.TAG = "Finder.FansListAdapter";
    this.fDf = paramActivity;
    this.mXB = new ArrayList();
    AppMethodBeat.o(167129);
  }
  
  public final asn MK(int paramInt)
  {
    AppMethodBeat.i(167125);
    Object localObject = this.mXB.get(paramInt);
    p.j(localObject, "dataList[position]");
    localObject = (asn)localObject;
    AppMethodBeat.o(167125);
    return localObject;
  }
  
  public final void eQ(List<? extends asn> paramList)
  {
    AppMethodBeat.i(167128);
    p.k(paramList, "contacts");
    this.mXB.clear();
    this.mXB.addAll((Collection)paramList);
    AppMethodBeat.o(167128);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167127);
    int i = this.mXB.size();
    AppMethodBeat.o(167127);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(167124);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate((Context)this.fDf, b.g.finder_fans_list_item, null);
      paramView = new a();
      p.j(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FansListAdapter.ContactViewHolder");
      AppMethodBeat.o(167124);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = paramViewGroup.findViewById(b.f.avatar_iv);
    p.j(paramView, "itemView.findViewById(R.id.avatar_iv)");
    paramView = (ImageView)paramView;
    p.k(paramView, "<set-?>");
    locala.jiu = paramView;
    paramView = paramViewGroup.findViewById(b.f.nickname_tv);
    p.j(paramView, "itemView.findViewById(R.id.nickname_tv)");
    paramView = (TextView)paramView;
    p.k(paramView, "<set-?>");
    locala.xoK = paramView;
    paramView = paramViewGroup.findViewById(b.f.before_split_tv);
    p.j(paramView, "itemView.findViewById(R.id.before_split_tv)");
    paramView = (TextView)paramView;
    p.k(paramView, "<set-?>");
    locala.Aao = paramView;
    asn localasn = MK(paramInt);
    paramView = localasn.contact;
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = paramView.headUrl;
      paramView = (View)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramView = "";
    }
    paramView = Util.nullAsNil(paramView);
    Object localObject2;
    Object localObject3;
    label315:
    label358:
    int i;
    if (localasn.displayFlag == 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject1 = com.tencent.mm.plugin.finder.loader.t.dJi();
      paramView = new e(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((d)localObject1).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
      localObject1 = locala.xoK;
      if (localObject1 == null) {
        p.bGy("nicknameTv");
      }
      localObject2 = (Context)this.fDf;
      paramView = aj.AGc;
      localObject3 = localasn.username;
      paramView = localasn.contact;
      if (paramView == null) {
        break label520;
      }
      paramView = paramView.nickname;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)aj.ht((String)localObject3, paramView)));
      paramView = (List)this.mXB;
      paramView = paramView.listIterator(paramView.size());
      if (!paramView.hasPrevious()) {
        break label531;
      }
      if (((asn)paramView.previous()).cUP != 1) {
        break label525;
      }
      i = 1;
      label386:
      if (i == 0) {
        break label529;
      }
      i = paramView.nextIndex();
      label399:
      if ((i != paramInt) || (paramInt == getCount() - 1)) {
        break label537;
      }
      locala.dZH().setVisibility(0);
      label424:
      paramView = paramViewGroup.findViewById(b.f.fans_main_layout);
      if (!MK(paramInt).fCB) {
        break label550;
      }
      paramView.setOnLongClickListener(null);
      paramView.setOnClickListener((View.OnClickListener)new b(this, paramView, paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(167124);
      return paramViewGroup;
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
      paramView = new e(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((d)localObject1).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      break;
      label520:
      paramView = null;
      break label315;
      label525:
      i = 0;
      break label386;
      label529:
      break label358;
      label531:
      i = -1;
      break label399;
      label537:
      locala.dZH().setVisibility(8);
      break label424;
      label550:
      paramView.setOnLongClickListener((View.OnLongClickListener)new c(this, paramView, paramInt));
      paramView.setOnClickListener((View.OnClickListener)new d(this, paramView, paramInt));
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public TextView Aao;
    public ImageView jiu;
    public TextView xoK;
    
    public final TextView dZH()
    {
      AppMethodBeat.i(167122);
      TextView localTextView = this.Aao;
      if (localTextView == null) {
        p.bGy("beforeTip");
      }
      AppMethodBeat.o(167122);
      return localTextView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(178428);
      ImageView localImageView = this.jiu;
      if (localImageView == null) {
        p.bGy("avatarIv");
      }
      AppMethodBeat.o(178428);
      return localImageView;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287134);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.AnV.yWH;
      if (paramView != null)
      {
        localObject = paramView;
        p.j(localObject, "clickArea");
        paramView.invoke(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287134);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class c
    implements View.OnLongClickListener
  {
    c(a parama, View paramView, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(290050);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      paramView = this.AnV.yWG;
      if (paramView != null)
      {
        localObject = paramView;
        p.j(localObject, "clickArea");
        paramView.invoke(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(290050);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280068);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.AnV.yWH;
      if (paramView != null)
      {
        localObject = paramView;
        p.j(localObject, "clickArea");
        paramView.invoke(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280068);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */