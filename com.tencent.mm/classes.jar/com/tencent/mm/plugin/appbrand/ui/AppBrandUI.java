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
import androidx.annotation.Keep;
import com.tencent.luggage.k.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.os;
import com.tencent.mm.f.b.a.os.a;
import com.tencent.mm.f.b.a.ov;
import com.tencent.mm.f.b.a.ov.a;
import com.tencent.mm.f.b.a.ow;
import com.tencent.mm.f.b.a.ow.a;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.7;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.am;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.performance.h.1;
import com.tencent.mm.plugin.appbrand.platform.window.a.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.widget.input.a.1;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.AccessibilityUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.vendor.Meizu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@com.tencent.mm.ui.base.a(7)
public class AppBrandUI
  extends AppBrandContainerFragmentActivity
  implements androidx.core.app.a.a, f.e, com.tencent.mm.plugin.appbrand.jsapi.nfc.b, com.tencent.mm.plugin.appbrand.platform.window.a.a, com.tencent.mm.ui.base.b.a
{
  private static boolean qYz = false;
  private LayoutInflater mLayoutInflater;
  private Resources mResources;
  @Keep
  public AppBrandRuntimeContainerWC mRuntimeContainer;
  private final com.tencent.mm.plugin.appbrand.task.q nvr;
  private boolean qYA;
  private boolean qYB;
  private boolean qYC;
  public boolean qYD;
  private final Object qYE;
  private v qYF;
  private com.tencent.mm.ui.widget.a.d qYG;
  private final Set<com.tencent.mm.plugin.appbrand.platform.window.a.a.a> qYH;
  private Boolean qYI;
  private final com.tencent.mm.plugin.appbrand.widget.input.a qYt;
  private final AppBrandUITranslucentWorkaroundDelegate qYu;
  private com.tencent.mm.plugin.appbrand.a.e qYv;
  private boolean qYw;
  private boolean qYx;
  private Boolean qYy;
  private Configuration qvv;
  
  public AppBrandUI()
  {
    AppMethodBeat.i(48819);
    this.qYt = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    this.qYu = new AppBrandUITranslucentWorkaroundDelegate(this);
    this.qYw = false;
    this.qYx = false;
    this.qYy = null;
    this.qvv = null;
    this.qYA = false;
    this.qYB = false;
    this.qYC = false;
    this.qYD = false;
    this.qYE = new byte[0];
    this.qYG = null;
    this.qYH = new HashSet();
    this.nvr = new com.tencent.mm.plugin.appbrand.task.q()
    {
      public final boolean bCS()
      {
        AppMethodBeat.i(278473);
        boolean bool = AppBrandUI.this.bCS();
        AppMethodBeat.o(278473);
        return bool;
      }
      
      public final FrameLayout cjf()
      {
        AppMethodBeat.i(278472);
        FrameLayout localFrameLayout = (FrameLayout)AppBrandUI.i(AppBrandUI.this);
        AppMethodBeat.o(278472);
        return localFrameLayout;
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
        localObject1 = com.tencent.mm.plugin.appbrand.task.r.qRZ;
        com.tencent.mm.plugin.appbrand.task.r.b(this, "<init>");
        AppBrandProcessSuicideLogic.B(this);
        if (com.tencent.mm.plugin.appbrand.app.e.bFn()) {
          break label209;
        }
      }
      for (;;)
      {
        this.qYy = Boolean.valueOf(bool);
        AppMethodBeat.o(48819);
        return;
        i += 1;
        break;
        label209:
        bool = false;
      }
    }
  }
  
  public static Configuration G(Activity paramActivity)
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
  
  public static Pair<AppBrandInitConfigWC, AppBrandStatObject> M(Intent paramIntent)
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
    AppMethodBeat.i(264997);
    if (this.mRuntimeContainer != null) {}
    for (Object localObject = this.mRuntimeContainer.getActiveRuntime();; localObject = null)
    {
      if ((localObject == null) || (!Util.isEqual(((AppBrandRuntime)localObject).mAppId, paramString)))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "handleDeclarePrompt: try dismiss last dialog, activeRuntime(%s) newAppId(%s)", new Object[] { localObject, paramString });
        if (this.qYG != null) {
          this.qYG.dismiss();
        }
      }
      if (paramWeAppOpenDeclarePromptBundle != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt with null bundle: appid(%s) try dismiss last dialog", new Object[] { Util.nullAs(paramString, "") });
      if (this.qYG != null) {
        this.qYG.dismiss();
      }
      AppMethodBeat.o(264997);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt bundle:%s appid:%s", new Object[] { paramWeAppOpenDeclarePromptBundle, Util.nullAs(paramString, "") });
    if (this.qYG != null) {
      this.qYG.dismiss();
    }
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    locala.bBc(paramWeAppOpenDeclarePromptBundle.nBL);
    locala.bBd(paramWeAppOpenDeclarePromptBundle.nBM);
    localObject = paramWeAppOpenDeclarePromptBundle.nBN;
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = getString(au.i.app_ok);
    }
    locala.bBj(paramString).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(278319);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt: onClick");
        j.a(MainProcessIPCService.PROCESS_NAME, new AppBrandUIDeclarePromptIPC.IPCDeclarePromptCallbackParam(paramWeAppOpenDeclarePromptBundle.hDp, false, paramWeAppOpenDeclarePromptBundle.nBK), AppBrandUIDeclarePromptIPC.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(278319);
      }
    });
    locala.HG(paramWeAppOpenDeclarePromptBundle.bxO);
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(267011);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "handleDeclarePrompt: onCancel");
        j.a(MainProcessIPCService.PROCESS_NAME, new AppBrandUIDeclarePromptIPC.IPCDeclarePromptCallbackParam(paramWeAppOpenDeclarePromptBundle.hDp, true, paramWeAppOpenDeclarePromptBundle.nBK), AppBrandUIDeclarePromptIPC.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(267011);
      }
    });
    paramWeAppOpenDeclarePromptBundle = locala.icu();
    this.qYG = paramWeAppOpenDeclarePromptBundle;
    paramWeAppOpenDeclarePromptBundle.show();
    AppMethodBeat.o(264997);
  }
  
  private void cJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(48833);
    if ((this.qYA) || (this.qYB))
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
        this.qYB = true;
        Object localObject = M(getIntent());
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)((Pair)localObject).first;
        localObject = (AppBrandStatObject)((Pair)localObject).second;
        localAppBrandInitConfigWC.nYc = Util.nowMilliSecond();
        localAppBrandInitConfigWC.startTime = Util.nowMilliSecond();
        Intent localIntent = getIntent();
        localIntent.putExtra("key_appbrand_init_config", localAppBrandInitConfigWC);
        localIntent.putExtra("key_appbrand_stat_object", (Parcelable)localObject);
        setIntent(localIntent);
        AppBrandProcessSuicideLogic.bFp();
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
        this.qYA = true;
      } else if (paramInt == 2) {
        this.qYC = true;
      }
    }
  }
  
  private LayoutInflater ckc()
  {
    AppMethodBeat.i(264993);
    if (this.mLayoutInflater != null)
    {
      ??? = this.mLayoutInflater;
      AppMethodBeat.o(264993);
      return ???;
    }
    synchronized (this.qYE)
    {
      if (this.mLayoutInflater == null)
      {
        this.mLayoutInflater = ((LayoutInflater)Objects.requireNonNull(androidx.core.content.a.a(getApplicationContext(), LayoutInflater.class))).cloneInContext(this);
        ad.c(this.mLayoutInflater);
      }
      LayoutInflater localLayoutInflater = this.mLayoutInflater;
      AppMethodBeat.o(264993);
      return localLayoutInflater;
    }
  }
  
  private void cke()
  {
    AppMethodBeat.i(48824);
    if (this.mRuntimeContainer == null) {}
    for (int i = -1;; i = this.mRuntimeContainer.getStackSize())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "%s.closeIfNoActiveRuntimes %d,", new Object[] { getLocalClassName(), Integer.valueOf(i) });
      if (!(this.mRuntimeContainer instanceof AppBrandRuntimeContainerWC)) {
        break;
      }
      ((AppBrandRuntimeContainerWC)this.mRuntimeContainer).Se();
      AppMethodBeat.o(48824);
      return;
    }
    if (i <= 0) {
      finish();
    }
    AppMethodBeat.o(48824);
  }
  
  /* Error */
  private void e(Intent paramIntent, String paramString)
  {
    // Byte code:
    //   0: ldc_w 533
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 450	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:setIntent	(Landroid/content/Intent;)V
    //   16: aload_1
    //   17: invokestatic 425	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:M	(Landroid/content/Intent;)Landroid/util/Pair;
    //   20: astore 7
    //   22: aload 7
    //   24: getfield 428	android/util/Pair:first	Ljava/lang/Object;
    //   27: checkcast 236	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   30: astore 6
    //   32: aload 7
    //   34: getfield 431	android/util/Pair:second	Ljava/lang/Object;
    //   37: checkcast 256	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject
    //   40: astore 7
    //   42: aload 6
    //   44: ifnull +16 -> 60
    //   47: aload 7
    //   49: ifnull +11 -> 60
    //   52: aload 6
    //   54: getfield 540	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:cwV	Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;
    //   57: ifnonnull +118 -> 175
    //   60: aload_0
    //   61: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   64: ifnull +13 -> 77
    //   67: aload_0
    //   68: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   71: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   74: ifnonnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 474	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   81: ldc_w 300
    //   84: ldc_w 543
    //   87: iconst_2
    //   88: anewarray 304	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_2
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   100: lload 4
    //   102: lsub
    //   103: invokestatic 548	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: aastore
    //   107: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: ldc_w 533
    //   113: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: ldc_w 300
    //   121: ldc_w 550
    //   124: iconst_1
    //   125: anewarray 304	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_0
    //   136: invokevirtual 474	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   139: ldc_w 300
    //   142: ldc_w 543
    //   145: iconst_2
    //   146: anewarray 304	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_2
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   158: lload 4
    //   160: lsub
    //   161: invokestatic 548	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   164: aastore
    //   165: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: ldc_w 533
    //   171: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: aload_1
    //   176: aload_0
    //   177: invokevirtual 551	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getClassLoader	()Ljava/lang/ClassLoader;
    //   180: invokevirtual 554	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   183: aload 6
    //   185: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   188: invokestatic 563	com/tencent/mm/plugin/appbrand/d:abA	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/t;
    //   191: ifnonnull +142 -> 333
    //   194: iconst_1
    //   195: istore_3
    //   196: iload_3
    //   197: ifeq +43 -> 240
    //   200: aload 6
    //   202: getfield 567	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYk	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   205: getfield 572	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:cBH	Ljava/lang/String;
    //   208: aload 6
    //   210: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   213: aload 6
    //   215: getfield 575	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:username	Ljava/lang/String;
    //   218: aload 6
    //   220: getfield 578	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appVersion	I
    //   223: invokestatic 580	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   226: aload 6
    //   228: invokevirtual 583	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:Qv	()Z
    //   231: invokestatic 588	com/tencent/mm/plugin/appbrand/report/quality/k:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   234: iconst_1
    //   235: aload 6
    //   237: invokestatic 593	com/tencent/mm/plugin/appbrand/r:a	(ILcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V
    //   240: aload_1
    //   241: ldc_w 595
    //   244: getstatic 600	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   247: invokestatic 606	com/tencent/mm/sdk/platformtools/IntentUtil:getIntExtra	(Landroid/content/Intent;Ljava/lang/String;I)I
    //   250: istore_3
    //   251: getstatic 600	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   254: iload_3
    //   255: if_icmpeq +83 -> 338
    //   258: ldc_w 300
    //   261: ldc_w 608
    //   264: iconst_2
    //   265: anewarray 304	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: getstatic 600	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   273: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: iload_3
    //   280: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: iconst_5
    //   288: aload 6
    //   290: invokestatic 593	com/tencent/mm/plugin/appbrand/r:a	(ILcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V
    //   293: aload_0
    //   294: invokevirtual 474	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   297: ldc_w 300
    //   300: ldc_w 543
    //   303: iconst_2
    //   304: anewarray 304	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload_2
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   316: lload 4
    //   318: lsub
    //   319: invokestatic 548	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: aastore
    //   323: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: ldc_w 533
    //   329: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: return
    //   333: iconst_0
    //   334: istore_3
    //   335: goto -139 -> 196
    //   338: aload_1
    //   339: invokevirtual 611	android/content/Intent:getFlags	()I
    //   342: ldc_w 612
    //   345: iand
    //   346: ifle +427 -> 773
    //   349: ldc_w 300
    //   352: ldc_w 614
    //   355: iconst_1
    //   356: anewarray 304	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload 6
    //   363: invokevirtual 617	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:toString	()Ljava/lang/String;
    //   366: aastore
    //   367: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: invokestatic 622	com/tencent/mm/plugin/appbrand/ui/o:ckj	()I
    //   373: istore_3
    //   374: iload_3
    //   375: ifne +79 -> 454
    //   378: aload_0
    //   379: getstatic 625	com/tencent/mm/plugin/appbrand/au$i:app_brand_account_release_error	I
    //   382: iconst_1
    //   383: invokestatic 631	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   386: invokevirtual 632	android/widget/Toast:show	()V
    //   389: iconst_0
    //   390: invokestatic 637	com/tencent/mm/plugin/appbrand/report/model/j:rE	(I)V
    //   393: ldc_w 300
    //   396: ldc_w 639
    //   399: iconst_1
    //   400: anewarray 304	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: aload 6
    //   407: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   410: aastore
    //   411: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: aload_0
    //   415: invokevirtual 474	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   418: ldc_w 300
    //   421: ldc_w 543
    //   424: iconst_2
    //   425: anewarray 304	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_2
    //   431: aastore
    //   432: dup
    //   433: iconst_1
    //   434: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   437: lload 4
    //   439: lsub
    //   440: invokestatic 548	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   443: aastore
    //   444: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: ldc_w 533
    //   450: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: return
    //   454: iload_3
    //   455: aload 6
    //   457: getfield 642	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   460: if_icmpeq +52 -> 512
    //   463: iconst_1
    //   464: invokestatic 637	com/tencent/mm/plugin/appbrand/report/model/j:rE	(I)V
    //   467: ldc_w 300
    //   470: ldc_w 644
    //   473: iconst_3
    //   474: anewarray 304	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: iload_3
    //   480: invokestatic 647	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   483: aastore
    //   484: dup
    //   485: iconst_1
    //   486: aload 6
    //   488: getfield 642	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   491: invokestatic 647	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   494: aastore
    //   495: dup
    //   496: iconst_2
    //   497: aload 6
    //   499: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   502: aastore
    //   503: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   506: aload 6
    //   508: iload_3
    //   509: putfield 642	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   512: aload 6
    //   514: invokestatic 435	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   517: putfield 442	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   520: aload 6
    //   522: invokestatic 435	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   525: putfield 439	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYc	J
    //   528: aload 6
    //   530: iconst_1
    //   531: putfield 650	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYl	I
    //   534: aload 6
    //   536: new 569	com/tencent/mm/plugin/appbrand/report/quality/QualitySession
    //   539: dup
    //   540: aload 6
    //   542: getfield 642	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:uin	I
    //   545: invokestatic 655	com/tencent/mm/plugin/appbrand/utils/d:Do	(I)Ljava/lang/String;
    //   548: aload 6
    //   550: aload 7
    //   552: invokespecial 658	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   555: putfield 567	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYk	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   558: aload 6
    //   560: invokevirtual 661	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:resetSession	()V
    //   563: aload 6
    //   565: getfield 666	com/tencent/luggage/sdk/config/AppBrandInitConfigLU:cwQ	Ljava/lang/String;
    //   568: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   571: ifeq +24 -> 595
    //   574: aload 6
    //   576: getfield 567	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYk	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   579: ifnull +16 -> 595
    //   582: aload 6
    //   584: aload 6
    //   586: getfield 567	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYk	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   589: getfield 572	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:cBH	Ljava/lang/String;
    //   592: invokevirtual 669	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:dW	(Ljava/lang/String;)V
    //   595: aload 6
    //   597: getfield 567	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYk	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   600: ifnull +23 -> 623
    //   603: getstatic 675	com/tencent/mm/plugin/appbrand/report/quality/o:qOt	Lcom/tencent/mm/plugin/appbrand/report/quality/o;
    //   606: astore_1
    //   607: aload 6
    //   609: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   612: aload 6
    //   614: getfield 567	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYk	Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;
    //   617: getfield 572	com/tencent/mm/plugin/appbrand/report/quality/QualitySession:cBH	Ljava/lang/String;
    //   620: invokestatic 678	com/tencent/mm/plugin/appbrand/report/quality/o:eW	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload_0
    //   624: aload 6
    //   626: aload 7
    //   628: invokespecial 682	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:h	(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   631: ldc_w 300
    //   634: ldc_w 684
    //   637: iconst_2
    //   638: anewarray 304	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: aload 6
    //   645: aastore
    //   646: dup
    //   647: iconst_1
    //   648: aload 7
    //   650: aastore
    //   651: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   654: aload 6
    //   656: invokevirtual 583	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:Qv	()Z
    //   659: pop
    //   660: aload 6
    //   662: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   665: getstatic 690	com/tencent/mm/plugin/appbrand/step/KSProcessWeAppLaunch:stepContainerUILaunch	Lcom/tencent/mm/plugin/appbrand/keylogger/base/a;
    //   668: invokestatic 695	com/tencent/mm/plugin/appbrand/keylogger/c:b	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/keylogger/base/a;)V
    //   671: aload_0
    //   672: aload 6
    //   674: getfield 699	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYs	Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;
    //   677: aload 6
    //   679: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   682: invokespecial 701	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:a	(Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;Ljava/lang/String;)V
    //   685: aload_0
    //   686: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   689: aconst_null
    //   690: aload 6
    //   692: aload 7
    //   694: invokevirtual 706	com/tencent/luggage/sdk/e/b:a	(Lcom/tencent/luggage/sdk/e/d;Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   702: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   705: invokevirtual 710	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:am	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V
    //   708: ldc_w 712
    //   711: aload_2
    //   712: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq +169 -> 884
    //   718: aload_0
    //   719: invokevirtual 716	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getLifecycle	()Landroidx/lifecycle/h;
    //   722: new 22	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$3
    //   725: dup
    //   726: aload_0
    //   727: aload 6
    //   729: aload 7
    //   731: invokespecial 719	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$3:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   734: invokevirtual 724	androidx/lifecycle/h:a	(Landroidx/lifecycle/k;)V
    //   737: ldc_w 300
    //   740: ldc_w 543
    //   743: iconst_2
    //   744: anewarray 304	java/lang/Object
    //   747: dup
    //   748: iconst_0
    //   749: aload_2
    //   750: aastore
    //   751: dup
    //   752: iconst_1
    //   753: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   756: lload 4
    //   758: lsub
    //   759: invokestatic 548	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   762: aastore
    //   763: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: ldc_w 533
    //   769: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   772: return
    //   773: aload 6
    //   775: iconst_0
    //   776: putfield 650	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYl	I
    //   779: goto -216 -> 563
    //   782: astore_1
    //   783: ldc_w 300
    //   786: ldc_w 543
    //   789: iconst_2
    //   790: anewarray 304	java/lang/Object
    //   793: dup
    //   794: iconst_0
    //   795: aload_2
    //   796: aastore
    //   797: dup
    //   798: iconst_1
    //   799: invokestatic 536	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   802: lload 4
    //   804: lsub
    //   805: invokestatic 548	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   808: aastore
    //   809: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: ldc_w 533
    //   815: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   818: aload_1
    //   819: athrow
    //   820: astore_1
    //   821: ldc_w 300
    //   824: ldc_w 726
    //   827: iconst_1
    //   828: anewarray 304	java/lang/Object
    //   831: dup
    //   832: iconst_0
    //   833: aload_1
    //   834: aastore
    //   835: invokestatic 729	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   838: goto -207 -> 631
    //   841: astore_1
    //   842: ldc_w 300
    //   845: ldc_w 731
    //   848: iconst_2
    //   849: anewarray 304	java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: aload 6
    //   856: getfield 557	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:appId	Ljava/lang/String;
    //   859: aastore
    //   860: dup
    //   861: iconst_1
    //   862: aload_1
    //   863: aastore
    //   864: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   867: aload_0
    //   868: getfield 127	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYG	Lcom/tencent/mm/ui/widget/a/d;
    //   871: ifnull -186 -> 685
    //   874: aload_0
    //   875: getfield 127	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYG	Lcom/tencent/mm/ui/widget/a/d;
    //   878: invokevirtual 315	com/tencent/mm/ui/widget/a/d:dismiss	()V
    //   881: goto -196 -> 685
    //   884: aload_0
    //   885: aload 6
    //   887: aload 7
    //   889: invokevirtual 734	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:g	(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   892: goto -155 -> 737
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	895	0	this	AppBrandUI
    //   0	895	1	paramIntent	Intent
    //   0	895	2	paramString	String
    //   195	314	3	i	int
    //   9	794	4	l	long
    //   30	856	6	localAppBrandInitConfigWC	AppBrandInitConfigWC
    //   20	868	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	42	117	java/lang/Exception
    //   16	42	782	finally
    //   52	60	782	finally
    //   60	77	782	finally
    //   77	81	782	finally
    //   118	139	782	finally
    //   175	194	782	finally
    //   200	240	782	finally
    //   240	297	782	finally
    //   338	374	782	finally
    //   378	418	782	finally
    //   454	512	782	finally
    //   512	563	782	finally
    //   563	595	782	finally
    //   595	623	782	finally
    //   623	631	782	finally
    //   631	671	782	finally
    //   671	685	782	finally
    //   685	737	782	finally
    //   773	779	782	finally
    //   821	838	782	finally
    //   842	881	782	finally
    //   884	892	782	finally
    //   595	623	820	java/lang/Throwable
    //   623	631	820	java/lang/Throwable
    //   671	685	841	java/lang/Throwable
  }
  
  private void h(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(264995);
    if (this.qYy == null) {
      this.qYy = Boolean.FALSE;
    }
    if ((!this.qYy.booleanValue()) || (qYz))
    {
      AppMethodBeat.o(264995);
      return;
    }
    if (paramAppBrandInitConfigWC.nYk == null)
    {
      AppMethodBeat.o(264995);
      return;
    }
    if (paramAppBrandInitConfigWC.nYi)
    {
      AppMethodBeat.o(264995);
      return;
    }
    qYz = true;
    com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.h.aHD().aHf();
    Object localObject = new ov();
    ((ov)localObject).gfn = ((ov)localObject).z("InstanceId", paramAppBrandInitConfigWC.nYk.cBH, true);
    ((ov)localObject).gmF = ((ov)localObject).z("AppId", paramAppBrandInitConfigWC.appId, true);
    ((ov)localObject).gYL = paramAppBrandInitConfigWC.appVersion;
    ((ov)localObject).hdm = ov.a.ou(paramAppBrandInitConfigWC.cBI + 1);
    ((ov)localObject).gYN = (paramAppBrandInitConfigWC.cwR + 1000);
    ((ov)localObject).gnP = paramAppBrandStatObject.scene;
    ((ov)localObject).Bp(paramAppBrandInitConfigWC.nYc);
    ((ov)localObject).Bq(localg.kfk.kfm);
    ((ov)localObject).Bo(((ov)localObject).hcV - ((ov)localObject).hcU);
    ((ov)localObject).hdn = paramAppBrandInitConfigWC.nYl;
    ((ov)localObject).bpa();
    localObject = new ow();
    ((ow)localObject).gfn = ((ow)localObject).z("InstanceId", paramAppBrandInitConfigWC.nYk.cBH, true);
    ((ow)localObject).gmF = ((ow)localObject).z("AppId", paramAppBrandInitConfigWC.appId, true);
    ((ow)localObject).gYL = paramAppBrandInitConfigWC.appVersion;
    ((ow)localObject).hdt = ow.a.ov(paramAppBrandInitConfigWC.cBI + 1);
    ((ow)localObject).gYN = (paramAppBrandInitConfigWC.cwR + 1000);
    ((ow)localObject).gnP = paramAppBrandStatObject.scene;
    ((ow)localObject).Bs(com.tencent.mm.plugin.appbrand.api.a.nBl);
    ((ow)localObject).Bt(com.tencent.mm.plugin.appbrand.api.a.nBm);
    ((ow)localObject).Br(((ow)localObject).hcV - ((ow)localObject).hcU);
    switch (AppBrandUI.4.qYM[com.tencent.xweb.WebView.getCurWebType().ordinal()])
    {
    default: 
      ((ow)localObject).bpa();
      localObject = new os();
      ((os)localObject).gfn = ((os)localObject).z("InstanceId", paramAppBrandInitConfigWC.nYk.cBH, true);
      ((os)localObject).gmF = ((os)localObject).z("AppId", paramAppBrandInitConfigWC.appId, true);
      ((os)localObject).gYL = paramAppBrandInitConfigWC.appVersion;
      ((os)localObject).hcS = os.a.or(paramAppBrandInitConfigWC.cBI + 1);
      ((os)localObject).gYN = (paramAppBrandInitConfigWC.cwR + 1000);
      ((os)localObject).gnP = paramAppBrandStatObject.scene;
      ((os)localObject).Bh(localg.kfk.kfm);
      ((os)localObject).Bi(localg.kfk.kfu);
      ((os)localObject).Bg(((os)localObject).hcV - ((os)localObject).hcU);
      if (!com.tencent.mm.plugin.appbrand.api.a.nBn) {
        break;
      }
    }
    for (long l = 1L;; l = 0L)
    {
      ((os)localObject).hcW = l;
      ((os)localObject).bpa();
      AppMethodBeat.o(264995);
      return;
      ((ow)localObject).grp = 3L;
      break;
      ((ow)localObject).grp = 4L;
      break;
      ((ow)localObject).grp = 2L;
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.platform.window.a.a.a parama)
  {
    AppMethodBeat.i(265005);
    this.qYH.add(parama);
    AppMethodBeat.o(265005);
  }
  
  protected void am(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void b(com.tencent.mm.plugin.appbrand.platform.window.a.a.a parama)
  {
    AppMethodBeat.i(265006);
    this.qYH.remove(parama);
    AppMethodBeat.o(265006);
  }
  
  public final ak bBY()
  {
    return this.mRuntimeContainer;
  }
  
  public final boolean bCS()
  {
    boolean bool = true;
    AppMethodBeat.i(48854);
    if (this.qYI != null)
    {
      bool = this.qYI.booleanValue();
      AppMethodBeat.o(48854);
      return bool;
    }
    Object localObject = MMApplicationContext.getContext().getPackageManager();
    Boolean localBoolean;
    try
    {
      localObject = ((PackageManager)localObject).getActivityInfo(getComponentName(), 128);
      if (localObject == null)
      {
        AppMethodBeat.o(48854);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", new Object[] { localException });
        localBoolean = null;
      }
    }
    if (!MMApplicationContext.getPackageName().equals(localBoolean.taskAffinity)) {}
    for (;;)
    {
      localBoolean = Boolean.valueOf(bool);
      this.qYI = localBoolean;
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(48854);
      return bool;
      bool = false;
    }
  }
  
  protected final AppBrandInitConfigWC bDy()
  {
    AppMethodBeat.i(265000);
    try
    {
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)M(getIntent()).first;
      AppMethodBeat.o(265000);
      return localAppBrandInitConfigWC;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(265000);
    }
    return null;
  }
  
  public final void bTs()
  {
    AppMethodBeat.i(265003);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "forceEnableBackPress");
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    ((q)com.tencent.mm.ui.component.g.b(this).i(q.class)).ckk();
    AppMethodBeat.o(265003);
  }
  
  public final v ckd()
  {
    AppMethodBeat.i(48822);
    if (this.qYF == null) {
      this.qYF = new v(this);
    }
    v localv = this.qYF;
    AppMethodBeat.o(48822);
    return localv;
  }
  
  protected final HalfScreenConfig ckf()
  {
    AppMethodBeat.i(264999);
    Object localObject = bDy();
    if (localObject == null)
    {
      AppMethodBeat.o(264999);
      return null;
    }
    localObject = ((AppBrandInitConfigWC)localObject).nBE;
    AppMethodBeat.o(264999);
    return localObject;
  }
  
  public final void ckg()
  {
    AppMethodBeat.i(265007);
    AppBrandRuntime localAppBrandRuntime;
    switch (AppBrandUI.4.aac[getLifecycle().jc().ordinal()])
    {
    default: 
      if (this.mRuntimeContainer != null)
      {
        localAppBrandRuntime = this.mRuntimeContainer.getActiveRuntime();
        if ((localAppBrandRuntime != null) && (!localAppBrandRuntime.ntU.get()) && (!localAppBrandRuntime.aol)) {
          break;
        }
      }
      else
      {
        finish();
        AppMethodBeat.o(265007);
        return;
      }
      break;
    case 1: 
    case 2: 
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandUI", "forceMoveTaskToBack, hash:%d, name:%s, state:%s, skip.", new Object[] { Integer.valueOf(hashCode()), getLocalClassName(), getLifecycle().jc() });
      AppMethodBeat.o(265007);
      return;
    }
    if (moveTaskToBack(false)) {
      localAppBrandRuntime.ntR.nKU.a(com.tencent.mm.plugin.appbrand.a.d.a.nLA);
    }
    AppMethodBeat.o(265007);
  }
  
  public final void ckh()
  {
    this.qYu.qZC = true;
  }
  
  public final void cki()
  {
    this.qYu.qZC = false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(180389);
    Object localObject = this.mRuntimeContainer;
    if (localObject != null)
    {
      localObject = ((ak)localObject).getActiveRuntime();
      if (localObject != null)
      {
        int i = paramKeyEvent.getKeyCode();
        localObject = (Set)((AppBrandRuntime)localObject).nuo.get(i);
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
            am localam = (am)((Iterator)localObject).next();
            if ((localam.nyD != -1) && (localam.nyD != paramKeyEvent.getAction())) {
              break label186;
            }
            boolean bool1 = localam.d(paramKeyEvent) | i;
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
  
  public void finish()
  {
    AppMethodBeat.i(48846);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(48846);
      return;
    }
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "finish");
    s.l(this);
    try
    {
      if (this.mRuntimeContainer != null)
      {
        this.mRuntimeContainer.bDf();
        this.mRuntimeContainer.a(AppBrandRuntimeContainerWC.a.nvN);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        super.finishAndRemoveTask();
      }
      for (;;)
      {
        if (!this.qYD) {
          initActivityCloseAnimation();
        }
        AppMethodBeat.o(48846);
        return;
        super.finish();
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "finish e = %s", new Object[] { localException });
      try
      {
        getIntent().removeExtra("android.view.autofill.extra.RESTORE_SESSION_TOKEN");
        super.finishAndRemoveTask();
        AppMethodBeat.o(48846);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "finish api27 fallback, thr = %s", new Object[] { localThrowable });
        AppMethodBeat.o(48846);
      }
    }
  }
  
  protected void g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48844);
    paramAppBrandInitConfigWC.cxf = paramAppBrandStatObject;
    if (com.tencent.mm.plugin.appbrand.utils.d.anh(paramAppBrandInitConfigWC.nYh))
    {
      overridePendingTransition(0, 0);
      AppMethodBeat.o(48844);
      return;
    }
    p.qYV.a(this, paramAppBrandInitConfigWC);
    AppMethodBeat.o(48844);
  }
  
  public LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(264992);
    LayoutInflater localLayoutInflater = ckc();
    AppMethodBeat.o(264992);
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
      paramString = ckc();
      AppMethodBeat.o(48821);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48821);
    return paramString;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(265011);
    AppBrandUI.2 local2 = new AppBrandUI.2(this, super.importUIComponents());
    AppMethodBeat.o(265011);
    return local2;
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(48843);
    p.qYV.k(this);
    AppMethodBeat.o(48843);
  }
  
  public final void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(48842);
    if ((paramIntent == null) || (paramIntent.getComponent() == null) || (!paramIntent.getComponent().getClassName().endsWith(getLocalClassName())))
    {
      if ((paramIntent != null) && (paramIntent.getComponent() != null) && (com.tencent.mm.ui.base.b.byA(com.tencent.mm.ui.base.b.f(paramIntent.getComponent()))))
      {
        com.tencent.mm.ui.base.b.lc(this);
        AppMethodBeat.o(48842);
        return;
      }
      super.initActivityOpenAnimation(paramIntent);
    }
    AppMethodBeat.o(48842);
  }
  
  public final boolean moveTaskToBack(boolean paramBoolean)
  {
    AppMethodBeat.i(48847);
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, String.format(Locale.ENGLISH, "moveTaskToBack(%b)", new Object[] { Boolean.valueOf(paramBoolean) }));
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "moveTaskToBack stack:" + android.util.Log.getStackTraceString(new Throwable()));
    s.l(this);
    try
    {
      paramBoolean = super.moveTaskToBack(paramBoolean);
      if (!this.qYD) {
        initActivityCloseAnimation();
      }
      AppMethodBeat.o(48847);
      return paramBoolean;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "moveTaskToBack() get exception %s, invoke finish()", new Object[] { localNullPointerException });
      finish();
      AppMethodBeat.o(48847);
    }
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48853);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.luggage.k.f.aI(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && ("jsapi_pay_onActivityResult".equals(paramIntent.getStringExtra("key_jsapi_pay_onActivityResult"))) && (paramInt2 == 5)) {
      com.tencent.mm.ui.base.h.a(this, paramIntent.getStringExtra("key_jsapi_pay_err_msg"), "", paramIntent.getStringExtra("key_jsapi_pay_err_dialog_confirm"), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(48853);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48849);
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onBackPressed");
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
    if (this.qvv != null)
    {
      localObject1 = this.qvv;
      if ((paramConfiguration.smallestScreenWidthDp != ((Configuration)localObject1).smallestScreenWidthDp) && (AppBrandRuntimeWCAccessible.isGame(this.mRuntimeContainer.getActiveRuntime()))) {}
      for (i = 1; i != 0; i = 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onConfigurationChanged by fold or unfold, last.smallestScreenWidthDp[%d], new.smallestScreenWidthDp[%d]", new Object[] { Integer.valueOf(this.qvv.smallestScreenWidthDp), Integer.valueOf(paramConfiguration.smallestScreenWidthDp) });
        cJ("multiWindowMode", 1);
        AppMethodBeat.o(48831);
        return;
      }
    }
    Object localObject2;
    if (this.qvv != null)
    {
      localObject1 = this.qvv;
      localObject2 = (com.tencent.mm.plugin.appbrand.t)this.mRuntimeContainer.getActiveRuntime();
      if ((localObject2 == null) || (((com.tencent.mm.plugin.appbrand.t)localObject2).getAppConfig() == null)) {
        break label469;
      }
    }
    label306:
    label469:
    for (boolean bool1 = ((com.tencent.mm.plugin.appbrand.t)localObject2).getAppConfig().bKT();; bool1 = false)
    {
      boolean bool2;
      if ((paramConfiguration.uiMode & 0x30) != (((Configuration)localObject1).uiMode & 0x30))
      {
        bool2 = true;
        boolean bool3 = com.tencent.mm.ui.ar.aEf();
        boolean bool4 = com.tencent.mm.ui.ar.aEk();
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
        cJ("darkModeTheme", 2);
        AppMethodBeat.o(48831);
        return;
        bool2 = false;
        break;
        localObject1 = "DAY";
        break label306;
      }
      label368:
      this.qvv = new Configuration(paramConfiguration);
      localObject1 = this.qYt;
      if (paramConfiguration != null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
        ((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).cnU();
      }
      this.mRuntimeContainer.dispatchConfigurationChanged(paramConfiguration);
      localObject1 = this.mRuntimeContainer.getActiveRuntime();
      if (localObject1 != null) {
        try
        {
          ((AppBrandRuntime)localObject1).bBX().getCurrentPage().onConfigurationChanged(paramConfiguration);
          AppMethodBeat.o(48831);
          return;
        }
        catch (NullPointerException paramConfiguration) {}
      }
      AppMethodBeat.o(48831);
      return;
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(48823);
    l = Util.currentTicks();
    Object localObject = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    Locale localLocale = Locale.ENGLISH;
    if (paramBundle == null) {}
    for (localObject = "null";; localObject = Integer.valueOf(paramBundle.hashCode()))
    {
      com.tencent.mm.plugin.appbrand.task.r.b(this, String.format(localLocale, "onCreate(%s)", new Object[] { localObject }));
      setTheme(w.ckq());
      if ((!DebuggerShell.bLS()) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vBc, 0) > 0)) {
        AccessibilityUtil.smartDisableAccessibility();
      }
      try
      {
        com.tencent.luggage.sdk.h.d.a("[AppBrandUILifeCycleSpeedProfile] AppBrandUI.super.onCreate", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48808);
            AppBrandUI.a(AppBrandUI.this, paramBundle);
            AppMethodBeat.o(48808);
          }
        });
        if ((paramBundle == null) || (!paramBundle.containsKey("com.tencent.mm.plugin.appbrand.ui.AppBrandUI.SAVED_INSTANCE_STATE_KEY_OVERRIDE_INTENT"))) {}
      }
      catch (Throwable localThrowable)
      {
        label160:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUI", localThrowable, "%s.onCreate", new Object[] { getLocalClassName() });
      }
      try
      {
        paramBundle = (Intent)paramBundle.getParcelable("com.tencent.mm.plugin.appbrand.ui.AppBrandUI.SAVED_INSTANCE_STATE_KEY_OVERRIDE_INTENT");
        if (paramBundle != null)
        {
          setIntent(paramBundle);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onCreate %d, overrideIntent is applied", new Object[] { Integer.valueOf(hashCode()) });
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          Field localField = Activity.class.getDeclaredField("mCalled");
          localField.setAccessible(true);
          if (((Boolean)localField.get(this)).booleanValue()) {
            break label273;
          }
          super.onCreate(paramBundle);
          finish();
          AppMethodBeat.o(48823);
          return;
          paramBundle = paramBundle;
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "onCreate %d, try use overrideIntent, exception:%s", new Object[] { Integer.valueOf(hashCode()), paramBundle });
          break label160;
          paramBundle = bDy();
          if (paramBundle == null) {
            break label348;
          }
          if (!paramBundle.nBE.nnk) {
            break label558;
          }
          AppBrandContainerFragmentActivity.e(this, getResources().getColor(au.c.White));
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "[AppBrandUILifeCycleSpeedProfile] onCreate %d, intent.flags = %d, super.onCreate() cost %dms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getIntent().getFlags()), Long.valueOf(Util.currentTicks() - l) });
          this.qYw = true;
          com.tencent.luggage.sdk.h.d.a("[AppBrandUILifeCycleSpeedProfile] onCreate stuffs " + getLocalClassName(), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48811);
              AppBrandUI.a(AppBrandUI.this, new Configuration(AppBrandUI.G(AppBrandUI.this)));
              AppBrandUI.a(AppBrandUI.this);
              AppBrandUI.a(AppBrandUI.this, new AppBrandRuntimeContainerWC(AppBrandUI.b(AppBrandUI.this)));
              Object localObject1 = AppBrandUI.d(AppBrandUI.this);
              Object localObject2 = new n(AppBrandUI.this, AppBrandUI.c(AppBrandUI.this));
              ((AppBrandRuntimeContainer)localObject1).mContentView.removeView((View)localObject2);
              int i = ((AppBrandRuntimeContainer)localObject1).mContentView.getChildCount();
              ((AppBrandRuntimeContainer)localObject1).mContentView.addView((View)localObject2, i, new ViewGroup.LayoutParams(-1, -1));
              ((AppBrandRuntimeContainer)localObject1).nvv = ((n)localObject2);
              ((AppBrandRuntimeContainer)localObject1).mContentView.requestChildFocus(((AppBrandRuntimeContainer)localObject1).nvv, ((AppBrandRuntimeContainer)localObject1).nvv);
              localObject1 = AppBrandUI.e(AppBrandUI.this);
              localObject2 = AppBrandUI.b(AppBrandUI.this).cjf();
              if ((((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).activity == null) || (((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).activity.getWindow() == null) || (localObject2 == null)) {}
              for (;;)
              {
                AppBrandUI.a(AppBrandUI.this, new com.tencent.mm.plugin.appbrand.a.e(AppBrandUI.this)
                {
                  public final void bIk()
                  {
                    AppMethodBeat.i(48809);
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onHomePressed %s", new Object[] { AppBrandUI.this.getLocalClassName() });
                    AppBrandRuntime localAppBrandRuntime = AppBrandUI.d(AppBrandUI.this).getActiveRuntime();
                    if (localAppBrandRuntime == null)
                    {
                      AppMethodBeat.o(48809);
                      return;
                    }
                    com.tencent.mm.plugin.appbrand.k.a(localAppBrandRuntime.mAppId, k.d.ntf);
                    AppMethodBeat.o(48809);
                  }
                  
                  public final void bIl()
                  {
                    AppMethodBeat.i(48810);
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onRecentAppsPressed %s", new Object[] { AppBrandUI.this.getLocalClassName() });
                    AppBrandRuntime localAppBrandRuntime = AppBrandUI.d(AppBrandUI.this).getActiveRuntime();
                    if (localAppBrandRuntime == null)
                    {
                      AppMethodBeat.o(48810);
                      return;
                    }
                    com.tencent.mm.plugin.appbrand.k.a(localAppBrandRuntime.mAppId, k.d.ntg);
                    AppMethodBeat.o(48810);
                  }
                });
                localObject1 = AppBrandUI.f(AppBrandUI.this);
                localObject2 = new IntentFilter();
                ((IntentFilter)localObject2).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                try
                {
                  MMApplicationContext.getContext().registerReceiver(((com.tencent.mm.plugin.appbrand.a.e)localObject1).receiver, (IntentFilter)localObject2);
                  com.tencent.mm.ui.ar.aN(AppBrandUI.this);
                  AppMethodBeat.o(48811);
                  return;
                  if ((((View)localObject2).getParent() == null) || (!(((View)localObject2).getParent() instanceof ViewGroup))) {
                    continue;
                  }
                  ((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).rtH = true;
                  localObject2 = (ViewGroup)((View)localObject2).getParent();
                  if (Build.VERSION.SDK_INT < 20)
                  {
                    Meizu.hideMeizuSmartBar(((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).activity, (View)localObject2);
                    ((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).cnV();
                  }
                  if ((!com.tencent.mm.plugin.appbrand.widget.input.a.rtG) || (!com.tencent.mm.plugin.appbrand.widget.input.a.eB(((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1).activity))) {
                    continue;
                  }
                  com.tencent.mm.plugin.appbrand.widget.input.ar.a((View)localObject2, new a.1((com.tencent.mm.plugin.appbrand.widget.input.a)localObject1));
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = ".concat(String.valueOf(localException)));
                  }
                }
              }
            }
          });
          s.k(this);
          e(getIntent(), "onCreate");
          paramBundle = com.tencent.mm.plugin.appbrand.performance.h.a.qzf;
          if ((System.currentTimeMillis() % 100L != 1L) && (!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()) && (!BuildInfo.IS_FLAVOR_RED)) {
            break label575;
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0)
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryNegativeFeedbackReporter", "register");
              paramBundle.fkt = new h.1(paramBundle);
              registerComponentCallbacks(paramBundle.fkt);
            }
            getLifecycle().a(this.qYu);
            if ((getContentView() instanceof com.tencent.mm.plugin.appbrand.ui.wxa_container.a)) {
              ((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)getContentView()).setRuntimeContainer(this.mRuntimeContainer);
            }
            AppMethodBeat.o(48823);
            return;
            AppBrandContainerFragmentActivity.e(this, getResources().getColor(au.c.BG_1));
            break;
          }
        }
        catch (Exception paramBundle)
        {
          break label273;
        }
      }
      if (getIntent() != null) {
        break label315;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "onCreate %d, null intent", new Object[] { Integer.valueOf(hashCode()) });
      finish();
      AppMethodBeat.o(48823);
      return;
    }
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48850);
    super.onCreateBeforeSetContentView();
    com.tencent.mm.plugin.appbrand.widget.input.a locala = this.qYt;
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
    Object localObject = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onDestroy");
    s.l(this);
    if ((!this.qYA) && (!isChangingConfigurations()) && (this.mRuntimeContainer != null)) {
      this.mRuntimeContainer.a(AppBrandRuntimeContainerWC.a.nvO);
    }
    if (this.mRuntimeContainer != null) {
      this.mRuntimeContainer.cleanup();
    }
    if (this.qYv != null) {
      localObject = this.qYv;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(((com.tencent.mm.plugin.appbrand.a.e)localObject).receiver);
      if (this.qYG != null) {
        this.qYG.dismiss();
      }
      super.onDestroy();
      localObject = com.tencent.mm.plugin.appbrand.performance.h.a.qzf;
      if (((com.tencent.mm.plugin.appbrand.performance.h)localObject).fkt != null) {
        unregisterComponentCallbacks(((com.tencent.mm.plugin.appbrand.performance.h)localObject).fkt);
      }
      com.tencent.luggage.k.f.aJ(this);
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
    Object localObject = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onEnterAnimationComplete");
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((q)com.tencent.mm.ui.component.g.b(this).i(q.class)).ckk();
    if (this.mRuntimeContainer != null)
    {
      localObject = this.mRuntimeContainer;
      if (((AppBrandRuntimeContainerWC)localObject).getStackSize() == 1) {
        ((com.tencent.mm.plugin.appbrand.t)((AppBrandRuntimeContainerWC)localObject).getActiveRuntime()).onEnterAnimationComplete();
      }
    }
    try
    {
      localObject = r.qZg;
      r.eY(MainProcessIPCService.PROCESS_NAME, getClass().getCanonicalName());
      localObject = ((AppBrandInitConfigWC)M(getIntent()).first).nYd;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        r localr = r.qZg;
        r.eY((String)localObject, getClass().getCanonicalName());
      }
      AppMethodBeat.o(48834);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(48834);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48825);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onNewIntent %s, %d, isFinishing:%b", new Object[] { paramIntent, Integer.valueOf(hashCode()), Boolean.valueOf(isFinishing()) });
    Object localObject = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onNewIntent");
    if ((isFinishing()) || (isDestroyed()) || (paramIntent == null))
    {
      AppMethodBeat.o(48825);
      return;
    }
    this.qYx = true;
    if (paramIntent.getBooleanExtra("key_appbrand_bring_ui_to_front", false))
    {
      cke();
      AppMethodBeat.o(48825);
      return;
    }
    s.k(this);
    int i;
    if (paramIntent.getParcelableExtra("key_appbrand_init_config") != null)
    {
      i = 1;
      if (i != 0) {
        break label182;
      }
      if (this.mRuntimeContainer != null) {
        break label161;
      }
    }
    label161:
    for (localObject = null;; localObject = (com.tencent.luggage.sdk.e.d)this.mRuntimeContainer.getActiveRuntime())
    {
      if ((localObject == null) || (!com.tencent.mm.plugin.appbrand.k.b(((AppBrandRuntime)localObject).mAppId, paramIntent))) {
        break label175;
      }
      AppMethodBeat.o(48825);
      return;
      i = 0;
      break;
    }
    label175:
    AppMethodBeat.o(48825);
    return;
    try
    {
      label182:
      super.onNewIntent(paramIntent);
      com.tencent.mm.ui.base.b.bv(this);
      e(paramIntent, "onNewIntent");
      AppMethodBeat.o(48825);
      return;
    }
    catch (Throwable paramIntent)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUI", paramIntent, "%s.onNewIntent", new Object[] { getLocalClassName() });
      cke();
      AppMethodBeat.o(48825);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(48840);
    Object localObject = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onPause");
    super.onPause();
    localObject = new kotlin.g.a.b() {};
    kotlin.g.b.p.k(this, "context");
    kotlin.g.b.p.k(localObject, "onScreenStatusGot");
    MMHandlerThread.postToMainThread((Runnable)new y.a(this, (kotlin.g.a.b)localObject));
    this.qYw = false;
    this.qYx = false;
    localObject = this.mRuntimeContainer;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeContainer", "onPause tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    ((AppBrandRuntimeContainer)localObject).runOnUiThread(new AppBrandRuntimeContainer.7((AppBrandRuntimeContainer)localObject));
    localObject = i.F(this);
    com.tencent.mm.sdk.platformtools.Log.d(((i)localObject).bqj, "onPause");
    ((i)localObject).qHt.disable();
    com.tencent.mm.plugin.appbrand.ad.e.K(this.mRuntimeContainer.getActiveRuntime());
    try
    {
      if (this.mRuntimeContainer.getActiveRuntime() != null) {
        com.tencent.mm.modelstat.d.d(4, "AppBrandUI_" + ((com.tencent.luggage.sdk.e.d)this.mRuntimeContainer.getActiveRuntime()).mAppId, hashCode());
      }
      if (AppBrandRuntimeWCAccessible.isGame(this.mRuntimeContainer.getActiveRuntime()))
      {
        if (com.tencent.mm.plugin.normsg.a.d.GxJ.aTn("ce_mg")) {
          com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_mg");
        }
        localObject = com.tencent.mm.plugin.normsg.a.d.GxJ.aTo("ce_mg");
        if (localObject == null) {}
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          fgr localfgr = new fgr();
          localfgr.UGN = new eae().dc((byte[])localObject);
          localObject = localfgr.toByteArray();
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandUI", String.format("[debug] extinfo data len = %d", new Object[] { Integer.valueOf(localObject.length) }));
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.s(540999682, (byte[])localObject);
          AppMethodBeat.o(48840);
          return;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandUI", localThrowable1, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
      }
      AppMethodBeat.o(48840);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(48852);
    Iterator localIterator = this.mRuntimeContainer.nvp.iterator();
    while (localIterator.hasNext()) {
      com.tencent.mm.plugin.appbrand.permission.r.a(((AppBrandRuntime)localIterator.next()).mAppId, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    com.tencent.luggage.k.f.aI(this).b(paramInt, paramArrayOfInt);
    AppMethodBeat.o(48852);
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: ldc_w 1863
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 170	com/tencent/mm/plugin/appbrand/task/r:qRZ	Lcom/tencent/mm/plugin/appbrand/task/r;
    //   9: astore_2
    //   10: aload_0
    //   11: ldc_w 1864
    //   14: invokestatic 175	com/tencent/mm/plugin/appbrand/task/r:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   17: ldc_w 1866
    //   20: new 36	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$8
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 1867	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$8:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   28: invokestatic 1491	com/tencent/luggage/sdk/h/d:a	(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/String;
    //   31: pop
    //   32: ldc_w 300
    //   35: ldc_w 1869
    //   38: iconst_1
    //   39: anewarray 304	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 1089	java/lang/Object:hashCode	()I
    //   48: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: invokevirtual 1871	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:bCS	()Z
    //   59: ifeq +245 -> 304
    //   62: aload_0
    //   63: getfield 109	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYw	Z
    //   66: ifne +238 -> 304
    //   69: aload_0
    //   70: getfield 111	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYx	Z
    //   73: ifne +231 -> 304
    //   76: iconst_2
    //   77: istore_1
    //   78: aload_0
    //   79: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   82: invokeinterface 286 1 0
    //   87: checkcast 1387	com/tencent/mm/plugin/appbrand/t
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +38 -> 130
    //   95: ldc_w 300
    //   98: ldc_w 1873
    //   101: iconst_2
    //   102: anewarray 304	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: getfield 292	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: iload_1
    //   115: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_2
    //   123: invokevirtual 1874	com/tencent/mm/plugin/appbrand/t:bDy	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   126: iload_1
    //   127: putfield 650	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nYl	I
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 111	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYx	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 109	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYw	Z
    //   140: aload_0
    //   141: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   144: invokevirtual 1875	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:onResume	()V
    //   147: aload_0
    //   148: invokestatic 1762	com/tencent/mm/plugin/appbrand/platform/window/a/i:F	(Landroid/app/Activity;)Lcom/tencent/mm/plugin/appbrand/platform/window/a/i;
    //   151: astore_2
    //   152: aload_2
    //   153: getfield 1765	com/tencent/mm/plugin/appbrand/platform/window/a/i:bqj	Ljava/lang/String;
    //   156: ldc_w 1864
    //   159: invokestatic 1767	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: getfield 1771	com/tencent/mm/plugin/appbrand/platform/window/a/i:qHt	Lcom/tencent/mm/plugin/appbrand/utils/af;
    //   166: invokevirtual 1878	com/tencent/mm/plugin/appbrand/utils/af:enable	()V
    //   169: aload_0
    //   170: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   173: invokeinterface 286 1 0
    //   178: invokestatic 1880	com/tencent/mm/plugin/appbrand/ad/e:J	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V
    //   181: aload_0
    //   182: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   185: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   188: ifnull +40 -> 228
    //   191: iconst_3
    //   192: new 1305	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 1783
    //   199: invokespecial 1308	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   206: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   209: checkcast 1704	com/tencent/luggage/sdk/e/d
    //   212: getfield 292	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   215: invokevirtual 1319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aload_0
    //   222: invokevirtual 1089	java/lang/Object:hashCode	()I
    //   225: invokestatic 1788	com/tencent/mm/modelstat/d:d	(ILjava/lang/String;I)V
    //   228: aload_0
    //   229: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   232: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   235: invokestatic 1379	com/tencent/mm/plugin/appbrand/AppBrandRuntimeWCAccessible:isGame	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)Z
    //   238: ifeq +27 -> 265
    //   241: aload_0
    //   242: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   245: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   248: checkcast 1704	com/tencent/luggage/sdk/e/d
    //   251: getfield 292	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   254: astore_2
    //   255: getstatic 1794	com/tencent/mm/plugin/normsg/a/d:GxJ	Lcom/tencent/mm/plugin/normsg/a/d;
    //   258: ldc_w 1796
    //   261: aload_2
    //   262: invokevirtual 1883	com/tencent/mm/plugin/normsg/a/d:jr	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: getstatic 170	com/tencent/mm/plugin/appbrand/task/r:qRZ	Lcom/tencent/mm/plugin/appbrand/task/r;
    //   268: astore_2
    //   269: aload_0
    //   270: ldc_w 1885
    //   273: invokestatic 175	com/tencent/mm/plugin/appbrand/task/r:b	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V
    //   276: ldc_w 1863
    //   279: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: astore_2
    //   284: ldc_w 300
    //   287: ldc_w 1887
    //   290: invokestatic 1657	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokevirtual 474	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   297: ldc_w 1863
    //   300: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: iconst_0
    //   305: istore_1
    //   306: goto -228 -> 78
    //   309: astore_2
    //   310: ldc_w 300
    //   313: aload_2
    //   314: ldc_w 1842
    //   317: iconst_0
    //   318: anewarray 304	java/lang/Object
    //   321: invokestatic 471	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   181	228	309	java/lang/Throwable
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(265009);
    super.onSaveInstanceState(paramBundle);
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onSaveInstanceState");
    try
    {
      M(getIntent());
      paramBundle.putParcelable("com.tencent.mm.plugin.appbrand.ui.AppBrandUI.SAVED_INSTANCE_STATE_KEY_OVERRIDE_INTENT", getIntent());
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "onSaveInstanceState override intent is saved, instance:%d", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(265009);
      return;
    }
    catch (Exception paramBundle)
    {
      AppMethodBeat.o(265009);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(48837);
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onStart");
    super.onStart();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUIccf", "onStart");
    localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onStarted");
    AppMethodBeat.o(48837);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(265004);
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onStop");
    super.onStop();
    AppMethodBeat.o(265004);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(48835);
    super.onWindowAttributesChanged(paramLayoutParams);
    com.tencent.mm.plugin.appbrand.widget.input.a locala = this.qYt;
    if (paramLayoutParams != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", new Object[] { Integer.valueOf(locala.rtI), Integer.valueOf(paramLayoutParams.flags) });
      if (paramLayoutParams.flags != locala.rtI)
      {
        locala.rtI = paramLayoutParams.flags;
        locala.cnU();
      }
    }
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
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "onWindowFocusChanged:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(48838);
  }
  
  public void recreate()
  {
    AppMethodBeat.i(265008);
    com.tencent.mm.plugin.appbrand.task.r localr = com.tencent.mm.plugin.appbrand.task.r.qRZ;
    com.tencent.mm.plugin.appbrand.task.r.b(this, "recreate");
    super.recreate();
    AppMethodBeat.o(265008);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(48841);
    if (this.qYH.size() > 0)
    {
      LinkedList localLinkedList = new LinkedList(this.qYH);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.platform.window.a.a.a locala = (com.tencent.mm.plugin.appbrand.platform.window.a.a.a)localIterator.next();
        if (locala.Bk(paramInt))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "setRequestedOrientation name[%s], request[%d], hooks.size[%d] intercept by %s", new Object[] { getLocalClassName(), Integer.valueOf(paramInt), Integer.valueOf(localLinkedList.size()), locala });
          AppMethodBeat.o(48841);
          return;
        }
      }
    }
    super.setRequestedOrientation(paramInt);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUI", "setRequestedOrientation name[%s], request[%d], stack %s", new Object[] { getLocalClassName(), Integer.valueOf(paramInt), android.util.Log.getStackTraceString(new Throwable()) });
    AppMethodBeat.o(48841);
  }
  
  public final void setTaskDescription(ActivityManager.TaskDescription paramTaskDescription)
  {
    AppMethodBeat.i(48855);
    if (bCS()) {
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
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 1992
    //   6: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 107	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:qYu	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate;
    //   13: astore 8
    //   15: aload 8
    //   17: getfield 1996	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:qZB	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;
    //   20: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   23: invokeinterface 286 1 0
    //   28: checkcast 1387	com/tencent/mm/plugin/appbrand/t
    //   31: invokevirtual 1874	com/tencent/mm/plugin/appbrand/t:bDy	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   34: getfield 1060	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:nBE	Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;
    //   37: invokevirtual 1999	com/tencent/mm/plugin/appbrand/config/HalfScreenConfig:isEnable	()Z
    //   40: istore 6
    //   42: iload 6
    //   44: ifeq +133 -> 177
    //   47: aload_1
    //   48: ifnull +154 -> 202
    //   51: aload_1
    //   52: invokevirtual 611	android/content/Intent:getFlags	()I
    //   55: ldc_w 2000
    //   58: iand
    //   59: ifle +143 -> 202
    //   62: iconst_1
    //   63: istore 4
    //   65: aload_1
    //   66: ifnull +142 -> 208
    //   69: aload_1
    //   70: invokevirtual 1271	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   73: invokestatic 2004	com/tencent/mm/plugin/appbrand/utils/h:e	(Landroid/content/ComponentName;)Ljava/lang/String;
    //   76: aload_0
    //   77: invokevirtual 1001	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getComponentName	()Landroid/content/ComponentName;
    //   80: invokestatic 2004	com/tencent/mm/plugin/appbrand/utils/h:e	(Landroid/content/ComponentName;)Ljava/lang/String;
    //   83: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +122 -> 208
    //   89: aload_1
    //   90: invokestatic 2010	com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI:C	(Landroid/content/Intent;)Z
    //   93: istore 6
    //   95: aload_1
    //   96: invokestatic 2015	com/tencent/mm/plugin/appbrand/launching/AppBrandLaunchProxyUI:H	(Landroid/content/Intent;)Z
    //   99: istore 7
    //   101: aload_0
    //   102: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   105: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   108: ifnull +31 -> 139
    //   111: aload_0
    //   112: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   115: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   118: checkcast 1704	com/tencent/luggage/sdk/e/d
    //   121: getfield 292	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mAppId	Ljava/lang/String;
    //   124: astore 8
    //   126: iload 7
    //   128: ifeq +86 -> 214
    //   131: aload 8
    //   133: getstatic 2021	com/tencent/mm/plugin/appbrand/k$d:nti	Lcom/tencent/mm/plugin/appbrand/k$d;
    //   136: invokestatic 2024	com/tencent/mm/plugin/appbrand/k:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/k$d;)V
    //   139: aload_0
    //   140: getfield 275	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:mRuntimeContainer	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;
    //   143: invokevirtual 541	com/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC:getActiveRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   146: checkcast 1387	com/tencent/mm/plugin/appbrand/t
    //   149: invokevirtual 2028	com/tencent/mm/plugin/appbrand/t:bDz	()Lcom/tencent/mm/plugin/appbrand/page/y;
    //   152: invokevirtual 2034	com/tencent/mm/plugin/appbrand/page/y:getReporter	()Lcom/tencent/mm/plugin/appbrand/report/model/f;
    //   155: aload_1
    //   156: invokeinterface 2038 2 0
    //   161: aload_0
    //   162: aload_1
    //   163: iload_2
    //   164: aload_3
    //   165: invokespecial 2040	com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandContainerFragmentActivity:startActivityForResult	(Landroid/content/Intent;ILandroid/os/Bundle;)V
    //   168: ldc_w 1992
    //   171: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore 9
    //   177: aload 8
    //   179: getfield 1100	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:qZC	Z
    //   182: ifeq -135 -> 47
    //   185: aload 8
    //   187: iconst_1
    //   188: putfield 2043	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:qZD	Z
    //   191: aload 8
    //   193: getfield 1996	com/tencent/mm/plugin/appbrand/ui/AppBrandUITranslucentWorkaroundDelegate:qZB	Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;
    //   196: invokestatic 1709	com/tencent/mm/ui/base/b:bv	(Landroid/app/Activity;)V
    //   199: goto -152 -> 47
    //   202: iconst_0
    //   203: istore 4
    //   205: goto -140 -> 65
    //   208: iconst_0
    //   209: istore 5
    //   211: goto -122 -> 89
    //   214: iload 4
    //   216: ifeq +13 -> 229
    //   219: iload 5
    //   221: ifne +8 -> 229
    //   224: iload 6
    //   226: ifeq -87 -> 139
    //   229: getstatic 2046	com/tencent/mm/plugin/appbrand/k$d:ntd	Lcom/tencent/mm/plugin/appbrand/k$d;
    //   232: aload 8
    //   234: invokestatic 2050	com/tencent/mm/plugin/appbrand/k:abM	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/k$d;
    //   237: if_acmpne -98 -> 139
    //   240: aload 8
    //   242: getstatic 2053	com/tencent/mm/plugin/appbrand/k$d:nth	Lcom/tencent/mm/plugin/appbrand/k$d;
    //   245: invokestatic 2024	com/tencent/mm/plugin/appbrand/k:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/k$d;)V
    //   248: goto -109 -> 139
    //   251: astore_1
    //   252: ldc_w 300
    //   255: aload_1
    //   256: ldc_w 2054
    //   259: iconst_0
    //   260: anewarray 304	java/lang/Object
    //   263: invokestatic 471	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: ldc_w 1992
    //   269: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: astore 8
    //   275: goto -114 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	AppBrandUI
    //   0	278	1	paramIntent	Intent
    //   0	278	2	paramInt	int
    //   0	278	3	paramBundle	Bundle
    //   63	152	4	i	int
    //   1	219	5	j	int
    //   40	185	6	bool1	boolean
    //   99	28	7	bool2	boolean
    //   13	228	8	localObject	Object
    //   273	1	8	localException1	Exception
    //   175	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	42	175	java/lang/Exception
    //   161	168	251	java/lang/Throwable
    //   139	161	273	java/lang/Exception
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(264990);
    try
    {
      super.unbindService(paramServiceConnection);
      AppMethodBeat.o(264990);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "unbindService IllegalArgumentException %s", new Object[] { paramServiceConnection });
      AppMethodBeat.o(264990);
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(264991);
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      AppMethodBeat.o(264991);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandUI", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
      AppMethodBeat.o(264991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */