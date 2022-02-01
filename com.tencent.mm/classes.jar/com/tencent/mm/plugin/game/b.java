package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean sdr = false;
  private boolean ubZ = false;
  
  public final void HU(int paramInt)
  {
    AppMethodBeat.i(195587);
    Object localObject = new HashMap();
    ((Map)localObject).put("interactive", "20002");
    ((Map)localObject).put("chatmsg_num", String.valueOf(paramInt));
    localObject = com.tencent.mm.game.report.f.a("resource", "4", null, (Map)localObject);
    com.tencent.mm.game.report.f.a(ak.getContext(), 9, 901, 1, 1, 0, null, 0, 200, null, null, (String)localObject);
    AppMethodBeat.o(195587);
  }
  
  public final void P(long paramLong, int paramInt)
  {
    AppMethodBeat.i(40822);
    o localo = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().xZ(paramLong);
    if (localo != null)
    {
      localo.dbE();
      String str = com.tencent.mm.game.report.f.a("resource", String.valueOf(paramInt), localo.unF, null);
      if (localo.ctn())
      {
        com.tencent.mm.game.report.f.a(ak.getContext(), 9, 901, 1, 1, 0, localo.field_appId, 0, localo.unD, localo.field_gameMsgId, localo.unE, str);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(40822);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(40818);
    com.tencent.mm.game.report.api.a.guC.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6);
    AppMethodBeat.o(40818);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(40813);
    com.tencent.mm.game.report.api.a.guC.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(40813);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(40812);
    com.tencent.mm.game.report.api.a.guC.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(40812);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40814);
    com.tencent.mm.pluginsdk.model.app.g localg = h.m(paramString1, true, false);
    if (localg != null) {
      com.tencent.mm.game.report.api.a.guC.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localg.Ee(), paramString4, paramInt3);
    }
    AppMethodBeat.o(40814);
  }
  
  public final void aj(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40815);
    com.tencent.mm.game.report.api.a.guC.m(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(40815);
  }
  
  public final boolean cZf()
  {
    AppMethodBeat.i(40811);
    try
    {
      boolean bool;
      if (com.tencent.mm.plugin.game.commlib.a.udz != null)
      {
        bool = com.tencent.mm.plugin.game.commlib.a.udz.usV;
        ae.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
        AppMethodBeat.o(40811);
        return bool;
      }
      com.tencent.mm.plugin.game.commlib.a.cZs();
      Object localObject = ak.getContext().getSharedPreferences(ak.fow(), 0);
      ak.getContext();
      localObject = ad.f((SharedPreferences)localObject);
      ae.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { localObject });
      if ("zh_CN".equals(localObject)) {}
      for (localObject = "0";; localObject = "1")
      {
        localObject = bu.bI(com.tencent.mm.n.g.acL().getValue("HideGameCenter"), (String)localObject);
        ae.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[] { localObject });
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
  
  public final String cZg()
  {
    AppMethodBeat.i(40820);
    String str = com.tencent.mm.plugin.game.model.e.fz(ak.getContext());
    AppMethodBeat.o(40820);
    return str;
  }
  
  public final void fo(Context paramContext)
  {
    AppMethodBeat.i(40819);
    com.tencent.mm.plugin.game.model.e.fo(paramContext);
    AppMethodBeat.o(40819);
  }
  
  public final void j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40817);
    com.tencent.mm.game.report.api.a.guC.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(40817);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40816);
    com.tencent.mm.game.report.api.a.guC.k(paramString1, paramString2, paramString3);
    AppMethodBeat.o(40816);
  }
  
  public final void mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(40821);
    if (!this.ubZ)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qws, true)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qwv, false))) {
        break label160;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.sdr = paramBoolean;
      this.ubZ = true;
      Object localObject;
      if (this.sdr)
      {
        localObject = c.ddg();
        if (!bu.isNullOrNil((String)localObject))
        {
          ae.i("MicroMsg.GameDelegateImpl", "preload");
          na localna = new na();
          localna.dBZ.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localna.dBZ.intent = localIntent;
          com.tencent.mm.sdk.b.a.IvT.l(localna);
        }
      }
      AppMethodBeat.o(40821);
      return;
      label160:
      ae.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      com.tencent.mm.plugin.report.service.g.yxI.n(939L, 4L, 1L);
      if (YearClass.get(ak.getContext()) < 2014)
      {
        ae.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        com.tencent.mm.plugin.report.service.g.yxI.n(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = com.tencent.mm.plugin.game.model.e.dbw();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          ae.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
            localObject = r.dbG();
            if ((localObject == null) || (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L))
            {
              ae.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              com.tencent.mm.plugin.report.service.g.yxI.n(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.g.yxI.n(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (k.fnT())
        {
          ae.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          com.tencent.mm.plugin.report.service.g.yxI.n(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (bu.isNullOrNil(c.ddg()))
        {
          com.tencent.mm.plugin.report.service.g.yxI.n(939L, 9L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b
 * JD-Core Version:    0.7.0.1
 */