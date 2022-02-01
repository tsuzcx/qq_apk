package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.bm;
import com.tencent.mm.plugin.finder.live.view.span.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.b;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.cxk;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.k.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "stickViewContainer", "Landroid/view/View;", "liveCommonSlice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;)V", "DEFAULT_MEMBER_NICKNAME_MAX_WIDTH", "", "getDEFAULT_MEMBER_NICKNAME_MAX_WIDTH", "()I", "setDEFAULT_MEMBER_NICKNAME_MAX_WIDTH", "(I)V", "DEFAULT_REWARD_MEMBER_NICKNAME_MAX_WIDTH", "getDEFAULT_REWARD_MEMBER_NICKNAME_MAX_WIDTH", "ITEM_CATAGORY_COUNT", "getITEM_CATAGORY_COUNT", "setITEM_CATAGORY_COUNT", "RV_ITEM_START_OFFSET", "SCREEN_WIDTH", "TAG", "", "getTAG", "()Ljava/lang/String;", "TYPE_BOTTOM", "TYPE_MEMBER_OFFLINE", "TYPE_MEMBER_ONLINE", "TYPE_REWARD_MEMBER_EXPAND", "TYPE_REWARD_MEMBER_ONLINE", "TYPE_REWARD_MEMBER_TITLE", "TYPE_REWARD_TOTAL_VALUE", "TYPE_TITLE_OFFLINE", "TYPE_TITLE_ONLINE", "allRewardMemberList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "Lkotlin/collections/ArrayList;", "getAllRewardMemberList", "()Ljava/util/ArrayList;", "setAllRewardMemberList", "(Ljava/util/ArrayList;)V", "continueFlag", "getContinueFlag", "setContinueFlag", "dataList", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;", "getDataList", "setDataList", "enableGift", "", "isBussineVistor", "()Z", "setBussineVistor", "(Z)V", "itemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/ParameterName;", "name", "contact", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "lastRewardOnlineList", "getLastRewardOnlineList", "lastVisibleViewPos", "", "getLastVisibleViewPos", "()[I", "setLastVisibleViewPos", "([I)V", "getLiveCommonSlice", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "maxMemberCount", "getMaxMemberCount", "setMaxMemberCount", "onlineMembersCount", "onlineMembersSize", "orinNickNameMaxWidth", "getOrinNickNameMaxWidth", "setOrinNickNameMaxWidth", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "selfItemPosition", "getSelfItemPosition", "setSelfItemPosition", "stickView", "getStickView", "()Landroid/view/View;", "setStickView", "(Landroid/view/View;)V", "getStickViewContainer", "stickViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "getStickViewHolder", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "setStickViewHolder", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;)V", "stickViewY", "getStickViewY", "setStickViewY", "tempNickNameMaxWidth", "getTempNickNameMaxWidth", "setTempNickNameMaxWidth", "totalGiftValue", "", "getTotalGiftValue", "()J", "setTotalGiftValue", "(J)V", "bindBottom", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberBottomViewHolder;", "position", "bindMember", "bindTitle", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberCategoryViewHolder;", "bindTotalRewardTitle", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberTitleTotalRewardViewHolder;", "fillStickView", "selfPosition", "data", "getItemCount", "getItemViewType", "getNickNameTvWidth", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberViewHolder;", "globalSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpan;", "haveAttachStickView", "hideStickContainer", "isAnchorOrAssistant", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "onRecyclerViewScrollLogic", "setRankTv", "isSelf", "setRewardAmount", "setRewardMember", "setRewardMemberExpand", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberExpandViewHolder;", "setUserItem", "isBindMember", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;ILcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;Ljava/lang/Boolean;)V", "setUserSex", "updateMemberList", "rewardOnlineMember", "onlineMembers", "", "selfContact", "offlineMembers", "onlineMemberCnt", "offlineMemberCnt", "AbsMemberViewHolder", "FinderLiveContactInfo", "MemberBottomViewHolder", "MemberCategoryViewHolder", "MemberTitleTotalRewardViewHolder", "MemberViewHolder", "RewardMemberExpandViewHolder", "RewardMemberTitleViewHolder", "RewardMemberViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends RecyclerView.a<a>
{
  private int CNV;
  private int CNW;
  private int[] CNX;
  private int DQG;
  private final e DRD;
  private final int DRE;
  private final int DRF;
  private final int DRG;
  private final int DRH;
  private final int DRI;
  private final int DRJ;
  private final int DRK;
  private final int DRL;
  private final int DRM;
  private final int DRN;
  private final int DRO;
  private boolean DRP;
  private int DRQ;
  private int DRR;
  private f DRS;
  private View DRT;
  public long DRU;
  public int DRV;
  public boolean DRW;
  final ArrayList<w.b> DRX;
  ArrayList<blq> DRY;
  private int DRZ;
  private final int DSa;
  private int DSb;
  private int DSc;
  private final View Dfb;
  private final String TAG;
  public int continueFlag;
  private final RecyclerView mkw;
  public kotlin.g.a.b<? super bgh, ah> nod;
  ArrayList<w.b> pUj;
  
  public w(RecyclerView paramRecyclerView, View paramView, e parame)
  {
    AppMethodBeat.i(358767);
    this.mkw = paramRecyclerView;
    this.Dfb = paramView;
    this.DRD = parame;
    this.TAG = "FinderLiveMemberLinearAdapter";
    this.DRE = bf.bf(MMApplicationContext.getContext()).x;
    this.DRF = 1;
    this.DRH = 1;
    this.DRI = 2;
    this.DRJ = 3;
    this.DRK = 4;
    this.DRL = 5;
    this.DRM = 6;
    this.DRN = 7;
    this.DRO = 8;
    this.DRP = true;
    this.pUj = new ArrayList();
    this.CNV = 2147483647;
    paramRecyclerView = this.Dfb.findViewById(p.e.BNH);
    kotlin.g.b.s.s(paramRecyclerView, "stickViewContainer.findV…r_live_member_stick_view)");
    this.DRT = paramRecyclerView;
    this.CNX = new int[2];
    this.DRX = new ArrayList();
    int j;
    int k;
    if (!eqc())
    {
      j = bf.bf(this.mkw.getContext()).y;
      k = bf.bk(this.mkw.getContext());
      paramRecyclerView = this.DRT.getLayoutParams();
      if (paramRecyclerView != null) {
        break label326;
      }
    }
    label326:
    for (int i = 0;; i = paramRecyclerView.height)
    {
      this.CNW = (j - k - i);
      this.DRT.setBackgroundColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_BG_20));
      this.mkw.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(359089);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(359089);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(359082);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          kotlin.g.b.s.u(paramAnonymousRecyclerView, "recyclerView");
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          w.a(this.DSd, paramAnonymousRecyclerView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(359082);
        }
      });
      this.DSa = ((int)(this.DRE * 0.4F));
      this.DQG = MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_24A);
      this.DSb = this.DQG;
      this.DSc = this.DQG;
      AppMethodBeat.o(358767);
      return;
    }
  }
  
  private final void a(f paramf, int paramInt, w.b paramb, Boolean paramBoolean)
  {
    List localList = null;
    FinderContact localFinderContact = null;
    AppMethodBeat.i(358827);
    Object localObject1;
    int i;
    Object localObject2;
    if (this.DRD.Ecv)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      if (!com.tencent.mm.plugin.finder.live.util.u.bUx())
      {
        i = 1;
        if (paramf.caK.getMeasuredWidth() == 0) {
          paramf.caK.measure(View.MeasureSpec.makeMeasureSpec(bf.bf(MMApplicationContext.getContext()).x, -2147483648), 0);
        }
        int j = paramf.caK.getMeasuredWidth();
        int k = paramf.DSl.getMeasuredWidth();
        int m = MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_5A);
        localObject2 = paramf.vgb;
        Context localContext = MMApplicationContext.getContext();
        localObject1 = paramb.Ddj;
        if (localObject1 != null) {
          break label811;
        }
        localObject1 = null;
        label123:
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject1, paramf.vgb.getTextSize()));
        if (paramb.type != this.DRG) {
          break label865;
        }
        if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE))
        {
          if (paramInt > 3) {
            break label839;
          }
          paramf.vgb.setTextColor(paramf.vgb.getContext().getResources().getColor(p.b.BW_100_Alpha_0_9));
        }
        label198:
        paramf.DSq.setTextColor(paramf.DSq.getContext().getResources().getColor(p.b.BW_100_Alpha_0_9));
        label221:
        localObject1 = paramf.caK;
        paramInt = p.e.BEA;
        paramBoolean = paramb.Ddj;
        if (paramBoolean != null) {
          break label914;
        }
        paramBoolean = null;
        label245:
        ((View)localObject1).setTag(paramInt, paramBoolean);
        paramBoolean = paramf.DSm;
        localObject1 = paramb.Ddj;
        if ((localObject1 == null) || (((bgh)localObject1).mXJ != 0)) {
          break label942;
        }
        paramInt = 1;
        label280:
        if (paramInt == 0) {
          break label947;
        }
        paramInt = 0;
        label286:
        paramBoolean.setVisibility(paramInt);
        paramBoolean = paramf.DSn;
        if (i != 0) {
          break label958;
        }
        localObject1 = paramb.Ddj;
        if ((localObject1 == null) || (((bgh)localObject1).ZEt != 3)) {
          break label953;
        }
        paramInt = 1;
        label325:
        if (paramInt == 0) {
          break label958;
        }
        paramInt = 0;
        label331:
        paramBoolean.setVisibility(paramInt);
        paramBoolean = paramb.Ddj;
        if (paramBoolean == null) {
          break label969;
        }
        paramBoolean = paramBoolean.ZKa;
        if (paramBoolean == null) {
          break label969;
        }
        if (!((Collection)paramBoolean).isEmpty()) {
          break label964;
        }
        paramInt = 1;
        label375:
        if (paramInt != 0) {
          break label969;
        }
        paramInt = 1;
        label381:
        if (paramInt == 0) {
          break label1000;
        }
        paramBoolean = h.DWP;
        localObject1 = paramf.caK.getContext();
        kotlin.g.b.s.s(localObject1, "holder.itemView.context");
        localObject1 = h.a(paramBoolean, (Context)localObject1, " ", paramb.Ddj.ZKa, new int[] { 2, 4 }, 0, 48);
        paramf.DSp.setText((CharSequence)((r)localObject1).bsC);
        paramf.DSp.setVisibility(0);
        if (((List)((r)localObject1).bsD).isEmpty())
        {
          paramBoolean = e.Eck;
          localList = (List)paramb.Ddj.ZKa;
          paramBoolean = paramb.Ddj;
          if (paramBoolean != null) {
            break label974;
          }
          paramBoolean = localFinderContact;
          label511:
          e.b.n(localList, kotlin.g.b.s.X(paramBoolean, ",setUserItem"));
        }
        paramf.caK.setTag(p.e.BEz, ((r)localObject1).bsC);
        if (paramf.DSp.getMeasuredWidth() == 0) {
          paramf.DSp.measure(View.MeasureSpec.makeMeasureSpec(bf.bf(MMApplicationContext.getContext()).x, -2147483648), 0);
        }
        i = j - k - m - paramf.DSp.getMeasuredWidth();
        a(paramf, paramb);
        paramInt = i;
        if (paramf.DSo.getVisibility() == 0) {
          paramInt = i - MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_3A);
        }
        i = paramInt;
        if (paramf.DSn.getVisibility() == 0) {
          i = paramInt - MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_2_5_A);
        }
        paramInt = i;
        if (paramf.DSm.getVisibility() == 0) {
          paramInt = i - MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_2_5_A);
        }
        if (paramf.DSq.getVisibility() != 0) {
          break label1107;
        }
        paramInt -= paramf.DSq.getMeasuredWidth() + MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_2A);
      }
    }
    label811:
    label839:
    label969:
    label974:
    label1107:
    for (;;)
    {
      if (paramInt > 0) {}
      for (i = paramInt;; i = this.DQG)
      {
        this.DSb = i;
        this.DSc = paramf.vgb.getMaxWidth();
        paramf.vgb.setMaxWidth(this.DSb);
        if (this.DSb < this.DSc) {
          paramf.vgb.requestLayout();
        }
        paramf = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, "setUserItem usernameMaxWidth:" + paramInt + ",DEFAULT_NICKNAME_MAX_WIDTH:" + this.DQG);
        AppMethodBeat.o(358827);
        return;
        i = 0;
        break;
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label123;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        break label123;
        paramf.vgb.setTextColor(paramf.vgb.getContext().getResources().getColor(p.b.BW_100_Alpha_0_6));
        break label198;
        label865:
        paramf.vgb.setTextColor(paramf.vgb.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
        paramf.DSq.setTextColor(paramf.DSq.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
        break label221;
        paramBoolean = paramBoolean.contact;
        if (paramBoolean == null)
        {
          paramBoolean = null;
          break label245;
        }
        paramBoolean = paramBoolean.nickname;
        break label245;
        paramInt = 0;
        break label280;
        paramInt = 8;
        break label286;
        paramInt = 0;
        break label325;
        paramInt = 8;
        break label331;
        paramInt = 0;
        break label375;
        paramInt = 0;
        break label381;
        localObject2 = paramBoolean.contact;
        paramBoolean = localFinderContact;
        if (localObject2 == null) {
          break label511;
        }
        paramBoolean = ((FinderContact)localObject2).nickname;
        break label511;
        label1000:
        paramf.DSp.setText((CharSequence)"");
        paramf.DSp.setVisibility(8);
        localObject1 = this.TAG;
        paramBoolean = paramb.Ddj;
        if (paramBoolean == null) {
          paramBoolean = localList;
        }
        for (;;)
        {
          Log.i((String)localObject1, kotlin.g.b.s.X(paramBoolean, " badge_infos is empty!"));
          paramf.caK.setTag(p.e.BEz, "");
          break;
          localFinderContact = paramBoolean.contact;
          paramBoolean = localList;
          if (localFinderContact != null) {
            paramBoolean = localFinderContact.nickname;
          }
        }
      }
    }
  }
  
  private final void a(f paramf, int paramInt, bgh parambgh, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358786);
    int i;
    int j;
    int k;
    Object localObject3;
    StringBuilder localStringBuilder;
    Object localObject1;
    if (parambgh == null)
    {
      i = 0;
      j = this.DRQ;
      k = this.DRF;
      int m = this.DRX.size();
      j = this.DRZ + (j + k + m);
      if (!paramBoolean) {
        break label350;
      }
      localObject3 = this.TAG;
      localStringBuilder = new StringBuilder("myself position:").append(paramInt).append('(').append(j).append("),rewardAmount:").append(i).append(",badgeInfo:");
      localObject1 = e.Eck;
      if (parambgh != null) {
        break label341;
      }
      localObject1 = null;
      label118:
      Log.i((String)localObject3, e.b.gW((List)localObject1));
      paramf.caK.setTag(p.e.BEC, Integer.valueOf(i));
      if ((i <= 0) || (paramInt >= j)) {
        break label639;
      }
      k = paramInt - this.DRX.size() - this.DRZ;
      paramf.DSl.setText((CharSequence)String.valueOf(k));
      paramf.caK.setTag(p.e.BEB, String.valueOf(k));
      if (k != this.DRF) {
        break label498;
      }
      paramf.DSl.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.ByP));
      paramf.DSl.setTextSize(1, 22.0F);
      label250:
      if (paramBoolean) {
        break label684;
      }
      localObject1 = this.TAG;
      localObject3 = new StringBuilder("setRankTv ");
      if (parambgh != null) {
        break label619;
      }
      paramf = localObject2;
    }
    for (;;)
    {
      Log.i((String)localObject1, paramf + ",position:" + paramInt + '(' + j + "),rewardAmount:" + i);
      AppMethodBeat.o(358786);
      return;
      i = parambgh.ZPR;
      break;
      label341:
      localObject1 = parambgh.ZKa;
      break label118;
      label350:
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject3 = this.TAG;
      localStringBuilder = new StringBuilder("setRankTv ");
      if (parambgh == null)
      {
        localObject1 = null;
        label380:
        localStringBuilder = localStringBuilder.append(localObject1).append(",position:").append(paramInt).append('(').append(j).append("),rewardAmount:").append(i).append(",badgeInfo:");
        localObject1 = e.Eck;
        if (parambgh != null) {
          break label489;
        }
      }
      label489:
      for (localObject1 = null;; localObject1 = parambgh.ZKa)
      {
        com.tencent.mm.plugin.finder.live.utils.a.hQ((String)localObject3, e.b.gW((List)localObject1));
        break;
        localObject1 = parambgh.contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label380;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        break label380;
      }
      label498:
      if (k == this.DRF + 1)
      {
        paramf.DSl.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.ByR));
        paramf.DSl.setTextSize(1, 22.0F);
        break label250;
      }
      if (k == this.DRF + 2)
      {
        paramf.DSl.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.ByQ));
        paramf.DSl.setTextSize(1, 22.0F);
        break label250;
      }
      paramf.DSl.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_6));
      paramf.DSl.setTextSize(1, 15.0F);
      break label250;
      label619:
      parambgh = parambgh.contact;
      paramf = localObject2;
      if (parambgh != null) {
        paramf = parambgh.nickname;
      }
    }
    label639:
    paramf.caK.setTag(p.e.BEB, "");
    paramf.DSl.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_6));
    paramf.DSl.setText((CharSequence)"-");
    label684:
    AppMethodBeat.o(358786);
  }
  
  private final void a(f paramf, w.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358807);
    if (eqc())
    {
      Object localObject1 = paramb.Ddj;
      label31:
      label35:
      label48:
      String str;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label179;
        }
        if (localObject1 != null) {
          break label212;
        }
        paramf.DSo.setVisibility(8);
        paramf = "unknow";
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("setUserSex:");
        localObject1 = paramb.Ddj;
        if (localObject1 != null) {
          break label245;
        }
        localObject1 = null;
        label81:
        localObject1 = localStringBuilder.append(localObject1).append(" sex is ").append(paramf).append('(');
        paramf = paramb.Ddj;
        if (paramf != null) {
          break label267;
        }
        paramf = localObject2;
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.utils.a.hQ(str, paramf + ')');
        AppMethodBeat.o(358807);
        return;
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderContact)localObject1).extInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((avl)localObject1).sex);
        break;
        label179:
        if (((Integer)localObject1).intValue() != 1) {
          break label31;
        }
        paramf.DSo.setVisibility(0);
        paramf.DSo.setImageResource(p.g.ic_sex_male);
        paramf = "male";
        break label48;
        label212:
        if (((Integer)localObject1).intValue() != 2) {
          break label35;
        }
        paramf.DSo.setVisibility(0);
        paramf.DSo.setImageResource(p.g.ic_sex_female);
        paramf = "female";
        break label48;
        label245:
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label81;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        break label81;
        label267:
        paramb = paramf.contact;
        paramf = localObject2;
        if (paramb != null)
        {
          paramb = paramb.extInfo;
          paramf = localObject2;
          if (paramb != null) {
            paramf = Integer.valueOf(paramb.sex);
          }
        }
      }
    }
    paramf.DSo.setVisibility(8);
    AppMethodBeat.o(358807);
  }
  
  private static void a(f paramf, bgh parambgh)
  {
    AppMethodBeat.i(358794);
    if (parambgh == null) {}
    for (int i = 0;; i = parambgh.ZPR)
    {
      parambgh = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      parambgh = com.tencent.mm.plugin.finder.live.utils.a.jp(i);
      paramf.DSq.setVisibility(0);
      paramf.DSq.setText((CharSequence)parambgh);
      AppMethodBeat.o(358794);
      return;
    }
  }
  
  private static final void a(w paramw, w.b paramb, View paramView)
  {
    AppMethodBeat.i(358847);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramw);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramw, "this$0");
    kotlin.g.b.s.u(paramb, "$data");
    paramw = paramw.nod;
    if (paramw != null) {
      paramw.invoke(paramb.Ddj);
    }
    j.Dob.a(q.bm.DBy);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358847);
  }
  
  private static final void b(w paramw, w.b paramb, View paramView)
  {
    AppMethodBeat.i(358854);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramw);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramw, "this$0");
    kotlin.g.b.s.u(paramb, "$data");
    paramw = paramw.nod;
    if (paramw != null) {
      paramw.invoke(paramb.Ddj);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358854);
  }
  
  private final boolean eqc()
  {
    AppMethodBeat.i(358837);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (this.DRD.DUe))
    {
      AppMethodBeat.o(358837);
      return true;
    }
    AppMethodBeat.o(358837);
    return false;
  }
  
  public final void a(ArrayList<blq> paramArrayList, List<? extends bgh> paramList1, bgh parambgh, List<? extends bgh> paramList2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(358913);
    kotlin.g.b.s.u(paramArrayList, "rewardOnlineMember");
    kotlin.g.b.s.u(paramList1, "onlineMembers");
    kotlin.g.b.s.u(paramList2, "offlineMembers");
    this.DRQ = paramList1.size();
    this.DRR = paramInt;
    this.DRP = paramBoolean;
    this.pUj.clear();
    this.CNV = 2147483647;
    evP();
    boolean bool2 = false;
    boolean bool1 = false;
    this.DRY = paramArrayList;
    this.pUj.removeAll((Collection)this.DRX);
    this.DRX.clear();
    this.DRZ = 0;
    if ((this.DRU > 0L) && (eqc()))
    {
      this.pUj.add(new w.b(null, this.DRO, this.DRQ, null, 48));
      this.DRZ += 1;
    }
    int i;
    int k;
    if (!((Collection)paramArrayList).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        this.DRX.add(new w.b(null, this.DRM, 0, null, 48));
        k = k.qv(paramArrayList.size(), 3);
        i = 0;
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      paramList2 = paramArrayList.get(i);
      kotlin.g.b.s.s(paramList2, "rewardOnlineMember[i]");
      paramList2 = (blq)paramList2;
      this.DRX.add(new w.b(paramList2.Ddj, this.DRL, 0, paramList2.nUC, 16));
      label1156:
      if (j >= k)
      {
        if (paramArrayList.size() > 3) {
          this.DRX.add(new w.b(null, this.DRN, 0, null, 48));
        }
        this.pUj.addAll((Collection)this.DRX);
        label351:
        w.b localb;
        if (!((Collection)paramList1).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label837;
          }
          this.pUj.add(new w.b(null, this.DRI, this.DRQ, null, 48));
          paramList2 = new ArrayList();
          Iterator localIterator = ((Iterable)paramList1).iterator();
          i = 0;
          label406:
          if (!localIterator.hasNext()) {
            break label656;
          }
          paramArrayList = localIterator.next();
          j = i + 1;
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          bgh localbgh = (bgh)paramArrayList;
          localb = new w.b(localbgh, this.DRG, 0, null, 48);
          paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          paramArrayList = localbgh.contact;
          if (paramArrayList != null) {
            break label609;
          }
          paramList1 = null;
          label479:
          if (parambgh != null) {
            break label617;
          }
          paramArrayList = null;
          label485:
          if (!com.tencent.mm.plugin.finder.live.utils.a.hS(paramList1, paramArrayList))
          {
            paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            paramArrayList = localbgh.contact;
            if (paramArrayList != null) {
              break label639;
            }
            paramArrayList = null;
            label509:
            if (!com.tencent.mm.plugin.finder.live.utils.a.axR(paramArrayList)) {
              break label1174;
            }
          }
          this.CNV = (this.DRF + i);
          bool1 = true;
          localb.yAN = true;
        }
        label647:
        label656:
        label1174:
        for (;;)
        {
          paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if ((com.tencent.mm.plugin.finder.live.utils.a.a(this.DRD)) && (!eqc()) && (!this.DRW))
          {
            paramArrayList = localb.Ddj;
            if (paramArrayList != null) {
              break label647;
            }
            i = 0;
          }
          for (;;)
          {
            if (i > 0)
            {
              paramList2.add(localb);
              i = j;
              break label406;
              i = 0;
              break;
              i = 0;
              break label351;
              label609:
              paramList1 = paramArrayList.username;
              break label479;
              label617:
              paramArrayList = parambgh.contact;
              if (paramArrayList == null)
              {
                paramArrayList = null;
                break label485;
              }
              paramArrayList = paramArrayList.username;
              break label485;
              label639:
              paramArrayList = paramArrayList.username;
              break label509;
              i = paramArrayList.ZPR;
              continue;
              this.pUj.addAll((Collection)paramList2);
              bool2 = bool1;
              if (paramBoolean)
              {
                bool2 = bool1;
                if (!eqc())
                {
                  bool2 = bool1;
                  if (this.CNV >= 0)
                  {
                    bool2 = bool1;
                    if (this.CNV < this.pUj.size())
                    {
                      i = this.CNV;
                      paramArrayList = this.pUj.get(this.CNV);
                      kotlin.g.b.s.s(paramArrayList, "dataList[selfItemPosition]");
                      paramArrayList = (w.b)paramArrayList;
                      this.DRS = new f(this.DRT);
                      this.DRT.setTag(Boolean.TRUE);
                      paramList1 = this.DRS;
                      if (paramList1 != null)
                      {
                        a(paramList1, i, paramArrayList.Ddj, paramArrayList.yAN);
                        a(paramList1, paramArrayList.Ddj);
                        a(paramList1, i, paramArrayList, Boolean.FALSE);
                      }
                      this.DRT.setOnClickListener(new w..ExternalSyntheticLambda0(this, paramArrayList));
                      bool2 = bool1;
                    }
                  }
                }
              }
              label837:
              paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              if ((com.tencent.mm.plugin.finder.live.utils.a.a(this.DRD)) && (!this.DRW))
              {
                if ((this.continueFlag == 0) && (this.DRV > 0) && (this.pUj.size() > this.DRV)) {
                  this.pUj.add(new w.b(null, this.DRK, this.pUj.size(), null, 48));
                }
                paramList1 = this.TAG;
                paramArrayList = new StringBuilder("updateMemberList enableGift:").append(paramBoolean).append(",onlineList size:").append(this.DRQ).append(",continueFlag：").append(this.continueFlag).append(",maxMemberCount:").append(this.DRV).append(",selfContact is empty:");
                if (parambgh != null) {
                  break label1150;
                }
                paramBoolean = true;
                label989:
                paramList2 = paramArrayList.append(paramBoolean).append(",self amount heat:");
                if (parambgh != null) {
                  break label1156;
                }
              }
              for (paramArrayList = null;; paramArrayList = Integer.valueOf(parambgh.ZPR))
              {
                Log.i(paramList1, paramArrayList + ",haveSelfItem:" + bool2 + ",selfItemPosition:" + this.CNV);
                AppMethodBeat.o(358913);
                return;
                if (eqc())
                {
                  if (paramInt <= this.DRQ) {
                    break;
                  }
                  this.pUj.add(new w.b(null, this.DRK, this.DRQ, null, 48));
                  break;
                }
                if ((this.continueFlag != 0) || (this.pUj.size() < this.DRV)) {
                  break;
                }
                this.pUj.add(new w.b(null, this.DRK, this.DRV, null, 48));
                break;
                label1150:
                paramBoolean = false;
                break label989;
              }
            }
          }
          i = j;
          break label406;
        }
      }
      i = j;
    }
  }
  
  public final void evP()
  {
    AppMethodBeat.i(358893);
    this.Dfb.setVisibility(4);
    this.DRT.setTag(Boolean.FALSE);
    AppMethodBeat.o(358893);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358916);
    int i = this.pUj.size();
    AppMethodBeat.o(358916);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(358925);
    paramInt = ((w.b)this.pUj.get(paramInt)).type;
    AppMethodBeat.o(358925);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(358983);
      AppMethodBeat.o(358983);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberBottomViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "tip", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/widget/TextView;", "setTip", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends w.a
  {
    TextView DSh;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(358990);
      this.DSh = ((TextView)localObject.findViewById(p.e.BMF));
      AppMethodBeat.o(358990);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberCategoryViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "wecoinHotTitle", "getWecoinHotTitle", "setWecoinHotTitle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends w.a
  {
    TextView DSi;
    TextView mll;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(358993);
      this.mll = ((TextView)localObject.findViewById(p.e.BEe));
      this.DSi = ((TextView)localObject.findViewById(p.e.BEf));
      AppMethodBeat.o(358993);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberTitleTotalRewardViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "totalGiftValueLayout", "kotlin.jvm.PlatformType", "getTotalGiftValueLayout", "()Landroid/view/View;", "setTotalGiftValueLayout", "(Landroid/view/View;)V", "totalGiftValueTxtView", "Landroid/widget/TextView;", "getTotalGiftValueTxtView", "()Landroid/widget/TextView;", "setTotalGiftValueTxtView", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends w.a
  {
    View DSj;
    TextView DSk;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(358991);
      this.DSj = localObject.findViewById(p.e.BEh);
      this.DSk = ((TextView)localObject.findViewById(p.e.BEg));
      AppMethodBeat.o(358991);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "badgeRank", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getBadgeRank", "()Landroid/widget/TextView;", "setBadgeRank", "(Landroid/widget/TextView;)V", "banComment", "getBanComment", "()Landroid/view/View;", "setBanComment", "(Landroid/view/View;)V", "finder", "getFinder", "setFinder", "globalLevel", "getGlobalLevel", "setGlobalLevel", "sex", "Landroid/widget/ImageView;", "getSex", "()Landroid/widget/ImageView;", "setSex", "(Landroid/widget/ImageView;)V", "userName", "getUserName", "setUserName", "wecoinHot", "getWecoinHot", "setWecoinHot", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    extends w.a
  {
    TextView DSl;
    View DSm;
    View DSn;
    ImageView DSo;
    TextView DSp;
    TextView DSq;
    TextView vgb;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(358994);
      this.DSl = ((TextView)localObject.findViewById(p.e.BWU));
      this.vgb = ((TextView)localObject.findViewById(p.e.live_member_item_username_tv));
      this.DSm = localObject.findViewById(p.e.BGP);
      this.DSn = localObject.findViewById(p.e.finder_icon);
      this.DSo = ((ImageView)localObject.findViewById(p.e.sex));
      this.DSp = ((TextView)localObject.findViewById(p.e.BVB));
      this.DSq = ((TextView)localObject.findViewById(p.e.BWV));
      AppMethodBeat.o(358994);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberExpandViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class g
    extends w.a
  {
    public g()
    {
      super(localObject);
      AppMethodBeat.i(359001);
      localObject.setOnClickListener(new w.g..ExternalSyntheticLambda0(w.this));
      AppMethodBeat.o(359001);
    }
    
    private static final void a(w paramw, View paramView)
    {
      AppMethodBeat.i(359022);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramw);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberExpandViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(paramw, "this$0");
      localObject1 = (Iterable)paramw.DRX;
      paramView = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label143:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((w.b)localObject2).type == w.a(paramw)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label143;
          }
          paramView.add(localObject2);
          break;
        }
      }
      int i = ((List)paramView).size();
      paramView = paramw.DRY;
      int j;
      int n;
      if (paramView == null)
      {
        j = 0;
        if (i >= 15) {
          break label413;
        }
        k = 0;
        if (j < 15)
        {
          com.tencent.mm.ae.d.a(paramw.DRX, (kotlin.g.a.b)new a(paramw));
          com.tencent.mm.ae.d.a(paramw.pUj, (kotlin.g.a.b)new b(paramw));
          k = 1;
          paramw.fX(paramw.DRX.size());
        }
        n = k.qv(j, 15);
        if (k == 0) {
          break label400;
        }
        j = paramw.DRX.size();
        label254:
        if (i >= n) {}
      }
      int m;
      for (int k = i;; k = m)
      {
        m = k + 1;
        paramView = paramw.DRY;
        if (paramView != null)
        {
          paramView = (blq)paramView.get(k);
          if (paramView != null)
          {
            paramw.pUj.add(j, new w.b(paramView.Ddj, w.a(paramw), 0, paramView.nUC, 16));
            paramw.DRX.add(j, new w.b(paramView.Ddj, w.a(paramw), 0, paramView.nUC, 16));
          }
        }
        if (m >= n)
        {
          paramw.bA(j, n - i);
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberExpandViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(359022);
          return;
          j = paramView.size();
          break;
          label400:
          j = paramw.DRX.size() - 1;
          break label254;
          label413:
          n = k.qv(i + 10, j);
          k = 0;
          if (n == j)
          {
            com.tencent.mm.ae.d.a(paramw.DRX, (kotlin.g.a.b)new c(paramw));
            com.tencent.mm.ae.d.a(paramw.pUj, (kotlin.g.a.b)new d(paramw));
            k = 1;
            paramw.fX(paramw.DRX.size());
          }
          if (k != 0)
          {
            j = paramw.DRX.size();
            label497:
            if (i >= n) {}
          }
          for (k = i;; k = m)
          {
            m = k + 1;
            paramView = paramw.DRY;
            if (paramView != null)
            {
              paramView = (blq)paramView.get(k);
              if (paramView != null)
              {
                paramw.pUj.add(j, new w.b(paramView.Ddj, w.a(paramw), 0, paramView.nUC, 16));
                paramw.DRX.add(j, new w.b(paramView.Ddj, w.a(paramw), 0, paramView.nUC, 16));
              }
            }
            if (m >= n)
            {
              paramw.bA(j, n - i);
              break;
              j = paramw.DRX.size() - 1;
              break label497;
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<w.b, Boolean>
    {
      a(w paramw)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.b<w.b, Boolean>
    {
      b(w paramw)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.b<w.b, Boolean>
    {
      c(w paramw)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.b<w.b, Boolean>
    {
      d(w paramw)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberTitleViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class h
    extends w.a
  {
    public h()
    {
      super(localObject);
      AppMethodBeat.i(359002);
      AppMethodBeat.o(359002);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$RewardMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "giftLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "kotlin.jvm.PlatformType", "getGiftLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setGiftLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "giftLayoutContainer", "Landroid/widget/RelativeLayout;", "getGiftLayoutContainer", "()Landroid/widget/RelativeLayout;", "setGiftLayoutContainer", "(Landroid/widget/RelativeLayout;)V", "globalLevel", "Landroid/widget/TextView;", "getGlobalLevel", "()Landroid/widget/TextView;", "setGlobalLevel", "(Landroid/widget/TextView;)V", "nicknameTxt", "getNicknameTxt", "setNicknameTxt", "sex", "Landroid/widget/ImageView;", "getSex", "()Landroid/widget/ImageView;", "setSex", "(Landroid/widget/ImageView;)V", "userInfoContainer", "getUserInfoContainer", "()Landroid/view/View;", "setUserInfoContainer", "(Landroid/view/View;)V", "addGiftItem", "", "giftItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/GiftItem;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class i
    extends w.a
  {
    ImageView DSo;
    TextView DSp;
    View DSr;
    TextView DSs;
    RelativeLayout DSt;
    private FinderTagFlowLayout DSu;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(359014);
      this.DSr = localObject.findViewById(p.e.CbL);
      this.DSs = ((TextView)localObject.findViewById(p.e.BWZ));
      this.DSo = ((ImageView)localObject.findViewById(p.e.sex));
      this.DSp = ((TextView)localObject.findViewById(p.e.BVB));
      this.DSt = ((RelativeLayout)localObject.findViewById(p.e.BWY));
      this.DSu = ((FinderTagFlowLayout)localObject.findViewById(p.e.BWX));
      AppMethodBeat.o(359014);
    }
    
    private static final void a(i parami, LinkedList paramLinkedList)
    {
      int i = 1;
      AppMethodBeat.i(359039);
      kotlin.g.b.s.u(parami, "this$0");
      int k = parami.DSu.GCA.size();
      LinkedList localLinkedList;
      if (k > 1)
      {
        localLinkedList = new LinkedList();
        if (1 >= k) {}
      }
      for (;;)
      {
        int j = i + 1;
        Object localObject = parami.DSu.GCA.get(i);
        kotlin.g.b.s.s(localObject, "giftLayout.mAllViews[i]");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((Iterator)localObject).next();
          parami.DSu.removeView(localView);
          localLinkedList.add(localView);
        }
        if (j >= k)
        {
          parami.DSu.setOnClickListener(new w.i..ExternalSyntheticLambda0(parami, paramLinkedList, localLinkedList));
          ((TextView)parami.DSu.getChildAt(parami.DSu.getChildCount() - 1).findViewById(p.e.BSd)).setText((CharSequence)"...");
          AppMethodBeat.o(359039);
          return;
        }
        i = j;
      }
    }
    
    private static final void a(i parami, LinkedList paramLinkedList1, LinkedList paramLinkedList2, View paramView)
    {
      AppMethodBeat.i(359028);
      kotlin.g.b.s.u(parami, "this$0");
      kotlin.g.b.s.u(paramLinkedList2, "$removedView");
      ((TextView)parami.DSu.getChildAt(parami.DSu.getChildCount() - 1).findViewById(p.e.BSd)).setText((CharSequence)kotlin.g.b.s.X("x", Integer.valueOf(((cxk)paramLinkedList1.get(0)).ZnA)));
      paramLinkedList1 = ((Iterable)paramLinkedList2).iterator();
      while (paramLinkedList1.hasNext())
      {
        paramLinkedList2 = (View)paramLinkedList1.next();
        parami.DSu.addView(paramLinkedList2);
      }
      parami.DSu.setOnClickListener(null);
      AppMethodBeat.o(359028);
    }
    
    public final void aw(LinkedList<cxk> paramLinkedList)
    {
      Object localObject2 = null;
      AppMethodBeat.i(359063);
      new LinkedList();
      Iterator localIterator;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if (paramLinkedList != null)
      {
        localIterator = ((Iterable)paramLinkedList).iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (cxk)localIterator.next();
          localObject1 = q.CFU;
          localObject1 = ((cxk)localObject3).ZOR;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((bim)localObject1).ZOC)
          {
            localObject1 = q.awx((String)localObject1);
            if (localObject1 == null) {
              break;
            }
            localObject4 = ((cxk)localObject3).ZOR;
            if (localObject4 != null) {
              ((bim)localObject4).ZRI = ((com.tencent.d.a.a.a.d.a.d)localObject1).field_price;
            }
            localObject3 = ((cxk)localObject3).ZOR;
            if (localObject3 == null) {
              break;
            }
            ((bim)localObject3).ZRC = ((com.tencent.d.a.a.a.d.a.d)localObject1).field_thumbnailFileUrl;
            break;
          }
        }
      }
      if (paramLinkedList == null) {}
      for (paramLinkedList = (LinkedList<cxk>)localObject2;; paramLinkedList = Boolean.valueOf(this.DSu.post(new w.i..ExternalSyntheticLambda1(this, paramLinkedList))))
      {
        if (paramLinkedList == null) {
          ((i)this).DSu.setVisibility(8);
        }
        AppMethodBeat.o(359063);
        return;
        this.DSu.setGravity(-1);
        this.DSu.setVisibility(0);
        this.DSu.removeAllViews();
        localObject1 = (List)paramLinkedList;
        if (((List)localObject1).size() > 1) {
          kotlin.a.p.a((List)localObject1, (Comparator)new a());
        }
        localIterator = ((Iterable)paramLinkedList).iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (cxk)localIterator.next();
          localObject4 = View.inflate(this.caK.getContext(), p.f.Cfv, null);
          ImageView localImageView = (ImageView)((View)localObject4).findViewById(p.e.BSc);
          TextView localTextView = (TextView)((View)localObject4).findViewById(p.e.BSd);
          localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
          com.tencent.mm.loader.d locald = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject1 = ((cxk)localObject3).ZOR;
          if (localObject1 == null) {
            localObject1 = "";
          }
          for (;;)
          {
            localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKZ);
            kotlin.g.b.s.s(localImageView, "giftImgView");
            localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
            locald.a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
            localTextView.setText((CharSequence)kotlin.g.b.s.X("x", Integer.valueOf(((cxk)localObject3).ZnA)));
            this.DSu.addView((View)localObject4);
            break;
            localObject2 = ((bim)localObject1).ZRC;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
    public static final class a<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        float f2 = 0.0F;
        AppMethodBeat.i(358682);
        paramT2 = (cxk)paramT2;
        float f3 = paramT2.ZnA;
        paramT2 = paramT2.ZOR;
        if (paramT2 == null)
        {
          f1 = 0.0F;
          paramT2 = (Comparable)Float.valueOf(f1 * f3);
          paramT1 = (cxk)paramT1;
          f3 = paramT1.ZnA;
          paramT1 = paramT1.ZOR;
          if (paramT1 != null) {
            break label98;
          }
        }
        label98:
        for (float f1 = f2;; f1 = paramT1.ZRI)
        {
          int i = kotlin.b.a.b(paramT2, (Comparable)Float.valueOf(f1 * f3));
          AppMethodBeat.o(358682);
          return i;
          f1 = paramT2.ZRI;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.w
 * JD-Core Version:    0.7.0.1
 */