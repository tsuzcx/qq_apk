package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zg;
import com.tencent.mm.g.a.zg.a;
import com.tencent.mm.g.a.zg.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ax
  implements f
{
  boolean vCV;
  public as vCW;
  public ap vCX;
  private ah vCY;
  public c vCZ;
  
  public ax()
  {
    AppMethodBeat.i(65315);
    this.vCZ = new c()
    {
      private boolean a(zg paramAnonymouszg)
      {
        AppMethodBeat.i(65313);
        if ((paramAnonymouszg instanceof zg)) {
          switch (paramAnonymouszg.dPn.action)
          {
          }
        }
        label268:
        for (;;)
        {
          AppMethodBeat.o(65313);
          return false;
          ax localax = ax.this;
          long l = paramAnonymouszg.dPn.dnX;
          if (!localax.vCV)
          {
            localax.vCV = true;
            bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(l);
            paramAnonymouszg = localbv.field_content;
            if (paramAnonymouszg != null) {}
            for (paramAnonymouszg = k.b.aB(paramAnonymouszg, localbv.field_reserved);; paramAnonymouszg = null)
            {
              if (paramAnonymouszg == null) {
                break label268;
              }
              paramAnonymouszg = bu.nullAsNil(paramAnonymouszg.hEl);
              Uri localUri = Uri.parse(paramAnonymouszg);
              String str = localUri.getQueryParameter("sendid");
              int i = bu.getInt(localUri.getQueryParameter("channelid"), 1);
              if (localax.vCW != null)
              {
                g.ajS();
                g.ajQ().gDv.a(localax.vCW);
                localax.vCW = null;
              }
              g.ajS();
              g.ajQ().gDv.a(1581, localax);
              localax.vCW = new as(i, str, paramAnonymouszg, 3, "v1.0");
              localax.vCW.talker = localbv.field_talker;
              localax.vCW.msgId = l;
              g.ajS();
              g.ajQ().gDv.a(localax.vCW, 0);
              break;
            }
          }
        }
      }
    };
    a.IvT.c(this.vCZ);
    AppMethodBeat.o(65315);
  }
  
  private static void a(l paraml, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    zg localzg = new zg();
    localzg.dPn.action = 2;
    localzg.dPo.dnX = paramLong;
    localzg.dPo.dPq = paraml.dPq;
    localzg.dPo.dPr = paraml.vAu;
    localzg.dPo.dPs = new ArrayList();
    if (x.wb(paramString))
    {
      paraml = paraml.vAC.iterator();
      while (paraml.hasNext())
      {
        paramString = (y)paraml.next();
        paramString = p.aEP().Dz(paramString.vBG) + "=" + paramString.vBF + "=" + paramString.vBs;
        localzg.dPo.dPs.add(paramString);
      }
    }
    a.IvT.a(localzg, Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  private static void yq(long paramLong)
  {
    AppMethodBeat.i(65317);
    zg localzg = new zg();
    localzg.dPn.action = 2;
    localzg.dPo.dnX = paramLong;
    localzg.dPo.dPq = 0L;
    localzg.dPo.dPr = "";
    a.IvT.a(localzg, Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65316);
    g.ajS();
    g.ajQ().gDv.b(1581, this);
    g.ajS();
    g.ajQ().gDv.b(1685, this);
    g.ajS();
    g.ajQ().gDv.b(1585, this);
    if ((paramn instanceof as))
    {
      paramString = (as)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.vCV = false;
        yq(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.dPd == 4)
      {
        if (this.vCY != null)
        {
          g.ajS();
          g.ajQ().gDv.a(this.vCY);
          this.vCY = null;
        }
        g.ajS();
        g.ajQ().gDv.a(1585, this);
        this.vCY = new ah(paramString.vwq, 11, 0, paramString.dPb, "v1.0");
        this.vCY.talker = paramString.talker;
        this.vCY.msgId = paramString.msgId;
        g.ajS();
        g.ajQ().gDv.a(this.vCY, 0);
        ae.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.dPe != 1) && (paramString.dPd != 5) && (paramString.dPd != 1))
      {
        if (this.vCX != null)
        {
          g.ajS();
          g.ajQ().gDv.a(this.vCX);
          this.vCX = null;
        }
        g.ajS();
        g.ajQ().gDv.a(1685, this);
        this.vCX = new ap(paramString.msgType, paramString.cSM, paramString.vwq, paramString.dPb, z.dlp(), v.aAE(), paramString.talker, "v1.0", paramString.vCP);
        this.vCX.msgId = paramString.msgId;
        g.ajS();
        g.ajQ().gDv.a(this.vCX, 0);
        ae.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.vCV = false;
      ae.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      yq(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ap))
    {
      this.vCV = false;
      paramString = (ap)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        yq(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramn = paramString.vBT;
      if (paramn.dPe == 2)
      {
        a(paramn, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      yq(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ah))
    {
      this.vCV = false;
      paramString = (ah)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        yq(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.vBT, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ax
 * JD-Core Version:    0.7.0.1
 */