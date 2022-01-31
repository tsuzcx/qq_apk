package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.bmk;

public final class e
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public byte[] hOL;
  private final String id;
  
  public e(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new abs();
    ((b.a)localObject).ecI = new abt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    ((b.a)localObject).ecG = 596;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (abs)this.dmK.ecE.ecN;
    ((abs)localObject).ID = paramString;
    ((abs)localObject).taV = com.tencent.mm.protocal.y.cpj().ver;
    this.id = paramString;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((abs)localObject).ID, Integer.valueOf(((abs)localObject).taV) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.hOL = ((abt)this.dmK.ecF.ecN).syK.tFM.oY;
      paramq = this.id;
      if (this.hOL == null) {}
      for (paramInt1 = 0;; paramInt1 = this.hOL.length)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { paramq, Integer.valueOf(paramInt1) });
        if (this.hOL == null) {
          break label191;
        }
        paramArrayOfByte = this.hOL;
        paramq = "";
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.length)
        {
          paramq = paramq + Integer.toHexString(paramArrayOfByte[paramInt1] & 0xFF) + " ";
          paramInt1 += 1;
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[] { paramq });
    }
    label191:
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final void cancel()
  {
    super.cancel();
  }
  
  public final int getType()
  {
    return 596;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.e
 * JD-Core Version:    0.7.0.1
 */