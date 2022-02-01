package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class i<Task>
  extends d
{
  final i<Task>.b moe = new b((byte)0);
  private final i<Task>.a mof = new a((byte)0);
  final String mog;
  private final Queue<Task> moh = new LinkedList();
  
  protected i(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.mog = paramString;
    a(this.moe);
    a(this.mof);
    b(this.moe);
    start();
  }
  
  public final void aWu()
  {
    super.aWu();
    synchronized (this.moh)
    {
      this.moh.clear();
      return;
    }
  }
  
  protected abstract boolean bfj();
  
  public final void cG(Task paramTask)
  {
    if (bfj()) {
      return;
    }
    synchronized (this.moh)
    {
      this.moh.offer(paramTask);
      Yv(1);
      return;
    }
  }
  
  protected abstract void cs(Task paramTask);
  
  final class a
    extends n
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(107819);
      String str = i.this.mog + "|StateExecuting";
      AppMethodBeat.o(107819);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(107818);
      if (2 == paramMessage.what)
      {
        i.this.b(i.this.moe);
        AppMethodBeat.o(107818);
        return true;
      }
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(107818);
      return bool;
    }
  }
  
  final class b
    extends n
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
      String str = i.this.mog + "|StateIdle";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.i
 * JD-Core Version:    0.7.0.1
 */