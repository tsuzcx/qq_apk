package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$3
  implements w.a
{
  c$3(c paramc, com.tencent.mm.plugin.webview.preload.e parame) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.Preload.BizAppMsgContextService", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (gn)paramb.ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null))
    {
      a.jdMethod_if(24);
      y.i("MicroMsg.Preload.BizAppMsgContextService", "response.AppMsgContextList size:%d", new Object[] { Integer.valueOf(paramString.sAx.size()) });
      this.iit.endTime = System.currentTimeMillis();
      paramString = paramString.sAx.iterator();
      if (paramString.hasNext())
      {
        paramb = (do)paramString.next();
        paramm = paramb.kSC;
        if (paramb.kVs != null)
        {
          paramInt1 = paramb.kVs.length();
          label144:
          y.v("MicroMsg.Preload.BizAppMsgContextService", "appMsgContext url:%s content:%d clientCacheTime:%d forceUrl:%s lastModifyTime:%d noNeedUpdate:%b", new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(paramb.swX), paramb.swY, Integer.valueOf(paramb.swZ), Boolean.valueOf(paramb.sxa) });
          c.a(this.iiv).a(paramb.kSC, paramb);
          if (!paramb.sxa) {
            break label276;
          }
          a.jdMethod_if(31);
          label241:
          if (!paramb.sxa) {
            break label284;
          }
          this.iit.ccV();
        }
        for (;;)
        {
          this.iit.Ck(paramb.btq());
          break;
          paramInt1 = 0;
          break label144;
          label276:
          a.jdMethod_if(32);
          break label241;
          label284:
          this.iit.ccU();
        }
      }
      this.iit.wn();
    }
    for (;;)
    {
      c.b(this.iiv).set(false);
      if (c.c(this.iiv).size() > 0) {
        g.DS().k(c.d(this.iiv), 1000L);
      }
      return 0;
      a.jdMethod_if(25);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c.3
 * JD-Core Version:    0.7.0.1
 */