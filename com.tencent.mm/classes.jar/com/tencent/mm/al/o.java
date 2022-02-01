package com.tencent.mm.al;

import com.tencent.mm.model.bb;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class o
  extends n
  implements k
{
  protected int hOs = 3;
  private boolean hOt = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract void aEK();
  
  public abstract f aEL();
  
  public abstract pv b(q paramq);
  
  public abstract ccc c(q paramq);
  
  public abstract bor d(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ad.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.hOs) });
      if (paramq != null)
      {
        ad.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        bb.a(true, b(paramq), c(paramq), d(paramq));
      }
      this.hOs -= 1;
      if (this.hOs <= 0)
      {
        aEK();
        this.hOt = false;
        return;
      }
      ad.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), aEL());
      return;
    }
    a(paramInt2, paramInt3, paramString, paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.o
 * JD-Core Version:    0.7.0.1
 */