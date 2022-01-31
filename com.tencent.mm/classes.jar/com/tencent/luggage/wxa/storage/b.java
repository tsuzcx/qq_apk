package com.tencent.luggage.wxa.storage;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
public final class b
{
  public static final b bFO;
  
  static
  {
    AppMethodBeat.i(94161);
    bFO = new b();
    AppMethodBeat.o(94161);
  }
  
  public static final String xf()
  {
    AppMethodBeat.i(94160);
    Object localObject = new StringBuilder();
    Context localContext = ah.getContext();
    j.p(localContext, "MMApplicationContext.getContext()");
    localObject = localContext.getPackageName() + ".wxa_critical_content";
    AppMethodBeat.o(94160);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.b
 * JD-Core Version:    0.7.0.1
 */