package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"})
public final class q
{
  private static final String TAG = "Finder.FinderTwoFeedRecord";
  public static final a sqI;
  final long dtq;
  long endTime;
  final FinderItem feed;
  f rRb;
  int soY;
  final long startTime;
  
  static
  {
    AppMethodBeat.i(203360);
    sqI = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(203360);
  }
  
  public q(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.dtq = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"})
  public static final class a
  {
    public static String a(q paramq)
    {
      AppMethodBeat.i(203359);
      p.h(paramq, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paramq = paramq.rRb;
        if (paramq != null)
        {
          localJSONObject.put("x", paramq.LvF + 1);
          localJSONObject.put("width", paramq.width);
          localJSONObject.put("height", paramq.height);
        }
      }
      catch (Exception paramq)
      {
        label63:
        break label63;
      }
      paramq = localJSONObject.toString();
      p.g(paramq, "jsonObj.toString()");
      AppMethodBeat.o(203359);
      return paramq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.q
 * JD-Core Version:    0.7.0.1
 */