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
  private static final a aHE;
  private static final Handler aHF;
  private final com.bumptech.glide.c.b.c.a aCC;
  private final com.bumptech.glide.c.b.c.a aCv;
  final com.bumptech.glide.c.b.c.a aCw;
  public h aFP;
  boolean aFQ;
  u<?> aFR;
  com.bumptech.glide.c.a aGL;
  public final b aGq;
  private final l.a<k<?>> aGr;
  boolean aGz;
  public final List<f> aHG;
  private final a aHH;
  boolean aHI;
  boolean aHJ;
  public boolean aHK;
  private p aHL;
  public boolean aHM;
  public List<f> aHN;
  o<?> aHO;
  public g<R> aHP;
  private final com.bumptech.glide.c.b.c.a aHx;
  public final l aHy;
  public volatile boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(77000);
    aHE = new a();
    aHF = new Handler(Looper.getMainLooper(), new b());
    AppMethodBeat.o(77000);
  }
  
  k(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml, l.a<k<?>> parama)
  {
    this(parama1, parama2, parama3, parama4, paraml, parama, aHE);
  }
  
  private k(com.bumptech.glide.c.b.c.a parama1, com.bumptech.glide.c.b.c.a parama2, com.bumptech.glide.c.b.c.a parama3, com.bumptech.glide.c.b.c.a parama4, l paraml, l.a<k<?>> parama, a parama5)
  {
    AppMethodBeat.i(76992);
    this.aHG = new ArrayList(2);
    this.aGq = new b.a();
    this.aCw = parama1;
    this.aCv = parama2;
    this.aHx = parama3;
    this.aCC = parama4;
    this.aHy = paraml;
    this.aGr = parama;
    this.aHH = parama5;
    AppMethodBeat.o(76992);
  }
  
  public final void a(g<?> paramg)
  {
    AppMethodBeat.i(76998);
    oN().execute(paramg);
    AppMethodBeat.o(76998);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(76997);
    this.aHL = paramp;
    aHF.obtainMessage(2, this).sendToTarget();
    AppMethodBeat.o(76997);
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(76993);
    j.qs();
    this.aGq.qw();
    if (this.aHK)
    {
      paramf.c(this.aHO, this.aGL);
      AppMethodBeat.o(76993);
      return;
    }
    if (this.aHM)
    {
      paramf.a(this.aHL);
      AppMethodBeat.o(76993);
      return;
    }
    this.aHG.add(paramf);
    AppMethodBeat.o(76993);
  }
  
  final boolean b(f paramf)
  {
    AppMethodBeat.i(76994);
    if ((this.aHN != null) && (this.aHN.contains(paramf)))
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
    this.aFR = paramu;
    this.aGL = parama;
    aHF.obtainMessage(1, this).sendToTarget();
    AppMethodBeat.o(76996);
  }
  
  public final b oE()
  {
    return this.aGq;
  }
  
  final com.bumptech.glide.c.b.c.a oN()
  {
    if (this.aHI) {
      return this.aHx;
    }
    if (this.aHJ) {
      return this.aCC;
    }
    return this.aCv;
  }
  
  final void oO()
  {
    AppMethodBeat.i(76995);
    j.qs();
    this.aHG.clear();
    this.aFP = null;
    this.aHO = null;
    this.aFR = null;
    if (this.aHN != null) {
      this.aHN.clear();
    }
    this.aHM = false;
    this.isCancelled = false;
    this.aHK = false;
    g localg = this.aHP;
    if (localg.aGt.oG()) {
      localg.oy();
    }
    this.aHP = null;
    this.aHL = null;
    this.aGL = null;
    this.aGr.release(this);
    AppMethodBeat.o(76995);
  }
  
  final void oP()
  {
    AppMethodBeat.i(76999);
    this.aGq.qw();
    if (this.isCancelled)
    {
      oO();
      AppMethodBeat.o(76999);
      return;
    }
    if (this.aHG.isEmpty())
    {
      localObject = new IllegalStateException("Received an exception without any callbacks to notify");
      AppMethodBeat.o(76999);
      throw ((Throwable)localObject);
    }
    if (this.aHM)
    {
      localObject = new IllegalStateException("Already failed once");
      AppMethodBeat.o(76999);
      throw ((Throwable)localObject);
    }
    this.aHM = true;
    this.aHy.a(this, this.aFP, null);
    Object localObject = this.aHG.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if (!b(localf)) {
        localf.a(this.aHL);
      }
    }
    oO();
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
        localk.aGq.qw();
        if (localk.isCancelled)
        {
          localk.aFR.recycle();
          localk.oO();
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(76991);
        return true;
        if (localk.aHG.isEmpty())
        {
          paramMessage = new IllegalStateException("Received a resource without any callbacks to notify");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        if (localk.aHK)
        {
          paramMessage = new IllegalStateException("Already have resource");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        localk.aHO = new o(localk.aFR, localk.aFQ, true);
        localk.aHK = true;
        localk.aHO.acquire();
        localk.aHy.a(localk, localk.aFP, localk.aHO);
        int j = localk.aHG.size();
        int i = 0;
        while (i < j)
        {
          paramMessage = (f)localk.aHG.get(i);
          if (!localk.b(paramMessage))
          {
            localk.aHO.acquire();
            paramMessage.c(localk.aHO, localk.aGL);
          }
          i += 1;
        }
        localk.aHO.release();
        localk.oO();
        continue;
        localk.oP();
        continue;
        localk.aGq.qw();
        if (!localk.isCancelled)
        {
          paramMessage = new IllegalStateException("Not cancelled");
          AppMethodBeat.o(76991);
          throw paramMessage;
        }
        localk.aHy.a(localk, localk.aFP);
        localk.oO();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.k
 * JD-Core Version:    0.7.0.1
 */