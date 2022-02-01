package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, cry paramcry, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24866);
    cJr();
    if ((8 != paramInt) || (9 != paramInt)) {
      ac.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    og localog = (og)this.rr.hvr.hvw;
    localog.EaV = paramString1;
    localog.Eeg = paramcry;
    localog.DLC = paramInt;
    localog.DLD = paramString2;
    AppMethodBeat.o(24866);
  }
  
  public final String cJD()
  {
    AppMethodBeat.i(24867);
    Object localObject = ((oh)this.rr.hvs.hvw).Eeh;
    if ((localObject != null) && (((LinkedList)localObject).size() == 1))
    {
      localObject = ((dw)((LinkedList)localObject).get(0)).DQG;
      AppMethodBeat.o(24867);
      return localObject;
    }
    AppMethodBeat.o(24867);
    return null;
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24865);
    b.a locala = new b.a();
    locala.hvt = new og();
    locala.hvu = new oh();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.funcId = 1705;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24865);
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