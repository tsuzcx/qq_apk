package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ab
  implements au.b
{
  private au.b hIl;
  
  public ab(au.b paramb)
  {
    this.hIl = paramb;
  }
  
  public final void Bt(String paramString)
  {
    AppMethodBeat.i(221722);
    Iterator localIterator = ab.a.aBJ().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ag(paramString, 0))
      {
        localb.aBK().Bt(paramString);
        ae.i("MicroMsg.GetContactServiceProxy", "[removeCallBack] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(221722);
        return;
      }
    }
    this.hIl.Bt(paramString);
    AppMethodBeat.o(221722);
  }
  
  public final void Bu(String paramString)
  {
    AppMethodBeat.i(221723);
    Iterator localIterator = ab.a.aBJ().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ag(paramString, 0))
      {
        localb.aBK().Bu(paramString);
        ae.i("MicroMsg.GetContactServiceProxy", "[clearMapRecentDown] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(221723);
        return;
      }
    }
    this.hIl.Bu(paramString);
    AppMethodBeat.o(221723);
  }
  
  public final void a(String paramString1, String paramString2, au.b.a parama)
  {
    AppMethodBeat.i(221721);
    Iterator localIterator = ab.a.aBJ().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ag(paramString1, 0))
      {
        localb.aBK().a(paramString1, paramString2, parama);
        ae.i("MicroMsg.GetContactServiceProxy", "[getNow] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(221721);
        return;
      }
    }
    this.hIl.a(paramString1, paramString2, parama);
    AppMethodBeat.o(221721);
  }
  
  public final au.b aBH()
  {
    return this.hIl;
  }
  
  public final void aBI()
  {
    AppMethodBeat.i(221724);
    this.hIl.aBI();
    AppMethodBeat.o(221724);
  }
  
  public final void aJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221719);
    Iterator localIterator = ab.a.aBJ().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ag(paramString1, 0))
      {
        localb.aBK().aJ(paramString1, paramString2);
        ae.i("MicroMsg.GetContactServiceProxy", "[addContact] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(221719);
        return;
      }
    }
    this.hIl.aJ(paramString1, paramString2);
    AppMethodBeat.o(221719);
  }
  
  public final void g(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(221720);
    Iterator localIterator = ab.a.aBJ().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ag(paramString1, paramInt))
      {
        localb.aBK().g(paramString1, paramInt, paramString2);
        ae.i("MicroMsg.GetContactServiceProxy", "[addContactExtra] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(221720);
        return;
      }
    }
    this.hIl.g(paramString1, paramInt, paramString2);
    AppMethodBeat.o(221720);
  }
  
  public static abstract interface b
  {
    public abstract au.b aBK();
    
    public abstract boolean ag(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */