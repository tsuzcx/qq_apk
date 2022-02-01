package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements k, a
{
  public FinderContact contact;
  
  public p(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(332224);
    this.contact = paramFinderContact;
    AppMethodBeat.o(332224);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332252);
    s.u(paramk, "obj");
    AppMethodBeat.o(332252);
    return 0;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332235);
    String str = this.contact.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = i;
      AppMethodBeat.o(332235);
      return l;
    }
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332244);
    int i = p.class.getName().hashCode();
    AppMethodBeat.o(332244);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.p
 * JD-Core Version:    0.7.0.1
 */