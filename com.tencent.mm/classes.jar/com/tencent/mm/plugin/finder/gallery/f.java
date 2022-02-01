package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.fh;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryReportLogic;", "", "()V", "TAG", "", "pickScene", "", "getPickScene", "()J", "setPickScene", "(J)V", "query", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "tabType", "getTabType", "setTabType", "getTabReportEventCode", "tab", "", "getTabReportType", "report22878ClickFeed", "", "feedId", "isPicFeed", "", "report22878ClickPrevDone", "report22878ClickSearch", "report22878ClickTab", "report22878Enter", "bizScene", "defaultTab", "report22878Exit", "report22878FeedExposure", "report22878PrevRet", "report22878SearchClickFeed", "keyword", "report22878SearchEnter", "report22878SearchExit", "report22878SearchPrevDone", "report22878SearchPrevRet", "resetSessionId", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f BuT;
  public static long BuU;
  public static long BuV;
  public static String query;
  public static String sessionId;
  
  static
  {
    AppMethodBeat.i(334423);
    BuT = new f();
    sessionId = "";
    query = "";
    AppMethodBeat.o(334423);
  }
  
  public static long Ou(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0L;
    case 1: 
      return 1L;
    case 2: 
      return 2L;
    case 3: 
      return 3L;
    case 4: 
      return 4L;
    case 5: 
      return 5L;
    }
    return 6L;
  }
  
  public static String Ov(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "follow_tab";
    case 2: 
      return "rec_tab";
    case 3: 
      return "fav_tab";
    case 4: 
      return "like_tab";
    case 5: 
      return "post_tab";
    }
    return "search_icon";
  }
  
  public static void R(long paramLong, int paramInt)
  {
    AppMethodBeat.i(334417);
    fh localfh = new fh();
    localfh.pO(sessionId);
    localfh.iGT = BuU;
    localfh.iFe = 4L;
    localfh.pP("feed_exposure");
    localfh.iGV = Ou(paramInt);
    localfh.pQ("{\"feedid\":\"" + d.hF(paramLong) + "\"}");
    localfh.pR(String.valueOf(cn.bDw()));
    localfh.bMH();
    a((a)localfh);
    AppMethodBeat.o(334417);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(334389);
    s.u(parama, "struct");
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.aIF();
    s.s(parama, "struct.toShowString()");
    Log.i("FinderGalleryReportLogic", n.bV(parama, "\r\n", " "));
    AppMethodBeat.o(334389);
  }
  
  public static String getSessionId()
  {
    return sessionId;
  }
  
  public static void nO(long paramLong)
  {
    AppMethodBeat.i(334322);
    BuU = paramLong;
    sessionId = String.valueOf(cn.bDw());
    AppMethodBeat.o(334322);
  }
  
  public static void nP(long paramLong)
  {
    AppMethodBeat.i(334331);
    fh localfh = new fh();
    localfh.pO(sessionId);
    localfh.iGT = BuU;
    localfh.iFe = 2L;
    localfh.pP("prev_done");
    localfh.iGV = BuV;
    localfh.pQ("{\"feedid\":\"" + d.hF(paramLong) + "\"}");
    localfh.pR(String.valueOf(cn.bDw()));
    localfh.bMH();
    a((a)localfh);
    AppMethodBeat.o(334331);
  }
  
  public static void nQ(long paramLong)
  {
    AppMethodBeat.i(334369);
    fh localfh = new fh();
    localfh.pO(sessionId);
    localfh.iGT = BuU;
    localfh.iFe = 2L;
    localfh.pP("prev_return");
    localfh.iGV = BuV;
    localfh.pQ("{\"feedid\":\"" + d.hF(paramLong) + "\"}");
    localfh.pR(String.valueOf(cn.bDw()));
    localfh.bMH();
    a((a)localfh);
    AppMethodBeat.o(334369);
  }
  
  public static void nR(long paramLong)
  {
    AppMethodBeat.i(334399);
    fh localfh = new fh();
    localfh.pO(sessionId);
    localfh.iGT = BuU;
    localfh.iFe = 2L;
    localfh.pP("prev_done");
    localfh.iGV = 6L;
    localfh.pQ("{\"feedid\":\"" + d.hF(paramLong) + "\";\"keyword\":\"" + query + "\"}");
    localfh.pR(String.valueOf(cn.bDw()));
    localfh.bMH();
    a((a)localfh);
    AppMethodBeat.o(334399);
  }
  
  public static void nS(long paramLong)
  {
    AppMethodBeat.i(334408);
    fh localfh = new fh();
    localfh.pO(sessionId);
    localfh.iGT = BuU;
    localfh.iFe = 2L;
    localfh.pP("prev_return");
    localfh.iGV = 6L;
    localfh.pQ("{\"feedid\":\"" + d.hF(paramLong) + "\";\"keyword\":\"" + query + "\"}");
    localfh.pR(String.valueOf(cn.bDw()));
    localfh.bMH();
    a((a)localfh);
    AppMethodBeat.o(334408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.f
 * JD-Core Version:    0.7.0.1
 */