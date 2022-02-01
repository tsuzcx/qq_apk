package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class s
{
  public final AtomicInteger lqc;
  public volatile a lqd;
  public final c lqe;
  private final b lqf;
  long lqg;
  public long lqh;
  public final String mName;
  
  public s(String paramString)
  {
    AppMethodBeat.i(139919);
    this.lqe = new c((byte)0);
    this.lqf = new b((byte)0);
    this.mName = paramString;
    this.lqc = new AtomicInteger(0);
    this.lqd = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean bmo()
  {
    AppMethodBeat.i(193715);
    if (this.lqc.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.lqd.exit();
        b localb = this.lqf;
        this.lqd = localb;
        localb.enter();
      }
      AppMethodBeat.o(193715);
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
    private long lqi;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.lqi = bt.eGO();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      s.this.lqg = (bt.eGO() - this.lqi);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.lqi;
    }
  }
  
  final class c
    implements s.a
  {
    private long lqk;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.lqk = bt.eGO();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      s.this.lqh = (bt.eGO() - this.lqk);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.lqk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.s
 * JD-Core Version:    0.7.0.1
 */