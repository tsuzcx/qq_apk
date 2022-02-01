package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class a
  extends p
  implements m
{
  protected String JEf;
  protected String JEg;
  protected LinkedList<dzo> JEh;
  protected int JEi;
  protected h callback;
  protected int mScene;
  protected final c rr;
  protected String type;
  protected LinkedList<dzp> wuC;
  
  public a()
  {
    AppMethodBeat.i(117444);
    this.JEh = new LinkedList();
    this.wuC = new LinkedList();
    this.JEi = 0;
    this.mScene = 0;
    c.a locala = new c.a();
    locala.otE = new dzp();
    locala.otF = new dzq();
    locala.uri = "/cgi-bin/micromsg-bin/prconfig";
    locala.funcId = 3899;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(117444);
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117445);
    this.callback = paramh;
    paramh = (dzp)c.b.b(this.rr.otB);
    paramh.abeK = this.JEf;
    paramh.ycW = this.JEg;
    paramh.abeL = this.JEh;
    paramh.type = this.type;
    paramh.VXB = this.wuC;
    paramh.abeM = this.JEi;
    paramh.abeN = this.mScene;
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