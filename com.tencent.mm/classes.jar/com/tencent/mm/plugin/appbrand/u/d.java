package com.tencent.mm.plugin.appbrand.u;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.b.a;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements b.a, e.a
{
  private final s kAr;
  private final com.tencent.mm.plugin.appbrand.m.i lxm;
  private final Map<Integer, Integer> njU;
  private final e njV;
  
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
  
  public d(s params, com.tencent.mm.plugin.appbrand.m.i parami)
  {
    AppMethodBeat.i(147370);
    this.kAr = params;
    this.lxm = parami;
    parami = new e();
    parami.a(new com.tencent.mm.plugin.appbrand.u.d.a(this, params));
    parami.a(new com.tencent.mm.plugin.appbrand.u.d.c(this, params));
    parami.a(new com.tencent.mm.plugin.appbrand.u.d.b(this, params));
    this.njV = parami;
    this.njU = new ConcurrentHashMap();
    AppMethodBeat.o(147370);
  }
  
  public final void ap(int paramInt, String paramString)
  {
    AppMethodBeat.i(147373);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(147373);
      return;
    }
    paramString = String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.lxm.evaluateJavascript(paramString, null);
    AppMethodBeat.o(147373);
  }
  
  public final void bPS()
  {
    AppMethodBeat.i(147371);
    Log.i("MicroMsg.NodeJavaBroker", "shutdown");
    Iterator localIterator = this.njU.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.njU.clear();
    AppMethodBeat.o(147371);
  }
  
  public final void f(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147377);
    com.tencent.luggage.h.e.m(paramMap);
    paramMap = String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), new com.tencent.mm.ab.i(paramMap).toString() });
    this.lxm.evaluateJavascript(paramMap, null);
    AppMethodBeat.o(147377);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147375);
    com.tencent.mm.plugin.appbrand.u.a.e locale = this.njV.yG(paramInt1);
    if (locale == null)
    {
      Log.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      AppMethodBeat.o(147375);
      return;
    }
    locale.listen(paramInt2);
    this.njU.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    AppMethodBeat.o(147375);
  }
  
  @JavascriptInterface
  public void req(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(147372);
    Log.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.appbrand.u.a.a locala = b.yF(paramInt1);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147372);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.u.a.b))
    {
      paramString = new IllegalStateException("req asynchronously, but target cmd not async!");
      AppMethodBeat.o(147372);
      throw paramString;
    }
    paramString = new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(177511);
        String str = "MicroMsg.NodeJavaBroker~CMD~" + this.njX.bPT();
        AppMethodBeat.o(177511);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(147369);
        com.tencent.mm.plugin.appbrand.u.a.c localc = new com.tencent.mm.plugin.appbrand.u.a.c(d.a(d.this), paramInt2, d.this);
        this.njX.a(paramString, localc);
        AppMethodBeat.o(147369);
      }
    };
    com.tencent.f.h.RTc.aX(paramString);
    AppMethodBeat.o(147372);
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(147374);
    Log.v("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.appbrand.u.a.a locala = b.yF(paramInt);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147374);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.u.a.d))
    {
      paramString = new IllegalStateException("req synchronously, but target cmd not sync!");
      AppMethodBeat.o(147374);
      throw paramString;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.u.a.d)locala).a(paramString, new com.tencent.mm.plugin.appbrand.u.a.c(this.kAr));
    AppMethodBeat.o(147374);
    return paramString;
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    AppMethodBeat.i(147376);
    Object localObject = (Integer)this.njU.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(147376);
      return;
    }
    int i = ((Integer)localObject).intValue();
    Log.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = this.njV.yG(i);
    if (localObject == null)
    {
      Log.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      AppMethodBeat.o(147376);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.u.a.e)localObject).unListen(paramInt);
    this.njU.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(147376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d
 * JD-Core Version:    0.7.0.1
 */