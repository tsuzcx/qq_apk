package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.Util;

class az
  extends a
{
  public final String qGf;
  
  az(String paramString1, int paramInt, String paramString2, String paramString3, a.a parama)
  {
    super(str1, str2 + String.format("debug_%d_%d_%d", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(Util.nullAsNil(parama.append()).hashCode()) }), paramString3, paramString1, String.format("%s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), Util.nullAsNil(parama.append()) }).hashCode(), paramInt);
    AppMethodBeat.i(320226);
    this.qGf = paramString2;
    AppMethodBeat.o(320226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */