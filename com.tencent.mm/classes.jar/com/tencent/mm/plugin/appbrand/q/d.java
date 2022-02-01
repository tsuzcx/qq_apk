package com.tencent.mm.plugin.appbrand.q;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.b.a;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements b.a, e.a
{
  private final com.tencent.mm.plugin.appbrand.jsruntime.i jVT;
  private final q jdy;
  private final Map<Integer, Integer> lye;
  private final e lyf;
  
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
    this.jdy = paramq;
    this.jVT = parami;
    parami = new e();
    parami.a(new com.tencent.mm.plugin.appbrand.q.d.a(this, paramq));
    parami.a(new com.tencent.mm.plugin.appbrand.q.d.c(this, paramq));
    parami.a(new com.tencent.mm.plugin.appbrand.q.d.b(this, paramq));
    this.lyf = parami;
    this.lye = new ConcurrentHashMap();
    AppMethodBeat.o(147370);
  }
  
  public final void al(int paramInt, String paramString)
  {
    AppMethodBeat.i(147373);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(147373);
      return;
    }
    paramString = String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.jVT.evaluateJavascript(paramString, null);
    AppMethodBeat.o(147373);
  }
  
  public final void bpz()
  {
    AppMethodBeat.i(147371);
    ac.i("MicroMsg.NodeJavaBroker", "shutdown");
    Iterator localIterator = this.lye.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.lye.clear();
    AppMethodBeat.o(147371);
  }
  
  public final void d(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147377);
    com.tencent.luggage.h.d.d(paramMap);
    paramMap = String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), new com.tencent.mm.ab.i(paramMap).toString() });
    this.jVT.evaluateJavascript(paramMap, null);
    AppMethodBeat.o(147377);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147375);
    com.tencent.mm.plugin.appbrand.q.a.e locale = this.lyf.uf(paramInt1);
    if (locale == null)
    {
      ac.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      AppMethodBeat.o(147375);
      return;
    }
    locale.listen(paramInt2);
    this.lye.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    AppMethodBeat.o(147375);
  }
  
  @JavascriptInterface
  public void req(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(147372);
    ac.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.appbrand.q.a.a locala = b.ue(paramInt1);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147372);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.q.a.b))
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
        String str = "MicroMsg.NodeJavaBroker~CMD~" + this.lyh.bpA();
        AppMethodBeat.o(177511);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(147369);
        com.tencent.mm.plugin.appbrand.q.a.c localc = new com.tencent.mm.plugin.appbrand.q.a.c(d.a(d.this), paramInt2, d.this);
        this.lyh.a(paramString, localc);
        AppMethodBeat.o(147369);
      }
    };
    com.tencent.e.h.JZN.aS(paramString);
    AppMethodBeat.o(147372);
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(147374);
    ac.v("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.appbrand.q.a.a locala = b.ue(paramInt);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147374);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.q.a.d))
    {
      paramString = new IllegalStateException("req synchronously, but target cmd not sync!");
      AppMethodBeat.o(147374);
      throw paramString;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.q.a.d)locala).a(paramString, new com.tencent.mm.plugin.appbrand.q.a.c(this.jdy));
    AppMethodBeat.o(147374);
    return paramString;
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    AppMethodBeat.i(147376);
    Object localObject = (Integer)this.lye.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(147376);
      return;
    }
    int i = ((Integer)localObject).intValue();
    ac.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = this.lyf.uf(i);
    if (localObject == null)
    {
      ac.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      AppMethodBeat.o(147376);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.q.a.e)localObject).unListen(paramInt);
    this.lye.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(147376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d
 * JD-Core Version:    0.7.0.1
 */