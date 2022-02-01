package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.l;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "", "getFeedDataPos", "()I", "setFeedDataPos", "(I)V", "getFeedId", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "onRelease", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
{
  public static final a FtN;
  private static final String TAG;
  final FinderItem ANj;
  l AOo;
  int FsD;
  long endTime;
  final long feedId;
  final long startTime;
  
  static
  {
    AppMethodBeat.i(331293);
    FtN = new a((byte)0);
    TAG = "Finder.FinderTwoFeedRecord";
    AppMethodBeat.o(331293);
  }
  
  public an(long paramLong1, long paramLong2, FinderItem paramFinderItem)
  {
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.ANj = paramFinderItem;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "printStats", "", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "toIndexInfo", "record", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "trans2Stats", "fastSlip", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String a(an paraman)
    {
      AppMethodBeat.i(331017);
      s.u(paraman, "record");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        paraman = paraman.AOo;
        if (paraman != null)
        {
          localJSONObject.put("x", paraman.Mkq + 1);
          localJSONObject.put("width", paraman.width);
          localJSONObject.put("height", paraman.height);
        }
      }
      catch (Exception paraman)
      {
        label63:
        break label63;
      }
      paraman = localJSONObject.toString();
      s.s(paraman, "jsonObj.toString()");
      AppMethodBeat.o(331017);
      return paraman;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.an
 * JD-Core Version:    0.7.0.1
 */