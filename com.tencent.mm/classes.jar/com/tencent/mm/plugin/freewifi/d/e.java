package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<auc> paramLinkedList)
  {
    AppMethodBeat.i(24852);
    cUl();
    if (paramLinkedList.size() > 0) {
      ((aud)this.rr.hQD.hQJ).GLb = paramLinkedList;
    }
    AppMethodBeat.o(24852);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24853);
    ae.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.gc(paramInt2, paramInt3)) {
      j.cUi().cTQ().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24850);
          if ((aue)e.this.rr.hQE.hQJ == null)
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
  
  protected final void cUl()
  {
    AppMethodBeat.i(24851);
    b.a locala = new b.a();
    locala.hQF = new aud();
    locala.hQG = new aue();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24851);
  }
  
  public final LinkedList<auc> cUs()
  {
    aue localaue = (aue)this.rr.hQE.hQJ;
    if (localaue == null) {
      return null;
    }
    return localaue.GLb;
  }
  
  public final int getType()
  {
    return 1781;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.e
 * JD-Core Version:    0.7.0.1
 */