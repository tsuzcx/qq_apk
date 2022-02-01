package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"})
public final class j
{
  private static final String TAG = "Finder.FinderCgiConstants";
  private static final String qoL = "/cgi-bin/mmfinder-bin";
  private static final String qoM = "/cgi-bin/micromsg-bin";
  private static String qoN;
  public static final j qoO;
  
  static
  {
    AppMethodBeat.i(168863);
    qoO = new j();
    TAG = "Finder.FinderCgiConstants";
    qoL = "/cgi-bin/mmfinder-bin";
    qoM = "/cgi-bin/micromsg-bin";
    qoN = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void cky()
  {
    AppMethodBeat.i(168862);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.Fxb, 0);
    if (i == 1) {}
    for (qoN = qoL;; qoN = qoM)
    {
      ad.i(TAG, "config " + i + ' ' + qoN);
      AppMethodBeat.o(168862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */