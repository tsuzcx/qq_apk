package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.e.l.a;
import com.bumptech.glide.c.h;
import com.bumptech.glide.f.f;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b;
import com.bumptech.glide.h.a.b.a;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k<R>
  implements g.a<R>, a.c
{
  private static final a aEX;
  private static final Handler aEY;
  public final b aDI;
  private final l.a<k<?>> aDJ;
  boolean aDR;
  public h aDh;
  boolean aDi;
  u<?> aDj;
  private final com.bumptech.glide.c.b.c.a aEQ;
  public final l aER;
  public final List<f> aEZ;
  com.bumptech.glide.c.a aEd;
  private final a aFa;
  boolean aFb;
  boolean aFc;
  public boolean aFd;
  private p aFe;
  public boolean aFf;
  public List<f> aFg;
  o<?> aFh;
  public g<R> aFi;
  private final com.bumptech.glide.c.b.c.a azK;
  final com.bumptech.glide.c.b.c.a azL;
  private final com.bumptech.glide.c.b.c.a azR;
  public volatile boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(77000);
    aEX = new a();
    aEY = new Handler(Looper.getMainLooper(), new b());
    AppMethodBeat.o(77000);
  }
  
  k(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml, l.a<k<?>> parama)
  {
    this(parama1, parama2, parama3, parama4, paraml, parama, aEX);
  }
  
  private k(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml, l.a<k<?>> parama, a parama5)
  {
    AppMethodBeat.i(76992);
    this.aEZ = new ArrayList(2);
    this.aDI = new b.a();
    this.azL = parama1;
    this.azK = parama2;
    this.aEQ = parama3;
    this.azR = parama4;
    this.aER = paraml;
    this.aDJ = parama;
    this.aFa = parama5;
    AppMethodBeat.o(76992);
  }
  
  public final void a(g<?> paramg)
  {
    AppMethodBeat.i(76998);
    ol().execute(paramg);
    AppMethodBeat.o(76998);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(76997);
    this.aFe = paramp;
    aEY.obtainMessage(2, this).sendToTarget();
    AppMethodBeat.o(76997);
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(76993);
    j.pQ();
    this.aDI.pU();
    if (this.aFd)
    {
      paramf.c(this.aFh, this.aEd);
      AppMethodBeat.o(76993);
      return;
    }
    if (this.aFf)
    {
      paramf.a(this.aFe);
      AppMethodBeat.o(76993);
      return;
    }
    this.aEZ.add(paramf);
    AppMethodBeat.o(76993);
  }
  
  final boolean b(f paramf)
  {
    AppMethodBeat.i(76994);
    if ((this.aFg != null) && (this.aFg.contains(paramf)))
    {
      AppMethodBeat.o(76994);
      return true;
    }
    AppMethodBeat.o(76994);
    return false;
  }
  
  public final void c(u<R> paramu, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(76996);
    this.aDj = paramu;
    this.aEd = parama;
    aEY.obtainMessage(1, this).sendToTarget();
    AppMethodBeat.o(76996);
  }
  
  public final b oc()
  {
    return this.aDI;
  }
  
  final com.bumptech.glide.c.b.c.a ol()
  {
    if (this.aFb) {
      return this.aEQ;
    }
    if (this.aFc) {
      return this.azR;
    }
    return this.azK;
  }
  
  final void om()
  {
    AppMethodBeat.i(76995);
    j.pQ();
    this.aEZ.clear();
    this.aDh = null;
    this.aFh = null;
    this.aDj = null;
    if (this.aFg != null) {
      this.aFg.clear();
    }
    this.aFf = false;
    this.isCancelled = false;
    this.aFd = false;
    g localg = this.aFi;
    if (localg.aDL.oe()) {
      localg.nW();
    }
    this.aFi = null;
    this.aFe = null;
    this.aEd = null;
    this.aDJ.release(this);
    AppMethodBeat.o(76995);
  }
  
  final void on()
  {
    AppMethodBeat.i(76999);
    this.aDI.pU();
    if (this.isCancelled)
    {
      om();
      AppMethodBeat.o(76999);
      return;
    }
    if (this.aEZ.isEmpty())
    {
      localObject = new IllegalStateException("Received an exception without any callbacks to notify");
      AppMethodBeat.o(76999);
      throw ((Throwable)localObject);
    }
    if (this.aFf)
    {
      localObject = new IllegalStateException("Already failed once");
      AppMethodBeat.o(76999);
      throw ((Throwable)localObject);
    }
    this.aFf = true;
    this.aER.a(this, this.aDh, null);
    Object localObject = this.aEZ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if (!b(localf)) {
        localf.a(this.aFe);
      }
    }
    om();
    AppMethodBeat.o(76999);
  }
  
  static final class a {}
  
  static final class b
    implements Handler.Callback
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(76991);
      k localk = (k)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        paramMessage = new IllegalStateException("Unrecognized message: " + paramMessage.what);
        AppMethodBeat.o(76991);
        throw paramMessage;
      case 1: 
        localk.aDI.pU();
        if (localk.isCancelled)
        {
          localk.aDj.recycle();
          localk.om();
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(76991);
        return true;
        if (localk.aEZ.isEmpty())
        {
          paramMessage = new IllegalStateException("Received a resource without any callbacks to notify");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        if (localk.aFd)
        {
          paramMessage = new IllegalStateException("Already have resource");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        localk.aFh = new o(localk.aDj, localk.aDi, true);
        localk.aFd = true;
        localk.aFh.acquire();
        localk.aER.a(localk, localk.aDh, localk.aFh);
        int j = localk.aEZ.size();
        int i = 0;
        while (i < j)
        {
          paramMessage = (f)localk.aEZ.get(i);
          if (!localk.b(paramMessage))
          {
            localk.aFh.acquire();
            paramMessage.c(localk.aFh, localk.aEd);
          }
          i += 1;
        }
        localk.aFh.release();
        localk.om();
        continue;
        localk.on();
        continue;
        localk.aDI.pU();
        if (!localk.isCancelled)
        {
          paramMessage = new IllegalStateException("Not cancelled");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        localk.aER.a(localk, localk.aDh);
        localk.om();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.k
 * JD-Core Version:    0.7.0.1
 */