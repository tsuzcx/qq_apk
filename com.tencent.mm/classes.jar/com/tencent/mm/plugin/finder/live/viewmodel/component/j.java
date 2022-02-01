package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveWatchCountDownUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "currentItemIndex", "", "finderLiveBundle", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "isFromRed", "", "refreshInterval", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "isOtherScene", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPreDestroyed", "parseData", "data", "selectItemView", "itemData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "position", "startCountDown", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends UIComponent
{
  public static final a Eba;
  public static long Ebd;
  private static boolean Ebe;
  private FinderLiveBundle Eab;
  public int Ebb;
  public boolean Ebc;
  public final Runnable hPJ;
  private int refreshInterval;
  
  static
  {
    AppMethodBeat.i(356941);
    Eba = new a((byte)0);
    AppMethodBeat.o(356941);
  }
  
  public j(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(356909);
    this.Ebb = -1;
    this.hPJ = new j..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(356909);
  }
  
  private static final void a(j paramj)
  {
    AppMethodBeat.i(356917);
    s.u(paramj, "this$0");
    Log.i("FinderLiveWatchCountDownUIC", s.X("notify nearby requestRefresh : ", Long.valueOf(Ebd)));
    if (Ebd != 0L) {
      ((com.tencent.d.a.b.a.b.a)h.ax(com.tencent.d.a.b.a.b.a.class)).A(Ebd, paramj.Ebc);
    }
    AppMethodBeat.o(356917);
  }
  
  public final void exT()
  {
    AppMethodBeat.i(356972);
    if (this.refreshInterval != 0) {
      d.a(this.refreshInterval * 1000L, this.hPJ);
    }
    AppMethodBeat.o(356972);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356962);
    super.onCreate(paramBundle);
    this.Eab = ((FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
    paramBundle = this.Eab;
    long l;
    int i;
    if ((paramBundle != null) && (paramBundle != null))
    {
      paramBundle = paramBundle.CFj;
      if (paramBundle == null)
      {
        l = 0L;
        Ebd = l;
      }
    }
    else
    {
      Log.i("FinderLiveWatchCountDownUIC", "onCreate lastFromRed: " + Ebe + " , scene = " + com.tencent.mm.plugin.expt.hellhound.a.dIJ());
      if (!s.p(q.n.DtJ.scene, com.tencent.mm.plugin.expt.hellhound.a.dIJ()))
      {
        if (!Ebe) {
          break label269;
        }
        if ((!s.p(q.n.Dtu.scene, com.tencent.mm.plugin.expt.hellhound.a.dIJ())) && (!s.p(q.n.DtL.scene, com.tencent.mm.plugin.expt.hellhound.a.dIJ()))) {
          break label264;
        }
        i = 1;
        label141:
        if (i == 0) {
          break label269;
        }
      }
    }
    label264:
    label269:
    for (boolean bool = true;; bool = false)
    {
      this.Ebc = bool;
      Ebe = this.Ebc;
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      this.refreshInterval = com.tencent.mm.plugin.finder.live.utils.a.aBP().getInt("finder_live_watch_count_down_refresh_interval", 0);
      paramBundle = com.tencent.d.a.b.a.a.a.a.ahqb;
      com.tencent.d.a.b.a.a.a.a.cl((kotlin.g.a.a)new b(this));
      Log.i("FinderLiveWatchCountDownUIC", "onCreate objectId = " + Ebd + " refreshInterval = " + this.refreshInterval + " isFromRed: " + this.Ebc);
      exT();
      AppMethodBeat.o(356962);
      return;
      l = paramBundle.id;
      break;
      i = 0;
      break label141;
    }
  }
  
  public final void onPreDestroyed()
  {
    AppMethodBeat.i(356980);
    super.onPreDestroyed();
    d.H(this.hPJ);
    Fragment localFragment = getFragment();
    if (localFragment != null)
    {
      k localk = k.aeZF;
      k.y(localFragment).q(i.class);
    }
    ((com.tencent.d.a.b.a.b.a)h.ax(com.tencent.d.a.b.a.b.a.class)).deo();
    Log.i("FinderLiveWatchCountDownUIC", "onDestroy");
    AppMethodBeat.o(356980);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveWatchCountDownUIC$Companion;", "", "()V", "TAG", "", "UNIT_MILLIS", "", "currentObjectId", "getCurrentObjectId", "()J", "setCurrentObjectId", "(J)V", "lastFromRed", "", "getLastFromRed", "()Z", "setLastFromRed", "(Z)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.j
 * JD-Core Version:    0.7.0.1
 */