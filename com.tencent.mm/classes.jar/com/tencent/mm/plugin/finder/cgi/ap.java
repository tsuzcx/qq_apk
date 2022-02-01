package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"})
public final class ap
{
  private static final String TAG = "Finder.FinderCgiConstants";
  private static final String xck = "/cgi-bin/mmfinder-bin";
  private static final String xcl = "/cgi-bin/micromsg-bin";
  private static String xcm;
  public static final ap xcn;
  
  static
  {
    AppMethodBeat.i(168863);
    xcn = new ap();
    TAG = "Finder.FinderCgiConstants";
    xck = "/cgi-bin/mmfinder-bin";
    xcl = "/cgi-bin/micromsg-bin";
    xcm = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void dnQ()
  {
    AppMethodBeat.i(168862);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VAB, 0);
    if (i == 1) {}
    for (xcm = xck;; xcm = xcl)
    {
      Log.i(TAG, "config " + i + ' ' + xcm);
      AppMethodBeat.o(168862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */