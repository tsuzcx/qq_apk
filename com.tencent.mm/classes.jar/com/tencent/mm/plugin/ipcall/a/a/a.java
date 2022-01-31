package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a
  implements f
{
  protected int errCode = 0;
  protected int errType = 0;
  protected a.a nMW;
  protected c nMs;
  
  public final void a(a.a parama)
  {
    this.nMW = parama;
  }
  
  public void a(c paramc)
  {
    ab.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
    this.nMs = paramc;
    b(this.nMs);
  }
  
  public abstract void b(c paramc);
  
  public abstract int[] bJz();
  
  public void destroy()
  {
    int[] arrayOfInt = bJz();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      aw.Rc().b(k, this);
      i += 1;
    }
    this.nMW = null;
    onDestroy();
  }
  
  public abstract int getServiceType();
  
  public void init()
  {
    int[] arrayOfInt = bJz();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      aw.Rc().a(k, this);
      i += 1;
    }
    tW();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    ab.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()), Integer.valueOf(getServiceType()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.nMW != null) {
        this.nMW.a(getServiceType(), paramm, paramInt1, paramInt2);
      }
    }
    while (this.nMW == null) {
      return;
    }
    this.nMW.b(getServiceType(), paramm, paramInt1, paramInt2);
  }
  
  public abstract void tW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.a
 * JD-Core Version:    0.7.0.1
 */