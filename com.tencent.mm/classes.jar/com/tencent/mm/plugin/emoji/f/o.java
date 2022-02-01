package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import java.io.IOException;

public class o
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static int pMK = 0;
  public static int pML = 1;
  public static int pMM = 1;
  public static int pMN = 2;
  public static int pMO = 256;
  private f callback;
  private String pLX;
  private int pMP;
  private final b rr;
  
  public o(String paramString, int paramInt)
  {
    AppMethodBeat.i(108712);
    b.a locala = new b.a();
    locala.hQF = new GetEmotionRewardRequest();
    locala.hQG = new GetEmotionRewardResponse();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pLX = paramString;
    this.pMP = paramInt;
    AppMethodBeat.o(108712);
  }
  
  public final GetEmotionRewardResponse ciB()
  {
    return (GetEmotionRewardResponse)this.rr.hQE.hQJ;
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108714);
    this.callback = paramf;
    paramf = (GetEmotionRewardRequest)this.rr.hQD.hQJ;
    paramf.ProductID = this.pLX;
    paramf.OpCode = this.pMP;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108714);
    return i;
  }
  
  public int getType()
  {
    return 822;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108713);
    ae.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.pMP == pMK)
      {
        paramq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfZ;
        paramArrayOfByte = this.pLX;
        localObject = ciB();
        if ((bu.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          ae.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((ciB() == null) || (ciB().Reward == null)) {
          break label285;
        }
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jgb.gB(this.pLX, ciB().Reward.FNv);
        com.tencent.mm.plugin.emoji.model.k.cik().da(this.pLX, ciB().Reward.FNv);
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
          com.tencent.mm.storage.emotion.n localn = new com.tencent.mm.storage.emotion.n();
          localn.field_productID = paramArrayOfByte;
          localn.field_content = ((GetEmotionRewardResponse)localObject).toByteArray();
          localObject = localn.convertTo();
          if (paramq.db.replace("EmotionRewardInfo", "productID", (ContentValues)localObject) <= 0L) {
            break label266;
          }
          ae.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
        }
        catch (IOException paramq)
        {
          ae.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bu.o(paramq) });
        }
      }
      break;
      label266:
      ae.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      break;
      label285:
      ae.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jgb.gB(this.pLX, pMO);
      com.tencent.mm.plugin.emoji.model.k.cik().da(this.pLX, pMO);
      continue;
      if (paramInt3 == 1)
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jgb.gB(this.pLX, pMO);
        com.tencent.mm.plugin.emoji.model.k.cik().da(this.pLX, pMO);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */