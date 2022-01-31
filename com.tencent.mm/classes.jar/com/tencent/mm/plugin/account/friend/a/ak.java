package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqk;
import com.tencent.mm.protocal.c.bql;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ak
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public ak(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bqk();
    locala.ecI = new bql();
    locala.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
    locala.ecG = 382;
    locala.ecJ = 181;
    locala.ecK = 1000000181;
    this.dmK = locala.Kt();
    ((bqk)this.dmK.ecE.ecN).sBC = bk.ZK(paramString);
    y.d("MicroMsg.NetSceneSetEmailPwd", "md5 " + paramString);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 382;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ak
 * JD-Core Version:    0.7.0.1
 */