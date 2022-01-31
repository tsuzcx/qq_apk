package com.tencent.mm.ah;

import com.tencent.mm.model.av;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.sdk.platformtools.y;

public abstract class n
  extends m
  implements k
{
  protected int edu = 3;
  private boolean edv = false;
  
  public abstract void KD();
  
  public abstract f KE();
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      y.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.edu) });
      if (paramq != null)
      {
        y.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        av.a(true, c(paramq), d(paramq), e(paramq));
      }
      this.edu -= 1;
      if (this.edu <= 0)
      {
        KD();
        this.edv = false;
        return;
      }
      y.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      a(this.edc, KE());
      return;
    }
    a(paramInt2, paramInt3, paramString, paramq);
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract jv c(q paramq);
  
  public abstract ays d(q paramq);
  
  public abstract apl e(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ah.n
 * JD-Core Version:    0.7.0.1
 */