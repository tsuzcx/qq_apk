package com.tencent.mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.bl;
import com.tencent.mm.h.a.cg;
import com.tencent.mm.h.a.cl;
import com.tencent.mm.h.a.cm;
import com.tencent.mm.h.a.cn;
import com.tencent.mm.h.a.co;
import com.tencent.mm.h.a.gr;
import com.tencent.mm.h.a.gy;
import com.tencent.mm.h.a.ml;
import com.tencent.mm.h.a.pz;
import com.tencent.mm.h.a.qc;
import com.tencent.mm.h.a.qs;
import com.tencent.mm.h.a.uj;
import com.tencent.mm.h.a.un;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.c;
import com.tencent.mm.pluginsdk.o.e;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.chatting.b.aj;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class b
{
  private static final HashSet<String> dAq;
  
  static
  {
    boolean bool = true;
    com.tencent.mm.console.a.d.init();
    com.tencent.mm.console.a.i.init();
    com.tencent.mm.console.a.j.init();
    com.tencent.mm.console.a.g.init();
    com.tencent.mm.console.a.e.init();
    com.tencent.mm.console.a.f.init();
    com.tencent.mm.console.a.b.init();
    com.tencent.mm.console.a.c.init();
    com.tencent.mm.console.a.l.init();
    com.tencent.mm.console.a.h.init();
    com.tencent.mm.console.a.k.init();
    com.tencent.mm.console.a.m.init();
    try
    {
      Class.forName("com.tencent.mm.console.a.b.a");
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.a(), new String[] { "//fsd" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), new String[] { "//hcsetting" });
      com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a(), new String[] { "//clearrecent" });
      HashSet localHashSet = new HashSet();
      dAq = localHashSet;
      localHashSet.add("//uplog");
      dAq.add("//pullxlog");
      dAq.add("//upcrash");
      dAq.add("//getfpkey");
      dAq.add("//voipdebug");
      dAq.add("//setkey");
      dAq.add("//wxcamera");
      dAq.add("//deletetbs");
      if (dAq.size() == 8)
      {
        Assert.assertTrue(bool);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", localThrowable, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  private static int fq(String paramString)
  {
    if ((!paramString.startsWith("//")) || (paramString.length() <= 2)) {}
    for (;;)
    {
      return 0;
      int j = paramString.indexOf(" ");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      try
      {
        i = bk.getInt(paramString.substring(2, i), 0);
        j = com.tencent.mm.protocal.d.spa % 256;
        if ((j != 0) && (i >= j) && (i % j == 0)) {
          return i / j;
        }
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  private static String fr(String paramString)
  {
    int i = paramString.indexOf(" ");
    if (i < 0) {
      return "";
    }
    return paramString.substring(i).trim();
  }
  
  private static boolean fs(String paramString)
  {
    Iterator localIterator = dAq.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static StringBuilder gL(int paramInt)
  {
    // Byte code:
    //   0: new 192	java/util/Date
    //   3: dup
    //   4: invokestatic 196	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   7: iload_0
    //   8: i2l
    //   9: ldc2_w 197
    //   12: lmul
    //   13: lsub
    //   14: invokespecial 201	java/util/Date:<init>	(J)V
    //   17: astore_1
    //   18: new 203	java/text/SimpleDateFormat
    //   21: dup
    //   22: ldc 205
    //   24: invokestatic 211	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   27: invokespecial 214	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   30: astore_2
    //   31: new 216	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   38: getstatic 223	com/tencent/mm/compatible/util/e:dOR	Ljava/lang/String;
    //   41: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 229
    //   46: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: aload_1
    //   51: invokevirtual 233	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   54: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 235
    //   59: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_1
    //   66: new 216	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: aload_1
    //   76: invokestatic 243	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   79: ifeq +32 -> 111
    //   82: new 216	java/lang/StringBuilder
    //   85: dup
    //   86: new 216	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 245
    //   92: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: iload_0
    //   96: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc 252
    //   101: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: areturn
    //   111: new 254	java/io/BufferedReader
    //   114: dup
    //   115: new 256	com/tencent/mm/vfs/g
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 257	com/tencent/mm/vfs/g:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore_2
    //   127: aload_2
    //   128: astore_1
    //   129: aload_2
    //   130: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   133: invokestatic 266	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   136: ifeq +51 -> 187
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: invokevirtual 269	java/io/BufferedReader:close	()V
    //   145: aload_2
    //   146: astore_1
    //   147: new 216	java/lang/StringBuilder
    //   150: dup
    //   151: new 216	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 271
    //   158: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: iload_0
    //   162: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc_w 273
    //   168: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: astore_3
    //   178: aload_2
    //   179: invokevirtual 269	java/io/BufferedReader:close	()V
    //   182: aload_3
    //   183: areturn
    //   184: astore_1
    //   185: aload_3
    //   186: areturn
    //   187: aload_2
    //   188: astore_1
    //   189: aload_2
    //   190: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   193: astore_3
    //   194: aload_3
    //   195: ifnull +79 -> 274
    //   198: aload_2
    //   199: astore_1
    //   200: aload 4
    //   202: new 66	java/lang/String
    //   205: dup
    //   206: aload_3
    //   207: ldc_w 275
    //   210: invokevirtual 279	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   213: iconst_1
    //   214: aaload
    //   215: iconst_0
    //   216: invokestatic 285	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   219: invokespecial 288	java/lang/String:<init>	([B)V
    //   222: ldc_w 290
    //   225: invokevirtual 279	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   228: iconst_1
    //   229: aaload
    //   230: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_2
    //   235: astore_1
    //   236: aload 4
    //   238: ldc_w 292
    //   241: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: goto -58 -> 187
    //   248: astore_3
    //   249: aload_2
    //   250: astore_1
    //   251: ldc 121
    //   253: aload_3
    //   254: ldc 123
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 129	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 269	java/io/BufferedReader:close	()V
    //   271: aload 4
    //   273: areturn
    //   274: aload_2
    //   275: invokevirtual 269	java/io/BufferedReader:close	()V
    //   278: goto -7 -> 271
    //   281: astore_1
    //   282: goto -11 -> 271
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +7 -> 296
    //   292: aload_1
    //   293: invokevirtual 269	java/io/BufferedReader:close	()V
    //   296: aload_2
    //   297: athrow
    //   298: astore_1
    //   299: goto -28 -> 271
    //   302: astore_1
    //   303: goto -7 -> 296
    //   306: astore_2
    //   307: goto -19 -> 288
    //   310: astore_3
    //   311: aconst_null
    //   312: astore_2
    //   313: goto -64 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramInt	int
    //   17	130	1	localObject1	Object
    //   184	1	1	localException1	Exception
    //   188	63	1	localObject2	Object
    //   281	1	1	localException2	Exception
    //   287	6	1	localObject3	Object
    //   298	1	1	localException3	Exception
    //   302	1	1	localException4	Exception
    //   30	245	2	localObject4	Object
    //   285	12	2	localObject5	Object
    //   306	1	2	localObject6	Object
    //   312	1	2	localObject7	Object
    //   177	30	3	localObject8	Object
    //   248	6	3	localException5	Exception
    //   310	1	3	localException6	Exception
    //   73	199	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   178	182	184	java/lang/Exception
    //   129	139	248	java/lang/Exception
    //   141	145	248	java/lang/Exception
    //   147	178	248	java/lang/Exception
    //   189	194	248	java/lang/Exception
    //   200	234	248	java/lang/Exception
    //   236	245	248	java/lang/Exception
    //   274	278	281	java/lang/Exception
    //   111	127	285	finally
    //   267	271	298	java/lang/Exception
    //   292	296	302	java/lang/Exception
    //   129	139	306	finally
    //   141	145	306	finally
    //   147	178	306	finally
    //   189	194	306	finally
    //   200	234	306	finally
    //   236	245	306	finally
    //   251	263	306	finally
    //   111	127	310	java/lang/Exception
  }
  
  private static void gM(int paramInt)
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ap.l(com.tencent.mm.sdk.platformtools.ae.getContext(), "sp_sns_dynswitch_stg", 4);
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Bad op parameter: " + paramInt);
    case -1: 
      localSharedPreferences.edit().remove("st_sw_use_vcodec_img").commit();
      return;
    case 0: 
      localSharedPreferences.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
      return;
    }
    localSharedPreferences.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
  }
  
  private static void gN(int paramInt)
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ap.l(com.tencent.mm.sdk.platformtools.ae.getContext(), "sp_sns_dynswitch_stg", 4);
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Bad op parameter: " + paramInt);
    case -1: 
      localSharedPreferences.edit().remove("st_sw_use_wxpc_img").commit();
      return;
    case 0: 
      localSharedPreferences.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
      return;
    }
    localSharedPreferences.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
  }
  
  public static boolean w(final Context paramContext, final String paramString)
  {
    if (!paramString.startsWith("//")) {
      return false;
    }
    if ((1 < com.tencent.mm.sdk.platformtools.y.getLogLevel()) && (!fs(paramString)))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summer processed log level[%s], need open debug ret false", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.y.getLogLevel()) });
      return false;
    }
    if (com.tencent.mm.pluginsdk.cmd.b.bg(paramContext, paramString)) {
      return true;
    }
    if (paramString.startsWith("//clearWXSNSDB"))
    {
      paramContext = new pz();
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
      return true;
    }
    if (paramString.startsWith("//verifytokenerror"))
    {
      com.tencent.mm.platformtools.ae.eTH = true;
      return true;
    }
    if (paramString.startsWith("//testLqt"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 2) {
        if (bk.getInt(paramContext[1], 0) != 1) {
          break label142;
        }
      }
      label142:
      for (com.tencent.mm.platformtools.ae.eTM = true;; com.tencent.mm.platformtools.ae.eTM = false) {
        return true;
      }
    }
    if (paramString.startsWith("//resetbackupdata"))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uum, Boolean.valueOf(false));
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uun, Boolean.valueOf(false));
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uuo, Boolean.valueOf(false));
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uup, Boolean.valueOf(false));
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uuq, Boolean.valueOf(false));
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uur, Boolean.valueOf(false));
      au.Hx().Gd().ctu();
      au.Hx().Ge().ctu();
      au.Hx().Gc().ctu();
      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "backup data has been reset!", 1).show();
      return true;
    }
    Object localObject1;
    Object localObject4;
    int i;
    if (paramString.equalsIgnoreCase("//ftsmsbiz"))
    {
      localObject1 = com.tencent.mm.plugin.websearch.api.ai.bZE();
      paramString = new StringBuilder();
      localObject1 = ((ayl)localObject1).hPT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (ayk)((Iterator)localObject1).next();
        paramString.append(String.format("%s | %.2f | %s", new Object[] { r.gV(((ayk)localObject4).sxM), Double.valueOf(((ayk)localObject4).tuu), com.tencent.mm.pluginsdk.f.h.g("yyyy-MM-dd HH:mm", ((ayk)localObject4).tuv / 1000L) }));
        paramString.append("\n");
      }
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText(paramString.toString());
      ((TextView)localObject1).setGravity(19);
      ((TextView)localObject1).setTextSize(1, 10.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(-16711936);
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      ((TextView)localObject1).setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, (View)localObject1, null);
      return true;
    }
    if (paramString.startsWith("//cleanww"))
    {
      ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).UD();
      return true;
    }
    if (paramString.startsWith("//setgamejs"))
    {
      paramString = paramString.split(" ");
      if (paramString.length == 2)
      {
        if ((paramString[1] == null) || (paramString[1].isEmpty()) || (paramString[1].endsWith("/"))) {
          break label673;
        }
        paramContext = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (paramContext != null)
        {
          paramContext = paramContext.edit();
          paramContext.remove("app_brand_game_js_path");
          paramContext.commit();
          if (!paramString[1].equalsIgnoreCase("null"))
          {
            paramContext.putString("app_brand_game_js_path", paramString[1]);
            paramContext.commit();
          }
        }
      }
      for (;;)
      {
        return true;
        label673:
        com.tencent.mm.ui.base.s.makeText(paramContext, "param set error, please don't end with /", 0).show();
      }
    }
    if (com.tencent.mm.sdk.a.b.cqk())
    {
      if (paramString.startsWith("//launchapp clear"))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uuV, "");
        return true;
      }
      if (paramString.startsWith("//setsupportwxcode"))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwj, Boolean.valueOf(true));
        return true;
      }
      if (paramString.startsWith("//setnotsupportwxcode"))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwj, Boolean.valueOf(false));
        return true;
      }
      if (paramString.startsWith("//resetsupportwxcode"))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwj, null);
        return true;
      }
    }
    if (paramString.startsWith("//testsightwidget"))
    {
      paramString = new Intent();
      paramString.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
      paramString.putExtra("KSightThumbPath", "");
      paramString.putExtra("sight_md5", com.tencent.mm.vfs.e.aeY("/mnt/sdcard/tencent/tempvideo4.mp4"));
      paramString.putExtra("KSnsPostManu", true);
      paramString.putExtra("KTouchCameraTime", bk.UX());
      paramString.putExtra("Ksnsupload_type", 14);
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsUploadUI", paramString);
      return true;
    }
    if (paramString.startsWith("//openremitbank"))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyz, Integer.valueOf(1));
      return true;
    }
    if (paramString.startsWith("//chatroomdebug "))
    {
      if (paramString.substring(paramString.indexOf(" ") + 1).equalsIgnoreCase("true")) {
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).eF(true);
      }
      for (;;)
      {
        return true;
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).eF(false);
      }
    }
    if (paramString.startsWith("//angerbag"))
    {
      if (((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzu, "0")).equals("0")) {}
      for (paramContext = "1";; paramContext = "0")
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzu, paramContext);
        return true;
      }
    }
    if (paramString.startsWith("//clearbag"))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzt, "");
      return true;
    }
    if (paramString.startsWith("//closeremitbank"))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyz, Integer.valueOf(0));
      return true;
    }
    if (paramString.startsWith("//ftstemplatetest"))
    {
      localObject1 = new com.tencent.mm.h.a.be();
      ((com.tencent.mm.h.a.be)localObject1).bHu.bHv = 27;
      ((com.tencent.mm.h.a.be)localObject1).bHu.bHv = 1;
      ((com.tencent.mm.h.a.be)localObject1).bHu.filePath = "/sdcard/fts_template.zip";
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    if (paramString.startsWith("//sightforward"))
    {
      paramString = new Intent();
      paramString.setClassName(paramContext, "com.tencent.mm.ui.transmit.SightForwardUI");
      paramContext.startActivity(paramString);
      return true;
    }
    if (paramString.startsWith("//remit"))
    {
      com.tencent.mm.br.d.b(paramContext, "remittance", ".ui.RemittanceBusiUI", new Intent());
      return true;
    }
    if (paramString.startsWith("//fixtools"))
    {
      paramString = new Intent();
      paramString.setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
      paramString.putExtra("entry_fix_tools", 2);
      paramContext.startActivity(paramString);
      return true;
    }
    if (paramString.startsWith("//uplog"))
    {
      paramString = new Intent();
      paramString.setClassName(paramContext, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI");
      paramString.putExtra("entry_fix_tools_uplog", 5);
      MMWizardActivity.C(paramContext, paramString);
      return true;
    }
    if (paramString.startsWith("//pullxlog"))
    {
      com.tencent.mm.sdk.platformtools.y.moveLogsFromCacheDirToLogDir();
      Toast.makeText(paramContext, "move success", 0).show();
      return true;
    }
    int j;
    if (paramString.startsWith("//upcrash"))
    {
      paramContext = "weixin";
      if (au.DK()) {
        paramContext = com.tencent.mm.model.q.Gj();
      }
      localObject1 = paramString.split(" ");
      j = 0;
      i = 0;
      paramString = paramContext;
      if (localObject1 != null)
      {
        if (localObject1.length > 1) {
          i = bk.getInt(localObject1[1], 0);
        }
        paramString = paramContext;
        j = i;
        if (localObject1.length > 2)
        {
          paramString = localObject1[2];
          j = i;
        }
      }
      au.Dk().d(new com.tencent.mm.model.bi(new b.1(paramString, j)));
      return true;
    }
    boolean bool1;
    if (paramString.startsWith("//switchnotificationstatus"))
    {
      if (!com.tencent.mm.m.f.zP()) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.m.f.bx(bool1);
        return true;
      }
    }
    if (paramString.startsWith("//fixError0831"))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "fixError0831");
      com.tencent.mm.sdk.b.a.udP.m(new bl());
      return true;
    }
    if (paramString.startsWith("//resetbankremit"))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyA, Integer.valueOf(0));
      return true;
    }
    if (paramString.startsWith("//busiluck "))
    {
      paramString = paramString.replace("//busiluck ", "");
      paramString = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + paramString;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_way", 5);
      ((Intent)localObject1).putExtra("key_native_url", paramString);
      com.tencent.mm.br.d.b(paramContext, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", (Intent)localObject1);
      return true;
    }
    if (paramString.startsWith("//testsoter"))
    {
      paramString = new Intent();
      paramString.setClassName(com.tencent.mm.sdk.platformtools.ae.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
      paramContext.startActivity(paramString);
      return true;
    }
    if (paramString.startsWith("//facevideo"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 3)
      {
        at.dVC.Y("imgType", paramContext[1]);
        at.dVC.Y("depth", paramContext[2]);
      }
      return true;
    }
    if (paramString.startsWith("//alpha"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 2) {
        at.dVC.Y("alpha_duration", paramContext[1]);
      }
      return true;
    }
    if (paramString.startsWith("//rectwidth"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 2) {
        at.dVC.Y("rect_width", paramContext[1]);
      }
      return true;
    }
    if (paramString.startsWith("//newyearsw "))
    {
      au.Hx();
      i = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uot, Integer.valueOf(0))).intValue();
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uot, Integer.valueOf(i ^ 0x1));
      return true;
    }
    if (paramString.startsWith("//commitxlog"))
    {
      au.Dk().a(1, "", 0, false);
      com.tencent.mm.sdk.platformtools.y.cqL();
      return true;
    }
    if (paramString.startsWith("//open neattextview"))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyE, Boolean.valueOf(true));
      return true;
    }
    if (paramString.startsWith("//close neattextview"))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyE, Boolean.valueOf(false));
      return true;
    }
    if (paramString.startsWith("//unprint specialtext"))
    {
      com.tencent.mm.ui.widget.MMNeatTextView.wjq = false;
      return true;
    }
    if (paramString.startsWith("//print specialtext"))
    {
      com.tencent.mm.ui.widget.MMNeatTextView.wjq = true;
      return true;
    }
    if (paramString.startsWith("//netstatus"))
    {
      paramString = com.tencent.mm.sdk.platformtools.aq.fG(com.tencent.mm.sdk.platformtools.ae.getContext());
      com.tencent.mm.ui.base.h.a(paramContext, paramString, "netstatus", paramContext.getString(R.l.voip_get_key_copy), paramContext.getString(R.l.confirm_dialog_cancel), new b.8(paramContext, paramString), null);
      return true;
    }
    long l1;
    if (paramString.startsWith("//scaninterval "))
    {
      localObject1 = paramString.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = bk.getLong(localObject1[1], -1L);
      l1 = l2;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        long l2;
        continue;
        paramString = null;
        continue;
        Object localObject5 = null;
        String str = paramString;
        paramString = (String)localObject5;
        continue;
        paramString = null;
        continue;
        paramString = null;
        localObject4 = null;
      }
    }
    if (l1 > 0L)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uuf, Long.valueOf(l1));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", new Object[] { Long.valueOf(l1) });
      return true;
    }
    if (paramString.startsWith("//scanwait "))
    {
      localObject1 = paramString.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = bk.getLong(localObject1[1], -1L);
      l1 = l2;
    }
    catch (Exception localException3)
    {
      label2123:
      boolean bool3;
      boolean bool2;
      boolean bool4;
      break label2123;
    }
    if (l1 > 0L)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uug, Long.valueOf(l1));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", new Object[] { Long.valueOf(l1) });
      return true;
    }
    if (paramString.equalsIgnoreCase("//delayquery"))
    {
      if (!com.tencent.mm.platformtools.ae.eTK) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.platformtools.ae.eTK = bool1;
        return true;
      }
    }
    if (paramString.startsWith("//newinit -hard"))
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().set(15, Integer.valueOf(0));
      return true;
    }
    if (paramString.startsWith("//websearch-widget-draw "))
    {
      paramContext = paramString.split("\\s+");
      if (paramContext.length == 2) {
        ((com.tencent.mm.plugin.websearch.api.n)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.websearch.api.n.class)).Bk(bk.ZR(paramContext[1].trim()));
      }
      return true;
    }
    if (paramString.startsWith("//opensearchpreload "))
    {
      paramContext = paramString.split("\\s+");
      if (paramContext.length == 2)
      {
        if (!"1".equals(paramContext[1].trim())) {
          break label2330;
        }
        com.tencent.mm.plugin.websearch.api.ak.bZF().kY(true);
      }
      for (;;)
      {
        return true;
        label2330:
        if ("0".equals(paramContext[1].trim())) {
          com.tencent.mm.plugin.websearch.api.ak.bZF().kY(false);
        }
      }
    }
    if (paramString.startsWith("//closesearchhtmlpreload "))
    {
      paramContext = paramString.split("\\s+");
      if (paramContext.length == 2)
      {
        if (!"1".equals(paramContext[1].trim())) {
          break label2399;
        }
        com.tencent.mm.plugin.websearch.api.aa.bZs();
      }
      for (;;)
      {
        return true;
        label2399:
        if ("0".equals(paramContext[1].trim())) {
          com.tencent.mm.plugin.websearch.api.aa.bZs();
        }
      }
    }
    if (paramString.equalsIgnoreCase("//swipe"))
    {
      paramContext = com.tencent.mm.sdk.platformtools.ae.cqS();
      bool1 = paramContext.getBoolean("settings_support_swipe", true);
      paramContext = paramContext.edit();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_support_swipe", bool1).commit();
        return true;
      }
    }
    if (paramString.equalsIgnoreCase("//multiwebview"))
    {
      paramContext = LauncherUI.cyX().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0);
      bool1 = paramContext.getBoolean("settings_multi_webview", false);
      if (bool1)
      {
        paramContext = paramContext.edit();
        if (bool1) {
          break label2558;
        }
      }
      label2558:
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_multi_webview", bool1).commit();
        return true;
      }
    }
    if (paramString.equalsIgnoreCase("//sightinfo"))
    {
      au.Hx();
      bool1 = ((Boolean)com.tencent.mm.model.c.Dz().get(344065, Boolean.valueOf(false))).booleanValue();
      au.Hx();
      paramContext = com.tencent.mm.model.c.Dz();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.set(344065, Boolean.valueOf(bool1));
        au.Hx();
        com.tencent.mm.model.c.Dz().mC(true);
        return true;
      }
    }
    if (paramString.startsWith("//sighttest"))
    {
      i = bk.ZR(paramString.replace("//sighttest ", ""));
      au.Hx();
      com.tencent.mm.model.c.Dz().set(344066, Integer.valueOf(i));
      au.Hx();
      com.tencent.mm.model.c.Dz().mC(true);
      return true;
    }
    if (paramString.startsWith("//wxcamera"))
    {
      i = bk.ZR(paramString.replace("//wxcamera ", ""));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "set param %d", new Object[] { Integer.valueOf(i) });
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.utS, Integer.valueOf(i));
      return true;
    }
    if (paramString.startsWith("//printcrash"))
    {
      paramString = paramString.replace("//printcrash ", "");
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText(gL(bk.getInt(paramString, 0)));
      ((TextView)localObject1).setGravity(19);
      ((TextView)localObject1).setTextSize(1, 8.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(-16711936);
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.SmallestPadding);
      ((TextView)localObject1).setPadding(i, i, i, i);
      ((TextView)localObject1).setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, (View)localObject1, null);
      return true;
    }
    if (paramString.startsWith("//printleak"))
    {
      paramString = new TextView(paramContext);
      paramString.setText(com.tencent.mm.compatible.b.f.yB());
      paramString.setGravity(19);
      paramString.setTextSize(1, 8.0F);
      paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString.setTextColor(-16711936);
      paramString.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.SmallestPadding);
      paramString.setPadding(i, i, i, i);
      paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString, null);
      return true;
    }
    if (paramString.startsWith("//resetmapcnt"))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uwk, Integer.valueOf(0));
      return true;
    }
    if (paramString.equals("//testrsa"))
    {
      com.tencent.mm.protocal.y.K("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      return true;
    }
    if (paramString.equals("//testrsabad"))
    {
      com.tencent.mm.protocal.y.K("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      return true;
    }
    if (paramString.equals("//walletofflinetest"))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.utx, Boolean.valueOf(false));
      return false;
    }
    if (paramString.startsWith("//makemsgdata "))
    {
      i = bk.getInt(paramString.split(" ")[1], 0);
      au.Hx();
      com.tencent.mm.model.c.Fy().N(com.tencent.mm.ui.chatting.y.unh, i);
      return true;
    }
    if (paramString.startsWith("//pullappservice"))
    {
      com.tencent.mm.pluginsdk.model.app.aq.clf().eT(com.tencent.mm.sdk.platformtools.ae.getContext());
      return true;
    }
    if (paramString.startsWith("//boundaryconfig"))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitSessionTextMsg"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitSNSObjectText"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsCommentMaxSize"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitFavText"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitSendEmotionBufSize"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitSendEmotionWidth"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitFavImageSize"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitFavVoiceLength"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitSessionShortVideoBufSize"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitVideoSize"), 0)) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", new Object[] { Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AA().getValue("InputLimitFileSize"), 0)) });
      return true;
    }
    if (paramString.startsWith("//whatsnew"))
    {
      MMAppMgr.Y((Activity)paramContext);
      return true;
    }
    if (paramString.startsWith("//profile "))
    {
      au.Hx();
      paramString = com.tencent.mm.model.c.Fw().abl(paramString.replace("//profile ", "").trim());
      if ((paramString != null) && (paramString.Bo() != 0))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.getUsername());
        com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      }
      return true;
    }
    if (paramString.startsWith("//minigameupdate"))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.unU, Long.valueOf(0L));
      return true;
    }
    if (com.tencent.mm.sdk.a.b.cqk())
    {
      if (paramString.startsWith("//cs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_b35727b00b78");
        paramContext.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ae.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        return true;
      }
      if (paramString.startsWith("//acs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
        paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ae.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        return true;
      }
      if (paramString.startsWith("//wifiset"))
      {
        paramContext = new Intent();
        paramContext.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
        paramContext.putExtra("free_wifi_passowrd", "WX12345789");
        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ae.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", paramContext);
        return true;
      }
      if (paramString.startsWith("//bcs"))
      {
        paramContext = new Intent();
        paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
        paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
        paramContext.putExtra("voipCSAllowBackCamera", "1");
        paramContext.putExtra("voipCSShowOther", "1");
        paramContext.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
        paramContext.putExtra("voipCSContext", "test");
        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ae.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
        return true;
      }
    }
    if (paramString.startsWith("//getfpkey"))
    {
      paramString = bs.cwc();
      com.tencent.mm.ui.base.h.a(paramContext, paramString, "Fingerprint Key", paramContext.getString(R.l.voip_get_key_copy), paramContext.getString(R.l.confirm_dialog_cancel), new b.9(paramContext, paramString), null);
      return true;
    }
    if (paramString.startsWith("//commitwd"))
    {
      WatchDogPushReceiver.RD();
      return true;
    }
    if (paramString.startsWith("//setsnstestenv"))
    {
      localObject5 = paramString.split(" +");
      localObject1 = null;
      if (localObject5.length <= 1) {
        break label15294;
      }
      localObject4 = localObject5[1];
      if ((!com.tencent.mm.sdk.platformtools.q.isIPv4Address((String)localObject4)) && (!com.tencent.mm.sdk.platformtools.q.isIPv6Address((String)localObject4))) {
        break label15294;
      }
      if (localObject5.length <= 2) {
        break label15289;
      }
      paramString = localObject5[2];
      if ((!com.tencent.mm.sdk.platformtools.q.isIPv4Address(paramString)) && (!com.tencent.mm.sdk.platformtools.q.isIPv6Address(paramString))) {
        break label15289;
      }
      if (localObject5.length > 3)
      {
        localObject5 = localObject5[3];
        localObject1 = paramString;
        paramString = (String)localObject5;
        if (localObject4 != null) {}
        for (bool1 = true;; bool1 = false)
        {
          com.tencent.mm.platformtools.ae.eTi = bool1;
          com.tencent.mm.platformtools.ae.eSZ = (String)localObject4;
          com.tencent.mm.platformtools.ae.eTB = (String)localObject1;
          com.tencent.mm.platformtools.ae.eTC = paramString;
          com.tencent.mm.ak.f.Na().Nf();
          Toast.makeText(paramContext, String.format("%s %s %s", new Object[] { com.tencent.mm.platformtools.ae.eSZ, com.tencent.mm.platformtools.ae.eTB, com.tencent.mm.platformtools.ae.eTC }), 1).show();
          return true;
        }
      }
    }
    else
    {
      if (paramString.startsWith("//snsvcodec"))
      {
        paramContext = paramString.split(" +");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          if ("on".equalsIgnoreCase(paramContext))
          {
            gM(1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
          }
        }
        for (;;)
        {
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            gM(0);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
            continue;
            gM(-1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
          }
        }
      }
      if (paramString.startsWith("//snswxpc"))
      {
        paramContext = paramString.split(" +");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          if ("on".equalsIgnoreCase(paramContext))
          {
            gN(1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
          }
        }
        for (;;)
        {
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            gN(0);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
            continue;
            gN(-1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
          }
        }
      }
      if (paramString.startsWith("//mmdumpsys"))
      {
        au.DS().O(new b.10());
        return true;
      }
      if (paramString.startsWith("//remittance reset"))
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().set(327729, "0");
        return true;
      }
      if (paramString.startsWith("//wv "))
      {
        paramString = paramString.replace("//wv ", "");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString);
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        return true;
      }
      if (paramString.startsWith("//wvjsapi "))
      {
        paramString = paramString.replace("//wvjsapi ", "");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString);
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewTestUI", (Intent)localObject1);
        return true;
      }
      if (paramString.startsWith("//setibeacontabuinopen"))
      {
        if (au.DK())
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.urh, Integer.valueOf(1));
          return true;
        }
        return false;
      }
      if (paramString.startsWith("//setibeacontabuinclose"))
      {
        if (au.DK())
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.urh, Integer.valueOf(0));
          return true;
        }
        return false;
      }
      if (paramString.startsWith("//setibeaconpushopen"))
      {
        if (au.DK())
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.urc, Boolean.valueOf(true));
          return true;
        }
        return false;
      }
      if (paramString.startsWith("//setibeaconpushclose"))
      {
        if (au.DK())
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.urc, Boolean.valueOf(false));
          return true;
        }
        return false;
      }
      if (paramString.startsWith("//ibeacon"))
      {
        bool1 = false;
        bool3 = false;
        if (Build.VERSION.SDK_INT >= 18) {
          bool1 = true;
        }
        paramString = BluetoothAdapter.getDefaultAdapter();
        bool2 = bool3;
        if (paramString != null)
        {
          bool2 = bool3;
          if (paramString.getState() == 12) {
            bool2 = true;
          }
        }
        bool4 = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if ((bool1) && (bool2) && (bool4)) {}
        for (bool3 = true;; bool3 = false)
        {
          paramString = "isNowSupportedIbeacon:" + bool3 + "\n\nisSystemSupported:" + bool1 + "\nisBlueStateOn:" + bool2 + "\nisSupportedBLE:" + bool4 + "\nSDK:" + Build.VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.e.q.zl() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.e.q.zp();
          com.tencent.mm.ui.base.h.a(paramContext, paramString, "TestResult", paramContext.getString(R.l.chatting_copy), paramContext.getString(R.l.confirm_dialog_cancel), new b.11(paramContext, paramString), null);
          return true;
        }
      }
      if (paramString.startsWith("//gettbs"))
      {
        bool1 = com.tencent.mm.compatible.e.q.dyg.dyU;
        paramString = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        localObject1 = paramString.getString("tbs_download", null);
        localObject4 = paramString.getString("tbs_webview_disable", null);
        bool2 = paramString.getBoolean("x5_jscore_enabled", false);
        i = WebView.getInstalledTbsCoreVersion(paramContext);
        j = WebView.getTbsSDKVersion(paramContext);
        Toast.makeText(paramContext, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[] { Boolean.valueOf(bool1), localObject1, localObject4, paramString.getString("tbs_webview_min_sdk_version", null), paramString.getString("tbs_webview_max_sdk_version", null), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2) }), 1).show();
        return true;
      }
      if (paramString.startsWith("//deletetbs"))
      {
        paramString = new Intent();
        paramString.setComponent(new ComponentName(com.tencent.mm.sdk.platformtools.ae.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
        paramContext.sendBroadcast(paramString);
        paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramContext.putLong("last_check_ts", 0L);
        paramContext.apply();
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.ush, Boolean.valueOf(false));
        return true;
      }
      if (paramString.startsWith("//tbsDisableOverScroll"))
      {
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        try
        {
          paramContext = paramString.substring(paramString.indexOf(":") + 1);
          ((SharedPreferences.Editor)localObject1).putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(paramContext));
          ((SharedPreferences.Editor)localObject1).apply();
          return true;
        }
        catch (IndexOutOfBoundsException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
      if (paramString.startsWith("//enabletbs"))
      {
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramString = paramString.replace("//enabletbs ", "");
        if ("1".equals(paramString)) {}
        for (paramContext = "0";; paramContext = "1")
        {
          ((SharedPreferences.Editor)localObject1).putString("tbs_webview_disable", paramContext);
          if ("0".equals(paramString))
          {
            ((SharedPreferences.Editor)localObject1).putString("tbs_webview_min_sdk_version", "0");
            ((SharedPreferences.Editor)localObject1).putString("tbs_webview_max_sdk_version", "0");
          }
          ((SharedPreferences.Editor)localObject1).apply();
          return true;
        }
      }
      if (paramString.startsWith("//wvsha1"))
      {
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        try
        {
          paramContext = paramString.substring(paramString.indexOf(":") + 1);
          ((SharedPreferences.Editor)localObject1).putBoolean("wvsha1", Boolean.parseBoolean(paramContext));
          ((SharedPreferences.Editor)localObject1).apply();
          return true;
        }
        catch (IndexOutOfBoundsException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
      if (paramString.startsWith("//channelId")) {
        com.tencent.mm.ui.base.h.z(paramContext, com.tencent.mm.sdk.platformtools.e.bvj, "channelId");
      }
      if (paramString.startsWith("//traceroute"))
      {
        com.tencent.mm.br.d.x(paramContext, "traceroute", ".ui.NetworkDiagnoseIntroUI");
        return true;
      }
      if (paramString.startsWith("//testoom"))
      {
        i = 0;
        while (i < 20)
        {
          Bitmap.createBitmap(1024, 1920, Bitmap.Config.ARGB_8888);
          i += 1;
        }
        if (com.tencent.mm.compatible.util.d.gF(23))
        {
          Debug.getMemoryInfo(new Debug.MemoryInfo());
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "testoom %s", new Object[] { Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()) });
        }
        return true;
      }
      if (paramString.startsWith("//qzone "))
      {
        localObject1 = paramString.replace("//qzone ", "");
        new com.tencent.mm.pluginsdk.ui.applet.u(paramContext).WJ((String)localObject1);
      }
      if (paramString.startsWith("//dumpcrash"))
      {
        com.tencent.mm.vfs.e.gC(com.tencent.mm.compatible.util.e.dOP + "crash/", com.tencent.mm.compatible.util.e.dOR);
        return true;
      }
      if (paramString.startsWith("//dumpanr"))
      {
        com.tencent.mm.vfs.e.gC("/data/anr/", com.tencent.mm.compatible.util.e.dOR);
        return true;
      }
      if (paramString.startsWith("//testanr")) {
        try
        {
          Thread.sleep(10000L);
          return true;
        }
        catch (InterruptedException paramContext)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          }
        }
      }
      if (paramString.startsWith("//opensnsadRightbar"))
      {
        com.tencent.mm.platformtools.ae.eSY = true;
        return true;
      }
      if (paramString.startsWith("//setlocation "))
      {
        paramContext = paramString.split(" ");
        if ((paramContext != null) && (com.tencent.mm.sdk.a.b.cqk()))
        {
          com.tencent.mm.platformtools.ae.eSo = true;
          if (paramContext.length > 0) {
            com.tencent.mm.platformtools.ae.lat = bk.getDouble(paramContext[1], 0.0D);
          }
          if (paramContext.length > 1) {
            com.tencent.mm.platformtools.ae.lng = bk.getDouble(paramContext[2], 0.0D);
          }
          return true;
        }
        return false;
      }
      if (paramString.startsWith("//switchsdcard"))
      {
        paramString = az.crF();
        j = paramString.size();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + j);
        if ((j > 0) && (paramString.get(0) != null) && (!bk.bl(((az.a)paramString.get(0)).uhW)))
        {
          i = 0;
          while (i < j)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + i + " StatMountParse: " + paramString.get(i));
            i += 1;
          }
        }
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label15272;
          }
          if (!((az.a)paramString.get(i)).uhW.equals(com.tencent.mm.compatible.util.e.bkF))
          {
            paramString = ((az.a)paramString.get(i)).uhW;
            localObject1 = (Activity)paramContext;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + paramString);
            if (!bk.bl(paramString)) {
              break;
            }
            com.tencent.mm.ui.base.h.bA(paramContext, paramContext.getString(R.l.switch_sdcard_failed));
            return true;
          }
          i += 1;
        }
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.switch_sdcard_tips), "", paramContext.getString(R.l.app_ok), paramContext.getString(R.l.app_cancel), new b.12(paramString, paramContext, (Activity)localObject1), null);
        return true;
      }
      if (paramString.startsWith("//getip"))
      {
        au.Dk().d(new com.tencent.mm.model.bi(new b.13()));
        return true;
      }
      if (paramString.startsWith("//localjsapi"))
      {
        paramString = "file://" + com.tencent.mm.compatible.util.e.bkH + "test_jsapi.html";
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.CommandProcessor", "alvinluo path: %s", new Object[] { paramString });
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString);
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        return true;
      }
      if (paramString.startsWith("//getlocalkey"))
      {
        paramString = bs.cwb();
        com.tencent.mm.ui.base.h.a(paramContext, paramString, "Fingerprint Key", paramContext.getString(R.l.voip_get_key_copy), paramContext.getString(R.l.confirm_dialog_cancel), new b.14(paramContext, paramString), null);
        return true;
      }
      if (paramString.startsWith("//getdevid"))
      {
        paramString = com.tencent.mm.compatible.e.q.zg();
        com.tencent.mm.ui.base.h.a(paramContext, paramString, "devid", paramContext.getString(R.l.chatting_copy), paramContext.getString(R.l.confirm_dialog_cancel), new b.15(paramContext, paramString), null);
        return true;
      }
      if (paramString.startsWith("//testhtml"))
      {
        paramString = new Intent();
        paramString.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
        return true;
      }
      if (paramString.startsWith("//testlocalhtml "))
      {
        paramString = paramString.replace("//testlocalhtml ", "");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", "file://" + paramString);
        ((Intent)localObject1).putExtra("neverGetA8Key", true);
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        return true;
      }
      if (paramString.startsWith("//setkey"))
      {
        if (bs.acr(paramString.replace("//setkey", ""))) {
          Toast.makeText(paramContext, R.l.voip_config_succ, 0).show();
        }
        return true;
      }
      if (paramString.startsWith("//checkspell"))
      {
        paramString = paramString.replace("//checkspell ", "");
        if (bk.bl(paramString)) {
          return true;
        }
        localObject1 = new StringBuilder();
        i = 0;
        while (i < paramString.length())
        {
          ((StringBuilder)localObject1).append("[" + paramString.charAt(i) + ":" + SpellMap.e(paramString.charAt(i)) + "]");
          i += 1;
        }
        com.tencent.mm.ui.base.h.z(paramContext, ((StringBuilder)localObject1).toString(), "Check Spell");
        return true;
      }
      if (paramString.startsWith("//gallery "))
      {
        paramString = paramString.replace("//gallery ", "");
        if (bk.bl(paramString)) {
          return true;
        }
        paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putString("gallery", paramString).commit();
        return true;
      }
      if (paramString.startsWith("//svgtag"))
      {
        paramContext = paramString.replace("//svgtag ", "");
        if (paramContext.equals("on")) {
          com.tencent.mm.cc.c.ml(true);
        }
        for (;;)
        {
          return true;
          if (paramContext.equals("off")) {
            com.tencent.mm.cc.c.ml(false);
          }
        }
      }
      if (paramString.startsWith("//svgcode")) {}
      try
      {
        paramContext = paramString.replace("//svgcode ", "");
        if (!paramContext.equals("on")) {
          paramContext.equals("off");
        }
        paramContext = Class.forName("com.tencent.mm.BuildConfig");
        paramString = paramContext.getDeclaredField("SVGCode");
        paramString.setAccessible(true);
        bool1 = paramString.getBoolean(paramContext);
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (NoSuchFieldException paramContext)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalAccessException paramContext)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalArgumentException paramContext)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
        if (!paramString.startsWith("//testMbanner")) {
          break label6855;
        }
        try
        {
          paramContext = paramString.replace("//testMbanner ", "").split(",");
          if (paramContext.length < 2) {
            break label6853;
          }
          bc.HI().a(new bb(Integer.valueOf(paramContext[0]).intValue(), Integer.valueOf(paramContext[1]).intValue(), null));
          return true;
          if (!paramString.startsWith("//testrsa")) {
            break label6876;
          }
          com.tencent.mm.protocal.y.K("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
          if (!paramString.startsWith("//recomT")) {
            break label6910;
          }
          try
          {
            paramContext = paramString.replace("//recomT ", "");
            au.Hx().FX().a(paramContext, true, null);
            return true;
            if (!paramString.startsWith("//recomF")) {
              break label6944;
            }
            try
            {
              paramContext = paramString.replace("//recomF ", "");
              au.Hx().FX().a(paramContext, false, null);
              return true;
              if (!paramString.startsWith("//resetwxpayagree")) {
                break label6976;
              }
              com.tencent.mm.kernel.g.DQ();
              com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyY, Boolean.valueOf(false));
              return true;
              if (!paramString.startsWith("//ffmpeg")) {
                break label7104;
              }
              try
              {
                i = paramString.indexOf("-r ");
                j = paramString.indexOf("-b ");
                paramContext = paramString.substring(i + 3, j);
                paramString = paramString.substring(j + 3);
                float f = bk.getFloat(paramContext.trim(), 0.0F);
                i = bk.getInt(paramString.trim(), 0);
                com.tencent.mm.plugin.sight.base.b.oeb = i;
                com.tencent.mm.plugin.sight.base.b.oec = f;
                Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "set C2C video encode frame rate " + f + " bitrate " + i, 0).show();
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                }
              }
              if (!paramString.startsWith("//onlinevideo")) {
                break label7203;
              }
              try
              {
                i = bk.getInt(paramString.replace("//onlinevideo ", ""), 0);
                au.Hx();
                com.tencent.mm.model.c.Dz().c(ac.a.utw, Integer.valueOf(i));
                if (i > 0) {}
                for (paramContext = "online video";; paramContext = "offline video")
                {
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), paramContext, 0).show();
                  break;
                }
                if (!paramString.startsWith("//hevcinfo")) {
                  break label7270;
                }
              }
              catch (Exception paramContext)
              {
                com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "set online video fail, please ensure your command.", 1).show();
              }
              paramContext = com.tencent.mm.plugin.s.e.biq();
              paramString = com.tencent.mm.ui.chatting.y.unh;
              localObject1 = new com.tencent.mm.storage.bi();
              ((com.tencent.mm.storage.bi)localObject1).ec(paramString);
              ((com.tencent.mm.storage.bi)localObject1).fA(2);
              ((com.tencent.mm.storage.bi)localObject1).setType(1);
              ((com.tencent.mm.storage.bi)localObject1).bg(System.currentTimeMillis());
              ((com.tencent.mm.storage.bi)localObject1).setContent(paramContext);
              com.tencent.mm.model.bd.h((com.tencent.mm.storage.bi)localObject1);
              return true;
              if (!paramString.startsWith("//presns")) {
                break label7312;
              }
              com.tencent.mm.kernel.g.DS().k(new b.2(), 3000L);
              Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "preload sns", 0).show();
              return true;
              if (!paramString.startsWith("//calcwxdata")) {
                break label7354;
              }
              au.Hx();
              com.tencent.mm.model.c.Dz().c(ac.a.uwr, Long.valueOf(0L));
              Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "calc wx data success", 0).show();
              return true;
              if (!paramString.startsWith("//checkspace")) {
                break label7460;
              }
              try
              {
                i = bk.getInt(paramString.replace("//checkspace ", ""), 0);
                paramContext = new com.tencent.mm.h.a.bd();
                paramContext.bHs.bHt = i;
                com.tencent.mm.sdk.b.a.udP.m(paramContext);
                Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "check space code " + i, 0).show();
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                  Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "check space code fail, please ensure your command.", 1).show();
                }
              }
              if ((!paramString.startsWith("//showkv")) || (!com.tencent.mm.sdk.a.b.cqk())) {
                break label7544;
              }
              try
              {
                localObject1 = new Intent();
                ((Intent)localObject1).addFlags(134217728);
                ((Intent)localObject1).addFlags(524288);
                ((com.tencent.mm.plugin.kitchen.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.kitchen.a.a.class)).r(paramContext, (Intent)localObject1);
                return true;
              }
              catch (Exception localException1)
              {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CommandProcessor", "showkv error [%s]", new Object[] { localException1.toString() });
              }
              if ((!paramString.startsWith("//showexpt")) || (!com.tencent.mm.sdk.a.b.cqk())) {
                break label7584;
              }
              ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.expt.a.a.class)).p(paramContext, new Intent());
              return true;
              if ((!paramString.startsWith("//showroomexpt")) || (!com.tencent.mm.sdk.a.b.cqk())) {
                break label7624;
              }
              ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.expt.roomexpt.d.class)).q(paramContext, new Intent());
              return true;
              if (!paramString.startsWith("//upfacemodel")) {
                break label7652;
              }
              au.Dk().d(new com.tencent.mm.pluginsdk.g.a.a.m(42));
              return true;
              if (!paramString.startsWith("//facett")) {
                break label7681;
              }
              au.Hx();
              com.tencent.mm.model.c.Dz().c(ac.a.uuY, Boolean.valueOf(false));
              return true;
              if (!paramString.startsWith("//switchpaytype")) {
                break label7748;
              }
              paramContext = paramString.split(" ");
              if ((paramContext == null) || (paramContext.length < 2)) {
                break label7746;
              }
              try
              {
                i = bk.getInt(paramContext[1], 0);
                au.Hx();
                com.tencent.mm.model.c.Dz().set(339975, Integer.valueOf(i));
                return true;
              }
              catch (Exception paramContext)
              {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                return false;
              }
              return false;
              if (!paramString.startsWith("//setNfcOpenUrl ")) {
                break label7815;
              }
              paramString = paramString.replace("//setNfcOpenUrl ", "");
              Object localObject2 = com.tencent.mm.sdk.platformtools.ae.cqT().edit();
              paramContext = paramString;
              if (!paramString.equalsIgnoreCase("null")) {
                break label7793;
              }
              paramContext = "";
              ((SharedPreferences.Editor)localObject2).putString("nfc_open_url", paramContext);
              ((SharedPreferences.Editor)localObject2).commit();
              return true;
              if (!paramString.startsWith("//setMBV8Debug ")) {
                break label7888;
              }
              paramContext = paramString.replace("//setMBV8Debug ", "");
              paramString = com.tencent.mm.sdk.platformtools.ae.cqT().edit();
              if (!paramContext.equalsIgnoreCase("true")) {
                break label7874;
              }
              paramString.putBoolean("appbrandgame_open_v8debug", true);
              for (;;)
              {
                paramString.commit();
                return true;
                paramString.putBoolean("appbrandgame_open_v8debug", false);
              }
              if (!paramString.startsWith("//setAppBrandActionBar ")) {
                break label7961;
              }
              paramContext = paramString.replace("//setAppBrandActionBar ", "");
              paramString = com.tencent.mm.sdk.platformtools.ae.cqT().edit();
              if (!paramContext.equalsIgnoreCase("new")) {
                break label7947;
              }
              paramString.putBoolean("appbrand_new_actionbar", true);
              for (;;)
              {
                paramString.commit();
                return true;
                paramString.putBoolean("appbrand_new_actionbar", false);
              }
              if (!paramString.startsWith("//snskvtest ")) {
                break label8017;
              }
              paramContext = paramString.replace("//snskvtest", "").trim();
              if (!paramContext.equals("0")) {
                break label8000;
              }
              com.tencent.mm.platformtools.ae.eTu = false;
              for (;;)
              {
                return true;
                if (paramContext.equals("1")) {
                  com.tencent.mm.platformtools.ae.eTu = true;
                }
              }
              if (!paramString.startsWith("//emoji ")) {
                break label8059;
              }
              paramContext = paramString.replace("//emoji ", "");
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().AD(paramContext);
              return true;
              if (!paramString.startsWith("//share ")) {
                break label8104;
              }
              i = Integer.valueOf(paramString.replace("//share ", "")).intValue();
              au.Hx();
              com.tencent.mm.model.c.Dz().set(229635, Integer.valueOf(i));
              return true;
              if (!paramString.startsWith("//dumpappinfoblob ")) {
                break label8184;
              }
              paramString = paramString.replace("//dumpappinfoblob ", "");
              paramString = com.tencent.mm.pluginsdk.model.app.ap.brn().VU(paramString);
              com.tencent.mm.ui.base.h.z(paramContext, paramString.vh() + "\n" + paramString.vi() + "\n" + paramString.vj(), "");
              return true;
              if (!paramString.startsWith("//googleauth ")) {
                break label8292;
              }
              paramString = paramString.replace("//googleauth ", "");
              if (TextUtils.isEmpty(paramString)) {
                break label8249;
              }
              if (!"webview".equals(paramString)) {
                break label8251;
              }
              paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putBoolean("googleauth", true).commit();
              for (;;)
              {
                return true;
                if ("local".equals(paramString)) {
                  paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putBoolean("googleauth", false).commit();
                }
              }
              if (!paramString.startsWith("//clrgamecache")) {
                break label8319;
              }
              paramString = com.tencent.mm.plugin.game.a.a.a.aYi();
              if (paramString == null) {
                break label8317;
              }
              paramString.dm(paramContext);
              return true;
              if (!paramString.startsWith("//clearwepkg")) {
                break label8394;
              }
              paramContext = new un();
              paramContext.cfh.bHz = 6;
              paramString = paramString.replace("//clearwepkg ", "").trim();
              if ((bk.bl(paramString)) || (paramString.equals("//clearwepkg"))) {
                break label8384;
              }
              paramContext.cfh.cfi = paramString;
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//disableWePkg")) {
                break label8431;
              }
              paramContext = new un();
              paramContext.cfh.bHz = 7;
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//updateGameConfig")) {
                break label8467;
              }
              paramContext = new gr();
              paramContext.bOv.uC = 5;
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//clrgsd")) {
                break label8541;
              }
              paramContext = new gy();
              paramContext.bOM.bHz = 3;
              paramString = paramString.replace("//clrgsd ", "").trim();
              if ((bk.bl(paramString)) || (paramString.equals("//clrgsd"))) {
                break label8531;
              }
              paramContext.bOM.bOL = paramString;
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//delDownload")) {
                break label8615;
              }
              paramContext = new gy();
              paramContext.bOM.bHz = 4;
              paramString = paramString.replace("//delDownload ", "").trim();
              if ((bk.bl(paramString)) || (paramString.equals("//delDownload"))) {
                break label8613;
              }
              paramContext.bOM.bOL = paramString;
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//googlemap")) {
                break label8631;
              }
              com.tencent.mm.platformtools.ae.eSX = true;
              return true;
              if (!paramString.startsWith("//sosomap")) {
                break label8647;
              }
              com.tencent.mm.platformtools.ae.eSX = false;
              return true;
              if (!paramString.startsWith("//opentrace")) {
                break label8673;
              }
              new com.tencent.mm.ui.applet.d();
              com.tencent.mm.ui.applet.d.gG(com.tencent.mm.sdk.platformtools.ae.getContext());
              return true;
              if (!paramString.startsWith("//updateConversation")) {
                break label8771;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "update all conversation start");
              au.Hx();
              paramContext = com.tencent.mm.model.c.FB().cuI().iterator();
              while (paramContext.hasNext())
              {
                paramString = (String)paramContext.next();
                au.Hx();
                paramString = com.tencent.mm.model.c.Fy().dP(paramString, " and not ( type = 10000 and isSend != 2 ) ");
                au.Hx();
                com.tencent.mm.model.c.FB().aj(paramString);
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "update all conversation end");
              return true;
              if (!paramString.startsWith("//setshakecarddata")) {
                break label8791;
              }
              o.a.ckl().bzQ();
              return true;
              if (!paramString.startsWith("//clearshakecarddata")) {
                break label8811;
              }
              o.a.ckl().bzR();
              return true;
              if (!paramString.startsWith("//pageSize")) {
                break label8863;
              }
              paramContext = com.tencent.mm.sdk.platformtools.ae.getContext();
              paramString = new StringBuilder("pageSize is ");
              au.Hx();
              Toast.makeText(paramContext, com.tencent.mm.model.c.Dv().getPageSize(), 1).show();
              return true;
              if (!paramString.startsWith("//resetDBStatus")) {
                break label9035;
              }
              au.Hx();
              paramContext = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.Dx());
              try
              {
                paramString = new StringBuilder();
                au.Hx();
                paramString = com.tencent.mm.model.c.FT() + paramContext.getName().replace(".db", ".db.backup");
                com.tencent.mm.vfs.e.r(paramString, paramContext.getPath());
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "backupPath db path is %s", new Object[] { paramString });
                paramString = paramContext.getAbsolutePath() + "err" + System.currentTimeMillis();
                com.tencent.mm.vfs.e.aA(paramContext.getPath(), paramString);
                Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "db状态已重置,请重启微信", 1).show();
                return true;
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CommandProcessor", "delete failed: " + paramContext.getMessage());
                }
              }
              if (!paramString.startsWith("//makesnsdata ")) {
                break label9071;
              }
              i = bk.getInt(paramString.replace("//makesnsdata ", ""), 0);
              o.e.ckm().fJ(i);
              return true;
              if (!paramString.startsWith("//setsnsupload ")) {
                break label9099;
              }
              com.tencent.mm.platformtools.ae.eTh = bk.getInt(paramString.replace("//setsnsupload ", ""), 0);
              return true;
              if (!paramString.startsWith("//logsnstable")) {
                break label9127;
              }
              paramContext = new cn();
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//resetsnstip")) {
                break label9156;
              }
              au.Hx();
              com.tencent.mm.model.c.Dz().set(327776, Integer.valueOf(0));
              return true;
              if (!paramString.startsWith("//checkcount")) {
                break label9237;
              }
              au.Hx();
              i = com.tencent.mm.model.c.Fy().HR(com.tencent.mm.ui.chatting.y.unh);
              au.Hx();
              j = com.tencent.mm.model.c.Fy().HP(com.tencent.mm.ui.chatting.y.unh);
              Toast.makeText(paramContext, "current count :" + i + " countAuto :" + j, 1).show();
              return true;
              if (!paramString.startsWith("//changeframe ")) {
                break label9295;
              }
              paramContext = paramString.replace("//changeframe ", "");
              com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(paramContext).floatValue()).commit();
              return true;
              if (!paramString.startsWith("//opendumpview")) {
                break label9321;
              }
              new com.tencent.mm.ui.applet.c();
              com.tencent.mm.ui.applet.c.gF(com.tencent.mm.sdk.platformtools.ae.getContext());
              return true;
              if (!paramString.startsWith("//dumpmemory")) {
                break label9342;
              }
              System.gc();
              System.gc();
              com.tencent.mm.ch.b.cxy();
              return true;
              if (!paramString.startsWith("//dumpsnsfile")) {
                break label9370;
              }
              paramContext = new qc();
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              return true;
              if (!paramString.startsWith("//coverage")) {
                break label9395;
              }
              com.tencent.mm.plugin.report.b.f.LV(paramString.trim().substring(10));
              return true;
              if (!paramString.startsWith("//dumpthreadpool")) {
                break label9410;
              }
              com.tencent.mm.sdk.f.e.csy();
              return true;
              if (!paramString.startsWith("//testverifypsw ")) {
                break label9491;
              }
              paramContext = paramString.replace("//testverifypsw ", "").trim();
              if (!paramContext.equals("0")) {
                break label9474;
              }
              com.tencent.mm.platformtools.ae.eTw = false;
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.platformtools.ae.eTw) });
                return true;
                if (paramContext.equals("1")) {
                  com.tencent.mm.platformtools.ae.eTw = true;
                }
              }
              if (!paramString.startsWith("//pickpoi")) {
                break label9532;
              }
              paramString = new Intent();
              paramString.putExtra("map_view_type", 8);
              com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", paramString);
              return true;
              if (!paramString.startsWith("//configlist")) {
                break label9830;
              }
              if (!paramString.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                break label9622;
              }
              paramString = ah.aN(paramString, "^//configlist set ([\\S]*)=([\\S]*)$");
              if ((paramString == null) || (paramString.size() != 2)) {
                break label9620;
              }
              paramContext = (String)paramString.get(0);
              paramString = (String)paramString.get(1);
              com.tencent.mm.m.g.AA().put(paramContext, paramString);
              paramContext = new co();
              com.tencent.mm.sdk.b.a.udP.m(paramContext);
              for (;;)
              {
                return true;
                if (paramString.matches("^//configlist get ([\\S]*)$"))
                {
                  paramString = ah.aN(paramString, "^//configlist get ([\\S]*)$");
                  if ((paramString != null) && (paramString.size() == 1))
                  {
                    paramString = (String)paramString.get(0);
                    localObject2 = com.tencent.mm.m.g.AA().getValue(paramString);
                    Toast.makeText(paramContext, paramString + "=" + (String)localObject2, 0).show();
                  }
                }
                else
                {
                  au.Hx();
                  paramString = (String)com.tencent.mm.model.c.Dz().get(278530, "");
                  au.Hx();
                  localObject2 = (String)com.tencent.mm.model.c.Dz().get(278529, "");
                  localObject4 = com.tencent.mm.compatible.util.e.bkH + "dynacfg.xml";
                  bk.r((String)localObject4, (paramString + (String)localObject2).getBytes());
                  Toast.makeText(paramContext, "output dynacfg xml to " + (String)localObject4, 0).show();
                }
              }
              if (!paramString.startsWith("//security")) {
                break label9864;
              }
              try
              {
                paramContext = paramString.replace("//security ", "");
                au.Hx().FY().a(paramContext, true, null);
                return true;
                if (!paramString.startsWith("//updatepackage")) {
                  break label9908;
                }
                try
                {
                  paramContext = new com.tencent.mm.az.k(bk.getInt(paramString.replace("//updatepackage ", "").trim(), 0));
                  au.Dk().d(paramContext);
                  return true;
                  if (!paramString.startsWith("//copypackage")) {
                    break label10023;
                  }
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", new Object[] { paramString });
                  paramString = az.crF();
                  i = paramString.size();
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", new Object[] { Integer.valueOf(i) });
                  if (i >= 2) {
                    break label9981;
                  }
                  com.tencent.mm.ui.base.h.bA(paramContext, paramContext.getString(R.l.copy_acc_fail));
                  for (;;)
                  {
                    return true;
                    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.copy_acc_tips), "", paramContext.getString(R.l.app_ok), paramContext.getString(R.l.app_cancel), new b.3(i, paramString, paramContext), null);
                  }
                  if (!paramString.startsWith("//copy -n ")) {
                    break label10142;
                  }
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", new Object[] { paramString });
                  localObject2 = az.crF();
                  i = ((ArrayList)localObject2).size();
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", new Object[] { Integer.valueOf(i) });
                  if (i >= 2) {
                    break label10098;
                  }
                  com.tencent.mm.ui.base.h.bA(paramContext, paramContext.getString(R.l.copy_acc_fail));
                  for (;;)
                  {
                    return true;
                    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.copy_acc_tips), "", paramContext.getString(R.l.app_ok), paramContext.getString(R.l.app_cancel), new b.4(paramString, i, (ArrayList)localObject2, paramContext), null);
                  }
                  if (!paramString.startsWith("//deletepackage")) {
                    break label10192;
                  }
                  try
                  {
                    paramContext = paramString.replace("//deletepackage ", "");
                    paramString = new cg();
                    paramString.bIu.bIv = bk.getInt(paramContext, 0);
                    com.tencent.mm.sdk.b.a.udP.m(paramString);
                    return true;
                    if (!paramString.startsWith("//audiowritetofile")) {
                      break label10211;
                    }
                    com.tencent.mm.compatible.e.q.dye.dvs = true;
                    return true;
                    if (!paramString.startsWith("//bankcard")) {
                      break label10280;
                    }
                    paramString = new Intent();
                    paramString.putExtra("BaseScanUI_select_scan_mode", 7);
                    paramString.putExtra("bank_card_owner", "test");
                    if ((com.tencent.mm.plugin.voip.e.bj(paramContext)) || (com.tencent.mm.bf.e.bi(paramContext))) {
                      break label10278;
                    }
                    com.tencent.mm.br.d.b((Activity)paramContext, "scanner", ".ui.BaseScanUI", paramString);
                    return true;
                    if (!paramString.startsWith("//banner")) {
                      break label10361;
                    }
                    localObject2 = com.tencent.mm.sdk.platformtools.bn.s("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", new Object[] { (String)((Map)localObject2).get(".sysmsg.mainframebanner.$type"), (String)((Map)localObject2).get(".sysmsg.mainframebanner.showtype"), (String)((Map)localObject2).get(".sysmsg.mainframebanner.data") });
                    if (!paramString.startsWith("//gamemsg")) {
                      break label10397;
                    }
                    paramContext = new ml();
                    paramContext.bVN.content = paramString;
                    com.tencent.mm.sdk.b.a.udP.m(paramContext);
                    return true;
                    if (!paramString.startsWith("//shortcut#")) {
                      break label10433;
                    }
                    paramContext = new uj();
                    paramContext.ceN.ceO = paramString;
                    com.tencent.mm.sdk.b.a.udP.m(paramContext);
                    return true;
                    if (!paramString.startsWith("//gallerytype")) {
                      break label10465;
                    }
                    if (com.tencent.mm.ui.chatting.q.vjI) {
                      break label10459;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.ui.chatting.q.vjI = bool1;
                      return true;
                    }
                    paramContext.getString(R.l.voipface_debug);
                    if (!paramString.startsWith("//fullexit")) {
                      break label10514;
                    }
                    ag.Zn("show_whatsnew");
                    com.tencent.mm.kernel.l.k(paramContext, true);
                    MMAppMgr.aK(paramContext);
                    au.hold();
                    com.tencent.mm.kernel.g.DQ().gi("");
                    MMAppMgr.afy();
                    return true;
                    if (!paramString.startsWith("//cleardldb")) {
                      break label10537;
                    }
                    au.Hx();
                    com.tencent.mm.model.c.FC().aFX();
                    return true;
                    if (!paramString.startsWith("//setcardlayouttestdata")) {
                      break label10573;
                    }
                    paramContext = paramString.replace("//setcardlayouttestdata ", "");
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.uoV, paramContext);
                    return true;
                    if (!paramString.startsWith("//delchatroomsysmsg")) {
                      break label10685;
                    }
                    paramString = paramString.replace("//delchatroomsysmsg ", "");
                    i = paramString.indexOf(" ");
                    paramContext = paramString.substring(0, i);
                    paramString = paramString.substring(i);
                    if (!bk.bl(paramContext)) {
                      break label10622;
                    }
                    return false;
                    if (!paramString.startsWith("<")) {
                      break label10683;
                    }
                    localObject2 = new com.tencent.mm.storage.bi();
                    ((com.tencent.mm.storage.bi)localObject2).bg(System.currentTimeMillis());
                    ((com.tencent.mm.storage.bi)localObject2).setType(10002);
                    ((com.tencent.mm.storage.bi)localObject2).setContent(paramString);
                    ((com.tencent.mm.storage.bi)localObject2).fA(0);
                    ((com.tencent.mm.storage.bi)localObject2).ec(paramContext);
                    com.tencent.mm.model.bd.h((com.tencent.mm.storage.bi)localObject2);
                    return true;
                    return false;
                    if (!paramString.startsWith("//resetcrseq")) {
                      break label11018;
                    }
                    localObject2 = paramString.split(" ");
                    try
                    {
                      l1 = bk.getLong(localObject2[1], -1L);
                      l2 = bk.getLong(localObject2[2], -1L);
                      long l3 = bk.getLong(localObject2[3], -1L);
                      i = bk.getInt(localObject2[4], -1);
                      if (l1 > 0L)
                      {
                        localObject2 = l1 + "@chatroom";
                        au.Hx();
                        localObject2 = com.tencent.mm.model.c.FB().abv((String)localObject2);
                        if (localObject2 != null)
                        {
                          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", new Object[] { ((com.tencent.mm.storage.ak)localObject2).getUsername(), Long.valueOf(((com.tencent.mm.storage.ak)localObject2).vt()), Long.valueOf(((com.tencent.mm.storage.ak)localObject2).vr()), Integer.valueOf(((com.tencent.mm.storage.ak)localObject2).vs()), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
                          if (l2 > -1L) {
                            ((com.tencent.mm.storage.ak)localObject2).bd(l2);
                          }
                          if (l3 > -1L) {
                            ((com.tencent.mm.storage.ak)localObject2).bc(l3);
                          }
                          if (i >= 0) {
                            ((com.tencent.mm.storage.ak)localObject2).fF(i);
                          }
                          au.Hx();
                          i = com.tencent.mm.model.c.FB().a((com.tencent.mm.storage.ak)localObject2, ((com.tencent.mm.storage.ak)localObject2).getUsername(), false);
                          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", new Object[] { ((com.tencent.mm.storage.ak)localObject2).getUsername(), Long.valueOf(((com.tencent.mm.storage.ak)localObject2).vt()), Long.valueOf(((com.tencent.mm.storage.ak)localObject2).vr()), Integer.valueOf(((com.tencent.mm.storage.ak)localObject2).vs()), Integer.valueOf(i) });
                          return true;
                        }
                      }
                    }
                    catch (Exception localException2)
                    {
                      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", localException2, "summerbadcr resetcrseq", new Object[0]);
                    }
                    if (!paramString.startsWith("//printchatroominfo")) {
                      break label11099;
                    }
                    paramContext = com.tencent.mm.ui.chatting.y.unh;
                    if (com.tencent.mm.model.s.fn(paramContext)) {
                      break label11041;
                    }
                    return false;
                    au.Hx();
                    Object localObject3 = com.tencent.mm.model.c.FF().in(paramContext);
                    if (localObject3 != null) {
                      break label11079;
                    }
                    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", new Object[] { paramContext });
                    return false;
                    au.DS().O(new Runnable()
                    {
                      public final void run()
                      {
                        i = this.dAz.ctN();
                        j = this.dAz.field_chatroomdataflag;
                        int k = this.dAz.ctQ();
                        Object localObject1 = this.dAz;
                        if (((com.tencent.mm.storage.u)localObject1).b(((com.tencent.mm.storage.u)localObject1).unm)) {
                          ((com.tencent.mm.storage.u)localObject1).ctM();
                        }
                        int m = ((com.tencent.mm.storage.u)localObject1).unm.status;
                        int n = this.dAz.ctR();
                        localObject1 = this.dAz;
                        if (((com.tencent.mm.storage.u)localObject1).b(((com.tencent.mm.storage.u)localObject1).unm)) {
                          ((com.tencent.mm.storage.u)localObject1).ctM();
                        }
                        Object localObject3 = ((com.tencent.mm.storage.u)localObject1).unm.dtI;
                        localObject1 = this.dAz.MN();
                        au.Hx();
                        Object localObject2 = com.tencent.mm.model.c.Fy().dP(paramContext, " and msgSeq != 0 and flag & 2 != 0");
                        boolean bool;
                        if ((localObject2 != null) && (((cs)localObject2).field_msgId > 0L))
                        {
                          bool = true;
                          au.Hx();
                          int i1 = com.tencent.mm.model.c.Fy().HP(paramContext);
                          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(n), localObject3, Integer.valueOf(((List)localObject1).size()) });
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("---chatroominfo---\nid:").append(paramContext).append("\nver:").append(i).append("\nflag:").append(j).append("\ntype:").append(k).append("\nstatus:").append(m).append("\nget:").append(bool).append("\nmsgCount:").append(i1).append("\nmaxCount:").append(n).append("\nupgrader:").append((String)localObject3).append("\nmembersize:").append(((List)localObject1).size()).append("\nisSilence:").append(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhJ().Hk(paramContext)).append("\nsillenceBlock:").append(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhJ().Hn(paramContext).toString());
                          localObject3 = paramString.split(" ");
                          i = -1;
                        }
                        try
                        {
                          j = bk.getInt(localObject3[1], 0);
                          i = j;
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            continue;
                            i = j;
                          }
                        }
                        if (i != -1) {}
                        for (;;)
                        {
                          j = i;
                          if (i > ((List)localObject1).size()) {
                            j = ((List)localObject1).size();
                          }
                          if (j <= 10) {
                            break label623;
                          }
                          i = 10;
                          if (i > 0) {
                            ((StringBuilder)localObject2).append("\nmember:");
                          }
                          j = 0;
                          while (j < i)
                          {
                            ((StringBuilder)localObject2).append("\n").append((String)((List)localObject1).get(j));
                            j += 1;
                          }
                          bool = false;
                          break;
                          i = ((List)localObject1).size();
                        }
                        localObject1 = new com.tencent.mm.storage.bi();
                        ((com.tencent.mm.storage.bi)localObject1).ec(paramContext);
                        ((com.tencent.mm.storage.bi)localObject1).fA(2);
                        ((com.tencent.mm.storage.bi)localObject1).setType(1);
                        ((com.tencent.mm.storage.bi)localObject1).bg(System.currentTimeMillis());
                        ((com.tencent.mm.storage.bi)localObject1).setContent(((StringBuilder)localObject2).toString());
                        com.tencent.mm.model.bd.h((com.tencent.mm.storage.bi)localObject1);
                      }
                    });
                    return true;
                    if (!paramString.startsWith("//clean chatroomblock")) {
                      break label11331;
                    }
                    localObject3 = com.tencent.mm.ui.chatting.y.unh;
                    paramContext = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhJ();
                    if (!paramString.equals("//clean chatroomblock hard")) {
                      break label11179;
                    }
                    l1 = paramContext.He((String)localObject3);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "clean block hard! ret:" + l1, 1).show();
                    return true;
                    if (!paramString.equals("//clean chatroomblock all")) {
                      break label11227;
                    }
                    bool1 = paramContext.bhR();
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "delete table! ret:" + bool1, 1).show();
                    return true;
                    paramString = paramContext.Hm((String)localObject3);
                    paramString.field_lastLocalSeq = paramString.field_lastPushSeq;
                    paramString.field_lastLocalCreateTime = paramString.field_lastPushCreateTime;
                    if (paramString.field_seqBlockInfo == null) {
                      break label11269;
                    }
                    paramString.field_seqBlockInfo.dtR.clear();
                    l1 = paramContext.b(paramString);
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "[chatroomblock] ret:" + l1);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "clean chatroomblock! ret:" + l1, 1).show();
                    return true;
                    if (!paramString.equals("//testupdate")) {
                      break label11422;
                    }
                    paramString = "";
                    try
                    {
                      paramContext = bk.convertStreamToString(paramContext.getAssets().open("aplha_update_info.xml"));
                      au.Hx();
                      com.tencent.mm.model.c.Dz().set(352273, paramContext);
                      au.Hx();
                      com.tencent.mm.model.c.Dz().set(352274, Long.valueOf(System.currentTimeMillis()));
                      new com.tencent.mm.pluginsdk.model.app.a(paramContext).ckM();
                      return true;
                    }
                    catch (IOException paramContext)
                    {
                      for (;;)
                      {
                        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                        paramContext = paramString;
                      }
                    }
                    if ((!paramString.equals("//checkUpdate0")) && (!paramString.equals("//checkUpdate1"))) {
                      break label11463;
                    }
                    com.tencent.mm.plugin.w.d.bkt().hB(paramString.equals("//checkUpdate1"));
                    com.tencent.mm.plugin.w.d.mrJ = true;
                    return true;
                    if (!paramString.equals("//debugsnstimelinestat")) {
                      break label11524;
                    }
                    if (com.tencent.mm.platformtools.ae.eTp) {
                      break label11518;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ae.eTp = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "debugSnsTimelineStat: " + com.tencent.mm.platformtools.ae.eTp, 0).show();
                      return true;
                    }
                    if ((!paramString.startsWith("//abtestmsg")) || (!com.tencent.mm.sdk.a.b.cqk())) {
                      break label11577;
                    }
                    paramContext = com.tencent.mm.model.c.a.jj(paramString.replace("//abtestmsg", ""));
                    com.tencent.mm.model.c.c.IX().k(paramContext.items, 0);
                    com.tencent.mm.model.c.c.IY().k(paramContext.dYN, 1);
                    return true;
                    if (!paramString.startsWith("//triggergetabtest")) {
                      break label11606;
                    }
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.upI, Long.valueOf(1L));
                    return true;
                    if (!paramString.startsWith("//vad")) {
                      break label11844;
                    }
                    localObject3 = com.tencent.mm.sdk.platformtools.ae.cqS();
                    if (localObject3 != null) {
                      break label11628;
                    }
                    return false;
                    if (!paramString.startsWith("//vad get")) {
                      break label11653;
                    }
                    com.tencent.mm.ui.base.h.z(paramContext, com.tencent.mm.modelvoiceaddr.a.c.TF(), "VAD PARAMS").show();
                    return true;
                    paramContext = ((SharedPreferences)localObject3).edit();
                    if (!paramString.startsWith("//vad sd")) {
                      break label11696;
                    }
                    paramContext.putInt("s_delay_time", Integer.valueOf(paramString.substring(9).trim()).intValue());
                    if (!paramString.startsWith("//vad st")) {
                      break label11731;
                    }
                    paramContext.putInt("sil_time", Integer.valueOf(paramString.substring(9).trim()).intValue());
                    if (!paramString.startsWith("//vad snr")) {
                      break label11766;
                    }
                    paramContext.putFloat("s_n_ration", Float.valueOf(paramString.substring(10).trim()).floatValue());
                    if (!paramString.startsWith("//vad sw")) {
                      break label11801;
                    }
                    paramContext.putInt("s_window", Integer.valueOf(paramString.substring(9).trim()).intValue());
                    if (!paramString.startsWith("//vad sl")) {
                      break label11836;
                    }
                    paramContext.putInt("s_length", Integer.valueOf(paramString.substring(9).trim()).intValue());
                    paramContext.apply();
                    return true;
                    if (!paramString.startsWith("//dumpabtestrecords")) {
                      break label11997;
                    }
                    if (2 >= com.tencent.mm.sdk.platformtools.y.getLogLevel()) {
                      break label11863;
                    }
                    return false;
                    if (!paramString.contains("info")) {
                      break label11987;
                    }
                    for (paramString = com.tencent.mm.model.c.c.IY().ctq();; paramString = com.tencent.mm.model.c.c.IX().ctq())
                    {
                      localObject3 = new TextView(paramContext);
                      ((TextView)localObject3).setText(paramString);
                      ((TextView)localObject3).setGravity(8388627);
                      ((TextView)localObject3).setTextSize(1, 10.0F);
                      ((TextView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                      ((TextView)localObject3).setTextColor(-16744704);
                      ((TextView)localObject3).setTypeface(Typeface.MONOSPACE);
                      ((TextView)localObject3).setMovementMethod(new ScrollingMovementMethod());
                      i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
                      ((TextView)localObject3).setPadding(i, i, i, i);
                      com.tencent.mm.ui.base.h.a(paramContext, null, (View)localObject3, null);
                      return true;
                    }
                    if (!paramString.startsWith("//triggerWebViewCookiesCleanup")) {
                      break label12026;
                    }
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.uqU, Long.valueOf(0L));
                    return true;
                    if (!paramString.startsWith("//cleanwebcache")) {
                      break label12054;
                    }
                    paramContext = new com.tencent.mm.h.a.bn();
                    com.tencent.mm.sdk.b.a.udP.m(paramContext);
                    return true;
                    if (!paramString.startsWith("//triggerWebViewCacheCleanup")) {
                      break label12072;
                    }
                    com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    return true;
                    if (!paramString.startsWith("//dumpsnsabtest")) {
                      break label12100;
                    }
                    paramContext = new cl();
                    com.tencent.mm.sdk.b.a.udP.m(paramContext);
                    return true;
                    if (!paramString.startsWith("//dumpsilkvoicefile")) {
                      break label12116;
                    }
                    com.tencent.mm.platformtools.ae.eTt = true;
                    return true;
                    if (!paramString.startsWith("//fucktit")) {
                      break label12145;
                    }
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.uqH, Boolean.valueOf(true));
                    return true;
                    if (!paramString.startsWith("//clog ")) {
                      break label12190;
                    }
                    paramContext = paramString.substring(7);
                    com.tencent.mm.plugin.report.service.h.nFQ.ez(paramContext, "test cLog " + System.currentTimeMillis());
                    return true;
                    if ((!paramString.startsWith("//testformsg")) || (!com.tencent.mm.sdk.a.b.cqk())) {
                      break label12315;
                    }
                    paramContext = paramString.substring(12).trim();
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + au.getSysCmdMsgExtension());
                    paramString = new cd();
                    paramString.svH = com.tencent.mm.platformtools.aa.pj(paramContext);
                    paramString.svF = com.tencent.mm.platformtools.aa.pj("weixin");
                    paramString.svG = com.tencent.mm.platformtools.aa.pj(com.tencent.mm.model.q.Gj());
                    paramString.svJ = com.tencent.mm.platformtools.aa.pk("test");
                    paramString.kSW = 10002;
                    paramContext = new e.a(paramString, false, false, false);
                    au.getSysCmdMsgExtension().b(paramContext);
                    return true;
                    if (!paramString.startsWith("//canwebviewcachedownload")) {
                      break label12373;
                    }
                    if (bk.getInt(bk.pm(paramString.substring(25)).trim(), 1) <= 0) {
                      break label12367;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      au.Hx();
                      com.tencent.mm.model.c.Dz().c(ac.a.urt, Boolean.valueOf(bool1));
                      return true;
                    }
                    if (!paramString.startsWith("//canwebviewcacheprepushdownload")) {
                      break label12431;
                    }
                    if (bk.getInt(bk.pm(paramString.substring(32)).trim(), 1) <= 0) {
                      break label12425;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      au.Hx();
                      com.tencent.mm.model.c.Dz().c(ac.a.uru, Boolean.valueOf(bool1));
                      return true;
                    }
                    if (!paramString.startsWith("//resetsnslukcy")) {
                      break label12510;
                    }
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.urJ, Boolean.valueOf(false));
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.urK, Integer.valueOf(0));
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.urL, Integer.valueOf(0));
                    paramContext = new qs();
                    com.tencent.mm.sdk.b.a.udP.m(paramContext);
                    return true;
                    if (!paramString.startsWith("//mmimgdec ")) {
                      break label12582;
                    }
                    paramString = paramString.substring(11);
                    if (!"on".equalsIgnoreCase(paramString)) {
                      break label12554;
                    }
                    MMBitmapFactory.setUseMMBitmapFactory(true);
                    Toast.makeText(paramContext, "内置图片(png)解析库开启", 0).show();
                    for (;;)
                    {
                      return true;
                      if ("off".equalsIgnoreCase(paramString))
                      {
                        MMBitmapFactory.setUseMMBitmapFactory(false);
                        Toast.makeText(paramContext, "内置图片(png)解析库关闭", 0).show();
                      }
                    }
                    if (!paramString.startsWith("//enablempsp")) {
                      break label12609;
                    }
                    ap.a.mu(false);
                    Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                    return true;
                    if (!paramString.startsWith("//disablempsp")) {
                      break label12636;
                    }
                    ap.a.mu(true);
                    Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                    return true;
                    if (!paramString.startsWith("//soterpay")) {
                      break label12658;
                    }
                    com.tencent.mm.br.d.x(paramContext, "fingerprint", ".ui.SoterPayTestUI");
                    return true;
                    if (!paramString.startsWith(paramContext.getString(R.l.voip_debug))) {
                      break label12723;
                    }
                    if (com.tencent.mm.platformtools.ae.eTA) {
                      break label12717;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.platformtools.ae.eTA = bool1;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), String.format("showVoipDebugLog:%b", new Object[] { Boolean.valueOf(com.tencent.mm.platformtools.ae.eTA) }), 0).show();
                      return true;
                    }
                    if (!paramString.startsWith("//getdltaskinfo")) {
                      break label12884;
                    }
                    paramContext = paramString.replace("//getdltaskinfo ", "");
                    try
                    {
                      paramString = com.tencent.mm.plugin.downloader.model.c.dk(bk.getLong(paramContext, 0L));
                      if (paramString != null) {
                        com.tencent.mm.sdk.platformtools.y.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramString.field_downloadId), paramString.field_downloadUrl, paramString.field_filePath, paramString.field_md5 });
                      } else {
                        com.tencent.mm.sdk.platformtools.y.i("getdltaskinfo", "infoID null");
                      }
                    }
                    catch (Exception paramString)
                    {
                      paramContext = com.tencent.mm.plugin.downloader.model.c.zK(paramContext);
                      if (paramContext != null) {
                        com.tencent.mm.sdk.platformtools.y.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramContext.field_downloadId), paramContext.field_downloadUrl, paramContext.field_filePath, paramContext.field_md5 });
                      } else {
                        com.tencent.mm.sdk.platformtools.y.i("getdltaskinfo", "infoURL null");
                      }
                    }
                    if (!paramString.startsWith("//testscan ")) {
                      break label12964;
                    }
                    paramContext = paramString.split(" ");
                    com.tencent.mm.platformtools.ae.eTz = bk.getFloat(paramContext[1], 0.0F);
                    com.tencent.mm.platformtools.ae.eTy = bk.getFloat(paramContext[2], 0.0F);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "mode auto:" + com.tencent.mm.platformtools.ae.eTz + ",mode continuous:" + com.tencent.mm.platformtools.ae.eTy, 1).show();
                    return true;
                    if (!paramString.startsWith("//switchrecordmode")) {
                      break label13062;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.ae.cqS();
                    bool2 = paramContext.getBoolean("settings_voicerecorder_mode", false);
                    if (bool2) {
                      break label13040;
                    }
                    bool1 = true;
                    paramContext.edit().putBoolean("settings_voicerecorder_mode", bool1).commit();
                    if (!bool2) {
                      break label13046;
                    }
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "Turn off silk record", 1).show();
                    for (;;)
                    {
                      return true;
                      bool1 = false;
                      break;
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "Turn on silk record", 1).show();
                    }
                    if (!paramString.startsWith("//indoorsensorconfig ")) {
                      break label13090;
                    }
                    com.tencent.mm.modelstat.e.Rq().ns(paramString.replace("//indoorsensorconfig ", ""));
                    return true;
                    if (!paramString.startsWith("//testindoorsensor ")) {
                      break label13153;
                    }
                    paramContext = paramString.replace("//testindoorsensor ", "").split(",");
                    com.tencent.mm.modelstat.e.Rq().a(12345, false, paramContext[0].equals("1"), bk.getFloat(paramContext[1], 0.0F), bk.getFloat(paramContext[2], 0.0F), 12);
                    return true;
                    if (!paramString.startsWith("//facedebug")) {
                      break label13165;
                    }
                    return true;
                    if (!paramString.startsWith("//rstfacett")) {
                      break label13177;
                    }
                    return true;
                    if (!paramString.startsWith("//switchjsc")) {
                      break label13305;
                    }
                    paramContext = paramString.replace("//switchjsc ", "");
                    paramString = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                    if (!"clear".equals(paramContext)) {
                      break label13239;
                    }
                    paramString.edit().remove("switch_x5_jscore").apply();
                    for (;;)
                    {
                      return true;
                      if ("true".equals(paramContext)) {
                        paramString.edit().putBoolean("switch_x5_jscore", true).apply();
                      } else if ("false".equals(paramContext)) {
                        paramString.edit().putBoolean("switch_x5_jscore", false).apply();
                      }
                    }
                    if (!paramString.startsWith("//rfcdn")) {
                      break label13349;
                    }
                    try
                    {
                      com.tencent.mm.ak.f.Ne().keep_OnRequestDoGetCdnDnsInfo(888);
                      return true;
                    }
                    catch (Exception paramContext)
                    {
                      for (;;)
                      {
                        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CommandProcessor", "rfcdn :%s", new Object[] { bk.j(paramContext) });
                      }
                    }
                    if (!paramString.startsWith("//testcrscroll ")) {
                      break label13413;
                    }
                    localObject3 = paramString.split(" ");
                    if ((localObject3 == null) || (localObject3.length <= 1)) {
                      break label13413;
                    }
                    aj.vsu = bk.getInt(localObject3[1], 0);
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", new Object[] { Integer.valueOf(aj.vsu) });
                    return true;
                    if (!paramString.startsWith("//switchx5jscore")) {
                      break label13478;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.ae.cqS();
                    bool1 = paramContext.getBoolean("switch_x5_jscore", true);
                    paramContext = paramContext.edit();
                    if (bool1) {
                      break label13472;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("switch_x5_jscore", bool1).apply();
                      return true;
                    }
                    if (!paramString.startsWith("//removeaudioplayer")) {
                      break label13539;
                    }
                    paramContext = paramString.split(" ");
                    if (paramContext.length < 2) {
                      break label13537;
                    }
                    i = bk.getInt(paramContext[1], 3);
                    if ((i < 2) || (i > 9)) {
                      break label13537;
                    }
                    au.Hx();
                    com.tencent.mm.model.c.Dz().c(ac.a.uvD, Integer.valueOf(i));
                    return true;
                    if (!paramString.startsWith("//showaudiotoast")) {
                      break label13608;
                    }
                    paramContext = paramString.split(" ");
                    if (paramContext.length < 2) {
                      break label13600;
                    }
                    i = bk.getInt(paramContext[1], 0);
                    au.Hx();
                    paramContext = com.tencent.mm.model.c.Dz();
                    paramString = ac.a.uvE;
                    if (i != 1) {
                      break label13602;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.c(paramString, Boolean.valueOf(bool1));
                      return true;
                    }
                    if (!paramString.startsWith("//switchmusicplayer")) {
                      break label13951;
                    }
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "msg:%s", new Object[] { paramString });
                    paramContext = paramString.split(" ");
                    if (paramContext.length <= 2) {
                      break label13732;
                    }
                    if (bk.getInt(paramContext[1], 0) != 0) {
                      break label13734;
                    }
                    i = 0;
                    int m = bk.getInt(paramContext[2], -1);
                    au.Hx();
                    int k = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uvB, Integer.valueOf(0))).intValue();
                    j = 1;
                    if (m != -1) {
                      break label13744;
                    }
                    if (i == 0) {
                      break label13739;
                    }
                    i = 255;
                    for (;;)
                    {
                      if (j != 0)
                      {
                        au.Hx();
                        com.tencent.mm.model.c.Dz().c(ac.a.uvB, Integer.valueOf(i));
                      }
                      return true;
                      i = 1;
                      break;
                      i = 0;
                      continue;
                      if (m == 0)
                      {
                        if (i != 0) {
                          i = k | 0x1;
                        } else {
                          i = k & 0xFFFFFFFE;
                        }
                      }
                      else if (m == 1)
                      {
                        if (i != 0) {
                          i = k | 0x2;
                        } else {
                          i = k & 0xFFFFFFFD;
                        }
                      }
                      else if (m == 4)
                      {
                        if (i != 0) {
                          i = k | 0x4;
                        } else {
                          i = k & 0xFFFFFFFB;
                        }
                      }
                      else if (m == 6)
                      {
                        if (i != 0) {
                          i = k | 0x10;
                        } else {
                          i = k & 0xFFFFFFEF;
                        }
                      }
                      else if (m == 7)
                      {
                        if (i != 0) {
                          i = k | 0x20;
                        } else {
                          i = k & 0xFFFFFFDF;
                        }
                      }
                      else if (m == 8)
                      {
                        if (i != 0) {
                          i = k | 0x40;
                        } else {
                          i = k & 0xFFFFFFBF;
                        }
                      }
                      else if (m == 9)
                      {
                        if (i != 0) {
                          i = k | 0x80;
                        } else {
                          i = k & 0xFFFFFF7F;
                        }
                      }
                      else
                      {
                        j = 0;
                        i = k;
                      }
                    }
                    if (!paramString.startsWith("//testdefaultrsa")) {
                      break label14061;
                    }
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                    paramString = paramString.split(" ");
                    if ((paramString == null) || (paramString.length <= 1)) {
                      break label14021;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      com.tencent.mm.protocal.y.K("", "", 0);
                      paramString = com.tencent.mm.kernel.g.DO().Dk().Do();
                      if (paramString != null) {
                        break;
                      }
                      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.CommandProcessor", "summercert testdefaultrsa push not alive");
                      return false;
                    }
                    new com.tencent.mm.modelsimple.q("", "", "", 0).Qx().a(paramString, new b.6(bool1, paramContext));
                    return true;
                    if (!paramString.startsWith("//dumpdefaultrsa")) {
                      break label14078;
                    }
                    return x(paramContext, "");
                    if (!paramString.startsWith("//hardwareinfo")) {
                      break label14105;
                    }
                    ((com.tencent.mm.plugin.hardwareopt.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).gF(true);
                    return true;
                    if (!paramString.startsWith("//showStringName")) {
                      break label14171;
                    }
                    paramContext = com.tencent.mm.sdk.platformtools.ae.cqS();
                    bool1 = paramContext.getBoolean("ShowStringName", false);
                    paramContext = paramContext.edit();
                    if (bool1) {
                      break label14165;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("ShowStringName", bool1).commit();
                      return true;
                    }
                    if (!paramString.startsWith("//mmphotoedit")) {
                      break label14200;
                    }
                    com.tencent.mm.br.d.b(paramContext, "mmsight", ".ui.TestVideoEditUI", new Intent());
                    return true;
                    if (!paramString.startsWith("//msgDelay")) {
                      break label14216;
                    }
                    com.tencent.mm.ui.conversation.a.m.ha(paramContext);
                    return true;
                    if (!paramString.startsWith("//cpDelayedMsg")) {
                      break label14232;
                    }
                    com.tencent.mm.ui.conversation.a.m.hb(paramContext);
                    return true;
                    if (!paramString.startsWith("//testhce")) {
                      break label14254;
                    }
                    com.tencent.mm.br.d.x(paramContext, "nfc", ".ui.HceTestUI");
                    return true;
                    if (!paramString.startsWith("//debugbigimg")) {
                      break label14338;
                    }
                    paramContext = paramString.split(" ");
                    if (paramContext.length != 2) {
                      break label14311;
                    }
                    if (!paramContext[1].equals("1")) {
                      break label14313;
                    }
                    com.tencent.mm.sdk.platformtools.ae.cqS().edit().putBoolean("debug_big_img", true).apply();
                    for (;;)
                    {
                      return true;
                      com.tencent.mm.sdk.platformtools.ae.cqS().edit().putBoolean("debug_big_img", false).apply();
                    }
                    if (!paramString.startsWith("//testservice ")) {
                      break label14414;
                    }
                    paramString = paramString.replace("//testservice ", "");
                    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    if ((paramString == null) || (!paramString.equals("1"))) {
                      break label14408;
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramContext.putBoolean("forceTrigger", bool1).commit();
                      return true;
                    }
                    if (!paramString.startsWith("//openDetect")) {
                      break label14455;
                    }
                    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", false).apply();
                    return true;
                    if (!paramString.startsWith("//closeDetect")) {
                      break label14496;
                    }
                    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", true).apply();
                    return true;
                    if (!paramString.startsWith("//snsimage")) {
                      break label14585;
                    }
                    try
                    {
                      i = bk.getInt(paramString.replace("//snsimage ", ""), 0);
                      com.tencent.mm.ak.f.Nd().ir(i);
                      if (i > 0) {}
                      for (paramContext = "tcp sns image download";; paramContext = "http sns image download")
                      {
                        Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), paramContext, 0).show();
                        break;
                      }
                      if (!paramString.startsWith("//resetWeishi")) {
                        break label14613;
                      }
                    }
                    catch (Exception paramContext)
                    {
                      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "set snsimage fail, please ensure your command.", 1).show();
                    }
                    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzI, Integer.valueOf(0));
                    return true;
                    if (!paramString.startsWith("//clearWxWebCacheAndCookie")) {
                      break label14657;
                    }
                    paramContext = new Intent();
                    paramContext.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    paramContext.putExtra("tools_clean_webview_cache_ignore_cookie", true);
                    com.tencent.mm.cl.b.av(paramContext);
                    return true;
                    if (!paramString.startsWith("//destroyPreloadGameWebCore")) {
                      break label14672;
                    }
                    com.tencent.mm.plugin.game.luggage.i.destroy();
                    return true;
                    i = fq(paramString);
                    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", new Object[] { Integer.valueOf(i) });
                    switch (i)
                    {
                    default: 
                      return false;
                    case 0: 
                      return false;
                    case 568: 
                      Assert.assertTrue("test errlog", false);
                      return true;
                    case 569: 
                      au.Hx().FV();
                      return true;
                    case 570: 
                      if (bs.acr(fr(paramString))) {
                        Toast.makeText(paramContext, R.l.voip_config_succ, 0).show();
                      }
                      return true;
                    case 571: 
                      paramContext = fr(paramString);
                      au.Hx();
                      com.tencent.mm.model.c.Dz().set(8195, paramContext);
                      return true;
                    case 572: 
                      com.tencent.mm.sdk.platformtools.e.bvl = Integer.valueOf(fr(paramString)).intValue();
                      return true;
                    case 574: 
                      paramString = new StringBuilder().append(com.tencent.mm.compatible.e.q.zf());
                      au.Hx();
                      com.tencent.mm.ui.base.h.z(paramContext, com.tencent.mm.a.g.o(com.tencent.mm.model.c.CK().getBytes()), "md5");
                      return true;
                    case 579: 
                      paramContext = fr(paramString);
                      am.a.Hh().V(paramContext, "");
                      return true;
                    case 580: 
                      au.Dk().d(new com.tencent.mm.model.bi(new b.7()));
                      return true;
                    case 581: 
                      paramContext = fr(paramString);
                      com.tencent.mm.pluginsdk.model.app.ap.brm().VS(paramContext);
                      return true;
                    case 582: 
                      paramContext = fr(paramString);
                      au.Hx();
                      paramContext = com.tencent.mm.model.c.Fw().abl(paramContext);
                      if ((paramContext == null) || (paramContext.Bo() == 0)) {
                        return false;
                      }
                      paramContext.AH();
                      com.tencent.mm.model.s.u(paramContext);
                      return true;
                    case 583: 
                      au.Hx();
                      com.tencent.mm.model.c.FW();
                      return true;
                    case 584: 
                    case 585: 
                      bf.iO(fr(paramString));
                      return true;
                    case 586: 
                      paramContext = paramString.split(" ");
                      if ((paramContext != null) && (paramContext.length == 3)) {
                        com.tencent.mm.modelmulti.q.bo(bk.getInt(paramContext[1], 0), bk.getInt(paramContext[2], 0));
                      }
                      return true;
                    case 587: 
                      paramContext = new cm();
                      com.tencent.mm.sdk.b.a.udP.m(paramContext);
                      return true;
                    case 588: 
                      com.tencent.mm.vfs.e.nb("/sdcard/tencent/MicroMsg/back");
                      au.Hx();
                      com.tencent.mm.vfs.e.gC(com.tencent.mm.model.c.FT(), "/sdcard/tencent/MicroMsg/back");
                      return true;
                    case 590: 
                      return true;
                    }
                    try
                    {
                      paramContext = paramString.split(" ");
                      if ((paramContext != null) && (paramContext.length > 1))
                      {
                        paramContext = com.tencent.mm.sdk.platformtools.bn.s(paramContext[0], "sysmsg");
                        au.Hx().FZ().k(paramContext);
                      }
                    }
                    catch (Exception paramContext)
                    {
                      for (;;)
                      {
                        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "hy: error occured in commandProcessor", new Object[0]);
                      }
                    }
                    return true;
                  }
                  catch (Exception paramContext)
                  {
                    break label10190;
                  }
                }
                catch (Exception paramContext)
                {
                  break label9906;
                }
              }
              catch (Exception paramContext)
              {
                break label9862;
              }
            }
            catch (Exception paramContext)
            {
              break label6942;
            }
          }
          catch (Exception paramContext)
          {
            break label6908;
          }
        }
        catch (Exception paramContext)
        {
          break label6853;
        }
      }
      catch (Exception paramContext) {}
      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), "Using SVG Code : " + bool1 + " " + com.tencent.mm.svg.b.b.cxs(), 1).show();
      break label15302;
    }
    label6853:
    label6855:
    label6876:
    label6908:
    label6910:
    label8319:
    label13951:
    return true;
    label6942:
    label6944:
    label6976:
    label7270:
    label7544:
    label8059:
    label8317:
    label9342:
    label10622:
    return true;
    label7104:
    label7624:
    label7652:
    label7793:
    label8184:
    label9981:
    label11518:
    return true;
    label7203:
    label7354:
    label7746:
    label7748:
    label7888:
    label8017:
    label8292:
    label8431:
    label10098:
    label10361:
    label12026:
    label14078:
    return true;
  }
  
  private static boolean x(Context paramContext, String paramString)
  {
    boolean bool = true;
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bk.bl(paramString)) {
      localStringBuffer.append(paramString + "\n\n");
    }
    localStringBuffer.append("Default RSA Info:\n");
    localStringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION + "\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_VERSION = 179\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYN = A3A49624167DC4D46199771AC1B48319B57251A23A457592646E8C3E8EEE590F7205EC69668BD537D9A9BFF35694294D0841139DE3C5B9E64EB0BBF14660E6FC4C35EBD0DD291B7BE5B23AB72F84B1DE9DCB67A0E157176DC1D796D207F4E65B5FCCA8099CBCA4D1F550AA272752C0C9CC650AA32FDF4D9B46650BC7989562F9568605DC7EC49CDD3E4A498CCBDC16A1C679CE4D6CCB1871FF1D7F32D865D1F336DBFB0A09258EB42B69C09DEE45981D4B55A9C0EACB68AC22E525488202AFCF1FF6D0F18D18C29A72E6C83C5D8A55910D55B7E5E3787B6FE5BB915118817B01311130AD7F1F572FF7746E98F322AE834B0E4B68D9523BBBF6C0841ADD2309EB len(512)\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_VERSION = 180\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYN = A770028BA38DDB08252B6C41C201838553E75552DE0B8EC10DF3E2B6F641026644178D7C362912C51B8CE18682C8502C18B1ACB05A45C725E4EE4F4C8C4FE08D5C8D75FA305175D2595DF5632413E897AE5366ED1A63146B8B0AEE9D955999331B23988F7564FCA291E01E36CA3AE78116FCFDB7AB8A881B33DF687C59E3918A51F5D37C5C20401EE3CFDA007094C904ED4CCE96981548D04EDAD3EAD0071DD75C2C2AA07E5686781BD3723A1305FFB5EBA785B0A50B39EA5003599591ADDAF75B20B8E5048A0B1116CD8A368D54352E73E2FC884F4DE7FE451DE05CBA147BFBDC7A82D3A24C6F5D3F0698B57522E8B4075735A1D1E6D9F531B8C977B8E0619B len(512)\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + localStringBuffer.toString());
    if (!com.tencent.mm.sdk.a.b.cqk()) {
      bool = false;
    }
    do
    {
      return bool;
      paramString = new TextView(paramContext);
      paramString.setText(localStringBuffer.toString());
      paramString.setGravity(19);
      paramString.setTextSize(1, 10.0F);
      paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString.setTextColor(-16711936);
      paramString.setTypeface(Typeface.MONOSPACE);
      int i = paramContext.getResources().getDimensionPixelSize(R.f.SmallestPadding);
      paramString.setPadding(i, i, i, i);
      paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.h.a(paramContext, null, paramString, null);
    } while (!com.tencent.mm.protocal.y.cpl());
    Toast.makeText(paramContext, "dump file:" + com.tencent.mm.compatible.util.e.bkH + "DefaultRSA.java", 1).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b
 * JD-Core Version:    0.7.0.1
 */