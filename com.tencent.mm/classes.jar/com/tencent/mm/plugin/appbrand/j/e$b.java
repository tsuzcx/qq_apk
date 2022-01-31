package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public enum e$b
{
  private AtomicBoolean chm;
  Map<Integer, e.a> irH;
  private Runnable irI;
  
  static
  {
    AppMethodBeat.i(132291);
    irG = new b("INSTANCE");
    irJ = new b[] { irG };
    AppMethodBeat.o(132291);
  }
  
  private e$b()
  {
    AppMethodBeat.i(132283);
    this.irH = new ConcurrentHashMap();
    this.chm = new AtomicBoolean(true);
    this.irI = new e.b.1(this);
    AppMethodBeat.o(132283);
  }
  
  final void aId()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    try
    {
      AppMethodBeat.i(132286);
      g.RO();
      al.ae(this.irI);
      if (this.chm.get())
      {
        ab.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
        AppMethodBeat.o(132286);
      }
      for (;;)
      {
        return;
        if (this.irH.size() > 0) {
          break;
        }
        ab.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
        AppMethodBeat.o(132286);
      }
      l = 9223372036854775807L;
    }
    finally {}
    long l;
    Iterator localIterator = this.irH.values().iterator();
    label101:
    e.a locala;
    if (localIterator.hasNext())
    {
      locala = (e.a)localIterator.next();
      if (locala.aIb())
      {
        l = 0L;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l) });
      if (!bool1)
      {
        AppMethodBeat.o(132286);
        break;
        if (locala.irE < 0) {
          break label101;
        }
        l = Math.min(locala.irE, l);
        bool1 = true;
        break label101;
      }
      g.RO().o(this.irI, l * 1000L);
      AppMethodBeat.o(132286);
      break;
    }
  }
  
  public final void start()
  {
    try
    {
      AppMethodBeat.i(132284);
      this.chm.set(false);
      aId();
      AppMethodBeat.o(132284);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void stop()
  {
    try
    {
      AppMethodBeat.i(132285);
      this.chm.set(true);
      AppMethodBeat.o(132285);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.e.b
 * JD-Core Version:    0.7.0.1
 */