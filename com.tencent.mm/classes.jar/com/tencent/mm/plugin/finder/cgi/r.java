package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends c<azd>
{
  public static final r.a Aze;
  private final s<Integer, Integer, String, azd, p, ah> Azf;
  private final ar.c Azg;
  private final boolean Azh;
  private final int hJx;
  private final b lastBuffer;
  private final int pullType;
  
  static
  {
    AppMethodBeat.i(165165);
    Aze = new r.a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public r(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super azd, ? super p, ah> params, ar.c paramc, b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336432);
    this.pullType = paramInt1;
    this.hJx = paramInt2;
    this.Azf = params;
    this.Azg = null;
    this.lastBuffer = paramb;
    this.Azh = false;
    params = new c.a();
    paramc = new azc();
    paramc.YIZ = z.bAW();
    paramc.hJx = this.hJx;
    if (this.Azh)
    {
      paramb = h.baE().ban();
      av localav = av.GiL;
      paramb = paramb.get(av.Uh(this.hJx), "");
      if (paramb == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(336432);
        throw params;
      }
    }
    for (paramc.ZEQ = b.cX(Util.decodeHexString((String)paramb));; paramc.ZEQ = this.lastBuffer)
    {
      Log.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.hJx + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.Azh);
      paramb = bi.ABn;
      paramc.CJv = bi.a(parambui);
      params.otE = ((a)paramc);
      paramc = new azd();
      paramc.setBaseResponse(new kd());
      paramc.getBaseResponse().akjO = new etl();
      params.otF = ((a)paramc);
      params.uri = "/cgi-bin/micromsg-bin/findergethistory";
      params.funcId = 3814;
      c(params.bEF());
      AppMethodBeat.o(336432);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */