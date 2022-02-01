package com.tencent.mm.plugin.login_exdevice.a;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a
  extends q
  implements m
{
  private byte[] Esr;
  private i callback;
  private d kwO;
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(251102);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new yx();
    ((d.a)localObject).lBV = new yy();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkloginqrcode";
    this.kwO = ((d.a)localObject).bgN();
    localObject = (yx)d.b.b(this.kwO.lBR);
    byte[] arrayOfByte = Util.getUuidRandom();
    ((yx)localObject).RQU = z.aN(arrayOfByte);
    ((yx)localObject).jUj = ((int)(System.currentTimeMillis() / 1000L));
    ((yx)localObject).UUID = paramString;
    ((yx)localObject).RRw = 0;
    this.kwO.setRsaInfo(ac.hpj());
    this.kwO.option = 1;
    this.kwO.getReqObj().setPassKey(arrayOfByte);
    this.Esr = paramArrayOfByte;
    AppMethodBeat.o(251102);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(251104);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(251104);
    return i;
  }
  
  public final cta eNH()
  {
    AppMethodBeat.i(251105);
    Object localObject = z.a(((yy)d.c.b(this.kwO.lBS)).Slb.TAI);
    if ((this.Esr != null) && (this.Esr.length > 0))
    {
      byte[] arrayOfByte = MMProtocalJni.aesDecrypt((byte[])localObject, this.Esr);
      Log.i("MicroMsg.NetSceneCheckLoginQRCode", "decrypt notifyData %s %s %s", new Object[] { Integer.valueOf(this.Esr.length), Integer.valueOf(localObject.length), Integer.valueOf(arrayOfByte.length) });
      localObject = new cta();
      try
      {
        ((cta)localObject).parseFrom(arrayOfByte);
        AppMethodBeat.o(251105);
        return localObject;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneCheckLoginQRCode", localIOException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(251105);
    return null;
  }
  
  public final int getType()
  {
    return 503;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(251103);
    Log.i("MicroMsg.NetSceneCheckLoginQRCode", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(251103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */