package com.tencent.mm.plugin.finder.live.utils.fake;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftSingleDebug;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "createDefault", "giftType", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "count", "", "show", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a DKu;
  private static final String TAG;
  private final a CvU;
  private final LinkedList<c.d> DKi;
  private final MMActivity activity;
  
  static
  {
    AppMethodBeat.i(351154);
    DKu = new a((byte)0);
    TAG = "MicroMsg.FinderLiveGiftMockDebug";
    AppMethodBeat.o(351154);
  }
  
  public d(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(351076);
    this.activity = paramMMActivity;
    this.CvU = parama;
    this.DKi = new LinkedList();
    AppMethodBeat.o(351076);
  }
  
  private final c.d a(e parame, int paramInt)
  {
    AppMethodBeat.i(351084);
    c localc = c.DKj;
    parame = (c.c)c.euW().get(parame);
    if (parame == null)
    {
      AppMethodBeat.o(351084);
      return null;
    }
    parame = parame.Pv(paramInt);
    if (parame == null)
    {
      AppMethodBeat.o(351084);
      return null;
    }
    parame = parame.axT(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
    AppMethodBeat.o(351084);
    return parame;
  }
  
  private static final void a(d paramd, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(351149);
    kotlin.g.b.s.u(paramd, "this$0");
    if (params.jmw())
    {
      params.c(1, (CharSequence)kotlin.g.b.s.X(e.DKw.DKv, "*1")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda5(paramd));
      params.c(2, (CharSequence)kotlin.g.b.s.X(e.DKx.DKv, "*2")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda4(paramd));
      params.c(3, (CharSequence)kotlin.g.b.s.X(e.DKy.DKv, "*3")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda2(paramd));
      params.c(4, (CharSequence)kotlin.g.b.s.X(e.DKz.DKv, "*1")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda9(paramd));
      params.c(5, (CharSequence)kotlin.g.b.s.X(e.DKA.DKv, "*1")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda8(paramd));
      params.c(6, (CharSequence)kotlin.g.b.s.X(e.DKB.DKv, "*2")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda6(paramd));
      params.c(7, (CharSequence)kotlin.g.b.s.X(e.DKC.DKv, "*3")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda3(paramd));
      params.c(8, (CharSequence)kotlin.g.b.s.X(e.DKD.DKv, "*1")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda7(paramd));
      params.c(9, (CharSequence)kotlin.g.b.s.X(e.DKE.DKv, "*1")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda0(paramd));
      params.c(10, (CharSequence)kotlin.g.b.s.X(e.DKF.DKv, "*1")).setOnMenuItemClickListener(new d..ExternalSyntheticLambda1(paramd));
    }
    AppMethodBeat.o(351149);
  }
  
  private static final boolean a(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351088);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKw, 1));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351088);
    return true;
  }
  
  private static final boolean b(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351093);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKx, 2));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351093);
    return true;
  }
  
  private static final boolean c(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351096);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKy, 3));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351096);
    return true;
  }
  
  private static final boolean d(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351100);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKz, 1));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351100);
    return true;
  }
  
  private static final boolean e(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351106);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKA, 1));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351106);
    return true;
  }
  
  private static final boolean f(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351113);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKB, 2));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351113);
    return true;
  }
  
  private static final boolean g(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351120);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKC, 3));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351120);
    return true;
  }
  
  private static final boolean h(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351126);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKD, 1));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351126);
    return true;
  }
  
  private static final boolean i(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351132);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKE, 1));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351132);
    return true;
  }
  
  private static final boolean j(d paramd, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(351137);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.DKi.offerLast(paramd.a(e.DKF, 1));
    paramMenuItem = c.DKj;
    c.gH((List)paramd.DKi);
    AppMethodBeat.o(351137);
    return true;
  }
  
  public final void show()
  {
    AppMethodBeat.i(351233);
    f localf = new f((Context)this.activity, 1, false);
    localf.Vtg = new d..ExternalSyntheticLambda10(this);
    localf.dDn();
    AppMethodBeat.o(351233);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftSingleDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.d
 * JD-Core Version:    0.7.0.1
 */