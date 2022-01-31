package com.tencent.mm.plugin.appbrand.n;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a.a;
import com.tencent.mm.plugin.appbrand.n.a.b.a;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.n.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
  implements b.a, e.a
{
  private final r gPA;
  private final com.tencent.mm.plugin.appbrand.i.i hwG;
  private final Map<Integer, Integer> iua;
  private final ExecutorService mExecutorService;
  
  static
  {
    AppMethodBeat.i(102180);
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102180);
      return;
    }
  }
  
  public d(r paramr, com.tencent.mm.plugin.appbrand.i.i parami)
  {
    AppMethodBeat.i(102172);
    this.gPA = paramr;
    this.hwG = parami;
    this.mExecutorService = Executors.newCachedThreadPool();
    e.a(this, paramr);
    this.iua = new ConcurrentHashMap();
    AppMethodBeat.o(102172);
  }
  
  public final void Y(int paramInt, String paramString)
  {
    AppMethodBeat.i(102175);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(102175);
      return;
    }
    paramString = String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.hwG.evaluateJavascript(paramString, null);
    AppMethodBeat.o(102175);
  }
  
  public final void aIz()
  {
    AppMethodBeat.i(102173);
    ab.i("MicroMsg.NodeJavaBroker", "shutdown");
    this.mExecutorService.shutdown();
    Iterator localIterator = this.iua.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.iua.clear();
    AppMethodBeat.o(102173);
  }
  
  public final void d(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(102179);
    com.tencent.luggage.g.i.d(paramMap);
    paramMap = String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), new com.tencent.mm.aa.i(paramMap).toString() });
    this.hwG.evaluateJavascript(paramMap, null);
    AppMethodBeat.o(102179);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102177);
    com.tencent.mm.plugin.appbrand.n.a.e locale = e.oZ(paramInt1);
    if (locale == null)
    {
      ab.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      AppMethodBeat.o(102177);
      return;
    }
    locale.listen(paramInt2);
    this.iua.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    AppMethodBeat.o(102177);
  }
  
  @JavascriptInterface
  public void req(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(102174);
    ab.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    a locala = b.oY(paramInt1);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(102174);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.n.a.b))
    {
      paramString = new IllegalStateException("req asynchronously, but target cmd not async!");
      AppMethodBeat.o(102174);
      throw paramString;
    }
    paramString = new d.1(this, paramInt2, (com.tencent.mm.plugin.appbrand.n.a.b)locala, paramString);
    this.mExecutorService.execute(paramString);
    AppMethodBeat.o(102174);
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(102176);
    a locala = b.oY(paramInt);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(102176);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.n.a.d))
    {
      paramString = new IllegalStateException("req synchronously, but target cmd not sync!");
      AppMethodBeat.o(102176);
      throw paramString;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.n.a.d)locala).a(paramString, new c(this.gPA));
    AppMethodBeat.o(102176);
    return paramString;
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    AppMethodBeat.i(102178);
    Object localObject = (Integer)this.iua.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(102178);
      return;
    }
    int i = ((Integer)localObject).intValue();
    ab.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = e.oZ(i);
    if (localObject == null)
    {
      ab.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      AppMethodBeat.o(102178);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.n.a.e)localObject).unListen(paramInt);
    this.iua.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(102178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d
 * JD-Core Version:    0.7.0.1
 */