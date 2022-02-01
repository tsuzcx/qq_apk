package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends q
  implements c
{
  private final s ouH;
  private float zRW;
  private long zSm;
  private byte[] zSn;
  private byte[] zSo;
  
  public w(int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(271895);
    this.zSm = -1L;
    this.zRW = 0.5F;
    this.zSn = null;
    this.zSo = null;
    this.ouH = new i();
    j.a locala = (j.a)this.ouH.getReqObj();
    locala.zRG.aaoV = bIQ();
    locala.zRG.vhJ = 1;
    locala.zRG.IJG = paramInt1;
    locala.zRG.aaoW = paramInt2;
    locala.zRG.appid = paramString1;
    locala.zRG.YQb = paramString2;
    locala.zRG.aaoX = b.cX(paramArrayOfByte);
    AppMethodBeat.o(271895);
  }
  
  final void atG(String paramString)
  {
    AppMethodBeat.i(103640);
    ((j.a)this.ouH.getReqObj()).zRG.aaoV = paramString;
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
      this.zSm = localb.zRH.aaoY;
      this.zRW = localb.zRH.aapc;
      if (localb.zRH.aaoZ != null) {
        this.zSn = localb.zRH.aaoZ.Op;
      }
      if (localb.zRH.aaoX != null) {
        this.zSo = localb.zRH.aaoX.Op;
      }
      if (localb.zRH.aapb != null)
      {
        if ((localb.zRH.aapb.YPd == null) || (localb.zRH.aapb.YPd.abwJ <= 0)) {
          break label441;
        }
        Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.zRH.aapb.YPd.abwJ) });
      }
    }
    label441:
    for (params = com.tencent.mm.platformtools.w.a(localb.zRH.aapb.YPd);; params = null)
    {
      if ((localb.zRH.aapb.YPe != null) && (localb.zRH.aapb.YPe.abwJ > 0)) {
        Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.zRH.aapb.YPe.abwJ) });
      }
      for (byte[] arrayOfByte = com.tencent.mm.platformtools.w.a(localb.zRH.aapb.YPe);; arrayOfByte = null)
      {
        k.bHX().a(localb.zRH.aapb.YPa, localb.zRH.aapb.YPb, localb.zRH.aapb.YPc, params, arrayOfByte, localb.zRH.aapb.YPf);
        long l = this.zSm;
        if (this.zSn == null) {}
        for (int i = 0;; i = this.zSn.length)
        {
          Log.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d ratio:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Float.valueOf(this.zRW) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final byte[] dOA()
  {
    return this.zSn;
  }
  
  public final float dOB()
  {
    if ((this.zRW <= 0.0F) || (this.zRW > 1.0F)) {
      this.zRW = 0.5F;
    }
    return this.zRW;
  }
  
  public final byte[] dOC()
  {
    return this.zSo;
  }
  
  public final long dOz()
  {
    return this.zSm;
  }
  
  final int g(g paramg)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final dtt g(s params)
  {
    AppMethodBeat.i(103641);
    params = ((j.b)params.getRespObj()).zRH.aapa;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.w
 * JD-Core Version:    0.7.0.1
 */