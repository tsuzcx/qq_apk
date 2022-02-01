package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.b;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.k;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "dataList", "Ljava/util/LinkedList;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "scene", "getScene", "setScene", "topPlaceCount", "getTopPlaceCount", "setTopPlaceCount", "buildFinderCustomerInfo", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "finderContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "delConv", "", "conv", "formatTime", "", "", "getItem", "position", "getItemCount", "insertConvList", "convs", "insertOrUpdateConv", "notifyConvItemChanged", "index", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$ConversationHolder;", "onConversationOrContactChange", "", "_event", "_eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeConversation", "sessionId", "setConvRead", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "submitList", "datas", "updateConv", "OnItemClickListener", "OnItemLongClickListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends BasePrivateMsgConvListFragment.a<b>
{
  private a AFA;
  private b AFB;
  public HashMap<String, b> AFz;
  public int pageType;
  public int scene;
  public LinkedList<b> vEn;
  
  public c()
  {
    AppMethodBeat.i(336053);
    this.vEn = new LinkedList();
    this.AFz = new HashMap();
    this.pageType = 1;
    this.scene = 2;
    AppMethodBeat.o(336053);
  }
  
  private static SpannableString a(Context paramContext, ch paramch)
  {
    AppMethodBeat.i(336076);
    localStringBuilder1 = new StringBuilder();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = "";
    StringBuilder localStringBuilder2 = new StringBuilder();
    for (;;)
    {
      try
      {
        if ((paramch instanceof m))
        {
          Object localObject3 = (m)paramch;
          if ((((m)localObject3).field_badgeInfoList != null) && (((m)localObject3).field_badgeInfoList.ToF != null) && (((m)localObject3).field_badgeInfoList.ToF.size() != 0))
          {
            if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfd, false)) {
              continue;
            }
            localObject1 = new int[] { 2, 4 };
            com.tencent.d.a.a.a.b localb = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
            localObject3 = ((m)localObject3).field_badgeInfoList.ToF;
            s.s(localObject3, "localFinderContact.field_badgeInfoList.infos");
            localLinkedList.addAll((Collection)localb.parseAllBadgeInfos((List)localObject3, (int[])localObject1, 1, 0));
          }
          localStringBuilder2.append("isLocalFinderContact=true;");
        }
        l1 = paramch.dUx();
        if (l1 <= 0L) {
          continue;
        }
        localObject1 = paramContext.getResources().getString(e.h.finder_msg_contact_reward_total_amount_wecoin, new Object[] { Long.valueOf(l1) });
        s.s(localObject1, "context.resources\n      …al_amount_wecoin, wecoin)");
        localStringBuilder2.append("isFinderContact=true;have wecoin;");
        l2 = paramch.dUy();
        if ((l1 != 0L) || (l2 <= 0L)) {
          continue;
        }
        paramch = paramContext.getResources().getString(e.h.finder_msg_contact_interaction_count, new Object[] { Long.valueOf(l2) });
        s.s(paramch, "context.resources\n      …_count, interactionCount)");
        localStringBuilder2.append("interactionCount=" + l2 + ';');
        k = localLinkedList.size();
        localStringBuilder2.append(s.X("spanSize=", Integer.valueOf(k)));
        i = 0;
        if (k > 0)
        {
          j = i + 1;
          localStringBuilder1.append(" ");
          i = j;
          if (j < k) {
            continue;
          }
        }
        localStringBuilder1.append((String)localObject1);
        localStringBuilder1.append(paramch);
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)paramch)) && (k > 0)) {
          localStringBuilder1.append(" ");
        }
        localObject2 = new SpannableString((CharSequence)localStringBuilder1);
        i = 0;
        if (k <= 0) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        long l1;
        long l2;
        int k;
        int j;
        Log.e("Finder.FinderConversationParentUI", s.X("buildFinderCustomerInfo:", paramContext.getMessage()));
        paramContext = new SpannableString((CharSequence)localStringBuilder1);
        continue;
        int i = j;
        continue;
      }
      j = i + 1;
      ((SpannableString)localObject2).setSpan(localLinkedList.get(i), i, i + 1, 33);
      if (j < k) {
        continue;
      }
      if (l1 > 0L)
      {
        i = localStringBuilder1.indexOf((String)localObject1);
        j = ((String)localObject1).length();
        ((SpannableString)localObject2).setSpan(new k(Color.parseColor("#FF6146"), Color.parseColor("#26FF6146"), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 18), com.tencent.mm.cd.a.bs(paramContext, e.c.Edge_A)), i, j + i, 33);
      }
      if ((l1 == 0L) && (l2 > 0L))
      {
        i = localStringBuilder1.indexOf(paramch);
        j = paramch.length();
        ((SpannableString)localObject2).setSpan(new k(Color.parseColor("#FA9D3B"), Color.parseColor("#26FA9D3B"), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 18), com.tencent.mm.cd.a.bs(paramContext, e.c.Edge_A)), i, j + i, 33);
      }
      Log.i("Finder.FinderConversationParentUI", s.X("buildFinderCustomerInfo:", localStringBuilder2));
      paramContext = (Context)localObject2;
      AppMethodBeat.o(336076);
      return paramContext;
      localObject1 = new int[] { 4 };
      continue;
      localStringBuilder2.append("isFinderContact=true;no wecoin;");
      localObject1 = "";
      continue;
      localStringBuilder2.append("interactionCount=0;");
      paramch = (ch)localObject2;
    }
  }
  
  private static final boolean a(BasePrivateMsgConvListFragment.b paramb, c paramc, View paramView1, View paramView2)
  {
    AppMethodBeat.i(336084);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramc);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(paramc, "this$0");
    s.u(paramView1, "$itemView");
    paramView2 = (b)paramb.CSA;
    paramc = paramc.AFB;
    if (paramc != null)
    {
      int i = paramb.KJ();
      s.s(paramView2, "item");
      paramc.a(paramView1, i, paramView2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(336084);
    return true;
  }
  
  private static final void b(BasePrivateMsgConvListFragment.b paramb, c paramc, View paramView1, View paramView2)
  {
    AppMethodBeat.i(336096);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramc);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(paramc, "this$0");
    s.u(paramView1, "$itemView");
    paramView2 = (b)paramb.CSA;
    paramc = paramc.AFA;
    if (paramc != null)
    {
      paramb.KJ();
      s.s(paramView2, "item");
      paramc.a(paramView1, paramView2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(336096);
  }
  
  private static final void fW(List paramList)
  {
    AppMethodBeat.i(336112);
    s.u(paramList, "$convs");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      localObject3 = new avo();
      ((avo)localObject3).ZFM = ((b)localObject2).field_talker;
      ((avo)localObject3).session_id = ((b)localObject2).field_sessionId;
      paramList.add(localObject3);
    }
    paramList = (List)paramList;
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eYo().bmg()).booleanValue())
    {
      new bf(new LinkedList((Collection)paramList)).bFJ();
      AppMethodBeat.o(336112);
      return;
    }
    localObject1 = ((Iterable)paramList).iterator();
    label395:
    label400:
    label406:
    while (((Iterator)localObject1).hasNext())
    {
      paramList = (avo)((Iterator)localObject1).next();
      if (au.aAy(paramList.ZFM))
      {
        paramList = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw(paramList.ZFM);
        label207:
        paramList = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAo(paramList);
        if (!(paramList instanceof m)) {
          break label395;
        }
        label230:
        if (paramList != null) {
          break label400;
        }
      }
      for (paramList = null;; paramList = (m)paramList)
      {
        if (paramList == null) {
          break label406;
        }
        localObject2 = new bfm();
        ((bfm)localObject2).ToF = new LinkedList();
        localObject3 = ((bfm)localObject2).ToF;
        bfl localbfl = new bfl();
        localbfl.ZPp = 2;
        localbfl.ZPr = 1;
        ah localah = ah.aiuX;
        ((LinkedList)localObject3).add(localbfl);
        localObject3 = ((bfm)localObject2).ToF;
        localbfl = new bfl();
        localbfl.ZPp = 4;
        localbfl.ZPr = 1;
        localbfl.ZPs = "测试";
        localah = ah.aiuX;
        ((LinkedList)localObject3).add(localbfl);
        localObject3 = ah.aiuX;
        paramList.field_badgeInfoList = ((bfm)localObject2);
        paramList.field_rewardTotalAmountInWecoin = 2000L;
        paramList.field_interactionCount = 12L;
        ((y)com.tencent.mm.kernel.h.ax(y.class)).a((ch)paramList);
        break;
        paramList = paramList.ZFM;
        break label207;
        paramList = null;
        break label230;
      }
    }
    AppMethodBeat.o(336112);
  }
  
  public b MZ(int paramInt)
  {
    AppMethodBeat.i(336208);
    Object localObject = this.vEn.get(paramInt);
    s.s(localObject, "dataList[position]");
    localObject = (b)localObject;
    AppMethodBeat.o(336208);
    return localObject;
  }
  
  public void Na(int paramInt)
  {
    AppMethodBeat.i(336220);
    fV(paramInt);
    AppMethodBeat.o(336220);
  }
  
  public void Nb(int paramInt)
  {
    AppMethodBeat.i(336224);
    fW(paramInt);
    AppMethodBeat.o(336224);
  }
  
  public void Nc(int paramInt)
  {
    AppMethodBeat.i(336238);
    fX(paramInt);
    AppMethodBeat.o(336238);
  }
  
  public void a(BasePrivateMsgConvListFragment.b paramb, int paramInt)
  {
    AppMethodBeat.i(336171);
    s.u(paramb, "holder");
    View localView1 = paramb.caK;
    s.s(localView1, "holder.itemView");
    b localb = MZ(paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(336171);
      return;
    }
    paramb.CSA = localb;
    com.tencent.mm.ui.i.a.a.g((ImageView)localView1.findViewById(e.e.avatarIv), localb.field_sessionId);
    ((TextView)localView1.findViewById(e.e.conversationName)).setText(localb.AFy);
    ((TextView)localView1.findViewById(e.e.descTv)).setText(localb.dWM());
    label161:
    Object localObject2;
    Object localObject1;
    if ((localb.field_placedFlag > 0L) && (!s.p(localb.field_sessionId, "findersayhisessionholder")) && (!s.p(localb.field_sessionId, "finderaliassessionholder")))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label648;
      }
      localView1.setBackgroundResource(e.d.list_item_top_selector);
      localObject2 = (TextView)localView1.findViewById(e.e.timeTv);
      localObject1 = localView1.getContext();
      s.s(localObject1, "itemView.context");
      if (localb.field_status != 1) {
        break label659;
      }
      localObject1 = (CharSequence)((Context)localObject1).getString(e.h.finder_sending);
      label207:
      ((TextView)localObject2).setText((CharSequence)String.valueOf(localObject1));
      if ((!s.p(localb.field_sessionId, "findersayhisessionholder")) && (!s.p(localb.field_sessionId, "finderaliassessionholder"))) {
        break label679;
      }
      localObject1 = (TextView)localView1.findViewById(e.e.tipNomalTv);
      if ((localb.field_unReadCount <= 0) || (localb.field_readStatus != 0)) {
        break label673;
      }
      paramInt = 0;
      label277:
      ((TextView)localObject1).setVisibility(paramInt);
      ((TextView)localView1.findViewById(e.e.tipCountTv)).setVisibility(8);
      View localView2 = localView1.findViewById(e.e.finder_conversation_item_container);
      if (localView2 != null)
      {
        localView2.setTag(e.e.finder_accessibility_nickname_tag, localb.AFy);
        localView2.setTag(e.e.finder_accessibility_content_desc_tag, localb.dWM());
        paramInt = e.e.finder_accessibility_comment_time_tag;
        localObject1 = (TextView)localView1.findViewById(e.e.timeTv);
        if (localObject1 != null) {
          break label827;
        }
        localObject1 = (CharSequence)"";
        label365:
        localView2.setTag(paramInt, localObject1);
        localView2.setTag(e.e.finder_accessibility_msg_count_tag, Integer.valueOf(localb.field_unReadCount));
      }
      localObject1 = localb.contact;
      if (localObject1 != null) {
        break label850;
      }
      localObject1 = null;
      label400:
      if (!au.aAy((String)localObject1)) {
        break label866;
      }
      localObject2 = (bp)com.tencent.mm.kernel.h.ax(bp.class);
      localObject1 = localb.contact;
      if (localObject1 != null) {
        break label858;
      }
      localObject1 = null;
      label430:
      localObject1 = ((bp)localObject2).aAw((String)localObject1);
      label439:
      localObject2 = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAo((String)localObject1);
      if (!(localObject2 instanceof m)) {
        break label889;
      }
      label464:
      if (localObject2 != null) {
        break label895;
      }
      localObject2 = null;
      label472:
      if (localObject2 == null) {
        break label926;
      }
      if (au.bwV((String)localObject1))
      {
        localObject1 = av.GiL;
        localObject1 = localView1.findViewById(e.e.conv_auth_info);
        s.s(localObject1, "itemView.findViewById<Im…iew>(R.id.conv_auth_info)");
        av.a((ImageView)localObject1, ((m)localObject2).field_authInfo, 0, null, 12);
      }
      paramb = paramb.context;
      s.s(paramb, "holder.context");
      paramb = a(paramb, (ch)localObject2);
      localObject1 = (CharSequence)paramb;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label905;
      }
    }
    label648:
    label905:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label910;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((!((Boolean)com.tencent.mm.plugin.finder.storage.d.eYp().bmg()).booleanValue()) && (this.pageType != 2)) {
        break label910;
      }
      localObject1 = (TextView)localView1.findViewById(e.e.interaction_txt);
      ((TextView)localObject1).setText((CharSequence)paramb);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setTextColor(localView1.getContext().getResources().getColor(e.b.BG_2));
      AppMethodBeat.o(336171);
      return;
      paramInt = 0;
      break;
      localView1.setBackgroundResource(e.d.comm_list_item_selector);
      break label161;
      label659:
      localObject1 = com.tencent.mm.pluginsdk.platformtools.f.d((Context)localObject1, localb.field_updateTime, true);
      break label207;
      label673:
      paramInt = 8;
      break label277;
      label679:
      localObject1 = (TextView)localView1.findViewById(e.e.tipCountTv);
      if ((localb.field_unReadCount > 0) && (localb.field_readStatus == 0)) {}
      for (paramInt = 0;; paramInt = 8)
      {
        ((TextView)localObject1).setVisibility(paramInt);
        ((TextView)localView1.findViewById(e.e.tipCountTv)).setText((CharSequence)String.valueOf(localb.field_unReadCount));
        ((TextView)localView1.findViewById(e.e.tipCountTv)).setBackgroundResource(v.bC(localView1.getContext(), localb.field_unReadCount));
        ((TextView)localView1.findViewById(e.e.tipCountTv)).setTextSize(0, com.tencent.mm.cd.a.bs(localView1.getContext(), e.c.unReadCountTextSize) * com.tencent.mm.cd.a.jO(localView1.getContext()));
        ((TextView)localView1.findViewById(e.e.tipNomalTv)).setVisibility(8);
        break;
      }
      label827:
      localObject2 = ((TextView)localObject1).getText();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label365;
      }
      localObject1 = (CharSequence)"";
      break label365;
      label850:
      localObject1 = ((az)localObject1).field_username;
      break label400;
      label858:
      localObject1 = ((az)localObject1).field_username;
      break label430;
      label866:
      localObject1 = localb.contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label439;
      }
      localObject1 = ((az)localObject1).field_username;
      break label439;
      label889:
      localObject2 = null;
      break label464;
      label895:
      localObject2 = (m)localObject2;
      break label472;
    }
    label910:
    ((TextView)localView1.findViewById(e.e.interaction_txt)).setVisibility(8);
    label926:
    AppMethodBeat.o(336171);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(336196);
    s.u(parama, "listener");
    this.AFA = parama;
    AppMethodBeat.o(336196);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(336200);
    s.u(paramb, "listener");
    this.AFB = paramb;
    AppMethodBeat.o(336200);
  }
  
  public final boolean a(String paramString, final MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(336189);
    if ((paramString != null) && (paramMStorageEventData != null))
    {
      if ((paramMStorageEventData.obj instanceof b))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
          AppMethodBeat.o(336189);
          throw paramString;
        }
        paramString = (b)paramString;
        if (paramString.field_scene != this.scene)
        {
          Log.i("Finder.FinderConversationParentUI", "conv.field_scene:" + paramString.field_scene + " != conveScene:" + this.scene);
          AppMethodBeat.o(336189);
          return false;
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramMStorageEventData));
        AppMethodBeat.o(336189);
        return true;
      }
      if ((paramMStorageEventData.obj instanceof String))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(336189);
          throw paramString;
        }
        int i;
        if (((CharSequence)paramString).length() > 0) {
          i = 1;
        }
        while (i != 0)
        {
          paramString = paramMStorageEventData.obj;
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(336189);
            throw paramString;
            i = 0;
          }
          else
          {
            String str = (String)paramString;
            Iterator localIterator = ((Iterable)this.vEn).iterator();
            if (localIterator.hasNext())
            {
              paramMStorageEventData = localIterator.next();
              b localb = (b)paramMStorageEventData;
              paramString = localb.contact;
              if (paramString == null)
              {
                paramString = null;
                label286:
                if ((!s.p(paramString, str)) && (!s.p(localb.field_talker, str))) {
                  break label395;
                }
                i = 1;
                label310:
                if (i == 0) {
                  break label398;
                }
              }
            }
            for (paramString = paramMStorageEventData;; paramString = null)
            {
              paramString = (b)paramString;
              if (paramString != null)
              {
                Log.i("Finder.FinderConversationParentUI", s.X("[onContactStorageChange] username=", str));
                s.u(paramString, "conv");
                paramString.prepare();
                i = this.vEn.indexOf(paramString);
                if ((i >= 0) && (i < this.vEn.size())) {
                  Na(i);
                }
              }
              AppMethodBeat.o(336189);
              return true;
              paramString = paramString.field_username;
              break label286;
              label395:
              i = 0;
              break label310;
              label398:
              break;
            }
          }
        }
      }
      AppMethodBeat.o(336189);
      return false;
    }
    AppMethodBeat.o(336189);
    return false;
  }
  
  public final void bw(final List<b> paramList)
  {
    AppMethodBeat.i(336178);
    s.u(paramList, "convs");
    if (paramList != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramList));
    }
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Boolean)com.tencent.mm.plugin.finder.storage.d.eYp().bmg()).booleanValue()) || (this.pageType == 2)) {
      com.tencent.threadpool.h.ahAA.bn(new c..ExternalSyntheticLambda2(paramList));
    }
    AppMethodBeat.o(336178);
  }
  
  public final List<b> getDataList()
  {
    return (List)this.vEn;
  }
  
  public int getItemCount()
  {
    AppMethodBeat.i(336213);
    int i = this.vEn.size();
    AppMethodBeat.o(336213);
    return i;
  }
  
  public void hq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(336231);
    bA(paramInt1, paramInt2);
    AppMethodBeat.o(336231);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(View paramView, b paramb);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, b paramb);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(c paramc, MStorageEventData paramMStorageEventData)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(c paramc, List<b> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.c
 * JD-Core Version:    0.7.0.1
 */