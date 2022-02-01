package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sl;
import com.tencent.mm.autogen.mmdata.rpt.sl.a;
import com.tencent.mm.autogen.mmdata.rpt.so;
import com.tencent.mm.autogen.mmdata.rpt.so.a;
import com.tencent.mm.autogen.mmdata.rpt.sp;
import com.tencent.mm.autogen.mmdata.rpt.sp.a;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.performance.h.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.q;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.input.a.1;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.vendor.Meizu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.xweb.WebView.WebViewKind;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.ah;

@com.tencent.mm.ui.base.a(7)
public class AppBrandUI
  extends AppBrandContainerFragmentActivity
  implements androidx.core.app.a.a, e.e, com.tencent.mm.plugin.appbrand.jsapi.nfc.b, com.tencent.mm.plugin.appbrand.platform.window.a.a, b.a
{
  private static final int[] uer;
  private static boolean uey;
  private LayoutInflater mLayoutInflater;
  private Resources mResources;
  public AppBrandRuntimeContainerWC mRuntimeContainer;
  private final com.tencent.mm.plugin.appbrand.task.p qud;
  private Configuration tAl;
  private ab udU;
  private boolean ueA;
  private boolean ueB;
  public boolean ueC;
  private final Object ueD;
  private com.tencent.mm.ui.widget.a.e ueE;
  private final Set<com.tencent.mm.plugin.appbrand.platform.window.a.a.a> ueF;
  private Boolean ueG;
  private final com.tencent.mm.plugin.appbrand.widget.input.a ues;
  private final AppBrandUITranslucentWorkaroundDelegate uet;
  private com.tencent.mm.plugin.appbrand.b.e ueu;
  private boolean uev;
  private boolean uew;
  private Boolean uex;
  private boolean uez;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(322390);
    d.cbf();
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPk, 1) == 1)
    {
      bool1 = true;
      com.tencent.mm.plugin.appbrand.b.c.qKB = bool1;
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPl, 1) != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.tencent.mm.plugin.appbrand.page.bk.tAa = bool1;
      uer = new int[] { 0, 11, 6, 8 };
      uey = false;
      AppMethodBeat.o(322390);
      return;
      bool1 = false;
      break;
    }
  }
  
  public AppBrandUI()
  {
    AppMethodBeat.i(48819);
    this.ues = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    this.uet = new AppBrandUITranslucentWorkaroundDelegate(this);
    this.uev = false;
    this.uew = false;
    this.uex = null;
    this.tAl = null;
    this.uez = false;
    this.ueA = false;
    this.ueB = false;
    this.ueC = false;
    this.ueD = new byte[0];
    this.ueE = null;
    this.ueF = new HashSet();
    this.qud = new com.tencent.mm.plugin.appbrand.task.p()
    {
      public final FrameLayout cKf()
      {
        AppMethodBeat.i(321955);
        FrameLayout localFrameLayout = (FrameLayout)AppBrandUI.j(AppBrandUI.this);
        AppMethodBeat.o(321955);
        return localFrameLayout;
      }
      
      public final boolean ccf()
      {
        AppMethodBeat.i(321959);
        boolean bool = AppBrandUI.this.ccf();
        AppMethodBeat.o(321959);
        return bool;
      }
    };
    Object localObject1 = Thread.currentThread().getStackTrace();
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i];
      if ((!"android.app.Instrumentation".equals(localObject2.getClassName())) || (!"newActivity".equals(localObject2.getMethodName()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = q.tWE;
        q.b(this, "<init>");
        AppBrandProcessSuicideLogic.H(this);
        if (com.tencent.mm.plugin.appbrand.app.e.ceB()) {
          break label209;
        }
      }
      for (;;)
      {
        this.uex = Boolean.valueOf(bool);
        AppMethodBeat.o(48819);
        return;
        i += 1;
        break;
        label209:
        bool = false;
      }
    }
  }
  
  public static Configuration M(Activity paramActivity)
  {
    AppMethodBeat.i(48830);
    if ((paramActivity instanceof MMFragmentActivity))
    {
      paramActivity = ((MMFragmentActivity)paramActivity).getOriginalResources().getConfiguration();
      AppMethodBeat.o(48830);
      return paramActivity;
    }
    if ((paramActivity instanceof MMBaseActivity))
    {
      paramActivity = ((MMBaseActivity)paramActivity).getOriginalResources().getConfiguration();
      AppMethodBeat.o(48830);
      return paramActivity;
    }
    paramActivity = paramActivity.getResources().getConfiguration();
    AppMethodBeat.o(48830);
    return paramActivity;
  }
  
  public static Pair<AppBrandInitConfigWC, AppBrandStatObject> P(Intent paramIntent)
  {
    AppMethodBeat.i(48829);
    Object localObject = paramIntent.getExtras();
    if (localObject == null)
    {
      paramIntent = new NullPointerException("intent.getExtras() returns NULL");
      AppMethodBeat.o(48829);
      throw paramIntent;
    }
    ((Bundle)localObject).setClassLoader(AppBrandInitConfigWC.class.getClassLoader());
    paramIntent = (AppBrandInitConfigWC)((Bundle)localObject).getParcelable("key_appbrand_init_config");
    ((Bundle)localObject).setClassLoader(AppBrandStatObject.class.getClassLoader());
    localObject = (AppBrandStatObject)((Bundle)localObject).getParcelable("key_appbrand_stat_object");
    if (paramIntent == null)
    {
      paramIntent = new NullPointerException("config is NULL");
      AppMethodBeat.o(48829);
      throw paramIntent;
    }
    if (localObject == null)
    {
      paramIntent = new NullPointerException("stat is NULL");
      AppMethodBeat.o(48829);
      throw paramIntent;
    }
    paramIntent = Pair.create(paramIntent, localObject);
    AppMethodBeat.o(48829);
    return paramIntent;
  }
  
  private void a(final WeAppOpenDeclarePromptBundle paramWeAppOpenDeclarePromptBundle, String paramString)
  {
    AppMethodBeat.i(322319);
    if (this.mRuntimeContainer != null) {}
    for (Object localObject = this.mRuntimeContainer.getActiveRuntime();; localObject = null)
    {
      if ((localObject == null) || (!Util.isEqual(((AppBrandRuntime)localObject).mAppId, paramString)))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "handleDeclarePrompt: try dismiss last dialog, activeRuntime(%s) newAppId(%s)", new Object[] { localObject, paramString });
        if (this.ueE != null) {
          this.ueE.dismiss();
        }
      }
      if (paramWeAppOpenDeclarePromptBundle != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt with null bundle: appid(%s) try dismiss last dialog", new Object[] { Util.nullAs(paramString, "") });
      if (this.ueE != null) {
        this.ueE.dismiss();
      }
      AppMethodBeat.o(322319);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt bundle:%s appid:%s", new Object[] { paramWeAppOpenDeclarePromptBundle, Util.nullAs(paramString, "") });
    if (this.ueE != null) {
      this.ueE.dismiss();
    }
    e.a locala = new e.a(this);
    locala.bDv(paramWeAppOpenDeclarePromptBundle.qBc);
    locala.bDw(paramWeAppOpenDeclarePromptBundle.qBd);
    localObject = paramWeAppOpenDeclarePromptBundle.qBe;
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = getString(ba.i.app_ok);
    }
    locala.bDC(paramString).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(322333);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt: onClick");
        com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new AppBrandUIDeclarePromptIPC.IPCDeclarePromptCallbackParam(paramWeAppOpenDeclarePromptBundle.hyY, false, paramWeAppOpenDeclarePromptBundle.qBb), AppBrandUIDeclarePromptIPC.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(322333);
      }
    });
    locala.NC(paramWeAppOpenDeclarePromptBundle.dqR);
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(322331);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt: onCancel");
        com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new AppBrandUIDeclarePromptIPC.IPCDeclarePromptCallbackParam(paramWeAppOpenDeclarePromptBundle.hyY, true, paramWeAppOpenDeclarePromptBundle.qBb), AppBrandUIDeclarePromptIPC.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(322331);
      }
    });
    paramWeAppOpenDeclarePromptBundle = locala.jHH();
    this.ueE = paramWeAppOpenDeclarePromptBundle;
    paramWeAppOpenDeclarePromptBundle.show();
    AppMethodBeat.o(322319);
  }
  
  private LayoutInflater cLt()
  {
    AppMethodBeat.i(322281);
    if (this.mLayoutInflater != null)
    {
      ??? = this.mLayoutInflater;
      AppMethodBeat.o(322281);
      return ???;
    }
    synchronized (this.ueD)
    {
      if (this.mLayoutInflater == null)
      {
        this.mLayoutInflater = ((LayoutInflater)Objects.requireNonNull((LayoutInflater)androidx.core.content.a.a(getApplicationContext(), LayoutInflater.class))).cloneInContext(this);
        af.c(this.mLayoutInflater);
      }
      LayoutInflater localLayoutInflater = this.mLayoutInflater;
      AppMethodBeat.o(322281);
      return localLayoutInflater;
    }
  }
  
  private void cLu()
  {
    AppMethodBeat.i(48824);
    if (this.mRuntimeContainer == null) {}
    for (int i = -1;; i = this.mRuntimeContainer.getStackSize())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "%s.closeIfNoActiveRuntimes %d,", new Object[] { getLocalClassName(), Integer.valueOf(i) });
      if (!(this.mRuntimeContainer instanceof AppBrandRuntimeContainerWC)) {
        break;
      }
      ((AppBrandRuntimeContainerWC)this.mRuntimeContainer).asv();
      AppMethodBeat.o(48824);
      return;
    }
    if (i <= 0) {
      finish();
    }
    AppMethodBeat.o(48824);
  }
  
  private void di(String paramString, int paramInt)
  {
    AppMethodBeat.i(48833);
    if ((this.uez) || (this.ueA))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "has recreateProcess!");
      AppMethodBeat.o(48833);
      return;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.ueA = true;
        Object localObject = P(getIntent());
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)((Pair)localObject).first;
        localObject = (AppBrandStatObject)((Pair)localObject).second;
        localAppBrandInitConfigWC.qYe = Util.nowMilliSecond();
        localAppBrandInitConfigWC.startTime = Util.nowMilliSecond();
        Intent localIntent = getIntent();
        localIntent.putExtra("key_appbrand_init_config", localAppBrandInitConfigWC);
        localIntent.putExtra("key_appbrand_stat_object", (Parcelable)localObject);
        setIntent(localIntent);
        AppBrandProcessSuicideLogic.ceD();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "recreate Activity[%s] by %s", new Object[] { getClass().getSimpleName(), paramString });
        recreate();
        AppMethodBeat.o(48833);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUI", paramString, "recreate Activity exception", new Object[0]);
        finish();
        AppMethodBeat.o(48833);
        return;
      }
      if (paramInt == 0) {
        this.uez = true;
      } else if (paramInt == 2) {
        this.ueB = true;
      }
    }
  }
  
  /* Error */
  private void e(Intent paramIntent, String paramString)
  {
    // Byte code:
    //   0: ldc_w 574
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 548	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:setIntent	(Landroid/content/Intent;)V
    //   16: aload_1
    //   17: invokestatic 523	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:P	(Landroid/content/Intent;)Landroid/util/Pair;
    //   20: astore 7
    //   22: aload 7
    //   24: getfield 526	android/util/Pair:first	Ljava/lang/Object;
    //   27: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   30: astore 6
    //   32: aload 7
    //   34: getfield 529	android/util/Pair:second	Ljava/lang/Object;
    //   37: checkcast 300	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject
    //   40: astore 7
    //   42: aload 6
    //   44: ifnull +16 -> 60
    //   47: aload 7
    //   49: ifnull +11 -> 60
    //   52: aload 6
    //   54: getfield 581	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:eoV	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   57: ifnonnull +118 -> 175
    //   60: aload_0
    //   61: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   64: ifnull +13 -> 77
    //   67: aload_0
    //   68: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   71: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   74: ifnonnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   81: ldc_w 343
    //   84: ldc_w 584
    //   87: iconst_2
    //   88: anewarray 347	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_2
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   100: lload 4
    //   102: lsub
    //   103: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: aastore
    //   107: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: ldc_w 574
    //   113: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: ldc_w 343
    //   121: ldc_w 591
    //   124: iconst_1
    //   125: anewarray 347	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_0
    //   136: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   139: ldc_w 343
    //   142: ldc_w 584
    //   145: iconst_2
    //   146: anewarray 347	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_2
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   158: lload 4
    //   160: lsub
    //   161: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   164: aastore
    //   165: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: ldc_w 574
    //   171: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: aload_1
    //   176: aload_0
    //   177: invokevirtual 592	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getClassLoader	()Ljava/lang/ClassLoader;
    //   180: invokevirtual 595	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   183: aload 6
    //   185: getfield 599	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:epj	Lcom/tencent/luggage/sdk/config/AppBrandInitWindowConfig;
    //   188: ifnull +187 -> 375
    //   191: aload 6
    //   193: getfield 599	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:epj	Lcom/tencent/luggage/sdk/config/AppBrandInitWindowConfig;
    //   196: getfield 604	com/tencent/luggage/sdk/config/AppBrandInitWindowConfig:epo	Z
    //   199: ifeq +176 -> 375
    //   202: aload_0
    //   203: aload 6
    //   205: getfield 599	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:epj	Lcom/tencent/luggage/sdk/config/AppBrandInitWindowConfig;
    //   208: getfield 607	com/tencent/luggage/sdk/config/AppBrandInitWindowConfig:epp	I
    //   211: invokestatic 610	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:e	(Landroid/app/Activity;I)V
    //   214: aload 6
    //   216: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   219: invokestatic 617	com/tencent/mm/plugin/appbrand/d:Uc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/w;
    //   222: ifnonnull +840 -> 1062
    //   225: iconst_1
    //   226: istore_3
    //   227: iload_3
    //   228: ifeq +40 -> 268
    //   231: aload 6
    //   233: getfield 622	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:eoQ	Ljava/lang/String;
    //   236: aload 6
    //   238: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   241: aload 6
    //   243: getfield 625	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:username	Ljava/lang/String;
    //   246: aload 6
    //   248: getfield 628	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appVersion	I
    //   251: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   254: aload 6
    //   256: invokevirtual 633	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:aqJ	()Z
    //   259: invokestatic 638	com/tencent/mm/plugin/appbrand/report/quality/j:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   262: iconst_1
    //   263: aload 6
    //   265: invokestatic 643	com/tencent/mm/plugin/appbrand/r:a	(ILcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V
    //   268: aload 6
    //   270: aload 7
    //   272: putfield 647	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:epn	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
    //   275: aload_0
    //   276: aload 6
    //   278: aload_2
    //   279: invokestatic 652	com/tencent/mm/plugin/appbrand/report/model/f:a	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Ljava/lang/String;)V
    //   282: aload_1
    //   283: ldc_w 654
    //   286: getstatic 659	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   289: invokestatic 665	com/tencent/mm/sdk/platformtools/IntentUtil:getIntExtra	(Landroid/content/Intent;Ljava/lang/String;I)I
    //   292: istore_3
    //   293: getstatic 659	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   296: iload_3
    //   297: if_icmpeq +212 -> 509
    //   300: ldc_w 343
    //   303: ldc_w 667
    //   306: iconst_2
    //   307: anewarray 347	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: getstatic 659	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   315: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: iload_3
    //   322: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: iconst_5
    //   330: aload 6
    //   332: invokestatic 643	com/tencent/mm/plugin/appbrand/r:a	(ILcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V
    //   335: aload_0
    //   336: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   339: ldc_w 343
    //   342: ldc_w 584
    //   345: iconst_2
    //   346: anewarray 347	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload_2
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   358: lload 4
    //   360: lsub
    //   361: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   364: aastore
    //   365: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: ldc_w 574
    //   371: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: return
    //   375: aload 6
    //   377: getfield 671	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qAT	Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;
    //   380: getfield 676	com/tencent/mm/plugin/appbrand/config/HalfScreenConfig:qkq	Z
    //   383: ifeq +58 -> 441
    //   386: aload_0
    //   387: aload_0
    //   388: invokevirtual 677	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getResources	()Landroid/content/res/Resources;
    //   391: getstatic 682	com/tencent/mm/plugin/appbrand/ba$c:White	I
    //   394: invokevirtual 686	android/content/res/Resources:getColor	(I)I
    //   397: invokestatic 610	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:e	(Landroid/app/Activity;I)V
    //   400: goto -186 -> 214
    //   403: astore_1
    //   404: ldc_w 343
    //   407: ldc_w 584
    //   410: iconst_2
    //   411: anewarray 347	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: aload_2
    //   417: aastore
    //   418: dup
    //   419: iconst_1
    //   420: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   423: lload 4
    //   425: lsub
    //   426: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   429: aastore
    //   430: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: ldc_w 574
    //   436: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   439: aload_1
    //   440: athrow
    //   441: aload_0
    //   442: aload_0
    //   443: invokevirtual 677	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getResources	()Landroid/content/res/Resources;
    //   446: getstatic 689	com/tencent/mm/plugin/appbrand/ba$c:BG_1	I
    //   449: invokevirtual 686	android/content/res/Resources:getColor	(I)I
    //   452: invokestatic 610	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:e	(Landroid/app/Activity;I)V
    //   455: goto -241 -> 214
    //   458: astore_1
    //   459: bipush 35
    //   461: aload 6
    //   463: invokestatic 643	com/tencent/mm/plugin/appbrand/r:a	(ILcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V
    //   466: invokestatic 692	com/tencent/mm/plugin/appbrand/report/model/f:cIN	()V
    //   469: aload_0
    //   470: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   473: ldc_w 343
    //   476: ldc_w 584
    //   479: iconst_2
    //   480: anewarray 347	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload_2
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   492: lload 4
    //   494: lsub
    //   495: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   498: aastore
    //   499: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: ldc_w 574
    //   505: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   508: return
    //   509: aload_1
    //   510: invokevirtual 695	android/content/Intent:getFlags	()I
    //   513: ldc_w 696
    //   516: iand
    //   517: ifle +461 -> 978
    //   520: ldc_w 343
    //   523: ldc_w 698
    //   526: iconst_1
    //   527: anewarray 347	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: aload 6
    //   534: invokevirtual 701	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:toString	()Ljava/lang/String;
    //   537: aastore
    //   538: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: invokestatic 706	com/tencent/mm/kernel/b:aZP	()I
    //   544: istore_3
    //   545: iload_3
    //   546: ifne +79 -> 625
    //   549: aload_0
    //   550: getstatic 709	com/tencent/mm/plugin/appbrand/ba$i:app_brand_account_release_error	I
    //   553: iconst_1
    //   554: invokestatic 715	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   557: invokevirtual 716	android/widget/Toast:show	()V
    //   560: iconst_0
    //   561: invokestatic 721	com/tencent/mm/plugin/appbrand/report/model/m:rG	(I)V
    //   564: ldc_w 343
    //   567: ldc_w 723
    //   570: iconst_1
    //   571: anewarray 347	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: aload 6
    //   578: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   581: aastore
    //   582: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   585: aload_0
    //   586: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   589: ldc_w 343
    //   592: ldc_w 584
    //   595: iconst_2
    //   596: anewarray 347	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload_2
    //   602: aastore
    //   603: dup
    //   604: iconst_1
    //   605: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   608: lload 4
    //   610: lsub
    //   611: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   614: aastore
    //   615: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: ldc_w 574
    //   621: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   624: return
    //   625: iload_3
    //   626: aload 6
    //   628: getfield 726	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   631: if_icmpeq +86 -> 717
    //   634: iconst_1
    //   635: invokestatic 721	com/tencent/mm/plugin/appbrand/report/model/m:rG	(I)V
    //   638: ldc_w 343
    //   641: ldc_w 728
    //   644: iconst_3
    //   645: anewarray 347	java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: iload_3
    //   651: invokestatic 731	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   654: aastore
    //   655: dup
    //   656: iconst_1
    //   657: aload 6
    //   659: getfield 726	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   662: invokestatic 731	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   665: aastore
    //   666: dup
    //   667: iconst_2
    //   668: aload 6
    //   670: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   673: aastore
    //   674: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   677: aload_0
    //   678: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   681: ldc_w 343
    //   684: ldc_w 584
    //   687: iconst_2
    //   688: anewarray 347	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: aload_2
    //   694: aastore
    //   695: dup
    //   696: iconst_1
    //   697: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   700: lload 4
    //   702: lsub
    //   703: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   706: aastore
    //   707: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   710: ldc_w 574
    //   713: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: return
    //   717: aload 6
    //   719: invokestatic 533	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   722: putfield 540	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   725: aload 6
    //   727: invokestatic 533	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   730: putfield 537	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYe	J
    //   733: aload 6
    //   735: iconst_1
    //   736: putfield 734	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYn	I
    //   739: aload 6
    //   741: new 736	com/tencent/mm/plugin/appbrand/report/quality/QualitySession
    //   744: dup
    //   745: aload 6
    //   747: getfield 726	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   750: invokestatic 741	com/tencent/mm/plugin/appbrand/utils/f:DI	(I)Ljava/lang/String;
    //   753: aload 6
    //   755: aload 7
    //   757: invokespecial 744	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   760: putfield 748	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYm	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   763: aload 6
    //   765: invokevirtual 751	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:aqI	()V
    //   768: aload 6
    //   770: getfield 622	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:eoQ	Ljava/lang/String;
    //   773: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   776: ifeq +24 -> 800
    //   779: aload 6
    //   781: getfield 748	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYm	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   784: ifnull +16 -> 800
    //   787: aload 6
    //   789: aload 6
    //   791: getfield 748	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYm	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   794: getfield 754	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:eup	Ljava/lang/String;
    //   797: invokevirtual 757	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:fk	(Ljava/lang/String;)V
    //   800: aload 6
    //   802: getfield 748	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYm	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   805: ifnull +23 -> 828
    //   808: getstatic 763	com/tencent/mm/plugin/appbrand/report/quality/n:tTb	Lcom/tencent/mm/plugin/appbrand/report/quality/n;
    //   811: astore_1
    //   812: aload 6
    //   814: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   817: aload 6
    //   819: getfield 748	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYm	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   822: getfield 754	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:eup	Ljava/lang/String;
    //   825: invokestatic 766	com/tencent/mm/plugin/appbrand/report/quality/n:fn	(Ljava/lang/String;Ljava/lang/String;)V
    //   828: aload_0
    //   829: aload 6
    //   831: aload 7
    //   833: invokespecial 770	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:f	(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   836: ldc_w 343
    //   839: ldc_w 772
    //   842: iconst_2
    //   843: anewarray 347	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: aload 6
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: aload 7
    //   855: aastore
    //   856: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   859: aload 6
    //   861: invokevirtual 633	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:aqJ	()Z
    //   864: pop
    //   865: aload 6
    //   867: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   870: getstatic 778	com/tencent/mm/plugin/appbrand/step/KSProcessWeAppLaunch:stepContainerUILaunch	Lcom/tencent/mm/plugin/appbrand/keylogger/base/a;
    //   873: invokestatic 783	com/tencent/mm/plugin/appbrand/keylogger/c:b	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/keylogger/base/a;)V
    //   876: aload_0
    //   877: aload 6
    //   879: getfield 787	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYt	Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;
    //   882: aload 6
    //   884: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   887: invokespecial 789	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:a	(Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;Ljava/lang/String;)V
    //   890: aload_0
    //   891: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   894: aconst_null
    //   895: aload 6
    //   897: aload 7
    //   899: invokevirtual 794	com/tencent/luggage/sdk/e/b:a	(Lcom/tencent/luggage/sdk/e/d;Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   902: aload_0
    //   903: aload_0
    //   904: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   907: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   910: invokevirtual 798	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:aA	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V
    //   913: ldc_w 800
    //   916: aload_2
    //   917: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   920: ifeq +131 -> 1051
    //   923: aload_0
    //   924: invokevirtual 804	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLifecycle	()Landroidx/lifecycle/j;
    //   927: new 24	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$3
    //   930: dup
    //   931: aload_0
    //   932: aload 6
    //   934: aload 7
    //   936: invokespecial 807	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$3:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   939: invokevirtual 813	androidx/lifecycle/j:addObserver	(Landroidx/lifecycle/p;)V
    //   942: ldc_w 343
    //   945: ldc_w 584
    //   948: iconst_2
    //   949: anewarray 347	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: aload_2
    //   955: aastore
    //   956: dup
    //   957: iconst_1
    //   958: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   961: lload 4
    //   963: lsub
    //   964: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   967: aastore
    //   968: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   971: ldc_w 574
    //   974: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   977: return
    //   978: aload 6
    //   980: iconst_0
    //   981: putfield 734	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYn	I
    //   984: goto -216 -> 768
    //   987: astore_1
    //   988: ldc_w 343
    //   991: ldc_w 815
    //   994: iconst_1
    //   995: anewarray 347	java/lang/Object
    //   998: dup
    //   999: iconst_0
    //   1000: aload_1
    //   1001: aastore
    //   1002: invokestatic 818	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1005: goto -169 -> 836
    //   1008: astore_1
    //   1009: ldc_w 343
    //   1012: ldc_w 820
    //   1015: iconst_2
    //   1016: anewarray 347	java/lang/Object
    //   1019: dup
    //   1020: iconst_0
    //   1021: aload 6
    //   1023: getfield 613	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_1
    //   1029: aload_1
    //   1030: aastore
    //   1031: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: aload_0
    //   1035: getfield 174	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ueE	Lcom/tencent/mm/ui/widget/a/e;
    //   1038: ifnull -148 -> 890
    //   1041: aload_0
    //   1042: getfield 174	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ueE	Lcom/tencent/mm/ui/widget/a/e;
    //   1045: invokevirtual 358	com/tencent/mm/ui/widget/a/e:dismiss	()V
    //   1048: goto -158 -> 890
    //   1051: aload_0
    //   1052: aload 6
    //   1054: aload 7
    //   1056: invokevirtual 822	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:e	(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   1059: goto -117 -> 942
    //   1062: iconst_0
    //   1063: istore_3
    //   1064: goto -837 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1067	0	this	AppBrandUI
    //   0	1067	1	paramIntent	Intent
    //   0	1067	2	paramString	String
    //   226	838	3	i	int
    //   9	953	4	l	long
    //   30	1023	6	localAppBrandInitConfigWC	AppBrandInitConfigWC
    //   20	1035	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	42	117	java/lang/Exception
    //   16	42	403	finally
    //   52	60	403	finally
    //   60	77	403	finally
    //   77	81	403	finally
    //   118	139	403	finally
    //   175	214	403	finally
    //   214	225	403	finally
    //   231	268	403	finally
    //   268	275	403	finally
    //   275	282	403	finally
    //   282	339	403	finally
    //   375	400	403	finally
    //   441	455	403	finally
    //   459	473	403	finally
    //   509	545	403	finally
    //   549	589	403	finally
    //   625	681	403	finally
    //   717	768	403	finally
    //   768	800	403	finally
    //   836	876	403	finally
    //   890	942	403	finally
    //   978	984	403	finally
    //   988	1005	403	finally
    //   1009	1048	403	finally
    //   1051	1059	403	finally
    //   275	282	458	com/tencent/mm/plugin/appbrand/report/model/a
    //   800	828	987	finally
    //   828	836	987	finally
    //   876	890	1008	finally
  }
  
  private void f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(322298);
    if (this.uex == null) {
      this.uex = Boolean.FALSE;
    }
    if ((!this.uex.booleanValue()) || (uey))
    {
      AppMethodBeat.o(322298);
      return;
    }
    if (paramAppBrandInitConfigWC.qYm == null)
    {
      AppMethodBeat.o(322298);
      return;
    }
    if (paramAppBrandInitConfigWC.qYk)
    {
      AppMethodBeat.o(322298);
      return;
    }
    uey = true;
    g localg = com.tencent.mm.kernel.h.baB().bad();
    Object localObject = new so();
    ((so)localObject).ilM = ((so)localObject).F("InstanceId", paramAppBrandInitConfigWC.qYm.eup, true);
    ((so)localObject).imT = ((so)localObject).F("AppId", paramAppBrandInitConfigWC.appId, true);
    ((so)localObject).ind = paramAppBrandInitConfigWC.appVersion;
    ((so)localObject).jza = so.a.oK(paramAppBrandInitConfigWC.eul + 1);
    ((so)localObject).jax = (paramAppBrandInitConfigWC.appServiceType + 1000);
    ((so)localObject).iqr = paramAppBrandStatObject.scene;
    ((so)localObject).fE(paramAppBrandInitConfigWC.qYe);
    ((so)localObject).fF(localg.mFH.mFJ);
    ((so)localObject).fD(((so)localObject).jyJ - ((so)localObject).jyI);
    ((so)localObject).jzb = paramAppBrandInitConfigWC.qYn;
    ((so)localObject).bMH();
    localObject = new sp();
    ((sp)localObject).ilM = ((sp)localObject).F("InstanceId", paramAppBrandInitConfigWC.qYm.eup, true);
    ((sp)localObject).imT = ((sp)localObject).F("AppId", paramAppBrandInitConfigWC.appId, true);
    ((sp)localObject).ind = paramAppBrandInitConfigWC.appVersion;
    ((sp)localObject).jzg = sp.a.oL(paramAppBrandInitConfigWC.eul + 1);
    ((sp)localObject).jax = (paramAppBrandInitConfigWC.appServiceType + 1000);
    ((sp)localObject).iqr = paramAppBrandStatObject.scene;
    ((sp)localObject).fH(com.tencent.mm.plugin.appbrand.api.a.qAA);
    ((sp)localObject).fI(com.tencent.mm.plugin.appbrand.api.a.qAB);
    ((sp)localObject).fG(((sp)localObject).jyJ - ((sp)localObject).jyI);
    switch (4.ueK[com.tencent.xweb.WebView.getCurWebType().ordinal()])
    {
    default: 
      ((sp)localObject).bMH();
      localObject = new sl();
      ((sl)localObject).ilM = ((sl)localObject).F("InstanceId", paramAppBrandInitConfigWC.qYm.eup, true);
      ((sl)localObject).imT = ((sl)localObject).F("AppId", paramAppBrandInitConfigWC.appId, true);
      ((sl)localObject).ind = paramAppBrandInitConfigWC.appVersion;
      ((sl)localObject).jyG = sl.a.oH(paramAppBrandInitConfigWC.eul + 1);
      ((sl)localObject).jax = (paramAppBrandInitConfigWC.appServiceType + 1000);
      ((sl)localObject).iqr = paramAppBrandStatObject.scene;
      ((sl)localObject).fw(localg.mFH.mFJ);
      ((sl)localObject).fx(localg.mFH.mFR);
      ((sl)localObject).fv(((sl)localObject).jyJ - ((sl)localObject).jyI);
      if (!com.tencent.mm.plugin.appbrand.api.a.qAC) {
        break;
      }
    }
    for (long l = 1L;; l = 0L)
    {
      ((sl)localObject).jyK = l;
      ((sl)localObject).bMH();
      AppMethodBeat.o(322298);
      return;
      ((sp)localObject).ixD = 3L;
      break;
      ((sp)localObject).ixD = 3L;
      break;
      ((sp)localObject).ixD = 4L;
      break;
      ((sp)localObject).ixD = 2L;
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.a.a.a parama)
  {
    AppMethodBeat.i(322502);
    this.ueF.add(parama);
    AppMethodBeat.o(322502);
  }
  
  protected void aA(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void b(com.tencent.mm.plugin.appbrand.platform.window.a.a.a parama)
  {
    AppMethodBeat.i(322505);
    this.ueF.remove(parama);
    AppMethodBeat.o(322505);
  }
  
  public final ab cLq()
  {
    AppMethodBeat.i(48822);
    if (this.udU == null) {
      this.udU = new ab(this);
    }
    ab localab = this.udU;
    AppMethodBeat.o(48822);
    return localab;
  }
  
  public final void cLv()
  {
    this.uet.ufC = true;
  }
  
  public final void cLw()
  {
    this.uet.ufC = false;
  }
  
  public boolean ccf()
  {
    boolean bool = true;
    AppMethodBeat.i(48854);
    if (this.ueG != null)
    {
      bool = this.ueG.booleanValue();
      AppMethodBeat.o(48854);
      return bool;
    }
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    try
    {
      ComponentName localComponentName = getComponentName();
      localObject = localComponentName;
      if (localComponentName == null) {
        localObject = new ComponentName(MMApplicationContext.getContext(), getClass());
      }
      localObject = localPackageManager.getActivityInfo((ComponentName)localObject, 128);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", new Object[] { localException });
        localBoolean = null;
      }
    }
    if (localObject == null)
    {
      AppMethodBeat.o(48854);
      return true;
    }
    Boolean localBoolean;
    if (!MMApplicationContext.getPackageName().equals(localBoolean.taskAffinity)) {}
    for (;;)
    {
      localBoolean = Boolean.valueOf(bool);
      this.ueG = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(48854);
      return bool;
      bool = false;
    }
  }
  
  public final void ctx()
  {
    AppMethodBeat.i(322464);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "forceEnableBackPress");
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((u)com.tencent.mm.ui.component.k.d(this).q(u.class)).cLy();
    AppMethodBeat.o(322464);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(180389);
    Object localObject = this.mRuntimeContainer;
    if (localObject != null)
    {
      localObject = ((ap)localObject).getActiveRuntime();
      if (localObject != null)
      {
        int i = paramKeyEvent.getKeyCode();
        localObject = (Set)((AppBrandRuntime)localObject).qsX.get(i);
        int j;
        if (localObject == null) {
          j = 0;
        }
        while (j != 0)
        {
          AppMethodBeat.o(180389);
          return true;
          localObject = ((Set)localObject).iterator();
          i = 0;
          j = i;
          if (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.plugin.appbrand.ar localar = (com.tencent.mm.plugin.appbrand.ar)((Iterator)localObject).next();
            if ((localar.qxS != -1) && (localar.qxS != paramKeyEvent.getAction())) {
              break label186;
            }
            boolean bool1 = localar.i(paramKeyEvent) | i;
          }
        }
      }
    }
    label186:
    for (;;)
    {
      break;
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandUI", "onKeyDown: keyCode = [%d], keyAction =[%d]", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
      boolean bool2 = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(180389);
      return bool2;
    }
  }
  
  protected void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48844);
    paramAppBrandInitConfigWC.epn = paramAppBrandStatObject;
    if (com.tencent.mm.plugin.appbrand.utils.f.agB(paramAppBrandInitConfigWC.qYj))
    {
      overridePendingTransition(0, 0);
      AppMethodBeat.o(48844);
      return;
    }
    t.ueR.a(this, paramAppBrandInitConfigWC);
    AppMethodBeat.o(48844);
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc_w 1211
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 1214	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:isFinishing	()Z
    //   10: ifne +10 -> 20
    //   13: aload_0
    //   14: invokevirtual 1217	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:isDestroyed	()Z
    //   17: ifeq +10 -> 27
    //   20: ldc_w 1211
    //   23: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_0
    //   28: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   31: invokeinterface 329 1 0
    //   36: checkcast 1219	com/tencent/mm/plugin/appbrand/w
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +15 -> 56
    //   44: aload_1
    //   45: getfield 1223	com/tencent/mm/plugin/appbrand/w:qvN	Lcom/tencent/mm/plugin/appbrand/widget/d/d;
    //   48: iconst_0
    //   49: ldc2_w 1224
    //   52: invokevirtual 1230	com/tencent/mm/plugin/appbrand/widget/d/d:M	(IJ)Landroid/animation/ValueAnimator;
    //   55: pop
    //   56: getstatic 217	com/tencent/mm/plugin/appbrand/task/q:tWE	Lcom/tencent/mm/plugin/appbrand/task/q;
    //   59: astore_1
    //   60: aload_0
    //   61: ldc_w 1231
    //   64: invokestatic 222	com/tencent/mm/plugin/appbrand/task/q:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokestatic 1236	com/tencent/mm/plugin/appbrand/ui/x:m	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   71: aload_0
    //   72: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +305 -> 382
    //   80: aload_0
    //   81: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   84: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   87: checkcast 1238	com/tencent/luggage/sdk/e/d
    //   90: invokevirtual 1242	com/tencent/luggage/sdk/e/d:asA	()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;
    //   93: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   101: invokevirtual 1245	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:ccs	()V
    //   104: aload_0
    //   105: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   108: getstatic 1251	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC$a:quA	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC$a;
    //   111: invokevirtual 1254	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC$a;)V
    //   114: getstatic 1259	android/os/Build$VERSION:SDK_INT	I
    //   117: bipush 21
    //   119: if_icmplt +77 -> 196
    //   122: aload_0
    //   123: invokespecial 1262	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:finishAndRemoveTask	()V
    //   126: aload_0
    //   127: getfield 170	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ueC	Z
    //   130: ifne +8 -> 138
    //   133: aload_0
    //   134: aload_1
    //   135: invokevirtual 1266	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:k	(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V
    //   138: aload_0
    //   139: invokevirtual 557	java/lang/Object:getClass	()Ljava/lang/Class;
    //   142: invokevirtual 1269	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   145: invokestatic 1274	com/tencent/mm/plugin/appbrand/ui/w:doNotify	(Ljava/lang/String;)V
    //   148: aload_0
    //   149: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   152: invokestatic 523	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:P	(Landroid/content/Intent;)Landroid/util/Pair;
    //   155: getfield 526	android/util/Pair:first	Ljava/lang/Object;
    //   158: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   161: getfield 1277	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYf	Ljava/lang/String;
    //   164: astore_1
    //   165: aload_1
    //   166: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +14 -> 183
    //   172: aload_1
    //   173: aload_0
    //   174: invokevirtual 557	java/lang/Object:getClass	()Ljava/lang/Class;
    //   177: invokevirtual 1269	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   180: invokestatic 1280	com/tencent/mm/plugin/appbrand/ui/w:fp	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: ldc_w 1211
    //   186: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -96 -> 97
    //   196: aload_0
    //   197: invokespecial 1281	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:finish	()V
    //   200: goto -74 -> 126
    //   203: astore_1
    //   204: ldc_w 343
    //   207: ldc_w 1283
    //   210: iconst_1
    //   211: anewarray 347	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: aastore
    //   218: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: aload_0
    //   222: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   225: ldc_w 1285
    //   228: invokevirtual 1288	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   231: aload_0
    //   232: invokespecial 1262	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:finishAndRemoveTask	()V
    //   235: aload_0
    //   236: invokevirtual 557	java/lang/Object:getClass	()Ljava/lang/Class;
    //   239: invokevirtual 1269	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   242: invokestatic 1274	com/tencent/mm/plugin/appbrand/ui/w:doNotify	(Ljava/lang/String;)V
    //   245: aload_0
    //   246: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   249: invokestatic 523	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:P	(Landroid/content/Intent;)Landroid/util/Pair;
    //   252: getfield 526	android/util/Pair:first	Ljava/lang/Object;
    //   255: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   258: getfield 1277	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYf	Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +14 -> 280
    //   269: aload_1
    //   270: aload_0
    //   271: invokevirtual 557	java/lang/Object:getClass	()Ljava/lang/Class;
    //   274: invokevirtual 1269	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   277: invokestatic 1280	com/tencent/mm/plugin/appbrand/ui/w:fp	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: ldc_w 1211
    //   283: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: return
    //   287: astore_1
    //   288: ldc_w 1211
    //   291: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore_1
    //   296: ldc_w 343
    //   299: ldc_w 1290
    //   302: iconst_1
    //   303: anewarray 347	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: aload_1
    //   309: aastore
    //   310: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: goto -78 -> 235
    //   316: astore_1
    //   317: aload_0
    //   318: invokevirtual 557	java/lang/Object:getClass	()Ljava/lang/Class;
    //   321: invokevirtual 1269	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   324: invokestatic 1274	com/tencent/mm/plugin/appbrand/ui/w:doNotify	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   331: invokestatic 523	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:P	(Landroid/content/Intent;)Landroid/util/Pair;
    //   334: getfield 526	android/util/Pair:first	Ljava/lang/Object;
    //   337: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   340: getfield 1277	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYf	Ljava/lang/String;
    //   343: astore_2
    //   344: aload_2
    //   345: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +14 -> 362
    //   351: aload_2
    //   352: aload_0
    //   353: invokevirtual 557	java/lang/Object:getClass	()Ljava/lang/Class;
    //   356: invokevirtual 1269	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   359: invokestatic 1280	com/tencent/mm/plugin/appbrand/ui/w:fp	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: ldc_w 1211
    //   365: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: aload_1
    //   369: athrow
    //   370: astore_1
    //   371: ldc_w 1211
    //   374: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: return
    //   378: astore_2
    //   379: goto -17 -> 362
    //   382: aconst_null
    //   383: astore_1
    //   384: goto -270 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	AppBrandUI
    //   39	134	1	localObject1	Object
    //   190	1	1	localException1	Exception
    //   192	1	1	localObject2	Object
    //   203	14	1	localException2	Exception
    //   261	9	1	str1	String
    //   287	1	1	localException3	Exception
    //   295	14	1	localObject3	Object
    //   316	53	1	localObject4	Object
    //   370	1	1	localException4	Exception
    //   383	1	1	localObject5	Object
    //   343	9	2	str2	String
    //   378	1	2	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   80	97	190	java/lang/Exception
    //   71	76	203	java/lang/Exception
    //   97	114	203	java/lang/Exception
    //   114	126	203	java/lang/Exception
    //   126	138	203	java/lang/Exception
    //   196	200	203	java/lang/Exception
    //   138	183	287	java/lang/Exception
    //   221	235	295	finally
    //   71	76	316	finally
    //   80	97	316	finally
    //   97	114	316	finally
    //   114	126	316	finally
    //   126	138	316	finally
    //   196	200	316	finally
    //   204	221	316	finally
    //   296	313	316	finally
    //   235	280	370	java/lang/Exception
    //   317	362	378	java/lang/Exception
  }
  
  public final AppBrandInitConfigWC getInitConfig()
  {
    AppMethodBeat.i(322446);
    try
    {
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)P(getIntent()).first;
      AppMethodBeat.o(322446);
      return localAppBrandInitConfigWC;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(322446);
    }
    return null;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(322414);
    LayoutInflater localLayoutInflater = cLt();
    AppMethodBeat.o(322414);
    return localLayoutInflater;
  }
  
  public final String getLocalClassName()
  {
    AppMethodBeat.i(48820);
    if (getComponentName() != null)
    {
      str1 = super.getLocalClassName();
      AppMethodBeat.o(48820);
      return str1;
    }
    String str1 = MMApplicationContext.getPackageName();
    String str2 = getClass().getName();
    int i = str1.length();
    if ((!str2.startsWith(str1)) || (str2.length() <= i) || (str2.charAt(i) != '.'))
    {
      AppMethodBeat.o(48820);
      return str2;
    }
    str1 = str2.substring(i + 1);
    AppMethodBeat.o(48820);
    return str1;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(161868);
    if (this.mResources == null) {
      this.mResources = super.getResources();
    }
    Resources localResources = this.mResources;
    AppMethodBeat.o(161868);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(48821);
    if ("layout_inflater".equals(paramString))
    {
      paramString = cLt();
      AppMethodBeat.o(48821);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48821);
    return paramString;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(322559);
    HashSet local2 = new HashSet() {};
    AppMethodBeat.o(322559);
    return local2;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(48843);
    AppMethodBeat.o(48843);
  }
  
  public final void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(48842);
    if ((paramIntent == null) || (paramIntent.getComponent() == null) || (!paramIntent.getComponent().getClassName().endsWith(getLocalClassName())))
    {
      if ((paramIntent != null) && (paramIntent.getComponent() != null) && (com.tencent.mm.ui.base.b.bzY(com.tencent.mm.ui.base.b.f(paramIntent.getComponent()))))
      {
        com.tencent.mm.ui.base.b.ng(this);
        AppMethodBeat.o(48842);
        return;
      }
      super.initActivityOpenAnimation(paramIntent);
    }
    AppMethodBeat.o(48842);
  }
  
  protected void k(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(322518);
    t.ueR.b(this, paramAppBrandInitConfigWC);
    AppMethodBeat.o(322518);
  }
  
  public final boolean moveTaskToBack(boolean paramBoolean)
  {
    AppMethodBeat.i(48847);
    Object localObject1 = q.tWE;
    q.b(this, String.format(Locale.ENGLISH, "moveTaskToBack(%b)", new Object[] { Boolean.valueOf(paramBoolean) }));
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "moveTaskToBack stack:" + android.util.Log.getStackTraceString(new Throwable()));
    x.m(this);
    try
    {
      paramBoolean = super.moveTaskToBack(paramBoolean);
      boolean bool = this.ueC;
      if (!bool) {}
      try
      {
        localObject1 = (AppBrandInitConfigWC)this.mRuntimeContainer.getActiveRuntime().asH();
        k((AppBrandInitConfigWC)localObject1);
        AppMethodBeat.o(48847);
        return paramBoolean;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
      return true;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "moveTaskToBack() get exception %s, invoke finish()", new Object[] { localNullPointerException });
      finish();
      AppMethodBeat.o(48847);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48853);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.luggage.l.e.bt(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && ("jsapi_pay_onActivityResult".equals(paramIntent.getStringExtra("key_jsapi_pay_onActivityResult"))) && (paramInt2 == 5)) {
      com.tencent.mm.ui.base.k.a(this, paramIntent.getStringExtra("key_jsapi_pay_err_msg"), "", paramIntent.getStringExtra("key_jsapi_pay_err_dialog_confirm"), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(48853);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48849);
    q localq = q.tWE;
    q.b(this, "onBackPressed");
    super.onBackPressed();
    AppMethodBeat.o(48849);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(48831);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onConfigurationChanged newConfig: %s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    super.onConfigurationChanged(paramConfiguration);
    Object localObject1;
    int i;
    if (this.tAl != null)
    {
      localObject1 = this.tAl;
      if ((paramConfiguration.smallestScreenWidthDp != ((Configuration)localObject1).smallestScreenWidthDp) && (AppBrandRuntimeWCAccessible.isGame(this.mRuntimeContainer.getActiveRuntime()))) {}
      for (i = 1; i != 0; i = 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onConfigurationChanged by fold or unfold, last.smallestScreenWidthDp[%d], new.smallestScreenWidthDp[%d]", new Object[] { Integer.valueOf(this.tAl.smallestScreenWidthDp), Integer.valueOf(paramConfiguration.smallestScreenWidthDp) });
        di("multiWindowMode", 1);
        AppMethodBeat.o(48831);
        return;
      }
    }
    Object localObject2;
    if (this.tAl != null)
    {
      localObject1 = this.tAl;
      localObject2 = (w)this.mRuntimeContainer.getActiveRuntime();
      if ((localObject2 == null) || (((w)localObject2).getAppConfig() == null)) {
        break label469;
      }
    }
    label306:
    label469:
    for (boolean bool1 = ((w)localObject2).getAppConfig().cks();; bool1 = false)
    {
      boolean bool2;
      if ((paramConfiguration.uiMode & 0x30) != (((Configuration)localObject1).uiMode & 0x30))
      {
        bool2 = true;
        boolean bool3 = aw.aXj();
        boolean bool4 = aw.aXo();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "darkModeThemeChanged  isDarkModeSupportForCurrentWxa=%b  isNightModeEnableForWeChat=%b  isDarkModeFollowSystem=%b  nightModeChanged=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
        if ((!bool1) || (!bool3) || (!bool2) || (!bool4)) {
          break label363;
        }
        localObject2 = new StringBuilder("Theme change into ");
        if (32 != (paramConfiguration.uiMode & 0x30)) {
          break label355;
        }
        localObject1 = "NIGHT";
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", (String)localObject1 + " mode");
      }
      label355:
      label363:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label368;
        }
        di("darkModeTheme", 2);
        AppMethodBeat.o(48831);
        return;
        bool2 = false;
        break;
        localObject1 = "DAY";
        break label306;
      }
      label368:
      this.tAl = new Configuration(paramConfiguration);
      localObject1 = this.ues;
      if (paramConfiguration != null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
        ((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).cQw();
      }
      this.mRuntimeContainer.dispatchConfigurationChanged(paramConfiguration);
      localObject1 = this.mRuntimeContainer.getActiveRuntime();
      if (localObject1 != null) {
        try
        {
          ((AppBrandRuntime)localObject1).getPageContainer().getCurrentPage().onConfigurationChanged(paramConfiguration);
          AppMethodBeat.o(48831);
          return;
        }
        catch (NullPointerException paramConfiguration) {}
      }
      AppMethodBeat.o(48831);
      return;
    }
  }
  
  /* Error */
  public void onCreate(final Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1524
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   9: lstore_3
    //   10: getstatic 217	com/tencent/mm/plugin/appbrand/task/q:tWE	Lcom/tencent/mm/plugin/appbrand/task/q;
    //   13: astore 5
    //   15: getstatic 1371	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   18: astore 6
    //   20: aload_1
    //   21: ifnonnull +201 -> 222
    //   24: ldc_w 1526
    //   27: astore 5
    //   29: aload_0
    //   30: aload 6
    //   32: ldc_w 1528
    //   35: iconst_1
    //   36: anewarray 347	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload 5
    //   43: aastore
    //   44: invokestatic 1377	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokestatic 222	com/tencent/mm/plugin/appbrand/task/q:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokestatic 1533	com/tencent/mm/plugin/appbrand/ui/ac:cLF	()I
    //   54: invokevirtual 1536	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:setTheme	(I)V
    //   57: invokestatic 1541	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:cls	()Z
    //   60: ifne +26 -> 86
    //   63: ldc 99
    //   65: invokestatic 105	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   68: checkcast 99	com/tencent/mm/plugin/expt/b/c
    //   71: getstatic 1544	com/tencent/mm/plugin/expt/b/c$a:yOV	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   74: iconst_0
    //   75: invokeinterface 115 3 0
    //   80: ifle +6 -> 86
    //   83: invokestatic 1549	com/tencent/mm/sdk/platformtools/AccessibilityUtil:smartDisableAccessibility	()V
    //   86: ldc_w 1551
    //   89: new 16	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$1
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: invokespecial 1553	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$1:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Landroid/os/Bundle;)V
    //   98: invokestatic 1558	com/tencent/luggage/sdk/h/d:a	(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/String;
    //   101: pop
    //   102: aload_1
    //   103: ifnull +78 -> 181
    //   106: aload_1
    //   107: ldc_w 1560
    //   110: invokevirtual 1563	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   113: ifeq +68 -> 181
    //   116: aload_1
    //   117: ldc_w 1560
    //   120: invokevirtual 298	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   123: checkcast 267	android/content/Intent
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +51 -> 181
    //   133: aload_0
    //   134: invokevirtual 1565	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ccf	()Z
    //   137: ifne +169 -> 306
    //   140: iconst_0
    //   141: istore_2
    //   142: aconst_null
    //   143: astore_1
    //   144: iload_2
    //   145: ifeq +36 -> 181
    //   148: ldc_w 343
    //   151: ldc_w 1567
    //   154: iconst_2
    //   155: anewarray 347	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   164: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload_1
    //   171: aastore
    //   172: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_0
    //   176: aload 5
    //   178: invokevirtual 548	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:setIntent	(Landroid/content/Intent;)V
    //   181: aload_0
    //   182: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   185: ifnonnull +218 -> 403
    //   188: ldc_w 343
    //   191: ldc_w 1572
    //   194: iconst_1
    //   195: anewarray 347	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_0
    //   201: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   204: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   215: ldc_w 1524
    //   218: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: aload_1
    //   223: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   226: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: astore 5
    //   231: goto -202 -> 29
    //   234: astore 5
    //   236: ldc_w 343
    //   239: aload 5
    //   241: ldc_w 1574
    //   244: iconst_1
    //   245: anewarray 347	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_0
    //   251: invokevirtual 483	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLocalClassName	()Ljava/lang/String;
    //   254: aastore
    //   255: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: ldc_w 259
    //   261: ldc_w 1576
    //   264: invokevirtual 1580	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   267: astore 5
    //   269: aload 5
    //   271: iconst_1
    //   272: invokevirtual 1586	java/lang/reflect/Field:setAccessible	(Z)V
    //   275: aload 5
    //   277: aload_0
    //   278: invokevirtual 1588	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   281: checkcast 235	java/lang/Boolean
    //   284: invokevirtual 830	java/lang/Boolean:booleanValue	()Z
    //   287: ifne +8 -> 295
    //   290: aload_0
    //   291: aload_1
    //   292: invokespecial 443	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:onCreate	(Landroid/os/Bundle;)V
    //   295: aload_0
    //   296: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   299: ldc_w 1524
    //   302: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: return
    //   306: aload_0
    //   307: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   310: ifnonnull +12 -> 322
    //   313: iconst_1
    //   314: istore_2
    //   315: ldc_w 1590
    //   318: astore_1
    //   319: goto -175 -> 144
    //   322: aload_0
    //   323: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   326: invokestatic 523	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:P	(Landroid/content/Intent;)Landroid/util/Pair;
    //   329: getfield 526	android/util/Pair:first	Ljava/lang/Object;
    //   332: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   335: astore_1
    //   336: aload 5
    //   338: invokestatic 523	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:P	(Landroid/content/Intent;)Landroid/util/Pair;
    //   341: getfield 526	android/util/Pair:first	Ljava/lang/Object;
    //   344: checkcast 280	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   347: getfield 1591	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:startTime	J
    //   350: aload_1
    //   351: getfield 1591	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:startTime	J
    //   354: lcmp
    //   355: ifle +12 -> 367
    //   358: iconst_1
    //   359: istore_2
    //   360: ldc_w 1593
    //   363: astore_1
    //   364: goto -220 -> 144
    //   367: iconst_0
    //   368: istore_2
    //   369: goto -9 -> 360
    //   372: astore_1
    //   373: ldc_w 343
    //   376: ldc_w 1595
    //   379: iconst_2
    //   380: anewarray 347	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: aload_0
    //   386: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   389: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: aload_1
    //   396: aastore
    //   397: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: goto -219 -> 181
    //   403: ldc_w 343
    //   406: ldc_w 1597
    //   409: iconst_3
    //   410: anewarray 347	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_0
    //   416: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   419: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: aload_0
    //   426: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   429: invokevirtual 695	android/content/Intent:getFlags	()I
    //   432: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   435: aastore
    //   436: dup
    //   437: iconst_2
    //   438: invokestatic 577	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   441: lload_3
    //   442: lsub
    //   443: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   446: aastore
    //   447: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: aload_0
    //   451: iconst_1
    //   452: putfield 156	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uev	Z
    //   455: new 1379	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 1599
    //   462: invokespecial 1382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: aload_0
    //   466: invokevirtual 483	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLocalClassName	()Ljava/lang/String;
    //   469: invokevirtual 1395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 1396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: new 28	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$5
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 1600	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$5:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   483: invokestatic 1558	com/tencent/luggage/sdk/h/d:a	(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/String;
    //   486: pop
    //   487: aload_0
    //   488: invokestatic 1603	com/tencent/mm/plugin/appbrand/ui/x:l	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   491: aload_0
    //   492: aload_0
    //   493: invokevirtual 521	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   496: ldc_w 1604
    //   499: invokespecial 1606	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:e	(Landroid/content/Intent;Ljava/lang/String;)V
    //   502: getstatic 1612	com/tencent/mm/plugin/appbrand/performance/h$a:tEa	Lcom/tencent/mm/plugin/appbrand/performance/h;
    //   505: astore_1
    //   506: invokestatic 1617	java/lang/System:currentTimeMillis	()J
    //   509: ldc2_w 1224
    //   512: lrem
    //   513: lconst_1
    //   514: lcmp
    //   515: ifeq +21 -> 536
    //   518: invokestatic 1622	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   521: ifne +15 -> 536
    //   524: invokestatic 1625	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
    //   527: ifne +9 -> 536
    //   530: getstatic 1628	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   533: ifeq +108 -> 641
    //   536: iconst_1
    //   537: istore_2
    //   538: iload_2
    //   539: ifeq +32 -> 571
    //   542: ldc_w 1630
    //   545: ldc_w 1632
    //   548: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload_1
    //   552: new 1634	com/tencent/mm/plugin/appbrand/performance/h$1
    //   555: dup
    //   556: aload_1
    //   557: invokespecial 1637	com/tencent/mm/plugin/appbrand/performance/h$1:<init>	(Lcom/tencent/mm/plugin/appbrand/performance/h;)V
    //   560: putfield 1643	com/tencent/mm/plugin/appbrand/performance/h:hoG	Landroid/content/ComponentCallbacks2;
    //   563: aload_0
    //   564: aload_1
    //   565: getfield 1643	com/tencent/mm/plugin/appbrand/performance/h:hoG	Landroid/content/ComponentCallbacks2;
    //   568: invokevirtual 1647	android/content/Context:registerComponentCallbacks	(Landroid/content/ComponentCallbacks;)V
    //   571: aload_0
    //   572: invokevirtual 804	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLifecycle	()Landroidx/lifecycle/j;
    //   575: aload_0
    //   576: getfield 154	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uet	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate;
    //   579: invokevirtual 813	androidx/lifecycle/j:addObserver	(Landroidx/lifecycle/p;)V
    //   582: aload_0
    //   583: invokevirtual 507	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getContentView	()Landroid/view/View;
    //   586: instanceof 1649
    //   589: ifeq +17 -> 606
    //   592: aload_0
    //   593: invokevirtual 507	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getContentView	()Landroid/view/View;
    //   596: checkcast 1649	com/tencent/mm/plugin/appbrand/ui/wxa_container/a
    //   599: aload_0
    //   600: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   603: invokevirtual 1653	com/tencent/mm/plugin/appbrand/ui/wxa_container/a:setRuntimeContainer	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;)V
    //   606: aload_0
    //   607: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   610: invokeinterface 329 1 0
    //   615: checkcast 1219	com/tencent/mm/plugin/appbrand/w
    //   618: astore_1
    //   619: aload_1
    //   620: ifnull +14 -> 634
    //   623: aload_1
    //   624: getfield 1223	com/tencent/mm/plugin/appbrand/w:qvN	Lcom/tencent/mm/plugin/appbrand/widget/d/d;
    //   627: ldc2_w 1224
    //   630: invokevirtual 1657	com/tencent/mm/plugin/appbrand/widget/d/d:jW	(J)Landroid/animation/ValueAnimator;
    //   633: pop
    //   634: ldc_w 1524
    //   637: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   640: return
    //   641: iconst_0
    //   642: istore_2
    //   643: goto -105 -> 538
    //   646: astore_1
    //   647: goto -352 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	AppBrandUI
    //   0	650	1	paramBundle	Bundle
    //   141	502	2	i	int
    //   9	433	3	l	long
    //   13	217	5	localObject	Object
    //   234	6	5	localThrowable	Throwable
    //   267	70	5	localField	java.lang.reflect.Field
    //   18	13	6	localLocale	Locale
    // Exception table:
    //   from	to	target	type
    //   86	102	234	finally
    //   116	128	372	java/lang/Exception
    //   133	140	372	java/lang/Exception
    //   148	181	372	java/lang/Exception
    //   306	313	372	java/lang/Exception
    //   322	358	372	java/lang/Exception
    //   258	295	646	java/lang/Exception
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48850);
    super.onCreateBeforeSetContentView();
    com.tencent.mm.plugin.appbrand.widget.input.a locala = this.ues;
    if ((locala.activity == null) || (locala.activity.getWindow() == null))
    {
      AppMethodBeat.o(48850);
      return;
    }
    locala.activity.getWindow().setSoftInputMode(16);
    AppMethodBeat.o(48850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48848);
    Object localObject = q.tWE;
    q.b(this, "onDestroy");
    x.m(this);
    if ((!this.uez) && (!isChangingConfigurations()) && (this.mRuntimeContainer != null)) {
      this.mRuntimeContainer.a(AppBrandRuntimeContainerWC.a.quB);
    }
    if (this.mRuntimeContainer != null) {
      this.mRuntimeContainer.cleanup();
    }
    if (this.ueu != null) {
      localObject = this.ueu;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(((com.tencent.mm.plugin.appbrand.b.e)localObject).bJm);
      if (this.ueE != null) {
        this.ueE.dismiss();
      }
      super.onDestroy();
      ((ViewGroup)getContentView()).removeAllViews();
      localObject = h.a.tEa;
      if (((com.tencent.mm.plugin.appbrand.performance.h)localObject).hoG != null) {
        unregisterComponentCallbacks(((com.tencent.mm.plugin.appbrand.performance.h)localObject).hoG);
      }
      com.tencent.luggage.l.e.bu(this);
      AndroidContextUtil.fixInputMethodManagerLeak(this);
      AppMethodBeat.o(48848);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = ".concat(String.valueOf(localException)));
      }
    }
  }
  
  public void onEnterAnimationComplete()
  {
    AppMethodBeat.i(48834);
    Object localObject1 = q.tWE;
    q.b(this, "onEnterAnimationComplete");
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    ((u)com.tencent.mm.ui.component.k.d(this).q(u.class)).cLy();
    if (this.mRuntimeContainer != null)
    {
      localObject1 = this.mRuntimeContainer;
      if (((AppBrandRuntimeContainerWC)localObject1).getStackSize() == 1) {
        ((w)((AppBrandRuntimeContainerWC)localObject1).getActiveRuntime()).onEnterAnimationComplete();
      }
    }
    try
    {
      localObject1 = v.ufg;
      v.fp(MainProcessIPCService.PROCESS_NAME, getClass().getCanonicalName());
      localObject1 = ((AppBrandInitConfigWC)P(getIntent()).first).qYf;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        v localv = v.ufg;
        v.fp((String)localObject1, getClass().getCanonicalName());
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(48834);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48825);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onNewIntent %s, %d, isFinishing:%b", new Object[] { paramIntent, Integer.valueOf(hashCode()), Boolean.valueOf(isFinishing()) });
    Object localObject = q.tWE;
    q.b(this, "onNewIntent");
    if ((isFinishing()) || (isDestroyed()) || (paramIntent == null))
    {
      AppMethodBeat.o(48825);
      return;
    }
    this.uew = true;
    if (paramIntent.getBooleanExtra("key_appbrand_bring_ui_to_front", false))
    {
      cLu();
      AppMethodBeat.o(48825);
      return;
    }
    x.l(this);
    int i;
    if (paramIntent.getParcelableExtra("key_appbrand_init_config") != null)
    {
      i = 1;
      if (i != 0) {
        break label180;
      }
      if (this.mRuntimeContainer != null) {
        break label162;
      }
    }
    label162:
    for (localObject = null;; localObject = this.mRuntimeContainer.getActiveRuntime())
    {
      if ((localObject == null) || (!com.tencent.mm.plugin.appbrand.k.b(((AppBrandRuntime)localObject).mAppId, paramIntent))) {
        break label173;
      }
      AppMethodBeat.o(48825);
      return;
      i = 0;
      break;
    }
    label173:
    AppMethodBeat.o(48825);
    return;
    try
    {
      label180:
      super.onNewIntent(paramIntent);
      com.tencent.mm.ui.base.b.bZ(this);
      e(paramIntent, "onNewIntent");
      AppMethodBeat.o(48825);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUI", paramIntent, "%s.onNewIntent", new Object[] { getLocalClassName() });
      cLu();
      AppMethodBeat.o(48825);
    }
  }
  
  /* Error */
  public void onPause()
  {
    // Byte code:
    //   0: ldc_w 1772
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 217	com/tencent/mm/plugin/appbrand/task/q:tWE	Lcom/tencent/mm/plugin/appbrand/task/q;
    //   9: astore_1
    //   10: aload_0
    //   11: ldc_w 1773
    //   14: invokestatic 222	com/tencent/mm/plugin/appbrand/task/q:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokespecial 1775	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:onPause	()V
    //   21: aload_0
    //   22: new 42	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$9
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 1776	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$9:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   30: invokestatic 1781	com/tencent/mm/plugin/appbrand/ui/af:c	(Landroid/content/Context;Lkotlin/g/a/b;)V
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 156	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uev	Z
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 158	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uew	Z
    //   43: aload_0
    //   44: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   47: astore_1
    //   48: ldc_w 1783
    //   51: ldc_w 1785
    //   54: iconst_1
    //   55: anewarray 347	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: invokestatic 188	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   63: invokevirtual 1788	java/lang/Thread:getId	()J
    //   66: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: aastore
    //   70: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_1
    //   74: new 1790	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainer$7
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 1793	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainer$7:<init>	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainer;)V
    //   82: invokevirtual 1799	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainer:runOnUiThread	(Ljava/lang/Runnable;)V
    //   85: aload_0
    //   86: invokestatic 1805	com/tencent/mm/plugin/appbrand/platform/window/a/h:L	(Landroid/app/Activity;)Lcom/tencent/mm/plugin/appbrand/platform/window/a/h;
    //   89: astore_1
    //   90: aload_1
    //   91: getfield 1808	com/tencent/mm/plugin/appbrand/platform/window/a/h:djQ	Ljava/lang/String;
    //   94: ldc_w 1773
    //   97: invokestatic 1810	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: getfield 1814	com/tencent/mm/plugin/appbrand/platform/window/a/h:tMe	Lcom/tencent/mm/plugin/appbrand/utils/ak;
    //   104: invokevirtual 1819	com/tencent/mm/plugin/appbrand/utils/ak:disable	()V
    //   107: aload_0
    //   108: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   111: invokeinterface 329 1 0
    //   116: invokestatic 1824	com/tencent/mm/plugin/appbrand/ad/e:O	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V
    //   119: aload_0
    //   120: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   123: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   126: ifnull +40 -> 166
    //   129: iconst_4
    //   130: new 1379	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 1826
    //   137: invokespecial 1382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   144: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   147: checkcast 1238	com/tencent/luggage/sdk/e/d
    //   150: getfield 335	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   153: invokevirtual 1395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 1396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: aload_0
    //   160: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   163: invokestatic 1831	com/tencent/mm/modelstat/d:d	(ILjava/lang/String;I)V
    //   166: aload_0
    //   167: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   170: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   173: invokestatic 1460	com/tencent/mm/plugin/appbrand/AppBrandRuntimeWCAccessible:isGame	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)Z
    //   176: ifeq +126 -> 302
    //   179: getstatic 1837	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   182: ldc_w 1839
    //   185: invokevirtual 1842	com/tencent/mm/plugin/normsg/a/d:aQn	(Ljava/lang/String;)Z
    //   188: ifeq +12 -> 200
    //   191: getstatic 1837	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   194: ldc_w 1839
    //   197: invokevirtual 1845	com/tencent/mm/plugin/normsg/a/d:aQm	(Ljava/lang/String;)V
    //   200: getstatic 1837	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   203: ldc_w 1839
    //   206: invokevirtual 1849	com/tencent/mm/plugin/normsg/a/d:aQo	(Ljava/lang/String;)[B
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +91 -> 302
    //   214: new 1851	com/tencent/mm/protocal/protobuf/gdd
    //   217: dup
    //   218: invokespecial 1852	com/tencent/mm/protocal/protobuf/gdd:<init>	()V
    //   221: astore_2
    //   222: aload_2
    //   223: new 1854	com/tencent/mm/protocal/protobuf/gol
    //   226: dup
    //   227: invokespecial 1855	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   230: aload_1
    //   231: invokevirtual 1859	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   234: putfield 1863	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   237: aload_2
    //   238: invokevirtual 1867	com/tencent/mm/protocal/protobuf/gdd:toByteArray	()[B
    //   241: astore_1
    //   242: ldc_w 343
    //   245: ldc_w 1869
    //   248: iconst_1
    //   249: anewarray 347	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_1
    //   255: arraylength
    //   256: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aastore
    //   260: invokestatic 1872	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   263: invokestatic 1810	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: getstatic 1878	com/tencent/mm/plugin/secinforeport/a/d:Pmb	Lcom/tencent/mm/plugin/secinforeport/a/d;
    //   269: ldc_w 1879
    //   272: aload_1
    //   273: invokevirtual 1883	com/tencent/mm/plugin/secinforeport/a/d:t	(I[B)V
    //   276: ldc_w 1772
    //   279: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: astore_1
    //   284: ldc_w 343
    //   287: aload_1
    //   288: ldc_w 1885
    //   291: iconst_0
    //   292: anewarray 347	java/lang/Object
    //   295: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: goto -132 -> 166
    //   301: astore_1
    //   302: ldc_w 1772
    //   305: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	AppBrandUI
    //   9	264	1	localObject1	Object
    //   283	5	1	localThrowable	Throwable
    //   301	1	1	localObject2	Object
    //   221	17	2	localgdd	com.tencent.mm.protocal.protobuf.gdd
    // Exception table:
    //   from	to	target	type
    //   119	166	283	finally
    //   214	276	301	finally
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(48852);
    Iterator localIterator = this.mRuntimeContainer.qub.iterator();
    while (localIterator.hasNext()) {
      com.tencent.mm.plugin.appbrand.permission.s.a(((AppBrandRuntime)localIterator.next()).mAppId, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    com.tencent.luggage.l.e.bt(this).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(48852);
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: ldc_w 1905
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 217	com/tencent/mm/plugin/appbrand/task/q:tWE	Lcom/tencent/mm/plugin/appbrand/task/q;
    //   9: astore_2
    //   10: aload_0
    //   11: ldc_w 1906
    //   14: invokestatic 222	com/tencent/mm/plugin/appbrand/task/q:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   17: ldc_w 1908
    //   20: new 40	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$8
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 1909	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$8:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   28: invokestatic 1558	com/tencent/luggage/sdk/h/d:a	(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/String;
    //   31: pop
    //   32: ldc_w 343
    //   35: ldc_w 1911
    //   38: iconst_1
    //   39: anewarray 347	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   48: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: invokevirtual 1565	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ccf	()Z
    //   59: ifeq +245 -> 304
    //   62: aload_0
    //   63: getfield 156	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uev	Z
    //   66: ifne +238 -> 304
    //   69: aload_0
    //   70: getfield 158	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uew	Z
    //   73: ifne +231 -> 304
    //   76: iconst_2
    //   77: istore_1
    //   78: aload_0
    //   79: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   82: invokeinterface 329 1 0
    //   87: checkcast 1219	com/tencent/mm/plugin/appbrand/w
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +38 -> 130
    //   95: ldc_w 343
    //   98: ldc_w 1913
    //   101: iconst_2
    //   102: anewarray 347	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: getfield 335	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: iload_1
    //   115: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_2
    //   123: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   126: iload_1
    //   127: putfield 734	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:qYn	I
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 158	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uew	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 156	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uev	Z
    //   140: aload_0
    //   141: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   144: invokevirtual 1916	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:onResume	()V
    //   147: aload_0
    //   148: invokestatic 1805	com/tencent/mm/plugin/appbrand/platform/window/a/h:L	(Landroid/app/Activity;)Lcom/tencent/mm/plugin/appbrand/platform/window/a/h;
    //   151: astore_2
    //   152: aload_2
    //   153: getfield 1808	com/tencent/mm/plugin/appbrand/platform/window/a/h:djQ	Ljava/lang/String;
    //   156: ldc_w 1906
    //   159: invokestatic 1810	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: getfield 1814	com/tencent/mm/plugin/appbrand/platform/window/a/h:tMe	Lcom/tencent/mm/plugin/appbrand/utils/ak;
    //   166: invokevirtual 1919	com/tencent/mm/plugin/appbrand/utils/ak:enable	()V
    //   169: aload_0
    //   170: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   173: invokeinterface 329 1 0
    //   178: invokestatic 1922	com/tencent/mm/plugin/appbrand/ad/e:N	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V
    //   181: aload_0
    //   182: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   185: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   188: ifnull +40 -> 228
    //   191: iconst_3
    //   192: new 1379	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 1826
    //   199: invokespecial 1382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   206: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   209: checkcast 1238	com/tencent/luggage/sdk/e/d
    //   212: getfield 335	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   215: invokevirtual 1395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 1396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aload_0
    //   222: invokevirtual 1570	java/lang/Object:hashCode	()I
    //   225: invokestatic 1831	com/tencent/mm/modelstat/d:d	(ILjava/lang/String;I)V
    //   228: aload_0
    //   229: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   232: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   235: invokestatic 1460	com/tencent/mm/plugin/appbrand/AppBrandRuntimeWCAccessible:isGame	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)Z
    //   238: ifeq +27 -> 265
    //   241: aload_0
    //   242: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   245: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   248: checkcast 1238	com/tencent/luggage/sdk/e/d
    //   251: getfield 335	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   254: astore_2
    //   255: getstatic 1837	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   258: ldc_w 1839
    //   261: aload_2
    //   262: invokevirtual 1925	com/tencent/mm/plugin/normsg/a/d:kI	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: getstatic 217	com/tencent/mm/plugin/appbrand/task/q:tWE	Lcom/tencent/mm/plugin/appbrand/task/q;
    //   268: astore_2
    //   269: aload_0
    //   270: ldc_w 1927
    //   273: invokestatic 222	com/tencent/mm/plugin/appbrand/task/q:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   276: ldc_w 1905
    //   279: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: astore_2
    //   284: ldc_w 343
    //   287: ldc_w 1929
    //   290: invokestatic 1726	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokevirtual 500	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   297: ldc_w 1905
    //   300: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: iconst_0
    //   305: istore_1
    //   306: goto -228 -> 78
    //   309: astore_2
    //   310: ldc_w 343
    //   313: aload_2
    //   314: ldc_w 1885
    //   317: iconst_0
    //   318: anewarray 347	java/lang/Object
    //   321: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -96 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	AppBrandUI
    //   77	229	1	i	int
    //   9	260	2	localObject	Object
    //   283	1	2	localBadParcelableException	android.os.BadParcelableException
    //   309	5	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   17	32	283	android/os/BadParcelableException
    //   181	228	309	finally
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(322532);
    super.onSaveInstanceState(paramBundle);
    q localq = q.tWE;
    q.b(this, "onSaveInstanceState");
    try
    {
      P(getIntent());
      paramBundle.putParcelable("com.tencent.mm.plugin.appbrand.ui.AppBrandUI.SAVED_INSTANCE_STATE_KEY_OVERRIDE_INTENT", getIntent());
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onSaveInstanceState override intent is saved, instance:%d", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(322532);
      return;
    }
    catch (Exception paramBundle)
    {
      AppMethodBeat.o(322532);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(48837);
    Object localObject = q.tWE;
    q.b(this, "onStart");
    super.onStart();
    localObject = (w)this.mRuntimeContainer.getActiveRuntime();
    if (localObject != null)
    {
      z localz = z.ufw;
      localObject = ((AppBrandRuntime)localObject).mAppId;
      kotlin.g.b.s.u(localObject, "appId");
      z.agi((String)localObject);
    }
    localObject = q.tWE;
    q.b(this, "onStarted");
    AppMethodBeat.o(48837);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(322487);
    q localq = q.tWE;
    q.b(this, "onStop");
    super.onStop();
    this.mRuntimeContainer.onStop();
    AppMethodBeat.o(322487);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(48835);
    super.onWindowAttributesChanged(paramLayoutParams);
    if (this.mRuntimeContainer != null) {
      this.mRuntimeContainer.b(paramLayoutParams);
    }
    AppMethodBeat.o(48835);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(48838);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    q localq = q.tWE;
    q.b(this, "onWindowFocusChanged:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(48838);
  }
  
  public void recreate()
  {
    AppMethodBeat.i(322529);
    q localq = q.tWE;
    q.b(this, "recreate");
    super.recreate();
    AppMethodBeat.o(322529);
  }
  
  /* Error */
  public void setRequestedOrientation(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1996
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 179	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ueF	Ljava/util/Set;
    //   10: invokeinterface 1999 1 0
    //   15: ifle +110 -> 125
    //   18: new 1894	java/util/LinkedList
    //   21: dup
    //   22: aload_0
    //   23: getfield 179	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ueF	Ljava/util/Set;
    //   26: invokespecial 2002	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokeinterface 2005 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 1169 1 0
    //   47: ifeq +78 -> 125
    //   50: aload 5
    //   52: invokeinterface 1173 1 0
    //   57: checkcast 2007	com/tencent/mm/plugin/appbrand/platform/window/a/a$a
    //   60: astore 6
    //   62: aload 6
    //   64: iload_1
    //   65: invokeinterface 2011 2 0
    //   70: ifeq -30 -> 40
    //   73: ldc_w 343
    //   76: ldc_w 2013
    //   79: iconst_4
    //   80: anewarray 347	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: invokevirtual 483	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLocalClassName	()Ljava/lang/String;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: iload_1
    //   93: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: aload 4
    //   101: invokeinterface 2014 1 0
    //   106: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_3
    //   112: aload 6
    //   114: aastore
    //   115: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: ldc_w 1996
    //   121: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: aload_0
    //   126: invokevirtual 1214	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:isFinishing	()Z
    //   129: ifne +10 -> 139
    //   132: aload_0
    //   133: invokevirtual 1217	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:isDestroyed	()Z
    //   136: ifeq +15 -> 151
    //   139: aload_0
    //   140: iload_1
    //   141: invokespecial 2016	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:setRequestedOrientation	(I)V
    //   144: ldc_w 1996
    //   147: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: aload_0
    //   152: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   155: ifnull +222 -> 377
    //   158: aload_0
    //   159: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   162: invokeinterface 329 1 0
    //   167: instanceof 1219
    //   170: ifeq +207 -> 377
    //   173: aload_0
    //   174: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   177: invokeinterface 329 1 0
    //   182: checkcast 1219	com/tencent/mm/plugin/appbrand/w
    //   185: astore 4
    //   187: aload 4
    //   189: ifnull +194 -> 383
    //   192: aload 4
    //   194: getfield 2020	com/tencent/mm/plugin/appbrand/AppBrandRuntime:qsE	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   197: invokevirtual 2024	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   200: ifne +183 -> 383
    //   203: aload 4
    //   205: getfield 2027	com/tencent/mm/plugin/appbrand/AppBrandRuntime:ccV	Z
    //   208: ifne +175 -> 383
    //   211: aload 4
    //   213: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   216: ifnull +167 -> 383
    //   219: aload 4
    //   221: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   224: getfield 599	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:epj	Lcom/tencent/luggage/sdk/config/AppBrandInitWindowConfig;
    //   227: ifnull +156 -> 383
    //   230: aload 4
    //   232: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   235: getfield 599	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:epj	Lcom/tencent/luggage/sdk/config/AppBrandInitWindowConfig;
    //   238: getfield 2030	com/tencent/luggage/sdk/config/AppBrandInitWindowConfig:eps	Z
    //   241: ifeq +142 -> 383
    //   244: iconst_1
    //   245: istore_3
    //   246: iload_1
    //   247: istore_2
    //   248: iload_3
    //   249: ifeq +24 -> 273
    //   252: iconst_m1
    //   253: iload_1
    //   254: if_icmpne +155 -> 409
    //   257: aload_0
    //   258: invokevirtual 677	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getResources	()Landroid/content/res/Resources;
    //   261: invokevirtual 254	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   264: getfield 1449	android/content/res/Configuration:orientation	I
    //   267: iconst_1
    //   268: if_icmpne +120 -> 388
    //   271: iconst_1
    //   272: istore_2
    //   273: aload 4
    //   275: ifnull +43 -> 318
    //   278: aload 4
    //   280: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   283: ifnull +35 -> 318
    //   286: aload 4
    //   288: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   291: getfield 2034	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:eph	Lcom/tencent/luggage/sdk/launching/b;
    //   294: ifnull +24 -> 318
    //   297: aload 4
    //   299: invokevirtual 1915	com/tencent/mm/plugin/appbrand/w:getInitConfig	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   302: getfield 2034	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:eph	Lcom/tencent/luggage/sdk/launching/b;
    //   305: new 2036	com/tencent/mm/ipcinvoker/type/IPCInteger
    //   308: dup
    //   309: iload_2
    //   310: invokespecial 2038	com/tencent/mm/ipcinvoker/type/IPCInteger:<init>	(I)V
    //   313: invokeinterface 2044 2 0
    //   318: aload_0
    //   319: iload_2
    //   320: invokespecial 2016	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:setRequestedOrientation	(I)V
    //   323: ldc_w 343
    //   326: ldc_w 2046
    //   329: iconst_4
    //   330: anewarray 347	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload_0
    //   336: invokevirtual 483	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLocalClassName	()Ljava/lang/String;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: iload_2
    //   343: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: iload_3
    //   350: invokestatic 239	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   353: aastore
    //   354: dup
    //   355: iconst_3
    //   356: new 1384	java/lang/Throwable
    //   359: dup
    //   360: invokespecial 1385	java/lang/Throwable:<init>	()V
    //   363: invokestatic 1391	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   366: aastore
    //   367: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: ldc_w 1996
    //   373: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: return
    //   377: aconst_null
    //   378: astore 4
    //   380: goto -193 -> 187
    //   383: iconst_0
    //   384: istore_3
    //   385: goto -139 -> 246
    //   388: iload_1
    //   389: istore_2
    //   390: aload_0
    //   391: invokevirtual 677	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getResources	()Landroid/content/res/Resources;
    //   394: invokevirtual 254	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   397: getfield 1449	android/content/res/Configuration:orientation	I
    //   400: iconst_2
    //   401: if_icmpne -128 -> 273
    //   404: iconst_0
    //   405: istore_2
    //   406: goto -133 -> 273
    //   409: iload_1
    //   410: istore_2
    //   411: getstatic 130	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uer	[I
    //   414: iload_1
    //   415: invokestatic 2052	org/apache/commons/c/a:contains	([II)Z
    //   418: ifeq -145 -> 273
    //   421: iconst_0
    //   422: istore_2
    //   423: goto -150 -> 273
    //   426: astore 4
    //   428: ldc_w 343
    //   431: ldc_w 2054
    //   434: iconst_1
    //   435: anewarray 347	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: aload 4
    //   442: aastore
    //   443: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   446: goto -128 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	AppBrandUI
    //   0	449	1	paramInt	int
    //   247	176	2	i	int
    //   245	140	3	bool	boolean
    //   29	350	4	localObject1	Object
    //   426	15	4	localObject2	Object
    //   38	13	5	localIterator	Iterator
    //   60	53	6	locala	com.tencent.mm.plugin.appbrand.platform.window.a.a.a
    // Exception table:
    //   from	to	target	type
    //   278	318	426	finally
  }
  
  public final void setTaskDescription(ActivityManager.TaskDescription paramTaskDescription)
  {
    AppMethodBeat.i(48855);
    if (ccf()) {
      try
      {
        super.setTaskDescription(paramTaskDescription);
        AppMethodBeat.o(48855);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUI", localException, "setTaskDescription ", new Object[0]);
        if (paramTaskDescription != null) {
          try
          {
            super.setTaskDescription(new ActivityManager.TaskDescription(paramTaskDescription.getLabel(), null, paramTaskDescription.getPrimaryColor()));
            AppMethodBeat.o(48855);
            return;
          }
          catch (Exception paramTaskDescription) {}
        }
      }
    }
    AppMethodBeat.o(48855);
  }
  
  /* Error */
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 2075
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 154	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:uet	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate;
    //   10: astore 8
    //   12: aload 8
    //   14: getfield 2079	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:tOp	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;
    //   17: invokevirtual 1565	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:ccf	()Z
    //   20: istore 6
    //   22: iload 6
    //   24: ifne +136 -> 160
    //   27: aload_1
    //   28: ifnull +157 -> 185
    //   31: aload_1
    //   32: invokevirtual 695	android/content/Intent:getFlags	()I
    //   35: ldc_w 2080
    //   38: iand
    //   39: ifle +146 -> 185
    //   42: iconst_1
    //   43: istore 4
    //   45: aload_1
    //   46: ifnull +145 -> 191
    //   49: aload_1
    //   50: invokevirtual 1342	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   53: invokestatic 2084	com/tencent/mm/plugin/appbrand/utils/l:e	(Landroid/content/ComponentName;)Ljava/lang/String;
    //   56: aload_0
    //   57: invokevirtual 1097	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getComponentName	()Landroid/content/ComponentName;
    //   60: invokestatic 2084	com/tencent/mm/plugin/appbrand/utils/l:e	(Landroid/content/ComponentName;)Ljava/lang/String;
    //   63: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifeq +125 -> 191
    //   69: iconst_1
    //   70: istore 5
    //   72: aload_1
    //   73: invokestatic 2090	com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI:E	(Landroid/content/Intent;)Z
    //   76: istore 6
    //   78: aload_1
    //   79: invokestatic 2095	com/tencent/mm/plugin/appbrand/launching/AppBrandLaunchProxyUI:K	(Landroid/content/Intent;)Z
    //   82: istore 7
    //   84: aload_0
    //   85: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   88: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   91: ifnull +31 -> 122
    //   94: aload_0
    //   95: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   98: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   101: checkcast 1238	com/tencent/luggage/sdk/e/d
    //   104: getfield 335	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   107: astore 8
    //   109: iload 7
    //   111: ifeq +86 -> 197
    //   114: aload 8
    //   116: getstatic 2101	com/tencent/mm/plugin/appbrand/k$d:qrN	Lcom/tencent/mm/plugin/appbrand/k$d;
    //   119: invokestatic 2104	com/tencent/mm/plugin/appbrand/k:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/k$d;)V
    //   122: aload_0
    //   123: getfield 318	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   126: invokevirtual 582	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   129: checkcast 1219	com/tencent/mm/plugin/appbrand/w
    //   132: invokevirtual 2108	com/tencent/mm/plugin/appbrand/w:ccN	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   135: invokevirtual 2114	com/tencent/mm/plugin/appbrand/page/y:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/h;
    //   138: aload_1
    //   139: invokeinterface 2118 2 0
    //   144: aload_0
    //   145: aload_1
    //   146: iload_2
    //   147: aload_3
    //   148: invokespecial 2120	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:startActivityForResult	(Landroid/content/Intent;ILandroid/os/Bundle;)V
    //   151: ldc_w 2075
    //   154: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore 9
    //   160: aload 8
    //   162: getfield 1077	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:ufC	Z
    //   165: ifeq -138 -> 27
    //   168: aload 8
    //   170: iconst_1
    //   171: putfield 2123	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:ufD	Z
    //   174: aload 8
    //   176: getfield 2079	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:tOp	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;
    //   179: invokestatic 1768	com/tencent/mm/ui/base/b:bZ	(Landroid/app/Activity;)V
    //   182: goto -155 -> 27
    //   185: iconst_0
    //   186: istore 4
    //   188: goto -143 -> 45
    //   191: iconst_0
    //   192: istore 5
    //   194: goto -122 -> 72
    //   197: iload 4
    //   199: ifeq +13 -> 212
    //   202: iload 5
    //   204: ifne +8 -> 212
    //   207: iload 6
    //   209: ifeq -87 -> 122
    //   212: getstatic 2126	com/tencent/mm/plugin/appbrand/k$d:qrI	Lcom/tencent/mm/plugin/appbrand/k$d;
    //   215: aload 8
    //   217: invokestatic 2130	com/tencent/mm/plugin/appbrand/k:Uo	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/k$d;
    //   220: if_acmpne -98 -> 122
    //   223: aload 8
    //   225: getstatic 2133	com/tencent/mm/plugin/appbrand/k$d:qrM	Lcom/tencent/mm/plugin/appbrand/k$d;
    //   228: invokestatic 2104	com/tencent/mm/plugin/appbrand/k:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/k$d;)V
    //   231: goto -109 -> 122
    //   234: astore_1
    //   235: ldc_w 343
    //   238: aload_1
    //   239: ldc_w 2134
    //   242: iconst_0
    //   243: anewarray 347	java/lang/Object
    //   246: invokestatic 569	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: ldc_w 2075
    //   252: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: return
    //   256: astore 8
    //   258: goto -114 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	AppBrandUI
    //   0	261	1	paramIntent	Intent
    //   0	261	2	paramInt	int
    //   0	261	3	paramBundle	Bundle
    //   43	155	4	i	int
    //   70	133	5	j	int
    //   20	188	6	bool1	boolean
    //   82	28	7	bool2	boolean
    //   10	214	8	localObject	Object
    //   256	1	8	localException1	Exception
    //   158	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	22	158	java/lang/Exception
    //   144	151	234	finally
    //   122	144	256	java/lang/Exception
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(322399);
    try
    {
      super.unbindService(paramServiceConnection);
      AppMethodBeat.o(322399);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "unbindService IllegalArgumentException %s", new Object[] { paramServiceConnection });
      AppMethodBeat.o(322399);
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(322409);
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      AppMethodBeat.o(322409);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
      AppMethodBeat.o(322409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */