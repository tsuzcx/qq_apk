package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements h
{
  protected a JGS;
  protected c JGn;
  protected int errCode = 0;
  protected int errType = 0;
  
  public final void a(a parama)
  {
    this.JGS = parama;
  }
  
  public void a(c paramc)
  {
    Log.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.JGn = paramc;
    b(this.JGn);
  }
  
  public abstract void apC();
  
  public abstract void b(c paramc);
  
  public void destroy()
  {
    int[] arrayOfInt = fRD();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bh.aZW().b(k, this);
      i += 1;
    }
    this.JGS = null;
    onDestroy();
  }
  
  public abstract int[] fRD();
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = fRD();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bh.aZW().a(k, this);
      i += 1;
    }
    apC();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Log.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.JGS != null) {
        this.JGS.a(getServiceType(), paramp, paramInt1, paramInt2);
      }
    }
    while (this.JGS == null) {
      return;
    }
    this.JGS.b(getServiceType(), paramp, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.a
 * JD-Core Version:    0.7.0.1
 */