package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.py;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean AUs = false;
  private boolean HRU = false;
  
  public final void WX(int paramInt)
  {
    AppMethodBeat.i(275309);
    int i = 200;
    Object localObject = new JSONObject();
    com.tencent.mm.plugin.gamelife.f.b localb = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIj();
    if (localb == null) {}
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("interactive", "20002");
        ((JSONObject)localObject).put("chatmsg_num", String.valueOf(paramInt));
        paramInt = i;
      }
      catch (JSONException localJSONException1)
      {
        paramInt = i;
        continue;
      }
      localObject = com.tencent.mm.game.report.g.a("resource", "4", ((JSONObject)localObject).toString(), null);
      com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, null, 0, paramInt, null, null, (String)localObject);
      AppMethodBeat.o(275309);
      return;
      i = localJSONException1.msgType;
      try
      {
        JSONObject localJSONObject = new JSONObject(localJSONException1.ICw);
        try
        {
          localJSONObject.put("chatmsg_num", String.valueOf(paramInt));
          localObject = localJSONObject;
          paramInt = i;
        }
        catch (JSONException localJSONException2)
        {
          localObject = localJSONObject;
        }
      }
      catch (JSONException localJSONException3)
      {
        label150:
        break label150;
      }
      Log.printErrStackTrace("MicroMsg.GameDelegateImpl", localJSONException2, "", new Object[0]);
      paramInt = i;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(40818);
    com.tencent.mm.game.report.api.a.mtH.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5, paramString6);
    AppMethodBeat.o(40818);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(40813);
    com.tencent.mm.game.report.api.a.mtH.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(40813);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(40812);
    com.tencent.mm.game.report.api.a.mtH.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(40812);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40814);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(paramString1, true, false);
    if (localg != null) {
      com.tencent.mm.game.report.api.a.mtH.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localg.aqJ(), paramString4, paramInt3);
    }
    AppMethodBeat.o(40814);
  }
  
  public final void aFk(String paramString)
  {
    AppMethodBeat.i(275310);
    com.tencent.mm.plugin.game.b.b localb = com.tencent.mm.plugin.game.b.b.Itw;
    com.tencent.mm.plugin.game.b.b.aFN(paramString);
    AppMethodBeat.o(275310);
  }
  
  public final void al(long paramLong, int paramInt)
  {
    AppMethodBeat.i(40822);
    o localo = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().rG(paramLong);
    if (localo != null)
    {
      localo.fGp();
      String str = com.tencent.mm.game.report.g.a("resource", String.valueOf(paramInt), localo.IEi, null);
      if (localo.field_needReport)
      {
        com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, localo.field_appId, 0, localo.IEh, localo.field_gameMsgId, localo.mNoticeId, str);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(40822);
  }
  
  public final void av(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40815);
    com.tencent.mm.game.report.api.a.mtH.q(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(40815);
  }
  
  public final boolean fBZ()
  {
    AppMethodBeat.i(40811);
    try
    {
      boolean bool;
      if (com.tencent.mm.plugin.game.commlib.a.IsN != null)
      {
        bool = com.tencent.mm.plugin.game.commlib.a.IsN.ShowEntrance;
        Log.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
        AppMethodBeat.o(40811);
        return bool;
      }
      com.tencent.mm.plugin.game.commlib.a.fDQ();
      String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      Log.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { str });
      if ("zh_CN".equals(str)) {}
      for (str = "0";; str = "1")
      {
        str = Util.nullAs(i.aRC().getValue("HideGameCenter"), str);
        Log.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[] { str });
        bool = str.equalsIgnoreCase("0");
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(40811);
    }
  }
  
  public final String fCa()
  {
    AppMethodBeat.i(40820);
    String str = com.tencent.mm.plugin.game.model.e.hS(MMApplicationContext.getContext());
    AppMethodBeat.o(40820);
    return str;
  }
  
  public final void hG(Context paramContext)
  {
    AppMethodBeat.i(40819);
    com.tencent.mm.plugin.game.model.e.hG(paramContext);
    AppMethodBeat.o(40819);
  }
  
  public final void o(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40817);
    com.tencent.mm.game.report.api.a.mtH.o(paramContext, paramString1, paramString2);
    AppMethodBeat.o(40817);
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40816);
    com.tencent.mm.game.report.api.a.mtH.p(paramString1, paramString2, paramString3);
    AppMethodBeat.o(40816);
  }
  
  public final void wc(boolean paramBoolean)
  {
    AppMethodBeat.i(40821);
    if (!this.HRU)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGB, true)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGE, false))) {
        break label156;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.AUs = paramBoolean;
      this.HRU = true;
      Object localObject;
      if (this.AUs)
      {
        localObject = com.tencent.mm.plugin.game.d.c.fIa();
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.i("MicroMsg.GameDelegateImpl", "preload");
          py localpy = new py();
          localpy.hTd.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localpy.hTd.intent = localIntent;
          localpy.publish();
        }
      }
      AppMethodBeat.o(40821);
      return;
      label156:
      Log.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      com.tencent.mm.plugin.report.service.h.OAn.p(939L, 4L, 1L);
      if (com.c.a.b.aH(MMApplicationContext.getContext()) < 2014)
      {
        Log.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        com.tencent.mm.plugin.report.service.h.OAn.p(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = com.tencent.mm.plugin.game.model.e.fGg();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          Log.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg();
            localObject = r.fGr();
            if ((localObject == null) || (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L))
            {
              Log.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              com.tencent.mm.plugin.report.service.h.OAn.p(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.OAn.p(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (ChannelUtil.isGPVersion())
        {
          Log.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          com.tencent.mm.plugin.report.service.h.OAn.p(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (Util.isNullOrNil(com.tencent.mm.plugin.game.d.c.fIa()))
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(939L, 9L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b
 * JD-Core Version:    0.7.0.1
 */