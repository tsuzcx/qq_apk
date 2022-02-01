package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ae;
import java.text.DecimalFormat;

public final class b
  extends n
  implements k
{
  public static int pLU = 6;
  public static int pLV = 7;
  public static int pLW = 10;
  private f gCo;
  private String pLX;
  private EmotionPrice pLY;
  private final com.tencent.mm.ak.b rr;
  
  public b(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(108668);
    b.a locala = new b.a();
    locala.hQF = new gt();
    locala.hQG = new gu();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pLX = paramString;
    this.pLY = paramEmotionPrice;
    AppMethodBeat.o(108668);
  }
  
  public final gu ciq()
  {
    return (gu)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108670);
    this.gCo = paramf;
    paramf = (gt)this.rr.hQD.hQJ;
    paramf.ProductID = this.pLX;
    EmotionPrice localEmotionPrice = new EmotionPrice();
    localEmotionPrice.Label = this.pLY.Label;
    localEmotionPrice.Type = this.pLY.Type;
    localEmotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.pLY.Number));
    paramf.FRj = localEmotionPrice;
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
    ae.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */