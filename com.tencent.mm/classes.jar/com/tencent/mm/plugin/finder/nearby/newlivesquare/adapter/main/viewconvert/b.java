package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.h;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/AdListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/AdListConvertData;", "outsideEventListener", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "nearbyLiveViewItemClick", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick;", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clear", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "Companion", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.b>
{
  public static final b.a ENB;
  private a EMS;
  private final h ENC;
  private bui ENE;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  
  static
  {
    AppMethodBeat.i(340551);
    ENB = new b.a((byte)0);
    AppMethodBeat.o(340551);
  }
  
  public b(h paramh, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb)
  {
    AppMethodBeat.i(340537);
    this.ENC = paramh;
    this.ENg = paramb;
    AppMethodBeat.o(340537);
  }
  
  private static void F(j paramj)
  {
    AppMethodBeat.i(370500);
    Object localObject = paramj.tag;
    if ((localObject != null) && ((localObject instanceof b.c))) {
      ((b.c)localObject).CVn.a(null);
    }
    paramj.tag = null;
    AppMethodBeat.o(370500);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340568);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = k.aeZF;
    paramRecyclerView = paramj.context;
    s.s(paramRecyclerView, "holder.context");
    paramRecyclerView = ((as)k.nq(paramRecyclerView).q(as.class)).fou();
    Object localObject = paramj.context;
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(340568);
      throw paramRecyclerView;
    }
    this.EMS = new a(paramRecyclerView, (MMActivity)localObject, null);
    localObject = ah.aiuX;
    this.ENE = paramRecyclerView;
    paramRecyclerView = paramj.caK.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB = true;
    }
    AppMethodBeat.o(340568);
  }
  
  public final int getLayoutId()
  {
    return f.e.akhr;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(370509);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("AdListConvert", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(370509);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/AdListConvert$onBindViewHolder$adapter$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.b paramb, b paramb1, ah.f<WxRecyclerView> paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.b
 * JD-Core Version:    0.7.0.1
 */