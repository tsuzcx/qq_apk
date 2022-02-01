package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"debugPrint", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "print", "Lcom/tencent/mm/protocal/protobuf/FinderHlsMediaSpec;", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final String a(boz paramboz)
  {
    AppMethodBeat.i(346299);
    s.u(paramboz, "<this>");
    paramboz = "Spec[" + paramboz.EVK + ' ' + paramboz.hVy + ' ' + Util.getSizeKB(paramboz.ZMg) + ' ' + paramboz.ZPI + ']';
    AppMethodBeat.o(346299);
    return paramboz;
  }
  
  public static final String b(boz paramboz)
  {
    AppMethodBeat.i(346302);
    s.u(paramboz, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("Spec[").append(paramboz.EVK).append(' ');
    if (s.p(paramboz.hVy, "h264")) {}
    for (String str = "4";; str = "5")
    {
      paramboz = str + ' ' + Util.getSizeKB(paramboz.ZMg) + ' ' + paramboz.ZPI + ']';
      AppMethodBeat.o(346302);
      return paramboz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.c
 * JD-Core Version:    0.7.0.1
 */