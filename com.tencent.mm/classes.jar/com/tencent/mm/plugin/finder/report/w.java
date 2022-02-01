package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"})
public final class w
{
  private static final String TAG = "Finder.FinderTwoFeedRecord";
  public static final a vhM;
  long endTime;
  final long feedId;
  final long startTime;
  final FinderItem tHo;
  i tIw;
  int vfP;
  
  static
  {
    AppMethodBeat.i(250816);
    vhM = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(250816);
  }
  
  public w(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.tHo = paramFinderItem;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"})
  public static final class a
  {
    public static String a(w paramw)
    {
      AppMethodBeat.i(250815);
      p.h(paramw, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paramw = paramw.tIw;
        if (paramw != null)
        {
          localJSONObject.put("x", paramw.Rrj + 1);
          localJSONObject.put("width", paramw.width);
          localJSONObject.put("height", paramw.height);
        }
      }
      catch (Exception paramw)
      {
        label63:
        break label63;
      }
      paramw = localJSONObject.toString();
      p.g(paramw, "jsonObj.toString()");
      AppMethodBeat.o(250815);
      return paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.w
 * JD-Core Version:    0.7.0.1
 */