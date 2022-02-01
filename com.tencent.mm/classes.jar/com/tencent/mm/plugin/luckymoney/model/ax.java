package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xv.a;
import com.tencent.mm.g.a.xv.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ax
  implements com.tencent.mm.al.g
{
  boolean tfX;
  public as tfY;
  public ap tfZ;
  private ah tga;
  public c tgb;
  
  public ax()
  {
    AppMethodBeat.i(65315);
    this.tgb = new c()
    {
      private boolean a(xv paramAnonymousxv)
      {
        AppMethodBeat.i(65313);
        if ((paramAnonymousxv instanceof xv)) {
          switch (paramAnonymousxv.dDY.action)
          {
          }
        }
        label268:
        for (;;)
        {
          AppMethodBeat.o(65313);
          return false;
          ax localax = ax.this;
          long l = paramAnonymousxv.dDY.ded;
          if (!localax.tfX)
          {
            localax.tfX = true;
            bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(l);
            paramAnonymousxv = localbl.field_content;
            if (paramAnonymousxv != null) {}
            for (paramAnonymousxv = k.b.ar(paramAnonymousxv, localbl.field_reserved);; paramAnonymousxv = null)
            {
              if (paramAnonymousxv == null) {
                break label268;
              }
              paramAnonymousxv = bt.nullAsNil(paramAnonymousxv.gIO);
              Uri localUri = Uri.parse(paramAnonymousxv);
              String str = localUri.getQueryParameter("sendid");
              int i = bt.getInt(localUri.getQueryParameter("channelid"), 1);
              if (localax.tfY != null)
              {
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afA().gcy.a(localax.tfY);
                localax.tfY = null;
              }
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a(1581, localax);
              localax.tfY = new as(i, str, paramAnonymousxv, 3, "v1.0");
              localax.tfY.talker = localbl.field_talker;
              localax.tfY.msgId = l;
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a(localax.tfY, 0);
              break;
            }
          }
        }
      }
    };
    a.ESL.c(this.tgb);
    AppMethodBeat.o(65315);
  }
  
  private static void a(l paraml, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    xv localxv = new xv();
    localxv.dDY.action = 2;
    localxv.dDZ.ded = paramLong;
    localxv.dDZ.dEb = paraml.dEb;
    localxv.dDZ.dEc = paraml.tdu;
    localxv.dDZ.dEd = new ArrayList();
    if (w.pF(paramString))
    {
      paraml = paraml.tdC.iterator();
      while (paraml.hasNext())
      {
        paramString = (y)paraml.next();
        paramString = p.auH().vS(paramString.teG) + "=" + paramString.teF + "=" + paramString.tes;
        localxv.dDZ.dEd.add(paramString);
      }
    }
    a.ESL.a(localxv, Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  private static void rj(long paramLong)
  {
    AppMethodBeat.i(65317);
    xv localxv = new xv();
    localxv.dDY.action = 2;
    localxv.dDZ.ded = paramLong;
    localxv.dDZ.dEb = 0L;
    localxv.dDZ.dEc = "";
    a.ESL.a(localxv, Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65316);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1581, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1685, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1585, this);
    if ((paramn instanceof as))
    {
      paramString = (as)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.tfX = false;
        rj(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.dDO == 4)
      {
        if (this.tga != null)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(this.tga);
          this.tga = null;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(1585, this);
        this.tga = new ah(paramString.sZn, 11, 0, paramString.dDM, "v1.0");
        this.tga.talker = paramString.talker;
        this.tga.msgId = paramString.msgId;
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(this.tga, 0);
        ad.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.dDP != 1) && (paramString.dDO != 5) && (paramString.dDO != 1))
      {
        if (this.tfZ != null)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(this.tfZ);
          this.tfZ = null;
        }
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(1685, this);
        this.tfZ = new ap(paramString.msgType, paramString.cJR, paramString.sZn, paramString.dDM, z.cLy(), u.aqI(), paramString.talker, "v1.0", paramString.tfR);
        this.tfZ.msgId = paramString.msgId;
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(this.tfZ, 0);
        ad.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.tfX = false;
      ad.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      rj(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ap))
    {
      this.tfX = false;
      paramString = (ap)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        rj(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramn = paramString.teT;
      if (paramn.dDP == 2)
      {
        a(paramn, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      rj(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ah))
    {
      this.tfX = false;
      paramString = (ah)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        rj(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.teT, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ax
 * JD-Core Version:    0.7.0.1
 */