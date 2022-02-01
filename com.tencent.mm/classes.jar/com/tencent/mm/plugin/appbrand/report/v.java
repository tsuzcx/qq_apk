package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class v
{
  public final String mName;
  public final AtomicInteger nHO;
  public volatile a nHP;
  public final c nHQ;
  private final b nHR;
  long nHS;
  public long nHT;
  
  public v(String paramString)
  {
    AppMethodBeat.i(139919);
    this.nHQ = new c((byte)0);
    this.nHR = new b((byte)0);
    this.mName = paramString;
    this.nHO = new AtomicInteger(0);
    this.nHP = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean bUz()
  {
    AppMethodBeat.i(230540);
    if (this.nHO.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.nHP.exit();
        b localb = this.nHR;
        this.nHP = localb;
        localb.enter();
      }
      AppMethodBeat.o(230540);
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
    implements v.a
  {
    private long nHU;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.nHU = Util.nowMilliSecond();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      v.this.nHS = (Util.nowMilliSecond() - this.nHU);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.nHU;
    }
  }
  
  final class c
    implements v.a
  {
    private long nHW;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.nHW = Util.nowMilliSecond();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      v.this.nHT = (Util.nowMilliSecond() - this.nHW);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.nHW;
    }
  }
  
  public final class d
    implements v.a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.v
 * JD-Core Version:    0.7.0.1
 */