package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptKVStorageTransfer$Companion;", "", "()V", "TAG", "", "getKey", "key", "uin", "", "appId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static String b(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(323249);
    s.u(paramString1, "key");
    s.u(paramString2, "appId");
    paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
    AppMethodBeat.o(323249);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.a.a
 * JD-Core Version:    0.7.0.1
 */