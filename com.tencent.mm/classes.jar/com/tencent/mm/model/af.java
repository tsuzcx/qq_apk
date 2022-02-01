package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class af
  implements ay.b
{
  private ay.b iCV;
  
  public af(ay.b paramb)
  {
    this.iCV = paramb;
  }
  
  public final void JZ(String paramString)
  {
    AppMethodBeat.i(229792);
    Iterator localIterator = af.a.aVh().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aj(paramString, 0))
      {
        localb.aVi().JZ(paramString);
        Log.i("MicroMsg.GetContactServiceProxy", "[removeCallBack] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(229792);
        return;
      }
    }
    this.iCV.JZ(paramString);
    AppMethodBeat.o(229792);
  }
  
  public final void Ka(String paramString)
  {
    AppMethodBeat.i(229793);
    Iterator localIterator = af.a.aVh().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aj(paramString, 0))
      {
        localb.aVi().Ka(paramString);
        Log.i("MicroMsg.GetContactServiceProxy", "[clearMapRecentDown] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(229793);
        return;
      }
    }
    this.iCV.Ka(paramString);
    AppMethodBeat.o(229793);
  }
  
  public final void a(String paramString1, String paramString2, ay.b.a parama)
  {
    AppMethodBeat.i(229791);
    Iterator localIterator = af.a.aVh().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aj(paramString1, 0))
      {
        localb.aVi().a(paramString1, paramString2, parama);
        Log.i("MicroMsg.GetContactServiceProxy", "[getNow] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(229791);
        return;
      }
    }
    this.iCV.a(paramString1, paramString2, parama);
    AppMethodBeat.o(229791);
  }
  
  public final void aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229789);
    Iterator localIterator = af.a.aVh().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aj(paramString1, 0))
      {
        localb.aVi().aL(paramString1, paramString2);
        Log.i("MicroMsg.GetContactServiceProxy", "[addContact] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(229789);
        return;
      }
    }
    this.iCV.aL(paramString1, paramString2);
    AppMethodBeat.o(229789);
  }
  
  public final ay.b aVf()
  {
    return this.iCV;
  }
  
  public final void aVg()
  {
    AppMethodBeat.i(229794);
    this.iCV.aVg();
    AppMethodBeat.o(229794);
  }
  
  public final void j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(229790);
    Iterator localIterator = af.a.aVh().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.aj(paramString1, paramInt))
      {
        localb.aVi().j(paramString1, paramInt, paramString2);
        Log.i("MicroMsg.GetContactServiceProxy", "[addContactExtra] has consume. interceptor=%s", new Object[] { localb });
        AppMethodBeat.o(229790);
        return;
      }
    }
    this.iCV.j(paramString1, paramInt, paramString2);
    AppMethodBeat.o(229790);
  }
  
  public static abstract interface b
  {
    public abstract ay.b aVi();
    
    public abstract boolean aj(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */