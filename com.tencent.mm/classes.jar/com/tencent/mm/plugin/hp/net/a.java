package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public class a
  extends n
  implements k
{
  protected f callback;
  protected int mScene;
  protected LinkedList<cgu> ozU;
  protected final b rr;
  protected String type;
  protected String uIB;
  protected String uIC;
  protected LinkedList<cgt> uID;
  protected int uIE;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.uID = new LinkedList();
    this.ozU = new LinkedList();
    this.uIE = 0;
    this.mScene = 0;
    b.a locala = new b.a();
    locala.hNM = new cgu();
    locala.hNN = new cgv();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117445);
    this.callback = paramf;
    paramf = (cgu)this.rr.hNK.hNQ;
    paramf.Hak = this.uIB;
    paramf.wDT = this.uIC;
    paramf.Hal = this.uID;
    paramf.type = this.type;
    paramf.DnG = this.ozU;
    paramf.Ham = this.uIE;
    paramf.Han = this.mScene;
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