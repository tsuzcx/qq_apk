package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<a> ohC;
  private static LinkedList<b> ohD;
  private static LinkedList<c> ohE;
  private static LinkedList<f> ohF;
  private static LinkedList<e> ohG;
  private static LinkedList<d> ohH;
  private static LinkedList<g> ohI;
  private static a.b ohJ;
  
  static
  {
    AppMethodBeat.i(8895);
    ohC = new LinkedList();
    ohD = new LinkedList();
    ohE = new LinkedList();
    ohF = new LinkedList();
    ohG = new LinkedList();
    ohH = new LinkedList();
    ohI = new LinkedList();
    AppMethodBeat.o(8895);
  }
  
  public static void SD(String paramString)
  {
    AppMethodBeat.i(8887);
    Iterator localIterator = ohF.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).SH(paramString);
    }
    AppMethodBeat.o(8887);
  }
  
  public static void SE(String paramString)
  {
    AppMethodBeat.i(8890);
    Iterator localIterator = ohG.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).SG(paramString);
    }
    AppMethodBeat.o(8890);
  }
  
  public static void SF(String paramString)
  {
    AppMethodBeat.i(8893);
    Iterator localIterator = ohI.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).SI(paramString);
    }
    AppMethodBeat.o(8893);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(8876);
    ohC.add(parama);
    AppMethodBeat.o(8876);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(8879);
    ohD.add(paramb);
    AppMethodBeat.o(8879);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(8882);
    ohE.add(paramc);
    AppMethodBeat.o(8882);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(8874);
    if (!ohH.contains(paramd)) {
      ohH.add(paramd);
    }
    AppMethodBeat.o(8874);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(8888);
    if (!ohG.contains(parame)) {
      ohG.add(parame);
    }
    AppMethodBeat.o(8888);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(8885);
    ohF.add(paramf);
    AppMethodBeat.o(8885);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(8891);
    if (!ohI.contains(paramg)) {
      ohI.add(paramg);
    }
    AppMethodBeat.o(8891);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(8877);
    ohC.remove(parama);
    AppMethodBeat.o(8877);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(8880);
    ohD.remove(paramb);
    AppMethodBeat.o(8880);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(8883);
    ohE.remove(paramc);
    AppMethodBeat.o(8883);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(8875);
    ohH.remove(paramd);
    AppMethodBeat.o(8875);
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(8889);
    ohG.remove(parame);
    AppMethodBeat.o(8889);
  }
  
  public static void b(f paramf)
  {
    AppMethodBeat.i(8886);
    ohF.remove(paramf);
    AppMethodBeat.o(8886);
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(8892);
    ohI.remove(paramg);
    AppMethodBeat.o(8892);
  }
  
  public static void bQY()
  {
    AppMethodBeat.i(8881);
    Iterator localIterator = ohD.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(8881);
  }
  
  public static void bQj()
  {
    AppMethodBeat.i(8871);
    if (ohJ == null) {
      ohJ = new a.b()
      {
        public final void L(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8870);
          d.M(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(8870);
        }
      };
    }
    a.a(ohJ);
    AppMethodBeat.o(8871);
  }
  
  public static void bQk()
  {
    AppMethodBeat.i(8872);
    a.b(ohJ);
    ohJ = null;
    ohC.clear();
    ohD.clear();
    ohE.clear();
    ohF.clear();
    ohG.clear();
    ohH.clear();
    AppMethodBeat.o(8872);
  }
  
  public static void jh(boolean paramBoolean)
  {
    AppMethodBeat.i(8878);
    Iterator localIterator = ohC.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).jj(paramBoolean);
    }
    AppMethodBeat.o(8878);
  }
  
  public static void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(8884);
    Iterator localIterator = ohE.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).jk(paramBoolean);
    }
    AppMethodBeat.o(8884);
  }
  
  public static void oD(long paramLong)
  {
    AppMethodBeat.i(8873);
    Iterator localIterator = ohH.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).L(5, paramLong);
    }
    AppMethodBeat.o(8873);
  }
  
  public static abstract interface a
  {
    public abstract void jj(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
  
  public static abstract interface c
  {
    public abstract void jk(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void L(int paramInt, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void SG(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void SH(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void SI(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.d
 * JD-Core Version:    0.7.0.1
 */