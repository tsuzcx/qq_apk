package com.tencent.mm.br;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.service.ProcessService.DexOptProcessService;
import com.tencent.mm.service.ProcessService.ExDeviceProcessService;
import com.tencent.mm.service.ProcessService.LiteProcessService;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.service.ProcessService.PushProcessServicer;
import com.tencent.mm.service.ProcessService.SandBoxProcessService;
import com.tencent.mm.service.ProcessService.SupportProcessService;
import com.tencent.mm.service.ProcessService.ToolsProcessService;
import com.tencent.mm.service.ProcessService.ToolsmpProcessService;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.xweb.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class c
{
  private static final Map<String, String> KxX;
  private static HashMap<String, com.tencent.mm.pluginsdk.b.d> KxY;
  private static final HashSet<String> KxZ;
  
  static
  {
    AppMethodBeat.i(133750);
    HashMap localHashMap = new HashMap();
    KxX = localHashMap;
    localHashMap.put("location", "talkroom");
    KxX.put("talkroom", "voip");
    KxY = new HashMap();
    KxZ = new HashSet() {};
    AppMethodBeat.o(133750);
  }
  
  public static void V(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(133711);
    c(paramContext, paramString1, paramString2, null);
    AppMethodBeat.o(133711);
  }
  
  public static com.tencent.mm.pluginsdk.b.a W(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(133743);
    Object localObject = bfU(paramString1);
    if (localObject == null)
    {
      Log.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(133743);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.d)localObject).getContactWidgetFactory();
    if (localObject == null)
    {
      Log.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(133743);
      return null;
    }
    paramContext = ((com.tencent.mm.pluginsdk.b.c)localObject).ak(paramContext, paramString2);
    AppMethodBeat.o(133743);
    return paramContext;
  }
  
  /* Error */
  @java.lang.Deprecated
  public static com.tencent.mm.pluginsdk.b.d a(String paramString, a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 131
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 61	com/tencent/mm/br/c:KxX	Ljava/util/Map;
    //   11: aload_0
    //   12: invokeinterface 135 2 0
    //   17: checkcast 137	java/lang/String
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +22 -> 44
    //   25: ldc 98
    //   27: ldc 139
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: getstatic 75	com/tencent/mm/br/c:KxY	Ljava/util/HashMap;
    //   47: aload_0
    //   48: invokevirtual 143	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 108	com/tencent/mm/pluginsdk/b/d
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +21 -> 77
    //   59: aload_1
    //   60: invokeinterface 148 1 0
    //   65: ldc 131
    //   67: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_2
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: areturn
    //   77: aload_0
    //   78: invokestatic 151	com/tencent/mm/br/c:bfV	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/d;
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 148 1 0
    //   92: ldc 131
    //   94: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: astore_0
    //   99: goto -27 -> 72
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    //   108: astore_2
    //   109: aload_0
    //   110: invokestatic 151	com/tencent/mm/br/c:bfV	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/d;
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_1
    //   119: invokeinterface 148 1 0
    //   124: ldc 131
    //   126: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_2
    //   130: astore_0
    //   131: goto -59 -> 72
    //   134: astore_2
    //   135: ldc 98
    //   137: ldc 153
    //   139: iconst_2
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_0
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_2
    //   150: invokevirtual 157	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: ldc 98
    //   159: ldc 162
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_0
    //   168: aastore
    //   169: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_1
    //   173: invokeinterface 148 1 0
    //   178: aconst_null
    //   179: astore_0
    //   180: ldc 131
    //   182: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: goto -113 -> 72
    //   188: astore_2
    //   189: ldc 98
    //   191: ldc 167
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_0
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: aload_2
    //   204: invokevirtual 168	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: goto -54 -> 157
    //   214: astore_2
    //   215: ldc 98
    //   217: ldc 170
    //   219: iconst_2
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload_2
    //   230: invokevirtual 171	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -80 -> 157
    //   240: astore_0
    //   241: ldc 98
    //   243: aload_0
    //   244: ldc 173
    //   246: iconst_0
    //   247: anewarray 4	java/lang/Object
    //   250: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: goto -75 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramString	String
    //   0	256	1	parama	a
    //   20	78	2	localObject	Object
    //   108	1	2	localException	Exception
    //   113	17	2	locald	com.tencent.mm.pluginsdk.b.d
    //   134	16	2	localClassNotFoundException	ClassNotFoundException
    //   188	16	2	localInstantiationException	java.lang.InstantiationException
    //   214	16	2	localIllegalAccessException	java.lang.IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   3	21	102	finally
    //   25	44	102	finally
    //   44	55	102	finally
    //   59	70	102	finally
    //   77	82	102	finally
    //   86	92	102	finally
    //   92	97	102	finally
    //   109	114	102	finally
    //   118	124	102	finally
    //   124	129	102	finally
    //   135	157	102	finally
    //   157	178	102	finally
    //   180	185	102	finally
    //   189	211	102	finally
    //   215	237	102	finally
    //   241	253	102	finally
    //   77	82	108	java/lang/Exception
    //   86	92	108	java/lang/Exception
    //   109	114	134	java/lang/ClassNotFoundException
    //   118	124	134	java/lang/ClassNotFoundException
    //   109	114	188	java/lang/InstantiationException
    //   118	124	188	java/lang/InstantiationException
    //   109	114	214	java/lang/IllegalAccessException
    //   118	124	214	java/lang/IllegalAccessException
    //   157	178	240	java/lang/Exception
  }
  
  private static String a(Intent paramIntent, Uri paramUri)
  {
    AppMethodBeat.i(229796);
    String str = paramUri.getQueryParameter("not_in_game_luggage");
    int i = paramIntent.getIntExtra("KHalfScreenHeight", 0);
    if ((!Util.nullAsNil(str).equals("1")) && (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOd, true))) {
      if ((t.bsh(paramUri.getHost())) && (!ToolsProcessIPCService.ayt()))
      {
        paramIntent = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewMpUI";
        if (i > 0) {
          paramIntent = "com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI";
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(229796);
      return paramIntent;
      paramIntent = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
      break;
      if ((t.bsh(paramUri.getHost())) && (!ToolsProcessIPCService.ayt())) {
        paramIntent = ".ui.tools.game.GameWebViewMpUI";
      } else {
        paramIntent = ".ui.tools.game.GameWebViewUI";
      }
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(133709);
    paramContext = new a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(133696);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label114;
          }
        }
        label114:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(MMApplicationContext.getPackageName(), str);
          MMWizardActivity.ay(paramContext, localIntent);
          AppMethodBeat.o(133696);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    };
    new Object() {};
    a(paramString1, paramContext);
    AppMethodBeat.o(133709);
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133722);
    Log.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.PluginHelper", "start activity error, context is null");
      AppMethodBeat.o(133722);
      return;
    }
    if (".ui.tools.WebViewUI".equals(paramString2))
    {
      paramBoolean = WXHardCoderJNI.hcBizEnable;
      int j = WXHardCoderJNI.hcBizDelay;
      int k = WXHardCoderJNI.hcBizCPU;
      int m = WXHardCoderJNI.hcBizIO;
      int i;
      if (WXHardCoderJNI.hcBizThr) {
        i = Process.myTid();
      }
      for (;;)
      {
        Log.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")) });
        try
        {
          String str = paramIntent.getStringExtra("rawUrl");
          Uri localUri;
          if (!Util.isNullOrNil(str))
          {
            localUri = Uri.parse(str);
            if (paramIntent.getLongExtra("start_activity_time", 0L) == 0L) {
              paramIntent.putExtra("start_activity_time", System.currentTimeMillis());
            }
            if ((localUri.getHost() != null) && (localUri.getHost().equals("mp.weixin.qq.com")) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext)))
            {
              Log.i("MicroMsg.PluginHelper", "Block mp url %s", new Object[] { str });
              AppMethodBeat.o(133722);
              return;
              i = 0;
              continue;
            }
            if ((localUri.getHost() != null) && (localUri.getHost().equals(WeChatHosts.domainString(2131761707))))
            {
              str = a(paramIntent, localUri);
              paramString2 = str;
            }
          }
          for (;;)
          {
            paramContext = new a()
            {
              public final void onDone()
              {
                AppMethodBeat.i(133706);
                Intent localIntent;
                if (this.val$intent == null)
                {
                  localIntent = new Intent();
                  str = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
                  if (!paramString2.startsWith(".")) {
                    break label143;
                  }
                }
                label143:
                for (String str = str + paramString2;; str = paramString2)
                {
                  localIntent.setClassName(MMApplicationContext.getPackageName(), str);
                  if (!(paramContext instanceof Activity)) {
                    break label151;
                  }
                  ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
                  c.g(paramContext, paramString2, localIntent);
                  AppMethodBeat.o(133706);
                  return;
                  localIntent = this.val$intent;
                  break;
                }
                label151:
                Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
                AppMethodBeat.o(133706);
              }
            };
            new Object() {};
            a(paramString1, paramContext);
            AppMethodBeat.o(133722);
            return;
            if ((t.bsh(localUri.getHost())) && (!ToolsProcessIPCService.ayt()))
            {
              if (!"true".equalsIgnoreCase(com.tencent.xweb.a.brJ("dis_switch_to_mp_start_activity_for_ret"))) {
                paramString2 = ".ui.tools.WebviewMpUI";
              } else {
                Log.i("MicroMsg.PluginHelper", "dis_switch_to_mp_start_activity_for_ret == true");
              }
            }
            else {}
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PluginHelper", "parse url failed :" + localException.getMessage());
        }
      }
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent1, final Intent paramIntent2)
  {
    AppMethodBeat.i(133710);
    paramContext = new a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(133702);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label118;
          }
        }
        label118:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(MMApplicationContext.getPackageName(), str);
          MMWizardActivity.b(paramContext, localIntent, paramIntent2);
          AppMethodBeat.o(133702);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    };
    new Object() {};
    a(paramString1, paramContext);
    AppMethodBeat.o(133710);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(133713);
    if (!com.tencent.mm.compatible.util.d.oE(21)) {}
    try
    {
      if ((paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_multi_webview", false)) && (".ui.tools.WebViewUI".endsWith(paramString2)))
      {
        Log.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
        paramIntent.addFlags(134217728);
        paramIntent.addFlags(524288);
      }
      b(paramContext, paramString1, paramString2, paramIntent, paramBundle);
      AppMethodBeat.o(133713);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PluginHelper", "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static void a(ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(133738);
    com.tencent.mm.service.c.a(paramServiceConnection, paramString, true, bfS(paramString));
    AppMethodBeat.o(133738);
  }
  
  public static void a(Fragment paramFragment, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(133728);
    String str = MMApplicationContext.getSourcePackageName();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(MMApplicationContext.getPackageName(), str);
      if (!(paramFragment instanceof Fragment)) {
        break;
      }
      paramFragment.startActivityForResult(paramIntent, paramInt);
      g(paramFragment.getActivity(), paramString, paramIntent);
      AppMethodBeat.o(133728);
      return;
    }
    Log.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    AppMethodBeat.o(133728);
  }
  
  public static void a(final Fragment paramFragment, final String paramString1, final String paramString2, Intent paramIntent, final int paramInt)
  {
    AppMethodBeat.i(133723);
    Log.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    paramFragment = new a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(133699);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label136;
          }
        }
        label136:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(MMApplicationContext.getPackageName(), str);
          paramFragment.startActivityForResult(localIntent, paramInt);
          c.g(paramFragment.getActivity(), paramString2, this.val$intent);
          AppMethodBeat.o(133699);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    };
    new Object() {};
    a(paramString1, paramFragment);
    AppMethodBeat.o(133723);
  }
  
  public static void a(final b paramb, final String paramString1, final String paramString2, Intent paramIntent, final int paramInt, final a parama)
  {
    AppMethodBeat.i(133729);
    Log.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    paramb = new a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(133697);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
          {
            str = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
            if (!paramString2.startsWith(".")) {
              break label164;
            }
          }
        }
        label164:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(MMApplicationContext.getPackageName(), str);
          paramb.a(localIntent, paramInt, parama);
          c.g(paramb.getContext(), paramString2, this.val$intent);
          AppMethodBeat.o(133697);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    };
    new Object() {};
    a(paramString1, paramb);
    AppMethodBeat.o(133729);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, Intent paramIntent, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(133726);
    String str = MMApplicationContext.getSourcePackageName();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(MMApplicationContext.getPackageName(), str);
      paramMMActivity.mmStartActivityForResult(parama, paramIntent, paramInt);
      g(paramMMActivity, paramString, paramIntent);
      AppMethodBeat.o(133726);
      return;
    }
  }
  
  public static void a(MMFragmentActivity paramMMFragmentActivity, String paramString, Intent paramIntent, int paramInt, MMFragmentActivity.b paramb)
  {
    AppMethodBeat.i(133727);
    String str = MMApplicationContext.getSourcePackageName();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(MMApplicationContext.getPackageName(), str);
      paramMMFragmentActivity.mmStartActivityForResult(paramb, paramIntent, paramInt);
      g(paramMMFragmentActivity, paramString, paramIntent);
      AppMethodBeat.o(133727);
      return;
    }
  }
  
  public static void a(String paramString, m paramm, l paraml)
  {
    AppMethodBeat.i(133741);
    Log.d("MicroMsg.PluginHelper", "--> registerApplication: %s", new Object[] { paramString });
    Object localObject = bfU(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133741);
      return;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.d)localObject).createApplication();
    if (localObject == null)
    {
      Log.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133741);
      return;
    }
    ((n)localObject).a(paraml);
    ((n)localObject).a(paramm);
    Log.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", new Object[] { paramString, paramm, paraml });
    AppMethodBeat.o(133741);
  }
  
  public static boolean a(Intent paramIntent, ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(133737);
    boolean bool = com.tencent.mm.service.c.a(paramIntent, paramServiceConnection, 1, paramString, true, bfS(paramString));
    AppMethodBeat.o(133737);
    return bool;
  }
  
  /* Error */
  public static boolean aZU(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 559
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 75	com/tencent/mm/br/c:KxY	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 143	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: ifnull +16 -> 32
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc_w 559
    //   24: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc_w 559
    //   37: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -13 -> 27
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramString	String
    //   20	14	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	19	43	finally
    //   21	27	43	finally
    //   34	40	43	finally
  }
  
  public static com.tencent.mm.pluginsdk.b.a ak(Context paramContext, String paramString)
  {
    AppMethodBeat.i(133742);
    paramContext = W(paramContext, paramString, null);
    AppMethodBeat.o(133742);
    return paramContext;
  }
  
  public static boolean ayt()
  {
    AppMethodBeat.i(258664);
    boolean bool = ToolsProcessIPCService.ayt();
    AppMethodBeat.o(258664);
    return bool;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(133712);
    a(paramContext, paramString1, paramString2, paramIntent, null);
    AppMethodBeat.o(133712);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(133721);
    a(paramContext, paramString1, paramString2, paramIntent, paramInt, true);
    AppMethodBeat.o(133721);
  }
  
  private static void b(final Context paramContext, String paramString1, final String paramString2, final Intent paramIntent, final Bundle paramBundle)
  {
    AppMethodBeat.i(133715);
    Log.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    if (paramContext == null)
    {
      Log.e("MicroMsg.PluginHelper", "start activity error, context is null");
      AppMethodBeat.o(133715);
      return;
    }
    if ((paramIntent != null) && (!Util.isNullOrNil(paramIntent.getStringExtra("rawUrl")))) {
      paramIntent.putExtra("startTime", System.currentTimeMillis());
    }
    if ((".ui.tools.WebViewUI".equals(paramString2)) || ("com.tencent.mm.plugin.webview.ui.tools.WebViewUI".equals(paramString2)))
    {
      boolean bool1 = WXHardCoderJNI.hcBizEnable;
      int j = WXHardCoderJNI.hcBizDelay;
      int k = WXHardCoderJNI.hcBizCPU;
      int m = WXHardCoderJNI.hcBizIO;
      int i;
      if (WXHardCoderJNI.hcBizThr) {
        i = Process.myTid();
      }
      for (;;)
      {
        Log.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")) });
        try
        {
          String str2 = paramIntent.getStringExtra("rawUrl");
          String str1 = paramString2;
          Uri localUri;
          if (!Util.isNullOrNil(str2))
          {
            localUri = Uri.parse(str2);
            if (paramIntent.getLongExtra("start_activity_time", 0L) == 0L) {
              paramIntent.putExtra("start_activity_time", System.currentTimeMillis());
            }
            if ((localUri.getHost() != null) && (localUri.getHost().equals("mp.weixin.qq.com")) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext)))
            {
              Log.i("MicroMsg.PluginHelper", "Block mp url %s", new Object[] { str2 });
              AppMethodBeat.o(133715);
              return;
              i = 0;
              continue;
            }
            if ((localUri.getHost() != null) && (localUri.getHost().equals(WeChatHosts.domainString(2131761707))))
            {
              str1 = a(paramIntent, localUri);
              paramString2 = str1;
            }
          }
          for (;;)
          {
            paramContext = new a()
            {
              public final void onDone()
              {
                AppMethodBeat.i(133704);
                Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", new Object[] { this.KxV, paramString2 });
                try
                {
                  if (paramIntent == null)
                  {
                    localObject1 = new Intent();
                    localObject2 = MMApplicationContext.getSourcePackageName() + ".plugin." + this.KxV;
                    if (!paramString2.startsWith(".")) {
                      break label236;
                    }
                  }
                  label236:
                  for (Object localObject2 = (String)localObject2 + paramString2;; localObject2 = paramString2)
                  {
                    ((Intent)localObject1).setClassName(MMApplicationContext.getPackageName(), (String)localObject2);
                    Class.forName((String)localObject2, false, paramContext.getClassLoader());
                    if (!(paramContext instanceof Activity)) {
                      break label244;
                    }
                    localObject2 = paramContext;
                    localBundle = paramBundle;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localBundle).bl(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0), (Bundle)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(1));
                    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                    AppMethodBeat.o(133704);
                    return;
                    localObject1 = paramIntent;
                    break;
                  }
                  label244:
                  ((Intent)localObject1).addFlags(268435456);
                  localObject2 = paramContext;
                  Bundle localBundle = paramBundle;
                  Object localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localBundle).bl(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                  ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0), (Bundle)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(1));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                  AppMethodBeat.o(133704);
                  return;
                }
                catch (ClassNotFoundException localClassNotFoundException)
                {
                  Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[] { localClassNotFoundException });
                  AppMethodBeat.o(133704);
                }
              }
            };
            new Object() {};
            a(paramString1, paramContext);
            AppMethodBeat.o(133715);
            return;
            if ((localUri.getHost() != null) && (localUri.getHost().equals(WeChatHosts.domainString(2131761726))) && (!ToolsProcessIPCService.ayt()))
            {
              paramString2 = ".ui.tools.WebviewMpUI";
            }
            else if ((t.bsh(localUri.getHost())) && (!ToolsProcessIPCService.ayt()))
            {
              paramString2 = ".ui.tools.WebviewMpUI";
            }
            else
            {
              boolean bool2 = ao.isDarkMode();
              if (!"false".equalsIgnoreCase(com.tencent.xweb.b.nS("dark_to_toolsmp", "tools"))) {}
              for (bool1 = true;; bool1 = false)
              {
                Log.i("MicroMsg.PluginHelper", "other web, isDarkMode:%s, darkToToolsmp:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                str1 = paramString2;
                if (ao.isDarkMode())
                {
                  str1 = paramString2;
                  if (!"false".equalsIgnoreCase(com.tencent.xweb.b.nS("dark_to_toolsmp", "tools")))
                  {
                    str1 = paramString2;
                    if (!t.bsi(localUri.getHost())) {
                      str1 = ".ui.tools.WebviewMpUI";
                    }
                  }
                }
                paramString2 = str1;
                break;
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PluginHelper", "parse url failed :" + localException.getMessage());
        }
      }
    }
  }
  
  private static Intent bfS(String paramString)
  {
    AppMethodBeat.i(133739);
    Object localObject = null;
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramString = localObject;
      }
      break;
    }
    for (;;)
    {
      paramString = new Intent(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(133739);
      return paramString;
      if (!paramString.equals("mm")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("push")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("dexopt")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("tools")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("exdevice")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("support")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("toolsmp")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("sandbox")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("lite")) {
        break;
      }
      i = 8;
      break;
      paramString = ProcessService.MMProcessService.class;
      continue;
      paramString = ProcessService.PushProcessServicer.class;
      continue;
      paramString = ProcessService.DexOptProcessService.class;
      continue;
      paramString = ProcessService.ToolsProcessService.class;
      continue;
      paramString = ProcessService.ExDeviceProcessService.class;
      continue;
      paramString = ProcessService.SupportProcessService.class;
      continue;
      paramString = ProcessService.ToolsmpProcessService.class;
      continue;
      paramString = ProcessService.SandBoxProcessService.class;
      continue;
      paramString = ProcessService.LiteProcessService.class;
    }
  }
  
  public static bd bfT(String paramString)
  {
    AppMethodBeat.i(133740);
    Log.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", new Object[] { paramString });
    Object localObject = bfU(paramString);
    if (localObject == null)
    {
      Log.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133740);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.d)localObject).createSubCore();
    if (localObject == null)
    {
      Log.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133740);
      return null;
    }
    Log.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[] { paramString });
    AppMethodBeat.o(133740);
    return localObject;
  }
  
  /* Error */
  private static com.tencent.mm.pluginsdk.b.d bfU(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 665
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 151	com/tencent/mm/br/c:bfV	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/d;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: ldc_w 665
    //   19: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: astore_1
    //   28: ldc 98
    //   30: ldc_w 667
    //   33: iconst_2
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_1
    //   44: invokevirtual 157	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   47: aastore
    //   48: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aconst_null
    //   52: astore_0
    //   53: ldc_w 665
    //   56: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -37 -> 22
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: astore_1
    //   69: ldc 98
    //   71: ldc 167
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_1
    //   84: invokevirtual 168	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: goto -40 -> 51
    //   94: astore_1
    //   95: ldc 98
    //   97: ldc 170
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_1
    //   110: invokevirtual 171	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: goto -66 -> 51
    //   120: astore_1
    //   121: ldc 98
    //   123: ldc_w 669
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_1
    //   137: invokevirtual 670	java/lang/Exception:toString	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto -93 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   13	2	1	locald	com.tencent.mm.pluginsdk.b.d
    //   27	17	1	localClassNotFoundException	ClassNotFoundException
    //   68	16	1	localInstantiationException	java.lang.InstantiationException
    //   94	16	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   120	17	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	14	27	java/lang/ClassNotFoundException
    //   3	9	62	finally
    //   9	14	62	finally
    //   16	22	62	finally
    //   28	51	62	finally
    //   53	59	62	finally
    //   69	91	62	finally
    //   95	117	62	finally
    //   121	144	62	finally
    //   9	14	68	java/lang/InstantiationException
    //   9	14	94	java/lang/IllegalAccessException
    //   9	14	120	java/lang/Exception
  }
  
  private static com.tencent.mm.pluginsdk.b.d bfV(String paramString)
  {
    AppMethodBeat.i(133747);
    com.tencent.mm.pluginsdk.b.d locald = (com.tencent.mm.pluginsdk.b.d)KxY.get(paramString);
    if (locald != null)
    {
      AppMethodBeat.o(133747);
      return locald;
    }
    locald = (com.tencent.mm.pluginsdk.b.d)MMApplicationContext.getContext().getClassLoader().loadClass(MMApplicationContext.getSourcePackageName() + ".plugin." + paramString + ".Plugin").newInstance();
    KxY.put(paramString, locald);
    AppMethodBeat.o(133747);
    return locald;
  }
  
  /* Error */
  public static boolean bfW(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 694
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 96	com/tencent/mm/br/c:bfU	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/d;
    //   13: ifnull +16 -> 29
    //   16: iconst_1
    //   17: istore_1
    //   18: ldc_w 694
    //   21: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc_w 694
    //   34: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -13 -> 24
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramString	String
    //   17	14	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	40	finally
    //   18	24	40	finally
    //   31	37	40	finally
  }
  
  public static void bs(Intent paramIntent)
  {
    AppMethodBeat.i(133735);
    n(paramIntent, "mm");
    AppMethodBeat.o(133735);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(133725);
    Intent localIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      str = MMApplicationContext.getSourcePackageName();
      if (!paramString.startsWith(".")) {
        break label102;
      }
    }
    label102:
    for (String str = str + paramString;; str = paramString)
    {
      localIntent.setClassName(MMApplicationContext.getPackageName(), str);
      if (!(paramContext instanceof Activity)) {
        break label108;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      g(paramContext, paramString, paramIntent);
      AppMethodBeat.o(133725);
      return;
      localIntent = paramIntent;
      break;
    }
    label108:
    Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
    AppMethodBeat.o(133725);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(133719);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    String str = MMApplicationContext.getSourcePackageName();
    paramIntent = paramString;
    if (paramString.startsWith(".")) {
      paramIntent = str + paramString;
    }
    localIntent.setClassName(MMApplicationContext.getPackageName(), paramIntent);
    if ((paramContext instanceof Activity))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle).bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.pG(0), (Bundle)paramString.pG(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(133719);
      return;
    }
    localIntent.addFlags(268435456);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle).bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    paramContext.startActivity((Intent)paramString.pG(0), (Bundle)paramString.pG(1));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    AppMethodBeat.o(133719);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(133714);
    b(paramContext, paramString1, paramString2, paramIntent, null);
    AppMethodBeat.o(133714);
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133720);
    a(paramContext, paramString1, paramString2, null, paramInt, true);
    AppMethodBeat.o(133720);
  }
  
  public static void f(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(133718);
    c(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(133718);
  }
  
  public static void g(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(133724);
    if (paramIntent != null)
    {
      if (KxZ.contains(paramString)) {
        paramIntent.putExtra("animation_pop_in", true);
      }
      com.tencent.mm.ui.base.b.az(paramContext, paramIntent);
    }
    AppMethodBeat.o(133724);
  }
  
  public static void gsW()
  {
    AppMethodBeat.i(133730);
    com.tencent.mm.service.c.b("mm", true, bfS("mm"));
    AppMethodBeat.o(133730);
  }
  
  public static boolean gsX()
  {
    return false;
  }
  
  private static void l(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(133731);
    com.tencent.mm.service.c.a(paramIntent, paramString, true, bfS(paramString));
    AppMethodBeat.o(133731);
  }
  
  public static void m(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(258665);
    l(paramIntent, paramString);
    AppMethodBeat.o(258665);
  }
  
  public static Class<?> mI(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133748);
        str1 = (String)KxX.get(paramString1);
        if (str1 != null) {
          Log.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[] { paramString1, str1 });
        }
        if (bfW(paramString1)) {
          continue;
        }
        Log.e("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString1 });
        AppMethodBeat.o(133748);
        paramString1 = null;
      }
      finally
      {
        try
        {
          String str1;
          String str2;
          paramString2 = MMApplicationContext.getContext().getClassLoader().loadClass(str1);
          paramString1 = paramString2;
          AppMethodBeat.o(133748);
        }
        catch (Exception paramString2)
        {
          Log.e("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString1 });
          AppMethodBeat.o(133748);
          paramString1 = null;
        }
        paramString1 = finally;
      }
      return paramString1;
      str2 = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
      str1 = paramString2;
      if (paramString2.startsWith(".")) {
        str1 = str2 + paramString2;
      }
    }
  }
  
  private static void n(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(133734);
    com.tencent.mm.service.c.b(paramIntent, paramString, true, bfS(paramString));
    AppMethodBeat.o(133734);
  }
  
  public static void o(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(258666);
    n(paramIntent, paramString);
    AppMethodBeat.o(258666);
  }
  
  public static void startService(Intent paramIntent)
  {
    AppMethodBeat.i(133732);
    l(paramIntent, "mm");
    AppMethodBeat.o(133732);
  }
  
  public static abstract interface a
  {
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  public static abstract interface b
  {
    public abstract void a(Intent paramIntent, int paramInt, c.a parama);
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.br.c
 * JD-Core Version:    0.7.0.1
 */