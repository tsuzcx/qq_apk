package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getItemId", "", "getItemType", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  implements a
{
  public final m contact;
  
  public aj(m paramm)
  {
    AppMethodBeat.i(332137);
    this.contact = paramm;
    AppMethodBeat.o(332137);
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332149);
    int i = aj.class.getName().hashCode();
    AppMethodBeat.o(332149);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aj
 * JD-Core Version:    0.7.0.1
 */