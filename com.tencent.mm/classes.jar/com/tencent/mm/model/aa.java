package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class aa
  implements as.b
{
  private as.b hFt;
  
  public aa(as.b paramb)
  {
    this.hFt = paramb;
  }
  
  public final void AJ(String paramString)
  {
    AppMethodBeat.i(197013);
    Iterator localIterator = aa.a.aBt().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.af(paramString, 0))
      {
        localb.aBu().AJ(paramString);
        ad.i("MicroMsg.GetContactServiceProxy", "[removeCallBack] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(197013);
        return;
      }
    }
    this.hFt.AJ(paramString);
    AppMethodBeat.o(197013);
  }
  
  public final void AK(String paramString)
  {
    AppMethodBeat.i(197014);
    Iterator localIterator = aa.a.aBt().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.af(paramString, 0))
      {
        localb.aBu().AK(paramString);
        ad.i("MicroMsg.GetContactServiceProxy", "[clearMapRecentDown] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(197014);
        return;
      }
    }
    this.hFt.AK(paramString);
    AppMethodBeat.o(197014);
  }
  
  public final void a(String paramString1, String paramString2, as.b.a parama)
  {
    AppMethodBeat.i(197012);
    Iterator localIterator = aa.a.aBt().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.af(paramString1, 0))
      {
        localb.aBu().a(paramString1, paramString2, parama);
        ad.i("MicroMsg.GetContactServiceProxy", "[getNow] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(197012);
        return;
      }
    }
    this.hFt.a(paramString1, paramString2, parama);
    AppMethodBeat.o(197012);
  }
  
  public final as.b aBr()
  {
    return this.hFt;
  }
  
  public final void aBs()
  {
    AppMethodBeat.i(197015);
    this.hFt.aBs();
    AppMethodBeat.o(197015);
  }
  
  public final void aI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197010);
    Iterator localIterator = aa.a.aBt().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.af(paramString1, 0))
      {
        localb.aBu().aI(paramString1, paramString2);
        ad.i("MicroMsg.GetContactServiceProxy", "[addContact] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(197010);
        return;
      }
    }
    this.hFt.aI(paramString1, paramString2);
    AppMethodBeat.o(197010);
  }
  
  public final void g(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(197011);
    Iterator localIterator = aa.a.aBt().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.af(paramString1, paramInt))
      {
        localb.aBu().g(paramString1, paramInt, paramString2);
        ad.i("MicroMsg.GetContactServiceProxy", "[addContactExtra] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(197011);
        return;
      }
    }
    this.hFt.g(paramString1, paramInt, paramString2);
    AppMethodBeat.o(197011);
  }
  
  public static abstract interface b
  {
    public abstract as.b aBu();
    
    public abstract boolean af(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.aa
 * JD-Core Version:    0.7.0.1
 */