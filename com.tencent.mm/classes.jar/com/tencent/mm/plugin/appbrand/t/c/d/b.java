package com.tencent.mm.plugin.appbrand.t.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"AD_CA_ISSUERS_OID", "", "AUTHORITY_INFO_ACCESS_OID_DOT_NOTATION", "", "TAG", "parseAIA", "Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/AuthorityInfoAccess;", "Ljava/security/cert/X509Certificate;", "luggage-commons_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final byte[] tpM = { 43, 6, 1, 5, 5, 7, 48, 2 };
  
  public static final a a(X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(319200);
    s.u(paramX509Certificate, "<this>");
    paramX509Certificate = paramX509Certificate.getExtensionValue("1.3.6.1.5.5.7.1.1");
    if (paramX509Certificate == null)
    {
      Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, aiaExtVal is null");
      AppMethodBeat.o(319200);
      return null;
    }
    try
    {
      paramX509Certificate = new com.tencent.mm.plugin.appbrand.t.c.a.d(paramX509Certificate).Cu(4);
      paramX509Certificate = new com.tencent.mm.plugin.appbrand.t.c.a.d(paramX509Certificate);
      try
      {
        ArrayList localArrayList = new ArrayList();
        while (!paramX509Certificate.cCI())
        {
          Object localObject2 = paramX509Certificate.cCH();
          Object localObject1 = ((com.tencent.mm.plugin.appbrand.t.c.a.d)localObject2).Cu(6);
          ((com.tencent.mm.plugin.appbrand.t.c.a.d)localObject2).checkThread();
          Object localObject3 = ((com.tencent.mm.plugin.appbrand.t.c.a.d)localObject2).cCJ();
          com.tencent.mm.plugin.appbrand.t.c.a.d.a((com.tencent.mm.plugin.appbrand.t.c.a.d)localObject2);
          int i = ((Number)((r)localObject3).bsC).intValue();
          localObject2 = (com.tencent.mm.plugin.appbrand.t.c.a.a)((r)localObject3).bsD;
          localObject3 = com.tencent.mm.plugin.appbrand.t.c.a.b.tpn;
          if ((i == com.tencent.mm.plugin.appbrand.t.c.a.b.cCG()) && (((com.tencent.mm.plugin.appbrand.t.c.a.a)localObject1).bb(tpM)))
          {
            localObject1 = new String(((com.tencent.mm.plugin.appbrand.t.c.a.a)localObject2).data, ((com.tencent.mm.plugin.appbrand.t.c.a.a)localObject2).dIY, ((com.tencent.mm.plugin.appbrand.t.c.a.a)localObject2).size, kotlin.n.d.UTF_8);
            Log.i("MicroMsg.Verify.AuthorityInfoAccess", s.X("parseAIA, caIssuersUri: ", localObject1));
            localArrayList.add(localObject1);
          }
        }
        paramX509Certificate = new a((List)localArrayList);
      }
      catch (Exception paramX509Certificate)
      {
        Log.w("MicroMsg.Verify.AuthorityInfoAccess", s.X("parseAIA, parse fail since ", paramX509Certificate));
        AppMethodBeat.o(319200);
        return null;
      }
    }
    catch (Exception paramX509Certificate)
    {
      try
      {
        paramX509Certificate = paramX509Certificate.cCH();
        if (!paramX509Certificate.cCI()) {
          break label122;
        }
        Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, seqParser data is exhausted");
        AppMethodBeat.o(319200);
        return null;
      }
      catch (Exception paramX509Certificate)
      {
        Log.w("MicroMsg.Verify.AuthorityInfoAccess", s.X("parseAIA, readSequence fail since ", paramX509Certificate));
        AppMethodBeat.o(319200);
        return null;
      }
      paramX509Certificate = paramX509Certificate;
      Log.w("MicroMsg.Verify.AuthorityInfoAccess", s.X("parseAIA, readTag(OCTET_STRING) fail since ", paramX509Certificate));
      AppMethodBeat.o(319200);
      return null;
    }
    label122:
    AppMethodBeat.o(319200);
    return paramX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.d.b
 * JD-Core Version:    0.7.0.1
 */