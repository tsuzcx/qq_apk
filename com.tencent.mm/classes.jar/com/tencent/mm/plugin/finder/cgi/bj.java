package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgiConstants;", "", "()V", "CGI_1", "", "getCGI_1", "()Ljava/lang/String;", "CGI_2", "getCGI_2", "CGI_PRE", "getCGI_PRE", "setCGI_PRE", "(Ljava/lang/String;)V", "TAG", "getTAG", "config", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bj
{
  public static final bj ABo;
  private static final String ABp;
  private static final String ABq;
  private static String ABr;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(168863);
    ABo = new bj();
    TAG = "Finder.FinderCgiConstants";
    ABp = "/cgi-bin/mmfinder-bin";
    ABq = "/cgi-bin/micromsg-bin";
    ABr = "/cgi-bin/micromsg-bin";
    AppMethodBeat.o(168863);
  }
  
  public static void dVw()
  {
    AppMethodBeat.i(168862);
    int i = h.baE().ban().getInt(at.a.adcT, 0);
    switch (i)
    {
    default: 
      ABr = ABq;
    }
    for (;;)
    {
      Log.i(TAG, "config " + i + ' ' + ABr);
      AppMethodBeat.o(168862);
      return;
      ABr = ABp;
      continue;
      ABr = ABq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bj
 * JD-Core Version:    0.7.0.1
 */