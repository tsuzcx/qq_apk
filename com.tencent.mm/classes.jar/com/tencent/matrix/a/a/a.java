package com.tencent.matrix.a.a;

import com.tencent.matrix.a.a.a.d.b;
import com.tencent.matrix.a.a.a.f;
import com.tencent.matrix.a.a.a.f.d;
import com.tencent.matrix.a.a.a.j.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.b.k.c;
import com.tencent.matrix.a.b.k.c.a;
import com.tencent.matrix.a.c;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  public long cSL;
  public int cSN;
  public int cSO;
  public int cSP;
  public int cSQ;
  public int cSR;
  public int cSS;
  public int cST;
  public String cSU = "";
  public int cSV;
  public String cSW = "";
  public int cSX;
  public boolean cSY = false;
  AtomicBoolean cSZ;
  
  public static a VQ()
  {
    if (com.tencent.matrix.b.Vt())
    {
      Object localObject = (c)com.tencent.matrix.b.Vu().Y(c.class);
      if (localObject != null)
      {
        localObject = new a(((c)localObject).cSM);
        ((a)localObject).cSY = true;
        return localObject;
      }
    }
    return bl(1L);
  }
  
  public static a bl(long paramLong)
  {
    if (paramLong > 0L) {}
    for (;;)
    {
      a locala = new a();
      locala.cSL = paramLong;
      Object localObject1 = (com.tencent.matrix.a.a.a.d)com.tencent.matrix.a.a.Z(com.tencent.matrix.a.a.a.d.class);
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.matrix.a.a.a.d)localObject1).bn(paramLong);
        if (((j.a)localObject2).cWl)
        {
          locala.cSN = ((Long)((d.b)localObject2).cVi.cWu).intValue();
          locala.cSO = ((Long)((d.b)localObject2).cVj.cWu).intValue();
          locala.cSP = ((Long)((d.b)localObject2).cVk.cWu).intValue();
          localObject1 = ((com.tencent.matrix.a.a.a.d)localObject1).bo(paramLong);
          localObject2 = ((k.c)localObject1).WH();
          if (localObject2 != null)
          {
            locala.cSU = ((k.c.a)localObject2).key;
            locala.cSV = ((k.c.a)localObject2).ratio;
            localObject1 = ((k.c)localObject1).WI();
            if (localObject1 != null)
            {
              locala.cSW = ((k.c.a)localObject1).key;
              locala.cSX = ((k.c.a)localObject1).ratio;
            }
            localObject1 = (f)com.tencent.matrix.a.a.Z(f.class);
            if (localObject1 != null)
            {
              localObject1 = ((f)localObject1).bp(paramLong);
              if (((j.a)localObject1).cWl)
              {
                locala.cSQ = ((Long)((f.d)localObject1).cVH.cWu).intValue();
                locala.cSR = ((Long)((f.d)localObject1).cVI.cWu).intValue();
                locala.cSS = ((Long)((f.d)localObject1).cVJ.cWu).intValue();
                locala.cST = ((Long)((f.d)localObject1).cVK.cWu).intValue();
                locala.cSY = true;
              }
            }
          }
        }
      }
      return locala;
      paramLong = 0L;
    }
  }
  
  public long VM()
  {
    return Math.max(1L, this.cSL / 60000L);
  }
  
  public boolean VN()
  {
    return VO() == 3;
  }
  
  public int VO()
  {
    if (this.cSN >= 50) {
      return 1;
    }
    if (this.cSP >= 50) {
      return 3;
    }
    return 2;
  }
  
  public int VP()
  {
    if (this.cSQ >= 50) {
      return 1;
    }
    if (this.cSS >= 50) {
      return 3;
    }
    if (this.cST >= 50) {
      return 4;
    }
    return 2;
  }
  
  public boolean isCharging()
  {
    return VP() == 1;
  }
  
  public boolean isForeground()
  {
    boolean bool = true;
    if (this.cSZ != null) {
      bool = this.cSZ.get();
    }
    while (VO() == 1) {
      return bool;
    }
    return false;
  }
  
  public String toString()
  {
    return "AppStats{appFgRatio=" + this.cSN + ", appBgRatio=" + this.cSO + ", appFgSrvRatio=" + this.cSP + ", devChargingRatio=" + this.cSQ + ", devUnChargingRatio=" + this.cSR + ", devSceneOffRatio=" + this.cSS + ", devLowEnergyRatio=" + this.cST + ", sceneTop1='" + this.cSU + '\'' + ", sceneTop1Ratio=" + this.cSV + ", sceneTop2='" + this.cSW + '\'' + ", sceneTop2Ratio=" + this.cSX + ", isValid=" + this.cSY + ", duringMillis=" + this.cSL + ", foregroundOverride=" + this.cSZ + '}';
  }
  
  static final class a
    extends a
  {
    final d cSI;
    
    a(d paramd)
    {
      this.cSI = paramd;
    }
    
    public final long VM()
    {
      return 0L;
    }
    
    public final boolean VN()
    {
      return com.tencent.matrix.a.b.b.br(d.getContext());
    }
    
    public final int VO()
    {
      return com.tencent.matrix.a.b.b.k(d.getContext(), this.cSI.cUh);
    }
    
    public final int VP()
    {
      return com.tencent.matrix.a.b.b.bl(d.getContext());
    }
    
    public final boolean isCharging()
    {
      return com.tencent.matrix.a.b.b.bo(d.getContext());
    }
    
    public final boolean isForeground()
    {
      return this.cSI.cUh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */