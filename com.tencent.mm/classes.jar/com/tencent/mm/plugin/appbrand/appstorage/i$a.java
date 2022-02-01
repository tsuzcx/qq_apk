package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "getKEY_HAD_FINISH_TRANSFER", "()Ljava/lang/String;", "KEY_HAD_TRANSFER_TO_MMKV", "getKEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", "uin", "", "appId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$a
{
  public static String b(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(50210);
    s.u(paramString1, "key");
    s.u(paramString2, "appId");
    paramString1 = paramString1 + '#' + paramLong + '#' + paramString2;
    AppMethodBeat.o(50210);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i.a
 * JD-Core Version:    0.7.0.1
 */