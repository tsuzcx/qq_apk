package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.DecimalFormat;

public final class b
  extends q
  implements m
{
  public static int rcn = 6;
  public static int rco = 7;
  public static int rcp = 10;
  private i heq;
  private String rcq;
  private EmotionPrice rcr;
  private final d rr;
  
  public b(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(108668);
    d.a locala = new d.a();
    locala.iLN = new hg();
    locala.iLO = new hh();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcq = paramString;
    this.rcr = paramEmotionPrice;
    AppMethodBeat.o(108668);
  }
  
  public final hh cGp()
  {
    return (hh)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108670);
    this.heq = parami;
    parami = (hg)this.rr.iLK.iLR;
    parami.ProductID = this.rcq;
    EmotionPrice localEmotionPrice = new EmotionPrice();
    localEmotionPrice.Label = this.rcr.Label;
    localEmotionPrice.Type = this.rcr.Type;
    localEmotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.rcr.Number));
    parami.KKQ = localEmotionPrice;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108670);
    return i;
  }
  
  public final int getType()
  {
    return 830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108669);
    Log.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */