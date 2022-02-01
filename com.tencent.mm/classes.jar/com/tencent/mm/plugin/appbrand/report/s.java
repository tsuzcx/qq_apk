package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class s
{
  public final String mName;
  public final AtomicInteger mrN;
  public volatile a mrO;
  public final c mrP;
  private final b mrQ;
  long mrR;
  public long mrS;
  
  public s(String paramString)
  {
    AppMethodBeat.i(139919);
    this.mrP = new c((byte)0);
    this.mrQ = new b((byte)0);
    this.mName = paramString;
    this.mrN = new AtomicInteger(0);
    this.mrO = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean bxp()
  {
    AppMethodBeat.i(194936);
    if (this.mrN.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.mrO.exit();
        b localb = this.mrQ;
        this.mrO = localb;
        localb.enter();
      }
      AppMethodBeat.o(194936);
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
    private long mrT;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.mrT = bt.flT();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      s.this.mrR = (bt.flT() - this.mrT);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.mrT;
    }
  }
  
  final class c
    implements s.a
  {
    private long mrV;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.mrV = bt.flT();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      s.this.mrS = (bt.flT() - this.mrV);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.mrV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.s
 * JD-Core Version:    0.7.0.1
 */