package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class v
  implements q
{
  public final LinkedList<q> kTe;
  private final q kTf;
  
  public v(LinkedList<q> paramLinkedList)
  {
    AppMethodBeat.i(175580);
    this.kTf = new j();
    this.kTe = new LinkedList();
    this.kTe.addAll(paramLinkedList);
    AppMethodBeat.o(175580);
  }
  
  public final com.tencent.mm.vfs.o VV(String paramString)
  {
    AppMethodBeat.i(196178);
    paramString = Wj(paramString).VV(paramString);
    AppMethodBeat.o(196178);
    return paramString;
  }
  
  public final boolean VW(String paramString)
  {
    AppMethodBeat.i(196179);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq.Vi(paramString)) && (!localq.VW(paramString)))
      {
        AppMethodBeat.o(196179);
        return false;
      }
    }
    AppMethodBeat.o(196179);
    return true;
  }
  
  public final m VX(String paramString)
  {
    AppMethodBeat.i(134366);
    paramString = Wj(paramString).VX(paramString);
    AppMethodBeat.o(134366);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.o VY(String paramString)
  {
    AppMethodBeat.i(175582);
    paramString = ag(paramString, false);
    AppMethodBeat.o(175582);
    return paramString;
  }
  
  public final boolean VZ(String paramString)
  {
    AppMethodBeat.i(175585);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq.Vi(paramString)) && (localq.VZ(paramString)))
      {
        AppMethodBeat.o(175585);
        return true;
      }
    }
    AppMethodBeat.o(175585);
    return false;
  }
  
  public final boolean Vi(String paramString)
  {
    AppMethodBeat.i(134373);
    int i = 0;
    while (i < 3)
    {
      if (l.C(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(134373);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(134373);
    return true;
  }
  
  public final m Vj(String paramString)
  {
    AppMethodBeat.i(134358);
    paramString = Wj(paramString).Vj(paramString);
    AppMethodBeat.o(134358);
    return paramString;
  }
  
  public final m Vl(String paramString)
  {
    AppMethodBeat.i(134359);
    paramString = Wj(paramString).Vl(paramString);
    AppMethodBeat.o(134359);
    return paramString;
  }
  
  public com.tencent.mm.vfs.o Wa(String paramString)
  {
    AppMethodBeat.i(134376);
    paramString = ((o)az(o.class)).Wa(paramString);
    AppMethodBeat.o(134376);
    return paramString;
  }
  
  public final boolean Wb(String paramString)
  {
    AppMethodBeat.i(134381);
    boolean bool = ((o)az(o.class)).Wb(paramString);
    AppMethodBeat.o(134381);
    return bool;
  }
  
  public final InputStream Wc(String paramString)
  {
    AppMethodBeat.i(134355);
    i locali = new i();
    m localm = b(paramString, locali);
    if (localm == m.kSu)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(134355);
      return paramString;
    }
    Log.e("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", new Object[] { localm, paramString });
    AppMethodBeat.o(134355);
    return null;
  }
  
  public final q Wj(String paramString)
  {
    AppMethodBeat.i(134357);
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.kTf;
      AppMethodBeat.o(134357);
      return paramString;
    }
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq.Vi(paramString))
      {
        AppMethodBeat.o(134357);
        return localq;
      }
    }
    paramString = this.kTf;
    AppMethodBeat.o(134357);
    return paramString;
  }
  
  public final m a(i<String> parami)
  {
    AppMethodBeat.i(134377);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((q)localIterator.next()).a(parami);
      if (localm != m.kSK)
      {
        AppMethodBeat.o(134377);
        return localm;
      }
    }
    parami = m.kSK;
    AppMethodBeat.o(134377);
    return parami;
  }
  
  public final m a(com.tencent.mm.vfs.o paramo, String paramString, i<String> parami)
  {
    AppMethodBeat.i(175587);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((q)localIterator.next()).a(paramo, paramString, parami);
      if (localm != m.kSK)
      {
        AppMethodBeat.o(175587);
        return localm;
      }
    }
    paramo = m.kSK;
    AppMethodBeat.o(175587);
    return paramo;
  }
  
  public m a(com.tencent.mm.vfs.o paramo, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175586);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((q)localIterator.next()).a(paramo, paramString, paramBoolean, parami);
      if (localm != m.kSK)
      {
        AppMethodBeat.o(175586);
        return localm;
      }
    }
    paramo = m.kSK;
    AppMethodBeat.o(175586);
    return paramo;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134364);
    paramString = Wj(paramString).a(paramString, paramLong1, paramLong2, parami);
    AppMethodBeat.o(134364);
    return paramString;
  }
  
  public m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134362);
    paramString = Wj(paramString).a(paramString, parami);
    AppMethodBeat.o(134362);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134367);
    paramString = Wj(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(134367);
    return paramString;
  }
  
  public final m a(String paramString, com.tencent.mm.vfs.o paramo)
  {
    AppMethodBeat.i(175584);
    paramString = Wj(paramString).a(paramString, paramo);
    AppMethodBeat.o(175584);
    return paramString;
  }
  
  public final m a(String paramString, com.tencent.mm.vfs.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(175581);
    paramString = Wj(paramString).a(paramString, paramo, paramBoolean);
    AppMethodBeat.o(175581);
    return paramString;
  }
  
  public final m a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134365);
    paramString = Wj(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(134365);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.o ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175583);
    paramString = Wj(paramString).ag(paramString, paramBoolean);
    AppMethodBeat.o(175583);
    return paramString;
  }
  
  public final m ai(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134360);
    paramString = Wj(paramString).ai(paramString, paramBoolean);
    AppMethodBeat.o(134360);
    return paramString;
  }
  
  public final m aj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    paramString = Wj(paramString).aj(paramString, paramBoolean);
    AppMethodBeat.o(134361);
    return paramString;
  }
  
  public final <T extends q> T az(Class<T> paramClass)
  {
    AppMethodBeat.i(134356);
    Iterator localIterator = this.kTe.iterator();
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
    paramString = Wj(paramString).b(paramString, parami);
    AppMethodBeat.o(134363);
    return paramString;
  }
  
  public List<? extends q.a> bxs()
  {
    AppMethodBeat.i(134380);
    List localList = ((o)az(o.class)).kSN.bxw();
    AppMethodBeat.o(134380);
    return localList;
  }
  
  public final LinkedList<q> bxv()
  {
    return this.kTe;
  }
  
  public final m h(String paramString, List<x> paramList)
  {
    AppMethodBeat.i(134368);
    paramString = Wj(paramString).h(paramString, paramList);
    AppMethodBeat.o(134368);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134374);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).initialize();
    }
    this.kTf.initialize();
    AppMethodBeat.o(134374);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134375);
    Iterator localIterator = this.kTe.iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).release();
    }
    this.kTf.release();
    AppMethodBeat.o(134375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.v
 * JD-Core Version:    0.7.0.1
 */