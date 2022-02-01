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
import com.tencent.mm.autogen.a.kq;
import com.tencent.mm.autogen.a.py;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.h.j;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.ax;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static DisplayMetrics IRP;
  private static int IXY;
  private static volatile MMHandler Itf;
  private static int maxSize;
  private static int oQY;
  private static Rect rect;
  private static final Object uqi;
  
  static
  {
    AppMethodBeat.i(42526);
    maxSize = -1;
    oQY = -1;
    IXY = -1;
    uqi = new Object();
    rect = new Rect();
    AppMethodBeat.o(42526);
  }
  
  public static LinkedList<String> D(JSONArray paramJSONArray)
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
  
  public static int I(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42498);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42498);
      return 0;
    }
    if (bb(paramContext, paramString1))
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
    AppMethodBeat.i(275392);
    f(paramContext, paramString1, paramString2, 0);
    AppMethodBeat.o(275392);
  }
  
  public static String P(String paramString, Map<String, String> paramMap)
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
      paramBundle = com.tencent.mm.plugin.game.model.a.fw(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.eQp == 2)
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
    int i = e.fGe();
    if (i == 2)
    {
      paramInt = m(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    if (i == 1)
    {
      i(paramContext, (Bundle)localObject);
      AppMethodBeat.o(42509);
      return 6;
    }
    paramString2 = Util.getSimCountryCode(paramContext);
    if ((Util.isNullOrNil(paramString2)) || (paramString2.toLowerCase().equals("cn")))
    {
      paramInt = m(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    i(paramContext, (Bundle)localObject);
    AppMethodBeat.o(42509);
    return 6;
  }
  
  public static void a(Context paramContext, o paramo, String paramString)
  {
    AppMethodBeat.i(42500);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramo.IDI.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.IDI.ItB);
    localIntent.putExtra("disable_progress_bar", paramo.IDI.ItB);
    int i = -1;
    switch (paramo.IDI.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramo = new py();
      paramo.hTd.type = 1;
      paramo.hTd.context = paramContext;
      paramo.hTd.intent = localIntent;
      paramo.publish();
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
  
  public static int aHj(String paramString)
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
  
  public static String aHk(String paramString)
  {
    AppMethodBeat.i(275400);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(275400);
      return "";
    }
    try
    {
      paramString = MMApplicationContext.getContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        AppMethodBeat.o(275400);
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
      AppMethodBeat.o(275400);
    }
    return paramString;
  }
  
  public static int aHl(String paramString)
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
  
  public static int aHm(String paramString)
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
  
  private static boolean aHn(String paramString)
  {
    AppMethodBeat.i(42521);
    if (!((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGB, true))
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
    if ((paramString.getHost() != null) && (paramString.getHost().equals(WeChatHosts.domainString(h.i.host_game_weixin_qq_com))))
    {
      AppMethodBeat.o(42521);
      return true;
    }
    AppMethodBeat.o(42521);
    return false;
  }
  
  public static LinkedList<String> aHo(String paramString)
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
  
  public static JSONArray aHp(String paramString)
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
  
  public static boolean aHq(String paramString)
  {
    AppMethodBeat.i(275441);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(275441);
      return false;
    }
    paramString = "NotDisturb_" + MD5Util.getMD5String(paramString);
    if (((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().aFI(paramString) == null)
    {
      AppMethodBeat.o(275441);
      return false;
    }
    AppMethodBeat.o(275441);
    return true;
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(42508);
    int i = a(paramContext, paramString1, paramString2, paramBundle, 0);
    AppMethodBeat.o(42508);
    return i;
  }
  
  public static boolean b(View paramView, Context paramContext)
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
  
  public static int ba(Context paramContext, String paramString)
  {
    AppMethodBeat.i(42497);
    int i = I(paramContext, paramString, null);
    AppMethodBeat.o(42497);
    return i;
  }
  
  public static boolean bb(Context paramContext, String paramString)
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
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
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
  
  public static void bx(LinkedList<String> paramLinkedList)
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
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(str, true, false);
      if ((localg != null) && (Util.isNullOrNil(localg.field_openId))) {
        localLinkedList.add(str);
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      com.tencent.mm.plugin.openapi.a.gxp().addAll(localLinkedList);
    }
    AppMethodBeat.o(42506);
  }
  
  public static String by(LinkedList<String> paramLinkedList)
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
  
  public static void cNl()
  {
    AppMethodBeat.i(42515);
    if (Itf == null)
    {
      AppMethodBeat.o(42515);
      return;
    }
    synchronized (uqi)
    {
      if (Itf != null)
      {
        com.tencent.mm.vending.h.g.bDQ("SubCoreGameCenter#WorkThread");
        Itf.quit();
        Itf = null;
      }
      AppMethodBeat.o(42515);
      return;
    }
  }
  
  public static void cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(275445);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(275445);
      return;
    }
    Log.i("MicroMsg.GameCenterUtil", "setNotDisturbMsg, msgRelatedId:%s, flag:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    paramString = "NotDisturb_" + MD5Util.getMD5String(paramString);
    if (paramBoolean)
    {
      ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().y(paramString, "1".getBytes());
      AppMethodBeat.o(275445);
      return;
    }
    ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().aGM(paramString);
    AppMethodBeat.o(275445);
  }
  
  public static MMHandler dqg()
  {
    AppMethodBeat.i(183911);
    if (Itf == null) {}
    synchronized (uqi)
    {
      if (Itf == null)
      {
        Itf = new MMHandler("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.cf.a("SubCoreGameCenter#WorkThread"));
      }
      ??? = Itf;
      AppMethodBeat.o(183911);
      return ???;
    }
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(275393);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.qAF = paramString2;
    localg.euz = paramInt;
    localg.scene = 1079;
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, localg);
    AppMethodBeat.o(275393);
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> fHZ()
  {
    AppMethodBeat.i(42507);
    Cursor localCursor = com.tencent.mm.plugin.openapi.a.gxn().iIy();
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
  
  public static String fIa()
  {
    AppMethodBeat.i(42520);
    Object localObject = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yHH, "");
    if ((localObject != null) && (!Util.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(42520);
        return null;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(42520);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.fFO();
    if ((((a.a)localObject).eQp == 2) && (!Util.isNullOrNil(((a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 12L, 1L, false);
      localObject = ((a.a)localObject).url;
      AppMethodBeat.o(42520);
      return localObject;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.IsN != null) && (com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting != null) && (com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting.IJb == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting.IJc;
      AppMethodBeat.o(42520);
      return localObject;
    }
    com.tencent.mm.plugin.game.commlib.a.fDQ();
    if ((com.tencent.mm.plugin.game.commlib.a.IsN != null) && (com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting != null) && (com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting.IJb == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting.IJc;
      AppMethodBeat.o(42520);
      return localObject;
    }
    AppMethodBeat.o(42520);
    return null;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(42496);
    if (paramContext == null)
    {
      AppMethodBeat.o(42496);
      return 0;
    }
    if (IRP == null)
    {
      IRP = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(IRP);
    }
    int i = IRP.widthPixels;
    AppMethodBeat.o(42496);
    return i;
  }
  
  public static Dialog hY(Context paramContext)
  {
    AppMethodBeat.i(42502);
    View localView = View.inflate(paramContext, h.f.Iad, null);
    paramContext = new i(paramContext, h.j.Icr);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42492);
        c.this.setOnCancelListener(null);
        AppMethodBeat.o(42492);
      }
    });
    AppMethodBeat.o(42502);
    return paramContext;
  }
  
  public static void i(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(42512);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
    localIntent.putExtras(paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBundle.aYi(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(42512);
  }
  
  /* Error */
  public static void i(String paramString, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 827
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 87	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 827
    //   19: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: ldc_w 292
    //   29: ldc_w 829
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 832	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 834	com/tencent/mm/autogen/a/kq
    //   46: dup
    //   47: invokespecial 835	com/tencent/mm/autogen/a/kq:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: getfield 839	com/tencent/mm/autogen/a/kq:hMl	Lcom/tencent/mm/autogen/a/kq$a;
    //   55: iconst_1
    //   56: putfield 844	com/tencent/mm/autogen/a/kq$a:bUl	I
    //   59: aload_2
    //   60: getfield 839	com/tencent/mm/autogen/a/kq:hMl	Lcom/tencent/mm/autogen/a/kq$a;
    //   63: aload_0
    //   64: putfield 845	com/tencent/mm/autogen/a/kq$a:url	Ljava/lang/String;
    //   67: aload_2
    //   68: invokevirtual 846	com/tencent/mm/autogen/a/kq:publish	()Z
    //   71: pop
    //   72: aload_2
    //   73: getfield 850	com/tencent/mm/autogen/a/kq:hMm	Lcom/tencent/mm/autogen/a/kq$b;
    //   76: getfield 855	com/tencent/mm/autogen/a/kq$b:hMo	Z
    //   79: ifeq +87 -> 166
    //   82: new 353	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   89: aload_2
    //   90: getfield 850	com/tencent/mm/autogen/a/kq:hMm	Lcom/tencent/mm/autogen/a/kq$b;
    //   93: getfield 858	com/tencent/mm/autogen/a/kq$b:hMn	Ljava/lang/String;
    //   96: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 585	java/lang/String:getBytes	()[B
    //   103: invokestatic 864	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   106: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_3
    //   113: new 866	com/tencent/mm/modelimage/loader/a/c$a
    //   116: dup
    //   117: invokespecial 867	com/tencent/mm/modelimage/loader/a/c$a:<init>	()V
    //   120: astore 4
    //   122: aload 4
    //   124: iconst_1
    //   125: putfield 870	com/tencent/mm/modelimage/loader/a/c$a:oKp	Z
    //   128: aload 4
    //   130: aload_3
    //   131: putfield 873	com/tencent/mm/modelimage/loader/a/c$a:fullPath	Ljava/lang/String;
    //   134: aload 4
    //   136: invokevirtual 877	com/tencent/mm/modelimage/loader/a/c$a:bKx	()Lcom/tencent/mm/modelimage/loader/a/c;
    //   139: astore_3
    //   140: invokestatic 883	com/tencent/mm/modelimage/r:bKe	()Lcom/tencent/mm/modelimage/loader/a;
    //   143: aload_0
    //   144: aconst_null
    //   145: aload_3
    //   146: new 8	com/tencent/mm/plugin/game/d/c$2
    //   149: dup
    //   150: aload_2
    //   151: invokespecial 886	com/tencent/mm/plugin/game/d/c$2:<init>	(Lcom/tencent/mm/autogen/a/kq;)V
    //   154: new 10	com/tencent/mm/plugin/game/d/c$3
    //   157: dup
    //   158: fload_1
    //   159: aload_2
    //   160: invokespecial 889	com/tencent/mm/plugin/game/d/c$3:<init>	(FLcom/tencent/mm/autogen/a/kq;)V
    //   163: invokevirtual 894	com/tencent/mm/modelimage/loader/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/modelimage/loader/a/c;Lcom/tencent/mm/modelimage/loader/b/k;Lcom/tencent/mm/modelimage/loader/b/h;)V
    //   166: ldc_w 827
    //   169: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: goto -150 -> 22
    //   175: astore_0
    //   176: ldc 2
    //   178: monitorexit
    //   179: aload_0
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   0	181	1	paramFloat	float
    //   50	110	2	localkq	kq
    //   112	34	3	localObject	Object
    //   120	15	4	locala	com.tencent.mm.modelimage.loader.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	22	175	finally
    //   26	166	175	finally
    //   166	172	175	finally
  }
  
  public static boolean jh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42518);
    paramString1 = new u(paramString1);
    String str = y.bub(ah.v(paramString1.mUri));
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(str)))
    {
      Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      bool = paramString1.jKS();
      AppMethodBeat.o(42518);
      return bool;
    }
    Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
    boolean bool = paramString2.equalsIgnoreCase(str);
    AppMethodBeat.o(42518);
    return bool;
  }
  
  public static int m(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(42510);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42510);
      return 0;
    }
    String str = e.fGd();
    HashMap localHashMap;
    if (!Util.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = P(str, localHashMap);; paramString = WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/gamecenter/detail.html?appid=" + paramString)
    {
      paramInt = I(paramContext, paramString, "game_center_detail");
      AppMethodBeat.o(42510);
      return paramInt;
    }
  }
  
  public static void rH(long paramLong)
  {
    AppMethodBeat.i(42519);
    com.tencent.mm.plugin.downloader.h.a.a(paramLong, false, null);
    AppMethodBeat.o(42519);
  }
  
  public static void v(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42513);
    if (aHn(paramIntent.getStringExtra("rawUrl")))
    {
      w(paramIntent, paramContext);
      AppMethodBeat.o(42513);
      return;
    }
    py localpy = new py();
    localpy.hTd.type = 0;
    localpy.hTd.context = paramContext;
    localpy.hTd.intent = paramIntent;
    localpy.publish();
    AppMethodBeat.o(42513);
  }
  
  public static void w(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42514);
    py localpy = new py();
    localpy.hTd.type = 2;
    localpy.hTd.context = paramContext;
    localpy.hTd.intent = paramIntent;
    localpy.publish();
    AppMethodBeat.o(42514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.c
 * JD-Core Version:    0.7.0.1
 */