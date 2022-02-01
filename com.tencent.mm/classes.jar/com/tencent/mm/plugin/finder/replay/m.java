package com.tencent.mm.plugin.finder.replay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.ui.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
{
  private i FkN;
  private FinderLiveReplayViewCallback FkO;
  
  public m(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(332626);
    AppMethodBeat.o(332626);
  }
  
  public final int getLayoutId()
  {
    return p.f.Cft;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(332659);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity)) {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
    }
    getActivity().getWindow().addFlags(2097280);
    getActivity().getWindow().addFlags(67108864);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int j;
    label432:
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getActivity().getWindow().clearFlags(1024);
      getActivity().getWindow().clearFlags(512);
      getActivity().getWindow().clearFlags(67108864);
      if (getContext().getResources().getConfiguration().orientation == 2)
      {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
        getActivity().getWindow().addFlags(1024);
        getActivity().getWindow().addFlags(-2147483648);
        getActivity().getWindow().setStatusBarColor(0);
        getActivity().getWindow().setNavigationBarColor(0);
      }
    }
    else
    {
      getActivity().getWindow().setFormat(-3);
      getActivity().getWindow().setSoftInputMode(51);
      this.FkN = new i(getContext(), getIntent());
      paramBundle = (MMActivity)getActivity();
      localObject1 = this.FkN;
      s.checkNotNull(localObject1);
      this.FkO = new FinderLiveReplayViewCallback(paramBundle, (f.a)localObject1);
      paramBundle = this.FkO;
      if (paramBundle != null)
      {
        localObject1 = this.FkN;
        if (localObject1 != null) {
          ((i)localObject1).a((f.b)paramBundle);
        }
        paramBundle.activity.getLifecycle().addObserver((p)paramBundle);
        localObject1 = paramBundle.BwI;
        ((FinderLiveRecyclerView)localObject1).setHasFixedSize(true);
        localObject2 = new FinderLiveLayoutManager((Context)paramBundle.activity, 1);
        ((FinderLiveLayoutManager)localObject2).DNT = ((q)new FinderLiveReplayViewCallback.b(paramBundle));
        localObject3 = ah.aiuX;
        paramBundle.BwJ = ((FinderLiveLayoutManager)localObject2);
        ((FinderLiveRecyclerView)localObject1).a((LinearLayoutManager)paramBundle.BwJ);
        localObject2 = new d();
        localObject3 = paramBundle.FkR.eLv();
        s.u(localObject3, "list");
        ((d)localObject2).pUj = ((ArrayList)localObject3);
        ((RecyclerView.a)localObject2).bZE.notifyChanged();
        localObject3 = k.Fky.eLF().Fkz;
        if (localObject3 != null) {
          break label618;
        }
        j = 0;
        if (j < 0) {
          break label632;
        }
        if (j >= ((d)localObject2).getItemCount()) {
          break label627;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject3 = paramBundle.BwI;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(j, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, locala.aYi(), "com/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((FinderLiveRecyclerView)localObject3).scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
      localObject3 = ah.aiuX;
      ((FinderLiveRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      paramBundle.FkS.a((RecyclerView)localObject1);
      localObject1 = paramBundle.BwD;
      ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new FinderLiveReplayViewCallback.c(paramBundle));
      AppMethodBeat.o(332659);
      return;
      getActivity().getWindow().getDecorView().setSystemUiVisibility(1792);
      break;
      label618:
      j = ((com.tencent.mm.plugin.finder.replay.model.c)localObject3).CEY;
      break label432;
      label627:
      i = 0;
      continue;
      label632:
      i = 0;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(332665);
    super.onDestroy();
    i locali = this.FkN;
    if (locali != null) {
      locali.onDetach();
    }
    AppMethodBeat.o(332665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.m
 * JD-Core Version:    0.7.0.1
 */