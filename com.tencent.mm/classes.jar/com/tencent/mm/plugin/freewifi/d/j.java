package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bci;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<bci> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(20794);
    bAR();
    bcg localbcg = (bcg)this.rr.fsV.fta;
    localbcg.xrq = Build.BRAND;
    localbcg.xrp = paramInt;
    localbcg.xro = paramLinkedList;
    AppMethodBeat.o(20794);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20793);
    b.a locala = new b.a();
    locala.fsX = new bcg();
    locala.fsY = new bch();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.funcId = 1707;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20793);
  }
  
  public final bch bBc()
  {
    return (bch)this.rr.fsW.fta;
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