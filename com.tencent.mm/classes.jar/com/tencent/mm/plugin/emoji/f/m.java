package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bj;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private int cR;
  private i callback;
  private int mScene;
  public String rcD;
  private final com.tencent.mm.ak.d rr;
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108699);
    this.rcD = paramString;
    this.mScene = paramInt1;
    this.cR = paramInt2;
    paramString = new d.a();
    paramString.iLN = new GetEmotionDetailRequest();
    paramString.iLO = new GetEmotionDetailResponse();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.funcId = 412;
    paramString.iLP = 211;
    paramString.respCmdId = 1000000211;
    this.rr = paramString.aXF();
    AppMethodBeat.o(108699);
  }
  
  public final EmotionDetail cGv()
  {
    AppMethodBeat.i(108702);
    new EmotionDetail();
    EmotionDetail localEmotionDetail = ((GetEmotionDetailResponse)this.rr.iLL.iLR).EmotionDetail;
    AppMethodBeat.o(108702);
    return localEmotionDetail;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(108700);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.rcD, Integer.valueOf(this.mScene), Integer.valueOf(this.cR) });
    this.callback = parami;
    parami = (GetEmotionDetailRequest)this.rr.iLK.iLR;
    parami.ProductID = this.rcD;
    parami.Scene = this.mScene;
    parami.Version = this.cR;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108700);
    return i;
  }
  
  public final int getType()
  {
    return 412;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108701);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt3 != 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108701);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpR.a(this.rcD, (GetEmotionDetailResponse)this.rr.iLL.iLR, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */