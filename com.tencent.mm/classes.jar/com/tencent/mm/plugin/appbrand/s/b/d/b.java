package com.tencent.mm.plugin.appbrand.s.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"AD_CA_ISSUERS_OID", "", "AUTHORITY_INFO_ACCESS_OID_DOT_NOTATION", "", "TAG", "parseAIA", "Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/AuthorityInfoAccess;", "Ljava/security/cert/X509Certificate;", "luggage-commons_release"})
public final class b
{
  private static final byte[] qkP = { 43, 6, 1, 5, 5, 7, 48, 2 };
  
  public static final a a(X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(207543);
    p.k(paramX509Certificate, "$this$parseAIA");
    paramX509Certificate = paramX509Certificate.getExtensionValue("1.3.6.1.5.5.7.1.1");
    if (paramX509Certificate == null)
    {
      Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, aiaExtVal is null");
      AppMethodBeat.o(207543);
      return null;
    }
    try
    {
      paramX509Certificate = new com.tencent.mm.plugin.appbrand.s.b.a.d(paramX509Certificate).Cf(4);
      paramX509Certificate = new com.tencent.mm.plugin.appbrand.s.b.a.d(paramX509Certificate);
      try
      {
        ArrayList localArrayList = new ArrayList();
        while (!paramX509Certificate.ccm())
        {
          Object localObject2 = paramX509Certificate.ccl();
          Object localObject1 = ((com.tencent.mm.plugin.appbrand.s.b.a.d)localObject2).Cf(6);
          ((com.tencent.mm.plugin.appbrand.s.b.a.d)localObject2).checkThread();
          Object localObject3 = ((com.tencent.mm.plugin.appbrand.s.b.a.d)localObject2).ccn();
          com.tencent.mm.plugin.appbrand.s.b.a.d.a((com.tencent.mm.plugin.appbrand.s.b.a.d)localObject2);
          int i = ((Number)((o)localObject3).Mx).intValue();
          localObject2 = (com.tencent.mm.plugin.appbrand.s.b.a.a)((o)localObject3).My;
          localObject3 = com.tencent.mm.plugin.appbrand.s.b.a.b.qkq;
          if ((i == com.tencent.mm.plugin.appbrand.s.b.a.b.cck()) && (((com.tencent.mm.plugin.appbrand.s.b.a.a)localObject1).bb(qkP)))
          {
            localObject1 = new String(((com.tencent.mm.plugin.appbrand.s.b.a.a)localObject2).data, ((com.tencent.mm.plugin.appbrand.s.b.a.a)localObject2).bPt, ((com.tencent.mm.plugin.appbrand.s.b.a.a)localObject2).size, kotlin.n.d.UTF_8);
            Log.i("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, caIssuersUri: ".concat(String.valueOf(localObject1)));
            localArrayList.add(localObject1);
          }
        }
        paramX509Certificate = new a((List)localArrayList);
      }
      catch (Exception paramX509Certificate)
      {
        Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, parse fail since ".concat(String.valueOf(paramX509Certificate)));
        AppMethodBeat.o(207543);
        return null;
      }
    }
    catch (Exception paramX509Certificate)
    {
      try
      {
        paramX509Certificate = paramX509Certificate.ccl();
        if (!paramX509Certificate.ccm()) {
          break label128;
        }
        Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, seqParser data is exhausted");
        AppMethodBeat.o(207543);
        return null;
      }
      catch (Exception paramX509Certificate)
      {
        Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, readSequence fail since ".concat(String.valueOf(paramX509Certificate)));
        AppMethodBeat.o(207543);
        return null;
      }
      paramX509Certificate = paramX509Certificate;
      Log.w("MicroMsg.Verify.AuthorityInfoAccess", "parseAIA, readTag(OCTET_STRING) fail since ".concat(String.valueOf(paramX509Certificate)));
      AppMethodBeat.o(207543);
      return null;
    }
    label128:
    AppMethodBeat.o(207543);
    return paramX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.d.b
 * JD-Core Version:    0.7.0.1
 */