package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, cmr paramcmr, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24866);
    cwf();
    if ((8 != paramInt) || (9 != paramInt)) {
      ad.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    nz localnz = (nz)this.rr.gUS.gUX;
    localnz.CIt = paramString1;
    localnz.CLD = paramcmr;
    localnz.Ctl = paramInt;
    localnz.Ctm = paramString2;
    AppMethodBeat.o(24866);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24865);
    b.a locala = new b.a();
    locala.gUU = new nz();
    locala.gUV = new oa();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.funcId = 1705;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24865);
  }
  
  public final String cwr()
  {
    AppMethodBeat.i(24867);
    Object localObject = ((oa)this.rr.gUT.gUX).CLE;
    if ((localObject != null) && (((LinkedList)localObject).size() == 1))
    {
      localObject = ((du)((LinkedList)localObject).get(0)).Cyk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.k
 * JD-Core Version:    0.7.0.1
 */