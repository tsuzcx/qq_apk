package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.List;

public final class e
{
  static void a(List<dfz> paramList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(44374);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(44374);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dfz localdfz = (dfz)paramList.next();
      if (localdfz.FPm == null)
      {
        ac.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[] { localdfz.Fed, localdfz.DPF });
      }
      else
      {
        String str1 = localdfz.Fed;
        String str2 = localdfz.DPF;
        boolean bool1;
        label110:
        boolean bool2;
        label124:
        boolean bool3;
        label138:
        boolean bool4;
        label152:
        boolean bool5;
        if (localdfz.FPm.Ghv != null)
        {
          bool1 = true;
          if (localdfz.FPm.Ghw == null) {
            break label615;
          }
          bool2 = true;
          if (localdfz.FPm.Ghx == null) {
            break label621;
          }
          bool3 = true;
          if (localdfz.FPm.Ghy == null) {
            break label627;
          }
          bool4 = true;
          if (localdfz.FPm.Ghz == null) {
            break label633;
          }
          bool5 = true;
          label166:
          if (localdfz.FPm.GhA == null) {
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
          ac.i("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)", new Object[] { str1, str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
          if (localdfz.FPm.Ghv != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.Ghv).j(new d());
          }
          if (localdfz.FPm.Ghw != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.Ghw).j(new c(paramBoolean, paramInt)).g(new a() {});
          }
          if (localdfz.FPm.Ghx != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.Ghx).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.e());
          }
          if (localdfz.FPm.Ghy != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.Ghy).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
          }
          if (localdfz.FPm.Ghz != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.Ghz).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.f());
          }
          if (localdfz.FPm.GhA != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.GhA).j(new i());
          }
          if (localdfz.FPm.GhB != null) {
            com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.GhB).j(new b());
          }
          if (localdfz.FPm.GhC == null) {
            break;
          }
          com.tencent.mm.cn.g.j(localdfz.Fed, localdfz.DPF, localdfz.FPm.GhC).j(new h());
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