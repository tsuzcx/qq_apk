package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStreamCardAlbumReporter;", "", "()V", "report21086", "", "title", "", "cardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "position", "", "exposedTime", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report21087", "cardId", "action", "feedId", "report21089", "index", "report21090", "txtCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "clickWording", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
{
  public static final aj FtF;
  
  static
  {
    AppMethodBeat.i(331310);
    FtF = new aj();
    AppMethodBeat.o(331310);
  }
  
  public static void a(String paramString, long paramLong1, int paramInt1, long paramLong2, bui parambui, int paramInt2)
  {
    Object localObject = null;
    AppMethodBeat.i(331280);
    s.u(paramString, "title");
    h localh = h.OAn;
    Integer localInteger;
    String str3;
    String str4;
    String str1;
    label48:
    String str2;
    if (parambui == null)
    {
      localInteger = null;
      str3 = d.hF(paramLong1);
      str4 = d.hF(paramLong2);
      if (parambui != null) {
        break label149;
      }
      str1 = null;
      if (parambui != null) {
        break label159;
      }
      str2 = null;
      label56:
      if (parambui != null) {
        break label169;
      }
    }
    label149:
    label159:
    label169:
    for (parambui = localObject;; parambui = parambui.zIB)
    {
      localh.b(21087, new Object[] { localInteger, str3, paramString, Integer.valueOf(paramInt1), str4, str1, str2, parambui, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(331280);
      return;
      localInteger = Integer.valueOf(parambui.AJo);
      break;
      str1 = parambui.sessionId;
      break label48;
      str2 = parambui.zIO;
      break label56;
    }
  }
  
  public static void a(String paramString, au paramau, int paramInt, long paramLong, bui parambui)
  {
    AppMethodBeat.i(331302);
    s.u(paramau, "cardFeed");
    Object localObject3 = paramau.AYW;
    Object localObject1 = (Iterable)paramau.rvFeedList;
    int i = 0;
    Object localObject2 = ((Iterable)localObject1).iterator();
    localObject1 = "";
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      localObject4 = (BaseFinderFeed)localObject4;
      str1 = d.hF(((BaseFinderFeed)localObject4).bZA());
      if ((((BaseFinderFeed)localObject4).bZB() == 4) && (i == 0))
      {
        localObject1 = (String)localObject1 + str1 + ';' + i + ";1|";
        i = j;
      }
      else
      {
        localObject1 = (String)localObject1 + str1 + ';' + i + ";0|";
        i = j;
      }
    }
    n.d((String)localObject1, (CharSequence)"|");
    Object localObject4 = h.OAn;
    String str2;
    if (parambui == null)
    {
      localObject2 = null;
      str1 = d.hF(paramau.AYW.id);
      str2 = ((bwa)localObject3).aadS;
      i = paramau.rvFeedList.size();
      if (parambui != null) {
        break label366;
      }
      paramau = null;
      label253:
      if (parambui != null) {
        break label375;
      }
      localObject3 = null;
      label261:
      if (parambui != null) {
        break label385;
      }
    }
    label385:
    for (parambui = null;; parambui = parambui.zIB)
    {
      ((h)localObject4).b(21086, new Object[] { localObject2, str1, paramString, localObject1, str2, Integer.valueOf(i), paramau, localObject3, parambui, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(331302);
      return;
      localObject2 = Integer.valueOf(parambui.AJo);
      break;
      label366:
      paramau = parambui.sessionId;
      break label253;
      label375:
      localObject3 = parambui.zIO;
      break label261;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.aj
 * JD-Core Version:    0.7.0.1
 */