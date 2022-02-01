package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class b
  extends w
{
  private aqc Kom;
  private aqd Kon;
  private h callback;
  public int hAV;
  private c nao;
  public String wYI;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new c.a();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).otE = new aqc();
    ((c.a)localObject).otF = new aqd();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.nao = ((c.a)localObject).bEF();
    this.Kom = ((aqc)c.b.b(this.nao.otB));
    localObject = k.iis();
    if (localObject != null)
    {
      this.Kom.latitude = ((bi)localObject).latitude;
      this.Kom.longitude = ((bi)localObject).longitude;
    }
    this.Kom.Zxt = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65039);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(65039);
    return i;
  }
  
  public final int getType()
  {
    return 1971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(283854);
    Log.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Kon = ((aqd)c.c.b(((c)params).otC));
    this.hAV = this.Kon.hAV;
    this.wYI = this.Kon.wYI;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.Kon.hAV, this.Kon.wYI, this);
    }
    AppMethodBeat.o(283854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */