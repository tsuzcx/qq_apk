package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.k.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
public final class c$a
{
  public static String adJ(String paramString)
  {
    AppMethodBeat.i(202612);
    k.h(paramString, "mediaId");
    paramString = paramString.substring(13, h.lb(paramString.length(), 24));
    k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(202612);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c.a
 * JD-Core Version:    0.7.0.1
 */