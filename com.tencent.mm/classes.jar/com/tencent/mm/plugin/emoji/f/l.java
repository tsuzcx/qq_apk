package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.aw;

public class l
  extends n
  implements k
{
  private int cR;
  private com.tencent.mm.al.g callback;
  private int mScene;
  public String oyw;
  private final b rr;
  
  public l(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108699);
    this.oyw = paramString;
    this.mScene = paramInt1;
    this.cR = paramInt2;
    paramString = new b.a();
    paramString.gUU = new GetEmotionDetailRequest();
    paramString.gUV = new GetEmotionDetailResponse();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.funcId = 412;
    paramString.reqCmdId = 211;
    paramString.respCmdId = 1000000211;
    this.rr = paramString.atI();
    AppMethodBeat.o(108699);
  }
  
  public final EmotionDetail bVp()
  {
    AppMethodBeat.i(108702);
    new EmotionDetail();
    EmotionDetail localEmotionDetail = ((GetEmotionDetailResponse)this.rr.gUT.gUX).EmotionDetail;
    AppMethodBeat.o(108702);
    return localEmotionDetail;
  }
  
  public final GetEmotionDetailResponse bVq()
  {
    return (GetEmotionDetailResponse)this.rr.gUT.gUX;
  }
  
  public int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108700);
    ad.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.oyw, Integer.valueOf(this.mScene), Integer.valueOf(this.cR) });
    this.callback = paramg;
    paramg = (GetEmotionDetailRequest)this.rr.gUS.gUX;
    paramg.ProductID = this.oyw;
    paramg.Scene = this.mScene;
    paramg.Version = this.cR;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108700);
    return i;
  }
  
  public int getType()
  {
    return 412;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108701);
    ad.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt3 != 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108701);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiStorageMgr().Fzc.a(this.oyw, bVq(), ac.ir(aj.getContext()));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.l
 * JD-Core Version:    0.7.0.1
 */