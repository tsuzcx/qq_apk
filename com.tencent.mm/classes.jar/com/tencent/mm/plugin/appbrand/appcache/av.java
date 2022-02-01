package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"DefaultLocale"})
class av
  extends a
{
  av(String paramString1, String paramString2, int paramInt)
  {
    super(str1, str2 + String.format("debug_%d_%d_%d.wxapkg", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(paramString2.hashCode()) }), paramString2, paramString1, String.format("%d-%s", new Object[] { Integer.valueOf(paramInt), paramString2 }).hashCode(), paramInt);
    AppMethodBeat.i(90588);
    AppMethodBeat.o(90588);
  }
  
  av(String paramString1, String paramString2, int paramInt, a.a parama)
  {
    super(str1, str2 + String.format("debug_%d_%d_%d", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(Util.nullAsNil(parama.bvJ()).hashCode()) }), paramString2, paramString1, String.format("%s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), Util.nullAsNil(parama.bvJ()) }).hashCode(), paramInt);
    AppMethodBeat.i(90589);
    AppMethodBeat.o(90589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av
 * JD-Core Version:    0.7.0.1
 */