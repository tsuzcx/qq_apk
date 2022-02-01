package com.tencent.mm.plugin.login_exdevice.a;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a
  extends q
  implements m
{
  private i callback;
  private d hJu;
  private byte[] yOt;
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231728);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new yt();
    ((d.a)localObject).iLO = new yu();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkloginqrcode";
    this.hJu = ((d.a)localObject).aXF();
    localObject = (yt)this.hJu.iLK.iLR;
    byte[] arrayOfByte = Util.getUuidRandom();
    ((yt)localObject).KPW = z.aC(arrayOfByte);
    ((yt)localObject).hil = ((int)(System.currentTimeMillis() / 1000L));
    ((yt)localObject).UUID = paramString;
    ((yt)localObject).KQy = 0;
    this.hJu.setRsaInfo(ac.gtT());
    this.hJu.option = 1;
    this.hJu.getReqObj().setPassKey(arrayOfByte);
    this.yOt = paramArrayOfByte;
    AppMethodBeat.o(231728);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(231730);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(231730);
    return i;
  }
  
  public final ckg een()
  {
    AppMethodBeat.i(231731);
    Object localObject = z.a(((yu)this.hJu.iLL.iLR).LjU.MpF);
    if ((this.yOt != null) && (this.yOt.length > 0))
    {
      byte[] arrayOfByte = MMProtocalJni.aesDecrypt((byte[])localObject, this.yOt);
      Log.i("MicroMsg.NetSceneCheckLoginQRCode", "decrypt notifyData %s %s %s", new Object[] { Integer.valueOf(this.yOt.length), Integer.valueOf(localObject.length), Integer.valueOf(arrayOfByte.length) });
      localObject = new ckg();
      try
      {
        ((ckg)localObject).parseFrom(arrayOfByte);
        AppMethodBeat.o(231731);
        return localObject;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneCheckLoginQRCode", localIOException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(231731);
    return null;
  }
  
  public final int getType()
  {
    return 503;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231729);
    Log.i("MicroMsg.NetSceneCheckLoginQRCode", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(231729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */