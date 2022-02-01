package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean rUN = false;
  private boolean tRi = false;
  
  public final void Hx(int paramInt)
  {
    AppMethodBeat.i(206778);
    Object localObject = new HashMap();
    ((Map)localObject).put("interactive", "20002");
    ((Map)localObject).put("chatmsg_num", String.valueOf(paramInt));
    localObject = com.tencent.mm.game.report.f.a("resource", "4", null, (Map)localObject);
    com.tencent.mm.game.report.f.a(aj.getContext(), 9, 901, 1, 1, 0, null, 0, 200, null, null, (String)localObject);
    AppMethodBeat.o(206778);
  }
  
  public final void P(long paramLong, int paramInt)
  {
    AppMethodBeat.i(40822);
    o localo = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().xF(paramLong);
    if (localo != null)
    {
      localo.cYU();
      String str = com.tencent.mm.game.report.f.a("resource", String.valueOf(paramInt), localo.ucB, null);
      if (localo.crL())
      {
        com.tencent.mm.game.report.f.a(aj.getContext(), 9, 901, 1, 1, 0, localo.field_appId, 0, localo.ucz, localo.field_gameMsgId, localo.ucA, str);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(40822);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(40818);
    com.tencent.mm.game.report.api.a.gsb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6);
    AppMethodBeat.o(40818);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(40813);
    com.tencent.mm.game.report.api.a.gsb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(40813);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(40812);
    com.tencent.mm.game.report.api.a.gsb.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(40812);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40814);
    com.tencent.mm.pluginsdk.model.app.g localg = h.m(paramString1, true, false);
    if (localg != null) {
      com.tencent.mm.game.report.api.a.gsb.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localg.Eb(), paramString4, paramInt3);
    }
    AppMethodBeat.o(40814);
  }
  
  public final void aj(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40815);
    com.tencent.mm.game.report.api.a.gsb.m(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(40815);
  }
  
  public final boolean cWA()
  {
    AppMethodBeat.i(40811);
    try
    {
      boolean bool;
      if (com.tencent.mm.plugin.game.commlib.a.tSI != null)
      {
        bool = com.tencent.mm.plugin.game.commlib.a.tSI.uhx;
        ad.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
        AppMethodBeat.o(40811);
        return bool;
      }
      com.tencent.mm.plugin.game.commlib.a.cWO();
      Object localObject = aj.getContext().getSharedPreferences(aj.fkC(), 0);
      aj.getContext();
      localObject = ac.f((SharedPreferences)localObject);
      ad.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { localObject });
      if ("zh_CN".equals(localObject)) {}
      for (localObject = "0";; localObject = "1")
      {
        localObject = bt.bI(com.tencent.mm.n.g.acA().getValue("HideGameCenter"), (String)localObject);
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
  
  public final String cWB()
  {
    AppMethodBeat.i(40820);
    String str = com.tencent.mm.plugin.game.model.e.fv(aj.getContext());
    AppMethodBeat.o(40820);
    return str;
  }
  
  public final void fk(Context paramContext)
  {
    AppMethodBeat.i(40819);
    com.tencent.mm.plugin.game.model.e.fk(paramContext);
    AppMethodBeat.o(40819);
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40817);
    com.tencent.mm.game.report.api.a.gsb.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(40817);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40816);
    com.tencent.mm.game.report.api.a.gsb.k(paramString1, paramString2, paramString3);
    AppMethodBeat.o(40816);
  }
  
  public final void mV(boolean paramBoolean)
  {
    AppMethodBeat.i(40821);
    if (!this.tRi)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qpL, true)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qpO, false))) {
        break label160;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.rUN = paramBoolean;
      this.tRi = true;
      Object localObject;
      if (this.rUN)
      {
        localObject = c.dau();
        if (!bt.isNullOrNil((String)localObject))
        {
          ad.i("MicroMsg.GameDelegateImpl", "preload");
          mz localmz = new mz();
          localmz.dAU.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localmz.dAU.intent = localIntent;
          com.tencent.mm.sdk.b.a.IbL.l(localmz);
        }
      }
      AppMethodBeat.o(40821);
      return;
      label160:
      ad.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      com.tencent.mm.plugin.report.service.g.yhR.n(939L, 4L, 1L);
      if (YearClass.get(aj.getContext()) < 2014)
      {
        ad.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        com.tencent.mm.plugin.report.service.g.yhR.n(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = com.tencent.mm.plugin.game.model.e.cYM();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          ad.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
            localObject = r.cYW();
            if ((localObject == null) || (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L))
            {
              ad.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              com.tencent.mm.plugin.report.service.g.yhR.n(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.g.yhR.n(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (j.fjZ())
        {
          ad.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          com.tencent.mm.plugin.report.service.g.yhR.n(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (bt.isNullOrNil(c.dau()))
        {
          com.tencent.mm.plugin.report.service.g.yhR.n(939L, 9L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b
 * JD-Core Version:    0.7.0.1
 */