package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class t
  implements p
{
  public final LinkedList<p> jti;
  private final p jtj;
  
  public t(LinkedList<p> paramLinkedList)
  {
    AppMethodBeat.i(175580);
    this.jtj = new i();
    this.jti = new LinkedList();
    this.jti.addAll(paramLinkedList);
    AppMethodBeat.o(175580);
  }
  
  public final l IR(String paramString)
  {
    AppMethodBeat.i(134366);
    paramString = Jc(paramString).IR(paramString);
    AppMethodBeat.o(134366);
    return paramString;
  }
  
  public final e IS(String paramString)
  {
    AppMethodBeat.i(175582);
    paramString = ae(paramString, false);
    AppMethodBeat.o(175582);
    return paramString;
  }
  
  public final boolean IT(String paramString)
  {
    AppMethodBeat.i(175585);
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((localp.Ie(paramString)) && (localp.IT(paramString)))
      {
        AppMethodBeat.o(175585);
        return true;
      }
    }
    AppMethodBeat.o(175585);
    return false;
  }
  
  public e IU(String paramString)
  {
    AppMethodBeat.i(134376);
    paramString = ((n)av(n.class)).IU(paramString);
    AppMethodBeat.o(134376);
    return paramString;
  }
  
  public final boolean IV(String paramString)
  {
    AppMethodBeat.i(134381);
    boolean bool = ((n)av(n.class)).IV(paramString);
    AppMethodBeat.o(134381);
    return bool;
  }
  
  public final InputStream IW(String paramString)
  {
    AppMethodBeat.i(134355);
    com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    l locall = b(paramString, locali);
    if (locall == l.jsB)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(134355);
      return paramString;
    }
    ac.e("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", new Object[] { locall, paramString });
    AppMethodBeat.o(134355);
    return null;
  }
  
  public final boolean Ie(String paramString)
  {
    AppMethodBeat.i(134373);
    int i = 0;
    while (i < 3)
    {
      if (k.B(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(134373);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(134373);
    return true;
  }
  
  public final l If(String paramString)
  {
    AppMethodBeat.i(134358);
    paramString = Jc(paramString).If(paramString);
    AppMethodBeat.o(134358);
    return paramString;
  }
  
  public final l Ih(String paramString)
  {
    AppMethodBeat.i(134359);
    paramString = Jc(paramString).Ih(paramString);
    AppMethodBeat.o(134359);
    return paramString;
  }
  
  public final p Jc(String paramString)
  {
    AppMethodBeat.i(134357);
    if (bs.isNullOrNil(paramString))
    {
      paramString = this.jtj;
      AppMethodBeat.o(134357);
      return paramString;
    }
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (localp.Ie(paramString))
      {
        AppMethodBeat.o(134357);
        return localp;
      }
    }
    paramString = this.jtj;
    AppMethodBeat.o(134357);
    return paramString;
  }
  
  public final l a(com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    AppMethodBeat.i(134377);
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext())
    {
      l locall = ((p)localIterator.next()).a(parami);
      if (locall != l.jsR)
      {
        AppMethodBeat.o(134377);
        return locall;
      }
    }
    parami = l.jsR;
    AppMethodBeat.o(134377);
    return parami;
  }
  
  public final l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    AppMethodBeat.i(175587);
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext())
    {
      l locall = ((p)localIterator.next()).a(parame, paramString, parami);
      if (locall != l.jsR)
      {
        AppMethodBeat.o(175587);
        return locall;
      }
    }
    parame = l.jsR;
    AppMethodBeat.o(175587);
    return parame;
  }
  
  public l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    AppMethodBeat.i(175586);
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext())
    {
      l locall = ((p)localIterator.next()).a(parame, paramString, paramBoolean, parami);
      if (locall != l.jsR)
      {
        AppMethodBeat.o(175586);
        return locall;
      }
    }
    parame = l.jsR;
    AppMethodBeat.o(175586);
    return parame;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134364);
    paramString = Jc(paramString).a(paramString, paramLong1, paramLong2, parami);
    AppMethodBeat.o(134364);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134367);
    paramString = Jc(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(134367);
    return paramString;
  }
  
  public l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    AppMethodBeat.i(134362);
    paramString = Jc(paramString).a(paramString, parami);
    AppMethodBeat.o(134362);
    return paramString;
  }
  
  public final l a(String paramString, e parame)
  {
    AppMethodBeat.i(175584);
    paramString = Jc(paramString).a(paramString, parame);
    AppMethodBeat.o(175584);
    return paramString;
  }
  
  public final l a(String paramString, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(175581);
    paramString = Jc(paramString).a(paramString, parame, paramBoolean);
    AppMethodBeat.o(175581);
    return paramString;
  }
  
  public final l a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134365);
    paramString = Jc(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(134365);
    return paramString;
  }
  
  public List<? extends p.a> aYc()
  {
    AppMethodBeat.i(134380);
    List localList = ((n)av(n.class)).jsW.aYe();
    AppMethodBeat.o(134380);
    return localList;
  }
  
  public final LinkedList<p> aYd()
  {
    return this.jti;
  }
  
  public final e ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175583);
    paramString = Jc(paramString).ae(paramString, paramBoolean);
    AppMethodBeat.o(175583);
    return paramString;
  }
  
  public final l ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134360);
    paramString = Jc(paramString).ag(paramString, paramBoolean);
    AppMethodBeat.o(134360);
    return paramString;
  }
  
  public final l ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    paramString = Jc(paramString).ah(paramString, paramBoolean);
    AppMethodBeat.o(134361);
    return paramString;
  }
  
  public final <T extends p> T av(Class<T> paramClass)
  {
    AppMethodBeat.i(134356);
    Iterator localIterator = this.jti.iterator();
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
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134363);
    paramString = Jc(paramString).b(paramString, parami);
    AppMethodBeat.o(134363);
    return paramString;
  }
  
  public final l h(String paramString, List<v> paramList)
  {
    AppMethodBeat.i(134368);
    paramString = Jc(paramString).h(paramString, paramList);
    AppMethodBeat.o(134368);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134374);
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext()) {
      ((p)localIterator.next()).initialize();
    }
    this.jtj.initialize();
    AppMethodBeat.o(134374);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134375);
    Iterator localIterator = this.jti.iterator();
    while (localIterator.hasNext()) {
      ((p)localIterator.next()).release();
    }
    this.jti.clear();
    this.jtj.release();
    AppMethodBeat.o(134375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.t
 * JD-Core Version:    0.7.0.1
 */