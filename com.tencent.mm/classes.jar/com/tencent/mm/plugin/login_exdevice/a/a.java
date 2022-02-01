package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a
  extends p
  implements m
{
  private byte[] KkX;
  private h callback;
  private c nao;
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262313);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aau();
    ((c.a)localObject).otF = new aav();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkloginqrcode";
    this.nao = ((c.a)localObject).bEF();
    localObject = (aau)c.b.b(this.nao.otB);
    byte[] arrayOfByte = Util.getUuidRandom();
    ((aau)localObject).YOj = w.aN(arrayOfByte);
    ((aau)localObject).muB = ((int)(System.currentTimeMillis() / 1000L));
    ((aau)localObject).UUID = paramString;
    ((aau)localObject).YOO = 0;
    this.nao.setRsaInfo(ac.iQe());
    this.nao.option = 1;
    this.nao.getReqObj().setPassKey(arrayOfByte);
    this.KkX = paramArrayOfByte;
    AppMethodBeat.o(262313);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262334);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(262334);
    return i;
  }
  
  public final dkc fWa()
  {
    AppMethodBeat.i(262339);
    Object localObject = w.a(((aav)c.c.b(this.nao.otC)).Zjl.aaPX);
    if ((this.KkX != null) && (this.KkX.length > 0))
    {
      byte[] arrayOfByte = MMProtocalJni.aesDecrypt((byte[])localObject, this.KkX);
      Log.i("MicroMsg.NetSceneCheckLoginQRCode", "decrypt notifyData %s %s %s", new Object[] { Integer.valueOf(this.KkX.length), Integer.valueOf(localObject.length), Integer.valueOf(arrayOfByte.length) });
      localObject = new dkc();
      try
      {
        ((dkc)localObject).parseFrom(arrayOfByte);
        AppMethodBeat.o(262339);
        return localObject;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneCheckLoginQRCode", localIOException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(262339);
    return null;
  }
  
  public final int getType()
  {
    return 503;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262319);
    Log.i("MicroMsg.NetSceneCheckLoginQRCode", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(262319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */