package com.tencent.mm.ak;

import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class o
  extends n
  implements k
{
  protected int hwd = 3;
  private boolean hwe = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract void aBH();
  
  public abstract g aBI();
  
  public abstract oq b(q paramq);
  
  public abstract bxl c(q paramq);
  
  public abstract bkh d(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ac.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.hwd) });
      if (paramq != null)
      {
        ac.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        ba.a(true, b(paramq), c(paramq), d(paramq));
      }
      this.hwd -= 1;
      if (this.hwd <= 0)
      {
        aBH();
        this.hwe = false;
        return;
      }
      ac.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), aBI());
      return;
    }
    a(paramInt2, paramInt3, paramString, paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.o
 * JD-Core Version:    0.7.0.1
 */