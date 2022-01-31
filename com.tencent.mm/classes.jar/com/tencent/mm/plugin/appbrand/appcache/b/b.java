package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.protocal.c.bwt;
import com.tencent.mm.protocal.c.cna;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class b
{
  static void aq(List<bwt> paramList)
  {
    if (bk.dk(paramList)) {
      return;
    }
    paramList = paramList.iterator();
    label15:
    bwt localbwt;
    String str1;
    String str2;
    boolean bool1;
    label100:
    boolean bool2;
    label113:
    boolean bool3;
    label126:
    boolean bool4;
    label140:
    boolean bool5;
    while (paramList.hasNext())
    {
      localbwt = (bwt)paramList.next();
      if (localbwt.tNb == null)
      {
        y.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localbwt.tMY, localbwt.svu });
      }
      else
      {
        str1 = localbwt.tMY;
        str2 = localbwt.svu;
        if (localbwt.tNb.tZL == null) {
          break label551;
        }
        bool1 = true;
        if (localbwt.tNb.tZM == null) {
          break label556;
        }
        bool2 = true;
        if (localbwt.tNb.tZN == null) {
          break label561;
        }
        bool3 = true;
        if (localbwt.tNb.tZO == null) {
          break label566;
        }
        bool4 = true;
        if (localbwt.tNb.tZP == null) {
          break label572;
        }
        bool5 = true;
        label154:
        if (localbwt.tNb.tZQ == null) {
          break label578;
        }
      }
    }
    label551:
    label556:
    label561:
    label566:
    label572:
    label578:
    for (boolean bool6 = true;; bool6 = false)
    {
      y.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
      if (localbwt.tNb.tZL != null) {
        com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZL).j(new d());
      }
      if (localbwt.tNb.tZM != null) {
        com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZM).j(new c()).g(new b.1());
      }
      if (localbwt.tNb.tZN != null) {
        com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZN).j(new e());
      }
      if (localbwt.tNb.tZO != null) {
        com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZO).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
      }
      if (localbwt.tNb.tZP != null) {
        com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZP).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.f());
      }
      if (localbwt.tNb.tZQ != null) {
        com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZQ).j(new h());
      }
      if (localbwt.tNb.tZR == null) {
        break label15;
      }
      com.tencent.mm.ck.g.e(localbwt.tMY, localbwt.svu, localbwt.tNb.tZR).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.b());
      break label15;
      break;
      bool1 = false;
      break label100;
      bool2 = false;
      break label113;
      bool3 = false;
      break label126;
      bool4 = false;
      break label140;
      bool5 = false;
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b
 * JD-Core Version:    0.7.0.1
 */