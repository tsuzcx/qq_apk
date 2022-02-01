package com.tencent.mm.plugin.lite.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.wxa.b.b;
import com.tencent.wxa.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;

public class WxaLiteAppBaseFragment
  extends Fragment
  implements LifecycleOwner, com.tencent.liteapp.ui.a, b, a.a
{
  protected String crm;
  protected com.tencent.wxa.ui.a crn;
  HashMap<String, Object> mMap;
  String mName;
  View yFg;
  a yFh;
  
  public WxaLiteAppBaseFragment()
  {
    AppMethodBeat.i(198908);
    this.mMap = new HashMap();
    AppMethodBeat.o(198908);
  }
  
  private Drawable KG()
  {
    AppMethodBeat.i(198928);
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
            AppMethodBeat.o(198928);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(198928);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(198928);
        return null;
      }
      AppMethodBeat.o(198928);
      return null;
      label115:
      Object localObject2 = null;
    }
  }
  
  private d.a KH()
  {
    AppMethodBeat.i(198930);
    if (getActivity().getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getActivity().getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(198930);
      return locala;
    }
    d.a locala = d.a.SMF;
    AppMethodBeat.o(198930);
    return locala;
  }
  
  public final void KC()
  {
    AppMethodBeat.i(198934);
    if (d.oD(19))
    {
      getActivity().getWindow().clearFlags(201327616);
      View localView = getActivity().getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD & 0xFFFFEFFF);
      AppMethodBeat.o(198934);
      return;
    }
    getActivity().getWindow().clearFlags(1024);
    AppMethodBeat.o(198934);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(198933);
    if (d.oD(19))
    {
      getActivity().getWindow().setFlags(201327616, 201327616);
      View localView = getActivity().getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x1002);
      AppMethodBeat.o(198933);
      return;
    }
    getActivity().getWindow().setFlags(1024, 1024);
    AppMethodBeat.o(198933);
  }
  
  public final j KF()
  {
    AppMethodBeat.i(198927);
    Object localObject = KG();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(198927);
      return localObject;
    }
    AppMethodBeat.o(198927);
    return null;
  }
  
  public final b KI()
  {
    return this;
  }
  
  public final String KJ()
  {
    AppMethodBeat.i(198920);
    String str = getActivity().getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(198920);
    return str;
  }
  
  public final String KK()
  {
    AppMethodBeat.i(198921);
    Object localObject1;
    if (getActivity().getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(198921);
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
          AppMethodBeat.o(198921);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(198921);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(198921);
    return "main";
  }
  
  public final String KL()
  {
    AppMethodBeat.i(198922);
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(198922);
    return str;
  }
  
  public final String KM()
  {
    AppMethodBeat.i(198923);
    Object localObject1;
    if (getActivity().getIntent().hasExtra("initial_route"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(198923);
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
          AppMethodBeat.o(198923);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(198923);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(198923);
    return "/";
  }
  
  public final FlutterView.b KN()
  {
    AppMethodBeat.i(198924);
    if (KH() == d.a.SMF)
    {
      localb = FlutterView.b.SNy;
      AppMethodBeat.o(198924);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.SNz;
    AppMethodBeat.o(198924);
    return localb;
  }
  
  public final FlutterView.c KO()
  {
    AppMethodBeat.i(198925);
    if (KH() == d.a.SMF)
    {
      localc = FlutterView.c.SNC;
      AppMethodBeat.o(198925);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.SND;
    AppMethodBeat.o(198925);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a KP()
  {
    AppMethodBeat.i(198926);
    io.flutter.embedding.engine.a locala = com.tencent.wxa.c.hrH().SxF;
    AppMethodBeat.o(198926);
    return locala;
  }
  
  public final String KQ()
  {
    AppMethodBeat.i(198929);
    if ((getActivity().getIntent().hasExtra("activityId")) && (!Util.isNullOrNil(getActivity().getIntent().getStringExtra("activityId"))))
    {
      str = getActivity().getIntent().getStringExtra("activityId");
      AppMethodBeat.o(198929);
      return str;
    }
    if (Util.isNullOrNil(this.crm)) {
      this.crm = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.crm;
    AppMethodBeat.o(198929);
    return str;
  }
  
  public final String KR()
  {
    return this.mName;
  }
  
  public final Map KS()
  {
    return this.mMap;
  }
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bP(boolean paramBoolean) {}
  
  public final void c(io.flutter.embedding.engine.a parama) {}
  
  public final void hD(int paramInt)
  {
    AppMethodBeat.i(198931);
    Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    View localView = getActivity().getWindow().getDecorView();
    localView.scrollTo(localView.getScrollX(), paramInt);
    AppMethodBeat.o(198931);
  }
  
  public final void hideKeyboard()
  {
    AppMethodBeat.i(198932);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
    AppMethodBeat.o(198932);
  }
  
  public void navigateBack() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(198917);
    this.crn.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(198917);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(198910);
    Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onAttach");
    super.onAttach(paramContext);
    AppMethodBeat.o(198910);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198909);
    super.onCreate(paramBundle);
    this.crn = new com.tencent.wxa.ui.a(this);
    paramBundle = this.crn;
    getContext();
    paramBundle.hrO();
    Object localObject = getArguments();
    paramBundle = ((Bundle)localObject).getString("appId");
    localObject = LiteAppCenter.showIndexView(paramBundle, s.k(((Bundle)localObject).getString("pkgPath"), false), ((Bundle)localObject).getString("signatureKey"), "");
    this.mMap.put("appId", paramBundle);
    this.mMap.put("appPtr", Long.valueOf(((LiteAppCenter.PageInfo)localObject).appPtr));
    this.mMap.put("pageViewId", Long.valueOf(((LiteAppCenter.PageInfo)localObject).pageId));
    this.mMap.put("basePath", ((LiteAppCenter.PageInfo)localObject).basePath);
    this.mMap.put("pageRenderPtr", Long.valueOf(((LiteAppCenter.PageInfo)localObject).renderId));
    this.mMap.put("startTime", Long.valueOf(System.currentTimeMillis()));
    this.mName = Long.toString(((LiteAppCenter.PageInfo)localObject).pageId);
    AppMethodBeat.o(198909);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(198919);
    this.yFg = this.crn.hrQ();
    this.yFg.getViewTreeObserver().addOnGlobalLayoutListener(new WxaLiteAppBaseFragment.1(this));
    this.yFh = new a(getContext());
    this.yFh.setLayoutParams(new LinearLayout.LayoutParams(-1, 900));
    this.yFh.addView(this.yFg);
    paramLayoutInflater = this.yFh;
    AppMethodBeat.o(198919);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(198916);
    super.onDestroy();
    this.crn.onDestroyView();
    com.tencent.wxa.ui.a locala = this.crn;
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onCloseView()", new Object[0]);
    locala.Sye.hrN();
    this.crn.onDetach();
    AppMethodBeat.o(198916);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(198911);
    Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onDetach");
    super.onDetach();
    AppMethodBeat.o(198911);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(198914);
    super.onPause();
    this.crn.onPause();
    AppMethodBeat.o(198914);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(198918);
    this.crn.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(198918);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(198913);
    super.onResume();
    this.crn.onResume();
    AppMethodBeat.o(198913);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(198912);
    Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onStart");
    super.onStart();
    this.crn.onStart();
    AppMethodBeat.o(198912);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(198915);
    super.onStop();
    this.crn.onStop();
    AppMethodBeat.o(198915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppBaseFragment
 * JD-Core Version:    0.7.0.1
 */