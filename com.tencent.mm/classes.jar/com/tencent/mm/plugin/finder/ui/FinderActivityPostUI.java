package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.d;
import com.tencent.mm.plugin.finder.activity.uic.e;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "scrollView", "Landroid/widget/ScrollView;", "fixActionBar", "", "getLayoutId", "", "hideActionBar", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderActivityPostUI
  extends MMFinderUI
{
  public static final a AnY;
  private HashMap _$_findViewCache;
  private ScrollView jbL;
  
  static
  {
    AppMethodBeat.i(241217);
    AnY = new a((byte)0);
    AppMethodBeat.o(241217);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(241227);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(241227);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(241222);
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
    AppMethodBeat.o(241222);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_activity_post_ui_new;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(241209);
    Set localSet = ak.setOf(new Class[] { d.class, e.class });
    AppMethodBeat.o(241209);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241206);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.f.finder_activity_post_scroll);
    p.j(paramBundle, "findViewById(R.id.finder_activity_post_scroll)");
    this.jbL = ((ScrollView)paramBundle);
    c.f((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    int i = ax.getStatusBarHeight((Context)this);
    paramBundle = this.jbL;
    if (paramBundle == null) {
      p.bGy("scrollView");
    }
    paramBundle.setPadding(0, i, 0, 0);
    i = getResources().getColor(b.c.transparent);
    getController().setStatusBarColor(i);
    AppMethodBeat.o(241206);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(241212);
    super.onDestroy();
    AppMethodBeat.o(241212);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityPostUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderActivityPostUI
 * JD-Core Version:    0.7.0.1
 */