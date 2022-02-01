package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"})
public final class ao
{
  private static final String TAG = "Finder.FinderCgiConstants";
  private static final String tuB = "/cgi-bin/mmfinder-bin";
  private static final String tuC = "/cgi-bin/micromsg-bin";
  private static String tuD;
  public static final ao tuE;
  
  static
  {
    AppMethodBeat.i(168863);
    tuE = new ao();
    TAG = "Finder.FinderCgiConstants";
    tuB = "/cgi-bin/mmfinder-bin";
    tuC = "/cgi-bin/micromsg-bin";
    tuD = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void cYb()
  {
    AppMethodBeat.i(168862);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OlG, 0);
    if (i == 1) {}
    for (tuD = tuB;; tuD = tuC)
    {
      Log.i(TAG, "config " + i + ' ' + tuD);
      AppMethodBeat.o(168862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ao
 * JD-Core Version:    0.7.0.1
 */