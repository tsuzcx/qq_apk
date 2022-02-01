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
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static int hpA;
  private static final Object lLU;
  private static int maxSize;
  private static volatile ap rOz;
  private static Rect rect;
  private static DisplayMetrics sjE;
  private static int sok;
  
  static
  {
    AppMethodBeat.i(42526);
    maxSize = -1;
    hpA = -1;
    sok = -1;
    lLU = new Object();
    rect = new Rect();
    AppMethodBeat.o(42526);
  }
  
  public static int A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42498);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42498);
      return 0;
    }
    if (ay(paramContext, paramString1))
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
      paramBundle = com.tencent.mm.plugin.game.model.a.ds(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.dtM == 2)
      {
        localObject = localBundle;
        if (!bt.isNullOrNil(paramBundle.url))
        {
          paramInt = A(paramContext, paramBundle.url, "game_center_detail");
          AppMethodBeat.o(42509);
          return paramInt;
        }
      }
    }
    if (!bt.isNullOrNil(paramString2))
    {
      paramInt = A(paramContext, paramString2, "game_center_detail");
      AppMethodBeat.o(42509);
      return paramInt;
    }
    int i = com.tencent.mm.plugin.game.model.e.cCV();
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
    paramString2 = bt.iL(paramContext);
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
  
  public static void a(Context paramContext, o paramo, String paramString)
  {
    AppMethodBeat.i(42500);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramo.rWu.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.rWu.rOL);
    localIntent.putExtra("disable_progress_bar", paramo.rWu.rOL);
    int i = -1;
    switch (paramo.rWu.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramo = new mi();
      paramo.drw.type = 1;
      paramo.drw.context = paramContext;
      paramo.drw.intent = localIntent;
      com.tencent.mm.sdk.b.a.ESL.l(paramo);
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
  
  public static int acX(String paramString)
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
  
  public static int acY(String paramString)
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
  
  private static boolean acZ(String paramString)
  {
    AppMethodBeat.i(42521);
    if (!((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.piL, true))
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
  
  public static LinkedList<String> ada(String paramString)
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
  
  public static JSONArray adb(String paramString)
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
  
  public static void at(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42506);
    if (bt.gL(paramLinkedList))
    {
      AppMethodBeat.o(42506);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.j(str, true, false);
      if ((localg != null) && (bt.isNullOrNil(localg.field_openId))) {
        localLinkedList.add(str);
      }
    }
    if (!bt.gL(localLinkedList)) {
      com.tencent.mm.plugin.s.a.cZS().addAll(localLinkedList);
    }
    AppMethodBeat.o(42506);
  }
  
  public static String au(LinkedList<String> paramLinkedList)
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
  
  public static int ax(Context paramContext, String paramString)
  {
    AppMethodBeat.i(42497);
    int i = A(paramContext, paramString, null);
    AppMethodBeat.o(42497);
    return i;
  }
  
  public static boolean ay(Context paramContext, String paramString)
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
          ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
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
  
  public static ap bNl()
  {
    AppMethodBeat.i(183911);
    if (rOz == null) {}
    synchronized (lLU)
    {
      if (rOz == null)
      {
        rOz = new ap("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.cf.a("SubCoreGameCenter#WorkThread"));
      }
      ??? = rOz;
      AppMethodBeat.o(183911);
      return ???;
    }
  }
  
  public static void bql()
  {
    AppMethodBeat.i(42515);
    if (rOz == null)
    {
      AppMethodBeat.o(42515);
      return;
    }
    synchronized (lLU)
    {
      if (rOz != null)
      {
        com.tencent.mm.vending.h.g.aMy("SubCoreGameCenter#WorkThread");
        rOz.quit();
        rOz = null;
      }
      AppMethodBeat.o(42515);
      return;
    }
  }
  
  public static String cEA()
  {
    AppMethodBeat.i(42520);
    Object localObject = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pjj, "");
    if ((localObject != null) && (!bt.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(42520);
        return null;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(42520);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.cCF();
    if ((((a.a)localObject).dtM == 2) && (!bt.isNullOrNil(((a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(848L, 12L, 1L, false);
      localObject = ((a.a)localObject).url;
      AppMethodBeat.o(42520);
      return localObject;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.rOm != null) && (com.tencent.mm.plugin.game.commlib.a.rOm.sbE != null) && (com.tencent.mm.plugin.game.commlib.a.rOm.sbE.sbg == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.rOm.sbE.sbh;
      AppMethodBeat.o(42520);
      return localObject;
    }
    com.tencent.mm.plugin.game.commlib.a.cBk();
    if ((com.tencent.mm.plugin.game.commlib.a.rOm != null) && (com.tencent.mm.plugin.game.commlib.a.rOm.sbE != null) && (com.tencent.mm.plugin.game.commlib.a.rOm.sbE.sbg == 1))
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.rOm.sbE.sbh;
      AppMethodBeat.o(42520);
      return localObject;
    }
    AppMethodBeat.o(42520);
    return null;
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> cEz()
  {
    AppMethodBeat.i(42507);
    Cursor localCursor = com.tencent.mm.plugin.s.a.cZQ().evK();
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
  
  public static void f(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(42512);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
    localIntent.putExtras(paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.adn(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(42512);
  }
  
  public static Dialog fi(Context paramContext)
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
        this.sol.setOnCancelListener(null);
        AppMethodBeat.o(42492);
      }
    });
    AppMethodBeat.o(42502);
    return paramContext;
  }
  
  public static boolean gB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42518);
    paramString1 = new com.tencent.mm.vfs.e(paramString1);
    String str = com.tencent.mm.vfs.i.aEN(q.B(paramString1.mUri));
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
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(42496);
    if (paramContext == null)
    {
      AppMethodBeat.o(42496);
      return 0;
    }
    if (sjE == null)
    {
      sjE = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(sjE);
    }
    int i = sjE.widthPixels;
    AppMethodBeat.o(42496);
    return i;
  }
  
  /* Error */
  public static void i(String paramString, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 726
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 60	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 726
    //   19: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: ldc 222
    //   28: ldc_w 728
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokestatic 731	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: new 733	com/tencent/mm/g/a/hu
    //   45: dup
    //   46: invokespecial 734	com/tencent/mm/g/a/hu:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: getfield 738	com/tencent/mm/g/a/hu:dlw	Lcom/tencent/mm/g/a/hu$a;
    //   54: iconst_1
    //   55: putfield 743	com/tencent/mm/g/a/hu$a:BX	I
    //   58: aload_2
    //   59: getfield 738	com/tencent/mm/g/a/hu:dlw	Lcom/tencent/mm/g/a/hu$a;
    //   62: aload_0
    //   63: putfield 744	com/tencent/mm/g/a/hu$a:url	Ljava/lang/String;
    //   66: getstatic 208	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   69: aload_2
    //   70: invokevirtual 212	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   73: pop
    //   74: aload_2
    //   75: getfield 748	com/tencent/mm/g/a/hu:dlx	Lcom/tencent/mm/g/a/hu$b;
    //   78: getfield 753	com/tencent/mm/g/a/hu$b:dlz	Z
    //   81: ifeq +87 -> 168
    //   84: new 396	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 397	java/lang/StringBuilder:<init>	()V
    //   91: aload_2
    //   92: getfield 748	com/tencent/mm/g/a/hu:dlx	Lcom/tencent/mm/g/a/hu$b;
    //   95: getfield 756	com/tencent/mm/g/a/hu$b:dly	Ljava/lang/String;
    //   98: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 760	java/lang/String:getBytes	()[B
    //   105: invokestatic 766	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   108: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore_3
    //   115: new 768	com/tencent/mm/aw/a/a/c$a
    //   118: dup
    //   119: invokespecial 769	com/tencent/mm/aw/a/a/c$a:<init>	()V
    //   122: astore 4
    //   124: aload 4
    //   126: iconst_1
    //   127: putfield 772	com/tencent/mm/aw/a/a/c$a:hjU	Z
    //   130: aload 4
    //   132: aload_3
    //   133: putfield 775	com/tencent/mm/aw/a/a/c$a:gjt	Ljava/lang/String;
    //   136: aload 4
    //   138: invokevirtual 779	com/tencent/mm/aw/a/a/c$a:azc	()Lcom/tencent/mm/aw/a/a/c;
    //   141: astore_3
    //   142: invokestatic 785	com/tencent/mm/aw/o:ayJ	()Lcom/tencent/mm/aw/a/a;
    //   145: aload_0
    //   146: aconst_null
    //   147: aload_3
    //   148: new 8	com/tencent/mm/plugin/game/f/c$2
    //   151: dup
    //   152: aload_2
    //   153: invokespecial 788	com/tencent/mm/plugin/game/f/c$2:<init>	(Lcom/tencent/mm/g/a/hu;)V
    //   156: new 10	com/tencent/mm/plugin/game/f/c$3
    //   159: dup
    //   160: fload_1
    //   161: aload_2
    //   162: invokespecial 791	com/tencent/mm/plugin/game/f/c$3:<init>	(FLcom/tencent/mm/g/a/hu;)V
    //   165: invokevirtual 796	com/tencent/mm/aw/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/aw/a/a/c;Lcom/tencent/mm/aw/a/c/k;Lcom/tencent/mm/aw/a/c/h;)V
    //   168: ldc_w 726
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
    //   49	113	2	localhu	hu
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
    String str = com.tencent.mm.plugin.game.model.e.cCU();
    HashMap localHashMap;
    if (!bt.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = w(str, localHashMap);; paramString = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=".concat(String.valueOf(paramString)))
    {
      paramInt = A(paramContext, paramString, "game_center_detail");
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
  
  public static void qW(long paramLong)
  {
    AppMethodBeat.i(42519);
    com.tencent.mm.plugin.downloader.i.a.a(paramLong, false, null);
    AppMethodBeat.o(42519);
  }
  
  private static String w(String paramString, Map<String, String> paramMap)
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
  
  public static LinkedList<String> x(JSONArray paramJSONArray)
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
  
  public static void x(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42513);
    if (acZ(paramIntent.getStringExtra("rawUrl")))
    {
      y(paramIntent, paramContext);
      AppMethodBeat.o(42513);
      return;
    }
    mi localmi = new mi();
    localmi.drw.type = 0;
    localmi.drw.context = paramContext;
    localmi.drw.intent = paramIntent;
    com.tencent.mm.sdk.b.a.ESL.l(localmi);
    AppMethodBeat.o(42513);
  }
  
  public static void y(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(42514);
    mi localmi = new mi();
    localmi.drw.type = 2;
    localmi.drw.context = paramContext;
    localmi.drw.intent = paramIntent;
    com.tencent.mm.sdk.b.a.ESL.l(localmi);
    AppMethodBeat.o(42514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c
 * JD-Core Version:    0.7.0.1
 */