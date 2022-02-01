package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ac
  implements w
{
  public final LinkedList<w> qNv;
  private final w qNw;
  
  public ac(LinkedList<w> paramLinkedList)
  {
    AppMethodBeat.i(175580);
    this.qNw = new o();
    this.qNv = new LinkedList();
    this.qNv.addAll(paramLinkedList);
    AppMethodBeat.o(175580);
  }
  
  public final boolean Vq(String paramString)
  {
    AppMethodBeat.i(134373);
    int i = 0;
    while (i < 3)
    {
      if (m.M(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(134373);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(134373);
    return true;
  }
  
  public final r Vr(String paramString)
  {
    AppMethodBeat.i(134358);
    paramString = Wy(paramString).Vr(paramString);
    AppMethodBeat.o(134358);
    return paramString;
  }
  
  public final r Vt(String paramString)
  {
    AppMethodBeat.i(134359);
    paramString = Wy(paramString).Vt(paramString);
    AppMethodBeat.o(134359);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.u Wj(String paramString)
  {
    AppMethodBeat.i(323265);
    paramString = Wy(paramString).Wj(paramString);
    AppMethodBeat.o(323265);
    return paramString;
  }
  
  public final boolean Wk(String paramString)
  {
    AppMethodBeat.i(323278);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      if ((localw.Vq(paramString)) && (!localw.Wk(paramString)))
      {
        AppMethodBeat.o(323278);
        return false;
      }
    }
    AppMethodBeat.o(323278);
    return true;
  }
  
  public final r Wl(String paramString)
  {
    AppMethodBeat.i(134366);
    paramString = Wy(paramString).Wl(paramString);
    AppMethodBeat.o(134366);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.u Wm(String paramString)
  {
    AppMethodBeat.i(175582);
    paramString = ao(paramString, false);
    AppMethodBeat.o(175582);
    return paramString;
  }
  
  public final boolean Wn(String paramString)
  {
    AppMethodBeat.i(175585);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      if ((localw.Vq(paramString)) && (localw.Wn(paramString)))
      {
        AppMethodBeat.o(175585);
        return true;
      }
    }
    AppMethodBeat.o(175585);
    return false;
  }
  
  public com.tencent.mm.vfs.u Wo(String paramString)
  {
    AppMethodBeat.i(134376);
    paramString = ((u)aR(u.class)).Wo(paramString);
    AppMethodBeat.o(134376);
    return paramString;
  }
  
  public final boolean Wp(String paramString)
  {
    AppMethodBeat.i(134381);
    boolean bool = ((u)aR(u.class)).Wp(paramString);
    AppMethodBeat.o(134381);
    return bool;
  }
  
  public final boolean Wq(String paramString)
  {
    AppMethodBeat.i(323289);
    boolean bool = ((u)aR(u.class)).Wq(paramString);
    AppMethodBeat.o(323289);
    return bool;
  }
  
  public final InputStream Wr(String paramString)
  {
    AppMethodBeat.i(134355);
    paramString = Wy(paramString).Wr(paramString);
    AppMethodBeat.o(134355);
    return paramString;
  }
  
  public final w Wy(String paramString)
  {
    AppMethodBeat.i(134357);
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.qNw;
      AppMethodBeat.o(134357);
      return paramString;
    }
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      if (localw.Vq(paramString))
      {
        AppMethodBeat.o(134357);
        return localw;
      }
    }
    paramString = this.qNw;
    AppMethodBeat.o(134357);
    return paramString;
  }
  
  public r a(k<String> paramk)
  {
    AppMethodBeat.i(134377);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      r localr = ((w)localIterator.next()).a(paramk);
      if (localr != r.qNb)
      {
        AppMethodBeat.o(134377);
        return localr;
      }
    }
    paramk = r.qNb;
    AppMethodBeat.o(134377);
    return paramk;
  }
  
  public r a(com.tencent.mm.vfs.u paramu, String paramString, k<String> paramk)
  {
    AppMethodBeat.i(175587);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      r localr = ((w)localIterator.next()).a(paramu, paramString, paramk);
      if (localr != r.qNb)
      {
        AppMethodBeat.o(175587);
        return localr;
      }
    }
    paramu = r.qNb;
    AppMethodBeat.o(175587);
    return paramu;
  }
  
  public r a(com.tencent.mm.vfs.u paramu, String paramString, boolean paramBoolean, k<String> paramk)
  {
    AppMethodBeat.i(175586);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      r localr = ((w)localIterator.next()).a(paramu, paramString, paramBoolean, paramk);
      if (localr != r.qNb)
      {
        AppMethodBeat.o(175586);
        return localr;
      }
    }
    paramu = r.qNb;
    AppMethodBeat.o(175586);
    return paramu;
  }
  
  public final r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134364);
    paramString = Wy(paramString).a(paramString, paramLong1, paramLong2, paramk);
    AppMethodBeat.o(134364);
    return paramString;
  }
  
  public r a(String paramString, k<List<p>> paramk)
  {
    AppMethodBeat.i(134362);
    paramString = Wy(paramString).a(paramString, paramk);
    AppMethodBeat.o(134362);
    return paramString;
  }
  
  public final r a(String paramString1, k<Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(323270);
    paramString1 = Wy(paramString1).a(paramString1, paramk, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(323270);
    return paramString1;
  }
  
  public final r a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134367);
    paramString = Wy(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(134367);
    return paramString;
  }
  
  public final r a(String paramString, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(175584);
    paramString = Wy(paramString).a(paramString, paramu);
    AppMethodBeat.o(175584);
    return paramString;
  }
  
  public final r a(String paramString, com.tencent.mm.vfs.u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(175581);
    paramString = Wy(paramString).a(paramString, paramu, paramBoolean);
    AppMethodBeat.o(175581);
    return paramString;
  }
  
  public final r a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134365);
    paramString = Wy(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(134365);
    return paramString;
  }
  
  public final <T extends w> T aR(Class<T> paramClass)
  {
    AppMethodBeat.i(134356);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      if (paramClass.isInstance(localw))
      {
        AppMethodBeat.o(134356);
        return localw;
      }
    }
    AppMethodBeat.o(134356);
    return null;
  }
  
  public final com.tencent.mm.vfs.u ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175583);
    paramString = Wy(paramString).ao(paramString, paramBoolean);
    AppMethodBeat.o(175583);
    return paramString;
  }
  
  public final r aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134360);
    paramString = Wy(paramString).aq(paramString, paramBoolean);
    AppMethodBeat.o(134360);
    return paramString;
  }
  
  public final r ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134361);
    paramString = Wy(paramString).ar(paramString, paramBoolean);
    AppMethodBeat.o(134361);
    return paramString;
  }
  
  public final r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134363);
    paramString = Wy(paramString).b(paramString, paramk);
    AppMethodBeat.o(134363);
    return paramString;
  }
  
  public List<? extends w.a> cil()
  {
    AppMethodBeat.i(134380);
    List localList = ((u)aR(u.class)).qNd.cip();
    AppMethodBeat.o(134380);
    return localList;
  }
  
  public y cim()
  {
    return null;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134374);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext()) {
      ((w)localIterator.next()).initialize();
    }
    this.qNw.initialize();
    AppMethodBeat.o(134374);
  }
  
  public final r j(String paramString, List<ad> paramList)
  {
    AppMethodBeat.i(134368);
    paramString = Wy(paramString).j(paramString, paramList);
    AppMethodBeat.o(134368);
    return paramString;
  }
  
  public void release()
  {
    AppMethodBeat.i(134375);
    Iterator localIterator = this.qNv.iterator();
    while (localIterator.hasNext()) {
      ((w)localIterator.next()).release();
    }
    this.qNw.release();
    AppMethodBeat.o(134375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ac
 * JD-Core Version:    0.7.0.1
 */