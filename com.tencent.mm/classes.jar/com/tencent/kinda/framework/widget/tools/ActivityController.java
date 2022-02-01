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
    AppMethodBeat.i(226472);
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
      AppMethodBeat.o(226472);
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
    //   9: ldc 8
    //   11: ldc 134
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: invokevirtual 140	com/tencent/kinda/gen/IUIModal:getReportUrl	()Ljava/lang/String;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: aload_0
    //   27: invokevirtual 143	java/lang/Object:hashCode	()I
    //   30: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: aastore
    //   34: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   40: aload_0
    //   41: invokevirtual 143	java/lang/Object:hashCode	()I
    //   44: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 149	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 99	com/tencent/kinda/framework/widget/base/BaseFragment
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +36 -> 91
    //   58: aload_1
    //   59: invokevirtual 153	com/tencent/kinda/framework/widget/base/BaseFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   62: astore_0
    //   63: aload_0
    //   64: instanceof 72
    //   67: ifeq +14 -> 81
    //   70: aload_0
    //   71: checkcast 72	com/tencent/kinda/framework/widget/base/IEventFragment
    //   74: aload_1
    //   75: invokeinterface 156 2 0
    //   80: pop
    //   81: ldc 2
    //   83: monitorexit
    //   84: sipush 19309
    //   87: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   94: invokevirtual 160	java/util/HashMap:values	()Ljava/util/Collection;
    //   97: invokeinterface 163 1 0
    //   102: astore_2
    //   103: aload_2
    //   104: invokeinterface 87 1 0
    //   109: ifeq +67 -> 176
    //   112: aload_2
    //   113: invokeinterface 91 1 0
    //   118: checkcast 99	com/tencent/kinda/framework/widget/base/BaseFragment
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 164	com/tencent/kinda/framework/widget/base/BaseFragment:getReportUrl	()Ljava/lang/String;
    //   126: aload_0
    //   127: invokevirtual 140	com/tencent/kinda/gen/IUIModal:getReportUrl	()Ljava/lang/String;
    //   130: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq -30 -> 103
    //   136: ldc 8
    //   138: ldc 169
    //   140: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokevirtual 153	com/tencent/kinda/framework/widget/base/BaseFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   147: astore_0
    //   148: aload_0
    //   149: instanceof 72
    //   152: ifeq +14 -> 166
    //   155: aload_0
    //   156: checkcast 72	com/tencent/kinda/framework/widget/base/IEventFragment
    //   159: aload_1
    //   160: invokeinterface 156 2 0
    //   165: pop
    //   166: ldc 2
    //   168: monitorexit
    //   169: sipush 19309
    //   172: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: getstatic 178	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   179: sipush 965
    //   182: bipush 53
    //   184: invokevirtual 182	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   187: ldc 8
    //   189: ldc 184
    //   191: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: goto -113 -> 81
    //   197: astore_0
    //   198: ldc 2
    //   200: monitorexit
    //   201: sipush 19309
    //   204: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_0
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramIUIModal	com.tencent.kinda.gen.IUIModal
    //   53	107	1	localBaseFragment	BaseFragment
    //   102	11	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   9	54	197	finally
    //   58	81	197	finally
    //   81	84	197	finally
    //   91	103	197	finally
    //   103	166	197	finally
    //   166	169	197	finally
    //   176	194	197	finally
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
        h.OAn.kJ(965, 52);
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
    //   35: invokevirtual 196	java/util/HashMap:size	()I
    //   38: ifne +11 -> 49
    //   41: aload_2
    //   42: checkcast 121	com/tencent/mm/framework/app/UIPageFragmentActivity
    //   45: iconst_1
    //   46: putfield 218	com/tencent/mm/framework/app/UIPageFragmentActivity:msE	Z
    //   49: aload_0
    //   50: invokevirtual 143	java/lang/Object:hashCode	()I
    //   53: istore_1
    //   54: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   57: iload_1
    //   58: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 214	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   64: ifne +72 -> 136
    //   67: new 220	com/tencent/kinda/framework/app/ModalFragment
    //   70: dup
    //   71: invokespecial 221	com/tencent/kinda/framework/app/ModalFragment:<init>	()V
    //   74: astore_2
    //   75: aload_2
    //   76: checkcast 220	com/tencent/kinda/framework/app/ModalFragment
    //   79: aload_0
    //   80: invokevirtual 224	com/tencent/kinda/framework/app/ModalFragment:attachModal	(Lcom/tencent/kinda/gen/IUIModal;)V
    //   83: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   86: iload_1
    //   87: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aload_2
    //   91: invokevirtual 228	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload_2
    //   96: astore_0
    //   97: invokestatic 230	com/tencent/kinda/framework/widget/tools/ActivityController:isTopKindaActivity	()Z
    //   100: ifeq +53 -> 153
    //   103: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   106: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   109: checkcast 72	com/tencent/kinda/framework/widget/base/IEventFragment
    //   112: aload_0
    //   113: invokeinterface 103 2 0
    //   118: pop
    //   119: ldc 8
    //   121: ldc 232
    //   123: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc 2
    //   128: monitorexit
    //   129: sipush 19308
    //   132: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   139: iload_1
    //   140: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokevirtual 97	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: checkcast 99	com/tencent/kinda/framework/widget/base/BaseFragment
    //   149: astore_0
    //   150: goto -53 -> 97
    //   153: getstatic 43	com/tencent/kinda/framework/widget/tools/ActivityController:pendingList	Ljava/util/List;
    //   156: iload_1
    //   157: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokeinterface 235 2 0
    //   165: pop
    //   166: getstatic 38	com/tencent/kinda/framework/widget/tools/ActivityController:activityCreating	Z
    //   169: ifeq +20 -> 189
    //   172: ldc 8
    //   174: ldc 237
    //   176: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   199: ldc 239
    //   201: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: ldc 2
    //   206: monitorexit
    //   207: sipush 19308
    //   210: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: iconst_1
    //   215: putstatic 38	com/tencent/kinda/framework/widget/tools/ActivityController:activityCreating	Z
    //   218: ldc 8
    //   220: ldc 241
    //   222: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: new 243	android/content/Intent
    //   228: dup
    //   229: aload_0
    //   230: ldc 121
    //   232: invokespecial 246	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   235: astore_2
    //   236: aload_0
    //   237: instanceof 74
    //   240: ifeq +23 -> 263
    //   243: aload_0
    //   244: checkcast 74	android/app/Activity
    //   247: invokevirtual 250	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   250: astore_3
    //   251: aload_3
    //   252: ifnull +11 -> 263
    //   255: aload_3
    //   256: ldc 252
    //   258: iconst_1
    //   259: invokevirtual 256	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   262: pop
    //   263: aload_2
    //   264: ldc_w 258
    //   267: iconst_0
    //   268: invokevirtual 256	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   271: pop
    //   272: new 260	com/tencent/mm/hellhoundlib/b/a
    //   275: dup
    //   276: invokespecial 261	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   279: aload_2
    //   280: invokevirtual 265	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   283: astore_2
    //   284: aload_0
    //   285: aload_2
    //   286: invokevirtual 269	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   289: ldc_w 270
    //   292: ldc_w 271
    //   295: ldc_w 272
    //   298: ldc_w 274
    //   301: ldc_w 276
    //   304: ldc_w 278
    //   307: invokestatic 284	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: aload_2
    //   312: iconst_0
    //   313: invokevirtual 288	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   316: checkcast 243	android/content/Intent
    //   319: invokevirtual 292	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   322: aload_0
    //   323: ldc_w 270
    //   326: ldc_w 271
    //   329: ldc_w 272
    //   332: ldc_w 274
    //   335: ldc_w 276
    //   338: ldc_w 278
    //   341: invokestatic 296	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   344: ldc 8
    //   346: ldc_w 298
    //   349: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -226 -> 126
    //   355: astore_0
    //   356: ldc 2
    //   358: monitorexit
    //   359: sipush 19308
    //   362: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: aload_0
    //   366: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramIUIModal	com.tencent.kinda.gen.IUIModal
    //   53	104	1	i	int
    //   24	288	2	localObject	Object
    //   250	6	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   9	49	355	finally
    //   49	95	355	finally
    //   97	126	355	finally
    //   126	129	355	finally
    //   136	150	355	finally
    //   153	182	355	finally
    //   189	193	355	finally
    //   197	207	355	finally
    //   214	251	355	finally
    //   255	263	355	finally
    //   263	352	355	finally
  }
  
  public static void startNewUIPage(IUIPage paramIUIPage, ITransmitKvData paramITransmitKvData, int paramInt)
  {
    AppMethodBeat.i(226475);
    if (currentActivity != null)
    {
      localObject = (Activity)currentActivity.get();
      if ((localObject instanceof UIPageFragmentActivity)) {
        ((UIPageFragmentActivity)localObject).msE = false;
      }
    }
    String str1 = paramITransmitKvData.getString("KindaWebViewURL");
    String str2 = paramITransmitKvData.getString("KindaTinyAppUserName");
    String str3 = paramITransmitKvData.getString("KindaTinyAppPath");
    String str4 = paramITransmitKvData.getString("KindaTinyAppVersion");
    int i = Util.getInt(paramITransmitKvData.getString("KindaTinyAppScene"), 0);
    int j = Util.getInt(paramITransmitKvData.getString("KindaTinyAppType"), 0);
    Object localObject = new MainFragment();
    ((MainFragment)localObject).enterAnimStyle = paramInt;
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
        break label325;
      }
      localBundle.putBoolean("intent_webview", true);
      localBundle.putString("intent_webview_url", str1);
    }
    for (;;)
    {
      localIntent.putExtra("intent_bundle", localBundle);
      localIntent.putExtra("check_wallet_lock", paramITransmitKvData.getBool("check_wallet_lock"));
      if (!isTopKindaActivity()) {
        break label394;
      }
      ((UIPageFragmentActivity)currentActivity.get()).H(localIntent.getBundleExtra("intent_bundle"));
      Log.i("MicroMsg.ActivityController", "startNewUIPage by onNewIntentForKinda.");
      AppMethodBeat.o(226475);
      return;
      localObject = KindaContext.get();
      if (localObject == null)
      {
        AppMethodBeat.o(226475);
        return;
      }
      localIntent = new Intent((Context)localObject, UIPageFragmentActivity.class);
      break;
      label325:
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
    label394:
    paramIUIPage = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIUIPage.aYi(), "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramIUIPage.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.i("MicroMsg.ActivityController", "startNewUIPage by a new activity.");
    AppMethodBeat.o(226475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ActivityController
 * JD-Core Version:    0.7.0.1
 */