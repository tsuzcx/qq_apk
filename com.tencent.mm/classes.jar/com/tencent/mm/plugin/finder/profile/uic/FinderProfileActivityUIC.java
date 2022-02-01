package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderProfileActivityUIC
  extends UIComponent
{
  public static final a var;
  private ae.b tQm;
  private ae.a vaq;
  
  static
  {
    AppMethodBeat.i(250095);
    var = new a((byte)0);
    AppMethodBeat.o(250095);
  }
  
  public FinderProfileActivityUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250094);
    AppMethodBeat.o(250094);
  }
  
  public final int getLayoutId()
  {
    return 2131494613;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250090);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    this.vaq = new ae.a(true, paramBundle);
    Object localObject1 = getActivity();
    if (localObject1 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(250090);
      throw paramBundle;
    }
    localObject1 = (MMActivity)localObject1;
    Object localObject2 = getRootView();
    ae.a locala = this.vaq;
    if (locala == null) {
      p.btv("selectPresenter");
    }
    this.tQm = new ae.b((MMActivity)localObject1, (View)localObject2, locala);
    localObject1 = this.vaq;
    if (localObject1 == null) {
      p.btv("selectPresenter");
    }
    localObject2 = this.tQm;
    if (localObject2 == null) {
      p.btv("viewCallback");
    }
    ((ae.a)localObject1).a((ae.b)localObject2);
    localObject1 = this.tQm;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    ((ae.b)localObject1).initView();
    localObject1 = k.vfA;
    long l;
    if (p.j(paramBundle, z.aUg()))
    {
      l = 1L;
      paramBundle = FinderReporterUIC.wzC;
      paramBundle = FinderReporterUIC.a.fH((Context)getContext());
      if (paramBundle == null) {
        break label234;
      }
    }
    label234:
    for (paramBundle = paramBundle.dIx();; paramBundle = null)
    {
      k.a(l, "1", 3L, "", paramBundle);
      AppMethodBeat.o(250090);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250093);
    super.onDestroy();
    ae.a locala = this.vaq;
    if (locala == null) {
      p.btv("selectPresenter");
    }
    locala.onDetach();
    AppMethodBeat.o(250093);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250091);
    super.onResume();
    h.hkS();
    AppMethodBeat.o(250091);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(250092);
    super.onUserVisibleFocused();
    h.hkS();
    ae.b localb = this.tQm;
    if (localb == null) {
      p.btv("viewCallback");
    }
    Log.i(ae.b.TAG, "onUserVisibleFocused : " + localb.tQG);
    LinkedList localLinkedList = localb.tQG;
    if (localLinkedList != null)
    {
      localb.af(localLinkedList);
      AppMethodBeat.o(250092);
      return;
    }
    AppMethodBeat.o(250092);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileActivityUIC
 * JD-Core Version:    0.7.0.1
 */