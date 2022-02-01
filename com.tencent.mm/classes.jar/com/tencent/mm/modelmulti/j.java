package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class j
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private WakerLock fix;
  private final q gVZ;
  
  public j()
  {
    AppMethodBeat.i(132566);
    this.fix = new WakerLock(aj.getContext(), "MicroMsg.NetSceneSynCheck");
    this.fix.lock(3000L, "NetSceneSynCheck");
    this.gVZ = new a();
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afB() != null)
    {
      com.tencent.mm.kernel.g.afC();
      if (com.tencent.mm.kernel.g.afB().afk() != null)
      {
        com.tencent.mm.kernel.g.afC();
        Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(8195, null);
        ((aa.a)this.gVZ.getReqObj()).hlA = bt.aGd((String)localObject);
        localObject = (aa.a)this.gVZ.getReqObj();
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afz();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.a.getUin());
        ((aa.a)this.gVZ.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(aj.getContext());
        ((aa.a)this.gVZ.getReqObj()).Cqy = com.tencent.mm.protocal.a.eBB();
        ad.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    ad.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(132567);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
    if ((i == -1) && (this.fix.isLocking())) {
      this.fix.unLock();
    }
    AppMethodBeat.o(132567);
    return i;
  }
  
  public final long getReturnTimeout()
  {
    return 240000L;
  }
  
  public final int getType()
  {
    return 39;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132568);
    paramArrayOfByte = (aa.b)paramq.getRespObj();
    ad.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.Crj);
    if ((com.tencent.mm.kernel.g.afw()) && (!com.tencent.mm.kernel.a.aeC()))
    {
      paramq = ((aa.a)paramq.getReqObj()).gcD;
      if (bt.cw(paramq)) {
        ad.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.gcD = paramq;
      ((b)com.tencent.mm.kernel.g.ab(b.class)).azv().a(paramArrayOfByte.Crj, 2, paramArrayOfByte.eBX());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.fix.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends l
  {
    private final aa.a hlN;
    private final aa.b hlO;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.hlN = new aa.a();
      this.hlO = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hlN;
    }
    
    public final l.e getRespObj()
    {
      return this.hlO;
    }
    
    public final int getType()
    {
      return 39;
    }
    
    public final String getUri()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j
 * JD-Core Version:    0.7.0.1
 */