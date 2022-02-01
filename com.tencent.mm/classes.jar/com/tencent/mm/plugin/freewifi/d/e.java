package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<bfl> paramLinkedList)
  {
    AppMethodBeat.i(24852);
    dNu();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      ((bfm)this.rr.iLK.iLR).LPf = paramLinkedList;
    }
    AppMethodBeat.o(24852);
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24853);
    Log.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.gB(paramInt2, paramInt3)) {
      j.dNr().dMZ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24850);
          if ((bfn)e.this.rr.iLL.iLR == null)
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
  
  public final LinkedList<bfl> dNB()
  {
    bfn localbfn = (bfn)this.rr.iLL.iLR;
    if (localbfn == null) {
      return null;
    }
    return localbfn.LPf;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24851);
    d.a locala = new d.a();
    locala.iLN = new bfm();
    locala.iLO = new bfn();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24851);
  }
  
  public final int getType()
  {
    return 1781;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.e
 * JD-Core Version:    0.7.0.1
 */