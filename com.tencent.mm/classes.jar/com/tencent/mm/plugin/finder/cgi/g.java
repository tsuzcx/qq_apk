package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import d.g.a.s;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "Companion", "plugin-finder_release"})
public final class g
  extends w<anv>
{
  public static final a rHT;
  private final int duh;
  private final b lastBuffer;
  private final int pullType;
  private final s<Integer, Integer, String, anv, n, z> rHQ;
  private final n.c rHR;
  private final boolean rHS;
  
  static
  {
    AppMethodBeat.i(165165);
    rHT = new a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public g(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super anv, ? super n, z> params, b paramb, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201025);
    this.pullType = paramInt1;
    this.duh = paramInt2;
    this.rHQ = params;
    this.rHR = null;
    this.lastBuffer = paramb;
    this.rHS = false;
    params = new b.a();
    paramb = new anu();
    paramb.Gmz = u.aAu();
    paramb.duh = this.duh;
    Object localObject;
    if (this.rHS)
    {
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).ajl();
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject = ((ai)localObject).get(com.tencent.mm.plugin.finder.utils.p.FS(this.duh), "");
      if (localObject == null)
      {
        params = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201025);
        throw params;
      }
    }
    for (paramb.GmG = b.cj(bt.aRa((String)localObject));; paramb.GmG = this.lastBuffer)
    {
      ad.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.duh + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.rHS);
      localObject = v.rIR;
      paramb.Glv = v.a(paramaqy);
      params.c((a)paramb);
      paramb = new anv();
      paramb.setBaseResponse(new BaseResponse());
      paramb.getBaseResponse().ErrMsg = new cwt();
      params.d((a)paramb);
      params.Dl("/cgi-bin/micromsg-bin/findergethistory");
      params.oP(3814);
      c(params.aDC());
      AppMethodBeat.o(201025);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */