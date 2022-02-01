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
import io.flutter.embedding.android.h;
import io.flutter.view.FlutterMain;
import java.util.Map;

@com.tencent.mm.ui.base.a(2)
public class WxaLiteAppBaseUI
  extends MMActivity
  implements LifecycleOwner, b, a.a
{
  public static final String uYZ;
  protected com.tencent.wax.ui.a uZa;
  private LifecycleRegistry uZb;
  
  static
  {
    AppMethodBeat.i(214659);
    uYZ = d.a.MBn.name();
    AppMethodBeat.o(214659);
  }
  
  public WxaLiteAppBaseUI()
  {
    AppMethodBeat.i(214630);
    this.uZb = new LifecycleRegistry(this);
    AppMethodBeat.o(214630);
  }
  
  private Drawable dfM()
  {
    AppMethodBeat.i(214635);
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
            AppMethodBeat.o(214635);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(214635);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(214635);
        return null;
      }
      AppMethodBeat.o(214635);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a dfN()
  {
    AppMethodBeat.i(214636);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(214636);
      return locala;
    }
    d.a locala = d.a.MBn;
    AppMethodBeat.o(214636);
    return locala;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  protected View dfK()
  {
    AppMethodBeat.i(214631);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.uZa.fYY(), new LinearLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(214631);
    return localLinearLayout;
  }
  
  public final h dfL()
  {
    AppMethodBeat.i(214634);
    Object localObject = dfM();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(214634);
      return localObject;
    }
    AppMethodBeat.o(214634);
    return null;
  }
  
  public final String dfO()
  {
    AppMethodBeat.i(214649);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(214649);
    return str;
  }
  
  public final String dfP()
  {
    AppMethodBeat.i(214650);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(214650);
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
          AppMethodBeat.o(214650);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(214650);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(214650);
    return "main";
  }
  
  public final String dfQ()
  {
    AppMethodBeat.i(214651);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(214651);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(214651);
    return str;
  }
  
  public final String dfR()
  {
    AppMethodBeat.i(214652);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(214652);
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
          AppMethodBeat.o(214652);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(214652);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(214652);
    return "/";
  }
  
  public final FlutterView.b dfS()
  {
    AppMethodBeat.i(214653);
    if (dfN() == d.a.MBn)
    {
      localb = FlutterView.b.MBU;
      AppMethodBeat.o(214653);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.MBV;
    AppMethodBeat.o(214653);
    return localb;
  }
  
  public final FlutterView.c dfT()
  {
    AppMethodBeat.i(214654);
    if (dfN() == d.a.MBn)
    {
      localc = FlutterView.c.MBX;
      AppMethodBeat.o(214654);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.MBY;
    AppMethodBeat.o(214654);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a dfU()
  {
    AppMethodBeat.i(214655);
    io.flutter.embedding.engine.a locala = d.fYR().cOY;
    AppMethodBeat.o(214655);
    return locala;
  }
  
  public final String dfV()
  {
    AppMethodBeat.i(214656);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(214656);
      return str;
    }
    AppMethodBeat.o(214656);
    return "";
  }
  
  public final Map dfW()
  {
    AppMethodBeat.i(214657);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wax.d.a)))
    {
      Map localMap = ((com.tencent.wax.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(214657);
      return localMap;
    }
    AppMethodBeat.o(214657);
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
    return this.uZb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(214632);
    super.initView();
    dfK();
    AppMethodBeat.o(214632);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(214643);
    this.uZa.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(214643);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(214645);
    this.uZa.onBackPressed();
    AppMethodBeat.o(214645);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(214633);
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
        io.flutter.a.gee();
        continue;
      }
      super.onCreate(paramBundle);
      this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.uZa = new com.tencent.wax.ui.a(this);
      this.uZa.fYW();
      setContentView(dfK());
      AppMethodBeat.o(214633);
      return;
      io.flutter.a.gec();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(214642);
    super.onDestroy();
    this.uZa.onDestroyView();
    this.uZa.onDetach();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(214642);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(214644);
    super.onNewIntent(paramIntent);
    this.uZa.onNewIntent(paramIntent);
    AppMethodBeat.o(214644);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(214640);
    super.onPause();
    this.uZa.onPause();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(214640);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(214639);
    super.onPostResume();
    this.uZa.onPostResume();
    AppMethodBeat.o(214639);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(214646);
    this.uZa.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(214646);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(214638);
    super.onResume();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.uZa.onResume();
    AppMethodBeat.o(214638);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(214637);
    super.onStart();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.uZa.onStart();
    AppMethodBeat.o(214637);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(214641);
    super.onStop();
    this.uZa.onStop();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(214641);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(214648);
    this.uZa.onTrimMemory(paramInt);
    AppMethodBeat.o(214648);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(214647);
    this.uZa.onUserLeaveHint();
    AppMethodBeat.o(214647);
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