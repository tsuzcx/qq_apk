package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LoadingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/LoadingConvertData;", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "getOutsideOperator", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.i>
{
  public static final a EOv;
  private final b ENg;
  
  static
  {
    AppMethodBeat.i(340513);
    EOv = new a((byte)0);
    AppMethodBeat.o(340513);
  }
  
  public i(b paramb)
  {
    this.ENg = paramb;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340525);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(340525);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGX;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LoadingConvert$Companion;", "", "()V", "TAG", "", "autoAddLoadingItem", "", "feeds", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "continueFlag", "", "autoRemoveLoadingItem", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(ArrayList<cc> paramArrayList, WxRecyclerAdapter<cc> paramWxRecyclerAdapter)
    {
      AppMethodBeat.i(340477);
      s.u(paramArrayList, "feeds");
      s.u(paramWxRecyclerAdapter, "adapter");
      cc localcc = (cc)p.oN((List)paramArrayList);
      if ((localcc != null) && ((localcc instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.i)))
      {
        p.oH((List)paramArrayList);
        paramWxRecyclerAdapter.fX(paramArrayList.size());
      }
      AppMethodBeat.o(340477);
    }
    
    public static void a(ArrayList<cc> paramArrayList, WxRecyclerAdapter<cc> paramWxRecyclerAdapter, int paramInt)
    {
      AppMethodBeat.i(340483);
      s.u(paramArrayList, "feeds");
      s.u(paramWxRecyclerAdapter, "adapter");
      if (paramInt <= 0)
      {
        AppMethodBeat.o(340483);
        return;
      }
      if (!((Collection)p.a((Iterable)paramArrayList, com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.i.class)).isEmpty()) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(340483);
        return;
      }
      paramArrayList.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.i());
      paramWxRecyclerAdapter.fW(paramArrayList.size() - 1);
      AppMethodBeat.o(340483);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.i
 * JD-Core Version:    0.7.0.1
 */