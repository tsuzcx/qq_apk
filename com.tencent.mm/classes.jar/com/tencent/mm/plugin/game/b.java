package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean rgG = false;
  private boolean sUJ = false;
  
  public final void L(long paramLong, int paramInt)
  {
    AppMethodBeat.i(40822);
    o localo = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(paramLong);
    if (localo != null)
    {
      localo.cQp();
      String str = com.tencent.mm.game.report.e.a("resource", String.valueOf(paramInt), localo.teK, null);
      if (localo.cmf())
      {
        com.tencent.mm.game.report.e.a(ai.getContext(), 9, 901, 1, 1, 0, localo.field_appId, 0, localo.teI, localo.field_gameMsgId, localo.teJ, str);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(858L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(40822);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(40818);
    com.tencent.mm.game.report.api.a.fYF.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6);
    AppMethodBeat.o(40818);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(40813);
    com.tencent.mm.game.report.api.a.fYF.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(40813);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(40812);
    com.tencent.mm.game.report.api.a.fYF.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(40812);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40814);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.k(paramString1, true, false);
    if (localg != null) {
      com.tencent.mm.game.report.api.a.fYF.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localg.CC(), paramString4, paramInt3);
    }
    AppMethodBeat.o(40814);
  }
  
  public final void af(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40815);
    com.tencent.mm.game.report.api.a.fYF.k(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(40815);
  }
  
  public final boolean cOh()
  {
    AppMethodBeat.i(40811);
    try
    {
      boolean bool;
      if (com.tencent.mm.plugin.game.commlib.a.sWd != null)
      {
        bool = com.tencent.mm.plugin.game.commlib.a.sWd.tjx;
        ac.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
        AppMethodBeat.o(40811);
        return bool;
      }
      com.tencent.mm.plugin.game.commlib.a.cOt();
      Object localObject = ai.getContext().getSharedPreferences(ai.eUX(), 0);
      ai.getContext();
      localObject = ab.f((SharedPreferences)localObject);
      ac.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { localObject });
      if ("zh_CN".equals(localObject)) {}
      for (localObject = "0";; localObject = "1")
      {
        localObject = bs.bG(com.tencent.mm.m.g.ZY().getValue("HideGameCenter"), (String)localObject);
        ac.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[] { localObject });
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
  
  public final String cOi()
  {
    AppMethodBeat.i(40820);
    String str = com.tencent.mm.plugin.game.model.e.fr(ai.getContext());
    AppMethodBeat.o(40820);
    return str;
  }
  
  public final void fh(Context paramContext)
  {
    AppMethodBeat.i(40819);
    com.tencent.mm.plugin.game.model.e.fh(paramContext);
    AppMethodBeat.o(40819);
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40817);
    com.tencent.mm.game.report.api.a.fYF.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(40817);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40816);
    com.tencent.mm.game.report.api.a.fYF.k(paramString1, paramString2, paramString3);
    AppMethodBeat.o(40816);
  }
  
  public final void mD(boolean paramBoolean)
  {
    AppMethodBeat.i(40821);
    if (!this.sUJ)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pLY, true)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pMa, false))) {
        break label160;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.rgG = paramBoolean;
      this.sUJ = true;
      Object localObject;
      if (this.rgG)
      {
        localObject = c.cRK();
        if (!bs.isNullOrNil((String)localObject))
        {
          ac.i("MicroMsg.GameDelegateImpl", "preload");
          mr localmr = new mr();
          localmr.dph.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localmr.dph.intent = localIntent;
          com.tencent.mm.sdk.b.a.GpY.l(localmr);
        }
      }
      AppMethodBeat.o(40821);
      return;
      label160:
      ac.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      com.tencent.mm.plugin.report.service.h.wUl.n(939L, 4L, 1L);
      if (YearClass.get(ai.getContext()) < 2014)
      {
        ac.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        com.tencent.mm.plugin.report.service.h.wUl.n(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = com.tencent.mm.plugin.game.model.e.cQh();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          ac.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((d)com.tencent.mm.kernel.g.ab(d.class)).cOl();
            localObject = r.cQr();
            if ((localObject == null) || (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L))
            {
              ac.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              com.tencent.mm.plugin.report.service.h.wUl.n(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.wUl.n(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (i.eUv())
        {
          ac.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          com.tencent.mm.plugin.report.service.h.wUl.n(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (bs.isNullOrNil(c.cRK()))
        {
          com.tencent.mm.plugin.report.service.h.wUl.n(939L, 9L, 1L);
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