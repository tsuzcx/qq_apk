package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<amp> paramLinkedList)
  {
    AppMethodBeat.i(24852);
    cwf();
    if (paramLinkedList.size() > 0) {
      ((amq)this.rr.gUS.gUX).DnL = paramLinkedList;
    }
    AppMethodBeat.o(24852);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24853);
    ad.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.fF(paramInt2, paramInt3)) {
      j.cwc().cvK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24850);
          if ((amr)e.this.rr.gUT.gUX == null)
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
  
  protected final void cwf()
  {
    AppMethodBeat.i(24851);
    b.a locala = new b.a();
    locala.gUU = new amq();
    locala.gUV = new amr();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24851);
  }
  
  public final LinkedList<amp> cwm()
  {
    amr localamr = (amr)this.rr.gUT.gUX;
    if (localamr == null) {
      return null;
    }
    return localamr.DnL;
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