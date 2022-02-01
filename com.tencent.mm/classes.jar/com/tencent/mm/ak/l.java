package com.tencent.mm.ak;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

final class l
  extends n
  implements k
{
  private f callback;
  private String hMI;
  private int hMM;
  private String hMO;
  private int hNd;
  private String hNe;
  private OutputStream output;
  private String username;
  
  public l(String paramString)
  {
    AppMethodBeat.i(150296);
    this.output = null;
    this.username = paramString;
    if (am.zs(paramString)) {
      this.username = am.aSZ(paramString);
    }
    ad.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.hMM = 480;
    this.hNd = 480;
    this.hMO = "jpg";
    AppMethodBeat.o(150296);
  }
  
  private int W(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150302);
    try
    {
      if (this.output == null) {
        this.output = i.cX(this.hNe, false);
      }
      this.output.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      AppMethodBeat.o(150302);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      AppMethodBeat.o(150302);
    }
    return -1;
  }
  
  private void aEt()
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
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bt.n(localIOException) });
      AppMethodBeat.o(150303);
    }
  }
  
  public static void aY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150300);
    p.aEk().aX(paramString1, paramString2);
    AppMethodBeat.o(150300);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150301);
    super.cancel();
    aEt();
    AppMethodBeat.o(150301);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int j = 0;
    AppMethodBeat.i(150297);
    this.callback = paramf;
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
    Object localObject1 = p.aEy();
    p.aEk();
    this.hMI = e.J(this.username, true);
    if (i.fv(this.hMI))
    {
      ad.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      AppMethodBeat.o(150297);
      return 0;
    }
    this.hNe = (this.hMI + ".tmp");
    paramf = ((h)localObject1).Dh(this.username);
    Object localObject2;
    if (paramf == null)
    {
      i.deleteFile(this.hNe);
      paramf = new g();
      paramf.username = this.username;
      paramf.hMO = this.hMO;
      paramf.hMM = this.hMM;
      paramf.hMN = this.hNd;
      paramf.dDp = -1;
      localObject2 = paramf.convertTo();
      ((h)localObject1).hHS.a("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).hNM = new bbw();
      ((b.a)localObject1).hNN = new bbx();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).funcId = 158;
      ((b.a)localObject1).hNO = 47;
      ((b.a)localObject1).respCmdId = 1000000047;
      localObject1 = ((b.a)localObject1).aDC();
      localObject2 = (bbw)((com.tencent.mm.al.b)localObject1).hNK.hNQ;
      if (am.zs(this.username)) {
        break label636;
      }
      ((bbw)localObject2).nDo = this.username;
      ((bbw)localObject2).GyK = 1;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((bbw)localObject2).nDo + " outType:" + ((bbw)localObject2).GyK);
      ((bbw)localObject2).GyH = this.hMM;
      ((bbw)localObject2).GyI = this.hNd;
      ((bbw)localObject2).GyJ = this.hMO;
      ((bbw)localObject2).xcK = paramf.hMP;
      ((bbw)localObject2).xcL = paramf.dfG;
      int i = dispatch(parame, (q)localObject1, this);
      AppMethodBeat.o(150297);
      return i;
      localObject2 = this.hNe;
      i = j;
      if (paramf != null)
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
          i.deleteFile(this.hNe);
          paramf.reset();
          paramf.username = this.username;
          paramf.hMO = this.hMO;
          paramf.hMM = this.hMM;
          paramf.hMN = this.hNd;
          ((h)localObject1).a(this.username, paramf);
        }
        break;
        label569:
        i = j;
        if (paramf.aEo().equals(this.hMO))
        {
          i = j;
          if (paramf.hMM == this.hMM)
          {
            i = j;
            if (paramf.hMN == this.hNd)
            {
              i = j;
              if (i.aYo((String)localObject2) == paramf.dfG) {
                i = 1;
              }
            }
          }
        }
      }
      label636:
      if (this.username.equals(u.aAm() + "@bottle"))
      {
        ((bbw)localObject2).nDo = u.aAm();
        ((bbw)localObject2).GyK = 2;
      }
      else
      {
        ((bbw)localObject2).nDo = this.username;
        ((bbw)localObject2).GyK = 2;
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
    paramArrayOfByte = (bbx)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    ad.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEt();
      AppMethodBeat.o(150299);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      aEt();
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
      aEt();
      AppMethodBeat.o(150299);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.xcN != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.xcN.getBuffer() != null) {
        paramInt1 = W(paramArrayOfByte.xcN.getBuffer().zr);
      }
    }
    if (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEt();
      AppMethodBeat.o(150299);
      return;
    }
    paramq = p.aEy();
    g localg = paramq.Dh(this.username);
    if (localg == null)
    {
      ad.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aEt();
      AppMethodBeat.o(150299);
      return;
    }
    localg.dfG = (paramInt1 + paramArrayOfByte.xcL);
    localg.hMP = paramArrayOfByte.xcK;
    paramq.a(this.username, localg);
    if (localg.dfG >= localg.hMP) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      ad.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localg.dfG), Integer.valueOf(localg.hMP) });
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(150299);
      return;
    }
    i.mA(this.hNe, this.hMI);
    aY(this.hMI, this.username);
    aEt();
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
      paramq = n.b.hOq;
      AppMethodBeat.o(150298);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(150298);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.l
 * JD-Core Version:    0.7.0.1
 */