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
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class f
  extends BaseAdapter
{
  private String TAG;
  private ArrayList<ajs> dataList;
  private Activity dgE;
  m<? super View, ? super Integer, y> rFA;
  m<? super View, ? super Integer, y> rFB;
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(167129);
    this.TAG = "Finder.FansListAdapter";
    this.dgE = paramActivity;
    this.dataList = new ArrayList();
    AppMethodBeat.o(167129);
  }
  
  public final ajs Eq(int paramInt)
  {
    AppMethodBeat.i(167125);
    Object localObject = this.dataList.get(paramInt);
    d.g.b.k.g(localObject, "dataList[position]");
    localObject = (ajs)localObject;
    AppMethodBeat.o(167125);
    return localObject;
  }
  
  public final void dC(List<? extends ajs> paramList)
  {
    AppMethodBeat.i(167128);
    d.g.b.k.h(paramList, "contacts");
    this.dataList.clear();
    this.dataList.addAll((Collection)paramList);
    AppMethodBeat.o(167128);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167127);
    int i = this.dataList.size();
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
      paramViewGroup = View.inflate((Context)this.dgE, 2131494032, null);
      paramView = new a();
      d.g.b.k.g(paramViewGroup, "itemView");
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
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.avatar_iv)");
    localObject1 = (ImageView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.fxQ = ((ImageView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131302867);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.nickname_tv)");
    localObject1 = (TextView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.nMU = ((TextView)localObject1);
    localObject1 = paramViewGroup.findViewById(2131297197);
    d.g.b.k.g(localObject1, "itemView.findViewById(R.id.before_split_tv)");
    localObject1 = (TextView)localObject1;
    d.g.b.k.h(localObject1, "<set-?>");
    paramView.rFC = ((TextView)localObject1);
    localObject1 = Eq(paramInt);
    Object localObject2 = bs.nullAsNil(((ajs)localObject1).contact.headUrl);
    Object localObject3;
    ImageView localImageView;
    h localh;
    label328:
    int i;
    if (((ajs)localObject1).displayFlag == 0)
    {
      localObject3 = h.rtK;
      localObject3 = h.cwp();
      localObject2 = new a((String)localObject2);
      localImageView = paramView.getAvatarIv();
      localh = h.rtK;
      ((d)localObject3).a(localObject2, localImageView, h.a(h.a.rtO));
      localObject2 = paramView.nMU;
      if (localObject2 == null) {
        d.g.b.k.aVY("nicknameTv");
      }
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.dgE, (CharSequence)bs.nullAsNil(((ajs)localObject1).contact.nickname)));
      localObject1 = (List)this.dataList;
      localObject1 = ((List)localObject1).listIterator(((List)localObject1).size());
      if (!((ListIterator)localObject1).hasPrevious()) {
        break label488;
      }
      if (((ajs)((ListIterator)localObject1).previous()).drx != 1) {
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
      paramView.cBt().setVisibility(0);
      label396:
      paramView = paramViewGroup.findViewById(2131299759);
      if (!Eq(paramInt).dfZ) {
        break label506;
      }
      paramView.setOnLongClickListener(null);
      paramView.setOnClickListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(167124);
      return paramViewGroup;
      localObject3 = h.rtK;
      localObject3 = h.cwo();
      localObject2 = new a((String)localObject2);
      localImageView = paramView.getAvatarIv();
      localh = h.rtK;
      ((d)localObject3).a(localObject2, localImageView, h.a(h.a.rtN));
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
      paramView.cBt().setVisibility(8);
      break label396;
      label506:
      paramView.setOnLongClickListener((View.OnLongClickListener)new b(this, paramView, paramInt));
      paramView.setOnClickListener((View.OnClickListener)new c(this, paramView, paramInt));
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public ImageView fxQ;
    public TextView nMU;
    public TextView rFC;
    
    public final TextView cBt()
    {
      AppMethodBeat.i(167122);
      TextView localTextView = this.rFC;
      if (localTextView == null) {
        d.g.b.k.aVY("beforeTip");
      }
      AppMethodBeat.o(167122);
      return localTextView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(178428);
      ImageView localImageView = this.fxQ;
      if (localImageView == null) {
        d.g.b.k.aVY("avatarIv");
      }
      AppMethodBeat.o(178428);
      return localImageView;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(f paramf, View paramView, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(167123);
      paramView = this.rFD.rFA;
      if (paramView != null)
      {
        View localView = paramView;
        d.g.b.k.g(localView, "clickArea");
        paramView.n(localView, Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(167123);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(f paramf, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203085);
      paramView = this.rFD.rFB;
      if (paramView != null)
      {
        View localView = paramView;
        d.g.b.k.g(localView, "clickArea");
        paramView.n(localView, Integer.valueOf(paramInt));
        AppMethodBeat.o(203085);
        return;
      }
      AppMethodBeat.o(203085);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f
 * JD-Core Version:    0.7.0.1
 */