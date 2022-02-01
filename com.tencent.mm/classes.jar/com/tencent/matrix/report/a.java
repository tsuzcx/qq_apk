package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.c.a.b.a;
import com.tencent.matrix.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

public final class a
  extends b
{
  private long cER;
  private long cES;
  private long cET;
  long cEU;
  
  public a()
  {
    aa.a(5, new x()
    {
      public final void a(com.tencent.mm.bx.a paramAnonymousa)
      {
        paramAnonymousa = a.this;
        paramAnonymousa.cEU += 1L;
      }
      
      public final void b(com.tencent.mm.bx.a paramAnonymousa) {}
    });
  }
  
  public final void If()
  {
    super.If();
    ad.i("Matrix.BatteryReporter", "onTraceBegin");
    this.cER = (bs.CZ(0L) + bs.Da(0L) + bs.CY(0L) + bs.Da(0L));
    this.cES = com.tencent.mm.a.a.cPx;
    this.cET = this.cEU;
  }
  
  public final void Ig()
  {
    super.Ig();
    ad.i("Matrix.BatteryReporter", "onTraceEnd");
    this.cER = (bs.CZ(0L) + bs.Da(0L) + bs.CY(0L) + bs.Da(0L) - this.cER);
    this.cES = (com.tencent.mm.a.a.cPx - this.cES);
    this.cET = (this.cEU - this.cET);
    e.ygI.idkeyStat(1013L, 200L, this.cES, false);
  }
  
  public final StringBuilder Ih()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("| extInfo:\n");
    localStringBuilder.append("| ->diffTraffic=").append(bt.sy(this.cER)).append("\n");
    localStringBuilder.append("| ->diffAlarmCount=").append(this.cES).append("\n");
    localStringBuilder.append("| ->diffAddMsgCount=").append(this.cET).append("\n");
    return localStringBuilder;
  }
  
  public final void a(b.a parama)
  {
    int k = 20;
    super.a(parama);
    if (parama.cBJ) {
      return;
    }
    long l = parama.cDq;
    parama = new ArrayList(4);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1013);
    int m = -1;
    int i = -1;
    int j;
    if (aj.cmR())
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
      if (!aj.cmR()) {
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
      if (aj.cmR()) {
        i = 0;
      }
      for (;;)
      {
        localIDKey.SetKey(i + 18);
        localIDKey.SetValue(1L);
        parama.add(localIDKey);
        e.ygI.b(parama, false);
        return;
        if (aj.fkI())
        {
          i = 20;
          break;
        }
        if (aj.fkG())
        {
          i = 40;
          break;
        }
        if (aj.fkL())
        {
          i = 60;
          break;
        }
        if (aj.fkK())
        {
          i = 80;
          break;
        }
        if (aj.isAppBrandProcess())
        {
          i = 100;
          break;
        }
        if (!aj.fkJ()) {
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
        if (aj.fkI())
        {
          i = 20;
          break label133;
        }
        if (aj.fkG())
        {
          i = 40;
          break label133;
        }
        if (aj.fkL())
        {
          i = 60;
          break label133;
        }
        if (aj.fkK())
        {
          i = 80;
          break label133;
        }
        if (aj.isAppBrandProcess())
        {
          i = 100;
          break label133;
        }
        if (!aj.fkJ()) {
          break label506;
        }
        i = 120;
        break label133;
        i = k;
        if (!aj.fkI()) {
          if (aj.fkG()) {
            i = 40;
          } else if (aj.fkL()) {
            i = 60;
          } else if (aj.fkK()) {
            i = 80;
          } else if (aj.isAppBrandProcess()) {
            i = 100;
          } else if (aj.fkJ()) {
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
      e.ygI.idkeyStat(1013L, 201L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */