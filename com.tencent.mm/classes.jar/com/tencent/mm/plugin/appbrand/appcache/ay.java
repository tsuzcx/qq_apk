package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"DefaultLocale"})
class ay
  extends a
{
  public final String nGm;
  
  ay(String paramString1, int paramInt, String paramString2, String paramString3, a.a parama)
  {
    super(str1, str2 + String.format("debug_%d_%d_%d", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(Util.nullAsNil(parama.bGQ()).hashCode()) }), paramString3, paramString1, String.format("%s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), Util.nullAsNil(parama.bGQ()) }).hashCode(), paramInt);
    AppMethodBeat.i(206582);
    this.nGm = paramString2;
    AppMethodBeat.o(206582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ay
 * JD-Core Version:    0.7.0.1
 */