package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> oLc;
  private static LinkedList<b> oLd;
  private static LinkedList<c> oLe;
  private static LinkedList<f> oLf;
  private static LinkedList<e> oLg;
  private static LinkedList<d> oLh;
  private static LinkedList<g> oLi;
  private static a.b oLj;
  
  static
  {
    AppMethodBeat.i(8895);
    oLc = new LinkedList();
    oLd = new LinkedList();
    oLe = new LinkedList();
    oLf = new LinkedList();
    oLg = new LinkedList();
    oLh = new LinkedList();
    oLi = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void WP(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = oLf.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).WT(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void WQ(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = oLg.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).WS(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void WR(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = oLi.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).WU(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    oLc.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    oLd.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    oLe.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!oLh.contains(paramd)) {
      oLh.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!oLg.contains(parame)) {
      oLg.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    oLf.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!oLi.contains(paramg)) {
      oLi.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    oLc.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    oLd.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    oLe.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    oLh.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    oLg.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    oLf.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    oLi.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void bXA()
  {
    AppMethodBeat.i(8871);
    if (oLj == null) {
      oLj = new a.b()
      {
        public final void K(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.L(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(oLj);
    AppMethodBeat.o(8871);
  }
  
  public static void bXB()
  {
    AppMethodBeat.i(8872);
    a.b(oLj);
    oLj = null;
    oLc.clear();
    oLd.clear();
    oLe.clear();
    oLf.clear();
    oLg.clear();
    oLh.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void bYn()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = oLd.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = oLc.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).jM(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = oLe.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).jN(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static void sp(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = oLh.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).K(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static abstract interface a
  {
    public abstract void jM(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void jN(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void K(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void WS(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void WT(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void WU(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */