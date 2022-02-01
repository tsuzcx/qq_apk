package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class t
  implements p
{
  public final LinkedList<p> iSX;
  private final p iSY;
  
  public t(LinkedList<p> paramLinkedList)
  {
    AppMethodBeat.i(175580);
    this.iSY = new i();
    this.iSX = new LinkedList();
    this.iSX.addAll(paramLinkedList);
    AppMethodBeat.o(175580);
  }
  
  public final l EO(String paramString)
  {
    AppMethodBeat.i(134366);
    paramString = EZ(paramString).EO(paramString);
    AppMethodBeat.o(134366);
    return paramString;
  }
  
  public final e EP(String paramString)
  {
    AppMethodBeat.i(175582);
    paramString = ad(paramString, false);
    AppMethodBeat.o(175582);
    return paramString;
  }
  
  public final boolean EQ(String paramString)
  {
    AppMethodBeat.i(175585);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((localp.Eb(paramString)) && (localp.EQ(paramString)))
      {
        AppMethodBeat.o(175585);
        return true;
      }
    }
    AppMethodBeat.o(175585);
    return false;
  }
  
  public e ER(String paramString)
  {
    AppMethodBeat.i(134376);
    paramString = ((n)av(n.class)).ER(paramString);
    AppMethodBeat.o(134376);
    return paramString;
  }
  
  public final boolean ES(String paramString)
  {
    AppMethodBeat.i(134381);
    boolean bool = ((n)av(n.class)).ES(paramString);
    AppMethodBeat.o(134381);
    return bool;
  }
  
  public final InputStream ET(String paramString)
  {
    AppMethodBeat.i(134355);
    com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
    l locall = b(paramString, locali);
    if (locall == l.iSq)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(134355);
      return paramString;
    }
    ad.e("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", new Object[] { locall, paramString });
    AppMethodBeat.o(134355);
    return null;
  }
  
  public final p EZ(String paramString)
  {
    AppMethodBeat.i(134357);
    if (bt.isNullOrNil(paramString))
    {
      paramString = this.iSY;
      AppMethodBeat.o(134357);
      return paramString;
    }
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (localp.Eb(paramString))
      {
        AppMethodBeat.o(134357);
        return localp;
      }
    }
    paramString = this.iSY;
    AppMethodBeat.o(134357);
    return paramString;
  }
  
  public final boolean Eb(String paramString)
  {
    AppMethodBeat.i(134373);
    int i = 0;
    while (i < 3)
    {
      if (k.A(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(134373);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(134373);
    return true;
  }
  
  public final l Ec(String paramString)
  {
    AppMethodBeat.i(134358);
    paramString = EZ(paramString).Ec(paramString);
    AppMethodBeat.o(134358);
    return paramString;
  }
  
  public final l Ee(String paramString)
  {
    AppMethodBeat.i(134359);
    paramString = EZ(paramString).Ee(paramString);
    AppMethodBeat.o(134359);
    return paramString;
  }
  
  public final l a(com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    AppMethodBeat.i(134377);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext())
    {
      l locall = ((p)localIterator.next()).a(parami);
      if (locall != l.iSG)
      {
        AppMethodBeat.o(134377);
        return locall;
      }
    }
    parami = l.iSG;
    AppMethodBeat.o(134377);
    return parami;
  }
  
  public final l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    AppMethodBeat.i(175587);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext())
    {
      l locall = ((p)localIterator.next()).a(parame, paramString, parami);
      if (locall != l.iSG)
      {
        AppMethodBeat.o(175587);
        return locall;
      }
    }
    parame = l.iSG;
    AppMethodBeat.o(175587);
    return parame;
  }
  
  public l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    AppMethodBeat.i(175586);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext())
    {
      l locall = ((p)localIterator.next()).a(parame, paramString, paramBoolean, parami);
      if (locall != l.iSG)
      {
        AppMethodBeat.o(175586);
        return locall;
      }
    }
    parame = l.iSG;
    AppMethodBeat.o(175586);
    return parame;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134364);
    paramString = EZ(paramString).a(paramString, paramLong1, paramLong2, parami);
    AppMethodBeat.o(134364);
    return paramString;
  }
  
  public l a(String paramString, com.tencent.mm.plugin.appbrand.aa.i<List<j>> parami)
  {
    AppMethodBeat.i(134362);
    paramString = EZ(paramString).a(paramString, parami);
    AppMethodBeat.o(134362);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134367);
    paramString = EZ(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(134367);
    return paramString;
  }
  
  public final l a(String paramString, e parame)
  {
    AppMethodBeat.i(175584);
    paramString = EZ(paramString).a(paramString, parame);
    AppMethodBeat.o(175584);
    return paramString;
  }
  
  public final l a(String paramString, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(175581);
    paramString = EZ(paramString).a(paramString, parame, paramBoolean);
    AppMethodBeat.o(175581);
    return paramString;
  }
  
  public final l a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134365);
    paramString = EZ(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(134365);
    return paramString;
  }
  
  public List<? extends p.a> aRh()
  {
    AppMethodBeat.i(134380);
    List localList = ((n)av(n.class)).iSL.aRj();
    AppMethodBeat.o(134380);
    return localList;
  }
  
  public final LinkedList<p> aRi()
  {
    return this.iSX;
  }
  
  public final e ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175583);
    paramString = EZ(paramString).ad(paramString, paramBoolean);
    AppMethodBeat.o(175583);
    return paramString;
  }
  
  public final l af(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134360);
    paramString = EZ(paramString).af(paramString, paramBoolean);
    AppMethodBeat.o(134360);
    return paramString;
  }
  
  public final l ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    paramString = EZ(paramString).ag(paramString, paramBoolean);
    AppMethodBeat.o(134361);
    return paramString;
  }
  
  public final <T extends p> T av(Class<T> paramClass)
  {
    AppMethodBeat.i(134356);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (paramClass.isInstance(localp))
      {
        AppMethodBeat.o(134356);
        return localp;
      }
    }
    AppMethodBeat.o(134356);
    return null;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134363);
    paramString = EZ(paramString).b(paramString, parami);
    AppMethodBeat.o(134363);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134374);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext()) {
      ((p)localIterator.next()).initialize();
    }
    this.iSY.initialize();
    AppMethodBeat.o(134374);
  }
  
  public final l j(String paramString, List<v> paramList)
  {
    AppMethodBeat.i(134368);
    paramString = EZ(paramString).j(paramString, paramList);
    AppMethodBeat.o(134368);
    return paramString;
  }
  
  public final void release()
  {
    AppMethodBeat.i(134375);
    Iterator localIterator = this.iSX.iterator();
    while (localIterator.hasNext()) {
      ((p)localIterator.next()).release();
    }
    this.iSX.clear();
    this.iSY.release();
    AppMethodBeat.o(134375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.t
 * JD-Core Version:    0.7.0.1
 */