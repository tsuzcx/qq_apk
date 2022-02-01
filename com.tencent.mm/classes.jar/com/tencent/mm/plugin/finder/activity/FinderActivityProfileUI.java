package com.tencent.mm.plugin.finder.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityActionBarUIC;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC;
import com.tencent.mm.plugin.finder.activity.uic.FinderInvalidActivityUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setFullScreen", "Companion", "plugin-finder_release"})
public final class FinderActivityProfileUI
  extends MMFinderUI
{
  public static final a tqh;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(242002);
    tqh = new a((byte)0);
    AppMethodBeat.o(242002);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(242004);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(242004);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(242003);
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
    AppMethodBeat.o(242003);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 59;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(242001);
    Set localSet = ak.setOf(new Class[] { FinderInvalidActivityUIC.class, FinderActivityActionBarUIC.class, FinderActivityContentUIC.class });
    AppMethodBeat.o(242001);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242000);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101287));
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
      AppMethodBeat.o(242000);
      return;
    }
    AppMethodBeat.o(242000);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityProfileUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.FinderActivityProfileUI
 * JD-Core Version:    0.7.0.1
 */