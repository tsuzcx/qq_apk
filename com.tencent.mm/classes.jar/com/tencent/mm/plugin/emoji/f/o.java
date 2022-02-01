package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.p;
import java.io.IOException;

public class o
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static int oyW = 0;
  public static int oyX = 1;
  public static int oyY = 1;
  public static int oyZ = 2;
  public static int oza = 256;
  private g callback;
  private String oyj;
  private int ozb;
  private final b rr;
  
  public o(String paramString, int paramInt)
  {
    AppMethodBeat.i(108712);
    b.a locala = new b.a();
    locala.gUU = new GetEmotionRewardRequest();
    locala.gUV = new GetEmotionRewardResponse();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyj = paramString;
    this.ozb = paramInt;
    AppMethodBeat.o(108712);
  }
  
  public final GetEmotionRewardResponse bVu()
  {
    return (GetEmotionRewardResponse)this.rr.gUT.gUX;
  }
  
  public int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(108714);
    this.callback = paramg;
    paramg = (GetEmotionRewardRequest)this.rr.gUS.gUX;
    paramg.ProductID = this.oyj;
    paramg.OpCode = this.ozb;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108714);
    return i;
  }
  
  public int getType()
  {
    return 822;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108713);
    ad.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.ozb == oyW)
      {
        paramq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzd;
        paramArrayOfByte = this.oyj;
        localObject = bVu();
        if ((bt.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          ad.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((bVu() == null) || (bVu().Reward == null)) {
          break label285;
        }
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzf.fR(this.oyj, bVu().Reward.Cxm);
        com.tencent.mm.plugin.emoji.model.k.bVd().cO(this.oyj, bVu().Reward.Cxm);
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108713);
        return;
        try
        {
          m localm = new m();
          localm.field_productID = paramArrayOfByte;
          localm.field_content = ((GetEmotionRewardResponse)localObject).toByteArray();
          localObject = localm.convertTo();
          if (paramq.db.replace("EmotionRewardInfo", "productID", (ContentValues)localObject) <= 0L) {
            break label266;
          }
          ad.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
        }
        catch (IOException paramq)
        {
          ad.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bt.m(paramq) });
        }
      }
      break;
      label266:
      ad.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      break;
      label285:
      ad.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzf.fR(this.oyj, oza);
      com.tencent.mm.plugin.emoji.model.k.bVd().cO(this.oyj, oza);
      continue;
      if (paramInt3 == 1)
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzf.fR(this.oyj, oza);
        com.tencent.mm.plugin.emoji.model.k.bVd().cO(this.oyj, oza);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */