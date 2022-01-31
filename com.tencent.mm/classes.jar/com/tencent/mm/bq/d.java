package com.tencent.mm.bq;

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
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.ProcessService.DexOptProcessService;
import com.tencent.mm.service.ProcessService.ExDeviceProcessService;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.service.ProcessService.PushProcessServicer;
import com.tencent.mm.service.ProcessService.SandBoxProcessService;
import com.tencent.mm.service.ProcessService.SupportProcessService;
import com.tencent.mm.service.ProcessService.ToolsProcessService;
import com.tencent.mm.service.ProcessService.ToolsmpProcessService;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d
{
  private static final Map<String, String> wgU;
  private static HashMap<String, com.tencent.mm.pluginsdk.b.c> wgV;
  private static final HashSet<String> wgW;
  
  static
  {
    AppMethodBeat.i(114738);
    HashMap localHashMap = new HashMap();
    wgU = localHashMap;
    localHashMap.put("location", "talkroom");
    wgU.put("talkroom", "voip");
    wgV = new HashMap();
    wgW = new d.13();
    AppMethodBeat.o(114738);
  }
  
  public static void H(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114700);
    c(paramContext, paramString1, paramString2, null);
    AppMethodBeat.o(114700);
  }
  
  public static com.tencent.mm.pluginsdk.b.a I(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114731);
    Object localObject = anf(paramString1);
    if (localObject == null)
    {
      ab.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(114731);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.c)localObject).getContactWidgetFactory();
    if (localObject == null)
    {
      ab.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(114731);
      return null;
    }
    paramContext = ((com.tencent.mm.pluginsdk.b.b)localObject).ab(paramContext, paramString2);
    AppMethodBeat.o(114731);
    return paramContext;
  }
  
  public static boolean Qa()
  {
    AppMethodBeat.i(156789);
    boolean bool = ToolsProcessIPCService.Qa();
    AppMethodBeat.o(156789);
    return bool;
  }
  
  public static com.tencent.mm.pluginsdk.b.c a(String paramString, a parama, b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114734);
        localObject = (String)wgU.get(paramString);
        if (localObject != null) {
          ab.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[] { paramString, localObject });
        }
        localObject = (com.tencent.mm.pluginsdk.b.c)wgV.get(paramString);
        if (localObject == null) {
          continue;
        }
        parama.onDone();
        AppMethodBeat.o(114734);
        paramString = (String)localObject;
      }
      finally
      {
        try
        {
          Object localObject = ang(paramString);
          if (localObject != null) {
            parama.onDone();
          }
          AppMethodBeat.o(114734);
          paramString = (String)localObject;
        }
        catch (Exception localException) {}
        paramString = finally;
      }
      return paramString;
      try
      {
        com.tencent.mm.pluginsdk.b.c localc = ang(paramString);
        if (localc != null) {
          parama.onDone();
        }
        AppMethodBeat.o(114734);
        paramString = localc;
      }
      catch (ClassNotFoundException parama)
      {
        ab.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", new Object[] { paramString, parama.toString() });
        ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString });
        paramb.c(new IllegalArgumentException("Load Plugin Faild"));
        paramString = null;
        AppMethodBeat.o(114734);
      }
      catch (InstantiationException parama)
      {
        for (;;)
        {
          ab.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", new Object[] { paramString, parama.toString() });
        }
      }
      catch (IllegalAccessException parama)
      {
        for (;;)
        {
          ab.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", new Object[] { paramString, parama.toString() });
        }
      }
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(114698);
    a(paramString1, new a()new b
    {
      public final void onDone()
      {
        AppMethodBeat.i(114685);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = ah.dsO() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label114;
          }
        }
        label114:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ah.getPackageName(), str);
          MMWizardActivity.J(paramContext, localIntent);
          AppMethodBeat.o(114685);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new b()
    {
      public final void c(Exception paramAnonymousException)
      {
        AppMethodBeat.i(114690);
        ab.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.wgS });
        ab.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramAnonymousException });
        AppMethodBeat.o(114690);
      }
    });
    AppMethodBeat.o(114698);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(114710);
    ab.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.valueOf(paramBoolean) });
    a(paramString1, new d.11(paramIntent, paramString1, paramString2, paramContext, paramInt), new d.12(paramString1));
    AppMethodBeat.o(114710);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(114699);
    a(paramString1, new d.7(paramIntent1, paramString1, paramString2, paramContext, paramIntent2), new b()
    {
      public final void c(Exception paramAnonymousException)
      {
        AppMethodBeat.i(114692);
        ab.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.wgS });
        ab.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramAnonymousException });
        AppMethodBeat.o(114692);
      }
    });
    AppMethodBeat.o(114699);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(114702);
    if (!com.tencent.mm.compatible.util.d.fw(21)) {}
    try
    {
      if ((paramContext.getSharedPreferences(ah.dsP(), 0).getBoolean("settings_multi_webview", false)) && (".ui.tools.WebViewUI".endsWith(paramString2)))
      {
        ab.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
        paramIntent.addFlags(134217728);
        paramIntent.addFlags(524288);
      }
      b(paramContext, paramString1, paramString2, paramIntent, paramBundle);
      AppMethodBeat.o(114702);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.PluginHelper", "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static void a(ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(114725);
    com.tencent.mm.service.c.a(paramServiceConnection, paramString, true, and(paramString));
    AppMethodBeat.o(114725);
  }
  
  public static void a(Fragment paramFragment, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(114715);
    String str = ah.dsO();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ah.getPackageName(), str);
      if (!(paramFragment instanceof Fragment)) {
        break;
      }
      paramFragment.startActivityForResult(paramIntent, paramInt);
      g(paramFragment.getActivity(), paramString, paramIntent);
      AppMethodBeat.o(114715);
      return;
    }
    ab.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    AppMethodBeat.o(114715);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(114711);
    ab.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    a(paramString1, new d.4(paramIntent, paramString1, paramString2, paramFragment, paramInt), new d.5(paramString1));
    AppMethodBeat.o(114711);
  }
  
  public static void a(d.b paramb, String paramString1, String paramString2, Intent paramIntent, int paramInt, a parama)
  {
    AppMethodBeat.i(114716);
    ab.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    a(paramString1, new d.2(paramIntent, paramString1, paramString2, paramb, paramInt, parama), new d.3(paramString1));
    AppMethodBeat.o(114716);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, Intent paramIntent, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(114714);
    Intent localIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      str = ah.dsO();
      if (!paramString.startsWith(".")) {
        break label93;
      }
    }
    label93:
    for (String str = str + paramString;; str = paramString)
    {
      localIntent.setClassName(ah.getPackageName(), str);
      paramMMActivity.mmStartActivityForResult(parama, paramIntent, paramInt);
      g(paramMMActivity, paramString, paramIntent);
      AppMethodBeat.o(114714);
      return;
      localIntent = paramIntent;
      break;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.pluginsdk.n paramn, m paramm)
  {
    AppMethodBeat.i(114729);
    ab.d("MicroMsg.PluginHelper", "--> registerApplication: %s", new Object[] { paramString });
    Object localObject = anf(paramString);
    if (localObject == null)
    {
      ab.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(114729);
      return;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.c)localObject).createApplication();
    if (localObject == null)
    {
      ab.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(114729);
      return;
    }
    ((o)localObject).a(paramm);
    ((o)localObject).a(paramn);
    ab.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", new Object[] { paramString, paramn, paramm });
    AppMethodBeat.o(114729);
  }
  
  public static boolean a(Intent paramIntent, ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(114724);
    boolean bool = com.tencent.mm.service.c.a(paramIntent, paramServiceConnection, 1, paramString, true, and(paramString));
    AppMethodBeat.o(114724);
    return bool;
  }
  
  public static void aG(Intent paramIntent)
  {
    AppMethodBeat.i(114719);
    i(paramIntent, "mm");
    AppMethodBeat.o(114719);
  }
  
  public static void aH(Intent paramIntent)
  {
    AppMethodBeat.i(114722);
    k(paramIntent, "mm");
    AppMethodBeat.o(114722);
  }
  
  public static com.tencent.mm.pluginsdk.b.a ab(Context paramContext, String paramString)
  {
    AppMethodBeat.i(114730);
    paramContext = I(paramContext, paramString, null);
    AppMethodBeat.o(114730);
    return paramContext;
  }
  
  /* Error */
  public static boolean ahR(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 387
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 54	com/tencent/mm/bq/d:wgV	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 130	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: ifnull +16 -> 32
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc_w 387
    //   24: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc_w 387
    //   37: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static Intent and(String paramString)
  {
    AppMethodBeat.i(114726);
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
      paramString = new Intent(ah.getContext(), paramString);
      AppMethodBeat.o(114726);
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
    }
  }
  
  public static at ane(String paramString)
  {
    AppMethodBeat.i(114728);
    ab.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", new Object[] { paramString });
    Object localObject = anf(paramString);
    if (localObject == null)
    {
      ab.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(114728);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.c)localObject).createSubCore();
    if (localObject == null)
    {
      ab.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(114728);
      return null;
    }
    ab.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[] { paramString });
    AppMethodBeat.o(114728);
    return localObject;
  }
  
  /* Error */
  private static com.tencent.mm.pluginsdk.b.c anf(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 449
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 138	com/tencent/mm/bq/d:ang	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/c;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: ldc_w 449
    //   19: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: astore_1
    //   28: ldc 79
    //   30: ldc_w 451
    //   33: iconst_2
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_1
    //   44: invokevirtual 144	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   47: aastore
    //   48: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aconst_null
    //   52: astore_0
    //   53: ldc_w 449
    //   56: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -37 -> 22
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: astore_1
    //   69: ldc 79
    //   71: ldc 160
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_1
    //   84: invokevirtual 161	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: goto -40 -> 51
    //   94: astore_1
    //   95: ldc 79
    //   97: ldc 163
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_1
    //   110: invokevirtual 164	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: goto -66 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString	String
    //   13	2	1	localc	com.tencent.mm.pluginsdk.b.c
    //   27	17	1	localClassNotFoundException	ClassNotFoundException
    //   68	16	1	localInstantiationException	InstantiationException
    //   94	16	1	localIllegalAccessException	IllegalAccessException
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
    //   9	14	68	java/lang/InstantiationException
    //   9	14	94	java/lang/IllegalAccessException
  }
  
  private static com.tencent.mm.pluginsdk.b.c ang(String paramString)
  {
    AppMethodBeat.i(114735);
    com.tencent.mm.pluginsdk.b.c localc = (com.tencent.mm.pluginsdk.b.c)wgV.get(paramString);
    if (localc != null)
    {
      AppMethodBeat.o(114735);
      return localc;
    }
    localc = (com.tencent.mm.pluginsdk.b.c)ah.getContext().getClassLoader().loadClass(ah.dsO() + ".plugin." + paramString + ".Plugin").newInstance();
    wgV.put(paramString, localc);
    AppMethodBeat.o(114735);
    return localc;
  }
  
  /* Error */
  private static boolean anh(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 475
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 77	com/tencent/mm/bq/d:anf	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/c;
    //   13: ifnull +16 -> 29
    //   16: iconst_1
    //   17: istore_1
    //   18: ldc_w 475
    //   21: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc_w 475
    //   34: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(114713);
    String str = ah.dsO();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ah.getPackageName(), str);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      g(paramContext, paramString, paramIntent);
      AppMethodBeat.o(114713);
      return;
    }
    ab.f("MicroMsg.PluginHelper", "context not activity, skipped");
    AppMethodBeat.o(114713);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(114701);
    a(paramContext, paramString1, paramString2, paramIntent, null);
    AppMethodBeat.o(114701);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(114709);
    a(paramContext, paramString1, paramString2, paramIntent, paramInt, true);
    AppMethodBeat.o(114709);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(114704);
    ab.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    if (paramContext == null)
    {
      ab.e("MicroMsg.PluginHelper", "start activity error, context is null");
      AppMethodBeat.o(114704);
      return;
    }
    if (".ui.tools.WebViewUI".equals(paramString2))
    {
      boolean bool = WXHardCoderJNI.hcBizEnable;
      int j = WXHardCoderJNI.hcBizDelay;
      int k = WXHardCoderJNI.hcBizCPU;
      int m = WXHardCoderJNI.hcBizIO;
      int i;
      if (WXHardCoderJNI.hcBizThr) {
        i = Process.myTid();
      }
      for (;;)
      {
        ab.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")) });
        try
        {
          Object localObject = paramIntent.getStringExtra("rawUrl");
          String str = paramString2;
          if (!bo.isNullOrNil((String)localObject))
          {
            localObject = Uri.parse((String)localObject);
            if (paramIntent.getLongExtra("start_activity_time", 0L) == 0L) {
              paramIntent.putExtra("start_activity_time", System.currentTimeMillis());
            }
            if ((((Uri)localObject).getHost() != null) && (((Uri)localObject).getHost().equals("game.weixin.qq.com"))) {
              if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRy, false)) {
                paramString2 = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
              }
            }
          }
          for (;;)
          {
            a(paramString1, new d.9(paramString1, paramString2, paramIntent, paramContext, paramBundle), new d.10(paramString1));
            AppMethodBeat.o(114704);
            return;
            i = 0;
            break;
            paramString2 = ".ui.tools.game.GameWebViewUI";
            continue;
            if ((((Uri)localObject).getHost() != null) && (((Uri)localObject).getHost().equals("mp.weixin.qq.com")) && (!ToolsProcessIPCService.Qa()))
            {
              paramString2 = ".ui.tools.WebviewMpUI";
            }
            else
            {
              str = paramString2;
              if (com.tencent.xweb.n.axU(((Uri)localObject).getHost()))
              {
                str = paramString2;
                if (!ToolsProcessIPCService.Qa()) {
                  str = ".ui.tools.WebviewMpUI";
                }
              }
              paramString2 = str;
            }
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.PluginHelper", "parse url failed :" + localException.getMessage());
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(114707);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    String str = ah.dsO();
    paramIntent = paramString;
    if (paramString.startsWith(".")) {
      paramIntent = str + paramString;
    }
    localIntent.setClassName(ah.getPackageName(), paramIntent);
    if ((paramContext instanceof Activity))
    {
      paramContext.startActivity(localIntent, paramBundle);
      AppMethodBeat.o(114707);
      return;
    }
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent, paramBundle);
    AppMethodBeat.o(114707);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114708);
    a(paramContext, paramString1, paramString2, null, paramInt, true);
    AppMethodBeat.o(114708);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(114703);
    b(paramContext, paramString1, paramString2, paramIntent, null);
    AppMethodBeat.o(114703);
  }
  
  public static void dpT()
  {
    AppMethodBeat.i(114717);
    com.tencent.mm.service.c.b("mm", true, and("mm"));
    AppMethodBeat.o(114717);
  }
  
  public static boolean dpU()
  {
    return false;
  }
  
  public static void f(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(114706);
    c(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(114706);
  }
  
  public static void g(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(114712);
    if ((paramIntent != null) && (wgW.contains(paramString)))
    {
      paramIntent.putExtra("animation_pop_in", true);
      com.tencent.mm.ui.base.b.K(paramContext, paramIntent);
    }
    AppMethodBeat.o(114712);
  }
  
  private static void i(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(114718);
    com.tencent.mm.service.c.a(paramIntent, paramString, true, and(paramString));
    AppMethodBeat.o(114718);
  }
  
  public static Class<?> ia(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114736);
        str1 = (String)wgU.get(paramString1);
        if (str1 != null) {
          ab.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[] { paramString1, str1 });
        }
        if (anh(paramString1)) {
          continue;
        }
        ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString1 });
        AppMethodBeat.o(114736);
        paramString1 = null;
      }
      finally
      {
        try
        {
          String str1;
          String str2;
          paramString2 = ah.getContext().getClassLoader().loadClass(str1);
          paramString1 = paramString2;
          AppMethodBeat.o(114736);
        }
        catch (Exception paramString2)
        {
          ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString1 });
          AppMethodBeat.o(114736);
          paramString1 = null;
        }
        paramString1 = finally;
      }
      return paramString1;
      str2 = ah.dsO() + ".plugin." + paramString1;
      str1 = paramString2;
      if (paramString2.startsWith(".")) {
        str1 = str2 + paramString2;
      }
    }
  }
  
  public static void j(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(156790);
    i(paramIntent, paramString);
    AppMethodBeat.o(156790);
  }
  
  private static void k(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(114721);
    com.tencent.mm.service.c.b(paramIntent, paramString, true, and(paramString));
    AppMethodBeat.o(114721);
  }
  
  public static void l(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(156791);
    k(paramIntent, paramString);
    AppMethodBeat.o(156791);
  }
  
  public static abstract interface a
  {
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bq.d
 * JD-Core Version:    0.7.0.1
 */