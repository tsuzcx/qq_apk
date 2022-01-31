package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  private Runnable eAk;
  
  public a(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new wc();
    locala.ecI = new wd();
    locala.uri = "/cgi-bin/micromsg-bin/exittrackroom";
    locala.ecG = 491;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((wc)this.dmK.ecE.ecN).sTd = paramString;
    y.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:" + paramString);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.eAk != null) {
      this.eAk.run();
    }
  }
  
  public final int getType()
  {
    return 491;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */