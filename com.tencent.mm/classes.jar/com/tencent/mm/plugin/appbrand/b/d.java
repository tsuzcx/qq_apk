package com.tencent.mm.plugin.appbrand.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.t;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d
  extends i
{
  final String TAG = this.mName;
  public final AtomicBoolean bIO = new AtomicBoolean(false);
  final com.tencent.mm.plugin.appbrand.i gRG;
  final e gYm;
  final d.b gYn;
  final f gYo;
  final d.d gYp;
  final d.c gYq;
  private final AtomicBoolean gYr = new AtomicBoolean(false);
  private final AtomicReference<com.tencent.mm.sdk.d.c> gYs = new AtomicReference(null);
  private final AtomicReference<com.tencent.mm.sdk.d.c> gYt = new AtomicReference(null);
  private volatile com.tencent.mm.sdk.d.c gYu = null;
  
  d(com.tencent.mm.plugin.appbrand.i parami)
  {
    super("MicroMsg.AppBrand.AppRunningStateMachine[" + parami.mAppId + "]", Looper.getMainLooper());
    this.gRG = parami;
    super.pP(false);
    this.gYp = new d.d(this, this);
    this.gYq = new d.c(this, this);
    this.gYn = new d.b(this, this, parami);
    this.gYm = new e(this);
    this.gYo = new f(this);
    parami = new d.1(this);
    if (Looper.myLooper() == this.yrd.getLooper())
    {
      parami.run();
      return;
    }
    this.gYr.set(true);
    this.yrd.post(parami);
  }
  
  private b a(a parama)
  {
    if ((parama == this.gYn) || (parama == this.gYp) || (parama == this.gYq)) {
      return b.gYf;
    }
    if (parama == this.gYo) {
      return b.gYg;
    }
    if (parama == this.gYm) {
      return b.gYe;
    }
    return b.gYe;
  }
  
  private b dM(boolean paramBoolean)
  {
    if (this.bIO.get())
    {
      com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExportImpl, mStopped=true, return DESTROYED");
      return b.gYh;
    }
    Object localObject = (com.tencent.mm.sdk.d.c)this.gYs.get();
    if (localObject != null) {
      return a((a)localObject);
    }
    localObject = (com.tencent.mm.sdk.d.c)this.gYt.get();
    if (localObject != null) {
      return a((a)localObject);
    }
    if (!paramBoolean) {
      return a(this.gYu);
    }
    if (Thread.currentThread().getId() != this.yrd.getLooper().getThread().getId())
    {
      localObject = new d.4(this);
      com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExportImpl, await");
    }
    for (localObject = (a)((bj)localObject).b(new ak(this.yrd.getLooper()));; localObject = super.dui()) {
      return a((a)localObject);
    }
  }
  
  abstract void a(b paramb);
  
  public final void a(d.a parama)
  {
    int j = 1;
    if (this.yrd == null) {
      com.tencent.luggage.g.d.w(this.TAG, "executeOrPostMessage with cmd[%s], null handler", new Object[] { parama.name() });
    }
    Object localObject;
    label159:
    do
    {
      return;
      this.gYr.set(true);
      if ((Looper.myLooper() == this.yrd.getLooper()) && (duh() != null) && (duh().what != -2))
      {
        localObject = d.a.values();
        int k = localObject.length;
        int i = 0;
        if (i < k)
        {
          d.a locala = localObject[i];
          if ((d.a.c(locala)) || (!this.yrd.hasMessages(d.a.b(locala)))) {}
        }
        for (i = j;; i = 0)
        {
          if ((i != 0) || (this.gYX)) {
            break label159;
          }
          this.yrd.dispatchMessage(obtainMessage(d.a.b(parama)));
          return;
          i += 1;
          break;
        }
      }
      parama = obtainMessage(d.a.b(parama));
      localObject = this.yrd;
    } while (localObject == null);
    ((com.tencent.mm.sdk.d.d.c)localObject).sendMessage(parama);
  }
  
  public final void a(h paramh)
  {
    this.gYs.set(null);
    this.gYt.set(paramh);
    Object localObject = duh();
    if ((localObject != null) && (((Message)localObject).what == -2)) {
      this.gYu = paramh;
    }
    do
    {
      return;
      localObject = this.gYu;
      this.gYu = paramh;
    } while ((localObject == null) || (a((a)localObject) == a(paramh)));
    a(a(paramh));
  }
  
  public final void avu()
  {
    super.avu();
    if (this.yrd.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
      this.yrd.post(new d.6(this));
    }
  }
  
  abstract void awq();
  
  public final b awr()
  {
    com.tencent.mm.sdk.d.d.c localc = this.yrd;
    if (localc == null)
    {
      com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExport, NULL handler, return DESTROYED");
      return b.gYh;
    }
    if (localc.hasMessages(-1))
    {
      com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExport, has SM_QUIT_CMD, return DESTROYED");
      return b.gYh;
    }
    if (this.bIO.get())
    {
      com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExport, mStopped=true, return DESTROYED");
      return b.gYh;
    }
    if ((this.gYr.get()) && (Thread.currentThread().getId() != localc.getLooper().getThread().getId()))
    {
      if (al.isMainThread())
      {
        localObject = (com.tencent.mm.sdk.d.c)this.gYt.get();
        boolean bool = this.bIO.get();
        com.tencent.luggage.g.d.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", new Object[] { Long.valueOf(localc.getLooper().getThread().getId()), localObject, Boolean.valueOf(bool) });
        if (localObject != null) {
          return a((a)localObject);
        }
        if (bool) {
          return b.gYh;
        }
        return b.gYe;
      }
      Object localObject = new d.3(this);
      com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExport, await");
      if ((b)((bj)localObject).b(new ak(localc.getLooper())) == null)
      {
        com.tencent.luggage.g.d.d(this.TAG, "getRunningStateExport, await timeout");
        return dM(false);
      }
    }
    return dM(true);
  }
  
  public final boolean i(Message paramMessage)
  {
    return paramMessage.what != d.a.gYG.intValue;
  }
  
  public final void j(Message paramMessage)
  {
    super.j(paramMessage);
    this.gYr.set(false);
  }
  
  public final void start()
  {
    if (this.bIO.get()) {
      return;
    }
    if (Looper.myLooper() == this.yrd.getLooper())
    {
      super.start();
      return;
    }
    this.yrd.post(new d.2(this));
  }
  
  public final void stop()
  {
    this.bIO.set(true);
    duj();
    a(b.gYh);
  }
  
  final class e
    extends h
  {
    e(i parami)
    {
      super();
    }
    
    public final void enter()
    {
      AppMethodBeat.i(86858);
      super.enter();
      Object localObject = d.e(d.this);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.i.r)localObject).resume();
        localObject = d.this.gRG.ws().gRH.gRP.ccv.values().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((l)((Iterator)localObject).next()).cbC.resume();
        }
      }
      AppMethodBeat.o(86858);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(86859);
      super.exit();
      AppMethodBeat.o(86859);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(86856);
      AppMethodBeat.o(86856);
      return "|Foreground";
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(86857);
      switch (d.7.gYy[d.a.no(paramMessage.what).ordinal()])
      {
      default: 
        boolean bool = super.k(paramMessage);
        AppMethodBeat.o(86857);
        return bool;
      }
      d.a(d.this, d.this.gYn);
      AppMethodBeat.o(86857);
      return true;
    }
  }
  
  final class f
    extends h
  {
    f(i parami)
    {
      super();
    }
    
    public final void enter()
    {
      AppMethodBeat.i(86861);
      super.enter();
      d.this.yrd.sendEmptyMessageDelayed(d.a.gYE.intValue, d.this.gRG.wY().hiW * 1000L);
      Object localObject = d.e(d.this);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.i.r)localObject).pause();
        localObject = d.this.gRG.ws().gRH.gRP.ccv.values().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((l)((Iterator)localObject).next()).cbC.pause();
        }
      }
      AppMethodBeat.o(86861);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(86862);
      super.exit();
      d.this.yrd.removeMessages(d.a.gYE.intValue);
      AppMethodBeat.o(86862);
    }
    
    public final String getName()
    {
      AppMethodBeat.i(86860);
      AppMethodBeat.o(86860);
      return "|Suspend";
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(86863);
      switch (d.7.gYy[d.a.no(paramMessage.what).ordinal()])
      {
      case 5: 
      default: 
        boolean bool = super.k(paramMessage);
        AppMethodBeat.o(86863);
        return bool;
      case 4: 
        d.a(d.this, d.this.gYm);
        AppMethodBeat.o(86863);
        return true;
      }
      com.tencent.luggage.g.d.i(d.this.TAG, "suspend timeout");
      d.this.awq();
      AppMethodBeat.o(86863);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d
 * JD-Core Version:    0.7.0.1
 */