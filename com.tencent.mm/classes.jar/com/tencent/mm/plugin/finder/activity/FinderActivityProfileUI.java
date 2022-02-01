package com.tencent.mm.plugin.finder.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.c;
import com.tencent.mm.plugin.finder.activity.uic.f;
import com.tencent.mm.plugin.finder.activity.uic.g;
import com.tencent.mm.plugin.finder.activity.uic.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setFullScreen", "Companion", "plugin-finder_release"})
public final class FinderActivityProfileUI
  extends MMFinderUI
{
  public static final a wWL;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(267660);
    wWL = new a((byte)0);
    AppMethodBeat.o(267660);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(267662);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(267662);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(267661);
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
    AppMethodBeat.o(267661);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 59;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(267658);
    Set localSet = ak.setOf(new Class[] { c.class, g.class, h.class, com.tencent.mm.plugin.finder.activity.uic.a.class, f.class });
    AppMethodBeat.o(267658);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(267657);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(b.c.transparent));
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
      AppMethodBeat.o(267657);
      return;
    }
    AppMethodBeat.o(267657);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityProfileUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.FinderActivityProfileUI
 * JD-Core Version:    0.7.0.1
 */