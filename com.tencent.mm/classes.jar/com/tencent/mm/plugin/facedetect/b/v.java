package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.an.a;
import com.tencent.mm.an.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends p
  implements m, b
{
  private final s iMO;
  private long sQh;
  private float sQi;
  private byte[] sQj;
  private byte[] sQk;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103637);
    this.sQh = -1L;
    this.sQi = 0.5F;
    this.sQj = null;
    this.sQk = null;
    this.iMO = new h();
    i.a locala = (i.a)this.iMO.getReqObj();
    locala.sPH.LSY = p.sQc;
    locala.sPH.oUv = 1;
    locala.sPH.Scene = paramInt1;
    locala.sPH.LSZ = paramInt2;
    AppMethodBeat.o(103637);
  }
  
  final void ary(String paramString)
  {
    AppMethodBeat.i(103640);
    ((i.a)this.iMO.getReqObj()).sPH.LSY = paramString;
    AppMethodBeat.o(103640);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(103639);
    Log.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    i.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (i.b)params.getRespObj();
      this.sQh = localb.sPI.LTb;
      this.sQi = localb.sPI.LTf;
      if (localb.sPI.LTc != null) {
        this.sQj = localb.sPI.LTc.zy;
      }
      if (localb.sPI.LTa != null) {
        this.sQk = localb.sPI.LTa.zy;
      }
      if (localb.sPI.LTe != null)
      {
        if ((localb.sPI.LTe.KQN == null) || (localb.sPI.LTe.KQN.getILen() <= 0)) {
          break label441;
        }
        Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.sPI.LTe.KQN.getILen()) });
      }
    }
    label441:
    for (params = z.a(localb.sPI.LTe.KQN);; params = null)
    {
      if ((localb.sPI.LTe.KQO != null) && (localb.sPI.LTe.KQO.getILen() > 0)) {
        Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.sPI.LTe.KQO.getILen()) });
      }
      for (byte[] arrayOfByte = z.a(localb.sPI.LTe.KQO);; arrayOfByte = null)
      {
        f.baR().a(localb.sPI.LTe.KQK, localb.sPI.LTe.KQL, localb.sPI.LTe.KQM, params, arrayOfByte, localb.sPI.LTe.KQP);
        long l = this.sQh;
        if (this.sQj == null) {}
        for (int i = 0;; i = this.sQj.length)
        {
          Log.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d ratio:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Float.valueOf(this.sQi) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final long cSK()
  {
    return this.sQh;
  }
  
  public final byte[] cSL()
  {
    return this.sQj;
  }
  
  public final float cSM()
  {
    if ((this.sQi <= 0.0F) || (this.sQi > 1.0F)) {
      this.sQi = 0.5F;
    }
    return this.sQi;
  }
  
  public final byte[] cSN()
  {
    return this.sQk;
  }
  
  final int f(g paramg)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final ctc f(s params)
  {
    AppMethodBeat.i(103641);
    params = ((i.b)params.getRespObj()).sPI.LTd;
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
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */