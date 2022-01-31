package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean nhY = false;
  private boolean nhZ = false;
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(111131);
    com.tencent.mm.game.report.api.a.ezM.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5, paramString6);
    AppMethodBeat.o(111131);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(111126);
    com.tencent.mm.game.report.api.a.ezM.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(111126);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(111125);
    com.tencent.mm.game.report.api.a.ezM.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(111125);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4)
  {
    AppMethodBeat.i(111127);
    f localf = com.tencent.mm.pluginsdk.model.app.g.ca(paramString1, true);
    if (localf != null) {
      com.tencent.mm.game.report.api.a.ezM.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localf.vY(), paramString4);
    }
    AppMethodBeat.o(111127);
  }
  
  public final void ag(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111128);
    com.tencent.mm.game.report.api.a.ezM.o(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(111128);
  }
  
  public final boolean bEM()
  {
    AppMethodBeat.i(111124);
    try
    {
      boolean bool = com.tencent.mm.plugin.game.commlib.a.bEZ();
      AppMethodBeat.o(111124);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111124);
    }
    return true;
  }
  
  public final String bEN()
  {
    AppMethodBeat.i(111133);
    String str = e.ej(ah.getContext());
    AppMethodBeat.o(111133);
    return str;
  }
  
  public final void dZ(Context paramContext)
  {
    AppMethodBeat.i(111132);
    e.dZ(paramContext);
    AppMethodBeat.o(111132);
  }
  
  public final void hY(boolean paramBoolean)
  {
    AppMethodBeat.i(111134);
    if (!this.nhZ)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.game.report.a.b.class)).b(a.a.lRy)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.game.report.a.b.class)).b(a.a.lRA))) {
        break label151;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.nhY = paramBoolean;
      this.nhZ = true;
      Object localObject;
      if (this.nhY)
      {
        localObject = c.bHD();
        if (!bo.isNullOrNil((String)localObject))
        {
          ab.i("MicroMsg.GameDelegateImpl", "preload");
          ld localld = new ld();
          localld.cBn.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localld.cBn.intent = localIntent;
          com.tencent.mm.sdk.b.a.ymk.l(localld);
        }
      }
      AppMethodBeat.o(111134);
      return;
      label151:
      ab.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      h.qsU.j(939L, 4L, 1L);
      if (YearClass.get(ah.getContext()) < 2014)
      {
        ab.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        h.qsU.j(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = e.bGe();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          ab.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((d)com.tencent.mm.kernel.g.E(d.class)).bER();
            localObject = q.bGn();
            if ((localObject == null) || (System.currentTimeMillis() - ((n)localObject).field_receiveTime * 1000L > 21600000L))
            {
              ab.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              h.qsU.j(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            h.qsU.j(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (com.tencent.mm.sdk.platformtools.g.dsn())
        {
          ab.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          h.qsU.j(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (bo.isNullOrNil(c.bHD()))
        {
          h.qsU.j(939L, 9L, 1L);
          paramBoolean = false;
        }
        else
        {
          paramBoolean = true;
        }
      }
    }
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(111130);
    com.tencent.mm.game.report.api.a.ezM.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(111130);
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(111129);
    com.tencent.mm.game.report.api.a.ezM.m(paramString1, paramString2, paramString3);
    AppMethodBeat.o(111129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b
 * JD-Core Version:    0.7.0.1
 */