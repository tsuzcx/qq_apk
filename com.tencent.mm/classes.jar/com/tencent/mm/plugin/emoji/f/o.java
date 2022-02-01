package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import java.io.IOException;

public class o
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static int pcA = 256;
  public static int pcw = 0;
  public static int pcx = 1;
  public static int pcy = 1;
  public static int pcz = 2;
  private g callback;
  private String pbJ;
  private int pcB;
  private final b rr;
  
  public o(String paramString, int paramInt)
  {
    AppMethodBeat.i(108712);
    b.a locala = new b.a();
    locala.hvt = new GetEmotionRewardRequest();
    locala.hvu = new GetEmotionRewardResponse();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pbJ = paramString;
    this.pcB = paramInt;
    AppMethodBeat.o(108712);
  }
  
  public final GetEmotionRewardResponse ccH()
  {
    return (GetEmotionRewardResponse)this.rr.hvs.hvw;
  }
  
  public int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(108714);
    this.callback = paramg;
    paramg = (GetEmotionRewardRequest)this.rr.hvr.hvw;
    paramg.ProductID = this.pbJ;
    paramg.OpCode = this.pcB;
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
    ac.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.pcB == pcw)
      {
        paramq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYe;
        paramArrayOfByte = this.pbJ;
        localObject = ccH();
        if ((bs.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          ac.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((ccH() == null) || (ccH().Reward == null)) {
          break label285;
        }
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYg.fV(this.pbJ, ccH().Reward.DPI);
        com.tencent.mm.plugin.emoji.model.k.ccq().cT(this.pbJ, ccH().Reward.DPI);
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
          ac.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
        }
        catch (IOException paramq)
        {
          ac.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bs.m(paramq) });
        }
      }
      break;
      label266:
      ac.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      break;
      label285:
      ac.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYg.fV(this.pbJ, pcA);
      com.tencent.mm.plugin.emoji.model.k.ccq().cT(this.pbJ, pcA);
      continue;
      if (paramInt3 == 1)
      {
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYg.fV(this.pbJ, pcA);
        com.tencent.mm.plugin.emoji.model.k.ccq().cT(this.pbJ, pcA);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */