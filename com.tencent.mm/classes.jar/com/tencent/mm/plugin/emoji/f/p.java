package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.o;
import java.io.IOException;

public final class p
  extends com.tencent.mm.an.q
  implements m
{
  public static int uGk = 0;
  public static int uGl = 1;
  public static int uGm = 1;
  public static int uGn = 2;
  public static int uGo = 256;
  private com.tencent.mm.an.i callback;
  private final d rr;
  private String uFv;
  private int uGp;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(108712);
    d.a locala = new d.a();
    locala.lBU = new bui();
    locala.lBV = new buj();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uFv = paramString;
    this.uGp = paramInt;
    AppMethodBeat.o(108712);
  }
  
  public final buj cVi()
  {
    AppMethodBeat.i(256917);
    buj localbuj = (buj)d.c.b(this.rr.lBS);
    AppMethodBeat.o(256917);
    return localbuj;
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(108714);
    this.callback = parami;
    parami = (bui)d.b.b(this.rr.lBR);
    parami.ProductID = this.uFv;
    parami.RLe = this.uGp;
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
      if (this.uGp == uGk)
      {
        params = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFM;
        paramArrayOfByte = this.uFv;
        localObject = cVi();
        if ((Util.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          Log.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((cVi() == null) || (cVi().VIh == null)) {
          break label286;
        }
        com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFO.hD(this.uFv, cVi().VIh.RIs);
        com.tencent.mm.plugin.emoji.model.p.cUS().dB(this.uFv, cVi().VIh.RIs);
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
          localn.field_content = ((buj)localObject).toByteArray();
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
      label286:
      Log.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFO.hD(this.uFv, uGo);
      com.tencent.mm.plugin.emoji.model.p.cUS().dB(this.uFv, uGo);
      continue;
      if (paramInt3 == 1)
      {
        com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFO.hD(this.uFv, uGo);
        com.tencent.mm.plugin.emoji.model.p.cUS().dB(this.uFv, uGo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */