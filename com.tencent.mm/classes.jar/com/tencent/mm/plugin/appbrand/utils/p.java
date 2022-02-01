package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.util.LinkedList;
import java.util.Queue;

public abstract class p<Task>
  extends StateMachine
{
  private final Queue<Task> eMA = new LinkedList();
  private final p<Task>.b uqL = new b((byte)0);
  private final p<Task>.a uqM = new a((byte)0);
  private final String uqN;
  
  protected p(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.uqN = paramString;
    addState(this.uqL);
    addState(this.uqM);
    setInitialState(this.uqL);
    start();
  }
  
  protected final int cNA()
  {
    return this.eMA.size();
  }
  
  protected abstract boolean cqn();
  
  protected abstract void dY(Task paramTask);
  
  public final void en(Task paramTask)
  {
    if (cqn()) {
      return;
    }
    synchronized (this.eMA)
    {
      this.eMA.offer(paramTask);
      sendMessage(1);
      return;
    }
  }
  
  public void onQuitting()
  {
    super.onQuitting();
    synchronized (this.eMA)
    {
      this.eMA.clear();
      return;
    }
  }
  
  final class a
    extends s
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(107819);
      String str = p.b(p.this) + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean processMessage(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        p.a(p.this, p.a(p.this));
        AppMethodBeat.o(107818);
        return true;
      }
      boolean bool = super.processMessage(paramMessage);
      AppMethodBeat.o(107818);
      return bool;
    }
  }
  
  final class b
    extends s
  {
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(107820);
      super.enter();
      p.c(p.this);
      AppMethodBeat.o(107820);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(107822);
      String str = p.b(p.this) + "|StateIdle";
      AppMethodBeat.o(107822);
      return str;
    }
    
    public final boolean processMessage(Message paramMessage)
    {
      AppMethodBeat.i(107821);
      if ((1 == paramMessage.what) || (2 == paramMessage.what))
      {
        p.c(p.this);
        AppMethodBeat.o(107821);
        return true;
      }
      boolean bool = super.processMessage(paramMessage);
      AppMethodBeat.o(107821);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.p
 * JD-Core Version:    0.7.0.1
 */