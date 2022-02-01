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
  private static final a aFN;
  private static final Handler aFO;
  private final com.bumptech.glide.c.b.c.a aAE;
  final com.bumptech.glide.c.b.c.a aAF;
  private final com.bumptech.glide.c.b.c.a aAL;
  public h aDY;
  boolean aDZ;
  private final l.a<k<?>> aEA;
  boolean aEI;
  com.bumptech.glide.c.a aEU;
  u<?> aEa;
  public final b aEz;
  private final com.bumptech.glide.c.b.c.a aFG;
  public final l aFH;
  public final List<f> aFP;
  private final a aFQ;
  boolean aFR;
  boolean aFS;
  public boolean aFT;
  private p aFU;
  public boolean aFV;
  public List<f> aFW;
  o<?> aFX;
  public g<R> aFY;
  public volatile boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(77000);
    aFN = new a();
    aFO = new Handler(Looper.getMainLooper(), new b());
    AppMethodBeat.o(77000);
  }
  
  k(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml, l.a<k<?>> parama)
  {
    this(parama1, parama2, parama3, parama4, paraml, parama, aFN);
  }
  
  private k(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml, l.a<k<?>> parama, a parama5)
  {
    AppMethodBeat.i(76992);
    this.aFP = new ArrayList(2);
    this.aEz = new b.a();
    this.aAF = parama1;
    this.aAE = parama2;
    this.aFG = parama3;
    this.aAL = parama4;
    this.aFH = paraml;
    this.aEA = parama;
    this.aFQ = parama5;
    AppMethodBeat.o(76992);
  }
  
  public final void a(g<?> paramg)
  {
    AppMethodBeat.i(76998);
    ov().execute(paramg);
    AppMethodBeat.o(76998);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(76997);
    this.aFU = paramp;
    aFO.obtainMessage(2, this).sendToTarget();
    AppMethodBeat.o(76997);
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(76993);
    j.qa();
    this.aEz.qe();
    if (this.aFT)
    {
      paramf.c(this.aFX, this.aEU);
      AppMethodBeat.o(76993);
      return;
    }
    if (this.aFV)
    {
      paramf.a(this.aFU);
      AppMethodBeat.o(76993);
      return;
    }
    this.aFP.add(paramf);
    AppMethodBeat.o(76993);
  }
  
  final boolean b(f paramf)
  {
    AppMethodBeat.i(76994);
    if ((this.aFW != null) && (this.aFW.contains(paramf)))
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
    this.aEa = paramu;
    this.aEU = parama;
    aFO.obtainMessage(1, this).sendToTarget();
    AppMethodBeat.o(76996);
  }
  
  public final b om()
  {
    return this.aEz;
  }
  
  final com.bumptech.glide.c.b.c.a ov()
  {
    if (this.aFR) {
      return this.aFG;
    }
    if (this.aFS) {
      return this.aAL;
    }
    return this.aAE;
  }
  
  final void ow()
  {
    AppMethodBeat.i(76995);
    j.qa();
    this.aFP.clear();
    this.aDY = null;
    this.aFX = null;
    this.aEa = null;
    if (this.aFW != null) {
      this.aFW.clear();
    }
    this.aFV = false;
    this.isCancelled = false;
    this.aFT = false;
    g localg = this.aFY;
    if (localg.aEC.oo()) {
      localg.og();
    }
    this.aFY = null;
    this.aFU = null;
    this.aEU = null;
    this.aEA.release(this);
    AppMethodBeat.o(76995);
  }
  
  final void ox()
  {
    AppMethodBeat.i(76999);
    this.aEz.qe();
    if (this.isCancelled)
    {
      ow();
      AppMethodBeat.o(76999);
      return;
    }
    if (this.aFP.isEmpty())
    {
      localObject = new IllegalStateException("Received an exception without any callbacks to notify");
      AppMethodBeat.o(76999);
      throw ((Throwable)localObject);
    }
    if (this.aFV)
    {
      localObject = new IllegalStateException("Already failed once");
      AppMethodBeat.o(76999);
      throw ((Throwable)localObject);
    }
    this.aFV = true;
    this.aFH.a(this, this.aDY, null);
    Object localObject = this.aFP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if (!b(localf)) {
        localf.a(this.aFU);
      }
    }
    ow();
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
        localk.aEz.qe();
        if (localk.isCancelled)
        {
          localk.aEa.recycle();
          localk.ow();
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(76991);
        return true;
        if (localk.aFP.isEmpty())
        {
          paramMessage = new IllegalStateException("Received a resource without any callbacks to notify");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        if (localk.aFT)
        {
          paramMessage = new IllegalStateException("Already have resource");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        localk.aFX = new o(localk.aEa, localk.aDZ, true);
        localk.aFT = true;
        localk.aFX.acquire();
        localk.aFH.a(localk, localk.aDY, localk.aFX);
        int j = localk.aFP.size();
        int i = 0;
        while (i < j)
        {
          paramMessage = (f)localk.aFP.get(i);
          if (!localk.b(paramMessage))
          {
            localk.aFX.acquire();
            paramMessage.c(localk.aFX, localk.aEU);
          }
          i += 1;
        }
        localk.aFX.release();
        localk.ow();
        continue;
        localk.ox();
        continue;
        localk.aEz.qe();
        if (!localk.isCancelled)
        {
          paramMessage = new IllegalStateException("Not cancelled");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        localk.aFH.a(localk, localk.aDY);
        localk.ow();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.k
 * JD-Core Version:    0.7.0.1
 */