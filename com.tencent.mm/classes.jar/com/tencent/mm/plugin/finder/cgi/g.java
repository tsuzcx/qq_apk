package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import d.g.a.s;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "Companion", "plugin-finder_release"})
public final class g
  extends w<aoi>
{
  public static final a rQe;
  private final int dvm;
  private final b lastBuffer;
  private final int pullType;
  private final s<Integer, Integer, String, aoi, n, z> rQb;
  private final n.c rQc;
  private final boolean rQd;
  
  static
  {
    AppMethodBeat.i(165165);
    rQe = new a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public g(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super aoi, ? super n, z> params, b paramb, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201447);
    this.pullType = paramInt1;
    this.dvm = paramInt2;
    this.rQb = params;
    this.rQc = null;
    this.lastBuffer = paramb;
    this.rQd = false;
    params = new b.a();
    paramb = new aoh();
    paramb.GDP = com.tencent.mm.model.v.aAK();
    paramb.dvm = this.dvm;
    Object localObject;
    if (this.rQd)
    {
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).ajA();
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject = ((aj)localObject).get(com.tencent.mm.plugin.finder.utils.p.Gr(this.dvm), "");
      if (localObject == null)
      {
        params = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201447);
        throw params;
      }
    }
    for (paramb.GFN = b.cm(bu.aSx((String)localObject));; paramb.GFN = this.lastBuffer)
    {
      ae.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.dvm + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.rQd);
      localObject = v.rRb;
      paramb.GDR = v.a(paramarn);
      params.c((a)paramb);
      paramb = new aoi();
      paramb.setBaseResponse(new BaseResponse());
      paramb.getBaseResponse().ErrMsg = new cxn();
      params.d((a)paramb);
      params.DN("/cgi-bin/micromsg-bin/findergethistory");
      params.oS(3814);
      c(params.aDS());
      AppMethodBeat.o(201447);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */