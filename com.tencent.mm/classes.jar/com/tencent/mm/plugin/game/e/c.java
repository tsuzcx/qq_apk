package com.tencent.mm.plugin.game.e;

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
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.av;
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
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static int jhr;
  private static int maxSize;
  private static final Object ogA;
  private static Rect rect;
  private static DisplayMetrics xTo;
  private static int xZa;
  private static volatile MMHandler xvA;
  
  static
  {
    AppMethodBeat.i(42526);
    maxSize = -1;
    jhr = -1;
    xZa = -1;
    ogA = new Object();
    rect = new Rect();
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
  
  public static int D(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42498);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42498);
      return 0;
    }
    if (aR(paramContext, paramString1))
    {
      AppMethodBeat.o(42498);
      return 30;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("geta8key_scene", 32);
    localIntent.putExtra("KPublisherId", paramString2);
    w(localIntent, paramContext);
    AppMethodBeat.o(42498);
    return 7;
  }
  
  public static void E(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(204324);
    c(paramContext, paramString1, paramString2, 0);
    AppMethodBeat.o(204324);
  }
  
  public static String F(String paramString, Map<String, String> paramMap)
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
  
  public static void GK(long paramLong)
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
      paramBundle = com.tencent.mm.plugin.game.model.a.ei(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.cSx == 2)
      {
        localObject = localBundle;
        if (!Util.isNullOrNil(paramBundle.url))
        {
          paramInt = D(paramContext, paramBundle.url, "game_center_detail");
          AppMethodBeat.o(42509);
          return paramInt;
        }
      }
    }
    if (!Util.isNullOrNil(paramString2))
    {
      paramInt = D(paramContext, paramString2, "game_center_detail");
      AppMethodBeat.o(42509);
      return paramInt;
    }
    int i = e.dVb();
    if (i == 2)
    {
      paramInt = l(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    if (i == 1)
    {
      f(paramContext, (Bundle)localObject);
      AppMethodBeat.o(42509);
      return 6;
    }
    paramString2 = Util.getSimCountryCode(paramContext);
    if ((Util.isNullOrNil(paramString2)) || (paramString2.toLowerCase().equals("cn")))
    {
      paramInt = l(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    f(paramContext, (Bundle)localObject);
    AppMethodBeat.o(42509);
    return 6;
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, String paramString)
  {
    AppMethodBeat.i(42500);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramo.xFw.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.xFw.xvW);
    localIntent.putExtra("disable_progress_bar", paramo.xFw.xvW);
    int i = -1;
    switch (paramo.xFw.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramo = new nr();
      paramo.dTO.type = 1;
      paramo.dTO.context = paramContext;
      paramo.dTO.intent = localIntent;
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
    w(localIntent, paramContext);
    AppMethodBeat.o(42501);
    return true;
  }
  
  public static int aAH(String paramString)
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
  
  public static String aAI(String paramString)
  {
    AppMethodBeat.i(204326);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(204326);
      return "";
    }
    try
    {
      paramString = MMApplicationContext.getContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        AppMethodBeat.o(204326);
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
      AppMethodBeat.o(204326);
    }
    return paramString;
  }
  
  public static int aAJ(String paramString)
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
  
  private static boolean aAK(String paramString)
  {
    AppMethodBeat.i(42521);
    if (!((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOd, true))
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
    if ((paramString.getHost() != null) && (paramString.getHost().equals(WeChatHosts.domainString(2131761707))))
    {
      AppMethodBeat.o(42521);
      return true;
    }
    AppMethodBeat.o(42521);
    return false;
  }
  
  public static LinkedList<String> aAL(String paramString)
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
  
  public static JSONArray aAM(String paramString)
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
  
  public static boolean aAN(String paramString)
  {
    AppMethodBeat.i(204327);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(204327);
      return false;
    }
    paramString = "NotDisturb_" + MD5Util.getMD5String(paramString);
    if (((f)com.tencent.mm.kernel.g.af(f.class)).dSL().azn(paramString) == null)
    {
      AppMethodBeat.o(204327);
      return false;
    }
    AppMethodBeat.o(204327);
    return true;
  }
  
  public static int aQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(42497);
    int i = D(paramContext, paramString, null);
    AppMethodBeat.o(42497);
    return i;
  }
  
  public static boolean aR(Context paramContext, String paramString)
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
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
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
  
  public static void aX(LinkedList<String> paramLinkedList)
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
      com.tencent.mm.plugin.r.a.eAU().addAll(localLinkedList);
    }
    AppMethodBeat.o(42506);
  }
  
  public static String aY(LinkedList<String> paramLinkedList)
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
  
  public static int b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(42508);
    int i = a(paramContext, paramString1, paramString2, paramBundle, 0);
    AppMethodBeat.o(42508);
    return i;
  }
  
  public static void bJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204328);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(204328);
      return;
    }
    Log.i("MicroMsg.GameCenterUtil", "setNotDisturbMsg, msgRelatedId:%s, flag:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    paramString = "NotDisturb_" + MD5Util.getMD5String(paramString);
    if (paramBoolean)
    {
      ((f)com.tencent.mm.kernel.g.af(f.class)).dSL().r(paramString, "1".getBytes());
      AppMethodBeat.o(204328);
      return;
    }
    ((f)com.tencent.mm.kernel.g.af(f.class)).dSL().aAl(paramString);
    AppMethodBeat.o(204328);
  }
  
  public static void bZm()
  {
    AppMethodBeat.i(42515);
    if (xvA == null)
    {
      AppMethodBeat.o(42515);
      return;
    }
    synchronized (ogA)
    {
      if (xvA != null)
      {
        com.tencent.mm.vending.h.g.boG("SubCoreGameCenter#WorkThread");
        xvA.quit();
        xvA = null;
      }
      AppMethodBeat.o(42515);
      return;
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(204325);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.kHw = paramString2;
    localg.iOo = paramInt;
    localg.scene = 1079;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, localg);
    AppMethodBeat.o(204325);
  }
  
  public static MMHandler cyh()
  {
    AppMethodBeat.i(183911);
    if (xvA == null) {}
    synchronized (ogA)
    {
      if (xvA == null)
      {
        xvA = new MMHandler("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.cd.a("SubCoreGameCenter#WorkThread"));
      }
      ??? = xvA;
      AppMethodBeat.o(183911);
      return ???;
    }
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> dWP()
  {
    AppMethodBeat.i(42507);
    Cursor localCursor = com.tencent.mm.plugin.r.a.eAS().gmX();
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
  
  public static String dWQ()
  {
    AppMethodBeat.i(42520);
    Object localObject = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOL, "");
    if ((localObject != null) && (!Util.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(42520);
        return null;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(42520);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.dUL();
    if ((((a.a)localObject).cSx == 2) && (!Util.isNullOrNil(((a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(848L, 12L, 1L, false);
      localObject = ((a.a)localObject).url;
      AppMethodBeat.o(42520);
      return localObject;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.xvl != null) && (com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting != null) && (com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKK == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKL;
      AppMethodBeat.o(42520);
      return localObject;
    }
    com.tencent.mm.plugin.game.commlib.a.dSS();
    if ((com.tencent.mm.plugin.game.commlib.a.xvl != null) && (com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting != null) && (com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKK == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKL;
      AppMethodBeat.o(42520);
      return localObject;
    }
    AppMethodBeat.o(42520);
    return null;
  }
  
  public static void f(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(42512);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
    localIntent.putExtras(paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.axQ(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(42512);
  }
  
  /* Error */
  public static void g(String paramString, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 758
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 88	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 758
    //   19: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: ldc_w 311
    //   29: ldc_w 760
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 763	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 765	com/tencent/mm/g/a/iz
    //   46: dup
    //   47: invokespecial 766	com/tencent/mm/g/a/iz:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: getfield 770	com/tencent/mm/g/a/iz:dND	Lcom/tencent/mm/g/a/iz$a;
    //   55: iconst_1
    //   56: putfield 775	com/tencent/mm/g/a/iz$a:EX	I
    //   59: aload_2
    //   60: getfield 770	com/tencent/mm/g/a/iz:dND	Lcom/tencent/mm/g/a/iz$a;
    //   63: aload_0
    //   64: putfield 776	com/tencent/mm/g/a/iz$a:url	Ljava/lang/String;
    //   67: getstatic 298	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   70: aload_2
    //   71: invokevirtual 302	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   74: pop
    //   75: aload_2
    //   76: getfield 780	com/tencent/mm/g/a/iz:dNE	Lcom/tencent/mm/g/a/iz$b;
    //   79: getfield 785	com/tencent/mm/g/a/iz$b:dNG	Z
    //   82: ifeq +87 -> 169
    //   85: new 427	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: getfield 780	com/tencent/mm/g/a/iz:dNE	Lcom/tencent/mm/g/a/iz$b;
    //   96: getfield 788	com/tencent/mm/g/a/iz$b:dNF	Ljava/lang/String;
    //   99: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 571	java/lang/String:getBytes	()[B
    //   106: invokestatic 794	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   109: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_3
    //   116: new 796	com/tencent/mm/av/a/a/c$a
    //   119: dup
    //   120: invokespecial 797	com/tencent/mm/av/a/a/c$a:<init>	()V
    //   123: astore 4
    //   125: aload 4
    //   127: iconst_1
    //   128: putfield 800	com/tencent/mm/av/a/a/c$a:jbf	Z
    //   131: aload 4
    //   133: aload_3
    //   134: putfield 803	com/tencent/mm/av/a/a/c$a:fullPath	Ljava/lang/String;
    //   137: aload 4
    //   139: invokevirtual 807	com/tencent/mm/av/a/a/c$a:bdv	()Lcom/tencent/mm/av/a/a/c;
    //   142: astore_3
    //   143: invokestatic 813	com/tencent/mm/av/q:bcV	()Lcom/tencent/mm/av/a/a;
    //   146: aload_0
    //   147: aconst_null
    //   148: aload_3
    //   149: new 8	com/tencent/mm/plugin/game/e/c$2
    //   152: dup
    //   153: aload_2
    //   154: invokespecial 816	com/tencent/mm/plugin/game/e/c$2:<init>	(Lcom/tencent/mm/g/a/iz;)V
    //   157: new 10	com/tencent/mm/plugin/game/e/c$3
    //   160: dup
    //   161: fload_1
    //   162: aload_2
    //   163: invokespecial 819	com/tencent/mm/plugin/game/e/c$3:<init>	(FLcom/tencent/mm/g/a/iz;)V
    //   166: invokevirtual 824	com/tencent/mm/av/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/av/a/a/c;Lcom/tencent/mm/av/a/c/k;Lcom/tencent/mm/av/a/c/h;)V
    //   169: ldc_w 758
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
    //   50	113	2	localiz	iz
    //   115	34	3	localObject	Object
    //   123	15	4	locala	com.tencent.mm.av.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	22	178	finally
    //   26	169	178	finally
    //   169	175	178	finally
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(42496);
    if (paramContext == null)
    {
      AppMethodBeat.o(42496);
      return 0;
    }
    if (xTo == null)
    {
      xTo = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(xTo);
    }
    int i = xTo.widthPixels;
    AppMethodBeat.o(42496);
    return i;
  }
  
  public static Dialog gl(Context paramContext)
  {
    AppMethodBeat.i(42502);
    View localView = View.inflate(paramContext, 2131494933, null);
    paramContext = new i(paramContext, 2131820984);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42492);
        this.xZb.setOnCancelListener(null);
        AppMethodBeat.o(42492);
      }
    });
    AppMethodBeat.o(42502);
    return paramContext;
  }
  
  public static boolean hR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42518);
    paramString1 = new com.tencent.mm.vfs.o(paramString1);
    String str = s.bhK(aa.z(paramString1.mUri));
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(str)))
    {
      Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      bool = paramString1.exists();
      AppMethodBeat.o(42518);
      return bool;
    }
    Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
    boolean bool = paramString2.equalsIgnoreCase(str);
    AppMethodBeat.o(42518);
    return bool;
  }
  
  public static int l(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(42510);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42510);
      return 0;
    }
    String str = e.dVa();
    HashMap localHashMap;
    if (!Util.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = F(str, localHashMap);; paramString = com.tencent.mm.plugin.game.a.xtm + "?appid=" + paramString)
    {
      paramInt = D(paramContext, paramString, "game_center_detail");
      AppMethodBeat.o(42510);
      return paramInt;
    }
  }
  
  public static int parseColor(String paramString)
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
  
  public static void w(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42513);
    if (aAK(paramIntent.getStringExtra("rawUrl")))
    {
      x(paramIntent, paramContext);
      AppMethodBeat.o(42513);
      return;
    }
    nr localnr = new nr();
    localnr.dTO.type = 0;
    localnr.dTO.context = paramContext;
    localnr.dTO.intent = paramIntent;
    EventCenter.instance.publish(localnr);
    AppMethodBeat.o(42513);
  }
  
  public static void x(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42514);
    nr localnr = new nr();
    localnr.dTO.type = 2;
    localnr.dTO.context = paramContext;
    localnr.dTO.intent = paramIntent;
    EventCenter.instance.publish(localnr);
    AppMethodBeat.o(42514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e.c
 * JD-Core Version:    0.7.0.1
 */