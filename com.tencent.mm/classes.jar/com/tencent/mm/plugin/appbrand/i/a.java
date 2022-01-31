package com.tencent.mm.plugin.appbrand.i;

import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.mm.d.a.k;
import com.tencent.mm.d.a.k.1;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends b
  implements f, h, l, m
{
  private final k bzI = k.tF();
  public final com.tencent.mm.d.a.b gIp = this.bzI.ev(1);
  private final AtomicInteger gIq = new AtomicInteger(1);
  private final SparseArray<c> gIr = new SparseArray();
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a()
  {
    assert (this.gIp != null);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    super.a(paramURL, paramString3, paramValueCallback);
  }
  
  public final boolean age()
  {
    return true;
  }
  
  public final int agf()
  {
    return 1;
  }
  
  public final d ago()
  {
    return this;
  }
  
  public final d agp()
  {
    int i = this.gIq.incrementAndGet();
    c localc = new c(this.bzI.ev(i), i);
    synchronized (this.gIr)
    {
      this.gIr.put(i, localc);
      return localc;
    }
  }
  
  protected final com.tencent.mm.d.a.b alz()
  {
    return this.gIp;
  }
  
  public void destroy()
  {
    super.destroy();
    k localk = this.bzI;
    localk.byY.i(new k.1(localk));
  }
  
  public final d kQ(int paramInt)
  {
    if (1 == paramInt) {
      return this;
    }
    synchronized (this.gIr)
    {
      d locald = (d)this.gIr.get(paramInt);
      return locald;
    }
  }
  
  public final void kR(int paramInt)
  {
    if (1 == paramInt) {
      destroy();
    }
    for (;;)
    {
      return;
      synchronized (this.gIr)
      {
        c localc = (c)this.gIr.get(paramInt);
        if (localc == null) {
          continue;
        }
        localc.destroy();
        return;
      }
    }
  }
  
  public void setJsExceptionHandler(e parame)
  {
    this.gIp.a(1, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.a
 * JD-Core Version:    0.7.0.1
 */