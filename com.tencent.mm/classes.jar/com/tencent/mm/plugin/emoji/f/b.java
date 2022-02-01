package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.DecimalFormat;

public final class b
  extends n
  implements k
{
  public static int pFq = 6;
  public static int pFr = 7;
  public static int pFs = 10;
  private f gzH;
  private String pFt;
  private EmotionPrice pFu;
  private final com.tencent.mm.al.b rr;
  
  public b(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(108668);
    b.a locala = new b.a();
    locala.hNM = new gt();
    locala.hNN = new gu();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFt = paramString;
    this.pFu = paramEmotionPrice;
    AppMethodBeat.o(108668);
  }
  
  public final gu cha()
  {
    return (gu)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108670);
    this.gzH = paramf;
    paramf = (gt)this.rr.hNK.hNQ;
    paramf.ProductID = this.pFt;
    EmotionPrice localEmotionPrice = new EmotionPrice();
    localEmotionPrice.Label = this.pFu.Label;
    localEmotionPrice.Type = this.pFu.Type;
    localEmotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.pFu.Number));
    paramf.FyL = localEmotionPrice;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108670);
    return i;
  }
  
  public final int getType()
  {
    return 830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108669);
    ad.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */