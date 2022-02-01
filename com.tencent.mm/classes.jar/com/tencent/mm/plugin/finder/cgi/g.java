package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderConsumePrefetchReportResponse;", "tabType", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "getTabType", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class g
  extends c<apm>
{
  public static final a tsP;
  private final int dLS;
  private final b tsO;
  
  static
  {
    AppMethodBeat.i(242211);
    tsP = new a((byte)0);
    AppMethodBeat.o(242211);
  }
  
  public g(int paramInt, b paramb)
  {
    AppMethodBeat.i(242210);
    this.dLS = paramInt;
    this.tsO = paramb;
    paramb = new d.a();
    Object localObject = new apl();
    ((apl)localObject).tab_type = this.dLS;
    ((apl)localObject).LBu = this.tsO;
    paramb.c((a)localObject);
    localObject = new apm();
    ((apm)localObject).setBaseResponse(new BaseResponse());
    ((apm)localObject).getBaseResponse().ErrMsg = new dqi();
    paramb.d((a)localObject);
    paramb.MB("/cgi-bin/micromsg-bin/finderconsumeprefetchreport");
    paramb.sG(3839);
    c(paramb.aXF());
    localObject = new StringBuilder("[init] tabType=").append(this.dLS).append(" lastBuff=");
    paramb = this.tsO;
    if (paramb != null) {}
    for (paramb = Integer.valueOf(paramb.zy.length);; paramb = null)
    {
      Log.i("Cgi.FinderConsumePrefetchReport", paramb);
      AppMethodBeat.o(242210);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */