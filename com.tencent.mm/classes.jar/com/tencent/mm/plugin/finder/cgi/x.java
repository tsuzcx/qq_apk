package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"})
public final class x
{
  private static final String TAG = "Finder.FinderCgiConstants";
  private static final String rRc = "/cgi-bin/mmfinder-bin";
  private static final String rRd = "/cgi-bin/micromsg-bin";
  private static String rRe;
  public static final x rRf;
  
  static
  {
    AppMethodBeat.i(168863);
    rRf = new x();
    TAG = "Finder.FinderCgiConstants";
    rRc = "/cgi-bin/mmfinder-bin";
    rRd = "/cgi-bin/micromsg-bin";
    rRe = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void czA()
  {
    AppMethodBeat.i(168862);
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JcC, 0);
    if (i == 1) {}
    for (rRe = rRc;; rRe = rRd)
    {
      ae.i(TAG, "config " + i + ' ' + rRe);
      AppMethodBeat.o(168862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */