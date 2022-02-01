package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.k.a;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class x
  implements r
{
  public final LinkedList<r> nNC;
  private final r nND;
  
  public x(LinkedList<r> paramLinkedList)
  {
    AppMethodBeat.i(175580);
    this.nND = new j();
    this.nNC = new LinkedList();
    this.nNC.addAll(paramLinkedList);
    AppMethodBeat.o(175580);
  }
  
  public m a(i<String> parami)
  {
    AppMethodBeat.i(134377);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((r)localIterator.next()).a(parami);
      if (localm != m.nNh)
      {
        AppMethodBeat.o(134377);
        return localm;
      }
    }
    parami = m.nNh;
    AppMethodBeat.o(134377);
    return parami;
  }
  
  public m a(q paramq, String paramString, i<String> parami)
  {
    AppMethodBeat.i(175587);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((r)localIterator.next()).a(paramq, paramString, parami);
      if (localm != m.nNh)
      {
        AppMethodBeat.o(175587);
        return localm;
      }
    }
    paramq = m.nNh;
    AppMethodBeat.o(175587);
    return paramq;
  }
  
  public m a(q paramq, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175586);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      m localm = ((r)localIterator.next()).a(paramq, paramString, paramBoolean, parami);
      if (localm != m.nNh)
      {
        AppMethodBeat.o(175586);
        return localm;
      }
    }
    paramq = m.nNh;
    AppMethodBeat.o(175586);
    return paramq;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134364);
    paramString = adY(paramString).a(paramString, paramLong1, paramLong2, parami);
    AppMethodBeat.o(134364);
    return paramString;
  }
  
  public m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134362);
    paramString = adY(paramString).a(paramString, parami);
    AppMethodBeat.o(134362);
    return paramString;
  }
  
  public final m a(String paramString1, i<Map<String, ByteBuffer>> parami, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(225285);
    paramString1 = adY(paramString1).a(paramString1, parami, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(225285);
    return paramString1;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134367);
    paramString = adY(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(134367);
    return paramString;
  }
  
  public final m a(String paramString, q paramq)
  {
    AppMethodBeat.i(175584);
    paramString = adY(paramString).a(paramString, paramq);
    AppMethodBeat.o(175584);
    return paramString;
  }
  
  public final m a(String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(175581);
    paramString = adY(paramString).a(paramString, paramq, paramBoolean);
    AppMethodBeat.o(175581);
    return paramString;
  }
  
  public final m a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134365);
    paramString = adY(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(134365);
    return paramString;
  }
  
  public final boolean acS(String paramString)
  {
    AppMethodBeat.i(134373);
    int i = 0;
    while (i < 3)
    {
      if (l.J(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(134373);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(134373);
    return true;
  }
  
  public final m acT(String paramString)
  {
    AppMethodBeat.i(134358);
    paramString = adY(paramString).acT(paramString);
    AppMethodBeat.o(134358);
    return paramString;
  }
  
  public final m acV(String paramString)
  {
    AppMethodBeat.i(134359);
    paramString = adY(paramString).acV(paramString);
    AppMethodBeat.o(134359);
    return paramString;
  }
  
  public final q adI(String paramString)
  {
    AppMethodBeat.i(225282);
    paramString = adY(paramString).adI(paramString);
    AppMethodBeat.o(225282);
    return paramString;
  }
  
  public final boolean adJ(String paramString)
  {
    AppMethodBeat.i(225291);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if ((localr.acS(paramString)) && (!localr.adJ(paramString)))
      {
        AppMethodBeat.o(225291);
        return false;
      }
    }
    AppMethodBeat.o(225291);
    return true;
  }
  
  public final m adK(String paramString)
  {
    AppMethodBeat.i(134366);
    paramString = adY(paramString).adK(paramString);
    AppMethodBeat.o(134366);
    return paramString;
  }
  
  public final q adL(String paramString)
  {
    AppMethodBeat.i(175582);
    paramString = ah(paramString, false);
    AppMethodBeat.o(175582);
    return paramString;
  }
  
  public final boolean adM(String paramString)
  {
    AppMethodBeat.i(175585);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if ((localr.acS(paramString)) && (localr.adM(paramString)))
      {
        AppMethodBeat.o(175585);
        return true;
      }
    }
    AppMethodBeat.o(175585);
    return false;
  }
  
  public q adN(String paramString)
  {
    AppMethodBeat.i(134376);
    paramString = ((p)ay(p.class)).adN(paramString);
    AppMethodBeat.o(134376);
    return paramString;
  }
  
  public final boolean adO(String paramString)
  {
    AppMethodBeat.i(134381);
    boolean bool = ((p)ay(p.class)).adO(paramString);
    AppMethodBeat.o(134381);
    return bool;
  }
  
  public final boolean adP(String paramString)
  {
    AppMethodBeat.i(225299);
    boolean bool = ((p)ay(p.class)).adP(paramString);
    AppMethodBeat.o(225299);
    return bool;
  }
  
  public final InputStream adQ(String paramString)
  {
    AppMethodBeat.i(134355);
    i locali = new i();
    m localm = b(paramString, locali);
    if (localm == m.nMR)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(134355);
      return paramString;
    }
    Log.e("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", new Object[] { localm, paramString });
    AppMethodBeat.o(134355);
    return null;
  }
  
  public final r adY(String paramString)
  {
    AppMethodBeat.i(134357);
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.nND;
      AppMethodBeat.o(134357);
      return paramString;
    }
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.acS(paramString))
      {
        AppMethodBeat.o(134357);
        return localr;
      }
    }
    paramString = this.nND;
    AppMethodBeat.o(134357);
    return paramString;
  }
  
  public final q ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175583);
    paramString = adY(paramString).ah(paramString, paramBoolean);
    AppMethodBeat.o(175583);
    return paramString;
  }
  
  public final m aj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134360);
    paramString = adY(paramString).aj(paramString, paramBoolean);
    AppMethodBeat.o(134360);
    return paramString;
  }
  
  public final m ak(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    paramString = adY(paramString).ak(paramString, paramBoolean);
    AppMethodBeat.o(134361);
    return paramString;
  }
  
  public final <T extends r> T ay(Class<T> paramClass)
  {
    AppMethodBeat.i(134356);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (paramClass.isInstance(localr))
      {
        AppMethodBeat.o(134356);
        return localr;
      }
    }
    AppMethodBeat.o(134356);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134363);
    paramString = adY(paramString).b(paramString, parami);
    AppMethodBeat.o(134363);
    return paramString;
  }
  
  public List<? extends r.a> bIG()
  {
    AppMethodBeat.i(134380);
    List localList = ((p)ay(p.class)).nNk.bIL();
    AppMethodBeat.o(134380);
    return localList;
  }
  
  public t bIH()
  {
    return null;
  }
  
  public final LinkedList<r> bIK()
  {
    return this.nNC;
  }
  
  public final m h(String paramString, List<z> paramList)
  {
    AppMethodBeat.i(134368);
    paramString = adY(paramString).h(paramString, paramList);
    AppMethodBeat.o(134368);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134374);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).initialize();
    }
    this.nND.initialize();
    AppMethodBeat.o(134374);
  }
  
  public void release()
  {
    AppMethodBeat.i(134375);
    Iterator localIterator = this.nNC.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).release();
    }
    this.nND.release();
    AppMethodBeat.o(134375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x
 * JD-Core Version:    0.7.0.1
 */