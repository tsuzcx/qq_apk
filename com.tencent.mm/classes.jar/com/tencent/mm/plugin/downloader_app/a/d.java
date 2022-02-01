package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.event.a;
import com.tencent.mm.plugin.downloader.event.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> xsf;
  private static LinkedList<b> xsg;
  private static LinkedList<c> xsh;
  private static LinkedList<f> xsi;
  private static LinkedList<e> xsj;
  private static LinkedList<d> xsk;
  private static LinkedList<g> xsl;
  private static a.b xsm;
  
  static
  {
    AppMethodBeat.i(8895);
    xsf = new LinkedList();
    xsg = new LinkedList();
    xsh = new LinkedList();
    xsi = new LinkedList();
    xsj = new LinkedList();
    xsk = new LinkedList();
    xsl = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    xsf.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    xsg.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    xsh.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!xsk.contains(paramd)) {
      xsk.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!xsj.contains(parame)) {
      xsj.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    xsi.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!xsl.contains(paramg)) {
      xsl.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void anb(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = xsi.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).anf(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void anc(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = xsj.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).ane(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void and(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = xsl.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).ang(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    xsf.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    xsg.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    xsh.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    xsk.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    xsj.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    xsi.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    xsl.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void cuD()
  {
    AppMethodBeat.i(8872);
    a.b(xsm);
    xsm = null;
    xsf.clear();
    xsg.clear();
    xsh.clear();
    xsi.clear();
    xsj.clear();
    xsk.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void duT()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = xsg.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void duo()
  {
    AppMethodBeat.i(8871);
    if (xsm == null) {
      xsm = new a.b()
      {
        public final void S(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.T(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(xsm);
    AppMethodBeat.o(8871);
  }
  
  public static void lm(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = xsk.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).S(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = xsf.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).nH(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void nG(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = xsh.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).nI(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static abstract interface a
  {
    public abstract void nH(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void nI(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void S(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void ane(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void anf(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void ang(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */