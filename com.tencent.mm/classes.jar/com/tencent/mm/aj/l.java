package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

final class l
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private int huL;
  private String huM;
  private String huq;
  private int huu;
  private String huw;
  private OutputStream output;
  private String username;
  
  public l(String paramString)
  {
    AppMethodBeat.i(150296);
    this.output = null;
    this.username = paramString;
    if (ai.ww(paramString)) {
      this.username = ai.aNh(paramString);
    }
    ac.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.huu = 480;
    this.huL = 480;
    this.huw = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private int X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.output == null) {
        this.output = i.cS(this.huM, false);
      }
      this.output.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(150302);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      AppMethodBeat.o(150302);
    }
    return -1;
  }
  
  private void aBr()
  {
    AppMethodBeat.i(150303);
    try
    {
      if (this.output != null)
      {
        this.output.flush();
        this.output.close();
        this.output = null;
      }
      AppMethodBeat.o(150303);
      return;
    }
    catch (IOException localIOException)
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bs.m(localIOException) });
      AppMethodBeat.o(150303);
    }
  }
  
  public static void aX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    p.aBh().aW(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    aBr();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    int j = 0;
    AppMethodBeat.i(150297);
    this.callback = paramg;
    if ((this.username == null) || (this.username.length() == 0))
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      AppMethodBeat.o(150297);
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      AppMethodBeat.o(150297);
      return -1;
    }
    Object localObject1 = p.aBx();
    p.aBh();
    this.huq = e.J(this.username, true);
    if (i.eA(this.huq))
    {
      ac.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.huM = (this.huq + ".tmp");
    paramg = ((h)localObject1).Ai(this.username);
    Object localObject2;
    if (paramg == null)
    {
      i.deleteFile(this.huM);
      paramg = new g();
      paramg.username = this.username;
      paramg.huw = this.huw;
      paramg.huu = this.huu;
      paramg.huv = this.huL;
      paramg.drx = -1;
      localObject2 = paramg.convertTo();
      ((h)localObject1).hpA.a("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).hvt = new axu();
      ((b.a)localObject1).hvu = new axv();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).funcId = 158;
      ((b.a)localObject1).reqCmdId = 47;
      ((b.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((b.a)localObject1).aAz();
      localObject2 = (axu)((com.tencent.mm.ak.b)localObject1).hvr.hvw;
      if (ai.ww(this.username)) {
        break label636;
      }
      ((axu)localObject2).ncR = this.username;
      ((axu)localObject2).EPz = 1;
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((axu)localObject2).ncR + " outType:" + ((axu)localObject2).EPz);
      ((axu)localObject2).EPw = this.huu;
      ((axu)localObject2).EPx = this.huL;
      ((axu)localObject2).EPy = this.huw;
      ((axu)localObject2).vTH = paramg.hux;
      ((axu)localObject2).vTI = paramg.cUq;
      int i = dispatch(parame, (q)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.huM;
      i = j;
      if (paramg != null)
      {
        i = j;
        if (localObject2 != null)
        {
          if (((String)localObject2).length() != 0) {
            break label569;
          }
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          i.deleteFile(this.huM);
          paramg.reset();
          paramg.username = this.username;
          paramg.huw = this.huw;
          paramg.huu = this.huu;
          paramg.huv = this.huL;
          ((h)localObject1).a(this.username, paramg);
        }
        break;
        label569:
        i = j;
        if (paramg.aBm().equals(this.huw))
        {
          i = j;
          if (paramg.huu == this.huu)
          {
            i = j;
            if (paramg.huv == this.huL)
            {
              i = j;
              if (i.aSp((String)localObject2) == paramg.cUq) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(u.axw() + "@bottle"))
      {
        ((axu)localObject2).ncR = u.axw();
        ((axu)localObject2).EPz = 2;
      }
      else
      {
        ((axu)localObject2).ncR = this.username;
        ((axu)localObject2).EPz = 2;
      }
    }
  }
  
  public final int getType()
  {
    return 158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150299);
    paramArrayOfByte = (axv)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    ac.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aBr();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      aBr();
      AppMethodBeat.o(150299);
      return;
    }
    paramInt1 = paramq.getRespObj().getRetCode();
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(paramInt1)));
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aBr();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.vTK != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.vTK.getBuffer() != null) {
        paramInt1 = X(paramArrayOfByte.vTK.getBuffer().xy);
      }
    }
    if (paramInt1 < 0)
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aBr();
      AppMethodBeat.o(150299);
      return;
    }
    paramq = p.aBx();
    g localg = paramq.Ai(this.username);
    if (localg == null)
    {
      ac.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aBr();
      AppMethodBeat.o(150299);
      return;
    }
    localg.cUq = (paramInt1 + paramArrayOfByte.vTI);
    localg.hux = paramArrayOfByte.vTH;
    paramq.a(this.username, localg);
    if (localg.cUq >= localg.hux) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      ac.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localg.cUq), Integer.valueOf(localg.hux) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    i.ma(this.huM, this.huq);
    aX(this.huq, this.username);
    aBr();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150299);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(150298);
    if ((this.username == null) || (this.username.length() == 0))
    {
      paramq = n.b.hwb;
      AppMethodBeat.o(150298);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(150298);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.l
 * JD-Core Version:    0.7.0.1
 */