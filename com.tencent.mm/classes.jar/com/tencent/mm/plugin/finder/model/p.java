package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class p
  implements i, a
{
  public FinderContact contact;
  
  public p(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(248725);
    this.contact = paramFinderContact;
    AppMethodBeat.o(248725);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248724);
    kotlin.g.b.p.h(parami, "obj");
    AppMethodBeat.o(248724);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248723);
    int i = p.class.getName().hashCode();
    AppMethodBeat.o(248723);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248722);
    String str = this.contact.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = i;
      AppMethodBeat.o(248722);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.p
 * JD-Core Version:    0.7.0.1
 */