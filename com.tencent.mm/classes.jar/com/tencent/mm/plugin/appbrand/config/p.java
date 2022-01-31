package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import com.tencent.mm.ck.f;
import com.tencent.mm.ck.g;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class p
  implements c
{
  public final void a(String paramString, c.a parama)
  {
    s.a(paramString, false, new p.1(this, parama));
  }
  
  public final void at(List<String> paramList)
  {
    if (bk.dk(paramList)) {
      return;
    }
    y.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { bk.c(paramList, ", ") });
    s.a(paramList, l.a.fQA);
  }
  
  public final void b(String paramString, c.a parama)
  {
    if (bk.bl(paramString))
    {
      if (parama != null) {
        parama.b(null);
      }
      return;
    }
    ai localai = new ai();
    new ah(localai.mnU.getLooper()).post(new p.3(this, paramString, parama, localai));
  }
  
  public final WxaAttributes so(String paramString)
  {
    return com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[0]);
  }
  
  public final com.tencent.mm.vending.g.e<WxaAttributes> sp(String paramString)
  {
    return g.cn(paramString).b(new p.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */