package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.view.recyclerview.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class t
  implements a
{
  public final g contact;
  
  public t(g paramg)
  {
    AppMethodBeat.i(202956);
    this.contact = paramg;
    AppMethodBeat.o(202956);
  }
  
  public final int bYk()
  {
    AppMethodBeat.i(202955);
    int i = t.class.getName().hashCode();
    AppMethodBeat.o(202955);
    return i;
  }
  
  public final long lP()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.t
 * JD-Core Version:    0.7.0.1
 */