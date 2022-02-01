package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "TopicType", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c
{
  private static final Map<Integer, Map<String, i>> qVG;
  private static final Map<String, Map<String, i>> qVH;
  private static float qVI;
  private static final List<String> qVJ;
  private static final List<String> qVK;
  private static final List<String> qVL;
  private static final List<String> qVM;
  private static final List<String> qVN;
  private static final List<String> qVO;
  public static int qVP;
  public static String qVQ;
  public static String qVR;
  public static String qVS;
  private static final ArrayList<String> qVT;
  private static final ArrayList<String> qVU;
  private static final ArrayList<String> qVV;
  private static final ArrayList<String> qVW;
  private static int qVX;
  public static final a qVY;
  
  static
  {
    AppMethodBeat.i(210791);
    qVY = new a((byte)0);
    qVG = (Map)new LinkedHashMap();
    qVH = (Map)new LinkedHashMap();
    qVJ = (List)new ArrayList();
    qVK = (List)new ArrayList();
    qVL = (List)new ArrayList();
    qVM = (List)new ArrayList();
    qVN = (List)new ArrayList();
    qVO = (List)new ArrayList();
    qVP = -1;
    String str = b.qQQ;
    p.g(str, "HellhoundUtil._sChattingUIFragment");
    qVT = j.ac(new String[] { str, "ChattingUI", "SnsTimeLineUI", "FavoriteIndexUI" });
    qVU = j.ac(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI" });
    qVV = j.ac(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI" });
    qVW = j.ac(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    qVX = c.c.qWd.value;
    AppMethodBeat.o(210791);
  }
  
  public static final boolean aeh(String paramString)
  {
    AppMethodBeat.i(210792);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(210792);
          return true;
        }
        AppMethodBeat.o(210792);
        return false;
      }
      if ((p.i("FinderFollowTabFragment", paramString)) || (p.i("FinderFriendTabFragment", paramString)) || (p.i("FinderLbsTabFragment", paramString)) || (p.i("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(210792);
        return true;
      }
    }
    AppMethodBeat.o(210792);
    return false;
  }
  
  public static final void d(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(210793);
    if (p.i(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
      if (paramIntent == null) {
        break label64;
      }
    }
    label64:
    for (int i = paramIntent.getIntExtra("key_topic_type", c.c.qWd.value);; i = c.c.qWd.value)
    {
      qVX = i;
      ad.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + qVX);
      AppMethodBeat.o(210793);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "PRE_PAGE_LIST", "getPRE_PAGE_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderTopicFeedUI", "gActivityActionLatest", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "isFinderHomeUI", "", "pageName", "isFinderHomeUIFragment", "fragmentName", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "restoreFeedIdOnRefreshEnd", "setTopicType", "intent", "Landroid/content/Intent;", "plugin-expt_release"})
  public static final class a
  {
    public static void cpc()
    {
      AppMethodBeat.i(210780);
      ad.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.coS().clear();
      cpd();
      AppMethodBeat.o(210780);
    }
    
    public static void cpd()
    {
      AppMethodBeat.i(210781);
      c.coT().clear();
      c.coU().clear();
      AppMethodBeat.o(210781);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(210782);
      b localb1 = new b("EXPOSURE", 0, 0);
      qVZ = localb1;
      b localb2 = new b("INOUT", 1, 1);
      qWa = localb2;
      b localb3 = new b("INOUT_WITHOUT_78EVENT", 2, 2);
      qWb = localb3;
      qWc = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(210782);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
  public static enum d
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(210788);
      d locald1 = new d("LBS", 0, 1000);
      qWg = locald1;
      d locald2 = new d("TOPIC", 1, 1001);
      qWh = locald2;
      d locald3 = new d("POI", 2, 1002);
      qWi = locald3;
      d locald4 = new d("SEARCH", 3, 1004);
      qWj = locald4;
      d locald5 = new d("OTHER_PROFILE", 4, 1006);
      qWk = locald5;
      d locald6 = new d("FAVORITE", 5, 1008);
      qWl = locald6;
      qWm = new d[] { locald1, locald2, locald3, locald4, locald5, locald6 };
      AppMethodBeat.o(210788);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */