package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityPostUIC;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivitySelectCoverUIC;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.t;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "scrollView", "Landroid/widget/ScrollView;", "fixActionBar", "", "getLayoutId", "", "hideActionBar", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderActivityPostUI
  extends MMFinderUI
{
  public static final a vHb;
  private HashMap _$_findViewCache;
  private ScrollView gxx;
  
  static
  {
    AppMethodBeat.i(252109);
    vHb = new a((byte)0);
    AppMethodBeat.o(252109);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252111);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252111);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252110);
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
    AppMethodBeat.o(252110);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494196;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252107);
    Set localSet = ak.setOf(new Class[] { FinderActivityPostUIC.class, FinderActivitySelectCoverUIC.class });
    AppMethodBeat.o(252107);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252106);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131300763);
    p.g(paramBundle, "findViewById(R.id.finder_activity_post_scroll)");
    this.gxx = ((ScrollView)paramBundle);
    b.e((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    int i = au.getStatusBarHeight((Context)this);
    paramBundle = this.gxx;
    if (paramBundle == null) {
      p.btv("scrollView");
    }
    paramBundle.setPadding(0, i, 0, 0);
    i = getResources().getColor(2131101287);
    getController().setStatusBarColor(i);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    ((FinderActivitySelectCoverUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderActivitySelectCoverUIC.class)).initView();
    AppMethodBeat.o(252106);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252108);
    super.onDestroy();
    AppMethodBeat.o(252108);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityPostUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderActivityPostUI
 * JD-Core Version:    0.7.0.1
 */