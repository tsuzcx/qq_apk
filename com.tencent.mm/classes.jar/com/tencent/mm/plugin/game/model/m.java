package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.a;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  public static String a(String paramString, o paramo, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(195643);
    String str = paramString;
    if (paramo != null)
    {
      paramo.dbE();
      if ((paramIntent != null) && (!paramIntent.hasExtra("game_pre_inject_data"))) {
        paramIntent.putExtra("game_pre_inject_data", paramo.unB.unM);
      }
      paramIntent = paramString;
      if (!bu.isNullOrNil(paramo.une.url))
      {
        if (paramBoolean) {
          eh(paramo.une.unL);
        }
        paramIntent = hf(paramString, "h5FloatLayer=1");
        ae.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { paramIntent });
      }
      paramString = paramIntent;
      if (!bu.isNullOrNil(paramo.unv.unO)) {
        if (paramBoolean) {
          eh(paramo.unv.unL);
        }
      }
    }
    try
    {
      paramString = hf(paramIntent, "h5BannerId=" + q.encode(paramo.unv.unO, "UTF-8"));
      ae.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      paramIntent = paramString;
      if (!bu.isNullOrNil(paramo.umQ.mDesc))
      {
        paramIntent = paramString;
        if (!bu.isNullOrNil(paramo.umQ.unP))
        {
          paramIntent = paramString;
          if (!bu.isNullOrNil(paramo.umQ.unQ)) {
            paramIntent = hf(paramString, "hasBubble=1");
          }
        }
      }
      paramString = hf(paramIntent, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!bu.isNullOrNil(paramo.unG)) {}
      try
      {
        str = hf(paramString, "business_data=" + URLEncoder.encode(paramo.unG, "utf-8"));
        AppMethodBeat.o(195643);
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
        paramString = paramIntent;
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
      paramo.dbE();
      if (paramo.une.unK) {
        paramIntent.putExtra("game_transparent_float_url", paramo.une.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.une.url);
    }
    c.x(paramIntent, paramContext);
    AppMethodBeat.o(41438);
  }
  
  public static void a(Intent paramIntent, String paramString1, boolean paramBoolean, o paramo, int paramInt, String paramString2)
  {
    AppMethodBeat.i(195642);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString1);
    paramIntent.putExtra("game_check_float", paramBoolean);
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.dbE();
      if ((paramo.une != null) && (!bu.isNullOrNil(paramo.une.url)))
      {
        paramString1 = new GameFloatLayerInfo();
        paramString1.url = he(paramString2, paramo.une.url);
        paramString1.uea = paramo.une.uea;
        i = -1;
        switch (paramo.une.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString1.orientation = i;
      paramString2 = new GameWebViewLaunchParams();
      paramString2.uec = paramString1;
      paramIntent.putExtra("launchParams", paramString2);
      paramIntent.putExtra("game_float_layer_url", paramo.une.url);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(195642);
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
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
      paramo = r.dbJ();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.dbE();
    ae.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!bu.isNullOrNil(localo.une.url))
    {
      paramo = com.tencent.mm.game.report.f.a("resource", String.valueOf(localo.umO.unR), localo.unF, null);
      com.tencent.mm.game.report.f.a(ak.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.unD, localo.field_gameMsgId, localo.unE, paramo);
      if (paramInt2 != 1) {
        break label188;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().update(localo, new String[0]);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
      r.dbK();
      AppMethodBeat.o(41437);
      return;
      label188:
      if (paramInt2 == 2) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
    o localo = r.dbG();
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
      com.tencent.mm.game.report.f.a(ak.getContext(), 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.e.a.s(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.dbE();
    paramString = com.tencent.mm.game.report.f.a("resource", String.valueOf(localo.umO.unR), localo.unF, localHashMap);
    com.tencent.mm.game.report.f.a(ak.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.unD, localo.field_gameMsgId, localo.unE, paramString);
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
    r.dbH();
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  public static boolean d(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(195641);
    if (paramIntent == null)
    {
      AppMethodBeat.o(195641);
      return false;
    }
    boolean bool4 = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    boolean bool5 = paramIntent.getBooleanExtra("has_game_life_chat_msg", false);
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
    o localo = r.dbF();
    paramIntent.putExtra("from_find_more_friend", true);
    GameTabData2 localGameTabData2 = GameTabData2.dcU();
    if (localGameTabData2 == null)
    {
      AppMethodBeat.o(195641);
      return false;
    }
    Object localObject1 = localGameTabData2.uEZ.entrySet().iterator();
    boolean bool3;
    for (boolean bool1 = true; ((Iterator)localObject1).hasNext(); bool1 = bool3)
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (GameTabData2.TabItem)((Map.Entry)localObject2).getValue();
      bool3 = bool1;
      if (localObject3 != null)
      {
        boolean bool2 = bool1;
        if (!bu.isNullOrNil(((GameTabData2.TabItem)localObject3).jumpUrl))
        {
          ((GameTabData2.TabItem)localObject3).jumpUrl = a(((GameTabData2.TabItem)localObject3).jumpUrl, localo, paramIntent, bool1);
          bool2 = false;
        }
        localGameTabData2.uEZ.a((String)((Map.Entry)localObject2).getKey(), (GameTabData2.TabItem)localObject3);
        bool3 = bool2;
        if (((GameTabData2.TabItem)localObject3).dvm == 1)
        {
          bool3 = bool2;
          if (bool5)
          {
            localGameTabData2.uFa = ((GameTabData2.TabItem)localObject3).upi;
            bool3 = bool2;
          }
        }
      }
    }
    ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
    Object localObject3 = r.dbG();
    if ((localObject3 != null) && (!bool5))
    {
      ((o)localObject3).dbE();
      if ((!bu.isNullOrNil(((o)localObject3).unA.uoe)) && (localGameTabData2.uEZ.containsKey(((o)localObject3).unA.uoe))) {
        localGameTabData2.uFa = ((o)localObject3).unA.uoe;
      }
    }
    localObject1 = paramIntent.getStringExtra("default_game_tab_key");
    if ((!bu.isNullOrNil((String)localObject1)) && (localGameTabData2.uEZ.containsKey(localObject1))) {
      localGameTabData2.uFa = ((String)localObject1);
    }
    localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl();
    Object localObject2 = "select * from GameRawMessage where redDotExpireTime>" + bu.aRi() + " and isRead=0 and isHidden=0 order by redDotExpireTime desc";
    ae.i("MicroMsg.GameMessageStorage", "getTabRedDotMsg sql:%s", new Object[] { localObject2 });
    Cursor localCursor = ((s)localObject1).rawQuery((String)localObject2, new String[0]);
    if (localCursor == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((o)localObject1).dbE();
        paramIntent.putExtra("game_red_dot_tab_key", ((o)localObject1).unA.uof);
        paramIntent.putExtra("game_tab_red_dot_msgid", ((o)localObject1).field_gameMsgId);
      }
      localObject1 = (GameTabData2.TabItem)localGameTabData2.uEZ.get(localGameTabData2.uFa);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(195641);
      return false;
      localObject1 = null;
      if (localCursor.moveToFirst())
      {
        do
        {
          localObject2 = new o();
          ((o)localObject2).convertFrom(localCursor);
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          localObject1 = localObject2;
          if (((o)localObject2).field_msgId != ((o)localObject3).field_msgId) {
            break;
          }
        } while (localCursor.moveToNext());
        localObject1 = localObject2;
      }
      localCursor.close();
    }
    ae.i("MicroMsg.GameEntranceChecker", "defaultKey:%s, tabType:%d, gameTabData:%s", new Object[] { ((GameTabData2.TabItem)localObject1).upi, Integer.valueOf(((GameTabData2.TabItem)localObject1).dvm), localGameTabData2.toJson() });
    if (bool4)
    {
      if (localObject3 != null)
      {
        ((o)localObject3).dbE();
        if (((o)localObject3).unD == 107) {
          paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
        }
      }
      a(paramIntent, "game_center_entrance", true, localo, i, ((GameTabData2.TabItem)localObject1).jumpUrl);
      paramIntent.putExtra("game_tab_data", localGameTabData2);
      paramIntent.putExtra("game_tab_key", localGameTabData2.uFa);
      GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject1, true);
      if (bool5)
      {
        i = paramIntent.getIntExtra("game_life_msg_count", 0);
        paramActivity = new HashMap();
        paramActivity.put("interactive", "20002");
        paramActivity.put("chatmsg_num", String.valueOf(i));
        paramActivity = com.tencent.mm.game.report.f.r(paramActivity);
        com.tencent.mm.game.report.f.a(ak.getContext(), 9, 901, 1, 6, 0, null, 0, 200, null, null, paramActivity);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(195641);
      return true;
      b(7, true, ((GameTabData2.TabItem)localObject1).jumpUrl);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cZk();
      r.dbO();
      continue;
      a(paramIntent, "game_center_entrance", false, localo, i, ((GameTabData2.TabItem)localObject1).jumpUrl);
      paramIntent.putExtra("game_tab_data", localGameTabData2);
      paramIntent.putExtra("game_tab_key", localGameTabData2.uFa);
      GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject1, true);
    }
  }
  
  private static void eh(List paramList)
  {
    AppMethodBeat.i(41442);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    zs localzs = new zs();
    localzs.dQc.dlO = 8;
    localzs.dQc.scene = 1;
    localzs.dQc.dQi = paramList;
    com.tencent.mm.sdk.b.a.IvT.l(localzs);
    AppMethodBeat.o(41442);
  }
  
  private static String he(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41440);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = Uri.parse(paramString1).getQueryParameter("nav_color");
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = hf(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  private static String hf(String paramString1, String paramString2)
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
        ae.printErrStackTrace("MicroMsg.GameEntranceChecker", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(41443);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */