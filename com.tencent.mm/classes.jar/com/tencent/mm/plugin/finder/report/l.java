package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.k;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"})
public final class l
{
  private static final String TAG = "Finder.FinderTwoFeedRecord";
  public static final a ryZ;
  final long dig;
  long endTime;
  final FinderItem feed;
  f rdF;
  int rxD;
  final long startTime;
  
  static
  {
    AppMethodBeat.i(202809);
    ryZ = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(202809);
  }
  
  public l(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.dig = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"})
  public static final class a
  {
    public static String a(l paraml)
    {
      AppMethodBeat.i(202808);
      k.h(paraml, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paraml = paraml.rdF;
        if (paraml != null)
        {
          localJSONObject.put("x", paraml.JCz + 1);
          localJSONObject.put("width", paraml.width);
          localJSONObject.put("height", paraml.height);
        }
      }
      catch (Exception paraml)
      {
        label63:
        break label63;
      }
      paraml = localJSONObject.toString();
      k.g(paraml, "jsonObj.toString()");
      AppMethodBeat.o(202808);
      return paraml;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */