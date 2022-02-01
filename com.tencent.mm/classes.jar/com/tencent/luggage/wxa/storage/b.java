package com.tencent.luggage.wxa.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"})
public final class b
{
  public static final b cqL;
  
  static
  {
    AppMethodBeat.i(146074);
    cqL = new b();
    AppMethodBeat.o(146074);
  }
  
  public static final String Fy()
  {
    AppMethodBeat.i(146073);
    Object localObject = new StringBuilder();
    Context localContext = aj.getContext();
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