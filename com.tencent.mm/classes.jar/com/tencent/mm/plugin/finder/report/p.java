package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"})
public final class p
{
  public static final a KVv;
  private static final String TAG = "Finder.FinderTwoFeedRecord";
  f KMj;
  int KUQ;
  long endTime;
  final FinderItem feed;
  final long feedId;
  final long startTime;
  
  static
  {
    AppMethodBeat.i(198856);
    KVv = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(198856);
  }
  
  public p(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"})
  public static final class a
  {
    public static String a(p paramp)
    {
      AppMethodBeat.i(198855);
      k.h(paramp, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paramp = paramp.KMj;
        if (paramp != null)
        {
          localJSONObject.put("x", paramp.LDP + 1);
          localJSONObject.put("width", paramp.width);
          localJSONObject.put("height", paramp.height);
        }
      }
      catch (Exception paramp)
      {
        label63:
        break label63;
      }
      paramp = localJSONObject.toString();
      k.g(paramp, "jsonObj.toString()");
      AppMethodBeat.o(198855);
      return paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */