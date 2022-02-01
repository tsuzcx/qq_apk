package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  List<a> kpG;
  
  private b()
  {
    AppMethodBeat.i(199362);
    this.kpG = new ArrayList();
    AppMethodBeat.o(199362);
  }
  
  public static b aLY()
  {
    AppMethodBeat.i(199363);
    b localb = a.aMa();
    AppMethodBeat.o(199363);
    return localb;
  }
  
  public final void ND(String paramString)
  {
    AppMethodBeat.i(199367);
    Iterator localIterator = this.kpG.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((a)localIterator.next()).iSn))
      {
        localIterator.remove();
        AppMethodBeat.o(199367);
        return;
      }
    }
    AppMethodBeat.o(199367);
  }
  
  public final a NE(String paramString)
  {
    AppMethodBeat.i(199368);
    Iterator localIterator = this.kpG.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.iSn))
      {
        AppMethodBeat.o(199368);
        return locala;
      }
    }
    AppMethodBeat.o(199368);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(199365);
    this.kpG.add(parama);
    AppMethodBeat.o(199365);
  }
  
  public final List<a> aLZ()
  {
    return this.kpG;
  }
  
  static final class a
  {
    private static b kpH;
    
    static
    {
      AppMethodBeat.i(198671);
      kpH = new b((byte)0);
      AppMethodBeat.o(198671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.b
 * JD-Core Version:    0.7.0.1
 */