package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.za.a;
import com.tencent.mm.g.a.za.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ax
  implements f
{
  boolean vqQ;
  public as vqR;
  public ap vqS;
  private ah vqT;
  public c vqU;
  
  public ax()
  {
    AppMethodBeat.i(65315);
    this.vqU = new c()
    {
      private boolean a(za paramAnonymousza)
      {
        AppMethodBeat.i(65313);
        if ((paramAnonymousza instanceof za)) {
          switch (paramAnonymousza.dNX.action)
          {
          }
        }
        label268:
        for (;;)
        {
          AppMethodBeat.o(65313);
          return false;
          ax localax = ax.this;
          long l = paramAnonymousza.dNX.dmV;
          if (!localax.vqQ)
          {
            localax.vqQ = true;
            bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(l);
            paramAnonymousza = localbu.field_content;
            if (paramAnonymousza != null) {}
            for (paramAnonymousza = k.b.aA(paramAnonymousza, localbu.field_reserved);; paramAnonymousza = null)
            {
              if (paramAnonymousza == null) {
                break label268;
              }
              paramAnonymousza = bt.nullAsNil(paramAnonymousza.hBx);
              Uri localUri = Uri.parse(paramAnonymousza);
              String str = localUri.getQueryParameter("sendid");
              int i = bt.getInt(localUri.getQueryParameter("channelid"), 1);
              if (localax.vqR != null)
              {
                g.ajD();
                g.ajB().gAO.a(localax.vqR);
                localax.vqR = null;
              }
              g.ajD();
              g.ajB().gAO.a(1581, localax);
              localax.vqR = new as(i, str, paramAnonymousza, 3, "v1.0");
              localax.vqR.talker = localbu.field_talker;
              localax.vqR.msgId = l;
              g.ajD();
              g.ajB().gAO.a(localax.vqR, 0);
              break;
            }
          }
        }
      }
    };
    a.IbL.c(this.vqU);
    AppMethodBeat.o(65315);
  }
  
  private static void a(l paraml, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    za localza = new za();
    localza.dNX.action = 2;
    localza.dNY.dmV = paramLong;
    localza.dNY.dOa = paraml.dOa;
    localza.dNY.dOb = paraml.vop;
    localza.dNY.dOc = new ArrayList();
    if (w.vF(paramString))
    {
      paraml = paraml.vox.iterator();
      while (paraml.hasNext())
      {
        paramString = (y)paraml.next();
        paramString = p.aEz().CX(paramString.vpB) + "=" + paramString.vpA + "=" + paramString.vpn;
        localza.dNY.dOc.add(paramString);
      }
    }
    a.IbL.a(localza, Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  private static void xW(long paramLong)
  {
    AppMethodBeat.i(65317);
    za localza = new za();
    localza.dNX.action = 2;
    localza.dNY.dmV = paramLong;
    localza.dNY.dOa = 0L;
    localza.dNY.dOb = "";
    a.IbL.a(localza, Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65316);
    g.ajD();
    g.ajB().gAO.b(1581, this);
    g.ajD();
    g.ajB().gAO.b(1685, this);
    g.ajD();
    g.ajB().gAO.b(1585, this);
    if ((paramn instanceof as))
    {
      paramString = (as)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.vqQ = false;
        xW(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.dNN == 4)
      {
        if (this.vqT != null)
        {
          g.ajD();
          g.ajB().gAO.a(this.vqT);
          this.vqT = null;
        }
        g.ajD();
        g.ajB().gAO.a(1585, this);
        this.vqT = new ah(paramString.vkl, 11, 0, paramString.dNL, "v1.0");
        this.vqT.talker = paramString.talker;
        this.vqT.msgId = paramString.msgId;
        g.ajD();
        g.ajB().gAO.a(this.vqT, 0);
        ad.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.dNO != 1) && (paramString.dNN != 5) && (paramString.dNN != 1))
      {
        if (this.vqS != null)
        {
          g.ajD();
          g.ajB().gAO.a(this.vqS);
          this.vqS = null;
        }
        g.ajD();
        g.ajB().gAO.a(1685, this);
        this.vqS = new ap(paramString.msgType, paramString.cSc, paramString.vkl, paramString.dNL, z.diq(), u.aAo(), paramString.talker, "v1.0", paramString.vqK);
        this.vqS.msgId = paramString.msgId;
        g.ajD();
        g.ajB().gAO.a(this.vqS, 0);
        ad.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.vqQ = false;
      ad.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      xW(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ap))
    {
      this.vqQ = false;
      paramString = (ap)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        xW(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramn = paramString.vpO;
      if (paramn.dNO == 2)
      {
        a(paramn, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      xW(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ah))
    {
      this.vqQ = false;
      paramString = (ah)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        xW(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.vpO, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ax
 * JD-Core Version:    0.7.0.1
 */