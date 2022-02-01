package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.brandservice.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private static d.a a(fp paramfp)
  {
    AppMethodBeat.i(6198);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramfp);
    paramfp = c(localLinkedList, 0);
    AppMethodBeat.o(6198);
    return paramfp;
  }
  
  static void a(final fp paramfp, int paramInt)
  {
    AppMethodBeat.i(6195);
    aa.a(a(paramfp).bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(6192);
        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fr)d.c.b(paramAnonymousd.lBS);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.rSO > 0) {
            com.tencent.mm.plugin.webview.h.a.rE(57);
          }
          Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramfp.Url });
          com.tencent.mm.plugin.webview.h.a.rE(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.rSO < 3)
            {
              c.a(paramfp, this.rSO + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.h.a.rE(52);
              com.tencent.mm.plugin.webview.h.a.rE(59);
              if (e.cyP().a(new a(paramfp))) {
                Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.rSO > 0) {
              com.tencent.mm.plugin.webview.h.a.rE(58);
            }
            com.tencent.mm.plugin.webview.h.a.rE(52);
            if (e.cyP().a(new a(paramfp))) {
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
  
  public static void apV(String paramString)
  {
    AppMethodBeat.i(6194);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(6194);
      return;
    }
    fp localfp = new fp();
    localfp.Url = paramString;
    com.tencent.mm.plugin.webview.h.a.rE(50);
    com.tencent.mm.plugin.webview.h.a.rE(56);
    a(localfp, 0);
    AppMethodBeat.o(6194);
  }
  
  private static d.a c(LinkedList<fp> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6199);
    d.a locala = new d.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.lBW = 0;
    locala.respCmdId = 0;
    fq localfq = new fq();
    localfq.RKJ = paramLinkedList;
    localfq.RKK = paramInt;
    locala.lBU = localfq;
    locala.lBV = new fr();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  public static void cCn()
  {
    AppMethodBeat.i(6196);
    Object localObject = e.cyP().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    final LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    localObject = cH(localLinkedList);
    if (((LinkedList)localObject).size() <= 0)
    {
      e.cyP().cG(localLinkedList);
      Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(6196);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.rE(53);
    aa.a(c((LinkedList)localObject, 1).bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(6193);
        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (fr)d.c.b(paramAnonymousd.lBS);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.sQy.size()) });
          com.tencent.mm.plugin.webview.h.a.rE(54);
          e.cyP().cG(localLinkedList);
        }
        for (;;)
        {
          AppMethodBeat.o(6193);
          return 0;
          Log.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.sQy.size()) });
          com.tencent.mm.plugin.webview.h.a.rE(55);
        }
      }
    });
    AppMethodBeat.o(6196);
  }
  
  private static LinkedList<fp> cH(List<a> paramList)
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
          if (System.currentTimeMillis() - locala.field_reportTime >= g.sLo)
          {
            com.tencent.mm.plugin.webview.h.a.lz(60, 1);
          }
          else
          {
            fp localfp = new fp();
            localfp.Url = locala.field_url;
            localfp.RKG = locala.field_reportTime;
            localLinkedList.add(localfp);
            Log.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localfp.Url, Long.valueOf(localfp.RKG) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c
 * JD-Core Version:    0.7.0.1
 */