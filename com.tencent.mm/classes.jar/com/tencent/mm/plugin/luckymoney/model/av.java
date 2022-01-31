package com.tencent.mm.plugin.luckymoney.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.vv.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class av
  implements f
{
  boolean opS;
  public aq opT;
  public an opU;
  private af opV;
  public com.tencent.mm.sdk.b.c opW;
  
  public av()
  {
    AppMethodBeat.i(42428);
    this.opW = new av.1(this);
    a.ymk.c(this.opW);
    AppMethodBeat.o(42428);
  }
  
  private static void a(k paramk, long paramLong, String paramString)
  {
    AppMethodBeat.i(42431);
    vv localvv = new vv();
    localvv.cNa.action = 2;
    localvv.cNb.cpg = paramLong;
    localvv.cNb.cNd = paramk.cNd;
    localvv.cNb.cNe = paramk.onD;
    localvv.cNb.cNf = new ArrayList();
    if (t.lA(paramString))
    {
      paramk = paramk.onL.iterator();
      while (paramk.hasNext())
      {
        paramString = (w)paramk.next();
        paramString = o.adi().qX(paramString.ooC) + "=" + paramString.ooB + "=" + paramString.ooo;
        localvv.cNb.cNf.add(paramString);
      }
    }
    a.ymk.a(localvv, Looper.getMainLooper());
    AppMethodBeat.o(42431);
  }
  
  private static void kz(long paramLong)
  {
    AppMethodBeat.i(42430);
    vv localvv = new vv();
    localvv.cNa.action = 2;
    localvv.cNb.cpg = paramLong;
    localvv.cNb.cNd = 0L;
    localvv.cNb.cNe = "";
    a.ymk.a(localvv, Looper.getMainLooper());
    AppMethodBeat.o(42430);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42429);
    g.RM();
    g.RK().eHt.b(1581, this);
    g.RM();
    g.RK().eHt.b(1685, this);
    g.RM();
    g.RK().eHt.b(1585, this);
    if ((paramm instanceof aq))
    {
      paramString = (aq)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.opS = false;
        kz(paramString.cpO);
        AppMethodBeat.o(42429);
        return;
      }
      if (paramString.cMQ == 4)
      {
        if (this.opV != null)
        {
          g.RM();
          g.RK().eHt.a(this.opV);
          this.opV = null;
        }
        g.RM();
        g.RK().eHt.a(1585, this);
        this.opV = new af(paramString.ojA, 11, 0, paramString.cMO, "v1.0");
        this.opV.talker = paramString.talker;
        this.opV.cpO = paramString.cpO;
        g.RM();
        g.RK().eHt.a(this.opV, 0);
        ab.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(42429);
        return;
      }
      if ((paramString.cMR != 1) && (paramString.cMQ != 5) && (paramString.cMQ != 1))
      {
        if (this.opU != null)
        {
          g.RM();
          g.RK().eHt.a(this.opU);
          this.opU = null;
        }
        g.RM();
        g.RK().eHt.a(1685, this);
        this.opU = new an(paramString.msgType, paramString.bWu, paramString.ojA, paramString.cMO, x.bNq(), r.Zp(), paramString.talker, "v1.0", paramString.opM);
        this.opU.cpO = paramString.cpO;
        g.RM();
        g.RK().eHt.a(this.opU, 0);
        ab.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(42429);
        return;
      }
      this.opS = false;
      ab.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      kz(paramString.cpO);
      AppMethodBeat.o(42429);
      return;
    }
    if ((paramm instanceof an))
    {
      this.opS = false;
      paramString = (an)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        kz(paramString.cpO);
        AppMethodBeat.o(42429);
        return;
      }
      paramm = paramString.ooO;
      if (paramm.cMR == 2)
      {
        a(paramm, paramString.cpO, paramString.talker);
        AppMethodBeat.o(42429);
        return;
      }
      kz(paramString.cpO);
      AppMethodBeat.o(42429);
      return;
    }
    if ((paramm instanceof af))
    {
      this.opS = false;
      paramString = (af)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        kz(paramString.cpO);
        AppMethodBeat.o(42429);
        return;
      }
      a(paramString.ooO, paramString.cpO, paramString.talker);
    }
    AppMethodBeat.o(42429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.av
 * JD-Core Version:    0.7.0.1
 */