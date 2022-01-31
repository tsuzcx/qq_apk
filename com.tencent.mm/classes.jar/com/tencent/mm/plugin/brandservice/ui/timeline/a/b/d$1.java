package com.tencent.mm.plugin.brandservice.ui.timeline.a.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements w.a
{
  d$1(int paramInt, dp paramdp) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (dr)paramb.ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null))
    {
      if (this.hPw > 0) {
        com.tencent.mm.plugin.webview.preload.a.jdMethod_if(57);
      }
      y.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s, ascene:%d, sessionId:%s, scene:%d, subScene:%d, reportTime:%d", new Object[] { this.iiw.kSC, Integer.valueOf(this.iiw.sxd), this.iiw.sxe, Integer.valueOf(this.iiw.pyo), Integer.valueOf(this.iiw.sxf), Long.valueOf(this.iiw.sxc) });
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(51);
      return 0;
    }
    if (paramInt2 == 50001)
    {
      if (this.hPw < 3)
      {
        d.a(this.iiw, this.hPw + 1);
        return 0;
      }
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(52);
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(59);
      if (com.tencent.mm.plugin.brandservice.c.axp().a(new a(this.iiw)))
      {
        y.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
        return 0;
      }
      y.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
      return 0;
    }
    if (this.hPw > 0) {
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(58);
    }
    com.tencent.mm.plugin.webview.preload.a.jdMethod_if(52);
    if (com.tencent.mm.plugin.brandservice.c.axp().a(new a(this.iiw)))
    {
      y.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
      return 0;
    }
    y.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.d.1
 * JD-Core Version:    0.7.0.1
 */