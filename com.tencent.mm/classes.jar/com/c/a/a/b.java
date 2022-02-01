package com.c.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b
  extends a
{
  private z bON;
  
  b()
  {
    super(new d[] { ab.zz(), r.zc(), u.zt(), k.yY() });
  }
  
  private void b(p paramp)
  {
    if (this.bON != null) {}
    try
    {
      this.bON.execute(new a(this, paramp, (byte)0));
      return;
    }
    catch (Exception paramp) {}
  }
  
  k.a a(d.a parama)
  {
    if (parama == null) {
      return null;
    }
    return new k.a(Math.max(parama.bOU, 10000L));
  }
  
  abstract void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, long paramLong1, long paramLong2);
  
  abstract void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong);
  
  abstract void a(int paramInt, String paramString, long paramLong1, long paramLong2);
  
  void a(Handler paramHandler, d.a parama)
  {
    if (paramHandler == null) {
      try
      {
        throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
      }
      finally {}
    }
    this.bON = z.b(paramHandler);
    super.a(paramHandler, parama);
  }
  
  final void a(Handler paramHandler, Handler[] paramArrayOfHandler)
  {
    paramArrayOfHandler[0] = paramHandler;
    paramArrayOfHandler[1] = null;
    paramArrayOfHandler[2] = paramHandler;
    paramArrayOfHandler[3] = paramHandler;
  }
  
  final void a(d.a parama, d.a[] paramArrayOfa)
  {
    paramArrayOfa[0] = parama;
    paramArrayOfa[1] = null;
    paramArrayOfa[2] = null;
    paramArrayOfa[3] = a(parama);
  }
  
  public void a(p paramp)
  {
    switch (paramp.what)
    {
    default: 
      return;
    case 101: 
      a(((ab.a)paramp).bVi, paramp.bRC, paramp.bRD);
      return;
    case 201: 
      b(paramp);
      return;
    case 202: 
      b(paramp);
      return;
    case 301: 
      paramp = (u.e)paramp;
      a(paramp.x, paramp.y, paramp.bUc, paramp.bUa, paramp.bUb, paramp.aSD, paramp.bRD);
      return;
    }
    paramp = (k.b)paramp;
    a(paramp.lat, paramp.lng, Double.valueOf(paramp.bQK).intValue(), Math.round(paramp.bQL), Math.round(paramp.aSD), paramp.bQN, paramp.bQO, paramp.bQM, paramp.bQP, paramp.bRD);
  }
  
  abstract void a(x paramx, long paramLong1, long paramLong2);
  
  abstract void a(List<ScanResult> paramList, long paramLong1, long paramLong2);
  
  static final class a
    implements Runnable
  {
    private final WeakReference<b> bOO;
    private final p bOP;
    
    private a(b paramb, p paramp)
    {
      AppMethodBeat.i(88017);
      if ((paramb == null) || (paramp == null))
      {
        paramb = new Exception("CoreAssembly: HandleMsgTask: null arg");
        AppMethodBeat.o(88017);
        throw paramb;
      }
      this.bOO = new WeakReference(paramb);
      this.bOP = paramp;
      AppMethodBeat.o(88017);
    }
    
    public final void run()
    {
      AppMethodBeat.i(88018);
      b localb = (b)this.bOO.get();
      if (localb != null) {
        switch (this.bOP.what)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(88018);
        return;
        r.f localf = (r.f)this.bOP;
        if (localf.bRZ == 1)
        {
          localb.a(localf.bSa, localf.bRC, localf.bRD);
          AppMethodBeat.o(88018);
          return;
        }
        localb.a(localf.bRZ, localf.message, localf.bRC, localf.bRD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */