package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements w.a
{
  c$1(int paramInt, eq parameq) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(14399);
    ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (es)paramb.fsW.fta;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null))
    {
      if (this.jIY > 0) {
        com.tencent.mm.plugin.webview.preload.a.kS(57);
      }
      ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", new Object[] { this.kcx.Url });
      com.tencent.mm.plugin.webview.preload.a.kS(51);
    }
    for (;;)
    {
      AppMethodBeat.o(14399);
      return 0;
      if (paramInt2 == 50001)
      {
        if (this.jIY < 3)
        {
          c.a(this.kcx, this.jIY + 1);
        }
        else
        {
          com.tencent.mm.plugin.webview.preload.a.kS(52);
          com.tencent.mm.plugin.webview.preload.a.kS(59);
          if (d.aWq().a(new a(this.kcx))) {
            ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
          } else {
            ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
          }
        }
      }
      else
      {
        if (this.jIY > 0) {
          com.tencent.mm.plugin.webview.preload.a.kS(58);
        }
        com.tencent.mm.plugin.webview.preload.a.kS(52);
        if (d.aWq().a(new a(this.kcx))) {
          ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
        } else {
          ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.1
 * JD-Core Version:    0.7.0.1
 */