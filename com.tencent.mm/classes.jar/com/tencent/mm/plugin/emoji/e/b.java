package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.DecimalFormat;

public final class b
  extends p
  implements m
{
  public static int xNU = 6;
  public static int xNV = 7;
  public static int xNW = 10;
  private h mAY;
  private final c rr;
  private String xNX;
  private ciy xNY;
  
  public b(String paramString, ciy paramciy)
  {
    AppMethodBeat.i(108668);
    c.a locala = new c.a();
    locala.otE = new hn();
    locala.otF = new ho();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xNX = paramString;
    this.xNY = paramciy;
    AppMethodBeat.o(108668);
  }
  
  public final ho dAx()
  {
    AppMethodBeat.i(269834);
    ho localho = (ho)c.c.b(this.rr.otC);
    AppMethodBeat.o(269834);
    return localho;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(108670);
    this.mAY = paramh;
    paramh = (hn)c.b.b(this.rr.otB);
    paramh.ProductID = this.xNX;
    ciy localciy = new ciy();
    localciy.ILD = this.xNY.ILD;
    localciy.crp = this.xNY.crp;
    try
    {
      localciy.akkx = new DecimalFormat("0.00").format(Float.valueOf(this.xNY.akkx));
      paramh.YIT = localciy;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108670);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.NetSceneAskForReward", localException, "format error %s", new Object[] { this.xNY.akkx });
        localciy.akkx = "0.00";
      }
    }
  }
  
  public final int getType()
  {
    return 830;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108669);
    Log.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */