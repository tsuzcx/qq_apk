package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.util.LinkedList;
import java.util.Queue;

public abstract class j<Task>
  extends StateMachine
{
  private final j<Task>.b ogM = new b((byte)0);
  private final j<Task>.a ogN = new a((byte)0);
  private final String ogO;
  protected final Queue<Task> ogP = new LinkedList();
  
  protected j(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.ogO = paramString;
    addState(this.ogM);
    addState(this.ogN);
    setInitialState(this.ogM);
    start();
  }
  
  protected abstract boolean bEJ();
  
  protected abstract void cE(Task paramTask);
  
  public final void cQ(Task paramTask)
  {
    if (bEJ()) {
      return;
    }
    synchronized (this.ogP)
    {
      this.ogP.offer(paramTask);
      sendMessage(1);
      return;
    }
  }
  
  public void onQuitting()
  {
    super.onQuitting();
    synchronized (this.ogP)
    {
      this.ogP.clear();
      return;
    }
  }
  
  final class a
    extends q
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(107819);
      String str = j.b(j.this) + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean processMessage(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        j.a(j.this, j.a(j.this));
        AppMethodBeat.o(107818);
        return true;
      }
      boolean bool = super.processMessage(paramMessage);
      AppMethodBeat.o(107818);
      return bool;
    }
  }
  
  final class b
    extends q
  {
    private b() {}
    
    public final void enter()
    {
      AppMethodBeat.i(107820);
      super.enter();
      j.c(j.this);
      AppMethodBeat.o(107820);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(107822);
      String str = j.b(j.this) + "|StateIdle";
      AppMethodBeat.o(107822);
      return str;
    }
    
    public final boolean processMessage(Message paramMessage)
    {
      AppMethodBeat.i(107821);
      if ((1 == paramMessage.what) || (2 == paramMessage.what))
      {
        j.c(j.this);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.j
 * JD-Core Version:    0.7.0.1
 */