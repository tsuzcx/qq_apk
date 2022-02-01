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
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class a
  extends BaseAdapter
{
  private String TAG;
  private Activity dtg;
  private ArrayList<anb> jhZ;
  m<? super View, ? super Integer, z> sLA;
  m<? super View, ? super Integer, z> sLz;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(167129);
    this.TAG = "Finder.FansListAdapter";
    this.dtg = paramActivity;
    this.jhZ = new ArrayList();
    AppMethodBeat.o(167129);
  }
  
  public final anb FW(int paramInt)
  {
    AppMethodBeat.i(167125);
    Object localObject = this.jhZ.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (anb)localObject;
    AppMethodBeat.o(167125);
    return localObject;
  }
  
  public final void dM(List<? extends anb> paramList)
  {
    AppMethodBeat.i(167128);
    p.h(paramList, "contacts");
    this.jhZ.clear();
    this.jhZ.addAll((Collection)paramList);
    AppMethodBeat.o(167128);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167127);
    int i = this.jhZ.size();
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
      paramViewGroup = View.inflate((Context)this.dtg, 2131494032, null);
      paramView = new a();
      p.g(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FansListAdapter.ContactViewHolder");
      AppMethodBeat.o(167124);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = paramViewGroup.findViewById(2131297008);
    p.g(paramView, "itemView.findViewById(R.id.avatar_iv)");
    paramView = (ImageView)paramView;
    p.h(paramView, "<set-?>");
    locala.fTj = paramView;
    paramView = paramViewGroup.findViewById(2131302867);
    p.g(paramView, "itemView.findViewById(R.id.nickname_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.ovs = paramView;
    paramView = paramViewGroup.findViewById(2131297197);
    p.g(paramView, "itemView.findViewById(R.id.before_split_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.sLB = paramView;
    anb localanb = FW(paramInt);
    paramView = localanb.contact;
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
    paramView = bu.nullAsNil(paramView);
    Object localObject2;
    Object localObject3;
    label352:
    int i;
    if (localanb.displayFlag == 0)
    {
      localObject1 = i.srW;
      localObject1 = i.cEp();
      paramView = new com.tencent.mm.plugin.finder.loader.a(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = i.srW;
      ((d)localObject1).a(paramView, (ImageView)localObject2, i.a(i.a.ssb));
      localObject2 = locala.ovs;
      if (localObject2 == null) {
        p.bdF("nicknameTv");
      }
      localObject3 = (Context)this.dtg;
      paramView = localanb.contact;
      if (paramView != null)
      {
        localObject1 = paramView.nickname;
        paramView = (View)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramView = "";
      }
      ((TextView)localObject2).setText((CharSequence)k.c((Context)localObject3, (CharSequence)bu.nullAsNil(paramView)));
      paramView = (List)this.jhZ;
      paramView = paramView.listIterator(paramView.size());
      if (!paramView.hasPrevious()) {
        break label508;
      }
      if (((anb)paramView.previous()).dEu != 1) {
        break label502;
      }
      i = 1;
      label380:
      if (i == 0) {
        break label506;
      }
      i = paramView.nextIndex();
      label393:
      if ((i != paramInt) || (paramInt == getCount() - 1)) {
        break label514;
      }
      locala.cLW().setVisibility(0);
      label418:
      paramView = paramViewGroup.findViewById(2131299759);
      if (!FW(paramInt).dsB) {
        break label527;
      }
      paramView.setOnLongClickListener(null);
      paramView.setOnClickListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(167124);
      return paramViewGroup;
      localObject1 = i.srW;
      localObject1 = i.cEo();
      paramView = new com.tencent.mm.plugin.finder.loader.a(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = i.srW;
      ((d)localObject1).a(paramView, (ImageView)localObject2, i.a(i.a.srZ));
      break;
      label502:
      i = 0;
      break label380;
      label506:
      break label352;
      label508:
      i = -1;
      break label393;
      label514:
      locala.cLW().setVisibility(8);
      break label418;
      label527:
      paramView.setOnLongClickListener((View.OnLongClickListener)new b(this, paramView, paramInt));
      paramView.setOnClickListener((View.OnClickListener)new c(this, paramView, paramInt));
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public ImageView fTj;
    public TextView ovs;
    public TextView sLB;
    
    public final TextView cLW()
    {
      AppMethodBeat.i(167122);
      TextView localTextView = this.sLB;
      if (localTextView == null) {
        p.bdF("beforeTip");
      }
      AppMethodBeat.o(167122);
      return localTextView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(178428);
      ImageView localImageView = this.fTj;
      if (localImageView == null) {
        p.bdF("avatarIv");
      }
      AppMethodBeat.o(178428);
      return localImageView;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(a parama, View paramView, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(167123);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
      paramView = this.sLC.sLz;
      if (paramView != null)
      {
        localObject = paramView;
        p.g(localObject, "clickArea");
        paramView.p(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(167123);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204476);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = this.sLC.sLA;
      if (paramView != null)
      {
        localObject = paramView;
        p.g(localObject, "clickArea");
        paramView.p(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204476);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */