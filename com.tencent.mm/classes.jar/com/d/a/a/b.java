package com.d.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import java.util.List;

abstract class b
  extends a
{
  private z aVF;
  
  b()
  {
    super(new d[] { ab.pF(), r.pi(), u.pz(), k.pe() });
  }
  
  private void b(p paramp)
  {
    if (this.aVF != null) {}
    try
    {
      this.aVF.execute(new b.a(this, paramp, (byte)0));
      return;
    }
    catch (Exception paramp) {}
  }
  
  k.a a(d.a parama)
  {
    if (parama == null) {
      return null;
    }
    return new k.a(Math.max(parama.aVM, 10000L));
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
    this.aVF = z.b(paramHandler);
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
      a(((ab.a)paramp).bch, paramp.aYz, paramp.aYA);
      return;
    case 201: 
      b(paramp);
      return;
    case 202: 
      b(paramp);
      return;
    case 301: 
      paramp = (u.e)paramp;
      a(paramp.x, paramp.y, paramp.bba, paramp.baY, paramp.baZ, paramp.auT, paramp.aYA);
      return;
    }
    paramp = (k.b)paramp;
    a(paramp.lat, paramp.lng, Double.valueOf(paramp.aXG).intValue(), Math.round(paramp.aXH), Math.round(paramp.auT), paramp.aXJ, paramp.aXK, paramp.aXI, paramp.aXL, paramp.aYA);
  }
  
  abstract void a(x paramx, long paramLong1, long paramLong2);
  
  abstract void a(List<ScanResult> paramList, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */