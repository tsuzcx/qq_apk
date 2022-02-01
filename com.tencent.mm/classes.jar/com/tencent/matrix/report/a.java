package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.c.a.b.a;
import com.tencent.matrix.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;

public final class a
  extends b
{
  private long ctW;
  private long ctX;
  private long ctY;
  long ctZ;
  
  public a()
  {
    y.a(5, new v()
    {
      public final void a(com.tencent.mm.bw.a paramAnonymousa)
      {
        paramAnonymousa = a.this;
        paramAnonymousa.ctZ += 1L;
      }
      
      public final void b(com.tencent.mm.bw.a paramAnonymousa) {}
    });
  }
  
  public final void GK()
  {
    super.GK();
    ac.i("Matrix.BatteryReporter", "onTraceBegin");
    this.ctW = (br.Aj(0L) + br.Ak(0L) + br.Ai(0L) + br.Ak(0L));
    this.ctX = com.tencent.mm.a.a.cEs;
    this.ctY = this.ctZ;
  }
  
  public final void GL()
  {
    super.GL();
    ac.i("Matrix.BatteryReporter", "onTraceEnd");
    this.ctW = (br.Aj(0L) + br.Ak(0L) + br.Ai(0L) + br.Ak(0L) - this.ctW);
    this.ctX = (com.tencent.mm.a.a.cEs - this.ctX);
    this.ctY = (this.ctZ - this.ctY);
    e.wTc.idkeyStat(1013L, 200L, this.ctX, false);
  }
  
  public final StringBuilder GM()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("| extInfo:\n");
    localStringBuilder.append("| ->diffTraffic=").append(bs.qz(this.ctW)).append("\n");
    localStringBuilder.append("| ->diffAlarmCount=").append(this.ctX).append("\n");
    localStringBuilder.append("| ->diffAddMsgCount=").append(this.ctY).append("\n");
    return localStringBuilder;
  }
  
  public final void a(b.a parama)
  {
    int k = 20;
    super.a(parama);
    if (parama.cqM) {
      return;
    }
    long l = parama.csu;
    parama = new ArrayList(4);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1013);
    int m = -1;
    int i = -1;
    int j;
    if (ai.cin())
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
      if (!ai.cin()) {
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
      if (ai.cin()) {
        i = 0;
      }
      for (;;)
      {
        localIDKey.SetKey(i + 18);
        localIDKey.SetValue(1L);
        parama.add(localIDKey);
        e.wTc.b(parama, false);
        return;
        if (ai.eVd())
        {
          i = 20;
          break;
        }
        if (ai.eVb())
        {
          i = 40;
          break;
        }
        if (ai.eVg())
        {
          i = 60;
          break;
        }
        if (ai.eVf())
        {
          i = 80;
          break;
        }
        if (ai.isAppBrandProcess())
        {
          i = 100;
          break;
        }
        if (!ai.eVe()) {
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
        if (ai.eVd())
        {
          i = 20;
          break label133;
        }
        if (ai.eVb())
        {
          i = 40;
          break label133;
        }
        if (ai.eVg())
        {
          i = 60;
          break label133;
        }
        if (ai.eVf())
        {
          i = 80;
          break label133;
        }
        if (ai.isAppBrandProcess())
        {
          i = 100;
          break label133;
        }
        if (!ai.eVe()) {
          break label506;
        }
        i = 120;
        break label133;
        i = k;
        if (!ai.eVd()) {
          if (ai.eVb()) {
            i = 40;
          } else if (ai.eVg()) {
            i = 60;
          } else if (ai.eVf()) {
            i = 80;
          } else if (ai.isAppBrandProcess()) {
            i = 100;
          } else if (ai.eVe()) {
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
    ac.w("Matrix.BatteryReporter", "[onWakeLockTimeout] tag=%s packageName=%s warningCount=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (paramInt <= 1) {
      e.wTc.idkeyStat(1013L, 201L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */