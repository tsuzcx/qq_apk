package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.protocal.protobuf.cmj;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<cmj> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(24864);
    dNu();
    cmh localcmh = (cmh)this.rr.iLK.iLR;
    localcmh.MrE = Build.BRAND;
    localcmh.MrD = paramInt;
    localcmh.MrC = paramLinkedList;
    AppMethodBeat.o(24864);
  }
  
  public final cmi dNF()
  {
    return (cmi)this.rr.iLL.iLR;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24863);
    d.a locala = new d.a();
    locala.iLN = new cmh();
    locala.iLO = new cmi();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.funcId = 1707;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24863);
  }
  
  public final int getType()
  {
    return 1707;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.j
 * JD-Core Version:    0.7.0.1
 */