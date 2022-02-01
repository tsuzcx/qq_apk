package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import java.util.LinkedList;

public final class j
  extends c
{
  public j(LinkedList<bot> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(24864);
    cwf();
    bor localbor = (bor)this.rr.gUS.gUX;
    localbor.DMb = Build.BRAND;
    localbor.DMa = paramInt;
    localbor.DLZ = paramLinkedList;
    AppMethodBeat.o(24864);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24863);
    b.a locala = new b.a();
    locala.gUU = new bor();
    locala.gUV = new bos();
    locala.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
    locala.funcId = 1707;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24863);
  }
  
  public final bos cwq()
  {
    return (bos)this.rr.gUT.gUX;
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