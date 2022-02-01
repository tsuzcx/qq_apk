package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/EnumDownloadUrlRespItemIndex;", "", "()V", "LEGACY", "", "MAX", "PATCH", "ZSTD", "nameOfIndex", "", "index", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u sZw;
  
  static
  {
    AppMethodBeat.i(320793);
    sZw = new u();
    AppMethodBeat.o(320793);
  }
  
  public static String BW(int paramInt)
  {
    AppMethodBeat.i(320789);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(320789);
      return String.valueOf(paramInt);
    case 0: 
      AppMethodBeat.o(320789);
      return "LEGACY";
    case 1: 
      AppMethodBeat.o(320789);
      return "ZSTD";
    }
    AppMethodBeat.o(320789);
    return "PATCH";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.u
 * JD-Core Version:    0.7.0.1
 */