package com.tencent.mm.ak;

import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class r
  extends q
  implements m
{
  protected int iMt = 3;
  private boolean iMu = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, s params);
  
  public abstract void aYP();
  
  public abstract i aYQ();
  
  public abstract qy b(s params);
  
  public abstract ctb c(s params);
  
  public abstract ccb d(s params);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      Log.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.iMt) });
      if (params != null)
      {
        Log.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        bh.a(true, b(params), c(params), d(params));
      }
      this.iMt -= 1;
      if (this.iMt <= 0)
      {
        aYP();
        this.iMu = false;
        return;
      }
      Log.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), aYQ());
      return;
    }
    a(paramInt2, paramInt3, paramString, params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.r
 * JD-Core Version:    0.7.0.1
 */