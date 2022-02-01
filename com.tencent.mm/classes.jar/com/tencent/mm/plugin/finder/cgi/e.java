package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import d.g.a.s;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "Companion", "plugin-finder_release"})
public final class e
  extends r<aku>
{
  public static final a qWS;
  private final int diw;
  private final b lastBuffer;
  private final int pullType;
  private final s<Integer, Integer, String, aku, com.tencent.mm.ak.n, y> qWP;
  private final l.c qWQ;
  private final boolean qWR;
  
  static
  {
    AppMethodBeat.i(165165);
    qWS = new a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public e(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super aku, ? super com.tencent.mm.ak.n, y> params, b paramb, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201104);
    this.pullType = paramInt1;
    this.diw = paramInt2;
    this.qWP = params;
    this.qWQ = null;
    this.lastBuffer = paramb;
    this.qWR = false;
    params = new b.a();
    paramb = new akt();
    paramb.EEI = u.axE();
    paramb.diw = this.diw;
    Object localObject;
    if (this.qWR)
    {
      localObject = g.agR();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agA();
      com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      localObject = ((ae)localObject).get(com.tencent.mm.plugin.finder.utils.n.EI(this.diw), "");
      if (localObject == null)
      {
        params = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201104);
        throw params;
      }
    }
    for (paramb.EEJ = b.cc(bs.aLu((String)localObject));; paramb.EEJ = this.lastBuffer)
    {
      ac.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.diw + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.qWR);
      localObject = q.qXH;
      paramb.EDL = q.a(paramanm);
      params.c((a)paramb);
      paramb = new aku();
      paramb.setBaseResponse(new BaseResponse());
      paramb.getBaseResponse().ErrMsg = new crm();
      params.d((a)paramb);
      params.Am("/cgi-bin/micromsg-bin/findergethistory");
      params.op(3814);
      c(params.aAz());
      AppMethodBeat.o(201104);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */