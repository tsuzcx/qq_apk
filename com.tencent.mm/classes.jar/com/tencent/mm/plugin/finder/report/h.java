package com.tencent.mm.plugin.finder.report;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ast;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderRedDotReporter;", "", "()V", "INNER_VERSION", "", "report20411", "", "currUI", "", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "autoClick", "currentTabType", "contextId", "plugin-finder_release"})
public final class h
{
  public static final h syO;
  
  static
  {
    AppMethodBeat.i(203806);
    syO = new h();
    AppMethodBeat.o(203806);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.extension.reddot.i parami, ast paramast, int paramInt1, arn paramarn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203804);
    p.h(paramString, "currUI");
    p.h(parami, "ctrInfo");
    p.h(paramast, "showInfo");
    bp localbp = new bp();
    localbp.gh(parami.field_ctrInfo.type);
    localbp.kD(parami.field_tipsId);
    localbp.kE(paramast.path);
    localbp.kF(paramast.xvd);
    localbp.gi(paramast.uoi);
    localbp.gj(paramast.count);
    localbp.kG(paramast.title);
    Object localObject = paramast.GJO;
    if (localObject != null)
    {
      p.g(localObject, "it");
      localObject = Base64.encodeToString(((com.tencent.mm.bw.b)localObject).getBytes(), 2);
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      localbp.kH((String)localObject);
      localbp.gk(paramInt1);
      localbp.kI(paramString);
      label198:
      long l;
      if (paramarn != null)
      {
        paramString = paramarn.rfA;
        localbp.kJ(paramString);
        if (paramarn == null) {
          break label382;
        }
        paramString = paramarn.rfo;
        localbp.kK(paramString);
        paramString = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() != 1) {
          break label387;
        }
        l = 1L;
        label228:
        localbp.gl(l);
        paramString = g.ad(t.class);
        p.g(paramString, "MMKernel.plugin(IPluginFinder::class.java)");
        paramString = ((t)paramString).getRedDotManager();
        p.g(paramString, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        if (!paramString.cBv()) {
          break label393;
        }
        l = 1L;
        label276:
        localbp.gm(l);
        if (paramInt2 != 0) {
          break label399;
        }
        l = 1L;
        label292:
        localbp.gn(l);
        localbp.Ss();
        if (paramarn == null) {
          break label405;
        }
      }
      label387:
      label393:
      label399:
      label405:
      for (paramString = paramarn.sessionId;; paramString = null)
      {
        localbp.kL(paramString);
        localbp.go(parami.field_time);
        localbp.kM(paramast.pqW);
        localbp.gp(paramInt3);
        localbp.aLH();
        paramString = i.syT;
        i.a((a)localbp);
        AppMethodBeat.o(203804);
        return;
        paramString = null;
        break;
        label382:
        paramString = null;
        break label198;
        l = 0L;
        break label228;
        l = 0L;
        break label276;
        l = 0L;
        break label292;
      }
    }
  }
  
  public static void a(String paramString1, com.tencent.mm.plugin.finder.extension.reddot.i parami, ast paramast, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(203802);
    p.h(paramString1, "currUI");
    p.h(parami, "ctrInfo");
    p.h(paramast, "showInfo");
    p.h(paramString2, "contextId");
    arn localarn = new arn();
    localarn.rfA = paramString2;
    localarn.rfo = "";
    a(paramString1, parami, paramast, paramInt1, localarn, paramInt2, 0, 64);
    AppMethodBeat.o(203802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.h
 * JD-Core Version:    0.7.0.1
 */