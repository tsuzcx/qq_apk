package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class p
  implements k, a
{
  public FinderContact contact;
  
  public p(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(276025);
    this.contact = paramFinderContact;
    AppMethodBeat.o(276025);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(276024);
    kotlin.g.b.p.k(paramk, "obj");
    AppMethodBeat.o(276024);
    return 0;
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(276023);
    int i = p.class.getName().hashCode();
    AppMethodBeat.o(276023);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(276022);
    String str = this.contact.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = i;
      AppMethodBeat.o(276022);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.p
 * JD-Core Version:    0.7.0.1
 */