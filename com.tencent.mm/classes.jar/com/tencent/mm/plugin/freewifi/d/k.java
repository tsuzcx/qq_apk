package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, cxf paramcxf, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24866);
    cRG();
    if ((8 != paramInt) || (9 != paramInt)) {
      ad.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    pl localpl = (pl)this.rr.hNK.hNQ;
    localpl.FGE = paramString1;
    localpl.FKF = paramcxf;
    localpl.FqH = paramInt;
    localpl.FqI = paramString2;
    AppMethodBeat.o(24866);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24865);
    b.a locala = new b.a();
    locala.hNM = new pl();
    locala.hNN = new pm();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.funcId = 1705;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24865);
  }
  
  public final String cRS()
  {
    AppMethodBeat.i(24867);
    Object localObject = ((pm)this.rr.hNL.hNQ).FKG;
    if ((localObject != null) && (((LinkedList)localObject).size() == 1))
    {
      localObject = ((dx)((LinkedList)localObject).get(0)).FvV;
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