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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    ac.i("MicroMsg.ActivityController", "attach %s", new Object[] { paramActivity });
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
    ac.i("MicroMsg.ActivityController", "activityCreating has set false.");
    AppMethodBeat.o(19305);
  }
  
  public static void detach(Activity paramActivity)
  {
    AppMethodBeat.i(207416);
    ac.i("MicroMsg.ActivityController", "detach %s", new Object[] { paramActivity });
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
      AppMethodBeat.o(207416);
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
    //   19: invokestatic 137	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   95: getstatic 155	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   98: sipush 965
    //   101: bipush 53
    //   103: invokevirtual 159	com/tencent/mm/plugin/report/service/h:dB	(II)V
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
    //   133: invokestatic 137	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    ac.i("MicroMsg.ActivityController", "removeAllFragments");
    if ((currentActivity == null) || (currentActivity.get() == null))
    {
      ac.e("MicroMsg.ActivityController", "currentActivity is null, needn't remove any modal.");
      AppMethodBeat.o(185698);
      return;
    }
    Activity localActivity = (Activity)currentActivity.get();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      ac.w("MicroMsg.ActivityController", "remove all modal");
      if (fragmentPond.size() > 0)
      {
        fragmentPond.clear();
        h.wUl.dB(965, 52);
      }
      localActivity.finish();
    }
    AppMethodBeat.o(185698);
  }
  
  public static void resetFlag()
  {
    AppMethodBeat.i(19310);
    activityCreating = false;
    ac.i("MicroMsg.ActivityController", "activityCreating has set false.");
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
    //   9: aload_0
    //   10: invokevirtual 140	java/lang/Object:hashCode	()I
    //   13: istore_1
    //   14: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   17: iload_1
    //   18: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: invokevirtual 207	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   24: ifne +72 -> 96
    //   27: new 210	com/tencent/kinda/framework/app/ModalFragment
    //   30: dup
    //   31: invokespecial 211	com/tencent/kinda/framework/app/ModalFragment:<init>	()V
    //   34: astore_2
    //   35: aload_2
    //   36: checkcast 210	com/tencent/kinda/framework/app/ModalFragment
    //   39: aload_0
    //   40: invokevirtual 214	com/tencent/kinda/framework/app/ModalFragment:attachModal	(Lcom/tencent/kinda/gen/IUIModal;)V
    //   43: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   46: iload_1
    //   47: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aload_2
    //   51: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_2
    //   56: astore_0
    //   57: invokestatic 220	com/tencent/kinda/framework/widget/tools/ActivityController:isTopKindaActivity	()Z
    //   60: ifeq +53 -> 113
    //   63: getstatic 64	com/tencent/kinda/framework/widget/tools/ActivityController:currentActivity	Ljava/lang/ref/WeakReference;
    //   66: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   69: checkcast 72	com/tencent/kinda/framework/widget/base/IEventFragment
    //   72: aload_0
    //   73: invokeinterface 103 2 0
    //   78: pop
    //   79: ldc 8
    //   81: ldc 222
    //   83: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: ldc 2
    //   88: monitorexit
    //   89: sipush 19308
    //   92: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: getstatic 36	com/tencent/kinda/framework/widget/tools/ActivityController:fragmentPond	Ljava/util/HashMap;
    //   99: iload_1
    //   100: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: invokevirtual 97	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 99	com/tencent/kinda/framework/widget/base/BaseFragment
    //   109: astore_0
    //   110: goto -53 -> 57
    //   113: getstatic 43	com/tencent/kinda/framework/widget/tools/ActivityController:pendingList	Ljava/util/List;
    //   116: iload_1
    //   117: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: invokeinterface 225 2 0
    //   125: pop
    //   126: getstatic 38	com/tencent/kinda/framework/widget/tools/ActivityController:activityCreating	Z
    //   129: ifeq +20 -> 149
    //   132: ldc 8
    //   134: ldc 227
    //   136: invokestatic 188	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 2
    //   141: monitorexit
    //   142: sipush 19308
    //   145: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: invokestatic 126	com/tencent/kinda/framework/widget/tools/KindaContext:get	()Landroid/content/Context;
    //   152: astore_0
    //   153: aload_0
    //   154: ifnonnull +20 -> 174
    //   157: ldc 8
    //   159: ldc 229
    //   161: invokestatic 188	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: ldc 2
    //   166: monitorexit
    //   167: sipush 19308
    //   170: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: iconst_1
    //   175: putstatic 38	com/tencent/kinda/framework/widget/tools/ActivityController:activityCreating	Z
    //   178: ldc 8
    //   180: ldc 231
    //   182: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: new 233	android/content/Intent
    //   188: dup
    //   189: aload_0
    //   190: ldc 121
    //   192: invokespecial 236	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   195: astore_2
    //   196: aload_0
    //   197: instanceof 74
    //   200: ifeq +23 -> 223
    //   203: aload_0
    //   204: checkcast 74	android/app/Activity
    //   207: invokevirtual 240	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   210: astore_3
    //   211: aload_3
    //   212: ifnull +11 -> 223
    //   215: aload_3
    //   216: ldc 242
    //   218: iconst_1
    //   219: invokevirtual 246	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   222: pop
    //   223: aload_2
    //   224: ldc 248
    //   226: iconst_0
    //   227: invokevirtual 246	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   230: pop
    //   231: new 250	com/tencent/mm/hellhoundlib/b/a
    //   234: dup
    //   235: invokespecial 251	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 255	com/tencent/mm/hellhoundlib/b/a:ba	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   242: astore_2
    //   243: aload_0
    //   244: aload_2
    //   245: invokevirtual 259	com/tencent/mm/hellhoundlib/b/a:aeD	()[Ljava/lang/Object;
    //   248: ldc_w 260
    //   251: ldc_w 261
    //   254: ldc_w 262
    //   257: ldc_w 264
    //   260: ldc_w 266
    //   263: ldc_w 268
    //   266: invokestatic 274	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_0
    //   270: aload_2
    //   271: iconst_0
    //   272: invokevirtual 278	com/tencent/mm/hellhoundlib/b/a:lR	(I)Ljava/lang/Object;
    //   275: checkcast 233	android/content/Intent
    //   278: invokevirtual 282	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   281: aload_0
    //   282: ldc_w 260
    //   285: ldc_w 261
    //   288: ldc_w 262
    //   291: ldc_w 264
    //   294: ldc_w 266
    //   297: ldc_w 268
    //   300: invokestatic 285	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   303: ldc 8
    //   305: ldc_w 287
    //   308: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: goto -225 -> 86
    //   314: astore_0
    //   315: ldc 2
    //   317: monitorexit
    //   318: sipush 19308
    //   321: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_0
    //   325: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramIUIModal	com.tencent.kinda.gen.IUIModal
    //   13	104	1	i	int
    //   34	237	2	localObject	Object
    //   210	6	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   9	55	314	finally
    //   57	86	314	finally
    //   86	89	314	finally
    //   96	110	314	finally
    //   113	142	314	finally
    //   149	153	314	finally
    //   157	167	314	finally
    //   174	211	314	finally
    //   215	223	314	finally
    //   223	311	314	finally
    //   315	318	314	finally
  }
  
  public static void startNewUIPage(IUIPage paramIUIPage, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(19307);
    String str1 = paramITransmitKvData.getString("KindaWebViewURL");
    String str2 = paramITransmitKvData.getString("KindaTinyAppUserName");
    String str3 = paramITransmitKvData.getString("KindaTinyAppPath");
    String str4 = paramITransmitKvData.getString("KindaTinyAppVersion");
    int i = bs.getInt(paramITransmitKvData.getString("KindaTinyAppType"), 0);
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
        break label264;
      }
      localBundle.putBoolean("intent_webview", true);
      localBundle.putString("intent_webview_url", str1);
    }
    for (;;)
    {
      localIntent.putExtra("intent_bundle", localBundle);
      localIntent.putExtra("check_wallet_lock", paramITransmitKvData.getBool("check_wallet_lock"));
      if (!isTopKindaActivity()) {
        break label323;
      }
      ((UIPageFragmentActivity)currentActivity.get()).p(localIntent.getBundleExtra("intent_bundle"));
      ac.i("MicroMsg.ActivityController", "startNewUIPage by onNewIntentForKinda.");
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
      label264:
      if (str2.length() > 0)
      {
        localBundle.putBoolean("intent_tinyapp", true);
        localBundle.putString("intent_tinyapp_username", str2);
        localBundle.putString("intent_tinyapp_path", str3);
        localBundle.putString("intent_tinyapp_version", str4);
        localBundle.putInt("intent_tinyapp_type", i);
      }
    }
    label323:
    paramIUIPage = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramIUIPage.aeD(), "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject).startActivity((Intent)paramIUIPage.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ac.i("MicroMsg.ActivityController", "startNewUIPage by a new activity.");
    AppMethodBeat.o(19307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ActivityController
 * JD-Core Version:    0.7.0.1
 */