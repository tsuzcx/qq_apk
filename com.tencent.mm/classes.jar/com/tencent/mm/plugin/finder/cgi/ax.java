package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetCurLocation;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "latitude", "", "longitude", "(DD)V", "request", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends b<cig>
{
  public static final a AAP;
  private final cif AAQ;
  
  static
  {
    AppMethodBeat.i(336183);
    AAP = new a((byte)0);
    AppMethodBeat.o(336183);
  }
  
  public ax(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(336175);
    this.AAQ = new cif();
    this.AAQ.YTd = paramDouble1;
    this.AAQ.YTc = paramDouble2;
    c.a locala = new c.a();
    locala.otE = ((a)this.AAQ);
    locala.otF = ((a)new cig());
    locala.uri = "/cgi-bin/micromsg-bin/getcurlocation";
    locala.funcId = 665;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    AppMethodBeat.o(336175);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetCurLocation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */