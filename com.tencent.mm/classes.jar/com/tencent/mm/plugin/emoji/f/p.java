package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.o;
import java.io.IOException;

public final class p
  extends com.tencent.mm.ak.q
  implements m
{
  public static int rde = 0;
  public static int rdf = 1;
  public static int rdg = 1;
  public static int rdh = 2;
  public static int rdi = 256;
  private com.tencent.mm.ak.i callback;
  private String rcq;
  private int rdj;
  private final d rr;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(108712);
    d.a locala = new d.a();
    locala.iLN = new GetEmotionRewardRequest();
    locala.iLO = new GetEmotionRewardResponse();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcq = paramString;
    this.rdj = paramInt;
    AppMethodBeat.o(108712);
  }
  
  public final GetEmotionRewardResponse cGz()
  {
    return (GetEmotionRewardResponse)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(108714);
    this.callback = parami;
    parami = (GetEmotionRewardRequest)this.rr.iLK.iLR;
    parami.ProductID = this.rcq;
    parami.OpCode = this.rdj;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108714);
    return i;
  }
  
  public final int getType()
  {
    return 822;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108713);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.rdj == rde)
      {
        params = k.getEmojiStorageMgr().OpS;
        paramArrayOfByte = this.rcq;
        localObject = cGz();
        if ((Util.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          Log.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((cGz() == null) || (cGz().Reward == null)) {
          break label285;
        }
        k.getEmojiStorageMgr().OpU.gU(this.rcq, cGz().Reward.KHa);
        k.cGj().dg(this.rcq, cGz().Reward.KHa);
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
          n localn = new n();
          localn.field_productID = paramArrayOfByte;
          localn.field_content = ((GetEmotionRewardResponse)localObject).toByteArray();
          localObject = localn.convertTo();
          if (params.db.replace("EmotionRewardInfo", "productID", (ContentValues)localObject) <= 0L) {
            break label266;
          }
          Log.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
        }
        catch (IOException params)
        {
          Log.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { Util.stackTraceToString(params) });
        }
      }
      break;
      label266:
      Log.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      break;
      label285:
      Log.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      k.getEmojiStorageMgr().OpU.gU(this.rcq, rdi);
      k.cGj().dg(this.rcq, rdi);
      continue;
      if (paramInt3 == 1)
      {
        k.getEmojiStorageMgr().OpU.gU(this.rcq, rdi);
        k.cGj().dg(this.rcq, rdi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */