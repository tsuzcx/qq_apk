package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.atomic.AtomicInteger;

public final class s
{
  public final String mName;
  public final AtomicInteger mwL;
  public volatile a mwM;
  public final c mwN;
  private final b mwO;
  long mwP;
  public long mwQ;
  
  public s(String paramString)
  {
    AppMethodBeat.i(139919);
    this.mwN = new c((byte)0);
    this.mwO = new b((byte)0);
    this.mName = paramString;
    this.mwL = new AtomicInteger(0);
    this.mwM = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean byi()
  {
    AppMethodBeat.i(221826);
    if (this.mwL.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.mwM.exit();
        b localb = this.mwO;
        this.mwM = localb;
        localb.enter();
      }
      AppMethodBeat.o(221826);
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
    implements s.a
  {
    private long mwR;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.mwR = bu.fpO();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      s.this.mwP = (bu.fpO() - this.mwR);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.mwR;
    }
  }
  
  final class c
    implements s.a
  {
    private long mwT;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.mwT = bu.fpO();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      s.this.mwQ = (bu.fpO() - this.mwT);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.mwT;
    }
  }
  
  public final class d
    implements s.a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.s
 * JD-Core Version:    0.7.0.1
 */