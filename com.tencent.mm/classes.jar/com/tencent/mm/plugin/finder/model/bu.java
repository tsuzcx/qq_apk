package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderSearchData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "searchHint", "", "(I)V", "getSearchHint", "()I", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bu
  extends i.b
{
  public final int EDB;
  
  public bu(int paramInt)
  {
    this.EDB = paramInt;
  }
  
  public final long bZA()
  {
    return 100L;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331898);
    int i = bu.class.getName().hashCode();
    AppMethodBeat.o(331898);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bu
 * JD-Core Version:    0.7.0.1
 */