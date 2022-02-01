package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<atm> paramLinkedList)
  {
    AppMethodBeat.i(24852);
    cRG();
    if (paramLinkedList.size() > 0) {
      ((atn)this.rr.hNK.hNQ).GrD = paramLinkedList;
    }
    AppMethodBeat.o(24852);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24853);
    ad.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.gc(paramInt2, paramInt3)) {
      j.cRD().cRl().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24850);
          if ((ato)e.this.rr.hNL.hNQ == null)
          {
            AppMethodBeat.o(24850);
            return;
          }
          AppMethodBeat.o(24850);
        }
      });
    }
    AppMethodBeat.o(24853);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24851);
    b.a locala = new b.a();
    locala.hNM = new atn();
    locala.hNN = new ato();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24851);
  }
  
  public final LinkedList<atm> cRN()
  {
    ato localato = (ato)this.rr.hNL.hNQ;
    if (localato == null) {
      return null;
    }
    return localato.GrD;
  }
  
  public final int getType()
  {
    return 1781;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.e
 * JD-Core Version:    0.7.0.1
 */