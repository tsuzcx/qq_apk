package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends c<jf>
{
  public List<cds> uAx;
  
  public a(LinkedList<cds> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    je localje = new je();
    localje.DWR = paramLinkedList;
    localje.DWS = paramInt;
    localje.DWT = 0;
    b.a locala = new b.a();
    locala.hvt = localje;
    locala.hvu = new jf();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.uAx = paramLinkedList;
    ac.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */