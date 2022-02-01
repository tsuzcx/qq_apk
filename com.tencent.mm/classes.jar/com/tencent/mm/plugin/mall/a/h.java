package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private cae EOM;
  public caf EON;
  private i callback;
  private d kwO;
  
  public h()
  {
    AppMethodBeat.i(65997);
    d.a locala = new d.a();
    locala.lBU = new cae();
    locala.lBV = new caf();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.EOM = ((cae)d.b.b(this.kwO.lBR));
    AppMethodBeat.o(65997);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65998);
    Log.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(65998);
    return i;
  }
  
  public final int getType()
  {
    return 1754;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65999);
    Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.EON = ((caf)d.c.b(this.kwO.lBS));
      params = this.EON.title;
      paramArrayOfByte = this.EON.TiL;
      if (this.EON.TiL == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.EON.TiL.size();; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { params, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65999);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */