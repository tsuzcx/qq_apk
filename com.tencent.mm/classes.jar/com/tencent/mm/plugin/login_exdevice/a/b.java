package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends p
  implements m
{
  private h callback;
  public c nao;
  
  public b()
  {
    AppMethodBeat.i(262302);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cmu();
    ((c.a)localObject).otF = new cmv();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getloginqrcode";
    this.nao = ((c.a)localObject).bEF();
    localObject = (cmu)c.b.b(this.nao.otB);
    byte[] arrayOfByte = Util.getUuidRandom();
    ((cmu)localObject).YOj = w.aN(arrayOfByte);
    ((cmu)localObject).YOO = 0;
    this.nao.setRsaInfo(ac.iQe());
    this.nao.option = 1;
    this.nao.getReqObj().setPassKey(arrayOfByte);
    AppMethodBeat.o(262302);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262325);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(262325);
    return i;
  }
  
  public final int getType()
  {
    return 502;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262311);
    Log.i("MicroMsg.NetSceneGetLoginQRCode", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(262311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.b
 * JD-Core Version:    0.7.0.1
 */