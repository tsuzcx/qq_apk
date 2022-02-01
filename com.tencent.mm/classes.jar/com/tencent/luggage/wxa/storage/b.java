package com.tencent.luggage.wxa.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
public final class b
{
  public static final b crp;
  
  static
  {
    AppMethodBeat.i(146074);
    crp = new b();
    AppMethodBeat.o(146074);
  }
  
  public static final String FE()
  {
    AppMethodBeat.i(146073);
    Object localObject = new StringBuilder();
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localObject = localContext.getPackageName() + ".wxa_critical_content";
    AppMethodBeat.o(146073);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.b
 * JD-Core Version:    0.7.0.1
 */