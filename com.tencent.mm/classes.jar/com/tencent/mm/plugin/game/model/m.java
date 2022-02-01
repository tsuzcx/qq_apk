package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
      paramo.cQp();
      str = paramString;
      if (!bs.isNullOrNil(paramo.tem.url))
      {
        dT(paramo.tem.teQ);
        str = gP(paramString, "h5FloatLayer=1");
        ac.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { str });
      }
      paramString = str;
      if (!bs.isNullOrNil(paramo.teD.teR)) {
        dT(paramo.teD.teQ);
      }
    }
    try
    {
      paramString = gP(str, "h5BannerId=" + p.encode(paramo.teD.teR, "UTF-8"));
      ac.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      str = paramString;
      if (!bs.isNullOrNil(paramo.tdY.mDesc))
      {
        str = paramString;
        if (!bs.isNullOrNil(paramo.tdY.teS))
        {
          str = paramString;
          if (!bs.isNullOrNil(paramo.tdY.teT)) {
            str = gP(paramString, "hasBubble=1");
          }
        }
      }
      paramString = gP(str, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!bs.isNullOrNil(paramo.teL)) {}
      try
      {
        str = gP(paramString, "business_data=" + URLEncoder.encode(paramo.teL, "utf-8"));
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
    if ((bs.isNullOrNil(paramString)) || (paramIntent == null))
    {
      AppMethodBeat.o(41435);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    ((d)g.ab(d.class)).cOl();
    o localo2 = r.cQu();
    o localo1 = localo2;
    if (localo2 == null)
    {
      ((d)g.ab(d.class)).cOl();
      localo2 = r.cQy();
      localo1 = localo2;
      if (localo2 == null)
      {
        ((d)g.ab(d.class)).cOl();
        localo1 = r.cQw();
      }
    }
    paramString = a(paramString, localo1);
    paramIntent.putExtra("rawUrl", paramString);
    if (bool)
    {
      a(paramActivity, paramIntent, "game_center_entrance", true, localo1, i);
      b(7, true, paramString);
      ((d)g.ab(d.class)).cOl();
      r.cQz();
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
      paramo.cQp();
      if (paramo.tem.teP) {
        paramIntent.putExtra("game_transparent_float_url", paramo.tem.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.tem.url);
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
      ((d)g.ab(d.class)).cOl();
      paramo = r.cQu();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.cQp();
    ac.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!bs.isNullOrNil(localo.tem.url))
    {
      paramo = com.tencent.mm.game.report.e.a("resource", String.valueOf(localo.tdW.teU), localo.teK, null);
      com.tencent.mm.game.report.e.a(ai.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.teI, localo.field_gameMsgId, localo.teJ, paramo);
      if (paramInt2 != 1) {
        break label188;
      }
      h.wUl.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().update(localo, new String[0]);
      ((d)g.ab(d.class)).cOl();
      r.cQv();
      AppMethodBeat.o(41437);
      return;
      label188:
      if (paramInt2 == 2) {
        h.wUl.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((d)g.ab(d.class)).cOl();
    o localo = r.cQr();
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
      com.tencent.mm.game.report.e.a(ai.getContext(), 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.e.a.l(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.cQp();
    paramString = com.tencent.mm.game.report.e.a("resource", String.valueOf(localo.tdW.teU), localo.teK, localHashMap);
    com.tencent.mm.game.report.e.a(ai.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.teI, localo.field_gameMsgId, localo.teJ, paramString);
    ((d)g.ab(d.class)).cOl();
    r.cQs();
    h.wUl.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  public static void b(Activity paramActivity, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(41436);
    if ((bs.isNullOrNil(paramString)) || (paramIntent == null))
    {
      AppMethodBeat.o(41436);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    ((d)g.ab(d.class)).cOl();
    o localo2 = r.cQu();
    o localo1 = localo2;
    if (localo2 == null)
    {
      ((d)g.ab(d.class)).cOl();
      localo2 = r.cQy();
      localo1 = localo2;
      if (localo2 == null)
      {
        ((d)g.ab(d.class)).cOl();
        localo1 = r.cQw();
      }
    }
    paramString = a(paramString, localo1);
    paramIntent.putExtra("rawUrl", paramString);
    paramIntent.putExtra("from_find_more_friend", true);
    if (bool)
    {
      ((d)g.ab(d.class)).cOl();
      localo2 = r.cQr();
      if (localo2 != null)
      {
        localo2.cQp();
        if (localo2.teI == 107) {
          paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
        }
      }
      b(paramActivity, paramIntent, "game_center_entrance", true, localo1, i);
      b(7, true, paramString);
      ((d)g.ab(d.class)).cOl();
      r.cQz();
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
      paramo.cQp();
      if ((paramo.tem != null) && (!bs.isNullOrNil(paramo.tem.url)))
      {
        paramString = new GameFloatLayerInfo();
        paramString.url = gO((String)localObject, paramo.tem.url);
        paramString.sWB = paramo.tem.sWB;
        i = -1;
        switch (paramo.tem.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString.orientation = i;
      localObject = new GameWebViewLaunchParams();
      ((GameWebViewLaunchParams)localObject).sWE = paramString;
      paramIntent.putExtra("launchParams", (Parcelable)localObject);
      paramIntent.putExtra("game_float_layer_url", paramo.tem.url);
      c.y(paramIntent, paramContext);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(41439);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  private static void dT(List paramList)
  {
    AppMethodBeat.i(41442);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    ys localys = new ys();
    localys.dCz.cZu = 8;
    localys.dCz.scene = 1;
    localys.dCz.dCF = paramList;
    com.tencent.mm.sdk.b.a.GpY.l(localys);
    AppMethodBeat.o(41442);
  }
  
  private static String gO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41440);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = Uri.parse(paramString1).getQueryParameter("nav_color");
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = gP(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  private static String gP(String paramString1, String paramString2)
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
        ac.printErrStackTrace("MicroMsg.GameEntranceChecker", paramString2, "", new Object[0]);
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