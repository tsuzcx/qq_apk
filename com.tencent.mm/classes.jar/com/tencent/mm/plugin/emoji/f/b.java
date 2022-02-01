package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.sdk.platformtools.ac;
import java.text.DecimalFormat;

public final class b
  extends n
  implements k
{
  public static int pbG = 6;
  public static int pbH = 7;
  public static int pbI = 10;
  private g gfX;
  private String pbJ;
  private EmotionPrice pbK;
  private final com.tencent.mm.ak.b rr;
  
  public b(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(108668);
    b.a locala = new b.a();
    locala.hvt = new gm();
    locala.hvu = new gn();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pbJ = paramString;
    this.pbK = paramEmotionPrice;
    AppMethodBeat.o(108668);
  }
  
  public final gn ccw()
  {
    return (gn)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108670);
    this.gfX = paramg;
    paramg = (gm)this.rr.hvr.hvw;
    paramg.ProductID = this.pbJ;
    EmotionPrice localEmotionPrice = new EmotionPrice();
    localEmotionPrice.Label = this.pbK.Label;
    localEmotionPrice.Type = this.pbK.Type;
    localEmotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.pbK.Number));
    paramg.DTs = localEmotionPrice;
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
    ac.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */