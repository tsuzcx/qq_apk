package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "Companion", "plugin-finder_release"})
public final class m
  extends an<ask>
{
  public static final a ttf;
  private final int dLS;
  private final b lastBuffer;
  private final int pullType;
  private final s<Integer, Integer, String, ask, q, x> ttc;
  private final ab.c ttd;
  private final boolean tte;
  
  static
  {
    AppMethodBeat.i(165165);
    ttf = new a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public m(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super ask, ? super q, x> params, ab.c paramc, b paramb, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242226);
    this.pullType = paramInt1;
    this.dLS = paramInt2;
    this.ttc = params;
    this.ttd = null;
    this.lastBuffer = paramb;
    this.tte = false;
    params = new d.a();
    paramc = new asj();
    paramc.LAt = z.aUg();
    paramc.dLS = this.dLS;
    if (this.tte)
    {
      paramb = g.aAh();
      p.g(paramb, "MMKernel.storage()");
      paramb = paramb.azQ();
      y localy = y.vXH;
      paramb = paramb.get(y.LK(this.dLS), "");
      if (paramb == null)
      {
        params = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(242226);
        throw params;
      }
    }
    for (paramc.LDs = b.cD(Util.decodeHexString((String)paramb));; paramc.LDs = this.lastBuffer)
    {
      Log.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.dLS + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.tte);
      paramb = am.tuw;
      paramc.uli = am.a(parambbn);
      params.c((a)paramc);
      paramc = new ask();
      paramc.setBaseResponse(new BaseResponse());
      paramc.getBaseResponse().ErrMsg = new dqi();
      params.d((a)paramc);
      params.MB("/cgi-bin/micromsg-bin/findergethistory");
      params.sG(3814);
      c(params.aXF());
      AppMethodBeat.o(242226);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */