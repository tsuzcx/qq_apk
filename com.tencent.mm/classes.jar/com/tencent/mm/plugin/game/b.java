package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean quE = false;
  private boolean rMU = false;
  
  public final void I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(40822);
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(paramLong);
    if (localo != null)
    {
      localo.cDf();
      String str = com.tencent.mm.game.report.e.a("resource", String.valueOf(paramInt), localo.rWS, null);
      if (localo.cey())
      {
        com.tencent.mm.game.report.e.a(aj.getContext(), 9, 901, 1, 1, 0, localo.field_appId, 0, localo.rWQ, localo.field_gameMsgId, localo.rWR, str);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(858L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(40822);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(40818);
    com.tencent.mm.game.report.api.a.fUK.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6);
    AppMethodBeat.o(40818);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(40813);
    com.tencent.mm.game.report.api.a.fUK.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(40813);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(40812);
    com.tencent.mm.game.report.api.a.fUK.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(40812);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40814);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.j(paramString1, true, false);
    if (localg != null) {
      com.tencent.mm.game.report.api.a.fUK.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localg.CZ(), paramString4, paramInt3);
    }
    AppMethodBeat.o(40814);
  }
  
  public final void ag(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40815);
    com.tencent.mm.game.report.api.a.fUK.k(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(40815);
  }
  
  public final boolean cAY()
  {
    AppMethodBeat.i(40811);
    try
    {
      boolean bool;
      if (com.tencent.mm.plugin.game.commlib.a.rOm != null)
      {
        bool = com.tencent.mm.plugin.game.commlib.a.rOm.sbD;
        ad.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
        AppMethodBeat.o(40811);
        return bool;
      }
      com.tencent.mm.plugin.game.commlib.a.cBk();
      Object localObject = aj.getContext().getSharedPreferences(aj.eFD(), 0);
      aj.getContext();
      localObject = ac.f((SharedPreferences)localObject);
      ad.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { localObject });
      if ("zh_CN".equals(localObject)) {}
      for (localObject = "0";; localObject = "1")
      {
        localObject = bt.by(com.tencent.mm.m.g.Zd().getValue("HideGameCenter"), (String)localObject);
        ad.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[] { localObject });
        bool = ((String)localObject).equalsIgnoreCase("0");
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(40811);
    }
  }
  
  public final String cAZ()
  {
    AppMethodBeat.i(40820);
    String str = com.tencent.mm.plugin.game.model.e.fe(aj.getContext());
    AppMethodBeat.o(40820);
    return str;
  }
  
  public final void eU(Context paramContext)
  {
    AppMethodBeat.i(40819);
    com.tencent.mm.plugin.game.model.e.eU(paramContext);
    AppMethodBeat.o(40819);
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40817);
    com.tencent.mm.game.report.api.a.fUK.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(40817);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40816);
    com.tencent.mm.game.report.api.a.fUK.k(paramString1, paramString2, paramString3);
    AppMethodBeat.o(40816);
  }
  
  public final void lK(boolean paramBoolean)
  {
    AppMethodBeat.i(40821);
    if (!this.rMU)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.piL, true)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.piN, false))) {
        break label160;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.quE = paramBoolean;
      this.rMU = true;
      Object localObject;
      if (this.quE)
      {
        localObject = c.cEA();
        if (!bt.isNullOrNil((String)localObject))
        {
          ad.i("MicroMsg.GameDelegateImpl", "preload");
          mi localmi = new mi();
          localmi.drw.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localmi.drw.intent = localIntent;
          com.tencent.mm.sdk.b.a.ESL.l(localmi);
        }
      }
      AppMethodBeat.o(40821);
      return;
      label160:
      ad.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      com.tencent.mm.plugin.report.service.h.vKh.m(939L, 4L, 1L);
      if (YearClass.get(aj.getContext()) < 2014)
      {
        ad.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        com.tencent.mm.plugin.report.service.h.vKh.m(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = com.tencent.mm.plugin.game.model.e.cCX();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          ad.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((d)com.tencent.mm.kernel.g.ab(d.class)).cBc();
            localObject = r.cDh();
            if ((localObject == null) || (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L))
            {
              ad.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              com.tencent.mm.plugin.report.service.h.vKh.m(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.vKh.m(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (i.eFb())
        {
          ad.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          com.tencent.mm.plugin.report.service.h.vKh.m(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (bt.isNullOrNil(c.cEA()))
        {
          com.tencent.mm.plugin.report.service.h.vKh.m(939L, 9L, 1L);
          paramBoolean = false;
        }
        else
        {
          paramBoolean = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b
 * JD-Core Version:    0.7.0.1
 */