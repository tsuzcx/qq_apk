package com.b.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b
  extends a
{
  private z bmn;
  
  b()
  {
    super(new d[] { ab.tL(), r.to(), u.tF(), k.tk() });
  }
  
  private void b(p paramp)
  {
    if (this.bmn != null) {}
    try
    {
      this.bmn.execute(new a(this, paramp, (byte)0));
      return;
    }
    catch (Exception paramp) {}
  }
  
  k.a a(d.a parama)
  {
    if (parama == null) {
      return null;
    }
    return new k.a(Math.max(parama.bmu, 10000L));
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
    this.bmn = z.b(paramHandler);
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
      a(((ab.a)paramp).bsN, paramp.bpg, paramp.bph);
      return;
    case 201: 
      b(paramp);
      return;
    case 202: 
      b(paramp);
      return;
    case 301: 
      paramp = (u.e)paramp;
      a(paramp.x, paramp.y, paramp.brG, paramp.brE, paramp.brF, paramp.speed, paramp.bph);
      return;
    }
    paramp = (k.b)paramp;
    a(paramp.lat, paramp.lng, Double.valueOf(paramp.bon).intValue(), Math.round(paramp.boo), Math.round(paramp.speed), paramp.boq, paramp.bor, paramp.bop, paramp.bos, paramp.bph);
  }
  
  abstract void a(x paramx, long paramLong1, long paramLong2);
  
  abstract void a(List<ScanResult> paramList, long paramLong1, long paramLong2);
  
  static final class a
    implements Runnable
  {
    private final WeakReference<b> bmo;
    private final p bmp;
    
    private a(b paramb, p paramp)
    {
      AppMethodBeat.i(55672);
      if ((paramb == null) || (paramp == null))
      {
        paramb = new Exception("CoreAssembly: HandleMsgTask: null arg");
        AppMethodBeat.o(55672);
        throw paramb;
      }
      this.bmo = new WeakReference(paramb);
      this.bmp = paramp;
      AppMethodBeat.o(55672);
    }
    
    public final void run()
    {
      AppMethodBeat.i(55673);
      b localb = (b)this.bmo.get();
      if (localb != null) {
        switch (this.bmp.what)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(55673);
        return;
        r.f localf = (r.f)this.bmp;
        if (localf.bpE == 1)
        {
          localb.a(localf.bpF, localf.bpg, localf.bph);
          AppMethodBeat.o(55673);
          return;
        }
        localb.a(localf.bpE, localf.message, localf.bpg, localf.bph);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */