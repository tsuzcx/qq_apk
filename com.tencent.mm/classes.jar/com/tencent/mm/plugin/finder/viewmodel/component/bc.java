package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.bd.a;
import com.tencent.mm.plugin.finder.feed.bd.b;
import com.tencent.mm.plugin.finder.feed.be;
import com.tencent.mm.plugin.finder.feed.be.f;
import com.tencent.mm.plugin.finder.feed.bf;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.i;
import com.tencent.mm.plugin.finder.viewmodel.i.a;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onUserVisibleFocused", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
  extends UIComponent
{
  public static final a GVy;
  private be GVz;
  
  static
  {
    AppMethodBeat.i(338346);
    GVy = new a((byte)0);
    AppMethodBeat.o(338346);
  }
  
  public bc(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338333);
    AppMethodBeat.o(338333);
  }
  
  private static final boolean a(bc parambc, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(338338);
    s.u(parambc, "this$0");
    boolean bool = parambc.onBackPressed();
    AppMethodBeat.o(338338);
    return bool;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_timeline_machine_ui;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(338378);
    getActivity().finish();
    AppMethodBeat.o(338378);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(338373);
    super.onCreate(paramBundle);
    ((MMActivity)getActivity()).setMMTitle(e.h.finder_algo_recommend);
    ((MMActivity)getActivity()).setBackBtn(new bc..ExternalSyntheticLambda0(this));
    this.GVz = new be((MMActivity)getActivity());
    MMActivity localMMActivity = (MMActivity)getActivity();
    Object localObject2 = this.GVz;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("presenter");
      paramBundle = null;
    }
    localObject2 = new bf(localMMActivity, (bd.a)paramBundle, getRootView(), getFragment());
    paramBundle = this.GVz;
    if (paramBundle == null)
    {
      s.bIx("presenter");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.a((bd.b)localObject2);
      AppMethodBeat.o(338373);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338408);
    super.onDestroy();
    be localbe2 = this.GVz;
    be localbe1 = localbe2;
    if (localbe2 == null)
    {
      s.bIx("presenter");
      localbe1 = null;
    }
    localbe1.onDetach();
    AppMethodBeat.o(338408);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(338402);
    super.onFinished();
    Object localObject1 = this.GVz;
    if (localObject1 == null)
    {
      s.bIx("presenter");
      localObject1 = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.viewmodel.d.a(((be)localObject1).AZj, 4, 0, ((be)localObject1).totalDy, (ArrayList)((be)localObject1).AZs.getDataListJustForAdapter(), null, 112);
      if (((be)localObject1).AZF != null)
      {
        Object localObject2 = ((be)localObject1).AZC;
        localObject1 = ((be)localObject1).AZF;
        s.checkNotNull(localObject1);
        s.u(localObject1, "lastDataList");
        new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((auk)localObject1).ZEO.size()).append(' ');
        h.jXD();
        localObject2 = (Map)((i)localObject2).GKl;
        i.a locala = new i.a();
        locala.GLs = -1;
        s.u(localObject1, "<set-?>");
        locala.GLr = ((auk)localObject1);
        ((Map)localObject2).put(Integer.valueOf(4), locala);
      }
      AppMethodBeat.o(338402);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(338389);
    super.onUserVisibleFocused();
    be localbe = this.GVz;
    if (localbe == null)
    {
      s.bIx("presenter");
      localbe = null;
    }
    for (;;)
    {
      com.tencent.mm.ae.d.B((a)new be.f(localbe));
      AppMethodBeat.o(338389);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bc
 * JD-Core Version:    0.7.0.1
 */