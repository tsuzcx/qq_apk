package com.tencent.mm.plugin.appbrand.v;

import android.os.Looper;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class f<Task>
  extends d
{
  final f<Task>.b hlk = new f.b(this, (byte)0);
  private final f<Task>.a hll = new f.a(this, (byte)0);
  final String hlm;
  public final Queue<Task> hln = new LinkedList();
  
  public f(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    this.hlm = paramString;
    a(this.hlk);
    a(this.hll);
    b(this.hlk);
    start();
  }
  
  public abstract void aQ(Task paramTask);
  
  protected final void abD()
  {
    super.abD();
    synchronized (this.hln)
    {
      this.hln.clear();
      return;
    }
  }
  
  public abstract boolean aid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.f
 * JD-Core Version:    0.7.0.1
 */