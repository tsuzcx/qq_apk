package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BaseAdapter
{
  m<? super View, ? super Integer, ah> CyZ;
  m<? super View, ? super Integer, ah> FNY;
  private String TAG;
  private Activity hHU;
  private ArrayList<axc> pUj;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(167129);
    this.TAG = "Finder.FansListAdapter";
    this.hHU = paramActivity;
    this.pUj = new ArrayList();
    AppMethodBeat.o(167129);
  }
  
  private static final void a(a parama, View paramView1, int paramInt, View paramView2)
  {
    AppMethodBeat.i(346568);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView1);
    localb.sc(paramInt);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FansListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.CyZ;
    if (parama != null)
    {
      s.s(paramView1, "clickArea");
      parama.invoke(paramView1, Integer.valueOf(paramInt));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FansListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346568);
  }
  
  private static final boolean b(a parama, View paramView1, int paramInt, View paramView2)
  {
    AppMethodBeat.i(346570);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView1);
    localb.sc(paramInt);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FansListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.FNY;
    if (parama != null)
    {
      s.s(paramView1, "clickArea");
      parama.invoke(paramView1, Integer.valueOf(paramInt));
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/ui/FansListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(346570);
    return true;
  }
  
  private static final void c(a parama, View paramView1, int paramInt, View paramView2)
  {
    AppMethodBeat.i(346575);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView1);
    localb.sc(paramInt);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FansListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.CyZ;
    if (parama != null)
    {
      s.s(paramView1, "clickArea");
      parama.invoke(paramView1, Integer.valueOf(paramInt));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FansListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346575);
  }
  
  private final int eOz()
  {
    AppMethodBeat.i(346562);
    Object localObject = (List)this.pUj;
    localObject = ((List)localObject).listIterator(((List)localObject).size());
    while (((ListIterator)localObject).hasPrevious())
    {
      if (((axc)((ListIterator)localObject).previous()).eQp == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        i = ((ListIterator)localObject).nextIndex();
        AppMethodBeat.o(346562);
        return i;
      }
    }
    AppMethodBeat.o(346562);
    return -1;
  }
  
  public final axc Oi(int paramInt)
  {
    AppMethodBeat.i(167125);
    Object localObject = this.pUj.get(paramInt);
    s.s(localObject, "dataList[position]");
    localObject = (axc)localObject;
    AppMethodBeat.o(167125);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167127);
    int i = this.pUj.size();
    AppMethodBeat.o(167127);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(167124);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate((Context)this.hHU, e.f.finder_fans_list_item, null);
      paramViewGroup.setTag(new a());
    }
    s.checkNotNull(paramViewGroup);
    paramView = paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FansListAdapter.ContactViewHolder");
      AppMethodBeat.o(167124);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = paramViewGroup.findViewById(e.e.avatar_iv);
    s.s(paramView, "itemView.findViewById(R.id.avatar_iv)");
    paramView = (ImageView)paramView;
    s.u(paramView, "<set-?>");
    locala.lKK = paramView;
    paramView = paramViewGroup.findViewById(e.e.nickname_tv);
    s.s(paramView, "itemView.findViewById(R.id.nickname_tv)");
    paramView = (TextView)paramView;
    s.u(paramView, "<set-?>");
    locala.nicknameTv = paramView;
    paramView = paramViewGroup.findViewById(e.e.before_split_tv);
    s.s(paramView, "itemView.findViewById(R.id.before_split_tv)");
    paramView = (TextView)paramView;
    s.u(paramView, "<set-?>");
    locala.FvR = paramView;
    axc localaxc = Oi(paramInt);
    paramView = localaxc.contact;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      paramView = "";
      paramView = Util.nullAsNil(paramView);
      if (localaxc.displayFlag != 0) {
        break label412;
      }
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCq();
      paramView = new com.tencent.mm.plugin.finder.loader.b(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject1).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      label251:
      paramView = locala.nicknameTv;
      if (paramView == null) {
        break label460;
      }
      label261:
      localObject2 = (Context)this.hHU;
      localObject1 = av.GiL;
      localObject3 = localaxc.username;
      localObject1 = localaxc.contact;
      if (localObject1 != null) {
        break label471;
      }
      localObject1 = null;
      label297:
      paramView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)av.ip((String)localObject3, (String)localObject1)));
      if ((eOz() != paramInt) || (paramInt == getCount() - 1)) {
        break label481;
      }
      locala.faB().setVisibility(0);
      label346:
      paramView = paramViewGroup.findViewById(e.e.fans_main_layout);
      if (!Oi(paramInt).hHq) {
        break label494;
      }
      paramView.setOnLongClickListener(null);
      paramView.setOnClickListener(new a..ExternalSyntheticLambda1(this, paramView, paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(167124);
      return paramViewGroup;
      localObject1 = paramView.headUrl;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramView = "";
      break;
      label412:
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramView = new com.tencent.mm.plugin.finder.loader.b(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject1).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      break label251;
      label460:
      s.bIx("nicknameTv");
      paramView = null;
      break label261;
      label471:
      localObject1 = ((FinderContact)localObject1).nickname;
      break label297;
      label481:
      locala.faB().setVisibility(8);
      break label346;
      label494:
      paramView.setOnLongClickListener(new a..ExternalSyntheticLambda2(this, paramView, paramInt));
      paramView.setOnClickListener(new a..ExternalSyntheticLambda0(this, paramView, paramInt));
    }
  }
  
  public final void hD(List<? extends axc> paramList)
  {
    AppMethodBeat.i(167128);
    s.u(paramList, "contacts");
    this.pUj.clear();
    this.pUj.addAll((Collection)paramList);
    AppMethodBeat.o(167128);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    public TextView FvR;
    public ImageView lKK;
    public TextView nicknameTv;
    
    public final TextView faB()
    {
      AppMethodBeat.i(167122);
      TextView localTextView = this.FvR;
      if (localTextView != null)
      {
        AppMethodBeat.o(167122);
        return localTextView;
      }
      s.bIx("beforeTip");
      AppMethodBeat.o(167122);
      return null;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(178428);
      ImageView localImageView = this.lKK;
      if (localImageView != null)
      {
        AppMethodBeat.o(178428);
        return localImageView;
      }
      s.bIx("avatarIv");
      AppMethodBeat.o(178428);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */