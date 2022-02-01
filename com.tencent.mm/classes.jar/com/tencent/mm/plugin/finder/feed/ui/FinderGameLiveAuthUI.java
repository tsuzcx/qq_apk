package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveAuthUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "firstOnResume", "", "showCreateAccount", "checkShow", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGameLiveAuthUI
  extends FinderGameLiveBaseUI
  implements com.tencent.mm.am.h
{
  private boolean BnS;
  private boolean BnT = true;
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void eeX()
  {
    AppMethodBeat.i(365464);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adbA, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(365464);
      throw ((Throwable)localObject);
    }
    if (!((Boolean)localObject).booleanValue())
    {
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.h)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.h.class)).show();
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.h)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.h.class)).DYl = ((kotlin.g.a.a)new a(this));
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.b.class)).hide();
      localObject = k.aeZF;
      ((c)k.d((AppCompatActivity)this).q(c.class)).hide();
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.a.class)).hide();
      AppMethodBeat.o(365464);
      return;
    }
    localObject = aw.Gjk;
    if (aw.ffR())
    {
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.b.class)).show();
      localObject = k.aeZF;
      ((c)k.d((AppCompatActivity)this).q(c.class)).hide();
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.a.class)).hide();
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.h)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.h.class)).hide();
      AppMethodBeat.o(365464);
      return;
    }
    localObject = k.aeZF;
    ((com.tencent.mm.plugin.finder.live.viewmodel.b)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.b.class)).hide();
    localObject = k.aeZF;
    ((c)k.d((AppCompatActivity)this).q(c.class)).show();
    localObject = k.aeZF;
    ((com.tencent.mm.plugin.finder.live.viewmodel.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.a.class)).hide();
    localObject = k.aeZF;
    ((com.tencent.mm.plugin.finder.live.viewmodel.h)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.h.class)).hide();
    this.BnS = true;
    AppMethodBeat.o(365464);
  }
  
  public final int getLayoutId()
  {
    return p.f.Ccz;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365444);
    Set localSet = ar.setOf(new Class[] { com.tencent.mm.plugin.finder.live.viewmodel.b.class, c.class, com.tencent.mm.plugin.finder.live.viewmodel.a.class, com.tencent.mm.plugin.finder.live.viewmodel.h.class });
    AppMethodBeat.o(365444);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365433);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(p.e.BUP);
    t localt = t.GgN;
    t.gO(paramBundle);
    AppMethodBeat.o(365433);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365468);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(365468);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365452);
    super.onResume();
    if (this.BnT)
    {
      aw localaw = aw.Gjk;
      if (aw.ffR()) {
        eeX();
      }
      for (;;)
      {
        this.BnT = false;
        AppMethodBeat.o(365452);
        return;
        com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
        ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(8, (kotlin.g.a.b)new b(this));
      }
    }
    if (this.BnS) {
      eeX();
    }
    AppMethodBeat.o(365452);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(365472);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      eeX();
      AppMethodBeat.o(365472);
      return;
    }
    aa.makeText((Context)getContext(), p.h.finder_live_game_prepare_error, 0).show();
    AppMethodBeat.o(365472);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(FinderGameLiveAuthUI paramFinderGameLiveAuthUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "prepareScene", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.h, ah>
  {
    b(FinderGameLiveAuthUI paramFinderGameLiveAuthUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveAuthUI
 * JD-Core Version:    0.7.0.1
 */