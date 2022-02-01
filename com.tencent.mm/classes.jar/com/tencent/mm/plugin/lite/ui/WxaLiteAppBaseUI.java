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
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
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
  public static final String vlc;
  protected com.tencent.wax.ui.a vkX;
  protected String vla;
  private LifecycleRegistry vld;
  
  static
  {
    AppMethodBeat.i(212450);
    vlc = d.a.MYs.name();
    AppMethodBeat.o(212450);
  }
  
  public WxaLiteAppBaseUI()
  {
    AppMethodBeat.i(212419);
    this.vld = new LifecycleRegistry(this);
    AppMethodBeat.o(212419);
  }
  
  private Drawable diQ()
  {
    AppMethodBeat.i(212424);
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
            AppMethodBeat.o(212424);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(212424);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(212424);
        return null;
      }
      AppMethodBeat.o(212424);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a diU()
  {
    AppMethodBeat.i(212425);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(212425);
      return locala;
    }
    d.a locala = d.a.MYs;
    AppMethodBeat.o(212425);
    return locala;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final b diH()
  {
    return this;
  }
  
  public final String diI()
  {
    AppMethodBeat.i(212438);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(212438);
    return str;
  }
  
  public final String diJ()
  {
    AppMethodBeat.i(212439);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(212439);
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
          AppMethodBeat.o(212439);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(212439);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(212439);
    return "main";
  }
  
  public final String diK()
  {
    AppMethodBeat.i(212440);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(212440);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(212440);
    return str;
  }
  
  public final String diL()
  {
    AppMethodBeat.i(212441);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(212441);
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
          AppMethodBeat.o(212441);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(212441);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(212441);
    return "/";
  }
  
  public final FlutterView.b diM()
  {
    AppMethodBeat.i(212442);
    if (diU() == d.a.MYs)
    {
      localb = FlutterView.b.MYZ;
      AppMethodBeat.o(212442);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.MZa;
    AppMethodBeat.o(212442);
    return localb;
  }
  
  public final FlutterView.c diN()
  {
    AppMethodBeat.i(212443);
    if (diU() == d.a.MYs)
    {
      localc = FlutterView.c.MZc;
      AppMethodBeat.o(212443);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.MZd;
    AppMethodBeat.o(212443);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a diO()
  {
    AppMethodBeat.i(212444);
    io.flutter.embedding.engine.a locala = d.gdr().cPI;
    AppMethodBeat.o(212444);
    return locala;
  }
  
  public final h diP()
  {
    AppMethodBeat.i(212423);
    Object localObject = diQ();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(212423);
      return localObject;
    }
    AppMethodBeat.o(212423);
    return null;
  }
  
  public String diR()
  {
    AppMethodBeat.i(212445);
    if ((getIntent().hasExtra("activityId")) && (!bu.isNullOrNil(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(212445);
      return str;
    }
    if (TextUtils.isEmpty(this.vla)) {
      this.vla = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.vla;
    AppMethodBeat.o(212445);
    return str;
  }
  
  public final String diS()
  {
    AppMethodBeat.i(212446);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(212446);
      return str;
    }
    AppMethodBeat.o(212446);
    return "";
  }
  
  public final Map diT()
  {
    AppMethodBeat.i(212447);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wax.d.a)))
    {
      Map localMap = ((com.tencent.wax.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(212447);
      return localMap;
    }
    AppMethodBeat.o(212447);
    return null;
  }
  
  protected View diV()
  {
    AppMethodBeat.i(212420);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(this.vkX.gdz(), new LinearLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(212420);
    return localLinearLayout;
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
    return this.vld;
  }
  
  public void initView()
  {
    AppMethodBeat.i(212421);
    super.initView();
    diV();
    AppMethodBeat.o(212421);
  }
  
  public final void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(212448);
    SwipeBackLayout localSwipeBackLayout = getSwipeBackLayout();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwipeBackLayout.setEnableGesture(paramBoolean);
      AppMethodBeat.o(212448);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212432);
    this.vkX.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(212432);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(212434);
    this.vkX.onBackPressed();
    AppMethodBeat.o(212434);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212422);
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
        io.flutter.a.giH();
        continue;
      }
      super.onCreate(paramBundle);
      this.vld.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.vkX = new com.tencent.wax.ui.a(this);
      this.vkX.gdx();
      setContentView(diV());
      AppMethodBeat.o(212422);
      return;
      io.flutter.a.giF();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212431);
    super.onDestroy();
    this.vkX.onDestroyView();
    this.vkX.onDetach();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(212431);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(212433);
    super.onNewIntent(paramIntent);
    this.vkX.onNewIntent(paramIntent);
    AppMethodBeat.o(212433);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(212429);
    super.onPause();
    this.vkX.onPause();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(212429);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(212428);
    super.onPostResume();
    this.vkX.onPostResume();
    AppMethodBeat.o(212428);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(212435);
    this.vkX.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(212435);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212427);
    super.onResume();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.vkX.onResume();
    AppMethodBeat.o(212427);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(212426);
    super.onStart();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.vkX.onStart();
    AppMethodBeat.o(212426);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(212430);
    super.onStop();
    this.vkX.onStop();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(212430);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(212437);
    this.vkX.onTrimMemory(paramInt);
    AppMethodBeat.o(212437);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(212436);
    this.vkX.onUserLeaveHint();
    AppMethodBeat.o(212436);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppBaseUI
 * JD-Core Version:    0.7.0.1
 */