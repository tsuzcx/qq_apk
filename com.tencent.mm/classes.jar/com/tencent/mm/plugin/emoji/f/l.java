package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.m;

public class l
  extends n
  implements k
{
  private int cR;
  private f callback;
  private int mScene;
  public String pMk;
  private final b rr;
  
  public l(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108699);
    this.pMk = paramString;
    this.mScene = paramInt1;
    this.cR = paramInt2;
    paramString = new b.a();
    paramString.hQF = new GetEmotionDetailRequest();
    paramString.hQG = new GetEmotionDetailResponse();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.funcId = 412;
    paramString.hQH = 211;
    paramString.respCmdId = 1000000211;
    this.rr = paramString.aDS();
    AppMethodBeat.o(108699);
  }
  
  public final EmotionDetail ciw()
  {
    AppMethodBeat.i(108702);
    new EmotionDetail();
    EmotionDetail localEmotionDetail = ((GetEmotionDetailResponse)this.rr.hQE.hQJ).EmotionDetail;
    AppMethodBeat.o(108702);
    return localEmotionDetail;
  }
  
  public final GetEmotionDetailResponse cix()
  {
    return (GetEmotionDetailResponse)this.rr.hQE.hQJ;
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108700);
    ae.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.pMk, Integer.valueOf(this.mScene), Integer.valueOf(this.cR) });
    this.callback = paramf;
    paramf = (GetEmotionDetailRequest)this.rr.hQD.hQJ;
    paramf.ProductID = this.pMk;
    paramf.Scene = this.mScene;
    paramf.Version = this.cR;
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
    ae.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt3 != 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108701);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ((d)g.ad(d.class)).getEmojiStorageMgr().JfY.a(this.pMk, cix(), ad.iR(ak.getContext()));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.l
 * JD-Core Version:    0.7.0.1
 */