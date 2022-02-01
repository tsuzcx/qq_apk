package com.tencent.liteapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import com.tencent.liteapp.b.a;
import com.tencent.liteapp.d.f;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.wxa.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Constructor;
import java.util.Map;

public class WxaLiteAppBaseFragment
  extends Fragment
  implements q, com.tencent.wxa.b.b, a.a
{
  public static final String DEFAULT_BACKGROUND_MODE;
  protected long appPtr = 0L;
  protected String brD;
  protected String egQ;
  protected com.tencent.wxa.ui.a egR;
  protected WxaLiteAppInfo egS;
  protected boolean egT = false;
  protected boolean egU = false;
  protected String egV;
  protected String mAppId;
  protected View mFlutterView;
  long renderId = -1L;
  
  static
  {
    AppMethodBeat.i(219118);
    DEFAULT_BACKGROUND_MODE = FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();
    AppMethodBeat.o(219118);
  }
  
  private FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    AppMethodBeat.i(219100);
    if (getArguments().containsKey("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getArguments().getString("background_mode"));
      AppMethodBeat.o(219100);
      return localBackgroundMode;
    }
    if (getActivity().getIntent().hasExtra("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getActivity().getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(219100);
      return localBackgroundMode;
    }
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    AppMethodBeat.o(219100);
    return localBackgroundMode;
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    AppMethodBeat.i(219109);
    for (;;)
    {
      try
      {
        Object localObject1 = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128).metaData;
        if (localObject1 == null) {
          break label115;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject1 = getResources().getDrawable(((Integer)localObject1).intValue(), getActivity().getTheme());
            AppMethodBeat.o(219109);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(219109);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(219109);
        return null;
      }
      AppMethodBeat.o(219109);
      return null;
      label115:
      Object localObject2 = null;
    }
  }
  
  public final void anL()
  {
    AppMethodBeat.i(219190);
    if (getArguments().containsKey("LiteApp"))
    {
      this.egS = ((WxaLiteAppInfo)getArguments().getParcelable("LiteApp"));
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Arguments KEY_LITE_APP", new Object[0]);
      if (!getArguments().containsKey("query")) {
        break label286;
      }
      this.brD = getArguments().getString("query");
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mQuery from Arguments KEY_QUERY", new Object[0]);
    }
    for (;;)
    {
      if (!getArguments().containsKey("page")) {
        break label391;
      }
      this.egV = getArguments().getString("page");
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mPage from Arguments KEY_PAGE", new Object[0]);
      AppMethodBeat.o(219190);
      return;
      String str;
      b.a locala;
      if (getArguments().containsKey("LiteAppId"))
      {
        str = getArguments().getString("LiteAppId");
        locala = com.tencent.liteapp.b.efD;
        this.egS = b.a.et(str);
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Arguments KEY_LITE_APP_ID", new Object[0]);
        break;
      }
      if (getActivity().getIntent().hasExtra("LiteApp"))
      {
        this.egS = ((WxaLiteAppInfo)getActivity().getIntent().getParcelableExtra("LiteApp"));
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Activity Intent KEY_LITE_APP", new Object[0]);
        break;
      }
      if (getActivity().getIntent().hasExtra("LiteAppId"))
      {
        str = getActivity().getIntent().getStringExtra("LiteAppId");
        locala = com.tencent.liteapp.b.efD;
        this.egS = b.a.et(str);
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Activity Intent KEY_LITE_APP_ID", new Object[0]);
        break;
      }
      com.tencent.liteapp.b.b.w("WxaLiteAp.WxaLiteAppBaseFragment", "Not contains app info.", new Object[0]);
      break;
      label286:
      if (getActivity().getIntent().hasExtra("query"))
      {
        this.brD = getActivity().getIntent().getStringExtra("query");
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mQuery from Activity Intent KEY_QUERY", new Object[0]);
      }
      else if (getActivity().getIntent().hasExtra("openWithNewTab"))
      {
        this.egU = getActivity().getIntent().getBooleanExtra("openWithNewTab", false);
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mOpenWithNewTab from Activity Intent KEY_NEW_TAB", new Object[0]);
      }
      else
      {
        com.tencent.liteapp.b.b.w("WxaLiteAp.WxaLiteAppBaseFragment", "Not contains query info.", new Object[0]);
      }
    }
    label391:
    if (getActivity().getIntent().hasExtra("page"))
    {
      this.egV = getActivity().getIntent().getStringExtra("page");
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mPage from Activity Intent KEY_PAGE", new Object[0]);
      AppMethodBeat.o(219190);
      return;
    }
    com.tencent.liteapp.b.b.w("WxaLiteAp.WxaLiteAppBaseFragment", "Not contains page info.", new Object[0]);
    AppMethodBeat.o(219190);
  }
  
  public final com.tencent.wxa.b.b anM()
  {
    return this;
  }
  
  public final FlutterView.RenderMode anN()
  {
    AppMethodBeat.i(219205);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localRenderMode = FlutterView.RenderMode.surface;
      AppMethodBeat.o(219205);
      return localRenderMode;
    }
    FlutterView.RenderMode localRenderMode = FlutterView.RenderMode.texture;
    AppMethodBeat.o(219205);
    return localRenderMode;
  }
  
  public final FlutterView.TransparencyMode anO()
  {
    AppMethodBeat.i(219209);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localTransparencyMode = FlutterView.TransparencyMode.opaque;
      AppMethodBeat.o(219209);
      return localTransparencyMode;
    }
    FlutterView.TransparencyMode localTransparencyMode = FlutterView.TransparencyMode.transparent;
    AppMethodBeat.o(219209);
    return localTransparencyMode;
  }
  
  public String anP()
  {
    AppMethodBeat.i(219224);
    if ((getArguments().containsKey("activityId")) && (!TextUtils.isEmpty(getArguments().getString("activityId"))))
    {
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewId from Arguments", new Object[0]);
      str = getArguments().getString("activityId");
      AppMethodBeat.o(219224);
      return str;
    }
    if ((getActivity().getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getActivity().getIntent().getStringExtra("activityId"))))
    {
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewId from Activity Intent", new Object[0]);
      str = getActivity().getIntent().getStringExtra("activityId");
      AppMethodBeat.o(219224);
      return str;
    }
    if (TextUtils.isEmpty(this.egQ)) {
      this.egQ = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.egQ;
    AppMethodBeat.o(219224);
    return str;
  }
  
  public String anQ()
  {
    AppMethodBeat.i(219227);
    String str;
    if ((getArguments().containsKey("name")) && (!TextUtils.isEmpty(getArguments().getString("name"))))
    {
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewName from Arguments", new Object[0]);
      str = getArguments().getString("name");
      AppMethodBeat.o(219227);
      return str;
    }
    if (getActivity().getIntent().hasExtra("name"))
    {
      str = getActivity().getIntent().getStringExtra("name");
      AppMethodBeat.o(219227);
      return str;
    }
    AppMethodBeat.o(219227);
    return "";
  }
  
  public Map anR()
  {
    AppMethodBeat.i(219231);
    Map localMap;
    if ((getArguments().containsKey("params")) && ((getArguments().getSerializable("params") instanceof com.tencent.wxa.d.a)))
    {
      localMap = ((com.tencent.wxa.d.a)getArguments().getSerializable("params")).map;
      if (this.egT) {
        localMap.put("transparent", Boolean.valueOf(this.egT));
      }
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewParams from Arguments", new Object[0]);
      AppMethodBeat.o(219231);
      return localMap;
    }
    if ((getActivity().getIntent().hasExtra("params")) && ((getActivity().getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      localMap = ((com.tencent.wxa.d.a)getActivity().getIntent().getSerializableExtra("params")).map;
      if (this.egT) {
        localMap.put("transparent", Boolean.valueOf(this.egT));
      }
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewParams from Activity Intent", new Object[0]);
      AppMethodBeat.o(219231);
      return localMap;
    }
    AppMethodBeat.o(219231);
    return null;
  }
  
  public final void cG(boolean paramBoolean) {}
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public final String getAppBundlePath()
  {
    AppMethodBeat.i(219200);
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(219200);
    return str;
  }
  
  public final String getCachedEngineId()
  {
    AppMethodBeat.i(219194);
    if (getArguments().containsKey("cached_engine_id"))
    {
      str = getArguments().getString("cached_engine_id");
      AppMethodBeat.o(219194);
      return str;
    }
    String str = getActivity().getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(219194);
    return str;
  }
  
  public final String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(219197);
    Object localObject1;
    if (getArguments().containsKey("dart_entrypoint"))
    {
      localObject1 = getArguments().getString("dart_entrypoint");
      AppMethodBeat.o(219197);
      return localObject1;
    }
    if (getActivity().getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(219197);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(219197);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.liteapp.b.b.e("WxaLiteAp.WxaLiteAppBaseFragment", "getDartEntrypointFunctionName fail. %s", new Object[] { localNameNotFoundException.toString() });
        AppMethodBeat.o(219197);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(219197);
    return "main";
  }
  
  public final String getInitialRoute()
  {
    AppMethodBeat.i(219203);
    Object localObject1;
    if (getArguments().containsKey("initial_route"))
    {
      localObject1 = getArguments().getString("initial_route");
      AppMethodBeat.o(219203);
      return localObject1;
    }
    if (getActivity().getIntent().hasExtra("initial_route"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(219203);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.InitialRoute");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(219203);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(219203);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(219203);
    return "/";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(219175);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(219175);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(219137);
    super.onAttach(paramContext);
    AppMethodBeat.o(219137);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(219171);
    this.egR.qf(true);
    AppMethodBeat.o(219171);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219131);
    super.onCreate(paramBundle);
    this.egR = new com.tencent.wxa.ui.a(this);
    paramBundle = this.egR;
    getContext();
    paramBundle.keU();
    paramBundle = getContext();
    long l = this.appPtr;
    Point localPoint = e.bf(paramBundle);
    Object localObject = ((WindowManager)paramBundle.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    int i = localPoint.x;
    int j = localPoint.y;
    localObject = Float.valueOf(localDisplayMetrics.density);
    int k = f.be(paramBundle);
    int m = f.bk(paramBundle);
    float f = f.anV() * ((Float)localObject).floatValue();
    LiteAppCenter.setDisplayParams(l, i / ((Float)localObject).floatValue(), j / ((Float)localObject).floatValue(), localPoint.x / ((Float)localObject).floatValue(), localPoint.y / ((Float)localObject).floatValue(), localDisplayMetrics.densityDpi, ((Float)localObject).floatValue(), f / ((Float)localObject).floatValue(), 0.0F, 0.0F);
    com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "updateLvCppDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.densityDpi), localObject, Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) });
    AppMethodBeat.o(219131);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(219181);
    this.mFlutterView = this.egR.keV();
    paramLayoutInflater = this.mFlutterView;
    AppMethodBeat.o(219181);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(219168);
    super.onDestroy();
    this.egR.onDestroyView();
    com.tencent.wxa.ui.a locala = this.egR;
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onCloseView()", new Object[0]);
    locala.aidW.keT();
    this.egR.onDetach();
    AppMethodBeat.o(219168);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(219142);
    super.onDetach();
    AppMethodBeat.o(219142);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(219164);
    super.onPause();
    this.egR.onPause();
    AppMethodBeat.o(219164);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(219178);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(219178);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(219159);
    super.onResume();
    this.egR.onResume();
    AppMethodBeat.o(219159);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(219153);
    super.onStart();
    this.egR.onStart();
    AppMethodBeat.o(219153);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(219183);
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(219183);
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    AppMethodBeat.i(219216);
    paramContext = com.tencent.wxa.c.keQ().OM(this.egU);
    AppMethodBeat.o(219216);
    return paramContext;
  }
  
  public final PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(219212);
    Object localObject = getSplashScreenFromManifest();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(219212);
      return localObject;
    }
    AppMethodBeat.o(219212);
    return null;
  }
  
  public static final class a
  {
    private String appId;
    private boolean egU = false;
    private String egj;
    private final Class<? extends WxaLiteAppBaseFragment> fragmentClass;
    private String query;
    private RenderMode renderMode = RenderMode.surface;
    private boolean shouldAttachEngineToActivity = true;
    private TransparencyMode transparencyMode = TransparencyMode.transparent;
    
    public a()
    {
      this.fragmentClass = WxaLiteAppBaseFragment.class;
    }
    
    public a(Class<? extends WxaLiteAppBaseFragment> paramClass)
    {
      this.fragmentClass = paramClass;
    }
    
    public final <T extends WxaLiteAppBaseFragment> T anS()
    {
      AppMethodBeat.i(219120);
      WxaLiteAppBaseFragment localWxaLiteAppBaseFragment;
      try
      {
        localWxaLiteAppBaseFragment = (WxaLiteAppBaseFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localWxaLiteAppBaseFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(219120);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", localException);
        AppMethodBeat.o(219120);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      if (this.renderMode != null)
      {
        localObject = this.renderMode.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.transparencyMode == null) {
          break label269;
        }
      }
      label269:
      for (Object localObject = this.transparencyMode.name();; localObject = TransparencyMode.transparent.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        if (this.appId != null) {
          localBundle.putString("LiteAppId", this.appId);
        }
        if (this.egj != null) {
          localBundle.putString("page", this.egj);
        }
        if (this.query != null) {
          localBundle.putString("query", this.query);
        }
        localBundle.putBoolean("openWithNewTab", this.egU);
        localWxaLiteAppBaseFragment.setArguments(localBundle);
        AppMethodBeat.o(219120);
        return localWxaLiteAppBaseFragment;
        localObject = RenderMode.surface.name();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppBaseFragment
 * JD-Core Version:    0.7.0.1
 */