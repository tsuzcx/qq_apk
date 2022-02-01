package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderConsumePrefetchReportResponse;", "tabType", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "getTabType", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.am.b<avh>
{
  public static final a AyA;
  private final com.tencent.mm.bx.b AyB;
  private final int hJx;
  
  static
  {
    AppMethodBeat.i(336359);
    AyA = new a((byte)0);
    AppMethodBeat.o(336359);
  }
  
  public h(int paramInt, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(336354);
    this.hJx = paramInt;
    this.AyB = paramb;
    paramb = new c.a();
    Object localObject = new avg();
    bi localbi = bi.ABn;
    ((avg)localObject).YIY = bi.dVu();
    ((avg)localObject).tab_type = this.hJx;
    ((avg)localObject).ZFz = this.AyB;
    paramb.otE = ((a)localObject);
    localObject = new avh();
    ((avh)localObject).setBaseResponse(new kd());
    ((avh)localObject).getBaseResponse().akjO = new etl();
    paramb.otF = ((a)localObject);
    paramb.uri = "/cgi-bin/micromsg-bin/finderconsumeprefetchreport";
    paramb.funcId = 3839;
    c(paramb.bEF());
    localObject = new StringBuilder("[init] tabType=").append(this.hJx).append(" lastBuff=");
    paramb = this.AyB;
    if (paramb == null) {}
    for (paramb = null;; paramb = Integer.valueOf(paramb.Op.length))
    {
      Log.i("Cgi.FinderConsumePrefetchReport", paramb);
      AppMethodBeat.o(336354);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */