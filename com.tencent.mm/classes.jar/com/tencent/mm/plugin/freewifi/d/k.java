package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, cxz paramcxz, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24866);
    cUl();
    if ((8 != paramInt) || (9 != paramInt)) {
      ae.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    pn localpn = (pn)this.rr.hQD.hQJ;
    localpn.FZa = paramString1;
    localpn.Gde = paramcxz;
    localpn.FJf = paramInt;
    localpn.FJg = paramString2;
    AppMethodBeat.o(24866);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24865);
    b.a locala = new b.a();
    locala.hQF = new pn();
    locala.hQG = new po();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.funcId = 1705;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24865);
  }
  
  public final String cUx()
  {
    AppMethodBeat.i(24867);
    Object localObject = ((po)this.rr.hQE.hQJ).Gdf;
    if ((localObject != null) && (((LinkedList)localObject).size() == 1))
    {
      localObject = ((dx)((LinkedList)localObject).get(0)).FOt;
      AppMethodBeat.o(24867);
      return localObject;
    }
    AppMethodBeat.o(24867);
    return null;
  }
  
  public final int getType()
  {
    return 1705;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.k
 * JD-Core Version:    0.7.0.1
 */