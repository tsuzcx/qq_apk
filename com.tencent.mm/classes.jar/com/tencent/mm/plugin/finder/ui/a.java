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
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class a
  extends BaseAdapter
{
  private String TAG;
  private Activity dKq;
  private ArrayList<aqr> kgc;
  kotlin.g.a.m<? super View, ? super Integer, x> uAi;
  kotlin.g.a.m<? super View, ? super Integer, x> uAj;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(167129);
    this.TAG = "Finder.FansListAdapter";
    this.dKq = paramActivity;
    this.kgc = new ArrayList();
    AppMethodBeat.o(167129);
  }
  
  public final aqr IR(int paramInt)
  {
    AppMethodBeat.i(167125);
    Object localObject = this.kgc.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (aqr)localObject;
    AppMethodBeat.o(167125);
    return localObject;
  }
  
  public final void ev(List<? extends aqr> paramList)
  {
    AppMethodBeat.i(167128);
    p.h(paramList, "contacts");
    this.kgc.clear();
    this.kgc.addAll((Collection)paramList);
    AppMethodBeat.o(167128);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167127);
    int i = this.kgc.size();
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
      paramViewGroup = View.inflate((Context)this.dKq, 2131494246, null);
      paramView = new a();
      p.g(paramViewGroup, "itemView");
      paramViewGroup.setTag(paramView);
    }
    paramView = paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FansListAdapter.ContactViewHolder");
      AppMethodBeat.o(167124);
      throw paramView;
    }
    a locala = (a)paramView;
    paramView = paramViewGroup.findViewById(2131297134);
    p.g(paramView, "itemView.findViewById(R.id.avatar_iv)");
    paramView = (ImageView)paramView;
    p.h(paramView, "<set-?>");
    locala.gyr = paramView;
    paramView = paramViewGroup.findViewById(2131305440);
    p.g(paramView, "itemView.findViewById(R.id.nickname_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.pIN = paramView;
    paramView = paramViewGroup.findViewById(2131297346);
    p.g(paramView, "itemView.findViewById(R.id.before_split_tv)");
    paramView = (TextView)paramView;
    p.h(paramView, "<set-?>");
    locala.vGX = paramView;
    aqr localaqr = IR(paramInt);
    paramView = localaqr.contact;
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
    label310:
    label353:
    int i;
    if (localaqr.displayFlag == 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.dkb();
      paramView = new com.tencent.mm.plugin.finder.loader.a(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((d)localObject1).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJg));
      localObject1 = locala.pIN;
      if (localObject1 == null) {
        p.btv("nicknameTv");
      }
      localObject2 = (Context)this.dKq;
      paramView = y.vXH;
      localObject3 = localaqr.username;
      paramView = localaqr.contact;
      if (paramView == null) {
        break label503;
      }
      paramView = paramView.nickname;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)y.hf((String)localObject3, paramView)));
      paramView = (List)this.kgc;
      paramView = paramView.listIterator(paramView.size());
      if (!paramView.hasPrevious()) {
        break label514;
      }
      if (((aqr)paramView.previous()).cSx != 1) {
        break label508;
      }
      i = 1;
      label381:
      if (i == 0) {
        break label512;
      }
      i = paramView.nextIndex();
      label394:
      if ((i != paramInt) || (paramInt == getCount() - 1)) {
        break label520;
      }
      locala.dyQ().setVisibility(0);
      label419:
      paramView = paramViewGroup.findViewById(2131300429);
      if (!IR(paramInt).dJM) {
        break label533;
      }
      paramView.setOnLongClickListener(null);
      paramView.setOnClickListener(null);
    }
    for (;;)
    {
      AppMethodBeat.o(167124);
      return paramViewGroup;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.dka();
      paramView = new com.tencent.mm.plugin.finder.loader.a(paramView);
      localObject2 = locala.getAvatarIv();
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((d)localObject1).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      break;
      label503:
      paramView = null;
      break label310;
      label508:
      i = 0;
      break label381;
      label512:
      break label353;
      label514:
      i = -1;
      break label394;
      label520:
      locala.dyQ().setVisibility(8);
      break label419;
      label533:
      paramView.setOnLongClickListener((View.OnLongClickListener)new b(this, paramView, paramInt));
      paramView.setOnClickListener((View.OnClickListener)new c(this, paramView, paramInt));
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  static final class a
  {
    public ImageView gyr;
    public TextView pIN;
    public TextView vGX;
    
    public final TextView dyQ()
    {
      AppMethodBeat.i(167122);
      TextView localTextView = this.vGX;
      if (localTextView == null) {
        p.btv("beforeTip");
      }
      AppMethodBeat.o(167122);
      return localTextView;
    }
    
    public final ImageView getAvatarIv()
    {
      AppMethodBeat.i(178428);
      ImageView localImageView = this.gyr;
      if (localImageView == null) {
        p.btv("avatarIv");
      }
      AppMethodBeat.o(178428);
      return localImageView;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(a parama, View paramView, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(167123);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
      paramView = this.vGY.uAi;
      if (paramView != null)
      {
        localObject = paramView;
        p.g(localObject, "clickArea");
        paramView.invoke(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(167123);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama, View paramView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252100);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.vGY.uAj;
      if (paramView != null)
      {
        localObject = paramView;
        p.g(localObject, "clickArea");
        paramView.invoke(localObject, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */