package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class a
  extends q
  implements m
{
  protected String DMR;
  protected String DMS;
  protected LinkedList<dhf> DMT;
  protected int DMU;
  protected i callback;
  protected int mScene;
  protected final d rr;
  protected LinkedList<dhg> tqd;
  protected String type;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.DMT = new LinkedList();
    this.tqd = new LinkedList();
    this.DMU = 0;
    this.mScene = 0;
    d.a locala = new d.a();
    locala.lBU = new dhg();
    locala.lBV = new dhh();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117445);
    this.callback = parami;
    parami = (dhg)d.b.b(this.rr.lBR);
    parami.TOo = this.DMR;
    parami.GIL = this.DMS;
    parami.TOp = this.DMT;
    parami.type = this.type;
    parami.PgO = this.tqd;
    parami.TOq = this.DMU;
    parami.TOr = this.mScene;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.a
 * JD-Core Version:    0.7.0.1
 */