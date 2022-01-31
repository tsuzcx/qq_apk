package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k
{
  private f dmL;
  private final b esv;
  public Object tag;
  
  public u(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new asj();
    locala.ecI = new ask();
    locala.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
    locala.ecG = 666;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.esv = locala.Kt();
    ((asj)this.esv.ecE.ecN).kSC = paramString;
  }
  
  public final ask QO()
  {
    return (ask)this.esv.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      y.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 666;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */