package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class af
  implements az.b
{
  private az.b lsV;
  
  public af(az.b paramb)
  {
    this.lsV = paramb;
  }
  
  public final void Rr(String paramString)
  {
    AppMethodBeat.i(244003);
    Iterator localIterator = af.a.bek().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aB(paramString, 0))
      {
        localb.bel().Rr(paramString);
        Log.i("MicroMsg.GetContactServiceProxy", "[removeCallBack] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(244003);
        return;
      }
    }
    this.lsV.Rr(paramString);
    AppMethodBeat.o(244003);
  }
  
  public final void Rs(String paramString)
  {
    AppMethodBeat.i(244004);
    Iterator localIterator = af.a.bek().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aB(paramString, 0))
      {
        localb.bel().Rs(paramString);
        Log.i("MicroMsg.GetContactServiceProxy", "[clearMapRecentDown] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(244004);
        return;
      }
    }
    this.lsV.Rs(paramString);
    AppMethodBeat.o(244004);
  }
  
  public final void a(String paramString1, String paramString2, az.b.a parama)
  {
    AppMethodBeat.i(244002);
    Iterator localIterator = af.a.bek().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aB(paramString1, 0))
      {
        localb.bel().a(paramString1, paramString2, parama);
        Log.i("MicroMsg.GetContactServiceProxy", "[getNow] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(244002);
        return;
      }
    }
    this.lsV.a(paramString1, paramString2, parama);
    AppMethodBeat.o(244002);
  }
  
  public final void aP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244000);
    Iterator localIterator = af.a.bek().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aB(paramString1, 0))
      {
        localb.bel().aP(paramString1, paramString2);
        Log.i("MicroMsg.GetContactServiceProxy", "[addContact] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(244000);
        return;
      }
    }
    this.lsV.aP(paramString1, paramString2);
    AppMethodBeat.o(244000);
  }
  
  public final az.b bei()
  {
    return this.lsV;
  }
  
  public final void bej()
  {
    AppMethodBeat.i(244005);
    this.lsV.bej();
    AppMethodBeat.o(244005);
  }
  
  public final void h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(244001);
    Iterator localIterator = af.a.bek().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aB(paramString1, paramInt))
      {
        localb.bel().h(paramString1, paramInt, paramString2);
        Log.i("MicroMsg.GetContactServiceProxy", "[addContactExtra] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(244001);
        return;
      }
    }
    this.lsV.h(paramString1, paramInt, paramString2);
    AppMethodBeat.o(244001);
  }
  
  public static abstract interface b
  {
    public abstract boolean aB(String paramString, int paramInt);
    
    public abstract az.b bel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */