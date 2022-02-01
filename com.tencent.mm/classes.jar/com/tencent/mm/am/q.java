package com.tencent.mm.am;

import com.tencent.mm.model.bj;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class q
  extends p
  implements m
{
  protected int ouk = 3;
  private boolean oul = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, s params);
  
  public abstract sc b(s params);
  
  public abstract void bFM();
  
  public abstract h bFN();
  
  public abstract dts c(s params);
  
  public abstract dal d(s params);
  
  public abstract int e(s params);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      Log.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.ouk) });
      if (params != null)
      {
        Log.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        bj.a(true, b(params), c(params), d(params), true, e(params));
      }
      this.ouk -= 1;
      if (this.ouk <= 0)
      {
        bFM();
        this.oul = false;
        return;
      }
      Log.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), bFN());
      return;
    }
    a(paramInt2, paramInt3, paramString, params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.q
 * JD-Core Version:    0.7.0.1
 */