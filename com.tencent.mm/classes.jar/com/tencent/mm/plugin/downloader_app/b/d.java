package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<d.a> iSd = new LinkedList();
  private static LinkedList<d.b> iSe = new LinkedList();
  private static LinkedList<d.c> iSf = new LinkedList();
  private static LinkedList<d.f> iSg = new LinkedList();
  private static LinkedList<d.e> iSh = new LinkedList();
  private static LinkedList<d.d> iSi = new LinkedList();
  private static a.b iSj;
  
  public static void Aa(String paramString)
  {
    Iterator localIterator = iSh.iterator();
    while (localIterator.hasNext()) {
      ((d.e)localIterator.next()).Ab(paramString);
    }
  }
  
  public static void a(d.a parama)
  {
    iSd.add(parama);
  }
  
  public static void a(d.b paramb)
  {
    iSe.add(paramb);
  }
  
  public static void a(d.c paramc)
  {
    iSf.add(paramc);
  }
  
  public static void a(d.d paramd)
  {
    if (!iSi.contains(paramd)) {
      iSi.add(paramd);
    }
  }
  
  public static void a(d.e parame)
  {
    if (!iSh.contains(parame)) {
      iSh.add(parame);
    }
  }
  
  public static void a(d.f paramf)
  {
    iSg.add(paramf);
  }
  
  public static void aFI()
  {
    if (iSj == null) {
      iSj = new d.1();
    }
    a.a(iSj);
  }
  
  public static void aFJ()
  {
    a.b(iSj);
    iSj = null;
    iSd.clear();
    iSe.clear();
    iSf.clear();
    iSg.clear();
    iSh.clear();
    iSi.clear();
  }
  
  public static void aGl()
  {
    Iterator localIterator = iSe.iterator();
    while (localIterator.hasNext()) {
      ((d.b)localIterator.next()).onClick();
    }
  }
  
  public static void b(d.a parama)
  {
    iSd.remove(parama);
  }
  
  public static void b(d.b paramb)
  {
    iSe.remove(paramb);
  }
  
  public static void b(d.c paramc)
  {
    iSf.remove(paramc);
  }
  
  public static void b(d.d paramd)
  {
    iSi.remove(paramd);
  }
  
  public static void b(d.e parame)
  {
    iSh.remove(parame);
  }
  
  public static void b(d.f paramf)
  {
    iSg.remove(paramf);
  }
  
  public static void eS(boolean paramBoolean)
  {
    Iterator localIterator = iSd.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).eU(paramBoolean);
    }
  }
  
  public static void eT(boolean paramBoolean)
  {
    Iterator localIterator = iSf.iterator();
    while (localIterator.hasNext()) {
      ((d.c)localIterator.next()).eV(paramBoolean);
    }
  }
  
  public static void zY(String paramString)
  {
    Iterator localIterator = iSi.iterator();
    while (localIterator.hasNext()) {
      ((d.d)localIterator.next()).X(5, paramString);
    }
  }
  
  public static void zZ(String paramString)
  {
    Iterator localIterator = iSg.iterator();
    while (localIterator.hasNext()) {
      ((d.f)localIterator.next()).Ac(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.d
 * JD-Core Version:    0.7.0.1
 */