package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
{
  public final AtomicInteger lRX;
  public volatile a lRY;
  public final c lRZ;
  private final b lSa;
  long lSb;
  public long lSc;
  public final String mName;
  
  public r(String paramString)
  {
    AppMethodBeat.i(139919);
    this.lRZ = new c((byte)0);
    this.lSa = new b((byte)0);
    this.mName = paramString;
    this.lRX = new AtomicInteger(0);
    this.lRY = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean btk()
  {
    AppMethodBeat.i(208986);
    if (this.lRX.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.lRY.exit();
        b localb = this.lSa;
        this.lRY = localb;
        localb.enter();
      }
      AppMethodBeat.o(208986);
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
    implements r.a
  {
    private long lSd;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.lSd = bs.eWj();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      r.this.lSb = (bs.eWj() - this.lSd);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.lSd;
    }
  }
  
  final class c
    implements r.a
  {
    private long lSf;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.lSf = bs.eWj();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      r.this.lSc = (bs.eWj() - this.lSf);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.lSf;
    }
  }
  
  public final class d
    implements r.a
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.r
 * JD-Core Version:    0.7.0.1
 */