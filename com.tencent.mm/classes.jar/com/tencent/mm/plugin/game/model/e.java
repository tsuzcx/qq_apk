package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static String umb = "";
  
  public static void Ij(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(183850);
    String str1 = String.valueOf(paramInt);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("game_center_pref", 0);
    String str2 = dbx();
    Object localObject = str1;
    if (!bu.isNullOrNil(str2))
    {
      localObject = str2.split(",");
      int j = localObject.length;
      paramInt = i;
      while (paramInt < j)
      {
        if (localObject[paramInt].equals(str1))
        {
          AppMethodBeat.o(183850);
          return;
        }
        paramInt += 1;
      }
      localObject = str2 + "," + str1;
    }
    localSharedPreferences.edit().putString("game_ban_msg_type_array", (String)localObject).apply();
    AppMethodBeat.o(183850);
  }
  
  public static void Ik(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(183851);
    Object localObject = dbx();
    if (!bu.isNullOrNil((String)localObject))
    {
      SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("game_center_pref", 0);
      localObject = ((String)localObject).split(",");
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      while (i < j)
      {
        String str = localObject[i];
        if (!str.equals(String.valueOf(paramInt))) {
          localStringBuilder.append(str).append(",");
        }
        i += 1;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localObject = localStringBuilder.toString();
      localSharedPreferences.edit().putString("game_ban_msg_type_array", (String)localObject).apply();
    }
    AppMethodBeat.o(183851);
  }
  
  public static boolean Il(int paramInt)
  {
    AppMethodBeat.i(183853);
    Object localObject = dbx();
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(String.valueOf(paramInt)))
        {
          AppMethodBeat.o(183853);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(183853);
    return false;
  }
  
  public static String a(GameRegionPreference.a parama)
  {
    AppMethodBeat.i(41367);
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (parama != null)
    {
      str = bu.nullAsNil(ad.fom());
      if (!"zh_CN".equalsIgnoreCase(str)) {
        break label54;
      }
      localStringBuffer.append(parama.uDG);
    }
    for (;;)
    {
      parama = localStringBuffer.toString();
      AppMethodBeat.o(41367);
      return parama;
      label54:
      if (("zh_TW".equalsIgnoreCase(str)) || ("zh_HK".equalsIgnoreCase(str))) {
        localStringBuffer.append(parama.uDH);
      } else {
        localStringBuffer.append(parama.uDI);
      }
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString1, String paramString2, al paramal)
  {
    AppMethodBeat.i(41364);
    if ((paramg == null) || (bu.isNullOrNil(paramg.field_appId)))
    {
      ae.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(41364);
      return;
    }
    if (!q.b(paramContext, paramg))
    {
      ae.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", new Object[] { paramg.field_appName });
      Toast.makeText(paramContext, paramContext.getString(2131759894, new Object[] { h.a(paramContext, paramg, null) }), 1).show();
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(41364);
      return;
    }
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 637928960;
    localWXMediaMessage.messageAction = paramString1;
    localWXMediaMessage.messageExt = paramString2;
    ae.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramg.field_appId, paramg.field_appName, paramg.field_openId });
    if (bu.isNullOrNil(paramg.field_openId))
    {
      ae.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", new Object[] { paramg.field_appName });
      com.tencent.mm.plugin.s.a.dBi().EL(paramg.field_appId);
    }
    com.tencent.mm.ch.a.post(new e.2(paramContext, paramg, localWXMediaMessage, paramal));
    AppMethodBeat.o(41364);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, al paramal)
  {
    AppMethodBeat.i(41363);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.GameCenterLogic", "null or nil appid");
      if (paramal != null) {
        paramal.v(false, false);
      }
    }
    a(paramContext, h.m(paramString1, true, false), paramString2, paramString3, paramal);
    AppMethodBeat.o(41363);
  }
  
  public static void a(Context paramContext, Set<String> paramSet)
  {
    AppMethodBeat.i(41383);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", paramSet).commit();
    AppMethodBeat.o(41383);
  }
  
  public static void aa(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(41388);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", paramInt).apply();
    AppMethodBeat.o(41388);
  }
  
  public static void ak(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41362);
    a(paramContext, paramString, null, "WX_GameCenter", new e.1(paramString));
    AppMethodBeat.o(41362);
  }
  
  private static String amR(String paramString)
  {
    AppMethodBeat.i(41371);
    Object localObject3 = null;
    label75:
    String str2;
    for (Object localObject1 = null;; str2 = "")
    {
      try
      {
        localInputStream = ak.getContext().getAssets().open("game_region_default.txt");
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        localObject4 = new byte[localInputStream.available()];
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        localInputStream.read((byte[])localObject4);
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        localObject4 = new String((byte[])localObject4);
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (IOException localIOException4)
      {
        for (;;)
        {
          InputStream localInputStream;
          Object localObject4;
          Object localObject2;
          localObject3 = localObject2;
          ae.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bu.o(localIOException4) });
          if (localObject2 == null) {
            break;
          }
          try
          {
            ((InputStream)localObject2).close();
            localObject2 = "";
          }
          catch (IOException localIOException2)
          {
            ae.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bu.o(localIOException2) });
            String str1 = "";
          }
        }
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject3).close();
          AppMethodBeat.o(41371);
          throw paramString;
        }
        catch (IOException localIOException3)
        {
          ae.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bu.o(localIOException3) });
          continue;
        }
        if (!"zh_CN".equalsIgnoreCase(paramString)) {
          continue;
        }
        paramString = localObject3[0];
        AppMethodBeat.o(41371);
        return paramString;
        if ((!"zh_TW".equalsIgnoreCase(paramString)) && (!"zh_HK".equalsIgnoreCase(paramString))) {
          continue;
        }
        paramString = localObject3[1];
        AppMethodBeat.o(41371);
        return paramString;
        paramString = localObject3[2];
        AppMethodBeat.o(41371);
        return paramString;
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (IOException localIOException1)
      {
        ae.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bu.o(localIOException1) });
        localObject2 = localObject4;
        break label75;
      }
      localObject3 = localObject1.trim().split("\\|");
      if (localObject3.length < 3)
      {
        ae.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", new Object[] { localObject1 });
        AppMethodBeat.o(41371);
        return "";
      }
    }
  }
  
  public static void ax(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(41377);
    String str2 = String.valueOf(System.currentTimeMillis() / 1000L);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("game_center_pref", 0);
    Object localObject = localSharedPreferences.getString("download_app_id_time_map", "");
    if (bu.isNullOrNil((String)localObject))
    {
      paramContext = paramString + "-" + str2;
      localSharedPreferences.edit().putString("download_app_id_time_map", paramContext).commit();
      AppMethodBeat.o(41377);
      return;
    }
    if (((String)localObject).contains(paramString))
    {
      paramContext = new String();
      String[] arrayOfString = ((String)localObject).split(",");
      if (i < arrayOfString.length)
      {
        String str1 = arrayOfString[i];
        localObject = str1;
        if (str1.contains(paramString)) {
          localObject = paramString + "-" + str2;
        }
        if (i == arrayOfString.length - 1) {}
        for (paramContext = paramContext + (String)localObject;; paramContext = paramContext + (String)localObject + ",")
        {
          i += 1;
          break;
        }
      }
      localSharedPreferences.edit().putString("download_app_id_time_map", paramContext).apply();
      AppMethodBeat.o(41377);
      return;
    }
    paramContext = (String)localObject + "," + paramString + "-" + str2;
    localSharedPreferences.edit().putString("download_app_id_time_map", paramContext).apply();
    AppMethodBeat.o(41377);
  }
  
  public static void ay(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(41378);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("game_center_pref", 0);
    paramContext = localSharedPreferences.getString("download_app_id_time_map", "");
    if (bu.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(41378);
      return;
    }
    if (paramContext.contains(paramString))
    {
      Object localObject = new String();
      String[] arrayOfString = paramContext.split(",");
      if (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        paramContext = (Context)localObject;
        if (!str.contains(paramString)) {
          if (i != arrayOfString.length - 1) {
            break label130;
          }
        }
        label130:
        for (paramContext = (String)localObject + str;; paramContext = (String)localObject + str + ",")
        {
          i += 1;
          localObject = paramContext;
          break;
        }
      }
      localSharedPreferences.edit().putString("download_app_id_time_map", (String)localObject).apply();
    }
    AppMethodBeat.o(41378);
  }
  
  public static void az(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41392);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", paramString).commit();
    AppMethodBeat.o(41392);
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> dbj()
  {
    AppMethodBeat.i(41360);
    ae.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
    LinkedList localLinkedList1 = new LinkedList();
    localLinkedList1.addAll(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().ulB);
    LinkedList localLinkedList2 = new LinkedList();
    Iterator localIterator = localLinkedList1.iterator();
    label162:
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.model.app.g localg = (com.tencent.mm.pluginsdk.model.app.g)localIterator.next();
      if (localg != null)
      {
        ae.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", new Object[] { localg.field_appId, Integer.valueOf(localg.field_appInfoFlag) });
        if ((localg.field_appInfoFlag & 0x4) <= 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label162;
        }
        ae.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[] { localg.field_appName });
        localLinkedList2.add(localg);
        break;
      }
    }
    if (localLinkedList2.size() > 0) {
      localLinkedList1.removeAll(localLinkedList2);
    }
    AppMethodBeat.o(41360);
    return localLinkedList1;
  }
  
  public static LinkedList<String> dbk()
  {
    AppMethodBeat.i(41361);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().ulA);
    AppMethodBeat.o(41361);
    return localLinkedList;
  }
  
  public static String dbl()
  {
    AppMethodBeat.i(41365);
    String str2 = bu.jm(ak.getContext());
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = "CN";
    }
    str1 = str1.toUpperCase();
    AppMethodBeat.o(41365);
    return str1;
  }
  
  public static String dbm()
  {
    AppMethodBeat.i(41368);
    Object localObject = dbl();
    localObject = (GameRegionPreference.a)a.a.dde().ddd().get(localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localObject != null)
    {
      localStringBuffer.append(((GameRegionPreference.a)localObject).uDG);
      localStringBuffer.append(amR("zh_CN"));
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(41368);
    return localObject;
  }
  
  public static String dbn()
  {
    AppMethodBeat.i(41369);
    Object localObject = dbl();
    localObject = (GameRegionPreference.a)a.a.dde().ddd().get(localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localObject != null)
    {
      localStringBuffer.append(((GameRegionPreference.a)localObject).uDH);
      localStringBuffer.append(amR("zh_TW"));
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(41369);
    return localObject;
  }
  
  public static String dbo()
  {
    AppMethodBeat.i(41370);
    Object localObject = dbl();
    localObject = (GameRegionPreference.a)a.a.dde().ddd().get(localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localObject != null)
    {
      localStringBuffer.append(((GameRegionPreference.a)localObject).uDI);
      localStringBuffer.append(amR("en"));
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(41370);
    return localObject;
  }
  
  public static void dbp()
  {
    AppMethodBeat.i(41373);
    String str = ad.fom();
    ak.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", str).commit();
    AppMethodBeat.o(41373);
  }
  
  public static String dbq()
  {
    AppMethodBeat.i(41374);
    String str = ak.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", ad.fom());
    AppMethodBeat.o(41374);
    return str;
  }
  
  public static boolean dbr()
  {
    AppMethodBeat.i(41375);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKE, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L)
    {
      AppMethodBeat.o(41375);
      return true;
    }
    AppMethodBeat.o(41375);
    return false;
  }
  
  public static void dbs()
  {
    AppMethodBeat.i(41376);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKE, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(41376);
  }
  
  public static String dbt()
  {
    AppMethodBeat.i(41389);
    Object localObject = com.tencent.mm.plugin.game.commlib.a.cZt();
    if (localObject != null)
    {
      localObject = ((am)localObject).uqf;
      AppMethodBeat.o(41389);
      return localObject;
    }
    AppMethodBeat.o(41389);
    return "";
  }
  
  public static int dbu()
  {
    AppMethodBeat.i(41390);
    am localam = com.tencent.mm.plugin.game.commlib.a.cZt();
    if (localam != null)
    {
      int i = localam.uqI;
      AppMethodBeat.o(41390);
      return i;
    }
    AppMethodBeat.o(41390);
    return 0;
  }
  
  public static void dbv()
  {
    AppMethodBeat.i(41395);
    ak.getContext().getSharedPreferences("game_center_pref", 0).edit().putLong("game_index_last_visit_time", System.currentTimeMillis()).commit();
    AppMethodBeat.o(41395);
  }
  
  public static long dbw()
  {
    AppMethodBeat.i(41396);
    long l = ak.getContext().getSharedPreferences("game_center_pref", 0).getLong("game_index_last_visit_time", 0L);
    AppMethodBeat.o(41396);
    return l;
  }
  
  public static String dbx()
  {
    AppMethodBeat.i(183852);
    Object localObject = ak.getContext().getSharedPreferences("game_center_pref", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString("game_ban_msg_type_array", "");
      AppMethodBeat.o(183852);
      return localObject;
    }
    AppMethodBeat.o(183852);
    return null;
  }
  
  public static String dby()
  {
    return umb;
  }
  
  public static ShapeDrawable eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41384);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    AppMethodBeat.o(41384);
    return localShapeDrawable;
  }
  
  public static boolean fA(Context paramContext)
  {
    AppMethodBeat.i(41393);
    if (paramContext.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) == 1)
    {
      AppMethodBeat.o(41393);
      return false;
    }
    AppMethodBeat.o(41393);
    return true;
  }
  
  public static void fB(Context paramContext)
  {
    AppMethodBeat.i(41394);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
    AppMethodBeat.o(41394);
  }
  
  public static void fo(Context paramContext)
  {
    AppMethodBeat.i(41372);
    if (paramContext != null)
    {
      paramContext.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
      paramContext.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
      paramContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
    }
    AppMethodBeat.o(41372);
  }
  
  public static GameRegionPreference.a fr(Context paramContext)
  {
    AppMethodBeat.i(41366);
    String str = fz(paramContext);
    paramContext = str;
    if (bu.isNullOrNil(str)) {
      paramContext = dbl();
    }
    paramContext = (GameRegionPreference.a)a.a.dde().ddd().get(paramContext);
    AppMethodBeat.o(41366);
    return paramContext;
  }
  
  public static void fs(Context paramContext)
  {
    AppMethodBeat.i(41379);
    long l = System.currentTimeMillis() / 1000L;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("game_center_pref", 0);
    Object localObject1 = localSharedPreferences.getString("download_app_id_time_map", "");
    if (bu.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(41379);
      return;
    }
    String[] arrayOfString1 = ((String)localObject1).split(",");
    localObject1 = new String();
    int j = arrayOfString1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = arrayOfString1[i];
      String[] arrayOfString2 = ((String)localObject3).split("-");
      String str = arrayOfString2[0];
      Object localObject2 = localObject1;
      if (!bu.isNullOrNil(str))
      {
        localObject2 = localObject1;
        if (!h.s(paramContext, str))
        {
          if (l - bu.getLong(arrayOfString2[1], 0L) >= 86400L) {
            break label183;
          }
          localObject2 = (String)localObject1 + (String)localObject3 + ",";
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label183:
        localObject3 = f.cdA().aaZ(str);
        ae.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", new Object[] { Integer.valueOf(((FileDownloadTaskInfo)localObject3).status), Long.valueOf(((FileDownloadTaskInfo)localObject3).id) });
        if (((FileDownloadTaskInfo)localObject3).status == 2)
        {
          f.cdA().ui(((FileDownloadTaskInfo)localObject3).id);
          localObject2 = localObject1;
        }
        else if (((FileDownloadTaskInfo)localObject3).status != 0)
        {
          localObject2 = localObject1;
          if (((FileDownloadTaskInfo)localObject3).status != 4) {}
        }
        else
        {
          localObject2 = localObject1;
          if (o.fB(((FileDownloadTaskInfo)localObject3).path))
          {
            o.deleteFile(((FileDownloadTaskInfo)localObject3).path);
            localObject2 = localObject1;
          }
        }
      }
    }
    if (bu.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(41379);
      return;
    }
    paramContext = (Context)localObject1;
    if (((String)localObject1).charAt(((String)localObject1).length() - 1) == ',') {
      paramContext = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localSharedPreferences.edit().putString("download_app_id_time_map", paramContext.toString()).apply();
    AppMethodBeat.o(41379);
  }
  
  public static boolean ft(Context paramContext)
  {
    AppMethodBeat.i(41380);
    boolean bool = paramContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false);
    AppMethodBeat.o(41380);
    return bool;
  }
  
  public static void fu(Context paramContext)
  {
    AppMethodBeat.i(41381);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
    AppMethodBeat.o(41381);
  }
  
  public static Set<String> fv(Context paramContext)
  {
    AppMethodBeat.i(41382);
    paramContext = paramContext.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    AppMethodBeat.o(41382);
    return paramContext;
  }
  
  public static boolean fw(Context paramContext)
  {
    AppMethodBeat.i(41385);
    boolean bool = paramContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true);
    AppMethodBeat.o(41385);
    return bool;
  }
  
  public static void fx(Context paramContext)
  {
    AppMethodBeat.i(41386);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
    AppMethodBeat.o(41386);
  }
  
  public static int fy(Context paramContext)
  {
    AppMethodBeat.i(41387);
    int i = paramContext.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
    AppMethodBeat.o(41387);
    return i;
  }
  
  public static String fz(Context paramContext)
  {
    AppMethodBeat.i(41391);
    paramContext = paramContext.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    AppMethodBeat.o(41391);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e
 * JD-Core Version:    0.7.0.1
 */