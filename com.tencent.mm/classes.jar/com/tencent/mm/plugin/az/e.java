package com.tencent.mm.plugin.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"getManifestId", "", "host", "getPrefetcherId", "appId", "key", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "webview-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final String a(a parama)
  {
    AppMethodBeat.i(260997);
    s.u(parama, "<this>");
    Object localObject1 = parama.WmT.oOI;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      s.s(localObject1, "realAppId");
      AppMethodBeat.o(260997);
      return localObject1;
    }
    localObject1 = (CharSequence)parama.WmT.IcT;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {
      i = 1;
    }
    while (i != 0)
    {
      parama = parama.WmS.aamn;
      if (parama == null)
      {
        AppMethodBeat.o(260997);
        return "";
        i = 0;
      }
      else
      {
        AppMethodBeat.o(260997);
        return parama;
      }
    }
    localObject2 = parama.WmT.IcT;
    s.s(localObject2, "it");
    localObject1 = localObject2;
    if (!n.U((String)localObject2, "/", false)) {
      localObject1 = s.X("/", localObject2);
    }
    s.s(localObject1, "manifest.Path.let {\n    …/\")) \"/$it\" else it\n    }");
    localObject2 = n.m((String)localObject1, "/", "_", false);
    localObject1 = parama.WmS.aamn;
    parama = (a)localObject1;
    if (localObject1 == null) {
      parama = "";
    }
    parama = s.X(parama, localObject2);
    AppMethodBeat.o(260997);
    return parama;
  }
  
  public static final String bim(String paramString)
  {
    AppMethodBeat.i(260983);
    s.u(paramString, "host");
    paramString = s.X("_manifest_", Integer.valueOf(paramString.hashCode()));
    AppMethodBeat.o(260983);
    return paramString;
  }
  
  public static final String bin(String paramString)
  {
    AppMethodBeat.i(260989);
    s.u(paramString, "appId");
    paramString = s.X("_prefetcher_", paramString);
    AppMethodBeat.o(260989);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.az.e
 * JD-Core Version:    0.7.0.1
 */