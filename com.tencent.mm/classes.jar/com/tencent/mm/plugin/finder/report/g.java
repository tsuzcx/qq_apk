package com.tencent.mm.plugin.finder.report;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ase;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderRedDotReporter;", "", "()V", "INNER_VERSION", "", "report20411", "", "currUI", "", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "autoClick", "currentTabType", "contextId", "plugin-finder_release"})
public final class g
{
  public static final g soH;
  
  static
  {
    AppMethodBeat.i(203252);
    soH = new g();
    AppMethodBeat.o(203252);
  }
  
  public static void a(String paramString, i parami, ase paramase, int paramInt1, aqy paramaqy, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203250);
    p.h(paramString, "currUI");
    p.h(parami, "ctrInfo");
    p.h(paramase, "showInfo");
    bp localbp = new bp();
    localbp.ge(parami.field_ctrInfo.type);
    localbp.kq(parami.field_tipsId);
    localbp.kr(paramase.path);
    localbp.ks(paramase.xfl);
    localbp.gf(paramase.uda);
    localbp.gg(paramase.count);
    localbp.kt(paramase.title);
    Object localObject = paramase.Gqt;
    if (localObject != null)
    {
      localObject = Base64.encodeToString(((com.tencent.mm.bx.b)localObject).getBytes(), 2);
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      localbp.ku((String)localObject);
      localbp.gh(paramInt1);
      localbp.kv(paramString);
      label191:
      long l;
      if (paramaqy != null)
      {
        paramString = paramaqy.qXu;
        localbp.kw(paramString);
        if (paramaqy == null) {
          break label375;
        }
        paramString = paramaqy.qXj;
        localbp.kx(paramString);
        paramString = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() != 1) {
          break label380;
        }
        l = 1L;
        label221:
        localbp.gi(l);
        paramString = com.tencent.mm.kernel.g.ad(t.class);
        p.g(paramString, "MMKernel.plugin(IPluginFinder::class.java)");
        paramString = ((t)paramString).getRedDotManager();
        p.g(paramString, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        if (!paramString.czR()) {
          break label386;
        }
        l = 1L;
        label269:
        localbp.gj(l);
        if (paramInt2 != 0) {
          break label392;
        }
        l = 1L;
        label285:
        localbp.gk(l);
        localbp.Su();
        if (paramaqy == null) {
          break label398;
        }
      }
      label386:
      label392:
      label398:
      for (paramString = paramaqy.sessionId;; paramString = null)
      {
        localbp.ky(paramString);
        localbp.gl(parami.field_time);
        localbp.kz(paramase.pkr);
        localbp.gm(paramInt3);
        localbp.aLk();
        paramString = h.soM;
        h.a((a)localbp);
        AppMethodBeat.o(203250);
        return;
        paramString = null;
        break;
        label375:
        paramString = null;
        break label191;
        label380:
        l = 0L;
        break label221;
        l = 0L;
        break label269;
        l = 0L;
        break label285;
      }
    }
  }
  
  public static void a(String paramString1, i parami, ase paramase, int paramInt, String paramString2)
  {
    AppMethodBeat.i(203248);
    p.h(paramString1, "currUI");
    p.h(parami, "ctrInfo");
    p.h(paramase, "showInfo");
    p.h(paramString2, "contextId");
    aqy localaqy = new aqy();
    localaqy.qXu = paramString2;
    localaqy.qXj = "";
    b(paramString1, parami, paramase, paramInt, localaqy, 0, 96);
    AppMethodBeat.o(203248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g
 * JD-Core Version:    0.7.0.1
 */