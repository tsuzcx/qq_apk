package com.tencent.mm.ai;

import com.tencent.mm.model.ax;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class n
  extends m
  implements k
{
  protected int ftx = 3;
  private boolean fty = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract void adq();
  
  public abstract f adr();
  
  public abstract mg b(q paramq);
  
  public abstract bft c(q paramq);
  
  public abstract avk d(q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      ab.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.ftx) });
      if (paramq != null)
      {
        ab.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        ax.a(true, b(paramq), c(paramq), d(paramq));
      }
      this.ftx -= 1;
      if (this.ftx <= 0)
      {
        adq();
        this.fty = false;
        return;
      }
      ab.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), adr());
      return;
    }
    a(paramInt2, paramInt3, paramString, paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.n
 * JD-Core Version:    0.7.0.1
 */