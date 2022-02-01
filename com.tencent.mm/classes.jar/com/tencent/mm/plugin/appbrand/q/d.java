package com.tencent.mm.plugin.appbrand.q;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.a.b.a;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements b.a, e.a
{
  private final r jzD;
  private final com.tencent.mm.plugin.appbrand.jsruntime.i ktw;
  private final Map<Integer, Integer> mcj;
  private final e mck;
  
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
  
  public d(r paramr, com.tencent.mm.plugin.appbrand.jsruntime.i parami)
  {
    AppMethodBeat.i(147370);
    this.jzD = paramr;
    this.ktw = parami;
    parami = new e();
    parami.a(new com.tencent.mm.plugin.appbrand.q.d.a(this, paramr));
    parami.a(new com.tencent.mm.plugin.appbrand.q.d.c(this, paramr));
    parami.a(new com.tencent.mm.plugin.appbrand.q.d.b(this, paramr));
    this.mck = parami;
    this.mcj = new ConcurrentHashMap();
    AppMethodBeat.o(147370);
  }
  
  public final void an(int paramInt, String paramString)
  {
    AppMethodBeat.i(147373);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(147373);
      return;
    }
    paramString = String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.ktw.evaluateJavascript(paramString, null);
    AppMethodBeat.o(147373);
  }
  
  public final void bul()
  {
    AppMethodBeat.i(147371);
    ae.i("MicroMsg.NodeJavaBroker", "shutdown");
    Iterator localIterator = this.mcj.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.mcj.clear();
    AppMethodBeat.o(147371);
  }
  
  public final void e(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147377);
    com.tencent.luggage.h.d.k(paramMap);
    paramMap = String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), new com.tencent.mm.ab.i(paramMap).toString() });
    this.ktw.evaluateJavascript(paramMap, null);
    AppMethodBeat.o(147377);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147375);
    com.tencent.mm.plugin.appbrand.q.a.e locale = this.mck.uP(paramInt1);
    if (locale == null)
    {
      ae.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      AppMethodBeat.o(147375);
      return;
    }
    locale.listen(paramInt2);
    this.mcj.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    AppMethodBeat.o(147375);
  }
  
  @JavascriptInterface
  public void req(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(147372);
    ae.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.appbrand.q.a.a locala = b.uO(paramInt1);
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
        String str = "MicroMsg.NodeJavaBroker~CMD~" + this.mcm.bum();
        AppMethodBeat.o(177511);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(147369);
        com.tencent.mm.plugin.appbrand.q.a.c localc = new com.tencent.mm.plugin.appbrand.q.a.c(d.a(d.this), paramInt2, d.this);
        this.mcm.a(paramString, localc);
        AppMethodBeat.o(147369);
      }
    };
    com.tencent.e.h.MqF.aO(paramString);
    AppMethodBeat.o(147372);
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(147374);
    ae.v("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.appbrand.q.a.a locala = b.uO(paramInt);
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
    paramString = ((com.tencent.mm.plugin.appbrand.q.a.d)locala).a(paramString, new com.tencent.mm.plugin.appbrand.q.a.c(this.jzD));
    AppMethodBeat.o(147374);
    return paramString;
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    AppMethodBeat.i(147376);
    Object localObject = (Integer)this.mcj.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(147376);
      return;
    }
    int i = ((Integer)localObject).intValue();
    ae.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = this.mck.uP(i);
    if (localObject == null)
    {
      ae.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      AppMethodBeat.o(147376);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.q.a.e)localObject).unListen(paramInt);
    this.mcj.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(147376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d
 * JD-Core Version:    0.7.0.1
 */