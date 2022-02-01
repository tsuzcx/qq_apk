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
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
import com.tencent.mm.ui.aj;
import com.tencent.xweb.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d
{
  private static final Map<String, String> DHn;
  private static HashMap<String, com.tencent.mm.pluginsdk.b.d> DHo;
  private static final HashSet<String> DHp;
  
  static
  {
    AppMethodBeat.i(133750);
    HashMap localHashMap = new HashMap();
    DHn = localHashMap;
    localHashMap.put("location", "talkroom");
    DHn.put("talkroom", "voip");
    DHo = new HashMap();
    DHp = new HashSet() {};
    AppMethodBeat.o(133750);
  }
  
  public static void N(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(133711);
    c(paramContext, paramString1, paramString2, null);
    AppMethodBeat.o(133711);
  }
  
  public static com.tencent.mm.pluginsdk.b.a O(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(133743);
    Object localObject = aIr(paramString1);
    if (localObject == null)
    {
      ac.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(133743);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.d)localObject).getContactWidgetFactory();
    if (localObject == null)
    {
      ac.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(133743);
      return null;
    }
    paramContext = ((com.tencent.mm.pluginsdk.b.c)localObject).ab(paramContext, paramString2);
    AppMethodBeat.o(133743);
    return paramContext;
  }
  
  public static com.tencent.mm.pluginsdk.b.d a(String paramString, a parama, b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133746);
        localObject = (String)DHn.get(paramString);
        if (localObject != null) {
          ac.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[] { paramString, localObject });
        }
        localObject = (com.tencent.mm.pluginsdk.b.d)DHo.get(paramString);
        if (localObject == null) {
          continue;
        }
        parama.onDone();
        AppMethodBeat.o(133746);
        paramString = (String)localObject;
      }
      finally
      {
        try
        {
          Object localObject = aIs(paramString);
          if (localObject != null) {
            parama.onDone();
          }
          AppMethodBeat.o(133746);
          paramString = (String)localObject;
        }
        catch (Exception localException) {}
        paramString = finally;
      }
      return paramString;
      try
      {
        com.tencent.mm.pluginsdk.b.d locald = aIs(paramString);
        if (locald != null) {
          parama.onDone();
        }
        AppMethodBeat.o(133746);
        paramString = locald;
      }
      catch (ClassNotFoundException parama)
      {
        ac.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", new Object[] { paramString, parama.toString() });
        ac.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString });
        paramb.j(new IllegalArgumentException("Load Plugin Faild"));
        paramString = null;
        AppMethodBeat.o(133746);
      }
      catch (InstantiationException parama)
      {
        for (;;)
        {
          ac.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", new Object[] { paramString, parama.toString() });
        }
      }
      catch (IllegalAccessException parama)
      {
        for (;;)
        {
          ac.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", new Object[] { paramString, parama.toString() });
        }
      }
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(133709);
    a(paramString1, new a()new b
    {
      public final void onDone()
      {
        AppMethodBeat.i(133696);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = ai.eUW() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label114;
          }
        }
        label114:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ai.getPackageName(), str);
          MMWizardActivity.aj(paramContext, localIntent);
          AppMethodBeat.o(133696);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new b()
    {
      public final void j(Exception paramAnonymousException)
      {
        AppMethodBeat.i(133701);
        ac.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.DHl });
        ac.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramAnonymousException });
        AppMethodBeat.o(133701);
      }
    });
    AppMethodBeat.o(133709);
  }
  
  public static void a(final Context paramContext, final String paramString1, String paramString2, Intent paramIntent, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133722);
    ac.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramContext == null)
    {
      ac.e("MicroMsg.PluginHelper", "start activity error, context is null");
      AppMethodBeat.o(133722);
      return;
    }
    int i;
    if (".ui.tools.WebViewUI".equals(paramString2))
    {
      paramBoolean = WXHardCoderJNI.hcBizEnable;
      int j = WXHardCoderJNI.hcBizDelay;
      int k = WXHardCoderJNI.hcBizCPU;
      int m = WXHardCoderJNI.hcBizIO;
      if (WXHardCoderJNI.hcBizThr)
      {
        i = Process.myTid();
        ac.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")) });
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = paramIntent.getStringExtra("rawUrl");
        final String str1 = paramString2;
        if (!bs.isNullOrNil((String)localObject))
        {
          localObject = Uri.parse((String)localObject);
          if (paramIntent.getLongExtra("start_activity_time", 0L) == 0L) {
            paramIntent.putExtra("start_activity_time", System.currentTimeMillis());
          }
          str1 = paramString2;
          if (((Uri)localObject).getHost() != null)
          {
            str1 = paramString2;
            if (((Uri)localObject).getHost().equals("game.weixin.qq.com")) {
              str1 = x((Uri)localObject);
            }
          }
        }
        a(paramString1, new a()new b
        {
          public final void onDone()
          {
            AppMethodBeat.i(133706);
            Intent localIntent;
            if (this.val$intent == null)
            {
              localIntent = new Intent();
              str = ai.eUW() + ".plugin." + paramString1;
              if (!str1.startsWith(".")) {
                break label143;
              }
            }
            label143:
            for (String str = str + str1;; str = str1)
            {
              localIntent.setClassName(ai.getPackageName(), str);
              if (!(paramContext instanceof Activity)) {
                break label151;
              }
              ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
              d.f(paramContext, str1, localIntent);
              AppMethodBeat.o(133706);
              return;
              localIntent = this.val$intent;
              break;
            }
            label151:
            ac.f("MicroMsg.PluginHelper", "context not activity, skipped");
            AppMethodBeat.o(133706);
          }
        }, new b()
        {
          public final void j(Exception paramAnonymousException)
          {
            AppMethodBeat.i(133707);
            ac.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.DHl });
            ac.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramAnonymousException });
            AppMethodBeat.o(133707);
          }
        });
        AppMethodBeat.o(133722);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.PluginHelper", "parse url failed :" + localException.getMessage());
      }
      i = 0;
      break;
      String str2 = paramString2;
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, Intent paramIntent1, final Intent paramIntent2)
  {
    AppMethodBeat.i(133710);
    a(paramString1, new a()new b
    {
      public final void onDone()
      {
        AppMethodBeat.i(133702);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = ai.eUW() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label118;
          }
        }
        label118:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ai.getPackageName(), str);
          MMWizardActivity.b(paramContext, localIntent, paramIntent2);
          AppMethodBeat.o(133702);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new b()
    {
      public final void j(Exception paramAnonymousException)
      {
        AppMethodBeat.i(133703);
        ac.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.DHl });
        ac.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramAnonymousException });
        AppMethodBeat.o(133703);
      }
    });
    AppMethodBeat.o(133710);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(133713);
    if (!com.tencent.mm.compatible.util.d.la(21)) {}
    try
    {
      if ((paramContext.getSharedPreferences(ai.eUX(), 0).getBoolean("settings_multi_webview", false)) && (".ui.tools.WebViewUI".endsWith(paramString2)))
      {
        ac.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
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
        ac.e("MicroMsg.PluginHelper", "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static void a(ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(133738);
    com.tencent.mm.service.c.a(paramServiceConnection, paramString, true, aIp(paramString));
    AppMethodBeat.o(133738);
  }
  
  public static void a(Fragment paramFragment, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(133728);
    String str = ai.eUW();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ai.getPackageName(), str);
      if (!(paramFragment instanceof Fragment)) {
        break;
      }
      paramFragment.startActivityForResult(paramIntent, paramInt);
      f(paramFragment.getActivity(), paramString, paramIntent);
      AppMethodBeat.o(133728);
      return;
    }
    ac.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    AppMethodBeat.o(133728);
  }
  
  public static void a(final Fragment paramFragment, final String paramString1, final String paramString2, Intent paramIntent, final int paramInt)
  {
    AppMethodBeat.i(133723);
    ac.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    a(paramString1, new a()new b
    {
      public final void onDone()
      {
        AppMethodBeat.i(133699);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          str = ai.eUW() + ".plugin." + paramString1;
          if (!paramString2.startsWith(".")) {
            break label136;
          }
        }
        label136:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ai.getPackageName(), str);
          paramFragment.startActivityForResult(localIntent, paramInt);
          d.f(paramFragment.getActivity(), paramString2, this.val$intent);
          AppMethodBeat.o(133699);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new b()
    {
      public final void j(Exception paramAnonymousException)
      {
        AppMethodBeat.i(133700);
        ac.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.DHl });
        ac.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramAnonymousException });
        AppMethodBeat.o(133700);
      }
    });
    AppMethodBeat.o(133723);
  }
  
  public static void a(final b paramb, final String paramString1, final String paramString2, Intent paramIntent, final int paramInt, final d.a parama)
  {
    AppMethodBeat.i(133729);
    ac.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    a(paramString1, new a()new b
    {
      public final void onDone()
      {
        AppMethodBeat.i(133697);
        Intent localIntent;
        if (this.val$intent == null)
        {
          localIntent = new Intent();
          if ((!bs.isNullOrNil(paramString2)) && (!bs.isNullOrNil(paramString1)))
          {
            str = ai.eUW() + ".plugin." + paramString1;
            if (!paramString2.startsWith(".")) {
              break label164;
            }
          }
        }
        label164:
        for (String str = str + paramString2;; str = paramString2)
        {
          localIntent.setClassName(ai.getPackageName(), str);
          paramb.a(localIntent, paramInt, parama);
          d.f(paramb.getContext(), paramString2, this.val$intent);
          AppMethodBeat.o(133697);
          return;
          localIntent = this.val$intent;
          break;
        }
      }
    }, new b()
    {
      public final void j(Exception paramAnonymousException)
      {
        AppMethodBeat.i(133698);
        ac.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.DHl });
        ac.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramAnonymousException });
        AppMethodBeat.o(133698);
      }
    });
    AppMethodBeat.o(133729);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, Intent paramIntent, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(133726);
    String str = ai.eUW();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ai.getPackageName(), str);
      paramMMActivity.mmStartActivityForResult(parama, paramIntent, paramInt);
      f(paramMMActivity, paramString, paramIntent);
      AppMethodBeat.o(133726);
      return;
    }
  }
  
  public static void a(MMFragmentActivity paramMMFragmentActivity, String paramString, Intent paramIntent, int paramInt, MMFragmentActivity.b paramb)
  {
    AppMethodBeat.i(133727);
    String str = ai.eUW();
    if (paramString.startsWith(".")) {}
    for (str = str + paramString;; str = paramString)
    {
      paramIntent.setClassName(ai.getPackageName(), str);
      paramMMFragmentActivity.mmStartActivityForResult(paramb, paramIntent, paramInt);
      f(paramMMFragmentActivity, paramString, paramIntent);
      AppMethodBeat.o(133727);
      return;
    }
  }
  
  public static void a(String paramString, l paraml, k paramk)
  {
    AppMethodBeat.i(133741);
    ac.d("MicroMsg.PluginHelper", "--> registerApplication: %s", new Object[] { paramString });
    Object localObject = aIr(paramString);
    if (localObject == null)
    {
      ac.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133741);
      return;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.d)localObject).createApplication();
    if (localObject == null)
    {
      ac.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133741);
      return;
    }
    ((m)localObject).a(paramk);
    ((m)localObject).a(paraml);
    ac.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", new Object[] { paramString, paraml, paramk });
    AppMethodBeat.o(133741);
  }
  
  public static boolean a(Intent paramIntent, ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(133737);
    boolean bool = com.tencent.mm.service.c.a(paramIntent, paramServiceConnection, 1, paramString, true, aIp(paramString));
    AppMethodBeat.o(133737);
    return bool;
  }
  
  /* Error */
  public static boolean aCT(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 472
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 74	com/tencent/mm/br/d:DHo	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 142	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: ifnull +16 -> 32
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc_w 472
    //   24: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc_w 472
    //   37: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static Intent aIp(String paramString)
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
      paramString = new Intent(ai.getContext(), paramString);
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
  
  public static aw aIq(String paramString)
  {
    AppMethodBeat.i(133740);
    ac.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", new Object[] { paramString });
    Object localObject = aIr(paramString);
    if (localObject == null)
    {
      ac.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133740);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.b.d)localObject).createSubCore();
    if (localObject == null)
    {
      ac.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", new Object[] { paramString });
      AppMethodBeat.o(133740);
      return null;
    }
    ac.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", new Object[] { paramString });
    AppMethodBeat.o(133740);
    return localObject;
  }
  
  /* Error */
  private static com.tencent.mm.pluginsdk.b.d aIr(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 535
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 150	com/tencent/mm/br/d:aIs	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/d;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: ldc_w 535
    //   19: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: astore_1
    //   28: ldc 97
    //   30: ldc_w 537
    //   33: iconst_2
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_1
    //   44: invokevirtual 156	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   47: aastore
    //   48: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aconst_null
    //   52: astore_0
    //   53: ldc_w 535
    //   56: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -37 -> 22
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: astore_1
    //   69: ldc 97
    //   71: ldc 173
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_1
    //   84: invokevirtual 174	java/lang/InstantiationException:toString	()Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: goto -40 -> 51
    //   94: astore_1
    //   95: ldc 97
    //   97: ldc 176
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_1
    //   110: invokevirtual 177	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: goto -66 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString	String
    //   13	2	1	locald	com.tencent.mm.pluginsdk.b.d
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
  
  private static com.tencent.mm.pluginsdk.b.d aIs(String paramString)
  {
    AppMethodBeat.i(133747);
    com.tencent.mm.pluginsdk.b.d locald = (com.tencent.mm.pluginsdk.b.d)DHo.get(paramString);
    if (locald != null)
    {
      AppMethodBeat.o(133747);
      return locald;
    }
    locald = (com.tencent.mm.pluginsdk.b.d)ai.getContext().getClassLoader().loadClass(ai.eUW() + ".plugin." + paramString + ".Plugin").newInstance();
    DHo.put(paramString, locald);
    AppMethodBeat.o(133747);
    return locald;
  }
  
  /* Error */
  public static boolean aIt(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 561
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 95	com/tencent/mm/br/d:aIr	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/b/d;
    //   13: ifnull +16 -> 29
    //   16: iconst_1
    //   17: istore_1
    //   18: ldc_w 561
    //   21: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc_w 561
    //   34: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void aZ(Intent paramIntent)
  {
    AppMethodBeat.i(133732);
    k(paramIntent, "mm");
    AppMethodBeat.o(133732);
  }
  
  public static com.tencent.mm.pluginsdk.b.a ab(Context paramContext, String paramString)
  {
    AppMethodBeat.i(133742);
    paramContext = O(paramContext, paramString, null);
    AppMethodBeat.o(133742);
    return paramContext;
  }
  
  public static boolean afc()
  {
    AppMethodBeat.i(210363);
    boolean bool = ToolsProcessIPCService.afc();
    AppMethodBeat.o(210363);
    return bool;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133720);
    a(paramContext, paramString1, paramString2, null, paramInt, true);
    AppMethodBeat.o(133720);
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
    ac.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", new Object[] { Boolean.TRUE });
    if (paramContext == null)
    {
      ac.e("MicroMsg.PluginHelper", "start activity error, context is null");
      AppMethodBeat.o(133715);
      return;
    }
    if ((paramIntent != null) && (!bs.isNullOrNil(paramIntent.getStringExtra("rawUrl")))) {
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
        ac.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")) });
        try
        {
          Object localObject = paramIntent.getStringExtra("rawUrl");
          String str = paramString2;
          if (!bs.isNullOrNil((String)localObject))
          {
            localObject = Uri.parse((String)localObject);
            if (paramIntent.getLongExtra("start_activity_time", 0L) == 0L) {
              paramIntent.putExtra("start_activity_time", System.currentTimeMillis());
            }
            if ((((Uri)localObject).getHost() != null) && (((Uri)localObject).getHost().equals("game.weixin.qq.com")))
            {
              str = x((Uri)localObject);
              paramString2 = str;
            }
          }
          for (;;)
          {
            a(paramString1, new a()new b
            {
              public final void onDone()
              {
                AppMethodBeat.i(133704);
                ac.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", new Object[] { this.DHl, paramString2 });
                try
                {
                  if (paramIntent == null)
                  {
                    localObject1 = new Intent();
                    localObject2 = ai.eUW() + ".plugin." + this.DHl;
                    if (!paramString2.startsWith(".")) {
                      break label236;
                    }
                  }
                  label236:
                  for (Object localObject2 = (String)localObject2 + paramString2;; localObject2 = paramString2)
                  {
                    ((Intent)localObject1).setClassName(ai.getPackageName(), (String)localObject2);
                    Class.forName((String)localObject2, false, paramContext.getClassLoader());
                    if (!(paramContext instanceof Activity)) {
                      break label244;
                    }
                    localObject2 = paramContext;
                    localBundle = paramBundle;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localBundle).ba(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0), (Bundle)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(1));
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
                  Object localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localBundle).ba(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                  ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0), (Bundle)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(1));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                  AppMethodBeat.o(133704);
                  return;
                }
                catch (ClassNotFoundException localClassNotFoundException)
                {
                  ac.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[] { localClassNotFoundException });
                  AppMethodBeat.o(133704);
                }
              }
            }, new b()
            {
              public final void j(Exception paramAnonymousException)
              {
                AppMethodBeat.i(133705);
                ac.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.DHl });
                ac.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramAnonymousException });
                AppMethodBeat.o(133705);
              }
            });
            AppMethodBeat.o(133715);
            return;
            i = 0;
            break;
            if ((((Uri)localObject).getHost() != null) && (((Uri)localObject).getHost().equals("mp.weixin.qq.com")) && (!ToolsProcessIPCService.afc()))
            {
              paramString2 = ".ui.tools.WebviewMpUI";
            }
            else if ((t.aUS(((Uri)localObject).getHost())) && (!ToolsProcessIPCService.afc()))
            {
              paramString2 = ".ui.tools.WebviewMpUI";
            }
            else
            {
              boolean bool2 = aj.DT();
              if (!"false".equalsIgnoreCase(com.tencent.xweb.b.mx("dark_to_toolsmp", "tools"))) {}
              for (bool1 = true;; bool1 = false)
              {
                ac.i("MicroMsg.PluginHelper", "other web, isDarkMode:%s, darkToToolsmp:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                str = paramString2;
                if (aj.DT())
                {
                  str = paramString2;
                  if (!"false".equalsIgnoreCase(com.tencent.xweb.b.mx("dark_to_toolsmp", "tools")))
                  {
                    str = paramString2;
                    if (!t.aUT(((Uri)localObject).getHost())) {
                      str = ".ui.tools.WebviewMpUI";
                    }
                  }
                }
                paramString2 = str;
                break;
              }
            }
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.PluginHelper", "parse url failed :" + localException.getMessage());
        }
      }
    }
  }
  
  public static void ba(Intent paramIntent)
  {
    AppMethodBeat.i(133735);
    m(paramIntent, "mm");
    AppMethodBeat.o(133735);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(133725);
    Intent localIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      str = ai.eUW();
      if (!paramString.startsWith(".")) {
        break label102;
      }
    }
    label102:
    for (String str = str + paramString;; str = paramString)
    {
      localIntent.setClassName(ai.getPackageName(), str);
      if (!(paramContext instanceof Activity)) {
        break label108;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      f(paramContext, paramString, paramIntent);
      AppMethodBeat.o(133725);
      return;
      localIntent = paramIntent;
      break;
    }
    label108:
    ac.f("MicroMsg.PluginHelper", "context not activity, skipped");
    AppMethodBeat.o(133725);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(133719);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    String str = ai.eUW();
    paramIntent = paramString;
    if (paramString.startsWith(".")) {
      paramIntent = str + paramString;
    }
    localIntent.setClassName(ai.getPackageName(), paramIntent);
    if ((paramContext instanceof Activity))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle).ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.lR(0), (Bundle)paramString.lR(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(133719);
      return;
    }
    localIntent.addFlags(268435456);
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle).ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    paramContext.startActivity((Intent)paramString.lR(0), (Bundle)paramString.lR(1));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
    AppMethodBeat.o(133719);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(133714);
    b(paramContext, paramString1, paramString2, paramIntent, null);
    AppMethodBeat.o(133714);
  }
  
  public static void e(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(133718);
    c(paramContext, paramString, paramIntent, null);
    AppMethodBeat.o(133718);
  }
  
  public static void eQC()
  {
    AppMethodBeat.i(133730);
    com.tencent.mm.service.c.b("mm", true, aIp("mm"));
    AppMethodBeat.o(133730);
  }
  
  public static boolean eQD()
  {
    return false;
  }
  
  public static void f(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(133724);
    if (paramIntent != null)
    {
      if (DHp.contains(paramString)) {
        paramIntent.putExtra("animation_pop_in", true);
      }
      com.tencent.mm.ui.base.b.ak(paramContext, paramIntent);
    }
    AppMethodBeat.o(133724);
  }
  
  private static void k(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(133731);
    com.tencent.mm.service.c.a(paramIntent, paramString, true, aIp(paramString));
    AppMethodBeat.o(133731);
  }
  
  public static void l(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(210364);
    k(paramIntent, paramString);
    AppMethodBeat.o(210364);
  }
  
  public static Class<?> le(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133748);
        str1 = (String)DHn.get(paramString1);
        if (str1 != null) {
          ac.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", new Object[] { paramString1, str1 });
        }
        if (aIt(paramString1)) {
          continue;
        }
        ac.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString1 });
        AppMethodBeat.o(133748);
        paramString1 = null;
      }
      finally
      {
        try
        {
          String str1;
          String str2;
          paramString2 = ai.getContext().getClassLoader().loadClass(str1);
          paramString1 = paramString2;
          AppMethodBeat.o(133748);
        }
        catch (Exception paramString2)
        {
          ac.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", new Object[] { paramString1 });
          AppMethodBeat.o(133748);
          paramString1 = null;
        }
        paramString1 = finally;
      }
      return paramString1;
      str2 = ai.eUW() + ".plugin." + paramString1;
      str1 = paramString2;
      if (paramString2.startsWith(".")) {
        str1 = str2 + paramString2;
      }
    }
  }
  
  private static void m(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(133734);
    com.tencent.mm.service.c.b(paramIntent, paramString, true, aIp(paramString));
    AppMethodBeat.o(133734);
  }
  
  public static void n(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(210365);
    m(paramIntent, paramString);
    AppMethodBeat.o(210365);
  }
  
  private static String x(Uri paramUri)
  {
    AppMethodBeat.i(133716);
    if ((!bs.nullAsNil(paramUri.getQueryParameter("not_in_game_luggage")).equals("1")) && (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pLY, true))) {
      if ((t.aUS(paramUri.getHost())) && (!ToolsProcessIPCService.afc())) {
        paramUri = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewMpUI";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133716);
      return paramUri;
      paramUri = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
      continue;
      if ((t.aUS(paramUri.getHost())) && (!ToolsProcessIPCService.afc())) {
        paramUri = ".ui.tools.game.GameWebViewMpUI";
      } else {
        paramUri = ".ui.tools.game.GameWebViewUI";
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Intent paramIntent, int paramInt, d.a parama);
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.br.d
 * JD-Core Version:    0.7.0.1
 */