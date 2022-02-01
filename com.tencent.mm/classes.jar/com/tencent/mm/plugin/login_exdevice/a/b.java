package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
  implements m
{
  private i callback;
  public d kwO;
  
  public b()
  {
    AppMethodBeat.i(292342);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bxr();
    ((d.a)localObject).lBV = new bxs();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getloginqrcode";
    this.kwO = ((d.a)localObject).bgN();
    localObject = (bxr)d.b.b(this.kwO.lBR);
    byte[] arrayOfByte = Util.getUuidRandom();
    ((bxr)localObject).RQU = z.aN(arrayOfByte);
    ((bxr)localObject).RRw = 0;
    this.kwO.setRsaInfo(ac.hpj());
    this.kwO.option = 1;
    this.kwO.getReqObj().setPassKey(arrayOfByte);
    AppMethodBeat.o(292342);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(292344);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(292344);
    return i;
  }
  
  public final int getType()
  {
    return 502;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(292343);
    Log.i("MicroMsg.NetSceneGetLoginQRCode", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(292343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.b
 * JD-Core Version:    0.7.0.1
 */