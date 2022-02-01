package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.i;
import com.tencent.mm.protocal.protobuf.epz;
import com.tencent.mm.protocal.protobuf.fpp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static void a(List<epz> paramList, boolean paramBoolean, int paramInt)
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
      epz localepz = (epz)paramList.next();
      if (localepz.Usx == null)
      {
        Log.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localepz.Txp, localepz.Uhg });
      }
      else
      {
        String str1 = localepz.Txp;
        String str2 = localepz.Uhg;
        boolean bool1;
        label110:
        boolean bool2;
        label124:
        boolean bool3;
        label138:
        boolean bool4;
        label152:
        boolean bool5;
        if (localepz.Usx.UNu != null)
        {
          bool1 = true;
          if (localepz.Usx.UNv == null) {
            break label615;
          }
          bool2 = true;
          if (localepz.Usx.UNw == null) {
            break label621;
          }
          bool3 = true;
          if (localepz.Usx.UNx == null) {
            break label627;
          }
          bool4 = true;
          if (localepz.Usx.UNy == null) {
            break label633;
          }
          bool5 = true;
          label166:
          if (localepz.Usx.UNz == null) {
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
          if (localepz.Usx.UNu != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNu).j(new d());
          }
          if (localepz.Usx.UNv != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNv).j(new c(paramBoolean, paramInt)).g(new a() {});
          }
          if (localepz.Usx.UNw != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNw).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.e());
          }
          if (localepz.Usx.UNx != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNx).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.g());
          }
          if (localepz.Usx.UNy != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNy).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.f());
          }
          if (localepz.Usx.UNz != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNz).j(new i());
          }
          if (localepz.Usx.UNA != null) {
            com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNA).j(new b());
          }
          if (localepz.Usx.UNB == null) {
            break;
          }
          com.tencent.mm.cw.g.i(localepz.Txp, localepz.Uhg, localepz.Usx.UNB).j(new h());
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e
 * JD-Core Version:    0.7.0.1
 */