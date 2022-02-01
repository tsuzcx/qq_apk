package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.i;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.j;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.k;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.l;
import com.tencent.mm.protocal.protobuf.flc;
import com.tencent.mm.protocal.protobuf.gmp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static void a(List<flc> paramList, boolean paramBoolean, int paramInt)
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
      flc localflc = (flc)paramList.next();
      if (localflc.abLE == null)
      {
        Log.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localflc.aaLU, localflc.abyJ });
      }
      else
      {
        String str1 = localflc.aaLU;
        String str2 = localflc.abyJ;
        boolean bool1;
        label110:
        boolean bool2;
        label124:
        boolean bool3;
        label138:
        boolean bool4;
        label152:
        boolean bool5;
        label166:
        boolean bool6;
        label180:
        boolean bool7;
        label194:
        boolean bool8;
        label208:
        boolean bool9;
        label222:
        boolean bool10;
        if (localflc.abLE.achO != null)
        {
          bool1 = true;
          if (localflc.abLE.achP == null) {
            break label859;
          }
          bool2 = true;
          if (localflc.abLE.achQ == null) {
            break label865;
          }
          bool3 = true;
          if (localflc.abLE.achR == null) {
            break label871;
          }
          bool4 = true;
          if (localflc.abLE.achS == null) {
            break label877;
          }
          bool5 = true;
          if (localflc.abLE.achT == null) {
            break label883;
          }
          bool6 = true;
          if (localflc.abLE.achU == null) {
            break label889;
          }
          bool7 = true;
          if (localflc.abLE.achV == null) {
            break label895;
          }
          bool8 = true;
          if (localflc.abLE.achW == null) {
            break label901;
          }
          bool9 = true;
          if (localflc.abLE.achX == null) {
            break label907;
          }
          bool10 = true;
          label236:
          if (localflc.abLE.achY == null) {
            break label913;
          }
        }
        label901:
        label907:
        label913:
        for (boolean bool11 = true;; bool11 = false)
        {
          Log.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b), BlockCgiRequest(%b), PreLaunch(%b), InvalidCode(%b), InvalidContact(%b), PullGlobalConf(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool7), Boolean.valueOf(bool8), Boolean.valueOf(bool9), Boolean.valueOf(bool10), Boolean.valueOf(bool11) });
          if (localflc.abLE.achO != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achO).j(new d());
          }
          if (localflc.abLE.achP != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achP).j(new c(paramBoolean, paramInt)).g(new a() {});
          }
          if (localflc.abLE.achQ != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achQ).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.g());
          }
          if (localflc.abLE.achR != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achR).j(new i());
          }
          if (localflc.abLE.achS != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achS).j(new h());
          }
          if (localflc.abLE.achT != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achT).j(new l());
          }
          if (localflc.abLE.achU != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achU).j(new b());
          }
          if (localflc.abLE.achV != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achV).j(new j());
          }
          if (localflc.abLE.achW != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achW).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.e());
          }
          if (localflc.abLE.achX != null) {
            com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achX).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.b.f());
          }
          if (localflc.abLE.achY == null) {
            break;
          }
          com.tencent.mm.cp.g.h(localflc.aaLU, localflc.abyJ, localflc.abLE.achY).j(new k());
          break;
          bool1 = false;
          break label110;
          label859:
          bool2 = false;
          break label124;
          label865:
          bool3 = false;
          break label138;
          label871:
          bool4 = false;
          break label152;
          label877:
          bool5 = false;
          break label166;
          label883:
          bool6 = false;
          break label180;
          label889:
          bool7 = false;
          break label194;
          label895:
          bool8 = false;
          break label208;
          bool9 = false;
          break label222;
          bool10 = false;
          break label236;
        }
      }
    }
    AppMethodBeat.o(44374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e
 * JD-Core Version:    0.7.0.1
 */