package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class x
{
  public final String mName;
  public final AtomicInteger tOG;
  public volatile a tOH;
  public final c tOI;
  private final b tOJ;
  long tOK;
  public long tOL;
  
  public x(String paramString)
  {
    AppMethodBeat.i(139919);
    this.tOI = new c((byte)0);
    this.tOJ = new b((byte)0);
    this.mName = paramString;
    this.tOG = new AtomicInteger(0);
    this.tOH = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean cIE()
  {
    AppMethodBeat.i(321464);
    if (this.tOG.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.tOH.exit();
        b localb = this.tOJ;
        this.tOH = localb;
        localb.enter();
      }
      AppMethodBeat.o(321464);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void enter();
    
    public abstract void exit();
    
    public abstract long getStartTime();
  }
  
  final class b
    implements x.a
  {
    private long tOM;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.tOM = Util.nowMilliSecond();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      x.this.tOK = (Util.nowMilliSecond() - this.tOM);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.tOM;
    }
  }
  
  final class c
    implements x.a
  {
    private long tOO;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.tOO = Util.nowMilliSecond();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      x.this.tOL = (Util.nowMilliSecond() - this.tOO);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.tOO;
    }
  }
  
  public final class d
    implements x.a
  {
    private d() {}
    
    public final void enter() {}
    
    public final void exit() {}
    
    public final long getStartTime()
    {
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.x
 * JD-Core Version:    0.7.0.1
 */