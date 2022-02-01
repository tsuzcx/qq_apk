package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  public int action;
  private i callback;
  private final d rr;
  public ctv zqw;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(194478);
    Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString1, ""), Util.nullAs(paramString1, ""), Util.secPrint(paramString3) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLN = new ctu();
    ((d.a)localObject).iLO = new ctv();
    this.rr = ((d.a)localObject).aXF();
    this.action = paramInt;
    localObject = (ctu)this.rr.iLK.iLR;
    ((ctu)localObject).Mzd = Util.nullAs(paramString1, "");
    ((ctu)localObject).Mze = Util.nullAs(paramString2, "");
    ((ctu)localObject).Mzf = Util.nullAs(paramString3, "");
    ((ctu)localObject).action = paramInt;
    AppMethodBeat.o(194478);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(194479);
    this.callback = parami;
    this.zqw = ((ctv)this.rr.iLL.iLR);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(194479);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194480);
    Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(194480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */