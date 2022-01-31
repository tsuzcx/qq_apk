package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<d.a> laJ;
  private static LinkedList<d.b> laK;
  private static LinkedList<d.c> laL;
  private static LinkedList<d.f> laM;
  private static LinkedList<d.e> laN;
  private static LinkedList<d.d> laO;
  private static LinkedList<d.g> laP;
  private static a.b laQ;
  
  static
  {
    AppMethodBeat.i(136134);
    laJ = new LinkedList();
    laK = new LinkedList();
    laL = new LinkedList();
    laM = new LinkedList();
    laN = new LinkedList();
    laO = new LinkedList();
    laP = new LinkedList();
    AppMethodBeat.o(136134);
  }
  
  public static void JV(String paramString)
  {
    AppMethodBeat.i(136126);
    Iterator localIterator = laM.iterator();
    while (localIterator.hasNext()) {
      ((d.f)localIterator.next()).JZ(paramString);
    }
    AppMethodBeat.o(136126);
  }
  
  public static void JW(String paramString)
  {
    AppMethodBeat.i(136129);
    Iterator localIterator = laN.iterator();
    while (localIterator.hasNext()) {
      ((d.e)localIterator.next()).JY(paramString);
    }
    AppMethodBeat.o(136129);
  }
  
  public static void JX(String paramString)
  {
    AppMethodBeat.i(136132);
    Iterator localIterator = laP.iterator();
    while (localIterator.hasNext()) {
      ((d.g)localIterator.next()).Ka(paramString);
    }
    AppMethodBeat.o(136132);
  }
  
  public static void a(d.a parama)
  {
    AppMethodBeat.i(136115);
    laJ.add(parama);
    AppMethodBeat.o(136115);
  }
  
  public static void a(d.b paramb)
  {
    AppMethodBeat.i(136118);
    laK.add(paramb);
    AppMethodBeat.o(136118);
  }
  
  public static void a(d.c paramc)
  {
    AppMethodBeat.i(136121);
    laL.add(paramc);
    AppMethodBeat.o(136121);
  }
  
  public static void a(d.d paramd)
  {
    AppMethodBeat.i(136113);
    if (!laO.contains(paramd)) {
      laO.add(paramd);
    }
    AppMethodBeat.o(136113);
  }
  
  public static void a(d.e parame)
  {
    AppMethodBeat.i(136127);
    if (!laN.contains(parame)) {
      laN.add(parame);
    }
    AppMethodBeat.o(136127);
  }
  
  public static void a(d.f paramf)
  {
    AppMethodBeat.i(136124);
    laM.add(paramf);
    AppMethodBeat.o(136124);
  }
  
  public static void a(d.g paramg)
  {
    AppMethodBeat.i(136130);
    if (!laP.contains(paramg)) {
      laP.add(paramg);
    }
    AppMethodBeat.o(136130);
  }
  
  public static void b(d.a parama)
  {
    AppMethodBeat.i(136116);
    laJ.remove(parama);
    AppMethodBeat.o(136116);
  }
  
  public static void b(d.b paramb)
  {
    AppMethodBeat.i(136119);
    laK.remove(paramb);
    AppMethodBeat.o(136119);
  }
  
  public static void b(d.c paramc)
  {
    AppMethodBeat.i(136122);
    laL.remove(paramc);
    AppMethodBeat.o(136122);
  }
  
  public static void b(d.d paramd)
  {
    AppMethodBeat.i(136114);
    laO.remove(paramd);
    AppMethodBeat.o(136114);
  }
  
  public static void b(d.e parame)
  {
    AppMethodBeat.i(136128);
    laN.remove(parame);
    AppMethodBeat.o(136128);
  }
  
  public static void b(d.f paramf)
  {
    AppMethodBeat.i(136125);
    laM.remove(paramf);
    AppMethodBeat.o(136125);
  }
  
  public static void b(d.g paramg)
  {
    AppMethodBeat.i(136131);
    laP.remove(paramg);
    AppMethodBeat.o(136131);
  }
  
  public static void bjO()
  {
    AppMethodBeat.i(136120);
    Iterator localIterator = laK.iterator();
    while (localIterator.hasNext()) {
      ((d.b)localIterator.next()).onClick();
    }
    AppMethodBeat.o(136120);
  }
  
  public static void bje()
  {
    AppMethodBeat.i(136110);
    if (laQ == null) {
      laQ = new d.1();
    }
    a.a(laQ);
    AppMethodBeat.o(136110);
  }
  
  public static void bjf()
  {
    AppMethodBeat.i(136111);
    a.b(laQ);
    laQ = null;
    laJ.clear();
    laK.clear();
    laL.clear();
    laM.clear();
    laN.clear();
    laO.clear();
    AppMethodBeat.o(136111);
  }
  
  public static void gv(boolean paramBoolean)
  {
    AppMethodBeat.i(136117);
    Iterator localIterator = laJ.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).gx(paramBoolean);
    }
    AppMethodBeat.o(136117);
  }
  
  public static void gw(boolean paramBoolean)
  {
    AppMethodBeat.i(136123);
    Iterator localIterator = laL.iterator();
    while (localIterator.hasNext()) {
      ((d.c)localIterator.next()).gy(paramBoolean);
    }
    AppMethodBeat.o(136123);
  }
  
  public static void iV(long paramLong)
  {
    AppMethodBeat.i(136112);
    Iterator localIterator = laO.iterator();
    while (localIterator.hasNext()) {
      ((d.d)localIterator.next()).H(5, paramLong);
    }
    AppMethodBeat.o(136112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.d
 * JD-Core Version:    0.7.0.1
 */