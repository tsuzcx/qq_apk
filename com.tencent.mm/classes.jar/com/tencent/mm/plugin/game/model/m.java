package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.a;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2;
import com.tencent.mm.plugin.gamelife.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public static String a(String paramString, o paramo, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(204162);
    String str = paramString;
    if (paramo != null)
    {
      paramo.dVl();
      if ((paramIntent != null) && (!paramIntent.hasExtra("game_pre_inject_data"))) {
        paramIntent.putExtra("game_pre_inject_data", paramo.xFT.xGd);
      }
      paramIntent = paramString;
      if (!Util.isNullOrNil(paramo.xFw.url))
      {
        if (paramBoolean) {
          fa(paramo.xFw.xGc);
        }
        paramIntent = hM(paramString, "h5FloatLayer=1");
        Log.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { paramIntent });
      }
      paramString = paramIntent;
      if (!Util.isNullOrNil(paramo.xFN.xGf)) {
        if (paramBoolean) {
          fa(paramo.xFN.xGc);
        }
      }
    }
    try
    {
      paramString = hM(paramIntent, "h5BannerId=" + q.encode(paramo.xFN.xGf, "UTF-8"));
      Log.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      paramIntent = paramString;
      if (!Util.isNullOrNil(paramo.xFi.mDesc))
      {
        paramIntent = paramString;
        if (!Util.isNullOrNil(paramo.xFi.xGg))
        {
          paramIntent = paramString;
          if (!Util.isNullOrNil(paramo.xFi.xGh)) {
            paramIntent = hM(paramString, "hasBubble=1");
          }
        }
      }
      paramString = hM(paramIntent, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!Util.isNullOrNil(paramo.xFY)) {}
      try
      {
        str = hM(paramString, "business_data=" + URLEncoder.encode(paramo.xFY, "utf-8"));
        AppMethodBeat.o(204162);
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
      paramo.dVl();
      if (paramo.xFw.crp) {
        paramIntent.putExtra("game_transparent_float_url", paramo.xFw.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.xFw.url);
    }
    com.tencent.mm.plugin.game.e.c.w(paramIntent, paramContext);
    AppMethodBeat.o(41438);
  }
  
  public static void a(Intent paramIntent, String paramString1, boolean paramBoolean, o paramo, int paramInt, String paramString2)
  {
    AppMethodBeat.i(204161);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString1);
    paramIntent.putExtra("game_check_float", paramBoolean);
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.dVl();
      if ((paramo.xFw != null) && (!Util.isNullOrNil(paramo.xFw.url)))
      {
        paramString1 = new GameFloatLayerInfo();
        paramString1.url = hL(paramString2, paramo.xFw.url);
        paramString1.xvW = paramo.xFw.xvW;
        i = -1;
        switch (paramo.xFw.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString1.orientation = i;
      paramString2 = new GameWebViewLaunchParams();
      paramString2.xvZ = paramString1;
      paramIntent.putExtra("launchParams", paramString2);
      paramIntent.putExtra("game_float_layer_url", paramo.xFw.url);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(204161);
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
      ((e)g.af(e.class)).dSJ();
      paramo = r.dVq();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.dVl();
    Log.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!Util.isNullOrNil(localo.xFw.url))
    {
      paramo = com.tencent.mm.game.report.f.a("resource", String.valueOf(localo.xFg.xGi), localo.xFX, null);
      com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.xFV, localo.field_gameMsgId, localo.xFW, paramo);
      if (paramInt2 != 1) {
        break label188;
      }
      h.CyF.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(localo, new String[0]);
      ((e)g.af(e.class)).dSJ();
      r.dVr();
      AppMethodBeat.o(41437);
      return;
      label188:
      if (paramInt2 == 2) {
        h.CyF.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((e)g.af(e.class)).dSJ();
    o localo = r.dVn();
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
      com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, paramInt, 0, a.u(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.dVl();
    paramString = com.tencent.mm.game.report.f.a("resource", String.valueOf(localo.xFg.xGi), localo.xFX, localHashMap);
    com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.xFV, localo.field_gameMsgId, localo.xFW, paramString);
    ((e)g.af(e.class)).dSJ();
    r.dVo();
    h.CyF.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  private static void fa(List paramList)
  {
    AppMethodBeat.i(41442);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    aaz localaaz = new aaz();
    localaaz.eif.dDe = 8;
    localaaz.eif.scene = 1;
    localaaz.eif.eil = paramList;
    EventCenter.instance.publish(localaaz);
    AppMethodBeat.o(41442);
  }
  
  private static String hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41440);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = Uri.parse(paramString1).getQueryParameter("nav_color");
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41440);
      return paramString2;
    }
    paramString1 = hM(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  private static String hM(String paramString1, String paramString2)
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
        Log.printErrStackTrace("MicroMsg.GameEntranceChecker", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(41443);
      return paramString1;
    }
  }
  
  public static boolean i(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(204160);
    if (paramIntent == null)
    {
      AppMethodBeat.o(204160);
      return false;
    }
    boolean bool4 = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    boolean bool5 = paramIntent.getBooleanExtra("has_game_life_chat_msg", false);
    ((e)g.af(e.class)).dSJ();
    o localo = r.dVm();
    paramIntent.putExtra("from_find_more_friend", true);
    GameTabData2 localGameTabData2 = GameTabData2.dWB();
    if (localGameTabData2 == null)
    {
      AppMethodBeat.o(204160);
      return false;
    }
    Object localObject1 = localGameTabData2.xWX.entrySet().iterator();
    boolean bool3;
    for (boolean bool1 = true; ((Iterator)localObject1).hasNext(); bool1 = bool3)
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (GameTabData2.TabItem)((Map.Entry)localObject2).getValue();
      bool3 = bool1;
      if (localObject3 != null)
      {
        boolean bool2 = bool1;
        if (!Util.isNullOrNil(((GameTabData2.TabItem)localObject3).jumpUrl))
        {
          ((GameTabData2.TabItem)localObject3).jumpUrl = a(((GameTabData2.TabItem)localObject3).jumpUrl, localo, paramIntent, bool1);
          bool2 = false;
        }
        localGameTabData2.xWX.a((String)((Map.Entry)localObject2).getKey(), (GameTabData2.TabItem)localObject3);
        bool3 = bool2;
        if (((GameTabData2.TabItem)localObject3).dLS == 1)
        {
          bool3 = bool2;
          if (bool5)
          {
            localGameTabData2.xWY = ((GameTabData2.TabItem)localObject3).xHB;
            bool3 = bool2;
          }
        }
      }
    }
    ((e)g.af(e.class)).dSJ();
    Object localObject3 = r.dVn();
    if ((localObject3 != null) && (!bool5))
    {
      ((o)localObject3).dVl();
      if ((!Util.isNullOrNil(((o)localObject3).xFS.xGv)) && (localGameTabData2.xWX.containsKey(((o)localObject3).xFS.xGv))) {
        localGameTabData2.xWY = ((o)localObject3).xFS.xGv;
      }
    }
    localObject1 = paramIntent.getStringExtra("default_game_tab_key");
    if ((!Util.isNullOrNil((String)localObject1)) && (localGameTabData2.xWX.containsKey(localObject1))) {
      localGameTabData2.xWY = ((String)localObject1);
    }
    localObject1 = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK();
    Object localObject2 = "select * from GameRawMessage where redDotExpireTime>" + Util.nowSecond() + " and isRead=0 and isHidden=0 order by redDotExpireTime desc";
    Log.i("MicroMsg.GameMessageStorage", "getTabRedDotMsg sql:%s", new Object[] { localObject2 });
    Cursor localCursor = ((s)localObject1).rawQuery((String)localObject2, new String[0]);
    if (localCursor == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((o)localObject1).dVl();
        paramIntent.putExtra("game_red_dot_tab_key", ((o)localObject1).xFS.xGw);
        paramIntent.putExtra("game_tab_red_dot_msgid", ((o)localObject1).field_gameMsgId);
      }
      localObject1 = (GameTabData2.TabItem)localGameTabData2.xWX.get(localGameTabData2.xWY);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(204160);
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
    Log.i("MicroMsg.GameEntranceChecker", "defaultKey:%s, tabType:%d, gameTabData:%s", new Object[] { ((GameTabData2.TabItem)localObject1).xHB, Integer.valueOf(((GameTabData2.TabItem)localObject1).dLS), localGameTabData2.toJson() });
    int j;
    if (bool4)
    {
      if (localObject3 != null)
      {
        ((o)localObject3).dVl();
        if (((o)localObject3).xFV == 107) {
          paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
        }
      }
      a(paramIntent, "game_center_entrance", true, localo, i, ((GameTabData2.TabItem)localObject1).jumpUrl);
      paramIntent.putExtra("game_tab_data", localGameTabData2);
      paramIntent.putExtra("game_tab_key", localGameTabData2.xWY);
      GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject1, true);
      if (bool5)
      {
        i = paramIntent.getIntExtra("game_life_msg_count", 0);
        paramIntent = new JSONObject();
        paramActivity = ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXa();
        j = paramActivity.msgType;
      }
    }
    for (;;)
    {
      try
      {
        paramActivity = new JSONObject(paramActivity.xEl);
        Log.printErrStackTrace("MicroMsg.GameEntranceChecker", paramIntent, "", new Object[0]);
      }
      catch (JSONException localJSONException)
      {
        try
        {
          paramActivity.put("chatmsg_num", String.valueOf(i));
          paramActivity = com.tencent.mm.game.report.f.a(null, null, paramActivity.toString(), null);
          com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 9, 901, 1, 6, 0, null, 0, j, null, null, paramActivity);
          AppMethodBeat.o(204160);
          return true;
        }
        catch (JSONException paramIntent)
        {
          break label835;
        }
        localJSONException = localJSONException;
        paramActivity = paramIntent;
        paramIntent = localJSONException;
      }
      label835:
      continue;
      b(7, true, localJSONException.jumpUrl);
      ((e)g.af(e.class)).dSJ();
      r.dVv();
      continue;
      a(paramIntent, "game_center_entrance", false, localo, i, localJSONException.jumpUrl);
      paramIntent.putExtra("game_tab_data", localGameTabData2);
      paramIntent.putExtra("game_tab_key", localGameTabData2.xWY);
      GameTabWidget2.a(paramActivity, localJSONException, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */