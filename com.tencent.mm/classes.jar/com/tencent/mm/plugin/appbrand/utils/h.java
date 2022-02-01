package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class h<Task>
  extends d
{
  final h<Task>.b lMg = new b((byte)0);
  private final h<Task>.a lMh = new a((byte)0);
  final String lMi;
  private final Queue<Task> lMj = new LinkedList();
  
  protected h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.lMi = paramString;
    a(this.lMg);
    a(this.lMh);
    b(this.lMg);
    start();
  }
  
  public final void aPC()
  {
    super.aPC();
    synchronized (this.lMj)
    {
      this.lMj.clear();
      return;
    }
  }
  
  protected abstract boolean aYm();
  
  public final void cH(Task paramTask)
  {
    if (aYm()) {
      return;
    }
    synchronized (this.lMj)
    {
      this.lMj.offer(paramTask);
      Wm(1);
      return;
    }
  }
  
  protected abstract void cu(Task paramTask);
  
  final class a
    extends o
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(107819);
      String str = h.this.lMi + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        h.this.b(h.this.lMg);
        AppMethodBeat.o(107818);
        return true;
      }
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(107818);
      return bool;
    }
  }
  
  final class b
    extends o
  {
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(107820);
      super.enter();
      h.a(h.this);
      AppMethodBeat.o(107820);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(107822);
      String str = h.this.lMi + "|StateIdle";
      AppMethodBeat.o(107822);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107821);
      if ((1 == paramMessage.what) || (2 == paramMessage.what))
      {
        h.a(h.this);
        AppMethodBeat.o(107821);
        return true;
      }
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(107821);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.h
 * JD-Core Version:    0.7.0.1
 */