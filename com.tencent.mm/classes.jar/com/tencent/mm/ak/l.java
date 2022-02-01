package com.tencent.mm.ak;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

final class l
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private String gTR;
  private int gTV;
  private String gTX;
  private int gUm;
  private String gUn;
  private OutputStream output;
  private String username;
  
  public l(String paramString)
  {
    AppMethodBeat.i(150296);
    this.output = null;
    this.username = paramString;
    if (af.st(paramString)) {
      this.username = af.aHM(paramString);
    }
    ad.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.gTV = 480;
    this.gUm = 480;
    this.gTX = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private int Y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.output == null) {
        this.output = i.cM(this.gUn, false);
      }
      this.output.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(150302);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      AppMethodBeat.o(150302);
    }
    return -1;
  }
  
  public static void aP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    p.auq().aO(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  private void auA()
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
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bt.m(localIOException) });
      AppMethodBeat.o(150303);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    auA();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    int j = 0;
    AppMethodBeat.i(150297);
    this.callback = paramg;
    if ((this.username == null) || (this.username.length() == 0))
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      AppMethodBeat.o(150297);
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      AppMethodBeat.o(150297);
      return -1;
    }
    Object localObject1 = p.auG();
    p.auq();
    this.gTR = e.I(this.username, true);
    if (i.eK(this.gTR))
    {
      ad.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.gUn = (this.gTR + ".tmp");
    paramg = ((h)localObject1).wc(this.username);
    Object localObject2;
    if (paramg == null)
    {
      i.deleteFile(this.gUn);
      paramg = new g();
      paramg.username = this.username;
      paramg.gTX = this.gTX;
      paramg.gTV = this.gTV;
      paramg.gTW = this.gUm;
      paramg.dtM = -1;
      localObject2 = paramg.convertTo();
      ((h)localObject1).gPa.a("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).gUU = new auo();
      ((b.a)localObject1).gUV = new aup();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).funcId = 158;
      ((b.a)localObject1).reqCmdId = 47;
      ((b.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((b.a)localObject1).atI();
      localObject2 = (auo)((com.tencent.mm.al.b)localObject1).gUS.gUX;
      if (af.st(this.username)) {
        break label636;
      }
      ((auo)localObject2).mAQ = this.username;
      ((auo)localObject2).Duq = 1;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((auo)localObject2).mAQ + " outType:" + ((auo)localObject2).Duq);
      ((auo)localObject2).Dun = this.gTV;
      ((auo)localObject2).Duo = this.gUm;
      ((auo)localObject2).Dup = this.gTX;
      ((auo)localObject2).uKQ = paramg.gTY;
      ((auo)localObject2).uKR = paramg.cWU;
      int i = dispatch(parame, (q)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.gUn;
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
          i.deleteFile(this.gUn);
          paramg.reset();
          paramg.username = this.username;
          paramg.gTX = this.gTX;
          paramg.gTV = this.gTV;
          paramg.gTW = this.gUm;
          ((h)localObject1).a(this.username, paramg);
        }
        break;
        label569:
        i = j;
        if (paramg.auv().equals(this.gTX))
        {
          i = j;
          if (paramg.gTV == this.gTV)
          {
            i = j;
            if (paramg.gTW == this.gUm)
            {
              i = j;
              if (i.aMN((String)localObject2) == paramg.cWU) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(u.aqG() + "@bottle"))
      {
        ((auo)localObject2).mAQ = u.aqG();
        ((auo)localObject2).Duq = 2;
      }
      else
      {
        ((auo)localObject2).mAQ = this.username;
        ((auo)localObject2).Duq = 2;
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
    paramArrayOfByte = (aup)((com.tencent.mm.al.b)paramq).gUT.gUX;
    ad.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      auA();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      auA();
      AppMethodBeat.o(150299);
      return;
    }
    paramInt1 = paramq.getRespObj().getRetCode();
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(paramInt1)));
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      auA();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.uKT != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.uKT.getBuffer() != null) {
        paramInt1 = Y(paramArrayOfByte.uKT.getBuffer().wA);
      }
    }
    if (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      auA();
      AppMethodBeat.o(150299);
      return;
    }
    paramq = p.auG();
    g localg = paramq.wc(this.username);
    if (localg == null)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      auA();
      AppMethodBeat.o(150299);
      return;
    }
    localg.cWU = (paramInt1 + paramArrayOfByte.uKR);
    localg.gTY = paramArrayOfByte.uKQ;
    paramq.a(this.username, localg);
    if (localg.cWU >= localg.gTY) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      ad.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localg.cWU), Integer.valueOf(localg.gTY) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    i.lD(this.gUn, this.gTR);
    aP(this.gTR, this.username);
    auA();
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
      paramq = n.b.gVC;
      AppMethodBeat.o(150298);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(150298);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.l
 * JD-Core Version:    0.7.0.1
 */