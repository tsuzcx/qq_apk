package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public enum e
  implements n
{
  static
  {
    AppMethodBeat.i(129453);
    gXz = new e("INSTANCE");
    gXA = new e[] { gXz };
    AppMethodBeat.o(129453);
  }
  
  private e() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(129451);
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!bo.isNullOrNil(paramString)) {
      g.cT(paramString).j(new e.1(this));
    }
    AppMethodBeat.o(129451);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e
 * JD-Core Version:    0.7.0.1
 */