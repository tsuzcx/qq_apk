package com.tencent.mm.plugin.game.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.f.a.jp;
import com.tencent.mm.f.a.oo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.g.j;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static DisplayMetrics CXz;
  private static volatile MMHandler Czq;
  private static int DdH;
  private static Rect byG;
  private static int lXU;
  private static int maxSize;
  private static final Object rim;
  
  static
  {
    AppMethodBeat.i(42526);
    maxSize = -1;
    lXU = -1;
    DdH = -1;
    rim = new Object();
    byG = new Rect();
    AppMethodBeat.o(42526);
  }
  
  public static LinkedList<String> A(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(42524);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(42524);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i).trim());
      i += 1;
    }
    AppMethodBeat.o(42524);
    return localLinkedList;
  }
  
  public static String H(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(42511);
    if ((Util.isNullOrNil(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42511);
      return paramString;
    }
    paramString = Uri.parse(paramString).buildUpon();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.appendQueryParameter(str, (String)paramMap.get(str));
    }
    paramString = paramString.build().toString();
    AppMethodBeat.o(42511);
    return paramString;
  }
  
  public static int I(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42498);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42498);
      return 0;
    }
    if (aZ(paramContext, paramString1))
    {
      AppMethodBeat.o(42498);
      return 30;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("geta8key_scene", 32);
    localIntent.putExtra("KPublisherId", paramString2);
    v(localIntent, paramContext);
    AppMethodBeat.o(42498);
    return 7;
  }
  
  public static void J(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209639);
    e(paramContext, paramString1, paramString2, 0);
    AppMethodBeat.o(209639);
  }
  
  public static void NQ(long paramLong)
  {
    AppMethodBeat.i(42519);
    com.tencent.mm.plugin.downloader.i.a.a(paramLong, false, null);
    AppMethodBeat.o(42519);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(42509);
    Object localObject = paramBundle;
    if (!Util.isNullOrNil(paramString1))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = com.tencent.mm.plugin.game.model.a.eG(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.cUP == 2)
      {
        localObject = localBundle;
        if (!Util.isNullOrNil(paramBundle.url))
        {
          paramInt = I(paramContext, paramBundle.url, "game_center_detail");
          AppMethodBeat.o(42509);
          return paramInt;
        }
      }
    }
    if (!Util.isNullOrNil(paramString2))
    {
      paramInt = I(paramContext, paramString2, "game_center_detail");
      AppMethodBeat.o(42509);
      return paramInt;
    }
    int i = e.eyi();
    if (i == 2)
    {
      paramInt = k(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    if (i == 1)
    {
      g(paramContext, (Bundle)localObject);
      AppMethodBeat.o(42509);
      return 6;
    }
    paramString2 = Util.getSimCountryCode(paramContext);
    if ((Util.isNullOrNil(paramString2)) || (paramString2.toLowerCase().equals("cn")))
    {
      paramInt = k(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    g(paramContext, (Bundle)localObject);
    AppMethodBeat.o(42509);
    return 6;
  }
  
  public static void a(Context paramContext, o paramo, String paramString)
  {
    AppMethodBeat.i(42500);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramo.CJx.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.CJx.CzQ);
    localIntent.putExtra("disable_progress_bar", paramo.CJx.CzQ);
    int i = -1;
    switch (paramo.CJx.FO)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramo = new oo();
      paramo.fNq.type = 1;
      paramo.fNq.context = paramContext;
      paramo.fNq.intent = localIntent;
      EventCenter.instance.publish(paramo);
      AppMethodBeat.o(42500);
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 1001;
      continue;
      i = 1002;
    }
  }
  
  public static boolean a(View paramView, Context paramContext)
  {
    AppMethodBeat.i(42501);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String)))
    {
      Log.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(42501);
      return false;
    }
    paramView = (String)paramView.getTag();
    if (Util.isNullOrNil(paramView))
    {
      Log.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(42501);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("show_bottom", false);
    v(localIntent, paramContext);
    AppMethodBeat.o(42501);
    return true;
  }
  
  public static int aIQ(String paramString)
  {
    AppMethodBeat.i(42517);
    int i = 0;
    try
    {
      int j = Color.parseColor(paramString);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.GameCenterUtil", "parseColor: " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(42517);
    return i;
  }
  
  public static int aKt(String paramString)
  {
    AppMethodBeat.i(42503);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(42503);
      return 0;
    }
    try
    {
      paramString = MMApplicationContext.getContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        AppMethodBeat.o(42503);
        return 0;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[] { paramString.toString() });
        paramString = null;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(42503);
      return i;
    }
  }
  
  public static String aKu(String paramString)
  {
    AppMethodBeat.i(209647);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(209647);
      return "";
    }
    try
    {
      paramString = MMApplicationContext.getContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        AppMethodBeat.o(209647);
        return "";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[] { paramString.toString() });
        paramString = null;
      }
      paramString = paramString.versionName;
      AppMethodBeat.o(209647);
    }
    return paramString;
  }
  
  public static int aKv(String paramString)
  {
    AppMethodBeat.i(42504);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GameCenterUtil", "Null or Nil path");
      AppMethodBeat.o(42504);
      return 0;
    }
    paramString = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(42504);
      return 0;
    }
    int i = paramString.versionCode;
    AppMethodBeat.o(42504);
    return i;
  }
  
  private static boolean aKw(String paramString)
  {
    AppMethodBeat.i(42521);
    if (!((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vtX, true))
    {
      AppMethodBeat.o(42521);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42521);
      return false;
    }
    paramString = Uri.parse(paramString);
    if ((paramString.getHost() != null) && (paramString.getHost().equals(WeChatHosts.domainString(g.i.host_game_weixin_qq_com))))
    {
      AppMethodBeat.o(42521);
      return true;
    }
    AppMethodBeat.o(42521);
    return false;
  }
  
  public static LinkedList<String> aKx(String paramString)
  {
    AppMethodBeat.i(42523);
    paramString = paramString.substring(1, paramString.length() - 1).split(",");
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i].trim());
      i += 1;
    }
    AppMethodBeat.o(42523);
    return localLinkedList;
  }
  
  public static JSONArray aKy(String paramString)
  {
    AppMethodBeat.i(42525);
    paramString = paramString.substring(1, paramString.length() - 1).split(",");
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramString.length)
    {
      localJSONArray.put(paramString[i].trim());
      i += 1;
    }
    AppMethodBeat.o(42525);
    return localJSONArray;
  }
  
  public static boolean aKz(String paramString)
  {
    AppMethodBeat.i(209678);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209678);
      return false;
    }
    paramString = "NotDisturb_" + MD5Util.getMD5String(paramString);
    if (((f)com.tencent.mm.kernel.h.ae(f.class)).evp().aIX(paramString) == null)
    {
      AppMethodBeat.o(209678);
      return false;
    }
    AppMethodBeat.o(209678);
    return true;
  }
  
  public static int aY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(42497);
    int i = I(paramContext, paramString, null);
    AppMethodBeat.o(42497);
    return i;
  }
  
  public static boolean aZ(Context paramContext, String paramString)
  {
    int j = 2;
    AppMethodBeat.i(42499);
    paramString = Uri.parse(paramString).getQueryParameter("weapp");
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Uri.parse(paramString);
        paramString = ((Uri)localObject1).getAuthority();
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.GameCenterUtil", "targetAppId is null");
          AppMethodBeat.o(42499);
          return false;
        }
        localObject2 = ((Uri)localObject1).getQueryParameter("env_version");
        localObject1 = ((Uri)localObject1).getQueryParameter("path");
        localObject2 = Util.nullAsNil((String)localObject2);
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 1559690845: 
          Log.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", new Object[] { paramString, Integer.valueOf(j), localObject1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).scene = 1079;
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
          AppMethodBeat.o(42499);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        boolean bool;
        Log.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + paramContext.getMessage());
      }
      if (((String)localObject2).equals("develop"))
      {
        i = 0;
        break label277;
        bool = ((String)localObject2).equals("trial");
        if (bool)
        {
          i = 1;
          break label277;
          j = 1;
          continue;
          AppMethodBeat.o(42499);
          return false;
        }
      }
      label277:
      switch (i)
      {
      }
      j = 0;
    }
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(42508);
    int i = a(paramContext, paramString1, paramString2, paramBundle, 0);
    AppMethodBeat.o(42508);
    return i;
  }
  
  public static void bO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209680);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209680);
      return;
    }
    Log.i("MicroMsg.GameCenterUtil", "setNotDisturbMsg, msgRelatedId:%s, flag:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    paramString = "NotDisturb_" + MD5Util.getMD5String(paramString);
    if (paramBoolean)
    {
      ((f)com.tencent.mm.kernel.h.ae(f.class)).evp().u(paramString, "1".getBytes());
      AppMethodBeat.o(209680);
      return;
    }
    ((f)com.tencent.mm.kernel.h.ae(f.class)).evp().aJX(paramString);
    AppMethodBeat.o(209680);
  }
  
  public static void bq(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42506);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(42506);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
      if ((localg != null) && (Util.isNullOrNil(localg.field_openId))) {
        localLinkedList.add(str);
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      com.tencent.mm.plugin.ab.a.fmB().addAll(localLinkedList);
    }
    AppMethodBeat.o(42506);
  }
  
  public static String br(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42522);
    paramLinkedList = paramLinkedList.iterator();
    if (!paramLinkedList.hasNext())
    {
      AppMethodBeat.o(42522);
      return "()";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    for (;;)
    {
      String str = ((String)paramLinkedList.next()).trim();
      localStringBuilder.append("\"" + str + "\"");
      if (!paramLinkedList.hasNext())
      {
        paramLinkedList = ')';
        AppMethodBeat.o(42522);
        return paramLinkedList;
      }
      localStringBuilder.append(',');
    }
  }
  
  public static MMHandler cMC()
  {
    AppMethodBeat.i(183911);
    if (Czq == null) {}
    synchronized (rim)
    {
      if (Czq == null)
      {
        Czq = new MMHandler("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.ck.a("SubCoreGameCenter#WorkThread"));
      }
      ??? = Czq;
      AppMethodBeat.o(183911);
      return ???;
    }
  }
  
  public static void clU()
  {
    AppMethodBeat.i(42515);
    if (Czq == null)
    {
      AppMethodBeat.o(42515);
      return;
    }
    synchronized (rim)
    {
      if (Czq != null)
      {
        com.tencent.mm.vending.h.g.bBw("SubCoreGameCenter#WorkThread");
        Czq.quit();
        Czq = null;
      }
      AppMethodBeat.o(42515);
      return;
    }
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(209642);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.nBq = paramString2;
    localg.cBU = paramInt;
    localg.scene = 1079;
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, localg);
    AppMethodBeat.o(209642);
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> ezY()
  {
    AppMethodBeat.i(42507);
    Cursor localCursor = com.tencent.mm.plugin.ab.a.fmz().hhy();
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null) {
      Log.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
    }
    for (;;)
    {
      AppMethodBeat.o(42507);
      return localLinkedList;
      if (localCursor.moveToFirst()) {
        do
        {
          com.tencent.mm.pluginsdk.model.app.g localg = new com.tencent.mm.pluginsdk.model.app.g();
          localg.convertFrom(localCursor);
          localLinkedList.add(localg);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
  }
  
  public static String ezZ()
  {
    AppMethodBeat.i(42520);
    Object localObject = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuN, "");
    if ((localObject != null) && (!Util.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(42520);
        return null;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(42520);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.exS();
    if ((((a.a)localObject).cUP == 2) && (!Util.isNullOrNil(((a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 12L, 1L, false);
      localObject = ((a.a)localObject).url;
      AppMethodBeat.o(42520);
      return localObject;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.Czb != null) && (com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting != null) && (com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting.COR == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting.COS;
      AppMethodBeat.o(42520);
      return localObject;
    }
    com.tencent.mm.plugin.game.commlib.a.ewa();
    if ((com.tencent.mm.plugin.game.commlib.a.Czb != null) && (com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting != null) && (com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting.COR == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting.COS;
      AppMethodBeat.o(42520);
      return localObject;
    }
    AppMethodBeat.o(42520);
    return null;
  }
  
  public static void g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(42512);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
    localIntent.putExtras(paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBundle.aFh(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(42512);
  }
  
  public static Dialog gF(Context paramContext)
  {
    AppMethodBeat.i(42502);
    View localView = View.inflate(paramContext, g.f.CnV, null);
    paramContext = new i(paramContext, g.j.Cqi);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42492);
        this.DdI.setOnCancelListener(null);
        AppMethodBeat.o(42492);
      }
    });
    AppMethodBeat.o(42502);
    return paramContext;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(42496);
    if (paramContext == null)
    {
      AppMethodBeat.o(42496);
      return 0;
    }
    if (CXz == null)
    {
      CXz = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(CXz);
    }
    int i = CXz.widthPixels;
    AppMethodBeat.o(42496);
    return i;
  }
  
  /* Error */
  public static void h(String paramString, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 842
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 88	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 842
    //   19: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: ldc_w 310
    //   29: ldc_w 844
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 847	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 849	com/tencent/mm/f/a/jp
    //   46: dup
    //   47: invokespecial 850	com/tencent/mm/f/a/jp:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: getfield 854	com/tencent/mm/f/a/jp:fGP	Lcom/tencent/mm/f/a/jp$a;
    //   55: iconst_1
    //   56: putfield 859	com/tencent/mm/f/a/jp$a:Vh	I
    //   59: aload_2
    //   60: getfield 854	com/tencent/mm/f/a/jp:fGP	Lcom/tencent/mm/f/a/jp$a;
    //   63: aload_0
    //   64: putfield 860	com/tencent/mm/f/a/jp$a:url	Ljava/lang/String;
    //   67: getstatic 297	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   70: aload_2
    //   71: invokevirtual 301	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   74: pop
    //   75: aload_2
    //   76: getfield 864	com/tencent/mm/f/a/jp:fGQ	Lcom/tencent/mm/f/a/jp$b;
    //   79: getfield 869	com/tencent/mm/f/a/jp$b:fGS	Z
    //   82: ifeq +87 -> 169
    //   85: new 329	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 584	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: getfield 864	com/tencent/mm/f/a/jp:fGQ	Lcom/tencent/mm/f/a/jp$b;
    //   96: getfield 872	com/tencent/mm/f/a/jp$b:fGR	Ljava/lang/String;
    //   99: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 541	java/lang/String:getBytes	()[B
    //   106: invokestatic 878	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   109: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_3
    //   116: new 880	com/tencent/mm/ay/a/a/c$a
    //   119: dup
    //   120: invokespecial 881	com/tencent/mm/ay/a/a/c$a:<init>	()V
    //   123: astore 4
    //   125: aload 4
    //   127: iconst_1
    //   128: putfield 884	com/tencent/mm/ay/a/a/c$a:lRD	Z
    //   131: aload 4
    //   133: aload_3
    //   134: putfield 887	com/tencent/mm/ay/a/a/c$a:fullPath	Ljava/lang/String;
    //   137: aload 4
    //   139: invokevirtual 891	com/tencent/mm/ay/a/a/c$a:bmL	()Lcom/tencent/mm/ay/a/a/c;
    //   142: astore_3
    //   143: invokestatic 897	com/tencent/mm/ay/q:bml	()Lcom/tencent/mm/ay/a/a;
    //   146: aload_0
    //   147: aconst_null
    //   148: aload_3
    //   149: new 8	com/tencent/mm/plugin/game/d/c$2
    //   152: dup
    //   153: aload_2
    //   154: invokespecial 900	com/tencent/mm/plugin/game/d/c$2:<init>	(Lcom/tencent/mm/f/a/jp;)V
    //   157: new 10	com/tencent/mm/plugin/game/d/c$3
    //   160: dup
    //   161: fload_1
    //   162: aload_2
    //   163: invokespecial 903	com/tencent/mm/plugin/game/d/c$3:<init>	(FLcom/tencent/mm/f/a/jp;)V
    //   166: invokevirtual 908	com/tencent/mm/ay/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/ay/a/a/c;Lcom/tencent/mm/ay/a/c/k;Lcom/tencent/mm/ay/a/c/h;)V
    //   169: ldc_w 842
    //   172: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -153 -> 22
    //   178: astore_0
    //   179: ldc 2
    //   181: monitorexit
    //   182: aload_0
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   0	184	1	paramFloat	float
    //   50	113	2	localjp	jp
    //   115	34	3	localObject	Object
    //   123	15	4	locala	com.tencent.mm.ay.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	22	178	finally
    //   26	169	178	finally
    //   169	175	178	finally
  }
  
  public static boolean ia(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42518);
    paramString1 = new q(paramString1);
    String str = u.buc(paramString1.getPath());
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(str)))
    {
      Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      bool = paramString1.ifE();
      AppMethodBeat.o(42518);
      return bool;
    }
    Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
    boolean bool = paramString2.equalsIgnoreCase(str);
    AppMethodBeat.o(42518);
    return bool;
  }
  
  public static int k(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(42510);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42510);
      return 0;
    }
    String str = e.eyh();
    HashMap localHashMap;
    if (!Util.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = H(str, localHashMap);; paramString = WeChatHosts.domainString(g.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/gamecenter/detail.html?appid=" + paramString)
    {
      paramInt = I(paramContext, paramString, "game_center_detail");
      AppMethodBeat.o(42510);
      return paramInt;
    }
  }
  
  public static void v(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42513);
    if (aKw(paramIntent.getStringExtra("rawUrl")))
    {
      w(paramIntent, paramContext);
      AppMethodBeat.o(42513);
      return;
    }
    oo localoo = new oo();
    localoo.fNq.type = 0;
    localoo.fNq.context = paramContext;
    localoo.fNq.intent = paramIntent;
    EventCenter.instance.publish(localoo);
    AppMethodBeat.o(42513);
  }
  
  public static void w(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42514);
    oo localoo = new oo();
    localoo.fNq.type = 2;
    localoo.fNq.context = paramContext;
    localoo.fNq.intent = paramIntent;
    EventCenter.instance.publish(localoo);
    AppMethodBeat.o(42514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.c
 * JD-Core Version:    0.7.0.1
 */