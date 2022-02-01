package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderStreamCardAlbumReporter;", "", "()V", "report21086", "", "title", "", "cardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "position", "", "exposedTime", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report21087", "cardId", "action", "feedId", "report21089", "index", "report21090", "txtCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "clickWording", "plugin-finder_release"})
public final class x
{
  public static final x zYS;
  
  static
  {
    AppMethodBeat.i(288121);
    zYS = new x();
    AppMethodBeat.o(288121);
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2, bid parambid)
  {
    String str3 = null;
    AppMethodBeat.i(288117);
    h localh = h.IzE;
    String str4 = d.Fw(paramLong);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if (parambid != null)
    {
      paramString = parambid.sessionId;
      if (parambid == null) {
        break label129;
      }
    }
    label129:
    for (String str2 = parambid.wmL;; str2 = null)
    {
      if (parambid != null) {
        str3 = parambid.wmz;
      }
      localh.a(21089, new Object[] { str4, str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str2, str3 });
      AppMethodBeat.o(288117);
      return;
      paramString = null;
      break;
    }
  }
  
  public static void a(String paramString, long paramLong1, int paramInt1, long paramLong2, bid parambid, int paramInt2)
  {
    String str3 = null;
    AppMethodBeat.i(288119);
    p.k(paramString, "title");
    h localh = h.IzE;
    Integer localInteger;
    String str4;
    String str5;
    String str1;
    if (parambid != null)
    {
      localInteger = Integer.valueOf(parambid.xkX);
      str4 = d.Fw(paramLong1);
      str5 = d.Fw(paramLong2);
      if (parambid == null) {
        break label160;
      }
      str1 = parambid.sessionId;
      label59:
      if (parambid == null) {
        break label166;
      }
    }
    label160:
    label166:
    for (String str2 = parambid.wmL;; str2 = null)
    {
      if (parambid != null) {
        str3 = parambid.wmz;
      }
      localh.a(21087, new Object[] { localInteger, str4, paramString, Integer.valueOf(paramInt1), str5, str1, str2, str3, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(288119);
      return;
      localInteger = null;
      break;
      str1 = null;
      break label59;
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt, bjy parambjy, String paramString2, bid parambid)
  {
    AppMethodBeat.i(288118);
    p.k(paramString1, "title");
    p.k(parambjy, "txtCard");
    p.k(paramString2, "clickWording");
    Object localObject1 = parambjy.SUU;
    p.j(localObject1, "txtCard.link_wording");
    Object localObject3 = ((Iterable)localObject1).iterator();
    int i = 0;
    localObject1 = "";
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.iBO();
      }
      String str = (String)localObject2;
      if (parambjy.SUW.isEmpty())
      {
        localObject2 = "";
        label107:
        localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).append(';').append(str).append(';').append(i).append(';');
        if (!p.h(paramString2, str)) {
          break label208;
        }
      }
      label208:
      for (int j = 1;; j = 0)
      {
        localObject1 = j + '|';
        i += 1;
        break;
        localObject2 = (String)parambjy.SUW.get(i);
        break label107;
      }
    }
    n.c((String)localObject1, (CharSequence)"|");
    Object localObject2 = h.IzE;
    localObject3 = d.Fw(paramLong);
    if (parambid != null)
    {
      parambjy = parambid.sessionId;
      if (parambid == null) {
        break label345;
      }
      paramString2 = parambid.wmL;
      label260:
      if (parambid == null) {
        break label351;
      }
    }
    label345:
    label351:
    for (parambid = parambid.wmz;; parambid = null)
    {
      ((h)localObject2).a(21090, new Object[] { localObject3, paramString1, Integer.valueOf(paramInt + 1), localObject1, parambjy, paramString2, parambid });
      Log.i("report21090", String.valueOf(paramString1));
      AppMethodBeat.o(288118);
      return;
      parambjy = null;
      break;
      paramString2 = null;
      break label260;
    }
  }
  
  public static void a(String paramString, an paraman, int paramInt, long paramLong, bid parambid)
  {
    AppMethodBeat.i(288120);
    p.k(paraman, "cardFeed");
    Object localObject3 = paraman.xBH;
    Object localObject1 = (Iterable)paraman.rvFeedList;
    int i = 0;
    Object localObject2 = ((Iterable)localObject1).iterator();
    localObject1 = "";
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject4 = (BaseFinderFeed)localObject4;
      str1 = d.Fw(((BaseFinderFeed)localObject4).mf());
      if ((((BaseFinderFeed)localObject4).bAQ() == 4) && (i == 0))
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
    n.c((String)localObject1, (CharSequence)"|");
    Object localObject4 = h.IzE;
    String str2;
    if (parambid != null)
    {
      localObject2 = Integer.valueOf(parambid.xkX);
      str1 = d.Fw(paraman.xBH.id);
      str2 = ((bjp)localObject3).STM;
      i = paraman.rvFeedList.size();
      if (parambid == null) {
        break label378;
      }
      paraman = parambid.sessionId;
      label264:
      if (parambid == null) {
        break label383;
      }
      localObject3 = parambid.wmL;
      label276:
      if (parambid == null) {
        break label389;
      }
    }
    label389:
    for (parambid = parambid.wmz;; parambid = null)
    {
      ((h)localObject4).a(21086, new Object[] { localObject2, str1, paramString, localObject1, str2, Integer.valueOf(i), paraman, localObject3, parambid, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(288120);
      return;
      localObject2 = null;
      break;
      label378:
      paraman = null;
      break label264;
      label383:
      localObject3 = null;
      break label276;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.x
 * JD-Core Version:    0.7.0.1
 */