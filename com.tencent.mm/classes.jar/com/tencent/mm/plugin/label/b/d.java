package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private f callback;
  private final b rr;
  private LinkedList<duw> vhR;
  
  public d(LinkedList<duw> paramLinkedList)
  {
    AppMethodBeat.i(26152);
    this.vhR = new LinkedList();
    b.a locala = new b.a();
    locala.hQF = new cbl();
    locala.hQG = new cbm();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.funcId = 638;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.vhR = paramLinkedList;
    AppMethodBeat.o(26152);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26154);
    ae.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.callback = paramf;
    paramf = (cbl)this.rr.hQD.hQJ;
    paramf.HoV = this.vhR;
    paramf.GQn = this.vhR.size();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26154);
    return i;
  }
  
  public final int getType()
  {
    return 638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26153);
    ae.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.d
 * JD-Core Version:    0.7.0.1
 */