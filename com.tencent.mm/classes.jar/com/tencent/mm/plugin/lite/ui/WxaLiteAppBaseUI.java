package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wax.b.b;
import com.tencent.wax.d;
import com.tencent.wax.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.android.g;
import io.flutter.view.FlutterMain;
import java.util.Map;

@com.tencent.mm.ui.base.a(2)
public class WxaLiteAppBaseUI
  extends MMActivity
  implements LifecycleOwner, b, a.a
{
  public static final String tWq;
  protected com.tencent.wax.ui.a tWr;
  private LifecycleRegistry tWs;
  
  static
  {
    AppMethodBeat.i(208194);
    tWq = d.a.KKz.name();
    AppMethodBeat.o(208194);
  }
  
  public WxaLiteAppBaseUI()
  {
    AppMethodBeat.i(208165);
    this.tWs = new LifecycleRegistry(this);
    AppMethodBeat.o(208165);
  }
  
  private Drawable cWA()
  {
    AppMethodBeat.i(208170);
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
            AppMethodBeat.o(208170);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(208170);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(208170);
        return null;
      }
      AppMethodBeat.o(208170);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a cWB()
  {
    AppMethodBeat.i(208171);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(208171);
      return locala;
    }
    d.a locala = d.a.KKz;
    AppMethodBeat.o(208171);
    return locala;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final String cWC()
  {
    AppMethodBeat.i(208184);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(208184);
    return str;
  }
  
  public final String cWD()
  {
    AppMethodBeat.i(208185);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(208185);
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
          AppMethodBeat.o(208185);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(208185);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(208185);
    return "main";
  }
  
  public final String cWE()
  {
    AppMethodBeat.i(208186);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(208186);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(208186);
    return str;
  }
  
  public final String cWF()
  {
    AppMethodBeat.i(208187);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(208187);
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
          AppMethodBeat.o(208187);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(208187);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(208187);
    return "/";
  }
  
  public final FlutterView.b cWG()
  {
    AppMethodBeat.i(208188);
    if (cWB() == d.a.KKz)
    {
      localb = FlutterView.b.KLd;
      AppMethodBeat.o(208188);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.KLe;
    AppMethodBeat.o(208188);
    return localb;
  }
  
  public final FlutterView.c cWH()
  {
    AppMethodBeat.i(208189);
    if (cWB() == d.a.KKz)
    {
      localc = FlutterView.c.KLg;
      AppMethodBeat.o(208189);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.KLh;
    AppMethodBeat.o(208189);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a cWI()
  {
    AppMethodBeat.i(208190);
    io.flutter.embedding.engine.a locala = d.fHA().cDT;
    AppMethodBeat.o(208190);
    return locala;
  }
  
  public final String cWJ()
  {
    AppMethodBeat.i(208191);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(208191);
      return str;
    }
    AppMethodBeat.o(208191);
    return "";
  }
  
  public final Map cWK()
  {
    AppMethodBeat.i(208192);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wax.d.a)))
    {
      Map localMap = ((com.tencent.wax.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(208192);
      return localMap;
    }
    AppMethodBeat.o(208192);
    return null;
  }
  
  protected View cWy()
  {
    AppMethodBeat.i(208166);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.tWr.fHH(), new LinearLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(208166);
    return localLinearLayout;
  }
  
  public final g cWz()
  {
    AppMethodBeat.i(208169);
    Object localObject = cWA();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(208169);
      return localObject;
    }
    AppMethodBeat.o(208169);
    return null;
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.tWs;
  }
  
  public void initView()
  {
    AppMethodBeat.i(208167);
    super.initView();
    cWy();
    AppMethodBeat.o(208167);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(208178);
    this.tWr.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(208178);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(208180);
    this.tWr.onBackPressed();
    AppMethodBeat.o(208180);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208168);
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
        io.flutter.a.fMH();
        continue;
      }
      super.onCreate(paramBundle);
      this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.tWr = new com.tencent.wax.ui.a(this);
      this.tWr.fHF();
      setContentView(cWy());
      AppMethodBeat.o(208168);
      return;
      io.flutter.a.fMF();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(208177);
    super.onDestroy();
    this.tWr.onDestroyView();
    this.tWr.onDetach();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(208177);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(208179);
    super.onNewIntent(paramIntent);
    this.tWr.onNewIntent(paramIntent);
    AppMethodBeat.o(208179);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(208175);
    super.onPause();
    this.tWr.onPause();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(208175);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(208174);
    super.onPostResume();
    this.tWr.onPostResume();
    AppMethodBeat.o(208174);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(208181);
    this.tWr.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(208181);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(208173);
    super.onResume();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.tWr.onResume();
    AppMethodBeat.o(208173);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(208172);
    super.onStart();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.tWr.onStart();
    AppMethodBeat.o(208172);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(208176);
    super.onStop();
    this.tWr.onStop();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(208176);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(208183);
    this.tWr.onTrimMemory(paramInt);
    AppMethodBeat.o(208183);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(208182);
    this.tWr.onUserLeaveHint();
    AppMethodBeat.o(208182);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppBaseUI
 * JD-Core Version:    0.7.0.1
 */