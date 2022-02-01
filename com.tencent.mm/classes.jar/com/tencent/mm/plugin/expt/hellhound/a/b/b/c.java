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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "ShareType", "TopicType", "VisiableState", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c
{
  private static boolean hSh;
  public static int sEA;
  private static String sEB;
  private static boolean sEC;
  private static String sED;
  private static String sEE;
  private static String sEF;
  private static String sEG;
  private static String sEH;
  private static float sEI;
  private static final List<String> sEJ;
  private static final List<String> sEK;
  private static final List<String> sEL;
  private static final List<String> sEM;
  private static final List<String> sEN;
  private static final List<String> sEO;
  public static int sEP;
  public static String sEQ;
  public static String sER;
  public static String sES;
  private static final ArrayList<String> sET;
  private static final ArrayList<String> sEU;
  private static final ArrayList<String> sEV;
  private static final ArrayList<String> sEW;
  private static int sEX;
  private static String sEY;
  private static String sEZ;
  public static boolean sEl;
  private static final Map<Integer, Map<String, i>> sEm;
  private static final Map<String, Map<String, i>> sEn;
  private static String sEo;
  private static int sEp;
  public static String sEq;
  public static String sEr;
  public static String sEs;
  public static boolean sEt;
  private static boolean sEu;
  private static boolean sEv;
  public static String sEw;
  public static long sEx;
  public static String sEy;
  private static String sEz;
  public static final a sFa;
  
  static
  {
    AppMethodBeat.i(220943);
    sFa = new a((byte)0);
    sEm = (Map)new LinkedHashMap();
    sEn = (Map)new LinkedHashMap();
    sEq = "";
    sEr = "";
    sEs = "";
    sEu = true;
    sEv = true;
    sEw = "";
    sEy = "";
    sEz = "";
    sEA = 1001;
    sEB = "";
    sED = "";
    sEE = "";
    sEF = "";
    sEG = "";
    sEH = "";
    sEJ = (List)new ArrayList();
    sEK = (List)new ArrayList();
    sEL = (List)new ArrayList();
    sEM = (List)new ArrayList();
    sEN = (List)new ArrayList();
    sEO = (List)new ArrayList();
    sEP = -1;
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.szf;
    p.g(str, "HellhoundUtil._sChattingUIFragment");
    sET = j.ac(new String[] { str, "ChattingUI", "SnsTimeLineUI", "FavoriteIndexUI" });
    sEU = j.ac(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI" });
    sEV = j.ac(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2" });
    sEW = j.ac(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    sEX = d.sFk.value;
    sEY = "";
    sEZ = "";
    AppMethodBeat.o(220943);
  }
  
  public static final boolean apB(String paramString)
  {
    AppMethodBeat.i(220944);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(220944);
          return true;
        }
        AppMethodBeat.o(220944);
        return false;
      }
      if ((p.j("FinderFollowTabFragment", paramString)) || (p.j("FinderFriendTabFragment", paramString)) || (p.j("FinderLbsTabFragment", paramString)) || (p.j("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(220944);
        return true;
      }
    }
    AppMethodBeat.o(220944);
    return false;
  }
  
  public static final int cPi()
  {
    AppMethodBeat.i(220946);
    int i = a.cPi();
    AppMethodBeat.o(220946);
    return i;
  }
  
  public static final void d(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(220945);
    if (p.j(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
      if (paramIntent == null) {
        break label69;
      }
    }
    label69:
    for (int i = paramIntent.getIntExtra("key_topic_type", d.sFk.value);; i = d.sFk.value)
    {
      sEX = i;
      Log.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + sEX);
      AppMethodBeat.o(220945);
      return;
    }
  }
  
  public static final void gr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220947);
    if ((paramString1 == null) || (paramString2 == null))
    {
      sEY = "";
      sEZ = "";
      AppMethodBeat.o(220947);
      return;
    }
    sEY = paramString1;
    sEZ = paramString2;
    Log.i("HABBYGE-MALI.HellFinderConfig", "setSnsAdData, snsAdData=" + sEY + ", snsFinderUsername=" + sEZ);
    AppMethodBeat.o(220947);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "PRE_PAGE_LIST", "getPRE_PAGE_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_BulletSubtitleViewCallback_Header", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderSelfUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_SnsTimelineUI", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderSelfUI", "_sFinderTopicFeedUI", "_sSnsTimelineUI", "actionMs", "", "curClickId", "getCurClickId", "()Ljava/lang/String;", "setCurClickId", "(Ljava/lang/String;)V", "curFinderUserName", "getCurFinderUserName", "setCurFinderUserName", "curNearbyFragmentType", "enterSessionId", "gActivityActionLatest", "gCurFinderHomePage", "gCurIsPoiScene", "", "getGCurIsPoiScene", "()Z", "setGCurIsPoiScene", "(Z)V", "gCurIsShareScene", "getGCurIsShareScene", "setGCurIsShareScene", "gCurShareUserName", "gCurSnsFeedId", "gCurSnsSessionId", "gEnterFinderBySnsCamera", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gLastVisible", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "giftPanelShow", "getGiftPanelShow", "setGiftPanelShow", "isLiving", "requestShareStateUserName", "getRequestShareStateUserName", "setRequestShareStateUserName", "shareStateCount", "getShareStateCount", "setShareStateCount", "snsAdData", "snsFinderUsername", "visitorAppId", "getVisitorAppId", "setVisitorAppId", "visitorClickId", "getVisitorClickId", "setVisitorClickId", "visitorLiveid", "getVisitorLiveid", "setVisitorLiveid", "visitorSessionid", "getVisitorSessionid", "setVisitorSessionid", "visitorShopwindowid", "getVisitorShopwindowid", "setVisitorShopwindowid", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "getShareType", "sid", "getSnsAdData", "finderUsername", "inLiveRoom", "isFinderHomeUI", "pageName", "isFinderHomeUIFragment", "fragmentName", "isSameFinderUserName", "isShare", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "resetSnsAdData", "resetVisitorCommerceParams", "restoreFeedIdOnRefreshEnd", "setInLiveRoom", "inRoom", "setSnsAdData", "snsAdInfo", "setTopicType", "intent", "Landroid/content/Intent;", "setVisitorCommerceParams", "clickId", "appId", "liveId", "shopwindowId", "sessionid", "plugin-expt_release"})
  public static final class a
  {
    public static void apC(String paramString)
    {
      AppMethodBeat.i(220912);
      p.h(paramString, "<set-?>");
      c.aps(paramString);
      AppMethodBeat.o(220912);
    }
    
    public static void apD(String paramString)
    {
      AppMethodBeat.i(220913);
      p.h(paramString, "<set-?>");
      c.apt(paramString);
      AppMethodBeat.o(220913);
    }
    
    public static void apE(String paramString)
    {
      AppMethodBeat.i(220914);
      p.h(paramString, "<set-?>");
      c.apu(paramString);
      AppMethodBeat.o(220914);
    }
    
    public static void apF(String paramString)
    {
      AppMethodBeat.i(220915);
      p.h(paramString, "<set-?>");
      c.apv(paramString);
      AppMethodBeat.o(220915);
    }
    
    public static void apG(String paramString)
    {
      AppMethodBeat.i(220916);
      p.h(paramString, "<set-?>");
      c.apw(paramString);
      AppMethodBeat.o(220916);
    }
    
    public static void apH(String paramString)
    {
      AppMethodBeat.i(220917);
      p.h(paramString, "<set-?>");
      c.apx(paramString);
      AppMethodBeat.o(220917);
    }
    
    public static void apI(String paramString)
    {
      AppMethodBeat.i(220918);
      p.h(paramString, "<set-?>");
      c.apy(paramString);
      AppMethodBeat.o(220918);
    }
    
    public static int apJ(String paramString)
    {
      AppMethodBeat.i(220923);
      int i = 0;
      if (paramString == null) {}
      do
      {
        for (;;)
        {
          AppMethodBeat.o(220923);
          return i;
          switch (paramString.hashCode())
          {
          }
        }
      } while (!paramString.equals("101"));
      for (;;)
      {
        i = c.c.sFf.type;
        break;
        if (!paramString.equals("123")) {
          break;
        }
        i = c.c.sFh.type;
        break;
        if (!paramString.equals("102")) {
          break;
        }
        i = c.c.sFg.type;
        break;
        if (!paramString.equals("999")) {
          break;
        }
      }
    }
    
    public static boolean apK(String paramString)
    {
      AppMethodBeat.i(220924);
      if ((p.j("999", paramString)) || (p.j("101", paramString)) || (p.j("102", paramString)) || (p.j("123", paramString)))
      {
        AppMethodBeat.o(220924);
        return true;
      }
      AppMethodBeat.o(220924);
      return false;
    }
    
    public static boolean apL(String paramString)
    {
      AppMethodBeat.i(220925);
      if (paramString == null)
      {
        AppMethodBeat.o(220925);
        return false;
      }
      boolean bool = p.j(paramString, c.cPh());
      AppMethodBeat.o(220925);
      return bool;
    }
    
    public static String apM(String paramString)
    {
      AppMethodBeat.i(220926);
      if (paramString == null)
      {
        AppMethodBeat.o(220926);
        return "";
      }
      if (p.j(c.cPh(), paramString))
      {
        paramString = c.cPg();
        AppMethodBeat.o(220926);
        return paramString;
      }
      AppMethodBeat.o(220926);
      return "";
    }
    
    public static int cPi()
    {
      AppMethodBeat.i(220922);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
      p.g(localObject, "HellSessionMonitor.getInstance()");
      localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).cPQ();
      if (apK((String)localObject))
      {
        int i = apJ((String)localObject);
        AppMethodBeat.o(220922);
        return i;
      }
      AppMethodBeat.o(220922);
      return 0;
    }
    
    public static void cPj()
    {
      AppMethodBeat.i(220920);
      Log.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.cOW().clear();
      cPk();
      AppMethodBeat.o(220920);
    }
    
    public static void cPk()
    {
      AppMethodBeat.i(220921);
      c.cOX().clear();
      c.cOY().clear();
      AppMethodBeat.o(220921);
    }
    
    public static void cPl()
    {
      AppMethodBeat.i(220927);
      c.apz("");
      c.apA("");
      AppMethodBeat.o(220927);
    }
    
    public static void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(220919);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      apE(str);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      apF(paramString1);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      apG(paramString1);
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      apH(paramString1);
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      apI(paramString1);
      AppMethodBeat.o(220919);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$ShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "SINGLE_CHAT", "GROUP_CHAT", "SNS", "JSAPI", "plugin-expt_release"})
  public static enum c
  {
    final int type;
    
    static
    {
      AppMethodBeat.i(220931);
      c localc1 = new c("SINGLE_CHAT", 0, 1);
      sFf = localc1;
      c localc2 = new c("GROUP_CHAT", 1, 2);
      sFg = localc2;
      c localc3 = new c("SNS", 2, 3);
      sFh = localc3;
      c localc4 = new c("JSAPI", 3, 4);
      sFi = localc4;
      sFj = new c[] { localc1, localc2, localc3, localc4 };
      AppMethodBeat.o(220931);
    }
    
    private c(int paramInt)
    {
      this.type = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$TopicType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Words", "Poi", "plugin-expt_release"})
  public static enum d
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(220934);
      d locald1 = new d("Words", 0, 1);
      sFk = locald1;
      d locald2 = new d("Poi", 1, 2);
      sFl = locald2;
      sFm = new d[] { locald1, locald2 };
      AppMethodBeat.o(220934);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "VISIABLE_ON_SCROLL", "INVISIABLE_ON_SCROLL", "VISIABLE_ON_RESUME", "INVISIABLE_ON_PAUSE", "EVENT_ON_DESTROY", "plugin-expt_release"})
  public static enum e
  {
    public final int state;
    
    static
    {
      AppMethodBeat.i(220937);
      e locale1 = new e("VISIABLE_ON_SCROLL", 0, 0);
      sFn = locale1;
      e locale2 = new e("INVISIABLE_ON_SCROLL", 1, 1);
      sFo = locale2;
      e locale3 = new e("VISIABLE_ON_RESUME", 2, 2);
      sFp = locale3;
      e locale4 = new e("INVISIABLE_ON_PAUSE", 3, 3);
      sFq = locale4;
      e locale5 = new e("EVENT_ON_DESTROY", 4, 4);
      sFr = locale5;
      sFs = new e[] { locale1, locale2, locale3, locale4, locale5 };
      AppMethodBeat.o(220937);
    }
    
    private e(int paramInt)
    {
      this.state = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */