package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.ar.a;
import com.tencent.mm.plugin.finder.feed.ar.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onUserVisibleFocused", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final a FcJ;
  private ar.b AYE;
  private ar.a FcK;
  
  static
  {
    AppMethodBeat.i(348921);
    FcJ = new a((byte)0);
    AppMethodBeat.o(348921);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348918);
    AppMethodBeat.o(348918);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_select_activity_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348927);
    super.onCreate(paramBundle);
    String str = getActivity().getIntent().getStringExtra("finder_username");
    this.FcK = new ar.a(true, str);
    Object localObject2 = (MMActivity)getActivity();
    View localView = getRootView();
    Object localObject1 = this.FcK;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("selectPresenter");
      paramBundle = null;
    }
    this.AYE = new ar.b((MMActivity)localObject2, localView, paramBundle);
    localObject1 = this.FcK;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("selectPresenter");
      paramBundle = null;
    }
    localObject2 = this.AYE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    paramBundle.a((ar.b)localObject1);
    localObject1 = this.AYE;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      paramBundle = null;
    }
    paramBundle.initView();
    paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
    long l;
    if (s.p(str, com.tencent.mm.model.z.bAW()))
    {
      l = 1L;
      paramBundle = as.GSQ;
      paramBundle = as.a.hu((Context)getContext());
      if (paramBundle != null) {
        break label226;
      }
    }
    label226:
    for (paramBundle = null;; paramBundle = paramBundle.fou())
    {
      com.tencent.mm.plugin.finder.report.z.a(l, "1", 3L, "", paramBundle);
      AppMethodBeat.o(348927);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348953);
    super.onDestroy();
    ar.a locala2 = this.FcK;
    ar.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("selectPresenter");
      locala1 = null;
    }
    locala1.onDetach();
    AppMethodBeat.o(348953);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(348933);
    super.onResume();
    h.jXD();
    AppMethodBeat.o(348933);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(348939);
    super.onUserVisibleFocused();
    h.jXD();
    Object localObject2 = this.AYE;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    Log.i(ar.b.TAG, s.X("onUserVisibleFocused : ", localObject1.AYQ));
    localObject2 = localObject1.AYQ;
    if (localObject2 != null) {
      localObject1.ah((LinkedList)localObject2);
    }
    AppMethodBeat.o(348939);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.b
 * JD-Core Version:    0.7.0.1
 */