package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderConsumePrefetchReportResponse;", "tabType", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "getTabType", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class h
  extends c<ara>
{
  public static final a xax;
  private final int fEH;
  private final b xaw;
  
  static
  {
    AppMethodBeat.i(272880);
    xax = new a((byte)0);
    AppMethodBeat.o(272880);
  }
  
  public h(int paramInt, b paramb)
  {
    AppMethodBeat.i(272879);
    this.fEH = paramInt;
    this.xaw = paramb;
    paramb = new d.a();
    Object localObject = new aqz();
    ao localao = ao.xcj;
    ((aqz)localObject).RLM = ao.dnO();
    ((aqz)localObject).tab_type = this.fEH;
    ((aqz)localObject).SEd = this.xaw;
    paramb.c((a)localObject);
    localObject = new ara();
    ((ara)localObject).setBaseResponse(new jh());
    ((ara)localObject).getBaseResponse().Tef = new eaf();
    paramb.d((a)localObject);
    paramb.TW("/cgi-bin/micromsg-bin/finderconsumeprefetchreport");
    paramb.vD(3839);
    c(paramb.bgN());
    localObject = new StringBuilder("[init] tabType=").append(this.fEH).append(" lastBuff=");
    paramb = this.xaw;
    if (paramb != null) {}
    for (paramb = Integer.valueOf(paramb.UH.length);; paramb = null)
    {
      Log.i("Cgi.FinderConsumePrefetchReport", paramb);
      AppMethodBeat.o(272879);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderConsumePrefetchReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */