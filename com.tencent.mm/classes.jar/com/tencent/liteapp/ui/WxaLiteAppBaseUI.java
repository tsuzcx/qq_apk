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
import androidx.lifecycle.h.a;
import androidx.lifecycle.m;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.SwipeBackActivity;
import com.tencent.mm.ext.ui.SwipeBackLayout;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.wxa.c;
import com.tencent.wxa.ui.a.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.e.a;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaLiteAppBaseUI
  extends SwipeBackActivity
  implements com.tencent.wxa.b.b, a.a
{
  public static final String cpb;
  protected String cpc;
  protected com.tencent.wxa.ui.a cpd;
  protected WxaLiteAppInfo cpe;
  protected boolean cpf = false;
  protected LiteAppCenter.PageInfo cpn;
  protected View mContentView;
  
  static
  {
    AppMethodBeat.i(258677);
    cpb = e.a.aaoG.name();
    AppMethodBeat.o(258677);
  }
  
  private e.a Ns()
  {
    AppMethodBeat.i(258633);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = e.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(258633);
      return locala;
    }
    e.a locala = e.a.aaoG;
    AppMethodBeat.o(258633);
    return locala;
  }
  
  private Drawable Nt()
  {
    AppMethodBeat.i(258632);
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
            AppMethodBeat.o(258632);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(258632);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(258632);
        return null;
      }
      AppMethodBeat.o(258632);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  public final FlutterView.b NA()
  {
    AppMethodBeat.i(258666);
    if (Ns() == e.a.aaoG)
    {
      localb = FlutterView.b.aapw;
      AppMethodBeat.o(258666);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.aapx;
    AppMethodBeat.o(258666);
    return localb;
  }
  
  public final FlutterView.c NB()
  {
    AppMethodBeat.i(258667);
    if (this.cpf)
    {
      localc = FlutterView.c.aapB;
      AppMethodBeat.o(258667);
      return localc;
    }
    if (Ns() == e.a.aaoG)
    {
      localc = FlutterView.c.aapA;
      AppMethodBeat.o(258667);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.aapB;
    AppMethodBeat.o(258667);
    return localc;
  }
  
  public final j NC()
  {
    AppMethodBeat.i(258631);
    Object localObject = Nt();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(258631);
      return localObject;
    }
    AppMethodBeat.o(258631);
    return null;
  }
  
  public final io.flutter.embedding.engine.a ND()
  {
    AppMethodBeat.i(258668);
    io.flutter.embedding.engine.a locala = c.ivt().ZYJ;
    AppMethodBeat.o(258668);
    return locala;
  }
  
  public String NE()
  {
    AppMethodBeat.i(258670);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(258670);
      return str;
    }
    if (TextUtils.isEmpty(this.cpc)) {
      this.cpc = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.cpc;
    AppMethodBeat.o(258670);
    return str;
  }
  
  public String NF()
  {
    AppMethodBeat.i(258671);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(258671);
      return str;
    }
    AppMethodBeat.o(258671);
    return "";
  }
  
  public Map NG()
  {
    AppMethodBeat.i(258672);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      Map localMap = ((com.tencent.wxa.d.a)getIntent().getSerializableExtra("params")).map;
      if (this.cpf) {
        localMap.put("transparent", Boolean.valueOf(this.cpf));
      }
      AppMethodBeat.o(258672);
      return localMap;
    }
    AppMethodBeat.o(258672);
    return null;
  }
  
  protected View NI()
  {
    AppMethodBeat.i(258628);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.cpd.ivC(), new LinearLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(258628);
    return localLinearLayout;
  }
  
  public final void NJ()
  {
    AppMethodBeat.i(258675);
    if (getIntent().hasExtra("pageInfo")) {
      this.cpn = ((LiteAppCenter.PageInfo)getIntent().getParcelableExtra("pageInfo"));
    }
    AppMethodBeat.o(258675);
  }
  
  public final void Nu()
  {
    AppMethodBeat.i(258673);
    if (getIntent().hasExtra("LiteApp")) {
      this.cpe = ((WxaLiteAppInfo)getIntent().getParcelableExtra("LiteApp"));
    }
    AppMethodBeat.o(258673);
  }
  
  public final com.tencent.wxa.b.b Nv()
  {
    return this;
  }
  
  public final String Nw()
  {
    AppMethodBeat.i(258659);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(258659);
    return str;
  }
  
  public final String Nx()
  {
    AppMethodBeat.i(258661);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(258661);
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
          AppMethodBeat.o(258661);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(258661);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(258661);
    return "main";
  }
  
  public final String Ny()
  {
    AppMethodBeat.i(258663);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(258663);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(258663);
    return str;
  }
  
  public final String Nz()
  {
    AppMethodBeat.i(258664);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(258664);
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
          AppMethodBeat.o(258664);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(258664);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(258664);
    return "/";
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(258669);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.plugin.platform.b(this, parama.aaqd);
      AppMethodBeat.o(258669);
      return paramActivity;
    }
    AppMethodBeat.o(258669);
    return null;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bZ(boolean paramBoolean)
  {
    AppMethodBeat.i(258676);
    SwipeBackLayout localSwipeBackLayout = aEb();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwipeBackLayout.setEnableGesture(paramBoolean);
      AppMethodBeat.o(258676);
      return;
    }
  }
  
  public final void c(Boolean paramBoolean)
  {
    AppMethodBeat.i(258646);
    this.cpd.oC(paramBoolean.booleanValue());
    AppMethodBeat.o(258646);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(258640);
    this.cpd.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(258640);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(258644);
    this.cpd.oC(true);
    AppMethodBeat.o(258644);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(258630);
    for (;;)
    {
      try
      {
        ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
        if (localActivityInfo.metaData == null) {
          continue;
        }
        i = localActivityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        io.flutter.b.iAh();
        continue;
        int i = 0;
        continue;
        c.ivt().init();
        ((m)getLifecycle()).a(h.a.ON_CREATE);
        this.cpd = new com.tencent.wxa.ui.a(this);
        this.cpd.ivA();
        this.mContentView = NI();
        setContentView(this.mContentView);
        AppMethodBeat.o(258630);
      }
      super.onCreate(paramBundle);
      if (c.ivt().ZYI == null) {
        continue;
      }
      i = 1;
      if (i != 0) {
        continue;
      }
      com.tencent.liteapp.b.b.e("WxaLiteAp.WxaLiteAppBaseUI", "wxa router has no init.", new Object[0]);
      finish();
      AppMethodBeat.o(258630);
      return;
      io.flutter.b.iAe();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(258639);
    super.onDestroy();
    if (this.cpd != null)
    {
      this.cpd.onDestroyView();
      this.cpd.onDetach();
      ((m)getLifecycle()).a(h.a.ON_DESTROY);
    }
    AppMethodBeat.o(258639);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(258642);
    super.onNewIntent(paramIntent);
    this.cpd.onNewIntent(paramIntent);
    AppMethodBeat.o(258642);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(258637);
    super.onPause();
    this.cpd.onPause();
    ((m)getLifecycle()).a(h.a.ON_PAUSE);
    AppMethodBeat.o(258637);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(258636);
    super.onPostResume();
    this.cpd.onPostResume();
    AppMethodBeat.o(258636);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(258650);
    this.cpd.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(258650);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(258635);
    super.onResume();
    ((m)getLifecycle()).a(h.a.ON_RESUME);
    this.cpd.onResume();
    AppMethodBeat.o(258635);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(258634);
    super.onStart();
    ((m)getLifecycle()).a(h.a.ON_START);
    this.cpd.onStart();
    AppMethodBeat.o(258634);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(258638);
    super.onStop();
    this.cpd.onStop();
    ((m)getLifecycle()).a(h.a.ON_STOP);
    AppMethodBeat.o(258638);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(258656);
    this.cpd.onTrimMemory(paramInt);
    AppMethodBeat.o(258656);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(258652);
    this.cpd.onUserLeaveHint();
    AppMethodBeat.o(258652);
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