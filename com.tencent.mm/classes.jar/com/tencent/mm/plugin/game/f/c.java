package com.tencent.mm.plugin.game.f;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
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
import com.tencent.mm.g.a.na;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static int imj;
  private static final Object mTx;
  private static int maxSize;
  private static Rect rect;
  private static DisplayMetrics uBq;
  private static int uGO;
  private static volatile aq udO;
  
  static
  {
    AppMethodBeat.i(42526);
    maxSize = -1;
    imj = -1;
    uGO = -1;
    mTx = new Object();
    rect = new Rect();
    AppMethodBeat.o(42526);
  }
  
  public static String A(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(42511);
    if ((bu.isNullOrNil(paramString)) || (paramMap.isEmpty()))
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
  
  public static int B(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42498);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42498);
      return 0;
    }
    if (aE(paramContext, paramString1))
    {
      AppMethodBeat.o(42498);
      return 30;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("geta8key_scene", 32);
    localIntent.putExtra("KPublisherId", paramString2);
    x(localIntent, paramContext);
    AppMethodBeat.o(42498);
    return 7;
  }
  
  public static void C(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(195784);
    b(paramContext, paramString1, paramString2, 0);
    AppMethodBeat.o(195784);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(42508);
    int i = a(paramContext, paramString1, paramString2, paramBundle, 0);
    AppMethodBeat.o(42508);
    return i;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(42509);
    Object localObject = paramBundle;
    if (!bu.isNullOrNil(paramString1))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = com.tencent.mm.plugin.game.model.a.dT(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.dEu == 2)
      {
        localObject = localBundle;
        if (!bu.isNullOrNil(paramBundle.url))
        {
          paramInt = B(paramContext, paramBundle.url, "game_center_detail");
          AppMethodBeat.o(42509);
          return paramInt;
        }
      }
    }
    if (!bu.isNullOrNil(paramString2))
    {
      paramInt = B(paramContext, paramString2, "game_center_detail");
      AppMethodBeat.o(42509);
      return paramInt;
    }
    int i = e.dbu();
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
    paramString2 = bu.jm(paramContext);
    if ((bu.isNullOrNil(paramString2)) || (paramString2.toLowerCase().equals("cn")))
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
    localIntent.putExtra("rawUrl", paramo.une.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.une.uea);
    localIntent.putExtra("disable_progress_bar", paramo.une.uea);
    int i = -1;
    switch (paramo.une.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramo = new na();
      paramo.dBZ.type = 1;
      paramo.dBZ.context = paramContext;
      paramo.dBZ.intent = localIntent;
      com.tencent.mm.sdk.b.a.IvT.l(paramo);
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
      ae.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(42501);
      return false;
    }
    paramView = (String)paramView.getTag();
    if (bu.isNullOrNil(paramView))
    {
      ae.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(42501);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("show_bottom", false);
    x(localIntent, paramContext);
    AppMethodBeat.o(42501);
    return true;
  }
  
  public static void aC(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42506);
    if (bu.ht(paramLinkedList))
    {
      AppMethodBeat.o(42506);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      com.tencent.mm.pluginsdk.model.app.g localg = h.m(str, true, false);
      if ((localg != null) && (bu.isNullOrNil(localg.field_openId))) {
        localLinkedList.add(str);
      }
    }
    if (!bu.ht(localLinkedList)) {
      com.tencent.mm.plugin.s.a.dBi().addAll(localLinkedList);
    }
    AppMethodBeat.o(42506);
  }
  
  public static int aD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(42497);
    int i = B(paramContext, paramString, null);
    AppMethodBeat.o(42497);
    return i;
  }
  
  public static String aD(LinkedList<String> paramLinkedList)
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
  
  public static boolean aE(Context paramContext, String paramString)
  {
    int j = 2;
    AppMethodBeat.i(42499);
    paramString = Uri.parse(paramString).getQueryParameter("weapp");
    if (!bu.isNullOrNil(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Uri.parse(paramString);
        paramString = ((Uri)localObject1).getAuthority();
        if (bu.isNullOrNil(paramString))
        {
          ae.w("MicroMsg.GameCenterUtil", "targetAppId is null");
          AppMethodBeat.o(42499);
          return false;
        }
        localObject2 = ((Uri)localObject1).getQueryParameter("env_version");
        localObject1 = ((Uri)localObject1).getQueryParameter("path");
        localObject2 = bu.nullAsNil((String)localObject2);
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 1559690845: 
          ae.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", new Object[] { paramString, Integer.valueOf(j), localObject1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).scene = 1079;
          ((p)com.tencent.mm.kernel.g.ab(p.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
          AppMethodBeat.o(42499);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        boolean bool;
        ae.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + paramContext.getMessage());
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
  
  public static int anq(String paramString)
  {
    AppMethodBeat.i(42503);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(42503);
      return 0;
    }
    try
    {
      paramString = ak.getContext().getPackageManager().getPackageInfo(paramString, 0);
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
        ae.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[] { paramString.toString() });
        paramString = null;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(42503);
      return i;
    }
  }
  
  public static int anr(String paramString)
  {
    AppMethodBeat.i(42504);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.GameCenterUtil", "Null or Nil path");
      AppMethodBeat.o(42504);
      return 0;
    }
    paramString = ak.getContext().getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(42504);
      return 0;
    }
    int i = paramString.versionCode;
    AppMethodBeat.o(42504);
    return i;
  }
  
  private static boolean ans(String paramString)
  {
    AppMethodBeat.i(42521);
    if (!((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qws, true))
    {
      AppMethodBeat.o(42521);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42521);
      return false;
    }
    paramString = Uri.parse(paramString);
    if ((paramString.getHost() != null) && (paramString.getHost().equals("game.weixin.qq.com")))
    {
      AppMethodBeat.o(42521);
      return true;
    }
    AppMethodBeat.o(42521);
    return false;
  }
  
  public static LinkedList<String> ant(String paramString)
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
  
  public static JSONArray anu(String paramString)
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
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195785);
    f localf = new f();
    localf.appId = paramString1;
    localf.jFL = paramString2;
    localf.hSZ = paramInt;
    localf.scene = 1079;
    ((p)com.tencent.mm.kernel.g.ab(p.class)).a(paramContext, localf);
    AppMethodBeat.o(195785);
  }
  
  public static void bCi()
  {
    AppMethodBeat.i(42515);
    if (udO == null)
    {
      AppMethodBeat.o(42515);
      return;
    }
    synchronized (mTx)
    {
      if (udO != null)
      {
        com.tencent.mm.vending.h.g.aZB("SubCoreGameCenter#WorkThread");
        udO.quit();
        udO = null;
      }
      AppMethodBeat.o(42515);
      return;
    }
  }
  
  public static aq caq()
  {
    AppMethodBeat.i(183911);
    if (udO == null) {}
    synchronized (mTx)
    {
      if (udO == null)
      {
        udO = new aq("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.cd.a("SubCoreGameCenter#WorkThread"));
      }
      ??? = udO;
      AppMethodBeat.o(183911);
      return ???;
    }
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> ddf()
  {
    AppMethodBeat.i(42507);
    Cursor localCursor = com.tencent.mm.plugin.s.a.dBg().fdM();
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null) {
      ae.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
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
  
  public static String ddg()
  {
    AppMethodBeat.i(42520);
    Object localObject = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwY, "");
    if ((localObject != null) && (!bu.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(42520);
        return null;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(42520);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.dbe();
    if ((((a.a)localObject).dEu == 2) && (!bu.isNullOrNil(((a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 12L, 1L, false);
      localObject = ((a.a)localObject).url;
      AppMethodBeat.o(42520);
      return localObject;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.udz != null) && (com.tencent.mm.plugin.game.commlib.a.udz.usW != null) && (com.tencent.mm.plugin.game.commlib.a.udz.usW.uss == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.udz.usW.ust;
      AppMethodBeat.o(42520);
      return localObject;
    }
    com.tencent.mm.plugin.game.commlib.a.cZs();
    if ((com.tencent.mm.plugin.game.commlib.a.udz != null) && (com.tencent.mm.plugin.game.commlib.a.udz.usW != null) && (com.tencent.mm.plugin.game.commlib.a.udz.usW.uss == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.udz.usW.ust;
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
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.ahE(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(42512);
  }
  
  public static Dialog fF(Context paramContext)
  {
    AppMethodBeat.i(42502);
    View localView = View.inflate(paramContext, 2131494367, null);
    paramContext = new i(paramContext, 2131820969);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42492);
        this.uGP.setOnCancelListener(null);
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
    if (uBq == null)
    {
      uBq = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(uBq);
    }
    int i = uBq.widthPixels;
    AppMethodBeat.o(42496);
    return i;
  }
  
  public static boolean hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42518);
    paramString1 = new k(paramString1);
    String str = com.tencent.mm.vfs.o.aRh(w.B(paramString1.mUri));
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(str)))
    {
      ae.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      bool = paramString1.exists();
      AppMethodBeat.o(42518);
      return bool;
    }
    ae.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
    boolean bool = paramString2.equalsIgnoreCase(str);
    AppMethodBeat.o(42518);
    return bool;
  }
  
  /* Error */
  public static void i(String paramString, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 778
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 56	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 778
    //   19: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: ldc_w 280
    //   29: ldc_w 780
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 783	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 785	com/tencent/mm/g/a/ik
    //   46: dup
    //   47: invokespecial 786	com/tencent/mm/g/a/ik:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: getfield 790	com/tencent/mm/g/a/ik:dvW	Lcom/tencent/mm/g/a/ik$a;
    //   55: iconst_1
    //   56: putfield 795	com/tencent/mm/g/a/ik$a:EN	I
    //   59: aload_2
    //   60: getfield 790	com/tencent/mm/g/a/ik:dvW	Lcom/tencent/mm/g/a/ik$a;
    //   63: aload_0
    //   64: putfield 796	com/tencent/mm/g/a/ik$a:url	Ljava/lang/String;
    //   67: getstatic 268	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   70: aload_2
    //   71: invokevirtual 271	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   74: pop
    //   75: aload_2
    //   76: getfield 800	com/tencent/mm/g/a/ik:dvX	Lcom/tencent/mm/g/a/ik$b;
    //   79: getfield 805	com/tencent/mm/g/a/ik$b:dvZ	Z
    //   82: ifeq +87 -> 169
    //   85: new 335	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   92: aload_2
    //   93: getfield 800	com/tencent/mm/g/a/ik:dvX	Lcom/tencent/mm/g/a/ik$b;
    //   96: getfield 808	com/tencent/mm/g/a/ik$b:dvY	Ljava/lang/String;
    //   99: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 812	java/lang/String:getBytes	()[B
    //   106: invokestatic 818	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   109: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_3
    //   116: new 820	com/tencent/mm/av/a/a/c$a
    //   119: dup
    //   120: invokespecial 821	com/tencent/mm/av/a/a/c$a:<init>	()V
    //   123: astore 4
    //   125: aload 4
    //   127: iconst_1
    //   128: putfield 824	com/tencent/mm/av/a/a/c$a:igk	Z
    //   131: aload 4
    //   133: aload_3
    //   134: putfield 827	com/tencent/mm/av/a/a/c$a:hgD	Ljava/lang/String;
    //   137: aload 4
    //   139: invokevirtual 831	com/tencent/mm/av/a/a/c$a:aJu	()Lcom/tencent/mm/av/a/a/c;
    //   142: astore_3
    //   143: invokestatic 837	com/tencent/mm/av/q:aJb	()Lcom/tencent/mm/av/a/a;
    //   146: aload_0
    //   147: aconst_null
    //   148: aload_3
    //   149: new 839	com/tencent/mm/plugin/game/f/c$2
    //   152: dup
    //   153: aload_2
    //   154: invokespecial 842	com/tencent/mm/plugin/game/f/c$2:<init>	(Lcom/tencent/mm/g/a/ik;)V
    //   157: new 844	com/tencent/mm/plugin/game/f/c$3
    //   160: dup
    //   161: fload_1
    //   162: aload_2
    //   163: invokespecial 847	com/tencent/mm/plugin/game/f/c$3:<init>	(FLcom/tencent/mm/g/a/ik;)V
    //   166: invokevirtual 852	com/tencent/mm/av/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/av/a/a/c;Lcom/tencent/mm/av/a/c/k;Lcom/tencent/mm/av/a/c/h;)V
    //   169: ldc_w 778
    //   172: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   50	113	2	localik	com.tencent.mm.g.a.ik
    //   115	34	3	localObject	Object
    //   123	15	4	locala	com.tencent.mm.av.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	22	178	finally
    //   26	169	178	finally
    //   169	175	178	finally
  }
  
  public static int l(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(42510);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42510);
      return 0;
    }
    String str = e.dbt();
    HashMap localHashMap;
    if (!bu.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = A(str, localHashMap);; paramString = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=".concat(String.valueOf(paramString)))
    {
      paramInt = B(paramContext, paramString, "game_center_detail");
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
        ae.e("MicroMsg.GameCenterUtil", "parseColor: " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(42517);
    return i;
  }
  
  public static void x(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42513);
    if (ans(paramIntent.getStringExtra("rawUrl")))
    {
      y(paramIntent, paramContext);
      AppMethodBeat.o(42513);
      return;
    }
    na localna = new na();
    localna.dBZ.type = 0;
    localna.dBZ.context = paramContext;
    localna.dBZ.intent = paramIntent;
    com.tencent.mm.sdk.b.a.IvT.l(localna);
    AppMethodBeat.o(42513);
  }
  
  public static void y(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42514);
    na localna = new na();
    localna.dBZ.type = 2;
    localna.dBZ.context = paramContext;
    localna.dBZ.intent = paramIntent;
    com.tencent.mm.sdk.b.a.IvT.l(localna);
    AppMethodBeat.o(42514);
  }
  
  public static void ya(long paramLong)
  {
    AppMethodBeat.i(42519);
    com.tencent.mm.plugin.downloader.i.a.a(paramLong, false, null);
    AppMethodBeat.o(42519);
  }
  
  public static LinkedList<String> z(JSONArray paramJSONArray)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c
 * JD-Core Version:    0.7.0.1
 */