package com.tencent.luggage.wxa.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b exx;
  
  static
  {
    AppMethodBeat.i(146074);
    exx = new b();
    AppMethodBeat.o(146074);
  }
  
  public static final String atr()
  {
    AppMethodBeat.i(146073);
    String str = s.X(MMApplicationContext.getContext().getPackageName(), ".wxa_critical_content");
    AppMethodBeat.o(146073);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.b
 * JD-Core Version:    0.7.0.1
 */