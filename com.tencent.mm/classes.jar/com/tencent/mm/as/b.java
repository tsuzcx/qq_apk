package com.tencent.mm.as;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Stack;

public final class b
  implements d.a
{
  private b.a emK;
  public Stack<Long> emL;
  long emM = 0L;
  public int emN = 0;
  boolean emO = false;
  public long emP = 0L;
  int emQ = 0;
  boolean emR = false;
  long emS = 0L;
  long emT = 0L;
  int emU;
  int emV;
  am emW = new am(new b.1(this), false);
  com.tencent.mm.sdk.b.c emX = new b.2(this);
  com.tencent.mm.sdk.b.c emY = new b.3(this);
  
  public b(Looper paramLooper)
  {
    this.emK = new b.a(this, paramLooper);
    this.emL = new Stack();
    this.emU = Process.myUid();
    paramLooper = (Integer)g.DP().Dz().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.emV = i;
      a.udP.c(this.emX);
      a.udP.c(this.emY);
      return;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (aq.isWifi(ae.getContext()))
      {
        y.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        return;
      }
      long l1 = bk.a((Long)g.DP().Dz().get(ac.a.uoM, null), 0L);
      long l2 = bk.ZS((String)DateFormat.format("M", System.currentTimeMillis()));
      y.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      g.DP().Dz().c(ac.a.uoM, Long.valueOf(l1 + 1L));
      g.DP().Dz().c(ac.a.uoN, Long.valueOf(l2));
      return;
    }
    y.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    y.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      y.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
    }
    for (;;)
    {
      this.emM = 0L;
      com.tencent.mm.modelcontrol.c.Ni();
      if (!com.tencent.mm.modelcontrol.c.Nj())
      {
        y.d("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.emL)
        {
          this.emL.clear();
          return;
          a(paramLong1, paramLong2, true);
        }
      }
    }
    this.emS = TrafficStats.getUidRxBytes(this.emU);
    this.emT = TrafficStats.getUidTxBytes(this.emU);
    this.emW.S(1000L, 1000L);
  }
  
  public final void bN(boolean paramBoolean)
  {
    y.d("MicroMsg.AutoGetBigImgLogic", "is foreground: " + paramBoolean);
    this.emO = paramBoolean;
    this.emP = System.currentTimeMillis();
  }
  
  public final void start()
  {
    this.emK.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.b
 * JD-Core Version:    0.7.0.1
 */