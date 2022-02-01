package com.tencent.mm.plugin.lite.ui;

import android.arch.lifecycle.LifecycleOwner;
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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.wax.b.c;
import com.tencent.wax.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.android.h;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;

public class WxaLiteAppBaseFragment
  extends Fragment
  implements LifecycleOwner, a, com.tencent.wax.b.b, a.a
{
  HashMap<String, Object> dz;
  String mName;
  protected com.tencent.wax.ui.a vkX;
  View vkY;
  b vkZ;
  protected String vla;
  
  public WxaLiteAppBaseFragment()
  {
    AppMethodBeat.i(212391);
    this.dz = new HashMap();
    AppMethodBeat.o(212391);
  }
  
  private Drawable diQ()
  {
    AppMethodBeat.i(212411);
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
            AppMethodBeat.o(212411);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(212411);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(212411);
        return null;
      }
      AppMethodBeat.o(212411);
      return null;
      label115:
      Object localObject2 = null;
    }
  }
  
  private d.a diU()
  {
    AppMethodBeat.i(212413);
    if (getActivity().getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getActivity().getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(212413);
      return locala;
    }
    d.a locala = d.a.MYs;
    AppMethodBeat.o(212413);
    return locala;
  }
  
  public final void Jt(int paramInt)
  {
    AppMethodBeat.i(212414);
    ae.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    View localView = getActivity().getWindow().getDecorView();
    localView.scrollTo(localView.getScrollX(), paramInt);
    AppMethodBeat.o(212414);
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bnT()
  {
    AppMethodBeat.i(212416);
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getActivity().getWindow().setFlags(201327616, 201327616);
      View localView = getActivity().getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x1002);
      AppMethodBeat.o(212416);
      return;
    }
    getActivity().getWindow().setFlags(1024, 1024);
    AppMethodBeat.o(212416);
  }
  
  public final void diF()
  {
    AppMethodBeat.i(212417);
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getActivity().getWindow().clearFlags(201327616);
      View localView = getActivity().getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD & 0xFFFFEFFF);
      AppMethodBeat.o(212417);
      return;
    }
    getActivity().getWindow().clearFlags(1024);
    AppMethodBeat.o(212417);
  }
  
  public final void diG()
  {
    AppMethodBeat.i(212415);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
    AppMethodBeat.o(212415);
  }
  
  public final com.tencent.wax.b.b diH()
  {
    return this;
  }
  
  public final String diI()
  {
    AppMethodBeat.i(212403);
    String str = getActivity().getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(212403);
    return str;
  }
  
  public final String diJ()
  {
    AppMethodBeat.i(212404);
    Object localObject1;
    if (getActivity().getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(212404);
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
          AppMethodBeat.o(212404);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(212404);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(212404);
    return "main";
  }
  
  public final String diK()
  {
    AppMethodBeat.i(212405);
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(212405);
    return str;
  }
  
  public final String diL()
  {
    AppMethodBeat.i(212406);
    Object localObject1;
    if (getActivity().getIntent().hasExtra("initial_route"))
    {
      localObject1 = getActivity().getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(212406);
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
          AppMethodBeat.o(212406);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(212406);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(212406);
    return "/";
  }
  
  public final FlutterView.b diM()
  {
    AppMethodBeat.i(212407);
    if (diU() == d.a.MYs)
    {
      localb = FlutterView.b.MYZ;
      AppMethodBeat.o(212407);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.MZa;
    AppMethodBeat.o(212407);
    return localb;
  }
  
  public final FlutterView.c diN()
  {
    AppMethodBeat.i(212408);
    if (diU() == d.a.MYs)
    {
      localc = FlutterView.c.MZc;
      AppMethodBeat.o(212408);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.MZd;
    AppMethodBeat.o(212408);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a diO()
  {
    AppMethodBeat.i(212409);
    io.flutter.embedding.engine.a locala = com.tencent.wax.d.gdr().cPI;
    AppMethodBeat.o(212409);
    return locala;
  }
  
  public final h diP()
  {
    AppMethodBeat.i(212410);
    Object localObject = diQ();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(212410);
      return localObject;
    }
    AppMethodBeat.o(212410);
    return null;
  }
  
  public final String diR()
  {
    AppMethodBeat.i(212412);
    if ((getActivity().getIntent().hasExtra("activityId")) && (!bu.isNullOrNil(getActivity().getIntent().getStringExtra("activityId"))))
    {
      str = getActivity().getIntent().getStringExtra("activityId");
      AppMethodBeat.o(212412);
      return str;
    }
    if (bu.isNullOrNil(this.vla)) {
      this.vla = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.vla;
    AppMethodBeat.o(212412);
    return str;
  }
  
  public final String diS()
  {
    return this.mName;
  }
  
  public final Map diT()
  {
    return this.dz;
  }
  
  public final void nX(boolean paramBoolean) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212400);
    this.vkX.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(212400);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(212393);
    ae.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onAttach");
    super.onAttach(paramContext);
    AppMethodBeat.o(212393);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212392);
    super.onCreate(paramBundle);
    this.vkX = new com.tencent.wax.ui.a(this);
    paramBundle = this.vkX;
    getContext();
    paramBundle.gdx();
    Object localObject = getArguments();
    paramBundle = ((Bundle)localObject).getString("appId");
    localObject = LiteAppCenter.showIndexView(paramBundle, ((Bundle)localObject).getString("pkgPath"), ((Bundle)localObject).getString("signatureKey"), "");
    this.dz.put("appId", paramBundle);
    this.dz.put("appPtr", Long.valueOf(((LiteAppCenter.PageInfo)localObject).appPtr));
    this.dz.put("pageViewId", Long.valueOf(((LiteAppCenter.PageInfo)localObject).pageId));
    this.dz.put("basePath", ((LiteAppCenter.PageInfo)localObject).basePath);
    this.dz.put("pageRenderPtr", Long.valueOf(((LiteAppCenter.PageInfo)localObject).renderId));
    this.dz.put("startTime", Long.valueOf(System.currentTimeMillis()));
    this.mName = Long.toString(((LiteAppCenter.PageInfo)localObject).pageId);
    AppMethodBeat.o(212392);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(212402);
    this.vkY = this.vkX.gdz();
    this.vkY.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(212390);
        Point localPoint = al.ck(WxaLiteAppBaseFragment.this.getContext());
        WxaLiteAppBaseFragment.this.vkY.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = ar.dX(WxaLiteAppBaseFragment.this.getContext());
        DisplayMetrics localDisplayMetrics = WxaLiteAppBaseFragment.this.getContext().getResources().getDisplayMetrics();
        int j = WxaLiteAppBaseFragment.this.vkY.getWidth();
        int k = WxaLiteAppBaseFragment.this.vkY.getHeight() - i;
        float f = localDisplayMetrics.density;
        LiteAppCenter.setDisplayParams(j / f, k / f, localPoint.x / f, localPoint.y / f, localDisplayMetrics.densityDpi, f);
        ae.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "SetDisplayParams w=%d h=%d screen=%d,%d actionBar=%d densityDpi=%d density=%f", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(i), Integer.valueOf(localDisplayMetrics.densityDpi), Float.valueOf(localDisplayMetrics.density) });
        AppMethodBeat.o(212390);
      }
    });
    this.vkZ = new b(getContext());
    this.vkZ.setLayoutParams(new LinearLayout.LayoutParams(-1, 900));
    this.vkZ.addView(this.vkY);
    paramLayoutInflater = this.vkZ;
    AppMethodBeat.o(212402);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212399);
    super.onDestroy();
    this.vkX.onDestroyView();
    com.tencent.wax.ui.a locala = this.vkX;
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onCloseView()", new Object[0]);
    locala.MIb.gdw();
    this.vkX.onDetach();
    AppMethodBeat.o(212399);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(212394);
    ae.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onDetach");
    super.onDetach();
    AppMethodBeat.o(212394);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(212397);
    super.onPause();
    this.vkX.onPause();
    AppMethodBeat.o(212397);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(212401);
    this.vkX.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(212401);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212396);
    super.onResume();
    this.vkX.onResume();
    AppMethodBeat.o(212396);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(212395);
    ae.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onStart");
    super.onStart();
    this.vkX.onStart();
    AppMethodBeat.o(212395);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(212398);
    super.onStop();
    this.vkX.onStop();
    AppMethodBeat.o(212398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppBaseFragment
 * JD-Core Version:    0.7.0.1
 */