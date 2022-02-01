package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum g$b
{
  static
  {
    AppMethodBeat.i(346133);
    EUT = new b("LOADING", 0);
    EUU = new b("PENDING", 1);
    EUV = new b("WAITING", 2);
    EUW = new b[] { EUT, EUU, EUV };
    AppMethodBeat.o(346133);
  }
  
  private g$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.g.b
 * JD-Core Version:    0.7.0.1
 */