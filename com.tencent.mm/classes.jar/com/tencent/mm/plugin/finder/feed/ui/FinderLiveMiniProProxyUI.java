package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMiniProProxyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkIntentState", "", "enableActivityAnimation", "", "finish", "getLayoutId", "", "launchMiniProgram", "context", "Landroid/content/Context;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class FinderLiveMiniProProxyUI
  extends MMFinderUI
{
  private static final int DEFAULT = 0;
  private static final String ubu = "ACTIVITY_PURPOSE";
  private static final String ubv = "LUANCH_KEY";
  private static final int ubw = 1;
  private static final int ubx = 2;
  private static final int uby = 3;
  public static final a ubz;
  final String TAG = "FinderLive.MiniProProxyUI";
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(245385);
    ubz = new a((byte)0);
    ubu = "ACTIVITY_PURPOSE";
    ubv = "LUANCH_KEY";
    ubw = 1;
    ubx = 2;
    uby = 3;
    AppMethodBeat.o(245385);
  }
  
  private final void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(245383);
    Log.i(this.TAG, "launchMiniProgram appid:" + paramg.appId + ", path:" + paramg.kHw);
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, paramg);
    AppMethodBeat.o(245383);
  }
  
  private final void deb()
  {
    Object localObject2 = null;
    AppMethodBeat.i(245384);
    Object localObject1 = getIntent();
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((Intent)localObject1).getIntExtra(ubu, DEFAULT));
      Log.i(this.TAG, "[checkIntentState] purpose = ".concat(String.valueOf(localObject1)));
      i = ubw;
      if (localObject1 != null) {
        break label86;
      }
      label55:
      i = ubx;
      if (localObject1 != null) {
        break label253;
      }
      label63:
      i = uby;
      if (localObject1 != null) {
        break label264;
      }
    }
    label264:
    for (;;)
    {
      finish();
      AppMethodBeat.o(245384);
      return;
      localObject1 = null;
      break;
      label86:
      if (((Integer)localObject1).intValue() != i) {
        break label55;
      }
      Object localObject3 = getIntent();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((Intent)localObject3).getIntExtra(ubv, 0));
      }
      localObject2 = d.uCw;
      localObject2 = (Map)d.diN();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(245384);
        throw ((Throwable)localObject1);
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.api.g)af.fd(localObject2).remove(localObject1);
      localObject3 = this.TAG;
      localObject1 = new StringBuilder("[LUANCH_MINI_PROGRAM] key = ").append(localObject1).append(",bundle is null:");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject3, bool);
        if (localObject2 == null) {
          break;
        }
        b((Context)this, (com.tencent.mm.plugin.appbrand.api.g)localObject2);
        AppMethodBeat.o(245384);
        return;
      }
      finish();
      AppMethodBeat.o(245384);
      return;
      label253:
      if (((Integer)localObject1).intValue() != i)
      {
        break label63;
        if (((Integer)localObject1).intValue() == i) {
          moveTaskToBack(true);
        }
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245387);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245387);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245386);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245386);
    return localView1;
  }
  
  public final boolean enableActivityAnimation()
  {
    AppMethodBeat.i(245382);
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra(ubu, DEFAULT) == ubw))
    {
      AppMethodBeat.o(245382);
      return false;
    }
    boolean bool = super.enableActivityAnimation();
    AppMethodBeat.o(245382);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245380);
    Log.i(this.TAG, "finish");
    super.finish();
    AppMethodBeat.o(245380);
  }
  
  public final int getLayoutId()
  {
    return 2131494448;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(245381);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "onConfigurationChanged orientation:" + paramConfiguration.orientation);
    AppMethodBeat.o(245381);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245373);
    Log.i(this.TAG, "onCreate");
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    b.a((Activity)this, (b.b)new b(this));
    AppMethodBeat.o(245373);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245379);
    Log.i(this.TAG, "onDestroy");
    super.onDestroy();
    AppMethodBeat.o(245379);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245375);
    Log.i(this.TAG, "onNewIntent");
    super.onNewIntent(paramIntent);
    deb();
    AppMethodBeat.o(245375);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245377);
    Log.i(this.TAG, "onPause");
    super.onPause();
    AppMethodBeat.o(245377);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245376);
    Log.i(this.TAG, "onResume");
    super.onResume();
    deb();
    AppMethodBeat.o(245376);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245374);
    Log.i(this.TAG, "onStart");
    super.onStart();
    AppMethodBeat.o(245374);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245378);
    Log.i(this.TAG, "onStop");
    super.onStop();
    AppMethodBeat.o(245378);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMiniProProxyUI$Companion;", "", "()V", "ACTIVITY_PURPOSE", "", "getACTIVITY_PURPOSE", "()Ljava/lang/String;", "DEFAULT", "", "getDEFAULT", "()I", "FINISH_AND_MOVE_BACK", "getFINISH_AND_MOVE_BACK", "FINISH_WITH_CLEAR_TOP", "getFINISH_WITH_CLEAR_TOP", "LUANCH_KEY", "getLUANCH_KEY", "LUANCH_MINI_PROGRAM", "getLUANCH_MINI_PROGRAM", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onComplete"})
  static final class b
    implements b.b
  {
    b(FinderLiveMiniProProxyUI paramFinderLiveMiniProProxyUI) {}
    
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(245372);
      Log.i(this.ubA.TAG, "convertActivityToTranslucent complete:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(245372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI
 * JD-Core Version:    0.7.0.1
 */