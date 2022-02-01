package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/AdAdapter;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "itemConvertFactory", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/AdItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/AdItemConvertFactory;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends WxRecyclerAdapter<cc>
{
  private final ArrayList<cc> data;
  
  public a(b paramb, ArrayList<cc> paramArrayList)
  {
    super((g)paramb, paramArrayList);
    AppMethodBeat.i(340415);
    this.data = paramArrayList;
    AppMethodBeat.o(340415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.a
 * JD-Core Version:    0.7.0.1
 */