package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class d
{
  static void az(List<cjc> paramList)
  {
    AppMethodBeat.i(129446);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(129446);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cjc localcjc = (cjc)paramList.next();
      if (localcjc.xTo == null)
      {
        ab.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localcjc.xTl, localcjc.woB });
      }
      else
      {
        String str1 = localcjc.xTl;
        String str2 = localcjc.woB;
        boolean bool1;
        label110:
        boolean bool2;
        label123:
        boolean bool3;
        label136:
        boolean bool4;
        label150:
        boolean bool5;
        if (localcjc.xTo.yhE != null)
        {
          bool1 = true;
          if (localcjc.xTo.yhF == null) {
            break label566;
          }
          bool2 = true;
          if (localcjc.xTo.yhG == null) {
            break label571;
          }
          bool3 = true;
          if (localcjc.xTo.yhH == null) {
            break label576;
          }
          bool4 = true;
          if (localcjc.xTo.yhI == null) {
            break label582;
          }
          bool5 = true;
          label164:
          if (localcjc.xTo.yhJ == null) {
            break label588;
          }
        }
        label566:
        label571:
        label576:
        label582:
        label588:
        for (boolean bool6 = true;; bool6 = false)
        {
          ab.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
          if (localcjc.xTo.yhE != null) {
            com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhE).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.d());
          }
          if (localcjc.xTo.yhF != null) {
            com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhF).j(new c()).g(new d.1());
          }
          if (localcjc.xTo.yhG != null) {
            com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhG).j(new e());
          }
          if (localcjc.xTo.yhH != null) {
            com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhH).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
          }
          if (localcjc.xTo.yhI != null) {
            com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhI).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.f());
          }
          if (localcjc.xTo.yhJ != null) {
            com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhJ).j(new h());
          }
          if (localcjc.xTo.yhK == null) {
            break;
          }
          com.tencent.mm.cm.g.j(localcjc.xTl, localcjc.woB, localcjc.xTo.yhK).j(new b());
          break;
          bool1 = false;
          break label110;
          bool2 = false;
          break label123;
          bool3 = false;
          break label136;
          bool4 = false;
          break label150;
          bool5 = false;
          break label164;
        }
      }
    }
    AppMethodBeat.o(129446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d
 * JD-Core Version:    0.7.0.1
 */