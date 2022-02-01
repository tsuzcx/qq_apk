package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.cb;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.bgw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "canClearScreen", "", "checkFansClubState", "", "onFollowChanged", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFollow", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cm
  extends b
{
  public static final cm.a DlR;
  
  static
  {
    AppMethodBeat.i(354303);
    DlR = new cm.a((byte)0);
    AppMethodBeat.o(354303);
  }
  
  public cm(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354283);
    paramViewGroup.setOnClickListener(new cm..ExternalSyntheticLambda0(paramb));
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
    AppMethodBeat.o(354283);
  }
  
  private static final void a(com.tencent.mm.live.b.b paramb, View paramView)
  {
    AppMethodBeat.i(354297);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$statusMonitor");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354297);
      return;
    }
    k.a(k.Doi, q.cb.DEo, null, null, 6);
    b.b.a(paramb, b.c.nfw);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354297);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void esz()
  {
    AppMethodBeat.i(354334);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.q(getBuContext()))
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      if ((localObject != null) && (((bgw)localObject).ZQq == true))
      {
        i = 1;
        if (i == 0) {
          break label133;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if ((localObject == null) || (((bgw)localObject).ZQo != true)) {
          break label128;
        }
      }
      label128:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Eff) || (((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())) {
          break label133;
        }
        tO(0);
        AppMethodBeat.o(354334);
        return;
        i = 0;
        break;
      }
    }
    label133:
    tO(8);
    AppMethodBeat.o(354334);
  }
  
  public final void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(354325);
    esz();
    AppMethodBeat.o(354325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cm
 * JD-Core Version:    0.7.0.1
 */