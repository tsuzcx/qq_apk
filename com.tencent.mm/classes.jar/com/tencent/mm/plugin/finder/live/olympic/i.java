package com.tencent.mm.plugin.finder.live.olympic;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.olympic.widget.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsActivitisPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "joinWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget;", "getJoinWidget", "()Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget;", "joinWidget$delegate", "Lkotlin/Lazy;", "runnerTabWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget;", "getRunnerTabWidget", "()Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget;", "runnerTabWidget$delegate", "mount", "", "onBackPress", "", "showJoinPanel", "showPanel", "showRunnerTabPanel", "sportActivity", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final a COg;
  private final j COh;
  private final j COi;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(360505);
    COg = new a((byte)0);
    AppMethodBeat.o(360505);
  }
  
  public i(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(360460);
    this.nfT = paramb;
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360460);
      throw paramViewGroup;
    }
    ((ViewGroup.MarginLayoutParams)paramb).bottomMargin = bf.bk(paramViewGroup.getContext());
    this.COh = k.cm((kotlin.g.a.a)new b(paramViewGroup, this));
    this.COi = k.cm((kotlin.g.a.a)new c(paramViewGroup, this));
    AppMethodBeat.o(360460);
  }
  
  private final void a(fgz paramfgz)
  {
    AppMethodBeat.i(360489);
    tO(0);
    enE().a(paramfgz, this.mJe, isLandscape());
    AppMethodBeat.o(360489);
  }
  
  private final com.tencent.mm.plugin.finder.live.olympic.widget.a enD()
  {
    AppMethodBeat.i(360468);
    com.tencent.mm.plugin.finder.live.olympic.widget.a locala = (com.tencent.mm.plugin.finder.live.olympic.widget.a)this.COh.getValue();
    AppMethodBeat.o(360468);
    return locala;
  }
  
  private final c enE()
  {
    AppMethodBeat.i(360476);
    c localc = (c)this.COi.getValue();
    AppMethodBeat.o(360476);
    return localc;
  }
  
  private final void enF()
  {
    AppMethodBeat.i(360482);
    tO(0);
    enD().e(this.mJe, isLandscape());
    AppMethodBeat.o(360482);
  }
  
  public final void ehV()
  {
    AppMethodBeat.i(360518);
    Object localObject = ((n)business(n.class)).Ehl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        Log.e("FinderLiveOlympicsActivitisPlugin", "showPanel error,sport activity is empty!");
      }
      AppMethodBeat.o(360518);
      return;
    }
    if (((n)business(n.class)).CPq) {
      a((fgz)localObject);
    }
    for (;;)
    {
      localObject = ah.aiuX;
      break;
      enF();
    }
  }
  
  public final void mount()
  {
    AppMethodBeat.i(360530);
    Log.i("FinderLiveOlympicsActivitisPlugin", "mount");
    AppMethodBeat.o(360530);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(360525);
    if (this.mJe.getVisibility() == 0)
    {
      enD().aa(true, false);
      enE().gc(true);
      AppMethodBeat.o(360525);
      return true;
    }
    AppMethodBeat.o(360525);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(360510);
    s.u(paramc, "status");
    if (paramc == b.c.nfE)
    {
      Log.i("FinderLiveOlympicsActivitisPlugin", s.X("isShareFromWXSport:", Boolean.valueOf(((n)business(n.class)).Ehg)));
      if (((n)business(n.class)).Ehg)
      {
        ((n)business(n.class)).Ehg = false;
        ehV();
      }
    }
    AppMethodBeat.o(360510);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(360537);
    Log.i("FinderLiveOlympicsActivitisPlugin", "unMount");
    enD().aa(false, false);
    enE().gc(false);
    tO(8);
    AppMethodBeat.o(360537);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsActivitisPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsJoinWidget;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.olympic.widget.a>
  {
    b(ViewGroup paramViewGroup, i parami)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ViewGroup paramViewGroup, i parami, com.tencent.mm.plugin.finder.live.olympic.widget.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "visible", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Boolean, ah>
    {
      b(i parami)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<c>
  {
    c(ViewGroup paramViewGroup, i parami)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "visible", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Boolean, ah>
    {
      a(i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.i
 * JD-Core Version:    0.7.0.1
 */