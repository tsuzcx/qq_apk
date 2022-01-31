package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static void GW(String paramString)
  {
    AppMethodBeat.i(14401);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(14401);
      return;
    }
    eq localeq = new eq();
    localeq.Url = paramString;
    com.tencent.mm.plugin.webview.preload.a.kS(50);
    com.tencent.mm.plugin.webview.preload.a.kS(56);
    a(localeq, 0);
    AppMethodBeat.o(14401);
  }
  
  private static b.a a(eq parameq)
  {
    AppMethodBeat.i(14405);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(parameq);
    parameq = b(localLinkedList, 0);
    AppMethodBeat.o(14405);
    return parameq;
  }
  
  static void a(eq parameq, int paramInt)
  {
    AppMethodBeat.i(14402);
    w.a(a(parameq).ado(), new c.1(paramInt, parameq));
    AppMethodBeat.o(14402);
  }
  
  public static void aXF()
  {
    AppMethodBeat.i(14403);
    Object localObject = d.aWq().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    localObject = aY(localLinkedList);
    if (((LinkedList)localObject).size() <= 0)
    {
      d.aWq().aX(localLinkedList);
      ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(14403);
      return;
    }
    com.tencent.mm.plugin.webview.preload.a.kS(53);
    w.a(b((LinkedList)localObject, 1).ado(), new c.2((LinkedList)localObject, localLinkedList));
    AppMethodBeat.o(14403);
  }
  
  private static LinkedList<eq> aY(List<a> paramList)
  {
    AppMethodBeat.i(14404);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!bo.isNullOrNil(locala.field_url))
        {
          if (System.currentTimeMillis() - locala.field_reportTime >= com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.jZT)
          {
            com.tencent.mm.plugin.webview.preload.a.d(908, 60, 1, true);
          }
          else
          {
            eq localeq = new eq();
            localeq.Url = locala.field_url;
            localeq.wqL = locala.field_reportTime;
            localLinkedList.add(localeq);
            ab.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localeq.Url, Long.valueOf(localeq.wqL) });
          }
        }
        else {
          ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
        }
      }
    }
    AppMethodBeat.o(14404);
    return localLinkedList;
  }
  
  private static b.a b(LinkedList<eq> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(14406);
    b.a locala = new b.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    er localer = new er();
    localer.wqP = paramLinkedList;
    localer.wqQ = paramInt;
    locala.fsX = localer;
    locala.fsY = new es();
    AppMethodBeat.o(14406);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c
 * JD-Core Version:    0.7.0.1
 */