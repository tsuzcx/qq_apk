package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"})
public final class s
{
  private static final String TAG = "Finder.FinderCgiConstants";
  private static final String qXI = "/cgi-bin/mmfinder-bin";
  private static final String qXJ = "/cgi-bin/micromsg-bin";
  private static String qXK;
  public static final s qXL;
  
  static
  {
    AppMethodBeat.i(168863);
    qXL = new s();
    TAG = "Finder.FinderCgiConstants";
    qXI = "/cgi-bin/mmfinder-bin";
    qXJ = "/cgi-bin/micromsg-bin";
    qXK = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void csj()
  {
    AppMethodBeat.i(168862);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GVr, 0);
    if (i == 1) {}
    for (qXK = qXI;; qXK = qXJ)
    {
      ac.i(TAG, "config " + i + ' ' + qXK);
      AppMethodBeat.o(168862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.s
 * JD-Core Version:    0.7.0.1
 */