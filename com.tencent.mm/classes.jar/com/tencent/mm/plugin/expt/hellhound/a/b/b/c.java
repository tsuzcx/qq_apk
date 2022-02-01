package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "TopicType", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c
{
  private static final List<String> KGA;
  private static final List<String> KGB;
  private static final List<String> KGC;
  private static final List<String> KGD;
  public static int KGE;
  public static String KGF;
  public static String KGG;
  public static String KGH;
  private static final ArrayList<String> KGI;
  private static final ArrayList<String> KGJ;
  private static final ArrayList<String> KGK;
  private static int KGL;
  public static final a KGM;
  private static final Map<Integer, Map<String, i>> KGv;
  private static final Map<String, Map<String, i>> KGw;
  private static float KGx;
  private static final List<String> KGy;
  private static final List<String> KGz;
  
  static
  {
    AppMethodBeat.i(205185);
    KGM = new a((byte)0);
    KGv = (Map)new LinkedHashMap();
    KGw = (Map)new LinkedHashMap();
    KGy = (List)new ArrayList();
    KGz = (List)new ArrayList();
    KGA = (List)new ArrayList();
    KGB = (List)new ArrayList();
    KGC = (List)new ArrayList();
    KGD = (List)new ArrayList();
    KGE = -1;
    KGI = j.Z(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI" });
    KGJ = j.Z(new String[] { "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI" });
    KGK = j.Z(new String[] { "com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI" });
    KGL = c.KGR.value;
    AppMethodBeat.o(205185);
  }
  
  public static final boolean aUV(String paramString)
  {
    AppMethodBeat.i(205186);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if ((k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
        {
          AppMethodBeat.o(205186);
          return true;
        }
        AppMethodBeat.o(205186);
        return false;
      }
      if ((k.g("FinderFollowTabFragment", paramString)) || (k.g("FinderFriendTabFragment", paramString)) || (k.g("FinderLbsTabFragment", paramString)) || (k.g("FinderMachineTabFragment", paramString)))
      {
        AppMethodBeat.o(205186);
        return true;
      }
    }
    AppMethodBeat.o(205186);
    return false;
  }
  
  public static final void e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(205187);
    if (k.g(paramString, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
      if (paramIntent == null) {
        break label64;
      }
    }
    label64:
    for (int i = paramIntent.getIntExtra("key_topic_type", c.KGR.value);; i = c.KGR.value)
    {
      KGL = i;
      ad.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + KGL);
      AppMethodBeat.o(205187);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderShareFeedDetailUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderTopicFeedUI", "gActivityActionLatest", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "isFinderHomeUIFragment", "", "fragmentName", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "restoreFeedIdOnRefreshEnd", "setTopicType", "pageName", "intent", "Landroid/content/Intent;", "plugin-expt_release"})
  public static final class a
  {
    public static void fRK()
    {
      AppMethodBeat.i(205174);
      ad.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
      c.fRA().clear();
      fRL();
      AppMethodBeat.o(205174);
    }
    
    public static void fRL()
    {
      AppMethodBeat.i(205175);
      c.fRB().clear();
      c.fRC().clear();
      AppMethodBeat.o(205175);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(205176);
      b localb1 = new b("EXPOSURE", 0, 0);
      KGN = localb1;
      b localb2 = new b("INOUT", 1, 1);
      KGO = localb2;
      b localb3 = new b("INOUT_WITHOUT_78EVENT", 2, 2);
      KGP = localb3;
      KGQ = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(205176);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$TopicType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Words", "Poi", "plugin-expt_release"})
  public static enum c
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(205179);
      c localc1 = new c("Words", 0, 1);
      KGR = localc1;
      c localc2 = new c("Poi", 1, 2);
      KGS = localc2;
      KGT = new c[] { localc1, localc2 };
      AppMethodBeat.o(205179);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
  public static enum d
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(205182);
      d locald1 = new d("LBS", 0, 1000);
      KGU = locald1;
      d locald2 = new d("TOPIC", 1, 1001);
      KGV = locald2;
      d locald3 = new d("POI", 2, 1002);
      KGW = locald3;
      d locald4 = new d("SEARCH", 3, 1004);
      KGX = locald4;
      d locald5 = new d("OTHER_PROFILE", 4, 1006);
      KGY = locald5;
      d locald6 = new d("FAVORITE", 5, 1008);
      KGZ = locald6;
      KHa = new d[] { locald1, locald2, locald3, locald4, locald5, locald6 };
      AppMethodBeat.o(205182);
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