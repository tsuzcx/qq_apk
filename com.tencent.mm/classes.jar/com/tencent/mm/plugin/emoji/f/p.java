package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.n;
import java.io.IOException;

public final class p
  extends m
  implements com.tencent.mm.network.k
{
  public static int jab = 0;
  public static int jac = 1;
  public static int jad = 1;
  public static int jae = 2;
  public static int jaf = 256;
  private final b dmK;
  private f dmL;
  private String iZs;
  private int jag;
  
  public p(String paramString, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new afj();
    locala.ecI = new afk();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.ecG = 822;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZs = paramString;
    this.jag = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (afj)this.dmK.ecE.ecN;
    paramf.syc = this.iZs;
    paramf.ssq = this.jag;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.jag == jab)
      {
        paramq = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBg;
        paramArrayOfByte = this.iZs;
        localObject = aIk();
        if ((bk.bl(paramArrayOfByte)) || (localObject == null)) {
          y.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((aIk() == null) || (aIk().tdo == null)) {
          break label275;
        }
        com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.dz(this.iZs, aIk().tdo.svx);
        com.tencent.mm.plugin.emoji.model.i.aHT().bw(this.iZs, aIk().tdo.svx);
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        try
        {
          com.tencent.mm.storage.emotion.k localk = new com.tencent.mm.storage.emotion.k();
          localk.field_productID = paramArrayOfByte;
          localk.field_content = ((afk)localObject).toByteArray();
          localObject = localk.vf();
          if (paramq.dXw.replace("EmotionRewardInfo", "productID", (ContentValues)localObject) <= 0L) {
            break label256;
          }
          y.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
        }
        catch (IOException paramq)
        {
          y.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bk.j(paramq) });
        }
      }
      break;
      label256:
      y.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      break;
      label275:
      y.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.dz(this.iZs, jaf);
      com.tencent.mm.plugin.emoji.model.i.aHT().bw(this.iZs, jaf);
      continue;
      if (paramInt3 == 1)
      {
        com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.dz(this.iZs, jaf);
        com.tencent.mm.plugin.emoji.model.i.aHT().bw(this.iZs, jaf);
      }
    }
  }
  
  public final afk aIk()
  {
    return (afk)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */