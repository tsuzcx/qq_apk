package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class w
{
  public final String mName;
  public final AtomicInteger qKa;
  public volatile a qKb;
  public final c qKc;
  private final b qKd;
  long qKe;
  public long qKf;
  
  public w(String paramString)
  {
    AppMethodBeat.i(139919);
    this.qKc = new c((byte)0);
    this.qKd = new b((byte)0);
    this.mName = paramString;
    this.qKa = new AtomicInteger(0);
    this.qKb = new d((byte)0);
    AppMethodBeat.o(139919);
  }
  
  public final boolean chJ()
  {
    AppMethodBeat.i(199258);
    if (this.qKa.getAndSet(2) != 2) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        this.qKb.exit();
        b localb = this.qKd;
        this.qKb = localb;
        localb.enter();
      }
      AppMethodBeat.o(199258);
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
    implements w.a
  {
    private long qKg;
    
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139911);
      this.qKg = Util.nowMilliSecond();
      AppMethodBeat.o(139911);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139912);
      w.this.qKe = (Util.nowMilliSecond() - this.qKg);
      AppMethodBeat.o(139912);
    }
    
    public final long getStartTime()
    {
      return this.qKg;
    }
  }
  
  final class c
    implements w.a
  {
    private long qKi;
    
    private c() {}
    
    public final void enter()
    {
      AppMethodBeat.i(139915);
      this.qKi = Util.nowMilliSecond();
      AppMethodBeat.o(139915);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(139916);
      w.this.qKf = (Util.nowMilliSecond() - this.qKi);
      AppMethodBeat.o(139916);
    }
    
    public final long getStartTime()
    {
      return this.qKi;
    }
  }
  
  public final class d
    implements w.a
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.w
 * JD-Core Version:    0.7.0.1
 */