package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.n;
import java.io.IOException;

public final class o
  extends m
  implements com.tencent.mm.network.k
{
  public static int liS = 0;
  public static int liT = 1;
  public static int liU = 1;
  public static int liV = 2;
  public static int liW = 256;
  private f callback;
  private int liX;
  private String lig;
  private final b rr;
  
  public o(String paramString, int paramInt)
  {
    AppMethodBeat.i(53140);
    b.a locala = new b.a();
    locala.fsX = new GetEmotionRewardRequest();
    locala.fsY = new GetEmotionRewardResponse();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lig = paramString;
    this.liX = paramInt;
    AppMethodBeat.o(53140);
  }
  
  public final GetEmotionRewardResponse blJ()
  {
    return (GetEmotionRewardResponse)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53142);
    this.callback = paramf;
    paramf = (GetEmotionRewardRequest)this.rr.fsV.fta;
    paramf.ProductID = this.lig;
    paramf.OpCode = this.liX;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53142);
    return i;
  }
  
  public final int getType()
  {
    return 822;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53141);
    ab.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.liX == liS)
      {
        paramq = i.getEmojiStorageMgr().yNs;
        paramArrayOfByte = this.lig;
        localObject = blJ();
        if ((bo.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          ab.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((blJ() == null) || (blJ().Reward == null)) {
          break label285;
        }
        i.getEmojiStorageMgr().yNu.eI(this.lig, blJ().Reward.woE);
        i.blt().cc(this.lig, blJ().Reward.woE);
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(53141);
        return;
        try
        {
          com.tencent.mm.storage.emotion.k localk = new com.tencent.mm.storage.emotion.k();
          localk.field_productID = paramArrayOfByte;
          localk.field_content = ((GetEmotionRewardResponse)localObject).toByteArray();
          localObject = localk.convertTo();
          if (paramq.db.replace("EmotionRewardInfo", "productID", (ContentValues)localObject) <= 0L) {
            break label266;
          }
          ab.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
        }
        catch (IOException paramq)
        {
          ab.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bo.l(paramq) });
        }
      }
      break;
      label266:
      ab.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      break;
      label285:
      ab.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      i.getEmojiStorageMgr().yNu.eI(this.lig, liW);
      i.blt().cc(this.lig, liW);
      continue;
      if (paramInt3 == 1)
      {
        i.getEmojiStorageMgr().yNu.eI(this.lig, liW);
        i.blt().cc(this.lig, liW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */