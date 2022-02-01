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
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class a
  extends BaseAdapter
{
  private String TAG;
  private Activity dsa;
  private ArrayList<amp> jfg;
  m<? super View, ? super Integer, z> sAA;
  m<? super View, ? super Integer, z> sAz;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(167129);
    this.TAG = "Finder.FansListAdapter";
    this.dsa = paramActivity;
    this.jfg = new ArrayList();
    AppMethodBeat.o(167129);
  }
  
  public final amp Fy(int paramInt)
  {
    AppMethodBeat.i(167125);
    Object localObject = this.jfg.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (amp)localObject;
    AppMethodBeat.o(167125);
    return localObject;
  }
  
  public final void dJ(List<? extends amp> paramList)
  {
    AppMethodBeat.i(167128);
    p.h(paramList, "contacts");
    this.jfg.clear();
    this.jfg.addAll((Collection)paramList);
    AppMethodBeat.o(167128);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167127);
    int i = this.jfg.size();
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
      paramViewGroup = View.inflate((Context)this.dsa, 2131494032, null);
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
    paramView = (a)paramView;
    Object localObject1 = paramViewGroup.findViewById(2131297008);
    p.g(localObject1, "itemView.findViewById(R.id.avatar_iv)");
    localObject1 = (ImageView)localObject1;
    p.h(localObject1, "<set-?>");
    paramView.fRd = ((ImageView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131302867);
    p.g(localObject1, "itemView.findViewById(R.id.nickname_tv)");
    localObject1 = (TextView)localObject1;
    p.h(localObject1, "<set-?>");
    paramView.opA = ((TextView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131297197);
    p.g(localObject1, "itemView.findViewById(R.id.before_split_tv)");
    localObject1 = (TextView)localObject1;
    p.h(localObject1, "<set-?>");
    paramView.sAB = ((TextView)localObject1);
    localObject1 = Fy(paramInt);
    Object localObject2 = bt.nullAsNil(((amp)localObject1).contact.headUrl);
    Object localObject3;
    ImageView localImageView;
    i locali;
    label328:
    int i;
    if (((amp)localObject1).displayFlag == 0)
    {
      localObject3 = i.sja;
      localObject3 = i.cCD();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a((String)localObject2);
      localImageView = paramView.getAvatarIv();
      locali = i.sja;
      ((d)localObject3).a(localObject2, localImageView, i.a(i.a.sje));
      localObject2 = paramView.opA;
      if (localObject2 == null) {
        p.bcb("nicknameTv");
      }
      ((TextView)localObject2).setText((CharSequence)k.c((Context)this.dsa, (CharSequence)bt.nullAsNil(((amp)localObject1).contact.nickname)));
      localObject1 = (List)this.jfg;
      localObject1 = ((List)localObject1).listIterator(((List)localObject1).size());
      if (!((ListIterator)localObject1).hasPrevious()) {
        break label488;
      }
      if (((amp)((ListIterator)localObject1).previous()).dDp != 1) {
        break label482;
      }
      i = 1;
      label358:
      if (i == 0) {
        break label486;
      }
      i = ((ListIterator)localObject1).nextIndex();
      label372:
      if ((i != paramInt) || (paramInt == getCount() - 1)) {
        break label494;
      }
      paramView.cJt().setVisibility(0);
      label396:
      paramView = paramViewGroup.findViewById(2131299759);
      if (!Fy(paramInt).drv) {
        break label506;
      }
      paramView.setOnLongClickListener(null);
      paramView.setOnClickListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(167124);
      return paramViewGroup;
      localObject3 = i.sja;
      localObject3 = i.cCC();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a((String)localObject2);
      localImageView = paramView.getAvatarIv();
      locali = i.sja;
      ((d)localObject3).a(localObject2, localImageView, i.a(i.a.sjd));
      break;
      label482:
      i = 0;
      break label358;
      label486:
      break label328;
      label488:
      i = -1;
      break label372;
      label494:
      paramView.cJt().setVisibility(8);
      break label396;
      label506:
      paramView.setOnLongClickListener((View.OnLongClickListener)new b(this, paramView, paramInt));
      paramView.setOnClickListener((View.OnClickListener)new c(this, paramView, paramInt));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public ImageView fRd;
    public TextView opA;
    public TextView sAB;
    
    public final TextView cJt()
    {
      AppMethodBeat.i(167122);
      TextView localTextView = this.sAB;
      if (localTextView == null) {
        p.bcb("beforeTip");
      }
      AppMethodBeat.o(167122);
      return localTextView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(178428);
      ImageView localImageView = this.fRd;
      if (localImageView == null) {
        p.bcb("avatarIv");
      }
      AppMethodBeat.o(178428);
      return localImageView;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(a parama, View paramView, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(167123);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
      paramView = this.sAC.sAz;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203881);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = this.sAC.sAA;
      if (paramView != null)
      {
        localObject = paramView;
        p.g(localObject, "clickArea");
        paramView.p(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */