package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.dx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryReportLogic;", "", "()V", "pickScene", "", "getPickScene", "()J", "setPickScene", "(J)V", "query", "", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "tabType", "getTabType", "setTabType", "getTabReportEventCode", "tab", "", "getTabReportType", "report22878ClickFeed", "", "feedId", "isPicFeed", "", "report22878ClickPrevDone", "report22878ClickSearch", "report22878ClickTab", "report22878Enter", "bizScene", "defaultTab", "report22878Exit", "report22878PrevRet", "report22878SearchClickFeed", "keyword", "report22878SearchEnter", "report22878SearchExit", "report22878SearchPrevDone", "report22878SearchPrevRet", "resetSessionId", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder_release"})
public final class f
{
  public static String query;
  public static String sessionId;
  public static long xTY;
  static long xTZ;
  public static final f xUa;
  
  static
  {
    AppMethodBeat.i(267194);
    xUa = new f();
    sessionId = "";
    query = "";
    AppMethodBeat.o(267194);
  }
  
  public static void Lb(long paramLong)
  {
    AppMethodBeat.i(267188);
    xTY = paramLong;
    sessionId = String.valueOf(cm.bfE());
    AppMethodBeat.o(267188);
  }
  
  public static void Lc(long paramLong)
  {
    AppMethodBeat.i(267189);
    dx localdx = new dx();
    localdx.qZ(sessionId);
    localdx.kd(xTY);
    localdx.ke(2L);
    localdx.ra("prev_done");
    localdx.kf(xTZ);
    localdx.rb("{\"feedid\":\"" + d.Fw(paramLong) + "\"}");
    localdx.rc(String.valueOf(cm.bfE()));
    localdx.bpa();
    a((a)localdx);
    AppMethodBeat.o(267189);
  }
  
  public static void Ld(long paramLong)
  {
    AppMethodBeat.i(267190);
    dx localdx = new dx();
    localdx.qZ(sessionId);
    localdx.kd(xTY);
    localdx.ke(2L);
    localdx.ra("prev_return");
    localdx.kf(xTZ);
    localdx.rb("{\"feedid\":\"" + d.Fw(paramLong) + "\"}");
    localdx.rc(String.valueOf(cm.bfE()));
    localdx.bpa();
    a((a)localdx);
    AppMethodBeat.o(267190);
  }
  
  public static void Le(long paramLong)
  {
    AppMethodBeat.i(267192);
    dx localdx = new dx();
    localdx.qZ(sessionId);
    localdx.kd(xTY);
    localdx.ke(2L);
    localdx.ra("prev_done");
    localdx.kf(6L);
    localdx.rb("{\"feedid\":\"" + d.Fw(paramLong) + "\";\"keyword\":\"" + query + "\"}");
    localdx.rc(String.valueOf(cm.bfE()));
    localdx.bpa();
    a((a)localdx);
    AppMethodBeat.o(267192);
  }
  
  public static void Lf(long paramLong)
  {
    AppMethodBeat.i(267193);
    dx localdx = new dx();
    localdx.qZ(sessionId);
    localdx.kd(xTY);
    localdx.ke(2L);
    localdx.ra("prev_return");
    localdx.kf(6L);
    localdx.rb("{\"feedid\":\"" + d.Fw(paramLong) + "\";\"keyword\":\"" + query + "\"}");
    localdx.rc(String.valueOf(cm.bfE()));
    localdx.bpa();
    a((a)localdx);
    AppMethodBeat.o(267193);
  }
  
  public static long MR(int paramInt)
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
  
  public static String MS(int paramInt)
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
  
  public static void a(a parama)
  {
    AppMethodBeat.i(267191);
    p.k(parama, "struct");
    Object localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject = com.tencent.mm.plugin.finder.report.n.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.agI();
    p.j(parama, "struct.toShowString()");
    Log.i((String)localObject, kotlin.n.n.l(parama, "\r\n", " ", false));
    AppMethodBeat.o(267191);
  }
  
  public static String getSessionId()
  {
    return sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.f
 * JD-Core Version:    0.7.0.1
 */