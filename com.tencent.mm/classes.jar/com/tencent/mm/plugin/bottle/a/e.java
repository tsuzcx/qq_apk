package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class e
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private String fileName = "";
  private String hYl = "";
  private int hYm = 0;
  private com.tencent.mm.modelvoice.a hYn = null;
  private int msgType = 0;
  
  public e(String paramString, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bar();
    locala.ecI = new bas();
    locala.uri = "/cgi-bin/micromsg-bin/openbottle";
    locala.ecG = 156;
    locala.ecJ = 55;
    locala.ecK = 1000000055;
    this.dmK = locala.Kt();
    this.hYl = paramString;
    this.msgType = paramInt;
  }
  
  private int awJ()
  {
    bar localbar = (bar)this.dmK.ecE.ecN;
    bas localbas = (bas)this.dmK.ecF.ecN;
    a locala = new a();
    locala.msgType = localbar.kSW;
    locala.hYe = 0;
    locala.hYg = 2;
    locala.hYf = c.xN(localbar.twD);
    locala.hYi = bk.UY();
    locala.hYd = com.tencent.mm.a.g.o(localbar.twD.getBytes());
    if (this.msgType == 3)
    {
      locala.content = this.fileName;
      locala.hYh = localbas.sRf;
    }
    for (;;)
    {
      i.awN().a(locala);
      return 0;
      locala.content = new String(localbas.twH.sPG.tFM.oY);
    }
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (bar)this.dmK.ecE.ecN;
    paramf.kSW = this.msgType;
    paramf.twD = this.hYl;
    if (paramf.twE == null) {
      paramf.twE = new ro();
    }
    if (paramf.twF == null) {
      paramf.twF = new ro();
    }
    if (this.msgType == 1)
    {
      paramf.twE.ndg = 0;
      paramf.twE.sPF = 0;
    }
    while (this.msgType == 3) {
      return a(parame, this.dmK, this);
    }
    y.e("MicroMsg.NetSceneOpenBottle", "doScene Error Msg type" + this.msgType);
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.d("MicroMsg.NetSceneOpenBottle", "ERR: onGYNetEnd errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      paramq = (bar)this.dmK.ecE.ecN;
      paramArrayOfByte = (bas)this.dmK.ecF.ecN;
      if (this.msgType == 1)
      {
        awJ();
        localbi = new bi();
        localbi.ec(paramq.twD);
        localbi.setContent(aa.b(paramArrayOfByte.twH.sPG));
        localbi.bg(bk.UY());
        localbi.fA(0);
        localbi.setStatus(3);
        localbi.setType(c.oh(paramq.kSW));
        au.Hx();
        com.tencent.mm.model.c.Fy().T(localbi);
        y.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd :" + localbi.field_content);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (bk.bl(this.fileName))
      {
        this.fileName = u.oI(this.hYl);
        this.hYn = new com.tencent.mm.modelvoice.a(com.tencent.mm.modelvoice.q.getFullPath(this.fileName));
        this.hYm = 0;
      }
      if (paramArrayOfByte.twH.sPF < paramArrayOfByte.twH.ndg + paramArrayOfByte.twH.sPG.tFK)
      {
        y.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd tot:" + paramArrayOfByte.twH.sPF + " start:" + paramArrayOfByte.twH.ndg + " len:" + paramArrayOfByte.twH.sPG.tFK);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      if (paramArrayOfByte.twH.ndg != this.hYm)
      {
        y.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + paramArrayOfByte.twH.ndg + " off:" + this.hYm);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      paramInt1 = this.hYn.write(paramArrayOfByte.twH.sPG.tFM.oY, paramArrayOfByte.twH.sPG.tFK, paramArrayOfByte.twH.ndg);
      if (paramInt1 != paramArrayOfByte.twH.sPG.tFK + paramArrayOfByte.twH.ndg)
      {
        y.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + paramArrayOfByte.twH.ndg + " len:" + paramArrayOfByte.twH.sPG.tFK + " writeRet:" + paramInt1);
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      this.hYm = paramInt1;
      if (paramArrayOfByte.twH.sPF <= this.hYm) {
        break;
      }
    } while (a(this.edc, this.dmL) != -1);
    this.dmL.onSceneEnd(3, -1, "doScene failed", this);
    return;
    awJ();
    bi localbi = new bi();
    localbi.ec(paramq.twD);
    localbi.setContent(n.d("bottle", paramArrayOfByte.sRf, false));
    localbi.ed(this.fileName);
    localbi.bg(bk.UY());
    localbi.fA(0);
    localbi.setStatus(3);
    localbi.setType(c.oh(paramq.kSW));
    au.Hx();
    com.tencent.mm.model.c.Fy().T(localbi);
    y.d("MicroMsg.NetSceneOpenBottle", "voice :" + paramArrayOfByte.sRf + " file:" + this.fileName);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    paramq = (bar)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    if (paramq.kSW == 1) {
      return m.b.edr;
    }
    if (paramq.kSW != 3) {
      return m.b.eds;
    }
    if (paramq.twE == null)
    {
      y.d("MicroMsg.NetSceneOpenBottle", "ERR: securityVerificationChecked errtype: rImpl.getBigContentInfo() == null");
      return m.b.eds;
    }
    if ((paramq.twE.sPF == 0) && (paramq.twE.ndg == 0)) {
      return m.b.edr;
    }
    if (paramq.twE.sPF <= paramq.twE.ndg) {
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 156;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.e
 * JD-Core Version:    0.7.0.1
 */