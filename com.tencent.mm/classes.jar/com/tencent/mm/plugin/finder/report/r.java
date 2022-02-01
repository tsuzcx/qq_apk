package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"})
public final class r
{
  private static final String TAG = "Finder.FinderTwoFeedRecord";
  public static final a sAS;
  final long duw;
  long endTime;
  final FinderItem feed;
  f rZD;
  final long startTime;
  int szj;
  
  static
  {
    AppMethodBeat.i(203919);
    sAS = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(203919);
  }
  
  public r(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.duw = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"})
  public static final class a
  {
    public static String a(r paramr)
    {
      AppMethodBeat.i(203918);
      p.h(paramr, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paramr = paramr.rZD;
        if (paramr != null)
        {
          localJSONObject.put("x", paramr.LSs + 1);
          localJSONObject.put("width", paramr.width);
          localJSONObject.put("height", paramr.height);
        }
      }
      catch (Exception paramr)
      {
        label63:
        break label63;
      }
      paramr = localJSONObject.toString();
      p.g(paramr, "jsonObj.toString()");
      AppMethodBeat.o(203918);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.r
 * JD-Core Version:    0.7.0.1
 */