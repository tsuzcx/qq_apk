package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderConsumePrefetchReportResponse;", "tabType", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "getTabType", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.ak.a<amh>
{
  public static final a rPR;
  private final int dvm;
  private final b rPQ;
  
  static
  {
    AppMethodBeat.i(201440);
    rPR = new a((byte)0);
    AppMethodBeat.o(201440);
  }
  
  public c(int paramInt, b paramb)
  {
    AppMethodBeat.i(201439);
    this.dvm = paramInt;
    this.rPQ = paramb;
    paramb = new b.a();
    Object localObject = new amg();
    ((amg)localObject).GEB = this.dvm;
    ((amg)localObject).GEC = this.rPQ;
    paramb.c((com.tencent.mm.bw.a)localObject);
    localObject = new amh();
    ((amh)localObject).setBaseResponse(new BaseResponse());
    ((amh)localObject).getBaseResponse().ErrMsg = new cxn();
    paramb.d((com.tencent.mm.bw.a)localObject);
    paramb.DN("/cgi-bin/micromsg-bin/finderconsumeprefetchreport");
    paramb.oS(3839);
    c(paramb.aDS());
    localObject = new StringBuilder("[init] tabType=").append(this.dvm).append(" lastBuff=");
    paramb = this.rPQ;
    if (paramb != null) {}
    for (paramb = Integer.valueOf(paramb.size());; paramb = null)
    {
      ae.i("Cgi.FinderConsumePrefetchReport", paramb);
      AppMethodBeat.o(201439);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */