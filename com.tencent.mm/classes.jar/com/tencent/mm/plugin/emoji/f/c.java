package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.sdk.platformtools.y;
import java.text.DecimalFormat;

public final class c
  extends m
  implements k
{
  public static int iZp = 6;
  public static int iZq = 7;
  public static int iZr = 10;
  private f dIJ;
  private final b dmK;
  private String iZs;
  private vl iZt;
  
  public c(String paramString, vl paramvl)
  {
    b.a locala = new b.a();
    locala.ecH = new en();
    locala.ecI = new eo();
    locala.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
    locala.ecG = 830;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZs = paramString;
    this.iZt = paramvl;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    paramf = (en)this.dmK.ecE.ecN;
    paramf.syc = this.iZs;
    vl localvl = new vl();
    localvl.kVZ = this.iZt.kVZ;
    localvl.sSA = this.iZt.sSA;
    localvl.sSz = new DecimalFormat("0.00").format(Float.valueOf(this.iZt.sSz));
    paramf.syd = localvl;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final eo aIb()
  {
    return (eo)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 830;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */