package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "TopicType", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c
{
  private static final Map<Integer, Map<String, i>> qmJ;
  private static final Map<String, Map<String, i>> qmK;
  private static float qmL;
  private static final List<String> qmM;
  private static final List<String> qmN;
  private static final List<String> qmO;
  private static final List<String> qmP;
  private static final List<String> qmQ;
  private static final List<String> qmR;
  public static int qmS;
  public static String qmT;
  public static String qmU;
  public static String qmV;
  private static final ArrayList<String> qmW;
  private static final ArrayList<String> qmX;
  private static final ArrayList<String> qmY;
  private static int qmZ;
  public static final a qna;
  
  static
  {
    AppMethodBeat.i(195444);
    qna = new a((byte)0);
    qmJ = (Map)new LinkedHashMap();
    qmK = (Map)new LinkedHashMap();
    qmM = (List)new ArrayList();
    qmN = (List)new ArrayList();
    qmO = (List)new ArrayList();
    qmP = (List)new ArrayList();
    qmQ = (List)new ArrayList();
    qmR = (List)new ArrayList();
    qmS = -1;
    qmW = j.ab(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI" });
    qmX = j.ab(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI" });
    qmY = j.ab(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    qmZ = c.c.qnf.value;
    AppMethodBeat.o(195444);
  }
  
  public static final boolean aat(String paramString)
  {
    AppMethodBeat.i(195445);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(195445);
          return true;
        }
        AppMethodBeat.o(195445);
        return false;
      }
      if ((k.g("FinderFollowTabFragment", paramString)) || (k.g("FinderFriendTabFragment", paramString)) || (k.g("FinderLbsTabFragment", paramString)) || (k.g("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(195445);
        return true;
      }
    }
    AppMethodBeat.o(195445);
    return false;
  }
  
  public static final void d(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(195446);
    if (k.g(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
      if (paramIntent == null) {
        break label64;
      }
    }
    label64:
    for (int i = paramIntent.getIntExtra("key_topic_type", c.c.qnf.value);; i = c.c.qnf.value)
    {
      qmZ = i;
      ac.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + qmZ);
      AppMethodBeat.o(195446);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderTopicFeedUI", "gActivityActionLatest", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "isFinderHomeUIFragment", "", "fragmentName", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "restoreFeedIdOnRefreshEnd", "setTopicType", "pageName", "intent", "Landroid/content/Intent;", "plugin-expt_release"})
  public static final class a
  {
    public static void cjR()
    {
      AppMethodBeat.i(195433);
      ac.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.cjH().clear();
      cjS();
      AppMethodBeat.o(195433);
    }
    
    public static void cjS()
    {
      AppMethodBeat.i(195434);
      c.cjI().clear();
      c.cjJ().clear();
      AppMethodBeat.o(195434);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(195435);
      b localb1 = new b("EXPOSURE", 0, 0);
      qnb = localb1;
      b localb2 = new b("INOUT", 1, 1);
      qnc = localb2;
      b localb3 = new b("INOUT_WITHOUT_78EVENT", 2, 2);
      qnd = localb3;
      qne = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(195435);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
  public static enum d
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(195441);
      d locald1 = new d("LBS", 0, 1000);
      qni = locald1;
      d locald2 = new d("TOPIC", 1, 1001);
      qnj = locald2;
      d locald3 = new d("POI", 2, 1002);
      qnk = locald3;
      d locald4 = new d("SEARCH", 3, 1004);
      qnl = locald4;
      d locald5 = new d("OTHER_PROFILE", 4, 1006);
      qnm = locald5;
      d locald6 = new d("FAVORITE", 5, 1008);
      qnn = locald6;
      qno = new d[] { locald1, locald2, locald3, locald4, locald5, locald6 };
      AppMethodBeat.o(195441);
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