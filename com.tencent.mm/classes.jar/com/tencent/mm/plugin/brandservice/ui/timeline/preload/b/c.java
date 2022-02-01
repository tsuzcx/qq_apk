package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.brandservice.SubCoreBrandService;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private static c.a a(gj paramgj)
  {
    AppMethodBeat.i(6198);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramgj);
    paramgj = d(localLinkedList, 0);
    AppMethodBeat.o(6198);
    return paramgj;
  }
  
  public static void a(final gj paramgj, int paramInt)
  {
    AppMethodBeat.i(6195);
    z.a(a(paramgj).bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(6192);
        Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (gl)c.c.b(paramAnonymousc.otC);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          if (this.ved > 0) {
            com.tencent.mm.plugin.webview.g.a.rG(57);
          }
          Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { paramgj.Url });
          com.tencent.mm.plugin.webview.g.a.rG(51);
        }
        for (;;)
        {
          AppMethodBeat.o(6192);
          return 0;
          if (paramAnonymousInt2 == 50001)
          {
            if (this.ved < 3)
            {
              c.a(paramgj, this.ved + 1);
            }
            else
            {
              com.tencent.mm.plugin.webview.g.a.rG(52);
              com.tencent.mm.plugin.webview.g.a.rG(59);
              if (SubCoreBrandService.dbN().a(new a(paramgj))) {
                Log.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
              } else {
                Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
              }
            }
          }
          else
          {
            if (this.ved > 0) {
              com.tencent.mm.plugin.webview.g.a.rG(58);
            }
            com.tencent.mm.plugin.webview.g.a.rG(52);
            if (SubCoreBrandService.dbN().a(new a(paramgj))) {
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
  
  public static c.a d(LinkedList<gj> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6199);
    c.a locala = new c.a();
    locala.funcId = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.otG = 0;
    locala.respCmdId = 0;
    gk localgk = new gk();
    localgk.YId = paramLinkedList;
    localgk.YIe = paramInt;
    locala.otE = localgk;
    locala.otF = new gl();
    AppMethodBeat.o(6199);
    return locala;
  }
  
  public static LinkedList<gj> eC(List<a> paramList)
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
          if (System.currentTimeMillis() - locala.field_reportTime >= g.vRc)
          {
            com.tencent.mm.plugin.webview.g.a.nk(60, 1);
          }
          else
          {
            gj localgj = new gj();
            localgj.Url = locala.field_url;
            localgj.YIa = locala.field_reportTime;
            localLinkedList.add(localgj);
            Log.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localgj.Url, Long.valueOf(localgj.YIa) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c
 * JD-Core Version:    0.7.0.1
 */