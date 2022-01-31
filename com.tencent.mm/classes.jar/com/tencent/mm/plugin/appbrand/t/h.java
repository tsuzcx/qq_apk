package com.tencent.mm.plugin.appbrand.t;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class h<Task>
  extends d
{
  final h<Task>.b iXF = new h.b(this, (byte)0);
  private final h<Task>.a iXG = new a((byte)0);
  final String iXH;
  private final Queue<Task> iXI = new LinkedList();
  
  protected h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.iXH = paramString;
    a(this.iXF);
    a(this.iXG);
    b(this.iXF);
    start();
  }
  
  protected abstract boolean aBX();
  
  public final void avu()
  {
    super.avu();
    synchronized (this.iXI)
    {
      this.iXI.clear();
      return;
    }
  }
  
  protected abstract void bj(Task paramTask);
  
  public final void bu(Task paramTask)
  {
    if (aBX()) {
      return;
    }
    synchronized (this.iXI)
    {
      this.iXI.offer(paramTask);
      sendMessage(1);
      return;
    }
  }
  
  final class a
    extends k
  {
    private a() {}
    
    public final String getName()
    {
      AppMethodBeat.i(73197);
      String str = h.this.iXH + "|StateExecuting";
      AppMethodBeat.o(73197);
      return str;
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(73196);
      if (2 == paramMessage.what)
      {
        h.this.b(h.this.iXF);
        AppMethodBeat.o(73196);
        return true;
      }
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(73196);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.h
 * JD-Core Version:    0.7.0.1
 */