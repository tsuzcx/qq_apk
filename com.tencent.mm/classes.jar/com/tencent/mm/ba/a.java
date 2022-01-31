package com.tencent.mm.ba;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.ajk;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL = null;
  public String exc = null;
  public String exd = null;
  public byte[] exe = null;
  
  public a()
  {
    this(com.tencent.mm.model.q.Gj(), bk.g((Integer)g.DP().Dz().get(66561, null)), 0);
  }
  
  public a(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ajk();
    ((b.a)localObject).ecI = new ajl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).ecG = 168;
    ((b.a)localObject).ecJ = 67;
    ((b.a)localObject).ecK = 1000000067;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ajk)this.dmK.ecE.ecN;
    ((ajk)localObject).sQs = aa.pj(paramString);
    ((ajk)localObject).tga = paramInt1;
    ((ajk)localObject).ssq = paramInt2;
    y.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (ajk)this.dmK.ecE.ecN;
      paramq = (ajl)this.dmK.ecF.ecN;
      paramArrayOfByte = aa.a(paramArrayOfByte.sQs);
      this.exe = aa.a(paramq.tgb, new byte[0]);
      this.exc = paramq.tgc;
      y.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.exc, paramq.tgd, paramq.tge });
      if (com.tencent.mm.model.q.Gj().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramq.tgd;
        String str = (String)g.DP().Dz().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          g.DP().Dz().o(66563, paramArrayOfByte);
          this.exd = paramq.tge;
        }
        g.DP().Dz().o(66561, Integer.valueOf(paramq.tga));
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 168;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */