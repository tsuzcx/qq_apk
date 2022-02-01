package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.byr;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<byr> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(24864);
    cUl();
    byp localbyp = (byp)this.rr.hQD.hQJ;
    localbyp.Hls = Build.BRAND;
    localbyp.Hlr = paramInt;
    localbyp.Hlq = paramLinkedList;
    AppMethodBeat.o(24864);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24863);
    b.a locala = new b.a();
    locala.hQF = new byp();
    locala.hQG = new byq();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.funcId = 1707;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24863);
  }
  
  public final byq cUw()
  {
    return (byq)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1707;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.j
 * JD-Core Version:    0.7.0.1
 */