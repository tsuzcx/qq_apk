package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> ulT;
  private static LinkedList<b> ulU;
  private static LinkedList<c> ulV;
  private static LinkedList<f> ulW;
  private static LinkedList<e> ulX;
  private static LinkedList<d> ulY;
  private static LinkedList<g> ulZ;
  private static a.b uma;
  
  static
  {
    AppMethodBeat.i(8895);
    ulT = new LinkedList();
    ulU = new LinkedList();
    ulV = new LinkedList();
    ulW = new LinkedList();
    ulX = new LinkedList();
    ulY = new LinkedList();
    ulZ = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void IR(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = ulY.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).O(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    ulT.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    ulU.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    ulV.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!ulY.contains(paramd)) {
      ulY.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!ulX.contains(parame)) {
      ulX.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    ulW.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!ulZ.contains(paramg)) {
      ulZ.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void atm(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = ulW.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).atq(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void atn(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = ulX.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).atp(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void ato(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = ulZ.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).atr(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    ulT.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    ulU.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    ulV.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    ulY.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    ulX.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    ulW.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    ulZ.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void cPR()
  {
    AppMethodBeat.i(8871);
    if (uma == null) {
      uma = new a.b()
      {
        public final void O(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.P(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(uma);
    AppMethodBeat.o(8871);
  }
  
  public static void cPS()
  {
    AppMethodBeat.i(8872);
    a.b(uma);
    uma = null;
    ulT.clear();
    ulU.clear();
    ulV.clear();
    ulW.clear();
    ulX.clear();
    ulY.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void cQA()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = ulU.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void mj(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = ulT.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ml(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = ulV.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).mm(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static abstract interface a
  {
    public abstract void ml(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void mm(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void O(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void atp(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void atq(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void atr(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */