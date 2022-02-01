package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static void PD(String paramString)
  {
    AppMethodBeat.i(6194);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(6194);
      return;
    }
    fh localfh = new fh();
    localfh.Url = paramString;
    com.tencent.mm.plugin.webview.g.a.lI(50);
    com.tencent.mm.plugin.webview.g.a.lI(56);
    a(localfh, 0);
    AppMethodBeat.o(6194);
  }
  
  private static b.a a(fh paramfh)
  {
    AppMethodBeat.i(6198);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramfh);
    paramfh = c(localLinkedList, 0);
    AppMethodBeat.o(6198);
    return paramfh;
  }
  
  static void a(final fh paramfh, int paramInt)
  {
    AppMethodBeat.i(6195);
    x.a(a(paramfh).atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6192);
        ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fj)paramAnonymousb.gUT.gUX;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.mAo > 0) {
            com.tencent.mm.plugin.webview.g.a.lI(57);
          }
          ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramfh.Url });
          com.tencent.mm.plugin.webview.g.a.lI(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.mAo < 3)
            {
              c.a(paramfh, this.mAo + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.g.a.lI(52);
              com.tencent.mm.plugin.webview.g.a.lI(59);
              if (d.bCa().a(new a(paramfh))) {
                ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.mAo > 0) {
              com.tencent.mm.plugin.webview.g.a.lI(58);
            }
            com.tencent.mm.plugin.webview.g.a.lI(52);
            if (d.bCa().a(new a(paramfh))) {
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
  
  public static void bDN()
  {
    AppMethodBeat.i(6196);
    Object localObject = d.bCa().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    final LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    localObject = cs(localLinkedList);
    if (((LinkedList)localObject).size() <= 0)
    {
      d.bCa().cr(localLinkedList);
      ad.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(6196);
      return;
    }
    com.tencent.mm.plugin.webview.g.a.lI(53);
    x.a(c((LinkedList)localObject, 1).atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6193);
        ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fj)paramAnonymousb.gUT.gUX;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          ad.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.ngB.size()) });
          com.tencent.mm.plugin.webview.g.a.lI(54);
          d.bCa().cr(localLinkedList);
        }
        for (;;)
        {
          AppMethodBeat.o(6193);
          return 0;
          ad.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.ngB.size()) });
          com.tencent.mm.plugin.webview.g.a.lI(55);
        }
      }
    });
    AppMethodBeat.o(6196);
  }
  
  private static b.a c(LinkedList<fh> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6199);
    b.a locala = new b.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    fi localfi = new fi();
    localfi.CAa = paramLinkedList;
    localfi.CAb = paramInt;
    locala.gUU = localfi;
    locala.gUV = new fj();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  private static LinkedList<fh> cs(List<a> paramList)
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
          if (System.currentTimeMillis() - locala.field_reportTime >= com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.ncr)
          {
            com.tencent.mm.plugin.webview.g.a.d(908, 60, 1, true);
          }
          else
          {
            fh localfh = new fh();
            localfh.Url = locala.field_url;
            localfh.CzW = locala.field_reportTime;
            localLinkedList.add(localfh);
            ad.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localfh.Url, Long.valueOf(localfh.CzW) });
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