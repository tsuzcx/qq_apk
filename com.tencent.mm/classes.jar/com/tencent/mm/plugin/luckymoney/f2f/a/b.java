package com.tencent.mm.plugin.luckymoney.f2f.a;

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
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.amk;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private amk EvE;
  private aml EvF;
  private i callback;
  public int fwx;
  private d kwO;
  public String tVo;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new d.a();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).lBU = new amk();
    ((d.a)localObject).lBV = new aml();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.kwO = ((d.a)localObject).bgN();
    this.EvE = ((amk)d.b.b(this.kwO.lBR));
    localObject = k.gJe();
    if (localObject != null)
    {
      this.EvE.latitude = ((bd)localObject).latitude;
      this.EvE.longitude = ((bd)localObject).longitude;
    }
    this.EvE.SwK = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65039);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.EvF = ((aml)d.c.b(((d)params).lBS));
    this.fwx = this.EvF.fwx;
    this.tVo = this.EvF.tVo;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.EvF.fwx, this.EvF.tVo, this);
    }
    AppMethodBeat.o(65040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */