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
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class c
{
  private static int fMv;
  private static volatile al ftB;
  private static final Object iXt;
  private static int maxSize;
  private static DisplayMetrics nAe;
  private static int nEc;
  private static Rect rect;
  
  static
  {
    AppMethodBeat.i(112322);
    maxSize = -1;
    fMv = -1;
    nEc = -1;
    iXt = new Object();
    rect = new Rect();
    AppMethodBeat.o(112322);
  }
  
  /* Error */
  public static void QA(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 48
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 54	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +12 -> 24
    //   15: ldc 48
    //   17: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: ldc 56
    //   26: ldc 58
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: new 66	com/tencent/mm/g/a/ha
    //   42: dup
    //   43: invokespecial 67	com/tencent/mm/g/a/ha:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: getfield 71	com/tencent/mm/g/a/ha:cvX	Lcom/tencent/mm/g/a/ha$a;
    //   51: iconst_1
    //   52: putfield 76	com/tencent/mm/g/a/ha$a:vA	I
    //   55: aload_1
    //   56: getfield 71	com/tencent/mm/g/a/ha:cvX	Lcom/tencent/mm/g/a/ha$a;
    //   59: aload_0
    //   60: putfield 80	com/tencent/mm/g/a/ha$a:url	Ljava/lang/String;
    //   63: getstatic 86	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   66: aload_1
    //   67: invokevirtual 90	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   70: pop
    //   71: aload_1
    //   72: getfield 94	com/tencent/mm/g/a/ha:cvY	Lcom/tencent/mm/g/a/ha$b;
    //   75: getfield 100	com/tencent/mm/g/a/ha$b:cwa	Z
    //   78: ifeq +82 -> 160
    //   81: new 102	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   88: aload_1
    //   89: getfield 94	com/tencent/mm/g/a/ha:cvY	Lcom/tencent/mm/g/a/ha$b;
    //   92: getfield 106	com/tencent/mm/g/a/ha$b:cvZ	Ljava/lang/String;
    //   95: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: invokevirtual 116	java/lang/String:getBytes	()[B
    //   102: invokestatic 122	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   105: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_2
    //   112: new 128	com/tencent/mm/at/a/a/c$a
    //   115: dup
    //   116: invokespecial 129	com/tencent/mm/at/a/a/c$a:<init>	()V
    //   119: astore_3
    //   120: aload_3
    //   121: iconst_1
    //   122: putfield 132	com/tencent/mm/at/a/a/c$a:eNM	Z
    //   125: aload_3
    //   126: aload_2
    //   127: putfield 135	com/tencent/mm/at/a/a/c$a:eNO	Ljava/lang/String;
    //   130: aload_3
    //   131: invokevirtual 139	com/tencent/mm/at/a/a/c$a:ahY	()Lcom/tencent/mm/at/a/a/c;
    //   134: astore_2
    //   135: invokestatic 145	com/tencent/mm/at/o:ahG	()Lcom/tencent/mm/at/a/a;
    //   138: aload_0
    //   139: aconst_null
    //   140: aload_2
    //   141: new 147	com/tencent/mm/plugin/game/f/c$2
    //   144: dup
    //   145: aload_1
    //   146: invokespecial 150	com/tencent/mm/plugin/game/f/c$2:<init>	(Lcom/tencent/mm/g/a/ha;)V
    //   149: new 152	com/tencent/mm/plugin/game/f/c$3
    //   152: dup
    //   153: aload_1
    //   154: invokespecial 153	com/tencent/mm/plugin/game/f/c$3:<init>	(Lcom/tencent/mm/g/a/ha;)V
    //   157: invokevirtual 159	com/tencent/mm/at/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/at/a/a/c;Lcom/tencent/mm/at/a/c/i;Lcom/tencent/mm/at/a/c/g;)V
    //   160: ldc 48
    //   162: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: goto -145 -> 20
    //   168: astore_0
    //   169: ldc 2
    //   171: monitorexit
    //   172: aload_0
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramString	String
    //   46	108	1	localha	com.tencent.mm.g.a.ha
    //   111	30	2	localObject	Object
    //   119	12	3	locala	com.tencent.mm.at.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   3	20	168	finally
    //   24	160	168	finally
    //   160	165	168	finally
  }
  
  private static boolean QB(String paramString)
  {
    AppMethodBeat.i(112321);
    if (!((b)com.tencent.mm.kernel.g.E(b.class)).b(com.tencent.mm.plugin.expt.a.a.a.lRy))
    {
      AppMethodBeat.o(112321);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(112321);
      return false;
    }
    paramString = Uri.parse(paramString);
    if ((paramString.getHost() != null) && (paramString.getHost().equals("game.weixin.qq.com")))
    {
      AppMethodBeat.o(112321);
      return true;
    }
    AppMethodBeat.o(112321);
    return false;
  }
  
  public static LinkedList<String> QC(String paramString)
  {
    AppMethodBeat.i(151893);
    paramString = paramString.substring(1, paramString.length() - 1).split(",");
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i].trim());
      i += 1;
    }
    AppMethodBeat.o(151893);
    return localLinkedList;
  }
  
  public static JSONArray QD(String paramString)
  {
    AppMethodBeat.i(151895);
    paramString = paramString.substring(1, paramString.length() - 1).split(",");
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramString.length)
    {
      localJSONArray.put(paramString[i].trim());
      i += 1;
    }
    AppMethodBeat.o(151895);
    return localJSONArray;
  }
  
  public static int Qy(String paramString)
  {
    AppMethodBeat.i(112303);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
      AppMethodBeat.o(112303);
      return 0;
    }
    try
    {
      paramString = ah.getContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        AppMethodBeat.o(112303);
        return 0;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[] { paramString.toString() });
        paramString = null;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(112303);
      return i;
    }
  }
  
  public static int Qz(String paramString)
  {
    AppMethodBeat.i(112304);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.GameCenterUtil", "Null or Nil path");
      AppMethodBeat.o(112304);
      return 0;
    }
    paramString = ah.getContext().getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(112304);
      return 0;
    }
    int i = paramString.versionCode;
    AppMethodBeat.o(112304);
    return i;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(112309);
    Object localObject = paramBundle;
    if (!bo.isNullOrNil(paramString1))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = com.tencent.mm.plugin.game.model.a.cu(paramString1, localBundle.getInt("game_report_from_scene", 0));
      localObject = localBundle;
      if (paramBundle.bsY == 2)
      {
        localObject = localBundle;
        if (!bo.isNullOrNil(paramBundle.url))
        {
          paramInt = t(paramContext, paramBundle.url, "game_center_detail");
          AppMethodBeat.o(112309);
          return paramInt;
        }
      }
    }
    if (!bo.isNullOrNil(paramString2))
    {
      paramInt = t(paramContext, paramString2, "game_center_detail");
      AppMethodBeat.o(112309);
      return paramInt;
    }
    int i = e.bGc();
    if (i == 2)
    {
      paramInt = l(paramContext, paramString1, paramInt);
      AppMethodBeat.o(112309);
      return paramInt;
    }
    if (i == 1)
    {
      h(paramContext, (Bundle)localObject);
      AppMethodBeat.o(112309);
      return 6;
    }
    paramString2 = bo.hi(paramContext);
    if ((bo.isNullOrNil(paramString2)) || (paramString2.toLowerCase().equals("cn")))
    {
      paramInt = l(paramContext, paramString1, paramInt);
      AppMethodBeat.o(112309);
      return paramInt;
    }
    h(paramContext, (Bundle)localObject);
    AppMethodBeat.o(112309);
    return 6;
  }
  
  public static void a(Context paramContext, n paramn, String paramString)
  {
    AppMethodBeat.i(112300);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramn.nnq.url);
    localIntent.putExtra("finishviewifloadfailed", true);
    localIntent.putExtra("show_full_screen", paramn.nnq.njd);
    localIntent.putExtra("disable_progress_bar", paramn.nnq.njd);
    int i = -1;
    switch (paramn.nnq.orientation)
    {
    }
    for (;;)
    {
      localIntent.putExtra("screen_orientation", i);
      localIntent.putExtra("geta8key_scene", 32);
      localIntent.putExtra("KPublisherId", paramString);
      localIntent.putExtra("open_game_float", true);
      paramn = new ld();
      paramn.cBn.type = 1;
      paramn.cBn.context = paramContext;
      paramn.cBn.intent = localIntent;
      com.tencent.mm.sdk.b.a.ymk.l(paramn);
      AppMethodBeat.o(112300);
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
    AppMethodBeat.i(112301);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String)))
    {
      ab.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(112301);
      return false;
    }
    paramView = (String)paramView.getTag();
    if (bo.isNullOrNil(paramView))
    {
      ab.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
      AppMethodBeat.o(112301);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("show_bottom", false);
    w(localIntent, paramContext);
    AppMethodBeat.o(112301);
    return true;
  }
  
  public static void aNR()
  {
    AppMethodBeat.i(112315);
    if (ftB == null)
    {
      AppMethodBeat.o(112315);
      return;
    }
    synchronized (iXt)
    {
      if (ftB != null)
      {
        com.tencent.mm.vending.h.g.avC("SubCoreGameCenter#WorkThread");
        ftB.oNc.quit();
        ftB = null;
      }
      AppMethodBeat.o(112315);
      return;
    }
  }
  
  public static al aNS()
  {
    AppMethodBeat.i(112316);
    if (ftB == null) {}
    synchronized (iXt)
    {
      if (ftB == null)
      {
        ftB = new al("SubCoreGameCenter#WorkThread");
        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.vending.h.h(ftB.oNc.getLooper(), "SubCoreGameCenter#WorkThread"));
      }
      ??? = ftB;
      AppMethodBeat.o(112316);
      return ???;
    }
  }
  
  public static void ae(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112306);
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(112306);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      f localf = com.tencent.mm.pluginsdk.model.app.g.ca(str, true);
      if ((localf != null) && (bo.isNullOrNil(localf.field_openId))) {
        localLinkedList.add(str);
      }
    }
    if (!bo.es(localLinkedList)) {
      com.tencent.mm.plugin.s.a.cae().addAll(localLinkedList);
    }
    AppMethodBeat.o(112306);
  }
  
  public static String af(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151892);
    paramLinkedList = paramLinkedList.iterator();
    if (!paramLinkedList.hasNext())
    {
      AppMethodBeat.o(151892);
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
        AppMethodBeat.o(151892);
        return paramLinkedList;
      }
      localStringBuilder.append(',');
    }
  }
  
  public static int ax(Context paramContext, String paramString)
  {
    AppMethodBeat.i(112297);
    int i = t(paramContext, paramString, null);
    AppMethodBeat.o(112297);
    return i;
  }
  
  public static boolean ay(Context paramContext, String paramString)
  {
    int j = 2;
    AppMethodBeat.i(112299);
    paramString = Uri.parse(paramString).getQueryParameter("weapp");
    if (!bo.isNullOrNil(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Uri.parse(paramString);
        paramString = ((Uri)localObject1).getAuthority();
        if (bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.GameCenterUtil", "targetAppId is null");
          AppMethodBeat.o(112299);
          return false;
        }
        localObject2 = ((Uri)localObject1).getQueryParameter("env_version");
        localObject1 = ((Uri)localObject1).getQueryParameter("path");
        localObject2 = bo.nullAsNil((String)localObject2);
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 1559690845: 
          ab.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", new Object[] { paramString, Integer.valueOf(j), localObject1 });
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).scene = 1079;
          ((j)com.tencent.mm.kernel.g.E(j.class)).a(paramContext, null, paramString, j, 0, (String)localObject1, (AppBrandStatObject)localObject2);
          AppMethodBeat.o(112299);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        boolean bool;
        ab.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + paramContext.getMessage());
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
          AppMethodBeat.o(112299);
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
  
  public static int b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(112308);
    int i = a(paramContext, paramString1, paramString2, paramBundle, 0);
    AppMethodBeat.o(112308);
    return i;
  }
  
  public static LinkedList<f> bHC()
  {
    AppMethodBeat.i(112307);
    Cursor localCursor = com.tencent.mm.plugin.s.a.cac().dlD();
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null) {
      ab.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
    }
    for (;;)
    {
      AppMethodBeat.o(112307);
      return localLinkedList;
      if (localCursor.moveToFirst()) {
        do
        {
          f localf = new f();
          localf.convertFrom(localCursor);
          localLinkedList.add(localf);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
    }
  }
  
  public static String bHD()
  {
    AppMethodBeat.i(112320);
    Object localObject = ((b)com.tencent.mm.kernel.g.E(b.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRT, "");
    if ((localObject != null) && (!bo.isNullOrNil(((String)localObject).trim())))
    {
      if (((String)localObject).equals("native"))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(848L, 11L, 1L, false);
        AppMethodBeat.o(112320);
        return null;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(848L, 10L, 1L, false);
      AppMethodBeat.o(112320);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.game.model.a.bFM();
    if ((((com.tencent.mm.plugin.game.model.a.a)localObject).bsY == 2) && (!bo.isNullOrNil(((com.tencent.mm.plugin.game.model.a.a)localObject).url)))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(848L, 12L, 1L, false);
      localObject = ((com.tencent.mm.plugin.game.model.a.a)localObject).url;
      AppMethodBeat.o(112320);
      return localObject;
    }
    AppMethodBeat.o(112320);
    return null;
  }
  
  public static boolean eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112318);
    paramString1 = new File(paramString1);
    String str = com.tencent.mm.a.g.r(paramString1);
    if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(str)))
    {
      ab.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
      bool = paramString1.exists();
      AppMethodBeat.o(112318);
      return bool;
    }
    ab.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[] { paramString2, str });
    boolean bool = paramString2.equalsIgnoreCase(str);
    AppMethodBeat.o(112318);
    return bool;
  }
  
  public static Dialog en(Context paramContext)
  {
    AppMethodBeat.i(112302);
    View localView = View.inflate(paramContext, 2130969803, null);
    paramContext = new com.tencent.mm.ui.base.i(paramContext, 2131493292);
    paramContext.setContentView(localView);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(new c.1(paramContext));
    AppMethodBeat.o(112302);
    return paramContext;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(112296);
    if (paramContext == null)
    {
      AppMethodBeat.o(112296);
      return 0;
    }
    if (nAe == null)
    {
      nAe = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(nAe);
    }
    int i = nAe.widthPixels;
    AppMethodBeat.o(112296);
    return i;
  }
  
  public static void h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(112312);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(112312);
  }
  
  public static void km(long paramLong)
  {
    AppMethodBeat.i(112319);
    com.tencent.mm.plugin.downloader.i.a.a(paramLong, false, null);
    AppMethodBeat.o(112319);
  }
  
  public static int l(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(112310);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(112310);
      return 0;
    }
    String str = e.bGb();
    HashMap localHashMap;
    if (!bo.isNullOrNil(str))
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", paramString);
      if (paramInt > 0) {
        localHashMap.put("ssid", String.valueOf(paramInt));
      }
    }
    for (paramString = r(str, localHashMap);; paramString = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=".concat(String.valueOf(paramString)))
    {
      paramInt = t(paramContext, paramString, "game_center_detail");
      AppMethodBeat.o(112310);
      return paramInt;
    }
  }
  
  public static int parseColor(String paramString)
  {
    AppMethodBeat.i(112317);
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
        ab.e("MicroMsg.GameCenterUtil", "parseColor: " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(112317);
    return i;
  }
  
  private static String r(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(112311);
    if ((bo.isNullOrNil(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(112311);
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
    AppMethodBeat.o(112311);
    return paramString;
  }
  
  public static int t(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112298);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(112298);
      return 0;
    }
    if (ay(paramContext, paramString1))
    {
      AppMethodBeat.o(112298);
      return 30;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("geta8key_scene", 32);
    localIntent.putExtra("KPublisherId", paramString2);
    w(localIntent, paramContext);
    AppMethodBeat.o(112298);
    return 7;
  }
  
  public static LinkedList<String> v(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(151894);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(151894);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i).trim());
      i += 1;
    }
    AppMethodBeat.o(151894);
    return localLinkedList;
  }
  
  public static void w(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(112313);
    if (QB(paramIntent.getStringExtra("rawUrl")))
    {
      x(paramIntent, paramContext);
      AppMethodBeat.o(112313);
      return;
    }
    ld localld = new ld();
    localld.cBn.type = 0;
    localld.cBn.context = paramContext;
    localld.cBn.intent = paramIntent;
    com.tencent.mm.sdk.b.a.ymk.l(localld);
    AppMethodBeat.o(112313);
  }
  
  public static void x(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(112314);
    ld localld = new ld();
    localld.cBn.type = 2;
    localld.cBn.context = paramContext;
    localld.cBn.intent = paramIntent;
    com.tencent.mm.sdk.b.a.ymk.l(localld);
    AppMethodBeat.o(112314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c
 * JD-Core Version:    0.7.0.1
 */