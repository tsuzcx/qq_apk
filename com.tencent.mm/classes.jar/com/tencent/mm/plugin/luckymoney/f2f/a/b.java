package com.tencent.mm.plugin.luckymoney.f2f.a;

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
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  public int dDN;
  private d hJu;
  public String qwn;
  private alj yRG;
  private alk yRH;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new d.a();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).iLN = new alj();
    ((d.a)localObject).iLO = new alk();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.hJu = ((d.a)localObject).aXF();
    this.yRG = ((alj)this.hJu.iLK.iLR);
    localObject = k.fQy();
    if (localObject != null)
    {
      this.yRG.latitude = ((bf)localObject).latitude;
      this.yRG.longitude = ((bf)localObject).longitude;
    }
    this.yRG.Lum = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65039);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(65039);
    return i;
  }
  
  public final int getType()
  {
    return 1971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65040);
    Log.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.yRH = ((alk)((d)params).iLL.iLR);
    this.dDN = this.yRH.dDN;
    this.qwn = this.yRH.qwn;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.yRH.dDN, this.yRH.qwn, this);
    }
    AppMethodBeat.o(65040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */