package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.s;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "Companion", "plugin-finder_release"})
public final class p
  extends c<aul>
{
  public static final a xaW;
  private final int fEH;
  private final b lastBuffer;
  private final int pullType;
  private final s<Integer, Integer, String, aul, q, x> xaT;
  private final ab.c xaU;
  private final boolean xaV;
  
  static
  {
    AppMethodBeat.i(165165);
    xaW = new a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public p(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super aul, ? super q, x> params, ab.c paramc, b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(282376);
    this.pullType = paramInt1;
    this.fEH = paramInt2;
    this.xaT = params;
    this.xaU = null;
    this.lastBuffer = paramb;
    this.xaV = false;
    params = new d.a();
    paramc = new auk();
    paramc.RLN = z.bdh();
    paramc.fEH = this.fEH;
    if (this.xaV)
    {
      paramb = h.aHG();
      kotlin.g.b.p.j(paramb, "MMKernel.storage()");
      paramb = paramb.aHp();
      aj localaj = aj.AGc;
      paramb = paramb.get(aj.QX(this.fEH), "");
      if (paramb == null)
      {
        params = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(282376);
        throw params;
      }
    }
    for (paramc.SDI = b.cU(Util.decodeHexString((String)paramb));; paramc.SDI = this.lastBuffer)
    {
      Log.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.fEH + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.xaV);
      paramb = ao.xcj;
      paramc.yjp = ao.a(parambid);
      params.c((a)paramc);
      paramc = new aul();
      paramc.setBaseResponse(new jh());
      paramc.getBaseResponse().Tef = new eaf();
      params.d((a)paramc);
      params.TW("/cgi-bin/micromsg-bin/findergethistory");
      params.vD(3814);
      c(params.bgN());
      AppMethodBeat.o(282376);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.p
 * JD-Core Version:    0.7.0.1
 */