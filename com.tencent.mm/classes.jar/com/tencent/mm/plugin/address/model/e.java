package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public boolean ftl;
  public String nickname;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new biy();
    ((b.a)localObject).ecI = new biz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((b.a)localObject).ecG = 417;
    ((b.a)localObject).ecJ = 202;
    ((b.a)localObject).ecK = 1000000202;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (biy)this.dmK.ecE.ecN;
    ((biy)localObject).timestamp = 0;
    ((biy)localObject).tDc = paramString1;
    ((biy)localObject).bOL = paramString2;
    ((biy)localObject).scene = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    y.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (biz)((b)paramq).ecF.ecN;
      this.username = paramq.jFa;
      this.nickname = paramq.tDf;
      if (paramq.tDe != 1) {
        break label186;
      }
    }
    for (;;)
    {
      this.ftl = bool;
      if (paramq.tCP.tCS != null)
      {
        y.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.tCP.tCS.size());
        a.YB();
        a.YD().s(paramq.tCP.tCS);
        a.YB();
        a.YD().YF();
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label186:
      bool = false;
    }
  }
  
  public final int getType()
  {
    return 417;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */