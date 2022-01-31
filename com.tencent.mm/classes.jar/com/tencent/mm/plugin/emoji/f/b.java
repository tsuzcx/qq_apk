package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.DecimalFormat;

public final class b
  extends m
  implements k
{
  public static int lid = 6;
  public static int lie = 7;
  public static int lif = 10;
  private f eGj;
  private String lig;
  private EmotionPrice lih;
  private final com.tencent.mm.ai.b rr;
  
  public b(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(53093);
    b.a locala = new b.a();
    locala.fsX = new fq();
    locala.fsY = new fr();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lig = paramString;
    this.lih = paramEmotionPrice;
    AppMethodBeat.o(53093);
  }
  
  public final fr blz()
  {
    return (fr)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(53095);
    this.eGj = paramf;
    paramf = (fq)this.rr.fsV.fta;
    paramf.ProductID = this.lig;
    EmotionPrice localEmotionPrice = new EmotionPrice();
    localEmotionPrice.Label = this.lih.Label;
    localEmotionPrice.Type = this.lih.Type;
    localEmotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.lih.Number));
    paramf.wrG = localEmotionPrice;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53095);
    return i;
  }
  
  public final int getType()
  {
    return 830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53094);
    ab.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(53094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */