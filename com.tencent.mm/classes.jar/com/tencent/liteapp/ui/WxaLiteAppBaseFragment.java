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
import androidx.lifecycle.l;
import com.tencent.liteapp.b.a;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.wxa.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.e.a;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaLiteAppBaseFragment
  extends Fragment
  implements l, com.tencent.wxa.b.b, a.a
{
  public static final String cpb;
  protected String Ln;
  protected long appPtr = 0L;
  protected String cpc;
  protected com.tencent.wxa.ui.a cpd;
  protected WxaLiteAppInfo cpe;
  protected boolean cpf = false;
  protected View cpg;
  protected String cph;
  protected String mAppId;
  
  static
  {
    AppMethodBeat.i(258624);
    cpb = e.a.aaoG.name();
    AppMethodBeat.o(258624);
  }
  
  private e.a Ns()
  {
    AppMethodBeat.i(258585);
    if (getArguments().containsKey("background_mode"))
    {
      locala = e.a.valueOf(getArguments().getString("background_mode"));
      AppMethodBeat.o(258585);
      return locala;
    }
    if (getActivity().getIntent().hasExtra("background_mode"))
    {
      locala = e.a.valueOf(getActivity().getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(258585);
      return locala;
    }
    e.a locala = e.a.aaoG;
    AppMethodBeat.o(258585);
    return locala;
  }
  
  private Drawable Nt()
  {
    AppMethodBeat.i(258587);
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
            AppMethodBeat.o(258587);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(258587);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(258587);
        return null;
      }
      AppMethodBeat.o(258587);
      return null;
      label115:
      Object localObject2 = null;
    }
  }
  
  public final FlutterView.b NA()
  {
    AppMethodBeat.i(258599);
    if (Ns() == e.a.aaoG)
    {
      localb = FlutterView.b.aapw;
      AppMethodBeat.o(258599);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.aapx;
    AppMethodBeat.o(258599);
    return localb;
  }
  
  public final FlutterView.c NB()
  {
    AppMethodBeat.i(258600);
    if (Ns() == e.a.aaoG)
    {
      localc = FlutterView.c.aapA;
      AppMethodBeat.o(258600);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.aapB;
    AppMethodBeat.o(258600);
    return localc;
  }
  
  public final j NC()
  {
    AppMethodBeat.i(258602);
    Object localObject = Nt();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(258602);
      return localObject;
    }
    AppMethodBeat.o(258602);
    return null;
  }
  
  public final io.flutter.embedding.engine.a ND()
  {
    AppMethodBeat.i(258605);
    io.flutter.embedding.engine.a locala = com.tencent.wxa.c.ivt().ZYJ;
    AppMethodBeat.o(258605);
    return locala;
  }
  
  public String NE()
  {
    AppMethodBeat.i(258615);
    if ((getArguments().containsKey("activityId")) && (!TextUtils.isEmpty(getArguments().getString("activityId"))))
    {
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewId from Arguments", new Object[0]);
      str = getArguments().getString("activityId");
      AppMethodBeat.o(258615);
      return str;
    }
    if ((getActivity().getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getActivity().getIntent().getStringExtra("activityId"))))
    {
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewId from Activity Intent", new Object[0]);
      str = getActivity().getIntent().getStringExtra("activityId");
      AppMethodBeat.o(258615);
      return str;
    }
    if (TextUtils.isEmpty(this.cpc)) {
      this.cpc = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.cpc;
    AppMethodBeat.o(258615);
    return str;
  }
  
  public String NF()
  {
    AppMethodBeat.i(258617);
    String str;
    if ((getArguments().containsKey("name")) && (!TextUtils.isEmpty(getArguments().getString("name"))))
    {
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewName from Arguments", new Object[0]);
      str = getArguments().getString("name");
      AppMethodBeat.o(258617);
      return str;
    }
    if (getActivity().getIntent().hasExtra("name"))
    {
      str = getActivity().getIntent().getStringExtra("name");
      AppMethodBeat.o(258617);
      return str;
    }
    AppMethodBeat.o(258617);
    return "";
  }
  
  public Map NG()
  {
    AppMethodBeat.i(258619);
    Map localMap;
    if ((getArguments().containsKey("params")) && ((getArguments().getSerializable("params") instanceof com.tencent.wxa.d.a)))
    {
      localMap = ((com.tencent.wxa.d.a)getArguments().getSerializable("params")).map;
      if (this.cpf) {
        localMap.put("transparent", Boolean.valueOf(this.cpf));
      }
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewParams from Arguments", new Object[0]);
      AppMethodBeat.o(258619);
      return localMap;
    }
    if ((getActivity().getIntent().hasExtra("params")) && ((getActivity().getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      localMap = ((com.tencent.wxa.d.a)getActivity().getIntent().getSerializableExtra("params")).map;
      if (this.cpf) {
        localMap.put("transparent", Boolean.valueOf(this.cpf));
      }
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getFlutterViewParams from Activity Intent", new Object[0]);
      AppMethodBeat.o(258619);
      return localMap;
    }
    AppMethodBeat.o(258619);
    return null;
  }
  
  public final void Nu()
  {
    AppMethodBeat.i(258588);
    if (getArguments().containsKey("LiteApp"))
    {
      this.cpe = ((WxaLiteAppInfo)getArguments().getParcelable("LiteApp"));
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Arguments KEY_LITE_APP", new Object[0]);
      if (!getArguments().containsKey("query")) {
        break label307;
      }
      this.Ln = getArguments().getString("query");
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mQuery from Arguments KEY_QUERY", new Object[0]);
    }
    for (;;)
    {
      if (!getArguments().containsKey("page")) {
        break label370;
      }
      this.cph = getArguments().getString("page");
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mPage from Arguments KEY_PAGE", new Object[0]);
      AppMethodBeat.o(258588);
      return;
      String str;
      b.a locala;
      if (getArguments().containsKey("LiteAppId"))
      {
        str = getArguments().getString("LiteAppId");
        locala = com.tencent.liteapp.b.cox;
        this.cpe = b.a.cY(str);
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Arguments KEY_LITE_APP_ID", new Object[0]);
        break;
      }
      if (getActivity().getIntent().hasExtra("LiteApp"))
      {
        this.cpe = ((WxaLiteAppInfo)getActivity().getIntent().getParcelableExtra("LiteApp"));
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Activity Intent KEY_LITE_APP", new Object[0]);
        break;
      }
      if (getActivity().getIntent().hasExtra("LiteAppId"))
      {
        str = getActivity().getIntent().getStringExtra("LiteAppId");
        locala = com.tencent.liteapp.b.cox;
        this.cpe = b.a.cY(str);
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "getWxaLiteAppInfo from Activity Intent KEY_LITE_APP_ID", new Object[0]);
        break;
      }
      com.tencent.liteapp.b.b.w("WxaLiteAp.WxaLiteAppBaseFragment", "Not contains app info.", new Object[0]);
      break;
      label307:
      if (getActivity().getIntent().hasExtra("query"))
      {
        this.Ln = getActivity().getIntent().getStringExtra("query");
        com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mQuery from Activity Intent KEY_QUERY", new Object[0]);
      }
      else
      {
        com.tencent.liteapp.b.b.w("WxaLiteAp.WxaLiteAppBaseFragment", "Not contains query info.", new Object[0]);
      }
    }
    label370:
    if (getActivity().getIntent().hasExtra("page"))
    {
      this.cph = getActivity().getIntent().getStringExtra("page");
      com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "mPage from Activity Intent KEY_PAGE", new Object[0]);
      AppMethodBeat.o(258588);
      return;
    }
    com.tencent.liteapp.b.b.w("WxaLiteAp.WxaLiteAppBaseFragment", "Not contains page info.", new Object[0]);
    AppMethodBeat.o(258588);
  }
  
  public final com.tencent.wxa.b.b Nv()
  {
    return this;
  }
  
  public final String Nw()
  {
    AppMethodBeat.i(258590);
    if (getArguments().containsKey("cached_engine_id"))
    {
      str = getArguments().getString("cached_engine_id");
      AppMethodBeat.o(258590);
      return str;
    }
    String str = getActivity().getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(258590);
    return str;
  }
  
  public final String Nx()
  {
    AppMethodBeat.i(258592);
    Object localObject1;
    if (getArguments().containsKey("dart_entrypoint"))
    {
      localObject1 = getArguments().getString("dart_entrypoint");
      AppMethodBeat.o(258592);
      return localObject1;
    }
    if (getActivity().getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(258592);
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
          AppMethodBeat.o(258592);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.liteapp.b.b.e("WxaLiteAp.WxaLiteAppBaseFragment", "getDartEntrypointFunctionName fail. %s", new Object[] { localNameNotFoundException.toString() });
        AppMethodBeat.o(258592);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(258592);
    return "main";
  }
  
  public final String Ny()
  {
    AppMethodBeat.i(258594);
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(258594);
    return str;
  }
  
  public final String Nz()
  {
    AppMethodBeat.i(258597);
    Object localObject1;
    if (getArguments().containsKey("initial_route"))
    {
      localObject1 = getArguments().getString("initial_route");
      AppMethodBeat.o(258597);
      return localObject1;
    }
    if (getActivity().getIntent().hasExtra("initial_route"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(258597);
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
          AppMethodBeat.o(258597);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(258597);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(258597);
    return "/";
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    return null;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bZ(boolean paramBoolean) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(258578);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(258578);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(258564);
    super.onAttach(paramContext);
    AppMethodBeat.o(258564);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(258576);
    this.cpd.oC(true);
    AppMethodBeat.o(258576);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(258562);
    super.onCreate(paramBundle);
    this.cpd = new com.tencent.wxa.ui.a(this);
    paramBundle = this.cpd;
    getContext();
    paramBundle.ivA();
    paramBundle = getContext();
    long l = this.appPtr;
    Point localPoint = com.tencent.mm.ext.ui.e.au(paramBundle);
    Object localObject = ((WindowManager)paramBundle.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    int i = localPoint.x;
    int j = localPoint.y;
    localObject = Float.valueOf(localDisplayMetrics.density);
    int k = com.tencent.liteapp.d.e.at(paramBundle);
    int m = com.tencent.liteapp.d.e.aB(paramBundle);
    float f = 48.0F * ((Float)localObject).floatValue();
    LiteAppCenter.setDisplayParams(l, i / ((Float)localObject).floatValue(), j / ((Float)localObject).floatValue(), localPoint.x / ((Float)localObject).floatValue(), localPoint.y / ((Float)localObject).floatValue(), localDisplayMetrics.densityDpi, ((Float)localObject).floatValue(), f / ((Float)localObject).floatValue(), 0.0F, 0.0F);
    com.tencent.liteapp.b.b.i("WxaLiteAp.WxaLiteAppBaseFragment", "updateLvCppDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.densityDpi), localObject, Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) });
    AppMethodBeat.o(258562);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(258582);
    this.cpg = this.cpd.ivC();
    paramLayoutInflater = this.cpg;
    AppMethodBeat.o(258582);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(258574);
    super.onDestroy();
    this.cpd.onDestroyView();
    com.tencent.wxa.ui.a locala = this.cpd;
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onCloseView()", new Object[0]);
    locala.ZZl.ivz();
    this.cpd.onDetach();
    AppMethodBeat.o(258574);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(258567);
    super.onDetach();
    AppMethodBeat.o(258567);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(258573);
    super.onPause();
    this.cpd.onPause();
    AppMethodBeat.o(258573);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(258579);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(258579);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(258571);
    super.onResume();
    this.cpd.onResume();
    AppMethodBeat.o(258571);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(258569);
    super.onStart();
    this.cpd.onStart();
    AppMethodBeat.o(258569);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(258584);
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(258584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppBaseFragment
 * JD-Core Version:    0.7.0.1
 */