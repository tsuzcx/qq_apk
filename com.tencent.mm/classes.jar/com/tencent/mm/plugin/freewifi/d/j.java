package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.bxx;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<bxx> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(24864);
    cRG();
    bxv localbxv = (bxv)this.rr.hNK.hNQ;
    localbxv.GRR = Build.BRAND;
    localbxv.GRQ = paramInt;
    localbxv.GRP = paramLinkedList;
    AppMethodBeat.o(24864);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24863);
    b.a locala = new b.a();
    locala.hNM = new bxv();
    locala.hNN = new bxw();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.funcId = 1707;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24863);
  }
  
  public final bxw cRR()
  {
    return (bxw)this.rr.hNL.hNQ;
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