package com.tencent.mm.ak;

import com.tencent.mm.model.bd;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class o
  extends n
  implements k
{
  protected int hRl = 3;
  private boolean hRm = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract void aFa();
  
  public abstract f aFb();
  
  public abstract px b(q paramq);
  
  public abstract ccw c(q paramq);
  
  public abstract bpj d(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ae.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.hRl) });
      if (paramq != null)
      {
        ae.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        bd.a(true, b(paramq), c(paramq), d(paramq));
      }
      this.hRl -= 1;
      if (this.hRl <= 0)
      {
        aFa();
        this.hRm = false;
        return;
      }
      ae.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), aFb());
      return;
    }
    a(paramInt2, paramInt3, paramString, paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.o
 * JD-Core Version:    0.7.0.1
 */