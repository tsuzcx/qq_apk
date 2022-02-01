package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.a;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class m
{
  public static String a(String paramString, o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(206828);
    String str = paramString;
    if (paramo != null)
    {
      paramo.cYU();
      str = paramString;
      if (!bt.isNullOrNil(paramo.ucc.url))
      {
        if (paramBoolean) {
          ed(paramo.ucc.ucH);
        }
        str = ha(paramString, "h5FloatLayer=1");
        ad.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { str });
      }
      paramString = str;
      if (!bt.isNullOrNil(paramo.uct.ucJ)) {
        if (paramBoolean) {
          ed(paramo.uct.ucH);
        }
      }
    }
    try
    {
      paramString = ha(str, "h5BannerId=" + q.encode(paramo.uct.ucJ, "UTF-8"));
      ad.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      str = paramString;
      if (!bt.isNullOrNil(paramo.ubO.mDesc))
      {
        str = paramString;
        if (!bt.isNullOrNil(paramo.ubO.ucK))
        {
          str = paramString;
          if (!bt.isNullOrNil(paramo.ubO.ucL)) {
            str = ha(paramString, "hasBubble=1");
          }
        }
      }
      paramString = ha(str, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!bt.isNullOrNil(paramo.ucC)) {}
      try
      {
        str = ha(paramString, "business_data=" + URLEncoder.encode(paramo.ucC, "utf-8"));
        AppMethodBeat.o(206828);
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
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, o paramo, int paramInt)
  {
    AppMethodBeat.i(41438);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    if ((paramBoolean) && (paramo != null))
    {
      paramo.cYU();
      if (paramo.ucc.ucG) {
        paramIntent.putExtra("game_transparent_float_url", paramo.ucc.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.ucc.url);
    }
    c.x(paramIntent, paramContext);
    AppMethodBeat.o(41438);
  }
  
  public static void a(Intent paramIntent, String paramString1, boolean paramBoolean, o paramo, int paramInt, String paramString2)
  {
    AppMethodBeat.i(206827);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString1);
    paramIntent.putExtra("game_check_float", paramBoolean);
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.cYU();
      if ((paramo.ucc != null) && (!bt.isNullOrNil(paramo.ucc.url)))
      {
        paramString1 = new GameFloatLayerInfo();
        paramString1.url = gZ(paramString2, paramo.ucc.url);
        paramString1.tTj = paramo.ucc.tTj;
        i = -1;
        switch (paramo.ucc.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString1.orientation = i;
      paramString2 = new GameWebViewLaunchParams();
      paramString2.tTl = paramString1;
      paramIntent.putExtra("launchParams", paramString2);
      paramIntent.putExtra("game_float_layer_url", paramo.ucc.url);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(206827);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public static void a(o paramo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41437);
    o localo = paramo;
    if (paramo == null)
    {
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
      paramo = r.cYZ();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.cYU();
    ad.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!bt.isNullOrNil(localo.ucc.url))
    {
      paramo = com.tencent.mm.game.report.f.a("resource", String.valueOf(localo.ubM.ucM), localo.ucB, null);
      com.tencent.mm.game.report.f.a(aj.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.ucz, localo.field_gameMsgId, localo.ucA, paramo);
      if (paramInt2 != 1) {
        break label188;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().update(localo, new String[0]);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
      r.cZa();
      AppMethodBeat.o(41437);
      return;
      label188:
      if (paramInt2 == 2) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
    o localo = r.cYW();
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
      com.tencent.mm.game.report.f.a(aj.getContext(), 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.e.a.l(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.cYU();
    paramString = com.tencent.mm.game.report.f.a("resource", String.valueOf(localo.ubM.ucM), localo.ucB, localHashMap);
    com.tencent.mm.game.report.f.a(aj.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.ucz, localo.field_gameMsgId, localo.ucA, paramString);
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
    r.cYX();
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  public static boolean d(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(206826);
    if (paramIntent == null)
    {
      AppMethodBeat.o(206826);
      return false;
    }
    boolean bool4 = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    boolean bool5 = paramIntent.getBooleanExtra("has_game_life_chat_msg", false);
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
    o localo = r.cYV();
    paramIntent.putExtra("from_find_more_friend", true);
    GameTabData2 localGameTabData2 = GameTabData2.daj();
    if (localGameTabData2 == null)
    {
      AppMethodBeat.o(206826);
      return false;
    }
    Object localObject1 = localGameTabData2.utG.entrySet().iterator();
    Object localObject2;
    boolean bool3;
    for (boolean bool1 = true; ((Iterator)localObject1).hasNext(); bool1 = bool3)
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)((Map.Entry)localObject2).getValue();
      bool3 = bool1;
      if (localTabItem != null)
      {
        boolean bool2 = bool1;
        if (!bt.isNullOrNil(localTabItem.jumpUrl))
        {
          localTabItem.jumpUrl = a(localTabItem.jumpUrl, localo, bool1);
          bool2 = false;
        }
        localGameTabData2.utG.a((String)((Map.Entry)localObject2).getKey(), localTabItem);
        bool3 = bool2;
        if (localTabItem.duh == 1)
        {
          bool3 = bool2;
          if (bool5)
          {
            localGameTabData2.utH = localTabItem.uea;
            bool3 = bool2;
          }
        }
      }
    }
    localObject1 = paramIntent.getStringExtra("default_game_tab_key");
    if ((!bt.isNullOrNil((String)localObject1)) && (localGameTabData2.utG.containsKey(localObject1))) {
      localGameTabData2.utH = ((String)localObject1);
    }
    localObject1 = (GameTabData2.TabItem)localGameTabData2.utG.get(localGameTabData2.utH);
    if (localObject1 == null)
    {
      AppMethodBeat.o(206826);
      return false;
    }
    ad.i("MicroMsg.GameEntranceChecker", "defaultKey:%s, tabType:%d, gameTabData:%s", new Object[] { ((GameTabData2.TabItem)localObject1).uea, Integer.valueOf(((GameTabData2.TabItem)localObject1).duh), localGameTabData2.toJson() });
    if (bool4)
    {
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
      localObject2 = r.cYW();
      if (localObject2 != null)
      {
        ((o)localObject2).cYU();
        if (((o)localObject2).ucz == 107) {
          paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
        }
      }
      a(paramIntent, "game_center_entrance", true, localo, i, ((GameTabData2.TabItem)localObject1).jumpUrl);
      paramIntent.putExtra("game_tab_data", localGameTabData2);
      paramIntent.putExtra("game_tab_key", localGameTabData2.utH);
      GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject1, true);
      if (bool5)
      {
        i = paramIntent.getIntExtra("game_life_msg_count", 0);
        paramActivity = new HashMap();
        paramActivity.put("interactive", "20002");
        paramActivity.put("chatmsg_num", String.valueOf(i));
        paramActivity = com.tencent.mm.game.report.f.k(paramActivity);
        com.tencent.mm.game.report.f.a(aj.getContext(), 9, 901, 1, 6, 0, null, 0, 200, null, null, paramActivity);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206826);
      return true;
      b(7, true, ((GameTabData2.TabItem)localObject1).jumpUrl);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cWG();
      r.cZe();
      continue;
      a(paramIntent, "game_center_entrance", false, localo, i, ((GameTabData2.TabItem)localObject1).jumpUrl);
      paramIntent.putExtra("game_tab_data", localGameTabData2);
      paramIntent.putExtra("game_tab_key", localGameTabData2.utH);
      GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject1, true);
    }
  }
  
  private static void ed(List paramList)
  {
    AppMethodBeat.i(41442);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    zm localzm = new zm();
    localzm.dOM.dkM = 8;
    localzm.dOM.scene = 1;
    localzm.dOM.dOS = paramList;
    com.tencent.mm.sdk.b.a.IbL.l(localzm);
    AppMethodBeat.o(41442);
  }
  
  private static String gZ(String paramString1, String paramString2)
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
    paramString1 = ha(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  private static String ha(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */