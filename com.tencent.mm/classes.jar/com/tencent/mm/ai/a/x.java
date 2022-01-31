package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.sdk.platformtools.y;

public final class x
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  
  public x(String paramString1, String paramString2, ir paramir1, ir paramir2, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bzq();
    ((b.a)localObject).ecI = new bzr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((b.a)localObject).ecG = 1357;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bzq)this.dmK.ecE.ecN;
    ((bzq)localObject).sCO = paramString1;
    ((bzq)localObject).sCI = paramString2;
    ((bzq)localObject).tPy = paramir1;
    ((bzq)localObject).tPz = paramir2;
    this.data = paramObject;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1357;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.a.x
 * JD-Core Version:    0.7.0.1
 */