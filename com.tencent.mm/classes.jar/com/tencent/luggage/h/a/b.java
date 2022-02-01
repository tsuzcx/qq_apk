package com.tencent.luggage.h.a;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylineBoot;", "", "()V", "TAG", "", "init", "", "renderBackend", "", "isLibSupportSkyline", "", "libReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "isUseSkyline", "shouldInitSkyline", "supportSkyline", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ewj;
  
  static
  {
    AppMethodBeat.i(220062);
    ewj = new b();
    AppMethodBeat.o(220062);
  }
  
  public static boolean a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(220044);
    s.checkNotNull(paramICommLibReader);
    boolean bool = Boolean.parseBoolean(paramICommLibReader.UX("skyline"));
    AppMethodBeat.o(220044);
    return bool;
  }
  
  public static boolean atc()
  {
    AppMethodBeat.i(220054);
    c localc = c.evV;
    boolean bool = c.asU();
    AppMethodBeat.o(220054);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.a.b
 * JD-Core Version:    0.7.0.1
 */