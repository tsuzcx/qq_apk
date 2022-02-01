package com.tencent.mm.plugin.emoji.e;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.emoji.mgr.i;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.goh;
import com.tencent.mm.protocal.protobuf.goi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import java.io.IOException;

public class p
  extends com.tencent.mm.am.p
  implements m
{
  public static int xOO = 0;
  public static int xOP = 1;
  public static int xOQ = 1;
  public static int xOR = 2;
  public static int xOS = 256;
  private h callback;
  private final c rr;
  private String xNX;
  private int xOT;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(108712);
    c.a locala = new c.a();
    locala.otE = new goh();
    locala.otF = new goi();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
    locala.funcId = 822;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xNX = paramString;
    this.xOT = paramInt;
    AppMethodBeat.o(108712);
  }
  
  public final goi dAH()
  {
    AppMethodBeat.i(269842);
    goi localgoi = (goi)c.c.b(this.rr.otC);
    AppMethodBeat.o(269842);
    return localgoi;
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(108714);
    this.callback = paramh;
    paramh = (goh)c.b.b(this.rr.otB);
    paramh.ProductID = this.xNX;
    paramh.YIq = this.xOT;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108714);
    return i;
  }
  
  public int getType()
  {
    return 822;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108713);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (this.xOT == xOO)
      {
        params = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjA;
        paramArrayOfByte = this.xNX;
        localObject = dAH();
        if ((Util.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
          Log.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
      }
      else
      {
        if ((dAH() == null) || (dAH().aklh == null)) {
          break label286;
        }
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjC.iK(this.xNX, dAH().aklh.YFu);
        com.tencent.mm.plugin.emoji.model.s.dAp().ec(this.xNX, dAH().aklh.YFu);
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
          localn.field_content = ((goi)localObject).toByteArray();
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
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjC.iK(this.xNX, xOS);
      com.tencent.mm.plugin.emoji.model.s.dAp().ec(this.xNX, xOS);
      continue;
      if (paramInt3 == 1)
      {
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjC.iK(this.xNX, xOS);
        com.tencent.mm.plugin.emoji.model.s.dAp().ec(this.xNX, xOS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.p
 * JD-Core Version:    0.7.0.1
 */