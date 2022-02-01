package com.tencent.luggage.wxa.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
public final class b
{
  public static final b cDF;
  
  static
  {
    AppMethodBeat.i(146074);
    cDF = new b();
    AppMethodBeat.o(146074);
  }
  
  public static final String Pn()
  {
    AppMethodBeat.i(146073);
    Object localObject = new StringBuilder();
    Context localContext = MMApplicationContext.getContext();
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