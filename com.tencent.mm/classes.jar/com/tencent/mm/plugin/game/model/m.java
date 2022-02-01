package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

public final class m
{
  public static String a(String paramString, o paramo)
  {
    AppMethodBeat.i(41441);
    String str = paramString;
    if (paramo != null)
    {
      paramo.cDf();
      str = paramString;
      if (!bt.isNullOrNil(paramo.rWu.url))
      {
        dP(paramo.rWu.rWY);
        str = gy(paramString, "h5FloatLayer=1");
        ad.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { str });
      }
      paramString = str;
      if (!bt.isNullOrNil(paramo.rWL.rWZ)) {
        dP(paramo.rWL.rWY);
      }
    }
    try
    {
      paramString = gy(str, "h5BannerId=" + p.encode(paramo.rWL.rWZ, "UTF-8"));
      ad.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      str = paramString;
      if (!bt.isNullOrNil(paramo.rWg.mDesc))
      {
        str = paramString;
        if (!bt.isNullOrNil(paramo.rWg.rXa))
        {
          str = paramString;
          if (!bt.isNullOrNil(paramo.rWg.rXb)) {
            str = gy(paramString, "hasBubble=1");
          }
        }
      }
      paramString = gy(str, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!bt.isNullOrNil(paramo.rWT)) {}
      try
      {
        str = gy(paramString, "business_data=" + URLEncoder.encode(paramo.rWT, "utf-8"));
        AppMethodBeat.o(41441);
        return str;
      }
      catch (UnsupportedEncodingException paramo)
      {
        for (;;)
        {
          str = paramString;
        }
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(41435);
    if ((bt.isNullOrNil(paramString)) || (paramIntent == null))
    {
      AppMethodBeat.o(41435);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    ((d)g.ab(d.class)).cBc();
    o localo2 = r.cDk();
    o localo1 = localo2;
    if (localo2 == null)
    {
      ((d)g.ab(d.class)).cBc();
      localo2 = r.cDo();
      localo1 = localo2;
      if (localo2 == null)
      {
        ((d)g.ab(d.class)).cBc();
        localo1 = r.cDm();
      }
    }
    paramString = a(paramString, localo1);
    paramIntent.putExtra("rawUrl", paramString);
    if (bool)
    {
      a(paramActivity, paramIntent, "game_center_entrance", true, localo1, i);
      b(7, true, paramString);
      ((d)g.ab(d.class)).cBc();
      r.cDp();
      AppMethodBeat.o(41435);
      return;
    }
    a(paramActivity, paramIntent, "game_center_entrance", false, localo1, i);
    AppMethodBeat.o(41435);
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, o paramo, int paramInt)
  {
    AppMethodBeat.i(41438);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    if ((paramBoolean) && (paramo != null))
    {
      paramo.cDf();
      if (paramo.rWu.rWX) {
        paramIntent.putExtra("game_transparent_float_url", paramo.rWu.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.rWu.url);
    }
    c.x(paramIntent, paramContext);
    AppMethodBeat.o(41438);
  }
  
  public static void a(o paramo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41437);
    o localo = paramo;
    if (paramo == null)
    {
      ((d)g.ab(d.class)).cBc();
      paramo = r.cDk();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.cDf();
    ad.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!bt.isNullOrNil(localo.rWu.url))
    {
      paramo = com.tencent.mm.game.report.e.a("resource", String.valueOf(localo.rWe.rXc), localo.rWS, null);
      com.tencent.mm.game.report.e.a(aj.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.rWQ, localo.field_gameMsgId, localo.rWR, paramo);
      if (paramInt2 != 1) {
        break label188;
      }
      h.vKh.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().update(localo, new String[0]);
      ((d)g.ab(d.class)).cBc();
      r.cDl();
      AppMethodBeat.o(41437);
      return;
      label188:
      if (paramInt2 == 2) {
        h.vKh.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((d)g.ab(d.class)).cBc();
    o localo = r.cDh();
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      localHashMap.put("luggage", "1");
    }
    if (paramString != null) {
      localHashMap.put("entrance_url", paramString);
    }
    if (localo == null)
    {
      localHashMap.put("function_type", "resource");
      localHashMap.put("function_value", "0");
      com.tencent.mm.game.report.e.a(aj.getContext(), 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.e.a.m(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.cDf();
    paramString = com.tencent.mm.game.report.e.a("resource", String.valueOf(localo.rWe.rXc), localo.rWS, localHashMap);
    com.tencent.mm.game.report.e.a(aj.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.rWQ, localo.field_gameMsgId, localo.rWR, paramString);
    ((d)g.ab(d.class)).cBc();
    r.cDi();
    h.vKh.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  public static void b(Activity paramActivity, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(41436);
    if ((bt.isNullOrNil(paramString)) || (paramIntent == null))
    {
      AppMethodBeat.o(41436);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    ((d)g.ab(d.class)).cBc();
    o localo2 = r.cDk();
    o localo1 = localo2;
    if (localo2 == null)
    {
      ((d)g.ab(d.class)).cBc();
      localo2 = r.cDo();
      localo1 = localo2;
      if (localo2 == null)
      {
        ((d)g.ab(d.class)).cBc();
        localo1 = r.cDm();
      }
    }
    paramString = a(paramString, localo1);
    paramIntent.putExtra("rawUrl", paramString);
    paramIntent.putExtra("from_find_more_friend", true);
    if (bool)
    {
      ((d)g.ab(d.class)).cBc();
      localo2 = r.cDh();
      if (localo2 != null)
      {
        localo2.cDf();
        if (localo2.rWQ == 107) {
          paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
        }
      }
      b(paramActivity, paramIntent, "game_center_entrance", true, localo1, i);
      b(7, true, paramString);
      ((d)g.ab(d.class)).cBc();
      r.cDp();
      AppMethodBeat.o(41436);
      return;
    }
    b(paramActivity, paramIntent, "game_center_entrance", false, localo1, i);
    AppMethodBeat.o(41436);
  }
  
  private static void b(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, o paramo, int paramInt)
  {
    AppMethodBeat.i(41439);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    Object localObject = paramIntent.getStringExtra("rawUrl");
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.cDf();
      if ((paramo.rWu != null) && (!bt.isNullOrNil(paramo.rWu.url)))
      {
        paramString = new GameFloatLayerInfo();
        paramString.url = gx((String)localObject, paramo.rWu.url);
        paramString.rOL = paramo.rWu.rOL;
        i = -1;
        switch (paramo.rWu.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString.orientation = i;
      localObject = new GameWebViewLaunchParams();
      ((GameWebViewLaunchParams)localObject).rOO = paramString;
      paramIntent.putExtra("launchParams", (Parcelable)localObject);
      paramIntent.putExtra("game_float_layer_url", paramo.rWu.url);
      c.y(paramIntent, paramContext);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(41439);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  private static void dP(List paramList)
  {
    AppMethodBeat.i(41442);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    yh localyh = new yh();
    localyh.dEN.dbV = 8;
    localyh.dEN.scene = 1;
    localyh.dEN.dET = paramList;
    com.tencent.mm.sdk.b.a.ESL.l(localyh);
    AppMethodBeat.o(41442);
  }
  
  private static String gx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41440);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = Uri.parse(paramString1).getQueryParameter("nav_color");
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = gy(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  private static String gy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41443);
    Uri localUri = Uri.parse(paramString1);
    String str = localUri.getQuery();
    if (str != null) {
      paramString2 = str + "&" + paramString2;
    }
    for (;;)
    {
      try
      {
        paramString2 = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), paramString2, localUri.getFragment()).toString();
        paramString1 = paramString2;
      }
      catch (URISyntaxException paramString2)
      {
        ad.printErrStackTrace("MicroMsg.GameEntranceChecker", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(41443);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */