package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "TopicType", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c
{
  public static boolean rdE;
  private static final Map<Integer, Map<String, i>> rdF;
  private static final Map<String, Map<String, i>> rdG;
  private static float rdH;
  private static final List<String> rdI;
  private static final List<String> rdJ;
  private static final List<String> rdK;
  private static final List<String> rdL;
  private static final List<String> rdM;
  private static final List<String> rdN;
  public static int rdO;
  public static String rdP;
  public static String rdQ;
  public static String rdR;
  private static final ArrayList<String> rdS;
  private static final ArrayList<String> rdT;
  private static final ArrayList<String> rdU;
  private static final ArrayList<String> rdV;
  private static int rdW;
  public static final a rdX;
  
  static
  {
    AppMethodBeat.i(196458);
    rdX = new a((byte)0);
    rdF = (Map)new LinkedHashMap();
    rdG = (Map)new LinkedHashMap();
    rdI = (List)new ArrayList();
    rdJ = (List)new ArrayList();
    rdK = (List)new ArrayList();
    rdL = (List)new ArrayList();
    rdM = (List)new ArrayList();
    rdN = (List)new ArrayList();
    rdO = -1;
    String str = b.qYO;
    p.g(str, "HellhoundUtil._sChattingUIFragment");
    rdS = j.ab(new String[] { str, "ChattingUI", "SnsTimeLineUI", "FavoriteIndexUI" });
    rdT = j.ab(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI" });
    rdU = j.ab(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI" });
    rdV = j.ab(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    rdW = c.rec.value;
    AppMethodBeat.o(196458);
  }
  
  public static final boolean afb(String paramString)
  {
    AppMethodBeat.i(196459);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(196459);
          return true;
        }
        AppMethodBeat.o(196459);
        return false;
      }
      if ((p.i("FinderFollowTabFragment", paramString)) || (p.i("FinderFriendTabFragment", paramString)) || (p.i("FinderLbsTabFragment", paramString)) || (p.i("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(196459);
        return true;
      }
    }
    AppMethodBeat.o(196459);
    return false;
  }
  
  public static final void d(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(196460);
    if (p.i(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
      if (paramIntent == null) {
        break label64;
      }
    }
    label64:
    for (int i = paramIntent.getIntExtra("key_topic_type", c.rec.value);; i = c.rec.value)
    {
      rdW = i;
      ae.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + rdW);
      AppMethodBeat.o(196460);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "PRE_PAGE_LIST", "getPRE_PAGE_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderSelfUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_SnsTimelineUI", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderSelfUI", "_sFinderTopicFeedUI", "_sSnsTimelineUI", "gActivityActionLatest", "gEnterFinderBySnsCamera", "", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "isFinderHomeUI", "pageName", "isFinderHomeUIFragment", "fragmentName", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "restoreFeedIdOnRefreshEnd", "setTopicType", "intent", "Landroid/content/Intent;", "plugin-expt_release"})
  public static final class a
  {
    public static void cqE()
    {
      AppMethodBeat.i(196447);
      ae.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.cqu().clear();
      cqF();
      AppMethodBeat.o(196447);
    }
    
    public static void cqF()
    {
      AppMethodBeat.i(196448);
      c.cqv().clear();
      c.cqw().clear();
      AppMethodBeat.o(196448);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(196449);
      b localb1 = new b("EXPOSURE", 0, 0);
      rdY = localb1;
      b localb2 = new b("INOUT", 1, 1);
      rdZ = localb2;
      b localb3 = new b("INOUT_WITHOUT_78EVENT", 2, 2);
      rea = localb3;
      reb = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(196449);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$TopicType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Words", "Poi", "plugin-expt_release"})
  public static enum c
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(196452);
      c localc1 = new c("Words", 0, 1);
      rec = localc1;
      c localc2 = new c("Poi", 1, 2);
      red = localc2;
      ree = new c[] { localc1, localc2 };
      AppMethodBeat.o(196452);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
  public static enum d
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(196455);
      d locald1 = new d("LBS", 0, 1000);
      reg = locald1;
      d locald2 = new d("TOPIC", 1, 1001);
      reh = locald2;
      d locald3 = new d("POI", 2, 1002);
      rei = locald3;
      d locald4 = new d("SEARCH", 3, 1004);
      rej = locald4;
      d locald5 = new d("OTHER_PROFILE", 4, 1006);
      rek = locald5;
      d locald6 = new d("FAVORITE", 5, 1008);
      rel = locald6;
      rem = new d[] { locald1, locald2, locald3, locald4, locald5, locald6 };
      AppMethodBeat.o(196455);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */