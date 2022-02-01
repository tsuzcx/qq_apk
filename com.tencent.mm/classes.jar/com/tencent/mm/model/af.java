package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class af
  implements az.b
{
  public az.b okv;
  
  public af(az.b paramb)
  {
    this.okv = paramb;
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(242053);
    Iterator localIterator = a.bCd().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aN(paramString, 0))
      {
        localb.bCe().Jq(paramString);
        Log.i("MicroMsg.GetContactServiceProxy", "[removeCallBack] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(242053);
        return;
      }
    }
    this.okv.Jq(paramString);
    AppMethodBeat.o(242053);
  }
  
  public final void Jr(String paramString)
  {
    AppMethodBeat.i(242055);
    Iterator localIterator = a.bCd().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aN(paramString, 0))
      {
        localb.bCe().Jr(paramString);
        Log.i("MicroMsg.GetContactServiceProxy", "[clearMapRecentDown] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(242055);
        return;
      }
    }
    this.okv.Jr(paramString);
    AppMethodBeat.o(242055);
  }
  
  public final void a(String paramString1, String paramString2, az.b.a parama)
  {
    AppMethodBeat.i(242051);
    Iterator localIterator = a.bCd().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aN(paramString1, 0))
      {
        localb.bCe().a(paramString1, paramString2, parama);
        Log.i("MicroMsg.GetContactServiceProxy", "[getNow] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(242051);
        return;
      }
    }
    this.okv.a(paramString1, paramString2, parama);
    AppMethodBeat.o(242051);
  }
  
  public final void aZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242048);
    Iterator localIterator = a.bCd().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aN(paramString1, 0))
      {
        localb.bCe().aZ(paramString1, paramString2);
        Log.i("MicroMsg.GetContactServiceProxy", "[addContact] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(242048);
        return;
      }
    }
    this.okv.aZ(paramString1, paramString2);
    AppMethodBeat.o(242048);
  }
  
  public final void bCc()
  {
    AppMethodBeat.i(242061);
    this.okv.bCc();
    AppMethodBeat.o(242061);
  }
  
  public final void j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(242050);
    Iterator localIterator = a.bCd().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aN(paramString1, paramInt))
      {
        localb.bCe().j(paramString1, paramInt, paramString2);
        Log.i("MicroMsg.GetContactServiceProxy", "[addContactExtra] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(242050);
        return;
      }
    }
    this.okv.j(paramString1, paramInt, paramString2);
    AppMethodBeat.o(242050);
  }
  
  public static final class a
  {
    private static ConcurrentLinkedQueue<af.b> okw;
    
    static
    {
      AppMethodBeat.i(241861);
      okw = new ConcurrentLinkedQueue();
      AppMethodBeat.o(241861);
    }
    
    public static void a(af.b paramb)
    {
      AppMethodBeat.i(241857);
      okw.add(paramb);
      AppMethodBeat.o(241857);
    }
    
    public static void b(af.b paramb)
    {
      AppMethodBeat.i(241858);
      okw.remove(paramb);
      AppMethodBeat.o(241858);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean aN(String paramString, int paramInt);
    
    public abstract az.b bCe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */