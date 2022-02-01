package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public class a
  extends n
  implements k
{
  protected g callback;
  protected int mScene;
  protected LinkedList<bxi> ntA;
  protected final b rr;
  protected String syd;
  protected String sye;
  protected LinkedList<bxh> syf;
  protected int syg;
  protected String type;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.syf = new LinkedList();
    this.ntA = new LinkedList();
    this.syg = 0;
    this.mScene = 0;
    b.a locala = new b.a();
    locala.gUU = new bxi();
    locala.gUV = new bxj();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117445);
    this.callback = paramg;
    paramg = (bxi)this.rr.gUS.gUX;
    paramg.DTN = this.syd;
    paramg.upD = this.sye;
    paramg.DTO = this.syf;
    paramg.type = this.type;
    paramg.AuU = this.ntA;
    paramg.DTP = this.syg;
    paramg.DTQ = this.mScene;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117445);
    return i;
  }
  
  public int getType()
  {
    return 3899;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117446);
    ad.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.a
 * JD-Core Version:    0.7.0.1
 */