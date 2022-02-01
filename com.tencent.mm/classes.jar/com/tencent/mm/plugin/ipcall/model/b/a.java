package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
  implements g
{
  protected int errCode = 0;
  protected int errType = 0;
  protected a sAU;
  protected c sAl;
  
  public abstract void Ca();
  
  public final void a(a parama)
  {
    this.sAU = parama;
  }
  
  public void a(c paramc)
  {
    ad.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.sAl = paramc;
    b(this.sAl);
  }
  
  public abstract void b(c paramc);
  
  public abstract int[] cHx();
  
  public void destroy()
  {
    int[] arrayOfInt = cHx();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      az.aeS().b(k, this);
      i += 1;
    }
    this.sAU = null;
    onDestroy();
  }
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = cHx();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      az.aeS().a(k, this);
      i += 1;
    }
    Ca();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ad.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.sAU != null) {
        this.sAU.a(getServiceType(), paramn, paramInt1, paramInt2);
      }
    }
    while (this.sAU == null) {
      return;
    }
    this.sAU.b(getServiceType(), paramn, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.a
 * JD-Core Version:    0.7.0.1
 */