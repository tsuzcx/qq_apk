package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adm;
import com.tencent.mm.protocal.c.adn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class ac
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public LinkedList<String> ijX;
  public int ijZ;
  public int ika;
  public int ikb;
  
  public ac(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new adm();
    locala.ecI = new adn();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.ecG = 577;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((adm)this.dmK.ecE.ecN).bZc = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (adn)this.dmK.ecF.ecN;
      this.ijX = paramq.ijX;
      this.ijZ = paramq.ijZ;
      this.ika = paramq.ika;
      this.ikb = paramq.ikb;
    }
    y.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.ijZ), Integer.valueOf(this.ika), Integer.valueOf(this.ikb) });
    if (this.ijX != null) {
      y.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.ijX.size());
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 577;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */