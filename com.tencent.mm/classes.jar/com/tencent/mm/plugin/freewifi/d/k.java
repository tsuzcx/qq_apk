package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, dqu paramdqu, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24866);
    dNu();
    if ((8 != paramInt) || (9 != paramInt)) {
      Log.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    qn localqn = (qn)this.rr.iLK.iLR;
    localqn.KSV = paramString1;
    localqn.KXt = paramdqu;
    localqn.KCx = paramInt;
    localqn.KCy = paramString2;
    AppMethodBeat.o(24866);
  }
  
  public final String dNG()
  {
    AppMethodBeat.i(24867);
    Object localObject = ((qo)this.rr.iLL.iLR).KXu;
    if ((localObject != null) && (((LinkedList)localObject).size() == 1))
    {
      localObject = ((ej)((LinkedList)localObject).get(0)).KIa;
      AppMethodBeat.o(24867);
      return localObject;
    }
    AppMethodBeat.o(24867);
    return null;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24865);
    d.a locala = new d.a();
    locala.iLN = new qn();
    locala.iLO = new qo();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.funcId = 1705;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24865);
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