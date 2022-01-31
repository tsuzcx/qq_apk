package com.tencent.mm.plugin.brandservice.ui.timeline.a.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.b;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  static void a(dp paramdp, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramdp);
    w.a(b(localLinkedList, 0).Kt(), new d.1(paramInt, paramdp));
  }
  
  static LinkedList<dp> aK(List<a> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      y.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (!bk.bl(locala.field_url))
        {
          if (System.currentTimeMillis() - locala.field_reportTime >= b.ihZ)
          {
            com.tencent.mm.plugin.webview.preload.a.aa(908, 60, 1);
          }
          else
          {
            dp localdp = new dp();
            localdp.kSC = locala.field_url;
            localdp.sxc = locala.field_reportTime;
            localLinkedList.add(localdp);
            y.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", new Object[] { localdp.kSC, Long.valueOf(localdp.sxc) });
          }
        }
        else {
          y.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
        }
      }
    }
    return localLinkedList;
  }
  
  static b.a b(LinkedList<dp> paramLinkedList, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecG = 2998;
    locala.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
    locala.ecJ = 0;
    locala.ecK = 0;
    dq localdq = new dq();
    localdq.sxg = paramLinkedList;
    localdq.sxh = paramInt;
    locala.ecH = localdq;
    locala.ecI = new dr();
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.d
 * JD-Core Version:    0.7.0.1
 */