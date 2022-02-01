package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static void a(List<dan> paramList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(44374);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(44374);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dan localdan = (dan)paramList.next();
      if (localdan.Esk == null)
      {
        ad.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localdan.DII, localdan.Cxj });
      }
      else
      {
        String str1 = localdan.DII;
        String str2 = localdan.Cxj;
        boolean bool1;
        label110:
        boolean bool2;
        label124:
        boolean bool3;
        label138:
        boolean bool4;
        label152:
        boolean bool5;
        if (localdan.Esk.EKj != null)
        {
          bool1 = true;
          if (localdan.Esk.EKk == null) {
            break label615;
          }
          bool2 = true;
          if (localdan.Esk.EKl == null) {
            break label621;
          }
          bool3 = true;
          if (localdan.Esk.EKm == null) {
            break label627;
          }
          bool4 = true;
          if (localdan.Esk.EKn == null) {
            break label633;
          }
          bool5 = true;
          label166:
          if (localdan.Esk.EKo == null) {
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
          ad.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
          if (localdan.Esk.EKj != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKj).j(new d());
          }
          if (localdan.Esk.EKk != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKk).j(new c(paramBoolean, paramInt)).g(new a() {});
          }
          if (localdan.Esk.EKl != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKl).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.e());
          }
          if (localdan.Esk.EKm != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKm).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
          }
          if (localdan.Esk.EKn != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKn).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.f());
          }
          if (localdan.Esk.EKo != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKo).j(new i());
          }
          if (localdan.Esk.EKp != null) {
            com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKp).j(new b());
          }
          if (localdan.Esk.EKq == null) {
            break;
          }
          com.tencent.mm.co.g.j(localdan.DII, localdan.Cxj, localdan.Esk.EKq).j(new h());
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e
 * JD-Core Version:    0.7.0.1
 */