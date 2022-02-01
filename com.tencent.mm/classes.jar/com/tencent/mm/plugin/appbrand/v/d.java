package com.tencent.mm.plugin.appbrand.v;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.a.b.a;
import com.tencent.mm.plugin.appbrand.v.a.e.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements b.a, e.a
{
  private final y qsi;
  private final com.tencent.mm.plugin.appbrand.n.i rvT;
  private final Map<Integer, Integer> tqq;
  private final e tqr;
  
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
  
  public d(y paramy, com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(147370);
    this.qsi = paramy;
    this.rvT = parami;
    parami = new e();
    parami.a(new com.tencent.mm.plugin.appbrand.v.d.a(this, paramy));
    parami.a(new com.tencent.mm.plugin.appbrand.v.d.c(this, paramy));
    parami.a(new com.tencent.mm.plugin.appbrand.v.d.b(this, paramy));
    this.tqr = parami;
    this.tqq = new ConcurrentHashMap();
    AppMethodBeat.o(147370);
  }
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(147373);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(147373);
      return;
    }
    paramString = String.format(Locale.ENGLISH, "typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.rvT.evaluateJavascript(paramString, null);
    AppMethodBeat.o(147373);
  }
  
  public final void cCW()
  {
    AppMethodBeat.i(147371);
    Log.i("MicroMsg.NodeJavaBroker", "shutdown");
    Iterator localIterator = this.tqq.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.tqq.clear();
    AppMethodBeat.o(147371);
  }
  
  public final void d(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147377);
    com.tencent.luggage.l.d.k(paramMap);
    paramMap = new com.tencent.mm.ad.i(paramMap).toString();
    paramMap = String.format(Locale.ENGLISH, "typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramMap });
    this.rvT.evaluateJavascript(paramMap, null);
    AppMethodBeat.o(147377);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147375);
    com.tencent.mm.plugin.appbrand.v.a.e locale = this.tqr.Cy(paramInt1);
    if (locale == null)
    {
      Log.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      AppMethodBeat.o(147375);
      return;
    }
    locale.CA(paramInt2);
    this.tqq.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    AppMethodBeat.o(147375);
  }
  
  @JavascriptInterface
  public void req(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(147372);
    Log.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.appbrand.v.a.a locala = b.Cx(paramInt1);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147372);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.v.a.b))
    {
      paramString = new IllegalStateException("req asynchronously, but target cmd not async!");
      AppMethodBeat.o(147372);
      throw paramString;
    }
    paramString = new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(177511);
        String str = "MicroMsg.NodeJavaBroker~CMD~" + this.tqt.cCX();
        AppMethodBeat.o(177511);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(147369);
        com.tencent.mm.plugin.appbrand.v.a.c localc = new com.tencent.mm.plugin.appbrand.v.a.c(d.a(d.this), paramInt2, d.this);
        this.tqt.a(paramString, localc);
        AppMethodBeat.o(147369);
      }
    };
    com.tencent.threadpool.h.ahAA.bm(paramString);
    AppMethodBeat.o(147372);
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(147374);
    Log.v("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.appbrand.v.a.a locala = b.Cx(paramInt);
    if ((!$assertionsDisabled) && (locala == null))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(147374);
      throw paramString;
    }
    if (!(locala instanceof com.tencent.mm.plugin.appbrand.v.a.d))
    {
      paramString = new IllegalStateException("req synchronously, but target cmd not sync!");
      AppMethodBeat.o(147374);
      throw paramString;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.v.a.d)locala).a(paramString, new com.tencent.mm.plugin.appbrand.v.a.c(this.qsi));
    AppMethodBeat.o(147374);
    return paramString;
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    AppMethodBeat.i(147376);
    Object localObject = (Integer)this.tqq.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(147376);
      return;
    }
    int i = ((Integer)localObject).intValue();
    Log.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = this.tqr.Cy(i);
    if (localObject == null)
    {
      Log.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      AppMethodBeat.o(147376);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.v.a.e)localObject).unListen(paramInt);
    this.tqq.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(147376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.d
 * JD-Core Version:    0.7.0.1
 */