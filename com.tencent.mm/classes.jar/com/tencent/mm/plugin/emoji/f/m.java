package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.j;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private final b dmK;
  private f dmL;
  private int fzn;
  public String iZD;
  private int mVersion;
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    this.iZD = paramString;
    this.fzn = paramInt1;
    this.mVersion = paramInt2;
    paramString = new b.a();
    paramString.ecH = new afd();
    paramString.ecI = new afe();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.ecG = 412;
    paramString.ecJ = 211;
    paramString.ecK = 1000000211;
    this.dmK = paramString.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.iZD, Integer.valueOf(this.fzn), Integer.valueOf(this.mVersion) });
    this.dmL = paramf;
    paramf = (afd)this.dmK.ecE.ecN;
    paramf.syc = this.iZD;
    paramf.pyo = this.fzn;
    paramf.hQQ = this.mVersion;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt3 != 5))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    Object localObject;
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)g.t(d.class)).getEmojiStorageMgr().uBf;
      paramArrayOfByte = this.iZD;
      localObject = (afe)this.dmK.ecF.ecN;
      str = x.fB(ae.getContext());
      if ((bk.bl(paramArrayOfByte)) || (localObject == null)) {
        y.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
      }
    }
    try
    {
      i locali = new i();
      locali.field_productID = paramArrayOfByte;
      locali.field_content = ((afe)localObject).toByteArray();
      locali.field_lan = str;
      localObject = locali.vf();
      if (paramq.dXw.replace("EmotionDetailInfo", "productID", (ContentValues)localObject) > 0L) {
        y.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        y.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      }
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        y.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bk.j(paramq) });
      }
    }
  }
  
  public final vj aIg()
  {
    new vj();
    return ((afe)this.dmK.ecF.ecN).tcV;
  }
  
  public final int getType()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */