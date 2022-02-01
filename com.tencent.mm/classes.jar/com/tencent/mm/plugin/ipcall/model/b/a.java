package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
  implements f
{
  protected int errCode = 0;
  protected int errType = 0;
  protected c uKI;
  protected a uLq;
  
  public abstract void Dd();
  
  public final void a(a parama)
  {
    this.uLq = parama;
  }
  
  public void a(c paramc)
  {
    ad.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.uKI = paramc;
    b(this.uKI);
  }
  
  public abstract void b(c paramc);
  
  public abstract int[] ddT();
  
  public void destroy()
  {
    int[] arrayOfInt = ddT();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      ba.aiU().b(k, this);
      i += 1;
    }
    this.uLq = null;
    onDestroy();
  }
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = ddT();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      ba.aiU().a(k, this);
      i += 1;
    }
    Dd();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ad.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.uLq != null) {
        this.uLq.a(getServiceType(), paramn, paramInt1, paramInt2);
      }
    }
    while (this.uLq == null) {
      return;
    }
    this.uLq.b(getServiceType(), paramn, paramInt1, paramInt2);
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