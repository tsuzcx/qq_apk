package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> poK;
  private static LinkedList<b> poL;
  private static LinkedList<c> poM;
  private static LinkedList<f> poN;
  private static LinkedList<e> poO;
  private static LinkedList<d> poP;
  private static LinkedList<g> poQ;
  private static a.b poR;
  
  static
  {
    AppMethodBeat.i(8895);
    poK = new LinkedList();
    poL = new LinkedList();
    poM = new LinkedList();
    poN = new LinkedList();
    poO = new LinkedList();
    poP = new LinkedList();
    poQ = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    poK.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    poL.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    poM.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!poP.contains(paramd)) {
      poP.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!poO.contains(parame)) {
      poO.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    poN.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!poQ.contains(paramg)) {
      poQ.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void aaw(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = poN.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).aaA(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void aax(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = poO.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).aaz(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void aay(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = poQ.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).aaB(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    poK.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    poL.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    poM.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    poP.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    poO.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    poN.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    poQ.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void ccR()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = poL.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void ccd()
  {
    AppMethodBeat.i(8871);
    if (poR == null) {
      poR = new a.b()
      {
        public final void M(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.N(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(poR);
    AppMethodBeat.o(8871);
  }
  
  public static void cce()
  {
    AppMethodBeat.i(8872);
    a.b(poR);
    poR = null;
    poK.clear();
    poL.clear();
    poM.clear();
    poN.clear();
    poO.clear();
    poP.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = poK.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).jX(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void jW(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = poM.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).jY(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static void un(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = poP.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).M(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static abstract interface a
  {
    public abstract void jX(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void jY(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void M(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void aaz(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void aaA(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void aaB(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */