package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.i;
import com.tencent.mm.protocal.protobuf.efx;
import com.tencent.mm.protocal.protobuf.feo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static void a(List<efx> paramList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(44374);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(44374);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      efx localefx = (efx)paramList.next();
      if (localefx.NfS == null)
      {
        Log.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localefx.Mmv, localefx.KGX });
      }
      else
      {
        String str1 = localefx.Mmv;
        String str2 = localefx.KGX;
        boolean bool1;
        label110:
        boolean bool2;
        label124:
        boolean bool3;
        label138:
        boolean bool4;
        label152:
        boolean bool5;
        if (localefx.NfS.NzS != null)
        {
          bool1 = true;
          if (localefx.NfS.NzT == null) {
            break label615;
          }
          bool2 = true;
          if (localefx.NfS.NzU == null) {
            break label621;
          }
          bool3 = true;
          if (localefx.NfS.NzV == null) {
            break label627;
          }
          bool4 = true;
          if (localefx.NfS.NzW == null) {
            break label633;
          }
          bool5 = true;
          label166:
          if (localefx.NfS.NzX == null) {
            break label639;
          }
        }
        label615:
        label621:
        label627:
        label633:
        label639:
        for (boolean bool6 = true;; bool6 = false)
        {
          Log.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
          if (localefx.NfS.NzS != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzS).j(new d());
          }
          if (localefx.NfS.NzT != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzT).j(new c(paramBoolean, paramInt)).g(new a() {});
          }
          if (localefx.NfS.NzU != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzU).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.e());
          }
          if (localefx.NfS.NzV != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzV).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.g());
          }
          if (localefx.NfS.NzW != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzW).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.f());
          }
          if (localefx.NfS.NzX != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzX).j(new i());
          }
          if (localefx.NfS.NzY != null) {
            com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzY).j(new b());
          }
          if (localefx.NfS.NzZ == null) {
            break;
          }
          com.tencent.mm.co.g.j(localefx.Mmv, localefx.KGX, localefx.NfS.NzZ).j(new h());
          break;
          bool1 = false;
          break label110;
          bool2 = false;
          break label124;
          bool3 = false;
          break label138;
          bool4 = false;
          break label152;
          bool5 = false;
          break label166;
        }
      }
    }
    AppMethodBeat.o(44374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e
 * JD-Core Version:    0.7.0.1
 */