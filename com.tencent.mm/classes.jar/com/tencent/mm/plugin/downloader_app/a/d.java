package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> pvq;
  private static LinkedList<b> pvr;
  private static LinkedList<c> pvs;
  private static LinkedList<f> pvt;
  private static LinkedList<e> pvu;
  private static LinkedList<d> pvv;
  private static LinkedList<g> pvw;
  private static a.b pvx;
  
  static
  {
    AppMethodBeat.i(8895);
    pvq = new LinkedList();
    pvr = new LinkedList();
    pvs = new LinkedList();
    pvt = new LinkedList();
    pvu = new LinkedList();
    pvv = new LinkedList();
    pvw = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    pvq.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    pvr.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    pvs.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!pvv.contains(paramd)) {
      pvv.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!pvu.contains(parame)) {
      pvu.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    pvt.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!pvw.contains(paramg)) {
      pvw.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void abn(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = pvt.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).abr(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void abo(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = pvu.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).abq(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void abp(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = pvw.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).abs(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    pvq.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    pvr.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    pvs.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    pvv.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    pvu.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    pvt.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    pvw.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void cds()
  {
    AppMethodBeat.i(8871);
    if (pvx == null) {
      pvx = new a.b()
      {
        public final void L(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.M(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(pvx);
    AppMethodBeat.o(8871);
  }
  
  public static void cdt()
  {
    AppMethodBeat.i(8872);
    a.b(pvx);
    pvx = null;
    pvq.clear();
    pvr.clear();
    pvs.clear();
    pvt.clear();
    pvu.clear();
    pvv.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void ceg()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = pvr.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void jU(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = pvq.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).jW(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = pvs.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).jX(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static void uE(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = pvv.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).L(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static abstract interface a
  {
    public abstract void jW(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void jX(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void L(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void abq(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void abr(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void abs(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */