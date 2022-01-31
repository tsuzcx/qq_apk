package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  public String ila;
  public int ilb = 0;
  public String ilc;
  public int ild;
  public String ile;
  public String ioJ;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new avw();
    ((b.a)localObject).ecI = new avx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((b.a)localObject).ecG = 907;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (avw)this.dmK.ecE.ecN;
    ((avw)localObject).bZc = paramString;
    ((avw)localObject).trs = paramInt2;
    ((avw)localObject).trr = paramInt1;
    ((avw)localObject).scene = paramInt3;
    this.ioJ = paramString;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(907), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (avx)this.dmK.ecF.ecN;
      y.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + paramq.inn);
      paramq = paramq.inn;
      if (!TextUtils.isEmpty(paramq)) {
        break label119;
      }
      y.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      try
      {
        label119:
        paramq = new JSONObject(paramq);
        this.ila = paramq.optString("mark_user");
        this.ilb = paramq.optInt("mark_succ", 0);
        this.ilc = paramq.optString("mark_card_id");
        this.ild = paramq.optInt("expire_time", 0);
        this.ile = paramq.optString("pay_qrcode_wording");
      }
      catch (JSONException paramq)
      {
        y.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", paramq, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 907;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.f
 * JD-Core Version:    0.7.0.1
 */