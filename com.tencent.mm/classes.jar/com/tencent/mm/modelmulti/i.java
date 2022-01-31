package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class i
  extends m
  implements k
{
  private WakerLock dhx = new WakerLock(ae.getContext(), "MicroMsg.NetSceneSynCheck");
  private f dmL;
  private final q edR;
  
  public i()
  {
    this.dhx.lock(3000L, "NetSceneSynCheck");
    this.edR = new i.a();
    g.DQ();
    if (g.DP() != null)
    {
      g.DQ();
      if (g.DP().Dz() != null)
      {
        g.DQ();
        Object localObject = (String)g.DP().Dz().get(8195, null);
        ((w.a)this.edR.Kv()).esK = bk.ZM((String)localObject);
        localObject = (w.a)this.edR.Kv();
        g.DQ();
        g.DN();
        ((w.a)localObject).uin = com.tencent.mm.kernel.a.CK();
        ((w.a)this.edR.Kv()).netType = com.tencent.mm.protocal.a.getNetType(ae.getContext());
        ((w.a)this.edR.Kv()).spQ = com.tencent.mm.protocal.a.coN();
        y.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        return;
      }
    }
    y.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    int i = a(parame, this.edR, this);
    if ((i == -1) && (this.dhx.isLocking())) {
      this.dhx.unLock();
    }
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (w.b)paramq.HF();
    y.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.sqp);
    if ((g.DK()) && (!com.tencent.mm.kernel.a.CW()))
    {
      paramq = ((w.a)paramq.Kv()).dKa;
      if (bk.bE(paramq)) {
        y.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.dKa = paramq;
      ((b)g.r(b.class)).Pm().a(paramArrayOfByte.sqp, 2, paramArrayOfByte.cpg());
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.dhx.unLock();
  }
  
  public final int getType()
  {
    return 39;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i
 * JD-Core Version:    0.7.0.1
 */