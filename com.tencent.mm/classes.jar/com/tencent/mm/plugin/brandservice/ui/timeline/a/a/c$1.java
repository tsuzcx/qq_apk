package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.brandservice.a.a.a;
import com.tencent.mm.plugin.brandservice.a.a.b;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class c$1
  implements w.a
{
  c$1(c paramc, a.a parama, com.tencent.mm.plugin.webview.preload.e parame, a.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.Preload.BizAppMsgContextService", "[findAppMsgContext]callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (gn)paramb.ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.sAx != null) && (paramString.sAx.size() > 0))
    {
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(21);
      paramString = (do)paramString.sAx.get(0);
      y.i("MicroMsg.Preload.BizAppMsgContextService", "[findAppMsgContext] url:%s", new Object[] { this.iis.url });
      if ((paramString != null) && (this.iis.url.equals(paramString.kSC))) {
        if (paramString.sxa)
        {
          this.iit.ccV();
          this.iit.endTime = System.currentTimeMillis();
          this.iit.Ck(paramString.btq());
          this.iit.wn();
          c.a(this.iiv).a(paramString.kSC, paramString);
          if (!paramString.sxa) {
            break label237;
          }
          com.tencent.mm.plugin.webview.preload.a.jdMethod_if(31);
          label200:
          if (this.iiu != null) {
            this.iiu.a(true, new a(paramString));
          }
        }
      }
    }
    label237:
    do
    {
      return 0;
      this.iit.ccU();
      break;
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(32);
      break label200;
      boolean bool;
      if (paramString != null)
      {
        bool = true;
        if (paramString == null) {
          break label292;
        }
      }
      for (paramString = paramString.kSC;; paramString = "")
      {
        y.w("MicroMsg.Preload.BizAppMsgContextService", "appMsgContext is :%b %s", new Object[] { Boolean.valueOf(bool), paramString });
        return 0;
        bool = false;
        break;
      }
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(22);
    } while (this.iiu == null);
    label292:
    this.iiu.a(false, null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */