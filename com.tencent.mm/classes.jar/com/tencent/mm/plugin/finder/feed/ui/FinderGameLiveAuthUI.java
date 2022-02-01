package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.viewmodel.a;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveAuthUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "firstOnResume", "", "showCreateAccount", "checkShow", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setWindowStyle", "plugin-finder_release"})
public final class FinderGameLiveAuthUI
  extends FinderGameLiveBaseUI
  implements i
{
  private HashMap _$_findViewCache;
  private boolean xNR;
  private boolean xNS = true;
  
  private final void dvh()
  {
    AppMethodBeat.i(289469);
    Object localObject = aj.AGc;
    if (aj.edY())
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.live.viewmodel.b.class)).show();
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((c)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(c.class)).hide();
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((a)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(a.class)).hide();
      AppMethodBeat.o(289469);
      return;
    }
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.finder.live.viewmodel.b)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.live.viewmodel.b.class)).hide();
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((c)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(c.class)).show();
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((a)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(a.class)).hide();
    this.xNR = true;
    AppMethodBeat.o(289469);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(289473);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(289473);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(289472);
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
    AppMethodBeat.o(289472);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_game_live_auth_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(289467);
    Set localSet = ak.setOf(new Class[] { com.tencent.mm.plugin.finder.live.viewmodel.b.class, c.class, a.class });
    AppMethodBeat.o(289467);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289465);
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
    paramBundle = findViewById(b.f.game_auth_root);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.ADF;
    com.tencent.mm.plugin.finder.utils.p.eM(paramBundle);
    AppMethodBeat.o(289465);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289470);
    super.onDestroy();
    h.aGY().b(3761, (i)this);
    AppMethodBeat.o(289470);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(289468);
    super.onResume();
    if (this.xNS)
    {
      aj localaj = aj.AGc;
      if (aj.edY()) {
        dvh();
      }
      for (;;)
      {
        this.xNS = false;
        AppMethodBeat.o(289468);
        return;
        h.aGY().a(3761, (i)this);
        ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).a(8, (kotlin.g.a.b)new a(this));
      }
    }
    if (this.xNR) {
      dvh();
    }
    AppMethodBeat.o(289468);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(289471);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dvh();
      AppMethodBeat.o(289471);
      return;
    }
    w.makeText((Context)getContext(), b.j.finder_live_game_prepare_error, 0).show();
    AppMethodBeat.o(289471);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "prepareScene", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.g, x>
  {
    a(FinderGameLiveAuthUI paramFinderGameLiveAuthUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveAuthUI
 * JD-Core Version:    0.7.0.1
 */