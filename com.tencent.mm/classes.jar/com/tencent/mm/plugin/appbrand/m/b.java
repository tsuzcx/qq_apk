package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.d;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;

public final class b
{
  public static int FAILED = -1;
  public static int SUCCESS = 0;
  public c hrA;
  public final String igf;
  protected final ArrayList<String> isA;
  public final Map<String, ConcurrentLinkedQueue<Runnable>> isB;
  public final ArrayList<com.tencent.mm.plugin.appbrand.m.a.b> isC;
  public int isx;
  public String isy;
  public SSLContext isz;
  
  public b(c paramc)
  {
    AppMethodBeat.i(108134);
    this.isy = (e.esq + "appbrand/");
    this.isA = new ArrayList();
    this.isC = new ArrayList();
    this.hrA = paramc;
    paramc = (a)paramc.U(a.class);
    this.isx = paramc.bDs;
    this.igf = paramc.isv;
    this.isz = j.a(paramc);
    this.isB = new Hashtable(10);
    AppMethodBeat.o(108134);
  }
  
  private void lI(String paramString)
  {
    AppMethodBeat.i(108136);
    if (paramString == null)
    {
      AppMethodBeat.o(108136);
      return;
    }
    synchronized (this.isC)
    {
      Iterator localIterator = this.isC.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.m.a.b localb = (com.tencent.mm.plugin.appbrand.m.a.b)localIterator.next();
        if (paramString.equals(localb.hwp)) {
          this.isC.remove(localb);
        }
      }
      AppMethodBeat.o(108136);
      return;
    }
  }
  
  public final void DL(String paramString)
  {
    AppMethodBeat.i(108135);
    d.post(new b.2(this, paramString), "appbrand_download_thread");
    AppMethodBeat.o(108135);
  }
  
  public final com.tencent.mm.plugin.appbrand.m.a.b DM(String paramString)
  {
    AppMethodBeat.i(108137);
    if (paramString == null)
    {
      AppMethodBeat.o(108137);
      return null;
    }
    synchronized (this.isC)
    {
      Iterator localIterator = this.isC.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.m.a.b localb = (com.tencent.mm.plugin.appbrand.m.a.b)localIterator.next();
        if (paramString.equals(localb.hwp))
        {
          AppMethodBeat.o(108137);
          return localb;
        }
      }
      AppMethodBeat.o(108137);
      return null;
    }
  }
  
  public final boolean DN(String paramString)
  {
    AppMethodBeat.i(108139);
    boolean bool = this.isA.contains(paramString);
    AppMethodBeat.o(108139);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.m.a.b paramb)
  {
    AppMethodBeat.i(108138);
    if (paramb == null)
    {
      AppMethodBeat.o(108138);
      return;
    }
    this.isA.add(paramb.hwp);
    lI(paramb.hwp);
    paramb.aIw();
    AppMethodBeat.o(108138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.b
 * JD-Core Version:    0.7.0.1
 */