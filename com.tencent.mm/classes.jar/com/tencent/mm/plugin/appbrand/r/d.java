package com.tencent.mm.plugin.appbrand.r;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.b.a;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements b.a, e.a
{
  private final q iDy;
  private final com.tencent.mm.plugin.appbrand.jsruntime.i jvx;
  private final Map<Integer, Integer> kWu;
  private final e kWv;
  
  static
  {
    AppMethodBeat.i(147378);
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(147378);
      return;
    }
  }
  
  public d(q paramq, com.tencent.mm.plugin.appbrand.jsruntime.i parami)
  {
    AppMethodBeat.i(147370);
    this.iDy = paramq;
    this.jvx = parami;
    parami = new e();
    parami.a(new com.tencent.mm.plugin.appbrand.r.d.a(this, paramq));
    parami.a(new com.tencent.mm.plugin.appbrand.r.d.c(this, paramq));
    parami.a(new com.tencent.mm.plugin.appbrand.r.d.b(this, paramq));
    this.kWv = parami;
    this.kWu = new ConcurrentHashMap();
    AppMethodBeat.o(147370);
  }
  
  public final void ak(int paramInt, String paramString)
  {
    AppMethodBeat.i(147373);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(147373);
      return;
    }
    paramString = String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.jvx.evaluateJavascript(paramString, null);
    AppMethodBeat.o(147373);
  }
  
  public final void biG()
  {
    AppMethodBeat.i(147371);
    ad.i("MicroMsg.NodeJavaBroker", "shutdown");
    Iterator localIterator = this.kWu.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.kWu.clear();
    AppMethodBeat.o(147371);
  }
  
  public final void d(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147377);
    com.tencent.luggage.h.d.e(paramMap);
    paramMap = String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), new com.tencent.mm.ac.i(paramMap).toString() });
    this.jvx.evaluateJavascript(paramMap, null);
    AppMethodBeat.o(147377);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147375);
    com.tencent.mm.plugin.appbrand.r.a.e locale = this.kWv.to(paramInt1);
    if (locale == null)
    {
      ad.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      AppMethodBeat.o(147375);
      return;
    }
    locale.listen(paramInt2);
    this.kWu.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    AppMethodBeat.o(147375);
  }
  
  @JavascriptInterface
  public void req(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(147372);
    ad.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.appbrand.r.a.a locala = b.tn(paramInt1);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147372);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.r.a.b))
    {
      paramString = new IllegalStateException("req asynchronously, but target cmd not async!");
      AppMethodBeat.o(147372);
      throw paramString;
    }
    paramString = new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(177511);
        String str = "MicroMsg.NodeJavaBroker~CMD~" + this.kWx.biH();
        AppMethodBeat.o(177511);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(147369);
        com.tencent.mm.plugin.appbrand.r.a.c localc = new com.tencent.mm.plugin.appbrand.r.a.c(d.a(d.this), paramInt2, d.this);
        this.kWx.a(paramString, localc);
        AppMethodBeat.o(147369);
      }
    };
    com.tencent.e.h.Iye.aP(paramString);
    AppMethodBeat.o(147372);
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(147374);
    ad.v("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.appbrand.r.a.a locala = b.tn(paramInt);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147374);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.r.a.d))
    {
      paramString = new IllegalStateException("req synchronously, but target cmd not sync!");
      AppMethodBeat.o(147374);
      throw paramString;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.r.a.d)locala).a(paramString, new com.tencent.mm.plugin.appbrand.r.a.c(this.iDy));
    AppMethodBeat.o(147374);
    return paramString;
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    AppMethodBeat.i(147376);
    Object localObject = (Integer)this.kWu.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(147376);
      return;
    }
    int i = ((Integer)localObject).intValue();
    ad.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = this.kWv.to(i);
    if (localObject == null)
    {
      ad.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      AppMethodBeat.o(147376);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.r.a.e)localObject).unListen(paramInt);
    this.kWu.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(147376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d
 * JD-Core Version:    0.7.0.1
 */