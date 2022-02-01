package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class j<Task>
  extends d
{
  final j<Task>.b mTL = new b((byte)0);
  private final j<Task>.a mTM = new a((byte)0);
  final String mTN;
  private final Queue<Task> mTO = new LinkedList();
  
  protected j(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.mTN = paramString;
    a(this.mTL);
    a(this.mTM);
    b(this.mTL);
    start();
  }
  
  public final void bao()
  {
    super.bao();
    synchronized (this.mTO)
    {
      this.mTO.clear();
      return;
    }
  }
  
  protected abstract boolean bjv();
  
  public final void cJ(Task paramTask)
  {
    if (bjv()) {
      return;
    }
    synchronized (this.mTO)
    {
      this.mTO.offer(paramTask);
      abg(1);
      return;
    }
  }
  
  protected abstract void cv(Task paramTask);
  
  final class a
    extends o
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(107819);
      String str = j.this.mTN + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        j.this.b(j.this.mTL);
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
      j.a(j.this);
      AppMethodBeat.o(107820);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(107822);
      String str = j.this.mTN + "|StateIdle";
      AppMethodBeat.o(107822);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107821);
      if ((1 == paramMessage.what) || (2 == paramMessage.what))
      {
        j.a(j.this);
        AppMethodBeat.o(107821);
        return true;
      }
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(107821);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.j
 * JD-Core Version:    0.7.0.1
 */