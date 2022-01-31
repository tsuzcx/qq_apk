package com.tencent.mm.br;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d
{
  private static final Map<String, String> soq;
  private static HashMap<String, c> sor = new HashMap();
  private static final HashSet<String> sos = new d.13();
  
  static
  {
    HashMap localHashMap = new HashMap();
    soq = localHashMap;
    localHashMap.put("location", "talkroom");
    soq.put("talkroom", "voip");
  }
  
  /* Error */
  public static boolean SP(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 52	com/tencent/mm/br/d:sor	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +10 -> 22
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 2
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -7 -> 17
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	paramString	String
    //   16	8	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	11	27	finally
  }
  
  public static void Xi(String paramString)
  {
    y.d("MicroMsg.PluginHelper", "-->createSubCore: %s", new Object[] { paramString });
    c localc = Xk(paramString);
    if (localc == null)
    {
      y.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[] { paramString });
      return;
    }
    if (localc.createSubCore() == null)
    {
      y.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[] { paramString });
      return;
    }
    y.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[] { paramString });
  }
  
  public static ar Xj(String paramString)
  {
    y.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", new Object[] { paramString });
    Object localObject = Xk(paramString);
    if (localObject == null)
    {
      y.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[] { paramString });
      return null;
    }
    localObject = ((c)localObject).createSubCore();
    if (localObject == null)
    {
      y.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[] { paramString });
      return null;
    }
    y.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[] { paramString });
    return localObject;
  }
  
  /* Error */
  private static c Xk(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 112	com/tencent/mm/br/d:Xl	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/c;
    //   7: astore_1
    //   8: aload_1
    //   9: astore_0
    //   10: ldc 2
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: astore_1
    //   16: ldc 68
    //   18: ldc 114
    //   20: iconst_2
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_1
    //   31: invokevirtual 118	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   34: aastore
    //   35: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: goto +58 -> 96
    //   41: astore_1
    //   42: ldc 68
    //   44: ldc 120
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_1
    //   57: invokevirtual 121	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto +32 -> 96
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    //   73: astore_1
    //   74: ldc 68
    //   76: ldc 123
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: invokevirtual 124	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aconst_null
    //   97: astore_0
    //   98: goto -88 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   7	2	1	localc	c
    //   15	16	1	localClassNotFoundException	ClassNotFoundException
    //   41	16	1	localInstantiationException	java.lang.InstantiationException
    //   73	16	1	localIllegalAccessException	java.lang.IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   3	8	15	java/lang/ClassNotFoundException
    //   3	8	41	java/lang/InstantiationException
    //   3	8	67	finally
    //   16	38	67	finally
    //   42	64	67	finally
    //   74	96	67	finally
    //   3	8	73	java/lang/IllegalAccessException
  }
  
  private static c Xl(String paramString)
  {
    c localc = (c)sor.get(paramString);
    if (localc != null) {
      return localc;
    }
    localc = (c)ae.getContext().getClassLoader().loadClass(ae.cqQ() + ".plugin." + paramString + ".Plugin").newInstance();
    sor.put(paramString, localc);
    return localc;
  }
  
  /* Error */
  public static boolean Xm(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 80	com/tencent/mm/br/d:Xk	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/c;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnull +10 -> 19
    //   12: iconst_1
    //   13: istore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_1
    //   21: goto -7 -> 14
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	paramString	String
    //   13	8	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	24	finally
  }
  
  public static com.tencent.mm.pluginsdk.b.a Y(Context paramContext, String paramString)
  {
    return y(paramContext, paramString, null);
  }
  
  /* Error */
  public static c a(String paramString, a parama, b paramb)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/tencent/mm/br/d:soq	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 176 2 0
    //   12: checkcast 178	java/lang/String
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +22 -> 39
    //   20: ldc 68
    //   22: ldc 180
    //   24: iconst_2
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_3
    //   35: aastore
    //   36: invokestatic 76	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: getstatic 52	com/tencent/mm/br/d:sor	Ljava/util/HashMap;
    //   42: aload_0
    //   43: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 87	com/tencent/mm/pluginsdk/b/c
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +14 -> 65
    //   54: aload_1
    //   55: invokeinterface 185 1 0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_3
    //   64: areturn
    //   65: aload_0
    //   66: invokestatic 112	com/tencent/mm/br/d:Xl	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/c;
    //   69: astore 4
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: ifnull -16 -> 60
    //   79: aload_1
    //   80: invokeinterface 185 1 0
    //   85: aload 4
    //   87: astore_3
    //   88: goto -28 -> 60
    //   91: astore_3
    //   92: aload_0
    //   93: invokestatic 112	com/tencent/mm/br/d:Xl	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/c;
    //   96: astore 4
    //   98: aload 4
    //   100: astore_3
    //   101: aload 4
    //   103: ifnull -43 -> 60
    //   106: aload_1
    //   107: invokeinterface 185 1 0
    //   112: aload 4
    //   114: astore_3
    //   115: goto -55 -> 60
    //   118: astore_1
    //   119: ldc 68
    //   121: ldc 187
    //   123: iconst_2
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload_1
    //   134: invokevirtual 118	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   137: aastore
    //   138: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: ldc 68
    //   143: ldc 189
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: aastore
    //   153: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_2
    //   157: new 191	java/lang/IllegalArgumentException
    //   160: dup
    //   161: ldc 193
    //   163: invokespecial 195	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   166: invokeinterface 200 2 0
    //   171: aconst_null
    //   172: astore_3
    //   173: goto -113 -> 60
    //   176: astore_1
    //   177: ldc 68
    //   179: ldc 120
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_1
    //   192: invokevirtual 121	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: goto -58 -> 141
    //   202: astore_0
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_0
    //   207: athrow
    //   208: astore_1
    //   209: ldc 68
    //   211: ldc 123
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_0
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_1
    //   224: invokevirtual 124	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   227: aastore
    //   228: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: goto -90 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramString	String
    //   0	234	1	parama	a
    //   0	234	2	paramb	b
    //   15	73	3	localObject1	Object
    //   91	1	3	localException	Exception
    //   100	73	3	localObject2	Object
    //   69	44	4	localc	c
    // Exception table:
    //   from	to	target	type
    //   65	71	91	java/lang/Exception
    //   79	85	91	java/lang/Exception
    //   92	98	118	java/lang/ClassNotFoundException
    //   106	112	118	java/lang/ClassNotFoundException
    //   92	98	176	java/lang/InstantiationException
    //   106	112	176	java/lang/InstantiationException
    //   3	16	202	finally
    //   20	39	202	finally
    //   39	50	202	finally
    //   54	60	202	finally
    //   65	71	202	finally
    //   79	85	202	finally
    //   92	98	202	finally
    //   106	112	202	finally
    //   119	141	202	finally
    //   141	171	202	finally
    //   177	199	202	finally
    //   209	231	202	finally
    //   92	98	208	java/lang/IllegalAccessException
    //   106	112	208	java/lang/IllegalAccessException
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent)
  {
    a(paramString1, new a()new d.6
    {
      public final void onDone()
      {
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = ae.cqQ() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label104;
          }
        }
        label104:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ae.getPackageName(), str);
          MMWizardActivity.C(paramContext, localIntent);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new d.6(paramString1));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    y.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.valueOf(paramBoolean) });
    a(paramString1, new d.11(paramIntent, paramString1, paramString2, paramContext, paramInt), new b()
    {
      public final void d(Exception paramAnonymousException)
      {
        y.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.soo });
        y.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramAnonymousException });
      }
    });
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent1, Intent paramIntent2)
  {
    a(paramString1, new d.7(paramIntent1, paramString1, paramString2, paramContext, paramIntent2), new b()
    {
      public final void d(Exception paramAnonymousException)
      {
        y.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.soo });
        y.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramAnonymousException });
      }
    });
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    if (!com.tencent.mm.compatible.util.d.gG(21)) {}
    try
    {
      if ((paramContext.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_multi_webview", false)) && (".ui.tools.WebViewUI".endsWith(paramString2)))
      {
        y.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
        paramIntent.addFlags(134217728);
        paramIntent.addFlags(524288);
      }
      b(paramContext, paramString1, paramString2, paramIntent, paramBundle);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.PluginHelper", "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static void a(Fragment paramFragment, String paramString, Intent paramIntent, int paramInt)
  {
    String str = ae.cqQ();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ae.getPackageName(), str);
      if (!(paramFragment instanceof Fragment)) {
        break;
      }
      paramFragment.startActivityForResult(paramIntent, paramInt);
      f(paramFragment.getActivity(), paramString, paramIntent);
      return;
    }
    y.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    y.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.valueOf(true) });
    a(paramString1, new d.4(paramIntent, paramString1, paramString2, paramFragment, paramInt), new d.5(paramString1));
  }
  
  public static void a(final d.b paramb, final String paramString1, final String paramString2, Intent paramIntent, final int paramInt, final d.a parama)
  {
    y.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.valueOf(true) });
    a(paramString1, new a()new d.3
    {
      public final void onDone()
      {
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = ae.cqQ() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label134;
          }
        }
        label134:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ae.getPackageName(), str);
          paramb.a(localIntent, paramInt, parama);
          d.f(paramb.getContext(), paramString2, this.val$intent);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new d.3(paramString1));
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, Intent paramIntent, int paramInt, MMActivity.a parama)
  {
    String str = ae.cqQ();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ae.getPackageName(), str);
      paramMMActivity.b(parama, paramIntent, paramInt);
      f(paramMMActivity, paramString, paramIntent);
      return;
    }
  }
  
  public static void a(String paramString, m paramm, l paraml)
  {
    y.d("MicroMsg.PluginHelper", "--> registerApplication: %s", new Object[] { paramString });
    Object localObject = Xk(paramString);
    if (localObject == null)
    {
      y.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      return;
    }
    localObject = ((c)localObject).createApplication();
    if (localObject == null)
    {
      y.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      return;
    }
    ((n)localObject).a(paraml);
    ((n)localObject).a(paramm);
    y.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", new Object[] { paramString, paramm, paraml });
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    a(paramContext, paramString1, paramString2, paramIntent, null);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramIntent, paramInt, true);
  }
  
  private static void b(final Context paramContext, String paramString1, final String paramString2, final Intent paramIntent, final Bundle paramBundle)
  {
    y.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", new Object[] { Boolean.valueOf(true) });
    if (paramContext == null)
    {
      y.e("MicroMsg.PluginHelper", "start activity error, context is null");
      return;
    }
    if (".ui.tools.WebViewUI".equals(paramString2)) {
      try
      {
        Object localObject = paramIntent.getStringExtra("rawUrl");
        String str = paramString2;
        if (!bk.bl((String)localObject))
        {
          localObject = Uri.parse((String)localObject);
          if ((((Uri)localObject).getHost() != null) && (((Uri)localObject).getHost().equals("game.weixin.qq.com")))
          {
            if (paramIntent.getLongExtra("start_activity_time", 0L) == 0L) {
              paramIntent.putExtra("start_activity_time", System.currentTimeMillis());
            }
            if (((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jIa, false)) {
              paramString2 = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
            }
          }
        }
        for (;;)
        {
          a(paramString1, new a()new b
          {
            public final void onDone()
            {
              y.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s", new Object[] { this.soo });
              try
              {
                Intent localIntent;
                if (paramIntent == null)
                {
                  localIntent = new Intent();
                  str = ae.cqQ() + ".plugin." + this.soo;
                  if (!paramString2.startsWith(".")) {
                    break label149;
                  }
                }
                label149:
                for (String str = str + paramString2;; str = paramString2)
                {
                  localIntent.setClassName(ae.getPackageName(), str);
                  Class.forName(str, false, paramContext.getClassLoader());
                  if (!(paramContext instanceof Activity)) {
                    break label157;
                  }
                  paramContext.startActivity(localIntent, paramBundle);
                  return;
                  localIntent = paramIntent;
                  break;
                }
                label157:
                localIntent.addFlags(268435456);
                paramContext.startActivity(localIntent, paramBundle);
                return;
              }
              catch (ClassNotFoundException localClassNotFoundException)
              {
                y.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[] { localClassNotFoundException });
              }
            }
          }, new b()
          {
            public final void d(Exception paramAnonymousException)
            {
              y.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.soo });
              y.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramAnonymousException });
            }
          });
          return;
          paramString2 = ".ui.tools.game.GameWebViewUI";
          continue;
          str = paramString2;
          if (((Uri)localObject).getHost() != null)
          {
            str = paramString2;
            if (((Uri)localObject).getHost().equals("mp.weixin.qq.com")) {
              str = ".ui.tools.WebviewMpUI";
            }
          }
          paramString2 = str;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.PluginHelper", "parse url failed :" + localException.getMessage());
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    String str = ae.cqQ();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ae.getPackageName(), str);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      f(paramContext, paramString, paramIntent);
      return;
    }
    y.f("MicroMsg.PluginHelper", "context not activity, skipped");
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    String str = ae.cqQ();
    paramIntent = paramString;
    if (paramString.startsWith(".")) {
      paramIntent = str + paramString;
    }
    localIntent.setClassName(ae.getPackageName(), paramIntent);
    if ((paramContext instanceof Activity))
    {
      paramContext.startActivity(localIntent, paramBundle);
      return;
    }
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent, paramBundle);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramString1, paramString2, null, paramInt, true);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    b(paramContext, paramString1, paramString2, paramIntent, null);
  }
  
  public static boolean coz()
  {
    return false;
  }
  
  public static void e(Context paramContext, String paramString, Intent paramIntent)
  {
    c(paramContext, paramString, paramIntent, null);
  }
  
  public static void f(Context paramContext, String paramString, Intent paramIntent)
  {
    if ((paramIntent != null) && (sos.contains(paramString)))
    {
      paramIntent.putExtra("animation_pop_in", true);
      com.tencent.mm.ui.base.b.D(paramContext, paramIntent);
    }
  }
  
  /* Error */
  public static Class<?> fZ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/tencent/mm/br/d:soq	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 176 2 0
    //   12: checkcast 178	java/lang/String
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +22 -> 39
    //   20: ldc 68
    //   22: ldc 180
    //   24: iconst_2
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_2
    //   35: aastore
    //   36: invokestatic 76	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: invokestatic 478	com/tencent/mm/br/d:Xm	(Ljava/lang/String;)Z
    //   43: ifne +25 -> 68
    //   46: ldc 68
    //   48: ldc 189
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aconst_null
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: areturn
    //   68: new 138	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   75: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:cqQ	()Ljava/lang/String;
    //   78: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 148
    //   83: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_1
    //   95: astore_2
    //   96: aload_1
    //   97: ldc_w 286
    //   100: invokevirtual 289	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   103: ifeq +22 -> 125
    //   106: new 138	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   113: aload_3
    //   114: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_2
    //   125: invokestatic 130	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   128: invokevirtual 136	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   131: aload_2
    //   132: invokevirtual 157	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   135: astore_1
    //   136: aload_1
    //   137: astore_0
    //   138: goto -75 -> 63
    //   141: astore_1
    //   142: ldc 68
    //   144: ldc 189
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: aastore
    //   154: invokestatic 85	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -96 -> 63
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString1	String
    //   0	168	1	paramString2	String
    //   15	117	2	str1	String
    //   93	21	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   125	136	141	java/lang/Exception
    //   3	16	162	finally
    //   20	39	162	finally
    //   39	61	162	finally
    //   68	94	162	finally
    //   96	125	162	finally
    //   125	136	162	finally
    //   142	157	162	finally
  }
  
  public static void x(Context paramContext, String paramString1, String paramString2)
  {
    c(paramContext, paramString1, paramString2, null);
  }
  
  public static com.tencent.mm.pluginsdk.b.a y(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = Xk(paramString1);
    if (localObject == null)
    {
      y.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      return null;
    }
    localObject = ((c)localObject).getContactWidgetFactory();
    if (localObject == null)
    {
      y.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      return null;
    }
    return ((com.tencent.mm.pluginsdk.b.b)localObject).Y(paramContext, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.br.d
 * JD-Core Version:    0.7.0.1
 */