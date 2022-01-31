package com.tencent.mm.plugin.address.model;

import com.tencent.mm.a.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public int status;
  
  public d(String paramString1, String paramString2, o paramo)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new biu();
    ((b.a)localObject).ecI = new biv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
    ((b.a)localObject).ecG = 582;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    StringBuilder localStringBuilder = new StringBuilder("a2key is ");
    if (!bk.bl(paramString1))
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", newa2key is ");
      if (bk.bl(paramString2)) {
        break label206;
      }
    }
    label206:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      y.d("MicroMsg.NetSceneRcptInfoImportYiXun", bool1);
      this.dmK = ((b.a)localObject).Kt();
      localObject = (biu)this.dmK.ecE.ecN;
      ((biu)localObject).syq = new bmk().bs(bk.ZM(paramString1));
      ((biu)localObject).tCQ = new bmk().bs(bk.ZM(paramString2));
      ((biu)localObject).qq = paramo.intValue();
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (biv)((b)paramq).ecF.ecN;
      this.status = paramq.tCR;
      y.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
      if ((paramq.tCP.tCS != null) && (this.status == 0))
      {
        y.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.tCP.tCS.size());
        a.YB();
        a.YD().s(paramq.tCP.tCS);
        a.YB();
        a.YD().YF();
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 582;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.d
 * JD-Core Version:    0.7.0.1
 */