package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.j;

public final class l
  extends m
  implements k
{
  private int cO;
  private f callback;
  public String liu;
  private int mScene;
  private final b rr;
  
  public l(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53127);
    this.liu = paramString;
    this.mScene = paramInt1;
    this.cO = paramInt2;
    paramString = new b.a();
    paramString.fsX = new GetEmotionDetailRequest();
    paramString.fsY = new GetEmotionDetailResponse();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.funcId = 412;
    paramString.reqCmdId = 211;
    paramString.respCmdId = 1000000211;
    this.rr = paramString.ado();
    AppMethodBeat.o(53127);
  }
  
  public final EmotionDetail blF()
  {
    AppMethodBeat.i(53130);
    new EmotionDetail();
    EmotionDetail localEmotionDetail = ((GetEmotionDetailResponse)this.rr.fsW.fta).EmotionDetail;
    AppMethodBeat.o(53130);
    return localEmotionDetail;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53128);
    ab.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.liu, Integer.valueOf(this.mScene), Integer.valueOf(this.cO) });
    this.callback = paramf;
    paramf = (GetEmotionDetailRequest)this.rr.fsV.fta;
    paramf.ProductID = this.liu;
    paramf.Scene = this.mScene;
    paramf.Version = this.cO;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53128);
    return i;
  }
  
  public final int getType()
  {
    return 412;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53129);
    ab.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt3 != 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53129);
      return;
    }
    Object localObject;
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)g.G(d.class)).getEmojiStorageMgr().yNr;
      paramArrayOfByte = this.liu;
      localObject = (GetEmotionDetailResponse)this.rr.fsW.fta;
      str = aa.gP(ah.getContext());
      if ((bo.isNullOrNil(paramArrayOfByte)) || (localObject == null)) {
        ab.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
      }
    }
    try
    {
      i locali = new i();
      locali.field_productID = paramArrayOfByte;
      locali.field_content = ((GetEmotionDetailResponse)localObject).toByteArray();
      locali.field_lan = str;
      localObject = locali.convertTo();
      if (paramq.db.replace("EmotionDetailInfo", "productID", (ContentValues)localObject) > 0L) {
        ab.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[] { paramArrayOfByte });
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(53129);
        return;
        ab.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[] { paramArrayOfByte });
      }
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ab.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[] { bo.l(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.l
 * JD-Core Version:    0.7.0.1
 */