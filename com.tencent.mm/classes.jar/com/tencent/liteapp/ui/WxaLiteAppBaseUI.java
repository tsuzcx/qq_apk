package com.tencent.liteapp.ui;

import android.app.Activity;
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
import androidx.lifecycle.j.a;
import androidx.lifecycle.s;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.SwipeBackActivity;
import com.tencent.mm.ext.ui.SwipeBackLayout;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.wxa.b.b;
import com.tencent.wxa.c;
import com.tencent.wxa.ui.a.a;
import io.flutter.Log;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaLiteAppBaseUI
  extends SwipeBackActivity
  implements b, a.a
{
  public static final String DEFAULT_BACKGROUND_MODE;
  protected String egQ;
  protected com.tencent.wxa.ui.a egR;
  protected WxaLiteAppInfo egS;
  protected boolean egT = false;
  protected boolean egU = false;
  protected LiteAppCenter.PageInfo egW;
  protected View mContentView;
  
  static
  {
    AppMethodBeat.i(219129);
    DEFAULT_BACKGROUND_MODE = FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();
    AppMethodBeat.o(219129);
  }
  
  private FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    AppMethodBeat.i(219123);
    if (getIntent().hasExtra("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(219123);
      return localBackgroundMode;
    }
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    AppMethodBeat.o(219123);
    return localBackgroundMode;
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    AppMethodBeat.i(219111);
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
            AppMethodBeat.o(219111);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(219111);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(219111);
        return null;
      }
      AppMethodBeat.o(219111);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  public final void anL()
  {
    AppMethodBeat.i(219241);
    if (getIntent().hasExtra("LiteApp")) {
      this.egS = ((WxaLiteAppInfo)getIntent().getParcelableExtra("LiteApp"));
    }
    AppMethodBeat.o(219241);
  }
  
  public final b anM()
  {
    return this;
  }
  
  public final FlutterView.RenderMode anN()
  {
    AppMethodBeat.i(219219);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localRenderMode = FlutterView.RenderMode.surface;
      AppMethodBeat.o(219219);
      return localRenderMode;
    }
    FlutterView.RenderMode localRenderMode = FlutterView.RenderMode.texture;
    AppMethodBeat.o(219219);
    return localRenderMode;
  }
  
  public final FlutterView.TransparencyMode anO()
  {
    AppMethodBeat.i(219221);
    if (this.egT)
    {
      localTransparencyMode = FlutterView.TransparencyMode.transparent;
      AppMethodBeat.o(219221);
      return localTransparencyMode;
    }
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localTransparencyMode = FlutterView.TransparencyMode.opaque;
      AppMethodBeat.o(219221);
      return localTransparencyMode;
    }
    FlutterView.TransparencyMode localTransparencyMode = FlutterView.TransparencyMode.transparent;
    AppMethodBeat.o(219221);
    return localTransparencyMode;
  }
  
  public String anP()
  {
    AppMethodBeat.i(219234);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(219234);
      return str;
    }
    if (TextUtils.isEmpty(this.egQ)) {
      this.egQ = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.egQ;
    AppMethodBeat.o(219234);
    return str;
  }
  
  public String anQ()
  {
    AppMethodBeat.i(219236);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(219236);
      return str;
    }
    AppMethodBeat.o(219236);
    return "";
  }
  
  public Map anR()
  {
    AppMethodBeat.i(219239);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      Map localMap = ((com.tencent.wxa.d.a)getIntent().getSerializableExtra("params")).map;
      if (this.egT) {
        localMap.put("transparent", Boolean.valueOf(this.egT));
      }
      AppMethodBeat.o(219239);
      return localMap;
    }
    AppMethodBeat.o(219239);
    return null;
  }
  
  protected View anT()
  {
    AppMethodBeat.i(219135);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.egR.keV(), new LinearLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(219135);
    return localLinearLayout;
  }
  
  public final void anU()
  {
    AppMethodBeat.i(219243);
    if (getIntent().hasExtra("pageInfo")) {
      this.egW = ((LiteAppCenter.PageInfo)getIntent().getParcelableExtra("pageInfo"));
    }
    AppMethodBeat.o(219243);
  }
  
  public final void cG(boolean paramBoolean)
  {
    AppMethodBeat.i(219245);
    SwipeBackLayout localSwipeBackLayout = aXf();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwipeBackLayout.setEnableGesture(paramBoolean);
      AppMethodBeat.o(219245);
      return;
    }
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public final void f(Boolean paramBoolean)
  {
    AppMethodBeat.i(219191);
    this.egR.qf(paramBoolean.booleanValue());
    AppMethodBeat.o(219191);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public final String getAppBundlePath()
  {
    AppMethodBeat.i(219214);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(219214);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(219214);
    return str;
  }
  
  public final String getCachedEngineId()
  {
    AppMethodBeat.i(219206);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(219206);
    return str;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public final String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(219210);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(219210);
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
          AppMethodBeat.o(219210);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(219210);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(219210);
    return "main";
  }
  
  public final FlutterEngine getFlutterEngine()
  {
    return this.egR.flutterEngine;
  }
  
  public final String getInitialRoute()
  {
    AppMethodBeat.i(219217);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(219217);
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
          AppMethodBeat.o(219217);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(219217);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(219217);
    return "/";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(219182);
    this.egR.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(219182);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(219187);
    this.egR.qf(true);
    AppMethodBeat.o(219187);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219146);
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
        Log.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        continue;
      }
      super.onCreate(paramBundle);
      c.keQ().init();
      ((s)getLifecycle()).a(j.a.ON_CREATE);
      this.egR = new com.tencent.wxa.ui.a(this);
      this.egR.keU();
      this.mContentView = anT();
      setContentView(this.mContentView);
      AppMethodBeat.o(219146);
      return;
      Log.d("FlutterActivity", "Using the launch theme as normal theme.");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(219179);
    super.onDestroy();
    if (this.egR != null)
    {
      this.egR.onDestroyView();
      this.egR.onDetach();
      ((s)getLifecycle()).a(j.a.ON_DESTROY);
    }
    AppMethodBeat.o(219179);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(219185);
    super.onNewIntent(paramIntent);
    this.egR.onNewIntent(paramIntent);
    AppMethodBeat.o(219185);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(219172);
    super.onPause();
    this.egR.onPause();
    ((s)getLifecycle()).a(j.a.ON_PAUSE);
    AppMethodBeat.o(219172);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(219169);
    super.onPostResume();
    this.egR.onPostResume();
    AppMethodBeat.o(219169);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(219193);
    this.egR.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(219193);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(219166);
    super.onResume();
    ((s)getLifecycle()).a(j.a.ON_RESUME);
    this.egR.onResume();
    AppMethodBeat.o(219166);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(219161);
    super.onStart();
    ((s)getLifecycle()).a(j.a.ON_START);
    this.egR.onStart();
    AppMethodBeat.o(219161);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(219176);
    super.onStop();
    this.egR.onStop();
    ((s)getLifecycle()).a(j.a.ON_STOP);
    AppMethodBeat.o(219176);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(219198);
    this.egR.onTrimMemory(paramInt);
    AppMethodBeat.o(219198);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(219196);
    this.egR.onUserLeaveHint();
    AppMethodBeat.o(219196);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    AppMethodBeat.i(219226);
    paramContext = c.keQ().OM(this.egU);
    AppMethodBeat.o(219226);
    return paramContext;
  }
  
  public final PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(219229);
    if (paramActivity != null)
    {
      paramActivity = new PlatformPlugin(this, paramFlutterEngine.getPlatformChannel());
      AppMethodBeat.o(219229);
      return paramActivity;
    }
    AppMethodBeat.o(219229);
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(219155);
    Object localObject = getSplashScreenFromManifest();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(219155);
      return localObject;
    }
    AppMethodBeat.o(219155);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppBaseUI
 * JD-Core Version:    0.7.0.1
 */