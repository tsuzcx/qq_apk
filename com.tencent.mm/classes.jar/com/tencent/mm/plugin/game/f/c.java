package com.tencent.mm.plugin.game.f;

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
import com.tencent.mm.aw.a.c.k;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static int ijq;
  private static final Object mOt;
  private static int maxSize;
  private static Rect rect;
  private static volatile ap tSX;
  private static DisplayMetrics upU;
  private static int uvp;
  
  static
  {
    AppMethodBeat.i(42526);
    maxSize = -1;
    ijq = -1;
    uvp = -1;
    mOt = new Object();
    rect = new Rect();
    AppMethodBeat.o(42526);
  }
  
  public static int B(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42498);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42498);
      return 0;
    }
    if (aC(paramContext, paramString1))
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
    AppMethodBeat.i(206954);
    b(paramContext, paramString1, paramString2, 0);
    AppMethodBeat.o(206954);
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
    if (!bt.isNullOrNil(paramString1))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = com.tencent.mm.plugin.game.model.a.dP(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.dDp == 2)
      {
        localObject = localBundle;
        if (!bt.isNullOrNil(paramBundle.url))
        {
          paramInt = B(paramContext, paramBundle.url, "game_center_detail");
          AppMethodBeat.o(42509);
          return paramInt;
        }
      }
    }
    if (!bt.isNullOrNil(paramString2))
    {
      paramInt = B(paramContext, paramString2, "game_center_detail");
      AppMethodBeat.o(42509);
      return paramInt;
    }
    int i = com.tencent.mm.plugin.game.model.e.cYK();
    if (i == 2)
    {
      paramInt = m(paramContext, paramString1, paramInt);
      AppMethodBeat.o(42509);
      return paramInt;
    }
    if (i == 1)
    {
      f(paramContext, (Bundle)localObject);
      AppMethodBeat.o(42509);
      return 6;
    }
    paramString2 = bt.jg(paramContext);
    if ((bt.isNullOrNil(paramString2)) || (paramString2.toLowerCase().equals("cn")))
    {
      paramInt = m(paramContext, paramString1, paramInt);
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
    localIntent.putExtra("rawUrl", paramo.ucc.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.ucc.tTj);
    localIntent.putExtra("disable_progress_bar", paramo.ucc.tTj);
    int i = -1;
    switch (paramo.ucc.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramo = new mz();
      paramo.dAU.type = 1;
      paramo.dAU.context = paramContext;
      paramo.dAU.intent = localIntent;
      com.tencent.mm.sdk.b.a.IbL.l(paramo);
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
      ad.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(42501);
      return false;
    }
    paramView = (String)paramView.getTag();
    if (bt.isNullOrNil(paramView))
    {
      ad.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
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
  
  public static int aB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(42497);
    int i = B(paramContext, paramString, null);
    AppMethodBeat.o(42497);
    return i;
  }
  
  public static void aC(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42506);
    if (bt.hj(paramLinkedList))
    {
      AppMethodBeat.o(42506);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(str, true, false);
      if ((localg != null) && (bt.isNullOrNil(localg.field_openId))) {
        localLinkedList.add(str);
      }
    }
    if (!bt.hj(localLinkedList)) {
      com.tencent.mm.plugin.s.a.dxS().addAll(localLinkedList);
    }
    AppMethodBeat.o(42506);
  }
  
  public static boolean aC(Context paramContext, String paramString)
  {
    int j = 2;
    AppMethodBeat.i(42499);
    paramString = Uri.parse(paramString).getQueryParameter("weapp");
    if (!bt.isNullOrNil(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Uri.parse(paramString);
        paramString = ((Uri)localObject1).getAuthority();
        if (bt.isNullOrNil(paramString))
        {
          ad.w("MicroMsg.GameCenterUtil", "targetAppId is null");
          AppMethodBeat.o(42499);
          return false;
        }
        localObject2 = ((Uri)localObject1).getQueryParameter("env_version");
        localObject1 = ((Uri)localObject1).getQueryParameter("path");
        localObject2 = bt.nullAsNil((String)localObject2);
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 1559690845: 
          ad.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", new Object[] { paramString, Integer.valueOf(j), localObject1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).scene = 1079;
          ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
          AppMethodBeat.o(42499);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        boolean bool;
        ad.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + paramContext.getMessage());
      }
      if (((String)localObject2).equals("develop"))
      {
        i = 0;
        break label271;
        bool = ((String)localObject2).equals("trial");
        if (bool)
        {
          i = 1;
          break label271;
          j = 1;
          continue;
          AppMethodBeat.o(42499);
          return false;
        }
      }
      label271:
      switch (i)
      {
      }
      j = 0;
    }
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
  
  public static int ams(String paramString)
  {
    AppMethodBeat.i(42503);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(42503);
      return 0;
    }
    try
    {
      paramString = aj.getContext().getPackageManager().getPackageInfo(paramString, 0);
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
        ad.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[] { paramString.toString() });
        paramString = null;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(42503);
      return i;
    }
  }
  
  public static int amt(String paramString)
  {
    AppMethodBeat.i(42504);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.GameCenterUtil", "Null or Nil path");
      AppMethodBeat.o(42504);
      return 0;
    }
    paramString = aj.getContext().getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(42504);
      return 0;
    }
    int i = paramString.versionCode;
    AppMethodBeat.o(42504);
    return i;
  }
  
  private static boolean amu(String paramString)
  {
    AppMethodBeat.i(42521);
    if (!((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qpL, true))
    {
      AppMethodBeat.o(42521);
      return false;
    }
    if (bt.isNullOrNil(paramString))
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
  
  public static LinkedList<String> amv(String paramString)
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
  
  public static JSONArray amw(String paramString)
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
    AppMethodBeat.i(206955);
    f localf = new f();
    localf.appId = paramString1;
    localf.jCN = paramString2;
    localf.hQh = paramInt;
    localf.scene = 1079;
    ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(paramContext, localf);
    AppMethodBeat.o(206955);
  }
  
  public static void bBo()
  {
    AppMethodBeat.i(42515);
    if (tSX == null)
    {
      AppMethodBeat.o(42515);
      return;
    }
    synchronized (mOt)
    {
      if (tSX != null)
      {
        com.tencent.mm.vending.h.g.aXZ("SubCoreGameCenter#WorkThread");
        tSX.quit();
        tSX = null;
      }
      AppMethodBeat.o(42515);
      return;
    }
  }
  
  public static ap bZb()
  {
    AppMethodBeat.i(183911);
    if (tSX == null) {}
    synchronized (mOt)
    {
      if (tSX == null)
      {
        tSX = new ap("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.ce.a("SubCoreGameCenter#WorkThread"));
      }
      ??? = tSX;
      AppMethodBeat.o(183911);
      return ???;
    }
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> dat()
  {
    AppMethodBeat.i(42507);
    Cursor localCursor = com.tencent.mm.plugin.s.a.dxQ().eZY();
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null) {
      ad.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
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
  
  public static String dau()
  {
    AppMethodBeat.i(42520);
    Object localObject = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qqq, "");
    if ((localObject != null) && (!bt.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(42520);
        return null;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(42520);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.cYu();
    if ((((a.a)localObject).dDp == 2) && (!bt.isNullOrNil(((a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 12L, 1L, false);
      localObject = ((a.a)localObject).url;
      AppMethodBeat.o(42520);
      return localObject;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.tSI != null) && (com.tencent.mm.plugin.game.commlib.a.tSI.uhy != null) && (com.tencent.mm.plugin.game.commlib.a.tSI.uhy.ugV == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.tSI.uhy.ugW;
      AppMethodBeat.o(42520);
      return localObject;
    }
    com.tencent.mm.plugin.game.commlib.a.cWO();
    if ((com.tencent.mm.plugin.game.commlib.a.tSI != null) && (com.tencent.mm.plugin.game.commlib.a.tSI.uhy != null) && (com.tencent.mm.plugin.game.commlib.a.tSI.uhy.ugV == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.tSI.uhy.ugW;
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
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.ahp(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(42512);
  }
  
  public static Dialog fA(Context paramContext)
  {
    AppMethodBeat.i(42502);
    View localView = View.inflate(paramContext, 2131494367, null);
    paramContext = new com.tencent.mm.ui.base.i(paramContext, 2131820969);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(42492);
        this.uvq.setOnCancelListener(null);
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
    if (upU == null)
    {
      upU = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(upU);
    }
    int i = upU.widthPixels;
    AppMethodBeat.o(42496);
    return i;
  }
  
  public static boolean hd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42518);
    paramString1 = new com.tencent.mm.vfs.e(paramString1);
    String str = com.tencent.mm.vfs.i.aPK(q.B(paramString1.mUri));
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(str)))
    {
      ad.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      bool = paramString1.exists();
      AppMethodBeat.o(42518);
      return bool;
    }
    ad.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
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
    //   3: ldc_w 747
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 60	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 747
    //   19: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: ldc 229
    //   28: ldc_w 749
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokestatic 752	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: new 754	com/tencent/mm/g/a/ij
    //   45: dup
    //   46: invokespecial 755	com/tencent/mm/g/a/ij:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: getfield 759	com/tencent/mm/g/a/ij:duR	Lcom/tencent/mm/g/a/ij$a;
    //   54: iconst_1
    //   55: putfield 764	com/tencent/mm/g/a/ij$a:EN	I
    //   58: aload_2
    //   59: getfield 759	com/tencent/mm/g/a/ij:duR	Lcom/tencent/mm/g/a/ij$a;
    //   62: aload_0
    //   63: putfield 765	com/tencent/mm/g/a/ij$a:url	Ljava/lang/String;
    //   66: getstatic 215	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   69: aload_2
    //   70: invokevirtual 219	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   73: pop
    //   74: aload_2
    //   75: getfield 769	com/tencent/mm/g/a/ij:duS	Lcom/tencent/mm/g/a/ij$b;
    //   78: getfield 774	com/tencent/mm/g/a/ij$b:duU	Z
    //   81: ifeq +87 -> 168
    //   84: new 356	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 377	java/lang/StringBuilder:<init>	()V
    //   91: aload_2
    //   92: getfield 769	com/tencent/mm/g/a/ij:duS	Lcom/tencent/mm/g/a/ij$b;
    //   95: getfield 777	com/tencent/mm/g/a/ij$b:duT	Ljava/lang/String;
    //   98: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 781	java/lang/String:getBytes	()[B
    //   105: invokestatic 787	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   108: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore_3
    //   115: new 789	com/tencent/mm/aw/a/a/c$a
    //   118: dup
    //   119: invokespecial 790	com/tencent/mm/aw/a/a/c$a:<init>	()V
    //   122: astore 4
    //   124: aload 4
    //   126: iconst_1
    //   127: putfield 793	com/tencent/mm/aw/a/a/c$a:idr	Z
    //   130: aload 4
    //   132: aload_3
    //   133: putfield 796	com/tencent/mm/aw/a/a/c$a:hdP	Ljava/lang/String;
    //   136: aload 4
    //   138: invokevirtual 800	com/tencent/mm/aw/a/a/c$a:aJc	()Lcom/tencent/mm/aw/a/a/c;
    //   141: astore_3
    //   142: invokestatic 806	com/tencent/mm/aw/q:aIJ	()Lcom/tencent/mm/aw/a/a;
    //   145: aload_0
    //   146: aconst_null
    //   147: aload_3
    //   148: new 8	com/tencent/mm/plugin/game/f/c$2
    //   151: dup
    //   152: aload_2
    //   153: invokespecial 809	com/tencent/mm/plugin/game/f/c$2:<init>	(Lcom/tencent/mm/g/a/ij;)V
    //   156: new 10	com/tencent/mm/plugin/game/f/c$3
    //   159: dup
    //   160: fload_1
    //   161: aload_2
    //   162: invokespecial 812	com/tencent/mm/plugin/game/f/c$3:<init>	(FLcom/tencent/mm/g/a/ij;)V
    //   165: invokevirtual 817	com/tencent/mm/aw/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/aw/a/a/c;Lcom/tencent/mm/aw/a/c/k;Lcom/tencent/mm/aw/a/c/h;)V
    //   168: ldc_w 747
    //   171: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: goto -152 -> 22
    //   177: astore_0
    //   178: ldc 2
    //   180: monitorexit
    //   181: aload_0
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   0	183	1	paramFloat	float
    //   49	113	2	localij	ij
    //   114	34	3	localObject	Object
    //   122	15	4	locala	com.tencent.mm.aw.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	22	177	finally
    //   26	168	177	finally
    //   168	174	177	finally
  }
  
  public static int m(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(42510);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42510);
      return 0;
    }
    String str = com.tencent.mm.plugin.game.model.e.cYJ();
    HashMap localHashMap;
    if (!bt.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = z(str, localHashMap);; paramString = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=".concat(String.valueOf(paramString)))
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
        ad.e("MicroMsg.GameCenterUtil", "parseColor: " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(42517);
    return i;
  }
  
  public static void x(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42513);
    if (amu(paramIntent.getStringExtra("rawUrl")))
    {
      y(paramIntent, paramContext);
      AppMethodBeat.o(42513);
      return;
    }
    mz localmz = new mz();
    localmz.dAU.type = 0;
    localmz.dAU.context = paramContext;
    localmz.dAU.intent = paramIntent;
    com.tencent.mm.sdk.b.a.IbL.l(localmz);
    AppMethodBeat.o(42513);
  }
  
  public static void xG(long paramLong)
  {
    AppMethodBeat.i(42519);
    com.tencent.mm.plugin.downloader.i.a.a(paramLong, false, null);
    AppMethodBeat.o(42519);
  }
  
  public static LinkedList<String> y(JSONArray paramJSONArray)
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
  
  public static void y(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42514);
    mz localmz = new mz();
    localmz.dAU.type = 2;
    localmz.dAU.context = paramContext;
    localmz.dAU.intent = paramIntent;
    com.tencent.mm.sdk.b.a.IbL.l(localmz);
    AppMethodBeat.o(42514);
  }
  
  public static String z(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(42511);
    if ((bt.isNullOrNil(paramString)) || (paramMap.isEmpty()))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c
 * JD-Core Version:    0.7.0.1
 */