package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.view.recyclerview.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class u
  implements a
{
  public final g contact;
  
  public u(g paramg)
  {
    AppMethodBeat.i(203439);
    this.contact = paramg;
    AppMethodBeat.o(203439);
  }
  
  public final int bZz()
  {
    AppMethodBeat.i(203438);
    int i = u.class.getName().hashCode();
    AppMethodBeat.o(203438);
    return i;
  }
  
  public final long lP()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.u
 * JD-Core Version:    0.7.0.1
 */