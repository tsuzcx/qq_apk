package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static void Xw(String paramString)
  {
    AppMethodBeat.i(6194);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(6194);
      return;
    }
    fo localfo = new fo();
    localfo.Url = paramString;
    com.tencent.mm.plugin.webview.g.a.ma(50);
    com.tencent.mm.plugin.webview.g.a.ma(56);
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
    x.a(a(paramfo).aDC(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6192);
        ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fq)paramAnonymousb.hNL.hNQ;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.nCM > 0) {
            com.tencent.mm.plugin.webview.g.a.ma(57);
          }
          ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramfo.Url });
          com.tencent.mm.plugin.webview.g.a.ma(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.nCM < 3)
            {
              c.a(paramfo, this.nCM + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.g.a.ma(52);
              com.tencent.mm.plugin.webview.g.a.ma(59);
              if (d.bNr().a(new a(paramfo))) {
                ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.nCM > 0) {
              com.tencent.mm.plugin.webview.g.a.ma(58);
            }
            com.tencent.mm.plugin.webview.g.a.ma(52);
            if (d.bNr().a(new a(paramfo))) {
              ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
            } else {
              ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
            }
          }
        }
      }
    });
    AppMethodBeat.o(6195);
  }
  
  public static void bPB()
  {
    AppMethodBeat.i(6196);
    Object localObject = d.bNr().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
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
      d.bNr().ct(localLinkedList);
      ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(6196);
      return;
    }
    com.tencent.mm.plugin.webview.g.a.ma(53);
    x.a(c((LinkedList)localObject, 1).aDC(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6193);
        ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fq)paramAnonymousb.hNL.hNQ;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.olX.size()) });
          com.tencent.mm.plugin.webview.g.a.ma(54);
          d.bNr().ct(localLinkedList);
        }
        for (;;)
        {
          AppMethodBeat.o(6193);
          return 0;
          ad.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.olX.size()) });
          com.tencent.mm.plugin.webview.g.a.ma(55);
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
    locala.hNO = 0;
    locala.respCmdId = 0;
    fp localfp = new fp();
    localfp.FxP = paramLinkedList;
    localfp.FxQ = paramInt;
    locala.hNM = localfp;
    locala.hNN = new fq();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  private static LinkedList<fo> cu(List<a> paramList)
  {
    AppMethodBeat.i(6197);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!bt.isNullOrNil(locala.field_url))
        {
          if (System.currentTimeMillis() - locala.field_reportTime >= com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.ohG)
          {
            com.tencent.mm.plugin.webview.g.a.e(908, 60, 1, true);
          }
          else
          {
            fo localfo = new fo();
            localfo.Url = locala.field_url;
            localfo.FxL = locala.field_reportTime;
            localLinkedList.add(localfo);
            ad.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localfo.Url, Long.valueOf(localfo.FxL) });
          }
        }
        else {
          ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
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