package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static void a(List<dmj> paramList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(44374);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(44374);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dmj localdmj = (dmj)paramList.next();
      if (localdmj.HTK == null)
      {
        ae.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localdmj.Hhh, localdmj.FNs });
      }
      else
      {
        String str1 = localdmj.Hhh;
        String str2 = localdmj.FNs;
        boolean bool1;
        label110:
        boolean bool2;
        label124:
        boolean bool3;
        label138:
        boolean bool4;
        label152:
        boolean bool5;
        if (localdmj.HTK.ImQ != null)
        {
          bool1 = true;
          if (localdmj.HTK.ImR == null) {
            break label615;
          }
          bool2 = true;
          if (localdmj.HTK.ImS == null) {
            break label621;
          }
          bool3 = true;
          if (localdmj.HTK.ImT == null) {
            break label627;
          }
          bool4 = true;
          if (localdmj.HTK.ImU == null) {
            break label633;
          }
          bool5 = true;
          label166:
          if (localdmj.HTK.ImV == null) {
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
          ae.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
          if (localdmj.HTK.ImQ != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImQ).j(new d());
          }
          if (localdmj.HTK.ImR != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImR).j(new c(paramBoolean, paramInt)).g(new a() {});
          }
          if (localdmj.HTK.ImS != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImS).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.e());
          }
          if (localdmj.HTK.ImT != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImT).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
          }
          if (localdmj.HTK.ImU != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImU).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.f());
          }
          if (localdmj.HTK.ImV != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImV).j(new i());
          }
          if (localdmj.HTK.ImW != null) {
            com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImW).j(new b());
          }
          if (localdmj.HTK.ImX == null) {
            break;
          }
          com.tencent.mm.cm.g.j(localdmj.Hhh, localdmj.FNs, localdmj.HTK.ImX).j(new h());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e
 * JD-Core Version:    0.7.0.1
 */