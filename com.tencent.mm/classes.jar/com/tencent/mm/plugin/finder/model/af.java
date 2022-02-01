package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class af
  implements a
{
  public final g contact;
  
  public af(g paramg)
  {
    AppMethodBeat.i(248754);
    this.contact = paramg;
    AppMethodBeat.o(248754);
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248753);
    int i = af.class.getName().hashCode();
    AppMethodBeat.o(248753);
    return i;
  }
  
  public final long lT()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.af
 * JD-Core Version:    0.7.0.1
 */