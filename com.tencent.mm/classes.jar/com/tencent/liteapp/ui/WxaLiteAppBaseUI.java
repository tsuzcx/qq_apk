package com.tencent.liteapp.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.SwipeBackActivity;
import com.tencent.mm.ext.ui.SwipeBackLayout;
import com.tencent.wxa.b.b;
import com.tencent.wxa.c;
import com.tencent.wxa.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaLiteAppBaseUI
  extends SwipeBackActivity
  implements LifecycleOwner, b, a.a
{
  public static final String crl;
  protected String crm;
  protected com.tencent.wxa.ui.a crn;
  protected WxaLiteAppInfo cro;
  protected boolean crp;
  private LifecycleRegistry crq;
  
  static
  {
    AppMethodBeat.i(197749);
    crl = d.a.SMF.name();
    AppMethodBeat.o(197749);
  }
  
  public WxaLiteAppBaseUI()
  {
    AppMethodBeat.i(197719);
    this.crp = false;
    this.crq = new LifecycleRegistry(this);
    AppMethodBeat.o(197719);
  }
  
  private Drawable KG()
  {
    AppMethodBeat.i(197723);
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject1 == null) {
          break label106;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject1 = getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
            AppMethodBeat.o(197723);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(197723);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(197723);
        return null;
      }
      AppMethodBeat.o(197723);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a KH()
  {
    AppMethodBeat.i(197724);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(197724);
      return locala;
    }
    d.a locala = d.a.SMF;
    AppMethodBeat.o(197724);
    return locala;
  }
  
  protected View KE()
  {
    AppMethodBeat.i(197720);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.crn.hrQ(), new LinearLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(197720);
    return localLinearLayout;
  }
  
  public final j KF()
  {
    AppMethodBeat.i(197722);
    Object localObject = KG();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(197722);
      return localObject;
    }
    AppMethodBeat.o(197722);
    return null;
  }
  
  public final b KI()
  {
    return this;
  }
  
  public final String KJ()
  {
    AppMethodBeat.i(197737);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(197737);
    return str;
  }
  
  public final String KK()
  {
    AppMethodBeat.i(197738);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(197738);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(197738);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(197738);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(197738);
    return "main";
  }
  
  public final String KL()
  {
    AppMethodBeat.i(197739);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(197739);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(197739);
    return str;
  }
  
  public final String KM()
  {
    AppMethodBeat.i(197740);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(197740);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.InitialRoute");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(197740);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(197740);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(197740);
    return "/";
  }
  
  public final FlutterView.b KN()
  {
    AppMethodBeat.i(197741);
    if (KH() == d.a.SMF)
    {
      localb = FlutterView.b.SNy;
      AppMethodBeat.o(197741);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.SNz;
    AppMethodBeat.o(197741);
    return localb;
  }
  
  public final FlutterView.c KO()
  {
    AppMethodBeat.i(197742);
    if (this.crp)
    {
      localc = FlutterView.c.SND;
      AppMethodBeat.o(197742);
      return localc;
    }
    if (KH() == d.a.SMF)
    {
      localc = FlutterView.c.SNC;
      AppMethodBeat.o(197742);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.SND;
    AppMethodBeat.o(197742);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a KP()
  {
    AppMethodBeat.i(197743);
    io.flutter.embedding.engine.a locala = c.hrH().SxF;
    AppMethodBeat.o(197743);
    return locala;
  }
  
  public String KQ()
  {
    AppMethodBeat.i(197744);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(197744);
      return str;
    }
    if (TextUtils.isEmpty(this.crm)) {
      this.crm = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.crm;
    AppMethodBeat.o(197744);
    return str;
  }
  
  public String KR()
  {
    AppMethodBeat.i(197745);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(197745);
      return str;
    }
    AppMethodBeat.o(197745);
    return "";
  }
  
  public Map KS()
  {
    AppMethodBeat.i(197746);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      Map localMap = ((com.tencent.wxa.d.a)getIntent().getSerializableExtra("params")).map;
      if (this.crp) {
        localMap.put("transparent", Boolean.valueOf(this.crp));
      }
      AppMethodBeat.o(197746);
      return localMap;
    }
    AppMethodBeat.o(197746);
    return null;
  }
  
  public final void KT()
  {
    AppMethodBeat.i(197747);
    if (getIntent().hasExtra("LiteApp")) {
      this.cro = ((WxaLiteAppInfo)getIntent().getParcelableExtra("LiteApp"));
    }
    AppMethodBeat.o(197747);
  }
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(197748);
    SwipeBackLayout localSwipeBackLayout = this.hfl;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwipeBackLayout.setEnableGesture(paramBoolean);
      AppMethodBeat.o(197748);
      return;
    }
  }
  
  public final void c(io.flutter.embedding.engine.a parama) {}
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.crq;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(197731);
    this.crn.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(197731);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(197733);
    this.crn.onBackPressed();
    AppMethodBeat.o(197733);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197721);
    for (;;)
    {
      try
      {
        ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
        if (localActivityInfo.metaData == null) {
          continue;
        }
        int i = localActivityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        io.flutter.a.hwg();
        continue;
      }
      super.onCreate(paramBundle);
      this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.crn = new com.tencent.wxa.ui.a(this);
      this.crn.hrO();
      setContentView(KE());
      AppMethodBeat.o(197721);
      return;
      io.flutter.a.hwe();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(197730);
    super.onDestroy();
    this.crn.onDestroyView();
    this.crn.onDetach();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(197730);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(197732);
    super.onNewIntent(paramIntent);
    this.crn.onNewIntent(paramIntent);
    AppMethodBeat.o(197732);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(197728);
    super.onPause();
    this.crn.onPause();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(197728);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(197727);
    super.onPostResume();
    this.crn.onPostResume();
    AppMethodBeat.o(197727);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(197734);
    this.crn.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(197734);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(197726);
    super.onResume();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.crn.onResume();
    AppMethodBeat.o(197726);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(197725);
    super.onStart();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.crn.onStart();
    AppMethodBeat.o(197725);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(197729);
    super.onStop();
    this.crn.onStop();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(197729);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(197736);
    this.crn.onTrimMemory(paramInt);
    AppMethodBeat.o(197736);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(197735);
    this.crn.onUserLeaveHint();
    AppMethodBeat.o(197735);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppBaseUI
 * JD-Core Version:    0.7.0.1
 */