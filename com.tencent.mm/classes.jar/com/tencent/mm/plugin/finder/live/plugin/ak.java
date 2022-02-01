package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bgDecorationView", "Lorg/libpag/PAGView;", "delayTask", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin$delayTask$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin$delayTask$1;", "canClearScreen", "", "checkDecoration", "", "item", "Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;", "playBgDecoration", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateBgDecoration", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends b
{
  public static final ak.a CYP;
  private static final String TAG;
  private final PAGView CYQ;
  private final d CYR;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355781);
    CYP = new ak.a((byte)0);
    TAG = "Finder.FinderLiveDecorationPlugin";
    AppMethodBeat.o(355781);
  }
  
  public ak(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355734);
    this.nfT = paramb;
    paramb = paramViewGroup.findViewById(p.e.BKh);
    s.s(paramb, "root.findViewById(R.id.f…_live_decoration_bg_view)");
    this.CYQ = ((PAGView)paramb);
    this.CYR = new d(paramViewGroup, this);
    AppMethodBeat.o(355734);
  }
  
  private final void eqg()
  {
    AppMethodBeat.i(355746);
    com.tencent.mm.plugin.finder.viewmodel.business.a locala = (com.tencent.mm.plugin.finder.viewmodel.business.a)business(com.tencent.mm.plugin.finder.viewmodel.business.a.class);
    locala.GLV = System.currentTimeMillis();
    this.CYQ.setVisibility(0);
    tO(0);
    this.CYQ.setProgress(0.0D);
    this.CYQ.setPath(com.tencent.mm.plugin.finder.viewmodel.business.a.d(locala.GLU));
    this.CYQ.stop();
    this.CYQ.play();
    this.CYQ.flush();
    AppMethodBeat.o(355746);
  }
  
  public final void a(final dik paramdik)
  {
    AppMethodBeat.i(355786);
    d.uiThread((kotlin.g.a.a)new c(this, paramdik));
    AppMethodBeat.o(355786);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355796);
    s.u(paramc, "status");
    boolean bool;
    long l2;
    long l1;
    if (ak.b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if (paramBundle != null) {
        break label189;
      }
      bool = false;
      if (bool)
      {
        paramc = (com.tencent.mm.plugin.finder.viewmodel.business.a)business(com.tencent.mm.plugin.finder.viewmodel.business.a.class);
        l2 = System.currentTimeMillis();
        if (paramc.GLV != 0L) {
          break label200;
        }
        paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
        l1 = ((Number)com.tencent.d.a.a.a.a.a.jUU().bmg()).longValue() * 1000L;
      }
    }
    for (;;)
    {
      Log.i(TAG, "fromMiniWin will running delayTask. lastBgDecorShowTimestamp:" + paramc.GLV + " now:" + l2 + " delay:" + l1);
      paramc = this.mJe;
      paramBundle = (Runnable)this.CYR;
      l1 = k.bR(l1, 0L);
      com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
      paramc.postDelayed(paramBundle, k.bS(l1, ((Number)com.tencent.d.a.a.a.a.a.jUU().bmg()).longValue() * 1000L));
      AppMethodBeat.o(355796);
      return;
      label189:
      bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW");
      break;
      label200:
      if (l2 - paramc.GLV <= 0L)
      {
        paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
        l1 = ((Number)com.tencent.d.a.a.a.a.a.jUU().bmg()).longValue() * 1000L;
      }
      else
      {
        paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
        l1 = ((Number)com.tencent.d.a.a.a.a.a.jUU().bmg()).longValue();
        long l3 = paramc.GLV;
        paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
        l1 = l1 * 1000L - (l2 - l3) % (((Number)com.tencent.d.a.a.a.a.a.jUU().bmg()).longValue() * 1000L);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355811);
    super.unMount();
    this.mJe.removeCallbacks((Runnable)this.CYR);
    AppMethodBeat.o(355811);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ak paramak, dik paramdik)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin$delayTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    d(ViewGroup paramViewGroup, ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(354119);
      Object localObject = ak.CYP;
      Log.i(ak.access$getTAG$cp(), s.X("updateBgDecoration by running delay task. ", this.nhV.getContext()));
      localObject = this.nhV.getContext();
      if ((localObject instanceof MMActivity))
      {
        localObject = (MMActivity)localObject;
        if ((localObject == null) || (((MMActivity)localObject).isDestroyed())) {
          break label152;
        }
        i = 1;
        label60:
        if (i != 0)
        {
          localObject = this.nhV.getContext();
          if (!(localObject instanceof MMActivity)) {
            break label157;
          }
          localObject = (MMActivity)localObject;
          label84:
          if ((localObject == null) || (((MMActivity)localObject).isFinishing())) {
            break label162;
          }
        }
      }
      label152:
      label157:
      label162:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (!((e)jdField_this.business(e.class)).eyA())) {
          ak.a(jdField_this, ((com.tencent.mm.plugin.finder.viewmodel.business.a)jdField_this.business(com.tencent.mm.plugin.finder.viewmodel.business.a.class)).GLU);
        }
        AppMethodBeat.o(354119);
        return;
        localObject = null;
        break;
        i = 0;
        break label60;
        localObject = null;
        break label84;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    e(dik paramdik, com.tencent.mm.plugin.finder.viewmodel.business.a parama, ak paramak)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ak
 * JD-Core Version:    0.7.0.1
 */