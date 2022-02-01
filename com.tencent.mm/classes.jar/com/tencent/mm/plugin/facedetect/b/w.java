package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.aq.a;
import com.tencent.mm.aq.f;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends q
  implements c
{
  private final s lCW;
  private float wvR;
  private long wwf;
  private byte[] wwg;
  private byte[] wwh;
  
  public w(int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194871);
    this.wwf = -1L;
    this.wvR = 0.5F;
    this.wwg = null;
    this.wwh = null;
    this.lCW = new i();
    j.a locala = (j.a)this.lCW.getReqObj();
    locala.wvB.TbJ = bkW();
    locala.wvB.rWu = 1;
    locala.wvB.CPw = paramInt1;
    locala.wvB.TbK = paramInt2;
    locala.wvB.appid = paramString1;
    locala.wvB.RSB = paramString2;
    locala.wvB.TbL = b.cU(paramArrayOfByte);
    AppMethodBeat.o(194871);
  }
  
  final void azz(String paramString)
  {
    AppMethodBeat.i(103640);
    ((j.a)this.lCW.getReqObj()).wvB.TbJ = paramString;
    AppMethodBeat.o(103640);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(103639);
    Log.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    j.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (j.b)params.getRespObj();
      this.wwf = localb.wvC.TbM;
      this.wvR = localb.wvC.TbQ;
      if (localb.wvC.TbN != null) {
        this.wwg = localb.wvC.TbN.UH;
      }
      if (localb.wvC.TbL != null) {
        this.wwh = localb.wvC.TbL.UH;
      }
      if (localb.wvC.TbP != null)
      {
        if ((localb.wvC.TbP.RRL == null) || (localb.wvC.TbP.RRL.Ufv <= 0)) {
          break label441;
        }
        Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.wvC.TbP.RRL.Ufv) });
      }
    }
    label441:
    for (params = z.a(localb.wvC.TbP.RRL);; params = null)
    {
      if ((localb.wvC.TbP.RRM != null) && (localb.wvC.TbP.RRM.Ufv > 0)) {
        Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.wvC.TbP.RRM.Ufv) });
      }
      for (byte[] arrayOfByte = z.a(localb.wvC.TbP.RRM);; arrayOfByte = null)
      {
        f.bkh().a(localb.wvC.TbP.RRI, localb.wvC.TbP.RRJ, localb.wvC.TbP.RRK, params, arrayOfByte, localb.wvC.TbP.RRN);
        long l = this.wwf;
        if (this.wwg == null) {}
        for (int i = 0;; i = this.wwg.length)
        {
          Log.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d ratio:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Float.valueOf(this.wvR) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final long dhO()
  {
    return this.wwf;
  }
  
  public final byte[] dhP()
  {
    return this.wwg;
  }
  
  public final float dhQ()
  {
    if ((this.wvR <= 0.0F) || (this.wvR > 1.0F)) {
      this.wvR = 0.5F;
    }
    return this.wvR;
  }
  
  public final byte[] dhR()
  {
    return this.wwh;
  }
  
  final int f(g paramg)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final dcb g(s params)
  {
    AppMethodBeat.i(103641);
    params = ((j.b)params.getRespObj()).wvC.TbO;
    AppMethodBeat.o(103641);
    return params;
  }
  
  public final int getType()
  {
    return 733;
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.w
 * JD-Core Version:    0.7.0.1
 */