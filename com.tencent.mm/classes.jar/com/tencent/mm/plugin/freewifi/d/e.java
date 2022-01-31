package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<aeb> paramLinkedList)
  {
    AppMethodBeat.i(20782);
    bAR();
    if (paramLinkedList.size() > 0) {
      ((aec)this.rr.fsV.fta).wXa = paramLinkedList;
    }
    AppMethodBeat.o(20782);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(20783);
    ab.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.ep(paramInt2, paramInt3)) {
      j.bAO().bAw().post(new e.1(this));
    }
    AppMethodBeat.o(20783);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20781);
    b.a locala = new b.a();
    locala.fsX = new aec();
    locala.fsY = new aed();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20781);
  }
  
  public final LinkedList<aeb> bAY()
  {
    aed localaed = (aed)this.rr.fsW.fta;
    if (localaed == null) {
      return null;
    }
    return localaed.wXa;
  }
  
  public final int getType()
  {
    return 1781;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.e
 * JD-Core Version:    0.7.0.1
 */