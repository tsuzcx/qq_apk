package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.r;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.util.LinkedList;
import java.util.Queue;

public abstract class l<Task>
  extends StateMachine
{
  private final Queue<Task> cRj = new LinkedList();
  private final l<Task>.b riA = new b((byte)0);
  private final l<Task>.a riB = new a((byte)0);
  private final String riC;
  
  protected l(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.riC = paramString;
    addState(this.riA);
    addState(this.riB);
    setInitialState(this.riA);
    start();
  }
  
  protected abstract boolean bQj();
  
  protected abstract void cE(Task paramTask);
  
  public final void cR(Task paramTask)
  {
    if (bQj()) {
      return;
    }
    synchronized (this.cRj)
    {
      this.cRj.offer(paramTask);
      sendMessage(1);
      return;
    }
  }
  
  protected final int cmg()
  {
    return this.cRj.size();
  }
  
  public void onQuitting()
  {
    super.onQuitting();
    synchronized (this.cRj)
    {
      this.cRj.clear();
      return;
    }
  }
  
  final class a
    extends r
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(107819);
      String str = l.b(l.this) + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean processMessage(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        l.a(l.this, l.a(l.this));
        AppMethodBeat.o(107818);
        return true;
      }
      boolean bool = super.processMessage(paramMessage);
      AppMethodBeat.o(107818);
      return bool;
    }
  }
  
  final class b
    extends r
  {
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(107820);
      super.enter();
      l.c(l.this);
      AppMethodBeat.o(107820);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(107822);
      String str = l.b(l.this) + "|StateIdle";
      AppMethodBeat.o(107822);
      return str;
    }
    
    public final boolean processMessage(Message paramMessage)
    {
      AppMethodBeat.i(107821);
      if ((1 == paramMessage.what) || (2 == paramMessage.what))
      {
        l.c(l.this);
        AppMethodBeat.o(107821);
        return true;
      }
      boolean bool = super.processMessage(paramMessage);
      AppMethodBeat.o(107821);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.l
 * JD-Core Version:    0.7.0.1
 */