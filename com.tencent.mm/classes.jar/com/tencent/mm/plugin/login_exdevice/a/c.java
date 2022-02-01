package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends p
  implements m
{
  private h callback;
  public com.tencent.mm.am.c nao;
  
  public c(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262305);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eis();
    ((c.a)localObject).otF = new eit();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/pushloginurl";
    this.nao = ((c.a)localObject).bEF();
    localObject = (eis)c.b.b(this.nao.otB);
    ((eis)localObject).UserName = paramString;
    ((eis)localObject).YJj = w.aN(paramArrayOfByte);
    ((eis)localObject).YOO = 3;
    ((eis)localObject).aaSC = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
    ((eis)localObject).vgW = d.Yxf;
    paramString = Util.getUuidRandom();
    ((eis)localObject).YOj = w.aN(paramString);
    this.nao.setRsaInfo(ac.iQe());
    this.nao.option = 1;
    this.nao.getReqObj().setPassKey(paramString);
    AppMethodBeat.o(262305);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(262327);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(262327);
    return i;
  }
  
  public final int getType()
  {
    return 654;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262315);
    Log.i("MicroMsg.NetScenePushLoginUrl", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(262315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.c
 * JD-Core Version:    0.7.0.1
 */