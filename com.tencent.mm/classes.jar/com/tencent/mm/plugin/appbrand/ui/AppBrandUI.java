package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.support.v4.app.a.a;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.config.e.1;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.input.a.1;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(1)
public class AppBrandUI
  extends MMActivity
  implements a.a, p, q
{
  private com.tencent.mm.plugin.appbrand.task.h fyY = new AppBrandUI.3(this);
  private final com.tencent.mm.plugin.appbrand.widget.input.a heh = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
  com.tencent.mm.plugin.appbrand.k hei;
  private k hej;
  private com.tencent.mm.plugin.appbrand.b.e hek;
  private Intent hel = null;
  public boolean hem = false;
  private Boolean hen;
  private com.tencent.mm.ui.widget.a.c heo = null;
  
  protected final void ahA() {}
  
  public final boolean aoO()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.hen != null) {
      bool1 = this.hen.booleanValue();
    }
    for (;;)
    {
      return bool1;
      Object localObject1 = ae.getContext().getPackageManager();
      try
      {
        localObject1 = ((PackageManager)localObject1).getActivityInfo(getComponentName(), 128);
        if (localObject1 == null) {
          continue;
        }
        if (!ae.getPackageName().equals(((ActivityInfo)localObject1).taskAffinity))
        {
          bool1 = bool2;
          localObject1 = Boolean.valueOf(bool1);
          this.hen = ((Boolean)localObject1);
          return ((Boolean)localObject1).booleanValue();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", new Object[] { localException });
          Object localObject2 = null;
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  protected final void apf()
  {
    super.finish();
  }
  
  public void finish()
  {
    if ((isFinishing()) || (this.uMr)) {
      return;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        super.finishAndRemoveTask();
        initActivityCloseAnimation();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandUI", "finish e = %s", new Object[] { localException });
        try
        {
          getIntent().removeExtra("android.view.autofill.extra.RESTORE_SESSION_TOKEN");
          super.finishAndRemoveTask();
          return;
        }
        catch (Throwable localThrowable)
        {
          y.e("MicroMsg.AppBrandUI", "finish api27 fallback, thr = %s", new Object[] { localThrowable });
          return;
        }
        super.finish();
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void initActivityCloseAnimation()
  {
    ((r)com.tencent.luggage.b.e.i(r.class)).h(this);
  }
  
  protected void initActivityOpenAnimation(Intent paramIntent)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramIntent == null) {
      localObject1 = null;
    }
    try
    {
      localObject1 = (AppBrandStatObject)localObject1;
      if (localObject1 != null) {
        ((r)com.tencent.luggage.b.e.i(r.class)).a(this, (AppBrandStatObject)localObject1);
      }
      while (AppBrandLaunchProxyUI.o(paramIntent))
      {
        return;
        localObject1 = paramIntent.getParcelableExtra("key_appbrand_stat_object");
        break;
      }
      super.initActivityOpenAnimation(paramIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public boolean initNavigationSwipeBack()
  {
    return false;
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    try
    {
      paramBoolean = super.moveTaskToBack(paramBoolean);
      initActivityCloseAnimation();
      return paramBoolean;
    }
    catch (NullPointerException localNullPointerException)
    {
      finish();
    }
    return true;
  }
  
  public final boolean needShowIdcError()
  {
    return false;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.AppBrandUI", "onBackPressed %d", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = this.hei.ZV();
    com.tencent.mm.plugin.appbrand.widget.b.e locale;
    com.tencent.mm.plugin.appbrand.widget.b.h localh;
    if (localObject != null)
    {
      if (((i)localObject).fyr != null) {
        break label133;
      }
      locale = ((i)localObject).fys;
      localh = (com.tencent.mm.plugin.appbrand.widget.b.h)locale.hsw.peekLast();
      if (localh != null) {
        break label105;
      }
      locale.setVisibility(8);
    }
    for (int i = 0;; i = 1)
    {
      if ((i == 0) && (((i)localObject).fyp != null))
      {
        localObject = ((i)localObject).fyp;
        if (!((com.tencent.mm.plugin.appbrand.page.n)localObject).getCurrentPage().getCurrentPageView().qc()) {
          ((com.tencent.mm.plugin.appbrand.page.n)localObject).agL();
        }
      }
      return;
      label105:
      if (localh.isCancelable())
      {
        localh.onCancel();
        locale.c(localh);
      }
    }
    label133:
    g.a(((i)localObject).mAppId, g.c.fya);
    ((i)localObject).finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    y.i("MicroMsg.AppBrandUI", "onConfigurationChanged newConfig: %s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = this.heh;
    if (paramConfiguration != null)
    {
      y.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      ((com.tencent.mm.plugin.appbrand.widget.input.a)localObject).arF();
    }
    localObject = this.hei;
    if (((j)localObject).fyW != null)
    {
      localObject = ((j)localObject).fyW.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).onConfigurationChanged(paramConfiguration);
      }
    }
    localObject = com.tencent.mm.plugin.appbrand.config.e.r(this);
    ((com.tencent.mm.plugin.appbrand.config.e)localObject).fOo = paramConfiguration.orientation;
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + ((com.tencent.mm.plugin.appbrand.config.e)localObject).fOo);
    ((com.tencent.mm.plugin.appbrand.config.e)localObject).a(com.tencent.mm.plugin.appbrand.config.e.C(((com.tencent.mm.plugin.appbrand.config.e)localObject).fOo, com.tencent.mm.plugin.appbrand.config.e.adY()));
    localObject = this.hei.ZV();
    if (localObject != null)
    {
      localObject = ((i)localObject).Zy();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.o)localObject).E(com.tencent.mm.plugin.appbrand.page.q.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.page.q)localObject).onConfigurationChanged(paramConfiguration);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.plugin.appbrand.app.b.aaJ();
    super.onCreate(paramBundle);
    y.i("MicroMsg.AppBrandUI", "onCreate %d", new Object[] { Integer.valueOf(hashCode()) });
    paramBundle = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "pref_appbrand_process", 4);
    Object localObject1 = ae.getProcessName() + ":start_time";
    Object localObject3 = paramBundle.edit();
    if (paramBundle.contains((String)localObject1))
    {
      ((SharedPreferences.Editor)localObject3).remove((String)localObject1);
      com.tencent.mm.plugin.report.f.nEG.a(365L, 2L, 1L, false);
    }
    com.tencent.mm.plugin.report.f.nEG.a(365L, 4L, 1L, false);
    ((SharedPreferences.Editor)localObject3).putLong((String)localObject1, System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject3).commit();
    y.v("MicroMsg.AppBrandReporter", "onProcessStart");
    KVCommCrossProcessReceiver.bwQ();
    paramBundle = this.heh;
    localObject3 = this.fyY.aoN();
    if ((paramBundle.activity == null) || (paramBundle.activity.getWindow() == null) || (localObject3 == null)) {}
    for (;;)
    {
      this.hei = new com.tencent.mm.plugin.appbrand.k(this.fyY);
      this.hej = new k(this, this.hei);
      paramBundle = this.hej;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      try
      {
        ae.getContext().registerReceiver(paramBundle.fGh, (IntentFilter)localObject1);
        this.hek = new AppBrandUI.1(this, this);
        paramBundle = this.hek;
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      }
      catch (Exception paramBundle)
      {
        try
        {
          ae.getContext().registerReceiver(paramBundle.zm, (IntentFilter)localObject1);
          paramBundle = com.tencent.mm.plugin.appbrand.config.e.r(this);
          y.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
          try
          {
            paramBundle.mFinished = false;
            this.hel = getIntent();
            return;
          }
          finally {}
          if ((((View)localObject3).getParent() == null) || (!(((View)localObject3).getParent() instanceof ViewGroup))) {
            continue;
          }
          paramBundle.hsR = true;
          localObject1 = (ViewGroup)((View)localObject3).getParent();
          ((ViewGroup)localObject1).removeView((View)localObject3);
          localObject3 = new m(paramBundle.activity, (View)localObject3);
          ((ViewGroup)localObject1).addView((View)localObject3, new ViewGroup.LayoutParams(-1, -1));
          if (Build.VERSION.SDK_INT < 20)
          {
            Activity localActivity = paramBundle.activity;
            if ((com.tencent.mm.sdk.g.c.csB()) && (localActivity.getResources().getConfiguration().orientation != 2))
            {
              localActivity.getWindow().setFlags(1024, 1024);
              localActivity.getWindow().addFlags(2048);
              ((View)localObject1).setPadding(0, ak.gy(localActivity), 0, 0);
            }
            paramBundle.a((m)localObject3);
          }
          if ((!com.tencent.mm.plugin.appbrand.widget.input.a.hsQ) || (!com.tencent.mm.plugin.appbrand.widget.input.a.cK(paramBundle.activity))) {
            continue;
          }
          al.a((View)localObject1, new a.1(paramBundle));
          continue;
          paramBundle = paramBundle;
          y.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = " + paramBundle);
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            y.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = " + paramBundle);
          }
        }
      }
    }
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    com.tencent.mm.plugin.appbrand.widget.input.a locala = this.heh;
    if ((locala.activity == null) || (locala.activity.getWindow() == null)) {
      return;
    }
    locala.activity.getWindow().setSoftInputMode(16);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 714	com/tencent/mm/ui/MMActivity:onDestroy	()V
    //   4: ldc 185
    //   6: ldc_w 716
    //   9: iconst_1
    //   10: anewarray 189	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: invokevirtual 284	java/lang/Object:hashCode	()I
    //   19: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 291	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 62	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hei	Lcom/tencent/mm/plugin/appbrand/k;
    //   30: invokevirtual 719	com/tencent/mm/plugin/appbrand/k:cleanup	()V
    //   33: aload_0
    //   34: getfield 596	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hek	Lcom/tencent/mm/plugin/appbrand/b/e;
    //   37: ifnull +18 -> 55
    //   40: aload_0
    //   41: getfield 596	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hek	Lcom/tencent/mm/plugin/appbrand/b/e;
    //   44: astore_2
    //   45: invokestatic 147	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   48: aload_2
    //   49: getfield 603	com/tencent/mm/plugin/appbrand/b/e:zm	Landroid/content/BroadcastReceiver;
    //   52: invokevirtual 723	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   55: aload_0
    //   56: getfield 571	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hej	Lcom/tencent/mm/plugin/appbrand/ui/k;
    //   59: ifnull +18 -> 77
    //   62: aload_0
    //   63: getfield 571	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hej	Lcom/tencent/mm/plugin/appbrand/ui/k;
    //   66: astore_2
    //   67: invokestatic 147	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   70: aload_2
    //   71: getfield 585	com/tencent/mm/plugin/appbrand/b/f:fGh	Landroid/content/BroadcastReceiver;
    //   74: invokevirtual 723	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   77: aload_0
    //   78: invokestatic 414	com/tencent/mm/plugin/appbrand/config/e:r	(Landroid/app/Activity;)Lcom/tencent/mm/plugin/appbrand/config/e;
    //   81: astore_2
    //   82: ldc_w 419
    //   85: ldc_w 725
    //   88: invokestatic 435	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: monitorenter
    //   93: aload_2
    //   94: getfield 729	com/tencent/mm/plugin/appbrand/config/e:fOi	Lcom/tencent/mm/plugin/appbrand/config/e$d;
    //   97: ifnonnull +76 -> 173
    //   100: aload_2
    //   101: getfield 732	com/tencent/mm/plugin/appbrand/config/e:fOj	Lcom/tencent/mm/plugin/appbrand/config/e$d;
    //   104: ifnonnull +69 -> 173
    //   107: ldc_w 419
    //   110: ldc_w 734
    //   113: invokestatic 435	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_2
    //   117: monitorexit
    //   118: return
    //   119: astore_2
    //   120: ldc_w 701
    //   123: new 421	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 736
    //   130: invokespecial 425	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_2
    //   134: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 432	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 699	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -88 -> 55
    //   146: astore_2
    //   147: ldc_w 692
    //   150: new 421	java/lang/StringBuilder
    //   153: dup
    //   154: ldc_w 736
    //   157: invokespecial 425	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: aload_2
    //   161: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 432	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 699	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto -93 -> 77
    //   173: ldc_w 419
    //   176: ldc_w 738
    //   179: iconst_2
    //   180: anewarray 189	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_2
    //   186: getfield 729	com/tencent/mm/plugin/appbrand/config/e:fOi	Lcom/tencent/mm/plugin/appbrand/config/e$d;
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: aload_2
    //   193: getfield 732	com/tencent/mm/plugin/appbrand/config/e:fOj	Lcom/tencent/mm/plugin/appbrand/config/e$d;
    //   196: aastore
    //   197: invokestatic 291	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload_2
    //   201: aconst_null
    //   202: putfield 729	com/tencent/mm/plugin/appbrand/config/e:fOi	Lcom/tencent/mm/plugin/appbrand/config/e$d;
    //   205: aload_2
    //   206: aconst_null
    //   207: putfield 732	com/tencent/mm/plugin/appbrand/config/e:fOj	Lcom/tencent/mm/plugin/appbrand/config/e$d;
    //   210: aload_2
    //   211: iconst_1
    //   212: putfield 608	com/tencent/mm/plugin/appbrand/config/e:mFinished	Z
    //   215: getstatic 742	com/tencent/mm/plugin/appbrand/config/e:fOh	Landroid/util/SparseArray;
    //   218: astore_3
    //   219: aload_3
    //   220: monitorenter
    //   221: getstatic 742	com/tencent/mm/plugin/appbrand/config/e:fOh	Landroid/util/SparseArray;
    //   224: aload_2
    //   225: invokevirtual 748	android/util/SparseArray:indexOfValue	(Ljava/lang/Object;)I
    //   228: istore_1
    //   229: iload_1
    //   230: iflt +10 -> 240
    //   233: getstatic 742	com/tencent/mm/plugin/appbrand/config/e:fOh	Landroid/util/SparseArray;
    //   236: iload_1
    //   237: invokevirtual 751	android/util/SparseArray:removeAt	(I)V
    //   240: aload_3
    //   241: monitorexit
    //   242: aload_2
    //   243: monitorexit
    //   244: return
    //   245: astore_3
    //   246: aload_2
    //   247: monitorexit
    //   248: aload_3
    //   249: athrow
    //   250: astore 4
    //   252: aload_3
    //   253: monitorexit
    //   254: aload 4
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	AppBrandUI
    //   228	9	1	i	int
    //   44	73	2	localObject1	Object
    //   119	15	2	localException1	Exception
    //   146	101	2	localException2	Exception
    //   245	8	3	localObject2	Object
    //   250	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   45	55	119	java/lang/Exception
    //   67	77	146	java/lang/Exception
    //   93	118	245	finally
    //   173	221	245	finally
    //   242	244	245	finally
    //   246	248	245	finally
    //   254	257	245	finally
    //   221	229	250	finally
    //   233	240	250	finally
    //   240	242	250	finally
    //   252	254	250	finally
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    y.i("MicroMsg.AppBrandUI", "onNewIntent %d", new Object[] { Integer.valueOf(hashCode()) });
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)))
    {
      if ((this.hei == null) || (this.hei.fyW.size() == 0)) {
        finish();
      }
      return;
    }
    this.hel = paramIntent;
    this.hem = true;
  }
  
  public void onPause()
  {
    super.onPause();
    y.i("MicroMsg.AppBrandUI", "onPause %d", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = this.hei.ZV();
    if (localObject != null) {
      ((i)localObject).ZM();
    }
    localObject = com.tencent.mm.plugin.appbrand.config.e.r(this);
    if (((com.tencent.mm.plugin.appbrand.config.e)localObject).fOl != null) {
      ae.getContext().getContentResolver().unregisterContentObserver(((com.tencent.mm.plugin.appbrand.config.e)localObject).fOl);
    }
    try
    {
      com.tencent.mm.modelstat.d.b(4, "AppBrandUI_" + this.hei.ZV().mAppId, hashCode());
      if ((this.hei.ZV() != null) && (this.hei.ZV().ZH()))
      {
        com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
        if (com.tencent.mm.plugin.normsg.a.b.mGK.Kb("ce_mg")) {
          com.tencent.mm.plugin.normsg.a.b.mGK.Ka("ce_mg");
        }
        localObject = com.tencent.mm.plugin.normsg.a.b.mGK.Kc("ce_mg");
        com.tencent.mm.plugin.secinforeport.a.d.nQr.o(540999682, (byte[])localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrandUI", localThrowable, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Iterator localIterator = this.hei.fyW.iterator();
    while (localIterator.hasNext()) {
      com.tencent.mm.plugin.appbrand.permission.e.a(((i)localIterator.next()).mAppId, paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    y.i("MicroMsg.AppBrandUI", "onResume %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.hel != null)
    {
      setIntent(this.hel);
      s(this.hel);
      this.hel = null;
    }
    this.hei.onResume();
    Object localObject = com.tencent.mm.plugin.appbrand.config.e.r(this);
    ((com.tencent.mm.plugin.appbrand.config.e)localObject).a(((com.tencent.mm.plugin.appbrand.config.e)localObject).fOm, null);
    ContentResolver localContentResolver = ae.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    ((com.tencent.mm.plugin.appbrand.config.e)localObject).fOl = new e.1((com.tencent.mm.plugin.appbrand.config.e)localObject, new Handler());
    localContentResolver.registerContentObserver(localUri, false, ((com.tencent.mm.plugin.appbrand.config.e)localObject).fOl);
    try
    {
      com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.hei.ZV().mAppId, hashCode());
      if ((this.hei.ZV() != null) && (this.hei.ZV().ZH()))
      {
        com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
        localObject = this.hei.ZV().mAppId;
        com.tencent.mm.plugin.normsg.a.b.mGK.ei("ce_mg", (String)localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrandUI", localThrowable, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    y.i("MicroMsg.AppBrandUI", "onStart");
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
    com.tencent.mm.plugin.appbrand.widget.input.a locala = this.heh;
    if (paramLayoutParams == null) {}
    do
    {
      return;
      y.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", new Object[] { Integer.valueOf(locala.hsS), Integer.valueOf(paramLayoutParams.flags) });
    } while (paramLayoutParams.flags == locala.hsS);
    locala.hsS = paramLayoutParams.flags;
    locala.arF();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    y.i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.hem = false;
    }
  }
  
  /* Error */
  protected void s(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 917	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +8 -> 14
    //   9: aload_0
    //   10: invokevirtual 276	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   13: return
    //   14: aload_2
    //   15: ldc_w 919
    //   18: invokevirtual 925	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   21: invokevirtual 931	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   24: aload_2
    //   25: ldc_w 933
    //   28: invokevirtual 936	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   31: checkcast 919	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC
    //   34: astore_1
    //   35: aload_2
    //   36: ldc_w 256
    //   39: invokevirtual 936	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   42: checkcast 251	com/tencent/mm/plugin/appbrand/report/AppBrandStatObject
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_2
    //   51: ifnonnull +49 -> 100
    //   54: aload_0
    //   55: getfield 62	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hei	Lcom/tencent/mm/plugin/appbrand/k;
    //   58: ifnull +13 -> 71
    //   61: aload_0
    //   62: getfield 62	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hei	Lcom/tencent/mm/plugin/appbrand/k;
    //   65: invokevirtual 790	com/tencent/mm/plugin/appbrand/k:ZV	()Lcom/tencent/mm/plugin/appbrand/i;
    //   68: ifnonnull -55 -> 13
    //   71: aload_0
    //   72: invokevirtual 276	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:finish	()V
    //   75: return
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: ldc 185
    //   81: ldc_w 938
    //   84: iconst_1
    //   85: anewarray 189	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_2
    //   91: aastore
    //   92: invokestatic 195	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aconst_null
    //   96: astore_2
    //   97: goto -51 -> 46
    //   100: aload_1
    //   101: getfield 941	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:fNK	Ljava/lang/String;
    //   104: invokestatic 946	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   107: ifne +24 -> 131
    //   110: aload_1
    //   111: invokestatic 950	com/tencent/mm/plugin/appbrand/config/e:d	(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;)Lcom/tencent/mm/plugin/appbrand/config/e$b;
    //   114: astore_3
    //   115: aload_0
    //   116: invokestatic 414	com/tencent/mm/plugin/appbrand/config/e:r	(Landroid/app/Activity;)Lcom/tencent/mm/plugin/appbrand/config/e;
    //   119: aload_3
    //   120: new 952	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$2
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 953	com/tencent/mm/plugin/appbrand/ui/AppBrandUI$2:<init>	(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V
    //   128: invokevirtual 863	com/tencent/mm/plugin/appbrand/config/e:a	(Lcom/tencent/mm/plugin/appbrand/config/e$b;Lcom/tencent/mm/plugin/appbrand/config/e$a;)V
    //   131: ldc 185
    //   133: ldc_w 955
    //   136: iconst_2
    //   137: anewarray 189	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_1
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_2
    //   147: aastore
    //   148: invokestatic 291	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_1
    //   152: invokevirtual 956	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:ZH	()Z
    //   155: ifeq +7 -> 162
    //   158: iconst_1
    //   159: invokestatic 803	com/tencent/mm/plugin/webview/ui/tools/widget/o:Dh	(I)V
    //   162: aload_0
    //   163: getfield 62	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:hei	Lcom/tencent/mm/plugin/appbrand/k;
    //   166: aconst_null
    //   167: aload_1
    //   168: aload_2
    //   169: invokevirtual 959	com/tencent/mm/plugin/appbrand/k:a	(Lcom/tencent/mm/plugin/appbrand/i;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 224	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:getIntent	()Landroid/content/Intent;
    //   177: invokevirtual 960	com/tencent/mm/plugin/appbrand/ui/AppBrandUI:initActivityOpenAnimation	(Landroid/content/Intent;)V
    //   180: return
    //   181: astore_2
    //   182: goto -103 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	AppBrandUI
    //   0	185	1	paramIntent	Intent
    //   4	47	2	localObject	Object
    //   76	15	2	localException1	Exception
    //   96	73	2	localAppBrandStatObject	AppBrandStatObject
    //   181	1	2	localException2	Exception
    //   114	6	3	localb	com.tencent.mm.plugin.appbrand.config.e.b
    // Exception table:
    //   from	to	target	type
    //   14	35	76	java/lang/Exception
    //   35	46	181	java/lang/Exception
  }
  
  public void setTaskDescription(ActivityManager.TaskDescription paramTaskDescription)
  {
    if (aoO()) {}
    try
    {
      super.setTaskDescription(paramTaskDescription);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        y.printErrStackTrace("MicroMsg.AppBrandUI", localException, "setTaskDescription ", new Object[0]);
      } while (paramTaskDescription == null);
      try
      {
        super.setTaskDescription(new ActivityManager.TaskDescription(paramTaskDescription.getLabel(), null, paramTaskDescription.getPrimaryColor()));
        return;
      }
      catch (Exception paramTaskDescription) {}
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    int j = 1;
    int i;
    if ((paramIntent != null) && ((paramIntent.getFlags() & 0x10000000) > 0)) {
      i = 1;
    }
    for (;;)
    {
      label45:
      boolean bool1;
      String str;
      if ((paramIntent != null) && (com.tencent.mm.plugin.appbrand.v.c.b(paramIntent.getComponent()).equals(com.tencent.mm.plugin.appbrand.v.c.b(getComponentName()))))
      {
        bool1 = AppBrandProcessProxyUI.m(paramIntent);
        boolean bool2 = AppBrandLaunchProxyUI.o(paramIntent);
        boolean bool3 = AppBrandEmbedUI.r(paramIntent);
        if (this.hei.ZV() != null)
        {
          str = this.hei.ZV().mAppId;
          if ((!bool2) && (!bool3)) {
            break label143;
          }
          g.a(str, g.c.fyf);
        }
      }
      try
      {
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.n)this.hei.ZV()).aad().getReporter().gXX = paramIntent;
          label123:
          super.startActivityForResult(paramIntent, paramInt, paramBundle);
          return;
          i = 0;
          break;
          j = 0;
          break label45;
          label143:
          if (((i == 0) || (j != 0) || (bool1)) && (g.c.fyb == g.qB(str))) {
            g.a(str, g.c.fye);
          }
        }
      }
      catch (Exception localException)
      {
        break label123;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */