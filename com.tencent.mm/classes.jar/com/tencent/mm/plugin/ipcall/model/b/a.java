package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class a
  implements f
{
  protected int errCode = 0;
  protected int errType = 0;
  protected c uWv;
  protected a uXd;
  
  public abstract void Dg();
  
  public final void a(a parama)
  {
    this.uXd = parama;
  }
  
  public void a(c paramc)
  {
    ae.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.uWv = paramc;
    b(this.uWv);
  }
  
  public abstract void b(c paramc);
  
  public void destroy()
  {
    int[] arrayOfInt = dgL();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bc.ajj().b(k, this);
      i += 1;
    }
    this.uXd = null;
    onDestroy();
  }
  
  public abstract int[] dgL();
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = dgL();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bc.ajj().a(k, this);
      i += 1;
    }
    Dg();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ae.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.uXd != null) {
        this.uXd.a(getServiceType(), paramn, paramInt1, paramInt2);
      }
    }
    while (this.uXd == null) {
      return;
    }
    this.uXd.b(getServiceType(), paramn, paramInt1, paramInt2);
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