package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"})
public final class aa
{
  private static final String TAG = "Finder.FinderTwoFeedRecord";
  public static final a zYV;
  long endTime;
  final long feedId;
  final long startTime;
  final FinderItem xpY;
  j xrf;
  int zWX;
  
  static
  {
    AppMethodBeat.i(290813);
    zYV = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(290813);
  }
  
  public aa(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.xpY = paramFinderItem;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"})
  public static final class a
  {
    public static String a(aa paramaa)
    {
      AppMethodBeat.i(224993);
      p.k(paramaa, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paramaa = paramaa.xrf;
        if (paramaa != null)
        {
          localJSONObject.put("x", paramaa.Gqn + 1);
          localJSONObject.put("width", paramaa.width);
          localJSONObject.put("height", paramaa.height);
        }
      }
      catch (Exception paramaa)
      {
        label63:
        break label63;
      }
      paramaa = localJSONObject.toString();
      p.j(paramaa, "jsonObj.toString()");
      AppMethodBeat.o(224993);
      return paramaa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.aa
 * JD-Core Version:    0.7.0.1
 */