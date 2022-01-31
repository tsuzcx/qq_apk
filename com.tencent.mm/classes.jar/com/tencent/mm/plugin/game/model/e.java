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
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static String nmu = "";
  
  public static void O(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(111226);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", paramInt).apply();
    AppMethodBeat.o(111226);
  }
  
  private static String Qb(String paramString)
  {
    AppMethodBeat.i(111209);
    Object localObject3 = null;
    label73:
    String str2;
    for (Object localObject1 = null;; str2 = "")
    {
      try
      {
        localInputStream = ah.getContext().getAssets().open("game_region_default.txt");
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
          ab.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bo.l(localIOException4) });
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
            ab.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bo.l(localIOException2) });
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
          AppMethodBeat.o(111209);
          throw paramString;
        }
        catch (IOException localIOException3)
        {
          ab.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bo.l(localIOException3) });
          continue;
        }
        if (!"zh_CN".equalsIgnoreCase(paramString)) {
          continue;
        }
        paramString = localObject3[0];
        AppMethodBeat.o(111209);
        return paramString;
        if ((!"zh_TW".equalsIgnoreCase(paramString)) && (!"zh_HK".equalsIgnoreCase(paramString))) {
          continue;
        }
        paramString = localObject3[1];
        AppMethodBeat.o(111209);
        return paramString;
        paramString = localObject3[2];
        AppMethodBeat.o(111209);
        return paramString;
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (IOException localIOException1)
      {
        ab.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[] { bo.l(localIOException1) });
        localObject2 = localObject4;
        break label73;
      }
      localObject3 = localObject1.trim().split("\\|");
      if (localObject3.length < 3)
      {
        ab.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", new Object[] { localObject1 });
        AppMethodBeat.o(111209);
        return "";
      }
    }
  }
  
  public static String a(GameRegionPreference.a parama)
  {
    AppMethodBeat.i(111205);
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (parama != null)
    {
      str = bo.nullAsNil(aa.dsG());
      if (!"zh_CN".equalsIgnoreCase(str)) {
        break label54;
      }
      localStringBuffer.append(parama.nCv);
    }
    for (;;)
    {
      parama = localStringBuffer.toString();
      AppMethodBeat.o(111205);
      return parama;
      label54:
      if (("zh_TW".equalsIgnoreCase(str)) || ("zh_HK".equalsIgnoreCase(str))) {
        localStringBuffer.append(parama.nCw);
      } else {
        localStringBuffer.append(parama.nCx);
      }
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.f paramf, String paramString1, String paramString2, ai paramai)
  {
    AppMethodBeat.i(111202);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      ab.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(111202);
      return;
    }
    if (!p.b(paramContext, paramf))
    {
      ab.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", new Object[] { paramf.field_appName });
      Toast.makeText(paramContext, paramContext.getString(2131300385, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(paramContext, paramf, null) }), 1).show();
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(111202);
      return;
    }
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 620954624;
    localWXMediaMessage.messageAction = paramString1;
    localWXMediaMessage.messageExt = paramString2;
    ab.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramf.field_appId, paramf.field_appName, paramf.field_openId });
    if (bo.isNullOrNil(paramf.field_openId))
    {
      ab.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", new Object[] { paramf.field_appName });
      com.tencent.mm.plugin.s.a.cae().xB(paramf.field_appId);
    }
    com.tencent.mm.ch.a.post(new e.2(paramContext, paramf, localWXMediaMessage, paramai));
    AppMethodBeat.o(111202);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, ai paramai)
  {
    AppMethodBeat.i(111201);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.GameCenterLogic", "null or nil appid");
      if (paramai != null) {
        paramai.dZ(false);
      }
    }
    a(paramContext, com.tencent.mm.pluginsdk.model.app.g.ca(paramString1, true), paramString2, paramString3, paramai);
    AppMethodBeat.o(111201);
  }
  
  public static void a(Context paramContext, Set<String> paramSet)
  {
    AppMethodBeat.i(111221);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", paramSet).commit();
    AppMethodBeat.o(111221);
  }
  
  public static void aj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(111200);
    a(paramContext, paramString, null, "WX_GameCenter", new e.1(paramString));
    AppMethodBeat.o(111200);
  }
  
  public static void ar(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(111215);
    String str2 = String.valueOf(System.currentTimeMillis() / 1000L);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("game_center_pref", 0);
    Object localObject = localSharedPreferences.getString("download_app_id_time_map", "");
    if (bo.isNullOrNil((String)localObject))
    {
      paramContext = paramString + "-" + str2;
      localSharedPreferences.edit().putString("download_app_id_time_map", paramContext).commit();
      AppMethodBeat.o(111215);
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
      AppMethodBeat.o(111215);
      return;
    }
    paramContext = (String)localObject + "," + paramString + "-" + str2;
    localSharedPreferences.edit().putString("download_app_id_time_map", paramContext).apply();
    AppMethodBeat.o(111215);
  }
  
  public static void as(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(111216);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("game_center_pref", 0);
    paramContext = localSharedPreferences.getString("download_app_id_time_map", "");
    if (bo.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(111216);
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
            break label131;
          }
        }
        label131:
        for (paramContext = (String)localObject + str;; paramContext = (String)localObject + str + ",")
        {
          i += 1;
          localObject = paramContext;
          break;
        }
      }
      localSharedPreferences.edit().putString("download_app_id_time_map", (String)localObject).apply();
    }
    AppMethodBeat.o(111216);
  }
  
  public static void at(Context paramContext, String paramString)
  {
    AppMethodBeat.i(111230);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", paramString).commit();
    AppMethodBeat.o(111230);
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.f> bFR()
  {
    AppMethodBeat.i(111198);
    ab.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
    LinkedList localLinkedList1 = new LinkedList();
    localLinkedList1.addAll(((d)com.tencent.mm.kernel.g.E(d.class)).bEP().nlS);
    LinkedList localLinkedList2 = new LinkedList();
    Iterator localIterator = localLinkedList1.iterator();
    label162:
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.model.app.f localf = (com.tencent.mm.pluginsdk.model.app.f)localIterator.next();
      if (localf != null)
      {
        ab.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", new Object[] { localf.field_appId, Integer.valueOf(localf.field_appInfoFlag) });
        if ((localf.field_appInfoFlag & 0x4) <= 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label162;
        }
        ab.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[] { localf.field_appName });
        localLinkedList2.add(localf);
        break;
      }
    }
    if (localLinkedList2.size() > 0) {
      localLinkedList1.removeAll(localLinkedList2);
    }
    AppMethodBeat.o(111198);
    return localLinkedList1;
  }
  
  public static LinkedList<String> bFS()
  {
    AppMethodBeat.i(111199);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(((d)com.tencent.mm.kernel.g.E(d.class)).bEP().nlR);
    AppMethodBeat.o(111199);
    return localLinkedList;
  }
  
  public static String bFT()
  {
    AppMethodBeat.i(111203);
    String str2 = bo.hi(ah.getContext());
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = "CN";
    }
    str1 = str1.toUpperCase();
    AppMethodBeat.o(111203);
    return str1;
  }
  
  public static String bFU()
  {
    AppMethodBeat.i(111206);
    Object localObject = bFT();
    localObject = (GameRegionPreference.a)a.a.bHB().bHA().get(localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localObject != null)
    {
      localStringBuffer.append(((GameRegionPreference.a)localObject).nCv);
      localStringBuffer.append(Qb("zh_CN"));
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(111206);
    return localObject;
  }
  
  public static String bFV()
  {
    AppMethodBeat.i(111207);
    Object localObject = bFT();
    localObject = (GameRegionPreference.a)a.a.bHB().bHA().get(localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localObject != null)
    {
      localStringBuffer.append(((GameRegionPreference.a)localObject).nCw);
      localStringBuffer.append(Qb("zh_TW"));
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(111207);
    return localObject;
  }
  
  public static String bFW()
  {
    AppMethodBeat.i(111208);
    Object localObject = bFT();
    localObject = (GameRegionPreference.a)a.a.bHB().bHA().get(localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localObject != null)
    {
      localStringBuffer.append(((GameRegionPreference.a)localObject).nCx);
      localStringBuffer.append(Qb("en"));
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(111208);
    return localObject;
  }
  
  public static void bFX()
  {
    AppMethodBeat.i(111211);
    String str = aa.dsG();
    ah.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", str).commit();
    AppMethodBeat.o(111211);
  }
  
  public static String bFY()
  {
    AppMethodBeat.i(111212);
    String str = ah.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", aa.dsG());
    AppMethodBeat.o(111212);
    return str;
  }
  
  public static boolean bFZ()
  {
    AppMethodBeat.i(111213);
    long l = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yxJ, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L)
    {
      AppMethodBeat.o(111213);
      return true;
    }
    AppMethodBeat.o(111213);
    return false;
  }
  
  public static void bGa()
  {
    AppMethodBeat.i(111214);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxJ, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(111214);
  }
  
  public static String bGb()
  {
    AppMethodBeat.i(111227);
    Object localObject = com.tencent.mm.plugin.game.commlib.a.bFb();
    if (localObject != null)
    {
      localObject = ((ac)localObject).npR;
      AppMethodBeat.o(111227);
      return localObject;
    }
    AppMethodBeat.o(111227);
    return "";
  }
  
  public static int bGc()
  {
    AppMethodBeat.i(111228);
    ac localac = com.tencent.mm.plugin.game.commlib.a.bFb();
    if (localac != null)
    {
      int i = localac.nrh;
      AppMethodBeat.o(111228);
      return i;
    }
    AppMethodBeat.o(111228);
    return 0;
  }
  
  public static void bGd()
  {
    AppMethodBeat.i(111233);
    ah.getContext().getSharedPreferences("game_center_pref", 0).edit().putLong("game_index_last_visit_time", System.currentTimeMillis()).commit();
    AppMethodBeat.o(111233);
  }
  
  public static long bGe()
  {
    AppMethodBeat.i(111234);
    long l = ah.getContext().getSharedPreferences("game_center_pref", 0).getLong("game_index_last_visit_time", 0L);
    AppMethodBeat.o(111234);
    return l;
  }
  
  public static String bGf()
  {
    return nmu;
  }
  
  public static ShapeDrawable dR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111222);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    AppMethodBeat.o(111222);
    return localShapeDrawable;
  }
  
  public static void dZ(Context paramContext)
  {
    AppMethodBeat.i(111210);
    if (paramContext != null)
    {
      paramContext.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
      paramContext.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
      paramContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
    }
    AppMethodBeat.o(111210);
  }
  
  public static GameRegionPreference.a eb(Context paramContext)
  {
    AppMethodBeat.i(111204);
    String str = ej(paramContext);
    paramContext = str;
    if (bo.isNullOrNil(str)) {
      paramContext = bFT();
    }
    paramContext = (GameRegionPreference.a)a.a.bHB().bHA().get(paramContext);
    AppMethodBeat.o(111204);
    return paramContext;
  }
  
  public static void ec(Context paramContext)
  {
    AppMethodBeat.i(111217);
    long l = System.currentTimeMillis() / 1000L;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("game_center_pref", 0);
    Object localObject1 = localSharedPreferences.getString("download_app_id_time_map", "");
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(111217);
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
      if (!bo.isNullOrNil(str))
      {
        localObject2 = localObject1;
        if (!com.tencent.mm.pluginsdk.model.app.g.u(paramContext, str))
        {
          if (l - bo.getLong(arrayOfString2[1], 0L) >= 86400L) {
            break label185;
          }
          localObject2 = (String)localObject1 + (String)localObject3 + ",";
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label185:
        localObject3 = com.tencent.mm.plugin.downloader.model.f.bjl().JH(str);
        ab.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", new Object[] { Integer.valueOf(((FileDownloadTaskInfo)localObject3).status), Long.valueOf(((FileDownloadTaskInfo)localObject3).id) });
        if (((FileDownloadTaskInfo)localObject3).status == 2)
        {
          com.tencent.mm.plugin.downloader.model.f.bjl().iz(((FileDownloadTaskInfo)localObject3).id);
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
          if (com.tencent.mm.vfs.e.cN(((FileDownloadTaskInfo)localObject3).path))
          {
            com.tencent.mm.vfs.e.deleteFile(((FileDownloadTaskInfo)localObject3).path);
            localObject2 = localObject1;
          }
        }
      }
    }
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(111217);
      return;
    }
    paramContext = (Context)localObject1;
    if (((String)localObject1).charAt(((String)localObject1).length() - 1) == ',') {
      paramContext = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localSharedPreferences.edit().putString("download_app_id_time_map", paramContext.toString()).apply();
    AppMethodBeat.o(111217);
  }
  
  public static boolean ed(Context paramContext)
  {
    AppMethodBeat.i(111218);
    boolean bool = paramContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false);
    AppMethodBeat.o(111218);
    return bool;
  }
  
  public static void ee(Context paramContext)
  {
    AppMethodBeat.i(111219);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
    AppMethodBeat.o(111219);
  }
  
  public static Set<String> ef(Context paramContext)
  {
    AppMethodBeat.i(111220);
    paramContext = paramContext.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    AppMethodBeat.o(111220);
    return paramContext;
  }
  
  public static boolean eg(Context paramContext)
  {
    AppMethodBeat.i(111223);
    boolean bool = paramContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true);
    AppMethodBeat.o(111223);
    return bool;
  }
  
  public static void eh(Context paramContext)
  {
    AppMethodBeat.i(111224);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
    AppMethodBeat.o(111224);
  }
  
  public static int ei(Context paramContext)
  {
    AppMethodBeat.i(111225);
    int i = paramContext.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
    AppMethodBeat.o(111225);
    return i;
  }
  
  public static String ej(Context paramContext)
  {
    AppMethodBeat.i(111229);
    paramContext = paramContext.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    AppMethodBeat.o(111229);
    return paramContext;
  }
  
  public static boolean ek(Context paramContext)
  {
    AppMethodBeat.i(111231);
    if (paramContext.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) == 1)
    {
      AppMethodBeat.o(111231);
      return false;
    }
    AppMethodBeat.o(111231);
    return true;
  }
  
  public static void el(Context paramContext)
  {
    AppMethodBeat.i(111232);
    paramContext.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
    AppMethodBeat.o(111232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e
 * JD-Core Version:    0.7.0.1
 */