package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.apt;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<aps> paramLinkedList)
  {
    AppMethodBeat.i(24852);
    cJr();
    if (paramLinkedList.size() > 0) {
      ((apt)this.rr.hvr.hvw).EIL = paramLinkedList;
    }
    AppMethodBeat.o(24852);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24853);
    ac.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.fM(paramInt2, paramInt3)) {
      j.cJo().cIW().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24850);
          if ((apu)e.this.rr.hvs.hvw == null)
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
  
  protected final void cJr()
  {
    AppMethodBeat.i(24851);
    b.a locala = new b.a();
    locala.hvt = new apt();
    locala.hvu = new apu();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24851);
  }
  
  public final LinkedList<aps> cJy()
  {
    apu localapu = (apu)this.rr.hvs.hvw;
    if (localapu == null) {
      return null;
    }
    return localapu.EIL;
  }
  
  public final int getType()
  {
    return 1781;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.e
 * JD-Core Version:    0.7.0.1
 */