package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.y;

public final class w
  extends m
  implements k
{
  public static int fgf = 0;
  public static int fgg = 1;
  public static int fgh = -85;
  private final b dmK;
  private f dmL;
  private int fgi = -1;
  private String fgj;
  private int fgk = 0;
  
  public w(w.a parama, String paramString, int paramInt)
  {
    switch (w.1.fgl[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.fgj = paramString;
      this.fgk = paramInt;
      parama = new b.a();
      parama.ecH = new hu();
      parama.ecI = new hv();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.ecG = 487;
      parama.ecJ = 0;
      parama.ecK = 0;
      this.dmK = parama.Kt();
      return;
      this.fgi = 1;
      continue;
      this.fgi = 2;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.dmL = paramf;
    paramf = (hu)this.dmK.ecE.ecN;
    paramf.syV = this.fgi;
    paramf.sAZ = this.fgj;
    paramf.sBa = this.fgk;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 487;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.w
 * JD-Core Version:    0.7.0.1
 */