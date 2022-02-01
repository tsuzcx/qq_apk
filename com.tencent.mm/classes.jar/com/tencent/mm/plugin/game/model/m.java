package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.TabItem;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2.a;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2;
import com.tencent.mm.plugin.gamelife.f.b;
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
    AppMethodBeat.i(275416);
    String str = paramString;
    if (paramo != null)
    {
      paramo.fGp();
      if ((paramIntent != null) && (!paramIntent.hasExtra("game_pre_inject_data"))) {
        paramIntent.putExtra("game_pre_inject_data", paramo.IEf.IEq);
      }
      paramIntent = paramString;
      if (!Util.isNullOrNil(paramo.IDI.url))
      {
        if (paramBoolean) {
          ir(paramo.IDI.IEp);
        }
        paramIntent = iO(paramString, "h5FloatLayer=1");
        Log.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { paramIntent });
      }
      paramString = paramIntent;
      if (!Util.isNullOrNil(paramo.IDZ.IEt)) {
        if (paramBoolean) {
          ir(paramo.IDZ.IEp);
        }
      }
    }
    try
    {
      paramString = iO(paramIntent, "h5BannerId=" + com.tencent.mm.compatible.util.r.as(paramo.IDZ.IEt, "UTF-8"));
      Log.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { paramString });
      paramIntent = paramString;
      if (!Util.isNullOrNil(paramo.IDu.mDesc))
      {
        paramIntent = paramString;
        if (!Util.isNullOrNil(paramo.IDu.IEu))
        {
          paramIntent = paramString;
          if (!Util.isNullOrNil(paramo.IDu.IEv)) {
            paramIntent = iO(paramString, "hasBubble=1");
          }
        }
      }
      paramString = iO(paramIntent, "gameMsgId=" + paramo.field_gameMsgId);
      str = paramString;
      if (!Util.isNullOrNil(paramo.IEj)) {}
      try
      {
        str = iO(paramString, "business_data=" + URLEncoder.encode(paramo.IEj, "utf-8"));
        AppMethodBeat.o(275416);
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
      paramo.fGp();
      if (paramo.IDI.egT) {
        paramIntent.putExtra("game_transparent_float_url", paramo.IDI.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramo.IDI.url);
    }
    com.tencent.mm.plugin.game.d.c.v(paramIntent, paramContext);
    AppMethodBeat.o(41438);
  }
  
  public static void a(Intent paramIntent, String paramString1, boolean paramBoolean, o paramo, int paramInt, String paramString2)
  {
    AppMethodBeat.i(275410);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString1);
    paramIntent.putExtra("game_check_float", paramBoolean);
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.fGp();
      if ((paramo.IDI != null) && (!Util.isNullOrNil(paramo.IDI.url)))
      {
        paramString1 = new GameFloatLayerInfo();
        paramString1.url = jc(paramString2, paramo.IDI.url);
        paramString1.ItB = paramo.IDI.ItB;
        i = -1;
        switch (paramo.IDI.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString1.orientation = i;
      paramString2 = new GameWebViewLaunchParams();
      paramString2.ItE = paramString1;
      paramIntent.putExtra("launchParams", paramString2);
      paramIntent.putExtra("game_float_layer_url", paramo.IDI.url);
      a(paramo, paramInt, 1);
      AppMethodBeat.o(275410);
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
      ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg();
      paramo = r.fGu();
      localo = paramo;
      if (paramo == null)
      {
        AppMethodBeat.o(41437);
        return;
      }
    }
    localo.fGp();
    Log.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!Util.isNullOrNil(localo.IDI.url))
    {
      paramo = g.a("resource", String.valueOf(localo.IDs.IEw), localo.IEi, null);
      g.a(MMApplicationContext.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, localo.IEh, localo.field_gameMsgId, localo.mNoticeId, paramo);
      if (paramInt2 != 1) {
        break label187;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().update(localo, new String[0]);
      ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg().fGv();
      AppMethodBeat.o(41437);
      return;
      label187:
      if (paramInt2 == 2) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183858);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg();
    o localo = r.fGr();
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
      g.a(MMApplicationContext.getContext(), 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.c.a.t(localHashMap));
      AppMethodBeat.o(183858);
      return;
    }
    localo.fGp();
    paramString = g.a("resource", String.valueOf(localo.IDs.IEw), localo.IEi, localHashMap);
    g.a(MMApplicationContext.getContext(), 9, 901, 1, paramInt, 0, localo.field_appId, 0, localo.IEh, localo.field_gameMsgId, localo.mNoticeId, paramString);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg();
    r.fGs();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(858L, 3L, 1L, false);
    AppMethodBeat.o(183858);
  }
  
  private static String iO(String paramString1, String paramString2)
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
  
  private static void ir(List paramList)
  {
    AppMethodBeat.i(41442);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(41442);
      return;
    }
    aee localaee = new aee();
    localaee.iiI.hAf = 8;
    localaee.iiI.scene = 1;
    localaee.iiI.iiO = paramList;
    localaee.publish();
    AppMethodBeat.o(41442);
  }
  
  private static String jc(String paramString1, String paramString2)
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
    paramString1 = iO(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(41440);
    return paramString1;
  }
  
  public static boolean s(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(275405);
    if (paramIntent == null)
    {
      AppMethodBeat.o(275405);
      return false;
    }
    boolean bool4 = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    boolean bool5 = paramIntent.getBooleanExtra("has_game_life_chat_msg", false);
    Object localObject1 = null;
    Object localObject4 = localObject1;
    if (bool4)
    {
      localObject4 = localObject1;
      if (!bool5)
      {
        ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg();
        localObject4 = r.fGq();
      }
    }
    paramIntent.putExtra("from_find_more_friend", true);
    GameTabData2 localGameTabData2 = GameTabData2.fHK();
    if (localGameTabData2 == null)
    {
      AppMethodBeat.o(275405);
      return false;
    }
    localObject1 = "";
    boolean bool1 = true;
    Object localObject5 = localGameTabData2.IVW.entrySet().iterator();
    Object localObject6;
    while (((Iterator)localObject5).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject5).next();
      localObject6 = (GameTabData2.TabItem)localEntry.getValue();
      boolean bool3 = bool1;
      localObject3 = localObject1;
      if (localObject6 != null)
      {
        boolean bool2 = bool1;
        if (!Util.isNullOrNil(((GameTabData2.TabItem)localObject6).jumpUrl))
        {
          ((GameTabData2.TabItem)localObject6).jumpUrl = a(((GameTabData2.TabItem)localObject6).jumpUrl, (o)localObject4, paramIntent, bool1);
          bool2 = false;
        }
        localGameTabData2.IVW.a((String)localEntry.getKey(), (GameTabData2.TabItem)localObject6);
        bool3 = bool2;
        localObject3 = localObject1;
        if (((GameTabData2.TabItem)localObject6).hJx == 1)
        {
          localObject1 = ((GameTabData2.TabItem)localObject6).IFL;
          bool3 = bool2;
          localObject3 = localObject1;
          if (bool5)
          {
            localGameTabData2.IVX = ((GameTabData2.TabItem)localObject6).IFL;
            localObject3 = localObject1;
            bool3 = bool2;
          }
        }
      }
      bool1 = bool3;
      localObject1 = localObject3;
    }
    if ((bool4) && (!bool5)) {
      ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg();
    }
    for (Object localObject3 = r.fGr();; localObject3 = null)
    {
      if ((localObject3 != null) && (!bool5))
      {
        ((o)localObject3).fGp();
        if ((!Util.isNullOrNil(((o)localObject3).IEe.IEI)) && (localGameTabData2.IVW.containsKey(((o)localObject3).IEe.IEI))) {
          localGameTabData2.IVX = ((o)localObject3).IEe.IEI;
        }
      }
      if (localObject3 != null)
      {
        ((o)localObject3).fGp();
        paramIntent.putExtra("game_tab_entrance_msgid", ((o)localObject3).field_gameMsgId);
        paramIntent.putExtra("game_msg_top_chatroom_name", ((o)localObject3).IEd.IEs.IEn);
      }
      localObject5 = paramIntent.getStringExtra("default_game_tab_key");
      if ((!Util.isNullOrNil((String)localObject5)) && (localGameTabData2.IVW.containsKey(localObject5))) {
        localGameTabData2.IVX = ((String)localObject5);
      }
      if ((paramIntent.getBooleanExtra("default_game_tab_chat_type", false)) && (!Util.isNullOrNil((String)localObject1))) {
        localGameTabData2.IVX = ((String)localObject1);
      }
      localObject1 = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh();
      localObject5 = "select * from GameRawMessage where redDotExpireTime>" + Util.nowSecond() + " and isRead=0 and isHidden=0 order by redDotExpireTime desc";
      Log.i("MicroMsg.GameMessageStorage", "getTabRedDotMsg sql:%s", new Object[] { localObject5 });
      localObject6 = ((s)localObject1).rawQuery((String)localObject5, new String[0]);
      if (localObject6 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((o)localObject1).fGp();
          paramIntent.putExtra("game_red_dot_tab_key", ((o)localObject1).IEe.IEJ);
          paramIntent.putExtra("game_tab_red_dot_msgid", ((o)localObject1).field_gameMsgId);
        }
        localObject5 = (GameTabData2.TabItem)localGameTabData2.IVW.get(localGameTabData2.IVX);
        if (localObject5 != null) {
          break;
        }
        AppMethodBeat.o(275405);
        return false;
        localObject1 = null;
        if (((Cursor)localObject6).moveToFirst())
        {
          do
          {
            localObject5 = new o();
            ((o)localObject5).convertFrom((Cursor)localObject6);
            localObject1 = localObject5;
            if (localObject3 == null) {
              break;
            }
            localObject1 = localObject5;
            if (((o)localObject5).field_msgId != ((o)localObject3).field_msgId) {
              break;
            }
          } while (((Cursor)localObject6).moveToNext());
          localObject1 = localObject5;
        }
        ((Cursor)localObject6).close();
      }
      Log.i("MicroMsg.GameEntranceChecker", "defaultKey:%s, tabType:%d, gameTabData:%s", new Object[] { ((GameTabData2.TabItem)localObject5).IFL, Integer.valueOf(((GameTabData2.TabItem)localObject5).hJx), localGameTabData2.toJson() });
      if (bool4)
      {
        if (localObject3 == null) {
          break label1151;
        }
        ((o)localObject3).fGp();
        if (((o)localObject3).IEh == 107) {
          paramIntent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
        }
      }
      label1012:
      label1151:
      Object localObject2;
      for (localObject1 = ((o)localObject3).IEd.IEs.IEo;; localObject2 = null)
      {
        a(paramIntent, "game_center_entrance", true, (o)localObject4, i, ((GameTabData2.TabItem)localObject5).jumpUrl);
        paramIntent.putExtra("game_tab_data", localGameTabData2);
        paramIntent.putExtra("game_tab_key", localGameTabData2.IVX);
        int j;
        if (!Util.isNullOrNil((String)localObject1))
        {
          ((com.tencent.mm.plugin.game.chatroom.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoomFromFind(paramActivity, (String)localObject1, "", i, 0L);
          if (!bool5) {
            break label1067;
          }
          j = paramIntent.getIntExtra("game_life_msg_count", 0);
          i = 200;
          paramActivity = new JSONObject();
          paramIntent = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIj();
          if (paramIntent != null) {
            break label1012;
          }
        }
        for (;;)
        {
          try
          {
            paramActivity.put("interactive", "20002");
            paramActivity.put("chatmsg_num", String.valueOf(j));
            paramActivity = g.a(null, null, paramActivity.toString(), null);
            g.a(MMApplicationContext.getContext(), 9, 901, 1, 6, 0, null, 0, i, null, null, paramActivity);
            AppMethodBeat.o(275405);
            return true;
            GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject5, true);
          }
          catch (JSONException paramIntent)
          {
            continue;
          }
          i = paramIntent.msgType;
          try
          {
            paramIntent = new JSONObject(paramIntent.ICw);
            try
            {
              paramIntent.put("chatmsg_num", String.valueOf(j));
              paramActivity = paramIntent;
            }
            catch (JSONException localJSONException1)
            {
              paramActivity = paramIntent;
            }
          }
          catch (JSONException localJSONException2)
          {
            label1050:
            break label1050;
          }
          Log.printErrStackTrace("MicroMsg.GameEntranceChecker", localJSONException1, "", new Object[0]);
          continue;
          label1067:
          b(7, true, ((GameTabData2.TabItem)localObject5).jumpUrl);
          ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg().fGz();
          continue;
          a(paramIntent, "game_center_entrance", false, (o)localObject4, i, ((GameTabData2.TabItem)localObject5).jumpUrl);
          paramIntent.putExtra("game_tab_data", localGameTabData2);
          paramIntent.putExtra("game_tab_key", localGameTabData2.IVX);
          GameTabWidget2.a(paramActivity, (GameTabData2.TabItem)localObject5, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */