package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> qKH;
  private static LinkedList<b> qKI;
  private static LinkedList<c> qKJ;
  private static LinkedList<f> qKK;
  private static LinkedList<e> qKL;
  private static LinkedList<d> qKM;
  private static LinkedList<g> qKN;
  private static a.b qKO;
  
  static
  {
    AppMethodBeat.i(8895);
    qKH = new LinkedList();
    qKI = new LinkedList();
    qKJ = new LinkedList();
    qKK = new LinkedList();
    qKL = new LinkedList();
    qKM = new LinkedList();
    qKN = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void CI(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = qKM.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).O(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    qKH.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    qKI.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    qKJ.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!qKM.contains(paramd)) {
      qKM.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!qKL.contains(parame)) {
      qKL.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    qKK.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!qKN.contains(paramg)) {
      qKN.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void alt(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = qKK.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).alx(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void alu(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = qKL.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).alw(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void alv(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = qKN.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).aly(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    qKH.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    qKI.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    qKJ.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    qKM.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    qKL.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    qKK.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    qKN.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void cBW()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = qKI.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void cBn()
  {
    AppMethodBeat.i(8871);
    if (qKO == null) {
      qKO = new a.b()
      {
        public final void O(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.P(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(qKO);
    AppMethodBeat.o(8871);
  }
  
  public static void cBo()
  {
    AppMethodBeat.i(8872);
    a.b(qKO);
    qKO = null;
    qKH.clear();
    qKI.clear();
    qKJ.clear();
    qKK.clear();
    qKL.clear();
    qKM.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void kX(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = qKH.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).kZ(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void kY(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = qKJ.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).la(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static abstract interface a
  {
    public abstract void kZ(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void la(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void O(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void alw(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void alx(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void aly(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */