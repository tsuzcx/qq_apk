package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  implements f
{
  protected int errCode = 0;
  protected int errType = 0;
  public c loW;
  public a.a lpA;
  
  public abstract int LW();
  
  public void a(c paramc)
  {
    y.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[] { Integer.valueOf(LW()) });
    this.loW = paramc;
    b(this.loW);
  }
  
  public abstract void b(c paramc);
  
  public abstract int[] bcs();
  
  public void destroy()
  {
    int[] arrayOfInt = bcs();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      au.Dk().b(k, this);
      i += 1;
    }
    this.lpA = null;
    onDestroy();
  }
  
  public void init()
  {
    int[] arrayOfInt = bcs();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      au.Dk().a(k, this);
      i += 1;
    }
    pT();
  }
  
  public abstract void onDestroy();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()), Integer.valueOf(LW()) });
    this.errType = paramInt1;
    this.errCode = paramInt2;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.lpA != null) {
        this.lpA.a(LW(), paramm, paramInt1, paramInt2);
      }
    }
    while (this.lpA == null) {
      return;
    }
    this.lpA.b(LW(), paramm, paramInt1, paramInt2);
  }
  
  public abstract void pT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.a
 * JD-Core Version:    0.7.0.1
 */