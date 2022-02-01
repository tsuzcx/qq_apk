package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
public final class c$a
{
  public static String aiC(String paramString)
  {
    AppMethodBeat.i(203518);
    p.h(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203518);
      return "";
    }
    if (paramString.length() <= 13)
    {
      AppMethodBeat.o(203518);
      return paramString;
    }
    paramString = paramString.substring(13, j.lx(paramString.length(), 24));
    p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(203518);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c.a
 * JD-Core Version:    0.7.0.1
 */