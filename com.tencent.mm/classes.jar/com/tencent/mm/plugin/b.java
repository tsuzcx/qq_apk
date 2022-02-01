package com.tencent.mm.plugin;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.ao;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.bek;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/IFinderCommonService;", "Lcom/tencent/mm/kernel/service/IService;", "cgiFinderSearch", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "topicBuffer", "hotWordInfo", "cgiGetFinderPrepareUser", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cgi", "checkActivityIsFinderHome", "", "context", "Landroid/content/Context;", "checkFriendFollowCount", "username", "checkOldConv", "checkOldSessionInfo", "downloadInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "getContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "getFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getFinderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "getFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "getFinderItemSessionBuffer", "getFinderItemSessionBufferEx", "Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getReportNetTypeInt", "isFriend", "isLibPagEnabled", "jumpAtProfileUI", "nickname", "feedObject", "jumpTopicUI", "topic", "refObjectId", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "onEnterFinder", "finder", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "onExitFinder", "parseXml", "Landroid/text/SpannableString;", "xml", "defaultDesc", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "atFinderContactList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "onAtClick", "processHighLight", "Landroid/text/Spanned;", "origin", "highLightFontColor", "removeHighLightTag", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateUserExtInfoCache", "info", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "plugin-finder-base_release"})
public abstract interface b
  extends a
{
  public abstract FinderItem Hc(long paramLong);
  
  public abstract SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<ax> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<bek> paramLinkedList1, m<? super String, ? super c, x> paramm, kotlin.g.a.b<? super String, x> paramb);
  
  public abstract BaseFinderFeed a(FinderItem paramFinderItem);
  
  public abstract com.tencent.mm.plugin.findersdk.b.g a(String paramString1, int paramInt, String paramString2, com.tencent.mm.cd.b paramb);
  
  public abstract void a(int paramInt, kotlin.g.a.b<? super com.tencent.mm.plugin.findersdk.b.g, x> paramb);
  
  public abstract void a(Context paramContext, String paramString, FinderItem paramFinderItem);
  
  public abstract void a(String paramString, d.a.a parama);
  
  public abstract void a(String paramString, Long paramLong, c paramc);
  
  public abstract i aab(String paramString);
  
  public abstract String aac(String paramString);
  
  public abstract int aad(String paramString);
  
  public abstract Spanned bZ(String paramString1, String paramString2);
  
  public abstract LinkedList<asb> bvN();
  
  public abstract boolean bvO();
  
  public abstract boolean bvP();
  
  public abstract boolean bvQ();
  
  public abstract int bvR();
  
  public abstract boolean dy(Context paramContext);
  
  public abstract e getContactStorage();
  
  public abstract com.tencent.mm.plugin.finder.api.b getFinderContactCache();
  
  public abstract com.tencent.mm.plugin.finder.api.g getFinderSyncExtension();
  
  public abstract ao h(long paramLong, int paramInt);
  
  public abstract boolean isFriend(String paramString);
  
  public abstract void onEnterFinder(MMFinderUI paramMMFinderUI);
  
  public abstract void onExitFinder(MMFinderUI paramMMFinderUI);
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.g, x>
    {
      public static final a mIE;
      
      static
      {
        AppMethodBeat.i(258036);
        mIE = new a();
        AppMethodBeat.o(258036);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.b
 * JD-Core Version:    0.7.0.1
 */