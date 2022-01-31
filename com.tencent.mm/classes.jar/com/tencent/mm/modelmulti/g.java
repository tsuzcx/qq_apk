package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.bzd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.i.a;
import org.c.d.i;

public final class g
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  private int esw = 0;
  
  public g(int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bfc();
    ((b.a)localObject).ecI = new bfd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((b.a)localObject).ecG = 1804;
    this.dmK = ((b.a)localObject).Kt();
    bfc localbfc = (bfc)this.dmK.ecE.ecN;
    localbfc.ten = paramInt;
    localbfc.tep = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new bzd();
      if (locala.wih == null) {
        break label173;
      }
      paramString = (String)localObject;
      if (!bk.bl(locala.wih.token))
      {
        ((bzd)localObject).tPj = locala.wih.token;
        ((bzd)localObject).tPk = locala.wih.tsv;
      }
    }
    label173:
    for (paramString = (String)localObject;; paramString = null)
    {
      localbfc.tzP = paramString;
      this.esw = paramInt;
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1804;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */