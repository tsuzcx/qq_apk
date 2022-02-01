package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.c.a.b.a;
import com.tencent.matrix.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

public final class a
  extends b
{
  private long cFA;
  long cFB;
  private long cFy;
  private long cFz;
  
  public a()
  {
    ab.a(5, new y()
    {
      public final void a(com.tencent.mm.bw.a paramAnonymousa)
      {
        paramAnonymousa = a.this;
        paramAnonymousa.cFB += 1L;
      }
      
      public final void b(com.tencent.mm.bw.a paramAnonymousa) {}
    });
  }
  
  public final void In()
  {
    super.In();
    ae.i("Matrix.BatteryReporter", "onTraceBegin");
    this.cFy = (bt.Dx(0L) + bt.Dy(0L) + bt.Dw(0L) + bt.Dy(0L));
    this.cFz = com.tencent.mm.a.a.cQh;
    this.cFA = this.cFB;
  }
  
  public final void Io()
  {
    super.Io();
    ae.i("Matrix.BatteryReporter", "onTraceEnd");
    this.cFy = (bt.Dx(0L) + bt.Dy(0L) + bt.Dw(0L) + bt.Dy(0L) - this.cFy);
    this.cFz = (com.tencent.mm.a.a.cQh - this.cFz);
    this.cFA = (this.cFB - this.cFA);
    e.ywz.idkeyStat(1013L, 200L, this.cFz, false);
  }
  
  public final StringBuilder Ip()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("| extInfo:\n");
    localStringBuilder.append("| ->diffTraffic=").append(bu.sL(this.cFy)).append("\n");
    localStringBuilder.append("| ->diffAlarmCount=").append(this.cFz).append("\n");
    localStringBuilder.append("| ->diffAddMsgCount=").append(this.cFA).append("\n");
    return localStringBuilder;
  }
  
  public final void a(b.a parama)
  {
    int k = 20;
    super.a(parama);
    if (parama.cCq) {
      return;
    }
    long l = parama.cDX;
    parama = new ArrayList(4);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1013);
    int m = -1;
    int i = -1;
    int j;
    if (ak.coh())
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
      if (!ak.coh()) {
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
      if (ak.coh()) {
        i = 0;
      }
      for (;;)
      {
        localIDKey.SetKey(i + 18);
        localIDKey.SetValue(1L);
        parama.add(localIDKey);
        e.ywz.b(parama, false);
        return;
        if (ak.foC())
        {
          i = 20;
          break;
        }
        if (ak.foA())
        {
          i = 40;
          break;
        }
        if (ak.foF())
        {
          i = 60;
          break;
        }
        if (ak.foE())
        {
          i = 80;
          break;
        }
        if (ak.isAppBrandProcess())
        {
          i = 100;
          break;
        }
        if (!ak.foD()) {
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
        if (ak.foC())
        {
          i = 20;
          break label133;
        }
        if (ak.foA())
        {
          i = 40;
          break label133;
        }
        if (ak.foF())
        {
          i = 60;
          break label133;
        }
        if (ak.foE())
        {
          i = 80;
          break label133;
        }
        if (ak.isAppBrandProcess())
        {
          i = 100;
          break label133;
        }
        if (!ak.foD()) {
          break label506;
        }
        i = 120;
        break label133;
        i = k;
        if (!ak.foC()) {
          if (ak.foA()) {
            i = 40;
          } else if (ak.foF()) {
            i = 60;
          } else if (ak.foE()) {
            i = 80;
          } else if (ak.isAppBrandProcess()) {
            i = 100;
          } else if (ak.foD()) {
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
    ae.w("Matrix.BatteryReporter", "[onWakeLockTimeout] tag=%s packageName=%s warningCount=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (paramInt <= 1) {
      e.ywz.idkeyStat(1013L, 201L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */