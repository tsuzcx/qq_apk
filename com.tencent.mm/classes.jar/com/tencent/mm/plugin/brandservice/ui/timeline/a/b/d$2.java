package com.tencent.mm.plugin.brandservice.ui.timeline.a.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class d$2
  implements w.a
{
  d$2(LinkedList paramLinkedList, List paramList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (dr)paramb.ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null))
    {
      y.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.iix.size()) });
      a.jdMethod_if(54);
      com.tencent.mm.plugin.brandservice.c.axp().aJ(this.iiy);
      return 0;
    }
    y.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.iix.size()) });
    a.jdMethod_if(55);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */