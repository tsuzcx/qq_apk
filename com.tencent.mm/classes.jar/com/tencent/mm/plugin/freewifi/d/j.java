package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.btj;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<btj> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(24864);
    cJr();
    bth localbth = (bth)this.rr.hvr.hvw;
    localbth.Fiq = Build.BRAND;
    localbth.Fip = paramInt;
    localbth.Fio = paramLinkedList;
    AppMethodBeat.o(24864);
  }
  
  public final bti cJC()
  {
    return (bti)this.rr.hvs.hvw;
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24863);
    b.a locala = new b.a();
    locala.hvt = new bth();
    locala.hvu = new bti();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.funcId = 1707;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24863);
  }
  
  public final int getType()
  {
    return 1707;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.j
 * JD-Core Version:    0.7.0.1
 */