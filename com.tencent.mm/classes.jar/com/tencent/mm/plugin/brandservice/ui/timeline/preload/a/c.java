package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private static d.a a(gb paramgb)
  {
    AppMethodBeat.i(6198);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramgb);
    paramgb = c(localLinkedList, 0);
    AppMethodBeat.o(6198);
    return paramgb;
  }
  
  static void a(final gb paramgb, int paramInt)
  {
    AppMethodBeat.i(6195);
    aa.a(a(paramgb).aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(6192);
        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (gd)paramAnonymousd.iLL.iLR;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.oTd > 0) {
            com.tencent.mm.plugin.webview.h.a.pl(57);
          }
          Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramgb.Url });
          com.tencent.mm.plugin.webview.h.a.pl(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.oTd < 3)
            {
              c.a(paramgb, this.oTd + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.h.a.pl(52);
              com.tencent.mm.plugin.webview.h.a.pl(59);
              if (com.tencent.mm.plugin.brandservice.d.clp().a(new a(paramgb))) {
                Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.oTd > 0) {
              com.tencent.mm.plugin.webview.h.a.pl(58);
            }
            com.tencent.mm.plugin.webview.h.a.pl(52);
            if (com.tencent.mm.plugin.brandservice.d.clp().a(new a(paramgb))) {
              Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
            } else {
              Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
            }
          }
        }
      }
    });
    AppMethodBeat.o(6195);
  }
  
  public static void aij(String paramString)
  {
    AppMethodBeat.i(6194);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(6194);
      return;
    }
    gb localgb = new gb();
    localgb.Url = paramString;
    com.tencent.mm.plugin.webview.h.a.pl(50);
    com.tencent.mm.plugin.webview.h.a.pl(56);
    a(localgb, 0);
    AppMethodBeat.o(6194);
  }
  
  private static d.a c(LinkedList<gb> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6199);
    d.a locala = new d.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.iLP = 0;
    locala.respCmdId = 0;
    gc localgc = new gc();
    localgc.KJT = paramLinkedList;
    localgc.KJU = paramInt;
    locala.iLN = localgc;
    locala.iLO = new gd();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  private static LinkedList<gb> cK(List<a> paramList)
  {
    AppMethodBeat.i(6197);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!Util.isNullOrNil(locala.field_url))
        {
          if (System.currentTimeMillis() - locala.field_reportTime >= g.pBc)
          {
            com.tencent.mm.plugin.webview.h.a.kh(60, 1);
          }
          else
          {
            gb localgb = new gb();
            localgb.Url = locala.field_url;
            localgb.KJQ = locala.field_reportTime;
            localLinkedList.add(localgb);
            Log.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localgb.Url, Long.valueOf(localgb.KJQ) });
          }
        }
        else {
          Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
        }
      }
    }
    AppMethodBeat.o(6197);
    return localLinkedList;
  }
  
  public static void coh()
  {
    AppMethodBeat.i(6196);
    Object localObject = com.tencent.mm.plugin.brandservice.d.clp().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    final LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    localObject = cK(localLinkedList);
    if (((LinkedList)localObject).size() <= 0)
    {
      com.tencent.mm.plugin.brandservice.d.clp().cJ(localLinkedList);
      Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(6196);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.pl(53);
    aa.a(c((LinkedList)localObject, 1).aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(6193);
        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (gd)paramAnonymousd.iLL.iLR;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.pFk.size()) });
          com.tencent.mm.plugin.webview.h.a.pl(54);
          com.tencent.mm.plugin.brandservice.d.clp().cJ(localLinkedList);
        }
        for (;;)
        {
          AppMethodBeat.o(6193);
          return 0;
          Log.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.pFk.size()) });
          com.tencent.mm.plugin.webview.h.a.pl(55);
        }
      }
    });
    AppMethodBeat.o(6196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c
 * JD-Core Version:    0.7.0.1
 */