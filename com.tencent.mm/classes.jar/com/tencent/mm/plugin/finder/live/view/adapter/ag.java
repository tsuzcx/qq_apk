package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.d;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingSecondaryServiceGoodsListAdapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingSecondaryGoodsListAdapter;", "context", "Landroid/content/Context;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends af
{
  public static final ag.a DTA;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final bz DSJ;
  private final Context context;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(358808);
    DTA = new ag.a((byte)0);
    AppMethodBeat.o(358808);
  }
  
  public ag(Context paramContext, com.tencent.mm.live.b.b paramb, bz parambz, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(paramContext, paramb, parambz, parama);
    AppMethodBeat.i(358780);
    this.context = paramContext;
    this.nfT = paramb;
    this.DSJ = parambz;
    this.CvU = parama;
    AppMethodBeat.o(358780);
  }
  
  private static final void a(RecyclerView.v paramv, final ag paramag, final k paramk, View paramView)
  {
    AppMethodBeat.i(358789);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramag);
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingSecondaryServiceGoodsListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "$holder");
    s.u(paramag, "this$0");
    s.u(paramk, "$item");
    paramv = (k)paramag.PE(((d)paramv).KJ());
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(paramag.context, paramv, (kotlin.g.a.a)new b(paramv, paramag, paramk));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingSecondaryServiceGoodsListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358789);
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(358829);
    s.u(paramv, "holder");
    super.d(paramv, paramInt);
    if (!(paramv instanceof d))
    {
      AppMethodBeat.o(358829);
      return;
    }
    k localk = (k)PE(paramInt);
    ((d)paramv).a(localk, this.DSR);
    ((d)paramv).DUs.setVisibility(8);
    ((d)paramv).DSU.setVisibility(8);
    paramv.caK.setOnClickListener(new ag..ExternalSyntheticLambda0(paramv, this, localk));
    AppMethodBeat.o(358829);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(k paramk1, ag paramag, k paramk2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ag
 * JD-Core Version:    0.7.0.1
 */