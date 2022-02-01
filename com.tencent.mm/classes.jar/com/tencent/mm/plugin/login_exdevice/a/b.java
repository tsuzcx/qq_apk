package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
  implements m
{
  private i callback;
  public d hJu;
  
  public b()
  {
    AppMethodBeat.i(231732);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bpx();
    ((d.a)localObject).iLO = new bpy();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getloginqrcode";
    this.hJu = ((d.a)localObject).aXF();
    localObject = (bpx)this.hJu.iLK.iLR;
    byte[] arrayOfByte = Util.getUuidRandom();
    ((bpx)localObject).KPW = z.aC(arrayOfByte);
    ((bpx)localObject).KQy = 0;
    this.hJu.setRsaInfo(ac.gtT());
    this.hJu.option = 1;
    this.hJu.getReqObj().setPassKey(arrayOfByte);
    AppMethodBeat.o(231732);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(231734);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(231734);
    return i;
  }
  
  public final int getType()
  {
    return 502;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231733);
    Log.i("MicroMsg.NetSceneGetLoginQRCode", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(231733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.b
 * JD-Core Version:    0.7.0.1
 */