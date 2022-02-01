package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderConsumePrefetchReportResponse;", "tabType", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "getTabType", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.al.a<alv>
{
  public static final a rHG;
  private final int duh;
  private final b rHF;
  
  static
  {
    AppMethodBeat.i(201018);
    rHG = new a((byte)0);
    AppMethodBeat.o(201018);
  }
  
  public c(int paramInt, b paramb)
  {
    AppMethodBeat.i(201017);
    this.duh = paramInt;
    this.rHF = paramb;
    paramb = new b.a();
    Object localObject = new alu();
    ((alu)localObject).Glz = this.duh;
    ((alu)localObject).GlA = this.rHF;
    paramb.c((com.tencent.mm.bx.a)localObject);
    localObject = new alv();
    ((alv)localObject).setBaseResponse(new BaseResponse());
    ((alv)localObject).getBaseResponse().ErrMsg = new cwt();
    paramb.d((com.tencent.mm.bx.a)localObject);
    paramb.Dl("/cgi-bin/micromsg-bin/finderconsumeprefetchreport");
    paramb.oP(3839);
    c(paramb.aDC());
    ad.i("Cgi.FinderConsumePrefetchReport", "[init] tabType=" + this.duh + " lastBuff=" + this.rHF.size());
    AppMethodBeat.o(201017);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */