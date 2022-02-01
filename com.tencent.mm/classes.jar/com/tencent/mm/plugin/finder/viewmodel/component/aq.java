package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.aw.a;
import com.tencent.mm.plugin.finder.feed.aw.b;
import com.tencent.mm.plugin.finder.feed.ax;
import com.tencent.mm.plugin.finder.feed.ax.h;
import com.tencent.mm.plugin.finder.feed.ay;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.finder.viewmodel.g;
import com.tencent.mm.plugin.finder.viewmodel.g.a;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class aq
  extends UIComponent
{
  public static final a BoU;
  private ax BoT;
  
  static
  {
    AppMethodBeat.i(234955);
    BoU = new a((byte)0);
    AppMethodBeat.o(234955);
  }
  
  public aq(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(234954);
    AppMethodBeat.o(234954);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_timeline_machine_ui;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(234944);
    getActivity().finish();
    AppMethodBeat.o(234944);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234940);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(234940);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setMMTitle(b.j.finder_algo_recommend);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(234940);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(234940);
      throw paramBundle;
    }
    this.BoT = new ax((MMActivity)paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(234940);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    ax localax = this.BoT;
    if (localax == null) {
      p.bGy("presenter");
    }
    paramBundle = new ay(paramBundle, (aw.a)localax, getRootView(), getFragment());
    localax = this.BoT;
    if (localax == null) {
      p.bGy("presenter");
    }
    localax.a((aw.b)paramBundle);
    AppMethodBeat.o(234940);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(234952);
    super.onDestroy();
    ax localax = this.BoT;
    if (localax == null) {
      p.bGy("presenter");
    }
    localax.onDetach();
    AppMethodBeat.o(234952);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(234949);
    super.onFinished();
    Object localObject1 = this.BoT;
    if (localObject1 == null) {
      p.bGy("presenter");
    }
    b.a(((ax)localObject1).tlCache, 4, 0, ((ax)localObject1).totalDy, (ArrayList)((ax)localObject1).xCg.getDataListJustForAdapter(), null, null, false, 112);
    if (((ax)localObject1).xCA != null)
    {
      Object localObject2 = ((ax)localObject1).xCx;
      localObject1 = ((ax)localObject1).xCA;
      if (localObject1 == null) {
        p.iCn();
      }
      p.k(localObject1, "lastDataList");
      new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(((aqk)localObject1).SDG.size()).append(' ');
      h.ioq();
      localObject2 = (Map)((g)localObject2).Bgm;
      g.a locala = new g.a();
      locala.Bhs = -1;
      p.k(localObject1, "<set-?>");
      locala.Bhr = ((aqk)localObject1);
      ((Map)localObject2).put(Integer.valueOf(4), locala);
    }
    AppMethodBeat.o(234949);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(234946);
    super.onUserVisibleFocused();
    ax localax = this.BoT;
    if (localax == null) {
      p.bGy("presenter");
    }
    d.h((a)new ax.h(localax));
    AppMethodBeat.o(234946);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(aq paramaq) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(276730);
      boolean bool = this.BoV.onBackPressed();
      AppMethodBeat.o(276730);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aq
 * JD-Core Version:    0.7.0.1
 */