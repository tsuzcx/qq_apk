package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.a.ach;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.c.a;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.a;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2;
import com.tencent.mm.plugin.gamelife.e.b;
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
    AppMethodBeat.i(198939);
    String str = paramString;
    if (paramo != null)
    {
      paramo.eyt();
      if ((paramIntent != null) && (!paramIntent.hasExtra("game_pre_inject_data"))) {
        paramIntent.putExtra("game_pre_inject_data", paramo.CJU.CKf);
      }
      paramIntent = paramString;
      if (!Util.isNullOrNil(paramo.CJx.url))
      {
        if (paramBoolean) {
          fv(paramo.CJx.CKe);
        }
        paramIntent = hV(paramString, "h5FloatLayer=1");
        Log.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { paramIntent });
      }
      paramString = paramIntent;
      if (!Util.isNullOrNil(paramo.CJO.CKi)) {
        if (paramBoolean) {
          fv(paramo.CJO.CKe);
        }
      }
    }
    try
    {
      paramString = hV(paramIntent, "h5BannerId=" + q.an(paramo.CJO.CKi, "UTF-8"));
      Log.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      paramIntent = paramString;
      if (!Util.isNullOrNil(paramo.CJj.mDesc))
      {
        paramIntent = paramString;
        if (!Util.isNullOrNil(paramo.CJj.CKj))
        {
          paramIntent = paramString;
          if (!Util.isNullOrNil(paramo.CJj.CKk)) {
            paramIntent = hV(paramString, "hasBubble=1");
          }
        }
      }
      paramString = hV(paramIntent, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!Util.isNullOrNil(paramo.CJZ)) {}
      try
      {
        str = hV(paramString, "business_data=" + URLEncoder.encode(paramo.CJZ, "utf-8"));
        AppMethodBeat.o(198939);
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
      paramo.eyt();
      if (paramo.CJx.cpf) {
        paramIntent.putExtra("game_transparent_float_url", paramo.CJx.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.CJx.url);
    }
    com.tencent.mm.plugin.game.d.c.v(paramIntent, paramContext);
    AppMethodBeat.o(41438);
  }
  
  public static void a(Intent paramIntent, String paramString1, boolean paramBoolean, o paramo, int paramInt, String paramString2)
  {
    AppMethodBeat.i(198929);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString1);
    paramIntent.putExtra("game_check_float", paramBoolean);
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.eyt();
      if ((paramo.CJx != null) && (!Util.isNullOrNil(paramo.CJx.url)))
      {
        paramString1 = new GameFloatLayerInfo();
        paramString1.url = hU(paramString2, paramo.CJx.url);
        paramString1.CzQ = paramo.CJx.CzQ;
        i = -1;
        switch (paramo.CJx.FO)
        {
        }
      }
    }
    for (;;)
    {
      paramString1.FO = i;
      paramString2 = new GameWebViewLaunchParams();
      paramString2.CzT = paramString1;
      paramIntent.putExtra("launchParams", paramString2);
      paramIntent.putExtra("game_float_layer_url", paramo.CJx.url);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(198929);
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
      ((e)com.tencent.mm.kernel.h.ae(e.class)).evn();
      paramo = r.eyy();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.eyt();
    Log.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!Util.isNullOrNil(localo.CJx.url))
    {
      paramo = g.a("resource", String.valueOf(localo.CJh.CKl), localo.CJY, null);
      g.a(MMApplicationContext.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.CJW, localo.field_gameMsgId, localo.CJX, paramo);
      if (paramInt2 != 1) {
        break label187;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().update(localo, new String[0]);
      ((e)com.tencent.mm.kernel.h.ae(e.class)).evn().eyz();
      AppMethodBeat.o(41437);
      return;
      label187:
      if (paramInt2 == 2) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).evn();
    o localo = r.eyv();
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
      g.a(MMApplicationContext.getContext(), 9, 901, 1, paramInt, 0, a.m(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.eyt();
    paramString = g.a("resource", String.valueOf(localo.CJh.CKl), localo.CJY, localHashMap);
    g.a(MMApplicationContext.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.CJW, localo.field_gameMsgId, localo.CJX, paramString);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).evn();
    r.eyw();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  private static void fv(List paramList)
  {
    AppMethodBeat.i(41442);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    ach localach = new ach();
    localach.gcw.fvK = 8;
    localach.gcw.scene = 1;
    localach.gcw.gcC = paramList;
    EventCenter.instance.publish(localach);
    AppMethodBeat.o(41442);
  }
  
  private static String hU(String paramString1, String paramString2)
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
    paramString1 = hV(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  private static String hV(String paramString1, String paramString2)
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
  
  public static boolean l(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(198912);
    if (paramIntent == null)
    {
      AppMethodBeat.o(198912);
      return false;
    }
    boolean bool4 = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    boolean bool5 = paramIntent.getBooleanExtra("has_game_life_chat_msg", false);
    Object localObject1 = null;
    Object localObject3 = localObject1;
    if (bool4)
    {
      localObject3 = localObject1;
      if (!bool5)
      {
        ((e)com.tencent.mm.kernel.h.ae(e.class)).evn();
        localObject3 = r.eyu();
      }
    }
    paramIntent.putExtra("from_find_more_friend", true);
    GameTabData2 localGameTabData2 = GameTabData2.ezJ();
    if (localGameTabData2 == null)
    {
      AppMethodBeat.o(198912);
      return false;
    }
    localObject1 = "";
    boolean bool1 = true;
    Object localObject4 = localGameTabData2.DbC.entrySet().iterator();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
      localObject5 = (GameTabData2.TabItem)localEntry.getValue();
      boolean bool3 = bool1;
      localObject2 = localObject1;
      if (localObject5 != null)
      {
        boolean bool2 = bool1;
        if (!Util.isNullOrNil(((GameTabData2.TabItem)localObject5).jumpUrl))
        {
          ((GameTabData2.TabItem)localObject5).jumpUrl = a(((GameTabData2.TabItem)localObject5).jumpUrl, (o)localObject3, paramIntent, bool1);
          bool2 = false;
        }
        localGameTabData2.DbC.a((String)localEntry.getKey(), (GameTabData2.TabItem)localObject5);
        bool3 = bool2;
        localObject2 = localObject1;
        if (((GameTabData2.TabItem)localObject5).fEH == 1)
        {
          localObject1 = ((GameTabData2.TabItem)localObject5).CLE;
          bool3 = bool2;
          localObject2 = localObject1;
          if (bool5)
          {
            localGameTabData2.DbD = ((GameTabData2.TabItem)localObject5).CLE;
            localObject2 = localObject1;
            bool3 = bool2;
          }
        }
      }
      bool1 = bool3;
      localObject1 = localObject2;
    }
    if ((bool4) && (!bool5)) {
      ((e)com.tencent.mm.kernel.h.ae(e.class)).evn();
    }
    for (Object localObject2 = r.eyv();; localObject2 = null)
    {
      if ((localObject2 != null) && (!bool5))
      {
        ((o)localObject2).eyt();
        if ((!Util.isNullOrNil(((o)localObject2).CJT.CKy)) && (localGameTabData2.DbC.containsKey(((o)localObject2).CJT.CKy))) {
          localGameTabData2.DbD = ((o)localObject2).CJT.CKy;
        }
      }
      if (localObject2 != null) {
        paramIntent.putExtra("game_tab_entrance_msgid", ((o)localObject2).field_gameMsgId);
      }
      localObject4 = paramIntent.getStringExtra("default_game_tab_key");
      if ((!Util.isNullOrNil((String)localObject4)) && (localGameTabData2.DbC.containsKey(localObject4))) {
        localGameTabData2.DbD = ((String)localObject4);
      }
      if ((paramIntent.getBooleanExtra("default_game_tab_chat_type", false)) && (!Util.isNullOrNil((String)localObject1))) {
        localGameTabData2.DbD = ((String)localObject1);
      }
      localObject1 = ((f)com.tencent.mm.kernel.h.ae(f.class)).evo();
      localObject4 = "select * from GameRawMessage where redDotExpireTime>" + Util.nowSecond() + " and isRead=0 and isHidden=0 order by redDotExpireTime desc";
      Log.i("MicroMsg.GameMessageStorage", "getTabRedDotMsg sql:%s", new Object[] { localObject4 });
      localObject5 = ((s)localObject1).rawQuery((String)localObject4, new String[0]);
      if (localObject5 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((o)localObject1).eyt();
          paramIntent.putExtra("game_red_dot_tab_key", ((o)localObject1).CJT.CKz);
          paramIntent.putExtra("game_tab_red_dot_msgid", ((o)localObject1).field_gameMsgId);
        }
        localObject1 = (GameTabData2.TabItem)localGameTabData2.DbC.get(localGameTabData2.DbD);
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(198912);
        return false;
        localObject1 = null;
        if (((Cursor)localObject5).moveToFirst())
        {
          do
          {
            localObject4 = new o();
            ((o)localObject4).convertFrom((Cursor)localObject5);
            localObject1 = localObject4;
            if (localObject2 == null) {
              break;
            }
            localObject1 = localObject4;
            if (((o)localObject4).field_msgId != ((o)localObject2).field_msgId) {
              break;
            }
          } while (((Cursor)localObject5).moveToNext());
          localObject1 = localObject4;
        }
        ((Cursor)localObject5).close();
      }
      Log.i("MicroMsg.GameEntranceChecker", "defaultKey:%s, tabType:%d, gameTabData:%s", new Object[] { ((GameTabData2.TabItem)localObject1).CLE, Integer.valueOf(((GameTabData2.TabItem)localObject1).fEH), localGameTabData2.toJson() });
      int j;
      if (bool4)
      {
        if (localObject2 != null)
        {
          ((o)localObject2).eyt();
          if (((o)localObject2).CJW == 107) {
            paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
          }
        }
        a(paramIntent, "game_center_entrance", true, (o)localObject3, i, ((GameTabData2.TabItem)localObject1).jumpUrl);
        paramIntent.putExtra("game_tab_data", localGameTabData2);
        paramIntent.putExtra("game_tab_key", localGameTabData2.DbD);
        GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject1, true);
        if (bool5)
        {
          i = paramIntent.getIntExtra("game_life_msg_count", 0);
          paramIntent = new JSONObject();
          paramActivity = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).eAj();
          j = paramActivity.msgType;
        }
      }
      for (;;)
      {
        try
        {
          paramActivity = new JSONObject(paramActivity.CIm);
          Log.printErrStackTrace("MicroMsg.GameEntranceChecker", paramIntent, "", new Object[0]);
        }
        catch (JSONException localJSONException)
        {
          try
          {
            paramActivity.put("chatmsg_num", String.valueOf(i));
            paramActivity = g.a(null, null, paramActivity.toString(), null);
            g.a(MMApplicationContext.getContext(), 9, 901, 1, 6, 0, null, 0, j, null, null, paramActivity);
            AppMethodBeat.o(198912);
            return true;
          }
          catch (JSONException paramIntent)
          {
            break label942;
          }
          localJSONException = localJSONException;
          paramActivity = paramIntent;
          paramIntent = localJSONException;
        }
        label942:
        continue;
        b(7, true, localJSONException.jumpUrl);
        ((e)com.tencent.mm.kernel.h.ae(e.class)).evn().eyD();
        continue;
        a(paramIntent, "game_center_entrance", false, (o)localObject3, i, localJSONException.jumpUrl);
        paramIntent.putExtra("game_tab_data", localGameTabData2);
        paramIntent.putExtra("game_tab_key", localGameTabData2.DbD);
        GameTabWidget2.a(paramActivity, localJSONException, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */