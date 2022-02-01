package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BigBannerAdapter;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "itemConvertFactory", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BigBannerItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BigBannerItemConvertFactory;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends WxRecyclerAdapter<cc>
{
  private final ArrayList<cc> data;
  
  public d(e parame, ArrayList<cc> paramArrayList)
  {
    super((g)parame, paramArrayList);
    AppMethodBeat.i(340558);
    this.data = paramArrayList;
    AppMethodBeat.o(340558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.d
 * JD-Core Version:    0.7.0.1
 */