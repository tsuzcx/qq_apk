package com.tencent.mm.plugin.luckymoney.b;

import android.os.Looper;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tz;
import com.tencent.mm.h.a.tz.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  implements com.tencent.mm.ah.f
{
  boolean lRP;
  public ag lRQ;
  public ad lRR;
  private w lRS;
  public com.tencent.mm.sdk.b.c lRT = new aj.1(this);
  
  public aj()
  {
    a.udP.c(this.lRT);
  }
  
  private static void a(f paramf, long paramLong, String paramString)
  {
    tz localtz = new tz();
    localtz.cen.action = 2;
    localtz.ceo.bHR = paramLong;
    localtz.ceo.ceq = paramf.ceq;
    localtz.ceo.cer = paramf.lQf;
    localtz.ceo.ces = new ArrayList();
    if (s.fn(paramString))
    {
      paramf = paramf.lQn.iterator();
      while (paramf.hasNext())
      {
        paramString = (n)paramf.next();
        paramString = com.tencent.mm.ag.o.Kj().ke(paramString.lQM) + "=" + paramString.lQL + "=" + paramString.lQy;
        localtz.ceo.ces.add(paramString);
      }
    }
    a.udP.a(localtz, Looper.getMainLooper());
  }
  
  private static void fb(long paramLong)
  {
    tz localtz = new tz();
    localtz.cen.action = 2;
    localtz.ceo.bHR = paramLong;
    localtz.ceo.ceq = 0L;
    localtz.ceo.cer = "";
    a.udP.a(localtz, Looper.getMainLooper());
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    g.DO().dJT.b(1581, this);
    g.DQ();
    g.DO().dJT.b(1685, this);
    g.DQ();
    g.DO().dJT.b(1585, this);
    if ((paramm instanceof ag))
    {
      paramString = (ag)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.lRP = false;
        fb(paramString.bIt);
      }
    }
    do
    {
      return;
      if (paramString.cec == 4)
      {
        if (this.lRS != null)
        {
          g.DQ();
          g.DO().dJT.c(this.lRS);
          this.lRS = null;
        }
        g.DQ();
        g.DO().dJT.a(1585, this);
        this.lRS = new w(paramString.lMg, 11, 0, paramString.ceb, "v1.0");
        this.lRS.talker = paramString.talker;
        this.lRS.bIt = paramString.bIt;
        g.DQ();
        g.DO().dJT.a(this.lRS, 0);
        y.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        return;
      }
      if ((paramString.ced != 1) && (paramString.cec != 5) && (paramString.cec != 1))
      {
        if (this.lRR != null)
        {
          g.DQ();
          g.DO().dJT.c(this.lRR);
          this.lRR = null;
        }
        g.DQ();
        g.DO().dJT.a(1685, this);
        this.lRR = new ad(paramString.msgType, paramString.bvj, paramString.lMg, paramString.ceb, o.bfL(), q.Gl(), paramString.talker, "v1.0", paramString.lRM);
        this.lRR.bIt = paramString.bIt;
        g.DQ();
        g.DO().dJT.a(this.lRR, 0);
        y.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        return;
      }
      this.lRP = false;
      y.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      fb(paramString.bIt);
      return;
      if ((paramm instanceof ad))
      {
        this.lRP = false;
        paramString = (ad)paramm;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          fb(paramString.bIt);
          return;
        }
        paramm = paramString.lQZ;
        if (paramm.ced == 2)
        {
          a(paramm, paramString.bIt, paramString.talker);
          return;
        }
        fb(paramString.bIt);
        return;
      }
    } while (!(paramm instanceof w));
    this.lRP = false;
    paramString = (w)paramm;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      fb(paramString.bIt);
      return;
    }
    a(paramString.lQZ, paramString.bIt, paramString.talker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.aj
 * JD-Core Version:    0.7.0.1
 */