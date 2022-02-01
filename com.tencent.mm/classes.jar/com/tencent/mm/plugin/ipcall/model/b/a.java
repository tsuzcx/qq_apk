package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements i
{
  protected c DOY;
  protected a DPG;
  protected int errCode = 0;
  protected int errType = 0;
  
  public abstract void Pu();
  
  public final void a(a parama)
  {
    this.DPG = parama;
  }
  
  public void a(c paramc)
  {
    Log.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.DOY = paramc;
    b(this.DOY);
  }
  
  public abstract void b(c paramc);
  
  public void destroy()
  {
    int[] arrayOfInt = eJD();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bh.aGY().b(k, this);
      i += 1;
    }
    this.DPG = null;
    onDestroy();
  }
  
  public abstract int[] eJD();
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = eJD();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bh.aGY().a(k, this);
      i += 1;
    }
    Pu();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.DPG != null) {
        this.DPG.a(getServiceType(), paramq, paramInt1, paramInt2);
      }
    }
    while (this.DPG == null) {
      return;
    }
    this.DPG.b(getServiceType(), paramq, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.a
 * JD-Core Version:    0.7.0.1
 */