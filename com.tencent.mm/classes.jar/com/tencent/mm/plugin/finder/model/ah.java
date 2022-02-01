package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class ah
  implements a
{
  public final i contact;
  
  public ah(i parami)
  {
    AppMethodBeat.i(286937);
    this.contact = parami;
    AppMethodBeat.o(286937);
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(286936);
    int i = ah.class.getName().hashCode();
    AppMethodBeat.o(286936);
    return i;
  }
  
  public final long mf()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ah
 * JD-Core Version:    0.7.0.1
 */