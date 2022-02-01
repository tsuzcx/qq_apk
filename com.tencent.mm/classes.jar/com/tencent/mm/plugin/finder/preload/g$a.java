package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
{
  public static String azk(String paramString)
  {
    AppMethodBeat.i(346117);
    s.u(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(346117);
      return "";
    }
    if (paramString.length() <= 13)
    {
      AppMethodBeat.o(346117);
      return paramString;
    }
    paramString = paramString.substring(13, k.qv(paramString.length(), 24));
    s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(346117);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.g.a
 * JD-Core Version:    0.7.0.1
 */