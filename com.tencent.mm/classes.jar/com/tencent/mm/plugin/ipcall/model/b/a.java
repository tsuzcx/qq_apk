package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class a
  implements g
{
  protected int errCode = 0;
  protected int errType = 0;
  protected c tHV;
  protected a tID;
  
  public abstract void BE();
  
  public final void a(a parama)
  {
    this.tID = parama;
  }
  
  public void a(c paramc)
  {
    ac.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.tHV = paramc;
    b(this.tHV);
  }
  
  public abstract void b(c paramc);
  
  public abstract int[] cUI();
  
  public void destroy()
  {
    int[] arrayOfInt = cUI();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      az.agi().b(k, this);
      i += 1;
    }
    this.tID = null;
    onDestroy();
  }
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = cUI();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      az.agi().a(k, this);
      i += 1;
    }
    BE();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ac.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.tID != null) {
        this.tID.a(getServiceType(), paramn, paramInt1, paramInt2);
      }
    }
    while (this.tID == null) {
      return;
    }
    this.tID.b(getServiceType(), paramn, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.a
 * JD-Core Version:    0.7.0.1
 */