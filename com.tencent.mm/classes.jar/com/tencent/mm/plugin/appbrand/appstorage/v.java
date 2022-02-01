package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class v
  implements q
{
  public final LinkedList<q> jQv;
  private final q jQw;
  
  public v(LinkedList<q> paramLinkedList)
  {
    AppMethodBeat.i(175580);
    this.jQw = new j();
    this.jQv = new LinkedList();
    this.jQv.addAll(paramLinkedList);
    AppMethodBeat.o(175580);
  }
  
  public final boolean LZ(String paramString)
  {
    AppMethodBeat.i(134373);
    int i = 0;
    while (i < 3)
    {
      if (com.tencent.luggage.h.k.C(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(134373);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(134373);
    return true;
  }
  
  public final com.tencent.mm.vfs.k MM(String paramString)
  {
    AppMethodBeat.i(195088);
    paramString = Na(paramString).MM(paramString);
    AppMethodBeat.o(195088);
    return paramString;
  }
  
  public final boolean MN(String paramString)
  {
    AppMethodBeat.i(195089);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq.LZ(paramString)) && (!localq.MN(paramString)))
      {
        AppMethodBeat.o(195089);
        return false;
      }
    }
    AppMethodBeat.o(195089);
    return true;
  }
  
  public final m MO(String paramString)
  {
    AppMethodBeat.i(134366);
    paramString = Na(paramString).MO(paramString);
    AppMethodBeat.o(134366);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.k MP(String paramString)
  {
    AppMethodBeat.i(175582);
    paramString = ae(paramString, false);
    AppMethodBeat.o(175582);
    return paramString;
  }
  
  public final boolean MQ(String paramString)
  {
    AppMethodBeat.i(175585);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq.LZ(paramString)) && (localq.MQ(paramString)))
      {
        AppMethodBeat.o(175585);
        return true;
      }
    }
    AppMethodBeat.o(175585);
    return false;
  }
  
  public com.tencent.mm.vfs.k MR(String paramString)
  {
    AppMethodBeat.i(134376);
    paramString = ((o)av(o.class)).MR(paramString);
    AppMethodBeat.o(134376);
    return paramString;
  }
  
  public final boolean MS(String paramString)
  {
    AppMethodBeat.i(134381);
    boolean bool = ((o)av(o.class)).MS(paramString);
    AppMethodBeat.o(134381);
    return bool;
  }
  
  public final InputStream MT(String paramString)
  {
    AppMethodBeat.i(134355);
    i locali = new i();
    m localm = b(paramString, locali);
    if (localm == m.jPM)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(134355);
      return paramString;
    }
    ae.e("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", new Object[] { localm, paramString });
    AppMethodBeat.o(134355);
    return null;
  }
  
  public final m Ma(String paramString)
  {
    AppMethodBeat.i(134358);
    paramString = Na(paramString).Ma(paramString);
    AppMethodBeat.o(134358);
    return paramString;
  }
  
  public final m Mc(String paramString)
  {
    AppMethodBeat.i(134359);
    paramString = Na(paramString).Mc(paramString);
    AppMethodBeat.o(134359);
    return paramString;
  }
  
  public final q Na(String paramString)
  {
    AppMethodBeat.i(134357);
    if (bu.isNullOrNil(paramString))
    {
      paramString = this.jQw;
      AppMethodBeat.o(134357);
      return paramString;
    }
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq.LZ(paramString))
      {
        AppMethodBeat.o(134357);
        return localq;
      }
    }
    paramString = this.jQw;
    AppMethodBeat.o(134357);
    return paramString;
  }
  
  public final m a(i<String> parami)
  {
    AppMethodBeat.i(134377);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((q)localIterator.next()).a(parami);
      if (localm != m.jQc)
      {
        AppMethodBeat.o(134377);
        return localm;
      }
    }
    parami = m.jQc;
    AppMethodBeat.o(134377);
    return parami;
  }
  
  public final m a(com.tencent.mm.vfs.k paramk, String paramString, i<String> parami)
  {
    AppMethodBeat.i(175587);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((q)localIterator.next()).a(paramk, paramString, parami);
      if (localm != m.jQc)
      {
        AppMethodBeat.o(175587);
        return localm;
      }
    }
    paramk = m.jQc;
    AppMethodBeat.o(175587);
    return paramk;
  }
  
  public m a(com.tencent.mm.vfs.k paramk, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175586);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((q)localIterator.next()).a(paramk, paramString, paramBoolean, parami);
      if (localm != m.jQc)
      {
        AppMethodBeat.o(175586);
        return localm;
      }
    }
    paramk = m.jQc;
    AppMethodBeat.o(175586);
    return paramk;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134364);
    paramString = Na(paramString).a(paramString, paramLong1, paramLong2, parami);
    AppMethodBeat.o(134364);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134367);
    paramString = Na(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(134367);
    return paramString;
  }
  
  public m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134362);
    paramString = Na(paramString).a(paramString, parami);
    AppMethodBeat.o(134362);
    return paramString;
  }
  
  public final m a(String paramString, com.tencent.mm.vfs.k paramk)
  {
    AppMethodBeat.i(175584);
    paramString = Na(paramString).a(paramString, paramk);
    AppMethodBeat.o(175584);
    return paramString;
  }
  
  public final m a(String paramString, com.tencent.mm.vfs.k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(175581);
    paramString = Na(paramString).a(paramString, paramk, paramBoolean);
    AppMethodBeat.o(175581);
    return paramString;
  }
  
  public final m a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134365);
    paramString = Na(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(134365);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.k ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175583);
    paramString = Na(paramString).ae(paramString, paramBoolean);
    AppMethodBeat.o(175583);
    return paramString;
  }
  
  public final m ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134360);
    paramString = Na(paramString).ag(paramString, paramBoolean);
    AppMethodBeat.o(134360);
    return paramString;
  }
  
  public final m ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    paramString = Na(paramString).ah(paramString, paramBoolean);
    AppMethodBeat.o(134361);
    return paramString;
  }
  
  public final <T extends q> T av(Class<T> paramClass)
  {
    AppMethodBeat.i(134356);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (paramClass.isInstance(localq))
      {
        AppMethodBeat.o(134356);
        return localq;
      }
    }
    AppMethodBeat.o(134356);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134363);
    paramString = Na(paramString).b(paramString, parami);
    AppMethodBeat.o(134363);
    return paramString;
  }
  
  public List<? extends q.a> bcd()
  {
    AppMethodBeat.i(134380);
    List localList = ((o)av(o.class)).jQe.bch();
    AppMethodBeat.o(134380);
    return localList;
  }
  
  public final LinkedList<q> bcg()
  {
    return this.jQv;
  }
  
  public final m g(String paramString, List<x> paramList)
  {
    AppMethodBeat.i(134368);
    paramString = Na(paramString).g(paramString, paramList);
    AppMethodBeat.o(134368);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134374);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).initialize();
    }
    this.jQw.initialize();
    AppMethodBeat.o(134374);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134375);
    Iterator localIterator = this.jQv.iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).release();
    }
    this.jQv.clear();
    this.jQw.release();
    AppMethodBeat.o(134375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.v
 * JD-Core Version:    0.7.0.1
 */