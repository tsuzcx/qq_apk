package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.a.a;
import com.tencent.mm.plugin.brandservice.a.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.d;
import com.tencent.mm.protocal.c.bll;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
  implements com.tencent.mm.plugin.brandservice.a.a
{
  private e iim = new b();
  private Map<String, a.b> iin = new ConcurrentHashMap();
  private AtomicBoolean iio = new AtomicBoolean(true);
  private Map<String, a.a> iip = new ConcurrentHashMap();
  private AtomicBoolean iiq = new AtomicBoolean(false);
  private Runnable iir = new c.2(this);
  
  private b.a G(LinkedList<a.a> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecG = 2594;
    locala.uri = "/cgi-bin/mmbiz-bin/batchgetappmsg";
    locala.ecJ = 0;
    locala.ecK = 0;
    gm localgm = new gm();
    localgm.sAw = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      a.a locala1 = (a.a)localIterator.next();
      bll localbll = new bll();
      localbll.kSC = locala1.url;
      localbll.swZ = 0;
      a locala2 = this.iim.xU(locala1.url);
      if (locala2 != null)
      {
        localbll.swZ = locala2.field_lastModifyTime;
        if (locala1.ibT > locala2.field_tmplVersion) {
          localbll.swZ = 0;
        }
      }
      localgm.sAw.add(localbll);
    }
    y.i("MicroMsg.Preload.BizAppMsgContextService", "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localgm.sAw.size()) });
    y.d("MicroMsg.Preload.BizAppMsgContextService", "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramLinkedList });
    locala.ecH = localgm;
    locala.ecI = new gn();
    return locala;
  }
  
  public final a a(a.a parama)
  {
    if (parama == null) {}
    do
    {
      return null;
      if (bk.bl(parama.url))
      {
        y.e("MicroMsg.Preload.BizAppMsgContextService", "[findAppMsgContextInCache] url is null, return");
        return null;
      }
    } while (!this.iim.bk(parama.url, parama.ibT));
    return this.iim.xU(parama.url);
  }
  
  public final void a(a.a parama, a.b paramb)
  {
    if (com.tencent.mm.plugin.brandservice.ui.timeline.a.c.ayt()) {
      paramb.a(true, new a());
    }
    while (bk.bl(parama.url)) {
      return;
    }
    Object localObject = a(parama);
    if ((localObject != null) && (((a)localObject).field_tmplVersion >= parama.ibT))
    {
      paramb.a(true, (a)localObject);
      return;
    }
    com.tencent.mm.plugin.webview.preload.a.jdMethod_if(20);
    com.tencent.mm.plugin.webview.preload.a.jdMethod_if(26);
    localObject = new com.tencent.mm.plugin.webview.preload.e();
    ((com.tencent.mm.plugin.webview.preload.e)localObject).startTime = System.currentTimeMillis();
    ((com.tencent.mm.plugin.webview.preload.e)localObject).iks = 1;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(parama);
    w.a(G(localLinkedList).Kt(), new c.1(this, parama, (com.tencent.mm.plugin.webview.preload.e)localObject, paramb));
  }
  
  public final void b(a.a parama)
  {
    if (!d.ayw()) {}
    while (!this.iio.get()) {
      return;
    }
    if (this.iim.bk(parama.url, parama.ibT))
    {
      y.v("MicroMsg.Preload.BizAppMsgContextService", "[syncAppMsgContextIfNeed]url:%s hit cache", new Object[] { parama.url });
      return;
    }
    y.v("MicroMsg.Preload.BizAppMsgContextService", "[syncAppMsgContextIfNeed] add url:%s", new Object[] { parama.url });
    this.iip.put(parama.url, parama);
    g.DS().crf().removeCallbacks(this.iir);
    g.DS().k(this.iir, 1000L);
  }
  
  public final void es(boolean paramBoolean)
  {
    y.d("MicroMsg.Preload.BizAppMsgContextService", "enableSyncAppMsgFromServer() enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iio.set(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c
 * JD-Core Version:    0.7.0.1
 */