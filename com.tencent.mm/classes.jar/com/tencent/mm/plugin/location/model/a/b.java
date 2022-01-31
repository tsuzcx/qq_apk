package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  public String aox;
  public final com.tencent.mm.ah.b dmK;
  private f dmL;
  private Runnable eAk;
  public int errCode;
  public int errType;
  public String gfH;
  public String lCH = "";
  
  public b(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new asf();
    locala.ecI = new asg();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.ecG = 490;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((asf)this.dmK.ecE.ecN).toj = paramString;
    y.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:" + paramString);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.aox = paramString;
    if (((com.tencent.mm.ah.b)paramq).ecF.ecN != null) {}
    for (paramq = (asg)((com.tencent.mm.ah.b)paramq).ecF.ecN;; paramq = null)
    {
      y.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (paramq != null))
      {
        this.lCH = paramq.sTd;
        y.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.lCH });
      }
      if (paramq != null) {
        this.gfH = paramq.sHj;
      }
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.eAk != null) {
        this.eAk.run();
      }
      return;
    }
  }
  
  public final int getType()
  {
    return 490;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.b
 * JD-Core Version:    0.7.0.1
 */