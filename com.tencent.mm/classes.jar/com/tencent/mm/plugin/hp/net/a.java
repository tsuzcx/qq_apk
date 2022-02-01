package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class a
  extends q
  implements m
{
  protected i callback;
  protected int mScene;
  protected LinkedList<cxv> pUc;
  protected final d rr;
  protected String type;
  protected String ymP;
  protected String ymQ;
  protected LinkedList<cxu> ymR;
  protected int ymS;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.ymR = new LinkedList();
    this.pUc = new LinkedList();
    this.ymS = 0;
    this.mScene = 0;
    d.a locala = new d.a();
    locala.iLN = new cxv();
    locala.iLO = new cxw();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117445);
    this.callback = parami;
    parami = (cxv)this.rr.iLK.iLR;
    parami.MCI = this.ymP;
    parami.APx = this.ymQ;
    parami.MCJ = this.ymR;
    parami.type = this.type;
    parami.Iow = this.pUc;
    parami.MCK = this.ymS;
    parami.MCL = this.mScene;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(117445);
    return i;
  }
  
  public int getType()
  {
    return 3899;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117446);
    Log.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.a
 * JD-Core Version:    0.7.0.1
 */