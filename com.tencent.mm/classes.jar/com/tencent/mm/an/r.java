package com.tencent.mm.an;

import com.tencent.mm.model.bi;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class r
  extends q
  implements m
{
  protected int lCA = 3;
  private boolean lCB = false;
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, s params);
  
  public abstract qr b(s params);
  
  public abstract void bie();
  
  public abstract i bif();
  
  public abstract dca c(s params);
  
  public abstract cke d(s params);
  
  public abstract int e(s params);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      Log.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[] { Integer.valueOf(this.lCA) });
      if (params != null)
      {
        Log.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
        bi.a(true, b(params), c(params), d(params), true, e(params));
      }
      this.lCA -= 1;
      if (this.lCA <= 0)
      {
        bie();
        this.lCB = false;
        return;
      }
      Log.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
      doScene(dispatcher(), bif());
      return;
    }
    a(paramInt2, paramInt3, paramString, params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.r
 * JD-Core Version:    0.7.0.1
 */