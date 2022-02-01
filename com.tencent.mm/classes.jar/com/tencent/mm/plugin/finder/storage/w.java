package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isHdrSpec", "", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "plugin-finder-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final boolean a(v paramv)
  {
    AppMethodBeat.i(339226);
    s.u(paramv, "<this>");
    if ((paramv == v.FLA) || (paramv == v.FLz))
    {
      AppMethodBeat.o(339226);
      return true;
    }
    AppMethodBeat.o(339226);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.w
 * JD-Core Version:    0.7.0.1
 */