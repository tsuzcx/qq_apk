package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static void Yj(String paramString)
  {
    AppMethodBeat.i(6194);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(6194);
      return;
    }
    fo localfo = new fo();
    localfo.Url = paramString;
    com.tencent.mm.plugin.webview.g.a.md(50);
    com.tencent.mm.plugin.webview.g.a.md(56);
    a(localfo, 0);
    AppMethodBeat.o(6194);
  }
  
  private static b.a a(fo paramfo)
  {
    AppMethodBeat.i(6198);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramfo);
    paramfo = c(localLinkedList, 0);
    AppMethodBeat.o(6198);
    return paramfo;
  }
  
  static void a(final fo paramfo, int paramInt)
  {
    AppMethodBeat.i(6195);
    x.a(a(paramfo).aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6192);
        ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fq)paramAnonymousb.hQE.hQJ;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.nIh > 0) {
            com.tencent.mm.plugin.webview.g.a.md(57);
          }
          ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramfo.Url });
          com.tencent.mm.plugin.webview.g.a.md(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.nIh < 3)
            {
              c.a(paramfo, this.nIh + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.g.a.md(52);
              com.tencent.mm.plugin.webview.g.a.md(59);
              if (d.bOp().a(new a(paramfo))) {
                ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                ae.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.nIh > 0) {
              com.tencent.mm.plugin.webview.g.a.md(58);
            }
            com.tencent.mm.plugin.webview.g.a.md(52);
            if (d.bOp().a(new a(paramfo))) {
              ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
            } else {
              ae.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
            }
          }
        }
      }
    });
    AppMethodBeat.o(6195);
  }
  
  public static void bQz()
  {
    AppMethodBeat.i(6196);
    Object localObject = d.bOp().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    final LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    localObject = cw(localLinkedList);
    if (((LinkedList)localObject).size() <= 0)
    {
      d.bOp().cv(localLinkedList);
      ae.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(6196);
      return;
    }
    com.tencent.mm.plugin.webview.g.a.md(53);
    x.a(c((LinkedList)localObject, 1).aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6193);
        ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fq)paramAnonymousb.hQE.hQJ;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.orN.size()) });
          com.tencent.mm.plugin.webview.g.a.md(54);
          d.bOp().cv(localLinkedList);
        }
        for (;;)
        {
          AppMethodBeat.o(6193);
          return 0;
          ae.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.orN.size()) });
          com.tencent.mm.plugin.webview.g.a.md(55);
        }
      }
    });
    AppMethodBeat.o(6196);
  }
  
  private static b.a c(LinkedList<fo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6199);
    b.a locala = new b.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.hQH = 0;
    locala.respCmdId = 0;
    fp localfp = new fp();
    localfp.FQn = paramLinkedList;
    localfp.FQo = paramInt;
    locala.hQF = localfp;
    locala.hQG = new fq();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  private static LinkedList<fo> cw(List<a> paramList)
  {
    AppMethodBeat.i(6197);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      ae.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!bu.isNullOrNil(locala.field_url))
        {
          if (System.currentTimeMillis() - locala.field_reportTime >= com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.onG)
          {
            com.tencent.mm.plugin.webview.g.a.e(908, 60, 1, true);
          }
          else
          {
            fo localfo = new fo();
            localfo.Url = locala.field_url;
            localfo.FQj = locala.field_reportTime;
            localLinkedList.add(localfo);
            ae.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localfo.Url, Long.valueOf(localfo.FQj) });
          }
        }
        else {
          ae.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
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