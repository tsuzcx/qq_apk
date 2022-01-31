package com.tencent.mm.plugin.appbrand.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d
  extends i
{
  final String TAG;
  final d.d fFQ;
  final d.a fFR;
  final e fFS;
  final d.c fFT;
  final d.b fFU;
  public final AtomicBoolean fFV;
  private final AtomicBoolean fFW;
  private final AtomicReference<c> fFX;
  private final AtomicReference<c> fFY;
  private c fFZ;
  final com.tencent.mm.plugin.appbrand.i fzT;
  
  d(com.tencent.mm.plugin.appbrand.i parami) {}
  
  private b a(a parama)
  {
    if ((parama == this.fFR) || (parama == this.fFT) || (parama == this.fFU)) {
      return b.fFJ;
    }
    if (parama == this.fFS) {
      return b.fFK;
    }
    if (parama == this.fFQ) {
      return b.fFI;
    }
    return b.fFI;
  }
  
  private b acA()
  {
    if (this.fFV.get()) {
      return b.fFL;
    }
    Object localObject = (c)this.fFX.get();
    if (localObject != null) {
      return a((a)localObject);
    }
    localObject = (c)this.fFY.get();
    if (localObject != null) {
      return a((a)localObject);
    }
    if (Thread.currentThread().getId() != this.ujd.getLooper().getThread().getId()) {}
    for (localObject = (a)new d.4(this).b(new ah(this.ujd.getLooper()));; localObject = super.csl()) {
      return a((a)localObject);
    }
  }
  
  public abstract void a(b paramb);
  
  final void a(h paramh)
  {
    this.fFX.set(null);
    this.fFY.set(paramh);
    Object localObject = csk();
    if ((localObject != null) && (((Message)localObject).what == -2)) {
      this.fFZ = paramh;
    }
    do
    {
      return;
      localObject = this.fFZ;
      this.fFZ = paramh;
    } while ((localObject == null) || (a((a)localObject) == a(paramh)));
    a(a(paramh));
  }
  
  protected final void abD()
  {
    super.abD();
    if (this.ujd.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
      this.ujd.post(new d.6(this));
    }
  }
  
  abstract void acy();
  
  public final b acz()
  {
    com.tencent.mm.sdk.d.d.c localc = this.ujd;
    if (localc == null) {
      return b.fFL;
    }
    if ((this.fFW.get()) && (Thread.currentThread().getId() != localc.getLooper().getThread().getId()))
    {
      if (ai.isMainThread())
      {
        c localc1 = (c)this.fFY.get();
        boolean bool = this.fFV.get();
        y.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", new Object[] { Long.valueOf(localc.getLooper().getThread().getId()), localc1, Boolean.valueOf(bool) });
        if (localc1 != null) {
          return a(localc1);
        }
        if (bool) {
          return b.fFL;
        }
        return b.fFI;
      }
      return (b)new d.3(this).b(new ah(localc.getLooper()));
    }
    return acA();
  }
  
  protected final boolean e(Message paramMessage)
  {
    return paramMessage.what != 1000;
  }
  
  protected final void f(Message paramMessage)
  {
    super.f(paramMessage);
    this.fFW.set(false);
  }
  
  public final void ku(int paramInt)
  {
    this.fFW.set(true);
    if (csk() == null)
    {
      super.Ff(paramInt);
      return;
    }
    super.Fg(paramInt);
  }
  
  public final void start()
  {
    if (this.fFV.get()) {
      return;
    }
    if (Looper.myLooper() == this.ujd.getLooper())
    {
      super.start();
      return;
    }
    this.ujd.post(new d.2(this));
  }
  
  private final class e
    extends h
  {
    e(i parami)
    {
      super();
    }
    
    private m acC()
    {
      return (m)d.this.fzT.Zy().ahK().I(m.class);
    }
    
    public final void enter()
    {
      super.enter();
      d.this.ujd.sendEmptyMessageDelayed(11, d.this.fzT.ZB().fPR * 1000L);
      Object localObject = acC();
      if (localObject != null)
      {
        ((m)localObject).pause();
        localObject = d.this.fzT.Zy().fzU.fAl.bzG.values().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.d.a.b)((Iterator)localObject).next()).pause();
        }
      }
    }
    
    public final void exit()
    {
      super.exit();
      d.this.ujd.removeMessages(11);
      Object localObject = acC();
      if (localObject != null)
      {
        ((m)localObject).resume();
        localObject = d.this.fzT.Zy().fzU.fAl.bzG.values().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.d.a.b)((Iterator)localObject).next()).resume();
        }
      }
    }
    
    public final boolean g(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return super.g(paramMessage);
      case 3: 
        d.a(d.this, d.this.fFQ);
        return true;
      }
      y.i(d.this.TAG, "suspend timeout");
      d.this.acy();
      return true;
    }
    
    public final String getName()
    {
      return d.this.mName + "|Suspend";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d
 * JD-Core Version:    0.7.0.1
 */