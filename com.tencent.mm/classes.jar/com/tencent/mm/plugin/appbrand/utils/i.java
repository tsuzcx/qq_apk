package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class i<Task>
  extends d
{
  final i<Task>.b mOG = new b((byte)0);
  private final i<Task>.a mOH = new a((byte)0);
  final String mOI;
  private final Queue<Task> mOJ = new LinkedList();
  
  protected i(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.mOI = paramString;
    a(this.mOG);
    a(this.mOH);
    b(this.mOG);
    start();
  }
  
  public final void aZP()
  {
    super.aZP();
    synchronized (this.mOJ)
    {
      this.mOJ.clear();
      return;
    }
  }
  
  protected abstract boolean biM();
  
  public final void cI(Task paramTask)
  {
    if (biM()) {
      return;
    }
    synchronized (this.mOJ)
    {
      this.mOJ.offer(paramTask);
      aaA(1);
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
      String str = i.this.mOI + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        i.this.b(i.this.mOG);
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
      i.a(i.this);
      AppMethodBeat.o(107820);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(107822);
      String str = i.this.mOI + "|StateIdle";
      AppMethodBeat.o(107822);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107821);
      if ((1 == paramMessage.what) || (2 == paramMessage.what))
      {
        i.a(i.this);
        AppMethodBeat.o(107821);
        return true;
      }
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(107821);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.i
 * JD-Core Version:    0.7.0.1
 */