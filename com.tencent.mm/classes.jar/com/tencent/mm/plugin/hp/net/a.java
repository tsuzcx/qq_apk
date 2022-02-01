package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public class a
  extends n
  implements k
{
  protected g callback;
  protected int mScene;
  protected LinkedList<ccd> nWA;
  protected final b rr;
  protected String tFS;
  protected String tFT;
  protected LinkedList<ccc> tFU;
  protected int tFV;
  protected String type;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.tFU = new LinkedList();
    this.nWA = new LinkedList();
    this.tFV = 0;
    this.mScene = 0;
    b.a locala = new b.a();
    locala.hvt = new ccd();
    locala.hvu = new cce();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117445);
    this.callback = paramg;
    paramg = (ccd)this.rr.hvr.hvw;
    paramg.FqA = this.tFS;
    paramg.vyz = this.tFT;
    paramg.FqB = this.tFU;
    paramg.type = this.type;
    paramg.BNo = this.nWA;
    paramg.FqC = this.tFV;
    paramg.FqD = this.mScene;
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
    ac.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.a
 * JD-Core Version:    0.7.0.1
 */