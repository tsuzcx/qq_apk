package com.tencent.mm.plugin.game.f;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.h.a.kp;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.j;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.h.h;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static volatile ai edy;
  private static int ewG;
  private static final Object hkZ = new Object();
  private static DisplayMetrics lcj;
  private static int lgh;
  private static int maxSize = -1;
  private static Rect rect = new Rect();
  
  static
  {
    ewG = -1;
    lgh = -1;
  }
  
  public static ai DS()
  {
    if (edy == null) {}
    synchronized (hkZ)
    {
      if (edy == null)
      {
        edy = new ai("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new h(edy.mnU.getLooper(), "SubCoreGameCenter#WorkThread"));
      }
      return edy;
    }
  }
  
  public static int Fe(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
    }
    for (;;)
    {
      return 0;
      try
      {
        paramString = ae.getContext().getPackageManager().getPackageInfo(paramString, 0);
        if (paramString == null) {
          continue;
        }
        return paramString.versionCode;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[] { paramString.toString() });
          paramString = null;
        }
      }
    }
  }
  
  public static int Ff(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.GameCenterUtil", "Null or Nil path");
    }
    do
    {
      return 0;
      paramString = ae.getContext().getPackageManager().getPackageArchiveInfo(paramString, 0);
    } while (paramString == null);
    return paramString.versionCode;
  }
  
  /* Error */
  public static void Fg(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 77	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: ldc 79
    //   18: ldc 128
    //   20: iconst_1
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: aastore
    //   28: invokestatic 131	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: new 133	com/tencent/mm/h/a/gw
    //   34: dup
    //   35: invokespecial 134	com/tencent/mm/h/a/gw:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: getfield 138	com/tencent/mm/h/a/gw:bOG	Lcom/tencent/mm/h/a/gw$a;
    //   43: iconst_1
    //   44: putfield 143	com/tencent/mm/h/a/gw$a:uC	I
    //   47: aload_2
    //   48: getfield 138	com/tencent/mm/h/a/gw:bOG	Lcom/tencent/mm/h/a/gw$a;
    //   51: aload_0
    //   52: putfield 147	com/tencent/mm/h/a/gw$a:url	Ljava/lang/String;
    //   55: getstatic 153	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   58: aload_2
    //   59: invokevirtual 157	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   62: pop
    //   63: aload_2
    //   64: getfield 161	com/tencent/mm/h/a/gw:bOH	Lcom/tencent/mm/h/a/gw$b;
    //   67: getfield 167	com/tencent/mm/h/a/gw$b:bOJ	Z
    //   70: ifeq -58 -> 12
    //   73: new 169	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   80: aload_2
    //   81: getfield 161	com/tencent/mm/h/a/gw:bOH	Lcom/tencent/mm/h/a/gw$b;
    //   84: getfield 173	com/tencent/mm/h/a/gw$b:bOI	Ljava/lang/String;
    //   87: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 183	java/lang/String:getBytes	()[B
    //   94: invokestatic 189	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   97: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_3
    //   104: new 192	com/tencent/mm/as/a/a/c$a
    //   107: dup
    //   108: invokespecial 193	com/tencent/mm/as/a/a/c$a:<init>	()V
    //   111: astore 4
    //   113: aload 4
    //   115: iconst_1
    //   116: putfield 196	com/tencent/mm/as/a/a/c$a:erf	Z
    //   119: aload 4
    //   121: aload_3
    //   122: putfield 199	com/tencent/mm/as/a/a/c$a:erh	Ljava/lang/String;
    //   125: aload 4
    //   127: invokevirtual 203	com/tencent/mm/as/a/a/c$a:OV	()Lcom/tencent/mm/as/a/a/c;
    //   130: astore_3
    //   131: invokestatic 209	com/tencent/mm/as/o:ON	()Lcom/tencent/mm/as/a/a;
    //   134: aload_0
    //   135: aconst_null
    //   136: aload_3
    //   137: new 211	com/tencent/mm/plugin/game/f/c$2
    //   140: dup
    //   141: aload_2
    //   142: invokespecial 214	com/tencent/mm/plugin/game/f/c$2:<init>	(Lcom/tencent/mm/h/a/gw;)V
    //   145: new 216	com/tencent/mm/plugin/game/f/c$3
    //   148: dup
    //   149: aload_2
    //   150: invokespecial 217	com/tencent/mm/plugin/game/f/c$3:<init>	(Lcom/tencent/mm/h/a/gw;)V
    //   153: invokevirtual 222	com/tencent/mm/as/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/as/a/a/c;Lcom/tencent/mm/as/a/c/i;Lcom/tencent/mm/as/a/c/g;)V
    //   156: goto -144 -> 12
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   7	2	1	bool	boolean
    //   38	112	2	localgw	com.tencent.mm.h.a.gw
    //   103	34	3	localObject	Object
    //   111	15	4	locala	com.tencent.mm.as.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	8	159	finally
    //   16	156	159	finally
  }
  
  public static void X(LinkedList<String> paramLinkedList)
  {
    if (bk.dk(paramLinkedList)) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.by(str, true);
        if ((localf != null) && (bk.bl(localf.field_openId))) {
          localLinkedList.add(str);
        }
      }
    } while (bk.dk(localLinkedList));
    com.tencent.mm.plugin.z.a.brp().addAll(localLinkedList);
  }
  
  public static void a(Context paramContext, o paramo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramo.kPu.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramo.kPu.kOO);
    localIntent.putExtra("disable_progress_bar", paramo.kPu.kOO);
    int i = -1;
    switch (paramo.kPu.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      paramo = new kp();
      paramo.bTG.type = 1;
      paramo.bTG.context = paramContext;
      paramo.bTG.intent = localIntent;
      com.tencent.mm.sdk.b.a.udP.m(paramo);
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
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String)))
    {
      y.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      return false;
    }
    paramView = (String)paramView.getTag();
    if (bk.bl(paramView))
    {
      y.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("show_bottom", false);
    x(localIntent, paramContext);
    return true;
  }
  
  public static int an(Context paramContext, String paramString)
  {
    return o(paramContext, paramString, null);
  }
  
  public static boolean ao(Context paramContext, String paramString)
  {
    int j = 2;
    paramString = Uri.parse(paramString).getQueryParameter("weapp");
    if (!bk.bl(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Uri.parse(paramString);
        paramString = ((Uri)localObject1).getAuthority();
        if (bk.bl(paramString))
        {
          y.w("MicroMsg.GameCenterUtil", "targetAppId is null");
          return false;
        }
        localObject2 = ((Uri)localObject1).getQueryParameter("env_version");
        localObject1 = ((Uri)localObject1).getQueryParameter("path");
        localObject2 = bk.pm((String)localObject2);
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 1559690845: 
          y.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", new Object[] { paramString, Integer.valueOf(j), localObject1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).scene = 1079;
          ((d)com.tencent.mm.kernel.g.r(d.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        boolean bool;
        y.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + paramContext.getMessage());
      }
      if (((String)localObject2).equals("develop"))
      {
        i = 0;
        break label247;
        bool = ((String)localObject2).equals("trial");
        if (bool)
        {
          i = 1;
          break label247;
          j = 1;
          continue;
          return false;
        }
      }
      label247:
      switch (i)
      {
      }
      j = 0;
    }
  }
  
  public static int ap(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    String str = com.tencent.mm.plugin.game.model.f.aZc();
    if (!bk.bl(str)) {}
    for (paramString = str + "?appid=" + paramString;; paramString = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=" + paramString) {
      return o(paramContext, paramString, "game_center_detail");
    }
  }
  
  public static void aqp()
  {
    if (edy == null) {
      return;
    }
    synchronized (hkZ)
    {
      if (edy != null)
      {
        com.tencent.mm.vending.h.g.aeK("SubCoreGameCenter#WorkThread");
        edy.mnU.quit();
        edy = null;
      }
      return;
    }
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (!bk.bl(paramString1))
    {
      b.a locala = b.bH(paramString1, paramBundle.getInt("game_report_from_scene", 0));
      if ((locala.bcw == 2) && (!bk.bl(locala.url))) {
        return o(paramContext, locala.url, "game_center_detail");
      }
    }
    if (!bk.bl(paramString2)) {
      return o(paramContext, paramString2, "game_center_detail");
    }
    int i = com.tencent.mm.plugin.game.model.f.aZd();
    if (i == 2) {
      return ap(paramContext, paramString1);
    }
    if (i == 1)
    {
      f(paramContext, paramBundle);
      return 6;
    }
    paramString2 = bk.fS(paramContext);
    if ((bk.bl(paramString2)) || (paramString2.toLowerCase().equals("cn"))) {
      return ap(paramContext, paramString1);
    }
    f(paramContext, paramBundle);
    return 6;
  }
  
  public static LinkedList<com.tencent.mm.pluginsdk.model.app.f> bav()
  {
    Cursor localCursor = com.tencent.mm.plugin.z.a.brn().ckT();
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null)
    {
      y.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
      return localLinkedList;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        com.tencent.mm.pluginsdk.model.app.f localf = new com.tencent.mm.pluginsdk.model.app.f();
        localf.d(localCursor);
        localLinkedList.add(localf);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public static Dialog dA(Context paramContext)
  {
    View localView = View.inflate(paramContext, g.f.game_progress_dialog_view, null);
    paramContext = new com.tencent.mm.ui.base.i(paramContext, g.j.GameProgressDialogStyle);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new c.1(paramContext));
    return paramContext;
  }
  
  public static boolean ds(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    String str = com.tencent.mm.a.g.m(paramString1);
    if ((bk.bl(paramString2)) || (bk.bl(str)))
    {
      y.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      return paramString1.exists();
    }
    y.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
    return paramString2.equalsIgnoreCase(str);
  }
  
  public static boolean eQ(long paramLong)
  {
    return com.tencent.mm.plugin.downloader.h.a.m(paramLong, false);
  }
  
  public static void f(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    if (lcj == null)
    {
      lcj = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(lcj);
    }
    return lcj.widthPixels;
  }
  
  public static int o(Context paramContext, String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return 0;
    }
    if (ao(paramContext, paramString1)) {
      return 30;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("geta8key_scene", 32);
    localIntent.putExtra("KPublisherId", paramString2);
    x(localIntent, paramContext);
    return 7;
  }
  
  public static int parseColor(String paramString)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.GameCenterUtil", "parseColor: " + paramString.getMessage());
    }
    return 0;
  }
  
  public static void x(Intent paramIntent, Context paramContext)
  {
    kp localkp = new kp();
    localkp.bTG.type = 0;
    localkp.bTG.context = paramContext;
    localkp.bTG.intent = paramIntent;
    com.tencent.mm.sdk.b.a.udP.m(localkp);
  }
  
  public static void y(Intent paramIntent, Context paramContext)
  {
    kp localkp = new kp();
    localkp.bTG.type = 2;
    localkp.bTG.context = paramContext;
    localkp.bTG.intent = paramIntent;
    com.tencent.mm.sdk.b.a.udP.m(localkp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c
 * JD-Core Version:    0.7.0.1
 */