package com.tencent.matrix.a.a;

import com.tencent.matrix.a.a.a.d.b;
import com.tencent.matrix.a.a.a.h;
import com.tencent.matrix.a.a.a.h.d;
import com.tencent.matrix.a.a.a.m.a;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.o.c;
import com.tencent.matrix.a.b.o.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  public boolean clZ = false;
  public long eOb;
  public int eOd;
  public int eOe;
  public int eOf;
  public int eOg;
  public int eOh;
  public int eOi;
  public int eOj;
  public String eOk = "";
  public int eOl;
  public String eOm = "";
  public int eOn;
  private AtomicBoolean eOo;
  
  public static a awA()
  {
    if (com.tencent.matrix.c.isInstalled())
    {
      Object localObject = (com.tencent.matrix.a.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.a.c.class);
      if (localObject != null)
      {
        localObject = new a(((com.tencent.matrix.a.c)localObject).eOc);
        ((a)localObject).clZ = true;
        return localObject;
      }
    }
    return dD(1L);
  }
  
  public static a dD(long paramLong)
  {
    if (paramLong > 0L) {}
    for (;;)
    {
      a locala = new a();
      locala.eOb = paramLong;
      Object localObject1 = (com.tencent.matrix.a.a.a.d)com.tencent.matrix.a.a.aj(com.tencent.matrix.a.a.a.d.class);
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.matrix.a.a.a.d)localObject1).dF(paramLong);
        if (((m.a)localObject2).eSe)
        {
          locala.eOd = ((Long)((d.b)localObject2).eQI.eSn).intValue();
          locala.eOe = ((Long)((d.b)localObject2).eQJ.eSn).intValue();
          locala.eOf = ((Long)((d.b)localObject2).eQK.eSn).intValue();
          localObject1 = ((com.tencent.matrix.a.a.a.d)localObject1).dG(paramLong);
          localObject2 = ((o.c)localObject1).axE();
          if (localObject2 != null)
          {
            locala.eOk = ((o.c.a)localObject2).key;
            locala.eOl = ((o.c.a)localObject2).ratio;
            localObject1 = ((o.c)localObject1).axF();
            if (localObject1 != null)
            {
              locala.eOm = ((o.c.a)localObject1).key;
              locala.eOn = ((o.c.a)localObject1).ratio;
            }
            localObject1 = (h)com.tencent.matrix.a.a.aj(h.class);
            if (localObject1 != null)
            {
              localObject1 = ((h)localObject1).dH(paramLong);
              if (((m.a)localObject1).eSe)
              {
                locala.eOg = ((Long)((h.d)localObject1).eRy.eSn).intValue();
                locala.eOh = ((Long)((h.d)localObject1).eRz.eSn).intValue();
                locala.eOi = ((Long)((h.d)localObject1).eRA.eSn).intValue();
                locala.eOj = ((Long)((h.d)localObject1).eRB.eSn).intValue();
                locala.clZ = true;
              }
            }
          }
        }
      }
      return locala;
      paramLong = 0L;
    }
  }
  
  public long aww()
  {
    return Math.max(1L, this.eOb / 60000L);
  }
  
  public boolean awx()
  {
    return awy() == 3;
  }
  
  public int awy()
  {
    if (this.eOd >= 50) {
      return 1;
    }
    if (this.eOf >= 50) {
      return 3;
    }
    return 2;
  }
  
  public int awz()
  {
    if (this.eOg >= 50) {
      return 1;
    }
    if (this.eOi >= 50) {
      return 3;
    }
    if (this.eOj >= 50) {
      return 4;
    }
    return 2;
  }
  
  public boolean isCharging()
  {
    return awz() == 1;
  }
  
  public boolean isForeground()
  {
    boolean bool = true;
    if (this.eOo != null) {
      bool = this.eOo.get();
    }
    while (awy() == 1) {
      return bool;
    }
    return false;
  }
  
  public String toString()
  {
    return "AppStats{appFgRatio=" + this.eOd + ", appBgRatio=" + this.eOe + ", appFgSrvRatio=" + this.eOf + ", devChargingRatio=" + this.eOg + ", devUnChargingRatio=" + this.eOh + ", devSceneOffRatio=" + this.eOi + ", devLowEnergyRatio=" + this.eOj + ", sceneTop1='" + this.eOk + '\'' + ", sceneTop1Ratio=" + this.eOl + ", sceneTop2='" + this.eOm + '\'' + ", sceneTop2Ratio=" + this.eOn + ", isValid=" + this.clZ + ", duringMillis=" + this.eOb + ", foregroundOverride=" + this.eOo + '}';
  }
  
  static final class a
    extends a
  {
    final d eNY;
    
    a(d paramd)
    {
      this.eNY = paramd;
    }
    
    public final long aww()
    {
      return 0L;
    }
    
    public final boolean awx()
    {
      return b.cc(d.getContext());
    }
    
    public final int awy()
    {
      return b.k(d.getContext(), this.eNY.ePI);
    }
    
    public final int awz()
    {
      return b.bW(d.getContext());
    }
    
    public final boolean isCharging()
    {
      return b.bZ(d.getContext());
    }
    
    public final boolean isForeground()
    {
      return this.eNY.ePI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */