package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.a.yg.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ax
  implements com.tencent.mm.ak.g
{
  boolean uom;
  public as uon;
  public ap uoo;
  private ah uop;
  public c uoq;
  
  public ax()
  {
    AppMethodBeat.i(65315);
    this.uoq = new c()
    {
      private boolean a(yg paramAnonymousyg)
      {
        AppMethodBeat.i(65313);
        if ((paramAnonymousyg instanceof yg)) {
          switch (paramAnonymousyg.dBK.action)
          {
          }
        }
        label268:
        for (;;)
        {
          AppMethodBeat.o(65313);
          return false;
          ax localax = ax.this;
          long l = paramAnonymousyg.dBK.dbz;
          if (!localax.uom)
          {
            localax.uom = true;
            bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(l);
            paramAnonymousyg = localbo.field_content;
            if (paramAnonymousyg != null) {}
            for (paramAnonymousyg = k.b.az(paramAnonymousyg, localbo.field_reserved);; paramAnonymousyg = null)
            {
              if (paramAnonymousyg == null) {
                break label268;
              }
              paramAnonymousyg = bs.nullAsNil(paramAnonymousyg.hjo);
              Uri localUri = Uri.parse(paramAnonymousyg);
              String str = localUri.getQueryParameter("sendid");
              int i = bs.getInt(localUri.getQueryParameter("channelid"), 1);
              if (localax.uon != null)
              {
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agQ().ghe.a(localax.uon);
                localax.uon = null;
              }
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(1581, localax);
              localax.uon = new as(i, str, paramAnonymousyg, 3, "v1.0");
              localax.uon.talker = localbo.field_talker;
              localax.uon.msgId = l;
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(localax.uon, 0);
              break;
            }
          }
        }
      }
    };
    a.GpY.c(this.uoq);
    AppMethodBeat.o(65315);
  }
  
  private static void a(l paraml, long paramLong, String paramString)
  {
    AppMethodBeat.i(65318);
    yg localyg = new yg();
    localyg.dBK.action = 2;
    localyg.dBL.dbz = paramLong;
    localyg.dBL.dBN = paraml.dBN;
    localyg.dBL.dBO = paraml.ulJ;
    localyg.dBL.dBP = new ArrayList();
    if (w.sQ(paramString))
    {
      paraml = paraml.ulR.iterator();
      while (paraml.hasNext())
      {
        paramString = (y)paraml.next();
        paramString = p.aBy().zY(paramString.umV) + "=" + paramString.umU + "=" + paramString.umH;
        localyg.dBL.dBP.add(paramString);
      }
    }
    a.GpY.a(localyg, Looper.getMainLooper());
    AppMethodBeat.o(65318);
  }
  
  private static void vM(long paramLong)
  {
    AppMethodBeat.i(65317);
    yg localyg = new yg();
    localyg.dBK.action = 2;
    localyg.dBL.dbz = paramLong;
    localyg.dBL.dBN = 0L;
    localyg.dBL.dBO = "";
    a.GpY.a(localyg, Looper.getMainLooper());
    AppMethodBeat.o(65317);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65316);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1581, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1685, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1585, this);
    if ((paramn instanceof as))
    {
      paramString = (as)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.uom = false;
        vM(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      if (paramString.dBA == 4)
      {
        if (this.uop != null)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(this.uop);
          this.uop = null;
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(1585, this);
        this.uop = new ah(paramString.uhB, 11, 0, paramString.dBy, "v1.0");
        this.uop.talker = paramString.talker;
        this.uop.msgId = paramString.msgId;
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(this.uop, 0);
        ac.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
        AppMethodBeat.o(65316);
        return;
      }
      if ((paramString.dBB != 1) && (paramString.dBA != 5) && (paramString.dBA != 1))
      {
        if (this.uoo != null)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(this.uoo);
          this.uoo = null;
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(1685, this);
        this.uoo = new ap(paramString.msgType, paramString.cGY, paramString.uhB, paramString.dBy, z.cZe(), u.axy(), paramString.talker, "v1.0", paramString.uog);
        this.uoo.msgId = paramString.msgId;
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(this.uoo, 0);
        ac.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
        AppMethodBeat.o(65316);
        return;
      }
      this.uom = false;
      ac.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
      vM(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ap))
    {
      this.uom = false;
      paramString = (ap)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        vM(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      paramn = paramString.uni;
      if (paramn.dBB == 2)
      {
        a(paramn, paramString.msgId, paramString.talker);
        AppMethodBeat.o(65316);
        return;
      }
      vM(paramString.msgId);
      AppMethodBeat.o(65316);
      return;
    }
    if ((paramn instanceof ah))
    {
      this.uom = false;
      paramString = (ah)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        vM(paramString.msgId);
        AppMethodBeat.o(65316);
        return;
      }
      a(paramString.uni, paramString.msgId, paramString.talker);
    }
    AppMethodBeat.o(65316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ax
 * JD-Core Version:    0.7.0.1
 */