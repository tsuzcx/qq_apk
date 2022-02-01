package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ActivityController
{
  public static final String TAG = "MicroMsg.ActivityController";
  private static boolean activityCreating;
  private static WeakReference<Activity> currentActivity;
  private static HashMap<Integer, BaseFragment> fragmentPond;
  private static List<Integer> pendingList;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(19311);
    fragmentPond = new HashMap();
    activityCreating = false;
    pendingList = new ArrayList();
    AppMethodBeat.o(19311);
  }
  
  public static void attach(Activity paramActivity)
  {
    AppMethodBeat.i(19305);
    Log.i("MicroMsg.ActivityController", "attach %s", new Object[] { paramActivity });
    try
    {
      currentActivity = new WeakReference(paramActivity);
      if (pendingList.size() > 0)
      {
        IEventFragment localIEventFragment = (IEventFragment)paramActivity;
        if (paramActivity.isFinishing()) {
          return;
        }
        paramActivity = pendingList.iterator();
        while (paramActivity.hasNext())
        {
          Object localObject = (Integer)paramActivity.next();
          localObject = (BaseFragment)fragmentPond.get(localObject);
          if (localObject != null) {
            localIEventFragment.addFragment((BaseFragment)localObject);
          }
        }
        pendingList.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(19305);
    }
    activityCreating = false;
    Log.i("MicroMsg.ActivityController", "activityCreating has set false.");
    AppMethodBeat.o(19305);
  }
  
  public static void detach(Activity paramActivity)
  {
    AppMethodBeat.i(214570);
    Log.i("MicroMsg.ActivityController", "detach %s", new Object[] { paramActivity });
    try
    {
      if ((currentActivity != null) && (paramActivity == currentActivity.get())) {
        currentActivity = null;
      }
      pendingList.clear();
      activityCreating = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(214570);
    }
  }
  
  private static boolean isTopKindaActivity()
  {
    AppMethodBeat.i(178778);
    if ((currentActivity != null) && ((currentActivity.get() instanceof UIPageFragmentActivity)) && (((Activity)currentActivity.get()).equals(KindaContext.get())))
    {
      AppMethodBeat.o(178778);
      return true;
    }
    AppMethodBeat.o(178778);
    return false;
  }
  
  /* Error */
  public static void remove(com.tencent.kinda.gen.IUIModal paramIUIModal)
  {
    // Byte code:
    //   0: sipush 19309
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   12: ifnonnull +20 -> 32
    //   15: ldc 8
    //   17: ldc 134
    //   19: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: sipush 19309
    //   28: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 74	android/app/Activity
    //   41: astore_1
    //   42: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   45: aload_0
    //   46: invokevirtual 140	java/lang/Object:hashCode	()I
    //   49: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: invokevirtual 146	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 99	com/tencent/kinda/framework/widget/base/BaseFragment
    //   58: astore_0
    //   59: aload_1
    //   60: instanceof 72
    //   63: ifeq +28 -> 91
    //   66: aload_0
    //   67: ifnull +24 -> 91
    //   70: aload_1
    //   71: checkcast 72	com/tencent/kinda/framework/widget/base/IEventFragment
    //   74: aload_0
    //   75: invokeinterface 149 2 0
    //   80: pop
    //   81: ldc 2
    //   83: monitorexit
    //   84: sipush 19309
    //   87: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: aload_0
    //   92: ifnonnull +14 -> 106
    //   95: getstatic 155	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   98: sipush 965
    //   101: bipush 53
    //   103: invokevirtual 159	com/tencent/mm/plugin/report/service/h:dN	(II)V
    //   106: ldc 8
    //   108: new 161	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 163
    //   114: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: ldc 172
    //   123: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -55 -> 81
    //   139: astore_0
    //   140: ldc 2
    //   142: monitorexit
    //   143: sipush 19309
    //   146: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_0
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramIUIModal	com.tencent.kinda.gen.IUIModal
    //   41	77	1	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   9	25	139	finally
    //   32	66	139	finally
    //   70	81	139	finally
    //   81	84	139	finally
    //   95	106	139	finally
    //   106	136	139	finally
    //   140	143	139	finally
  }
  
  public static void removeAll()
  {
    AppMethodBeat.i(185698);
    Log.i("MicroMsg.ActivityController", "removeAllFragments");
    if ((currentActivity == null) || (currentActivity.get() == null))
    {
      Log.e("MicroMsg.ActivityController", "currentActivity is null, needn't remove any modal.");
      AppMethodBeat.o(185698);
      return;
    }
    Activity localActivity = (Activity)currentActivity.get();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      Log.w("MicroMsg.ActivityController", "remove all modal");
      if (fragmentPond.size() > 0)
      {
        fragmentPond.clear();
        h.CyF.dN(965, 52);
      }
      localActivity.finish();
    }
    AppMethodBeat.o(185698);
  }
  
  public static void resetFlag()
  {
    AppMethodBeat.i(19310);
    activityCreating = false;
    Log.i("MicroMsg.ActivityController", "activityCreating has set false.");
    AppMethodBeat.o(19310);
  }
  
  public static BaseFragment resolveFragment(Bundle paramBundle)
  {
    AppMethodBeat.i(19306);
    int i = paramBundle.getInt("intent_target", 0);
    if (fragmentPond.containsKey(Integer.valueOf(i)))
    {
      paramBundle = (BaseFragment)fragmentPond.remove(Integer.valueOf(i));
      AppMethodBeat.o(19306);
      return paramBundle;
    }
    AppMethodBeat.o(19306);
    return null;
  }
  
  /* Error */
  public static void startNewUIModal(com.tencent.kinda.gen.IUIModal paramIUIModal)
  {
    // Byte code:
    //   0: sipush 19308
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   12: ifnull +37 -> 49
    //   15: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   18: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   21: checkcast 74	android/app/Activity
    //   24: astore_2
    //   25: aload_2
    //   26: instanceof 121
    //   29: ifeq +20 -> 49
    //   32: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   35: invokevirtual 189	java/util/HashMap:size	()I
    //   38: ifne +11 -> 49
    //   41: aload_2
    //   42: checkcast 121	com/tencent/mm/framework/app/UIPageFragmentActivity
    //   45: iconst_1
    //   46: putfield 211	com/tencent/mm/framework/app/UIPageFragmentActivity:hgt	Z
    //   49: aload_0
    //   50: invokevirtual 140	java/lang/Object:hashCode	()I
    //   53: istore_1
    //   54: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   57: iload_1
    //   58: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 207	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   64: ifne +72 -> 136
    //   67: new 213	com/tencent/kinda/framework/app/ModalFragment
    //   70: dup
    //   71: invokespecial 214	com/tencent/kinda/framework/app/ModalFragment:<init>	()V
    //   74: astore_2
    //   75: aload_2
    //   76: checkcast 213	com/tencent/kinda/framework/app/ModalFragment
    //   79: aload_0
    //   80: invokevirtual 217	com/tencent/kinda/framework/app/ModalFragment:attachModal	(Lcom/tencent/kinda/gen/IUIModal;)V
    //   83: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   86: iload_1
    //   87: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aload_2
    //   91: invokevirtual 221	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload_2
    //   96: astore_0
    //   97: invokestatic 223	com/tencent/kinda/framework/widget/tools/ActivityController:isTopKindaActivity	()Z
    //   100: ifeq +53 -> 153
    //   103: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   106: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   109: checkcast 72	com/tencent/kinda/framework/widget/base/IEventFragment
    //   112: aload_0
    //   113: invokeinterface 103 2 0
    //   118: pop
    //   119: ldc 8
    //   121: ldc 225
    //   123: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc 2
    //   128: monitorexit
    //   129: sipush 19308
    //   132: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   139: iload_1
    //   140: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokevirtual 97	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: checkcast 99	com/tencent/kinda/framework/widget/base/BaseFragment
    //   149: astore_0
    //   150: goto -53 -> 97
    //   153: getstatic 43	com/tencent/kinda/framework/widget/tools/ActivityController:pendingList	Ljava/util/List;
    //   156: iload_1
    //   157: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokeinterface 228 2 0
    //   165: pop
    //   166: getstatic 38	com/tencent/kinda/framework/widget/tools/ActivityController:activityCreating	Z
    //   169: ifeq +20 -> 189
    //   172: ldc 8
    //   174: ldc 230
    //   176: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: ldc 2
    //   181: monitorexit
    //   182: sipush 19308
    //   185: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: return
    //   189: invokestatic 126	com/tencent/kinda/framework/widget/tools/KindaContext:get	()Landroid/content/Context;
    //   192: astore_0
    //   193: aload_0
    //   194: ifnonnull +20 -> 214
    //   197: ldc 8
    //   199: ldc 232
    //   201: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: ldc 2
    //   206: monitorexit
    //   207: sipush 19308
    //   210: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: iconst_1
    //   215: putstatic 38	com/tencent/kinda/framework/widget/tools/ActivityController:activityCreating	Z
    //   218: ldc 8
    //   220: ldc 234
    //   222: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: new 236	android/content/Intent
    //   228: dup
    //   229: aload_0
    //   230: ldc 121
    //   232: invokespecial 239	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   235: astore_2
    //   236: aload_0
    //   237: instanceof 74
    //   240: ifeq +23 -> 263
    //   243: aload_0
    //   244: checkcast 74	android/app/Activity
    //   247: invokevirtual 243	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   250: astore_3
    //   251: aload_3
    //   252: ifnull +11 -> 263
    //   255: aload_3
    //   256: ldc 245
    //   258: iconst_1
    //   259: invokevirtual 249	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   262: pop
    //   263: aload_2
    //   264: ldc 251
    //   266: iconst_0
    //   267: invokevirtual 249	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   270: pop
    //   271: new 253	com/tencent/mm/hellhoundlib/b/a
    //   274: dup
    //   275: invokespecial 254	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   278: aload_2
    //   279: invokevirtual 258	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   282: astore_2
    //   283: aload_0
    //   284: aload_2
    //   285: invokevirtual 262	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   288: ldc_w 263
    //   291: ldc_w 264
    //   294: ldc_w 265
    //   297: ldc_w 267
    //   300: ldc_w 269
    //   303: ldc_w 271
    //   306: invokestatic 277	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: aload_2
    //   311: iconst_0
    //   312: invokevirtual 281	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   315: checkcast 236	android/content/Intent
    //   318: invokevirtual 285	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   321: aload_0
    //   322: ldc_w 263
    //   325: ldc_w 264
    //   328: ldc_w 265
    //   331: ldc_w 267
    //   334: ldc_w 269
    //   337: ldc_w 271
    //   340: invokestatic 288	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   343: ldc 8
    //   345: ldc_w 290
    //   348: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -225 -> 126
    //   354: astore_0
    //   355: ldc 2
    //   357: monitorexit
    //   358: sipush 19308
    //   361: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload_0
    //   365: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramIUIModal	com.tencent.kinda.gen.IUIModal
    //   53	104	1	i	int
    //   24	287	2	localObject	Object
    //   250	6	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   9	49	354	finally
    //   49	95	354	finally
    //   97	126	354	finally
    //   126	129	354	finally
    //   136	150	354	finally
    //   153	182	354	finally
    //   189	193	354	finally
    //   197	207	354	finally
    //   214	251	354	finally
    //   255	263	354	finally
    //   263	351	354	finally
    //   355	358	354	finally
  }
  
  public static void startNewUIPage(IUIPage paramIUIPage, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(19307);
    if (currentActivity != null)
    {
      localObject = (Activity)currentActivity.get();
      if ((localObject instanceof UIPageFragmentActivity)) {
        ((UIPageFragmentActivity)localObject).hgt = false;
      }
    }
    String str1 = paramITransmitKvData.getString("KindaWebViewURL");
    String str2 = paramITransmitKvData.getString("KindaTinyAppUserName");
    String str3 = paramITransmitKvData.getString("KindaTinyAppPath");
    String str4 = paramITransmitKvData.getString("KindaTinyAppVersion");
    int i = Util.getInt(paramITransmitKvData.getString("KindaTinyAppScene"), 0);
    int j = Util.getInt(paramITransmitKvData.getString("KindaTinyAppType"), 0);
    Object localObject = new MainFragment();
    ((MainFragment)localObject).attachPage(paramIUIPage);
    fragmentPond.put(Integer.valueOf(paramIUIPage.hashCode()), localObject);
    Intent localIntent;
    Bundle localBundle;
    if (isTopKindaActivity())
    {
      localObject = (Context)currentActivity.get();
      localIntent = new Intent((Context)localObject, UIPageFragmentActivity.class);
      localIntent.addFlags(67108864);
      localBundle = new Bundle();
      localBundle.putInt("intent_target", paramIUIPage.hashCode());
      if (str1.length() <= 0) {
        break label318;
      }
      localBundle.putBoolean("intent_webview", true);
      localBundle.putString("intent_webview_url", str1);
    }
    for (;;)
    {
      localIntent.putExtra("intent_bundle", localBundle);
      localIntent.putExtra("check_wallet_lock", paramITransmitKvData.getBool("check_wallet_lock"));
      if (!isTopKindaActivity()) {
        break label386;
      }
      ((UIPageFragmentActivity)currentActivity.get()).t(localIntent.getBundleExtra("intent_bundle"));
      Log.i("MicroMsg.ActivityController", "startNewUIPage by onNewIntentForKinda.");
      AppMethodBeat.o(19307);
      return;
      localObject = KindaContext.get();
      if (localObject == null)
      {
        AppMethodBeat.o(19307);
        return;
      }
      localIntent = new Intent((Context)localObject, UIPageFragmentActivity.class);
      break;
      label318:
      if (str2.length() > 0)
      {
        localBundle.putBoolean("intent_tinyapp", true);
        localBundle.putString("intent_tinyapp_username", str2);
        localBundle.putString("intent_tinyapp_path", str3);
        localBundle.putString("intent_tinyapp_version", str4);
        localBundle.putInt("intent_tinyapp_type", j);
        localBundle.putInt("intent_tinyapp_scene", i);
      }
    }
    label386:
    paramIUIPage = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramIUIPage.axQ(), "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramIUIPage.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.i("MicroMsg.ActivityController", "startNewUIPage by a new activity.");
    AppMethodBeat.o(19307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ActivityController
 * JD-Core Version:    0.7.0.1
 */