package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStreamCardAlbumReporter;", "", "()V", "report21086", "", "title", "", "cardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "position", "", "exposedTime", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report21087", "cardId", "action", "feedId", "report21089", "index", "report21090", "txtCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "clickWording", "plugin-finder_release"})
public final class t
{
  public static final t vhJ;
  
  static
  {
    AppMethodBeat.i(250802);
    vhJ = new t();
    AppMethodBeat.o(250802);
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2, bbn parambbn)
  {
    String str3 = null;
    AppMethodBeat.i(250798);
    h localh = h.CyF;
    String str4 = d.zs(paramLong);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if (parambbn != null)
    {
      paramString = parambbn.sessionId;
      if (parambbn == null) {
        break label129;
      }
    }
    label129:
    for (String str2 = parambbn.sGQ;; str2 = null)
    {
      if (parambbn != null) {
        str3 = parambbn.sGE;
      }
      localh.a(21089, new Object[] { str4, str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str2, str3 });
      AppMethodBeat.o(250798);
      return;
      paramString = null;
      break;
    }
  }
  
  public static void a(String paramString, long paramLong1, int paramInt1, long paramLong2, bbn parambbn, int paramInt2)
  {
    String str3 = null;
    AppMethodBeat.i(250800);
    p.h(paramString, "title");
    h localh = h.CyF;
    Integer localInteger;
    String str4;
    String str5;
    String str1;
    if (parambbn != null)
    {
      localInteger = Integer.valueOf(parambbn.tCE);
      str4 = d.zs(paramLong1);
      str5 = d.zs(paramLong2);
      if (parambbn == null) {
        break label160;
      }
      str1 = parambbn.sessionId;
      label59:
      if (parambbn == null) {
        break label166;
      }
    }
    label160:
    label166:
    for (String str2 = parambbn.sGQ;; str2 = null)
    {
      if (parambbn != null) {
        str3 = parambbn.sGE;
      }
      localh.a(21087, new Object[] { localInteger, str4, paramString, Integer.valueOf(paramInt1), str5, str1, str2, str3, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(250800);
      return;
      localInteger = null;
      break;
      str1 = null;
      break label59;
    }
  }
  
  public static void a(String paramString1, long paramLong, int paramInt, bdb parambdb, String paramString2, bbn parambbn)
  {
    AppMethodBeat.i(250799);
    p.h(paramString1, "title");
    p.h(parambdb, "txtCard");
    p.h(paramString2, "clickWording");
    Object localObject1 = parambdb.LMR;
    p.g(localObject1, "txtCard.link_wording");
    Object localObject3 = ((Iterable)localObject1).iterator();
    int i = 0;
    localObject1 = "";
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.hxH();
      }
      String str = (String)localObject2;
      if (parambdb.LMT.isEmpty())
      {
        localObject2 = "";
        label107:
        localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).append(';').append(str).append(';').append(i).append(';');
        if (!p.j(paramString2, str)) {
          break label208;
        }
      }
      label208:
      for (int j = 1;; j = 0)
      {
        localObject1 = j + '|';
        i += 1;
        break;
        localObject2 = (String)parambdb.LMT.get(i);
        break label107;
      }
    }
    n.c((String)localObject1, (CharSequence)"|");
    Object localObject2 = h.CyF;
    localObject3 = d.zs(paramLong);
    if (parambbn != null)
    {
      parambdb = parambbn.sessionId;
      if (parambbn == null) {
        break label345;
      }
      paramString2 = parambbn.sGQ;
      label260:
      if (parambbn == null) {
        break label351;
      }
    }
    label345:
    label351:
    for (parambbn = parambbn.sGE;; parambbn = null)
    {
      ((h)localObject2).a(21090, new Object[] { localObject3, paramString1, Integer.valueOf(paramInt + 1), localObject1, parambdb, paramString2, parambbn });
      Log.i("report21090", String.valueOf(paramString1));
      AppMethodBeat.o(250799);
      return;
      parambdb = null;
      break;
      paramString2 = null;
      break label260;
    }
  }
  
  public static void a(String paramString, ag paramag, int paramInt, long paramLong, bbn parambbn)
  {
    AppMethodBeat.i(250801);
    p.h(paramag, "cardFeed");
    Object localObject3 = paramag.tQQ;
    Object localObject1 = (Iterable)paramag.rvFeedList;
    int i = 0;
    Object localObject2 = ((Iterable)localObject1).iterator();
    localObject1 = "";
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      localObject4 = (BaseFinderFeed)localObject4;
      str1 = d.zs(((BaseFinderFeed)localObject4).lT());
      if ((((BaseFinderFeed)localObject4).cxn() == 4) && (i == 0))
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
    Object localObject4 = h.CyF;
    String str2;
    if (parambbn != null)
    {
      localObject2 = Integer.valueOf(parambbn.tCE);
      str1 = d.zs(paramag.tQQ.id);
      str2 = ((bcu)localObject3).LLT;
      i = paramag.rvFeedList.size();
      if (parambbn == null) {
        break label378;
      }
      paramag = parambbn.sessionId;
      label264:
      if (parambbn == null) {
        break label383;
      }
      localObject3 = parambbn.sGQ;
      label276:
      if (parambbn == null) {
        break label389;
      }
    }
    label389:
    for (parambbn = parambbn.sGE;; parambbn = null)
    {
      ((h)localObject4).a(21086, new Object[] { localObject2, str1, paramString, localObject1, str2, Integer.valueOf(i), paramag, localObject3, parambbn, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(250801);
      return;
      localObject2 = null;
      break;
      label378:
      paramag = null;
      break label264;
      label383:
      localObject3 = null;
      break label276;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.t
 * JD-Core Version:    0.7.0.1
 */