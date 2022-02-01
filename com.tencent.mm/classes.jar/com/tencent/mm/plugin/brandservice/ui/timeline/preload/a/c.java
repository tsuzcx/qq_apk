package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static void TO(String paramString)
  {
    AppMethodBeat.i(6194);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(6194);
      return;
    }
    fj localfj = new fj();
    localfj.Url = paramString;
    com.tencent.mm.plugin.webview.g.a.lA(50);
    com.tencent.mm.plugin.webview.g.a.lA(56);
    a(localfj, 0);
    AppMethodBeat.o(6194);
  }
  
  private static b.a a(fj paramfj)
  {
    AppMethodBeat.i(6198);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramfj);
    paramfj = c(localLinkedList, 0);
    AppMethodBeat.o(6198);
    return paramfj;
  }
  
  static void a(final fj paramfj, int paramInt)
  {
    AppMethodBeat.i(6195);
    x.a(a(paramfj).aAz(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6192);
        ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fl)paramAnonymousb.hvs.hvw;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.ncp > 0) {
            com.tencent.mm.plugin.webview.g.a.lA(57);
          }
          ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramfj.Url });
          com.tencent.mm.plugin.webview.g.a.lA(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.ncp < 3)
            {
              c.a(paramfj, this.ncp + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.g.a.lA(52);
              com.tencent.mm.plugin.webview.g.a.lA(59);
              if (d.bIY().a(new a(paramfj))) {
                ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                ac.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.ncp > 0) {
              com.tencent.mm.plugin.webview.g.a.lA(58);
            }
            com.tencent.mm.plugin.webview.g.a.lA(52);
            if (d.bIY().a(new a(paramfj))) {
              ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
            } else {
              ac.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
            }
          }
        }
      }
    });
    AppMethodBeat.o(6195);
  }
  
  public static void bLa()
  {
    AppMethodBeat.i(6196);
    Object localObject = d.bIY().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    final LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    localObject = cu(localLinkedList);
    if (((LinkedList)localObject).size() <= 0)
    {
      d.bIY().ct(localLinkedList);
      ac.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(6196);
      return;
    }
    com.tencent.mm.plugin.webview.g.a.lA(53);
    x.a(c((LinkedList)localObject, 1).aAz(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6193);
        ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fl)paramAnonymousb.hvs.hvw;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.nJr.size()) });
          com.tencent.mm.plugin.webview.g.a.lA(54);
          d.bIY().ct(localLinkedList);
        }
        for (;;)
        {
          AppMethodBeat.o(6193);
          return 0;
          ac.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.nJr.size()) });
          com.tencent.mm.plugin.webview.g.a.lA(55);
        }
      }
    });
    AppMethodBeat.o(6196);
  }
  
  private static b.a c(LinkedList<fj> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6199);
    b.a locala = new b.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    fk localfk = new fk();
    localfk.DSw = paramLinkedList;
    localfk.DSx = paramInt;
    locala.hvt = localfk;
    locala.hvu = new fl();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  private static LinkedList<fj> cu(List<a> paramList)
  {
    AppMethodBeat.i(6197);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      ac.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!bs.isNullOrNil(locala.field_url))
        {
          if (System.currentTimeMillis() - locala.field_reportTime >= com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.nFd)
          {
            com.tencent.mm.plugin.webview.g.a.e(908, 60, 1, true);
          }
          else
          {
            fj localfj = new fj();
            localfj.Url = locala.field_url;
            localfj.DSs = locala.field_reportTime;
            localLinkedList.add(localfj);
            ac.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localfj.Url, Long.valueOf(localfj.DSs) });
          }
        }
        else {
          ac.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
        }
      }
    }
    AppMethodBeat.o(6197);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c
 * JD-Core Version:    0.7.0.1
 */