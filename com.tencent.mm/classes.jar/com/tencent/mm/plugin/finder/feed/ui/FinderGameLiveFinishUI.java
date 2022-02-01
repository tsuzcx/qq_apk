package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.viewmodel.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveFinishUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "firstOnResume", "", "getFirstOnResume", "()Z", "setFirstOnResume", "(Z)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setWindowStyle", "plugin-finder_release"})
public final class FinderGameLiveFinishUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private boolean xNS = true;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290941);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290941);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290940);
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
    AppMethodBeat.o(290940);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_game_live_finish_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(290939);
    Set localSet = ak.setOf(a.class);
    AppMethodBeat.o(290939);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(290937);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      kotlin.g.b.p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      kotlin.g.b.p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      kotlin.g.b.p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      kotlin.g.b.p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(b.f.game_finish_root);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.ADF;
    com.tencent.mm.plugin.finder.utils.p.eM(paramBundle);
    AppMethodBeat.o(290937);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(290938);
    super.onResume();
    boolean bool1;
    Object localObject1;
    if (this.xNS)
    {
      bool1 = getIntent().getBooleanExtra("SUCC", false);
      localObject1 = getIntent().getStringExtra("TITLE");
      if (localObject1 != null) {
        break label200;
      }
      localObject1 = "";
    }
    label200:
    for (;;)
    {
      Object localObject2 = getIntent().getStringExtra("DESC");
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        boolean bool2 = getIntent().getBooleanExtra("IS_MINI_GAME", false);
        Object localObject3 = g.Xox;
        localObject3 = g.b((AppCompatActivity)this).i(a.class);
        kotlin.g.b.p.j(localObject3, "UICProvider.of(this).get…ameFinishUIC::class.java)");
        localObject3 = (a)localObject3;
        ((a)localObject3).f(bool1, (String)localObject1, (String)localObject2);
        ((a)localObject3).show();
        if (!bool1)
        {
          localObject1 = ((a)localObject3).getDescTv();
          localObject2 = com.tencent.mm.plugin.finder.utils.p.ADF;
          localObject2 = getContext();
          kotlin.g.b.p.j(localObject2, "context");
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.finder.utils.p.d((Context)localObject2, b.j.wcfinder_gamelive_forbidlivepageerror_subtitle_with_format, bool2));
        }
        getContentView().postDelayed((Runnable)FinderGameLiveFinishUI.a.xNV, 500L);
        this.xNS = false;
        AppMethodBeat.o(290938);
        return;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveFinishUI
 * JD-Core Version:    0.7.0.1
 */