package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"})
public final class x
{
  private static final String TAG = "Finder.FinderCgiConstants";
  private static final String rIS = "/cgi-bin/mmfinder-bin";
  private static final String rIT = "/cgi-bin/micromsg-bin";
  private static String rIU;
  public static final x rIV;
  
  static
  {
    AppMethodBeat.i(168863);
    rIV = new x();
    TAG = "Finder.FinderCgiConstants";
    rIS = "/cgi-bin/mmfinder-bin";
    rIT = "/cgi-bin/micromsg-bin";
    rIU = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void cxZ()
  {
    AppMethodBeat.i(168862);
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IHZ, 0);
    if (i == 1) {}
    for (rIU = rIS;; rIU = rIT)
    {
      ad.i(TAG, "config " + i + ' ' + rIU);
      AppMethodBeat.o(168862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */