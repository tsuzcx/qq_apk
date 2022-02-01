package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.oo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  implements com.tencent.mm.plugin.game.api.b
{
  private boolean CfN = false;
  private boolean xwN = false;
  
  /* Error */
  public final void Tm(int paramInt)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 30	org/json/JSONObject
    //   8: dup
    //   9: invokespecial 31	org/json/JSONObject:<init>	()V
    //   12: astore 4
    //   14: ldc 33
    //   16: invokestatic 39	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   19: checkcast 33	com/tencent/mm/plugin/gamelife/a/c
    //   22: invokeinterface 43 1 0
    //   27: astore_3
    //   28: aload_3
    //   29: getfield 49	com/tencent/mm/plugin/gamelife/e/b:msgType	I
    //   32: istore_2
    //   33: new 30	org/json/JSONObject
    //   36: dup
    //   37: aload_3
    //   38: getfield 53	com/tencent/mm/plugin/gamelife/e/b:CIm	Ljava/lang/String;
    //   41: invokespecial 56	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore_3
    //   45: aload_3
    //   46: ldc 58
    //   48: iload_1
    //   49: invokestatic 64	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: ldc 70
    //   58: ldc 72
    //   60: aload_3
    //   61: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   64: aconst_null
    //   65: invokestatic 82	com/tencent/mm/game/report/g:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   68: astore_3
    //   69: invokestatic 88	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   72: bipush 9
    //   74: sipush 901
    //   77: iconst_1
    //   78: iconst_1
    //   79: iconst_0
    //   80: aconst_null
    //   81: iconst_0
    //   82: iload_2
    //   83: aconst_null
    //   84: aconst_null
    //   85: aload_3
    //   86: invokestatic 91	com/tencent/mm/game/report/g:a	(Landroid/content/Context;IIIIILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 23
    //   91: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore 5
    //   97: aload 4
    //   99: astore_3
    //   100: aload 5
    //   102: astore 4
    //   104: ldc 96
    //   106: aload 4
    //   108: ldc 98
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: goto -61 -> 56
    //   120: astore 4
    //   122: goto -18 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	b
    //   0	125	1	paramInt	int
    //   32	51	2	i	int
    //   27	73	3	localObject1	Object
    //   12	95	4	localObject2	Object
    //   120	1	4	localJSONException1	org.json.JSONException
    //   95	6	5	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   33	45	95	org/json/JSONException
    //   45	56	120	org/json/JSONException
  }
  
  public final void V(long paramLong, int paramInt)
  {
    AppMethodBeat.i(40822);
    o localo = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().NP(paramLong);
    if (localo != null)
    {
      localo.eyt();
      String str = com.tencent.mm.game.report.g.a("resource", String.valueOf(paramInt), localo.CJY, null);
      if (localo.field_needReport)
      {
        com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 9, 901, 1, 1, 0, localo.field_appId, 0, localo.CJW, localo.field_gameMsgId, localo.CJX, str);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 2L, 1L, false);
      }
    }
    AppMethodBeat.o(40822);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(40818);
    com.tencent.mm.game.report.api.a.jTp.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, 0L, paramString5, paramString6);
    AppMethodBeat.o(40818);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(40813);
    com.tencent.mm.game.report.api.a.jTp.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2);
    AppMethodBeat.o(40813);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(40812);
    com.tencent.mm.game.report.api.a.jTp.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3);
    AppMethodBeat.o(40812);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(40814);
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(paramString1, true, false);
    if (localg != null) {
      com.tencent.mm.game.report.api.a.jTp.a(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramLong, localg.Qv(), paramString4, paramInt3);
    }
    AppMethodBeat.o(40814);
  }
  
  public final void aIK(String paramString)
  {
    AppMethodBeat.i(209788);
    com.tencent.mm.plugin.game.b.b localb = com.tencent.mm.plugin.game.b.b.CzF;
    com.tencent.mm.plugin.game.b.b.aJb(paramString);
    AppMethodBeat.o(209788);
  }
  
  public final void ao(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40815);
    com.tencent.mm.game.report.api.a.jTp.n(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(40815);
  }
  
  public final boolean evh()
  {
    AppMethodBeat.i(40811);
    try
    {
      boolean bool;
      if (com.tencent.mm.plugin.game.commlib.a.Czb != null)
      {
        bool = com.tencent.mm.plugin.game.commlib.a.Czb.ShowEntrance;
        Log.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
        AppMethodBeat.o(40811);
        return bool;
      }
      com.tencent.mm.plugin.game.commlib.a.ewa();
      String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      Log.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { str });
      if ("zh_CN".equals(str)) {}
      for (str = "0";; str = "1")
      {
        str = Util.nullAs(com.tencent.mm.n.h.axc().getValue("HideGameCenter"), str);
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
  
  public final String evi()
  {
    AppMethodBeat.i(40820);
    String str = com.tencent.mm.plugin.game.model.e.gz(MMApplicationContext.getContext());
    AppMethodBeat.o(40820);
    return str;
  }
  
  public final void gn(Context paramContext)
  {
    AppMethodBeat.i(40819);
    com.tencent.mm.plugin.game.model.e.gn(paramContext);
    AppMethodBeat.o(40819);
  }
  
  public final void k(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40817);
    com.tencent.mm.game.report.api.a.jTp.k(paramContext, paramString1, paramString2);
    AppMethodBeat.o(40817);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40816);
    com.tencent.mm.game.report.api.a.jTp.k(paramString1, paramString2, paramString3);
    AppMethodBeat.o(40816);
  }
  
  public final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(40821);
    if (!this.CfN)
    {
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vtX, true)) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vua, false))) {
        break label159;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.xwN = paramBoolean;
      this.CfN = true;
      Object localObject;
      if (this.xwN)
      {
        localObject = c.ezZ();
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.i("MicroMsg.GameDelegateImpl", "preload");
          oo localoo = new oo();
          localoo.fNq.type = 3;
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          localoo.fNq.intent = localIntent;
          EventCenter.instance.publish(localoo);
        }
      }
      AppMethodBeat.o(40821);
      return;
      label159:
      Log.i("MicroMsg.GameDelegateImpl", "hit expt preload");
      com.tencent.mm.plugin.report.service.h.IzE.p(939L, 4L, 1L);
      if (YearClass.get(MMApplicationContext.getContext()) < 2014)
      {
        Log.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
        com.tencent.mm.plugin.report.service.h.IzE.p(939L, 5L, 1L);
        paramBoolean = false;
      }
      else
      {
        long l = com.tencent.mm.plugin.game.model.e.eyk();
        if (System.currentTimeMillis() - l > 21600000L)
        {
          Log.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
          if (paramBoolean)
          {
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn();
            localObject = r.eyv();
            if ((localObject == null) || (System.currentTimeMillis() - ((o)localObject).field_receiveTime * 1000L > 21600000L))
            {
              Log.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
              com.tencent.mm.plugin.report.service.h.IzE.p(939L, 7L, 1L);
              paramBoolean = false;
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.IzE.p(939L, 6L, 1L);
            paramBoolean = false;
            continue;
          }
        }
        if (ChannelUtil.isGPVersion())
        {
          Log.i("MicroMsg.GameDelegateImpl", "isGPVersion");
          com.tencent.mm.plugin.report.service.h.IzE.p(939L, 8L, 1L);
          paramBoolean = false;
        }
        else if (Util.isNullOrNil(c.ezZ()))
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(939L, 9L, 1L);
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