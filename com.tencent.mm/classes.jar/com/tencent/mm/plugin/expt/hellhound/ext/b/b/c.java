package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.d.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "ShareType", "TopicType", "VisiableState", "WaterfallsFlowSceneEnum", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static boolean njA;
  public static int zGA;
  private static String zGB;
  private static boolean zGC;
  private static String zGD;
  private static String zGE;
  private static String zGF;
  private static String zGG;
  private static String zGH;
  private static float zGI;
  private static final List<String> zGJ;
  private static final List<String> zGK;
  private static final List<String> zGL;
  private static final List<String> zGM;
  private static final List<String> zGN;
  private static final List<String> zGO;
  public static int zGP;
  public static String zGQ;
  public static String zGR;
  public static String zGS;
  private static final ArrayList<String> zGT;
  private static final ArrayList<String> zGU;
  private static final ArrayList<String> zGV;
  private static final ArrayList<String> zGW;
  private static int zGX;
  private static String zGY;
  private static String zGZ;
  public static final a zGj;
  private static boolean zGk;
  public static boolean zGl;
  private static final Map<Integer, Map<String, i>> zGm;
  private static final Map<String, Map<String, i>> zGn;
  private static String zGo;
  private static int zGp;
  public static String zGq;
  public static String zGr;
  public static String zGs;
  public static boolean zGt;
  private static boolean zGu;
  private static boolean zGv;
  public static String zGw;
  public static long zGx;
  public static String zGy;
  private static String zGz;
  private static HashMap<String, String> zHa;
  
  static
  {
    AppMethodBeat.i(300721);
    zGj = new a((byte)0);
    zGm = (Map)new LinkedHashMap();
    zGn = (Map)new LinkedHashMap();
    zGq = "";
    zGr = "";
    zGs = "";
    zGu = true;
    zGv = true;
    zGw = "";
    zGy = "";
    zGz = "";
    zGA = 1001;
    zGB = "";
    zGD = "";
    zGE = "";
    zGF = "";
    zGG = "";
    zGH = "";
    zGJ = (List)new ArrayList();
    zGK = (List)new ArrayList();
    zGL = (List)new ArrayList();
    zGM = (List)new ArrayList();
    zGN = (List)new ArrayList();
    zGO = (List)new ArrayList();
    zGP = -1;
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.zBb;
    s.s(str, "_sChattingUIFragment");
    zGT = p.al(new String[] { str, "ChattingUI", "SnsTimeLineUI", "FavoriteIndexUI" });
    zGU = p.al(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI" });
    zGV = p.al(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2" });
    zGW = p.al(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    zGX = c.d.zHk.value;
    zGY = "";
    zGZ = "";
    AppMethodBeat.o(300721);
  }
  
  public static final boolean arv(String paramString)
  {
    AppMethodBeat.i(300585);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(300585);
          return true;
        }
        AppMethodBeat.o(300585);
        return false;
      }
      if ((s.p("FinderFollowTabFragment", paramString)) || (s.p("FinderFriendTabFragment", paramString)) || (s.p("FinderLbsTabFragment", paramString)) || (s.p("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(300585);
        return true;
      }
    }
    AppMethodBeat.o(300585);
    return false;
  }
  
  public static final int dKk()
  {
    AppMethodBeat.i(300603);
    int i = a.dKk();
    AppMethodBeat.o(300603);
    return i;
  }
  
  public static final void e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(300594);
    if (s.p(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI"))
    {
      if (paramIntent != null) {
        break label61;
      }
      paramString = null;
      if (paramString != null) {
        break label81;
      }
    }
    label61:
    label81:
    for (int i = c.d.zHk.value;; i = paramString.intValue())
    {
      zGX = i;
      Log.i("HABBYGE-MALI.HellFinderConfig", s.X("setTopicType: ", Integer.valueOf(zGX)));
      AppMethodBeat.o(300594);
      return;
      paramString = Integer.valueOf(paramIntent.getIntExtra("key_topic_type", c.d.zHk.value));
      break;
    }
  }
  
  public static final void hm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(300609);
    a.hm(paramString1, paramString2);
    AppMethodBeat.o(300609);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "PRE_PAGE_LIST", "getPRE_PAGE_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_BulletSubtitleViewCallback_Header", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabAffinityUI", "_FinderFriendTabFragment", "_FinderHomeAffinityUI", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderSelfUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_SnsTimelineUI", "_sChattingUIFragment", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeAffinityUI", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderMultiTaskRouterUI", "_sFinderSelfUI", "_sFinderTopicFeedUI", "_sSnsTimelineUI", "actionMs", "", "clickMoreLiveBtn", "", "getClickMoreLiveBtn", "()Z", "setClickMoreLiveBtn", "(Z)V", "curClickId", "getCurClickId", "()Ljava/lang/String;", "setCurClickId", "(Ljava/lang/String;)V", "curFinderUserName", "getCurFinderUserName", "setCurFinderUserName", "curNearbyFragmentType", "enterSessionId", "externalChnlExtra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "gActivityActionLatest", "gCurFinderHomePage", "gCurIsPoiScene", "getGCurIsPoiScene", "setGCurIsPoiScene", "gCurIsShareScene", "getGCurIsShareScene", "setGCurIsShareScene", "gCurShareUserName", "gCurSnsFeedId", "gCurSnsSessionId", "gEnterFinderBySnsCamera", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gLastVisible", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "giftPanelShow", "getGiftPanelShow", "setGiftPanelShow", "identityType", "getIdentityType", "setIdentityType", "isLiving", "requestShareStateUserName", "getRequestShareStateUserName", "setRequestShareStateUserName", "shareStateCount", "getShareStateCount", "setShareStateCount", "snsAdData", "snsFinderUsername", "visitorAppId", "getVisitorAppId", "setVisitorAppId", "visitorClickId", "getVisitorClickId", "setVisitorClickId", "visitorLiveid", "getVisitorLiveid", "setVisitorLiveid", "visitorSessionid", "getVisitorSessionid", "setVisitorSessionid", "visitorShopwindowid", "getVisitorShopwindowid", "setVisitorShopwindowid", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getExternalChnlExtra", "getFeedMapCache", "getShareType", "sid", "getSnsAdData", "finderUsername", "inLiveRoom", "isFinderHomeUI", "pageName", "isFinderHomeUIFragment", "fragmentName", "isSameFinderUserName", "isShare", "printInfo", "tag", "msg", "removeFeedMapCache", "resetExternalChnlExtra", "resetFeedIdCache", "resetFeedLeftRightCache", "resetSnsAdData", "resetVisitorCommerceParams", "restoreFeedIdOnRefreshEnd", "setExternalChnlExtra", "extra", "setInLiveRoom", "inRoom", "setSnsAdData", "snsAdInfo", "setTopicType", "intent", "Landroid/content/Intent;", "setVisitorCommerceParams", "clickId", "appId", "liveId", "shopwindowId", "sessionid", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void arG(String paramString)
    {
      AppMethodBeat.i(300637);
      s.u(paramString, "<set-?>");
      c.arx(paramString);
      AppMethodBeat.o(300637);
    }
    
    public static void arH(String paramString)
    {
      AppMethodBeat.i(300639);
      s.u(paramString, "<set-?>");
      c.ary(paramString);
      AppMethodBeat.o(300639);
    }
    
    private static void arI(String paramString)
    {
      AppMethodBeat.i(300641);
      s.u(paramString, "<set-?>");
      c.arz(paramString);
      AppMethodBeat.o(300641);
    }
    
    private static void arJ(String paramString)
    {
      AppMethodBeat.i(300646);
      s.u(paramString, "<set-?>");
      c.arA(paramString);
      AppMethodBeat.o(300646);
    }
    
    private static void arK(String paramString)
    {
      AppMethodBeat.i(300647);
      s.u(paramString, "<set-?>");
      c.arB(paramString);
      AppMethodBeat.o(300647);
    }
    
    private static void arL(String paramString)
    {
      AppMethodBeat.i(300651);
      s.u(paramString, "<set-?>");
      c.arC(paramString);
      AppMethodBeat.o(300651);
    }
    
    private static void arM(String paramString)
    {
      AppMethodBeat.i(300654);
      s.u(paramString, "<set-?>");
      c.arD(paramString);
      AppMethodBeat.o(300654);
    }
    
    public static int arN(String paramString)
    {
      AppMethodBeat.i(300680);
      int j = 0;
      int i = j;
      if (paramString != null) {
        switch (paramString.hashCode())
        {
        default: 
          i = j;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(300680);
        return i;
        i = j;
        if (paramString.equals("123"))
        {
          i = c.c.zHh.type;
          continue;
          i = j;
          if (paramString.equals("101"))
          {
            do
            {
              i = c.c.zHf.type;
              break;
              i = j;
              if (!paramString.equals("102")) {
                break;
              }
              i = c.c.zHg.type;
              break;
            } while (paramString.equals("999"));
            i = j;
          }
        }
      }
    }
    
    public static boolean arO(String paramString)
    {
      AppMethodBeat.i(300681);
      if ((s.p("999", paramString)) || (s.p("101", paramString)) || (s.p("102", paramString)) || (s.p("123", paramString)))
      {
        AppMethodBeat.o(300681);
        return true;
      }
      AppMethodBeat.o(300681);
      return false;
    }
    
    public static boolean arP(String paramString)
    {
      AppMethodBeat.i(300690);
      if (paramString == null)
      {
        AppMethodBeat.o(300690);
        return false;
      }
      boolean bool = s.p(paramString, c.dKK());
      AppMethodBeat.o(300690);
      return bool;
    }
    
    public static String arQ(String paramString)
    {
      AppMethodBeat.i(300692);
      if (paramString == null)
      {
        Log.i("HABBYGE-MALI.HellFinderConfig", "getSnsAdData finderUsername is null");
        AppMethodBeat.o(300692);
        return "";
      }
      if (s.p(c.dKK(), paramString))
      {
        paramString = c.dKJ();
        AppMethodBeat.o(300692);
        return paramString;
      }
      AppMethodBeat.o(300692);
      return "";
    }
    
    public static void b(Object paramObject, Map<String, i> paramMap)
    {
      AppMethodBeat.i(300664);
      s.u(paramMap, "feedMap");
      if (paramObject == null)
      {
        AppMethodBeat.o(300664);
        return;
      }
      c.dKw().put(Integer.valueOf(paramObject.hashCode()), paramMap);
      Map localMap = c.dKx();
      paramObject = paramObject.getClass().getName();
      s.s(paramObject, "page.javaClass.name");
      localMap.put(paramObject, paramMap);
      AppMethodBeat.o(300664);
    }
    
    public static void dKM()
    {
      AppMethodBeat.i(300659);
      arI("");
      arJ("");
      arK("");
      arL("");
      arM("");
      AppMethodBeat.o(300659);
    }
    
    public static void dKN()
    {
      AppMethodBeat.i(300671);
      Log.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.dKz().clear();
      dKO();
      AppMethodBeat.o(300671);
    }
    
    public static void dKO()
    {
      AppMethodBeat.i(300675);
      c.dKA().clear();
      c.dKB().clear();
      AppMethodBeat.o(300675);
    }
    
    public static void dKP()
    {
      AppMethodBeat.i(300696);
      c.arE("");
      c.arF("");
      hn("HABBYGE-MALI.HellFinderConfig", "resetSnsAdData!");
      AppMethodBeat.o(300696);
    }
    
    public static int dKk()
    {
      AppMethodBeat.i(300677);
      String str = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      if (arO(str))
      {
        int i = arN(str);
        AppMethodBeat.o(300677);
        return i;
      }
      AppMethodBeat.o(300677);
      return 0;
    }
    
    public static void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(300657);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      arI(str);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      arJ(paramString1);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      arK(paramString1);
      arL(paramString4);
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      arM(paramString1);
      AppMethodBeat.o(300657);
    }
    
    public static Map<String, i> fc(Object paramObject)
    {
      AppMethodBeat.i(300662);
      if (paramObject == null)
      {
        AppMethodBeat.o(300662);
        return null;
      }
      int i = paramObject.hashCode();
      Map localMap2 = (Map)c.dKw().get(Integer.valueOf(i));
      Map localMap1 = localMap2;
      if (localMap2 == null) {
        localMap1 = (Map)c.dKx().get(paramObject.getClass().getName());
      }
      AppMethodBeat.o(300662);
      return localMap1;
    }
    
    public static void fd(Object paramObject)
    {
      AppMethodBeat.i(300667);
      if (paramObject == null)
      {
        AppMethodBeat.o(300667);
        return;
      }
      c.dKw().remove(Integer.valueOf(paramObject.hashCode()));
      c.dKx().remove(paramObject.getClass().getName());
      AppMethodBeat.o(300667);
    }
    
    public static void hm(String paramString1, String paramString2)
    {
      AppMethodBeat.i(300688);
      if ((paramString1 == null) || (paramString2 == null))
      {
        c.arE("");
        c.arF("");
        hn("HABBYGE-MALI.HellFinderConfig", "setSnsAdData fail!");
        AppMethodBeat.o(300688);
        return;
      }
      c.arE(paramString1);
      c.arF(paramString2);
      hn("HABBYGE-MALI.HellFinderConfig", "setSnsAdData, snsAdData=" + c.dKJ() + ", snsFinderUsername=" + c.dKK());
      AppMethodBeat.o(300688);
    }
    
    private static void hn(String paramString1, String paramString2)
    {
      AppMethodBeat.i(300684);
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
      {
        Log.printInfoStack(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(300684);
        return;
      }
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(300684);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$ShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "SINGLE_CHAT", "GROUP_CHAT", "SNS", "JSAPI", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(300601);
      zHf = new c("SINGLE_CHAT", 0, 1);
      zHg = new c("GROUP_CHAT", 1, 2);
      zHh = new c("SNS", 2, 3);
      zHi = new c("JSAPI", 3, 4);
      zHj = new c[] { zHf, zHg, zHh, zHi };
      AppMethodBeat.o(300601);
    }
    
    private c(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(300622);
      zHt = new f("LBS", 0, 1000);
      zHu = new f("TOPIC", 1, 1001);
      zHv = new f("POI", 2, 1002);
      zHw = new f("SEARCH", 3, 1004);
      zHx = new f("OTHER_PROFILE", 4, 1006);
      zHy = new f("FAVORITE", 5, 1008);
      zHz = new f[] { zHt, zHu, zHv, zHw, zHx, zHy };
      AppMethodBeat.o(300622);
    }
    
    private f(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.c
 * JD-Core Version:    0.7.0.1
 */