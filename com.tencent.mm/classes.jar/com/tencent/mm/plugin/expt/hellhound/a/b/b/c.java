package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "ShareType", "TopicType", "VisiableState", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c
{
  private static boolean kGE;
  private static String wkA;
  private static String wkB;
  private static String wkC;
  private static float wkD;
  private static final List<String> wkE;
  private static final List<String> wkF;
  private static final List<String> wkG;
  private static final List<String> wkH;
  private static final List<String> wkI;
  private static final List<String> wkJ;
  public static int wkK;
  public static String wkL;
  public static String wkM;
  public static String wkN;
  private static final ArrayList<String> wkO;
  private static final ArrayList<String> wkP;
  private static final ArrayList<String> wkQ;
  private static final ArrayList<String> wkR;
  private static int wkS;
  private static String wkT;
  private static String wkU;
  public static final a wkV;
  private static boolean wkf;
  public static boolean wkg;
  private static final Map<Integer, Map<String, i>> wkh;
  private static final Map<String, Map<String, i>> wki;
  private static String wkj;
  private static int wkk;
  public static String wkl;
  public static String wkm;
  public static String wkn;
  public static boolean wko;
  private static boolean wkp;
  private static boolean wkq;
  public static String wkr;
  public static long wks;
  public static String wkt;
  private static String wku;
  public static int wkv;
  private static String wkw;
  private static boolean wkx;
  private static String wky;
  private static String wkz;
  
  static
  {
    AppMethodBeat.i(250777);
    wkV = new a((byte)0);
    wkh = (Map)new LinkedHashMap();
    wki = (Map)new LinkedHashMap();
    wkl = "";
    wkm = "";
    wkn = "";
    wkp = true;
    wkq = true;
    wkr = "";
    wkt = "";
    wku = "";
    wkv = 1001;
    wkw = "";
    wky = "";
    wkz = "";
    wkA = "";
    wkB = "";
    wkC = "";
    wkE = (List)new ArrayList();
    wkF = (List)new ArrayList();
    wkG = (List)new ArrayList();
    wkH = (List)new ArrayList();
    wkI = (List)new ArrayList();
    wkJ = (List)new ArrayList();
    wkK = -1;
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.wfb;
    p.j(str, "HellhoundUtil._sChattingUIFragment");
    wkO = j.ag(new String[] { str, "ChattingUI", "SnsTimeLineUI", "FavoriteIndexUI" });
    wkP = j.ag(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI" });
    wkQ = j.ag(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2" });
    wkR = j.ag(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    wkS = d.wlf.value;
    wkT = "";
    wkU = "";
    AppMethodBeat.o(250777);
  }
  
  public static final boolean axB(String paramString)
  {
    AppMethodBeat.i(250800);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(250800);
          return true;
        }
        AppMethodBeat.o(250800);
        return false;
      }
      if ((p.h("FinderFollowTabFragment", paramString)) || (p.h("FinderFriendTabFragment", paramString)) || (p.h("FinderLbsTabFragment", paramString)) || (p.h("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(250800);
        return true;
      }
    }
    AppMethodBeat.o(250800);
    return false;
  }
  
  public static final void d(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(250801);
    if (p.h(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
      if (paramIntent == null) {
        break label69;
      }
    }
    label69:
    for (int i = paramIntent.getIntExtra("key_topic_type", d.wlf.value);; i = d.wlf.value)
    {
      wkS = i;
      Log.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + wkS);
      AppMethodBeat.o(250801);
      return;
    }
  }
  
  public static final int deb()
  {
    AppMethodBeat.i(250802);
    int i = a.deb();
    AppMethodBeat.o(250802);
    return i;
  }
  
  public static final void gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250803);
    a.gF(paramString1, paramString2);
    AppMethodBeat.o(250803);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "PRE_PAGE_LIST", "getPRE_PAGE_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_BulletSubtitleViewCallback_Header", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderSelfUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_SnsTimelineUI", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderSelfUI", "_sFinderTopicFeedUI", "_sSnsTimelineUI", "actionMs", "", "clickMoreLiveBtn", "", "getClickMoreLiveBtn", "()Z", "setClickMoreLiveBtn", "(Z)V", "curClickId", "getCurClickId", "()Ljava/lang/String;", "setCurClickId", "(Ljava/lang/String;)V", "curFinderUserName", "getCurFinderUserName", "setCurFinderUserName", "curNearbyFragmentType", "enterSessionId", "gActivityActionLatest", "gCurFinderHomePage", "gCurIsPoiScene", "getGCurIsPoiScene", "setGCurIsPoiScene", "gCurIsShareScene", "getGCurIsShareScene", "setGCurIsShareScene", "gCurShareUserName", "gCurSnsFeedId", "gCurSnsSessionId", "gEnterFinderBySnsCamera", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gLastVisible", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "giftPanelShow", "getGiftPanelShow", "setGiftPanelShow", "identityType", "getIdentityType", "setIdentityType", "isLiving", "requestShareStateUserName", "getRequestShareStateUserName", "setRequestShareStateUserName", "shareStateCount", "getShareStateCount", "setShareStateCount", "snsAdData", "snsFinderUsername", "visitorAppId", "getVisitorAppId", "setVisitorAppId", "visitorClickId", "getVisitorClickId", "setVisitorClickId", "visitorLiveid", "getVisitorLiveid", "setVisitorLiveid", "visitorSessionid", "getVisitorSessionid", "setVisitorSessionid", "visitorShopwindowid", "getVisitorShopwindowid", "setVisitorShopwindowid", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "getShareType", "sid", "getSnsAdData", "finderUsername", "inLiveRoom", "isFinderHomeUI", "pageName", "isFinderHomeUIFragment", "fragmentName", "isSameFinderUserName", "isShare", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "resetSnsAdData", "resetVisitorCommerceParams", "restoreFeedIdOnRefreshEnd", "setInLiveRoom", "inRoom", "setSnsAdData", "snsAdInfo", "setTopicType", "intent", "Landroid/content/Intent;", "setVisitorCommerceParams", "clickId", "appId", "liveId", "shopwindowId", "sessionid", "plugin-expt_release"})
  public static final class a
  {
    public static void axC(String paramString)
    {
      AppMethodBeat.i(251529);
      p.k(paramString, "<set-?>");
      c.axs(paramString);
      AppMethodBeat.o(251529);
    }
    
    public static void axD(String paramString)
    {
      AppMethodBeat.i(251531);
      p.k(paramString, "<set-?>");
      c.axt(paramString);
      AppMethodBeat.o(251531);
    }
    
    private static void axE(String paramString)
    {
      AppMethodBeat.i(251533);
      p.k(paramString, "<set-?>");
      c.axu(paramString);
      AppMethodBeat.o(251533);
    }
    
    private static void axF(String paramString)
    {
      AppMethodBeat.i(251535);
      p.k(paramString, "<set-?>");
      c.axv(paramString);
      AppMethodBeat.o(251535);
    }
    
    private static void axG(String paramString)
    {
      AppMethodBeat.i(251536);
      p.k(paramString, "<set-?>");
      c.axw(paramString);
      AppMethodBeat.o(251536);
    }
    
    private static void axH(String paramString)
    {
      AppMethodBeat.i(251537);
      p.k(paramString, "<set-?>");
      c.axx(paramString);
      AppMethodBeat.o(251537);
    }
    
    private static void axI(String paramString)
    {
      AppMethodBeat.i(251538);
      p.k(paramString, "<set-?>");
      c.axy(paramString);
      AppMethodBeat.o(251538);
    }
    
    public static int axJ(String paramString)
    {
      AppMethodBeat.i(251547);
      int i = 0;
      if (paramString == null) {}
      do
      {
        for (;;)
        {
          AppMethodBeat.o(251547);
          return i;
          switch (paramString.hashCode())
          {
          }
        }
      } while (!paramString.equals("101"));
      for (;;)
      {
        i = c.c.wla.type;
        break;
        if (!paramString.equals("123")) {
          break;
        }
        i = c.c.wlc.type;
        break;
        if (!paramString.equals("102")) {
          break;
        }
        i = c.c.wlb.type;
        break;
        if (!paramString.equals("999")) {
          break;
        }
      }
    }
    
    public static boolean axK(String paramString)
    {
      AppMethodBeat.i(251548);
      if ((p.h("999", paramString)) || (p.h("101", paramString)) || (p.h("102", paramString)) || (p.h("123", paramString)))
      {
        AppMethodBeat.o(251548);
        return true;
      }
      AppMethodBeat.o(251548);
      return false;
    }
    
    public static boolean axL(String paramString)
    {
      AppMethodBeat.i(251550);
      if (paramString == null)
      {
        AppMethodBeat.o(251550);
        return false;
      }
      boolean bool = p.h(paramString, c.dea());
      AppMethodBeat.o(251550);
      return bool;
    }
    
    public static String axM(String paramString)
    {
      AppMethodBeat.i(251551);
      if (paramString == null)
      {
        AppMethodBeat.o(251551);
        return "";
      }
      if (p.h(c.dea(), paramString))
      {
        paramString = c.ddZ();
        AppMethodBeat.o(251551);
        return paramString;
      }
      AppMethodBeat.o(251551);
      return "";
    }
    
    public static int deb()
    {
      AppMethodBeat.i(251545);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      p.j(localObject, "HellSessionMonitor.getInstance()");
      localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).deK();
      if (axK((String)localObject))
      {
        int i = axJ((String)localObject);
        AppMethodBeat.o(251545);
        return i;
      }
      AppMethodBeat.o(251545);
      return 0;
    }
    
    public static void dec()
    {
      AppMethodBeat.i(251542);
      axE("");
      axF("");
      axG("");
      axH("");
      axI("");
      AppMethodBeat.o(251542);
    }
    
    public static void ded()
    {
      AppMethodBeat.i(251543);
      Log.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.ddP().clear();
      dee();
      AppMethodBeat.o(251543);
    }
    
    public static void dee()
    {
      AppMethodBeat.i(251544);
      c.ddQ().clear();
      c.ddR().clear();
      AppMethodBeat.o(251544);
    }
    
    public static void def()
    {
      AppMethodBeat.i(251552);
      c.axz("");
      c.axA("");
      AppMethodBeat.o(251552);
    }
    
    public static void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(251540);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      axE(str);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      axF(paramString1);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      axG(paramString1);
      axH(paramString4);
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      axI(paramString1);
      AppMethodBeat.o(251540);
    }
    
    public static void gF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(251549);
      if ((paramString1 == null) || (paramString2 == null))
      {
        c.axz("");
        c.axA("");
        AppMethodBeat.o(251549);
        return;
      }
      c.axz(paramString1);
      c.axA(paramString2);
      Log.i("HABBYGE-MALI.HellFinderConfig", "setSnsAdData, snsAdData=" + c.ddZ() + ", snsFinderUsername=" + c.dea());
      AppMethodBeat.o(251549);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(252518);
      b localb1 = new b("EXPOSURE", 0, 0);
      wkW = localb1;
      b localb2 = new b("INOUT", 1, 1);
      wkX = localb2;
      b localb3 = new b("INOUT_WITHOUT_78EVENT", 2, 2);
      wkY = localb3;
      wkZ = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(252518);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$TopicType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Words", "Poi", "plugin-expt_release"})
  public static enum d
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(251250);
      d locald1 = new d("Words", 0, 1);
      wlf = locald1;
      d locald2 = new d("Poi", 1, 2);
      wlg = locald2;
      wlh = new d[] { locald1, locald2 };
      AppMethodBeat.o(251250);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
  public static enum f
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(253381);
      f localf1 = new f("LBS", 0, 1000);
      wlo = localf1;
      f localf2 = new f("TOPIC", 1, 1001);
      wlp = localf2;
      f localf3 = new f("POI", 2, 1002);
      wlq = localf3;
      f localf4 = new f("SEARCH", 3, 1004);
      wlr = localf4;
      f localf5 = new f("OTHER_PROFILE", 4, 1006);
      wls = localf5;
      f localf6 = new f("FAVORITE", 5, 1008);
      wlt = localf6;
      wlu = new f[] { localf1, localf2, localf3, localf4, localf5, localf6 };
      AppMethodBeat.o(253381);
    }
    
    private f(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */