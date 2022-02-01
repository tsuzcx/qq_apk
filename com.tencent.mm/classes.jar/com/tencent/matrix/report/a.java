package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.c.a.b.a;
import com.tencent.matrix.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

public final class a
  extends b
{
  private long cwN;
  private long cwO;
  private long cwP;
  long cwQ;
  
  public a()
  {
    y.a(5, new v()
    {
      public final void a(com.tencent.mm.bx.a paramAnonymousa)
      {
        paramAnonymousa = a.this;
        paramAnonymousa.cwQ += 1L;
      }
      
      public final void b(com.tencent.mm.bx.a paramAnonymousa) {}
    });
  }
  
  public final void GZ()
  {
    super.GZ();
    ad.i("Matrix.BatteryReporter", "onTraceBegin");
    this.cwN = (bs.vG(0L) + bs.vH(0L) + bs.vF(0L) + bs.vH(0L));
    this.cwO = com.tencent.mm.a.a.cHk;
    this.cwP = this.cwQ;
  }
  
  public final void Ha()
  {
    super.Ha();
    ad.i("Matrix.BatteryReporter", "onTraceEnd");
    this.cwN = (bs.vG(0L) + bs.vH(0L) + bs.vF(0L) + bs.vH(0L) - this.cwN);
    this.cwO = (com.tencent.mm.a.a.cHk - this.cwO);
    this.cwP = (this.cwQ - this.cwP);
    e.vIY.idkeyStat(1013L, 200L, this.cwO, false);
  }
  
  public final StringBuilder Hb()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("| extInfo:\n");
    localStringBuilder.append("| ->diffTraffic=").append(bt.mK(this.cwN)).append("\n");
    localStringBuilder.append("| ->diffAlarmCount=").append(this.cwO).append("\n");
    localStringBuilder.append("| ->diffAddMsgCount=").append(this.cwP).append("\n");
    return localStringBuilder;
  }
  
  public final void a(b.a parama)
  {
    int k = 20;
    super.a(parama);
    if (parama.ctF) {
      return;
    }
    long l = parama.cvm;
    parama = new ArrayList(4);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1013);
    int m = -1;
    int i = -1;
    int j;
    if (aj.cbe())
    {
      i = 0;
      j = m;
      if (i >= 0)
      {
        if (l <= 2000L) {
          break label277;
        }
        j = i + 0;
      }
      label82:
      localIDKey.SetKey(j);
      localIDKey.SetValue(1L);
      parama.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetValue(l);
      localIDKey.SetID(1013);
      if (!aj.cbe()) {
        break label360;
      }
      i = 0;
    }
    for (;;)
    {
      label133:
      localIDKey.SetKey(i + 17);
      parama.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(1013);
      if (aj.cbe()) {
        i = 0;
      }
      for (;;)
      {
        localIDKey.SetKey(i + 18);
        localIDKey.SetValue(1L);
        parama.add(localIDKey);
        e.vIY.b(parama, false);
        return;
        if (aj.eFJ())
        {
          i = 20;
          break;
        }
        if (aj.eFH())
        {
          i = 40;
          break;
        }
        if (aj.eFM())
        {
          i = 60;
          break;
        }
        if (aj.eFL())
        {
          i = 80;
          break;
        }
        if (aj.isAppBrandProcess())
        {
          i = 100;
          break;
        }
        if (!aj.eFK()) {
          break;
        }
        i = 120;
        break;
        label277:
        if (l > 1500L)
        {
          j = i + 1;
          break label82;
        }
        if (l > 1000L)
        {
          j = i + 2;
          break label82;
        }
        if (l > 800L)
        {
          j = i + 3;
          break label82;
        }
        if (l > 600L)
        {
          j = i + 4;
          break label82;
        }
        j = m;
        if (l <= 300L) {
          break label82;
        }
        j = i + 5;
        break label82;
        label360:
        if (aj.eFJ())
        {
          i = 20;
          break label133;
        }
        if (aj.eFH())
        {
          i = 40;
          break label133;
        }
        if (aj.eFM())
        {
          i = 60;
          break label133;
        }
        if (aj.eFL())
        {
          i = 80;
          break label133;
        }
        if (aj.isAppBrandProcess())
        {
          i = 100;
          break label133;
        }
        if (!aj.eFK()) {
          break label506;
        }
        i = 120;
        break label133;
        i = k;
        if (!aj.eFJ()) {
          if (aj.eFH()) {
            i = 40;
          } else if (aj.eFM()) {
            i = 60;
          } else if (aj.eFL()) {
            i = 80;
          } else if (aj.isAppBrandProcess()) {
            i = 100;
          } else if (aj.eFK()) {
            i = 120;
          } else {
            i = 0;
          }
        }
      }
      label506:
      i = 0;
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt)
  {
    super.e(paramString1, paramString2, paramInt);
    ad.w("Matrix.BatteryReporter", "[onWakeLockTimeout] tag=%s packageName=%s warningCount=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (paramInt <= 1) {
      e.vIY.idkeyStat(1013L, 201L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */