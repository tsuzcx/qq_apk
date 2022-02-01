package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public class a
  extends n
  implements k
{
  protected f callback;
  protected int mScene;
  protected LinkedList<cho> oGw;
  protected final b rr;
  protected String type;
  protected String uUo;
  protected String uUp;
  protected LinkedList<chn> uUq;
  protected int uUr;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.uUq = new LinkedList();
    this.oGw = new LinkedList();
    this.uUr = 0;
    this.mScene = 0;
    b.a locala = new b.a();
    locala.hQF = new cho();
    locala.hQG = new chp();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117445);
    this.callback = paramf;
    paramf = (cho)this.rr.hQD.hQJ;
    paramf.HtK = this.uUo;
    paramf.wTE = this.uUp;
    paramf.HtL = this.uUq;
    paramf.type = this.type;
    paramf.DFl = this.oGw;
    paramf.HtM = this.uUr;
    paramf.HtN = this.mScene;
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
    ae.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.a
 * JD-Core Version:    0.7.0.1
 */