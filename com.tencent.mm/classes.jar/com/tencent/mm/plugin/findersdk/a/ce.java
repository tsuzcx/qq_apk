package com.tencent.mm.plugin.findersdk.a;

import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.e;
import com.tencent.mm.plugin.finder.live.report.o;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.av;
import com.tencent.mm.plugin.finder.live.report.q.bd;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.z;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IHellLiveReport;", "Lcom/tencent/mm/kernel/service/IService;", "getConfig", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig;", "report21017", "", "actionType", "", "actionJson", "", "report21053", "recyclerView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "", "visibleItemCount", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "headerShow", "", "Landroidx/recyclerview/widget/RecyclerView;", "report21053FeedOnFull", "centerFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "report21053OnClick", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "userName", "feedId", "liveId", "onlineNum", "chnlExtra", "clickTabContextId", "clickSubTabContextId", "report21053OnClickForLiveSquare", "report21053OnClickOnAvatar", "report21053OnClickOnShare", "enterData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "report21054", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$AnchorActionType;", "json", "report21106", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LiveBookAction;", "value", "description", "report21631", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$NearbyAction2;", "reportElementClick", "elementId", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementClickId;", "eidUdfKVMap", "", "reportElementExpose", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementExposeId;", "reportHalfProfile21054", "result", "scene", "type", "reportReplay", "paramsJson", "setPoiJSONObject", "jsonObject", "Lorg/json/JSONObject;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ce
  extends a
{
  public abstract void C(long paramLong, String paramString);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, q.w paramw, String paramString2, String paramString3);
  
  public abstract void a(AbsListView paramAbsListView, BaseAdapter paramBaseAdapter, c.e parame, int paramInt1, int paramInt2, q.w paramw, String paramString, com.tencent.mm.plugin.finder.live.report.d paramd, boolean paramBoolean);
  
  public abstract void a(q.av paramav, String paramString1, String paramString2);
  
  public abstract void a(q.bd parambd);
  
  public abstract void a(q.c paramc, String paramString);
  
  public abstract void a(q.s params, Map<String, String> paramMap);
  
  public abstract void a(q.t paramt, Map<String, String> paramMap);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, q.w paramw, String paramString);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, q.w paramw, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString);
  
  public abstract void a(z paramz, String paramString1, long paramLong, q.w paramw, String paramString2);
  
  public abstract void a(com.tencent.mm.plugin.finder.utils.d paramd);
  
  public abstract void b(RecyclerView paramRecyclerView, q.w paramw, String paramString, com.tencent.mm.plugin.finder.live.report.d paramd);
  
  public abstract void b(o paramo);
  
  public abstract void bc(JSONObject paramJSONObject);
  
  public abstract q etm();
  
  public abstract void hP(String paramString1, String paramString2);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.ce
 * JD-Core Version:    0.7.0.1
 */