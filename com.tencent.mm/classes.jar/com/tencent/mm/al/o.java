package com.tencent.mm.al;

import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class o
  extends n
  implements k
{
  protected int gVE = 3;
  private boolean gVF = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract void auO();
  
  public abstract g auP();
  
  public abstract oj b(q paramq);
  
  public abstract bsu c(q paramq);
  
  public abstract bgp d(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ad.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.gVE) });
      if (paramq != null)
      {
        ad.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        ba.a(true, b(paramq), c(paramq), d(paramq));
      }
      this.gVE -= 1;
      if (this.gVE <= 0)
      {
        auO();
        this.gVF = false;
        return;
      }
      ad.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), auP());
      return;
    }
    a(paramInt2, paramInt3, paramString, paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.o
 * JD-Core Version:    0.7.0.1
 */