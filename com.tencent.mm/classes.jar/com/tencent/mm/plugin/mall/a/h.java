package com.tencent.mm.plugin.mall.a;

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
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private i callback;
  private d hJu;
  private bsi zjv;
  public bsj zjw;
  
  public h()
  {
    AppMethodBeat.i(65997);
    d.a locala = new d.a();
    locala.iLN = new bsi();
    locala.iLO = new bsj();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.zjv = ((bsi)this.hJu.iLK.iLR);
    AppMethodBeat.o(65997);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65998);
    Log.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
      this.zjw = ((bsj)this.hJu.iLL.iLR);
      params = this.zjw.title;
      paramArrayOfByte = this.zjw.LZr;
      if (this.zjw.LZr == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.zjw.LZr.size();; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { params, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65999);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */