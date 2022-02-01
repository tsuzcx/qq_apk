package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements i
{
  protected int errCode = 0;
  protected int errType = 0;
  protected c yoW;
  protected a ypE;
  
  public abstract void MC();
  
  public final void a(a parama)
  {
    this.ypE = parama;
  }
  
  public void a(c paramc)
  {
    Log.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.yoW = paramc;
    b(this.yoW);
  }
  
  public abstract void b(c paramc);
  
  public void destroy()
  {
    int[] arrayOfInt = eaF();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bg.azz().b(k, this);
      i += 1;
    }
    this.ypE = null;
    onDestroy();
  }
  
  public abstract int[] eaF();
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = eaF();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      bg.azz().a(k, this);
      i += 1;
    }
    MC();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.ypE != null) {
        this.ypE.a(getServiceType(), paramq, paramInt1, paramInt2);
      }
    }
    while (this.ypE == null) {
      return;
    }
    this.ypE.b(getServiceType(), paramq, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.a
 * JD-Core Version:    0.7.0.1
 */