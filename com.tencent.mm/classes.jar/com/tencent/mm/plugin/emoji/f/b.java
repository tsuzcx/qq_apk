package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.DecimalFormat;

public final class b
  extends q
  implements m
{
  public static int uFs = 6;
  public static int uFt = 7;
  public static int uFu = 10;
  private i jQg;
  private final d rr;
  private String uFv;
  private akf uFw;
  
  public b(String paramString, akf paramakf)
  {
    AppMethodBeat.i(108668);
    d.a locala = new d.a();
    locala.lBU = new gu();
    locala.lBV = new gv();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.funcId = 830;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uFv = paramString;
    this.uFw = paramakf;
    AppMethodBeat.o(108668);
  }
  
  public final gv cUY()
  {
    AppMethodBeat.i(257521);
    gv localgv = (gv)d.c.b(this.rr.lBS);
    AppMethodBeat.o(257521);
    return localgv;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108670);
    this.jQg = parami;
    parami = (gu)d.b.b(this.rr.lBR);
    parami.ProductID = this.uFv;
    akf localakf = new akf();
    localakf.CRn = this.uFw.CRn;
    localakf.SuY = this.uFw.SuY;
    try
    {
      localakf.VHM = new DecimalFormat("0.00").format(Float.valueOf(this.uFw.VHM));
      parami.RLI = localakf;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108670);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.NetSceneAskForReward", localException, "format error %s", new Object[] { this.uFw.VHM });
        localakf.VHM = "0.00";
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
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */