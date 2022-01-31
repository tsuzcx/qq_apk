package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

final class c$2
  implements w.a
{
  c$2(LinkedList paramLinkedList, List paramList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(14400);
    ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (es)paramb.fsW.fta;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null))
    {
      ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", new Object[] { Integer.valueOf(this.kcy.size()) });
      a.kS(54);
      d.aWq().aX(this.kcz);
    }
    for (;;)
    {
      AppMethodBeat.o(14400);
      return 0;
      ab.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", new Object[] { Integer.valueOf(this.kcy.size()) });
      a.kS(55);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.2
 * JD-Core Version:    0.7.0.1
 */