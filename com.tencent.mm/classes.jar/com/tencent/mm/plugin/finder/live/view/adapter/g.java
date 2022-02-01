package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "stickViewContainer", "Landroid/view/View;", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "RV_ITEM_START_OFFSET", "TAG", "", "getTAG", "()Ljava/lang/String;", "TYPE_BOTTOM", "TYPE_MEMBER_OFFLINE", "TYPE_MEMBER_ONLINE", "TYPE_TITLE_OFFLINE", "TYPE_TITLE_ONLINE", "UP_ICON_SIZE", "getUP_ICON_SIZE", "UP_ICON_SIZE$delegate", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "enableGift", "", "itemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/ParameterName;", "name", "contact", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "lastVisibleViewPos", "", "getLastVisibleViewPos", "()[I", "setLastVisibleViewPos", "([I)V", "onlineMembersSize", "rankWidgetClickListener", "Lkotlin/Function0;", "getRankWidgetClickListener", "()Lkotlin/jvm/functions/Function0;", "setRankWidgetClickListener", "(Lkotlin/jvm/functions/Function0;)V", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "selfItemPosition", "getSelfItemPosition", "setSelfItemPosition", "(I)V", "stickView", "getStickView", "()Landroid/view/View;", "setStickView", "(Landroid/view/View;)V", "getStickViewContainer", "stickViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "getStickViewHolder", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "setStickViewHolder", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;)V", "stickViewY", "getStickViewY", "setStickViewY", "bindBottom", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberBottomViewHolder;", "position", "bindMember", "bindTitle", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberCategoryViewHolder;", "fillStickView", "selfPosition", "data", "getItemCount", "getItemViewType", "haveAttachStickView", "hideStickContainer", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "onRecyclerViewScrollLogic", "setRankTv", "setReawrdAmount", "setUserItem", "updateMemberList", "onlineMembers", "", "selfContact", "offlineMembers", "onlineMemberCnt", "offlineMemberCnt", "AbsMemberViewHolder", "FinderLiveContactInfo", "MemberBottomViewHolder", "MemberCategoryViewHolder", "MemberViewHolder", "plugin-finder_release"})
public final class g
  extends RecyclerView.a<a>
{
  public final String TAG;
  public kotlin.g.a.b<? super avn, x> hXE;
  private final RecyclerView hak;
  public ArrayList<b> kgc;
  public final int uAW;
  public final int uAX;
  private final int uAY;
  public final int uAZ;
  private final f uAe;
  private final int uBa;
  public final int uBb;
  public boolean uBc;
  public int uBd;
  public kotlin.g.a.a<x> uBe;
  public int uBf;
  public f uBg;
  public View uBh;
  private int uBi;
  private int[] uBj;
  private final f uBk;
  private final View usm;
  
  public g(RecyclerView paramRecyclerView, View paramView)
  {
    AppMethodBeat.i(247821);
    this.hak = paramRecyclerView;
    this.usm = paramView;
    this.TAG = "FinderLiveMemberLinearAdapter";
    this.uAW = 1;
    this.uAY = 1;
    this.uAZ = 2;
    this.uBa = 3;
    this.uBb = 4;
    this.uBc = true;
    this.kgc = new ArrayList();
    this.uBf = 2147483647;
    paramRecyclerView = this.usm.findViewById(2131301147);
    p.g(paramRecyclerView, "stickViewContainer.findV…r_live_member_stick_view)");
    this.uBh = paramRecyclerView;
    this.uBj = new int[2];
    paramRecyclerView = m.vVH;
    int j;
    int k;
    if (!m.dBP())
    {
      j = au.az(this.hak.getContext()).y;
      k = au.aD(this.hak.getContext());
      paramRecyclerView = this.uBh.getLayoutParams();
      if (paramRecyclerView == null) {
        break label257;
      }
    }
    label257:
    for (int i = paramRecyclerView.height;; i = 0)
    {
      this.uBi = (j - k - i);
      paramRecyclerView = this.uBh;
      paramView = MMApplicationContext.getContext();
      p.g(paramView, "MMApplicationContext.getContext()");
      paramRecyclerView.setBackgroundColor(paramView.getResources().getColor(2131099695));
      this.hak.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(247796);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(247796);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(247795);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          p.h(paramAnonymousRecyclerView, "recyclerView");
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          g.a(this.uBl, paramAnonymousRecyclerView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(247795);
        }
      });
      this.uAe = kotlin.g.ah((kotlin.g.a.a)c.uBp);
      this.uBk = kotlin.g.ah((kotlin.g.a.a)g.uBz);
      AppMethodBeat.o(247821);
      return;
    }
  }
  
  private int diF()
  {
    AppMethodBeat.i(247817);
    int i = ((Number)this.uAe.getValue()).intValue();
    AppMethodBeat.o(247817);
    return i;
  }
  
  private int diL()
  {
    AppMethodBeat.i(247818);
    int i = ((Number)this.uBk.getValue()).intValue();
    AppMethodBeat.o(247818);
    return i;
  }
  
  public final void a(f paramf, int paramInt, avn paramavn)
  {
    AppMethodBeat.i(247816);
    int i;
    label28:
    int j;
    label40:
    int k;
    label50:
    int m;
    label92:
    Object localObject2;
    if (paramavn != null)
    {
      localObject1 = paramavn.LDK;
      if (localObject1 == null) {
        break label399;
      }
      i = ((avi)localObject1).LFV;
      if (localObject1 == null) {
        break label405;
      }
      j = ((avi)localObject1).LFX;
      if (paramavn == null) {
        break label411;
      }
      k = paramavn.LGi;
      m = this.uBd;
      m = this.uAW + m;
      localObject1 = y.vXH;
      if (paramavn == null) {
        break label417;
      }
      localObject1 = paramavn.contact;
      if (localObject1 == null) {
        break label417;
      }
      localObject1 = ((FinderContact)localObject1).username;
      boolean bool2 = y.awn((String)localObject1);
      if (!bool2) {
        break label429;
      }
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("myself setRankTv contact is empty:");
      if (paramavn != null) {
        break label423;
      }
      bool1 = true;
      label129:
      Log.i((String)localObject1, bool1 + ",position:" + paramInt + ",badgeType:" + i + ",badgeLevel:" + j + ",rewardAmount:" + k + ",validPos:" + m);
      if ((k <= 0) || (paramInt >= m)) {
        break label710;
      }
      localObject1 = paramf.uBs;
      p.g(localObject1, "holder.badgeRank");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(paramInt));
      if (paramInt != this.uAW) {
        break label537;
      }
      localObject1 = paramf.uBs;
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100420));
      paramf.uBs.setTextSize(1, 22.0F);
      label289:
      if (bool2) {
        break label765;
      }
      paramf = this.TAG;
      localObject1 = new StringBuilder("setRankTv contact is empty:");
      if (paramavn != null) {
        break label704;
      }
    }
    label399:
    label405:
    label411:
    label417:
    label423:
    label429:
    label704:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i(paramf, bool1 + ",position:" + paramInt + ",badgeType:" + i + ",badgeLevel:" + j + ",rewardAmount:" + k + ",validPos:" + m);
      AppMethodBeat.o(247816);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label28;
      j = 0;
      break label40;
      k = 0;
      break label50;
      localObject1 = null;
      break label92;
      bool1 = false;
      break label129;
      localObject1 = m.vVH;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("setRankTv contact is empty:");
      if (paramavn == null) {}
      for (bool1 = true;; bool1 = false)
      {
        m.hd((String)localObject1, bool1 + ",position:" + paramInt + ",badgeType:" + i + ",badgeLevel:" + j + ",rewardAmount:" + k + ",validPos:" + m);
        break;
      }
      if (paramInt == this.uAW + 1)
      {
        localObject1 = paramf.uBs;
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100422));
        paramf.uBs.setTextSize(1, 22.0F);
        break label289;
      }
      if (paramInt == this.uAW + 2)
      {
        localObject1 = paramf.uBs;
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131100421));
        paramf.uBs.setTextSize(1, 22.0F);
        break label289;
      }
      localObject1 = paramf.uBs;
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099678));
      paramf.uBs.setTextSize(1, 15.0F);
      break label289;
    }
    label537:
    label710:
    paramavn = paramf.uBs;
    Object localObject1 = MMApplicationContext.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    paramavn.setTextColor(((Context)localObject1).getResources().getColor(2131099678));
    paramf = paramf.uBs;
    p.g(paramf, "holder.badgeRank");
    paramf.setText((CharSequence)"-");
    label765:
    AppMethodBeat.o(247816);
  }
  
  public final void a(f paramf, b paramb)
  {
    AppMethodBeat.i(247820);
    Object localObject2 = paramf.oSN;
    p.g(localObject2, "holder.userName");
    Context localContext = MMApplicationContext.getContext();
    Object localObject1 = paramb.uBm;
    if (localObject1 != null)
    {
      localObject1 = ((avn)localObject1).contact;
      if (localObject1 != null)
      {
        localObject1 = ((FinderContact)localObject1).nickname;
        localObject1 = (CharSequence)localObject1;
        TextView localTextView = paramf.oSN;
        p.g(localTextView, "holder.userName");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)localObject1, localTextView.getTextSize()));
        if (paramb.type != this.uAX) {
          break label257;
        }
        localObject1 = paramf.oSN;
        localObject2 = paramf.oSN;
        p.g(localObject2, "holder.userName");
        localObject2 = ((TextView)localObject2).getContext();
        p.g(localObject2, "holder.userName.context");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099681));
        localObject1 = paramf.uBu;
        localObject2 = paramf.uBu;
        p.g(localObject2, "holder.wecoinHot");
        localObject2 = ((TextView)localObject2).getContext();
        p.g(localObject2, "holder.wecoinHot.context");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099681));
        label209:
        paramf = paramf.uBt;
        p.g(paramf, "holder.banComment");
        paramb = paramb.uBm;
        if ((paramb == null) || (paramb.hFI != 0)) {
          break label362;
        }
      }
    }
    label257:
    label362:
    for (int i = 0;; i = 8)
    {
      paramf.setVisibility(i);
      AppMethodBeat.o(247820);
      return;
      localObject1 = null;
      break;
      localObject1 = paramf.oSN;
      localObject2 = paramf.oSN;
      p.g(localObject2, "holder.userName");
      localObject2 = ((TextView)localObject2).getContext();
      p.g(localObject2, "holder.userName.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099676));
      localObject1 = paramf.uBu;
      localObject2 = paramf.uBu;
      p.g(localObject2, "holder.wecoinHot");
      localObject2 = ((TextView)localObject2).getContext();
      p.g(localObject2, "holder.wecoinHot.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099676));
      break label209;
    }
  }
  
  public final void b(f paramf, int paramInt, avn paramavn)
  {
    AppMethodBeat.i(247819);
    int i;
    if (paramavn != null)
    {
      localObject = paramavn.contact;
      if (localObject != null)
      {
        localObject = ((FinderContact)localObject).username;
        y localy = y.vXH;
        if (!y.awn((String)localObject))
        {
          localy = y.vXH;
          if (!y.In((String)localObject)) {
            break label245;
          }
        }
        i = 1;
        label57:
        if (paramavn == null) {
          break label251;
        }
      }
    }
    label245:
    label251:
    for (int j = paramavn.LGi;; j = 0)
    {
      paramavn = y.vXH;
      paramavn = y.LT(j);
      if (i == 0) {
        break label320;
      }
      localObject = paramf.uBu;
      p.g(localObject, "holder.wecoinHot");
      ((TextView)localObject).setVisibility(8);
      localObject = paramf.uBv;
      p.g(localObject, "holder.selfWidget");
      ((LinearLayout)localObject).setVisibility(0);
      localObject = paramf.uBw;
      p.g(localObject, "holder.contributeValue");
      ((TextView)localObject).setText((CharSequence)paramavn);
      paramavn = paramf.uBx;
      p.g(paramavn, "holder.contributeWay");
      paramavn = paramavn.getLayoutParams();
      if ((paramInt != this.uAW) || (j <= 0)) {
        break label257;
      }
      paramavn.width = diF();
      paramavn.height = diF();
      paramf.uBx.setImageResource(2131690564);
      paramf = paramf.uBx;
      paramavn = MMApplicationContext.getContext();
      p.g(paramavn, "MMApplicationContext.getContext()");
      paramf.setIconColor(paramavn.getResources().getColor(2131099844));
      AppMethodBeat.o(247819);
      return;
      localObject = null;
      break;
      i = 0;
      break label57;
    }
    label257:
    paramavn.width = diL();
    paramavn.height = diL();
    paramf.uBx.setImageResource(2131690928);
    paramf = paramf.uBx;
    paramavn = MMApplicationContext.getContext();
    p.g(paramavn, "MMApplicationContext.getContext()");
    paramf.setIconColor(paramavn.getResources().getColor(2131099844));
    AppMethodBeat.o(247819);
    return;
    label320:
    Object localObject = paramf.uBu;
    p.g(localObject, "holder.wecoinHot");
    ((TextView)localObject).setVisibility(0);
    localObject = paramf.uBu;
    p.g(localObject, "holder.wecoinHot");
    ((TextView)localObject).setText((CharSequence)paramavn);
    paramf = paramf.uBv;
    p.g(paramf, "holder.selfWidget");
    paramf.setVisibility(8);
    AppMethodBeat.o(247819);
  }
  
  public final void diK()
  {
    AppMethodBeat.i(247811);
    View localView = this.usm;
    if (localView != null) {
      localView.setVisibility(4);
    }
    this.uBh.setTag(Boolean.FALSE);
    AppMethodBeat.o(247811);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247813);
    int i = this.kgc.size();
    AppMethodBeat.o(247813);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(247814);
    paramInt = ((b)this.kgc.get(paramInt)).type;
    AppMethodBeat.o(247814);
    return paramInt;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "plugin-finder_release"})
  public class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(247797);
      AppMethodBeat.o(247797);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "type", "", "onlineCnt", "offlineCnt", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;III)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getOfflineCnt", "()I", "getOnlineCnt", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final int type;
    public final avn uBm;
    final int uBn;
    final int uBo;
    
    public b(avn paramavn, int paramInt1, int paramInt2)
    {
      this.uBm = paramavn;
      this.type = paramInt1;
      this.uBn = paramInt2;
      this.uBo = 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(247800);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.uBm, paramObject.uBm)) || (this.type != paramObject.type) || (this.uBn != paramObject.uBn) || (this.uBo != paramObject.uBo)) {}
        }
      }
      else
      {
        AppMethodBeat.o(247800);
        return true;
      }
      AppMethodBeat.o(247800);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(247799);
      avn localavn = this.uBm;
      if (localavn != null) {}
      for (int i = localavn.hashCode();; i = 0)
      {
        int j = this.type;
        int k = this.uBn;
        int m = this.uBo;
        AppMethodBeat.o(247799);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(247798);
      String str = "FinderLiveContactInfo(contact=" + this.uBm + ", type=" + this.type + ", onlineCnt=" + this.uBn + ", offlineCnt=" + this.uBo + ")";
      AppMethodBeat.o(247798);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final c uBp;
    
    static
    {
      AppMethodBeat.i(247802);
      uBp = new c();
      AppMethodBeat.o(247802);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberBottomViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "tip", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/widget/TextView;", "setTip", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class d
    extends g.a
  {
    TextView uBq;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(247803);
      this.uBq = ((TextView)localObject.findViewById(2131301067));
      AppMethodBeat.o(247803);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberCategoryViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "wecoinHotTitle", "getWecoinHotTitle", "setWecoinHotTitle", "plugin-finder_release"})
  public final class e
    extends g.a
  {
    TextView hbb;
    TextView uBr;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(247804);
      this.hbb = ((TextView)localObject.findViewById(2131300612));
      this.uBr = ((TextView)localObject.findViewById(2131300613));
      AppMethodBeat.o(247804);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "badgeRank", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getBadgeRank", "()Landroid/widget/TextView;", "setBadgeRank", "(Landroid/widget/TextView;)V", "banComment", "getBanComment", "()Landroid/view/View;", "setBanComment", "(Landroid/view/View;)V", "contributeValue", "getContributeValue", "setContributeValue", "contributeWay", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getContributeWay", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setContributeWay", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "selfWidget", "Landroid/widget/LinearLayout;", "getSelfWidget", "()Landroid/widget/LinearLayout;", "setSelfWidget", "(Landroid/widget/LinearLayout;)V", "userName", "getUserName", "setUserName", "wecoinHot", "getWecoinHot", "setWecoinHot", "plugin-finder_release"})
  public final class f
    extends g.a
  {
    TextView oSN;
    TextView uBs;
    View uBt;
    TextView uBu;
    LinearLayout uBv;
    TextView uBw;
    WeImageView uBx;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(247806);
      this.uBs = ((TextView)localObject.findViewById(2131303438));
      this.oSN = ((TextView)localObject.findViewById(2131303443));
      this.uBt = localObject.findViewById(2131300911);
      this.uBu = ((TextView)localObject.findViewById(2131303444));
      this.uBv = ((LinearLayout)localObject.findViewById(2131303442));
      this.uBw = ((TextView)this.uBv.findViewById(2131299232));
      this.uBx = ((WeImageView)this.uBv.findViewById(2131299231));
      this.uBv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(247805);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = this.uBy.uBl.uBe;
          if (paramAnonymousView != null) {
            paramAnonymousView.invoke();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247805);
        }
      });
      AppMethodBeat.o(247806);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final g uBz;
    
    static
    {
      AppMethodBeat.i(247808);
      uBz = new g();
      AppMethodBeat.o(247808);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(g paramg, g.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247809);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$bindMember$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uBl.hXE;
      if (paramView != null) {
        paramView.invoke(this.uBA.uBm);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$bindMember$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247809);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class i
    implements View.OnClickListener
  {
    public i(g paramg, g.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247810);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$fillStickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uBl.hXE;
      if (paramView != null) {
        paramView.invoke(this.uBA.uBm);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$fillStickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.g
 * JD-Core Version:    0.7.0.1
 */