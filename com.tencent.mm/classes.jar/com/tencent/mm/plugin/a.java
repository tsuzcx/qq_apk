package com.tencent.mm.plugin;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.profile.uic.j.a;
import com.tencent.mm.plugin.finder.profile.uic.j.b;
import com.tencent.mm.plugin.finder.report.ao;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.utils.e.a;
import com.tencent.mm.plugin.finder.utils.e.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/FinderCommonService;", "Lcom/tencent/mm/plugin/IFinderCommonService;", "Lcom/tencent/mm/plugin/IFinderCommonService2;", "()V", "cgiFinderSearch", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "topicBuffer", "hotWordInfo", "cgiGetFinderFeedComment", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "objectNonceId", "enterScene", "feedUsername", "needObject", "", "lastBuffer", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "pullScene", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "cgiGetFinderPrepareUser", "Lkotlin/ParameterName;", "name", "cgi", "checkActivityIsFinderHome", "Landroid/content/Context;", "checkFriendFollowCount", "checkOldConv", "checkOldSessionInfo", "downloadInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "", "getContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "getFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getFinderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "getFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderItemSessionBuffer", "getFinderItemSessionBufferEx", "Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getReportNetTypeInt", "isFriend", "isLibPagEnabled", "jumpAtProfileUI", "nickname", "feedObject", "jumpTopicUI", "topic", "refObjectId", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "onEnterFinder", "finder", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "onExitFinder", "parseXml", "Landroid/text/SpannableString;", "xml", "defaultDesc", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "atFinderContactList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "onAtClick", "processHighLight", "Landroid/text/Spanned;", "origin", "highLightFontColor", "removeHighLightTag", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateUserExtInfoCache", "logOutInfo", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "plugin-finder_release"})
public final class a
  implements b, c
{
  public final FinderItem Hc(long paramLong)
  {
    AppMethodBeat.i(285138);
    Object localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject = com.tencent.mm.plugin.finder.report.n.Hc(paramLong);
    AppMethodBeat.o(285138);
    return localObject;
  }
  
  public final SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<ax> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<bek> paramLinkedList1, m<? super String, ? super com.tencent.mm.plugin.finder.utils.c, x> paramm, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(285123);
    p.k(paramSpannableString, "defaultDesc");
    p.k(paramList, "topicInfoList");
    p.k(paramLinkedList, "atFinderContactList");
    p.k(paramLinkedList1, "mentionedUserList");
    p.k(paramm, "onTopicClick");
    p.k(paramb, "onAtClick");
    Object localObject1 = ad.AFr;
    p.k(paramSpannableString, "defaultDesc");
    p.k(paramList, "topicInfoList");
    p.k(paramLinkedList, "atFinderContactList");
    p.k(paramLinkedList1, "mentionedUserList");
    p.k(paramm, "onTopicClick");
    p.k(paramb, "onAtClick");
    if (!Util.isNullOrNil(paramString))
    {
      paramLinkedList1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dTd())
      {
        paramLinkedList1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (com.tencent.mm.plugin.finder.storage.d.dTe()) {}
      }
    }
    else
    {
      paramString = ad.a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(285123);
      return paramString;
    }
    localObject1 = XmlParser.parseXml(paramString, "finder", null);
    if (localObject1 == null)
    {
      paramString = ad.a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(285123);
      return paramString;
    }
    int m = Util.getInt((String)((Map)localObject1).get("." + ad.AFa + '.' + ad.AFc), -1);
    if (m < 0)
    {
      paramString = ad.a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(285123);
      return paramString;
    }
    int n = Util.getInt((String)((Map)localObject1).get("." + ad.AFa + '.' + ad.VERSION), 0);
    paramString = Util.nullAs((String)((Map)localObject1).get("." + ad.AFa + '.' + ad.AFb + '.' + ad.AFe), "");
    p.j(paramString, "atIndexs");
    List localList = kotlin.n.n.b((CharSequence)paramString, new String[] { "," });
    paramLinkedList1 = new HashMap();
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderContact)((Iterator)localObject2).next();
      if (!((Map)paramLinkedList1).containsKey(((FinderContact)localObject3).username))
      {
        paramLinkedList = ((FinderContact)localObject3).username;
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        paramLinkedList1.put(paramString, localObject3);
      }
    }
    Object localObject3 = new StringBuilder("");
    localObject2 = new ArrayList();
    int i = 0;
    int j;
    if (i < m)
    {
      paramString = (String)((Map)localObject1).get("." + ad.AFa + '.' + ad.VALUE + i + '.' + ad.AFd);
      if (paramString == null)
      {
        j = ((StringBuilder)localObject3).toString().length();
        paramString = (String)((Map)localObject1).get("." + ad.AFa + '.' + ad.VALUE + i);
        if (paramString != null) {
          break label1383;
        }
        paramString = "";
      }
    }
    label806:
    label861:
    label1383:
    for (;;)
    {
      int k;
      if ((localList.contains(String.valueOf(i))) && (!Util.isNullOrNil(paramString)))
      {
        paramLinkedList = kotlin.n.n.l(paramString, " ", "_", false);
        if (paramLinkedList.length() > 2)
        {
          k = paramLinkedList.length();
          if (paramLinkedList == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(285123);
            throw paramString;
          }
          paramString = paramLinkedList.substring(1, k - 1);
          p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        for (;;)
        {
          paramLinkedList1 = paramString;
          if (paramLinkedList.length() <= 1) {
            break label806;
          }
          if ((!kotlin.n.n.a((CharSequence)paramLinkedList, ' ')) && (!kotlin.n.n.a((CharSequence)paramLinkedList, ' '))) {
            break label861;
          }
          k = paramLinkedList.length();
          if (paramLinkedList != null) {
            break;
          }
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(285123);
          throw paramString;
          paramString = paramLinkedList;
        }
        paramLinkedList = paramLinkedList.substring(0, k - 1);
        p.j(paramLinkedList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        p.j(((StringBuilder)localObject3).append(paramLinkedList), "sb.append(text.substring(0, text.length - 1))");
        paramLinkedList1 = paramString;
        if (n <= 0) {
          ((StringBuilder)localObject3).append(" ");
        }
        ((ArrayList)localObject2).add(new e.a(j, ((StringBuilder)localObject3).toString().length(), paramLinkedList1, new FinderContact()));
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject3).append(paramLinkedList);
        paramString = paramLinkedList;
        if (paramLinkedList.length() > 2)
        {
          if (paramLinkedList == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(285123);
            throw paramString;
          }
          paramString = paramLinkedList.substring(1);
          p.j(paramString, "(this as java.lang.String).substring(startIndex)");
        }
        paramLinkedList1 = paramString;
        break label806;
        paramLinkedList = com.tencent.mm.plugin.finder.utils.ag.AFH;
        paramLinkedList = com.tencent.mm.plugin.finder.utils.ag.a(paramString, new ArrayList(), null);
        int i1 = ((StringBuilder)localObject3).toString().length();
        paramLinkedList = ((Iterable)paramLinkedList).iterator();
        while (paramLinkedList.hasNext())
        {
          paramLinkedList1 = (ax)paramLinkedList.next();
          k = paramLinkedList1.start + i1 - 1;
          j = k;
          if (k < 0) {
            j = 0;
          }
          paramList.add(new ax(j, paramLinkedList1.count + 1, "#" + paramLinkedList1.topic));
        }
        p.j(((StringBuilder)localObject3).append(paramString), "sb.append(text)");
        continue;
        if (((CharSequence)kotlin.n.n.bb((CharSequence)paramString).toString()).length() > 0) {
          j = 1;
        }
        for (;;)
        {
          if (j != 0)
          {
            paramLinkedList = kotlin.n.n.l(paramString, " ", "", false);
            paramString = paramLinkedList;
            if (paramLinkedList.length() > 1)
            {
              j = paramLinkedList.length();
              if (paramLinkedList == null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(285123);
                throw paramString;
                j = 0;
              }
              else
              {
                paramString = paramLinkedList.substring(0, j - 1);
                p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              }
            }
            else
            {
              paramList.add(new ax(((StringBuilder)localObject3).toString().length(), paramString.length(), paramString));
              ((StringBuilder)localObject3).append(paramString);
              if (n > 0) {
                break;
              }
              ((StringBuilder)localObject3).append(" ");
              break;
            }
          }
        }
        p.j(((StringBuilder)localObject3).append(paramString), "sb.append(topic)");
      }
      Log.i(ad.TAG, "parseXml, version:" + n + ", result:" + localObject3);
      if ((Util.isNullOrNil(((StringBuilder)localObject3).toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
      {
        AppMethodBeat.o(285123);
        return paramSpannableString;
      }
      paramString = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)((StringBuilder)localObject3).toString())));
      p.j(paramString, "desc");
      ad.a(paramLong, paramString, paramList, paramm);
      ad.a(paramString, (ArrayList)localObject2, paramb);
      AppMethodBeat.o(285123);
      return paramString;
    }
  }
  
  public final BaseFinderFeed a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(285127);
    p.k(paramFinderItem, "finderObject");
    com.tencent.mm.plugin.finder.storage.logic.c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    paramFinderItem = com.tencent.mm.plugin.finder.storage.logic.c.a.a(paramFinderItem);
    AppMethodBeat.o(285127);
    return paramFinderItem;
  }
  
  public final com.tencent.mm.plugin.finder.utils.b a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Set<Integer> paramSet)
  {
    AppMethodBeat.i(285142);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramSet, "otherCareType");
    aj localaj = aj.AGc;
    paramRecyclerView = aj.a(paramRecyclerView, paramInt1, paramInt2, paramSet);
    AppMethodBeat.o(285142);
    return paramRecyclerView;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.g a(String paramString1, int paramInt, String paramString2, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(285141);
    p.k(paramString1, "query");
    p.k(paramString2, "requestId");
    paramString1 = new cj(paramString1, paramInt, paramString2, paramb, 11, null, null, null, null);
    com.tencent.mm.kernel.h.aGY().b((q)paramString1);
    paramString1 = (com.tencent.mm.plugin.findersdk.b.g)paramString1;
    AppMethodBeat.o(285141);
    return paramString1;
  }
  
  public final void a(int paramInt, kotlin.g.a.b<? super com.tencent.mm.plugin.findersdk.b.g, x> paramb)
  {
    AppMethodBeat.i(285140);
    p.k(paramb, "callback");
    ch localch = new ch(paramInt);
    paramb.invoke(localch);
    com.tencent.mm.kernel.h.aGY().b((q)localch);
    AppMethodBeat.o(285140);
  }
  
  public final void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(285124);
    p.k(paramString, "nickname");
    p.k(paramFinderItem, "feedObject");
    com.tencent.mm.plugin.finder.utils.e locale = com.tencent.mm.plugin.finder.utils.e.ACV;
    p.k(paramString, "nickname");
    p.k(paramFinderItem, "feedObject");
    if (paramContext != null)
    {
      if (com.tencent.mm.plugin.finder.utils.e.ACU.containsKey(paramString))
      {
        paramString = (FinderContact)com.tencent.mm.plugin.finder.utils.e.ACU.get(paramString);
        if (paramString != null) {}
        for (paramString = paramString.username; (!Util.isNullOrNil(paramString)) && (paramString != null); paramString = null)
        {
          com.tencent.mm.plugin.finder.utils.e.a(paramString, paramContext, paramFinderItem, paramContext);
          AppMethodBeat.o(285124);
          return;
        }
        Log.i(com.tencent.mm.plugin.finder.utils.e.TAG, "username nil");
        w.makeText(paramContext, b.j.finder_at_user_not_exist, 0).show();
        AppMethodBeat.o(285124);
        return;
      }
      new s(kotlin.a.j.listOf(paramString)).bhW().g((com.tencent.mm.vending.c.a)new e.c(paramString, paramContext, paramFinderItem));
    }
    AppMethodBeat.o(285124);
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, bid parambid, kotlin.g.a.b<? super com.tencent.mm.an.c.a<att>, x> paramb)
  {
    AppMethodBeat.i(285143);
    p.k(paramMMActivity, "context");
    p.k(paramString2, "feedUsername");
    p.k(paramString3, "username");
    p.k(paramString4, "encryptedObjectId");
    p.k(paramb, "callback");
    new com.tencent.mm.plugin.finder.cgi.ag(paramLong, paramString1, 0, 2, paramString2, true, null, null, 0L, paramString3, true, false, paramString4, parambid, 1, null, 32768).bhW().b((com.tencent.mm.vending.c.a)new a.a(paramb)).a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(285143);
  }
  
  public final void a(String paramString, d.a.a parama)
  {
    AppMethodBeat.i(285137);
    p.k(paramString, "username");
    p.k(parama, "logOutInfo");
    Object localObject = com.tencent.mm.plugin.finder.profile.uic.j.zSy;
    localObject = (j.b)com.tencent.mm.plugin.finder.profile.uic.j.access$getUserExtInfoCache$cp().get(paramString);
    if (localObject != null)
    {
      ((j.b)localObject).zSC = parama;
      AppMethodBeat.o(285137);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.profile.uic.j.zSy;
    localObject = com.tencent.mm.plugin.finder.profile.uic.j.access$getUserExtInfoCache$cp();
    j.b localb = new j.b();
    localb.zSC = parama;
    ((com.tencent.mm.b.h)localObject).put(paramString, localb);
    AppMethodBeat.o(285137);
  }
  
  public final void a(String paramString, Long paramLong, com.tencent.mm.plugin.finder.utils.c paramc)
  {
    AppMethodBeat.i(285122);
    p.k(paramString, "topic");
    p.k(paramc, "clickExtra");
    com.tencent.mm.plugin.finder.utils.ag localag = com.tencent.mm.plugin.finder.utils.ag.AFH;
    com.tencent.mm.plugin.finder.utils.ag.a(paramString, paramLong, paramc);
    AppMethodBeat.o(285122);
  }
  
  public final i aab(String paramString)
  {
    AppMethodBeat.i(285119);
    p.k(paramString, "username");
    paramString = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getContactStorage().aAK(paramString);
    AppMethodBeat.o(285119);
    return paramString;
  }
  
  public final String aac(String paramString)
  {
    AppMethodBeat.i(285126);
    p.k(paramString, "origin");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    paramString = com.tencent.mm.plugin.finder.search.j.aac(paramString);
    AppMethodBeat.o(285126);
    return paramString;
  }
  
  public final int aad(String paramString)
  {
    AppMethodBeat.i(285136);
    p.k(paramString, "username");
    j.a locala = com.tencent.mm.plugin.finder.profile.uic.j.zSy;
    paramString = (j.b)com.tencent.mm.plugin.finder.profile.uic.j.access$getUserExtInfoCache$cp().get(paramString);
    if (paramString != null)
    {
      int i = paramString.friendFollowCount;
      AppMethodBeat.o(285136);
      return i;
    }
    AppMethodBeat.o(285136);
    return 0;
  }
  
  public final Spanned bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(285125);
    p.k(paramString1, "origin");
    p.k(paramString2, "highLightFontColor");
    com.tencent.mm.plugin.finder.search.j localj = com.tencent.mm.plugin.finder.search.j.Acs;
    paramString1 = com.tencent.mm.plugin.finder.search.j.bZ(paramString1, paramString2);
    AppMethodBeat.o(285125);
    return paramString1;
  }
  
  public final LinkedList<asb> bvN()
  {
    AppMethodBeat.i(285116);
    Object localObject = com.tencent.mm.plugin.finder.video.reporter.d.ARA;
    localObject = com.tencent.mm.plugin.finder.video.reporter.d.ehP();
    AppMethodBeat.o(285116);
    return localObject;
  }
  
  public final boolean bvO()
  {
    AppMethodBeat.i(285117);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.bvO();
    AppMethodBeat.o(285117);
    return bool;
  }
  
  public final boolean bvP()
  {
    AppMethodBeat.i(285120);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().bvP();
    AppMethodBeat.o(285120);
    return bool;
  }
  
  public final boolean bvQ()
  {
    AppMethodBeat.i(285121);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage().bvQ();
    AppMethodBeat.o(285121);
    return bool;
  }
  
  public final int bvR()
  {
    AppMethodBeat.i(285135);
    com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
    int i = com.tencent.mm.plugin.finder.report.n.bvR();
    AppMethodBeat.o(285135);
    return i;
  }
  
  public final boolean dy(Context paramContext)
  {
    AppMethodBeat.i(285128);
    p.k(paramContext, "context");
    boolean bool = paramContext instanceof FinderHomeUI;
    AppMethodBeat.o(285128);
    return bool;
  }
  
  public final com.tencent.mm.plugin.finder.storage.e getContactStorage()
  {
    AppMethodBeat.i(285129);
    com.tencent.mm.plugin.finder.storage.e locale = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getContactStorage();
    AppMethodBeat.o(285129);
    return locale;
  }
  
  public final com.tencent.mm.plugin.finder.api.b getFinderContactCache()
  {
    AppMethodBeat.i(285118);
    com.tencent.mm.plugin.finder.api.b localb = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(285118);
    return localb;
  }
  
  public final com.tencent.mm.plugin.finder.api.g getFinderSyncExtension()
  {
    AppMethodBeat.i(285133);
    com.tencent.mm.plugin.finder.api.g localg = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension();
    AppMethodBeat.o(285133);
    return localg;
  }
  
  public final ao h(long paramLong, int paramInt)
  {
    AppMethodBeat.i(285134);
    Object localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject = com.tencent.mm.plugin.finder.report.n.h(paramLong, paramInt);
    AppMethodBeat.o(285134);
    return localObject;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(285130);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(285130);
    return bool;
  }
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(285132);
    p.k(paramMMFinderUI, "finder");
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).onEnterFinder(paramMMFinderUI);
    AppMethodBeat.o(285132);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(285131);
    p.k(paramMMFinderUI, "finder");
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).onExitFinder(paramMMFinderUI);
    AppMethodBeat.o(285131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */